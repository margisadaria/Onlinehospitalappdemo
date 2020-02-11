package e.margi.otpdynamicanotherone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class MessageActivity1  extends AppCompatActivity {
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

        usernamem = findViewById(R.id.username);
        btn_send = findViewById(R.id.btn_send);
        text_send = findViewById(R.id.textsend);
        recyclerView = findViewById(R.id.recyclerviewsend);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        //linearLayoutManager.
        //recyclerView.setLayoutManager(linearLayoutManager);
        intent = getIntent();
        final String userid = intent.getStringExtra("userid");
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                String msg = text_send.getText().toString();
                if (!msg.equals(""))
                {
                    sendmessage(fuser.getUid(),userid,msg);
                }else {
                    Toast.makeText(MessageActivity1.this,"u cant send empty message",Toast.LENGTH_SHORT).show();
                }
                text_send.setText("");
            }
        });
    }

    private void sendmessage(String uid, String userid, String msg) {
    }
}