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

import e.margi.otpdynamicanotherone.Fragment.Address;
import e.margi.otpdynamicanotherone.Fragment.CallActivity;

public  class MedicalorderAdapter extends RecyclerView.Adapter<MedicalorderAdapter.viewholder>

        {
        Context mcontext;
        ArrayList<Address> orderlist;

public MedicalorderAdapter(Context mcontext, ArrayList<Address> orderlist)
        {

        this.orderlist =orderlist;
        this.mcontext=mcontext;
        }
@NonNull
@Override
public MedicalorderAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
        {
        View view= LayoutInflater.from(mcontext).inflate(R.layout.order_item,viewGroup,false);
        return new MedicalorderAdapter.viewholder(view);

        }

            @Override
            public void onBindViewHolder(@NonNull viewholder viewholder, int i) {
                Address address1 = orderlist.get(i);
                viewholder.address.setText(address1.getAddress());
                viewholder.mobileno.setText(address1.getMobileno1());
                viewholder.pincode.setText(address1.getPincode());




        viewholder.itemView.setOnClickListener(new View.OnClickListener()
        {
@Override
public void onClick(View v)
        {
        mcontext.startActivity(new Intent(mcontext, CallActivity.class));

        }
        });


        }

@Override
public int getItemCount()
        {
        return orderlist.size();
        }

public  class viewholder extends RecyclerView.ViewHolder
{
    public TextView address,pincode,mobileno,dpassword;
    // public ImageView profile_image;

    public viewholder(@NonNull View itemView)
    {
        super(itemView);
        address = itemView.findViewById(R.id.addressorder);
        pincode=itemView.findViewById(R.id.pcode);
        mobileno=itemView.findViewById(R.id.mobilenoy);
        //dpassword=itemView.findViewById(R.id.dpass);
        // profile_image=itemView.findViewById(R.id.profile_image);
    }

}}