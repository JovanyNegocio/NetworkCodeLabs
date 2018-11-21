package com.jovanyguiagmail.networkcodelabs.data;

import com.jovanyguiagmail.networkcodelabs.Post;

public interface DataSource {

    interface GetPostsCallback {
        void onPostsLoaded(Post[] posts);
        void onPostsNoteAvailable(String error, Throwable cause);
    }

    void getPosts(GetPostsCallback getPostsCallback);
}
