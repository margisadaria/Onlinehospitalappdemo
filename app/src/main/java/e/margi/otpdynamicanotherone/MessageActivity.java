package e.margi.otpdynamicanotherone;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import java.util.List;
public class MessageActivity extends AppCompatActivity
{
    TextView usernamem;
    EditText text_send;
    ImageButton btn_send;
    FirebaseUser fuser;
    DatabaseReference reference;
    Intent intent;
    MessgeAdapter messgeAdapter;
    List<chat> mchat;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        /*usernamem=findViewById(R.id.username);
        btn_send=findViewById(R.id.btn_send);
        text_send=findViewById(R.id.textsend);
        recyclerView=findViewById(R.id.recyclerviewsend);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
       // linearLayoutManager.setStackFromEnd(true);
        //recyclerView.setLayoutManager(linearLayoutManager);
        intent = getIntent();
        final String userid = intent.getStringExtra("userid");
        btn_send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               String msg = text_send.getText().toString();
               if (!msg.equals(""))
               {
                   sendmessage(fuser.getUid(),userid,msg);
               }else {
                   Toast.makeText(MessageActivity.this,"u cant send empty message",Toast.LENGTH_SHORT).show();
               }
               text_send.setText("");
            }
        });
        fuser = FirebaseAuth.getInstance().getCurrentUser();


        reference = FirebaseDatabase.getInstance().getReference("Student").child(userid);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Student student = dataSnapshot.getValue(Student.class);
                usernamem.setText(student.getUsename());
                readmessage(fuser.getUid(), userid, student.getId());
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private  void sendmessage(String sender,String receiver,String message)
    {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("sender",sender);
        hashMap.put("receiver",receiver);
        hashMap.put("message",message);
        reference.child("chat").push().setValue(hashMap);
    }
    private void readmessage(final String myid, final String Userid, final String imageurl) {
        mchat = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("chat");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mchat.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    chat chat = snapshot.getValue(chat.class);
                    if (chat.getReceiver().equals(myid) && chat.getSender().equals(Userid)) {
                        mchat.add(chat);
                    }
                    messgeAdapter = new MessgeAdapter(MessageActivity.this, mchat, imageurl);
                    recyclerView.setAdapter(messgeAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }*/

    }
}


