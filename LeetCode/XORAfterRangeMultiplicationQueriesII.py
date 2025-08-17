class Solution:
    def xorAfterQueries(self, nums: List[int], queries: List[List[int]]) -> int:
        n = len(nums)
        mod = 10 ** 9 + 7
        s = int(n ** 0.5)
        if s == 0:
            s = 1

        sq = [[] for _ in range(s+1)]
        lq = []
        for l,r,k,v in queries:
            if k <= s:
                sq[k].append((l,r,v))
            else:
                lq.append((l,r,k,v))

        def modInverse(n, modulus):
            return pow(n, modulus -2, modulus)

        mul = [1] * n
        for k in range(1, s+1):
            if not sq[k]:
                continue
            qr = [[] for _ in range(k)]
            for l,r,v in sq[k]:
                qr[l%k].append((l,r,v))

            for rem in range(k):
                if not qr[rem]:
                    continue
                prog_len = (n-1-rem) // k + 1
                diff = [1] * (prog_len + 1)
                for l,r,v in qr[rem]:
                    spi = l // k
                    ns = (r-l) // k
                    epi = spi + ns
                    diff[spi] = (diff[spi] * v) % mod
                    if epi + 1 <= prog_len:
                        inv_v = modInverse(v, mod)
                        diff[epi + 1] = (diff[epi+1] * inv_v) % mod

                current_m = 1
                for i in range(prog_len):
                    current_m = (current_m * diff[i]) % mod
                    oi = rem + i * k
                    mul[oi] = (mul[oi] * current_m) % mod

        for i in range(n):
            nums[i] = (nums[i] * mul[i]) % mod

        for l,r,k,v in lq:
            idx = l
            while idx <= r:
                nums[idx] = (nums[idx] * v) % mod
                idx += k
        
                

        xor_sum = 0
        for num in nums:
            xor_sum ^= num

        return xor_sum
