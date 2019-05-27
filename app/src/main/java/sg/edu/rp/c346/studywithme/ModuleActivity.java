package sg.edu.rp.c346.studywithme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ModuleActivity extends AppCompatActivity {

    Button btnBack, btnDone;
    ListView lvModule, lvSelectedModule;

    ArrayList<String> alModules = new ArrayList<>();
    ArrayList<String> alSelectedModules = new ArrayList<>();
    //Dynamic ListView Step 2a
    ArrayAdapter<String> aaModules;
    ArrayAdapter<String> aaSelectedModules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module);

        btnBack = findViewById(R.id.backButton3);
        btnDone = findViewById(R.id.nextButton2);
        lvModule = findViewById(R.id.listViewModule);
        lvSelectedModule = findViewById(R.id.listViewSelectedModule);

        alModules.add("C346 Android Programming");
        alModules.add("B216 Marketing");
        alModules.add("C235 IT Security Management");
        alModules.add("C202 System Analysis and Design");
        alModules.add("C203 Web Application");

        aaModules = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alModules);

        aaSelectedModules = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alSelectedModules);

        lvModule.setAdapter(aaModules);
        lvSelectedModule.setAdapter(aaSelectedModules);

        lvModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String module = alModules.get(position);
              alModules.remove(module);
              aaModules.notifyDataSetChanged();
              alSelectedModules.add(module);
              aaSelectedModules.notifyDataSetChanged();
          }
        });

        lvSelectedModule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String module = alSelectedModules.get(position);
                alSelectedModules.remove(module);
                aaSelectedModules.notifyDataSetChanged();
                alModules.add(module);
                aaModules.notifyDataSetChanged();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewAct = new Intent(getBaseContext(), Register2Activity.class);
                startActivity(intentNewAct);


            }
        });

        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewAct = new Intent(getBaseContext(), HomeActivity.class);
                startActivity(intentNewAct);

            }
        });

    }
}
