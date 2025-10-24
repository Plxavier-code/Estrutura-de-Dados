import java.time.LocalDateTime;

public class Car implements IterCar {
    private Stackable<Car> stackCar = new Stackable<Car>(20);

    public void addCar(Car car) {
        stackCar.push(car);
    }

    public Car getCar(String plateLicense) {
        for (int i = 0; i < stackCar.size(); i++) {
            Car car = stackCar.get(i);
            if (car.getPlateLicense().equalsIgnoreCase(plateLicense)) {
                return car;
            }
        }
        return null;
    }

    public Car[] getAllCars() {
        return stackToArray(stackCar);
    }

    public void updateCar(Car newCar) {
        Stackable<Car> tempStack = new Stackable<Car>(20);
        while (!stackCar.isEmpty()) {
            Car car = stackCar.pop();
            if (car.getPlateLicense().equalsIgnoreCase(newCar.getPlateLicense())) {
                tempStack.push(newCar);
            } else {
                tempStack.push(car);
            }
        }
        while (!tempStack.isEmpty()) {
            stackCar.push(tempStack.pop());
        }
    }

    public Car deleteCar(String plateLicense) {
        Stackable<Car> tempStack = new Stackable<Car>(20);
        Car resultCar = null;

        while (!stackCar.isEmpty()) {
            Car car = stackCar.pop();
            if (car.getPlateLicense().equalsIgnoreCase(plateLicense)) {
                resultCar = car;
                
            } else {
                tempStack.push(car);
            }
        }

        while (!tempStack.isEmpty()) {
            stackCar.push(tempStack.pop());
        }

        return resultCar;
    }

    public void removeCarsByOwner(String owner) {
        Stackable<Car> tempStack = new Stackable<Car>(20);

        while (!stackCar.isEmpty()) {
            Car car = stackCar.pop();
            if (!car.getOwner().equalsIgnoreCase(owner)) {
                tempStack.push(car);
            }
        }

        while (!tempStack.isEmpty()) {
            stackCar.push(tempStack.pop());
        }
    }

    public void removeCarsOlderThan(LocalDateTime date) {
        Stackable<Car> tempStack = new Stackable<Car>(20);

        while (!stackCar.isEmpty()) {
            Car car = stackCar.pop();
            if (car.getArrivalTime().isAfter(date)) { 
                tempStack.push(car);
            }
        }

        while (!tempStack.isEmpty()) {
            stackCar.push(tempStack.pop());
        }
    }

    
   
}
