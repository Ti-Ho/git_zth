# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.14

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Remove some rules from gmake that .SUFFIXES does not remove.
SUFFIXES =

.SUFFIXES: .hpux_make_needs_suffix_list


# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "E:\CLion 2019.1.4\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "E:\CLion 2019.1.4\bin\cmake\win\bin\cmake.exe" -E remove -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles/Kmp.dir/depend.make

# Include the progress variables for this target.
include CMakeFiles/Kmp.dir/progress.make

# Include the compile flags for this target's objects.
include CMakeFiles/Kmp.dir/flags.make

CMakeFiles/Kmp.dir/main.cpp.obj: CMakeFiles/Kmp.dir/flags.make
CMakeFiles/Kmp.dir/main.cpp.obj: ../main.cpp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object CMakeFiles/Kmp.dir/main.cpp.obj"
	C:\MinGW\bin\g++.exe  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\Kmp.dir\main.cpp.obj -c D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp\main.cpp

CMakeFiles/Kmp.dir/main.cpp.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/Kmp.dir/main.cpp.i"
	C:\MinGW\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp\main.cpp > CMakeFiles\Kmp.dir\main.cpp.i

CMakeFiles/Kmp.dir/main.cpp.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/Kmp.dir/main.cpp.s"
	C:\MinGW\bin\g++.exe $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp\main.cpp -o CMakeFiles\Kmp.dir\main.cpp.s

# Object files for target Kmp
Kmp_OBJECTS = \
"CMakeFiles/Kmp.dir/main.cpp.obj"

# External object files for target Kmp
Kmp_EXTERNAL_OBJECTS =

Kmp.exe: CMakeFiles/Kmp.dir/main.cpp.obj
Kmp.exe: CMakeFiles/Kmp.dir/build.make
Kmp.exe: CMakeFiles/Kmp.dir/linklibs.rsp
Kmp.exe: CMakeFiles/Kmp.dir/objects1.rsp
Kmp.exe: CMakeFiles/Kmp.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX executable Kmp.exe"
	$(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\Kmp.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
CMakeFiles/Kmp.dir/build: Kmp.exe

.PHONY : CMakeFiles/Kmp.dir/build

CMakeFiles/Kmp.dir/clean:
	$(CMAKE_COMMAND) -P CMakeFiles\Kmp.dir\cmake_clean.cmake
.PHONY : CMakeFiles/Kmp.dir/clean

CMakeFiles/Kmp.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp\cmake-build-debug D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp\cmake-build-debug D:\360MoveData\Users\38004\Desktop\GitFile\git_zth\DataStructure_Code\Kmp\cmake-build-debug\CMakeFiles\Kmp.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles/Kmp.dir/depend
