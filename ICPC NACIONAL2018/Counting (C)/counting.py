import sys


def main():
	matrix = []
	for i in range(10001):
		matrix.insert(i,1)

	for i in range(2,10001):
		for j in range(i,10001):
			matrix[j] = (matrix[j]+matrix[j-i])%1000000007

	while True:
		 val = sys.stdin.readline().strip()
		 if val==''or val==None:
		 	break

		 n = int(val)
		 print(matrix[n])




if __name__ == '__main__':
    main()
