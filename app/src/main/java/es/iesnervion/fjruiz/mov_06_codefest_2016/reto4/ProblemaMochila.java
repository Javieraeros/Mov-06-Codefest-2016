package es.iesnervion.fjruiz.mov_06_codefest_2016.reto4;


public class ProblemaMochila{

    private double[][] datos;
    private double[] coeficientes;
    private double[][] mochila;


    //region Geters y Setters
    public double[][] getDatos() {
        return datos;
    }

    public void setDatos(double[][] datos) {
        this.datos = datos;
    }

    public double[] getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(double[] coeficientes) {
        this.coeficientes = coeficientes;
    }

    public double[][] getMochila() {
        return mochila;
    }

    public void setMochila(double[][] mochila) {
        this.mochila = mochila;
    }

    //endregion

    //region Constructor

    public ProblemaMochila(double[][] datos,double[][] mochila){
        this.datos=datos;
        this.mochila=mochila;
        this.coeficientes=new double[datos.length];
        generaCoeficientes();
        ordenaDatosCoeficientes(coeficientes, datos);
        int j=0;
        for(int i=0;i<coeficientes.length;i++){
            if((getPesoMochila()+datos[i][0])<8000.00){
                mochila[j][0]=datos[i][0];
                mochila[j][1]=datos[i][1];
                j++;
            }
        }
    }

    //endregion

    //region métodos
    public  double relacion(double peso,double precio){
        double resultado;
        //uso el precio dos veces, porque debemos comparar la relación cantidad/precio por el precio del objeto.
        resultado=precio*precio/peso;
        return resultado;
    }

    public void generaCoeficientes(){
        for(int i=0;i<datos.length;i++){
            //precio*precio/peso
            coeficientes[i]=datos[i][1]*datos[i][1]/datos[i][0];
        }
    }

    public  double getPesoMochila(){
        double resultado=0;
        for (int i=0;i<mochila.length;i++){
            resultado=resultado+mochila[i][0];
        }
        return resultado;
    }

    public  double getPrecioMochila(){
        double resultado=0;
        for (int i=0;i<mochila.length;i++){
            resultado=resultado+mochila[i][1];
        }
        return resultado;
    }

    /**
     * Método que ordena los coeficientes de mayor a menor, así como
     * la mochila siguiendo esos coeficientes.
     * @param coeficientes
     * @param mochila
     */
    public void ordenaDatosCoeficientes(double[] coeficientes,double[][] datos){
        double aux,aux2;
        for(int i=0;i<coeficientes.length-1;i++){
            for(int j=coeficientes.length-1;j>i;j--){
                if(coeficientes[j]>coeficientes[j-1] ||
                        (coeficientes[j]==coeficientes[j-1] && datos[j][1]>datos[j-1][1]) ||
                        (coeficientes[j]==coeficientes[j-1] && datos[j][1]==datos[j-1][1] &&
                                datos[j][0]>datos[j-1][0])){
                    //Ordenamos el array de coeficientes, y a continuación,la mochila
                    aux=coeficientes[j];
                    coeficientes[j]=coeficientes[j-1];
                    coeficientes[j-1]=aux;

                    //Peso
                    aux=datos[j][0];
                    aux2=datos[j-1][0];
                    datos[j][0]=aux2;
                    datos[j-1][0]=aux;

                    //Precio
                    aux=datos[j][1];
                    aux2=datos[j-1][1];
                    datos[j][1]=aux2;
                    datos[j-1][1]=aux;
                }
            }

        }
    }

    //endregion

}
