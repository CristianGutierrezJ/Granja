package animales;

import animales.Vaca;
import org.junit.Assert;
import org.junit.Test;

public class VacaTest {

    @Test
    public void testAumentaPesoAlComer(){   // Aumenta el tercio de lo que comió
        Vaca vaca = new Vaca(50);
        vaca.comer(3);
        Assert.assertEquals(51, vaca.getPeso(), 0.1);
    }

    @Test
    public void testCuandoComeLeDaSed(){
        Vaca vaca = new Vaca(50);
        vaca.comer(3);
        Assert.assertTrue(vaca.tieneSed());
    }

    @Test
    public void testCuandoBebeDejaDeTenerSed(){
        Vaca vaca = new Vaca(50);
        vaca.bebe();
        Assert.assertFalse(vaca.tieneSed());
    }

    @Test
    public void testCuandoBebePiedeQuinientosGramos(){
        Vaca vaca = new Vaca(50);
        vaca.bebe();
        Assert.assertEquals(49.5, vaca.getPeso(), 0.1);
    }

    @Test
    public void testNecesitaVacuna(){
        Vaca vaca = new Vaca(50);
        Assert.assertTrue(vaca.necesitaVacuna());
    }

    @Test
    public void testNecesitaVacunaLuegoDeVacunarla(){
        Vaca vaca = new Vaca(50);
        vaca.vacunarAnimal();
        Assert.assertFalse(vaca.necesitaVacuna());
    }

    @Test
    public void testTieneHambreSiPesaMenosDeDoscientosKg(){
        Vaca vaca = new Vaca(50);
        Assert.assertTrue(vaca.tieneHambre());
    }

    @Test
    public void testTieneHambreSiPesaMasDeDoscientosKg(){
        Vaca vaca = new Vaca(250);
        Assert.assertFalse(vaca.tieneHambre());
    }

    @Test
    public void testCuandoCaminaPierdePeso(){ // -3kg
        Vaca vaca = new Vaca(250);
        vaca.caminar();
        Assert.assertEquals(247, vaca.getPeso(), 0.1);
    }

}
