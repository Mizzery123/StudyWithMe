package sg.edu.rp.c346.studywithme;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SessionDetailUnjoinedActivity extends AppCompatActivity {

    Button btnunjoined;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_detail_unjoined);

        btnunjoined = findViewById(R.id.joinButton);

        btnunjoined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(SessionDetailUnjoinedActivity.this);
                myBuilder.setTitle("Successfully Unjoined!");
                myBuilder.setMessage("We hope you make it next time!");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Ok", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });
    }
}
