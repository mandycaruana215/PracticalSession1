package com.example.mobilepractical1final;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyListActivity extends ListActivity {

    String arr[] = {"Portal", "Settings", "Help", "About"};
    ListView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        l = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        l.setAdapter(adapter);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        TextView temp = (TextView) v;
        Toast.makeText(this, "" + temp.getText() + " " + position, Toast.LENGTH_SHORT).show();
        if (position == 0) {
            Intent inte = new Intent(getApplicationContext(), PortalActivity.class);
            startActivity(inte);


        }

    }

}