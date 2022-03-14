package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Kedua extends AppCompatActivity {
    // Deklarasi variable textView
    TextView Email,Password;

    // Deklarasi Variable String
    String email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        // Memanggil Email dan Password
        Email = findViewById(R.id.tf_nama);
        Password = findViewById(R.id.tf_password);

        // Penggunaan Bundle
        Bundle bundle = getIntent().getExtras();

        // Mendapatkan bundle dari MainActivity
        email = bundle.getString("a");
        pass = bundle.getString("b");

        Email.setText(email);
        Password.setText(pass);
    }
}

