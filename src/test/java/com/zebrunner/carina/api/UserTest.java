package com.zebrunner.carina.api;

import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.demo.api.user.*;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

public class UserTest implements IAbstractTest {
    static final Logger log = Logger.getLogger(UserTest.class);

    @Test
    public void testDeleteUser(){
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(1);
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }

    @Test
    public void testGetUser(){
        GetUserMethod getUserMethod = new GetUserMethod(1);
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
        PutUserMethod putUserMethod = new PutUserMethod(1);
        putUserMethod.callAPIExpectSuccess();
        putUserMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
    }
}
