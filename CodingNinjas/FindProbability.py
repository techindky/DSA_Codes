from collections import Counter
from typing import List

MOD = 10**9 + 7

def power(base, exp):
    res = 1
    base %= MOD
    while exp > 0:
        if exp % 2 == 1:
            res = (res * base) % MOD
        base = (base * base) % MOD
        exp //= 2
    return res

def modInverse(n):
    return power(n, MOD - 2)

def find_probability(n: int, a: List[int]) -> int:
    if n <= 1:
        return 1
      
    freq = Counter(a)

    is_already_sorted = all(a[i] <= a[i+1] for i in range(n - 1))
    
    if is_already_sorted:
        k = 0
        for count in freq.values():
            k = (k + count * count) % MOD
        
        total_outcomes = (n * n) % MOD
        inv_total = modInverse(total_outcomes)
        result = (k * inv_total) % MOD
        return result
    is_prefix_sorted = [False] * n
    is_prefix_sorted[0] = True
    for i in range(1, n):
        if is_prefix_sorted[i-1] and a[i-1] <= a[i]:
            is_prefix_sorted[i] = True
        else:
            break
    is_suffix_sorted = [False] * n
    is_suffix_sorted[n-1] = True
    for i in range(n - 2, -1, -1):
        if is_suffix_sorted[i+1] and a[i] <= a[i+1]:
            is_suffix_sorted[i] = True
        else:
            break

    k = 0
    for i in range(n):
        prefix_ok = is_prefix_sorted[i-1] if i > 0 else True
        suffix_ok = is_suffix_sorted[i+1] if i < n - 1 else True
        
        gap_ok = True
        if 0 < i < n - 1:
            if a[i-1] > a[i+1]:
                gap_ok = False
        
        if prefix_ok and suffix_ok and gap_ok:
            k = (k + freq[a[i]]) % MOD

    if k == 0:
        return 0

    total_outcomes = (n * n) % MOD
    inv_total = modInverse(total_outcomes)
    result = (k * inv_total) % MOD
    return result

