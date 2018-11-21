package servicios;

import animales.Animal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class EstacionDeServicio extends Servicio {

    private Collection<Servicio> servicios;
    private List<Servicio> necesitanRecarga = new ArrayList<>();
    private ControladorServicio controladorServicio = new ControladorServicio();



    public EstacionDeServicio(Servicio servicio1, Servicio servicio2, Servicio servicio3) {
        servicios = new ArrayList<>();
        servicios.add(servicio1);
        servicios.add(servicio2);
        servicios.add(servicio3);
    }

    public EstacionDeServicio(Collection<Servicio> servicios) {
        this.servicios = servicios;
    }



    public List<Servicio> getNecesitanRecarga() {
        return necesitanRecarga;
    }

    @Override
    public boolean puedeAtender(Animal animal) {
        boolean respuesta = false;
        for(Servicio servicio : servicios){
            if (servicio.puedeAtender(animal)){
                respuesta = true;
            }
        }
        return respuesta;
    }

    @Override
    public void recargarServicio() {

    }

    @Override
    public boolean necesitaRecargar() {
        boolean necesitoRecargar = false;

        for (Servicio servicioDisponible : servicios) {
            if (servicioDisponible.necesitaRecargar()) {
                necesitoRecargar = true;
                necesitanRecarga.add(servicioDisponible);
            }
        }
        return necesitoRecargar;
    }



    @Override
    protected void realizarAccion(Animal animal) {
        List<Servicio> serviciosDisponibles = new ArrayList<>();

        for (Servicio servicioDisponible : servicios) {
            if (servicioDisponible.puedeAtender(animal)) {
                serviciosDisponibles.add(servicioDisponible);
            }
        }

        if (!serviciosDisponibles.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(serviciosDisponibles.size());
            serviciosDisponibles.get(index).atenderAnimal(animal);
        }
    }

    public Collection<Animal> ultimosAnimalesAtendidos(){
        Collection<Animal> ultimosAnimalesAtendidos = new ArrayList<>();

        for(Servicio servicio : servicios) {
            if (servicio.ultimoAnimalAtendido() != null) {
                ultimosAnimalesAtendidos.add(servicio.ultimoAnimalAtendido());
            }
        }
        return ultimosAnimalesAtendidos;
    }
}
