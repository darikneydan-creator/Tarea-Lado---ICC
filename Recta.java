public class Recta {
    double a, b, c; // coeficientes de la recta: ax + by + c = 0
    Punto extremo1;
    Punto extremo2;

    public Recta(Lado segmento) {
	// ax + by + c = 0
	a = segmento.obtenerExtremo1().obtenerX() - segmento.obtenerExtremo2().obtenerX();
	b = segmento.obtenerExtremo1().obtenerY() - segmento.obtenerExtremo2().obtenerY();
	c = segmento.obtenerExtremo1().obtenerX()*segmento.obtenerExtremo2().obtenerY()
	    - segmento.obtenerExtremo2().obtenerX()*segmento.obtenerExtremo1().obtenerY();
        this.extremo1 = segmento.obtenerExtremo1();
        this.extremo2 = segmento.obtenerExtremo1();
    }
    public double obtenerA(){
        return a;
    }
    public double obtenerB(){
        return b;
    }


    @Override
    public String toString() {
	return "Recta: " + a + "x + " + b + "y + " + c + " = 0";
    }

    public Punto interseccion(Recta r) {
        double a1 = r.a, b1 = r.b, c1 = r.c; // Ecuación para r1
        double a2 = this.a, b2 = this.b, c2 = this.c; // Ecuación para r2

        double D = a1 * b2 - a2 * b1; // Determinante

        if (Math.abs(D) < 1e-9) {
            // Paralelas o coincidentes
            return null;
        }

        double y = (b1 * (-c2) - b2 * (-c1)) / D;
        double x = (a2 * (-c1) - a1 * (-c2)) / D;

        return new Punto(-1*x,y);
    }
 
    

    
}
