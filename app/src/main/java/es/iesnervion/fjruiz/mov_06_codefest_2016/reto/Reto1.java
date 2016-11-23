package es.iesnervion.fjruiz.mov_06_codefest_2016.reto;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import es.iesnervion.fjruiz.mov_06_codefest_2016.OnFragmentInteractionListener;
import es.iesnervion.fjruiz.mov_06_codefest_2016.R;

public class Reto1 extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    private EditText datos;
    private TextView distancia;
    private TextView posicion;
    private Button botonCalcular;

    public Reto1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_reto1, container, false);

        datos=(EditText) v.findViewById(R.id.numerosReto1);
        distancia=(TextView) v.findViewById(R.id.distanciaRecorridaResultado);
        posicion=(TextView) v.findViewById(R.id.posicionOptimaResultado);
        botonCalcular=(Button) v.findViewById(R.id.calcular);
        botonCalcular.setOnClickListener(this);
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
        String datosCadena=datos.getText().toString();

        List<String> valoresCadena= Arrays.asList(datosCadena.split(","));
        Vector<Integer> valores=new Vector<>(1,1);
        for(int i=0;i<valoresCadena.size();i++){
            valores.add(Integer.parseInt(valoresCadena.get(i)));
        }
        RobotFarmacia miRobot=new RobotFarmacia(valores);
        distancia.setText(miRobot.getDistanciaOptima()+" ");
        posicion.setText(miRobot.getPosicionOptima()+" ");
    }
}
