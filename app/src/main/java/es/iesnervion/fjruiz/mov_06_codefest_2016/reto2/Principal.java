package es.iesnervion.fjruiz.mov_06_codefest_2016.reto2;

public class Principal {

	public static void main(String[] args) {
		Reloj mireloj=new Reloj();

		int resultado= mireloj.consumoTotal(0,0,0,10);
        int resultado2= mireloj.consumoTotal(0,0,0,40);
        int resultado3= mireloj.consumoTotal(0,0,14,20);
        int resultado4= mireloj.consumoTotal(365,0,0,0); //876700800

		System.out.println(resultado);
        System.out.println(resultado2);
        System.out.println(resultado3);
        System.out.println(resultado4);

	}

}
