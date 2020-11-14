import subprocess

# anzahl elemente | zeit insertion sort best case | zeit insertion random | zeit insertion sort worst case | zeit selection sort best case | zeit selection random | zeit selection sort worst case
for i in range(1000, 10000, 100):

	file = open("zeiten.csv", "a")

	# high to low
	result = subprocess.run(['java', 'highToLow', str(i)], stdout=subprocess.PIPE)
	highToLow = result.stdout.decode("utf-8").split('\n')[0:2]
	highToLow[0] = highToLow[0].replace("\n","")
	highToLow[0] = highToLow[0].replace("\r","")
	highToLow[1] = highToLow[1].replace("\n","")
	highToLow[1] = highToLow[1].replace("\r","")

	# random
	result = subprocess.run(['java', 'random', str(i)], stdout=subprocess.PIPE)
	random = result.stdout.decode("utf-8").split('\n')[0:2]
	random[0] = random[0].replace("\n","")
	random[0] = random[0].replace("\r","")
	random[1] = random[1].replace("\n","")
	random[1] = random[1].replace("\r","")

	# low to high
	result = subprocess.run(['java', 'lowToHigh', str(i)], stdout=subprocess.PIPE)
	lowToHigh = result.stdout.decode("utf-8").split('\n')[0:2]
	lowToHigh[0] = lowToHigh[0].replace("\n","")
	lowToHigh[0] = lowToHigh[0].replace("\r","")
	lowToHigh[1] = lowToHigh[1].replace("\n","")
	lowToHigh[1] = lowToHigh[1].replace("\r","")
	

	# write to csv file
	file.write(str(i) + "," + highToLow[0] + "," + random[0] +  "," + lowToHigh[0] + "," + lowToHigh[1] + "," + random[1] + "," + highToLow[1] + "\n")
	file.close()
