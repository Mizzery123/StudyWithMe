package sg.edu.rp.c346.studywithme;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class EventActivity extends AppCompatActivity {

    private static final String TAG = "EventActivity";

    private TextView tvDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    ListView lvSession;
    ArrayList<ToDoItem> alToDoList;
    CustomAdapter caToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        tvDate = (TextView) findViewById(R.id.tvDate);

        lvSession = findViewById(R.id.listViewSession);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EventActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                tvDate.setText("Select Date : " + date);
            }
        };

        alToDoList = new ArrayList<>();
        Calendar date1 = Calendar.getInstance();
        date1.set(2018,7,1);
        Calendar date2 = Calendar.getInstance();
        date2.set(2018,9,22);
        ToDoItem item1 = new ToDoItem("Chemistry", date2, "", "", false);
        ToDoItem item2 = new ToDoItem("Android Programming", date1, "","", true);

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
                else if ( id==R.id.list){
                    Intent intentNewAct = new Intent(getBaseContext(),
                            EventActivity.class);
                    startActivity(intentNewAct);
                } else if ( id==R.id.edit) {
                    Intent intentNewAct = new Intent(getBaseContext(),
                            RegisteredActivity.class);
                    startActivity(intentNewAct);
                }


                return true;





            }
        });

        lvSession.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(getBaseContext(), SessionDetailUnjoinedActivity.class);
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
