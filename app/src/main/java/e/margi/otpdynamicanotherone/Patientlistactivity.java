package e.margi.otpdynamicanotherone;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;

public class Patientlistactivity extends AppCompatActivity
{
    //FirebaseAuth firebaseAuth;
    //FirebaseUser firebaseUser;
    DatabaseReference databaseReference;
    RecyclerView recyclerViewpatient;
    ArrayList<Patient> plist;
    PatientAdapter padapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patientlist);
        recyclerViewpatient = (RecyclerView)findViewById(R.id.recyclerviewpatient);
        recyclerViewpatient.setLayoutManager(new LinearLayoutManager(this));

        plist = new ArrayList<Patient>();

        //firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        //      String useri//d = firebaseUser.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference("Patient");

        // databaseReference = FirebaseDatabase.getInstance().getReference().child("Doctor");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                plist.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                    //    Doctor doctor = snapshot.getValue(Doctor.class);
                    // dlist.add(doctor);

                    String patientname1=snapshot.child("pname").getValue().toString();
                    String patientage1=snapshot.child("age").getValue().toString();
                    String patientemail1=snapshot.child("pemail").getValue().toString();
                    String patientpassword1=snapshot.child("ppassword").getValue().toString();
                    String pgender1=snapshot.child("gender").getValue().toString();
                    String whoisthepatient1=snapshot.child("wpatient").getValue().toString();
                    String whatstheproblem1=snapshot.child("problem").getValue().toString();

                    Patient patient=new Patient(patientname1,patientage1,patientemail1,patientpassword1,pgender1,whoisthepatient1,whatstheproblem1);
                    plist.add(patient);
                }
                padapter = new PatientAdapter(Patientlistactivity.this,plist);
                recyclerViewpatient.setAdapter(padapter);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });



    }
}
