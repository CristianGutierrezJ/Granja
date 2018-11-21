import animales.Cerdo;
import animales.Gallina;
import animales.Vaca;
import servicios.*;

public class Main {

    public static void main (String []args) {

        Vaca vaca = new Vaca(190);

        vaca.vacunarAnimal();

        System.out.println("La vaca está vacunada? ." + vaca.necesitaVacuna());
        System.out.println("Cuánto pesa? ." + vaca.getPeso());
        vaca.comer(40);
        System.out.println(vaca);
        System.out.println("La vaca tiene hambre?? " + vaca.tieneHambre());


        System.out.println();

        System.out.println(vaca);

        Gallina gallina = new Gallina ();
        System.out.println(gallina);


        Cerdo cerdo = new Cerdo (7);
        System.out.println(cerdo);


        ComederoNormal comederoNormal = new ComederoNormal(01, 20, 200, 4);

        System.out.println("...¿Comedero nornmal puede realizarAccion al cerdo?");
        System.out.println(comederoNormal.puedeAtender(cerdo));
        comederoNormal.atenderAnimal(cerdo);
        System.out.println(cerdo);


        ComederoInteligente comederoInteligente = new ComederoInteligente (2, 200, 200);
        EstacionDeServicio estacionDeServicio = new EstacionDeServicio
                (comederoInteligente
                , new Bebedero(1)
                , new Vacunatorio(1, 20));


        System.out.println("Puedo realizarAccion al cerdo?. -" + estacionDeServicio.puedeAtender(cerdo));
        estacionDeServicio.atenderAnimal(cerdo);
        System.out.println(cerdo);
        //System.out.println("Mayor cantidad de comida: " + cerdo.calcularMayorCantidadDeComida());

        System.out.println("Puedo realizarAccion al cerdo?. -" + estacionDeServicio.puedeAtender(cerdo));
        estacionDeServicio.atenderAnimal(cerdo);
        System.out.println(cerdo);
        cerdo.comer(200);
        //System.out.println("Mayor cantidad de comida: " + cerdo.calcularMayorCantidadDeComida());


    }

}
