package com.wissen.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    /********** Response error message constants **********/
    public static final String DETAILS_ALREADY_PRESENT_MESSAGE = "Details already present";

    /********** Log message constants **********/
    public static final String CLIENT_DETAILS_ALREADY_PRESENT_LOG_MESSAGE = "The Client details are already present : {}";
    public static final String PROJECT_DETAILS_ALREADY_PRESENT_LOG_MESSAGE = "This Project details already present : {}";
    public static final String SKILL_DETAILS_ALREADY_PRESENT_LOG_MESSAGE = "This Skill details already present : {}";

}
