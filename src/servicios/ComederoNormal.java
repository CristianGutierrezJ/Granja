package servicios;

import animales.Animal;

public class ComederoNormal extends Servicio {

    //

    //Comederos normales:

    //Cada comedero da de comer una cantidad fija que varía para cada comedero,

    //puede realizarAccion a los animales con hambre que pesen menos de lo que soporta el comedero, que también es un valor que depende del comedero.

    //Un comedero normal necesita recarga si le quedan menos de 10 raciones,

    //cuando se lo recarga se le cargan 30 raciones.

    // Voy a suponer que cada ración de comida posee 10 kg de alimento.

    private int numeroDeComedero;
    private int racionesDeComida;
    private double pesoMaximo;
    private double kilosdeComidaXRacion;
    private double kilosDeComidaComedero = racionesDeComida * kilosdeComidaXRacion;


    public double getKilosdeComidaXRacion() {
        return kilosdeComidaXRacion;
    }

    public void setKilosdeComidaXRacion(double kilosdeComidaXRacion) {
        this.kilosdeComidaXRacion = kilosdeComidaXRacion;
    }

    public double getKilosDeComidaComedero() {
        return kilosDeComidaComedero;
    }

    public void setKilosDeComidaComedero(double kilosDeComidaComedero) {
        this.kilosDeComidaComedero = kilosDeComidaComedero;
    }

    public ComederoNormal(int numeroDeComedero, int racionesDeComida, double pesoMaximo, double kilosdeComidaXRacion) {
        this.numeroDeComedero = numeroDeComedero;
        this.racionesDeComida = racionesDeComida;
        this.pesoMaximo = pesoMaximo;
        this.kilosdeComidaXRacion = kilosdeComidaXRacion;
    }

    public boolean puedeAtender(Animal animal){
        return  animal.tieneHambre() && (animal.getPeso() < pesoMaximo);
    }

    @Override
    public boolean necesitaRecargar() {
        return racionesDeComida < 10;
    }

    @Override
    public void recargarServicio() {
        if(necesitaRecargar()){
            racionesDeComida = racionesDeComida + 30;
        }
    }

    @Override
    protected void realizarAccion(Animal animal) {
        this.descargarComedero(animal);
        animal.comer(kilosdeComidaXRacion);
    }

    private void descargarComedero(Animal animal){
        this.racionesDeComida = this.racionesDeComida-1;
    }


}
