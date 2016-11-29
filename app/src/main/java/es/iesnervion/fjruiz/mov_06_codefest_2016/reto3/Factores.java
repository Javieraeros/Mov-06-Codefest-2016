package es.iesnervion.fjruiz.mov_06_codefest_2016.reto3;

public class Factores {

    private int resultado;
	public Factores(int numero){
        resultado = 0;
        for (int i = numero; i > 0; i--) {
            if (laFuncion(i)) {
                resultado++;
            }
        }
    }

    private boolean laFuncion(int num) {
        boolean devuelve = false;
        if (num - 5 == 1 || (num / 3 == 1 && num % 3 == 0)) {
            devuelve = true;
        } else {
            if (num % 3 == 0) {
                devuelve = laFuncion(num / 3);
            }
            if (!devuelve) {
                if (num - 5 > 0) {
                    devuelve = laFuncion(num - 5);
                }
            }
        }
        return devuelve;
    }

    public int getResultado(){
        return resultado;
    }
	
}
