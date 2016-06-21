package com.example.darri.calculadoralab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String a;
    private String b;
    private char operador;

    private double resultado;

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

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    if (!a.isEmpty()) {
                        a += "0";
                    }
                } else {
                    if (!b.isEmpty()) {
                        b += "0";
                    }
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    a += "1";
                } else {
                    b += "1";
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    a += "1";
                } else {
                    b += "1";
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    a += "1";
                } else {
                    b += "1";
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    a += "1";
                } else {
                    b += "1";
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    a += "1";
                } else {
                    b += "1";
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    a += "1";
                } else {
                    b += "1";
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    a += "1";
                } else {
                    b += "1";
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    a += "1";
                } else {
                    b += "1";
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == ' ') {
                    a += "1";
                } else {
                    b += "1";
                }
            }
        });

    }

}
