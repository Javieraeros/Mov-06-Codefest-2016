package es.iesnervion.fjruiz.mov_06_codefest_2016.reto4;

import android.content.Context;
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


/**
 * ToDo Textview con el listado de pesos y textview con el listado de precios
 * En un edit text el usuario insertará el peso, y en otro edit text el precio
 * Podrá borrar el último introducido.Separaremos los valores por comas, y al presionar el botón de aclcular
 * mostrará el peso total de la mochila y el precio total
 */
public class Reto4 extends Fragment implements Button.OnClickListener {

    private OnFragmentInteractionListener mListener;
    private EditText peso,precio;
    private TextView lblpeso,lblprecio;
    private Button botonCalcular,botonAnyadir;

    public Reto4() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_reto4, container, false);

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
        //Determinaremos que botón se ha pulsado por v.getId()
    }
}
