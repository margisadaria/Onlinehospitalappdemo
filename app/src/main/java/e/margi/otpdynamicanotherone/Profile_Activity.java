package e.margi.otpdynamicanotherone;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Profile_Activity extends AppCompatActivity {

    TextView usernamepatient;//contact,email,pass,birth,clg,gender,tech,duration,sem,degree,projectname,grp1,grp2,guide,join,end,tool;

    //FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    //FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_list);

        Toast.makeText(Profile_Activity.this,"hello",Toast.LENGTH_LONG);
        usernamepatient = findViewById(R.id.prtvname);
        /*contact = findViewById(R.id.prtvcontact);
        email = findViewById(R.id.prtvemail);
        pass = findViewById(R.id.prtvpass);
        birth = findViewById(R.id.prtvbirth);
        clg = findViewById(R.id.prtvclg);
        gender = findViewById(R.id.prtvgender);
        tech = findViewById(R.id.prtvtech);
        duration = findViewById(R.id.prtvduration);
        sem = findViewById(R.id.prtvsem);
        degree = findViewById(R.id.prtvdegree);
        projectname = findViewById(R.id.prtvproname);
        grp1 = findViewById(R.id.prtvgrp1);
        grp2 = findViewById(R.id.prtvgrp2);
        guide = findViewById(R.id.prtvguide);
        join = findViewById(R.id.prtvjoin);
        end = findViewById(R.id.prtvend);
        tool = findViewById(R.id.prtvtool);*/



//        firebaseAuth = FirebaseAuth.getInstance();
  //     firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        //databaseReference = FirebaseDatabase.getInstance().getReference("Student").child(fuser.getUid());
       // firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        //databaseReference = FirebaseDatabase.getInstance().getReference("Student").child(firebaseUser.getUid());

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Student").child("1PMM6gL5VCWW85bv3zzWulLv4fD3");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                String name = dataSnapshot.child("username").getValue().toString();
                usernamepatient.setText(name);


                   // for(DataSnapshot postSnapShot:dataSnapshot.getChildren())
                    //{

                        //Student user = dataSnapshot.getValue(Student.class);
                       // usernamepatient.setText(user.getUsername());
                        //contact.setText(user.getContact());
                        //email.setText(user.getEmail());
                        //pass.setText(user.getPass());
                      /*  birth.setText(user.getBirth());
                        clg.setText(user.getClg());
                        gender.setText(user.getGender());
                        tech.setText(user.getTech());
                        duration.setText(user.getDuration());
                        sem.setText(user.getSem());
                        degree.setText(user.getDegree());
                        projectname.setText(user.getProjectname());
                        grp1.setText(user.getGrp1());
                        grp2.setText(user.getGrp2());
                        guide.setText(user.getGuide());
                        join.setText(user.getJoin());
                        end.setText(user.getEnd());
                        tool.setText(user.getTool());*/

                    }


                 //Toast.makeText(Profile_Activity.this, firebaseAuth.getUid(), Toast.LENGTH_SHORT).show();



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(Profile_Activity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.stu_meny,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout:
                startActivity(new Intent(Profile_Activity.this,Taglayoutactivity.class));
                break;
            case R.id.gotodoctor:
                startActivity(new Intent(Profile_Activity.this,Login_form.class));

        }
        return true;
    }
   /* public void ShowUpdateDialog(String username, String contact, String email,String pass, String birth, String clg, String gender, String tech, String duration,String sem,String degree,String projectname,String grp1,String grp2,String guide,String join,String end,String tool ){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogview = inflater.inflate(R.layout.update_login,null);
        dialogBuilder.setView(dialogview);

        // TextView textView = dialogview.findViewById(R.id.tv_up);
        EditText etname= dialogview.findViewById(R.id.uprtvname);
        EditText etcon= dialogview.findViewById(R.id.uprtvname);
        EditText etemail= dialogview.findViewById(R.id.uprtvname);
        EditText etpass= dialogview.findViewById(R.id.uprtvname);
        EditText etbirth= dialogview.findViewById(R.id.uprtvname);
        EditText etclg= dialogview.findViewById(R.id.uprtvname);
        EditText etgender= dialogview.findViewById(R.id.uprtvname);
        EditText ettech= dialogview.findViewById(R.id.uprtvname);
        EditText etduration= dialogview.findViewById(R.id.uprtvname);
        EditText etsem= dialogview.findViewById(R.id.uprtvname);
        EditText etdegree= dialogview.findViewById(R.id.uprtvname);
        EditText etproname= dialogview.findViewById(R.id.uprtvname);
        EditText etgrp1= dialogview.findViewById(R.id.uprtvname);
        EditText etgrp2= dialogview.findViewById(R.id.uprtvname);
        EditText etguide= dialogview.findViewById(R.id.uprtvname);
        EditText etjoin= dialogview.findViewById(R.id.uprtvname);
        EditText etend= dialogview.findViewById(R.id.uprtvname);
        EditText ettool= dialogview.findViewById(R.id.uprtvname);

        Button btn_update = dialogview.findViewById(R.id.btn_up_update);
        dialogBuilder.setTitle("Update Student"+username);

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

    }*/
}



