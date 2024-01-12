package funciones;
import static funciones.Funciones.*;
public class Utilidades {
    /**
     * Esta funcion sirve para comparar dos contraseñas, las cuales tienen que ser iguales.
     * @param contrasena
     * @param contrasena2
     * @return contrasena, contrasena2
     */
    public static boolean contrasenasIguales(String contrasena, String contrasena2){
        if (contrasena.equals(contrasena2)){
            return true;
        }
        return false;
    }
    /**
     * Esta función sirve para crear nuestra propia contraseña donde podremos usar cualquier tipo de caracteres.
     * @param contrasena
     * @return contrasena
     */
    public static boolean validarContrasena(String contrasena){
        char[] mayusculas={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        char[] minusculas={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] numeros={'1','2','3','4','5','6','7','8','9','0'};
        char caracterMay, caracterMin,caracterNumero;
        boolean mayuscula=false, minuscula=false;
        if (contrasena.length()>=8){
            if (contrasena.contains("@")||contrasena.contains("-")||contrasena.contains("_")||contrasena.contains("*")||contrasena.contains("+")
                    ||contrasena.contains(".")||contrasena.contains(",")||contrasena.contains("&")) {
                for (int i = 0; i < contrasena.length(); i++) {
                    caracterMay=contrasena.charAt(i);
                    for (int j = 0; j < mayusculas.length; j++) {
                        if(caracterMay==mayusculas[j]){
                            mayuscula=true;
                            break;
                        }
                    }
                }
                if (mayuscula){
                    for (int i = 0; i < contrasena.length(); i++) {
                        caracterMin=contrasena.charAt(i);
                        for (int j = 0; j < minusculas.length; j++) {
                            if(caracterMin==minusculas[j]){
                                minuscula=true;
                                break;
                            }
                        }
                    }
                }
                if(minuscula) {
                    for (int i = 0; i < contrasena.length(); i++) {
                        caracterNumero = contrasena.charAt(i);
                        for (int j = 0; j < numeros.length; j++) {
                            if (caracterNumero == numeros[j]) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
