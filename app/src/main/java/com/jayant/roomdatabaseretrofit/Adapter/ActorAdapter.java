package com.jayant.roomdatabaseretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jayant.roomdatabaseretrofit.Modal.Actor;
import com.jayant.roomdatabaseretrofit.Modal.Smartfolder;
import com.jayant.roomdatabaseretrofit.R;

import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder> {

private Context context;
private List<Smartfolder> actorList;

    public ActorAdapter(Context context, List<Smartfolder> actorList) {
        this.context =  context;
        this.actorList = actorList;
    }

    @NonNull
    @Override
    public ActorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ActorViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.each_roe,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ActorViewHolder holder, int position) {
        Smartfolder actor=actorList.get(position);
      //holder.id.setText("Id "+actor.getId());
     // holder.name.setText("Name "+actor.getUrls().getSmall());
    //  holder.age.setText("Age "+actor.getAge());

        Glide.with(context)
                .load(actor.getUrls().getSmall())
                .into(holder.image);

    }

    public void getAllActors(List<Smartfolder> actorList)
    {
        this.actorList=actorList;
    }

    @Override
    public int getItemCount() {
        return actorList.size();
    }

    public static class ActorViewHolder extends RecyclerView.ViewHolder{
      public TextView id,name,age;
      public ImageView image;

        public ActorViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.id);
            name=itemView.findViewById(R.id.name);
            age=itemView.findViewById(R.id.age);
            image=itemView.findViewById(R.id.image);
        }
    }
}
