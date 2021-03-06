cmake_minimum_required(VERSION 3.5.2)

project(logika-c-runtime)

set(CMAKE_C_STANDARD 90)

list(APPEND CMAKE_MODULE_PATH "${CMAKE_CURRENT_LIST_DIR}/cmake")

find_package(GMP REQUIRED)
find_package(Sodium REQUIRED)

include_directories(${GMP_H} ${SODIUM_H} include)

set(LIB_SOURCE_FILES src/logika.c src/logika-io.c src/logika-random.c)
set(UB -DBIT_WIDTH=0 -DLOGIKA_DIRTY_WIPE)
set(B8 -DBIT_WIDTH=8 -DLOGIKA_DIRTY_WIPE)
set(B16 -DBIT_WIDTH=16 -DLOGIKA_DIRTY_WIPE)
set(B32 -DBIT_WIDTH=32 -DLOGIKA_DIRTY_WIPE)
set(B64 -DBIT_WIDTH=64 -DLOGIKA_DIRTY_WIPE)

add_definitions(-DLOGIKA_DEBUG)

add_library(logika ${LIB_SOURCE_FILES})
target_compile_definitions(logika PUBLIC ${UB})

add_library(logika8 ${LIB_SOURCE_FILES})
target_compile_definitions(logika8 PUBLIC ${B8})

add_library(logika16 ${LIB_SOURCE_FILES})
target_compile_definitions(logika16 PUBLIC ${B16})

add_library(logika32 ${LIB_SOURCE_FILES})
target_compile_definitions(logika32 PUBLIC ${B32})

add_library(logika64 ${LIB_SOURCE_FILES})
target_compile_definitions(logika64 PUBLIC ${B64})


add_executable(logika-main test/main.c)
target_link_libraries(logika-main logika ${GMP_L} ${SODIUM_L})
target_compile_definitions(logika-main PUBLIC ${UB})

add_executable(logika-main8 test/main.c)
target_link_libraries(logika-main8 logika8 ${SODIUM_L})
target_compile_definitions(logika-main8 PUBLIC ${B8})

add_executable(logika-main16 test/main.c)
target_link_libraries(logika-main16 logika16 ${SODIUM_L})
target_compile_definitions(logika-main16 PUBLIC ${B16})

add_executable(logika-main32 test/main.c)
target_link_libraries(logika-main32 logika32 ${SODIUM_L})
target_compile_definitions(logika-main32 PUBLIC ${B32})

add_executable(logika-main64 test/main.c)
target_link_libraries(logika-main64 logika64 ${SODIUM_L})
target_compile_definitions(logika-main64 PUBLIC ${B64})
