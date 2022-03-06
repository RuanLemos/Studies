import math

# according to the fundamental theorem of arithmetic, if n isn't already prime, it's first factor will always be prime.
def find_first_factor(n):
	for i in range(2, int(math.sqrt(n)) + 1):
		if n % i == 0:
			return i # i is a prime number
	return n # n already is a prime number itself

def solve():
	n = 600851475143
	while True:
		factor = find_first_factor(n)
		print(n)
		print(factor)
		if n > factor: # eventually, find_first_factor() will return the same number it received, because it's already a prime. We have to verify it in order to not break the code.
			n = n // factor # it never has a remainder, but I used floor division to get an integer value without using the int() method
		else:
			 return n

print(solve())
