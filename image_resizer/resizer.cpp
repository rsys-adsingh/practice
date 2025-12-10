#include <cstdlib>
#include <vector>

// Define implementations for the STB libraries
#define STB_IMAGE_IMPLEMENTATION
#include "stb_image.h"

#define STB_IMAGE_WRITE_IMPLEMENTATION
#include "stb_image_write.h"

#define STB_IMAGE_RESIZE_IMPLEMENTATION
#include "stb_image_resize2.h"

extern "C" {

    // Structure to return data to Go
    typedef struct {
        unsigned char* data;
        int len;
        char* error;
    } ResizeResult;

    // The function Go will call
    ResizeResult ResizeImage(unsigned char* inputData, int inputLen, int targetWidth, int targetHeight) {
        ResizeResult result = {nullptr, 0, nullptr};
        int width, height, channels;

        // 1. Decode the image (CPU intensive)
        unsigned char* img = stbi_load_from_memory(inputData, inputLen, &width, &height, &channels, 0);
        if (img == nullptr) {
            result.error = (char*)"Failed to decode image";
            return result;
        }

        // 2. Allocate memory for the output image
        std::vector<unsigned char> outputImg(targetWidth * targetHeight * channels);

        // 3. Resize (High Performance Step)
        // stbir_resize_uint8_linear is optimized and handles complex filtering
        stbir_resize_uint8_linear(img, width, height, 0, 
                                  outputImg.data(), targetWidth, targetHeight, 0, 
                                  (stbir_pixel_layout)channels);

        // Free the original image memory
        stbi_image_free(img);

        // 4. Encode back to JPEG/PNG format (to return to user)
        // We write to memory, not disk, for speed.
        int outLen;
        unsigned char* jpgData = stbi_write_png_to_mem(outputImg.data(), targetWidth, targetHeight, channels, 90, &outLen);

        if (jpgData == nullptr) {
            result.error = (char*)"Failed to encode image";
            return result;
        }

        result.data = jpgData;
        result.len = outLen;
        return result;
    }

    // Helper to free memory allocated by C++ from Go
    void FreeResult(unsigned char* data) {
        if (data) free(data); // stbi_write_to_mem uses malloc
    }
}