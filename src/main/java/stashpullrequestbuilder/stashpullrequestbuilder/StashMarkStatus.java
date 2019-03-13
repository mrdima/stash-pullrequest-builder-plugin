package stashpullrequestbuilder.stashpullrequestbuilder;

import hudson.model.Result;

public class StashMarkStatus {

    public void handleStatus(Boolean approveOnBuildSuccessful, Boolean needsWorkOnBuildFailure, String pullRequestId,
        Result result, StashRepository repository) {
        if(approveOnBuildSuccessful && result == Result.SUCCESS) {
            repository.markStatus(pullRequestId, "APPROVED");
        }

        if(needsWorkOnBuildFailure && result == Result.FAILURE) {
            repository.markStatus(pullRequestId, "NEEDS_WORK");
        }
    }
}
