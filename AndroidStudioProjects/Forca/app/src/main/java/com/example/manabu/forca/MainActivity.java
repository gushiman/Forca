package com.example.manabu.forca;

import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] strPalavra = new String[10];
    private String[] strPalavraFacil = new String[10];
    private boolean facil = true;
    private String strInicial = "";
    private String palavraFormatada = "";
    private StringBuffer stringBufferPalavraExibida;
    private String palavraExibida =  "";
    private int tamanhoP;
    private int tamanhoPF;
    private int erros = 0;
    private boolean acertou = false;
    private boolean Pedro = false;
    private boolean Sofia = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txtViewDificuldade = (TextView) findViewById(R.id.txtview_dificuldade);
        final RadioGroup rdGroupDificuldade = (RadioGroup) findViewById(R.id.rg_dificuldade);
        final RadioButton rbFacil = (RadioButton) findViewById(R.id.rb_facil);
        final RadioButton rbDificil = (RadioButton) findViewById(R.id.rb_dificil);

        final LinearLayout aM = (LinearLayout) findViewById(R.id.lilayout_am);
        final LinearLayout nZ = (LinearLayout) findViewById(R.id.lilayout_nz);

        final ImageView imgviewJogar = (ImageView) findViewById(R.id.imgview_jogar);
        final ImageView imgviewForca = (ImageView) findViewById(R.id.imgview_forca);
        final ImageView imgviewForcaSeisErros = (ImageView) findViewById(R.id.imgview_forca_6_erros);
        final ImageView imgviewAcertou = (ImageView) findViewById(R.id.imgview_acertou);
        final ImageView imgviewSofia = (ImageView) findViewById(R.id.imgview_Sofia);
        final ImageView imgviewPedro = (ImageView) findViewById(R.id.imgview_Pedro);

        rdGroupDificuldade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == rbFacil.getId()) {
                    facil = true;
                    txtViewDificuldade.setText("Dificuldade: Patrick");
                }
                else if (checkedId == rbDificil.getId()) {
                    facil = false;
                    txtViewDificuldade.setText("Dificuldade: Bob Esponja");
                }
            }
        });

        imgviewJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setVisibility(View.GONE);
                txtViewDificuldade.setVisibility(View.GONE);
                rdGroupDificuldade.setVisibility(View.GONE);
                imgviewForca.setVisibility(View.VISIBLE);

                aM.setVisibility(View.VISIBLE);
                nZ.setVisibility(View.VISIBLE);

                montaPalavra();
            }
        });

        imgviewForcaSeisErros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgviewForcaSeisErros.setVisibility(View.GONE);
                imgviewForca.setVisibility(View.VISIBLE);

                aM.setVisibility(View.VISIBLE);
                nZ.setVisibility(View.VISIBLE);

                limpar();

                montaPalavra();
            }
        });

        imgviewAcertou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgviewAcertou.setVisibility(View.GONE);
                imgviewForca.setVisibility(View.VISIBLE);

                aM.setVisibility(View.VISIBLE);
                nZ.setVisibility(View.VISIBLE);

                limpar();

                montaPalavra();
            }
        });

        imgviewSofia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgviewSofia.setVisibility(View.GONE);
                imgviewForca.setVisibility(View.VISIBLE);

                aM.setVisibility(View.VISIBLE);
                nZ.setVisibility(View.VISIBLE);

                limpar();

                montaPalavra();
            }
        });

        imgviewPedro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgviewPedro.setVisibility(View.GONE);
                imgviewForca.setVisibility(View.VISIBLE);

                aM.setVisibility(View.VISIBLE);
                nZ.setVisibility(View.VISIBLE);

                limpar();

                montaPalavra();
            }
        });

    }

    public void montaPalavra() {

        final TextView txtviewPalavra = (TextView) findViewById(R.id.t_view_palavra);

        strPalavra[0] = "responsivo";
        strPalavra[1] = "android";
        strPalavra[2] = "usabilidade";
        strPalavra[3] = "teste";
        strPalavra[4] = "activity";
        strPalavra[5] = "funcional";
        strPalavra[6] = "SERPRO";
        strPalavra[7] = "manifest";
        strPalavra[8] = "mobile";
        strPalavra[9] = "projeto";

        strPalavraFacil[0] = "alfabeto";
        strPalavraFacil[1] = "pato";
        strPalavraFacil[2] = "rato";
        strPalavraFacil[3] = "elefante";
        strPalavraFacil[4] = "queijo";
        strPalavraFacil[5] = "Sofia";
        strPalavraFacil[6] = "Pedro";
        strPalavraFacil[7] = "caixa";
        strPalavraFacil[8] = "sorvete";
        strPalavraFacil[9] = "espaguete";

        int indice;

        Random rdIndice = new Random();
        indice = rdIndice.nextInt(10);

        if (facil) {
            tamanhoP = strPalavraFacil[indice].length();
            if (indice == 5) {
                Sofia = true;
            } else if (indice == 6) {
                Pedro = true;
            }
        } else {
            tamanhoP = strPalavra[indice].length();
        }

        for (int i=0; i<tamanhoP; i++) {
            strInicial += "_";

            if (facil) {
                palavraFormatada += strPalavraFacil[indice].charAt(i);
            } else {
                palavraFormatada += strPalavra[indice].charAt(i);
            }

            if (i < (tamanhoP - 1)) {
                strInicial += " ";
                palavraFormatada += " ";
            }
        }

        stringBufferPalavraExibida = new StringBuffer(strInicial);

        tamanhoPF = palavraFormatada.length();

        txtviewPalavra.setText(strInicial);
        txtviewPalavra.setVisibility(View.VISIBLE);
    }

    public void verificaLetra(View view){
        TextView txtviewPalavra = (TextView) findViewById(R.id.t_view_palavra);

        boolean achou = false;

        if (view instanceof Button) {
            char letraMaiuscula = ((Button) view).getText().charAt(0);
            char letraMinuscula = ((Button) view).getText().toString().toLowerCase().charAt(0);

            for (int i=0; i<tamanhoPF; i++) {
                if (palavraFormatada.charAt(i) ==  letraMinuscula) {
                    stringBufferPalavraExibida.setCharAt(i, letraMinuscula);
                    palavraExibida = stringBufferPalavraExibida.toString();

                    achou = true;
                } else if (palavraFormatada.charAt(i) ==  letraMaiuscula) {
                    stringBufferPalavraExibida.setCharAt(i, letraMaiuscula);
                    palavraExibida = stringBufferPalavraExibida.toString();

                    achou = true;
                }
            }
            if (palavraExibida != "") {
                txtviewPalavra.setText(palavraExibida);
            }

            view.setClickable(false);

        }
        if (achou) {
            view.setBackgroundColor(Color.WHITE);

            if (palavraExibida.equals(palavraFormatada)) {
                acertou = true;
            }
        } else {
            erros++;
            view.setBackgroundColor(Color.BLACK);
        }
        mudaTela();
    }

    public void mudaTela() {
        final ImageView imgviewJogar = (ImageView) findViewById(R.id.imgview_jogar);
        final ImageView imgviewForca = (ImageView) findViewById(R.id.imgview_forca);
        final ImageView imgviewForcaUmErro = (ImageView) findViewById(R.id.imgview_forca_1_erro);
        final ImageView imgviewForcaDoisErros = (ImageView) findViewById(R.id.imgview_forca_2_erros);
        final ImageView imgviewForcaTresErros = (ImageView) findViewById(R.id.imgview_forca_3_erros);
        final ImageView imgviewForcaQuatroErros = (ImageView) findViewById(R.id.imgview_forca_4_erros);
        final ImageView imgviewForcaCincoErros = (ImageView) findViewById(R.id.imgview_forca_5_erros);
        final ImageView imgviewForcaSeisErros = (ImageView) findViewById(R.id.imgview_forca_6_erros);
        final ImageView imgviewAcertou = (ImageView) findViewById(R.id.imgview_acertou);
        final ImageView imgviewSofia = (ImageView) findViewById(R.id.imgview_Sofia);
        final ImageView imgviewPedro = (ImageView) findViewById(R.id.imgview_Pedro);

        final TextView txtviewMensagem = (TextView) findViewById(R.id.t_view_mensagem);

        final LinearLayout aM = (LinearLayout) findViewById(R.id.lilayout_am);
        final LinearLayout nZ = (LinearLayout) findViewById(R.id.lilayout_nz);

        if (acertou) {
            imgviewForca.setVisibility(View.GONE);
            imgviewForcaUmErro.setVisibility(View.GONE);
            imgviewForcaDoisErros.setVisibility(View.GONE);
            imgviewForcaTresErros.setVisibility(View.GONE);
            imgviewForcaQuatroErros.setVisibility(View.GONE);
            imgviewForcaCincoErros.setVisibility(View.GONE);
            txtviewMensagem.setText("Uiaaa, acertou!");
            txtviewMensagem.setTextColor(Color.BLUE);
            txtviewMensagem.setVisibility(View.VISIBLE);
            if (Pedro) {
                imgviewPedro.setVisibility(View.VISIBLE);
            } else if (Sofia) {
                imgviewSofia.setVisibility(View.VISIBLE);
            } else {
                imgviewAcertou.setVisibility(View.VISIBLE);
            }
            aM.setVisibility(View.INVISIBLE);
            nZ.setVisibility(View.INVISIBLE);
        } else if (erros == 1) {
            imgviewForca.setVisibility(View.GONE);
            imgviewForcaUmErro.setVisibility(View.VISIBLE);
        } else if (erros == 2) {
            imgviewForcaUmErro.setVisibility(View.GONE);
            imgviewForcaDoisErros.setVisibility(View.VISIBLE);
        } else if (erros == 3) {
            imgviewForcaDoisErros.setVisibility(View.GONE);
            imgviewForcaTresErros.setVisibility(View.VISIBLE);
        } else if (erros == 4) {
            imgviewForcaTresErros.setVisibility(View.GONE);
            imgviewForcaQuatroErros.setVisibility(View.VISIBLE);
        } else if (erros == 5) {
            imgviewForcaQuatroErros.setVisibility(View.GONE);
            imgviewForcaCincoErros.setVisibility(View.VISIBLE);
        } else if (erros ==6) {
            imgviewForcaCincoErros.setVisibility(View.GONE);
            imgviewForcaSeisErros.setVisibility(View.VISIBLE);
            txtviewMensagem.setText("Tsc tsc tsc");
            txtviewMensagem.setTextColor(Color.RED);
            txtviewMensagem.setVisibility(View.VISIBLE);
            aM.setVisibility(View.INVISIBLE);
            nZ.setVisibility(View.INVISIBLE);
        }
    }

    public void limpar() {
        strInicial = "";
        palavraFormatada = "";
        palavraExibida =  "";
        erros = 0;
        acertou = false;
        Sofia = false;
        Pedro = false;

        final TextView txtviewMensagem = (TextView) findViewById(R.id.t_view_mensagem);
        txtviewMensagem.setVisibility(View.INVISIBLE);

        final Button btnA = (Button) findViewById(R.id.btn_a);
        final Button btnB = (Button) findViewById(R.id.btn_b);
        final Button btnC = (Button) findViewById(R.id.btn_c);
        final Button btnD = (Button) findViewById(R.id.btn_d);
        final Button btnE = (Button) findViewById(R.id.btn_e);
        final Button btnF = (Button) findViewById(R.id.btn_f);
        final Button btnG = (Button) findViewById(R.id.btn_g);
        final Button btnH = (Button) findViewById(R.id.btn_h);
        final Button btnI = (Button) findViewById(R.id.btn_i);
        final Button btnJ = (Button) findViewById(R.id.btn_j);
        final Button btnK = (Button) findViewById(R.id.btn_k);
        final Button btnL = (Button) findViewById(R.id.btn_l);
        final Button btnM = (Button) findViewById(R.id.btn_m);
        final Button btnN = (Button) findViewById(R.id.btn_n);
        final Button btnO = (Button) findViewById(R.id.btn_o);
        final Button btnP = (Button) findViewById(R.id.btn_p);
        final Button btnQ = (Button) findViewById(R.id.btn_q);
        final Button btnR = (Button) findViewById(R.id.btn_r);
        final Button btnS = (Button) findViewById(R.id.btn_s);
        final Button btnT = (Button) findViewById(R.id.btn_t);
        final Button btnU = (Button) findViewById(R.id.btn_u);
        final Button btnV = (Button) findViewById(R.id.btn_v);
        final Button btnW = (Button) findViewById(R.id.btn_w);
        final Button btnX = (Button) findViewById(R.id.btn_x);
        final Button btnY = (Button) findViewById(R.id.btn_y);
        final Button btnZ = (Button) findViewById(R.id.btn_z);

        btnA.setClickable(true);
        btnB.setClickable(true);
        btnC.setClickable(true);
        btnD.setClickable(true);
        btnE.setClickable(true);
        btnF.setClickable(true);
        btnG.setClickable(true);
        btnH.setClickable(true);
        btnI.setClickable(true);
        btnJ.setClickable(true);
        btnK.setClickable(true);
        btnL.setClickable(true);
        btnM.setClickable(true);
        btnN.setClickable(true);
        btnO.setClickable(true);
        btnP.setClickable(true);
        btnQ.setClickable(true);
        btnR.setClickable(true);
        btnS.setClickable(true);
        btnT.setClickable(true);
        btnU.setClickable(true);
        btnV.setClickable(true);
        btnW.setClickable(true);
        btnX.setClickable(true);
        btnY.setClickable(true);
        btnZ.setClickable(true);

        btnA.setBackgroundColor(Color.rgb(140,225,123));
        btnB.setBackgroundColor(Color.rgb(140,225,123));
        btnC.setBackgroundColor(Color.rgb(140,225,123));
        btnD.setBackgroundColor(Color.rgb(140,225,123));
        btnE.setBackgroundColor(Color.rgb(140,225,123));
        btnF.setBackgroundColor(Color.rgb(140,225,123));
        btnG.setBackgroundColor(Color.rgb(140,225,123));
        btnH.setBackgroundColor(Color.rgb(140,225,123));
        btnI.setBackgroundColor(Color.rgb(140,225,123));
        btnJ.setBackgroundColor(Color.rgb(140,225,123));
        btnK.setBackgroundColor(Color.rgb(140,225,123));
        btnL.setBackgroundColor(Color.rgb(140,225,123));
        btnM.setBackgroundColor(Color.rgb(140,225,123));
        btnN.setBackgroundColor(Color.rgb(140,225,123));
        btnO.setBackgroundColor(Color.rgb(140,225,123));
        btnP.setBackgroundColor(Color.rgb(140,225,123));
        btnQ.setBackgroundColor(Color.rgb(140,225,123));
        btnR.setBackgroundColor(Color.rgb(140,225,123));
        btnS.setBackgroundColor(Color.rgb(140,225,123));
        btnT.setBackgroundColor(Color.rgb(140,225,123));
        btnU.setBackgroundColor(Color.rgb(140,225,123));
        btnV.setBackgroundColor(Color.rgb(140,225,123));
        btnW.setBackgroundColor(Color.rgb(140,225,123));
        btnX.setBackgroundColor(Color.rgb(140,225,123));
        btnY.setBackgroundColor(Color.rgb(140,225,123));
        btnZ.setBackgroundColor(Color.rgb(140,225,123));
    }

}