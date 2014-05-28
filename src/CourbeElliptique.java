

public class CourbeElliptique {

     int a;
     int b;
     int p;

    public CourbeElliptique(int a, int b, int p) {
        this.a = a;
        this.b = b;
        this.p = p;
    }
    
    public String borneHasse () {
        
     String borneHasse="";
     int bi=(int)Math.pow(Math.sqrt(p)-1,2);
     int bs=(int)Math.pow(Math.sqrt(p)+1,2);
     borneHasse+=bi+" <= Ep <= "+bs;
     
     return borneHasse;             
    }

    @Override
    public String toString() {
        return "[CourbeElliptique("+a+","+b+","+p+")]";
    }
    
    
    
}
