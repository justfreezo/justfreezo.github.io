package iut.dam.powerhome;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HabitatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_habitat);

        Bundle bundle = getIntent().getExtras();

        List<Habitat> habitats = new ArrayList<>();
        habitats.add(new Habitat(1, "Marc Dupond", 1, 80.0));
        habitats.add(new Habitat(2, "Bob Dupont", 2, 90.0));

        ListView habitatLV = findViewById(R.id.habitatLV);
        HabitatAdapter habitatAdapter = new HabitatAdapter(this, R.layout.item_habitat, habitats);
        habitatLV.setAdapter(habitatAdapter);


        habitatLV.setOnItemClickListener((parent, view, position, id) -> {
            Habitat selectedHabitat = (Habitat) parent.getItemAtPosition(position);
            String selectedPerson = selectedHabitat.getResident();
            Toast.makeText(HabitatActivity.this, selectedPerson, Toast.LENGTH_SHORT).show();
        });

    }
}
