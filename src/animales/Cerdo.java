package animales;

public class Cerdo implements Animal {


    private double peso;
    private boolean sed;
    private double kilosDeComida;
    private double mayorCantidadDeComida = 0;
    private int contadorDeComidas = 0;
    private boolean hambre;

    public double getPeso() {
        return peso;
    }

    public boolean necesitaVacuna() {
        return true;
    }

    public boolean tieneSed() {
        return sed;
    }

    public Cerdo(double peso) {
        this.peso = peso;
    }

    /*
          animales.Cerdo
    .  Cuando come aumenta el peso en lo que comió – 200 g (si come menos de 200 g no aumenta nada);
     si come más de 1 kg se le va el hambre, si no no.
    .  Quiero saber, para cada cerdo, cuánto comió la vez que más comió.
    .  Siempre conviene vacunarlo.
    .  Cuando bebe se le va la sed, y le da hambre.
    .  Si come más de tres veces sin beber le da sed.
    */

    public void comer(double kilosDeComida) {
        this.kilosDeComida = kilosDeComida;

        if (kilosDeComida > 0.2) {
            this.peso = this.peso + this.kilosDeComida - 0.2;

        }
        contadorDeComidas++;

        calcularMayorCantidadDeComida();

        if (contadorDeComidas > 3 && !sed) {
            this.sed = true;
            contadorDeComidas = 0;
        }
    }

    public boolean tieneHambre() {
        return this.kilosDeComida < 1;
    }

    private void calcularMayorCantidadDeComida() {
        if (kilosDeComida > mayorCantidadDeComida) {
            mayorCantidadDeComida = kilosDeComida;
        }
    }

    public double getMayorCantidadDeComida() {
        return mayorCantidadDeComida;
    }

    public void vacunarAnimal() {

    }

    public void bebe() {
        this.sed = false;
        this.hambre = true;
    }

    @Override
    public String toString() {
        return "animales.Cerdo{" +
                "peso=" + peso +
                ", vacuna=" + necesitaVacuna() +
                ", sed=" + sed +
                '}';
    }
}
