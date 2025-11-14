import java.time.Duration;
import java.time.LocalDateTime;

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
        Car resultcar=null;
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
        while(!cars.isEmpty()){
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
       Car resultcar=null;
        while(!cars.isEmpty()){
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
        Car resultcar=null;
         while(!cars.isEmpty()){
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
         Stackable<Car> temp1 = new LinkedStack<>(20);

    String markMaisPopular = null;
    int maiorContagem = 0;
    while (!cars.isEmpty()) {

        Car atual = cars.pop();
        temp1.push(atual);

        String Atual = atual.getMark();

        int contador = 1;
        while (!cars.isEmpty()) {
            Car outro = cars.pop();
            temp1.push(outro);

            if (Atual != null && Atual.equals(outro.getMark())) {
                contador++;
            }
        }
        while (!temp1.isEmpty()) {
            cars.push(temp1.pop());
        }
        if (contador > maiorContagem) {
            maiorContagem = contador;
            markMaisPopular = Atual;
        }
    }

    return markMaisPopular;
    }

    @Override
    public String getMostPopularModel() {
     
    Stackable<Car> temp1 = new LinkedStack<>(20);

    String modeloMaisPopular = null;
    int maiorContagem = 0;
    while (!cars.isEmpty()) {

        Car atual = cars.pop();
        temp1.push(atual);

        String modeloAtual = atual.getModel();

        int contador = 1;
        while (!cars.isEmpty()) {
            Car outro = cars.pop();
            temp1.push(outro);

            if (modeloAtual != null && modeloAtual.equals(outro.getModel())) {
                contador++;
            }
        }
        while (!temp1.isEmpty()) {
            cars.push(temp1.pop());
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
    Stackable<Car> temp1 = new LinkedStack<>(20);

    String corMaisPopular = null;
    int maiorContagem = 0;
    while (!cars.isEmpty()) {

        Car atual = cars.pop();
        temp1.push(atual);

        String corAtual = atual.getModel();

        int contador = 1;
        while (!cars.isEmpty()) {
            Car outro = cars.pop();
            temp1.push(outro);

            if (corAtual != null && corAtual.equals(outro.getColor())) {
                contador++;
            }
        }
        while (!temp1.isEmpty()) {
            cars.push(temp1.pop());
        }
        if (contador > maiorContagem) {
            maiorContagem = contador;
            corMaisPopular = corAtual;
        }
    }
    return corMaisPopular;
    }

    // Operações de gerenciamento
    /*
     */
    @Override
    public boolean isCarInPlaced(String plateLicense) {
          Stackable<Car> temp =new LinkedStack<>(20);
        boolean resultcar=false;
         while(!cars.isEmpty()){
            Car car=cars.pop();
            if(car.getLicensePlate()==plateLicense){
            temp.push(car);
            resultcar=true;
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
    public void clearAllCars() {
         while(!cars.isEmpty()){
            Car car=cars.pop();
            
    }
}

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
    Stackable<Car> temp =new LinkedStack<>(20);
         while(!cars.isEmpty()){
            Car car=cars.pop();
            if(!car.getArrived().isBefore(date)){
            temp.push(car);
            break;
        }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        }
    }
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
      Stackable<Car>temp= new LinkedStack<>(20);
        Stackable<Car>aux= new LinkedStack<>(20);
      LocalDateTime atual=LocalDateTime.now();
      while(!cars.isEmpty()){
        Car car=cars.pop();
        temp.push(car);
        if(car.getArrived()!=null){
            long dur=Duration.between(car.getArrived(), atual ).toHours();
            if(dur>=minHours && dur<=maxHours){
                aux.push(car);
            }
        }

      }
      return stackToArray(aux);
    }

    @Override
    public int getAvailableSpaces() {
       return getMaxCapacity()-countElements(cars);
        }

    @Override
    public boolean isParkingEmpty() {
        return cars.isEmpty();
    }

    @Override
    public int getMaxCapacity() {
        Stackable<Car>temp=new LinkedStack<>();
        int cont=0;
        Car phaton=new Car("xxxx","xxxx","xxxxxx");
        while(!cars.isEmpty()){
            Car car=cars.pop();
            temp.push(car);
        }
        while(!cars.isFull()){
            cars.push(phaton);
            cont++;
        } while(!cars.isEmpty()){
            cars.pop();
    }
    while(!temp.isEmpty()){
        cars.push(temp.pop());
    }
    return cont;
}

    @Override
    public int getOccupancyRate() {
      int cap=getMaxCapacity();
      int atual= countElements(cars);
      if(cap==0){
        return 0;
      }
      return (atual*100)/cap;
    }

    @Override
    public boolean isParkingFull() {
    return cars.isFull();
    }

    @Override
    public long getParkingDuration(String plateLicense) {
         Stackable<Car>temp= new LinkedStack<>(20);
        Stackable<Car>aux= new LinkedStack<>(20);
      LocalDateTime atual=LocalDateTime.now();
      long dur=0;
      while(!cars.isEmpty()){
        Car car=cars.pop();
        temp.push(car);
        if(car.getLicensePlate().equals(plateLicense)){
        if(car.getArrived()!=null){
        dur=Duration.between(car.getArrived(), atual ).toHours();
    }
}
}
return dur;
}

    @Override
    public void removeCarsByOwner(String owner) {
        Stackable<Car> temp =new LinkedStack<>(20);
        while(!cars.isEmpty()){
            Car car=cars.pop();
            if(!car.getOwnerName().equalsIgnoreCase(owner)){
            temp.push(car);
        }
    }
        while(!temp.isEmpty()){
            cars.push(temp.pop());
        
    }
}

    @Override
    public long getAverageArrivalTime() {
    if (cars.isEmpty()) {
        return 0;
    }

    Stackable<Car> temp = new LinkedStack<>(20);

    long soma = 0;
    int qtd = 0;

    while (!cars.isEmpty()) {
        Car car = cars.pop();
        temp.push(car);

        if (car.getArrived() != null) {
            soma += car.getArrived().atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
            qtd++;
        }
    }

    while (!temp.isEmpty()) {
        cars.push(temp.pop());
    }

    return (qtd == 0 ? 0 : soma / qtd);
}

    

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
    Stackable<Car> temp = new LinkedStack<>(20);
    Stackable<Car> result = new LinkedStack<>(20);

    LocalDateTime agora = LocalDateTime.now();

    while (!cars.isEmpty()) {
        Car car = cars.pop();
        temp.push(car);

        if (car.getArrived() != null) {
            long horas = Duration.between(car.getArrived(), agora).toHours();
            if (horas >= thresholdHours) {
                result.push(car);
            }
        }
    }

    while (!temp.isEmpty()) {
        cars.push(temp.pop());
    }

    return stackToArray(result);
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
