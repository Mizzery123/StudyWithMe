package sg.edu.rp.c346.studywithme;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    ListView lvSession;
    ArrayList<ToDoItem> alToDoList;

    CustomAdapter caToDo;
    SearchView svPartner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lvSession = findViewById(R.id.listViewSession);
        svPartner = findViewById(R.id.simpleSearchView);

        CharSequence search = svPartner.getQuery();


        alToDoList = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2018,7,1);
        Calendar date2 = Calendar.getInstance();
        date2.set(2018,9,22);
        ToDoItem item1 = new ToDoItem("Android Programming", date1, "","", true);
        ToDoItem item2 = new ToDoItem("Chemistry", date2, "", "", false);

        alToDoList.add(item1);
        alToDoList.add(item2);


        caToDo = new CustomAdapter(this, R.layout.todo_item, alToDoList);

        lvSession.setAdapter(caToDo);

        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                    if (id== R.id.partner) {
                        Intent intentNewAct = new Intent(getBaseContext(), HomeActivity.class);
                        startActivity(intentNewAct);
                    }
                    else if ( id== R.id.qna ) {
                        Intent intentNewAct = new Intent(getBaseContext(), QuestionActivity.class);
                        startActivity(intentNewAct);
                    }
                    else if ( id==R.id.account){
                        Intent intentNewAct = new Intent(getBaseContext(), Register2Activity.class);
                        startActivity(intentNewAct);
                    } else if ( id==R.id.settings) {

                    }


                        return true;





            }
        });

        lvSession.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), SessionDetailActivity.class);
                ToDoItem currentItem = alToDoList.get(position);

                if (position == 0) {
                    intent.putExtra("module", "Android Programming");
                    intent.putExtra("date", "Date : 1/7/2018");
                    intent.putExtra("time", "Time : 4.30pm");
                    intent.putExtra("descript", "For all students out there studying Android Programming, this serves as a revision as well as opportunity to help clarify each other's doubts!");
                    intent.putExtra("venue", "Venue : RP Lawn");
                    intent.putExtra("school", "SOI");

                } else {
                    intent.putExtra("module", "Chemistry");
                    intent.putExtra("date", "Date : 22/9/2018");
                    intent.putExtra("time", "Time : 11.00am");
                    intent.putExtra("descript", "For chemistry students. Please do join if you are good at it as I want an A!");
                    intent.putExtra("venue", "Venue : RP Library");
                    intent.putExtra("school", "SAS");
                }




                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}
