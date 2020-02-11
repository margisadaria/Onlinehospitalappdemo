package e.margi.otpdynamicanotherone;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewholder>
{
    Context mcontext;
    List<Student> users1;
   // ArrayList<Student> profiles;

    public UserAdapter(Context mcontext, List<Student> users1)
    {
        //this.mcontext=mcontext;
        //this.musers=musers;
       this.users1=users1;
        this.mcontext=mcontext;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(mcontext).inflate(R.layout.user_item,parent,false);
        return new UserAdapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {
        final Student student = users1.get(i);
        viewholder.usename.setText(student.getUsename());

viewholder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(mcontext,MessageActivity.class);
        intent.putExtra("userid",(student.getId()));
        mcontext.startActivity(intent);

    }
});
    }

    @Override
    public int getItemCount()
    {
        return  users1.size();
    }

    public  class viewholder extends RecyclerView.ViewHolder
    {
        public TextView usename;
       // public ImageView profile_image;

        public viewholder(@NonNull View itemView)
        {
            super(itemView);
            usename= itemView.findViewById(R.id.usename);
           // profile_image=itemView.findViewById(R.id.profile_image);
        }

    }
}
