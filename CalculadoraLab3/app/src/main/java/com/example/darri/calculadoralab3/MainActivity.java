package com.example.darri.calculadoralab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private StringBuilder sb;
    private char operador;
    
    private ArrayList<String> numeros;
    private ArrayDeque<Double> pila;
    
    private boolean decimal;

    private EditText txtOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb = new StringBuilder();
        numeros = new ArrayList<String>();
        pila = new ArrayDeque<Double>();
        
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
        Button btnFlotante = (Button) findViewById(R.id.punto);

        iniciarBotonNumero(btn0, '0');
        iniciarBotonNumero(btn1, '1');
        iniciarBotonNumero(btn2, '2');
        iniciarBotonNumero(btn3, '3');
        iniciarBotonNumero(btn4, '4');
        iniciarBotonNumero(btn5, '5');
        iniciarBotonNumero(btn6, '6');
        iniciarBotonNumero(btn7, '7');
        iniciarBotonNumero(btn8, '8');
        iniciarBotonNumero(btn9, '9');
        iniciarBotonFlotante(btnFlotante);

        Button btnDividir = (Button) findViewById(R.id.divide);
        Button btnMultiplicar = (Button) findViewById(R.id.por);
        Button btnRestar = (Button) findViewById(R.id.menos);
        Button btnSumar = (Button) findViewById(R.id.mas);

        iniciarBotonOperador(btnDividir, '/');
        iniciarBotonOperador(btnMultiplicar, 'x');
        iniciarBotonOperador(btnRestar, '-');
        iniciarBotonOperador(btnSumar, '+');
        
        Button btnLimpiar = (Button) findViewById(R.id.clear);
        iniciarBotonLimpiar(btnLimpiar);
        
        Button btnIgual = (Button) findViewById(R.id.igual);
    }

    protected void iniciarBotonNumero(Button btnAhora, final char numero) {
        btnAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operador == '/' && numero == '0') {
                    String ahora = "No se puede dividir entre cero";
                } else {
                    sb.append(numero);
                    txtOperacion.setText(sb.toString());
                }
            }
        });
    }

    protected void iniciarBotonOperador(Button btnAhora, final char letra) {
        btnAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char letra = sb.charAt(sb.length() - 1);
                if (letra == '/' || letra == '*' || letra == '-' || letra == '+') {
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(letra);
                txtOperacion.setText(sb.toString());
                operador = letra;
                decimal = false;
            }
        });
    }

    protected void iniciarBotonFlotante(Button btnAhora) {
        btnAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!decimal) {
                    sb.append('.');
                    decimal = true;
                }
            }
        });
    }
    
    protected void iniciarBotonLimpiar(Button btnAhora) {
        btnAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int largo = sb.length();
                if (largo != 0) {
                    sb.deleteCharAt(largo - 1);
                    txtOperacion.setText(sb.toString());
                }
            }
        });
    }
    
    protected void iniciarBotonIgual(Button btnAhora) {
        btnAhora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char letra = sb.charAt(sb.length() - 1);
                if (letra != '/' && letra != '*' && letra != '-' && letra != '+') {
                    evaluar(sb.toString());
                }
            }
        });
    }
    
    protected static double sumar(double num1, double num2) {
        return num1 + num2;
    }
    
    protected static double restar(double num1, double num2) {
        return num1 - num2;
    }
    
    protected static double multiplicar(double num1, double num2) {
        return num1 * num2;
    }
    
    protected static double dividir(double num1, double num2) {
        return num1 / num2;
    }
    
    protected static double calcular(double num1, double num2, char operador) {
        double valor = 0.0;
        switch (operador) {
            case '/':
                valor = dividir(num1, num2);
                break;
            case 'x':
                valor = multiplicar(num1, num2);
                break;
            case '-':
                valor = restar(num1, num2);
                break;
            case '+':
                valor = sumar(num1, num2);
                break;
        }
        return valor;
    }
    
    private static String obtenerNumero(String expresion, int inicio) {
        String numero = "";
        int i = inicio;
        char ahora = expresion.charAt(i);
        while (ahora != '/' && ahora != '*' && ahora != '-' && ahora != '+') {
            numero += ahora;
            i++;
            if (i == expresion.length()) {
                break;
            }
            ahora = expresion.charAt(i);
        }
        return numero;
    }
    
    private void npr(String operacion) {
        int largo = operacion.length();
        if (largo != 0) {
            int i = 0;
            char mayor = ' ';
            char menor = ' ';
            while (i < largo) {
                String a = obtenerNumero(operacion, i);
                numeros.add(a);
                if (numeros.size() > 1) {
                    if (mayor != ' ') {
                        numeros.add(mayor + "");
                        mayor = ' ';
                    }
                }
                i += a.length();
                if (i < largo) {
                    char ahora = operacion.charAt(i);
                    if (ahora == '/' || ahora == '*') {
                        mayor = ahora;
                    } else {
                        if (menor != ' ') {
                            numeros.add(menor + "");
                            menor = ' ';
                        }
                        menor = ahora;
                    }
                    i++;
                }
            }
            if (mayor != ' ') {
                numeros.add(mayor + "");
            }
            if (menor != ' ') {
                numeros.add(menor + "");
            }
        }
    }
    
    protected void evaluar(String operacion) {
        npr(operacion);
        if (numeros != null) {
            int largo = numeros.size();
            for (int i = 0; i < largo; i++) {
                String ahora = numeros.get(i);
                char letra = ahora.charAt(0);
                if (letra == '/' || letra == '*' || letra == '-' || letra == '+') {
                    double a = pila.removeLast();
                    double b = pila.removeLast();
                    pila.add(calcular(a, b, letra));
                } else {
                    pila.add(Double.parseDouble(ahora));
                }
            }
            String resultado = pila.getLast() + "";
        }
    }
    
}
