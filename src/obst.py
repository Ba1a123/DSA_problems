def optimal_bst(keys, freq):
    n = len(keys)

    # Create a 2D table to store the computed results
    dp = [[0 for x in range(n + 1)] for x in range(n + 1)]

    # Fill in the diagonal elements of the table with the frequency values
    for i in range(n):
        dp[i][i] = freq[i]

    # Construct the optimal BST using bottom-up dynamic programming approach
    for L in range(1, n + 1):
        for i in range(n - L + 1):
            j = i + L
            dp[i][j] = float('inf')

            # Calculate the cost of subtrees
            for k in range(i, j + 1):
                cost = sum(freq[i:j + 1]) + (dp[i][k - 1] if k > i else 0) + (dp[k + 1][j] if k < j else 0)
                if cost < dp[i][j]:
                    dp[i][j] = cost

    return dp[0][n - 1]

# Example usage
keys = [10, 20, 30, 40]
freq = [4, 2, 6, 3]
result = optimal_bst(keys, freq)
print("The cost of the optimal BST is:", result)
