import sys

def main():

    dp = [0,1]
    dd = [2,3,4,7,13]
    for i in range(50001):
        if i!=1 and i!=0:
        	dp.insert(i,(2*dp[i-1]) +dp[i-2])
    
    while True:
    	line = sys.stdin.readline().strip()
    	if(line =='' or line == None):
    		break
        
        n = int(line)
        output = ""
        for x in range(5):
        	if dp[n]%dd[x-1]==0:
        		output = output + "Pell's number "+str(n)+" is divisible by " + str(dd[x-1])+"\n"

        if len(output)>0:
        	print(output[0:len(output)-1])
        else:
        	print("-1")
    
if __name__ == '__main__':
    main()
             
