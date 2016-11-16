package es.iesnervion.fjruiz.mov_06_codefest_2016.reto;

public class RobotFarmacia {
	private int[] valores;
	private int posicionOptima;
	private int distanciaRecorrida;
	
	public RobotFarmacia(int[] valores,int posicionOptima){
		distanciaRecorrida=posicionOptima;
		for(int i=0;i<valores.length;i++){
			distanciaRecorrida=distanciaRecorrida+Math.abs(valores[i]-posicionOptima)*2;
		}
		distanciaRecorrida=distanciaRecorrida+posicionOptima;
	}
	public int getdistanciaRecorrida(){
		return distanciaRecorrida;
	}
}
