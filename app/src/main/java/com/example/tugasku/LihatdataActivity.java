package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LihatdataActivity extends AppCompatActivity {

    //deklarasi variabel dengan jenis data textview
    TextView tvnama, tvnomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihatdata);

        tvnama = findViewById(R.id.tvNamaKotak);
        tvnomor = findViewById(R.id.tvNomorTelepon);
        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("a");

        //membuat fungsi untuk mengatur textview nama dan nomor telepon
        //berdasarkan pesan yang dikirimkan dariactivity sebelumnya


        switch (nama) {
            case "Inayah":
                tvnama.setText("Inayah M");
                tvnomor.setText("08122233344");
                break;
            case "Ilham":
                tvnama.setText("Ilham R");
                tvnomor.setText("08122267993");
                break;
            case "Eris":
                tvnama.setText("Eris J");
                tvnomor.setText("09847282931");
                break;
            case "Fikri":
                tvnama.setText("M fikri");
                tvnomor.setText("082482746822");
                break;
            case "Maul":
                tvnama.setText("Maul M");
                tvnomor.setText("08273891022");
                break;
            case "Intan":
                tvnama.setText("Intan S");
                tvnomor.setText("09848213455");
                break;
            case "Vina":
                tvnama.setText("Vina R");
                tvnomor.setText("08789763222");
                break;
            case "Gita":
                tvnama.setText("Gita S");
                tvnomor.setText("08432721233");
                break;
            case "Lutfi":
                tvnama.setText("Lutfi M");
                tvnomor.setText("08126381933");
                break;
            case "Vian":
                tvnama.setText("Vian M");
                tvnomor.setText("086681932456");
                break;
        }
    }
}
