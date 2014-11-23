package com.example.teodor.broadcastreceiverexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        List<String> strings = new ArrayList<String>();
        adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
        adapter.addAll(NetworkChangeReceiver.changes);
        adapter.notifyDataSetChanged();
    }
}
