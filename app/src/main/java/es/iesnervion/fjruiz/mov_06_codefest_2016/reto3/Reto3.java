package es.iesnervion.fjruiz.mov_06_codefest_2016.reto3;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Vector;

import es.iesnervion.fjruiz.mov_06_codefest_2016.OnFragmentInteractionListener;
import es.iesnervion.fjruiz.mov_06_codefest_2016.R;

public class Reto3 extends Fragment implements View.OnClickListener,RecibeResultado{

    private OnFragmentInteractionListener mListener;
    private EditText numero;
    private TextView resultado,resultado2,resultado3,resultado4;
    private Button calcular,calcular2;

    private int contador,resultadoN;

    public Reto3() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_reto3,container,false);
        numero=(EditText) v.findViewById(R.id.numeroReto3);
        resultado=(TextView) v.findViewById(R.id.ResultadoReto3);
        resultado2=(TextView) v.findViewById(R.id.ResultadoReto32);
        resultado3=(TextView) v.findViewById(R.id.ResultadoReto33);
        resultado4=(TextView) v.findViewById(R.id.ResultadoReto34);

        calcular=(Button) v.findViewById(R.id.botonReto3);
        calcular.setOnClickListener(this);
        calcular2=(Button) v.findViewById(R.id.botonReto3Hilos);
        calcular2.setOnClickListener(this);
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        resultado.setVisibility(View.VISIBLE);
        resultado2.setVisibility(View.VISIBLE);
        resultado3.setVisibility(View.VISIBLE);
        resultado4.setVisibility(View.VISIBLE);
        if(v.getId()==R.id.botonReto3) {
            if (!numero.getText().toString().equals("")) {
                Factores f = new Factores(this);
                f.execute(Integer.parseInt(numero.getText().toString()));
                resultado.setTextColor(Color.BLACK);
            } else {
                resultado.setTextColor(Color.RED);
                resultado.setText(R.string.errrorReto3Vacio);
            }
        }else{
            if (!numero.getText().toString().equals("")) {

                int miNumero=Integer.parseInt(numero.getText().toString());
                Vector<Integer> divisor=new Vector<>(5,0);
                divisor.add(miNumero);
                divisor.add(miNumero*94/100);
                divisor.add(miNumero*86/100);
                divisor.add(miNumero*76/100);
                divisor.add(0);

                FactoresHilos f1 = new FactoresHilos(this);
                FactoresHilos f2 = new FactoresHilos(this);
                FactoresHilos f3 = new FactoresHilos(this);
                FactoresHilos f4 = new FactoresHilos(this);
                f1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,divisor.elementAt(0),divisor.elementAt(1));
                f2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,divisor.elementAt(1),divisor.elementAt(2));
                f3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,divisor.elementAt(2),divisor.elementAt(3));
                f4.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,divisor.elementAt(3),divisor.elementAt(4));
                resultado.setTextColor(Color.BLACK);
            } else {
                resultado.setTextColor(Color.RED);
                resultado.setText(R.string.errrorReto3Vacio);
            }
        }
    }


    @Override
    public void onResultReceived(Integer resultadoNumero) {
        contador++;
        resultadoN=resultadoNumero;
        switch (contador){
            case 1:
                resultado.setText(String.valueOf(resultadoN));
                resultadoN=0;
                break;
            case 2:
                resultado2.setText(String.valueOf(resultadoN));
                resultadoN=0;
                break;

            case 3:
                resultado3.setText(String.valueOf(resultadoN));
                resultadoN=0;
                break;

            case 4:
                resultado4.setText(String.valueOf(resultadoN));
                resultadoN=0;
                contador=0;
                break;
        }
    }
}
