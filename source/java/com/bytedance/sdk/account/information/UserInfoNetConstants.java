package com.bytedance.sdk.account.information;

import com.bytedance.sdk.account.api.BDAccountNetApi;

/* loaded from: classes5.dex */
public class UserInfoNetConstants extends BDAccountNetApi {
    public static final int API_CAN_MODIFY_USER = 80001;
    public static final int API_CHECK_DEFAULT_INFO = 80004;
    public static final int API_REMAIN_UPDATE_TIMES = 80006;
    public static final int API_UPDATE_USER_INFO = 80003;
    public static final int API_UPLOAD_AVATAR = 80002;
    public static final int API_UPLOAD_PIC = 80005;
    private static String CAN_MODIFY_USER_PATH = "/user/check/can_modify/";
    public static String CHECK_DEFAULT_INFO_PATH = "/user/check/default_info/";
    private static String REMAIN_UPDATE_TIMES = "/user/get/remain_update_times/";
    private static String UPDATE_USER_INFO_PATH = "/user/update/user_info/";
    private static String UPLOAD_AVATAR_PATH = "/user/update/upload_avatar/";
    private static final String UPLOAD_PIC_PATH = "/user/upload/pic/";

    /* loaded from: classes5.dex */
    public interface EventName {
        public static final String CAN_MODIFY_USER = "user_check_can_modify";
        public static final String CHECK_DEFAULT_INFO = "user_check_default_info";
        public static final String UPDATE_USER_INFO = "user_update_user_info";
        public static final String UPLOAD_AVATAR = "user_update_upload_avatar";
        public static final String UPLOAD_PIC = "user_upload_pic";
        public static final String USER_GET_REMAIN_UPDATE_TIMES = "user_get_remain_update_times";
    }

    public static String getCanModifyUserPath() {
        return getUrl(CAN_MODIFY_USER_PATH);
    }

    public static String getUploadAvatarPath() {
        return getUrl(UPLOAD_AVATAR_PATH);
    }

    public static String getUpdateUserInfoPath() {
        return getUrl(UPDATE_USER_INFO_PATH);
    }

    public static String getCheckDefaultInfoPath() {
        return getUrl(CHECK_DEFAULT_INFO_PATH);
    }

    public static String getUploadPicUrl() {
        return getUrl(UPLOAD_PIC_PATH);
    }

    public static String getRemainUpdateTimesUrl() {
        return getUrl(REMAIN_UPDATE_TIMES);
    }
}
