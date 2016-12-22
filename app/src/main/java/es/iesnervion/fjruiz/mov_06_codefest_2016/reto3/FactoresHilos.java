package es.iesnervion.fjruiz.mov_06_codefest_2016.reto3;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by fjruiz on 21/12/16.
 */

public class FactoresHilos extends AsyncTask<Integer,Boolean,Integer> {

    private RecibeResultado enviador;

    public FactoresHilos(Fragment miContexto){
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
        for (int i = params[0]; i > params[1]; i--) {
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
