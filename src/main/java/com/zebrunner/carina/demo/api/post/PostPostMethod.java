package com.zebrunner.carina.demo.api.post;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/posts", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/post/_post/rq.json")
@ResponseTemplatePath(path = "api/post/_post/rs.json")
@PropertiesPath(path = "api/post/post.properties")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostPostMethod extends AbstractApiMethodV2 {

    public PostPostMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
