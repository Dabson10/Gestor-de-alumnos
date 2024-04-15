package Funcionalidad;

import Dominio.AlumnosDatos;
import Dominio.AlumnosID;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicioAlumnosLista implements IServicioAlumnos{
    private final List<AlumnosDatos> lista;
    static Scanner teclado = new Scanner(System.in);


    public ServicioAlumnosLista(){
        this.lista =new ArrayList<>();
    }
    @Override
    public void listarAlumnos() {
        System.out.println("Lista de alumnos y sus promedios");
        lista.forEach(System.out::println);
    }

    @Override
    public void agregarAlumnos(AlumnosDatos objAlumnos) {
        lista.add(objAlumnos);
        System.out.println("Se agrego el alumno y sus calificaciones");
        System.out.println();
    }

    @Override
    public void buscarAlumnos(AlumnosDatos objAlumnos) {
        int indice=lista.indexOf(objAlumnos);
        if(indice==-1){
            System.out.println("No se encontro el ID ni el nombre del alumno");
        }else{
            System.out.println("Se encontro el ID y el nombre del alumno en el indice: "+indice);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AlumnosID idobj =new AlumnosID(0);
        int num = idobj.getId();
        String numAle =String.valueOf(num);
        AlumnosDatos obj1 =new AlumnosDatos(num,numAle,"Juan D","9","6","8");

        IServicioAlumnos objllamada = new ServicioAlumnosLista();
        objllamada.agregarAlumnos(obj1);
        objllamada.listarAlumnos();
    }

}
