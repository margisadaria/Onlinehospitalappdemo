package e.margi.otpdynamicanotherone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Doctorpatientlist extends AppCompatActivity {
    Button doctorlist,patientlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorpatientlist);


        doctorlist = findViewById(R.id.doctorlistbutton);
        patientlist = findViewById(R.id.patientlistbutton);

        doctorlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Doctorpatientlist.this, Doctorlistactivity.class));

            }
        });

        patientlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Doctorpatientlist.this,Patientlistactivity.class));

            }
        });
    }
}
