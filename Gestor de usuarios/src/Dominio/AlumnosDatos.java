package Dominio;

import java.util.Objects;

public class AlumnosDatos  extends AlumnosID{
    private String idAlumno;
    private String nombre;
    private String parcial1;
    private String parcial2;
    private String parcial3;



    public AlumnosDatos
            (int id,String idAlumno,String nombre,String parcial1,String parcial2,String parcial3){
        super(id);
        this.idAlumno=String.valueOf(id);
        this.nombre=nombre;
        this.parcial1=parcial1;
        this.parcial2=parcial2;
        this.parcial3=parcial3;

    }

    public String idAlumno() {
        return idAlumno;
    }
    public String nombre() {
        return nombre;
    }
    public String parcial1() {
        return parcial1;
    }
    public String parcial2() {
        return parcial2;
    }
    public String parcial3() {
        return parcial3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlumnosDatos that = (AlumnosDatos) o;

        if (!Objects.equals(idAlumno, that.idAlumno)) return false;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        int result = idAlumno != null ? idAlumno.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ID Alumno: "+idAlumno+", Nombre: "+nombre+"\n"
                +"CALIFICACIONES\n"+"Parcial 1: "+parcial1+"\n"
                +"Parcial 2: "+parcial2+"\nParcial 3: "+parcial3
                +"\n--------------------------------------";
    }

    public static void main(String[] args) {
        AlumnosID objpr =new AlumnosID(6);
        int num1 = objpr.getId();
        AlumnosDatos obj1 =new AlumnosDatos
                (num1,"","Juan D","7.5","9","10");
        System.out.println(obj1);
    }


}
