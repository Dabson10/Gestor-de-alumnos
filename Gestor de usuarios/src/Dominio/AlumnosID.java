package Dominio;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class AlumnosID {
    protected int id;

    public AlumnosID(int id){


        Set<Integer> numAle =new HashSet<>();
        Random rdm =new Random();

        int cantidadNumeros = 1;
        while (numAle.size()<cantidadNumeros){
            int numero =rdm.nextInt(1000);
            numAle.add(numero);
        }
        this.id=numAle.iterator().next();
        /*this.id=(int)(Math.random()*200+1);
        Si regresa un numero aleatorio.*/
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID alumno "+id;
    }

    public static void main(String[] args) {
        AlumnosID obj1 =new AlumnosID(3);
        int num1 =obj1.getId();
        System.out.println(obj1);
    }


}
