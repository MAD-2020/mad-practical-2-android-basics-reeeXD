package sg.edu.np.WhackAMole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private int count = 0;
    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        Log.v(TAG, "Whack-A-Mole!");
        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        setNewMole();
        Log.v(TAG, "Starting GUI!");
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "Stopped");
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "Destroyed");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "Paused");
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "Resuming");
    }
    
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(TAG, "Restarting");
    }
    
    public void OnClick(View v){
        TextView textChange = (TextView)findViewById(R.id.textView);
        if (v.getId() == R.id.button1) {
            Log.d("#d", "Left Button Clicked!");
            Button clickedButton = (Button) findViewById(R.id.button1);
            if (clickedButton.getText() == "*") {
                count += 1;
                setNewMole();
                Log.d("#d", "Hit, Score Added!");
            }
            else {
                count -= 1;
                setNewMole();
                Log.d("#d", "Missed, Score Deducted!");
            }
        }
        else if (v.getId() == R.id.button2) {
            Log.d("#d", "Middle Button Clicked!");
            Button clickedButton = (Button) findViewById(R.id.button2);
            if (clickedButton.getText() == "*") {
                count += 1;
                setNewMole();
                Log.d("#d", "Hit, Score Added!");
            }
            else {
                count -= 1;
                setNewMole();
                Log.d("#d", "Missed, Score Deducted!");
            }
        }
        else {
            Log.d("#d", "Right Button Clicked!");
            Button clickedButton = (Button) findViewById(R.id.button3);
            if (clickedButton.getText() == "*") {
                count += 1;
                setNewMole();
                Log.d("#d", "Hit, Score Added!");
            }
            else {
                count -= 1;
                setNewMole();
                Log.d("#d", "Missed, Score Deducted!");
            }
        }
        String countString = String.valueOf(count);
        textChange.setText(countString);
    }

    public void setNewMole() {
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        Button[] buttonArray = {button1, button2, button3};
        for (int i = 0; i < 3; i++) {
            Button clearButton = buttonArray[i];
            clearButton.setText("0");
        }
        Button selectedButton = buttonArray[randomLocation];
        selectedButton.setText("*");
    }
}
