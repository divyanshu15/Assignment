package com.divyanshu.assignment_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private Calendar calendar;
    private EditText Userdob, UserName, UserEmail;
    private Button Submitbtn;
    private DBHelper DB;
    private int year, month, day;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Userdob = (EditText) findViewById(R.id.userDOB);
        UserName = (EditText) findViewById(R.id.username);
        UserEmail = (EditText) findViewById(R.id.useremail);
        Submitbtn = (Button) findViewById(R.id.submit);
        calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);

        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        Userdob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        String date = day + "-" + month + "-" + year;
                        Userdob.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        DBHelper DB = new DBHelper(MainActivity.this);
        Submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String userName = UserName.getText().toString();
                String userDOB = Userdob.getText().toString();
                String userEmail = UserEmail.getText().toString();

                // validating if the text fields are empty or not.
                if (userName.isEmpty() && userDOB.isEmpty() && userEmail.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    DB.insertuserdata(userName, userDOB, userEmail);
                    Intent intent = new Intent(MainActivity.this, All_users.class);

                    startActivity(intent);
                }

            }

        });

    }
}