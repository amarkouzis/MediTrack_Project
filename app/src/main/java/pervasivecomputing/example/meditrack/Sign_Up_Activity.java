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
import com.google.firebase.database.ValueEventListener;

public class Sign_Up_Activity extends AppCompatActivity {

    private EditText edtUserName, edtUserFullname, edtUserAge, edtUserGender, edtUserPassword;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    UserInfo userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtUserName = findViewById(R.id.editUsername);
        edtUserFullname = findViewById(R.id.editFullname);
        edtUserAge = findViewById(R.id.editAge);
        edtUserGender = findViewById(R.id.editGender);
        edtUserPassword = findViewById(R.id.editPassword);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserInfo");
        userInfo = new UserInfo();
    }
    public void DoneSignUp(View view) {
        String usernm = edtUserName.getText().toString();
        String name = edtUserFullname.getText().toString();
        String age = edtUserAge.getText().toString();
        String gender = edtUserGender.getText().toString();
        String password = edtUserPassword.getText().toString();

        if (!validateUsername() | !validatePassword() | !validateFullname()) {

        } else {
            addDatatoFirebase(usernm, name, age, gender, password);
            Intent intent = new Intent();
            intent.putExtra("taken", usernm);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
    }
    public Boolean validateUsername() {
        String val = edtUserName.getText().toString();
        if (val.isEmpty()) {
            edtUserName.setError("Username cannot be empty");
            return false;
        } else {
            edtUserName.setError(null);
            return true;
        }
    }
    public Boolean validatePassword(){
        String val = edtUserPassword.getText().toString();
        if (val.isEmpty()) {
            edtUserPassword.setError("Password cannot be empty");
            return false;
        } else {
            edtUserPassword.setError(null);
            return true;
        }
    }
    public Boolean validateFullname(){
        String val = edtUserFullname.getText().toString();
        if (val.isEmpty()) {
            edtUserFullname.setError("Fullname cannot be empty");
            return false;
        } else {
            edtUserFullname.setError(null);
            return true;
        }
    }
    private void addDatatoFirebase(String usernm, String name, String age, String gender, String password){
        userInfo.setUserName(usernm);
        userInfo.setUserFullname(name);
        userInfo.setUserAge(age);
        userInfo.setUserGender(gender);
        userInfo.setUserPassword(password);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                databaseReference.child(usernm).setValue(userInfo);
                Toast.makeText(Sign_Up_Activity.this, "Data added", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Sign_Up_Activity.this, "Fail to add data " + error, Toast.LENGTH_SHORT).show();
            }
        });
    }
}