package com.example.aboutkinzaamjad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aboutkinzaamjad.data.Bio;
import com.example.aboutkinzaamjad.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
//
//    EditText enter_hobbies;
//    TextView hobbies;

    ActivityMainBinding binding;
    Bio bio = new Bio();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

//        enter_hobbies = findViewById(R.id.enter_hobbies);
//        hobbies = findViewById(R.id.hobbies_text);

        bio.setName("Kinza Amjad");
        binding.setBio(bio);

        binding.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHobbies(v);
            }
        });

    }

    public void addHobbies(View view) {
//
//        hobbies.setText("Hobbies: " + enter_hobbies.getText().toString().trim());
//        hobbies.setVisibility(View.VISIBLE);

        bio.setHobbies("Hobbies: " + binding.enterHobbies.getText().toString().trim());

  //      binding.hobbiesText.setText("Hobbies: " + binding.enterHobbies.getText().toString().trim());
        binding.hobbiesText.setVisibility(View.VISIBLE);
        binding.invalidateAll();

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}