package animales;

public class Gallina implements Animal {

    /*
       animales.Gallina
    Cuando come no se observa ningún cambio, siempre pesa 4 kg.
    Siempre tiene hambre, nunca tiene sed, nunca conviene vacunarla.
    Quiero saber, para una gallina, cuántas veces fue a comer.
    Como se ve, importa cuánto come un animal cuando come (excepto para las gallinas), pero no cuánto bebe cuando bebe.
   */

    private int contComer=0;

    public double getPeso() {
        return 4;
    }

    public boolean tieneHambre() {
        return true;
    }

    public void comer (double kilosDeComida) {
        contComer++;
    }

    public int vecesQueComio() {
        return contComer;
    }

    public boolean tieneSed(){
        return false;
    }

    public void bebe(){

    }

    public boolean necesitaVacuna(){
        return false;
    }

    public void vacunarAnimal(){

    }

    @Override
    public String toString() {
        return "animales.Gallina{" +
                "peso=" + getPeso() +
                ", tieneHambre=" + tieneHambre() +
                ", vecesQueComio=" + vecesQueComio() +
                '}';
    }

}
