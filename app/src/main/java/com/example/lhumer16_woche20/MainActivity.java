package com.example.lhumer16_woche20;

import android.content.res.AssetManager;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//https://stackoverflow.com/questions/35802924/android-searchview-setonquerytextlistener-not-working
public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private static final String TAG = "now";
    List<com.example.lhumer16_woche20.Person> list;
    ListView listV;
    SearchView sv;
    ArrayAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listV = findViewById(R.id.ListView);
        sv = findViewById(R.id.SearchView);
        setListView();


    }

    public static void main(String[] args) {

    }

    public List<Person> readCsv() {
        list = new ArrayList<com.example.lhumer16_woche20.Person>();
        InputStream in = getInputStreamForAsset("customers_data.csv");
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));
        String line;

        try {
            bin.readLine();
            while ((line = bin.readLine()) != null) {

                String[] arr = line.split(",");
                list.add(new com.example.lhumer16_woche20.Person(Integer.valueOf(arr[0]), arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]));
            }
            //int id, String firstname, String lastname, String title,String email, String mastatus, String credidCard
        } catch (IOException e) {
            Log.e(TAG, e.toString());
            e.printStackTrace();
        }

        return list;
    }

    private InputStream getInputStreamForAsset(String filename) {

        Log.d(TAG, "getInputStreamForAsset: " + filename);
        AssetManager assets = getAssets();
        try {
            return assets.open(filename);
        } catch (IOException e) {
            Log.e(TAG, e.toString());
            e.printStackTrace();
            return null;
        }
    }

    public void setListView() {
        List<Person> l = readCsv();
        String[] array = new String[l.size()];

        for (int i = 0; i < l.size(); i++) {

            array[i] = l.get(i).getFirstname() + "," + l.get(i).getLastname();
        }

        ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        listV.setAdapter(ad);

    }

    public void test()
    {
        int i = 10;
        //sköldfjadslköfjldas
        //askldfjadslköfjndskl
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        ad.getFilter().filter(newText);
                return false;
    }
}



