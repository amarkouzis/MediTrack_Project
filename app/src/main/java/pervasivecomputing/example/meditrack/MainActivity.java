package pervasivecomputing.example.meditrack;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private TextView emptyText;
    private LinearLayout groupFirst, groupWelcome;
    private String selection_first;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emptyText = findViewById(R.id.emptyText);
        groupFirst = findViewById(R.id.groupFirst);
        groupWelcome = findViewById(R.id.groupWelcome);
    }

    androidx.activity.result.ActivityResultLauncher<Intent> ActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();

                        String taken = data.getStringExtra("taken");
                        emptyText.setText("Welcome " + taken + " !");
                        groupWelcome.setVisibility(View.VISIBLE);
                    }
                }
            });
    public void SignUp(View view) {
        Intent setResultsIntent = new Intent(this, Sign_Up_Activity.class);
        ActivityResultLauncher.launch(setResultsIntent);
        groupFirst.setVisibility(View.INVISIBLE);
    }
    public void SignIn(View view) {
        Intent setResultsIntent = new Intent(this, Sign_In_Activity.class);
        ActivityResultLauncher.launch(setResultsIntent);
        groupFirst.setVisibility(View.INVISIBLE);
    }
    public void GoToMyProfile(View view) {
        selection_first = "Medications";
        Intent intent = new Intent(this, Second_Activity.class);
        intent.putExtra("return",selection_first);
        startActivity(intent);
    }
    public void GoToSettings(View view) {
        selection_first = "Settings";
        Intent intent = new Intent(this, First_Activity.class);
        intent.putExtra("return",selection_first);
        startActivity(intent);
    }
    public void GoToCameraActivity(View view) {
        Intent intent = new Intent(this, Camera_Activity.class);
        startActivity(intent);
    }

}
