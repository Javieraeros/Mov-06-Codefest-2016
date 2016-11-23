package es.iesnervion.fjruiz.mov_06_codefest_2016;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Vector;

import es.iesnervion.fjruiz.mov_06_codefest_2016.reto.Reto1;
import es.iesnervion.fjruiz.mov_06_codefest_2016.reto.RobotFarmacia;
import layout.Maestro;

public class Seleccionador extends FragmentActivity implements OnFragmentInteractionListener{
    private boolean estoyEnTablet=false;
    private TextView farmacia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionador);

        if(findViewById(R.id.activity_seleccionador)!=null){
            if(savedInstanceState==null){

                // Create an instance of ExampleFragment
                Maestro master = new Maestro();

                // In case this activity was started with special instructions from an Intent,
                // pass the Intent's extras to the fragment as arguments
                master.setArguments(getIntent().getExtras());

                // Add the fragment to the 'fragment_container' FrameLayout
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.activity_seleccionador,master).commit();
            }
        }else{
            estoyEnTablet=true;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        Vector<Integer> valores=new Vector<>(1,1);
        /*valores.add(1);
        valores.add(3);
        valores.add(4);
        valores.add(8);
        valores.add(8);
        valores.add(10);
        valores.add(10);
        valores.add(14);
        valores.add(15);
        valores.add(16);
        valores.add(20);
        valores.add(21);
        valores.add(22);
        valores.add(22);
        valores.add(23);
        valores.add(24);
        valores.add(24);
        valores.add(27);
        valores.add(31);
        valores.add(39);*/
        valores.add(2);
        valores.add(3);
        valores.add(5);
        valores.add(8);
        valores.add(9);
        valores.add(9);
        /*valores.add(1);
        valores.add(3);*/
        RobotFarmacia miRobot=new RobotFarmacia(valores);
        //farmacia.setText(miRobot.getPosicionOptima()+" ");
    }

    @Override
    public void onFragmentInteraction(int id) {
        switch (id){
            case R.id.reto1:
                if(estoyEnTablet){
                    //ToDo
                }else{
                    Reto1 reto1Fragment= new Reto1();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.activity_seleccionador, reto1Fragment);
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();
                }
                break;
            case R.id.reto2:

                break;
            case R.id.reto3:

                break;
            case R.id.reto4:

                break;
            case R.id.reto5:

                break;
            case R.id.leerRetos:
                Intent browser=new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.dropbox.com/s/s2wjs7av8a8j8hc/Retos%20codeFEST%2020161110%20v2.0.pdf?dl=0"));
                startActivity(browser);
                break;
        }
    }
}
