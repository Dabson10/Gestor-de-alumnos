package Funcionalidad;

import Dominio.AlumnosDatos;

public interface IServicioAlumnos {

    public void listarAlumnos();

    public void agregarAlumnos(AlumnosDatos objAlumnos);
    public void buscarAlumnos(AlumnosDatos objAlumnos);

}
