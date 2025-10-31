package io.taiga.api.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.taiga.api.models.UserStory;
import io.taiga.utils.Urls;
import lombok.extern.java.Log;

@Log
public class UserStoryService extends BaseService {
    public static Response get(Integer userStoryId, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.USER_STORY_URL + "/" + userStoryId);
        requestSpecification.headers(setToken(token));
        return get(requestSpecification);
    }

    public static Response get(UserStory userStory, String token) {
        return get(userStory.getId(), token);
    }

    public static Response create(UserStory userStory, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.USER_STORY_URL);
        requestSpecification.body(userStory);
        requestSpecification.headers(setToken(token));
        log.info(userStory.toString());
        return post(requestSpecification);
    }

    public static Response edit(UserStory userStory, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.USER_STORY_URL + "/" + userStory.getId());
        requestSpecification.body(userStory);
        requestSpecification.headers(setToken(token));
        return patch(requestSpecification);
    }

    public static Response delete(UserStory userStory, String token) {
        return delete(userStory.getId(), token);
    }

    public static Response delete(Integer userStoryId, String token) {
        RequestSpecification requestSpecification = configBaseRequest();
        requestSpecification.basePath(Urls.USER_STORY_URL + "/" + userStoryId);
        requestSpecification.headers(setToken(token));
        return delete(requestSpecification);
    }
}
