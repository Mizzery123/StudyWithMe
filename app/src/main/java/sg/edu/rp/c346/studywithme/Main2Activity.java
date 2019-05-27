package sg.edu.rp.c346.studywithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    Button btnRegister, btnFB, btnGoogle, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnRegister = findViewById(R.id.registerButton);
        btnFB = findViewById(R.id.facebookButton);
        btnGoogle = findViewById(R.id.googleButton);
        btnLogin = findViewById(R.id.loginButton);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewAct = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(intentNewAct);

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewAct = new Intent(getBaseContext(), RegisterActivity.class);
                startActivity(intentNewAct);

            }
        });

        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewAct = new Intent(getBaseContext(), WebPage.class);
                intentNewAct.putExtra("URL", "https://www.facebook.com/login");
                startActivity(intentNewAct);


            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewAct = new Intent(getBaseContext(), WebPage.class);
                intentNewAct.putExtra("URL", "https://accounts.google.com/ServiceLogin");
                startActivity(intentNewAct);


            }
        });

    }
}
