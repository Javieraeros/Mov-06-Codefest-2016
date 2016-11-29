package es.iesnervion.fjruiz.mov_06_codefest_2016.reto2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import es.iesnervion.fjruiz.mov_06_codefest_2016.OnFragmentInteractionListener;
import es.iesnervion.fjruiz.mov_06_codefest_2016.R;

public class Reto2 extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;
    private EditText dias,horas,minutos,segundos;
    private TextView error,resultado;
    private Button calcular;
    public Reto2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_reto2, container, false);
        
        dias=(EditText) v.findViewById(R.id.txtdias);
        horas=(EditText) v.findViewById(R.id.txthoras);
        minutos=(EditText) v.findViewById(R.id.txtminutos);
        segundos=(EditText) v.findViewById(R.id.txtsegundos);

        error=(TextView) v.findViewById(R.id.Error);
        resultado=(TextView) v.findViewById(R.id.ResultadoReto2);

        calcular=(Button) v.findViewById(R.id.calcular);
        calcular.setOnClickListener(this);
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
        int diasInt,horasInt,minutosInt,segundosInt;

        resultado.setText("");

        if(dias.getText().toString().equals("") || horas.getText().toString().equals("")  ||
                minutos.getText().toString().equals("")  || segundos.getText().toString().equals("") ){
            error.setVisibility(View.VISIBLE);
            error.setText(R.string.errorReto2Vacio);

        } else {
            diasInt=Integer.parseInt(dias.getText().toString());
            horasInt=Integer.parseInt(horas.getText().toString());
            minutosInt=Integer.parseInt(minutos.getText().toString());
            segundosInt=Integer.parseInt(segundos.getText().toString());
            if (!validaFecha(diasInt, horasInt, minutosInt, segundosInt)) {
                error.setVisibility(View.VISIBLE);
                error.setText(R.string.errorReto2);
            } else {
                error.setVisibility(View.INVISIBLE);
                Reloj miReloj = new Reloj();
                resultado.setText(String.valueOf(miReloj.consumoTotal(diasInt, horasInt, minutosInt, segundosInt)));
            }
        }
    }

    /**
     * Método que comprueba si una fecha es válida
     * Para hacerlo más legible, lo dividiré en varios ifs,lo que puede ralentizar el funcionamiento
     * pero trátandose de uan app de prueba y aprendizaje, no nos fijaremos en esos detalles
     * @param dias
     * @param horas
     * @param minutos
     * @param segundos
     * @return
     */
    public boolean validaFecha(int dias,int horas,int minutos,int segundos){
        boolean resultado=true;
        if(dias<0){
            resultado=false;
        } else
        if(horas>23 || horas<0){
            resultado=false;
        } else
        if(minutos<0 || minutos>60){
            resultado=false;
        } else
        if(segundos<0 || segundos>60){
            resultado=false;
        }

        return resultado;
    }

}
