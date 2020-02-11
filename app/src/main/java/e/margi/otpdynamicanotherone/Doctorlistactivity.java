package e.margi.otpdynamicanotherone;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
          import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Doctorlistactivity extends AppCompatActivity
{
    //FirebaseAuth firebaseAuth;
    //FirebaseUser firebaseUser;
    DatabaseReference databaseReference;
    RecyclerView recyclerViewdoctor;
    ArrayList<Doctor> dlist;
    DoctorAdapter dadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctorlistactivity);
        recyclerViewdoctor = (RecyclerView)findViewById(R.id.recyclerviewdoctor);
        recyclerViewdoctor.setLayoutManager(new LinearLayoutManager(this));

        dlist = new ArrayList<Doctor>();

        //firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        //      String useri//d = firebaseUser.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("Doctor");

       // databaseReference = FirebaseDatabase.getInstance().getReference().child("Doctor");

      databaseReference.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot)
          {
              dlist.clear();
              for (DataSnapshot snapshot : dataSnapshot.getChildren())
              {
               //    Doctor doctor = snapshot.getValue(Doctor.class);
                 // dlist.add(doctor);

                  String name=snapshot.child("dname").getValue().toString();
                  String contact=snapshot.child("dcontact").getValue().toString();
                  String email=snapshot.child("demail").getValue().toString();
                  String pass=snapshot.child("dpass").getValue().toString();
                  Doctor doctor=new Doctor(name,contact,email,pass);
                  dlist.add(doctor);
              }
              dadapter = new DoctorAdapter(Doctorlistactivity.this,dlist);
              recyclerViewdoctor.setAdapter(dadapter);
          }
          @Override
          public void onCancelled(@NonNull DatabaseError databaseError)
          {

          }
      });



    }
}
