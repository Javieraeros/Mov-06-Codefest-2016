package es.iesnervion.fjruiz.mov_06_codefest_2016.reto2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
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
        if(dias.getText()==null || horas.getText()==null || minutos.getText()==null || segundos.getText()==null){
            error.setText("Error, uno de los campos no se ha rellenado!");
        } else if(Integer.parseInt(dias.getText().toString())<0){
            //// TODO: 24/11/16
            /*
            Validar  los numeros de dias,horas minutos y segundos.
            En caso de que no lo sean, marcar en rojo el campo del número incorrecto, o borrarlo.
             */
        }
    }

}
