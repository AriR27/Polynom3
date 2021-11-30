public  class Car extends AbstractCar{
    private int countOfPassengers;
    public Car(String number,int countOfPassengers){
        super(number);
        this.countOfPassengers=countOfPassengers;
    }

    public void setCountOfPassengers(int countOfPassengers) {
        this.countOfPassengers = countOfPassengers;
    }

    public int getCountOfPassengers() {
        return countOfPassengers;
    }
@Override
public void makeSomeNoise(){
    System.out.println("вр==вр");
}
    @Override
    public String toString() {
        return super.toString()+"\n"+
                "Количество пассажиров" +
               countOfPassengers;
    }
}
