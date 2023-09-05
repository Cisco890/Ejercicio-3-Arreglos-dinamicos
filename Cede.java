import java.util.Arrays;

public class Cede {
    private String[] nombres; 
    private int[][][] notas; 

    public Cede(int numCedes, int numMaterias, int numEstudiantes) {
        this.nombres = new String[numCedes];
        this.notas = new int[numMaterias][numCedes][numEstudiantes];
    }

   
    public void setNombre(int cedeIndex, String nombre) {
        if (cedeIndex >= 0 && cedeIndex < nombres.length) {
            nombres[cedeIndex] = nombre;
        }
    }

    public void registrarNota(int materia, int cedeIndex, int estudiante, int nota) {
        if (cedeIndex >= 0 && cedeIndex < nombres.length) {
            notas[materia][cedeIndex][estudiante] = nota;
        }
    }

    public double Moda(int materia, int cedeIndex) {
        
        int[] data = new int[notas[materia][cedeIndex].length];
        for (int i = 0; i < data.length; i++) {
            data[i] = notas[materia][cedeIndex][i];
        }
        Arrays.sort(data);

        int moda = 0;
        int modaCount = 0;
        int count = 1;

        for (int i = 1; i < data.length; i++) {
            if (data[i] == data[i - 1]) {
                count++;
            } else {
                if (count > modaCount) {
                    modaCount = count;
                    moda = data[i - 1];
                }
                count = 1;
            }
        }

        return moda;
    }

    public double Mediana(int materia, int cedeIndex) {
        
        int[] data = new int[notas[materia][cedeIndex].length];
        for (int i = 0; i < data.length; i++) {
            data[i] = notas[materia][cedeIndex][i];
        }
        Arrays.sort(data);

        if (data.length % 2 == 0) {
            int mid1 = data[data.length / 2 - 1];
            int mid2 = data[data.length / 2];
            return (double) (mid1 + mid2) / 2.0;
        } else {
            return (double) data[data.length / 2];
        }
    }

    public double Desestandar(int materia, int cedeIndex) {
      
        int[] data = new int[notas[materia][cedeIndex].length];
        for (int i = 0; i < data.length; i++) {
            data[i] = notas[materia][cedeIndex][i];
        }

        double sum = 0.0;
        double mean = 0.0;
        int length = data.length;

        for (int num : data) {
            sum += num;
        }

        mean = sum / length;

        double squaredDiffSum = 0.0;

        for (int num : data) {
            squaredDiffSum += (num - mean) * (num - mean);
        }

        double variance = squaredDiffSum / length;
        return Math.sqrt(variance);
    }

    public int Max(int materia, int cedeIndex) {
        
        int[] data = new int[notas[materia][cedeIndex].length];
        for (int i = 0; i < data.length; i++) {
            data[i] = notas[materia][cedeIndex][i];
        }
        Arrays.sort(data);
        return data[data.length - 1];
    }

    public int Min(int materia, int cedeIndex) {
        
        int[] data = new int[notas[materia][cedeIndex].length];
        for (int i = 0; i < data.length; i++) {
            data[i] = notas[materia][cedeIndex][i];
        }
        Arrays.sort(data);
        return data[0];
    }
}