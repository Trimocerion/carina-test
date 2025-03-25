package com.zebrunner.carina.api;

import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.api.post.DeletePostMethod;
import com.zebrunner.carina.demo.api.post.GetPostMethod;
import com.zebrunner.carina.demo.api.post.GetPostsMethod;
import com.zebrunner.carina.demo.api.post.PostPostMethod;
import com.zebrunner.carina.demo.api.user.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class APITest implements IAbstractTest {

    //implement all tests

    static final Logger log = Logger.getLogger(APITest.class);

    @Test
    public void testDeletePost(){
        int postId = 1;

        DeletePostMethod deletePostMethod = new DeletePostMethod(postId);
        deletePostMethod.callAPIExpectSuccess();
        deletePostMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testGetPost(){
        int postId = 1;

        GetPostMethod getPostMethod = new GetPostMethod(postId);
        getPostMethod.callAPIExpectSuccess();
        getPostMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testGetPosts(){
        GetPostsMethod getPostsMethod = new GetPostsMethod();
        getPostsMethod.callAPIExpectSuccess();
        getPostsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testPostPost(){
        PostPostMethod postPostMethod = new PostPostMethod();
        postPostMethod.callAPIExpectSuccess();
        postPostMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testPutPost(){
        PostPostMethod postPostMethod = new PostPostMethod();
        postPostMethod.callAPIExpectSuccess();
        postPostMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testDeleteUser(){
        int userId = 1;

        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(userId);
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testGetUser(){
        int userId = 1;

        GetUserMethod getUserMethod = new GetUserMethod(userId);
        getUserMethod.callAPIExpectSuccess();
        getUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testGetUsers(){
        GetUsersMethod getUsersMethod = new GetUsersMethod();
        getUsersMethod.callAPI();
        getUsersMethod.validateResponse(JSONCompareMode.LENIENT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testPostUser(){
        PostUserMethod postUserMethod = new PostUserMethod();
        postUserMethod.callAPIExpectSuccess();
        postUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testPutUser(){

        int userId = 1;

        PutUserMethod putUserMethod = new PutUserMethod(userId);
        putUserMethod.callAPIExpectSuccess();
        putUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

}