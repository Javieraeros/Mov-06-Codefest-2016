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

import es.iesnervion.fjruiz.mov_06_codefest_2016.reto.RobotFarmacia;

public class Seleccionador extends FragmentActivity {

    private TextView farmacia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccionador);

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

    public void leer(View v){
        Intent brows=new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.dropbox.com/s/s2wjs7av8a8j8hc/Retos%20codeFEST%2020161110%20v2.0.pdf?dl=0"));
        startActivity(brows);

    }

}
