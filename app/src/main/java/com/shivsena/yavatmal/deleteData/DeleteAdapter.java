package com.shivsena.yavatmal.deleteData;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.adapter.ShivsenaAdapter;
import com.shivsena.yavatmal.model.ShivsenaDetails;

import java.util.List;

public class DeleteAdapter extends RecyclerView.Adapter<DeleteAdapter.DeleteViewHolder>{
    private Context context;
    private List<ShivsenaDetails> mList;

    public DeleteAdapter(Context context,List<ShivsenaDetails> mList){
        this.context = context;
        this.mList = mList;

    }
    @NonNull
    @Override
    public DeleteAdapter.DeleteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.delete_data,parent,false);
        return new DeleteAdapter.DeleteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeleteAdapter.DeleteViewHolder holder, int position) {

        ShivsenaDetails data = mList.get(position);
        holder.post.setText("पद : "+data.getPost());
        holder.post.setTextColor(Color.parseColor("#fa6604"));
        holder.name.setText("नाव : "+data.getName());
        holder.name.setTextColor(Color.parseColor("#fa6604"));
        holder.phone.setText("दूरध्वनि : "+data.getMobile());
        holder.phone.setTextColor(Color.parseColor("#fa6604"));
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class DeleteViewHolder extends RecyclerView.ViewHolder{

        private TextView post,name,phone;
        private Button delete;

        public DeleteViewHolder(@NonNull View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.del_post);
            name = (TextView) itemView.findViewById(R.id.del_name);
            phone = (TextView) itemView.findViewById(R.id.del_phone);
            delete = itemView.findViewById(R.id.btndelete);
        }
    }

}
