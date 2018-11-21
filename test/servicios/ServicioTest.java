package servicios;

import animales.Animal;
import animales.Cerdo;
import animales.Vaca;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;

public class ServicioTest {

    private Servicio bebedero;
    private Servicio vacunatorio;

    @Test
    public void testAnimalesAtendidosEnDosDispositivos(){
        //el conjunto de animales que fue atendido en los dos
        bebedero = new Bebedero(1);
        vacunatorio = new Vacunatorio(1, 20);

        Animal cerdo = new Cerdo(40);
        Animal vaca = new Vaca(30);

        cerdo.comer(1); // Con estas acciones, le doy sed al cerdo.
        cerdo.comer(1);
        cerdo.comer(1);
        cerdo.comer(1);

        bebedero.atenderAnimal(cerdo);
        vacunatorio.atenderAnimal(vaca);

        Collection<Animal> animales = new HashSet<>();
        animales.addAll(bebedero.getAnimalesAtendidos());
        animales.addAll(vacunatorio.getAnimalesAtendidos());

        Assert.assertEquals(2, animales.size(), 0.1);
    }

    @Test
    public void testAnimalesAtendidosEnUnDispositivoYEnelOtroNo(){
        //el conjunto de animales que fue atendido en uno sí y en el otro no
        bebedero = new Bebedero(1);
        vacunatorio = new Vacunatorio(2, 20);

        Collection<Animal> animales = new HashSet<>();

        Animal cerdo = new Cerdo(40);
        Animal vaca = new Vaca(30);

        animales.add(cerdo);
        animales.add(vaca);

        cerdo.comer(1);
        cerdo.comer(1);
        cerdo.comer(1);
        cerdo.comer(1);
        vaca.comer(1);

        bebedero.atenderAnimal(cerdo);     // bebedero .....1 animal Atendido (cerdo)......1 Sin Atender (vaca)
        vacunatorio.atenderAnimal(cerdo);
        vacunatorio.atenderAnimal(vaca);      // vacunatorio .....2 animales Atendidos......

        Collection<Animal> animalesAtendidosBebedero = new HashSet<>();
        animalesAtendidosBebedero.addAll(bebedero.getAnimalesAtendidos());

        Collection<Animal> animalesAtendidosVacunatorio = new HashSet<>();
        animalesAtendidosVacunatorio.addAll(vacunatorio.getAnimalesAtendidos());

        // Tengo una lista (animales) en la que guardo todos los animales creados
        // y otra lista (animalesAtendidos) en la que guardo los atendidos por el servicio 1
        // necesito mostrar los que NO atendio el servicio 2

        animalesAtendidosVacunatorio.removeAll(animalesAtendidosBebedero);
        System.out.println(animalesAtendidosVacunatorio);

        Assert.assertEquals(1, animalesAtendidosVacunatorio.size(), 0.1);
    }

    @Test
    public void testAnimalesMasPesadosDeDistintosDispositivos(){

        // Cómo harías, desde un test en el que se conoce a un conjunto de dispositivos,

        // para obtener el conjunto con el animal más pesado de cada dispositivo.

        bebedero = new Bebedero(1);
        vacunatorio = new Vacunatorio(2, 20);

        ControladorServicio controladorBebedero = new ControladorServicio();
        ControladorServicio controladorVacunatorio = new ControladorServicio();

        Animal cerdo = new Cerdo(50);
        Animal vaca = new Vaca(30);

        cerdo.comer(1);
        cerdo.comer(1);
        cerdo.comer(1);
        cerdo.comer(1);
        vaca.comer(1);

        bebedero.atenderAnimal(cerdo);     // bebedero .....1 animal Atendido (cerdo)......1 Sin Atender (vaca)
        vacunatorio.atenderAnimal(cerdo);
        vacunatorio.atenderAnimal(vaca);      // vacunatorio .....2 animales Atendidos......

        controladorBebedero.informarAtencion(cerdo);
        //controladorVacunatorio.informarAtencion(cerdo);
        controladorVacunatorio.informarAtencion(vaca);

        Collection<Animal> animalesPesados = new HashSet<>();

        animalesPesados.add(controladorBebedero.animalQueMasPesa());
        animalesPesados.add(controladorVacunatorio.animalQueMasPesa());

        System.out.println(animalesPesados);
        Assert.assertEquals(2, animalesPesados.size());

    }


}
