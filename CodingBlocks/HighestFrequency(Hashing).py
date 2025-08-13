max_freq = 0
freq = {}
n = int(input())
arr = list(map(int, input().split()))
for val in arr:
	f = freq.get(val,0) + 1
	freq[val] = f
	max_freq = max(f,max_freq)

for key,value in freq.items():
	if value == max_freq:
		print(key)
		break