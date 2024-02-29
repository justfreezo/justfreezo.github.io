package iut.dam.tpdrawers;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // Create a Handler object
        Handler handler = new Handler();

        // Post a delayed Runnable to start the new activity after 3 seconds
        handler.postDelayed(() -> {
            // Start the new activity
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
            // Finish the current activity
            finish();
        }, 3000); // 3000 milliseconds = 3 seconds
    }
}
