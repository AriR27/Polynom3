import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

//сделать масштаб он зависит от н, сделаем чтрбы н менялось при колесике мышки
// +сделать рефреш
// + анимация рисовки по точкам
public class Coordinates extends JFrame {
    public static void main(String[] arg){
        new Coordinates();
    }
    Graphics g;
    double X;
    double Y;
    JPanel Panel = new JPanel();
    int n=20;
    public double Transformation_of_Coordinates_X(double screen_X, JPanel Panel){
       X= (screen_X-1.0*Panel.getHeight()/2)/n;
        System.out.println("Декартовы координаты: " + "\n" + "x: " + X +
                " ");
      return X;
    }
    public double Transformation_of_Coordinates_Y(double screen_Y,JPanel Panel){
        //Y= (-screen_Y + (Panel.getHeight()/2))/50;
        Y=(-screen_Y+1.0*Panel.getHeight()/2)/n;
        System.out.println("y: " + Y);
        return Y;
    }
 public void Draw_Coordinates(JPanel Panel){
     g.drawLine(0,Panel.getHeight()/2,Panel.getWidth(),Panel.getHeight()/2);
        g.drawLine(Panel.getWidth()/2,0,Panel.getWidth()/2,Panel.getHeight());
        int count =1;
        for(int i=Panel.getWidth()/2-n;i>0;i--){
            g.drawString("-"+count+"",i,Panel.getHeight()/2);
            count++;
            i-=n;
        }
        int count1 =0;
     for(int i=Panel.getHeight()/2;i>0;i--){
         g.drawString(count1+"",Panel.getWidth()/2,i);
         count1++;
         i-=n;
     }
     count =1;
     for(int i=Panel.getWidth()/2+n;i<Panel.getWidth();i++){
         g.drawString(count + "",i,Panel.getHeight()/2);
         count++;
         i+=n;
     }
     count1=1;
     for(int i=Panel.getHeight()/2+n;i<Panel.getHeight();i++){
         g.drawString("-"+count1+"",Panel.getWidth()/2,i);
         count1++;
         i+=n;
     }
 }
 public void drawPolymom(Polynom m){//нарисовать какой-нибудь полином, подружить его с оконым приложением
       //Polynom larg = Polynom.Coeff_Lagr();
      //g.drawPolyline(points, val_func, points.lenght);

    }

    public Coordinates(){
        super();
        this.setVisible(true);
        this.setDefaultCloseOperation(Coordinates.EXIT_ON_CLOSE);
        // this.setSize(800,600);
        this.setBounds(200,50,800,600);
        this.setResizable(true);
        this.setLayout(null);//делает вывод компонентов на экран в абсолютных координатах
        g= this.getGraphics();
        JButton button = new JButton();
        button.setText("Нарисовать координатные линии");
        button.setBounds(600,450,150,75);
        this.add(button);
        Panel.setSize(650,650);
        this.add(Panel);
        List<Double> point= new ArrayList<Double>();
        double[] points= new double[point.size()];
        for (int i = 0; i < points.length; i++) {
            points[i]=point.get(i);
            Transformation_of_Coordinates_X(points[i],Panel);
        }
        List<Double> values= new ArrayList<Double>();
        double[] val_faunc=new double[values.size()];
        for (int i = 0; i < val_faunc.length; i++) {
            val_faunc[i]=values.get(i);
            Transformation_of_Coordinates_Y(val_faunc[i],Panel);
        }
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {//нажали и отпустили
                System.out.println("Screen_X: " + e.getX());
                System.out.println("Screen_Y: " + e.getY());
                Transformation_of_Coordinates_X(e.getX(),Panel);
               Transformation_of_Coordinates_Y(e.getY(),Panel);
                point.add((double)e.getX());
                for (int i = 0; i < points.length; i++) {
                   System.out.println(points[i]);
//GH
                }
                values.add((double)e.getY());
                for (int i = 0; i < val_faunc.length; i++) {
                    System.out.println(val_faunc[i]+"---");

                }
                Polynom.Coeff_Lagr(points, val_faunc);

            }

            @Override
            public void mousePressed(MouseEvent e) {//нажали и можем вести

            }

            @Override
            public void mouseReleased(MouseEvent e) {//нажали

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



    }
    public void paint(Graphics g){
        super.paint(g);
        Draw_Coordinates(Panel);
        }
}
