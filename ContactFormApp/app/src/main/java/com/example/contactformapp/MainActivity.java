package com.example.contactformapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    private Button nextButton;
    private TextInputEditText textName;
    private TextInputEditText textBirthDate;
    private TextInputEditText textPhone;
    private TextInputEditText textEmail;
    private TextInputEditText textDescriptionContact;
    private DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.buttonNext);

        textName = findViewById(R.id.txtName);
        textBirthDate = findViewById(R.id.txtBirthDate);
        textPhone = findViewById(R.id.txtPhone);
        textEmail = findViewById(R.id.txtEmail);
        textDescriptionContact = findViewById(R.id.txtDescriptionContact);

        getExtras();

        initListeners();

    }

    private void getExtras() {
        try {
            if (getIntent().getExtras() != null) {
                Bundle params = getIntent().getExtras();
                User user = params.getParcelable(getResources().getString(R.string.intent_user));
                showInfoUser(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showInfoUser(User user) {
        try {
            textName.setText(user.getName());
            textBirthDate.setText(user.getBirthDate());
            textPhone.setText(user.getPhone());
            textEmail.setText(user.getEmail());
            textDescriptionContact.setText(user.getDescriptionContact());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initListeners() {
        try {
            nextButton.setOnClickListener(this::goToConfirmInfoActivity);


            textBirthDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDataPicker();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //picker de fecha
    @SuppressLint("SetTextI18n")
    private void showDataPicker() {
        try {
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR); // current year
            int mMonth = c.get(Calendar.MONTH); // current month
            int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
            datePickerDialog = new DatePickerDialog(MainActivity.this,
                    (view, year, monthOfYear, dayOfMonth) -> {
                        textBirthDate.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void goToConfirmInfoActivity(View view) {
        try {
            if (textName.getText().toString().equals("") || textBirthDate.getText().toString().equals("") || textPhone.getText().toString().equals("") || textEmail.getText().toString().equals("") || textDescriptionContact.getText().toString().equals("")) {
                Snackbar.make(view, getBaseContext().getResources().getString(R.string.info_incomplete), LENGTH_SHORT)
                        .show();
            } else {
                User user = new User(textName.getText().toString(), textBirthDate.getText().toString(), textPhone.getText().toString(), textEmail.getText().toString(), textDescriptionContact.getText().toString());
                Intent confirmIntent = new Intent(MainActivity.this, ConfirmInfoActivity.class);
                confirmIntent.putExtra(getResources().getString(R.string.intent_user), user);
                startActivity(confirmIntent);
                finish();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}