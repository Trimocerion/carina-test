package com.zebrunner.carina.api;

import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.api.post.DeletePostMethod;
import com.zebrunner.carina.demo.api.post.GetPostMethod;
import com.zebrunner.carina.demo.api.post.GetPostsMethod;
import com.zebrunner.carina.demo.api.post.PostPostMethod;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class PostTest implements IAbstractTest {
    static final Logger log = Logger.getLogger(PostTest.class);

    @Test
    public void testDeletePost(){
        DeletePostMethod deletePostMethod = new DeletePostMethod(1);
        deletePostMethod.callAPIExpectSuccess();
        deletePostMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testGetPost(){
        GetPostMethod getPostMethod = new GetPostMethod(1);
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
}
