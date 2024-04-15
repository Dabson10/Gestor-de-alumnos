package Presentacion;

import Dominio.AlumnosDatos;
import Dominio.AlumnosID;
import Funcionalidad.IServicioAlumnos;
import Funcionalidad.ServicioAlumnoArchivo;
import Funcionalidad.ServicioAlumnosLista;

import java.util.Scanner;

public class Menu {
    static Scanner teclado =new Scanner(System.in);
    public static void main(String[] args) {

        boolean salir =false ;
        IServicioAlumnos objAlumnos =new ServicioAlumnoArchivo();
        while(!salir){
            try{
                opciones();
                salir = accionMenu(objAlumnos);
            }catch(Exception e){
                System.out.println("Se encontro un error del tipo "+e.getMessage());
            }
        }
    }
    public static void opciones(){
        System.out.println("ESCUELA\n¿Que accion quieres realizar?");
        System.out.println("1.Agregar Alumnos y calificaciones.\n2.Listar Alumnos.\n3.Buscar Alumnos.\n4.Salir");

    }
    public static boolean accionMenu(IServicioAlumnos objAlumnos){

        boolean salir =false;

        var opcion =Integer.valueOf(teclado.nextLine());
        switch(opcion){
            case 1://Agrega un alumno
                System.out.println("Ingrese el nombre del alumno");
        String nombre=teclado.nextLine();
        System.out.println("Cuantas materias tienes por parcial");
        int mat =teclado.nextInt();
        int i =1;
        int vect1[] =new int[20];
        int vect2[] =new int[20];
        int vect3[] =new int[20];
        int sum1=0; int sum2=0; int sum3=0;
        for(i=1;i<=mat;i++){//Vector para el primer parcial
            System.out.println("Ingrese la calificacion de la materia "+i+", del primer parcial");
            vect1[i]=teclado.nextInt();
            sum1=sum1+vect1[i];
        }String prom1 =String.valueOf( sum1/mat);//Resultado del primer parcial

        for(i=1;i<=mat;i++){//Vector para el segundo parcial
            System.out.println("Ingrese la calificacion de la materia "+i+", del segundo parcial");
            vect2[i]=teclado.nextInt();
            sum2=sum2+vect2[i];
        }String prom2=String.valueOf( sum2/mat);//Resultado del segundo parcial
        for(i=1;i<=mat;i++){//Vector para el tercer parcial
            System.out.println("Ingrese la calificacion de la materia "+i+", del tercer parcial");
            vect3[i]=teclado.nextInt();
            sum3=sum3+vect1[i];
        }String prom3 =String.valueOf( sum3/mat);
        AlumnosID idobj =new AlumnosID(0);
        int num = idobj.getId();
        String numAle =String.valueOf(num);
        objAlumnos.agregarAlumnos(new AlumnosDatos(num,numAle,nombre,prom1,prom2,prom3));

                break;
            case 2://enlista los alumnos y sus promedios
                objAlumnos.listarAlumnos();
                break;
            case 3://Buscar alumnos
                System.out.println("Para buscar el usuario ingrese su ID y su nombre");
                System.out.println("ID del alumnos");
                String buscarID=teclado.nextLine();
                int numAleEnt =Integer.valueOf(buscarID);
                System.out.println("Ingrese el nombre del alumno");
                String buscarNombre=teclado.nextLine();
                objAlumnos.buscarAlumnos(new AlumnosDatos(numAleEnt,buscarID,buscarNombre,"","","" ));
                break;
            case 4://Salir del codigo
                System.out.println("Hasta luego");
                salir =true;
                break;
            default :
                System.out.println("Ingrese una opcion correcta ");
        }
        return salir;
    }


}
