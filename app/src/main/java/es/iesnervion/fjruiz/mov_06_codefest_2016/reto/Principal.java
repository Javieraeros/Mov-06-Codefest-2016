package es.iesnervion.fjruiz.mov_06_codefest_2016.reto;


import java.util.Vector;

public class Principal {
	public static void main(String[] args){
		//int[] valores={1,3,4,8,8,10,10,14,15,16,20,21,22,22,23,24,24,27,31,39};
		Vector<Integer> valores=new Vector<Integer>();
		valores.add(1);
		valores.add(3);
		valores.add(4);
		valores.add(8);
		valores.add(8);
		valores.add(10);
		valores.add(10);
		valores.add(14);
		valores.add(15);
		valores.add(16);
		valores.add(20);
		valores.add(21);
		valores.add(22);
		valores.add(23);
		valores.add(24);
		valores.add(27);
		valores.add(31);
		valores.add(39);
		RobotFarmacia pr=new RobotFarmacia(valores);
		System.out.println(pr.getPosicionOptima());
	}
	
}
