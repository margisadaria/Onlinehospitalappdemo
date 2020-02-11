package e.margi.otpdynamicanotherone;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Searchscreen extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    RecyclerView recyclerView;
    DatabaseReference reference1;
    private SearchView editsearch;
    //private String[] datalist;


    //ProgressDialog mProgressDialog;
    //DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    Adapterclass adapter;
    ArrayList<Student> list ;

    Button btn_get, btn_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchscreen);

        //btn_back = findViewById(R.id.btn_back);
       // btn_get = findViewById(R.id.getdetail);
        //allusers = findViewById(R.id.allusers);


        firebaseAuth = FirebaseAuth.getInstance();
        reference1 = FirebaseDatabase.getInstance().getReference().child("Student");
        recyclerView = findViewById(R.id.rv);
        editsearch = findViewById(R.id.searchView2);



    }
        protected void onStart() {

            if (reference1 != null) {
                super.onStart();
                reference1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            list = new ArrayList<>();
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                list.add(ds.getValue(Student.class));

                            }
                            Adapterclass adapterclass = new Adapterclass(list);
                            recyclerView.setAdapter(adapterclass);
                        }
                        if (editsearch != null) {
                            editsearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                                @Override
                                public boolean onQueryTextSubmit(String query) {
                                    return false;
                                }

                                @Override
                                public boolean onQueryTextChange(String s) {
                                    search(s);
                                    return false;
                                }
                            });
                        }

                    }

                    private void search(String s) {
                        ArrayList<Student> mylist = new ArrayList<>();
                        for (Student object : list) {
                            if (object.getUsename().toLowerCase().contains(s.toLowerCase())) {
                                mylist.add(object);
                            }/* else if (object.getGuide().toLowerCase().contains(s.toLowerCase())) {
                                mylist.add(object);
                            } else if (object.getClg().toLowerCase().contains(s.toLowerCase())) {
                                mylist.add(object);*/

                        }
                        Adapterclass adapterclass = new Adapterclass(mylist);
                        recyclerView.setAdapter(adapterclass);
                    }


                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(Searchscreen.this, "something wrong", Toast.LENGTH_LONG).show();

                    }
                });
            }
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
                            startActivity(new Intent(Searchscreen.this,Navigation_drawer.class));
                            break;

                    }
                    return true;
                }
            }


