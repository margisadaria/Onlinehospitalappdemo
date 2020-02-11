package e.margi.otpdynamicanotherone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Paientfirstpage extends AppCompatActivity
{
    Button Registration,Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paientfirstpage);

        Login = findViewById(R.id.Loginpatiient);
        Registration = findViewById(R.id.Registration);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Paientfirstpage.this, Login_form.class));

            }
        });

        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Paientfirstpage.this,PatientRegistration.class));

            }
        });

    }
}
