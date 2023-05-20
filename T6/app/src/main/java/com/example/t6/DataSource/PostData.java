package com.example.t6.DataSource;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;

import com.example.t6.Models.PostModel;
import com.example.t6.Models.UserModel;
import com.example.t6.R;

import java.util.ArrayList;
import java.util.Arrays;

public class PostData {
    private static Context context;
    public PostData (Context context){
        this.context = context;
    }
    private static UserModel
            user1 = new UserModel("Erling Haaland", R.drawable.haaland),
            user2 = new UserModel("Cristiano Ronaldo", R.drawable.ronaldo),
            user3 = new UserModel("Kylian Mbappe", R.drawable.mbappe);
    private static ArrayList<PostModel> posts = new ArrayList<>(
            Arrays.asList(
                    new PostModel(user1, BitmapFactory.decodeResource(null, R.drawable.haaland), "This is a post"),
                    new PostModel(user2, BitmapFactory.decodeResource(null, R.drawable.ronaldo), "This is a second post"),
                    new PostModel(user3, BitmapFactory.decodeResource(null, R.drawable.mbappe), "This is a third post")
            )
    );

    public static void setPost(PostModel postModel) {
        posts.add(postModel);
    }

    public ArrayList<PostModel> getPosts() {
        return posts;
    }
}
