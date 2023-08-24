def issafe(list, i, col):
    for j in range(col):
        if(list[j] == i or abs(list[j] - i) == abs(j - col)):
            return False
    return True
        
def nqueen(col, n, list=None):
    count = 0
    if list is None:
        list = [0] * (n + 1)
    for i in range(1, n + 1):
        if issafe(list, i, col):
            list[col] = i
            if col == n - 1:
                print(list[1:n + 1])
                count += 1
            else:
                count += nqueen(col + 1, n, list)
    return count
        
n = int(input("Enter the number of queens: "))
total_solutions = nqueen(0, n)
print("Total solutions:", total_solutions)
