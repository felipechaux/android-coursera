package com.example.contactformapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textview.MaterialTextView;

import static com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT;

public class ConfirmInfoActivity extends AppCompatActivity {

    private MaterialTextView textNameValue;
    private MaterialTextView textBirthDateValue;
    private MaterialTextView textPhoneValue;
    private MaterialTextView textEmailValue;
    private MaterialTextView textDescriptionContactValue;
    private Button editButton;
    private User userParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_info);

        textNameValue = findViewById(R.id.txtNameValue);
        textBirthDateValue = findViewById(R.id.txtBirthDateValue);
        textPhoneValue= findViewById(R.id.txtPhoneValue);
        textEmailValue=findViewById(R.id.txtEmailValue);
        textDescriptionContactValue= findViewById(R.id.txtDescriptionValue);
        editButton=findViewById(R.id.buttonEdit);

        getExtras();
        initListeners();
    }

    private void initListeners() {
        try {
            editButton.setOnClickListener(this::goToContactForm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getExtras() {
        try {
            Bundle params = getIntent().getExtras();
            userParam = params.getParcelable(getResources().getString(R.string.intent_user));
            showInfoUser(userParam);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void showInfoUser(User user) {
        try {
            textNameValue.setText(user.getName());
            textBirthDateValue.setText(user.getBirthDate());
            textPhoneValue.setText(user.getPhone());
            textEmailValue.setText(user.getEmail());
            textDescriptionContactValue.setText(user.getDescriptionContact());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void goToContactForm(View view) {
        try {
        Intent confirmIntent = new Intent(ConfirmInfoActivity.this, MainActivity.class);
                confirmIntent.putExtra(getResources().getString(R.string.intent_user),  userParam);
                startActivity(confirmIntent);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //onBack
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode== KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(ConfirmInfoActivity.this,MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }


}