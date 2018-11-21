package com.jovanyguiagmail.networkcodelabs;

import com.jovanyguiagmail.networkcodelabs.data.DataSource;

public class MainPresenter implements MainContrat.Presenter {

    private final DataSource dataSource;
    private final MainContrat.View contractView;

    public MainPresenter(DataSource dataSource, MainContrat.View contractView) {
        this.dataSource = dataSource;
        this.contractView = contractView;
    }


    @Override
    public void start() {
        loadPosts();

    }

    @Override
    public void loadPosts() {
        contractView.setLoadingPosts(true);
        dataSource.getPosts(new DataSource.GetPostsCallback() {
            @Override
            public void onPostsLoaded(Post[] posts) {
                contractView.setLoadingPosts(false);
                if (posts != null && posts.length > 0){
                    contractView.showNoPostsMessage(false);
                    contractView.setPosts(posts);
                } else{
                    contractView.showNoPostsMessage(true);
                }
            }

            @Override
            public void onPostsNoteAvailable(String error, Throwable cause) {
                String fullError = error;
                contractView.showError(error, fullError);
                contractView.setLoadingPosts(false);
                contractView.showNoPostsMessage(true);
                contractView.setPosts(null);

            }
        });

    }

    @Override
    public void onLoadPostImageError(String error, Exception e) {

    }
}
