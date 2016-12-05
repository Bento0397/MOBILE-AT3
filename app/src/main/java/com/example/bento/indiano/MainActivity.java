package com.example.bento.indiano;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    ListView listView;
    private String[] names = {"Jorge", "Bruno", "Victor", " Rayane", "Paulo", "Arthur", "Gabriel", "Walckson", "Camila", "Fernando", "Breno", "Bento"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
        new MyTask().execute();
        
    }

    class MyTask extends AsyncTask<Void, String, String> {

        ArrayAdapter<String> adapter;


        @Override
        protected void onPreExecute() {
            adapter = (ArrayAdapter<String>) listView.getAdapter();

        }

        @Override
        protected String doInBackground(Void... params) {
            for (String Name : names) {
                publishProgress(Name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "All the Names were added as ScuccesFully!";
        }

        private void publishProgress(String name) {

        }

        @Override
        protected void onProgressUpdate(String... values) {
            adapter.add(values[0]);
        }

        @Override
        protected void onPostExecute(String result) {

            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}

