package sg.edu.rp.c346.studywithme;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SessionDetailActivity extends AppCompatActivity {

    Button buttonJoined;
    TextView tvModule, tvDate, tvTime, tvDescript, tvVenue;
    ImageView ivSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_detail);

        ivSchool=findViewById(R.id.ivSchool);
        tvModule=findViewById(R.id.tvModule);
        tvDate=findViewById(R.id.tvDate);
        tvTime=findViewById(R.id.tvTime);
        tvDescript=findViewById(R.id.tvDescription);
        tvVenue=findViewById(R.id.tvVenue);
        buttonJoined=findViewById(R.id.joinButton);

        Intent intentReceived = getIntent();

        String module = intentReceived.getStringExtra("module");
        String date = intentReceived.getStringExtra("date");
        String time = intentReceived.getStringExtra("time");
        String description = intentReceived.getStringExtra("descript");
        String venue = intentReceived.getStringExtra("venue");
        String school = intentReceived.getStringExtra("school");

tvModule.setText(module);
tvDate.setText(date);
tvTime.setText(time);
tvDescript.setText("\n"+description+"\n");
tvVenue.setText(venue);

if(module=="Android Programming"){
    ivSchool.setImageResource(R.drawable.soi);
} else {
    ivSchool.setImageResource(R.drawable.sas);
}

        buttonJoined.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(SessionDetailActivity.this);
                myBuilder.setTitle("Successfully Joined!");
                myBuilder.setMessage("Please be punctual! Check your event list for the details");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Ok", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();


            }
        });


    }
}
