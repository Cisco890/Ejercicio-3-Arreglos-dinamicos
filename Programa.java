import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        Estudiante[] estudiantes = new Estudiante[100];
        int numEstudiantes = 0;
        Cede cede = null;
        int materia = -1; 
        int sede = -1;    
        int nota = -1;    

        String[] materias = {"Matemática", "Lenguaje", "Química", "Física", "Comprensión Lectora", "Estadística"};

        
        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Ingresar datos del estudiante");
            System.out.println("2. Agregar notas del estudiante");
            System.out.println("3. Agregar la cede del estudiante y hacer el análisis de datos");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                    
                    System.out.print("Nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Carnet del estudiante: ");
                    String carnet = scanner.nextLine();
                    System.out.print("Fecha de nacimiento del estudiante (dia/mes/año): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Correo electrónico del estudiante: ");
                    String correo = scanner.nextLine();

                   
                    estudiantes[numEstudiantes] = new Estudiante(numEstudiantes + 1, nombre, carnet, fecha, correo);
                    numEstudiantes++;
                    System.out.println("Estudiante registrado con éxito.");
                    break;

                case 2:
                    
                    if (numEstudiantes == 0) {
                        System.out.println("No hay estudiantes registrados.");
                        break;
                    }

                    System.out.print("Ingrese el ID del estudiante (comenzando desde el 1): ");
                    int estudianteId = scanner.nextInt();

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

                    System.out.print("Ingrese la sede (1, 2 o 3): "); s
                    sede = scanner.nextInt();   
                    System.out.print("Ingrese la nota: ");
                    nota = scanner.nextInt(); 
                    
                    if (cede == null) {
                        
                        System.out.print("Ingrese el nombre de la cede: ");
                        String nombreCede = scanner.next();
                        cede = new Cede(nombreCede, materias.length, 3, numEstudiantes); 
                    }

                    
                    cede.registrarNota(materia - 1, sede - 1, estudianteId - 1, nota);
                    System.out.println("Nota registrada con éxito.");
                    break;
                

                case 3:
                    
                    if (cede == null) {
                        System.out.println("No se ha creado la cede.");
                    } else {
                       
                        double moda = cede.Moda(materia - 1, sede);
                        double mediana = cede.Mediana(materia - 1, sede);
                        double desviacionEstandar = cede.Desestandar(materia - 1, sede);
                        int notaMaxima = cede.Max(materia - 1, sede);
                        int notaMinima = cede.Min(materia - 1, sede);

                   
                        System.out.println("Análisis de datos:");
                        System.out.println("Moda: " + moda);
                        System.out.println("Mediana: " + mediana);
                        System.out.println("Desviación Estándar: " + desviacionEstandar);
                        System.out.println("Nota Máxima: " + notaMaxima);
                        System.out.println("Nota Mínima: " + notaMinima);
                    }
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