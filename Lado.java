public class Lado {
    private Punto extremo1;
    private Punto extremo2;
    private String nombre;

    public Lado(Punto extremo1, Punto extremo2, String nombre) {
	this.extremo1 = extremo1;
	this.extremo2 = extremo2;
	this.nombre = nombre;
    }

    public Lado(Lado otroLado){
        this.extremo1 = new Punto(otroLado.extremo1);
        this.extremo2 = new Punto(otroLado.extremo2);
        this.nombre = otroLado.nombre;
    }

    public String obtenerNombre(){
        return nombre;
    }

    public Punto obtenerExtremo1(){
        return extremo1;
    }

    public Punto obtenerExtremo2(){
        return extremo2;
    }

    public void asignarNombre(String nuevoNombre){
        nombre = nuevoNombre;
    }

    public void asignarExtremo1(Punto nuevoExtremo1){
        extremo1 = nuevoExtremo1;
    }

    public void asignarExtremo2(Punto nuevoExtremo2){
        extremo2 = nuevoExtremo2;
    }

    public String toString() {
        return "Lado: " + nombre + " [" + extremo1 + " - " + extremo2 + "]";
    }

    public boolean equals(Lado l){
        boolean igual = true;
        igual = igual && (this.extremo1.equals(l.extremo1) ? true : false);
        igual = igual && (this.extremo2.equals(l.extremo2) ? true : false);
        igual = igual && (this.nombre.equals(l.nombre) ? true : false);
        return igual;
    }

   public boolean seInterseca(Lado otroLado) {
	Recta r1 = new Recta(this);
	Recta r2 = new Recta(otroLado);

	Punto interseccion = r1.interseccion(r2);

    if(r1.obtenerA() * r2.obtenerB() !=  r2.obtenerA() * r1.obtenerB()){
        return true;
        //System.out.println(r1.interseccion(r2));
    } else{
        return false;
    }
    
    
    
    


}
public Punto interseccionPunto(Lado otroLado){
    Recta r3 = new Recta(this);
	Recta r4 = new Recta(otroLado);

	Punto interseccion = r3.interseccion(r4);
    return interseccion;


}
}
