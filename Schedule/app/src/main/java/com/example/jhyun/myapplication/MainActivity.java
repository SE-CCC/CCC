package com.example.jhyun.myapplication;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
public class MainActivity extends AppCompatActivity {
    TextInputEditText editName, editDate, editTime;
    Button btStore, btRedirect;
    sqlHelper sqlHelper;
    String getname,gettime,getdate;
    int date,month,year,hour,minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (TextInputEditText) findViewById(R.id.editname);
        editDate = (TextInputEditText) findViewById(R.id.editDate);
        editTime = (TextInputEditText) findViewById(R.id.editTime);
        btStore = (Button) findViewById(R.id.btStore);
        btRedirect = (Button) findViewById(R.id.btRedirect);

        //get calender values.
        Calendar calendar=Calendar.getInstance();
        date=calendar.get(Calendar.DAY_OF_MONTH);
        month=calendar.get(Calendar.MONTH);
        minute=calendar.get(Calendar.MINUTE);
        year=calendar.get(Calendar.YEAR);
        hour=calendar.get(Calendar.HOUR);


        //redirection code .
        btRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, Main2Activity.class));

            }
        });

        //get datepicker dialog.
        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        editDate.setText(i2+"/"+(i1+1)+"/"+i);
                        getdate=i2+"/"+i1+"/"+i;
                    }
                },year,month,date);
                datePickerDialog.show();

            }
        });

        //time picker dialog.
        editTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog dialog=new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        editTime.setText(i+" : "+i1);
                        gettime=i+" : "+i1;
                    }
                },hour,minute,false);
                dialog.show();
            }
        });






        btStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sqlHelper=new sqlHelper(MainActivity.this);
                //create table.
                sqlHelper.createtb();
                //get values from views and pass to sqlite.
                getname=editName.getText().toString();
                if(getdate.equals("")
                        ||gettime.equals("")
                        ||getname.equals("")){
                    Toast.makeText(MainActivity.this, "Please fill all details.", Toast.LENGTH_SHORT).show();
                }
                else{

                    //ready to store in sqlite.
                    sqlHelper.insert(getname,getdate, gettime);
                    Toast.makeText(MainActivity.this, "Data store successfully.", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}