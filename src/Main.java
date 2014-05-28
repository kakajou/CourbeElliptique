
import java.util.ArrayList;
import java.util.List;




public class Main {


    public static void main(String[] args) {

        CourbeElliptique courbe = new CourbeElliptique(1, 4, 13);
        System.out.println("Hasse : "+courbe.borneHasse());
        /*
        Point p1 = new Point(0, 2, courbe);
        Point p2 = new Point(2, 1, courbe);
        
        Point p3 = p1.add(p2);
        System.out.println(p1+" + "+p2+" = "+p3);
        
        /*Point generateur = new Point(0, 2, courbe);
        List<Point> listPoint = new ArrayList();
        listPoint.add(generateur);
        for (int i = 1; i < 13; i++) {
            int ii = i-2;if(ii<0) ii=0; 
            int is = i-1;if(is<0) is=0;
            Point pp1 = listPoint.get(ii);
            Point pp2 = listPoint.get(is);
            Point pp3 = pp1.add(pp2);
            listPoint.add(pp3);
        }        
        System.out.println(listPoint);*
        
        Point p4 = p1.multiply(2);
        System.out.println("2 * "+p1+" = "+p4);
        */
        
        Point p = new Point(0, 2, courbe);
        
        int ks = 5;
        
        Point b = p.multiply(ks);
        
        Point[] c = p.cheffrer(ks, b, p);
        Point m = p.decheffrer(ks, c);
        System.out.println(m);
        
    }
}
