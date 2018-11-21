package servicios;

import animales.Animal;
import animales.Cerdo;
import animales.Gallina;
import animales.Vaca;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class EstacionDeServicioTest {

    //  Para cada estación de servicio, pasar de 3 dispositivos a una cantidad indeterminada de dispositivos,

    //      y agregar estos requerimientos:
    //  saber cuáles de los dispositivos de una estación que necesitan recarga.
    //  obtener para una estación, el último animal atendido en cada dispositivo
    // (se espera un conjunto de animales como respuesta).


    @Test
    public void testEstacionDeServicioConCantidadIlimitadaDeServicios() {

        Bebedero bebedero = new Bebedero(1);
        Bebedero bebederoo = new Bebedero(2);
        Vacunatorio vacunatorio = new Vacunatorio(2, 20);
        Vacunatorio vacunatorioo = new Vacunatorio(3, 20);

        Collection<Servicio> servicios = new ArrayList<>();
        servicios.add(bebedero);
        servicios.add(bebederoo);
        servicios.add(vacunatorio);
        servicios.add(vacunatorioo);

        EstacionDeServicio estacionDeServicio = new EstacionDeServicio(servicios);

        Animal cerdo = new Cerdo(50);
        Animal vaca = new Vaca(30);

        System.out.println(estacionDeServicio.puedeAtender(cerdo));
        System.out.println(bebedero.puedeAtender(cerdo)); // Que hace al castear?. Por qué?

        vacunatorio.atenderAnimal(cerdo);
        Assert.assertEquals(4, servicios.size(), 0.1);
    }

    @Test
    public void testDispositivosQueNecesitanRecarga(){

        Vacunatorio vacunatorio = new Vacunatorio(1, 1);
        ComederoNormal comederoNormal = new ComederoNormal(1, 1, 60, 10);
        Bebedero bebedero = new Bebedero(1);

        EstacionDeServicio estacionDeServicio = new EstacionDeServicio(vacunatorio, comederoNormal, bebedero);

        Animal cerdo = new Cerdo(50);
        Animal vaca = new Vaca(30);

        vacunatorio.atenderAnimal(vaca);
        comederoNormal.atenderAnimal(cerdo); // Atender animal no aparece en las opciones visibles.

        System.out.println(estacionDeServicio.necesitaRecargar());
        System.out.println(estacionDeServicio.getNecesitanRecarga());

        Assert.assertEquals(2, estacionDeServicio.getNecesitanRecarga().size());
    }

    @Test
    public void testUltimoAnimalAtendidoPorDispositivo(){
//  obtener para una estación,
//      el último animal atendido en cada dispositivo
//      (se espera un conjunto de animales como respuesta).

        Vacunatorio vacunatorio = new Vacunatorio(1, 1);
        ControladorServicio controladorVacunatorio = new ControladorServicio();

        ComederoNormal comederoNormal = new ComederoNormal(1, 1, 60, 10);

        Bebedero bebedero = new Bebedero(1);

        ComederoInteligente comederoInteligente= new ComederoInteligente(1, 20, 60);

        Collection<Servicio> servicios = new ArrayList<>();
        servicios.add(vacunatorio);
        servicios.add(comederoNormal);
        servicios.add(comederoInteligente);
        servicios.add(bebedero);

        EstacionDeServicio estacionDeServicio = new EstacionDeServicio(servicios);


        Cerdo cerdo = new Cerdo(50);
        Vaca vaca = new Vaca(30);
        Gallina gallina = new Gallina ();


        vacunatorio.atenderAnimal(vaca);
        controladorVacunatorio.informarAtencion(vaca);

        comederoNormal.atenderAnimal(cerdo); // Atender animal no aparece en las opciones visibles.

        comederoInteligente.atenderAnimal(gallina);

        System.out.println(estacionDeServicio.ultimosAnimalesAtendidos());
        Assert.assertEquals(3, estacionDeServicio.ultimosAnimalesAtendidos().size());
    }

}
