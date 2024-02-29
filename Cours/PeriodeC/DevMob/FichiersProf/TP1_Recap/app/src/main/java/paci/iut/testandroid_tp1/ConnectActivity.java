package paci.iut.testandroid_tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class ConnectActivity extends AppCompatActivity {

    TextView t;
    Button bt;
    EditText nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        t = (TextView) findViewById(R.id.helloTV);
        nm = (EditText) findViewById(R.id.nomET);
        bt = (Button) findViewById(R.id.connectBT);

        t.setText(R.string.bienvenue);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String NOM = "JMI";
                String nom = nm.getText().toString();

                //Toast.makeText(ConnectActivity.this,s, Toast.LENGTH_SHORT).show();
                Toast.makeText(v.getContext(),nom, Toast.LENGTH_SHORT).show();

                if (nom.equals(NOM)) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("nom", nom);
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            }
        });

    }
}