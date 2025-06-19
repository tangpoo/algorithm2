n = int(input())
sum = 0
count = 1

while sum + count <= n:
    sum += count
    count += 1
    
print(count - 1)