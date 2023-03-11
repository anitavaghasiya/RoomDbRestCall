package com.jayant.roomdatabaseretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jayant.roomdatabaseretrofit.Adapter.ActorAdapter;
import com.jayant.roomdatabaseretrofit.Modal.Actor;
import com.jayant.roomdatabaseretrofit.Modal.Smartfolder;
import com.jayant.roomdatabaseretrofit.Network.Retrofit;
import com.jayant.roomdatabaseretrofit.Repository.ActorRespository;
import com.jayant.roomdatabaseretrofit.ViewModal.ActorViewModal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActorViewModal actorViewModal;

    private RecyclerView recyclerView;
    private List<Smartfolder> actorList;
    private ActorRespository actorRespository;
   private ActorAdapter actorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        actorRespository=new ActorRespository(getApplication());
        actorList=new ArrayList<>();
       actorAdapter=new ActorAdapter(this,actorList);

        actorViewModal=new ViewModelProvider(this).get(ActorViewModal.class);
        networkRequest();
        actorViewModal.getAllActor().observe(this, new Observer<List<Smartfolder>>() {
            @Override
            public void onChanged(List<Smartfolder> actorList) {
                recyclerView.setAdapter(actorAdapter);
                actorAdapter.getAllActors(actorList);

                Log.d("main", "onChanged: "+actorList);
            }
        });

    }

    private void networkRequest() {

        Retrofit retrofit=new Retrofit();
        Call<List<Smartfolder>> call=retrofit.api.getAllActors("w_dCwgRHHnaqcdt7Y9XXo82ZEBHLcpYB2S2kKhM0WF8");
        call.enqueue(new Callback<List<Smartfolder>>() {
            @Override
            public void onResponse(Call<List<Smartfolder>> call, Response<List<Smartfolder>> response) {
                if(response.isSuccessful())
                {
                    actorRespository.insert(response.body());
                    Log.d("main", "onResponse: "+response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Smartfolder>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "something went wrong...", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
