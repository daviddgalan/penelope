import java.util.Scanner;
import static funciones.funciones.*;

public class penelope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            inicioSesion();
            opcion = si();
            switch (opcion) {
                case 1: {
                    System.out.println("Bienvenido al sistema de proyectos. Por favor, inicia sesión.");
                    do{
                        System.out.print("Usuario: ");
                        usuario = scanner.nextLine();
                        System.out.print("Contraseña: ");
                        contrasena = scanner.nextLine();

                        if (validarCredenciales(usuario, contrasena)) {
                            System.out.println("Inicio de sesión exitoso.");
                            break;
                        } else {
                            System.out.println("Credenciales incorrectas. Intenta nuevamente.");
                        }
                    }while (true);
                    if (usuario.equals(GESTOR_USUARIO) && contrasena.equals(GESTOR_CONTRASENA)) {
                        do {
                            menuGestor();
                            opcion = si();
                            switch (opcion) {
                                case 1: {
                                    crearProyecto(scanner);
                                    salirDeMenu();
                                    break;
                                }
                                case 2: {
                                    do {
                                        menuDeProyectos();
                                        respuesta6 = si();
                                        switch (respuesta6) {
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
                                    }while (respuesta6 != 4);
                                    break;
                                }
                                case 3: {
                                    do {
                                        menuConfiguracion();
                                        respuesta2 = si();
                                        switch (respuesta2) {
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
                                    } while (respuesta2 != 4);
                                    break;
                                }
                                case 4: break;
                                default: error();
                            }
                        } while (opcion != 4);
                    } else if (usuario.equals(INVERSOR1_USUARIO) && contrasena.equals(INVERSOR1_CONTRASENA)) {
                        do {
                            menuInversor();
                            opcion = si();
                            switch (opcion) {
                                case 1: {
                                    do {
                                        menuDeProyectos();
                                        respuesta6 = si();
                                        switch (respuesta6) {
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
                                    }while (respuesta6 != 4);
                                    break;
                                }
                                case 2: {
                                    do {
                                        menuMisInversiones();
                                        respuesta4 = si();
                                        switch (respuesta4){
                                            case 1: {
                                                do {
                                                    menuDeProyectos();
                                                    respuesta5 = si();
                                                    switch (respuesta5) {
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
                                                }while (respuesta5 != 4);
                                                break;
                                            }
                                            case 2: {
                                                do {
                                                    menuDeProyectos();
                                                    respuesta7 = si();
                                                    switch (respuesta7){
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
                                                }while(respuesta7 != 4);
                                                break;
                                            }
                                            case 3: break;
                                            default: error();
                                        }
                                    }while (respuesta4 != 3);
                                    break;
                                }
                                case 3: {
                                    do {
                                        menuCarteraInversor();
                                        respuesta3 = si();
                                        switch (respuesta3) {
                                            case 1: {
                                                System.out.println(cartera);
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
                                    } while (respuesta3 != 3);
                                    break;
                                }
                                case 4: {
                                    do {
                                        menuConfiguracion();
                                        respuesta2 = si();
                                        switch (respuesta2) {
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
                                    } while (respuesta2 != 4);
                                    break;
                                }
                                case 5: break;
                                default: error();
                            }
                        } while (opcion != 5);
                    } else if (usuario.equals(INVERSOR2_USUARIO) && contrasena.equals(INVERSOR2_CONTRASENA)) {
                        do {
                            menuInversor();
                            opcion = si();
                            switch (opcion) {
                                case 1: {
                                    do {
                                        menuDeProyectos();
                                        respuesta6 = si();
                                        switch (respuesta6) {
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
                                    }while (respuesta6 != 4);
                                    break;
                                }
                                case 2: {
                                    do {
                                        menuMisInversiones();
                                        respuesta4 = si();
                                        switch (respuesta4){
                                            case 1: {
                                                do {
                                                    menuDeProyectos();
                                                    respuesta5 = si();
                                                    switch (respuesta5) {
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
                                                }while (respuesta5 != 4);
                                                break;
                                            }
                                            case 2: {
                                                do {
                                                    menuDeProyectos();
                                                    respuesta7 = si();
                                                    switch (respuesta7){
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
                                                }while(respuesta7 != 4);
                                                break;
                                            }
                                            case 3: break;
                                            default: error();
                                        }
                                    }while (respuesta4 != 3);
                                    break;
                                }
                                case 3: {
                                    do {
                                        menuCarteraInversor();
                                        respuesta3 = si();
                                        switch (respuesta3) {
                                            case 1: {
                                                System.out.println(cartera2);
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
                                    } while (respuesta3 != 3);
                                    break;
                                }
                                case 4: {
                                    do {
                                        menuConfiguracion();
                                        respuesta2 = si();
                                        switch (respuesta2) {
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
                                    } while (respuesta2 != 4);
                                    break;
                                }
                                case 5: break;
                                default: error();
                            }
                        } while (opcion != 5);

                    } else if (usuario.equals(ADMIN_USUARIO) && contrasena.equals(ADMIN_CONTRASENA)) {
                        do {
                            menuAdmin();
                            respuesta8 = si();
                            switch (respuesta8){
                                case 1: {
                                    do {
                                        menuDeProyectos();
                                        respuesta6 = si();
                                        switch (respuesta6) {
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
                                    }while (respuesta6 != 4);
                                    break;
                                }
                                case 2: {
                                    do {
                                    menuDeProyectos();
                                    respuesta8 = si();
                                        switch (respuesta8){
                                            case 1:{
                                                do {
                                                    editarProyectosAdmin();
                                                    respuesta9 = si();
                                                    switch (respuesta9) {
                                                        case 1: {
                                                            System.out.print("Nombre: ");
                                                            nombreProyecto1 = ss();
                                                            break;
                                                        }
                                                        case 2: {
                                                            System.out.print("Descripción: ");
                                                            descripcionProyecto1 = ss();
                                                            break;
                                                        }
                                                        case 3: {
                                                            System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
                                                            tipoProyecto1 = ss();
                                                            break;
                                                        }
                                                        case 4: {
                                                            System.out.print("Cantidad necesaria: ");
                                                            cantidadNecesariaProyecto1 = si();
                                                            break;
                                                        }
                                                        case 5: {
                                                            System.out.print("Cantidad financiada hasta el momento: ");
                                                            cantidadFinanciadaProyecto1 = si();
                                                            break;
                                                        }
                                                        case 6: {
                                                            System.out.print("Fecha inicio: ");
                                                            fechaInicioProyecto1 = ss();
                                                            break;
                                                        }
                                                        case 7: {
                                                            System.out.print("Fecha fin: ");
                                                            fechaFinProyecto1 = ss();
                                                            break;
                                                        }
                                                        case 8: break;
                                                        default: error();
                                                    }
                                                }while (respuesta9 != 8);
                                                break;
                                            }
                                            case 2:{
                                                do {
                                                    editarProyectosAdmin();
                                                    respuesta9 = si();
                                                    switch (respuesta9) {
                                                        case 1: {
                                                            System.out.print("Nombre: ");
                                                            nombreProyecto2 = ss();
                                                            break;
                                                        }
                                                        case 2: {
                                                            System.out.print("Descripción: ");
                                                            descripcionProyecto2 = ss();
                                                            break;
                                                        }
                                                        case 3: {
                                                            System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
                                                            tipoProyecto2 = ss();
                                                            break;
                                                        }
                                                        case 4: {
                                                            System.out.print("Cantidad necesaria: ");
                                                            cantidadNecesariaProyecto2 = si();
                                                            break;
                                                        }
                                                        case 5: {
                                                            System.out.print("Cantidad financiada hasta el momento: ");
                                                            cantidadFinanciadaProyecto2 = si();
                                                            break;
                                                        }
                                                        case 6: {
                                                            System.out.print("Fecha inicio: ");
                                                            fechaInicioProyecto2 = ss();
                                                            break;
                                                        }
                                                        case 7: {
                                                            System.out.print("Fecha fin: ");
                                                            fechaFinProyecto2 = ss();
                                                            break;
                                                        }
                                                        case 8: break;
                                                        default:error();
                                                    }
                                                }while (respuesta9 != 8);
                                            }
                                            case 3: {
                                                do {
                                                    editarProyectosAdmin();
                                                    respuesta9 = si();
                                                    switch (respuesta9) {
                                                        case 1: {
                                                            System.out.print("Nombre: ");
                                                            nombreProyecto3 = ss();
                                                            break;
                                                        }
                                                        case 2: {
                                                            System.out.print("Descripción: ");
                                                            descripcionProyecto3 = ss();
                                                            break;
                                                        }
                                                        case 3: {
                                                            System.out.print("Tipo (préstamo, plusvalía o alquiler): ");
                                                            tipoProyecto3 = ss();
                                                            break;
                                                        }
                                                        case 4: {
                                                            System.out.print("Cantidad necesaria: ");
                                                            cantidadNecesariaProyecto3 = si();
                                                            break;
                                                        }
                                                        case 5: {
                                                            System.out.print("Cantidad financiada hasta el momento: ");
                                                            cantidadFinanciadaProyecto3 = si();
                                                            break;
                                                        }
                                                        case 6: {
                                                            System.out.print("Fecha inicio: ");
                                                            fechaInicioProyecto3 = ss();
                                                            break;
                                                        }
                                                        case 7: {
                                                            System.out.print("Fecha fin: ");
                                                            fechaFinProyecto3 = ss();
                                                            break;
                                                        }
                                                        case 8: break;
                                                        default:error();
                                                    }
                                                }while (respuesta9 != 8);
                                            }
                                            case 4: break;
                                            default: error();
                                        }
                                    }while (respuesta8 != 4);
                                    break;
                                }
                                case 3: {
                                    do {
                                        desbloquearUsuariosAdmin();
                                        respuesta6 = si();
                                        switch (respuesta6){
                                            case 1: {
                                                if (bloquearGestor){
                                                    System.out.print("X para desbloquear a gestor: ");
                                                    respuesta1 = ss();
                                                    if (respuesta1.equalsIgnoreCase("x")) bloquearGestor = false;
                                                    salirDeMenu();
                                                }else{
                                                    System.out.print("X para bloquear a gestor: ");
                                                    respuesta1 = ss();
                                                    if (respuesta1.equalsIgnoreCase("x")) bloquearGestor = true;
                                                    salirDeMenu();
                                                }
                                                break;
                                            }
                                            case 2: {
                                                if (bloquearInversor1){
                                                    System.out.print("X para desbloquear a Inversor1: ");
                                                    respuesta1 = ss();
                                                    if (respuesta1.equalsIgnoreCase("x")) bloquearInversor1 = false;
                                                    salirDeMenu();
                                                }else{
                                                    System.out.print("X para bloquear a Inversor1: ");
                                                    respuesta1 = ss();
                                                    if (respuesta1.equalsIgnoreCase("x")) bloquearInversor1 = true;
                                                    salirDeMenu();
                                                }
                                                break;
                                            }
                                            case 3: {
                                                if (bloquearInversor2){
                                                    System.out.print("X para desbloquear a Inversor2: ");
                                                    respuesta1 = ss();
                                                    if (respuesta1.equalsIgnoreCase("x")) bloquearInversor2 = false;
                                                    salirDeMenu();
                                                }else{
                                                    System.out.print("X para bloquear a Inversor2: ");
                                                    respuesta1 = ss();
                                                    if (respuesta1.equalsIgnoreCase("x")) bloquearInversor2 = true;
                                                    salirDeMenu();
                                                }
                                                break;
                                            }
                                            case 4: break;
                                            default: {
                                                System.out.println("Por favor. Ingrese números solo 1-5.");
                                            }
                                        }
                                    }while (respuesta6 != 4);
                                    break;
                                }
                                case 4: {
                                    do {
                                        menuConfiguracion();
                                        respuesta2 = si();
                                        switch (respuesta2) {
                                            case 1: {
                                                System.out.print("Contraseña: ");
                                                respuesta1 = ss();
                                                if (respuesta1.equals(ADMIN_CONTRASENA)) {
                                                    System.out.print("Usuario nuevo: ");
                                                    ADMIN_USUARIO = ss();
                                                    salirDeMenu();
                                                }
                                                break;
                                            }
                                            case 2: {
                                                System.out.print("Contraseña actual: ");
                                                respuesta1 = ss();
                                                if (respuesta1.equals(ADMIN_CONTRASENA)) {
                                                    System.out.print("Contraseña nueva: ");
                                                    ADMIN_CONTRASENA = ss();
                                                    salirDeMenu();
                                                }
                                                break;
                                            }
                                            case 3: {
                                                System.out.println("Usuario: " + ADMIN_USUARIO + "\n" +
                                                        "Contraseña: " + ADMIN_CONTRASENA);
                                                salirDeMenu();
                                            }
                                            case 4: {
                                                break;
                                            }
                                            default: {
                                                System.out.println("Por favor. Ingrese números solo 1-4.");
                                            }
                                        }
                                    } while (respuesta2 != 4);
                                    break;
                                }
                                case 5: break;
                                default:{
                                    System.out.println("Por favor. Ingrese números solo 1-5.");
                                }
                            }

                        }while(respuesta8 != 5);
                    }
                    break;
                }
                case 2: {
                    System.out.println("Sesión cerrada. ¡Hasta luego!");
                    return;
                }
                default:
                    System.out.println("Por favor, ingrese los números 1-2.");
            }
        }while (opcion != 2);
    }
}