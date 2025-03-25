package com.zebrunner.carina.demo.api.user;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/user/_post/rq.json")
@ResponseTemplatePath(path = "api/user/_post/rs.json")
@PropertiesPath(path = "api/user/user.properties")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostUserMethod extends AbstractApiMethodV2 {

    public PostUserMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
