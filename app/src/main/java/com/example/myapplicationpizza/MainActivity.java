package com.example.myapplicationpizza;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spiner;
    private EditText nbr_pi;
    private RadioButton p1, p2, p4, p6;
    private CheckBox ch1, ch2;
    private Button btn;
    private TextView tv_result;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spiner = findViewById(R.id.spinner);
        nbr_pi = findViewById(R.id.nbr_pizza);
        p1 = findViewById(R.id.radioButton);
        p2 = findViewById(R.id.radioButton2);
        p4 = findViewById(R.id.radioButton3);
        p6 = findViewById(R.id.radioButton4);
        ch1 = findViewById(R.id.checkBox);
        ch2 = findViewById(R.id.checkBox2);
        btn = findViewById(R.id.button2);
        tv_result = findViewById(R.id.textView5);

        //ajouter les valeurs dans notre spiner

        List<String> list = new ArrayList<String>();
        list.add("Margarita");
        list.add("Quatre saisson");
        list.add("Americain");
        list.add("Fruis de mer");

        //cree un arrayAdapter
        ArrayAdapter<String> lst = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, list);
        spiner.setAdapter(lst);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int v_sp =0;
                int nbr_per;
                int nbr_pizza;
                int fr = 0;
                int bois = 0;
                int prix_tt;


                //on va tester la valeur de spiiner

                if (spiner.getSelectedItemId()==0){
                    v_sp = 12;
                }else
                    if (spiner.getSelectedItemId()==1){
                        v_sp=15;
                    }else
                        if (spiner.getSelectedItemId()==2){
                            v_sp=20;
                        }
                        else
                            v_sp = 40;
                //tester le nombre de perssone
                if (p1.isChecked()){
                    nbr_per=1;
                }else
                    if (p2.isChecked()){
                        nbr_per = 2;
                    }else
                        if (p4.isChecked()){
                            nbr_per = 4;
                        }else
                            nbr_per = 6;

                //tester le checkbox
                if (ch1.isChecked()){
                    bois=6;
                }
                if (ch2.isChecked()){
                    fr = 10;
                }
                nbr_pizza = Integer.parseInt(nbr_pi.getText().toString());
                prix_tt = v_sp * nbr_pizza * nbr_per + bois * nbr_per + fr * nbr_pizza ;

                //affichage de prix
                tv_result.setText("Le Prix Totale est :"+prix_tt+"DH");
            }
        });
    }
}