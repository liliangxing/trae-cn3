package com.bytedance.ug.sdk.share.impl.event;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.notification.Constants;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.share.BuildConfig;
import com.bytedance.ug.sdk.share.api.entity.ActivityInfo;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.network.model.GetSignInfoResponse;
import com.bytedance.ug.sdk.share.impl.network.model.SignInfo;
import com.bytedance.ug.sdk.share.impl.utils.AppLogUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.bytedance.ug.sdk.share.impl.utils.UGShareLogger;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareEvent {
    public static void sendShowPanelEvent(ShareContent shareContent) {
        JSONObject jSONObject = new JSONObject();
        if (shareContent != null) {
            try {
                jSONObject.put("panel_type", shareContent.getFrom());
                jSONObject.put("panel_id", shareContent.getPanelId());
                jSONObject.put("resource_id", shareContent.getResourceId());
                addExtraParams(jSONObject, shareContent.getLogEventParams());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_panel_show", jSONObject);
    }

    public static void sendShareChannelClick(ShareContent shareContent, boolean z, String str) {
        UGShareLogger.onShareStart(shareContent);
        JSONObject jSONObject = new JSONObject();
        if (shareContent != null) {
            try {
                jSONObject.put("panel_type", shareContent.getFrom());
                if (z) {
                    jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
                } else {
                    if (str == null) {
                        str = "";
                    }
                    jSONObject.put("channel_type", str);
                }
                jSONObject.put("share_type", ShareStrategy.getStrategyStr(shareContent.getShareStrategy()));
                jSONObject.put("panel_id", shareContent.getPanelId());
                jSONObject.put("resource_id", shareContent.getResourceId());
                jSONObject.put("is_share_channel", z ? 1 : 0);
                addExtraParams(jSONObject, shareContent.getLogEventParams());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_channel_click", jSONObject);
    }

    public static void sendShareChannelClick(ShareContent shareContent, boolean z) {
        sendShareChannelClick(shareContent, z, null);
    }

    public static void sendShareDialogShowEvent(ShareContent shareContent, String str) {
        JSONObject jSONObject = new JSONObject();
        if (shareContent != null) {
            try {
                jSONObject.put("panel_type", shareContent.getFrom());
                jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
                jSONObject.put("share_type", ShareStrategy.getStrategyStr(shareContent.getShareStrategy()));
                jSONObject.put("popup_type", str);
                jSONObject.put("panel_id", shareContent.getPanelId());
                jSONObject.put("resource_id", shareContent.getResourceId());
                addExtraParams(jSONObject, shareContent.getLogEventParams());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_popup_show", jSONObject);
    }

    public static void sendShareDialogClickEvent(ShareContent shareContent, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        if (shareContent != null) {
            try {
                jSONObject.put("panel_type", shareContent.getFrom());
                jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
                jSONObject.put("share_type", ShareStrategy.getStrategyStr(shareContent.getShareStrategy()));
                jSONObject.put("popup_type", str);
                jSONObject.put("click_result", str2);
                jSONObject.put("panel_id", shareContent.getPanelId());
                jSONObject.put("resource_id", shareContent.getResourceId());
                addExtraParams(jSONObject, shareContent.getLogEventParams());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_popup_click", jSONObject);
    }

    public static void sendPermissionRequest(ShareContent shareContent, boolean z) {
        if (shareContent == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("panel_type", shareContent.getFrom());
            jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
            jSONObject.put("share_type", ShareStrategy.getStrategyStr(shareContent.getShareStrategy()));
            jSONObject.put("had_authorize", z ? "1" : ViewVisibleBridge.INVISIBLE);
            jSONObject.put("panel_id", shareContent.getPanelId());
            jSONObject.put("resource_id", shareContent.getResourceId());
            addExtraParams(jSONObject, shareContent.getLogEventParams());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_authorize_popup_request", jSONObject);
    }

    public static void sendPermissionDialogClickEvent(ShareContent shareContent, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (shareContent != null) {
            try {
                jSONObject.put("panel_type", shareContent.getFrom());
                jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
                jSONObject.put("share_type", ShareStrategy.getStrategyStr(shareContent.getShareStrategy()));
                jSONObject.put("click_result", z ? "submit" : "cancel");
                jSONObject.put("panel_id", shareContent.getPanelId());
                jSONObject.put("resource_id", shareContent.getResourceId());
                addExtraParams(jSONObject, shareContent.getLogEventParams());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_authorize_popup_click", jSONObject);
    }

    public static void sendPermissionDialogShowEvent(ShareContent shareContent) {
        JSONObject jSONObject = new JSONObject();
        if (shareContent != null) {
            try {
                jSONObject.put("panel_type", shareContent.getFrom());
                jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
                jSONObject.put("share_type", ShareStrategy.getStrategyStr(shareContent.getShareStrategy()));
                jSONObject.put("panel_id", shareContent.getPanelId());
                jSONObject.put("resource_id", shareContent.getResourceId());
                addExtraParams(jSONObject, shareContent.getLogEventParams());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_authorize_popup_show", jSONObject);
    }

    public static void sendHiddenWriteEvent(ShareContent shareContent, boolean z, String str, int i, long j) {
        JSONObject jSONObject = new JSONObject();
        if (shareContent != null) {
            try {
                jSONObject.put("panel_type", shareContent.getFrom());
                jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
                jSONObject.put("share_type", ShareStrategy.getStrategyStr(shareContent.getShareStrategy()));
                jSONObject.put("condition", z ? "success" : " failed");
                jSONObject.put("panel_id", shareContent.getPanelId());
                jSONObject.put("hidden_str", str);
                jSONObject.put("resource_id", shareContent.getResourceId());
                jSONObject.put("status", i);
                jSONObject.put(CommonConstants.TOTAL_DURATION, j);
                addExtraParams(jSONObject, shareContent.getLogEventParams());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_hidden_interface_write", jSONObject);
    }

    public static void sendHiddenReadEvent() {
        JSONObject jSONObject = new JSONObject();
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_hidden_interface_read", jSONObject);
    }

    public static void sendQrcodeReadEvent() {
        JSONObject jSONObject = new JSONObject();
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_qrcode_interface_read", jSONObject);
    }

    public static void sendRequestRecogniseDataEvent(boolean z, String str, String str2, String str3, ActivityInfo activityInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("recognize_type", str);
            jSONObject.put("is_success", z ? 1 : 0);
            jSONObject.put("failed_reason", str2);
            jSONObject.put("open_url", str3);
            String str4 = "";
            jSONObject.put("activity_id", activityInfo == null ? "" : activityInfo.getId());
            if (activityInfo != null) {
                str4 = activityInfo.getName();
            }
            jSONObject.put("activity_name", str4);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_recognize_interface_request", jSONObject);
    }

    public static void sendRequestInitDataEvent(boolean z, String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_success", z ? 1 : 0);
            jSONObject.put("failed_reason", str);
            jSONObject.put(CommonConstants.TOTAL_DURATION, j);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_initial_interface_request", jSONObject);
    }

    public static void sendRequestShareDataEvent(boolean z, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_success", z ? 1 : 0);
            jSONObject.put("failed_reason", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_info_interface_request", jSONObject);
    }

    public static void sendRecognizeDialogShowEvent(TokenInfoBean tokenInfoBean) {
        JSONObject jSONObject = new JSONObject();
        if (tokenInfoBean != null) {
            try {
                jSONObject.put("show_from", tokenInfoBean.getFrom());
                jSONObject.put("media_type", tokenInfoBean.getMediaType());
                ActivityInfo activityInfo = tokenInfoBean.getActivityInfo();
                String str = "";
                jSONObject.put("activity_id", activityInfo == null ? "" : activityInfo.getId());
                jSONObject.put("activity_name", activityInfo == null ? "" : activityInfo.getName());
                jSONObject.put("domain_id", activityInfo == null ? "" : activityInfo.getDomainId());
                jSONObject.put("template_id", activityInfo == null ? "" : activityInfo.getTemplateId());
                jSONObject.put("client_pop_type", activityInfo == null ? "" : activityInfo.getClientPopType());
                if (activityInfo != null) {
                    str = activityInfo.getActId();
                }
                jSONObject.put("act_id", str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_recognize_popup_show", jSONObject);
    }

    public static void sendRecognizeDialogClickEvent(TokenInfoBean tokenInfoBean, String str) {
        JSONObject jSONObject = new JSONObject();
        if (tokenInfoBean != null) {
            try {
                jSONObject.put("show_from", tokenInfoBean.getFrom());
                jSONObject.put("media_type", tokenInfoBean.getMediaType());
                jSONObject.put("click_result", str);
                ActivityInfo activityInfo = tokenInfoBean.getActivityInfo();
                String str2 = "";
                jSONObject.put("activity_id", activityInfo == null ? "" : activityInfo.getId());
                jSONObject.put("activity_name", activityInfo == null ? "" : activityInfo.getName());
                jSONObject.put("domain_id", activityInfo == null ? "" : activityInfo.getDomainId());
                jSONObject.put("template_id", activityInfo == null ? "" : activityInfo.getTemplateId());
                jSONObject.put("client_pop_type", activityInfo == null ? "" : activityInfo.getClientPopType());
                if (activityInfo != null) {
                    str2 = activityInfo.getActId();
                }
                jSONObject.put("act_id", str2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_recognize_popup_click", jSONObject);
    }

    public static void addCommonParams(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            String deviceId = ShareConfigManager.getInstance().getDeviceId();
            if (!TextUtils.isEmpty(deviceId)) {
                jSONObject.put("ug_share_did", deviceId);
            }
            String appId = ShareConfigManager.getInstance().getAppId();
            if (!TextUtils.isEmpty(appId)) {
                jSONObject.put("ug_share_aid", appId);
            }
            jSONObject.put(Constants.NOTIFICATION_TAG, "ug_sdk_share");
            jSONObject.put("ug_share_v_code", String.valueOf(BuildConfig.SHARE_VERSION_CODE));
            jSONObject.put("ug_share_v_name", BuildConfig.SHARE_VERSION_NAME);
            jSONObject.put("ug_share_os_api", String.valueOf(Build.VERSION.SDK_INT));
            jSONObject.put("ug_share_platform", "android");
            jSONObject.put("params_for_special", "performance");
        } catch (JSONException e) {
            Logger.m465e(e.toString());
        }
    }

    private static void addExtraParams(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            return;
        }
        Iterator<String> keys = jSONObject2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject.put(next, jSONObject2.get(next));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendShareSuccessEvent(ShareContent shareContent, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (shareContent != null) {
            try {
                jSONObject.put("panel_type", shareContent.getFrom());
                jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
                jSONObject.put("share_type", ShareStrategy.getStrategyStr(shareContent.getShareStrategy()));
                jSONObject.put("panel_id", shareContent.getPanelId());
                jSONObject.put("resource_id", shareContent.getResourceId());
                if (z) {
                    jSONObject.put("share_token", shareContent.getShareToken());
                    jSONObject.put("share_url", shareContent.getTargetUrl());
                }
                addExtraParams(jSONObject, shareContent.getLogEventParams());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_share_success", jSONObject);
    }

    public static void sendDiversionEvent(ShareContent shareContent, String str) {
        JSONObject jSONObject = new JSONObject();
        if (shareContent != null) {
            try {
                jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
                jSONObject.put("share_channel_zlink", str);
            } catch (JSONException e) {
                Logger.m465e(e.toString());
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_channel_diversion", jSONObject);
    }

    public static void sendShareResultEvent(ShareContent shareContent, int i) {
        JSONObject jSONObject = new JSONObject();
        if (shareContent != null) {
            try {
                jSONObject.put("panel_id", shareContent.getPanelId());
                jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
                jSONObject.put("code", i);
            } catch (JSONException e) {
                Logger.m465e(e.toString());
            }
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_share_reuslt", jSONObject);
    }

    public static void sendShareSignResultEvent(ShareContent shareContent, ShareContentType shareContentType, GetSignInfoResponse getSignInfoResponse, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (shareContent != null) {
                jSONObject.put("panel_id", shareContent.getPanelId());
                jSONObject.put("channel_type", ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType()));
                if (shareContentType != null) {
                    jSONObject.put("content_type", shareContentType.getTypeName());
                }
                jSONObject.put("resource_id", shareContent.getResourceId());
                jSONObject.put(SchemaConstants.QUERY_KEY_TITLE, shareContent.getTitle());
                jSONObject.put("url", shareContent.getTargetUrl());
            }
            if (getSignInfoResponse != null) {
                jSONObject.put("result", getSignInfoResponse.getStatus());
                SignInfo signInfo = getSignInfoResponse.getSignInfo();
                if (signInfo != null) {
                    jSONObject.put("log_id", signInfo.getLogId());
                    jSONObject.put("strategy", signInfo.getStrategy());
                }
            }
            jSONObject.put("failed_reason", str);
            AppLogUtils.onEventV3("ug_sdk_share_signature_result", jSONObject);
        } catch (Throwable th) {
            Logger.m465e(th.toString());
        }
    }

    public static void sendAndroid12TokenDetectStrategyResultEvent(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException e) {
            Logger.m465e(e.toString());
        }
        addCommonParams(jSONObject);
        AppLogUtils.onEventV3("ug_sdk_share_clipboard_detect_result", jSONObject);
    }
}
