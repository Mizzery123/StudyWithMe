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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class QuestionActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    ListView lvSession;
    ArrayList<ToDoItem> alToDoList;
    CustomAdapter caToDo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        lvSession = findViewById(R.id.listViewSession);


        alToDoList = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2018,7,1);
        Calendar date2 = Calendar.getInstance();
        date2.set(2018,9,22);
        ToDoItem item1 = new ToDoItem("For Android Studio, how do I create a LinearLayout?", date1, "Android Programming", "2 Answers", true);
        ToDoItem item2 = new ToDoItem("What is the chemical symbol for sodium?", date2, "Chemistry", "5 Answers", false);
        ToDoItem item3 = new ToDoItem("What is the ph of acid?", date2, "Chemistry", "1 Answers", false);
        ToDoItem item4 = new ToDoItem("How do I create a new emulator for Android Studio?", date2, "Android Progamming", "5 Answers", true);

        alToDoList.add(item1);
        alToDoList.add(item2);
        alToDoList.add(item3);
        alToDoList.add(item4);


        caToDo = new CustomAdapter(this, R.layout.todo_item, alToDoList);

        lvSession.setAdapter(caToDo);

        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);
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
                Intent intent = new Intent(getBaseContext(), QuestionDetailActivity.class);
                ToDoItem currentItem = alToDoList.get(position);


if (position==0) {
    startActivity(intent);
}
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}

