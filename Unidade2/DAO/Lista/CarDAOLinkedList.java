import java.time.LocalDateTime;
import java.time.Duration;

public class CarDAOLinkedList implements CarDAO {

    private Listable<Car> cars = new LinkedList<>(20);

    @Override
    public void addCar(Car car) {
        cars.append(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        Car result = null;
        int index = findIndexBypl(plateLicense);
        if (index >= 0) {
            result = cars.select(index);
        }
        return result;
    }

    @Override
    public Car[] getAllCars() {
        return cars.selectAll();
    }

    @Override
    public void updateCar(Car newCar) {
        if (newCar == null) {
            throw new IllegalArgumentException("novo carro não pode ser nulo");
        }
        String aux = newCar.getLicensePlate();
        int index = findIndexBypl(aux);
        if (index < 0) {
            throw new IllegalArgumentException("carro não encontrado para atualização");
        }
        cars.update(index, newCar);
    }

    @Override
    public Car deleteCar(String plateLicense) {
        int index = findIndexBypl(plateLicense);
        if (index < 0) {
            throw new IllegalArgumentException("carro não encontrado para deletar");
        }
        return cars.delete(index);
    }

    @Override
    public Car getCarByLicensePlate(String licensePlate) {
        return getCar(licensePlate);
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        Listable<Car> result = new LinkedList<>(20);
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.select(i);
            if (c.getMark() != null && c.getMark().equalsIgnoreCase(mark)) {
                result.append(c);
            }
        }
        return result.selectAll();
    }

    @Override
    public Car[] getCarsByModel(String model) {
        Listable<Car> result = new LinkedList<>(20);
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.select(i);
            if (c.getModel() != null && c.getModel().equalsIgnoreCase(model)) {
                result.append(c);
            }
        }
        return result.selectAll();
    }

    @Override
    public Car[] getCarsByColor(String color) {
        Listable<Car> result = new LinkedList<>(20);
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.select(i);
            if (c.getColor() != null && c.getColor().equalsIgnoreCase(color)) {
                result.append(c);
            }
        }
        return result.selectAll();
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        Listable<Car> result = new LinkedList<>(20);
        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.select(i);
            if (c.getOwnerName() != null && c.getOwnerName().equalsIgnoreCase(owner)) {
                result.append(c);
            }
        }
        return result.selectAll();
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        if (initialMoment == null || finalMoment == null) return new Car[0];

        Listable<Car> result = new LinkedList<>(20);
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.select(i);
            if (car.getArrived() == null) continue;

            LocalDateTime arr = car.getArrived();

            if ((arr.isAfter(initialMoment) || arr.isEqual(initialMoment)) &&
                (arr.isBefore(finalMoment) || arr.isEqual(finalMoment))) {
                result.append(car);
            }
        }
        return result.selectAll();
    }

    @Override
    public Car getCarByNewestArrival() {
        Car atual = null;
        LocalDateTime aux = null;

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.select(i);
            if (car != null && car.getArrived() != null) {
                if (aux == null || car.getArrived().isAfter(aux)) {
                    aux = car.getArrived();
                    atual = car;
                }
            }
        }
        return atual;
    }

    @Override
    public Car getCarByOldestArrival() {
        Car atual = null;
        LocalDateTime aux = null;

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.select(i);
            if (car != null && car.getArrived() != null) {
                if (aux == null || car.getArrived().isBefore(aux)) {
                    aux = car.getArrived();
                    atual = car;
                }
            }
        }
        return atual;
    }

    @Override
    public String printCars() {
        return cars.print();
    }

    @Override
    public int getTotalCars() {
        return cars.size();
    }

    @Override
    public String getMostPopularMark() {
        if (cars.size() == 0) return null;

        String most = null;
        int bestCount = 0;

        for (int i = 0; i < cars.size(); i++) {
            String mark = cars.select(i).getMark();
            if (mark == null) continue;

            int count = 0;
            for (int j = 0; j < cars.size(); j++) {
                if (mark.equalsIgnoreCase(cars.select(j).getMark())) count++;
            }

            if (count > bestCount) {
                bestCount = count;
                most = mark;
            }
        }
        return most;
    }

    @Override
    public String getMostPopularModel() {
        if (cars.size() == 0) return null;

        String most = null;
        int bestCount = 0;

        for (int i = 0; i < cars.size(); i++) {
            String model = cars.select(i).getModel();
            if (model == null) continue;

            int count = 0;
            for (int j = 0; j < cars.size(); j++) {
                if (model.equalsIgnoreCase(cars.select(j).getModel())) count++;
            }

            if (count > bestCount) {
                bestCount = count;
                most = model;
            }
        }
        return most;
    }

    @Override
    public String getMostPopularColor() {
        if (cars.size() == 0) return null;

        String most = null;
        int bestCount = 0;

        for (int i = 0; i < cars.size(); i++) {
            String color = cars.select(i).getColor();
            if (color == null) continue;

            int count = 0;
            for (int j = 0; j < cars.size(); j++) {
                if (color.equalsIgnoreCase(cars.select(j).getColor())) count++;
            }

            if (count > bestCount) {
                bestCount = count;
                most = color;
            }
        }
        return most;
    }

    @Override
    public boolean isCarInPlaced(String plateLicense) {
        return findIndexBypl(plateLicense) >= 0;
    }

    @Override
    public void clearAllCars() {
        while (!cars.isEmpty()) {
            cars.delete(0);
        }
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        if (date == null) return;

        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.select(i);
            if (c.getArrived() != null && c.getArrived().isBefore(date)) {
                cars.delete(i);
                i--;
            }
        }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        Listable<Car> result = new LinkedList<>(20);

        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.select(i);
            if (c.getArrived() == null) continue;

            long hours = Duration.between(c.getArrived(), LocalDateTime.now()).toHours();

            if (hours >= minHours && hours <= maxHours) {
                result.append(c);
            }
        }
        return result.selectAll();
    }

    @Override
    public int getAvailableSpaces() {
        return cars.getMaxSize() - cars.size();
    }

    @Override
    public boolean isParkingEmpty() {
        return cars.size() == 0;
    }

    @Override
    public int getMaxCapacity() {
        return cars.getMaxSize();
    }

    @Override
    public int getOccupancyRate() {
        return (cars.size() * 100) / cars.getMaxSize();
    }

    @Override
    public boolean isParkingFull() {
        return cars.size() == cars.getMaxSize();
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        int idx = findIndexBypl(plateLicense);
        if (idx < 0) return -1;

        Car c = cars.select(idx);
        if (c.getArrived() == null) return -1;

        return Duration.between(c.getArrived(), LocalDateTime.now()).toHours();
    }

    @Override
    public void removeCarsByOwner(String owner) {
        if (owner == null) return;

        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.select(i);
            if (owner.equalsIgnoreCase(c.getOwnerName())) {
                cars.delete(i);
                i--;
            }
        }
    }

    @Override
    public long getAverageArrivalTime() {
        long total = 0;
        int count = 0;

        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.select(i);
            if (c.getArrived() != null) {
                total += c.getArrived().atZone(java.time.ZoneId.systemDefault()).toEpochSecond();
                count++;
            }
        }

        if (count == 0) return 0;

        return total / count;
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        Listable<Car> result = new LinkedList<>(20);

        for (int i = 0; i < cars.size(); i++) {
            Car c = cars.select(i);
            if (c.getArrived() == null) continue;

            long hours = Duration.between(c.getArrived(), LocalDateTime.now()).toHours();
            if (hours >= thresholdHours) {
                result.append(c);
            }
        }
        return result.selectAll();
    }

    private int findIndexBypl(String plateLicense) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.select(i).getLicensePlate().equalsIgnoreCase(plateLicense)) {
                return i;
            }
        }
        return -1;
    }
}
