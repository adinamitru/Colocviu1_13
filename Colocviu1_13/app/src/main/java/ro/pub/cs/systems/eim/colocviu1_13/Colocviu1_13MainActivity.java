package ro.pub.cs.systems.eim.colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Colocviu1_13MainActivity extends AppCompatActivity {

    int totalNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_13_main);

        Button northButton = (Button) findViewById(R.id.north_button);
        Button eastButton = (Button) findViewById(R.id.east_button);
        Button southButton = (Button) findViewById(R.id.south_button);
        Button westButton = (Button) findViewById(R.id.west_button);
        Button secondaryButton = (Button) findViewById(R.id.secondary_activity_button);

        northButton.setOnClickListener(buttonClickListener);
        eastButton.setOnClickListener(buttonClickListener);
        southButton.setOnClickListener(buttonClickListener);
        westButton.setOnClickListener(buttonClickListener);
        secondaryButton.setOnClickListener(buttonClickListener);
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            Button northButton = (Button) findViewById(R.id.north_button);
            Button eastButton = (Button) findViewById(R.id.east_button);
            Button southButton = (Button) findViewById(R.id.south_button);
            Button westButton = (Button) findViewById(R.id.west_button);
            Button secondaryButton = (Button) findViewById(R.id.secondary_activity_button);
            TextView totalText = (TextView) findViewById(R.id.text_total);
            TextView text = (TextView) findViewById(R.id.text_case);

            int north = 0;
            int east = 0;
            int south = 0;
            int west = 0;
            String oltCoord;
            String newCoord;
            List list = new ArrayList();
            if (northButton.isPressed()) {
                north++;
                oltCoord = text.getText().toString();
                if (oltCoord == "") {
                    newCoord = "NORTH";
                } else {
                    newCoord = oltCoord + ", " + "NORTH";
                }
                text.setText(newCoord);
            } else if (eastButton.isPressed()) {
                east++;
                oltCoord = text.getText().toString();
                if (oltCoord == "") {
                    newCoord = "EAST";
                } else {
                    newCoord = oltCoord + ", " + "EAST";
                }
                text.setText(newCoord);
            } else if (southButton.isPressed()) {
                south++;
                oltCoord = text.getText().toString();
                if (oltCoord == "") {
                    newCoord = "SOUTH";
                } else {
                    newCoord = oltCoord + ", " + "SOUTH";
                }
                text.setText(newCoord);
            } else if (westButton.isPressed()) {
                west++;
                oltCoord = text.getText().toString();
                if (oltCoord == "") {
                    newCoord = "WEST";
                } else {
                    newCoord = oltCoord + ", " + "WEST";
                }
                text.setText(newCoord);
            } else if (secondaryButton.isPressed()) {
                Intent intent = new Intent(getApplicationContext(), Colocviu1_13SecondaryActivity.class);
                totalNumber = north + south + east + west;
                intent.putExtra(Constants.TOTAL_COUNT, totalNumber);
                startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
            }

            //text.setText(android.text.TextUtils.join(", ", list));
            totalNumber = north + south + east + west;
        }

    }


    @Override
    public void onRestart() {
        super.onRestart();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        TextView totalText = (TextView) findViewById(R.id.text_total);
        savedInstanceState.putString(Constants.TOTAL_COUNT, String.valueOf(totalNumber));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.TOTAL_COUNT)) {
            TextView totalText = (TextView) findViewById(R.id.text_total);
            totalText.setText(savedInstanceState.getString(Constants.TOTAL_COUNT));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case Constants.SECONDARY_ACTIVITY_REQUEST_CODE:
                Toast.makeText(this, "Activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
                break;
        }
    }

}
