package e.margi.otpdynamicanotherone;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapterclass extends RecyclerView.Adapter<Adapterclass.Myviewholder>
{
    ArrayList<Student> list;
    public Adapterclass(ArrayList<Student> list)
    {
        this.list = list;
    }


    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()). inflate(R.layout.card_holder,viewGroup,false);
        return new Myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder myviewholder, int i)
    {
        myviewholder.username.setText(list.get(i).getUsename());
       // myviewholder.contact.setText(list.get(i).getContact());
       // myviewholder.email.setText(list.get(i).getEmail());
        //myviewholder.pass.setText(list.get(i).getPass());
       // myviewholder.edu.setText(list.get(i).getEducation());
        //myviewholder.experience.setText(list.get(i).getExperience());

        //myviewholder.getItemId();
      /*  myviewholder.birth.setText(list.get(i).getBirth());
        myviewholder.clg.setText(list.get(i).getClg());
        myviewholder.gender.setText(list.get(i).getGender());
        myviewholder.tech.setText(list.get(i).getTech());
        myviewholder.duration.setText(list.get(i).getDuration());
        myviewholder.sem.setText(list.get(i).getSem());
        myviewholder.degree.setText(list.get(i).getDegree());
        myviewholder.projectname.setText(list.get(i).getProjectname());
        myviewholder.grp1.setText(list.get(i).getGrp1());
        myviewholder.grp2.setText(list.get(i).getGrp2());
        myviewholder.guide.setText(list.get(i).getGuide());
        myviewholder.join.setText(list.get(i).getJoin());
        myviewholder.end.setText(list.get(i).getEnd());
        myviewholder.tool.setText(list.get(i).getTool());*/


    }

    @Override
    public int getItemCount()
    {

        return list.size();
    }
    class  Myviewholder extends RecyclerView.ViewHolder
    {
        TextView username,contact,pass,email,birth,edu,experience,tech,duration,sem,degree,projectname,grp1,grp2,guide,join,end,tool;
        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.tvname);
           // contact = itemView.findViewById(R.id.tvcontact);
            pass = itemView.findViewById(R.id.tvpass);
            email = itemView.findViewById(R.id.tvemail);
           // birth = itemView.findViewById(R.id.tvbirth);
            //edu = itemView.findViewById(R.id.tvedu);
            //experience = itemView.findViewById(R.id.tvexperience);
           /* tech = itemView.findViewById(R.id.tvtech);
            duration = itemView.findViewById(R.id.tvduration);
            sem = itemView.findViewById(R.id.tvsem);
            degree = itemView.findViewById(R.id.tvdegree);
            projectname = itemView.findViewById(R.id.tvproname);
            grp1 = itemView.findViewById(R.id.tvgrp1);
            grp2 = itemView.findViewById(R.id.tvgrp2);
            guide = itemView.findViewById(R.id.tvguide);
            join = itemView.findViewById(R.id.tvjoin);
            end = itemView.findViewById(R.id.tvend);
            tool = itemView.findViewById(R.id.tvtool);*/


        }
    }
}
