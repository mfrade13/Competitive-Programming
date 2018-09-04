import sys
import math

def main():
  l2 = math.log10(2)
  l5 = math.log10(5)
  n = int(sys.stdin.readline())
  for i in range(n):
  	a, b = sys.stdin.readline().strip().split(' ')
  	x = int(a)
  	y = int(b)
  	dif = min(x,y)
  	digits = 0
  	digits = digits + dif
  	if(x>=y):
  		d = x-y
  		digits = digits + (math.floor(d*l2)+1)
  	else:
  		d = y-x
  		digits = digits +(math.floor(l5*d)+1 )

	print( int(digits))


if __name__ == '__main__':
  main()
