package com.shivsena.yavatmal.adapter;

import android.Manifest;
import android.app.Activity;
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
import com.shivsena.yavatmal.model.ShivsenaDetails;

import java.util.List;

public class ShivsenaAdapter extends RecyclerView.Adapter<ShivsenaAdapter.ShivsenaViewHolder> {

    private Context context;
    private Activity activity;
    private List<ShivsenaDetails> mList;

    public ShivsenaAdapter(Context context,List<ShivsenaDetails> mList){
        this.context = context;
        this.mList = mList;

    }

    @NonNull
    @Override
    public ShivsenaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.shivsena_data,parent,false);
        return new ShivsenaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShivsenaViewHolder holder, int position) {

        ShivsenaDetails data = mList.get(position);
        holder.post.setText("पद : "+data.getPost());
        holder.post.setTextColor(Color.parseColor("#fa6604"));
        holder.name.setText("नाव : "+data.getName());
        holder.name.setTextColor(Color.parseColor("#fa6604"));
        holder.phone.setText("दूरध्वनि : "+data.getMobile());
        holder.phone.setTextColor(Color.parseColor("#fa6604"));
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) ==
                        PackageManager.PERMISSION_GRANTED)
                {
                    String mobile = data.getMobile();
                    Intent i= new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+mobile));
                    context.startActivity(i);
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ShivsenaViewHolder extends RecyclerView.ViewHolder{

        private TextView post,name,phone;
        private ImageButton call;

        public ShivsenaViewHolder(@NonNull View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.shiv_post);
            name = (TextView) itemView.findViewById(R.id.shiv_name);
            phone = (TextView) itemView.findViewById(R.id.shiv_phone);
            call = itemView.findViewById(R.id.btnCall);
        }
    }

}
