package reto5;

import java.util.Arrays;

public class principal {
	public static void main(String[] args) {
		int[][] relaciones={{10, 11},
				{13, 1},
				{6, 13},
				{8, 10},
				{5, 3},
				{12, 5},
				{15, 12},
				{8, 2},
				{10, 4},
				{12, 3},
				{10, 6},
				{12, 6},
				{8, 6},
				{7, 8},
				{14, 10},
				{9, 13},
				{13, 10},
				{8, 12},
				{13, 12}};
		int[] resultado=new int[15];
		boolean[] ciudades=new boolean[15];
		boolean[] almacenes=new boolean[15];
		int totalCiudades=0;
		
		
		for(int i=0;i<15;i++){
			ciudades[i]=false;
			almacenes[i]=false;
		}
		
		 final int n = 15;
	        for (int i = 0; i < Math.pow(2, n); i++) {
	            String bin = Integer.toBinaryString(i);
	            while (bin.length() < n)
	                bin = "0" + bin;
	            char[] chars = bin.toCharArray();
	            boolean[] boolArray = new boolean[n];
	            for (int j = 0; j < chars.length; j++) {
	                boolArray[j] = chars[j] == '0' ? true : false;
	            }
	            //System.out.println(Arrays.toString(boolArray));
	            for(int m=0;m<15;m++){

		            almacenes[m]=boolArray[m];
		            //System.out.println(almacenes[m]);
	            }
	            
	            for(int j=0;j<15;j++){
	            	if(almacenes[j]){
	            		ciudades[j]=true;
	            		for(int k=0;k<15;k++){
	            			if(relaciones[k][0]==j+1){
	            				ciudades[k]=true;
	            			}
	            			if(relaciones[k][1]==j+1){
	            				ciudades[k]=true;
	            			}
	            		}//fin for array doble
	            		totalCiudades=0;
	            		for(int l=0;l<15;l++){
		            		if(ciudades[l]){
		            			totalCiudades++;
		            		}
	            		}
	            		if(totalCiudades==15){
	            			System.out.println(Arrays.toString(almacenes));
	            		}
	            	}
	            }
	        }
		System.out.println("fin");
	}
}
