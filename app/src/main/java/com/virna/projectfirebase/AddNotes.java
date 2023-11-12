package com.virna.projectfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddNotes extends AppCompatActivity {

    private EditText titleEditText;
    private EditText notesEditText;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);

        titleEditText = (EditText) findViewById(R.id.editTitle);
        notesEditText = (EditText) findViewById(R.id.editNotes);
        addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleEditText.getText().toString();
                String notes = notesEditText.getText().toString();

                if (title.isEmpty()){
                    titleEditText.setError("Cannot be Empty");
                    return;
                }
                if (notes.isEmpty()){
                    notesEditText.setError("Cannot be Empty");
                    return;
                }
                addTitleToDB(title, notes);
            }
        });
    }

    private void addTitleToDB(String title, String notes) {
        HashMap<String, Object> titleHashMap = new HashMap<>();
        titleHashMap.put("title", title);
        titleHashMap.put("notes", notes);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference titleRef = database.getReference("title");

        String key = titleRef.push().getKey();
        titleHashMap.put("key", key);

        titleRef.child(key).setValue(titleHashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(AddNotes.this, "added", Toast.LENGTH_SHORT).show();
                titleEditText.getText().clear();
                notesEditText.getText().clear();
            }
        });
    }
}