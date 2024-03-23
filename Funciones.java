package aed;

class Funciones {
    int cuadrado(int x) {
        // COMPLETAR
        int res = x*x;
        return res;
    }

    double distancia(double x, double y) {
        // COMPLETAR
        double d = Math.sqrt(x*x + y*y);
        return d;
    }

    boolean esPar(int n) {
        // COMPLETAR
        boolean res = false;
        if (n%2 == 0) {
            return true;
        }
        return res;
    }

    boolean esBisiesto(int n) {
        // COMPLETAR
        if (n % 4 == 0 && n % 100 != 0) {  
           return true; 
        }
        else if (n % 400 == 0) {
            return true;
        }

        else {
            return false;
        }
    }

    int factorialIterativo(int n) {
        // COMPLETAR
        int res = 1;
        if ( n == 0) {
          return 1;   
        }
        else {
        for (int i = n; i > 0 && i <= n; i--) {
           res *= i; 
        }
        }
        return res;
    }

    int factorialRecursivo(int n) {
        // COMPLETAR
        int res = 1;
        if ( n == 0) {
            return 1;
        }
        else {
            res *= n * factorialIterativo(n-1);
        }
        return res;
    }

    boolean esPrimo(int n) {
        // COMPLETAR
        int count = 0;
        for (int i = 1; i <= n; i++ ) {
            if (n % i == 0) {
                count += 1;
            }
            }
        if (count == 2) {
            return true;
        }
        else {
            return false;
        }
    }

    int sumatoria(int[] numeros) {
        // COMPLETAR
        int res = 0;
        for (int i = 0; i < numeros.length; i++){
            res += numeros[i];
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        // COMPLETAR
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] == buscado) {
                return i;
            }
            }
        
        return -1;
    }

    boolean tienePrimo(int[] numeros) {
        // COMPLETAR
        for (int i = 0; i < numeros.length; i++){
            if (esPrimo(numeros[i]) == true){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        // COMPLETAR
        boolean res = true;
        for (int i = 0; i < numeros.length; i++){
            if (numeros[i] % 2 != 0) {
                res = false;
            }
            }
        
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        // COMPLETAR
        boolean res =true;
        for ( int i = 0; i < s1.length(); i++){
            if (s1.length() > s2.length() || s1.charAt(i) != s2.charAt(i)){
                res = false;
            }
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        // COMPLETAR
        boolean res =true;
        int c = s2.length()-1;
        if (s1.length() > s2.length()){
            res = false;
        }
        else {
        for (int i = s1.length()-1; i >= 0; i--){
            if(s1.charAt(i) == s2.charAt(c)){
                c-=1;
            }
            else {
                res = false;
            }
        }
    }
        return res;
    }
}
