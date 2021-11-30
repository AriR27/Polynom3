public abstract class AbstractCar {
    private String number="";
    private int weight;
    protected int maxSpeed;

    public AbstractCar(String number){
        if (checkNumber(number)){
            this.number=number;
        } else new IllegalArgumentException("Некорректный номер");
    }

    public abstract void makeSomeNoise();


    public void setNumber(String number) {
        this.number = number;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Номер машины" +
                number +  "\n" +"Масса машины" +
                 weight +"\n"+"Максимальная скорость машины" +
               + maxSpeed +'\n';
    }

    public boolean checkNumber(String number){
        if(number.length()==6)
        {
            return true;}
            else {
            return false;
        }
    }
}
