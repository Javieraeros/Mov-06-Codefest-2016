package es.iesnervion.fjruiz.mov_06_codefest_2016.reto2;

public class Reloj {
	
	private int consumo(int numero){
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
	public int consumoTotal(int dias,int horas,int minutos,int segundos){
		int resultado=0;

		//Calculamos el consumo de días completos
		if(dias!=0){
			for(int k=0;k<24;k++){
				for(int j=0;j<60;j++){
					for(int i=0;i<60;i++){
						resultado=resultado+consumo(i/10)+consumo(i%10);
						resultado=resultado+consumo(j/10)+consumo(j%10);
						resultado=resultado+consumo(k/10)+consumo(k%10);
					}
				}
			}
            resultado=resultado*dias;
		}

        //Calculamos el consumo de las horas que no pertenezcan a un día completo
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

        //Consumo de los minutos de la hora incompleta
        //Vamos reduciendo los bucles puesto que ya no nos hacen falta, pero muy a tener en cuenta:
        //Cambiamos las variables i,j,k por los valores reales de horas,minutos y segundos, para que
        //Nos calcule bien el consumo del reloj en cada momento
        if(minutos!=0){
            for(int j=0;j<minutos;j++){
                for(int i=0;i<60;i++){
                    resultado=resultado+consumo(i/10)+consumo(i%10);
                    resultado=resultado+consumo(j/10)+consumo(j%10);
                    resultado=resultado+consumo(horas/10)+consumo(horas%10);
                }
            }

        }

        //consumo de los segundos del minuto incompleto
        if(segundos!=0){
            for(int i=0;i<segundos;i++){
                resultado=resultado+consumo(i/10)+consumo(i%10);
                resultado=resultado+consumo(minutos/10)+consumo(minutos%10);
                resultado=resultado+consumo(horas/10)+consumo(horas%10);
            }

        }
		
		return resultado;
	}
	
}
