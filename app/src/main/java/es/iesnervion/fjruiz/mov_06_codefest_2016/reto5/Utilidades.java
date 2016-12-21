package es.iesnervion.fjruiz.mov_06_codefest_2016.reto5;

import java.util.Vector;
/**
 * Created by javi on 18/12/16.
 */

public class Utilidades {

    private boolean[] almacenesResultado;
    private int resultado;

    public void calculaResultado(int[][] relaciones){
        int numeroCiudades=maximoArrayDoble(relaciones);
        //Puesto que el número de almacenes va a ser igual o inferior al número de ciudades,
        //empezamos diciendo que es igual al número de ciudades
        this.resultado=numeroCiudades;
        boolean[] ciudades=new boolean[numeroCiudades];
        boolean[] almacenes=new boolean[numeroCiudades];

        this.almacenesResultado=new boolean[numeroCiudades];

        arrayFalse(almacenesResultado);
        for(int i=0;i<Math.pow(2,numeroCiudades);i++){
            almacenes=toBooleanArray(i, numeroCiudades);
            arrayFalse(ciudades);
            for(int j=0;j<numeroCiudades;j++){

                if(almacenes[j]){

                    for(int k=0;k<relaciones.length;k++){
                        //Buscamos ahora las relaciones, ponemos j+1 porque
                        //j empieza en 0, y las ciudades en 1
                        if(relaciones[k][0]==j+1){
                            ciudades[relaciones[k][1]-1]=true;
                        }
                        if(relaciones[k][1]==j+1){
                            ciudades[relaciones[k][0]-1]=true;
                        }
                    }

                    //Si el almacen está en la ciudad,la ciudad tiene servicio
                    ciudades[j]=true;

                }

            }

            int totalCiudades=cuentaTrue(ciudades);

            if(totalCiudades==numeroCiudades){
                int numeroAlmacenes=cuentaTrue(almacenes);

                if(numeroAlmacenes<resultado){
                    resultado=numeroAlmacenes;
                    almacenesResultado=almacenes;
                }
            }
        }
    }

    public boolean[] getAlmacenesResultado(){
        return almacenesResultado;
    }
    public int getResultado(){
        return resultado;
    }

    public Vector<Integer> getAlmacenesNumeros(){
        Vector<Integer> resultado=new Vector<>(1,1);
        for(int i=0;i<almacenesResultado.length;i++){
            if(almacenesResultado[i]){
                resultado.add(i+1);
            }
        }
        return resultado;
    }

    /**
     * Método que convierte un número a binario, usando para ello un array de booleanos, tal que
     * boolean[0] se corresponde con el primer valor del número en binario
     * @param numero: Lo que queires convertir a binario
     * @param tamanyoArray: tamaño total del array que quieres recibir
     * @return
     */
    public boolean[] toBooleanArray(int numero,int tamanyoArray){
        boolean[] devolver=new boolean[tamanyoArray];
        String cadenaNumeroBinario=Integer.toBinaryString(numero);
        char[] arrayNumeroBinario=cadenaNumeroBinario.toCharArray();

        for(int i=0;i<arrayNumeroBinario.length;i++){
            if(arrayNumeroBinario[arrayNumeroBinario.length-1-i]=='1'){
                devolver[i]=true;
            }else{
                devolver[i]=false;
            }
        }
        for(int j=arrayNumeroBinario.length;j<tamanyoArray;j++){
            devolver[j]=false;
        }
        return devolver;
    }

    public int maximoArrayDoble(int[][] array){
        int resultado=0;
        for(int i=0;i<array.length;i++){
            for (int j=0;j<array[0].length;j++){
                if(array[i][j]>resultado){
                    resultado=array[i][j];
                }
            }
        }
        return resultado;
    }

    public void arrayFalse(boolean[] array){
        for(int i=0;i<array.length;i++){
            array[i]=false;
        }
    }

    public int cuentaTrue(boolean[] array){
        int resultado=0;
        for(int i=0;i<array.length;i++){
            if(array[i]){
                resultado++;
            }
        }
        return resultado;
    }

}
