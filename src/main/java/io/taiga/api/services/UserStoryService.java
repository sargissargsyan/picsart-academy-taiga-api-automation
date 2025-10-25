package io.taiga.api.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.models.UserStory;
import io.taiga.utils.Urls;

public class UserStoryService extends BaseService {
    public static Response createUserStory(UserStory userStory, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.USER_STORY_URL);
        requestSpecification.body(userStory);
        requestSpecification.headers(setToken(token));
        return post(requestSpecification);
    }

    public static Response editUserStory(UserStory userStory, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.USER_STORY_URL + "/" + userStory.getId());
        requestSpecification.body(userStory);
        requestSpecification.headers(setToken(token));
        return patch(requestSpecification);
    }
}
