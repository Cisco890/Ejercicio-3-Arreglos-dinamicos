/**
  * Random
 
  * @param id,nombre,carnet,fecha,correo
  * @throws aca se le piden los datos al usuario
  */
public class Estudiante {
    private int id;
    private String nombre;
    private String carnet;
    private String fecha;
    private String correo;


    public Estudiante(int id, String nombre, String carnet, String fecha, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.carnet = carnet;
        this.fecha = fecha;
        this.correo = correo;
    }

   
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }


    public String getCarnet() {
        return carnet;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCorreo() {
        return correo;
    }
}