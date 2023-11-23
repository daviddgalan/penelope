package funciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class funciones {
    public static String usuario;
    public static String contrasena;
    public static String ADMIN_USUARIO = "admin";
    public static String ADMIN_CONTRASENA = "adminpass";
    public static String GESTOR_USUARIO = "gestor";
    public static String GESTOR_CONTRASENA = "gestorpass";
    public static String INVERSOR1_USUARIO = "inversor1";
    public static String INVERSOR1_CONTRASENA = "inversorpass1";
    public static String INVERSOR2_USUARIO = "inversor2";
    public static String INVERSOR2_CONTRASENA = "inversorpass2";
    public static int intentosFallidosGestor = 0;
    public static int intentosFallidosInversor1 = 0;
    public static int intentosFallidosInversor2 = 0;

    public static String nombreProyecto1 = "david";
    public static String descripcionProyecto1 = null;
    public static String tipoProyecto1 = null;
    public static double cantidadNecesariaProyecto1 = 1000;
    public static double cantidadFinanciadaProyecto1 = 768;
    public static String fechaInicioProyecto1 = null;
    public static String fechaFinProyecto1 = null;

    public static String nombreProyecto2 = "jose";
    public static String descripcionProyecto2 = null;
    public static String tipoProyecto2 = null;
    public static double cantidadNecesariaProyecto2 = 100;
    public static double cantidadFinanciadaProyecto2 = 100;
    public static String fechaInicioProyecto2 = null;
    public static String fechaFinProyecto2 = null;

    public static String nombreProyecto3 = "Marcos";
    public static String descripcionProyecto3 = null;
    public static String tipoProyecto3 = null;
    public static double cantidadNecesariaProyecto3 = 10000;
    public static double cantidadFinanciadaProyecto3 = 2000;
    public static String fechaInicioProyecto3 = null;
    public static String fechaFinProyecto3 = null;
    public static int opcion = 0;
    public static String respuesta1 = null;
    public static int respuesta2 = 0;
    public static int respuesta3 = 0;
    public static int respuesta4 = 0;
    public static int respuesta5 = 0;
    public static int respuesta6 = 0;
    public static int respuesta7 = 0;
    public static int respuesta8 = 0;
    public static int respuesta9 = 0;
    public static double cartera = 0;
    public static double cartera2 = 0;
    public static double cantidadInvertida1 = 0;
    public static double cantidadInvertida2 = 0;
    public static double cantidadInvertida3 = 0;
    public static double cantidadInvertida4 = 0;
    public static double cantidadInvertida5 = 0;
    public static double cantidadInvertida6 = 0;
    public static int x = 0;
    public static int y = 0;
    public static int graficoBarrasProyecto1 = (int) ((cantidadFinanciadaProyecto1*100)/cantidadNecesariaProyecto1);
    public static int graficoBarrasProyecto2 = (int) ((cantidadFinanciadaProyecto2*100)/cantidadNecesariaProyecto2);
    public static int graficoBarrasProyecto3 = (int) ((cantidadFinanciadaProyecto3*100)/cantidadNecesariaProyecto3);
    public static boolean bloquearGestor = false;
    public static boolean bloquearInversor1 = false;
    public static boolean bloquearInversor2 = false;
    public static void inicioSesion() {
        System.out.println("Seleccione una opción: \n" +
                "1.- Iniciar sesión.\n" +
                "2.- Salir.");
    }
    public static boolean validarCredenciales(String usuario, String contrasena) {
        if (usuario.equals(ADMIN_USUARIO) && contrasena.equals(ADMIN_CONTRASENA)) {
            return true;
        } else if (usuario.equals(GESTOR_USUARIO) && contrasena.equals(GESTOR_CONTRASENA) && bloquearGestor == false) {
            resetearIntentosFallidosGestor();
            return true;
        } else if (usuario.equals(INVERSOR1_USUARIO) && contrasena.equals(INVERSOR1_CONTRASENA) && bloquearInversor1 == false) {
            resetearIntentosFallidosInversor1();
            return true;
        } else if (usuario.equals(INVERSOR2_USUARIO) && contrasena.equals(INVERSOR2_CONTRASENA) && bloquearInversor2 == false) {
            resetearIntentosFallidosInversor2();
            return true;
        } else {
            incrementarIntentosFallidos(usuario);
            return false;
        }
    }
    public static int si() {
        Scanner escaner = new Scanner(System.in);
        int opcionInt = Integer.parseInt(escaner.nextLine());
        return opcionInt;
    }
    public static double sd() {
        Scanner escaner = new Scanner(System.in);
        double opcionInt = Integer.parseInt(escaner.nextLine());
        return opcionInt;
    }
    public static String ss() {
        Scanner escaner = new Scanner(System.in);
        String opcionString = escaner.nextLine();
        return opcionString;
    }
    private static void incrementarIntentosFallidos(String usuario) {
        if (usuario.equals(GESTOR_USUARIO)) {
            intentosFallidosGestor++;
            if (intentosFallidosGestor == 3) {
                bloquearGestor = true;
                System.out.println("Usuario gestor bloqueado. Contacta al administrador para desbloquear.");
            }
        } else if (usuario.equals(INVERSOR1_USUARIO)) {
            intentosFallidosInversor1++;
            if (intentosFallidosInversor1 == 3) {
                bloquearInversor1 = true;
                System.out.println("Usuario inversor 1 bloqueado. Contacta al administrador para desbloquear.");
            }
        } else if (usuario.equals(INVERSOR2_USUARIO)) {
            intentosFallidosInversor2++;
            if (intentosFallidosInversor2 == 3) {
                bloquearInversor2 = true;
                System.out.println("Usuario inversor 2 bloqueado. Contacta al administrador para desbloquear.");
            }
        }
    }

    private static void resetearIntentosFallidosGestor() {
        intentosFallidosGestor = 0;
    }

    private static void resetearIntentosFallidosInversor1() {
        intentosFallidosInversor1 = 0;
    }

    private static void resetearIntentosFallidosInversor2() {
        intentosFallidosInversor2 = 0;
    }

    public static void crearProyecto(Scanner scanner) {
        if (nombreProyecto1 == null) {
            System.out.println("Ingrese información para el proyecto 1:");
            System.out.print("Nombre: ");
            nombreProyecto1 = ss();
            System.out.print("Descripción: ");
            descripcionProyecto1 = ss();
            System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
            tipoProyecto1 = ss();
            System.out.print("Cantidad necesaria: ");
            cantidadNecesariaProyecto1 = sd();
            System.out.print("Cantidad financiada hasta el momento: ");
            cantidadFinanciadaProyecto1 = sd();
            System.out.print("Fecha inicio: ");
            fechaInicioProyecto1 = ss();
            System.out.print("Fecha fin: ");
            fechaFinProyecto1 = ss();
            System.out.println("Proyecto 1 creado exitosamente.");
        } else if (nombreProyecto2 == null) {
            System.out.println("Ingrese información para el proyecto 2:");
            System.out.print("Nombre: ");
            nombreProyecto2 = ss();
            System.out.print("Descripción: ");
            descripcionProyecto2 = ss();
            System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
            tipoProyecto2 = ss();
            System.out.print("Cantidad necesaria: ");
            cantidadNecesariaProyecto2 = sd();
            System.out.print("Cantidad financiada hasta el momento: ");
            cantidadFinanciadaProyecto2 = sd();
            System.out.print("Fecha inicio: ");
            fechaInicioProyecto2 = ss();
            System.out.print("Fecha fin: ");
            fechaFinProyecto2 = ss();
            System.out.println("Proyecto 2 creado exitosamente.");
        } else if (nombreProyecto3 == null) {
            System.out.println("Ingrese información para el proyecto 3:");
            System.out.print("Nombre: ");
            nombreProyecto3 = ss();
            System.out.print("Descripción: ");
            descripcionProyecto3 = ss();
            System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
            tipoProyecto3 = ss();
            System.out.print("Cantidad necesaria: ");
            cantidadNecesariaProyecto3 = sd();
            System.out.print("Cantidad financiada hasta el momento: ");
            cantidadFinanciadaProyecto3 = sd();
            System.out.print("Fecha inicio: ");
            fechaInicioProyecto3 = ss();
            System.out.print("Fecha fin: ");
            fechaFinProyecto3 = ss();
            System.out.println("Proyecto 3 creado exitosamente.");
        } else {
            System.out.println("Ya has alcanzado el límite de proyectos. No puedes crear más proyectos.");
        }
    }
    public static void salirDeMenu(){
        System.out.print("0 para Salir: ");
        opcion = si();
        switch (opcion) {
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
        cartera += sd();
    }
    public static void anadirSaldoInversor2(){
        System.out.println("Introduce la cantidad que quieres sumar a tu saldo.");
        cartera2 += sd();
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
        if (nombreProyecto1 != null) {
            System.out.print("PROYECTO 1\n" +
                    "Nombre: " + nombreProyecto1 + "\n" +
                    "Descripción: " + descripcionProyecto1 + "\n" +
                    "Tipo: " + tipoProyecto1 + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyecto1 + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyecto1 + "\n" +
                    "Fecha inicio: " + fechaInicioProyecto1 + "\n" +
                    "Fecha fin: " + fechaFinProyecto1 + "\n" +
                    "Invertir: ");
            cantidadInvertida1 = sd();
            if (cantidadInvertida1 > cartera) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida1 > (cantidadNecesariaProyecto1 - cantidadFinanciadaProyecto1)) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida1 <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida1 + " euros.");
                cartera = cartera - cantidadInvertida1;
                cantidadFinanciadaProyecto1 += cantidadInvertida1;
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void invertirProyecto2(){
        if (nombreProyecto2 != null) {
            System.out.print("PROYECTO 2\n" +
                    "Nombre: " + nombreProyecto2 + "\n" +
                    "Descripción: " + descripcionProyecto2 + "\n" +
                    "Tipo: " + tipoProyecto2 + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyecto2 + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyecto2 + "\n" +
                    "Fecha inicio: " + fechaInicioProyecto2 + "\n" +
                    "Fecha fin: " + fechaFinProyecto2 + "\n" +
                    "Invertir: ");
            cantidadInvertida2 = sd();
            if (cantidadInvertida2 > cartera) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida2 > (cantidadNecesariaProyecto2 - cantidadFinanciadaProyecto2)) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida2 <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida2 + " euros.");
                cartera = cartera - cantidadInvertida2;
                cantidadFinanciadaProyecto2 += cantidadInvertida2;
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void invertirProyecto3(){
        if (nombreProyecto3 != null) {
            System.out.print("PROYECTO 3\n" +
                    "Nombre: " + nombreProyecto3 + "\n" +
                    "Descripción: " + descripcionProyecto3 + "\n" +
                    "Tipo: " + tipoProyecto3 + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyecto3 + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyecto3 + "\n" +
                    "Fecha inicio: " + fechaInicioProyecto3 + "\n" +
                    "Fecha fin: " + fechaFinProyecto3 + "\n" +
                    "Invertir: ");
            cantidadInvertida3 = sd();
            if (cantidadInvertida3 > cartera) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida3 > (cantidadNecesariaProyecto3 - cantidadFinanciadaProyecto3)) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida3 <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida3 + " euros.");
                cartera = cartera - cantidadInvertida3;
                cantidadFinanciadaProyecto3 += cantidadInvertida3;
            }
        }else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void invertirProyecto4() {
        if (nombreProyecto1 != null) {
            System.out.print("PROYECTO 1\n" +
                    "Nombre: " + nombreProyecto1 + "\n" +
                    "Descripción: " + descripcionProyecto1 + "\n" +
                    "Tipo: " + tipoProyecto1 + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyecto1 + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyecto1 + "\n" +
                    "Fecha inicio: " + fechaInicioProyecto1 + "\n" +
                    "Fecha fin: " + fechaFinProyecto1 + "\n" +
                    "Invertir: ");
            cantidadInvertida4 = sd();
            if (cantidadInvertida4 > cartera2) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida4 > (cantidadNecesariaProyecto1 - cantidadFinanciadaProyecto1)) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida4 <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida4 + " euros.");
                cartera2 = cartera2 - cantidadInvertida4;
                cantidadFinanciadaProyecto1 += cantidadInvertida4;
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void invertirProyecto5() {
        if (nombreProyecto2 != null) {
            System.out.print("PROYECTO 2\n" +
                    "Nombre: " + nombreProyecto2 + "\n" +
                    "Descripción: " + descripcionProyecto2 + "\n" +
                    "Tipo: " + tipoProyecto2 + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyecto2 + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyecto2 + "\n" +
                    "Fecha inicio: " + fechaInicioProyecto2 + "\n" +
                    "Fecha fin: " + fechaFinProyecto2 + "\n" +
                    "Invertir: ");
            cantidadInvertida5 = sd();
            if (cantidadInvertida5 > cartera2) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida5 > (cantidadNecesariaProyecto2 - cantidadFinanciadaProyecto2)) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida5 <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida5 + " euros.");
                cartera2 = cartera2 - cantidadInvertida5;
                cantidadFinanciadaProyecto2 += cantidadInvertida5;
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void invertirProyecto6() {
        if (nombreProyecto3 != null) {
            System.out.print("PROYECTO 3\n" +
                    "Nombre: " + nombreProyecto3 + "\n" +
                    "Descripción: " + descripcionProyecto3 + "\n" +
                    "Tipo: " + tipoProyecto3 + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyecto3 + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyecto3 + "\n" +
                    "Fecha inicio: " + fechaInicioProyecto3 + "\n" +
                    "Fecha fin: " + fechaFinProyecto3 + "\n" +
                    "Invertir: ");
            cantidadInvertida6 = sd();
            if (cantidadInvertida6 > cartera2) {
                System.out.println("No tienes suficiente saldo en tu cartera");
            } else if (cantidadInvertida6 > (cantidadNecesariaProyecto3 - cantidadFinanciadaProyecto3)) {
                System.out.println("Cantidad Invertida mayor a la necesaria.");
            } else if (cantidadInvertida6 <= 0) {
                System.out.println("Introduce una cantidad mayor a 0.");
            }else {
                System.out.println("Has invertido " + cantidadInvertida6 + " euros.");
                cartera2 = cartera2 - cantidadInvertida6;
                cantidadFinanciadaProyecto3 += cantidadInvertida6;
            }
        } else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void mostrarProyecto1(){
        if (nombreProyecto1 != null) {
            System.out.println("PROYECTO 1\n" +
                    "Nombre: " + nombreProyecto1 + "\n" +
                    "Descripción: " + descripcionProyecto1 + "\n" +
                    "Tipo: " + tipoProyecto1 + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyecto1 + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyecto1 + "\n" +
                    "Fecha inicio: " + fechaInicioProyecto1 + "\n" +
                    "Fecha fin: " + fechaFinProyecto1);
            System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                    "| : Parte financiada.\n" +
                    "* : Parte por financiar.");
            graficoBarrasProyecto1 = (int) ((cantidadFinanciadaProyecto1*100)/cantidadNecesariaProyecto1);
            for (x = 0; x != graficoBarrasProyecto1; x++){
                System.out.print("|");

            }
            System.out.print(x + "%");
            if (0 != 100 - graficoBarrasProyecto1){
                for (y = 0; y != 100 - graficoBarrasProyecto1; y++){
                    System.out.print("*");
                }
                System.out.println();
            }else System.out.println();
        }else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void mostrarProyecto2(){
        if (nombreProyecto2 != null) {
            System.out.println("PROYECTO 2\n" +
                    "Nombre: " + nombreProyecto2 + "\n" +
                    "Descripción: " + descripcionProyecto2 + "\n" +
                    "Tipo: " + tipoProyecto2 + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyecto2 + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyecto2 + "\n" +
                    "Fecha inicio: " + fechaInicioProyecto2 + "\n" +
                    "Fecha fin: " + fechaFinProyecto2);
            System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                    "| : Parte financiada.\n" +
                    "* : Parte por financiar.");
            graficoBarrasProyecto2 = (int) ((cantidadFinanciadaProyecto2*100)/cantidadNecesariaProyecto2);
            for (x = 0; x != graficoBarrasProyecto2; x++){
                System.out.print("|");
            }
            System.out.print(x + "%");
            if (0 != 100 - graficoBarrasProyecto2){
                for (y = 0; y != 100 - graficoBarrasProyecto2; y++){
                    System.out.print("*");
                }
                System.out.println();
            }else System.out.println();
        }else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void mostrarProyecto3(){
        if (nombreProyecto3 != null) {
            System.out.println("PROYECTO 3\n" +
                    "Nombre: " + nombreProyecto3 + "\n" +
                    "Descripción: " + descripcionProyecto3 + "\n" +
                    "Tipo: " + tipoProyecto3 + "\n" +
                    "Cantidad necesaria: " + cantidadNecesariaProyecto3 + "\n" +
                    "Cantidad financiada: " + cantidadFinanciadaProyecto3 + "\n" +
                    "Fecha inicio: " + fechaInicioProyecto3 + "\n" +
                    "Fecha fin: " + fechaFinProyecto3);
            System.out.println("Gráfico de barras de cantidad finaciada: \n" +
                    "| : Parte financiada.\n" +
                    "* : Parte por financiar.");
            graficoBarrasProyecto3 = (int) ((cantidadFinanciadaProyecto3*100)/cantidadNecesariaProyecto3);
            for (x = 0; x != graficoBarrasProyecto3; x++){
                System.out.print("|");
            }
            System.out.print(x + "%");
            if (0 != 100 - graficoBarrasProyecto3){
                for (y = 0; y != 100 - graficoBarrasProyecto3; y++){
                    System.out.print("*");
                }
                System.out.println();
            }else System.out.println();
        }else System.out.println("Lo siento. Aun no se ha creado ningún proyecto.");
    }
    public static void mostrarMisInversiones1(){
        if (nombreProyecto1 == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida1 == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 1: \n" +
            "Nombre: " + nombreProyecto1 + "\n" +
            "Tipo: " + tipoProyecto1 + "\n" +
            "Inversión: " + cantidadInvertida1);
        }
    }
    public static void mostrarMisInversiones2(){
        if (nombreProyecto2 == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida2 == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 2: \n" +
                    "Nombre: " + nombreProyecto2 + "\n" +
                    "Tipo: " + tipoProyecto2 + "\n" +
                    "Inversión: " + cantidadInvertida2);
        }
    }
    public static void mostrarMisInversiones3(){
        if (nombreProyecto3 == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida3 == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 3: \n" +
                    "Nombre: " + nombreProyecto3 + "\n" +
                    "Tipo: " + tipoProyecto3 + "\n" +
                    "Inversión: " + cantidadInvertida3);
        }
    }
    public static void mostrarMisInversiones4(){
        if (nombreProyecto1 == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida4 == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 1: \n" +
                    "Nombre: " + nombreProyecto1 + "\n" +
                    "Tipo: " + tipoProyecto1 + "\n" +
                    "Inversión: " + cantidadInvertida4);
        }
    }
    public static void mostrarMisInversiones5(){
        if (nombreProyecto2 == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida5 == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 2: \n" +
                    "Nombre: " + nombreProyecto2 + "\n" +
                    "Tipo: " + tipoProyecto2 + "\n" +
                    "Inversión: " + cantidadInvertida5);
        }
    }
    public static void mostrarMisInversiones6(){
        if (nombreProyecto3 == null) System.out.println("Lo siento. Aun no se ha creado este proyecto.");
        else if (cantidadInvertida6 == 0) System.out.println("Lo siento. Aun no has invertido en este proyecto.");
        else {
            System.out.println("Proyecto 3: \n" +
                    "Nombre: " + nombreProyecto3 + "\n" +
                    "Tipo: " + tipoProyecto3 + "\n" +
                    "Inversión: " + cantidadInvertida6);
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
    public static boolean validacion(){
        System.out.print("Usuario: ");
        usuario = ss();
        System.out.print("Contraseña: ");
        contrasena = ss();

        if (validarCredenciales(usuario, contrasena)) {
            System.out.println("Inicio de sesión exitoso.");
            return false;
        } else {
            System.out.println("Credenciales incorrectas. Intenta nuevamente.");
            return true;
        }
    }
    public static void cambiarUsuarioGestor(){
        System.out.print("Contraseña: ");
        respuesta1 = ss();
        if (respuesta1.equals(GESTOR_CONTRASENA)) {
            System.out.print("Usuario nuevo: ");
            GESTOR_USUARIO = ss();
            salirDeMenu();
        }
    }
    public static void cambiarContrasenaGestor() {
        System.out.print("Contraseña actual: ");
        respuesta1 = ss();
        if (respuesta1.equals(GESTOR_CONTRASENA)) {
            System.out.print("Contraseña nueva: ");
            GESTOR_CONTRASENA = ss();
            salirDeMenu();
        }
    }
    public static void mostrarUsuarioContrasenaGestor() {
        System.out.println("Usuario: " + GESTOR_USUARIO + "\n" +
                "Contraseña: " + GESTOR_CONTRASENA);
    }
    public static void error(){
        System.out.println("Opción no válida. Inténtalo de nuevo.");
    }
    public static void cambiarUsuarioInversor1(){
        System.out.print("Contraseña: ");
        respuesta1 = ss();
        if (respuesta1.equals(INVERSOR1_CONTRASENA)) {
            System.out.print("Usuario nuevo: ");
            INVERSOR1_USUARIO = ss();
            salirDeMenu();
        }
    }
    public static void cambiarContrasenaInversor1(){
        System.out.print("Contraseña actual: ");
        respuesta1 = ss();
        if (respuesta1.equals(INVERSOR1_CONTRASENA)) {
            System.out.print("Contraseña nueva: ");
            INVERSOR1_CONTRASENA = ss();
            salirDeMenu();
        }
    }
    public static void mostrarUsuarioContrasenaInversor1() {
        System.out.println("Usuario: " + INVERSOR1_USUARIO + "\n" +
                "Contraseña: " + INVERSOR1_CONTRASENA);
    }
    public static void cambiarUsuarioInversor2() {
        System.out.print("Contraseña: ");
        respuesta1 = ss();
        if (respuesta1.equals(INVERSOR2_CONTRASENA)) {
            System.out.print("Usuario nuevo: ");
            INVERSOR2_USUARIO = ss();
            salirDeMenu();
        }
    }
    public static void cambiarContrasenaInversor2(){
        System.out.print("Contraseña actual: ");
        respuesta1 = ss();
        if (respuesta1.equals(INVERSOR2_CONTRASENA)) {
            System.out.print("Contraseña nueva: ");
            INVERSOR2_CONTRASENA = ss();
            salirDeMenu();
        }
    }
    public static void mostrarUsuarioContrasenaInversor2() {
        System.out.println("Usuario: " + INVERSOR2_USUARIO + "\n" +
                "Contraseña: " + INVERSOR2_CONTRASENA);
        salirDeMenu();
    }
}
