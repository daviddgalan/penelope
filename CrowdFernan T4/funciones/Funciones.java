package funciones;

import java.util.Scanner;
public class Funciones {
    public static String usuario = "";
    public static String contrasena = null;
    public static String contrasena2 = "";
    public static int opcion1;
    public static int opcion2;
    public static int opcion3;
    public static int opcion4;
    public static String[] usuarios = {"admin", "gestor", "inversor1", "inversor2"};
    public static String[] contrasenas = {"adminpass", "gestorpass", "inversorpass1", "inversorpass2"};
    public static int[] intentosFallidosGestorInversor12 = {0 ,0 ,0};
    public static String[] nombreProyectos = {null, null, null};
    public static String[] descripcionProyectos = {"", "", ""};
    public static String[] tipoProyectos = {"", "", ""};
    public static double[] cantidadNecesariaProyectos = {0 ,0 ,0};
    public static double[] cantidadFinanciadaProyectos = {0 ,0 ,0};
    public static String[] fechaInicioProyectos = {"", "", ""};
    public static String[] fechaFinProyectos = {"", "", ""};
    public static String[] respuesta = {null, null, null, null, null, null, null, null};
    public static double[] cartera = {0 ,0};
    public static double[] cantidadInvertida = {0 ,0 ,0, 0, 0, 0};
    public static int x = 0;
    public static int y = 0;
    public static int[] graficoBarrasProyectos = {0 ,0 ,0};
    public static boolean[] bloquearGestorInversor12 = {false, false, false};

    public static void inicioSesion() {
        System.out.println("Seleccione una opción: \n" +
                "1.- Iniciar sesión.\n" +
                "2.- Registro.\n" +
                "3.- Salir.");
    }

    /**
     *
     * @param usuario
     * @param contrasena
     * @return usuario, contrasena
     */
    public static boolean validarCredenciales(String usuario, String contrasena) {
        if (usuario.equals(usuarios[0]) && contrasena.equals(contrasenas[0])) {
            return true;
        } else if (usuario.equals(usuarios[1]) && contrasena.equals(contrasenas[1]) && !bloquearGestorInversor12[0]) {
            resetearIntentosFallidosGestor();
            return true;
        } else if (usuario.equals(usuarios[2]) && contrasena.equals(contrasenas[2]) && !bloquearGestorInversor12[1]) {
            resetearIntentosFallidosInversor1();
            return true;
        } else if (usuario.equals(usuarios[3]) && contrasena.equals(contrasenas[3]) && !bloquearGestorInversor12[2]) {
            resetearIntentosFallidosInversor2();
            return true;
        } else {
            incrementarIntentosFallidos(usuario);
            return false;
        }
    }

    /**
     *
     * @return opcionInt
     */
    public static int si() {
        Scanner escaner = new Scanner(System.in);
        int opcionInt = Integer.parseInt(escaner.nextLine());
        return opcionInt;
    }

    /**
     *
     * @return opcionInt
     */
    public static double sd() {
        Scanner escaner = new Scanner(System.in);
        double opcionInt = Integer.parseInt(escaner.nextLine());
        return opcionInt;
    }

    /**
     *
     * @return
     */
    public static String ss() {
        Scanner escaner = new Scanner(System.in);
        String opcionString = escaner.nextLine();
        return opcionString;
    }

    /**
     *
     * @param usuario
     */
    private static void incrementarIntentosFallidos(String usuario) {
        if (usuario.equals(usuarios[1])) {
            intentosFallidosGestorInversor12[0]++;
            if (intentosFallidosGestorInversor12[0] == 3) {
                bloquearGestorInversor12[0] = true;
                System.out.println("Usuario gestor bloqueado. Contacta al administrador para desbloquear.");
            }
        } else if (usuario.equals(usuarios[2])) {
            intentosFallidosGestorInversor12[1]++;
            if (intentosFallidosGestorInversor12[1] == 3) {
                bloquearGestorInversor12[1] = true;
                System.out.println("Usuario inversor 1 bloqueado. Contacta al administrador para desbloquear.");
            }
        } else if (usuario.equals(usuarios[3])) {
            intentosFallidosGestorInversor12[2]++;
            if (intentosFallidosGestorInversor12[2] == 3) {
                bloquearGestorInversor12[2] = true;
                System.out.println("Usuario inversor 2 bloqueado. Contacta al administrador para desbloquear.");
            }
        }
    }
    private static void resetearIntentosFallidosGestor() {intentosFallidosGestorInversor12[0] = 0;}
    private static void resetearIntentosFallidosInversor1() {intentosFallidosGestorInversor12[1] = 0;}
    private static void resetearIntentosFallidosInversor2() {intentosFallidosGestorInversor12[2] = 0;}

    public static void crearProyecto() {
        if (nombreProyectos[0] == null) {
            System.out.println("Ingrese información para el proyecto 1:");
            System.out.print("Nombre: ");
            nombreProyectos[0] = ss();
            System.out.print("Descripción: ");
            descripcionProyectos[0] = ss();
            System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
            tipoProyectos[0] = ss();
            System.out.print("Cantidad necesaria: ");
            cantidadNecesariaProyectos[0] = sd();
            System.out.print("Cantidad financiada hasta el momento: ");
            cantidadFinanciadaProyectos[0] = sd();
            System.out.print("Fecha inicio: ");
            fechaInicioProyectos[0] = ss();
            System.out.print("Fecha fin: ");
            fechaFinProyectos[0] = ss();
            System.out.println("Proyecto 1 creado exitosamente.");
        } else if (nombreProyectos[1] == null) {
            System.out.println("Ingrese información para el proyecto 2:");
            System.out.print("Nombre: ");
            nombreProyectos[1] = ss();
            System.out.print("Descripción: ");
            descripcionProyectos[1] = ss();
            System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
            tipoProyectos[1] = ss();
            System.out.print("Cantidad necesaria: ");
            cantidadNecesariaProyectos[1] = sd();
            System.out.print("Cantidad financiada hasta el momento: ");
            cantidadFinanciadaProyectos[1] = sd();
            System.out.print("Fecha inicio: ");
            fechaInicioProyectos[1] = ss();
            System.out.print("Fecha fin: ");
            fechaFinProyectos[1] = ss();
            System.out.println("Proyecto 2 creado exitosamente.");
        } else if (nombreProyectos[2] == null) {
            System.out.println("Ingrese información para el proyecto 3:");
            System.out.print("Nombre: ");
            nombreProyectos[2] = ss();
            System.out.print("Descripción: ");
            descripcionProyectos[2] = ss();
            System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
            tipoProyectos[2] = ss();
            System.out.print("Cantidad necesaria: ");
            cantidadNecesariaProyectos[2] = sd();
            System.out.print("Cantidad financiada hasta el momento: ");
            cantidadFinanciadaProyectos[2] = sd();
            System.out.print("Fecha inicio: ");
            fechaInicioProyectos[2] = ss();
            System.out.print("Fecha fin: ");
            fechaFinProyectos[2] = ss();
            System.out.println("Proyecto 3 creado exitosamente.");
        } else {
            System.out.println("Ya has alcanzado el límite de proyectos. No puedes crear más proyectos.");
        }
    }
    public static void salirDeMenu(){
        System.out.print("0 para Salir: ");
        opcion4 = si();
        switch (opcion4) {
            case 0:
                break;
            default:
                System.out.println("Opción no válida. Inténtalo de nuevo.");
        }
    }
    public static void menuGestor(){
        System.out.println("Menú de Gestor: \n" +
        "1. Crear proyectos.\n" +
        "2. Mostrar tus proyectos.\n" +
        "3. Configuración.\n" +
        "4. Salir.");
    }
    public static void menuConfiguracion(){
        System.out.println("1. Cambiar nombre de usuario.\n" +
        "2. Cambiar contraseña de usuario.\n" +
        "3. Mostrar usuario y contraseña actual.\n" +
        "4. Salir.");
    }
    public static void menuInversor(){
        System.out.println("Menú de Inversor: \n" +
        "1. Mostrar proyectos.\n" +
        "2. Mis inversiones.\n" +
        "3. Cartera digital.\n" +
        "4. Configuración.\n" +
        "5. Salir");
    }
    public static void menuCarteraInversor(){
        System.out.println("1. Saldo actual.\n" +
        "2. Añadir saldo.\n" +
        "3. Salir.");
    }
    public static void anadirSaldoInversor(){
        System.out.println("Introduce la cantidad que quieres sumar a tu saldo.");
        cartera[0] += sd();
    }
    public static void anadirSaldoInversor2(){
        System.out.println("Introduce la cantidad que quieres sumar a tu saldo.");
        cartera[1] += sd();
    }
    public static void menuMisInversiones(){
        System.out.println("Mis Inversiones: \n" +
        "1. Invertir en Proyectos.\n" +
        "2. Mostrar mis inversiones.\n" +
        "3. Salir.");
    }
    public static void menuDeProyectos(){
        System.out.println("Proyectos: \n" +
        "1. Proyecto 1.\n" +
        "2. Proyecto 2.\n" +
        "3. Proyecto 3.\n" +
        "4. Salir.");
    }
    public static void invertirProyecto1() {
        if (nombreProyectos[0] != null) {
            System.out.print("PROYECTO 1\n" +
                    "Nombre: " + nombreProyectos[0] + "\n" +
                    "Descripción: " + descripcionProyectos[0] + "\n" +
                    "Tipo: " + tipoProyectos[0] + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyectos[0] + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyectos[0] + "\n" +
                    "Fecha inicio: " + fechaInicioProyectos[0] + "\n" +
                    "Fecha fin: " + fechaFinProyectos[0] + "\n" +
                    "Invertir: ");
            cantidadInvertida[0] = sd();
            if (cantidadInvertida[0] > cartera[0]) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida[0] > (cantidadNecesariaProyectos[0] - cantidadFinanciadaProyectos[0])) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida[0] <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida[0] + " euros.");
                cartera[0] = cartera[0] - cantidadInvertida[0];
                cantidadFinanciadaProyectos[0] += cantidadInvertida[0];
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void invertirProyecto2(){
        if (nombreProyectos[1] != null) {
            System.out.print("PROYECTO 2\n" +
                    "Nombre: " + nombreProyectos[1] + "\n" +
                    "Descripción: " + descripcionProyectos[1] + "\n" +
                    "Tipo: " + tipoProyectos[1] + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyectos[1] + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyectos[1] + "\n" +
                    "Fecha inicio: " + fechaInicioProyectos[1] + "\n" +
                    "Fecha fin: " + fechaFinProyectos[1] + "\n" +
                    "Invertir: ");
            cantidadInvertida[1] = sd();
            if (cantidadInvertida[1] > cartera[0]) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida[1] > (cantidadNecesariaProyectos[1] - cantidadFinanciadaProyectos[1])) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida[1] <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida[1] + " euros.");
                cartera[0] = cartera[0] - cantidadInvertida[1];
                cantidadFinanciadaProyectos[1] += cantidadInvertida[1];
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void invertirProyecto3(){
        if (nombreProyectos[2] != null) {
            System.out.print("PROYECTO 3\n" +
                    "Nombre: " + nombreProyectos[2] + "\n" +
                    "Descripción: " + descripcionProyectos[2] + "\n" +
                    "Tipo: " + tipoProyectos[2] + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyectos[2] + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyectos[2] + "\n" +
                    "Fecha inicio: " + fechaInicioProyectos[2] + "\n" +
                    "Fecha fin: " + fechaFinProyectos[2] + "\n" +
                    "Invertir: ");
            cantidadInvertida[2] = sd();
            if (cantidadInvertida[2] > cartera[0]) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida[2] > (cantidadNecesariaProyectos[2] - cantidadFinanciadaProyectos[2])) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida[2] <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida[2] + " euros.");
                cartera[0] = cartera[0] - cantidadInvertida[2];
                cantidadFinanciadaProyectos[2] += cantidadInvertida[2];
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void invertirProyecto4() {
        if (nombreProyectos[0] != null) {
            System.out.print("PROYECTO 1\n" +
                    "Nombre: " + nombreProyectos[0] + "\n" +
                    "Descripción: " + descripcionProyectos[0] + "\n" +
                    "Tipo: " + tipoProyectos[0] + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyectos[0] + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyectos[0] + "\n" +
                    "Fecha inicio: " + fechaInicioProyectos[0] + "\n" +
                    "Fecha fin: " + fechaFinProyectos[0] + "\n" +
                    "Invertir: ");
            cantidadInvertida[3] = sd();
            if (cantidadInvertida[3] > cartera[1]) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida[3] > (cantidadNecesariaProyectos[0] - cantidadFinanciadaProyectos[0])) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida[3] <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida[3] + " euros.");
                cartera[1] = cartera[1] - cantidadInvertida[3];
                cantidadFinanciadaProyectos[0] += cantidadInvertida[3];
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void invertirProyecto5() {
            if (nombreProyectos[2] != null) {
                System.out.print("PROYECTO 3\n" +
                        "Nombre: " + nombreProyectos[2] + "\n" +
                        "Descripción: " + descripcionProyectos[2] + "\n" +
                        "Tipo: " + tipoProyectos[2] + "\n" +
                        "Cantidad necesaria: " + cantidadNecesariaProyectos[2] + "\n" +
                        "Cantidad financiada: " + cantidadFinanciadaProyectos[2] + "\n" +
                        "Fecha inicio: " + fechaInicioProyectos[2] + "\n" +
                        "Fecha fin: " + fechaFinProyectos[2] + "\n" +
                        "Invertir: ");
            cantidadInvertida[4] = sd();
            if (cantidadInvertida[4] > cartera[1]) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida[4] > (cantidadNecesariaProyectos[1] - cantidadFinanciadaProyectos[1])) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida[4] <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida[4] + " euros.");
                cartera[1] = cartera[1] - cantidadInvertida[4];
                cantidadFinanciadaProyectos[1] += cantidadInvertida[4];
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void invertirProyecto6() {
        if (nombreProyectos[0] != null) {
            System.out.print("PROYECTO 3\n" +
                    "Nombre: " + nombreProyectos[2] + "\n" +
                    "Descripción: " + descripcionProyectos[2] + "\n" +
                    "Tipo: " + tipoProyectos[2] + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyectos[2] + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyectos[2] + "\n" +
                    "Fecha inicio: " + fechaInicioProyectos[2] + "\n" +
                    "Fecha fin: " + fechaFinProyectos[2] + "\n" +
                    "Invertir: ");
            cantidadInvertida[5] = sd();
            if (cantidadInvertida[5] > cartera[1]) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida[5] > (cantidadNecesariaProyectos[2] - cantidadFinanciadaProyectos[2])) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida[5] <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida[5] + " euros.");
                cartera[1] = cartera[1] - cantidadInvertida[5];
                cantidadFinanciadaProyectos[2] += cantidadInvertida[5];
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void mostrarProyecto1(){
        if (nombreProyectos[0] != null) {
            System.out.println("PROYECTO 1\n" +
                    "Nombre: " + nombreProyectos[0] + "\n" +
                    "Descripción: " + descripcionProyectos[0] + "\n" +
                    "Tipo: " + tipoProyectos[0] + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyectos[0] + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyectos[0] + "\n" +
                    "Fecha inicio: " + fechaInicioProyectos[0] + "\n" +
                    "Fecha fin: " + fechaFinProyectos[0]);
            System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                    "| : Parte financiada.\n" +
                    "* : Parte por financiar.");
            graficoBarrasProyectos[0] = (int) ((cantidadFinanciadaProyectos[0]*100)/cantidadNecesariaProyectos[0]);
            for (x = 0; x != graficoBarrasProyectos[0]; x++){
                System.out.print("|");
            }
            System.out.print(x + "%");
            if (0 != 100 - graficoBarrasProyectos[0]){
                for (y = 0; y != 100 - graficoBarrasProyectos[0]; y++){
                    System.out.print("*");
                }
                System.out.println();
            }else System.out.println();
        }else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void mostrarProyecto2(){
        if (nombreProyectos[1] != null) {
            System.out.println("PROYECTO 2\n" +
                    "Nombre: " + nombreProyectos[1] + "\n" +
                    "Descripción: " + descripcionProyectos[1] + "\n" +
                    "Tipo: " + tipoProyectos[1] + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyectos[1] + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyectos[1] + "\n" +
                    "Fecha inicio: " + fechaInicioProyectos[1] + "\n" +
                    "Fecha fin: " + fechaFinProyectos[1]);
            System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                    "| : Parte financiada.\n" +
                    "* : Parte por financiar.");
            graficoBarrasProyectos[1] = (int) ((cantidadFinanciadaProyectos[1]*100)/cantidadNecesariaProyectos[1]);
            for (x = 0; x != graficoBarrasProyectos[1]; x++){
                System.out.print("|");
            }
            System.out.print(x + "%");
            if (0 != 100 - graficoBarrasProyectos[1]){
                for (y = 0; y != 100 - graficoBarrasProyectos[1]; y++){
                    System.out.print("*");
                }
                System.out.println();
            }else System.out.println();
        }else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void mostrarProyecto3(){
        if (nombreProyectos[2] != null) {
            System.out.println("PROYECTO 3\n" +
                    "Nombre: " + nombreProyectos[2] + "\n" +
                    "Descripción: " + descripcionProyectos[2] + "\n" +
                    "Tipo: " + tipoProyectos[2] + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyectos[2] + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyectos[2] + "\n" +
                    "Fecha inicio: " + fechaInicioProyectos[2] + "\n" +
                    "Fecha fin: " + fechaFinProyectos[2]);
            System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                    "| : Parte financiada.\n" +
                    "* : Parte por financiar.");
            graficoBarrasProyectos[2] = (int) ((cantidadFinanciadaProyectos[2]*100)/cantidadNecesariaProyectos[2]);
            for (x = 0; x != graficoBarrasProyectos[2]; x++){
                System.out.print("|");
            }
            System.out.print(x + "%");
            if (0 != 100 - graficoBarrasProyectos[2]){
                for (y = 0; y != 100 - graficoBarrasProyectos[2]; y++){
                    System.out.print("*");
                }
                System.out.println();
            }else System.out.println();
        }else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void mostrarMisInversiones1(){
        if (nombreProyectos[0] == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida[0] == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 1: \n" +
            "Nombre: " + nombreProyectos[0] + "\n" +
            "Tipo: " + tipoProyectos[0] + "\n" +
            "Inversión: " + cantidadInvertida[0]);
        }
    }
    public static void mostrarMisInversiones2(){
        if (nombreProyectos[1] == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida[1] == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 2: \n" +
                    "Nombre: " + nombreProyectos[1] + "\n" +
                    "Tipo: " + tipoProyectos[1] + "\n" +
                    "Inversión: " + cantidadInvertida[1]);
        }
    }
    public static void mostrarMisInversiones3(){
        if (nombreProyectos[2] == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida[2] == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 3: \n" +
                    "Nombre: " + nombreProyectos[2] + "\n" +
                    "Tipo: " + tipoProyectos[2] + "\n" +
                    "Inversión: " + cantidadInvertida[2]);
        }
    }
    public static void mostrarMisInversiones4(){
        if (nombreProyectos[0] == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida[3] == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 1: \n" +
                    "Nombre: " + nombreProyectos[0] + "\n" +
                    "Tipo: " + tipoProyectos[0] + "\n" +
                    "Inversión: " + cantidadInvertida[3]);
        }
    }
    public static void mostrarMisInversiones5(){
        if (nombreProyectos[1] == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida[4] == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 2: \n" +
                    "Nombre: " + nombreProyectos[1] + "\n" +
                    "Tipo: " + tipoProyectos[1] + "\n" +
                    "Inversión: " + cantidadInvertida[4]);
        }
    }
    public static void mostrarMisInversiones6(){
        if (nombreProyectos[2] == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida[5] == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 3: \n" +
                    "Nombre: " + nombreProyectos[2] + "\n" +
                    "Tipo: " + tipoProyectos[2] + "\n" +
                    "Inversión: " + cantidadInvertida[5]);
        }
    }
    public static void menuAdmin(){
        System.out.println("Menú Admin: \n" +
        "1. Mostrar proyectos.\n" +
        "2. Editar proyectos.\n" +
        "3. Desbloquear usuarios.\n" +
        "4. Configuración.\n" +
        "5. Salir.");
    }

    public static void editarProyectosAdmin(){
        System.out.println("Editar Proyecto: \n" +
                "1. Nombre.\n" +
                "2. Descripción.\n" +
                "3. Tipo (Préstamo, plusvalía o alquiler).\n" +
                "4. Cantidad necesaria.\n" +
                "5. Cantidad financiada hasta el momento.\n" +
                "6. Fecha inicio.\n" +
                "7. Fecha fin.\n" +
                "8. Salir.");
    }
    public static void desbloquearUsuariosAdmin(){
        System.out.println("Desbloquear Usuario: \n" +
                "1. Gestor.\n" +
                "2. Inversor1.\n" +
                "3. Inversor2.\n" +
                "4. Salir.");
    }
    public static void cambiarUsuarioGestor(){
        System.out.print("Contraseña: ");
        respuesta[0] = ss();
        if (respuesta[0].equals(contrasenas[1])) {
            System.out.print("Usuario nuevo: ");
            usuarios[1] = ss();
            salirDeMenu();
        }
    }
    public static void cambiarContrasenaGestor() {
        System.out.print("Contraseña actual: ");
        respuesta[0] = ss();
        if (respuesta[0].equals(contrasenas[1])) {
            System.out.print("Contraseña nueva: ");
            contrasenas[1] = ss();
            salirDeMenu();
        }
    }
    public static void mostrarUsuarioContrasenaGestor() {
        System.out.println("Usuario: " + usuarios[1] + "\n" +
                "Contraseña: " + contrasenas[1]);
    }
    public static void error(){
        System.out.println("Opción no válida. Inténtalo de nuevo.");
    }
    public static void cambiarUsuarioInversor1(){
        System.out.print("Contraseña: ");
        respuesta[0] = ss();
        if (respuesta[0].equals(contrasenas[2])) {
            System.out.print("Usuario nuevo: ");
            usuarios[2] = ss();
            salirDeMenu();
        }
    }
    public static void cambiarContrasenaInversor1(){
        System.out.print("Contraseña actual: ");
        respuesta[0] = ss();
        if (respuesta[0].equals(contrasenas[2])) {
            System.out.print("Contraseña nueva: ");
            contrasenas[2] = ss();
            salirDeMenu();
        }
    }

    public static void mostrarUsuarioContrasenaInversor1() {
        System.out.println("Usuario: " + usuarios[2] + "\n" +
                "Contraseña: " + contrasenas[2]);
    }
    public static void cambiarUsuarioInversor2() {
        System.out.print("Contraseña: ");
        respuesta[0] = ss();
        if (respuesta[0].equals(contrasenas[3])) {
            System.out.print("Usuario nuevo: ");
            usuarios[3] = ss();
            salirDeMenu();
        }
    }
    public static void cambiarContrasenaInversor2(){
        System.out.print("Contraseña actual: ");
        respuesta[0] = ss();
        if (respuesta[0].equals(contrasenas[3])) {
            System.out.print("Contraseña nueva: ");
            contrasenas[3] = ss();
            salirDeMenu();
        }
    }
    public static void mostrarUsuarioContrasenaInversor2() {
        System.out.println("Usuario: " + usuarios[3] + "\n" +
                "Contraseña: " + contrasenas[3]);
        salirDeMenu();
    }
    public static void mostrarMenuGestor() {

        switch (opcion1) {
            case 1: {
                crearProyecto();
                salirDeMenu();
                break;
            }
            case 2: {
                do {
                    menuDeProyectos();
                    opcion2 = si();
                    switch (opcion2) {
                        case 1: {
                            mostrarProyecto1();
                            salirDeMenu();
                            break;
                        }
                        case 2: {
                            mostrarProyecto2();
                            salirDeMenu();
                            break;
                        }
                        case 3: {
                            mostrarProyecto3();
                            salirDeMenu();
                            break;
                        }
                        case 4:
                            break;
                        default: error();
                    }
                }while (opcion2 != 4);
                break;
            }
            case 3: {
                do {
                    menuConfiguracion();
                    opcion2 = si();
                    switch (opcion2) {
                        case 1: {
                            cambiarUsuarioGestor();
                            break;
                        }
                        case 2: {
                            cambiarContrasenaGestor();
                            break;
                        }
                        case 3: {
                            mostrarUsuarioContrasenaGestor();
                            salirDeMenu();
                            break;
                        }
                        case 4: break;
                        default: error();
                    }
                } while (opcion2 != 4);
                break;
            }
            case 4: break;
            default: error();
        }
    }

    public static void mostrarMenuInversor1(){
        switch (opcion1) {
            case 1: {
                do {
                    menuDeProyectos();
                    opcion2 = si();
                    switch (opcion2) {
                        case 1: {
                            mostrarProyecto1();
                            salirDeMenu();
                            break;
                        }
                        case 2: {
                            mostrarProyecto2();
                            salirDeMenu();
                            break;
                        }
                        case 3: {
                            mostrarProyecto3();
                            salirDeMenu();
                            break;
                        }
                        case 4:
                            break;
                        default: error();
                    }
                }while (opcion2 != 4);
                break;
            }
            case 2: {
                do {
                    menuMisInversiones();
                    opcion2 = si();
                    switch (opcion2){
                        case 1: {
                            do {
                                menuDeProyectos();
                                opcion3 = si();
                                switch (opcion3) {
                                    case 1: {
                                        invertirProyecto1();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 2: {
                                        invertirProyecto2();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 3: {
                                        invertirProyecto3();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 4: break;
                                    default: error();
                                }
                            }while (opcion3 != 4);
                            break;
                        }
                        case 2: {
                            do {
                                menuDeProyectos();
                                opcion3 = si();
                                switch (opcion3){
                                    case 1: {
                                        mostrarMisInversiones1();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 2: {
                                        mostrarMisInversiones2();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 3: {
                                        mostrarMisInversiones3();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 4: break;
                                    default: error();
                                }
                            }while(opcion3 != 4);
                            break;
                        }
                        case 3: break;
                        default: error();
                    }
                }while (opcion2 != 3);
                break;
            }
            case 3: {
                do {
                    menuCarteraInversor();
                    opcion2 = si();
                    switch (opcion2) {
                        case 1: {
                            System.out.println(cartera[0]);
                            salirDeMenu();
                            break;
                        }
                        case 2: {
                            anadirSaldoInversor();
                            salirDeMenu();
                            break;
                        }
                        case 3: break;
                        default: error();
                    }
                } while (opcion2 != 3);
                break;
            }
            case 4: {
                do {
                    menuConfiguracion();
                    opcion2 = si();
                    switch (opcion2) {
                        case 1: {
                            cambiarUsuarioInversor1();
                            break;
                        }
                        case 2: {
                            cambiarContrasenaInversor1();
                            break;
                        }
                        case 3: {
                            mostrarUsuarioContrasenaInversor1();
                            salirDeMenu();
                            break;
                        }
                        case 4: break;
                        default: error();
                    }
                } while (opcion2 != 4);
                break;
            }
            case 5: break;
            default: error();
        }
    }
    public static void mostrarMenuInversor2(){
        switch (opcion1) {
            case 1: {
                do {
                    menuDeProyectos();
                    opcion2 = si();
                    switch (opcion2) {
                        case 1: {
                            mostrarProyecto1();
                            salirDeMenu();
                            break;
                        }
                        case 2: {
                            mostrarProyecto2();
                            salirDeMenu();
                            break;
                        }
                        case 3: {
                            mostrarProyecto3();
                            salirDeMenu();
                            break;
                        }
                        case 4: break;
                        default: error();
                    }
                }while (opcion2 != 4);
                break;
            }
            case 2: {
                do {
                    menuMisInversiones();
                    opcion2 = si();
                    switch (opcion2){
                        case 1: {
                            do {
                                menuDeProyectos();
                                opcion3 = si();
                                switch (opcion3) {
                                    case 1: {
                                        invertirProyecto4();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 2: {
                                        invertirProyecto5();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 3: {
                                        invertirProyecto6();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 4: break;
                                    default: error();
                                }
                            }while (opcion3 != 4);
                            break;
                        }
                        case 2: {
                            do {
                                menuDeProyectos();
                                opcion3 = si();
                                switch (opcion3){
                                    case 1: {
                                        mostrarMisInversiones4();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 2: {
                                        mostrarMisInversiones5();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 3: {
                                        mostrarMisInversiones6();
                                        salirDeMenu();
                                        break;
                                    }
                                    case 4: break;
                                    default: error();
                                }
                            }while(opcion3 != 4);
                            break;
                        }
                        case 3: break;
                        default: error();
                    }
                }while (opcion2 != 3);
                break;
            }
            case 3: {
                do {
                    menuCarteraInversor();
                    opcion2 = si();
                    switch (opcion2) {
                        case 1: {
                            System.out.println(cartera[1]);
                            salirDeMenu();
                            break;
                        }
                        case 2: {
                            anadirSaldoInversor2();
                            salirDeMenu();
                            break;
                        }
                        case 3: break;
                        default: error();
                    }
                } while (opcion2 != 3);
                break;
            }
            case 4: {
                do {
                    menuConfiguracion();
                    opcion2 = si();
                    switch (opcion2) {
                        case 1: {
                            cambiarUsuarioInversor2();
                            break;
                        }
                        case 2: {
                            cambiarContrasenaInversor2();
                            break;
                        }
                        case 3: {
                            mostrarUsuarioContrasenaInversor2();
                            break;
                        }
                        case 4: break;
                        default: error();
                    }
                } while (opcion2 != 4);
                break;
            }
            case 5: break;
            default: error();
        }
    }
    public static void mostrarMenuAdmin(){
        switch (opcion1){
            case 1: {
                do {
                    menuDeProyectos();
                    opcion2 = si();
                    switch (opcion2) {
                        case 1: {
                            mostrarProyecto1();
                            salirDeMenu();
                            break;
                        }
                        case 2: {
                            mostrarProyecto2();
                            salirDeMenu();
                            break;
                        }
                        case 3: {
                            mostrarProyecto3();
                            salirDeMenu();
                            break;
                        }
                        case 4: break;
                        default: error();
                    }
                }while (opcion2 != 4);
                break;
            }
            case 2: {
                do {
                    menuDeProyectos();
                    opcion2 = si();
                    switch (opcion2){
                        case 1:{
                            do {
                                editarProyectosAdmin();
                                opcion3 = si();
                                switch (opcion3) {
                                    case 1: {
                                        System.out.print("Nombre: ");
                                        nombreProyectos[0] = ss();
                                        break;
                                    }
                                    case 2: {
                                        System.out.print("Descripción: ");
                                        descripcionProyectos[0] = ss();
                                        break;
                                    }
                                    case 3: {
                                        System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
                                        tipoProyectos[0] = ss();
                                        break;
                                    }
                                    case 4: {
                                        System.out.print("Cantidad necesaria: ");
                                        cantidadNecesariaProyectos[0] = si();
                                        break;
                                    }
                                    case 5: {
                                        System.out.print("Cantidad financiada hasta el momento: ");
                                        cantidadFinanciadaProyectos[0] = si();
                                        break;
                                    }
                                    case 6: {
                                        System.out.print("Fecha inicio: ");
                                        fechaInicioProyectos[0] = ss();
                                        break;
                                    }
                                    case 7: {
                                        System.out.print("Fecha fin: ");
                                        fechaFinProyectos[0] = ss();
                                        break;
                                    }
                                    case 8: break;
                                    default: error();
                                }
                            }while (opcion3 != 8);
                            break;
                        }
                        case 2:{
                            do {
                                editarProyectosAdmin();
                                opcion3 = si();
                                switch (opcion3) {
                                    case 1: {
                                        System.out.print("Nombre: ");
                                        nombreProyectos[1] = ss();
                                        break;
                                    }
                                    case 2: {
                                        System.out.print("Descripción: ");
                                        descripcionProyectos[1] = ss();
                                        break;
                                    }
                                    case 3: {
                                        System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
                                        tipoProyectos[1] = ss();
                                        break;
                                    }
                                    case 4: {
                                        System.out.print("Cantidad necesaria: ");
                                        cantidadNecesariaProyectos[1] = si();
                                        break;
                                    }
                                    case 5: {
                                        System.out.print("Cantidad financiada hasta el momento: ");
                                        cantidadFinanciadaProyectos[1] = si();
                                        break;
                                    }
                                    case 6: {
                                        System.out.print("Fecha inicio: ");
                                        fechaInicioProyectos[1] = ss();
                                        break;
                                    }
                                    case 7: {
                                        System.out.print("Fecha fin: ");
                                        fechaFinProyectos[1] = ss();
                                        break;
                                    }
                                    case 8: break;
                                    default:error();
                                }
                            }while (opcion3 != 8);
                        }
                        case 3: {
                            do {
                                editarProyectosAdmin();
                                opcion3 = si();
                                switch (opcion3) {
                                    case 1: {
                                        System.out.print("Nombre: ");
                                        nombreProyectos[2] = ss();
                                        break;
                                    }
                                    case 2: {
                                        System.out.print("Descripción: ");
                                        descripcionProyectos[2] = ss();
                                        break;
                                    }
                                    case 3: {
                                        System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
                                        tipoProyectos[2] = ss();
                                        break;
                                    }
                                    case 4: {
                                        System.out.print("Cantidad necesaria: ");
                                        cantidadNecesariaProyectos[2] = si();
                                        break;
                                    }
                                    case 5: {
                                        System.out.print("Cantidad financiada hasta el momento: ");
                                        cantidadFinanciadaProyectos[2] = si();
                                        break;
                                    }
                                    case 6: {
                                        System.out.print("Fecha inicio: ");
                                        fechaInicioProyectos[2] = ss();
                                        break;
                                    }
                                    case 7: {
                                        System.out.print("Fecha fin: ");
                                        fechaFinProyectos[2] = ss();
                                        break;
                                    }
                                    case 8: break;
                                    default: error();
                                }
                            }while (opcion3 != 8);
                        }
                        case 4: break;
                        default: error();
                    }
                }while (opcion2 != 4);
                break;
            }
            case 3: {
                do {
                    desbloquearUsuariosAdmin();
                    opcion2 = si();
                    switch (opcion2){
                        case 1: {
                            if (bloquearGestorInversor12[0]){
                                System.out.print("X para desbloquear a gestor: ");
                                respuesta[0] = ss();
                                if (respuesta[0].equalsIgnoreCase("x")) bloquearGestorInversor12[0] = false;
                                salirDeMenu();
                            }else{
                                System.out.print("X para bloquear a gestor: ");
                                respuesta[0] = ss();
                                if (respuesta[0].equalsIgnoreCase("x")) bloquearGestorInversor12[0] = true;
                                salirDeMenu();
                            }break;
                        }
                        case 2: {
                            if (bloquearGestorInversor12[1]){
                                System.out.print("X para desbloquear a Inversor1: ");
                                respuesta[0] = ss();
                                if (respuesta[0].equalsIgnoreCase("x")) bloquearGestorInversor12[1] = false;
                                salirDeMenu();
                            }else{
                                System.out.print("X para bloquear a Inversor1: ");
                                respuesta[0] = ss();
                                if (respuesta[0].equalsIgnoreCase("x")) bloquearGestorInversor12[1] = true;
                                salirDeMenu();
                            }break;
                        }
                        case 3: {
                            if (bloquearGestorInversor12[2]){
                                System.out.print("X para desbloquear a Inversor2: ");
                                respuesta[0] = ss();
                                if (respuesta[0].equalsIgnoreCase("x")) bloquearGestorInversor12[2] = false;
                                salirDeMenu();
                            }else{
                                System.out.print("X para bloquear a Inversor2: ");
                                respuesta[0] = ss();
                                if (respuesta[0].equalsIgnoreCase("x")) bloquearGestorInversor12[2] = true;
                                salirDeMenu();
                            }break;
                        }
                        case 4: break;
                        default: error();
                    }
                }while (opcion2 != 4);
                break;
            }
            case 4: {
                do {
                    menuConfiguracion();
                    opcion2 = si();
                    switch (opcion2) {
                        case 1: {
                            System.out.print("Contraseña: ");
                            respuesta[0] = ss();
                            if (respuesta[0].equals(contrasenas[0])) {
                                System.out.print("Usuario nuevo: ");
                                usuarios[0] = ss();
                                salirDeMenu();
                            }break;
                        }
                        case 2: {
                            System.out.print("Contraseña actual: ");
                            respuesta[0] = ss();
                            if (respuesta[0].equals(contrasenas[0])) {
                                System.out.print("Contraseña nueva: ");
                                contrasenas[0] = ss();
                                salirDeMenu();
                            }break;
                        }
                        case 3: {
                            System.out.println("Usuario: " + usuarios[0] + "\n" +
                                    "Contraseña: " + contrasenas[0]);
                            salirDeMenu();
                        }
                        case 4: break;

                        default: System.out.println("Por favor. Ingrese números solo 1-4.");

                    }
                } while (opcion2 != 4);
                break;
            } default: System.out.println("Por favor. Ingrese números solo 1-5.");
        }
    }
}

