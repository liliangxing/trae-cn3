package com.bytedance.upc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes.dex */
public class Constants {
    public static final String BASIC_FUNCTION_MODE_ENABLE = "40";
    public static final String CITY_DISPLAY_ENABLE = "50";
    public static final String CLIPBOARD_READ_ENABLE = "80";
    public static final String CONTENT_RICHNESS_EXPANSION_FREQUENCY = "5";
    public static final String CONTENT_RICHNESS_EXPANSION_FREQUENCY_TEEN_MODE = "30";
    public static final String ENABLE_OFF = "off";
    public static final String ENABLE_ON = "on";
    public static final String ENABLE_UNKNOWN = "unknown";
    public static final String FREQUENCY_HIGH = "high";
    public static final String FREQUENCY_LOW = "low";
    public static final String FREQUENCY_MEDIUM = "medium";
    public static final String KEY_DIALOG_APP_LIST = "key_upc_app_list";
    public static final String KEY_DIALOG_CLIPBOARD_RECALL = "key_upc_clipboard_recall";
    public static final String KEY_DIALOG_CONFIRM = "key_upc_confirm_dialog";
    public static final String KEY_DIALOG_PRIVACY = "key_upc_privacy_dialog";
    public static final String KEY_DIALOG_RECALL = "key_upc_recall_dialog";
    public static final String KEY_DIALOG_RETAIN = "key_upc_retain_dialog";
    public static final String KEY_DIALOG_TEEN_MODE = "key_upc_teen_mode_dialog";
    public static final String KEY_PRIVACY_AGREEMENT_STATUS = "key_upc_privacy_agreement_status";
    public static final String KEY_PRIVACY_APP_LIST_STATUS = "key_upc_privacy_teen_mdoe_status";
    public static final String KEY_PRIVACY_TEEN_MODE_STATUS = "key_upc_privacy_teen_mode_status";
    public static final String MERGER_AGREEMENT_REVEALED = "1000";
    public static final String NON_TRACE_READING = "1";
    public static final String PERSONALIZED_AD_RECOMMENDATION_ENABLE = "11";
    public static final String PERSONALIZED_CONTENT_RECOMMENDATION_ENABLE = "10";
    public static final String PERSONAL_AUTHORIZATION_ENABLE = "70";
    public static final String PRIVACY_PERMISSION_APPLIST = "upc.permission.applist";
    public static final String PRIVACY_PERMISSION_CLIPBOARD = "upc.permission.clipboard";
    public static final String PRIVACY_THIRD_AUTHORIZE_PLATFORM_DOUYIN = "aweme_v2";
    public static final String PRIVACY_THIRD_AUTHORIZE_PLATFORM_QQ = "qzone_sns";
    public static final String PRIVACY_THIRD_AUTHORIZE_PLATFORM_TOUTIAO = "toutiao_v2";
    public static final String PRIVACY_THIRD_AUTHORIZE_PLATFORM_WEB = "sina_weibo";
    public static final String PRIVACY_THIRD_AUTHORIZE_PLATFORM_WEIXIN = "weixin";
    public static final String RECOMMEND_BASE_ON_FOLLOW_LIST = "4";
    public static final String RECOMMEND_BASE_ON_LOCATION = "2";
    public static final String RECOMMEND_BASE_ON_SEARCH_RECORD = "3";
    public static final String TRACELESS_SEARCH_ENABLE = "60";
    public static final String USER_EXPERIENCE_IMPROVEMENT_PLAN_ENABLE = "20";

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PrivacyDialogType {
    }

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PrivacyPermission {
    }

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PrivacyThirdAuthorizePlatform {
    }

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PrivacyType {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface PrivacyTypeValue {
    }
}
