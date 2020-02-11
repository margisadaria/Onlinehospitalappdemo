package e.margi.otpdynamicanotherone;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import e.margi.otpdynamicanotherone.Fragment.CallActivity;

public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.viewholder>

        {
        Context mcontext;
        ArrayList<Patient> Patientlist;

public PatientAdapter(Context mcontext, ArrayList<Patient> Patientlist)
        {

        this.Patientlist = Patientlist;
        this.mcontext=mcontext;
        }

@NonNull
@Override
public PatientAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
        {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.patient_item,viewGroup,false);
        return new PatientAdapter.viewholder(view);

        }

            @Override
            public void onBindViewHolder(@NonNull viewholder viewholder, int i) {

                Patient patient = Patientlist.get(i);
                viewholder.patientname1.setText(patient.getPname());
                viewholder.patientage1.setText(patient.getAge());
                viewholder.patientemail1.setText(patient.getPemail());
                viewholder.patientpassword1.setText(patient.getPpassword());
                viewholder.pgender1.setText(patient.getGender());
                viewholder.whoisthepatient1.setText(patient.getWpatient());
                viewholder.whatstheproblem1.setText(patient.getProblem());


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
        return Patientlist.size();
        }

public  class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView patientname1, patientage1, patientemail1, patientpassword1, pgender1, whoisthepatient1, whatstheproblem1;
    // public ImageView profile_image;
    public Button btndelete;

    public viewholder(@NonNull View itemView) {
        super(itemView);
        patientname1 = itemView.findViewById(R.id.pname1);
        patientage1 = itemView.findViewById(R.id.Patientage1);
        patientemail1 = itemView.findViewById(R.id.patientemail1);
        patientpassword1 = itemView.findViewById(R.id.Patientpass1);
        pgender1 = itemView.findViewById(R.id.pgender1);
        whoisthepatient1 = itemView.findViewById(R.id.pwhoisthepatient1);
        whatstheproblem1 = itemView.findViewById(R.id.patientproblem1);
        btndelete = itemView.findViewById(R.id.btndeletepatient);
        btndelete.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

    }
}
}
