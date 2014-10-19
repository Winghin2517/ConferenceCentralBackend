package com.google.devrel.training.conference;

import com.google.api.server.spi.Constant;

/**
 * Contains the client IDs and scopes for allowed clients consuming the conference API.
 */
public class Constants {
    public static final String WEB_CLIENT_ID = "768602300988-svangdhsm0se5vcgh35bkvbmnog4r9d9.apps.googleusercontent.com";
    public static final String ANDROID_CLIENT_ID = "768602300988-kikrglp38n6foimjs9ikihgcoe82ru0r.apps.googleusercontent.com";
    		//"768602300988-9k1dkji6r7d9bl1mvolc04ddua74dlp4.apps.googleusercontent.com"; this is the live key
    public static final String IOS_CLIENT_ID = "replace this with your iOS client ID";
    public static final String ANDROID_AUDIENCE = WEB_CLIENT_ID;
    public static final String EMAIL_SCOPE = Constant.API_EMAIL_SCOPE;
    public static final String API_EXPLORER_CLIENT_ID = Constant.API_EXPLORER_CLIENT_ID;

    public static final String MEMCACHE_ANNOUNCEMENTS_KEY = "RECENT_ANNOUNCEMENTS";
}
