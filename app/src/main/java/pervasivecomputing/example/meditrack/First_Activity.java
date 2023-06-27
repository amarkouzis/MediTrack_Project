package pervasivecomputing.example.meditrack;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class First_Activity extends AppCompatActivity {

    private String string, selection_second;
    private LinearLayout groupMyProfile, groupSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Intent intent = getIntent();
        string = intent.getStringExtra("return");
        setVisible(string);

    }
    public void GoToEdit(View view) {
        selection_second = "Edit";
        Intent intent = new Intent(First_Activity.this, Second_Activity.class);
        intent.putExtra("return",selection_second);
        startActivity(intent);
    }
    public void GoToDelete(View view) {
        selection_second = "Delete";
        Intent intent = new Intent(First_Activity.this, Second_Activity.class);
        intent.putExtra("return",selection_second);
        startActivity(intent);
    }
    public void setVisible(String str)
    {
        if(str.equals("Settings")){
            groupSettings = (LinearLayout) findViewById(R.id.groupSettings);
            groupSettings.setVisibility(View.VISIBLE);
        }
    }
}
