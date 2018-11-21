package com.jovanyguiagmail.networkcodelabs;

public interface MainContrat {

    interface View {

        void setPresenter(Presenter presenter);

        void setLoadingPosts(boolean isloading);

        void setPosts(Post[] posts);

        void showError(String title, String error);

        void hideError();

        void showNoPostsMessage(boolean showMessage);

    }

    interface Presenter {

        void start();

        void loadPosts();

        void onLoadPostImageError(String error, Exception e);

    }
}
