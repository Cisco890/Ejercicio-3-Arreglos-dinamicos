public class Notas {
    private int estudianteid;
    private int cursoid;
    private int nota;

 
    public Notas(int estudianteid, int cursoid, int nota) {
        this.estudianteid = estudianteid;
        this.cursoid = cursoid;
        this.nota = nota;
    }

  

    public int getestudianteid() {
        return estudianteid;
    }

    public void setEstudianteid(int estudianteid) {
        this.estudianteid = estudianteid;
    }

    public int getcursoid() {
        return cursoid;
    }

    public void setcursoid(int cursoid) {
        this.cursoid = cursoid;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}