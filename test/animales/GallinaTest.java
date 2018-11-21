package animales;

import animales.Gallina;
import org.junit.Assert;
import org.junit.Test;

public class GallinaTest {

    @Test
    public void testTieneHambre() {
        Gallina gallina = new Gallina();
        Assert.assertTrue(gallina.tieneHambre());
    }

    @Test
    public void testPeso(){
        Gallina gallina = new Gallina();
        Assert.assertEquals(4, gallina.getPeso(),0.1);
    }

    @Test
    public void testTieneSed(){
        Gallina gallina = new Gallina();
        Assert.assertFalse(gallina.tieneSed());
    }

    @Test
    public void testNecesitaVacuna(){
        Gallina gallina = new Gallina();
        Assert.assertFalse(gallina.necesitaVacuna());
    }

    @Test
    public void testVecesQueComio(){
        Gallina gallina = new Gallina();
        gallina.comer(11);
        gallina.comer(11);
        gallina.comer(11);
        Assert.assertEquals(3, gallina.vecesQueComio(), 0.1);
    }



}
