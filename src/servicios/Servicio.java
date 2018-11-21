package servicios;

import animales.Animal;

import java.util.Collection;

public abstract class Servicio {

    private ControladorServicio controladorServicio = new ControladorServicio();

    public abstract boolean puedeAtender(Animal animal);

    public abstract boolean necesitaRecargar();

    public abstract void recargarServicio();

    public void atenderAnimal(Animal animal){
        if(this.puedeAtender(animal)){
            realizarAccion(animal);
            controladorServicio.informarAtencion(animal);
        }
    }

    protected abstract void realizarAccion(Animal animal);

    public void reAtenderTodos(){
        for (Animal animal : controladorServicio.getAnimalesAtendidos()){
            atenderAnimal(animal);
        }
    }

    public Collection<Animal> getAnimalesAtendidos (){
        return controladorServicio.getAnimalesAtendidos();
    }

    public Animal ultimoAnimalAtendido(){
        return controladorServicio.ultimoAnimalAtendido();
    }

    public boolean fueAtendido(Animal animal) {
        return controladorServicio.fueAtendido(animal);
    }



}