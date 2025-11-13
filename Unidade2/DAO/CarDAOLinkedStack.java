import java.time.LocalDateTime;
import java.util.NoSuchElementException;

public class CarDAOLinkedStack implements CarDAO {
    private int amount;
    private int capcity;
     private Stackable<Car> cars = new LinkedStack<>(20);

    // Operações básicas CRUD
    @Override
    public void addCar(Car car) {
        cars.push(car); 
    }

    @Override
    public Car getCar(String plateLicense) {
        Stackable<Car> temp =new LinkedStack<>(20);
        Car resultcar;
         while(cars.isEmpty()){
            Car car=cars.pop();
            if(car.getLicensePlate()==plateLicense){
            resultcar=car;
            temp.push(car);
            break;
            }else{
                temp.push(car);
            }
        }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
        return resultcar;
    }

    @Override
    public Car[] getAllCars() {
       return stackToArray(cars);
    }

    @Override
    public void updateCar(Car newCar) {
        Stackable<Car> temp =new LinkedStack<>(20);
        while(cars.isEmpty()){
            Car car=cars.pop();
            if(car.getLicensePlate()==newCar.getLicensePlate()){
                temp.push(newCar);
                break;
            }else{
                temp.push(car);
            }
        }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
       Stackable<Car> temp =new LinkedStack<>(20);
       Car resultcar;
        while(cars.isEmpty()){
            Car car=cars.pop();
            if(car.getLicensePlate()==plateLicense){
                resultcar=car;
                break;
            }else{
                temp.push(car);
            }
        }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
        return resultcar;
    }

    // Operações de consulta específicas para carros
    @Override
    public Car getCarByLicensePlate(String licensePlate) {
         Stackable<Car> temp =new LinkedStack<>(20);
        Car resultcar;
         while(cars.isEmpty()){
            Car car=cars.pop();
            if(car.getLicensePlate()==licensePlate){
            resultcar=car;
            temp.push(car);
            break;
            }else{
                temp.push(car);
            }
        }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
        return resultcar;
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        Stackable<Car> temp =new LinkedStack<>(20);
        Stackable<Car> result =new LinkedStack<>(20);
        
        while(!cars.isEmpty()){
            Car car=cars.pop();
            temp.push(car);
            if(car.getMark()!=null && car.getMark().equalsIgnoreCase(mark)){
            result.push(car);
            }
        }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
        return stackToArray(result);

    }

    @Override
    public Car[] getCarsByModel(String model) {
        Stackable<Car> temp =new LinkedStack<>(20);
        Stackable<Car> result =new LinkedStack<>(20);
        
        while(!cars.isEmpty()){
            Car car=cars.pop();
            temp.push(car);
            if(car.getModel()!=null && car.getModel().equalsIgnoreCase(model)){
            result.push(car);
            }
        }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
        return stackToArray(result);

    }

    @Override
    public Car[] getCarsByColor(String color) {
         Stackable<Car> temp =new LinkedStack<>(20);
        Stackable<Car> result =new LinkedStack<>(20);
        
        while(!cars.isEmpty()){
            Car car=cars.pop();
            temp.push(car);
            if(car.getColor()!=null && car.getColor().equalsIgnoreCase(color)){
            result.push(car);
            }
        }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
        return stackToArray(result);

    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        Stackable<Car> temp =new LinkedStack<>(20);
        Stackable<Car> result =new LinkedStack<>(20);
        
        while(!cars.isEmpty()){
            Car car=cars.pop();
            temp.push(car);
            if(car.getOwnerName()!=null && car.getOwnerName().equalsIgnoreCase(owner)){
            result.push(car);
            }
        }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
        return stackToArray(result);

    }
    

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
         Stackable<Car> temp =new LinkedStack<>(20);
        Stackable<Car> result =new LinkedStack<>(20);
        
        while(!cars.isEmpty()){
            Car car=cars.pop();
            temp.push(car);
            if(car.getArrived() != null && 
                !car.getArrived().isBefore(initialMoment) && 
                !car.getArrived().isAfter(finalMoment)){
            result.push(car);
            }
        }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
        return stackToArray(result);

    }
    

    // Operações de análise e estatísticas
    @Override
    public Car getCarByNewestArrival() {
     Stackable<Car> temp = new LinkedStack<>(20);
    Car resultCar = null;

    if (!cars.isEmpty()) {
        Car car = cars.pop();
        temp.push(car);

        if (car.getArrived() != null) {
            resultCar = car;
        }

        while (!cars.isEmpty()) {
            car = cars.pop();
            temp.push(car);

            if (car.getArrived() != null) {
                if (resultCar == null ||
                    car.getArrived().isAfter(resultCar.getArrived())) {
                    
                    resultCar = car;
                }
            }
        }
    }
    while (!temp.isEmpty()) {
        cars.push(temp.pop());
    }

    return resultCar;
}
    @Override
    public Car getCarByOldestArrival() {
        Stackable<Car> temp = new LinkedStack<>(20);
    Car resultCar = null;

    if (!cars.isEmpty()) {
        Car car = cars.pop();
        temp.push(car);

        if (car.getArrived() != null) {
            resultCar = car;
        }

        while (!cars.isEmpty()) {
            car = cars.pop();
            temp.push(car);

            if (car.getArrived() != null) {
                if (resultCar == null ||
                    car.getArrived().isBefore(resultCar.getArrived())) {
                    
                    resultCar = car;
                }
            }
        }
    }
    while (!temp.isEmpty()) {
        cars.push(temp.pop());
    }

    return resultCar;
}

    // Operações de relatório e estatísticas
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
        
    }

    @Override
    public String getMostPopularModel() {
       if (stackCars.isEmpty()) {
        return null;
    }

    Stackable<Car> temp1 = new LinkedStack<>(20);

    String modeloMaisPopular = null;
    int maiorContagem = 0;
    while (!stackCars.isEmpty()) {

        Car atual = stackCars.pop();
        temp1.push(atual);

        String modeloAtual = atual.getModel();

        int contador = 1;
        while (!stackCars.isEmpty()) {
            Car outro = stackCars.pop();
            temp1.push(outro);

            if (modeloAtual != null && modeloAtual.equals(outro.getModel())) {
                contador++;
            }
        }
        while (!temp1.isEmpty()) {
            stackCars.push(temp1.pop());
        }
        if (contador > maiorContagem) {
            maiorContagem = contador;
            modeloMaisPopular = modeloAtual;
        }
    }

    return modeloMaisPopular;
    }

    @Override
    public String getMostPopularColor() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    // Operações de gerenciamento
    @Override
    public boolean isCarInPlaced(String plateLicense) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void clearAllCars() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getAvailableSpaces() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public boolean isParkingEmpty() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getMaxCapacity() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public int getOccupancyRate() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public boolean isParkingFull() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public void removeCarsByOwner(String owner) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public long getAverageArrivalTime() {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        throw new UnsupportedOperationException("Operação ainda não implementada");
    }
    private Car[] stackToArray(Stackable<Car> stack) {
    int size = countElements(stack);
    Car[] resultArrayCars = new Car[size];
    Stackable<Car> tempStack = new LinkedStack<>(size);
    int index = 0;

    while (!stack.isEmpty()) {
        Car c = stack.pop();
        tempStack.push(c);
        resultArrayCars[index++] = c;
    }

    while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
    }

    return resultArrayCars;
}

private Stackable<Car> arrayToStack(Car[] cars) {
    Stackable<Car> resultStackCars = new LinkedStack<>(cars.length);
    for (Car car : cars) {
        resultStackCars.push(car);
    }
    return resultStackCars;
}

private int countElements(Stackable<Car> stack) {
    int count = 0;
    Stackable<Car> tempStack = new LinkedStack<>(20);

    while (!stack.isEmpty()) {
        tempStack.push(stack.pop());
        count++;
    }

    while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
    }

    return count;
}

}
