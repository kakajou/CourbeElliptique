
import java.math.BigInteger;




public class Point {
    
     int x;
     int y;
     CourbeElliptique courbe;

    public Point(int x, int y, CourbeElliptique courbe) {
        this.x = x;
        this.y = y;
        this.courbe = courbe;
    }
    
    public Point inverse() {
        
        return null;
    }
    
    public Point add(Point p){
        
        if(this.x==0 && this.y==0) return p;
        if(p.x==0 && p.y==0) return this;
        
        int lambda = 0;
        
        if(p.x==this.x){
            if(p.y==-this.y) return new Point(0, 0, courbe);// infini
            else if(p.y==this.y)
                    lambda = (3*(int)Math.pow(p.x, 2)+courbe.a ) * BigInteger.valueOf(2*p.y).modInverse(BigInteger.valueOf(courbe.p)).intValue();                             
        }else{
                    lambda = (this.y-p.y) * BigInteger.valueOf(this.x-p.x).modInverse(BigInteger.valueOf(courbe.p)).intValue();
        }
        
        int x3 = BigInteger.valueOf(((int)Math.pow(lambda, 2) - p.x - this.x)).mod(BigInteger.valueOf(courbe.p)).intValue();                
        int y3 = BigInteger.valueOf((lambda * (p.x - x3) - p.y)).mod(BigInteger.valueOf(courbe.p)).intValue() ;
        return new Point(x3, y3, courbe);        
        
    }

    
    public Point multiply (int k) {
        
        Point res = this;
        for (int i = 1; i < k; i++) {
            res = res.add(this);
        }
        return res;
    }
    
    
    public Point[] cheffrer (int k, Point b, Point p){
        Point[] tab = new Point[2];
        Point c1 = p.multiply(k);
        Point c2 = this.add(b.multiply(k));
        tab[0] =c1;
        tab[1] =c2;
        return tab;
    }
    
    public Point decheffrer (int s, Point[] tab){
        //c[0].x*=-1;c[0].y*=-1;
        int ss = -s;
        while (ss<0) ss+=courbe.p;
        Point m = tab[1].add(tab[0].multiply(ss));
        return m;
    }
    
    @Override
    public String toString() {
        return "Point("+x+","+y+")";
    }
    
    
    
}
