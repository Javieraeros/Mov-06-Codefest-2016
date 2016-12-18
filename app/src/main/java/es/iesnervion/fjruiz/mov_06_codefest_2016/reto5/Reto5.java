package es.iesnervion.fjruiz.mov_06_codefest_2016.reto5;

import android.content.Context;
import android.net.Uri;
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
import es.iesnervion.fjruiz.mov_06_codefest_2016.reto4.ProblemaMochila;


public class Reto5 extends Fragment implements View.OnClickListener{


    private int ciudadOrigen,ciudadDestino,contador;
    private int[][] relaciones;
    private Vector<Integer> vectorOrigen,vectorDestino;
    private EditText ciudadIni,ciudadFin;
    private TextView listaCiudadesOrin,listaCiudadesDest,resultadoCantidad,resultadoCiudades;
    private Button botonCalcular,botonAñadir,borrarUltimo;

    public Reto5() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_reto5, container, false);

        vectorOrigen=new Vector<>(1,1);
        vectorDestino=new Vector<>(1,1);

        ciudadIni=(EditText) v.findViewById(R.id.txtIni);
        ciudadFin=(EditText) v.findViewById(R.id.txtFin);

        listaCiudadesOrin=(TextView) v.findViewById(R.id.listaIni);
        listaCiudadesDest=(TextView) v.findViewById(R.id.listaFin);
        resultadoCantidad=(TextView) v.findViewById(R.id.resultadoCantidad);
        resultadoCiudades=(TextView) v.findViewById(R.id.resultadoCiudades);

        botonAñadir=(Button) v.findViewById(R.id.añadirCiudad);
        botonAñadir.setOnClickListener(this);
        botonCalcular=(Button) v.findViewById(R.id.calcularCiudades);
        botonCalcular.setOnClickListener(this);
        borrarUltimo=(Button) v.findViewById(R.id.borrarCiudad);
        borrarUltimo.setOnClickListener(this);

        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v) {
        //Determinaremos que botón se ha pulsado por v.getId()
        switch (v.getId()){
            case R.id.añadirCiudad:
                if(!ciudadIni.getText().toString().equals("") && !ciudadFin.getText().toString().equals("") ){
                    try {
                        ciudadOrigen = Integer.parseInt(ciudadIni.getText().toString());
                        ciudadDestino = Integer.parseInt(ciudadFin.getText().toString());

                        //Añadimos al array
                        vectorOrigen.add(ciudadOrigen);
                        vectorDestino.add(ciudadDestino);

                        //Vaciamos los editTexts
                        ciudadIni.setText("");
                        ciudadFin.setText("");
                        //Añadimos al array de arriba
                        listaCiudadesOrin.setText(listaCiudadesOrin.getText() + "" + ciudadOrigen + "\n");
                        listaCiudadesDest.setText(listaCiudadesDest.getText() + "" + ciudadDestino + "\n");
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

            case R.id.calcularCiudades:
                if(vectorOrigen.size()>0){
                    relaciones=new int[vectorOrigen.size()][2];
                    for(int i=0;i<vectorOrigen.size();i++){
                        relaciones[i][0]=vectorOrigen.elementAt(i);
                        relaciones[i][1]=vectorDestino.elementAt(i);
                    }
                    Utilidades miUtil=new Utilidades();
                    miUtil.calculaResultado(relaciones);

                    resultadoCantidad.setText(getString(R.string.almacenesParametro, miUtil.getResultado()));
                    resultadoCiudades.setText(miUtil.getAlmacenesNumeros().toString());
                }else{
                    Toast toast=Toast.makeText(v.getContext(),"Introduce al menos un dato", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }

                break;

            case R.id.borrarCiudad:
                //Removemos los elementos del vector
                //ToDo
                if(vectorOrigen.size()>0){
                    vectorOrigen.removeElementAt(vectorOrigen.size()-1);
                    vectorDestino.removeElementAt(vectorDestino.size()-1);

                    //Generamos las cadenas que vamos a mostrar en la lista de pesos y precios
                    String cadenaOrigen="";
                    String cadenaDestino="";

                    for(int i=0;i<vectorOrigen.size();i++){
                        cadenaOrigen+=vectorOrigen.elementAt(i)+"\n";
                        cadenaDestino+=vectorDestino.elementAt(i)+"\n";
                    }
                    //las asignamos a los correpsondientes textviews
                    listaCiudadesOrin.setText(cadenaOrigen);
                    listaCiudadesDest.setText(cadenaDestino);
                }else{

                    Toast toast=Toast.makeText(v.getContext(),"No hay ningún elemento que borrar", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                }

                break;
        }
    }
}
