package com.bytedance.ug.sdk.share.api.entity;

import android.os.Bundle;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;
import com.bytedance.ug.sdk.share.impl.utils.UGShareLogger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareResult {
    public static final int ERROR_DATA_NULL = 10010;
    public static final int ERROR_FILE_TOO_LARGE = 10090;
    public static final int ERROR_IMAGE_TOO_LARGE = 10091;
    public static final int ERROR_PERMISSION_DENY = 10006;
    public static final int ERROR_SDK_APP_INIT_FAILED = 10016;
    public static final int ERROR_SDK_APP_NOT_INSTALL = 10011;
    public static final int ERROR_SDK_APP_VERSION_NOT_SUPPORT = 10015;
    public static final int ERROR_SDK_AUDIO_NOT_SUPPORT = 10100;
    public static final int ERROR_SDK_AUDIO_TARGET_URL_EMPTY = 10102;
    public static final int ERROR_SDK_AUDIO_TITLE_EMPTY = 10101;
    public static final int ERROR_SDK_AUDIO_URL_EMPTY = 10103;
    public static final int ERROR_SDK_CONTEXT_NULL = 10012;
    public static final int ERROR_SDK_DATA_NULL = 10013;
    public static final int ERROR_SDK_FILE_FETCH_FAILED = 10073;
    public static final int ERROR_SDK_FILE_NAME_EMPTY = 10072;
    public static final int ERROR_SDK_FILE_NOT_SUPPORT = 10070;
    public static final int ERROR_SDK_FILE_URL_EMPTY = 10071;
    public static final int ERROR_SDK_H5_IMAGE_EMPTY = 10023;
    public static final int ERROR_SDK_H5_NOT_SUPPORT = 10020;
    public static final int ERROR_SDK_H5_TITLE_EMPTY = 10021;
    public static final int ERROR_SDK_H5_URL_EMPTY = 10022;
    public static final int ERROR_SDK_IMAGE_AND_TEXT_FETCH_FAILED = 10034;
    public static final int ERROR_SDK_IMAGE_AND_TEXT_IMAGE_EMPTY = 10033;
    public static final int ERROR_SDK_IMAGE_AND_TEXT_NOT_SUPPORT = 10030;
    public static final int ERROR_SDK_IMAGE_AND_TEXT_TITLE_EMPTY = 10031;
    public static final int ERROR_SDK_IMAGE_AND_TEXT_URL_EMPTY = 10032;
    public static final int ERROR_SDK_IMAGE_FETCH_FAILED = 10055;
    public static final int ERROR_SDK_IMAGE_LOCAL_URL_ERROR = 10053;
    public static final int ERROR_SDK_IMAGE_NOT_SUPPORT = 10050;
    public static final int ERROR_SDK_IMAGE_RESP_DATA_EMPTY = 10052;
    public static final int ERROR_SDK_IMAGE_URL_EMPTY = 10051;
    public static final int ERROR_SDK_IMAGE_URL_NOT_SUPPORT = 10054;
    public static final int ERROR_SDK_MINIAPP_DATA_ERROR = 10080;
    public static final int ERROR_SDK_MINIAPP_ID_EMPTY = 10084;
    public static final int ERROR_SDK_MINIAPP_IMAGE_EMPTY = 10082;
    public static final int ERROR_SDK_MINIAPP_NOT_SUPPORT = 10085;
    public static final int ERROR_SDK_MINIAPP_PATH_EMPTY = 10086;
    public static final int ERROR_SDK_MINIAPP_TITLE_EMPTY = 10081;
    public static final int ERROR_SDK_MINIAPP_WEB_URL_EMPTY = 10083;
    public static final int ERROR_SDK_SHARE_ILLEGAL_CONTENT = 10300;
    public static final int ERROR_SDK_SUPER_GROUP_NOT_SUPPORT = 10200;
    public static final int ERROR_SDK_SUPER_GROUP_TITLE_EMPTY = 10201;
    public static final int ERROR_SDK_TEXT_NOT_SUPPORT = 10040;
    public static final int ERROR_SDK_TEXT_TITLE_EMPTY = 10041;
    public static final int ERROR_SDK_UNKNOWN = 10014;
    public static final int ERROR_SDK_VIDEO_FETCH_FAILED = 10066;
    public static final int ERROR_SDK_VIDEO_FILE_NULL = 10063;
    public static final int ERROR_SDK_VIDEO_NOT_SUPPORT = 10060;
    public static final int ERROR_SDK_VIDEO_NO_PERMISSION = 10067;
    public static final int ERROR_SDK_VIDEO_TARGET_URL_EMPTY = 10065;
    public static final int ERROR_SDK_VIDEO_TITLE_EMPTY = 10064;
    public static final int ERROR_SDK_VIDEO_TOO_LONG = 10062;
    public static final int ERROR_SDK_VIDEO_URL_EMPTY = 10061;
    public static final int ERROR_VIDEO_TOO_LARGE = 10092;
    public static final int SHARE_CANCEL = 10001;
    public static final int SHARE_FAILED = 10002;
    public static final int SHARE_SUCCESS = 10000;
    public static final int SHARE_WARNING = 10003;
    private static final String TAG = "ShareResult";
    public ShareChannelType channelType;
    public int detailErrorCode;
    public int detailSubErrorCode;
    public int errorCode;
    public String errorMsg;
    public Bundle extraBundle;
    public String transaction;

    public ShareResult(int i, ShareChannelType shareChannelType) {
        this.errorCode = i;
        this.channelType = shareChannelType;
    }

    public static void sendShareStatus(int i, ShareContent shareContent) {
        if (shareContent == null) {
            return;
        }
        ShareResult shareResult = new ShareResult(i, shareContent.getShareChanelType());
        if (shareContent.getEventCallBack() != null) {
            Logger.m463d(TAG, "share error code : " + i);
            ToastUtils.showDebugToast("error code : " + i);
            shareContent.getEventCallBack().onShareResultEvent(shareResult);
            if (i == 10000) {
                shareContent.getEventCallBack().onWillLaunchThirdAppEvent(shareContent.getShareChanelType());
            }
            ShareSdkManager.getInstance().resetShareEventCallback();
        }
        UGShareLogger.onShareFinish(shareResult, shareContent);
        ShareEvent.sendShareResultEvent(shareContent, i);
    }
}
