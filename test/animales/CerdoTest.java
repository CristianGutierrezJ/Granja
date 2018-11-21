package animales;

import animales.Cerdo;
import org.junit.Assert;
import org.junit.Test;

public class CerdoTest {

    @Test
    public void testTieneHambreCuandoNoComio() {
        Cerdo cerdo = new Cerdo(40);
        Assert.assertTrue(cerdo.tieneHambre());
    }

    @Test
    public void testTieneHambreCuandoComioDosKilos() {
        Cerdo cerdo = new Cerdo(70);
        cerdo.comer(2);
        Assert.assertFalse(cerdo.tieneHambre());
    }

    @Test
    public void testTieneHambreCuandoMedioKilo() {
        Cerdo cerdo = new Cerdo(60);
        cerdo.comer(0.5);
        Assert.assertTrue(cerdo.tieneHambre());
    }

    @Test
    public void testMayorCantidadDeComida() {
        Cerdo cerdo = new Cerdo(60);
        cerdo.comer(0.5);
        cerdo.comer(3);
        Assert.assertEquals(3, cerdo.getMayorCantidadDeComida(), 0.1);
    }

    @Test
    public void testAumentaPesoSegunComioMenosDoscientosGramos() {
        Cerdo cerdo = new Cerdo(60);
        cerdo.comer(0.9);
        Assert.assertEquals(60.7, cerdo.getPeso(), 0.1);
    }

    @Test
    public void testNoAumentaPesoSiComeMenosDeDoscientosGramos() {
        Cerdo cerdo = new Cerdo(60);
        cerdo.comer(0.2);
        Assert.assertEquals(60, cerdo.getPeso(), 0.1);
    }

    @Test
    public void testConvieneVacunarlo() {
        Cerdo cerdo = new Cerdo(60);
        Assert.assertTrue(cerdo.necesitaVacuna());
    }

    @Test
    public void testBeberLeSacaLaSed() {
        Cerdo cerdo = new Cerdo(60);
        cerdo.bebe();
        Assert.assertFalse(cerdo.tieneSed());
    }

    @Test
    public void testBeberLeDaHambre() {
        Cerdo cerdo = new Cerdo(60);
        cerdo.bebe();
        Assert.assertTrue(cerdo.tieneHambre());
    }

    @Test
    public void testTieneSedSiComeMasDeTresVeces() {
        Cerdo cerdo = new Cerdo(60);
        cerdo.comer(0.5);
        cerdo.comer(3);
        cerdo.comer(2);
        cerdo.comer(2);

        Assert.assertTrue(cerdo.tieneSed());
    }


}
