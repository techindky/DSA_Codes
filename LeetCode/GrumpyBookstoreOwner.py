class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        n = len(customers)
        if n==1 and grumpy[0]==0:
            return customers[0]
        elif minutes==n:
            return sum(customers)
        maxCustomerSatisfied = 0
        for i in range(n):
            if grumpy[i]==0:
                maxCustomerSatisfied+=customers[i]

        customerSatisfied = 0

        for i in range(minutes):
            if grumpy[i]:
                customerSatisfied+=customers[i]
        temp = customerSatisfied
        for i in range(minutes,n):
            if grumpy[i]:
                customerSatisfied+=customers[i]
            if grumpy[i-minutes]:
                customerSatisfied-=customers[i-minutes]
            if temp<customerSatisfied:
                temp = customerSatisfied
        return maxCustomerSatisfied + temp
