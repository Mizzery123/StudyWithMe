package sg.edu.rp.c346.studywithme;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class QuestionDetailActivity extends AppCompatActivity {

    Button backbtn, answerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);

        backbtn = findViewById(R.id.joinButton);
        answerbtn = findViewById(R.id.button3);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewAct = new Intent(getBaseContext(), QuestionActivity.class);
                startActivity(intentNewAct);


            }
        });

        answerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(QuestionDetailActivity.this);

                alert.setTitle("Title");
                alert.setMessage("Message");

// Set an EditText view to get user input
                final EditText input = new EditText(QuestionDetailActivity.this);
                alert.setView(input);

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String value = input.getText().toString();
                        // Do something with value!
                        AlertDialog.Builder myBuilder = new AlertDialog.Builder(QuestionDetailActivity.this);
                        myBuilder.setTitle("Answer Submitted!");
                        myBuilder.setMessage("Your Answer : " + value);
                        myBuilder.setCancelable(false);
                        myBuilder.setPositiveButton("Ok", null);
                        AlertDialog myDialog = myBuilder.create();
                        myDialog.show();

                    }
                });

                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Canceled.
                    }
                });

                alert.show();


            }
        });



    }
}
