package pervasivecomputing.example.meditrack;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Sign_In_Activity extends AppCompatActivity {

    private EditText signinUsername, signinPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        signinUsername = findViewById(R.id.existUser);
        signinPassword = findViewById(R.id.existPass);
    }
    public void DoneSignIn(View view) {
        if (!validateUsername() | !validatePassword()) {

                } else {
                    checkUser();
                }
    }
    public Boolean validateUsername() {
        String val = signinUsername.getText().toString();
        if (val.isEmpty()) {
            signinUsername.setError("Username cannot be empty");
            return false;
        } else {
            signinUsername.setError(null);
            return true;
        }
    }
    public Boolean validatePassword(){
        String val = signinPassword.getText().toString();
        if (val.isEmpty()) {
            signinPassword.setError("Password cannot be empty");
            return false;
        } else {
            signinPassword.setError(null);
            return true;
        }
    }
    public void checkUser(){
        String userUsername = signinUsername.getText().toString().trim();
        String userPassword = signinPassword.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("UserInfo");
        Query checkUserDatabase = reference.orderByChild("userName").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    signinUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("userPassword").getValue(String.class);
                    if (passwordFromDB.equals(userPassword)) {
                        signinUsername.setError(null);
                        String usernameFromDB = snapshot.child(userUsername).child("userName").getValue(String.class);
                        Intent intent = new Intent();
                        intent.putExtra("taken", usernameFromDB);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    } else {
                        signinPassword.setError("Invalid credentials");
                        signinPassword.requestFocus();
                    }
                } else {
                    signinUsername.setError("User does not exist");
                    signinUsername.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}
