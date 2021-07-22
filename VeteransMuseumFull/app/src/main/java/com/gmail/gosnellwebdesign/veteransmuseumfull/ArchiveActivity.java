package com.gmail.gosnellwebdesign.veteransmuseumfull;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArchiveActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<Model> list;
    private RecyclerViewAdapter adapter;

    private String baseURL = "http://www.stcharlescountyveteransmuseum.org";

    public static List<WPPost> mListPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive);

        // Widget references
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        mLayoutManager = new LinearLayoutManager(ArchiveActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        list = new ArrayList<Model>();
        /// Call retrofill
        getRetrofit();

        // Set adapter
        adapter = new RecyclerViewAdapter( list, ArchiveActivity.this);
        recyclerView.setAdapter(adapter);

    }
    public void getRetrofit(){

        // Retrofit for pulling from WordPress REST API
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitArrayApi service = retrofit.create(RetrofitArrayApi.class);
        Call<List<WPPost>>  call = service.getPostInfo();

        // Pull JSON data from WordPress REST API from veterans website to display a list of veterans
        call.enqueue(new Callback<List<WPPost>>() {
            @Override
            public void onResponse(Call<List<WPPost>> call, Response<List<WPPost>> response) {
                Log.e("mainactivyt", " response "+ response.body());
                mListPost = response.body();
                progressBar.setVisibility(View.GONE);
                for (int i=0; i<response.body().size();i++){
                    Log.e("main ", " title "+ response.body().get(i).getTitle().getRendered() + " "+
                            response.body().get(i).getId());

                    String tempdetails =  response.body().get(i).getExcerpt().getRendered().toString();
                    tempdetails = tempdetails.replace("<p>","");
                    tempdetails = tempdetails.replace("</p>","");
                    tempdetails = tempdetails.replace("[&hellip;]","");

                    list.add( new Model( Model.IMAGE_TYPE,  response.body().get(i).getTitle().getRendered(),
                            tempdetails,
                            response.body().get(i).getLinks().getWpFeaturedmedia().get(0).getHref())  );

                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<WPPost>> call, Throwable t) {

            }
        });

    }
    // Return the list of veterans
    public static List<WPPost> getList(){
        return  mListPost;
    }
}
