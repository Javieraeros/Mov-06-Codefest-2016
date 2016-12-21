package es.iesnervion.fjruiz.mov_06_codefest_2016.reto4;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

import es.iesnervion.fjruiz.mov_06_codefest_2016.OnFragmentInteractionListener;
import es.iesnervion.fjruiz.mov_06_codefest_2016.R;


/**
 * ToDo No me gusta que solo pueda borrar el último, preguntar
 * En un edit text el usuario insertará el peso, y en otro edit text el precio
 * Podrá borrar el último introducido.Separaremos los valores por comas, y al presionar el botón de aclcular
 * mostrará el peso total de la mochila y el precio total
 */
public class Reto4 extends Fragment implements Button.OnClickListener {

    private double pesoD,precioD;
    private Vector<Double> vectorPeso,vectorPrecio;
    private OnFragmentInteractionListener mListener;
    private EditText peso,precio;
    private TextView listapeso,listaprecio,resultadoPeso,resultadoPrecio;
    private Button botonCalcular,botonAñadir,borrarUltimo;

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

        peso=(EditText) v.findViewById(R.id.txtPeso);
        precio=(EditText) v.findViewById(R.id.txtPrecio);

        vectorPeso=new Vector<>(10,1);
        vectorPrecio=new Vector<>(10,1);

        listapeso=(TextView) v.findViewById(R.id.listaPeso);
        listaprecio=(TextView) v.findViewById(R.id.listaPrecio);
        resultadoPeso=(TextView) v.findViewById(R.id.resultadoPeso);
        resultadoPrecio=(TextView) v.findViewById(R.id.resultadoPrecio);

        botonAñadir=(Button) v.findViewById(R.id.añadir);
        botonAñadir.setOnClickListener(this);
        botonCalcular=(Button) v.findViewById(R.id.calcularMochila);
        botonCalcular.setOnClickListener(this);
        borrarUltimo=(Button) v.findViewById(R.id.borrarUltimo);
        borrarUltimo.setOnClickListener(this);

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
        switch (v.getId()){
            case R.id.añadir:
                if(!peso.getText().toString().equals("") && !precio.getText().toString().equals("") ){
                    try {
                        pesoD = Double.parseDouble(peso.getText().toString());
                        precioD = Double.parseDouble(precio.getText().toString());
                        vectorPeso.add(pesoD);
                        vectorPrecio.add(precioD);
                        //Vaciamos los editTexts
                        peso.setText("");
                        precio.setText("");
                        //Añadimos al array de arriba
                        listapeso.setText(listapeso.getText() + "" + pesoD + "\n");
                        listaprecio.setText(listaprecio.getText() + "" + precioD + "\n");
                    }catch (NumberFormatException e){
                        Toast toast=Toast.makeText(v.getContext(),"Introduce datos correctos", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }

                }else{
                    Toast toast=Toast.makeText(v.getContext(),"Falta algún dato.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }
                break;

            case R.id.calcularMochila:
                if(vectorPeso.size()>0){
                    double[][] datos=new double[vectorPrecio.size()][2];
                    double[][] mochila=new double[vectorPrecio.size()][2];
                    for(int i=0;i<vectorPrecio.size();i++){
                        datos[i][0]=vectorPeso.elementAt(i);
                        datos[i][1]=vectorPrecio.elementAt(i);
                    }
                    ProblemaMochila miProblema=new ProblemaMochila(datos,mochila);
                    resultadoPeso.setText(getString(R.string.pesoParametro,miProblema.getPesoMochila()));
                    resultadoPrecio.setText(getString(R.string.precioParametro,miProblema.getPrecioMochila()));
                }else{
                    Toast toast=Toast.makeText(v.getContext(),"Introduce al menos un dato", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }

                break;

            case R.id.borrarUltimo:
                //Removemos los elementos del vector
                if(vectorPeso.size()>0){
                    vectorPeso.removeElementAt(vectorPeso.size()-1);
                    vectorPrecio.removeElementAt(vectorPrecio.size()-1);

                    //Generamos las cadenas que vamos a mostrar en la lista de pesos y precios
                    String cadenaPeso="";
                    String cadenaPrecio="";

                    for(int i=0;i<vectorPeso.size();i++){
                        cadenaPeso+=vectorPeso.elementAt(i)+"\n";
                        cadenaPrecio+=vectorPrecio.elementAt(i)+"\n";
                    }
                    //las asignamos a los correpsondientes textviews
                    listapeso.setText(cadenaPeso);
                    listaprecio.setText(cadenaPrecio);
                }else{

                    Toast toast=Toast.makeText(v.getContext(),"No hay ningún elemento que borrar", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }

                break;
        }
    }
}
