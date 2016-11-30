package es.iesnervion.fjruiz.mov_06_codefest_2016.reto4;

//ToDo
/*
Vamos
 */

public class Principal {

	public static double relacion(int peso,int precio){
		double resultado;
		resultado=precio/peso;
		return resultado;
	}
	
	public static void main(String[] args) {
		int[][] prueba={{7000,150000},{200,7000},{620,40000},{3440,3000},
		{220,2000},
		{1777,10000},
		{800,3000},
		{950,3000},
		{2300,8000},
		{1250,150000},
		{1987,30000},
		{5000,699099},
		{2300,100050},
		{800,10000},
		{5300,20000},
		{4300,30000},
		{2100,1500}};
		double[] coeficientes = new double[prueba.length];
		double[][] mochila=new double[prueba.length][2];
		for(int i=0;i<prueba.length;i++){
			coeficientes[i]=relacion(prueba[0][i],prueba[1][i]);
		}
		
		for(int i=0;i<coeficientes.length;i++){
			double max=0.00;
			if(coeficientes[i]>max){
				
			}
		}
		
	}

}
