package e.margi.otpdynamicanotherone;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Forgotpass  extends AppCompatActivity {

    ProgressBar progressBar;
    EditText useremail,new_pass;
    Button btn_send,btn_cancle;
    FirebaseUser user ;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);


        progressBar = findViewById(R.id.progresbar);
        useremail = findViewById(R.id.et_forgot_email);
        //new_pass = findViewById(R.id.et_forgot_pass);
        btn_send = findViewById(R.id.btnsend);
        //btn_cancle = findViewById(R.id.btncancle);
        user = FirebaseAuth.getInstance().getCurrentUser();


        firebaseAuth = FirebaseAuth.getInstance();

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                progressBar.setVisibility(v.VISIBLE);
                firebaseAuth.sendPasswordResetEmail(useremail.getText().toString().trim())
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                progressBar.setVisibility(v.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(Forgotpass.this, "PassWord Send To your Email..", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Forgotpass.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            MenuInflater mi = getMenuInflater();
            mi.inflate(R.menu.main, menu);
            return true;

        }
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()){
                case R.id.logout:
                    startActivity(new Intent(Forgotpass.this,Navigation_drawer.class));
                    break;

            }
            return true;
        }
    }

     /*   btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(Forgotpass.this,Login_form.class));

            }
        });*/



