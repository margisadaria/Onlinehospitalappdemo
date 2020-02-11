package e.margi.otpdynamicanotherone;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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
public class PatientRegistration extends AppCompatActivity
{

    EditText pname,page, problem,pemail,ppassword;
    RadioButton r_male, r_female;
    RadioButton myself, mother, father, daughter, son;
    Button Consultation,backtologinpage;
   // RadioGroup radioGroupgender,radioGrouppatient;
    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    String gender = "";
    String whoisthepatient="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        pname = findViewById(R.id.pusername);
        page = findViewById(R.id.page);
        problem = findViewById(R.id.pproblem);
        myself = findViewById(R.id.pmyself);
        mother = findViewById(R.id.pmother);
        father = findViewById(R.id.pfather);
        daughter = findViewById(R.id.pdaughter);
        son = findViewById(R.id.pson);
        Consultation = findViewById(R.id.consultation);
        r_male=findViewById(R.id.pmale);
        r_female=findViewById(R.id.pfemale);
        pemail = findViewById(R.id.pemail);
        ppassword=findViewById(R.id.ppassword);
        backtologinpage=findViewById(R.id.backtologinpage);

        //radioGroupgender =findViewById(R.id.gender);
        //radioGrouppatient=findViewById(R.id.patientradio);


        firebaseAuth = FirebaseAuth.getInstance();
        Consultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(PatientRegistration.this,"Helllo",Toast.LENGTH_SHORT).show();
            //  String gender = "";

                final String patientname = pname.getText().toString();
                final String patientage = page.getText().toString();
                final String patientproblem = problem.getText().toString();
                final String patientemail = pemail.getText().toString();
                final String patientpassword = ppassword.getText().toString();
                /*final String pmyself = myself.getText().toString();
                final String pmother = mother.getText().toString();
                final String pfather = father.getText().toString();
                final String pdaughter = daughter.getText().toString();
                final String pson = son.getText().toString();*/
                if(r_male.isChecked())
                {
                    gender = "Male";
                }
                if(r_female.isChecked())
                {
                    gender = "FeMale";
                }
                if(myself.isChecked())
                {
                    whoisthepatient = "Myself";
                }
                if(mother.isChecked())
                {
                    whoisthepatient = "mother";
                }
                if(father.isChecked())
                {
                    whoisthepatient = "father";
                }
                if(daughter.isChecked())
                {
                    whoisthepatient = "daughter";
                }
                if(son.isChecked())
                {
                    whoisthepatient = "Son";
                }



                firebaseAuth.createUserWithEmailAndPassword(patientemail, patientpassword)
                        .addOnCompleteListener(PatientRegistration.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful())
                                {
                                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                    String userid = firebaseUser.getUid();
                                    databaseReference = FirebaseDatabase.getInstance().getReference("Patient").child(userid);


                                    /*HashMap<String, String> hashMap = new HashMap<>();
                                    //hashMap.put("id", userid);
                                    hashMap.put("pname", patientname);
                                    hashMap.put("age",patientage);
                                    hashMap.put("problem",patientproblem);
                                    hashMap.put("gender",gender);
                                    hashMap.put("wpatient",whoisthepatient);
                                    hashMap.put("pemail",patientemail);
                                    hashMap.put("ppassword",patientpassword);*/


                                    Patient patient = new Patient(
                                            patientname,
                                            patientage,
                                            gender,
                                            patientemail,
                                            patientpassword,
                                            whoisthepatient,
                                            patientproblem );

                                    databaseReference.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            Patient patient1 = dataSnapshot.getValue(Patient.class);

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    FirebaseDatabase.getInstance().getReference("Patient")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(patient).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(PatientRegistration.this, "Registration successfull----y....", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(PatientRegistration.this,Doctorlistactivity.class));

                                            // startActivity(new Intent(Registrationpage.this, BacktoLogin.class));


                                        }
                                    });


                                }
                                else
                                {

                                    Toast.makeText(PatientRegistration.this, "Registration Failed....", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                backtologinpage.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                         startActivity(new Intent(PatientRegistration.this, Login_form.class));

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
