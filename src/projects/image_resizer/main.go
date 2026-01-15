package main

/*
#cgo CXXFLAGS: -std=c++11 -O3
#include <stdlib.h>

// Define the struct layout in C so Go understands it
typedef struct {
    unsigned char* data;
    int len;
    char* error;
} ResizeResult;

// Forward declaration of the C++ function
ResizeResult ResizeImage(unsigned char* inputData, int inputLen, int targetWidth, int targetHeight);
void FreeResult(unsigned char* data);
*/
import "C"

import (
	"bytes"
	"fmt"
	"io"
	"net/http"
	"unsafe"
)

func resizeHandler(w http.ResponseWriter, r *http.Request) {
	if r.Method != http.MethodPost {
		http.Error(w, "Invalid method", http.StatusMethodNotAllowed)
		return
	}

	// 1. Parse Uploaded File
	file, _, err := r.FormFile("image")
	if err != nil {
		http.Error(w, "Failed to read image", http.StatusBadRequest)
		return
	}
	defer file.Close()

	// Read file into bytes
	buf := bytes.NewBuffer(nil)
	if _, err := io.Copy(buf, file); err != nil {
		http.Error(w, "Buffer error", http.StatusInternalServerError)
		return
	}
	inputBytes := buf.Bytes()

	// 2. Call C++ Code (Critical Section)
	// We pass a pointer to the first byte of the slice
	cData := C.CBytes(inputBytes)
	defer C.free(cData) // Free the copy we gave to C

	targetW := 800 // Example: Resize everything to 800x600
	targetH := 600

	// Call the C function
	result := C.ResizeImage(
		(*C.uchar)(cData),
		C.int(len(inputBytes)),
		C.int(targetW),
		C.int(targetH),
	)

	// Check for errors from C++
	if result.error != nil {
		http.Error(w, C.GoString(result.error), http.StatusInternalServerError)
		return
	}

	// 3. Convert C++ result back to Go
	// Create a Go slice from the C array without copying (unsafe but fast)
	// or with copying (safer). Here we copy for safety.
	goBytes := C.GoBytes(unsafe.Pointer(result.data), result.len)

	// Free the memory allocated inside C++
	C.FreeResult(result.data)

	// 4. Return Response
	w.Header().Set("Content-Type", "image/jpeg")
	w.Header().Set("Content-Length", fmt.Sprint(len(goBytes)))
	w.Write(goBytes)
}

func main() {
	http.HandleFunc("/resize", resizeHandler)
	fmt.Println("High-Performance Resizer running on :8080")
	http.ListenAndServe(":8080", nil)
}
