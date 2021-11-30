import java.util.Arrays;

public class Truck extends AbstractCar{

    private String[] owners;
    @Override
    public void makeSomeNoise(){
        System.out.println("р==р");
    }

    public Truck(String number,String[] owners){
        super(number);
        this.owners=owners;
    }
    @Override
    public String toString() {
        return super.toString()+"\n"+
                "все владельцы:" + Arrays.toString(owners);

   /* @Override
    public String toString() {
        return "Номер машины:" +super.getNumber() +"\n"+
                "все владельцы:" + Arrays.toString(owners);
    }*/



















    //инкапсуляция - закрываем доступ к полям и даем доступ по проверкам
    //наследование
    //абстракция
    //полиморфизм-использование иерархии, пример с шумом
    /*public void setOwners(String[] owners){
        this.owners=owners;
    }
   public String[] getOwners(){return owners.clone();}// создает новое место в памяти и если пользователь захочет поменять значение у него не получитяс
    // в стеке адресс где находится значение, а сами значения в хипе
    public void setNumber(String number){
        if(number.length()==6)
        {
        this.number=number;
        } else {
            throw new IllegalArgumentException("Длина строки равна"+number.length());
        }
    }
    public String getNumber(){
        return number;
    }
    public String ToString(){
        return "Номер этого грузовика:" + number;
    }*/
}}
