import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.Function;
import java.io.IOException;


public class Polynom {
    double [] Coeff;
    public Polynom(double [] Coeff)
    {
        this.Coeff= Coeff;
    }
    public static Polynom sum(Polynom a,Polynom p)
    {
        double[] result = new double[Math.max(a.Coeff.length,p.Coeff.length)];
        if (a.Coeff.length==p.Coeff.length)
        {
            for (int i = 0; i < result.length; i++)
            {
                result[i] = a.Coeff[i] + p.Coeff[i];

            }
        }
            else if (a.Coeff.length>p.Coeff.length)
            {
                for(int j=0;j< p.Coeff.length;j++) {
                    result[j] = a.Coeff[j] + p.Coeff[j];}
                for (int i = p.Coeff.length; i < a.Coeff.length; i++) {
                    result[i] += a.Coeff[i];
                }

            }

            else if (a.Coeff.length <p.Coeff.length)
            {
                for(int j=0;j<a.Coeff.length;j++) {
                    result[j] = a.Coeff[j] + p.Coeff[j];
                }
                for (int m =a.Coeff.length; m<p.Coeff.length;m++)
                {
                    result[m]+= p.Coeff[m];
                }
            }
            Polynom c= new Polynom(result);
              return c;
        }
      public static Polynom mult_dig( Polynom a,double b)
      {      double[] result= new double[a.Coeff.length];

                    for(int i=0; i<a.Coeff.length; i++){
                         result[i]= b*a.Coeff[i];
                    }
                    Polynom c= new Polynom(result);
                    return c;
      }

    public static Polynom mult(Polynom a, Polynom b) { //умножение многочленов
        int size = a.Coeff.length+b.Coeff.length-1;
        double[] result = new double[size];
        for (int i=0; i<a.Coeff.length; i++){
            for(int j=0; j<b.Coeff.length;j++){
                result[i+j]+=a.Coeff[i]*b.Coeff[j];
            }
        }
        return new Polynom(result);
    }
    public String ToString() {// взято полностью у Сонечки, как же лень думать://
        String result="";

        if(Coeff.length==1){
            result+=Coeff[0];
        }

        if (Coeff.length==2){
            if (Coeff[1] > 0) {
                if (Coeff[1] == 1) {
                    result += "x";
                } else
                    result += Coeff[1] + "x";
            }
            if (Coeff[1] == 0) {
                result = result;
            }
            if (Coeff[1] < 0) {
                if (Coeff[1] == -1) {
                    result += "-x";
                } else
                    result += Coeff[1] + "x";
            }

            if (Coeff[0] > 0) {
                result += "+" + Coeff[0];
            }
            if (Coeff[0] == 0) {
                result = result;
            }
            if (Coeff[0] < 0) {
                result += Coeff[0];
            }
        }

        if (Coeff.length>2) {
            if (Coeff[Coeff.length - 1] == 1) {
                result = "x^" + (Coeff.length - 1);
            }
            if (Coeff[Coeff.length - 1] == -1) {
                result = "-x^" + (Coeff.length - 1);
            } else {
                result = Coeff[Coeff.length - 1] + "x^" + (Coeff.length - 1);
            }

            for (int i = Coeff.length - 2; i > 1; i--) {

                if (Coeff[i] == 0) {
                    result += "";
                }

                if (Coeff[i] > 0) {
                    if (Coeff[i] == 1) {
                        result += "+x^" + i;
                    } else
                        result += "+" + Coeff[i] + "x^" + i;
                }

                if (Coeff[i] < 0) {
                    if (Coeff[i] == -1) {
                        result += "-x^" + i;
                    } else
                        result += Coeff[i] + "x^" + i;
                }

            }
            if (Coeff[1] > 0) {
                if (Coeff[1] == 1) {
                    result += "+x";
                } else
                    result += "+" + Coeff[1] + "x";
            }
            if (Coeff[1] == 0) {
                result = result;
            }
            if (Coeff[1] < 0) {
                if (Coeff[1] == -1) {
                    result += "-x";
                } else
                    result += Coeff[1] + "x";
            }

            if (Coeff[0] > 0) {
                result += "+" + Coeff[0];
            }
            if (Coeff[0] == 0) {
                result = result;
            }
            if (Coeff[0] < 0) {
                result += Coeff[0];
            }
        }

        return result;
    }

     public static Polynom[] l_k_chislit(double points[]){
         Polynom[] l_k_chis= new Polynom[points.length];
        for(int k=1; k< points.length; k++){
            l_k_chis[k]=new Polynom(new double[]{-1*points[k],1});
        }
        return l_k_chis;
     }
     public static double[] l_k_znam(double points[]){
        double[] l_k_zman=new double[points.length];
        for (int k=1;k< points.length;k++){
            for (int j=1;j< points.length;j++){
                if (j!=k){
                    l_k_zman[k]=1/(points[k]-points[j]);
                }
            }

        } return l_k_zman;
     }

    public static Polynom[] l_k(double points[]){
        Polynom[] l_k=new Polynom[points.length];
       // Polynom mul=new Polynom(l_k_znam(points));
        for (int k=1;k<points.length;k++){
            l_k[k]=Polynom.mult_dig(l_k_chislit(points)[k],l_k_znam(points)[k]);
        } return l_k;
    }
     public static Polynom Coeff_Lagr(double[] points,double[] val_func){
        /* double[] points;
         double[] val_func;
         System.out.println("Enter space-separated points: ");
         Scanner reader =new Scanner(System.in);
         String point= reader.nextLine();
         System.out.println("Enter space-separated function values: ");
         Scanner reader1 =new Scanner(System.in);
         String value= reader1.nextLine();

         String[] point_string=point.split(" ");
         points=new double[point_string.length];
         for(int i=0;i< point_string.length;i++){
             points[i]=Double.parseDouble(point_string[i]);
             //System.out.println(points[i]);
         }


         String[] value_string=value.split(" ");
         val_func=new double[value_string.length];
         for(int i=0;i< value_string.length;i++){
             val_func[i]=Double.parseDouble(value_string[i]);
             //System.out.println(val_func[i]);
         }*/
         xException(points);
         checkDimensions(points, val_func);
         Polynom larg= new Polynom(new double[]{0});
         for (int k=1;k<points.length;k++){
             larg=Polynom.sum(Polynom.mult_dig(l_k(points)[k],val_func[k]),larg);
         }return larg;
     }
     public static double Value_Larg(double x,double[] points, double[] val_func){
         double sum_pol=0;

         for(int i=0; i< points.length;i++){
            double mult_l_k=1;
            for(int j=0;j<points.length;j++){
                if(i!=j){

                   mult_l_k*=((x-points[j])/(points[i]-points[j]));
                }

            }
            sum_pol+=mult_l_k*val_func[i];

        } return sum_pol;
     }
     public static void xException(double[] points){
        for(int i=0;i< points.length;i++){
            for(int j=0;j<points.length;j++){
               if(i!=j && points[i]==points[j]) throw new Wrong_x_excep();
            }
        }
     }
     public static void checkDimensions(double[] points,double[] val_func){
        if(points.length!= val_func.length)
            throw new WrongLengthException();
     }

}

