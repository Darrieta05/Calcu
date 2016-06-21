package com.example.darri.calculadoralab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private String a;
    private String b;
    private char operador;

    private double resultado;

    private EditText txtOperacion;

    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private Button btnClear;
    private Button btnDividir;
    private Button btnPor;
    private Button btnMenos;
    private Button btnMas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = "";
        b = "";
        operador = ' ';

        txtOperacion = (EditText) findViewById(R.id.edit);
        Button btn0 = (Button) findViewById(R.id.cero);
        Button btn1 = (Button) findViewById(R.id.uno);
        Button btn2 = (Button) findViewById(R.id.dos);
        Button btn3 = (Button) findViewById(R.id.tres);
        Button btn4 = (Button) findViewById(R.id.cuatro);
        Button btn5 = (Button) findViewById(R.id.cinco);
        Button btn6 = (Button) findViewById(R.id.seis);
        Button btn7 = (Button) findViewById(R.id.siete);
        Button btn8 = (Button) findViewById(R.id.ocho);
        Button btn9 = (Button) findViewById(R.id.nueve);

        iniciarBotonNumero(btn0, "0");
        iniciarBotonNumero(btn1, "1");
        iniciarBotonNumero(btn2, "2");
        iniciarBotonNumero(btn3, "3");
        iniciarBotonNumero(btn4, "4");
        iniciarBotonNumero(btn5, "5");
        iniciarBotonNumero(btn6, "6");
        iniciarBotonNumero(btn7, "7");
        iniciarBotonNumero(btn8, "8");
        iniciarBotonNumero(btn9, "9");

        Button btnDividir = (Button) findViewById(R.id.divide);
        Button btnMultiplicar = (Button) findViewById(R.id.por);
        Button btnRestar = (Button) findViewById(R.id.menos);
        Button btnSumar = (Button) findViewById(R.id.mas);

        iniciarBotonOperador(btnDividir, '/');
        iniciarBotonOperador(btnMultiplicar, 'x');
        iniciarBotonOperador(btnRestar, '-');
        iniciarBotonOperador(btnSumar, '+');
    }

    protected void iniciarBotonNumero(Button btnAhora, final String numero) {
        btnAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    a += numero;
                    txtOperacion.setText(a);
                } else {
                    b += numero;
                    txtOperacion.setText(a + operador + b);
                }
            }
        });
    }

    protected void iniciarBotonOperador(Button btnAhora, final char letra) {
        btnAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador = letra;
                String ahora = txtOperacion.getText().toString();
                txtOperacion.setText(ahora + operador);
            }
        });
    }

}
