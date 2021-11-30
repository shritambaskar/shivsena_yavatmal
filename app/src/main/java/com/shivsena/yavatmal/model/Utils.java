package com.shivsena.yavatmal.model;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class Utils {

    public static Task<Void>  removeUser(String userId,String vidhasabha,String post){

        Task<Void> task = FirebaseDatabase.getInstance().getReference(vidhasabha).child(post).child(userId).removeValue();
        return task;
    }

    public static Task<Void> removeUser(String userId, String vidhansabha, String post, String taluka) {
        Task<Void> task = FirebaseDatabase.getInstance().getReference(vidhansabha).
                child(taluka+" तालुका").child(post).child(userId).removeValue();
        return task;
    }
}
