package servicios;

import animales.Animal;

import java.util.Collection;
import java.util.HashSet;

public class ControladorServicio {

    private Collection <Animal> animalesAtendidos = new HashSet<>();
    private Animal ultimoAnimalAtendido;

    public void informarAtencion(Animal animal) {
        animalesAtendidos.add(animal);
        ultimoAnimalAtendido = animal;
    }

    public boolean fueAtendido(Animal animal) {
        return animalesAtendidos.contains(animal);
    }

    public int cantidadDeAnimalesAtendidos(){
        return animalesAtendidos.size();
    }

    public Collection <Animal> animalesAVacunar(){
        Collection <Animal> animalesAVacunar = new HashSet<>();

        for (Animal animalAtendido : animalesAtendidos) {
            if(animalAtendido.necesitaVacuna()){
                animalesAVacunar.add(animalAtendido);
            }
        }

        return animalesAVacunar;
    }

    public Animal animalQueMasPesa(){

        Animal animalQueMasPesa = null;

        for (Animal animalAtendido : animalesAtendidos) {
            if (animalQueMasPesa == null || animalAtendido.getPeso() > animalQueMasPesa.getPeso()) {
                animalQueMasPesa = animalAtendido;
            }
        }

        return animalQueMasPesa;
    }

    public double pesoTotalAnimalesAtendidos(){
        double pesoTotal=0;

        for (Animal animalAtendido : animalesAtendidos) {
            pesoTotal = pesoTotal + animalAtendido.getPeso();
        }

        return pesoTotal;
    }

    public Collection<Animal> getAnimalesAtendidos() {
        return animalesAtendidos;
    }

    public Animal ultimoAnimalAtendido(){
        return ultimoAnimalAtendido;
    }

}
