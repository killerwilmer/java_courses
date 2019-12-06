from car import Car
from account import Account

if __name__ == "__main__":
    car = Car("123ABC", Account("Edwin", "1812345"))
    print(vars(car))
    print(vars(car.driver))