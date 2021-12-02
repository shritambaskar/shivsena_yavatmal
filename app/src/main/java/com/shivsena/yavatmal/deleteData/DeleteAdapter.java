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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.shivsena.yavatmal.R;
import com.shivsena.yavatmal.adapter.ShivsenaAdapter;
import com.shivsena.yavatmal.model.ShivsenaDetails;
import com.shivsena.yavatmal.model.Utils;

import java.util.List;

public class DeleteAdapter extends RecyclerView.Adapter<DeleteAdapter.DeleteViewHolder>{
    private Context context;
    private List<ShivsenaDetails> mList;
    private String vidhansabha,post,taluka;

    public DeleteAdapter(Context context,List<ShivsenaDetails> mList,String vidhansabha,String post,String taluka){
        this.context = context;
        this.mList = mList;
        this.vidhansabha = vidhansabha;
        this.post = post;
        this.taluka = taluka;

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
                String post = data.getPost();
                if(post.equals("उपजिल्हा प्रमुख") || post.equals("उपजिल्हा संघटीका") || post.equals("उपजिल्हा युवा अधिकारी")){
                        String userId = data.getUid();
                    Task<Void> task = Utils.removeUser(userId,vidhansabha,post);
                    task.addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(context, "Data Removed....", Toast.LENGTH_SHORT).show();
                        }
                    });

                }

                if(post.equals("तालुका प्रमुख") || post.equals("तालुका संघटीका") || post.equals("तालुका युवा अधिकारी")
                        || post.equals("उपतालुका प्रमुख") || post.equals("उपतालुका संघटीका")
                        || post.equals("उपतालुका युवा अधिकारी")|| post.equals("विभाग प्रमुख")
                        || post.equals("विभाग संघटीका")|| post.equals("विभाग युवा अधिकारी")
                        || post.equals("शाखा प्रमुख")|| post.equals("शाखा संघटीका")
                        || post.equals("शाखा युवा अधिकारी")){
                    String userId = data.getUid();
                    Task<Void> task = Utils.removeUser(userId,vidhansabha,post,taluka);
                    task.addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(context, "Data Removed....", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(context)
                        .setContentHolder(new ViewHolder(R.layout.update_data))
                        .setExpanded(true,650).create();


               // dialogPlus.show();
                View dialogView = dialogPlus.getHolderView();
                EditText post = dialogView.findViewById(R.id.txt_post);
                EditText name = dialogView.findViewById(R.id.txt_name);
                EditText mobile = dialogView.findViewById(R.id.txt_mobile);
                Button update = dialogView.findViewById(R.id.btn_update_data);

                post.setText(data.getPost());
                name.setText(data.getName());
                mobile.setText(data.getMobile());

                dialogPlus.show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class DeleteViewHolder extends RecyclerView.ViewHolder{

        private TextView post,name,phone;
        private Button delete,edit;

        public DeleteViewHolder(@NonNull View itemView) {
            super(itemView);
            post = (TextView) itemView.findViewById(R.id.del_post);
            name = (TextView) itemView.findViewById(R.id.del_name);
            phone = (TextView) itemView.findViewById(R.id.del_phone);
            delete = itemView.findViewById(R.id.btndelete);
            edit = itemView.findViewById(R.id.btnEdit);
        }
    }

}
