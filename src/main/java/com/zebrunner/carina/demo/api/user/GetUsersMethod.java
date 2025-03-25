package com.zebrunner.carina.demo.api.user;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/users", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/user/_get_all/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUsersMethod extends AbstractApiMethodV2 {

    public GetUsersMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }

}
