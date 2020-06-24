package io.eroshenkoam.allure;

import io.qameta.allure.Step;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestSteps {

    @Step("Create issue with title `{title}`")
    public void createIssueWithTitle(final String owner, final String repo, final String title) {
        assertEquals(title, "First Note");
        step(String.format("POST /repos/%s/%s/issues", owner, repo));
    }

    @Step("Close issue with title `{title}`")
    public void closeIssueWithTitle(final String owner, final String repo, final String title) {
        step(String.format("GET /repos/%s/%s/issues?text=%s", owner, repo, title));
        step(String.format("PATCH /repos/%s/%s/issues/%s", owner, repo, 10));
    }

    @Step("Check note with content `{title}` exists")
    public void shouldSeeIssueWithTitle(final String owner, final String repo, final String title) {
        step(String.format("GET /repos/%s/%s/issues?text=%s", owner, repo, title));
        step(String.format("GET /repos/%s/%s/issues/%s", owner, repo, 10));
    }

}
