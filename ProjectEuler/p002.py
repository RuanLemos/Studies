#The goal of this code is to output the sum of all even numbers below four million that belong to the Fibonacci sequence.
#The Fibonacci sequence goes as 0, 1, 1, 2, 3, 5, 8, and so on...
#It consists of the sum of the last two numbers in order to achieve the next one, creating an exponential growth of the sequence.


def fibonacci():
  
  first_number = 0
  next_number = 1
  fibonacci_number = 0
  sum = 0

  while first_number + next_number <= 4000000:
  
    fibonacci_number = first_number + next_number
    first_number = next_number
    next_number = fibonacci_number

    if fibonacci_number % 2 == 0:
      sum += fibonacci_number

  return sum

print(fibonacci())
