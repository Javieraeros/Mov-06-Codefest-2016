package layout;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import es.iesnervion.fjruiz.mov_06_codefest_2016.*;

import es.iesnervion.fjruiz.mov_06_codefest_2016.R;


public class Maestro extends Fragment implements View.OnClickListener {

    private OnFragmentInteractionListener mListener;
    private Button reto1,reto2,reto3,reto4,reto5,leerReto;

    public Maestro() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_maestro, container, false);
        reto1=(Button) v.findViewById(R.id.reto1);
        reto1.setOnClickListener(this);
        reto2=(Button) v.findViewById(R.id.reto2);
        reto3=(Button) v.findViewById(R.id.reto3);
        reto4=(Button) v.findViewById(R.id.reto4);
        reto5=(Button) v.findViewById(R.id.reto5);
        leerReto=(Button) v.findViewById(R.id.leerRetos);
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
        mListener.onFragmentInteraction(v.getId());
    }
}
