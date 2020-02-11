package e.margi.otpdynamicanotherone;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import e.margi.otpdynamicanotherone.Fragment.Address;

public class Medicalorder extends AppCompatActivity
{
    EditText address,pincode,mobilenoy;
    Button buttonconfirm;
    FirebaseAuth firebaseAuth1;
    DatabaseReference databaseReference1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicalorder);

        address = findViewById(R.id.addressorder);
        pincode = findViewById(R.id.pincode);
        mobilenoy = findViewById(R.id.mobilenoy);
        buttonconfirm = findViewById(R.id.btnconfirmo);
        firebaseAuth1 = FirebaseAuth.getInstance();

        buttonconfirm.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)

            {
                Toast.makeText(Medicalorder.this,"Helllo",Toast.LENGTH_SHORT).show();

                final String address1 = address.getText().toString();
                final String pincode1 = pincode.getText().toString();
                final String mobileno1 =mobilenoy.getText().toString();



                firebaseAuth1.createUserWithEmailAndPassword(address1,pincode1)
                        .addOnCompleteListener(Medicalorder.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    FirebaseUser firebaseUser = firebaseAuth1.getCurrentUser();
                                    String userid = firebaseUser.getUid();
                                    databaseReference1 = FirebaseDatabase.getInstance().getReference("Address").child(userid);


                                    HashMap<String, String> hashMap = new HashMap<>();
                                    //hashMap.put("id", userid);
                                    hashMap.put("address", address1);
                                    hashMap.put("mobileno",mobileno1);
                                    hashMap.put("pincode",pincode1);



                                   /* Address address = new Address(
                                            address1,
                                            pincode1,
                                            mobileno1
                                             );*/

                                    databaseReference1.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            Address address = dataSnapshot.getValue(Address.class);

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    FirebaseDatabase.getInstance().getReference("Address")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(address).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(Medicalorder.this, "Registration successfull----y....", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(Medicalorder.this,Doctorlistactivity.class));

                                            // startActivity(new Intent(Registrationpage.this, BacktoLogin.class));


                                        }
                                    });


                                }
                                else
                                {

                                    Toast.makeText(Medicalorder.this, "Registration Failed....", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


                                   /* databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>()
                                    {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                startActivity(new Intent(PatientRegistration.this, Login_form.class));

                                                Toast.makeText(PatientRegistration.this, "Registration successfull----y....", Toast.LENGTH_LONG).show();

                                            }


                                        }

                                    });*/

            }
        });

    }
}


