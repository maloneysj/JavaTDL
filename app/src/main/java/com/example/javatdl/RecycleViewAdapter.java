package com.example.javatdl;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<TDLs> TDLsList;
    Context context;
    MyApplication myApplication;
    DataBaseHelper dataBaseHelper;

    public RecycleViewAdapter(List<TDLs> TDLsList, Context context) {
        this.TDLsList = TDLsList;
        this.context = context;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_tdl, parent, false);
        MyViewHolder holder= new MyViewHolder(view);


        return holder;


    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_TDLname.setText(TDLsList.get(position).getName());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(myApplication.getMainActivityOn()==0) {

                String item;
                int Id;

                Intent intent=new Intent();

                intent.putExtra("id",TDLsList.get(holder.getAdapterPosition()).getId());
                intent.putExtra("item",TDLsList.get(holder.getAdapterPosition()).getItems());

                Id=intent.getIntExtra("id", -1);
                item=intent.getStringExtra("item");
                myApplication.setNewItem(item);


                Toast.makeText(context, item, Toast.LENGTH_SHORT).show();



                }

                else {

                    String item;


                    Intent intent = new Intent(context, AddEditOne.class);

                    intent.putExtra("id", TDLsList.get(holder.getAdapterPosition()).getId());
                    intent.putExtra("item", TDLsList.get(holder.getAdapterPosition()).getItems());


                    item=intent.getStringExtra("item");
                    Toast.makeText(context, item, Toast.LENGTH_SHORT).show();

                    context.startActivity(intent);
                }
                

            }
        });

    }

    @Override
    public int getItemCount() {
        return TDLsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_TDLname;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_TDLname=itemView.findViewById(R.id.tv_TDLname);
            parentLayout=itemView.findViewById(R.id.oneLineTDLLayout);
        }
    }

    /*

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        TextView tv_TDLname2;
        ConstraintLayout parentLayout2;

        public MyViewHolder2(@NonNull View itemView) {
            super(itemView);
            tv_TDLname2=itemView.findViewById(R.id.tv_TDLname2);
            parentLayout2=itemView.findViewById(R.id.oneLineTDLLayout2);
        }
    }
    */
}
