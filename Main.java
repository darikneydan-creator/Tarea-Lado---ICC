public class Main {
    public static void main(String[] pps) {
	Punto p1,p3,p4;
	p1 = new Punto(-5,4.5);
	Punto p2 = new Punto(-4,3.5);
	p3= new Punto(-4,4.5);
	p4 = new Punto (-5,3.5);
	//System.out.println(p1.toString());
	//System.out.println(p1.distancia(new Punto(2,0)));
	//System.out.println(p1.equals(new Punto(2,5)));
	Lado lado = new Lado(p1,p2,"Omana");
	Lado lado2 = new Lado(p3,p4, "Darik");
	
	System.out.println(lado.equals(lado2));
	System.out.println("Las rectas se intersecan: "+lado.seInterseca(lado2));
	System.out.println("El punto de interseccion de las rectas es"+lado.interseccionPunto(lado2));

    }
}
