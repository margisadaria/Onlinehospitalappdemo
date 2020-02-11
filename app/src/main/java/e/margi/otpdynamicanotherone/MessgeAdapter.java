package e.margi.otpdynamicanotherone;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class MessgeAdapter  extends RecyclerView.Adapter<MessgeAdapter.viewholder>
{
    public static  final int MSG_TYPE_LEFT=0;
    public static  final int MSG_TYPE_RIGHT=1;

    private Context mcontext;
    private List<chat> mchat;
    private String imageurl;
    FirebaseUser fuser;

    public MessgeAdapter (Context mcontext, List<chat> mchat, String imageurl)
    {
        //this.mcontext=mcontext;
        this.imageurl=imageurl;
        this.mchat=mchat;
        this.mcontext=mcontext;
    }

    @NonNull
    @Override
    public MessgeAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (i==MSG_TYPE_RIGHT)
        {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.chat_item_right,parent,false);
        return new MessgeAdapter.viewholder(view);
    }
    else {
            View view = LayoutInflater.from(mcontext).inflate(R.layout.chat_item_left,parent,false);
            return new MessgeAdapter.viewholder(view);
        }
        }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, int i) {
        final chat chat = mchat.get(i);
        viewholder.showmessage.setText(chat.getMessage());
        if(imageurl.equals("default"))
        {
            viewholder.profile_image.setImageResource(R.mipmap.ic_launcher1);
        }
        else {
            Glide.with(mcontext).load(imageurl).into(viewholder.profile_image);
        }
    }

    @Override
    public int getItemCount()
    {
        return  mchat.size();
    }

    public  class viewholder extends RecyclerView.ViewHolder {
        public TextView showmessage;
        public ImageView profile_image;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            showmessage = itemView.findViewById(R.id.showmessage);
            profile_image = itemView.findViewById(R.id.profile_image);
            //profile_image=itemView.findViewById(R.id.profile_image);
        }
    }

    @Override
    public int getItemViewType(int position)
    {
        fuser = FirebaseAuth
                .getInstance().getCurrentUser();
        if (mchat.get(position).getSender().equals(fuser.getUid()))
        {
            return MSG_TYPE_RIGHT;
        }
        else
        {
            return MSG_TYPE_LEFT;
        }

    }
}
