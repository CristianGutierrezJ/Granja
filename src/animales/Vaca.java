package animales;

public class Vaca implements Animal {

    /*
      animales.Vaca
 . Cuando come aumenta el peso en lo que comió / 3 y le da sed.
 . Cuando bebe se le va la sed y pierde 500 g de peso.
 . Conviene vacunarla una vez, o sea, si no se la vacunó conviene vacunarla,
y si ya se la vacunó no conviene volverla a vacunar.
 . Tiene hambre si pesa menos de 200 kg.
 . Cada tanto se la lleva a caminar, en cada caminata pierde 3 kg..

     */

    private double peso;
    private boolean sed;
    private boolean necesutaVacuna = true;


    //Constructor


    public Vaca(double peso) {
        this.peso = peso;
    }

    //Set
    public void setPeso(double peso) {
        this.peso = peso;
    }

    //Get
    public double getPeso() {
        return peso;
    }

    //Acciones
    public void comer (double kilosDeComida) {
        System.out.println("Comiendo...");
        this.peso = this.peso + kilosDeComida / 3;
        this.sed = true;
    }

    public void bebe() {
        System.out.println("Bebiendo...");
        this.sed = false;
        this.peso = this.peso - 0.5;
    }

    public boolean necesitaVacuna(){
        return necesutaVacuna;
    }

    public void vacunarAnimal() {
        if (necesutaVacuna) {
            System.out.println("Vacunando...");
            this.necesutaVacuna = false;
        } else {
            System.out.println(" - La vaca ya estaba vacunada");
        }
    }

    public void caminar() {
        System.out.println("Caminando...");
        this.peso = this.peso - 3;
    }

    public boolean tieneSed(){
        return sed;
    }

    public boolean tieneHambre() {
        return this.peso < 200;
    }

    @Override
    public String toString() {
        return "animales.Vaca{" +
                "peso=" + peso +
                ", sed=" + sed +
                ", necesutaVacuna=" + necesutaVacuna +
                '}';
    }

    /*
    public void informarEstado() {

        System.out.println("..Peso: " + getPeso() + " kg.");
        System.out.println("..Tiene sed? " + tieneSed());
        System.out.println("..Está vacunado? " + necesitaVacuna());
        System.out.println("..Tiene hambre? " + tieneHambre());
    }
    */
}
