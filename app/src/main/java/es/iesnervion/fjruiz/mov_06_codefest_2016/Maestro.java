package es.iesnervion.fjruiz.mov_06_codefest_2016;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import es.iesnervion.fjruiz.mov_06_codefest_2016.*;

import es.iesnervion.fjruiz.mov_06_codefest_2016.R;


public class Maestro extends ListFragment  {

    private OnFragmentInteractionListener mListener;

    public Maestro() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String[] cadenas={"Leer Retos",
                "Reto 1",
                "Reto 2",
                "Reto 3",
                "Reto 4",
                "Reto 5"};
        setListAdapter(new ArrayRetos<String>(getContext(), R.layout.row,R.id.TextoRetos,cadenas));
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
    public void onListItemClick(ListView l, View v, int position, long id) {
        mListener.onFragmentInteraction(position);
    }
}
