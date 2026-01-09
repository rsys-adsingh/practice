#!/bin/bash

# ==========================================
# Step 1: Install Dependencies
# ==========================================
echo "--- Checking and Installing Dependencies ---"
# Check if running as root, if not use sudo
if [ "$EUID" -ne 0 ]; then 
  echo "Requesting sudo privileges to install ImageMagick..."
  sudo yum install -y ImageMagick-c++-devel ImageMagick
else
  yum install -y ImageMagick-c++-devel ImageMagick
fi

if [ $? -ne 0 ]; then
    echo "Error: Installation failed. Please check your package manager."
    exit 1
fi

# ==========================================
# Step 2: Generate C++ Code
# ==========================================
# We create the C++ file dynamically so it accepts command line arguments
echo "--- Generating C++ Source Code (converter.cpp) ---"

cat <<EOF > converter.cpp
#include <Magick++.h>
#include <iostream>
#include <string>

using namespace Magick;

int main(int argc, char **argv) {
    if (argc < 3) {
        std::cerr << "Usage: " << argv[0] << " <input.svg> <output.jpg>" << std::endl;
        return 1;
    }

    InitializeMagick(*argv);

    try {
        Image image;

        // 1. Set Density (DPI) for HD Quality
        // 300 DPI is standard high quality (print grade)
        image.density(Geometry("300x300")); 

        // 2. Read the SVG file from first argument
        image.read(argv[1]);

        // 3. Flatten onto a white background (removes transparency)
        image.backgroundColor(Color("white"));
        std::list<Image> layers;
        layers.push_back(image);
        Image flatImage;
        flattenImages(&flatImage, layers.begin(), layers.end());

        // 4. Set JPEG Quality (max)
        flatImage.quality(100);

        // 5. Write to output file from second argument
        flatImage.write(argv[2]);

    } catch (Exception &error_) {
        std::cout << "Error: " << error_.what() << std::endl;
        return 1;
    }

    return 0;
}
EOF

# ==========================================
# Step 3: Compile the Code
# ==========================================
echo "--- Compiling converter.cpp ---"

# Compile using Magick++ flags
g++ -O2 -o svg2jpg converter.cpp \
    $(Magick++-config --cppflags --cxxflags --ldflags --libs)

if [ $? -ne 0 ]; then
    echo "Error: Compilation failed."
    exit 1
fi

echo "Compilation successful. Binary 'svg2jpg' created."

# ==========================================
# Step 4: User Input and Execution
# ==========================================
echo "----------------------------------------"
read -p "Enter the path/name of the SVG file (e.g., image.svg): " INPUT_SVG

# Check if file exists
if [ ! -f "$INPUT_SVG" ]; then
    echo "Error: File '$INPUT_SVG' not found!"
    exit 1
fi

# Determine Output Name (replace extension with .jpg)
OUTPUT_JPG="${INPUT_SVG%.*}.jpg"

echo "Converting '$INPUT_SVG' to '$OUTPUT_JPG'..."

# Run the binary
./svg2jpg "$INPUT_SVG" "$OUTPUT_JPG"

if [ $? -eq 0 ]; then
    echo "Success! Image saved as $OUTPUT_JPG"
else
    echo "Conversion failed."
fi