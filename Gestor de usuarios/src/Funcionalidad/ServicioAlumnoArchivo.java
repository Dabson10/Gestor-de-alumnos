package Funcionalidad;

import Dominio.AlumnosDatos;

import java.io.*;

public class ServicioAlumnoArchivo implements IServicioAlumnos{

    private static final String NOMBRE_ARCHIVO ="Alumnos y sus calificaciones";

    public ServicioAlumnoArchivo(){
        var archivo =new File(NOMBRE_ARCHIVO);
        try{
            if(archivo.exists()){
                System.out.println("El archivo ya existe!!!");
            }else{
                var salida =new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado con exito el archivo!!!");
            }
        }catch(Exception e){
            System.out.println("Se encontro un error del tipo: "+e.getMessage());
        }
    }//Contructor en donde se crea un archivo de texto

    @Override
    public void listarAlumnos() {
        //metodo que enlista a los alumnos y su promedios
        var archivoEnt =new File(NOMBRE_ARCHIVO);
        try{
            System.out.println("Listado de alumnos y sus promedios");
            var entrada = new BufferedReader(new FileReader(archivoEnt));
            String linea;
            linea = entrada.readLine();
            while (linea!= null){
                String partes [] = linea.split(",");
                if(partes.length >= 3){
                    int id =Integer.valueOf(partes[0].trim());
                    String idAlumno =partes[1].trim();
                    String nombre =partes[2].trim();
                    String parcial1 = partes[3].trim();
                    String parcial2 =partes[4].trim();
                    String parcial3 =partes[5].trim();
                    var objAlumnos =new AlumnosDatos(id,idAlumno,nombre,parcial1,parcial2,parcial3);
                    System.out.println(objAlumnos);
                    /*int id,String idAlumno,String nombre,String parcial1,String parcial2,String parcial3*/
                }else{
                    System.out.println(linea);
                }
                //Antes de cerrar el ciclo se lee la siguiente linea
                linea =entrada.readLine();
            }//Fin del bucle
            //Se tiene que cerrar el archivo
            entrada.close();
        }catch(Exception e){
            System.out.println("Se encontro un error del tipo: "+e.getMessage());
            //Se lee linea por linea del archivo
        }
    }//fin del metodo enlistar

    @Override
    public void agregarAlumnos(AlumnosDatos objAlumnos) {
        boolean anexar =false;
        var entrada =new File(NOMBRE_ARCHIVO);
        try{
            //Se revisa si el archivo existe
            anexar =entrada.exists();
            var salida =new PrintWriter(new FileWriter(entrada,anexar));
            //Se agregan los datos con toString
            salida.println(objAlumnos.toString());
            salida.close();
            System.out.println("Se agrego el archivo");
        }catch(Exception e){
            System.out.println("Ocurrio un error al agregar los datos: "+e.getMessage());
        }
    }
    @Override
    public void buscarAlumnos(AlumnosDatos objAlumnos) {
        var archivo =new File(NOMBRE_ARCHIVO);
        try{
            var entrada =new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto=entrada.readLine();
            //var indice =0;
            var encontrada =false;
            var idBuscar =objAlumnos.idAlumno();
            var nombreBuscar =objAlumnos.nombre();
            while(lineaTexto!=null){
                var partes =lineaTexto.split(",");
                if(partes.length>=3){
                    var idAlumno =partes[0].trim();
                    var nombre = partes[1].trim();
                    if(idBuscar != null && idAlumno.equalsIgnoreCase(idAlumno)&&
                    nombreBuscar !=null && nombreBuscar.equalsIgnoreCase(nombre)){
                        encontrada =true ;
                        break;
                    }
                }
                //Se lee la siguiente iteraccion
                lineaTexto = entrada.readLine();
               // indice=indice+1;
            }//Fin del bucle
            if (!encontrada){
                System.out.println("El alumno: "+objAlumnos.nombre()+", Si esta registrado/a");
            }else{
                System.out.println("No se encontro al alumno: "+objAlumnos.nombre());
            }
            entrada.close();
        }catch(Exception e ){
            System.out.println("Se encontro un error del tipo: "+e.getMessage());
        }
    }
}
