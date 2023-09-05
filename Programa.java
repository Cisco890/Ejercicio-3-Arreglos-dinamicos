/**
  * Random
 
  * @param Estudianes,Cede,notas
  * @throws Es el main del programa, aca se realiza todo

  */
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Estudiante[] estudiantes = new Estudiante[100];
        int numEstudiantes = 0; 
        Cede[] cedes = new Cede[3]; 
        int materia = -1;
        int sede = -1;
        int nota = -1;

        String[] cedeNombres = {"Central", "Sur", "Antiplano"}; 

        String[] materias = {"Matemática", "Lenguaje", "Química", "Física", "Comprensión Lectora", "Estadística"};

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Ingresar datos del estudiante");
            System.out.println("2. Agregar notas del estudiante");
            System.out.println("3. Hacer el análisis de datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (numEstudiantes >= estudiantes.length) {
                        System.out.println("Límite de estudiantes alcanzado.");
                        break;
                    }
                    
                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Carnet del estudiante: ");
                    String carnet = scanner.nextLine();
                    System.out.print("Fecha de nacimiento del estudiante (dia/mes/año): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Correo electrónico del estudiante: ");
                    String correo = scanner.nextLine();

                    int estudianteId = numEstudiantes + 1;

                    estudiantes[numEstudiantes] = new Estudiante(estudianteId, nombre, carnet, fecha, correo);
                    numEstudiantes++;
                    System.out.println("Estudiante registrado con éxito. ID del estudiante: " + estudianteId);
                    break;

                case 2:
                    if (numEstudiantes == 0) {
                        System.out.println("No hay estudiantes registrados.");
                        break;
                    }

                    System.out.print("Ingrese el ID del estudiante (comenzando desde el 1): ");
                    estudianteId = scanner.nextInt();

                    if (estudianteId < 1 || estudianteId > numEstudiantes) {
                        System.out.println("ID de estudiante no válido.");
                        break;
                    }

                    System.out.println("Cursos disponibles:");
                    for (int i = 0; i < materias.length; i++) {
                        System.out.println((i + 1) + ". " + materias[i]);
                    }

                    System.out.print("Ingrese el número de materia: ");
                    materia = scanner.nextInt();
                    if (materia < 1 || materia > materias.length) {
                        System.out.println("Número de materia no válido.");
                        break;
                    }

                    System.out.print("Ingrese la sede (1: Central, 2: Sur, 3: Antiplano): ");
                    sede = scanner.nextInt();
                    if (sede < 1 || sede > 3) {
                        System.out.println("Número de sede no válido.");
                        break;
                    }

                    System.out.print("Ingrese la nota: ");
                    nota = scanner.nextInt();

                    if (cedes[sede - 1] == null) {
                        cedes[sede - 1] = new Cede(1, materias.length, numEstudiantes); // Crear la cede correspondiente
                    }

                    cedes[sede - 1].registrarNota(materia - 1, 0, estudianteId - 1, nota);
                    System.out.println("Nota registrada con éxito.");
                    break;

                case 3:
                    System.out.print("Ingrese la sede para el análisis (1: Central, 2: Sur, 3: Antiplano): ");
                    sede = scanner.nextInt();
                    if (sede < 1 || sede > 3 || cedes[sede - 1] == null) {
                        System.out.println("Sede no válida o no se ha creado la cede.");
                        break;
                    }

                    double moda = cedes[sede - 1].Moda(materia - 1, 0);
                    double mediana = cedes[sede - 1].Mediana(materia - 1, 0);
                    double desviacionEstandar = cedes[sede - 1].Desestandar(materia - 1, 0);
                    int notaMaxima = cedes[sede - 1].Max(materia - 1, 0);
                    int notaMinima = cedes[sede - 1].Min(materia - 1, 0);

                    System.out.println("Análisis de datos para la cede " + cedeNombres[sede - 1] + ":");
                    System.out.println("Moda: " + moda);
                    System.out.println("Mediana: " + mediana);
                    System.out.println("Desviación Estándar: " + desviacionEstandar);
                    System.out.println("Nota Máxima: " + notaMaxima);
                    System.out.println("Nota Mínima: " + notaMinima);
                    break;

                case 4:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}