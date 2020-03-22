package br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.R;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.constants.Constantes;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.model.Calculadora;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView telaTextView;
    private Button tecla_0Button;
    private Button tecla_1Button;
    private Button tecla_2Button;
    private Button tecla_3Button;
    private Button tecla_4Button;
    private Button tecla_5Button;
    private Button tecla_6Button;
    private Button tecla_7Button;
    private Button tecla_8Button;
    private Button tecla_9Button;

    private Button tecla_cButton;
    private Button tecla_ceButton;
    private Button tecla_igualButton;

    private Button tecla_adicaoButton;
    private Button tecla_subtracaoButton;
    private Button tecla_divisaoButton;
    private Button tecla_multiplicacaoButton;
    private Button tecla_potenciaButton;
    private Button tecla_pontoButton;

    /*Outros*/
    private Calculadora c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        /*Atribuindo views*/
        telaTextView = findViewById(R.id.textview_lcd);
        tecla_0Button = findViewById(R.id.button_zero);
        tecla_1Button = findViewById(R.id.button_um);
        tecla_2Button = findViewById(R.id.button_dois);
        tecla_3Button = findViewById(R.id.button_tres);
        tecla_4Button = findViewById(R.id.button_quatro);
        tecla_5Button = findViewById(R.id.button_cinco);
        tecla_6Button = findViewById(R.id.button_seis);
        tecla_7Button = findViewById(R.id.button_sete);
        tecla_8Button = findViewById(R.id.button_oito);
        tecla_9Button = findViewById(R.id.button_nove);

        tecla_cButton  = findViewById(R.id.button_c);
        tecla_ceButton = findViewById(R.id.button_ce);
        tecla_igualButton = findViewById(R.id.button_igual);

        tecla_adicaoButton = findViewById(R.id.button_adicao);
        tecla_subtracaoButton = findViewById(R.id.button_subtracao);
        tecla_divisaoButton = findViewById(R.id.button_divisao);
        tecla_multiplicacaoButton = findViewById(R.id.button_multiplicacao);
        tecla_potenciaButton = findViewById(R.id.button_potencia);
        tecla_pontoButton = findViewById(R.id.button_ponto);

        /*Comportamento on click*/
        tecla_0Button.setOnClickListener(this);
        tecla_1Button.setOnClickListener(this);
        tecla_2Button.setOnClickListener(this);
        tecla_3Button.setOnClickListener(this);
        tecla_4Button.setOnClickListener(this);
        tecla_5Button.setOnClickListener(this);
        tecla_6Button.setOnClickListener(this);
        tecla_7Button.setOnClickListener(this);
        tecla_8Button.setOnClickListener(this);
        tecla_9Button.setOnClickListener(this);

        tecla_cButton.setOnClickListener(this);
        tecla_ceButton.setOnClickListener(this);
        tecla_igualButton.setOnClickListener(this);

        tecla_adicaoButton.setOnClickListener(this);
        tecla_subtracaoButton.setOnClickListener(this);
        tecla_divisaoButton.setOnClickListener(this);
        tecla_multiplicacaoButton.setOnClickListener(this);
        tecla_potenciaButton.setOnClickListener(this);
        tecla_pontoButton.setOnClickListener(this);
        
        c = inicializar();
    }

    @Override
    public void onClick(View v) {
        try {
            switch(v.getId()){
                case R.id.button_c:
                    clear(c);
                    break;

                case R.id.button_igual:
                    telaTextView.setText(geraResultado());
                    break;

                case R.id.button_adicao:
                    c.calcular(Constantes.ADICAO, Float.parseFloat(telaTextView.getText().toString()));
                    telaTextView.setText("");
                    break;

                case R.id.button_subtracao:
                    c.calcular(Constantes.SUBTRACAO, Float.parseFloat(telaTextView.getText().toString()));
                    telaTextView.setText("");
                    break;

                case R.id.button_divisao:
                    c.calcular(Constantes.DIVISAO, Float.parseFloat(telaTextView.getText().toString()));
                    telaTextView.setText("");
                    break;

                case R.id.button_multiplicacao:
                    c.calcular(Constantes.MULTIPLICACAO, Float.parseFloat(telaTextView.getText().toString()));
                    telaTextView.setText("");
                    break;

                case R.id.button_ponto:
                    telaTextView.append(".");
                    break;

                case R.id.button_ce:
                    telaTextView.setText("");
                    break;

                case R.id.button_potencia:
                    c.calcular(Constantes.POTENCIACAO, Float.parseFloat(telaTextView.getText().toString()));
                    telaTextView.setText("");
                    break;

                default:
                    Button b = (Button)v;
                    telaTextView.append(b.getText().toString());
                    break;
            }
        }catch (Exception e){
            telaTextView.setText("ERR");
        }
    }

    private String geraResultado() {
        float a = 0;
        String result = "";

        a = c.calcular(Constantes.NULO, Float.parseFloat(telaTextView.getText().toString()));

        result = String.valueOf(a);

        return result;
    }

    private Calculadora inicializar() {
        Calculadora c = Calculadora.getInstance();
        telaTextView.setText("");

        return c;
    }

    private void clear(Calculadora c) {
        c.calcular(0, 0);
        telaTextView.setText("");
    }
}
