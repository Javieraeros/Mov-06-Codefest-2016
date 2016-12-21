package es.iesnervion.fjruiz.mov_06_codefest_2016;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;

import es.iesnervion.fjruiz.mov_06_codefest_2016.reto.Reto1;
import es.iesnervion.fjruiz.mov_06_codefest_2016.reto2.Reto2;
import es.iesnervion.fjruiz.mov_06_codefest_2016.reto3.Reto3;
import es.iesnervion.fjruiz.mov_06_codefest_2016.reto4.Reto4;
import es.iesnervion.fjruiz.mov_06_codefest_2016.reto5.Reto5;

public class Seleccionador extends FragmentActivity implements OnFragmentInteractionListener{
    private boolean estoyEnTablet=false;

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
    }

    @Override
    public void onFragmentInteraction(int id) {
        switch (id){
            case 0:
                Intent browser=new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.dropbox.com/s/s2wjs7av8a8j8hc/Retos%20codeFEST%2020161110%20v2.0.pdf?dl=0"));
                startActivity(browser);
                break;
            case 1:
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
            case 2:
                if(estoyEnTablet){
                    //ToDo
                }else{
                    Reto2 reto2Fragment= new Reto2();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.activity_seleccionador, reto2Fragment);
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();
                }
                break;
            case 3:
                if(estoyEnTablet){
                    //ToDo
                }else{
                    Reto3 reto3Fragment= new Reto3();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.activity_seleccionador, reto3Fragment);
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();
                }
                break;
            case 4:
                if(estoyEnTablet){
                    //ToDo
                }else {
                    Reto4 reto4Fragment = new Reto4();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.activity_seleccionador, reto4Fragment);
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();
                }
                break;
            case 5:
                if(estoyEnTablet){
                    //ToDo
                }else {
                    Reto5 reto5Fragment = new Reto5();
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                    // Replace whatever is in the fragment_container view with this fragment,
                    // and add the transaction to the back stack so the user can navigate back
                    transaction.replace(R.id.activity_seleccionador, reto5Fragment);
                    transaction.addToBackStack(null);

                    // Commit the transaction
                    transaction.commit();
                }
                break;

        }
    }
}
