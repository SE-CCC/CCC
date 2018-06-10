package com.example.jhyun.myapplication;
import android.database.Cursor;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextInputEditText editName, editDate, editTime, editid;
    Button btget,btDelete,btDrop;
    sqlHelper sqlHelper;
    String getname,getdate,gettime,deletename,deletedate,deletetime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editName = (TextInputEditText) findViewById(R.id.editShowname);
        editDate = (TextInputEditText) findViewById(R.id.editShowDate);
        editTime = (TextInputEditText) findViewById(R.id.editShowTime);
        btget = (Button) findViewById(R.id.btGet);
        editid = (TextInputEditText) findViewById(R.id.editID);
        btget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editid.getText().toString().equals("")) {
                    Toast.makeText(Main2Activity.this, "Please enter id", Toast.LENGTH_SHORT).show();
                } else {
                    //initialized sqlitehelper class.
                    sqlHelper = new sqlHelper(Main2Activity.this);
                    //pass id to getRow sqlHelper function.
                    Cursor cursor = sqlHelper.getRow(editid.getText().toString());
                    while (cursor.moveToNext()) {
                        //you can get column values by passing column name using 'cursor.getColumnIndex("column")' statement.

                        getname=cursor.getString(cursor.getColumnIndex("name"));
                        getdate=cursor.getString(cursor.getColumnIndex("date"));
                        gettime=cursor.getString(cursor.getColumnIndex("time"));
                    }
                    //set the db values to edittext
                    editDate.setText(getdate);
                    editName.setText(getname);
                    editTime.setText(gettime);
                }
            }
        });

        btget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editid.getText().toString().equals("")) {
                    Toast.makeText(Main2Activity.this, "Please enter id", Toast.LENGTH_SHORT).show();
                } else {
                    //initialized sqlitehelper class.
                    sqlHelper = new sqlHelper(Main2Activity.this);
                    //pass id to getRow sqlHelper function.
                    Cursor cursor = sqlHelper.getRow(editid.getText().toString());
                    while (cursor.moveToNext()) {
                        //you can get column values by passing column name using 'cursor.getColumnIndex("column")' statement.

                        getname=cursor.getString(cursor.getColumnIndex("name"));
                        getdate=cursor.getString(cursor.getColumnIndex("date"));
                        gettime=cursor.getString(cursor.getColumnIndex("time"));
                    }
                    //set the db values to edittext
                    editDate.setText(getdate);
                    editName.setText(getname);
                    editTime.setText(gettime);

                }

            }
        });
        Button delete = (Button) findViewById(R.id.btDelete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlHelper = new sqlHelper(Main2Activity.this);
                //pass id to getRow sqlHelper function.
                Cursor cursor = sqlHelper.getRow(editid.getText().toString());
                while (cursor.moveToNext()) {
                    //you can get column values by passing column name using 'cursor.getColumnIndex("column")' statement.

                    deletename=cursor.getString(cursor.getColumnIndex("name"));
                    deletedate=cursor.getString(cursor.getColumnIndex("date"));
                    deletetime=cursor.getString(cursor.getColumnIndex("time"));
                }
                sqlHelper.delete(getname,getdate,gettime);



            }
        });

        Button drop = (Button) findViewById(R.id.btDrop);
        drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlHelper = new sqlHelper(Main2Activity.this);
                //pass id to getRow sqlHelper function.
                Cursor cursor = sqlHelper.getRow(editid.getText().toString());

                sqlHelper.droptb();



            }
        });





    }
}
