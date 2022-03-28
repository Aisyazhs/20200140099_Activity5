package com.example.tugasku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    //deklarasi variabel dengan jenis data listview
    private ListView list;

    //memanggil class listviewadapter dan diinisiasi menjadi variabel adapter
    private ListViewAdapter adapter;

    //deklarasi array untuk menyimpan nama
    String[] listNama;

    //memanggil class ClassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();

    //membuat objek bundle
    Bundle bundle = new Bundle();

    //membuat objek intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //menyimpan namadidalam array listnama
        listNama = new String[]{"Inayah", "Ilham", "Eris", "Fikri",
                "Maul", "Intan", "Vina", "Gita", "Vian", "Lutfi"};
        list = findViewById(R.id.listKontak);

        //membuat objek dari class ClassNama menjadi arraylist
        classNamaArrayList = new ArrayList<>();

        //membaca seluruh data pada arry listNama
        for (int i = 0; i < listNama.length; i++)
        {
            //membuat objek class nama
            ClassNama classNama = new ClassNama(listNama[i]);
            //Binds strings ke array
            classNamaArrayList.add(classNama);
        }

        //membuat objek dari listviewAdapter
        adapter = new ListViewAdapter(this);

        //binds adapter ke listview
        list.setAdapter(adapter);


        //membuat event dari list onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick (AdapterView < ? > parent, View view,int position, long id ){

                //deklarasi variabel nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getName();

                //memasukkan value dari variabel nama dengan kunci "a"
                //dan dimasukkan kedalam bunle
                bundle.putString("a", nama.trim());

                //membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);

                //membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(HomeActivity.this);

                //menampilkan popu mneu dari layout menu
                pm.inflate(R.menu.popup_menu);

                //show popup menu
                pm.show();
            }
        });
    }
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mview:
                intent = new Intent(getApplicationContext(),LihatdataActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.medit:
                Toast.makeText(getApplicationContext(),"Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}
