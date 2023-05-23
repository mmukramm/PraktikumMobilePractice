package com.example.t6.DataSource;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.t6.Models.PostModel;
import com.example.t6.Models.UserModel;
import com.example.t6.R;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class PostData {
    private final Context context;
    private static Boolean isRefresh = false;

    public PostData(Context context) {
        this.context = context;
    }

    private static final UserModel
            user1 = new UserModel("Haaland", "Erling Haaland", R.drawable.haaland),
            user2 = new UserModel("Ronaldo", "Cristiano Ronaldo", R.drawable.ronaldo),
            user3 = new UserModel("Mbappe", "Kylian Mbappe", R.drawable.mbappe),
            user4 = new UserModel("De Bruyne", "Kevin De Bruyne", R.drawable.debruyne),
            user5 = new UserModel("Messi", "Lionel Messi", R.drawable.messi);
    private static Deque<PostModel> posts;

    private void setData(){
        posts = new LinkedList<>();
        posts.push(new PostModel(user2, BitmapFactory.decodeResource(context.getResources(), R.drawable.ronaldo), "Suuuuuuiiiii. Anjay, intinya satu bro, jangan cemas"));
        posts.push(new PostModel(user5, BitmapFactory.decodeResource(context.getResources(), R.drawable.messi), "Kabuuuur, Mamaaah aku Takuuut"));
        posts.push(new PostModel(user3, BitmapFactory.decodeResource(context.getResources(), R.drawable.mbappe), "Ketekku basaaaah"));
        posts.push(new PostModel(user4, BitmapFactory.decodeResource(context.getResources(), R.drawable.debruyne), "4? Waaah 4"));
        posts.push(new PostModel(user1, BitmapFactory.decodeResource(context.getResources(), R.drawable.haaland), "Kembali bertapa setelah 4-0."));
    }

    public void setPost(PostModel postModel) {
        posts.push(postModel);
    }

    public ArrayList<PostModel> getPosts() {
        if (!isRefresh) setData();
        return new ArrayList<>(posts);
    }

    public ArrayList<UserModel> getUserPosts() {
        ArrayList<UserModel> userPosts = new ArrayList<>();
        ArrayList<PostModel> posts = getPosts();
        for (PostModel post : posts) {
            if (!userPosts.contains(post.getUser())) userPosts.add(post.getUser());
        }
        return userPosts;
    }

    public void setRefresh(Boolean refresh) {
        isRefresh = refresh;
    }

    public Boolean getRefresh() {
        return isRefresh;
    }
}
