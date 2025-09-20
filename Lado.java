
public class Lado {


    private Punto extremo1;   
    private Punto extremo2;  
    private String nombre;    


    
    public Lado(Punto extremo1, Punto extremo2, String nombre) {
        this.extremo1 = extremo1;
        this.extremo2 = extremo2;
        this.nombre = nombre;
    }

    public Lado(Lado otroLado) {
        this.extremo1 = new Punto(otroLado.extremo1); 
        this.extremo2 = new Punto(otroLado.extremo2);
        this.nombre = otroLado.nombre;
    }



    public String obtenerNombre() {
        return nombre;
    }

    public Punto obtenerExtremo1() {
        return extremo1;
    }

    public Punto obtenerExtremo2() {
        return extremo2;
    }



    public void asignarNombre(String nuevoNombre) {
        nombre = nuevoNombre;
    }

    public void asignarExtremo1(Punto nuevoExtremo1) {
        extremo1 = nuevoExtremo1;
    }

    public void asignarExtremo2(Punto nuevoExtremo2) {
        extremo2 = nuevoExtremo2;
    }


    @Override
    public String toString() {
        return "Lado: " + nombre + " [" + extremo1 + " - " + extremo2 + "]";
    }
    public boolean equals(Lado l) {
        boolean igual = true;
        igual = igual && (this.extremo1.equals(l.extremo1));
        igual = igual && (this.extremo2.equals(l.extremo2));
        igual = igual && (this.nombre.equals(l.nombre));
        return igual;
    }


    public boolean seInterseca(Lado otroLado) {
     
        Recta r1 = new Recta(this);
        Recta r2 = new Recta(otroLado);

  
        Punto interseccion = r1.interseccion(r2);
        /*Lo que hice fue cambiar los ifs originales que teniamos, ya que se repetia los mismos if muchas veces y era un proceso innecesario, ademas, 
        compacte mejor los casos para que fuesen menos ifs y por lo tanto menos lineas de codigo, ademas de declarar variables booleanas para guardar el valor
        de verdad de los ifs para despues, compararlas  y verificar si alguno de los casos es verdad, de queesta en el intervalo el punto de interseccion, y si todos los ifs dan verdadero
        , significa que las rectas se intersectan*/
    
     


        //COmprueba que la x de la interseccion este en el intervalo de los extremo de las x para el caso de la recta this
        boolean xEnRango1;
        if (this.extremo1.obtenerX() < this.extremo2.obtenerX()) {
            // Caso 1: extremo1.x es menor que extremo2.x
            xEnRango1 = (interseccion.obtenerX() >= this.extremo1.obtenerX() && interseccion.obtenerX() <= this.extremo2.obtenerX());//almacena el valor de verdad para despues compararla si se cumple en este caso
        } else {
            // Caso 2: extremo2.x es menor que extremo1.x
            xEnRango1 = (interseccion.obtenerX() >= this.extremo2.obtenerX() && interseccion.obtenerX() <= this.extremo1.obtenerX());//almacena el valor de verdad para despues compararla si se cumple en este caso
        }

        // Hacemos lo mismo para la coordenada Y.
        boolean yEnRango1;
        
        if (this.extremo1.obtenerY() < this.extremo2.obtenerY()) {
            // Caso 2: extremo1.y es menor que extremo2.y
            yEnRango1 = (interseccion.obtenerY() >= this.extremo1.obtenerY() && interseccion.obtenerY() <= this.extremo2.obtenerY());//almacena el valor de verdad para despues compararla si se cumple en este caso
        } else {
            // Caso 2: extremo2.y es menor que extremo1.y
            yEnRango1 = (interseccion.obtenerY() >= this.extremo2.obtenerY() && interseccion.obtenerY() <= this.extremo1.obtenerY());//almacena el valor de verdad para despues compararla si se cumple en este caso
        }

     
        // Repetimos exactamente el mismo proceso, pero con los datos de la recta otroLado.

        boolean xEnRango2;
        if (otroLado.extremo1.obtenerX() < otroLado.extremo2.obtenerX()) {
            // Caso 1: extremo1.x es menor que extremo2.x
            xEnRango2 = (interseccion.obtenerX() >= otroLado.extremo1.obtenerX() && interseccion.obtenerX() <= otroLado.extremo2.obtenerX());//almacena el valor de verdad para despues compararla si se cumple en este caso
        } else {
            // Caso 2: extremo2.x es menor que extremo1.x
            xEnRango2 = (interseccion.obtenerX() >= otroLado.extremo2.obtenerX() && interseccion.obtenerX() <= otroLado.extremo1.obtenerX()); //almacena el valor de verdad para despues compararla si se cumple en este caso
        }

        boolean yEnRango2;
            
        if (otroLado.extremo1.obtenerY() < otroLado.extremo2.obtenerY()) {
            //Caso1: extremo1.y es menor que extremo2.y
            yEnRango2 = (interseccion.obtenerY() >= otroLado.extremo1.obtenerY() && interseccion.obtenerY() <= otroLado.extremo2.obtenerY());//almacena el valor de verdad para despues compararla si se cumple en este caso
        } else {
            // Caso 2: extremo2.y es menor que extremo1.y
            yEnRango2 = (interseccion.obtenerY() >= otroLado.extremo2.obtenerY() && interseccion.obtenerY() <= otroLado.extremo1.obtenerY());//almacena el valor de verdad para despues compararla si se cumple en este caso
        }

        //Regresa el valor de verdad que tendra la comparacion de los 2 valores, si es verdad, se determina que las rectas son paralelas
        return xEnRango1 && yEnRango1 && xEnRango2 && yEnRango2;
    }
}



