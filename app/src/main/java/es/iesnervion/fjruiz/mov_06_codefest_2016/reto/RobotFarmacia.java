package es.iesnervion.fjruiz.mov_06_codefest_2016.reto;

import java.util.Collections;
import java.util.Vector;

public class RobotFarmacia {
	private Vector<Integer> valores=new Vector<>(1,1);
	private int distanciaOptima;
    private int posicionOptima;

	//Aquí guardaremos las distancias que recorre el robot en cada posición
	private Vector<Integer> distancias=new Vector<>(1,1);

	private int distanciaRecorrida;
	
	public RobotFarmacia(Vector<Integer> valores){
        this.valores=valores;
        //Tomamos el máximo del vector para poder coger todas las posiciones
        for(int j = 0; j<=Collections.max(valores); j++){
            distanciaOptima=j;
            distanciaRecorrida=distanciaOptima;
            for(int i=0;i<valores.size();i++){
                distanciaRecorrida=distanciaRecorrida+Math.abs(valores.elementAt(i)-distanciaOptima)*2;
            }
            distanciaRecorrida=distanciaRecorrida+distanciaOptima;
            distancias.add(distanciaRecorrida);
        }
        distanciaOptima=Collections.min(distancias);
        posicionOptima=distancias.indexOf(distanciaOptima);
	}

	public int getDistanciaOptima(){
        return distanciaOptima;
	}
    public int getPosicionOptima(){
        return posicionOptima;
    }
}
