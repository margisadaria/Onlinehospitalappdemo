package e.margi.otpdynamicanotherone;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class Backtologin extends AppCompatActivity
 {
    Button btnbacktologin;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backtologin);
        btnbacktologin = findViewById(R.id.Backtologin);
        btnbacktologin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(Backtologin.this, Login_form.class));
            }
        });
        Toast.makeText(Backtologin.this,"welcome",Toast.LENGTH_LONG).show();


    }

    }
