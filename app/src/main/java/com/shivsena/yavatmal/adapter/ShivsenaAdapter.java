package com.shivsena.yavatmal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.model.ShivsenaDetails;

import java.util.List;

public class ShivsenaAdapter extends RecyclerView.Adapter<ShivsenaAdapter.ShivsenaViewHolder> {

    private Context context;
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
        holder.post.setText(data.getPost());
        holder.name.setText(data.getName());
        holder.phone.setText(data.getMobile());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ShivsenaViewHolder extends RecyclerView.ViewHolder{

        private TextView post,name,phone;

        public ShivsenaViewHolder(@NonNull View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.shiv_post);
            name = (TextView) itemView.findViewById(R.id.shiv_name);
            phone = (TextView) itemView.findViewById(R.id.shiv_phone);
        }
    }

}
