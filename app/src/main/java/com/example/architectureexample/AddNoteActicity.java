package com.example.architectureexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddNoteActicity extends AppCompatActivity {
    public static final String EXTRA_TITLE = "Com.example.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESC = "Com.example.architectureexample.EXTRA_DESC";
    public static final String EXTRA_PRIORITY = "Com.example.architectureexample.EXTRA_PRIORITY";
    EditText editTextTitle, editTextDesc;
    NumberPicker numberPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note_acticity);

        editTextTitle = findViewById(R.id.ed_title);
        editTextDesc = findViewById(R.id.ed_des);
        numberPicker = findViewById(R.id.numberpicker);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(10);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Note");

    }

    private void saveNote(){
        String title = editTextTitle.getText().toString();
        String des = editTextDesc.getText().toString();
        int priority = numberPicker.getValue();

        if (title.trim().isEmpty() || des.trim().isEmpty())
        {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE,title);
        data.putExtra(EXTRA_DESC,des);
        data.putExtra(EXTRA_PRIORITY,priority);
        setResult(RESULT_OK,data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
