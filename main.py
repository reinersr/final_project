import random

work_edges = []
# out_edges = []

def find_matching():
	
	random.shuffle(work_edges)

	out_edges = []

	for i in work_edges[:round(len(work_edges)/4)+2]:
		if(check(i, out_edges)):
			out_edges.append(i)
			if(len(out_edges)%100==0):
				print(len(out_edges))
	print(len(out_edges))
	return out_edges


def check(edge, out_edges):
	for i in out_edges:
		if(edge[0] in i):
			return False
		if(edge[1] in i):
			return False
	return True

def print_out(output):
	fout = open('C:/Users/robbo/Desktop/output.csv', 'w')
	for i in output:
		fout.write(i[0])
		fout.write(',')
		fout.write(i[1])
		fout.write('\n')
	fout.close()

def main():
	fin = open('C:/Users/robbo/Documents/GitHub/Data_proc/final_project/musae_ENGB_edges.csv', "r")

	for i in fin.readlines():
		work_edges.append(i.strip().split(','))
	
	output = []
	print('Original length:\t', len(work_edges))
	for i in range(100):
		temp = find_matching()
		if(len(temp)>len(output)):
			output = temp
	print_out(output)
	print('Length:\t', len(output))
	fin.close()

main()