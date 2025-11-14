import java.time.LocalDateTime;

public class CarDAOLinkedDEQue implements CarDAO {

    private DEQueable<Car> cars = new LinkedDEQue<>(20);

    @Override
    public void addCar(Car car) {
        cars.enqueue(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        Car result = null;

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            temp.enqueue(car);

            if (car.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                result = car;
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return result;
    }

    @Override
    public Car[] getAllCars() {
        return queueToArray(cars);
    }

    @Override
    public void updateCar(Car newCar) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            if (car.getLicensePlate().equalsIgnoreCase(newCar.getLicensePlate())) {
                temp.enqueue(newCar);
            } else {
                temp.enqueue(car);
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        Car result = null;

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            if (car.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                result = car;
                break;
            } else {
                temp.enqueue(car);
            }
        }

        while (!cars.isEmpty()) {
            temp.enqueue(cars.dequeue());
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return result;
    }

    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        Car result = null;

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            temp.enqueue(car);

            if (car.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                result = car;
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return result;
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        DEQueable<Car> result = new LinkedDEQue<>(20);

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            temp.enqueue(car);

            if (car.getMark().equalsIgnoreCase(mark)) {
                result.enqueue(car);
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return queueToArray(result);
    }

    @Override
    public Car[] getCarsByModel(String model) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        DEQueable<Car> result = new LinkedDEQue<>(20);

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            temp.enqueue(car);

            if (car.getModel().equalsIgnoreCase(model)) {
                result.enqueue(car);
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return queueToArray(result);
    }

    @Override
    public Car[] getCarsByColor(String color) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        DEQueable<Car> result = new LinkedDEQue<>(20);

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            temp.enqueue(car);

            if (car.getColor().equalsIgnoreCase(color)) {
                result.enqueue(car);
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return queueToArray(result);
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        DEQueable<Car> result = new LinkedDEQue<>(20);

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            temp.enqueue(car);

            if (car.getOwnerName().equalsIgnoreCase(owner)) {
                result.enqueue(car);
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return queueToArray(result);
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        DEQueable<Car> result = new LinkedDEQue<>(20);

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            temp.enqueue(car);

            if (car.getArrived() != null &&
                (car.getArrived().isEqual(initialMoment) || car.getArrived().isAfter(initialMoment)) &&
                (car.getArrived().isEqual(finalMoment) || car.getArrived().isBefore(finalMoment))) {

                result.enqueue(car);
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return queueToArray(result);
    }

    @Override
    public Car getCarByNewestArrival() {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        Car result = null;

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            temp.enqueue(car);

            if (car.getArrived() != null &&
                (result == null || car.getArrived().isAfter(result.getArrived()))) {
                result = car;
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return result;
    }

    @Override
    public Car getCarByOldestArrival() {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        Car result = null;

        while (!cars.isEmpty()) {
            Car car = cars.dequeue();
            temp.enqueue(car);

            if (car.getArrived() != null &&
                (result == null || car.getArrived().isBefore(result.getArrived()))) {
                result = car;
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return result;
    }

    @Override
    public String printCars() {
        return cars.toString();
    }

    @Override
    public int getTotalCars() {
        return countElements(cars);
    }

    @Override
    public String getMostPopularMark() {
        return getMostPopularAttribute("mark");
    }

    @Override
    public String getMostPopularModel() {
        return getMostPopularAttribute("model");
    }

    @Override
    public String getMostPopularColor() {
        return getMostPopularAttribute("color");
    }

    private String getMostPopularAttribute(String type) {

        DEQueable<Car> temp1 = new LinkedDEQue<>(20);
        DEQueable<Car> temp2 = new LinkedDEQue<>(20);

        String mostPopular = null;
        int maiorContagem = 0;

        while (!cars.isEmpty()) {

            Car atual = cars.dequeue();
            temp1.enqueue(atual);

            String valorAtual = switch (type) {
                case "mark" -> atual.getMark();
                case "model" -> atual.getModel();
                case "color" -> atual.getColor();
                default -> null;
            };

            int contador = 1;

            while (!cars.isEmpty()) {
                Car outro = cars.dequeue();
                temp1.enqueue(outro);

                String valorOutro = switch (type) {
                    case "mark" -> outro.getMark();
                    case "model" -> outro.getModel();
                    case "color" -> outro.getColor();
                    default -> null;
                };

                if (valorAtual != null && valorAtual.equals(valorOutro)) {
                    contador++;
                }
            }

            while (!temp1.isEmpty()) {
                temp2.enqueue(temp1.dequeue());
            }

            while (!temp2.isEmpty()) {
                cars.enqueue(temp2.dequeue());
            }

            if (contador > maiorContagem) {
                maiorContagem = contador;
                mostPopular = valorAtual;
            }
        }

        return mostPopular;
    }

    private int countElements(DEQueable<Car> queue) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        int count = 0;

        while (!queue.isEmpty()) {
            temp.enqueue(queue.dequeue());
            count++;
        }

        while (!temp.isEmpty()) {
            queue.enqueue(temp.dequeue());
        }

        return count;
    }

    private Car[] queueToArray(DEQueable<Car> queue) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        int count = 0;

        while (!queue.isEmpty()) {
            temp.enqueue(queue.dequeue());
            count++;
        }

        Car[] array = new Car[count];
        int i = 0;

        while (!temp.isEmpty()) {
            Car car = temp.dequeue();
            array[i++] = car;
            queue.enqueue(car);
        }

        return array;
    }

    @Override
    public boolean isCarInPlaced(String plateLicense) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        boolean found = false;

        while (!cars.isEmpty()) {
            Car c = cars.dequeue();
            if (c.getLicensePlate().equalsIgnoreCase(plateLicense)) {
                found = true;
            }
            temp.enqueue(c);
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return found;
    }

    @Override
    public void clearAllCars() {
        while (!cars.isEmpty()) {
            cars.dequeue();
        }
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);

        while (!cars.isEmpty()) {
            Car c = cars.dequeue();
            if (c.getArrived() != null && c.getArrived().isAfter(date)) {
                temp.enqueue(c);
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        DEQueable<Car> result = new LinkedDEQue<>(20);
        LocalDateTime now = LocalDateTime.now();

        while (!cars.isEmpty()) {
            Car c = cars.dequeue();
            temp.enqueue(c);

            if (c.getArrived() != null) {
                long hours = java.time.Duration.between(c.getArrived(), now).toHours();
                if (hours >= minHours && hours <= maxHours) {
                    result.enqueue(c);
                }
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return queueToArray(result);
    }

    @Override
    public int getAvailableSpaces() {
        return getMaxCapacity() - getTotalCars();
    }

    @Override
    public boolean isParkingEmpty() {
        return cars.isEmpty();
    }

    @Override
    public int getMaxCapacity() {
        return 20;
    }

    @Override
    public int getOccupancyRate() {
        int total = getTotalCars();
        return (total * 100) / getMaxCapacity();
    }

    @Override
    public boolean isParkingFull() {
        return getTotalCars() >= getMaxCapacity();
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        Car c = getCarByLicensePlate(plateLicense);
        if (c == null || c.getArrived() == null) return -1;

        return java.time.Duration.between(c.getArrived(), LocalDateTime.now()).toHours();
    }

    @Override
    public void removeCarsByOwner(String owner) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);

        while (!cars.isEmpty()) {
            Car c = cars.dequeue();
            if (!c.getOwnerName().equalsIgnoreCase(owner)) {
                temp.enqueue(c);
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }
    }

    @Override
    public long getAverageArrivalTime() {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        long total = 0;
        int count = 0;

        while (!cars.isEmpty()) {
            Car c = cars.dequeue();
            temp.enqueue(c);

            if (c.getArrived() != null) {
                total += c.getArrived().toEpochSecond(java.time.ZoneOffset.UTC);
                count++;
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        if (count == 0) return -1;

        return total / count;
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        DEQueable<Car> temp = new LinkedDEQue<>(20);
        DEQueable<Car> result = new LinkedDEQue<>(20);
        LocalDateTime now = LocalDateTime.now();

        while (!cars.isEmpty()) {
            Car c = cars.dequeue();
            temp.enqueue(c);

            if (c.getArrived() != null) {
                long hours = java.time.Duration.between(c.getArrived(), now).toHours();
                if (hours >= thresholdHours) {
                    result.enqueue(c);
                }
            }
        }

        while (!temp.isEmpty()) {
            cars.enqueue(temp.dequeue());
        }

        return queueToArray(result);
    }
}
