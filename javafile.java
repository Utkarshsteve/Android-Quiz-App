package com.example.android.quiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String resultsDisplay;int x1,x2,x3,x4,x5,x6,x7=0,x8,x9,x10,final_score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitScore (View view) {


        //------------------------------------------------------------------------------------------
        // USERNAME
        //------------------------------------------------------------------------------------------


        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        


        //------------------------------------------------------------------------------------------
        // Question 1 - Correct Answer is "Intel"
        //------------------------------------------------------------------------------------------

        EditText intel = (EditText) findViewById(R.id.ans_intel);
        String ans1 = intel.getText().toString();
        if (ans1.equals("Intel")) {
            x1=1;
        } else {
            x1=0;
        }

        //------------------------------------------------------------------------------------------
        // Question 2 - Correct Answer is "Pixar"
        //------------------------------------------------------------------------------------------

        EditText pixar = (EditText) findViewById(R.id.ans_pixar);
        String ans2 = pixar.getText().toString();
        if (ans2.equals("Pixar")) {
            x2=1;
        } else {
            x2 = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 3 - Correct Answer is "Paypal Mafia"
        //------------------------------------------------------------------------------------------

        EditText paypal = (EditText) findViewById(R.id.ans_paypalmafia);
        String ans3 = paypal.getText().toString();
        if (ans3.equals("Paypal Mafia") || (ans3.equals("Paypalmafia")) || (ans3.equals("PayPal Mafia"))) {
            x3=1;
        } else {
            x3=0;
        }

        //------------------------------------------------------------------------------------------
        // Question 4 - Correct Answer is "Linux"
        //------------------------------------------------------------------------------------------

        EditText linux = (EditText) findViewById(R.id.ans_linux);
        String ans4 = linux.getText().toString();
        if (ans4.equals("Linux")) {
            x4=1;
        } else {
            x4=0;
        }

        //------------------------------------------------------------------------------------------
        // Question 5 - Correct Answer is "TCS"
        //------------------------------------------------------------------------------------------

        EditText TCS = (EditText) findViewById(R.id.ans_tcs);
        String ans5 = TCS.getText().toString();
        if (ans5.equals("Tcs") ||(ans5.equals("TCS"))) {
            x5=1;
        } else {
            x5=0;
        }

        //------------------------------------------------------------------------------------------
        // Question 6 - Correct Answer is "Google"
        //------------------------------------------------------------------------------------------

        EditText google = (EditText) findViewById(R.id.ans_google);
        String ans6 = google.getText().toString();
        if (ans6.equals("Google")) {
            x6=1;
        } else {
            x6=0;
        }

        //------------------------------------------------------------------------------------------
        // Question 7 - Correct Answer is "Lisp"
        //------------------------------------------------------------------------------------------

        CheckBox question7_choice1 = (CheckBox) findViewById(R.id.question7_choice1);
        CheckBox question7_choice2 = (CheckBox) findViewById(R.id.question7_choice2);
        CheckBox question7_choice3 = (CheckBox) findViewById(R.id.question7_choice3);
        CheckBox question7_choice4 = (CheckBox) findViewById(R.id.question7_choice4);

        boolean answer7_choice1 = question7_choice1.isChecked();
        boolean answer7_choice2 = question7_choice2.isChecked();
        boolean answer7_choice3 = question7_choice3.isChecked();
        boolean answer7_choice4 = question7_choice4.isChecked();
        if (answer7_choice1 && answer7_choice3) {
            x7 = 1;
        } else {
            x7 = 0;
        }



        //------------------------------------------------------------------------------------------
        // Question 8 - Correct Answer is "Uber"
        //------------------------------------------------------------------------------------------

        EditText uber = (EditText) findViewById(R.id.ans_uber);
        String ans8 = uber.getText().toString();
        if (ans8.equals("Uber")) {
            x8=1;
        } else {
            x8=0;
        }

        //------------------------------------------------------------------------------------------
        // Question 9 - Correct Answer is "Microsoft"
        //------------------------------------------------------------------------------------------

        RadioButton question9_choice2 = (RadioButton) findViewById(R.id.question9_choice2);
        boolean answer1 = question9_choice2.isChecked();
        if (answer1) {
            x9 = 1;
        } else {
            x9 = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 10 - Correct Answer is "Bing"
        //------------------------------------------------------------------------------------------

        EditText bing = (EditText) findViewById(R.id.ans_bing);
        String ans10 = bing.getText().toString();
        if (ans10.equals("Bing")) {
            x10=1;
        } else {
            x10=0;
        }

        //------------------------------------------------------------------------------------------
        // Final Score
        //------------------------------------------------------------------------------------------
         final_score = x1+x2+x3+x4+x5+x6+x7+x8+x9+x10;

        if (final_score == 10) {
            resultsDisplay =name + " Perfect! You scored 10 out of 10";
        } else {
            resultsDisplay =name+ " Try again. You scored " + final_score + " out of 10";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        if (final_score == 10)
            intent.putExtra(Intent.EXTRA_SUBJECT, name+ " ,Perfect! You scored 10 out of 10");
            else
            intent.putExtra(Intent.EXTRA_SUBJECT, name+ " ,Try again. You scored " + final_score + " out of 10");

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }


        }

    }

