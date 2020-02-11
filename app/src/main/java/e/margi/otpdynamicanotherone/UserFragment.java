package e.margi.otpdynamicanotherone;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment
{
     private RecyclerView recyclerviewuser1;
    private UserAdapter userAdapter;
    private List<Student> users1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment_user, container, false);
        recyclerviewuser1 = view.findViewById(R.id.recyclerviewuser);
        recyclerviewuser1.setHasFixedSize(true);
        recyclerviewuser1.setLayoutManager(new LinearLayoutManager(getContext()));
        users1 = new ArrayList<>();
        readUser();
        // Inflate the layout for this fragment
        return view;

    }

private void readUser()
    {
        final FirebaseUser firebaseuser = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Student");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users1.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren())
                {
                   // String userid = firebaseuser.getUid();

                    Student student = snapshot.getValue(Student.class);
                   // String id = snapshot.child("userid").getValue().toString();
                    //String name=snapshot.child("usename").getValue().toString();
                  //  Student student=new Student(name);

                    users1.add(student);

                    }
                userAdapter = new UserAdapter(getContext(), users1);
                recyclerviewuser1.setAdapter(userAdapter);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    }

