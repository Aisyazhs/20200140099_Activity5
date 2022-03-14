package com.example.tugasku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //untuk button
    Button btnLogin;

    //untuk editText
    EditText edEmail, edPassword;

    //untuk menyimpan email dan password
    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btSignin);
        edEmail=findViewById(R.id.edEmail);
        edPassword=findViewById(R.id.edPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                nama = edEmail.getText().toString();

                //menyimpan input user di edittext password
                password = edPassword.getText().toString();


                Toast t = Toast.makeText(getApplicationContext(),
                        "email anda: " + nama + " dan Password anda: " + password + "",
                        Toast.LENGTH_LONG);


                if (nama.equals("") || password.equals("")) {
                    Toast.makeText(MainActivity.this, "Email atau Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {

                    if (nama.equals("adm@mail.id") && password.equals("1306")) {
                        Bundle b = new Bundle();

                        b.putString("a", nama.trim());
                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), Kedua.class);
                        //memasukkan bundle kedalam intent
                        i.putExtras(b);
                        //berpindah ke halaman lain
                        startActivity(i);
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Login Berhasil", Toast.LENGTH_LONG);
                        toast.show();
                        //menghapus isi dari editText
                        edEmail.getText().clear();
                        edPassword.getText().clear();
                    } else {
                        if (password.equals("adm@mail.id")) {
                            Toast.makeText(MainActivity.this, "Email Salah", Toast.LENGTH_SHORT).show();
                        } else {
                            Bundle b = null;
                            if (nama.equals("1306")) {
                                Toast.makeText(MainActivity.this, "Password Salah", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(MainActivity.this, "Username Salah", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                }
            }
        });
    }
}