package ro.pub.cs.systems.eim.colocviu1_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Colocviu1_13MainActivity extends AppCompatActivity {

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
            TextView text = (TextView) findViewById(R.id.text_case);

            int totalNumber = 0;
            String oltCoord;
            String newCoord;
            List list = new ArrayList();
            if (northButton.isPressed()) {
                totalNumber++;
                oltCoord = text.getText().toString();
                if (oltCoord == "") {
                    newCoord = "NORTH";
                } else {
                    newCoord = oltCoord + ", " + "NORTH";
                }
                text.setText(newCoord);
            } else if (eastButton.isPressed()) {
                totalNumber++;
                oltCoord = text.getText().toString();
                if (oltCoord == "") {
                    newCoord = "EAST";
                } else {
                    newCoord = oltCoord + ", " + "EAST";
                }
                text.setText(newCoord);
            } else if (southButton.isPressed()) {
                totalNumber++;
                oltCoord = text.getText().toString();
                if (oltCoord == "") {
                    newCoord = "SOUTH";
                } else {
                    newCoord = oltCoord + ", " + "SOUTH";
                }
                text.setText(newCoord);
            } else if (westButton.isPressed()) {
                totalNumber++;
                oltCoord = text.getText().toString();
                if (oltCoord == "") {
                    newCoord = "WEST";
                } else {
                    newCoord = oltCoord + ", " + "WEST";
                }
                text.setText(newCoord);
            }
//            } else if (total.isPressed()) {
//                Intent intent = new Intent(getApplicationContext(),SecondaryActivity.class);
//                nr_total = leftTextNumber + rightTextNumber;
//                intent.putExtra(Constants.TOTAL_COUNT, nr_total);
//                startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);
//            }

            //text.setText(android.text.TextUtils.join(", ", list));
        }
    }
}
