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
import android.widget.RadioButton;
import android.widget.Spinner;
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

public class Registrationpage extends AppCompatActivity {

    EditText et_user, et_contact, et_email, et_pass,et_edu, et_birth,et_experience, et_clg, et_projectname, et_grp1, et_grp2, et_guide, et_join, et_end;
    Spinner sp_tech, sp_duration, sp_sem, sp_degree;
    RadioButton r_male, r_female, r_bisag, r_laptop;
    String gender = "";
    Button btn;

    FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrationpage);


        et_user = findViewById(R.id.username);
        et_email = findViewById(R.id.et_email);
        et_pass = findViewById(R.id.et_pass);
        //et_contact = findViewById(R.id.et_contact);
        //et_birth = findViewById(R.id.et_birth);
        //et_edu = findViewById(R.id.edt_edu);
        //et_experience = findViewById(R.id.et_experience);
       /* et_grp1 = findViewById(R.id.et_grp1);
        et_grp2 = findViewById(R.id.et_grp2);
        et_guide = findViewById(R.id.et_guide);
        et_join = findViewById(R.id.et_joining);
        et_end = findViewById(R.id.et_ending);
        sp_tech = findViewById(R.id.sp_tech);
        sp_duration = findViewById(R.id.sp_duration);
        sp_sem = findViewById(R.id.sp_sem);
        sp_degree = findViewById(R.id.sp_degree);*/
       // r_male = findViewById(R.id.r_male);
        //r_female = findViewById(R.id.r_female);
       /* r_bisag = findViewById(R.id.r_BISAG);
        r_laptop = findViewById(R.id.r_LAPTOP);*/
        btn = findViewById(R.id.btn_dreg);

        firebaseAuth = FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = et_user.getText().toString();
                //final String contact = et_contact.getText().toString();
                final String email = et_email.getText().toString();
                final String pass = et_pass.getText().toString();
               /* final String birth = et_birth.getText().toString();
                final String education = et_edu.getText().toString();
                final String experience = et_edu.getText().toString();*/
                /*final String duration = sp_duration.getSelectedItem().toString();
                final String sem = sp_sem.getSelectedItem().toString();
                final String degree = sp_degree.getSelectedItem().toString();
                final String projectname = et_projectname.getText().toString();
                final String grp1 = et_grp1.getText().toString();
                final String grp2 = et_grp2.getText().toString();
                final String guide = et_guide.getText().toString();
                final String join = et_join.getText().toString();
                final String end = et_end.getText().toString();*/

                if (username.isEmpty()) {
                    Toast.makeText(Registrationpage.this, "Enter Username..", Toast.LENGTH_SHORT).show();
                }
               /* if (contact.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Enter Contact Number..", Toast.LENGTH_SHORT).show();
                }
                if (contact.length()<=9){
                    Toast.makeText(Registrationpage.this, "Enter Correct Contact Number..", Toast.LENGTH_SHORT).show();*/
                if (email.isEmpty()) {
                    Toast.makeText(Registrationpage.this, "Enter Email..", Toast.LENGTH_SHORT).show();
                }
                if (pass.isEmpty()) {
                    Toast.makeText(Registrationpage.this, "Enter Password..", Toast.LENGTH_SHORT).show();
                }
                if (pass.length() <= 6) {
                    Toast.makeText(Registrationpage.this, "Enter Grater Then 6 Digit Password..", Toast.LENGTH_SHORT).show();
                }
               /* if (birth.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Enter BirthDate..", Toast.LENGTH_SHORT).show();
                }
                if (clg.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Enter College Name..", Toast.LENGTH_SHORT).show();
                }

                if (tech.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Select Technology..", Toast.LENGTH_SHORT).show();
                }
                if (duration.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Select Duration..", Toast.LENGTH_SHORT).show();
                }
                if (sem.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Select Semester..", Toast.LENGTH_SHORT).show();
                }
                if (degree.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Select Degree..", Toast.LENGTH_SHORT).show();
                }
                if (projectname.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Enter ProjectName..", Toast.LENGTH_SHORT).show();
                }
                if (guide.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Enter GuideName..", Toast.LENGTH_SHORT).show();
                }
                if (join.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Enter Joining Date..", Toast.LENGTH_SHORT).show();
                }
                if (end.isEmpty()){
                    Toast.makeText(Registrationpage.this, "Enter Ending Date..", Toast.LENGTH_SHORT).show();
                }


                if (r_male.isChecked()) {
                    gender = "MALE";
                }
                if (r_female.isChecked()) {
                    gender = "FEMALE";
                }
                if (r_bisag.isChecked()) {
                    tool = "BISAG PC";
                }
                if (r_laptop.isChecked()) {
                    tool = "LAPTOP";


                }*/
                firebaseAuth.createUserWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(Registrationpage.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                                    String userid = firebaseUser.getUid();
                                    databaseReference = FirebaseDatabase.getInstance().getReference("Student").child(userid);

                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("id", userid);
                                    hashMap.put("usename", username);
                                   /* hashMap.put("password",pass);
                                    hashMap.put("contact",contact);
                                    hashMap.put("birthdate",birth);
                                    hashMap.put("education",education);
                                    hashMap.put("experience",experience);*/


                                   /* Student stu = new Student(
                                            username,
                                            contact,
                                            email,
                                            pass
                                           /* birth,
                                            clg,
                                            gender,
                                            tech,
                                            duration,
                                            sem,
                                            degree,
                                            projectname,
                                            grp1,
                                            grp2,
                                            guide,
                                            join,
                                            end,
                                            tool*/



        /*databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Student student = dataSnapshot.getValue(Student.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
                                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(Registrationpage.this, "Registration successfull--y....", Toast.LENGTH_SHORT).show();
                                                startActivity(new Intent(Registrationpage.this, MainActivity.class));

                                            }
                                        }
                                    });

                                   /* FirebaseDatabase.getInstance().getReference("Student")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(stu).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            Toast.makeText(Registrationpage.this, "Registration successfull----y....", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(Registrationpage.this, Groupid.class));

                                            // startActivity(new Intent(Registrationpage.this, BacktoLogin.class));


                                        }
                                    });
*/
                                }

                                else
                                    {

                                        Toast.makeText(Registrationpage.this, "Registration Failed....", Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(Registrationpage.this,Navigation_drawer.class));
                break;

        }
        return true;
    }
/*
    @Override
    public void onBackPressed() {
       // super.onBackPressed();
    }*/
}
