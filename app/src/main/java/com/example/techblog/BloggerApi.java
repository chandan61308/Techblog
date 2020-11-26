package com.example.techblog;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;


public class BloggerApi
{
    public static final String key="AIzaSyA2nPFVunCg6MDD2R2Vxn2tkJnirllE-A0";
    public static final String Url="https://www.googleapis.com/blogger/v3/blogs/7650189263704473906/posts/";

    public static PostService postService=null;
    public static PostService getService()
    {
        if (postService==null) {

          Retrofit retrofit=new Retrofit.Builder().baseUrl(Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService=retrofit.create(PostService.class);
        }
        return postService;
    }

public interface PostService
{
   @GET
    Call<PostList> getPostList(@Url String url);

//   @GET("{postId}/?key="+key)
//
//    Call<Item> getPostById(@Path("postId") String Id);
}}