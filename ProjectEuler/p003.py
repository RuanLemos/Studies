# The goal of this code is to find the largest prime factor of 600851475143. 


number = 600851475143
factor_list = [] # Storages all the factors of the variable number
prime_list = [] # Contains the prime values of factor_list

min = 1
max = int(number/2) # the value is divided by two because we only search integer values, thus, 2 would be the smallest possible value

for i in range(min+1, max+1):
  if number % i == 0:
    print(i)
    factor_list.append(i) # if i successfully divides 600851475143 with no remainder, we it into factor_list

for factor in factor_list:
  flag = 0  
  for num in range (2, factor/2):
    if factor % num == 0:
      flag += 1
    if flag > 1:
      break
    elif flag == 0 and num == int(factor/2):
      prime_list.append(num)
      break

print(prime_list)
