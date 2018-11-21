package servicios;

import animales.Animal;

public class ComederoInteligente extends Servicio {

    //Comederos inteligentes:

    // le dan de comer a un animal su peso / 100.

    //Pueden realizarAccion a cualquier animal con hambre.

    //Un comedero inteligente necesita recarga si le quedan menos de 15 kg,

    //al recargarlo se lo lleva hasta su capacidad máxima (que se indica para cada comedero).

    private int numeroDeComedero;
    private double kilosDeComida;
    private double kilosDeComidaMaximo;
    private double pesoMaximo;

    public ComederoInteligente(int numeroDeComedero, double kilosDeComida, double pesoMaximo) {
        this.numeroDeComedero = numeroDeComedero;
        this.kilosDeComida = kilosDeComida;
        this.kilosDeComidaMaximo = kilosDeComida;
        this.pesoMaximo = pesoMaximo;
    }

    // le dan de comer a un animal su peso / 100.
    private void descargarComedero(Animal animal) {
        this.kilosDeComida = animal.getPeso() / 100;
    }

    @Override
    public boolean puedeAtender(Animal animal) {
        return animal.tieneHambre();
    }

    @Override
    public boolean necesitaRecargar() {
        return kilosDeComida < 15;
    }

    @Override
    public void recargarServicio() {
        if (necesitaRecargar()){
            kilosDeComida = kilosDeComidaMaximo;
        }
    }

    @Override
    protected void realizarAccion(Animal animal) {
        descargarComedero(animal);
        animal.comer(animal.getPeso() / 100);
    }


}



