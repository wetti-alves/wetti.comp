CC = gcc
CFLAGS = -fopenmp
EXECUTABLE = qs-psrs

all: $(EXECUTABLE)

$(EXECUTABLE): qs-psrs.o
	$(CC) $(CFLAGS) qs-psrs.o -o $(EXECUTABLE)

qs-psrs.o: qs-psrs.c
	$(CC) $(CFLAGS) -c qs-psrs.c -o qs-psrs.o

run: $(EXECUTABLE)
	./$(EXECUTABLE) $(n) $(nthread)

clean:
	rm -rf $(EXECUTABLE) *.o

