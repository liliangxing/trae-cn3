package com.ss.android.pushmanager;

import java.util.HashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public class MessageConstants {
    public static final String BUNDLE_BUTTON_INFO = "button_info";
    public static final String BUNDLE_FROM_BANNER_NOTIFICATION = "from_banner_notification";
    public static final String BUNDLE_FROM_NOTIFICATION = "from_notification";
    public static final String BUNDLE_ID = "id";
    public static final String BUNDLE_MESSAGE_BODY = "push_body";
    public static final String BUNDLE_OPEN_URL = "open_url";
    public static final String BUNDLE_TAG = "tag";
    public static final String BUTTON_OPEN_APP = "open_app";
    private static final String CLEAR_NOTIFICATION_URL_PATH = "/cloudpush/clear_notification/";
    private static final String EVENT_SYNC_URL_PATH = "/cloudpush/event_sync/";
    public static final String FLAG_SUPPLY_URL_PARAMS = "need_supply_url_params";
    private static final String GET_NOTIFY_ENABLE_URL_PATH = "/cloudpush/fetch_business_status/";
    public static final String KEY_MESSAGE_EXTRA = "message_extra";
    public static final String KEY_MESSAGE_FROM = "message_from";
    public static final String KEY_PUSH_TOKEN_SENT = "push_token_sent";
    public static final String LOG_TYPE = "ss_push";
    public static final String MESSAGE_ACTION = "com.ss.android.message";
    public static final String MESSAGE_KEY_DATA = "message_data";
    private static final String MSG_CLICK_CALLBACK_PATH = "/cloudpush/callback/client_click/";
    public static final String MSG_FROM = "msg_from";
    public static final int MSG_FROM_MESSAGE = 1;
    public static final String MSG_ID = "msg_id";
    private static final String MSG_SHOW_CALLBACK_PATH = "/cloudpush/callback/client_show/";
    public static final String NOTIFY_ACTION = "com.ss.android.message.action.PUSH_SERVICE";
    private static final String REQUEST_SETTINGS_URL_PATH = "/service/settings/v3/";
    private static final String SEND_NOTIFY_ENABLE_URL_PATH = "/service/1/app_notice_status/";
    private static final String SEND_PUSH_TOKEN_URL_PATH = "/service/1/update_token/";
    public static final String TAG = "MessageAppManager";
    public static final int TYPE_MSG_FROM_NOTIFY = 1;
    public static final int TYPE_MSG_FROM_WINDOW = 2;
    public static final int TYPE_REGISTER_FROM_HEART_BEAT = 4;
    public static final int TYPE_REGISTER_FROM_INIT = 2;
    public static final int TYPE_REGISTER_FROM_RECEIVER = 1;
    public static final int TYPE_REGISTER_FROM_SCHEDULED = 3;
    public static final Set<Integer> TYPE_REGISTER_SET;
    public static final String UNINSTALL_QUESTION_URL_MD5_SALT = "device_info_url_salt_650fa7";
    private static final String UPDATE_FRONTIER_SETTING_URL_PATH = "/cloudpush/update_frontier_setting/";
    private static final String UPDATE_SENDER_URL_PATH = "/cloudpush/update_sender/";
    private static final String UPLOAD_HW_DEVICE_INFO_URL_PATH = "/service/1/device_link/";

    static {
        HashSet hashSet = new HashSet();
        TYPE_REGISTER_SET = hashSet;
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);
    }

    public static String getSendPushTokenUrl() {
        return ApiConstants.i(SEND_PUSH_TOKEN_URL_PATH);
    }

    public static String getSendNotifyEnableUrl() {
        return ApiConstants.i(SEND_NOTIFY_ENABLE_URL_PATH);
    }

    public static String getNotifyStatusUrl() {
        return ApiConstants.i(GET_NOTIFY_ENABLE_URL_PATH);
    }

    public static String getUpdateSenderUrl() {
        return ApiConstants.i(UPDATE_SENDER_URL_PATH);
    }

    public static String getUpdateFrontierSettingUrl() {
        return ApiConstants.i(UPDATE_FRONTIER_SETTING_URL_PATH);
    }

    public static String getUploadHwDeviceInfoUrl() {
        return ApiConstants.i(UPLOAD_HW_DEVICE_INFO_URL_PATH);
    }

    public static String getRequestSettingsUrl() {
        return ApiConstants.i(REQUEST_SETTINGS_URL_PATH);
    }

    public static String getEventSyncUrl() {
        return ApiConstants.i(EVENT_SYNC_URL_PATH);
    }

    public static String getClearNotificationUrl() {
        return ApiConstants.i(CLEAR_NOTIFICATION_URL_PATH);
    }

    public static String getMsgArriveCallbackUrl() {
        return ApiConstants.i(MSG_SHOW_CALLBACK_PATH);
    }

    public static String getMsgClickCallbackUrl() {
        return ApiConstants.i(MSG_CLICK_CALLBACK_PATH);
    }
}
