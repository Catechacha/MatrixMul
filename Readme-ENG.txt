This program uses multithreading to multiply two very large matrices. The main thread: must generate 2
NxN random very large matrices (n = 1000 -> 1000 X 1000), implement a task that calculates a line of
multiplication (the line number must be given as a parameter to the task), use a thread pool to start N tasks that
calculate the multiplication.
