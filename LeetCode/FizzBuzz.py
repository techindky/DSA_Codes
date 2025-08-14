class Solution:
    def fizzBuzz(self, n: int) -> List[str]:
        arr = []
        for i in range(1,n+1):
            if i%3==0:
                if i%5==0:
                    arr+=["FizzBuzz"]
                else:
                    arr+=["Fizz"]
            elif i%5==0:
                arr+=["Buzz"]
            else:
                arr+=[str(i)]
        return arr
