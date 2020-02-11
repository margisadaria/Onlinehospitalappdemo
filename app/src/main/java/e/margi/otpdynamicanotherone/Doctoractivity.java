package e.margi.otpdynamicanotherone;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Doctoractivity extends AppCompatActivity {

    EditText doctorname, doctorcontact, doctoremail, doctorpass;
    Button btndoctor;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_activity);

        doctorname = findViewById(R.id.et_duser);
        doctorcontact = findViewById(R.id.et_dcontact);
        doctoremail = findViewById(R.id.et_demail);
        doctorpass = findViewById(R.id.et_dpass);
        btndoctor = findViewById(R.id.doctorbtn_reg);

        firebaseAuth = FirebaseAuth.getInstance();
        btndoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(Doctoractivity.this,"Helllo",Toast.LENGTH_LONG).show();


                final String dname = doctorname.getText().toString();
                final String dcontact = doctorcontact.getText().toString();
                final String demail = doctoremail.getText().toString();
                final String dpass = doctorpass.getText().toString();
                firebaseAuth.createUserWithEmailAndPassword(demail, dpass)
                        .addOnCompleteListener(Doctoractivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                    String userid = firebaseUser.getUid();
                                    databaseReference = FirebaseDatabase.getInstance().getReference("Doctor").child(userid);


                                    HashMap<String, String> hashMap = new HashMap<>();
                                    //hashMap.put("id", userid);
                                    hashMap.put("dname", dname);
                                    hashMap.put("dcontact",dcontact);
                                    hashMap.put("demail",demail);
                                    hashMap.put("dpass",dpass);

                                databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>()
                                {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful())
                                        {
                                            startActivity(new  Intent(Doctoractivity.this, UploadImage.class));

                                            Toast.makeText(Doctoractivity.this, "Registration successfully", Toast.LENGTH_LONG).show();

                                        }


                                    }

                        });

                                }
                                                                  }

                        });
            }
        });

    }

}