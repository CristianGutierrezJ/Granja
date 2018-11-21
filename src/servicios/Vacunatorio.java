package servicios;

import animales.Animal;

public class Vacunatorio extends Servicio {


//      servicios.Vacunatorio:

//  Vacunan a un animal,

//  Pueden realizarAccion a los animales que conviene vacunar.

//  Un vacunatorio necesita recarga si se queda sin vacunas,

//  al atenderlo se le recargan 50 vacunas.

    private int numeroDeVacunatorio;
    private int cantidadDeVacunas;

    public Vacunatorio(int numeroDeVacunatorio, int cantidadDeVacunas) {
        this.numeroDeVacunatorio = numeroDeVacunatorio;
        this.cantidadDeVacunas = cantidadDeVacunas;
    }

    @Override
    public boolean puedeAtender(Animal animal){
        return animal.necesitaVacuna();
    }

    @Override
    public boolean necesitaRecargar() {
        return cantidadDeVacunas==0;
    }

    @Override
    public void recargarServicio() {
        if(necesitaRecargar()){
            cantidadDeVacunas=50;
        }
    }

    @Override
    protected void realizarAccion(Animal animal) {
        animal.vacunarAnimal();
        cantidadDeVacunas--;
    }


}
