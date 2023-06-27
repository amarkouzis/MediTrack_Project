package pervasivecomputing.example.meditrack;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Second_Activity extends AppCompatActivity {
    private String string;
    private EditText editUsername, editFullname, editAge, editGender, editPassword, delMed, editSearch, viewMed, viewText;
    private LinearLayout groupChanges, groupDelete, groupMed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        string = intent.getStringExtra("return");
        if (string == null)
        {
            string = "Edit";
        }
        setVisible(string);

        viewMed = findViewById(R.id.viewMed);
        viewText = findViewById(R.id.viewTextMed);
        editSearch = findViewById(R.id.searchMed);
        delMed = findViewById(R.id.deleteMed);
        editUsername = findViewById(R.id.editUsername);
        editFullname = findViewById(R.id.editFullname);
        editAge = findViewById(R.id.editAge);
        editGender = findViewById(R.id.editGender);
        editPassword = findViewById(R.id.editPassword);

    }
    public void saveEdit(View view){
        if (!validateUsername() | !validatePassword() | !validateFullname()){
        }
        else {
            checkUser();
        }
    }
    public void deleteMed(View view){
        if (!validateMedication()){
        }
        else {
            checkMed();
        }
    }
    public void searchMed(View view){
        if (!validateMedication2()){
        }
        else {
            searchMed();
        }
    }
    public Boolean validateMedication2() {
        String val = editSearch.getText().toString();
        if (val.isEmpty()) {
            editSearch.setError("Medication's name cannot be empty");
            editSearch.requestFocus();
            return false;
        } else {
            editSearch.setError(null);
            return true;
        }
    }
    public Boolean validateMedication() {
        String val = delMed.getText().toString();
        if (val.isEmpty()) {
            delMed.setError("Medication's name cannot be empty");
            delMed.requestFocus();
            return false;
        } else {
            delMed.setError(null);
            return true;
        }
    }
    public Boolean validateUsername() {
        String val = editUsername.getText().toString();
        if (val.isEmpty()) {
            editUsername.setError("Username cannot be empty");
            editUsername.requestFocus();
            return false;
        } else {
            editUsername.setError(null);
            return true;
        }
    }
    public Boolean validatePassword(){
        String val = editPassword.getText().toString();
        if (val.isEmpty()) {
            editPassword.setError("Password cannot be empty");
            editPassword.requestFocus();
            return false;
        } else {
            editPassword.setError(null);
            return true;
        }
    }
    public Boolean validateFullname(){
        String val = editFullname.getText().toString();
        if (val.isEmpty()) {
            editFullname.setError("Fullname cannot be empty");
            editFullname.requestFocus();
            return false;
        } else {
            editFullname.setError(null);
            return true;
        }
    }
    public void searchMed(){
        String med = editSearch.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Medications");
        Query checkUserDatabase = reference.orderByChild("medicationsName").equalTo(med);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    editSearch.setError(null);
                    String text = snapshot.child(med).child("recognizedText").getValue(String.class);
                    viewText.setText(text);
                    viewMed.setText(med);
                } else {
                    editSearch.setError("Medication does not exist");
                    editSearch.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public void checkMed(){
        String nameMedication = delMed.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Medications");
        reference.orderByChild("medicationsName").equalTo(nameMedication)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            for (DataSnapshot ds : snapshot.getChildren()){
                                ds.getRef().removeValue();
                                Toast.makeText(Second_Activity.this, "Deleted", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }
                        else{
                            delMed.setError("Medication does not exist");
                            delMed.requestFocus();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Second_Activity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void checkUser(){
        String userUsername = editUsername.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("UserInfo");
        Query checkUserDatabase = reference.orderByChild("userName").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    editUsername.setError(null);
                    reference.child(userUsername).child("userFullname").setValue(editFullname.getText().toString());
                    reference.child(userUsername).child("userAge").setValue(editAge.getText().toString());
                    reference.child(userUsername).child("userGender").setValue(editGender.getText().toString());
                    reference.child(userUsername).child("userPassword").setValue(editPassword.getText().toString());
                    finish();
                }
                else{
                    editUsername.setError("User does not exist");
                    editUsername.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public void setVisible(String str)
    {
        if(str.equals("Edit")){
            groupChanges = (LinearLayout) findViewById(R.id.groupEdit);
            groupChanges.setVisibility(View.VISIBLE);
            groupChanges.bringToFront();
        }
        if(str.equals("Delete")){
            groupDelete = (LinearLayout) findViewById(R.id.groupDelete);
            groupDelete.setVisibility(View.VISIBLE);
            groupDelete.bringToFront();
        }
        if(str.equals("Medications")){
            groupMed = (LinearLayout) findViewById(R.id.groupMedications);
            groupMed.setVisibility(View.VISIBLE);
            groupMed.bringToFront();
        }
    }
}
