package servicios;

import animales.Animal;

public class Bebedero extends Servicio {

    private int cantidadAnimalesAtendidos = 0;


//  Bebederos:

// Dan de beber a un animal,

// pueden realizarAccion a los animales con sed.

// Un bebedero necesita recarga cada 20 animales que atiende,

// lo que se le hace al recargarlo no se registra en el sistema

// (que se lo recarga para volver a contar desde ahi 20 animales atendidos).


    private int numeroDeBebedero;


    public Bebedero(int numeroDeBebedero) {
        this.numeroDeBebedero = numeroDeBebedero;
    }

    public boolean puedeAtender(Animal animal){
        return animal.tieneSed();
    }

    @Override
    public boolean necesitaRecargar() {
        return cantidadAnimalesAtendidos>=20;
    }

    @Override
    public void recargarServicio() {
        if (necesitaRecargar()) {
            cantidadAnimalesAtendidos = 0;
        }
    }

    @Override
    protected void realizarAccion(Animal animal) {
        animal.bebe();
        cantidadAnimalesAtendidos++;
    }
}
