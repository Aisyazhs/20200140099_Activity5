package com.example.tugasku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //deklarasi variabel dengan jenis data context
    Context mContext;

    //deklrasi variabel dengan jenis data layout inflater
    LayoutInflater inflater;

    //deklarasi variabel dengan jenis data arraylist
    private ArrayList<ClassNama> arrayList;

    //membuat konstruktor ListViewAdapter
    public ListViewAdapter(Context context){
        //memberi nilai mcontext dengan context
        mContext = context;

        //mengatur layoutinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //memberikn nilai arraylist dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //menambahkan semua elemen ke arraylist
        this.arrayList.addAll(HomeActivity.classNamaArrayList);
    }

    public class ViewHolder{
        //mendeklarasi variabel dengan jenis TextView
        TextView name;
    }

    @Override
    public int getCount() {
        //mengembalikan nilai berupa jumlah data dari array data
        return HomeActivity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        //mengembalikan nilai berupa objek dariaray data
        return HomeActivity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variabeldengan jenis data viewholder
        final ViewHolder holder;

        //membuat kondisi apakah biew null atau tidak
        if(view == null){
            //membuat objek view holder
            holder = new ViewHolder();

            //mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.activity_listview, null);

            //set id untuk textview
            holder.name=(TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain.
            view.setTag(holder);
        } else{
            //mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }
        //set item ke text view
        holder.name.setText(HomeActivity.classNamaArrayList.get(i).getName());

        //mengembalikan nilai ke variabel view
        return view;
    }
}

