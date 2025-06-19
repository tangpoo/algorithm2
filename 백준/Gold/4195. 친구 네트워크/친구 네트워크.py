import sys

input = sys.stdin.readline

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    x_root = find(x)
    y_root = find(y)
    
    if x_root != y_root:
        parent[y_root] = x_root
        size[x_root] += size[y_root]
    
    return size[x_root]

T = int(input())

for _ in range(T):
    F = int(input())
    parent = dict()
    size = dict()
    
    for _ in range(F):
        a, b = input().split()
        
        if a not in parent:
            parent[a] = a
            size[a] = 1
        
        if b not in parent:
            parent[b] = b
            size[b] = 1
            
        print(union(a, b))
