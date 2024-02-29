package paci.iut.testandroid_tp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import paci.iut.testandroid_tp2.data.HabitatDesc;

public class HabitatActivity extends AppCompatActivity {

    List<String> items = new ArrayList<String>();
    ListView lv;
    TextView annonce;
    HabitatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habitat);

        List<HabitatDesc> items = new ArrayList<>();
        items.add(new HabitatDesc(R.drawable.ic_aspirateur, "aspi"));
        items.add(new HabitatDesc(R.drawable.ic_climatiseur, "clim"));

        annonce = (TextView) findViewById(R.id.annonceTV);
        lv = (ListView) findViewById(R.id.habitatLV);

        annonce.setText("Voici votre liste : ");

        adapter =
                new HabitatAdapter(HabitatActivity.this,
                        R.layout.item_habitat_desc,
                        items);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(onItemClick);
    }
    private AdapterView.OnItemClickListener onItemClick = new AdapterView.OnItemClickListener(){

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            //Toast.makeText(getApplicationContext(), adapter.getItem(i), Toast.LENGTH_SHORT).show();
            HabitatDesc hd = adapter.getItem(i);
            Toast.makeText(getApplicationContext(), hd.name, Toast.LENGTH_SHORT).show();
        }
    };
}

