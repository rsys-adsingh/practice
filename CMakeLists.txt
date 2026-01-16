cmake_minimum_required(VERSION 3.16)

# Initialize project with C, C++, and Java support
project(PracticeRepo LANGUAGES C CXX Java)

# ==========================================
# 0. GLOBAL SETTINGS
# ==========================================
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_C_STANDARD 11)

# Put all executables in a "bin" folder (keeps build clean)
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/bin)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_BINARY_DIR}/lib)

# Find Threading Library (Required for mutex.c, atomic.c, etc.)
find_package(Threads REQUIRED)

# Try to find DPDK (Optional) to decide if we build that specific file
find_package(PkgConfig QUIET)
if(PKG_CONFIG_FOUND)
    pkg_check_modules(DPDK libdpdk)
endif()

# ==========================================
# 1. C FILES AUTOMATION (src/c)
# ==========================================
# Find all .c files recursively
file(GLOB_RECURSE C_SOURCES "src/c/*.c")

foreach(sourcefile ${C_SOURCES})
    # Get the file name (e.g., "mutex.c" -> "mutex")
    get_filename_component(targetname ${sourcefile} NAME_WE)
    
    # --- 1. SPECIAL LOGIC FOR DPDK ---
    if(targetname STREQUAL "withDPDK")
        if(DPDK_FOUND)
            # Build with DPDK flags
            add_executable(c_${targetname} ${sourcefile})
            target_link_libraries(c_${targetname} PRIVATE ${DPDK_LIBRARIES})
            target_include_directories(c_${targetname} PRIVATE ${DPDK_INCLUDE_DIRS})
            target_link_libraries(c_${targetname} PRIVATE Threads::Threads)
            target_compile_options(c_${targetname} PRIVATE ${DPDK_CFLAGS})
            message(STATUS "✅ Configured DPDK target: c_${targetname}")
        else()
            message(STATUS "⚠️  Skipping 'withDPDK.c' (DPDK library not found)")
        endif()
        
        # CRITICAL FIX: Skip the rest of the loop so we don't build it again!
        continue()
    endif()

    # --- 2. STANDARD LOGIC (For all other C files) ---
    add_executable(c_${targetname} ${sourcefile})
    target_link_libraries(c_${targetname} PRIVATE Threads::Threads)

endforeach()

# ==========================================
# 2. C++ FILES AUTOMATION (src/cpp)
# ==========================================
# Find all .cpp files recursively
file(GLOB_RECURSE CPP_SOURCES "src/cpp/*.cpp")

foreach(sourcefile ${CPP_SOURCES})
    get_filename_component(targetname ${sourcefile} NAME_WE)
    
    # Create executable (prefixed with cpp_)
    add_executable(cpp_${targetname} ${sourcefile})
    
    # Link Threads
    target_link_libraries(cpp_${targetname} PRIVATE Threads::Threads)
endforeach()

# ==========================================
# 3. JAVA BUILDER (src/java)
# ==========================================
enable_language(Java)
find_package(Java REQUIRED)
include(UseJava)

set(CMAKE_JAVA_TARGET_OUTPUT_DIR ${CMAKE_BINARY_DIR}/bin)

# Find all Java files
file(GLOB_RECURSE JAVA_SOURCES "src/java/*.java")

foreach(javafile ${JAVA_SOURCES})
    # Get filename without extension (e.g., "SortAlgo.java" -> "SortAlgo")
    get_filename_component(classname ${javafile} NAME_WE)

    # Create a separate JAR for this specific file
    # Output: build/bin/java_SortAlgo.jar
    add_jar(java_${classname} ${javafile} ENTRY_POINT ${classname})
endforeach()

# ==========================================
# 4. SUB-PROJECTS (src/projects)
# ==========================================
# If your sub-projects have their own CMakeLists.txt, include them.
file(GLOB SUB_PROJECTS "src/projects/*")
foreach(proj ${SUB_PROJECTS})
    if(IS_DIRECTORY ${proj} AND EXISTS "${proj}/CMakeLists.txt")
        get_filename_component(projname ${proj} NAME)
        message(STATUS "📂 Adding Sub-project: ${projname}")
        add_subdirectory(${proj})
    endif()
endforeach()

# ==========================================
# 5. UTILITY TARGETS
# ==========================================
# This allows you to run "cmake --build . --target install_deps"
add_custom_target(install_deps
    COMMAND sudo ${CMAKE_SOURCE_DIR}/setup_dependencies.sh
    WORKING_DIRECTORY ${CMAKE_SOURCE_DIR}
    COMMENT "Running setup_dependencies.sh (Requires Sudo Password)..."
    VERBATIM
)