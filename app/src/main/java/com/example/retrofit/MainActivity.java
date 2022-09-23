package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.net.CacheRequest;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapters myAdapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetData service = RetrofitClient.GetRetrofitInstance().create(GetData.class);
        Call<List<RetroUsers>> call = service.getAllUsers();

        call.enqueue(new Callback<List<RetroUsers>>() {
            @Override
            public void onResponse(Call<List<RetroUsers>> call, Response<List<RetroUsers>> response) {
                LoadDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroUsers>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Unable to load user", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private  void LoadDataList(List<RetroUsers> userlist){

        recyclerView = findViewById(R.id.recyclerview);
        myAdapters = new MyAdapters(userlist);

        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapters);

    }
}
