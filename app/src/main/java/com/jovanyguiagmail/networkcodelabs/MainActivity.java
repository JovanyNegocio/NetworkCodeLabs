package com.jovanyguiagmail.networkcodelabs;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jovanyguiagmail.networkcodelabs.data.DataSource;

public class MainActivity extends AppCompatActivity implements MainContrat.View {

    MainContrat.Presenter presenter;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    PostAdapter adapter;
    View omptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new PostAdapter();
        progressBar = findViewById(R.id.progress_bar);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        DataSource dataSource = Injection.provideDataSource(this);
        presenter = new MainPresenter(dataSource, this );
        setPresenter(presenter);
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadPosts();
            }
        });

    }



    @Override
    public void setPresenter(final MainContrat.Presenter presenter) {
        this.presenter = presenter;
        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... voids) {
                presenter.start();
                return null;
            }
        }.execute();

    }

    @Override
    public void setLoadingPosts(boolean isloading) {
        if(isloading){
            progressBar.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.GONE);
        }

    }

    @Override
    public void setPosts(Post[] posts) {
        adapter.posts = posts;
        adapter.notifyDataSetChanged();

    }

    @Override
    public void showError(String title, String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();

    }

    @Override
    public void hideError() {

    }

    @Override
    public void showNoPostsMessage(boolean showMessage) {

    }
}
