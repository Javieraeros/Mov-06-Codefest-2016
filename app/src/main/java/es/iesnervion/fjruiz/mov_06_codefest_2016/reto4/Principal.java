package es.iesnervion.fjruiz.mov_06_codefest_2016.reto4;

//ToDo
/*
Vamos
 */

public class Principal {

	public static void main(String[] args) {
		//Columna 0 peso. columna 1 precio
		double[][] prueba={{7000,150000},
				{200,7000},
				{620,40000},
				{3440,3000},
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

		/*double[][] prueba={{7000,1500000},
				{1000,70000},
				{400,400000},
				{650,300000},
				{500,200000}
				};*/

		/*double[][] prueba={{5000,900},
				{100,750},
				{3000,300},
				{300,50},
				{1500,500},
				{500,400},
				{900,10},
				{800,8}};*/
		double[][] mochila=new double[prueba.length][2];

		ProblemaMochila miProblemita=new ProblemaMochila(prueba, mochila);
		System.out.println(miProblemita.getPrecioMochila());

	}

}
