package es.iesnervion.fjruiz.mov_06_codefest_2016.reto3;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;

//ToDo
/*
Intentar usar varios hilos para la operación: laFunción, de tal forma que el número que paso en Params
lo dividamos entre el número de hilos posibles del teléfono,para que así tarde menos tiempo.
 */

public class Factores extends AsyncTask<Integer,Boolean,Integer> {

    private RecibeResultado enviador;

	public Factores(Fragment miContexto){
        if (miContexto instanceof RecibeResultado) {
            enviador = (RecibeResultado) miContexto;
        } else {
            throw new RuntimeException(miContexto.toString()
                    + " must implement RecibeResultado");
        }
    }

    private boolean laFuncion(int num) {
        boolean devuelve = false;
        if (num - 5 == 1 || (num / 3 == 1 && num % 3 == 0)) {
            devuelve = true;
        } else {
            if (num % 3 == 0) {
                devuelve = laFuncion(num / 3);
            }
            if (!devuelve) {
                if (num - 5 > 0) {
                    devuelve = laFuncion(num - 5);
                }
            }
        }
        return devuelve;
    }


    @Override
    protected Integer doInBackground(Integer... params) {
        Integer resultado = 0;
        for (int i = params[0]; i > 0; i--) {
            if (laFuncion(i)) {
                resultado++;
            }
        }
        return resultado;
    }

    @Override
    protected void onPostExecute(Integer result) {
     enviador.onResultReceived(result);
    }

}
