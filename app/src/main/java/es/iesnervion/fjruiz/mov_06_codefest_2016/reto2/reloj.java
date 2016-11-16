package reto2;

public class reloj {
	private int segundo1;
	private int segundo2;
	private int minuto1;
	private int minuto2;
	private int hora1;
	private int hora2;
	
	public int consumo(int numero){
		int resultado=0;
		switch (numero){
			case 0:
				resultado=6;
				break;
			case 1:
				resultado=2;
				break;
			case 2:
				resultado=5;
				break;
			case 3:
				resultado=5;
				break;
			case 4:
				resultado=4;
				break;
			case 5:
				resultado=5;
				break;
			case 6:
				resultado=6;
				break;
			case 7:
				resultado=3;
				break;
			case 8:
				resultado=7;
				break;
			case 9:
				resultado=6;
				break;
			
		}
		
		return resultado;
	}
	//Acabar
	public int consumoTotal(int horas,int minutos,int seguntos){
		int resultado=0;
		if(horas!=0){
			for(int k=0;k<horas;k++){
				for(int j=0;j<60;j++){
					for(int i=0;i<60;i++){
						resultado=resultado+consumo(i/10)+consumo(i%10);
						resultado=resultado+consumo(j/10)+consumo(j%10);
						resultado=resultado+consumo(k/10)+consumo(k%10);
					}
				}
			}
		}
		
		return resultado;
	}
	
}
