public class Main {
    public static void main(String[] pps) {
	
	Punto p1 = new Punto(1, 1);
        Punto p2 = new Punto(4, 5);

        // Puntos para el Lado 2
        Punto p3 = new Punto(1, 2);
        Punto p4 = new Punto(5, 6);
	//System.out.println(p1.toString());
	//System.out.println(p1.distancia(new Punto(2,0)));
	//System.out.println(p1.equals(new Punto(2,5)));
	Lado lado = new Lado(p1,p2,"Omana");
	Lado lado2 = new Lado(p3,p4, "Darik");
	
	Recta recta1 = new Recta(lado);
	Recta recta2 = new  Recta(lado2);
	System.out.println(lado.equals(lado2));
	System.out.println("Las rectas se intersectan: "+lado.seInterseca(lado2));
	System.out.println("El punto de la interseccion es: " + recta1.interseccion(recta2));

	


    }
}
