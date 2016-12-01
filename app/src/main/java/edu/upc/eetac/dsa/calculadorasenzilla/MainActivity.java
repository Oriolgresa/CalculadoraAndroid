package edu.upc.eetac.dsa.calculadorasenzilla;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    Integer numero1, numero2;
    Double resultatOperacio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickResultat(View v) {
        RadioButton botoSuma = (RadioButton) findViewById(R.id.rbSuma);
        RadioButton botoResta = (RadioButton) findViewById(R.id.rbResta);
        RadioButton botoMult = (RadioButton) findViewById(R.id.rbMult);
        RadioButton botoDiv = (RadioButton) findViewById(R.id.rbDiv);
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView resultat = (TextView) findViewById(R.id.resultat);

        try {
            numero1 = Integer.parseInt(num1.getText().toString());
            numero2 = Integer.parseInt(num2.getText().toString());

            Context context = getApplicationContext();
            CharSequence text = "Operació resolta";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();


            if (botoSuma.isChecked()) {
                resultatOperacio = (double) numero1 + (double) numero2;
            } else if (botoResta.isChecked()) {
                resultatOperacio = (double) numero1 - (double) numero2;
            } else if (botoDiv.isChecked()) {
                resultatOperacio = (double) numero1 / (double) numero2;
            } else if (botoMult.isChecked()) {
                resultatOperacio = (double) numero1 * (double) numero2;
            }
            DecimalFormat format = new DecimalFormat("#.###");
            String res = format.format(resultatOperacio);
            resultat.setText(res.toString());
        }
        catch (Exception e) {

            Context context = getApplicationContext();
            CharSequence text2 = "Cal indicar els dos valors numèrics";
            int duration = Toast.LENGTH_SHORT;

            Toast toast2 = Toast.makeText(context, text2, duration);
            toast2.show();

        }

    }

    public void onClickEsborra(View v) {
        numero1 = 0;
        numero2 = 0;
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView resultat = (TextView) findViewById(R.id.resultat);

        num1.setText("0");
        num2.setText("0");
        resultat.setText("0.0");
    }

    public void onRadioButtonClicked(View v) {
        // Is the button now checked?
        boolean checked = ((RadioButton) v).isChecked();
        // Check which radio button was clicked
        switch (v.getId()) {
            case R.id.rbSuma:
                if (checked)
                    break;
            case R.id.rbResta:
                if (checked)
                    break;
            case R.id.rbMult:
                if (checked)
                    break;
            case R.id.rbDiv:
                if (checked)
                    break;
        }
    }
}
