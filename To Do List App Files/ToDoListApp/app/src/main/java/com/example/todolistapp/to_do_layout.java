package com.example.todolistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class to_do_layout extends AppCompatActivity {

    ArrayList<CheckBoxName> myArrayList;
    CheckBoxName name;
    String text;
    EditText nameOfText;
    Button addCheckBox;
    ListView myList;

    private static CustomAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_layout);
        myArrayList = new ArrayList<>();
        nameOfText = findViewById(R.id.EditString);
        addCheckBox = findViewById(R.id.AddButton);
        name = new CheckBoxName("");
        myList = findViewById(R.id.list_itemView);

        addCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = new CheckBoxName(nameOfText.getText().toString());
                myArrayList.add(name);
                myAdapter = new CustomAdapter(getApplicationContext(), myArrayList);
                myList.setAdapter(myAdapter);
            }
        });

        myAdapter = new CustomAdapter(getApplicationContext(), myArrayList);
        myList.setAdapter(myAdapter);

    }
}