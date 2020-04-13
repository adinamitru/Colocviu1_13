package ro.pub.cs.systems.eim.colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Colocviu1_13SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13_secondary);

        TextView totalText = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.TOTAL_COUNT)) {
            int numberOfClicks = intent.getIntExtra(Constants.TOTAL_COUNT, -1);
            totalText.setText(String.valueOf(numberOfClicks));
        }
    }
}
