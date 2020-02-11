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
import e.margi.otpdynamicanotherone.Fragment.CallActivity;
public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.viewholder>

{
    Context mcontext;
    ArrayList<Doctor> doctlist;

    public DoctorAdapter(Context mcontext, ArrayList<Doctor> doctlist)
    {

        this.doctlist = doctlist;
        this.mcontext=mcontext;
    }
    @NonNull
    @Override
    public DoctorAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.doctor_item,viewGroup,false);
        return new DoctorAdapter.viewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.viewholder viewholder, int i) {

        Doctor doctor = doctlist.get(i);
        viewholder.dname.setText(doctor.getDname());
        viewholder.dcontact.setText(doctor.getDcontact());
        viewholder.demail.setText(doctor.getDemail());
        viewholder.dpassword.setText(doctor.getDpassword());

        viewholder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mcontext.startActivity(new Intent(mcontext,CallActivity.class));

            }
        });


    }

    @Override
    public int getItemCount()
    {
        return doctlist.size();
    }

    public  class viewholder extends RecyclerView.ViewHolder
    {
        public TextView dname,dcontact,demail,dpassword;
        // public ImageView profile_image;

        public viewholder(@NonNull View itemView)
        {
            super(itemView);
            dname = itemView.findViewById(R.id.dname);
            dcontact=itemView.findViewById(R.id.dcontact);
            demail=itemView.findViewById(R.id.demail);
            dpassword=itemView.findViewById(R.id.dpass);
            // profile_image=itemView.findViewById(R.id.profile_image);
        }

    }
}
