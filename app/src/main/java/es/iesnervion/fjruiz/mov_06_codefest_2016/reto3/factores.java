package reto3;

public class factores {
	public int numerosPosibles(int maximo){
		int resultado=0;
		for(int i=0;i<=maximo;i++){
			if(combinacion(i)){
				resultado++;
			}
		}
		return resultado;
	}
	//Modificar
	public boolean combinacion(int comprobar){
		boolean resultado=false;
		for(int l=0;l<comprobar;l++){
			for(int k=1;k<comprobar;k++){
				for(int i=1;i<comprobar;i++){
					for(int j=0;j<comprobar;j++){

						if(comprobar==((i+5*j)*3*k)+5*l || comprobar==(i+5*j)){
							resultado=true;
						}
					}
				}
			}
		}
		
		return resultado;
	}
	
}
