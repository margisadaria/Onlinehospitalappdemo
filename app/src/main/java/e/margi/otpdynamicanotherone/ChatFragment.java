package e.margi.otpdynamicanotherone;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
public class ChatFragment extends Fragment {
    private RecyclerView recyclerView1;
    private UserAdapter userAdapter;
    private List<Student> musers;
    private List<String> userlist;
    FirebaseUser firebaseuser;
    DatabaseReference reference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);


        recyclerView1 = view.findViewById(R.id.recyclerviewchat);

        recyclerView1.setHasFixedSize(true);

        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        userlist = new ArrayList<>();

        firebaseuser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Chats");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userlist.clear();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    chat chat = snapshot.getValue(e.margi.otpdynamicanotherone.chat.class);
                    if (chat.getSender().equals(firebaseuser.getUid())) {
                        userlist.add(chat.getReceiver());
                    }
                    if (chat.getReceiver().equals(firebaseuser.getUid())) {
                        userlist.add(chat.getSender());
                    }
                }
                readchats();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return view;
    }


    private void readchats() {
        musers = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("Student");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                musers.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Student student = snapshot.getValue(Student.class);
                    for (String id : userlist) {
                        if (student.getId().equals(id)) {
                            if (musers.size() != 0) {
                                for (Student student1 : musers) {
                                    if (!student.getId().equals(student1.getId())) {
                                        musers.add(student);
                                    }
                                }
                            } else {
                                musers.add(student);
                            }
                        }
                    }
                }

                userAdapter = new UserAdapter(getContext(), musers);
                recyclerView1.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}