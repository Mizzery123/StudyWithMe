package sg.edu.rp.c346.studywithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register2Activity extends AppCompatActivity {

    Button btnBack, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        btnBack = findViewById(R.id.backButton2);
        btnNext = findViewById(R.id.nextButton3);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewAct = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(intentNewAct);


            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewAct = new Intent(getBaseContext(), ModuleActivity.class);
                startActivity(intentNewAct);

            }
        });
    }
}
