package iut.dam.powerhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Button loginBtn = findViewById(R.id.loginBtn);
        EditText emailET = findViewById(R.id.emailET);
        EditText passwordET = findViewById(R.id.passwordET);

        /*List<Country> items = new ArrayList<>();
        items.add(new Country(R.drawable.france_flag, "France"));

        Spinner spinner = findViewById(R.id.spinner);
        CountryAdapter adapter = new CountryAdapter(this, R.layout.item_country, items);
        spinner.setAdapter(adapter);*/

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("LoginActivity", "Bouton cliqué !");

                String email = emailET.getText().toString();
                String password = passwordET.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

                Toast t;
                if(email.matches(emailPattern) && password.equals("pass")){
                    t = Toast.makeText(v.getContext(), LoginActivity.this.getString(R.string.auth_success), Toast.LENGTH_SHORT);

                    Intent i = new Intent(LoginActivity.this, HabitatActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("email", email);
                    bundle.putString("password", password);
                    i.putExtras(bundle);

                    startActivity(i);
                }
                else{
                    t = Toast.makeText(v.getContext(), LoginActivity.this.getString(R.string.auth_fail), Toast.LENGTH_SHORT);
                }
                t.show();
            }
        });
    }
}