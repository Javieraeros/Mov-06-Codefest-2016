package es.iesnervion.fjruiz.mov_06_codefest_2016.reto3;

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

public class Reto3 extends Fragment implements View.OnClickListener{

    private OnFragmentInteractionListener mListener;
    private EditText numero;
    private TextView resultado;
    private Button calcular;

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

        calcular=(Button) v.findViewById(R.id.botonReto3);
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
        if(!numero.getText().toString().equals("")) {
            Factores f = new Factores(Integer.parseInt(numero.getText().toString()));
            resultado.setText(String.valueOf(f.getResultado()));
        }else{

        }
    }
}
