package com.bytedance.ug.sdk.share.channel.wechat.wxshare;

import android.text.TextUtils;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.network.request.GetSignInfoThread;
import com.bytedance.ug.sdk.share.impl.utils.EncryptUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WXShareSignHelper {
    private static final String TAG = "WXShareSignHelper";

    public static void signText(ShareContent shareContent, WXTextObject wXTextObject, GetSignInfoThread.GetSignInfoCallback getSignInfoCallback) {
        if (needSign(shareContent, getSignInfoCallback)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("text", wXTextObject.text);
                ShareConfigManager.getInstance().execute(new GetSignInfoThread(shareContent, ShareContentType.TEXT, jSONObject, getSignInfoCallback));
            } catch (Throwable th) {
                Logger.m467e(TAG, "signText()...error", th);
            }
        }
    }

    public static void signH5(ShareContent shareContent, WXWebpageObject wXWebpageObject, WXMediaMessage wXMediaMessage, GetSignInfoThread.GetSignInfoCallback getSignInfoCallback) {
        if (needSign(shareContent, getSignInfoCallback)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("webpageUrl", wXWebpageObject.webpageUrl);
                jSONObject.put(SchemaConstants.QUERY_KEY_TITLE, wXMediaMessage.title);
                if (!TextUtils.isEmpty(wXMediaMessage.description)) {
                    jSONObject.put("description", wXMediaMessage.description);
                }
                if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                    wXMediaMessage.thumbDataHash = EncryptUtils.sha256(wXMediaMessage.thumbData);
                    jSONObject.put("thumbDataHash", wXMediaMessage.thumbDataHash);
                }
                ShareConfigManager.getInstance().execute(new GetSignInfoThread(shareContent, ShareContentType.H5, jSONObject, getSignInfoCallback));
            } catch (Throwable th) {
                Logger.m467e(TAG, "signH5()...error", th);
            }
        }
    }

    public static void signVideo(ShareContent shareContent, WXVideoObject wXVideoObject, WXMediaMessage wXMediaMessage, GetSignInfoThread.GetSignInfoCallback getSignInfoCallback) {
        if (needSign(shareContent, getSignInfoCallback)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("videoUrl", wXVideoObject.videoUrl);
                jSONObject.put(SchemaConstants.QUERY_KEY_TITLE, wXMediaMessage.title);
                if (!TextUtils.isEmpty(wXMediaMessage.description)) {
                    jSONObject.put("description", wXMediaMessage.description);
                }
                if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                    wXMediaMessage.thumbDataHash = EncryptUtils.sha256(wXMediaMessage.thumbData);
                    jSONObject.put("thumbDataHash", wXMediaMessage.thumbDataHash);
                }
                ShareConfigManager.getInstance().execute(new GetSignInfoThread(shareContent, ShareContentType.VIDEO, jSONObject, getSignInfoCallback));
            } catch (Throwable th) {
                Logger.m467e(TAG, "signVideo()...error", th);
            }
        }
    }

    public static void signAudio(ShareContent shareContent, WXMusicObject wXMusicObject, WXMediaMessage wXMediaMessage, GetSignInfoThread.GetSignInfoCallback getSignInfoCallback) {
        if (needSign(shareContent, getSignInfoCallback)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("musicUrl", wXMusicObject.musicUrl);
                jSONObject.put(SchemaConstants.QUERY_KEY_TITLE, wXMediaMessage.title);
                if (!TextUtils.isEmpty(wXMediaMessage.description)) {
                    jSONObject.put("description", wXMediaMessage.description);
                }
                if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                    wXMediaMessage.thumbDataHash = EncryptUtils.sha256(wXMediaMessage.thumbData);
                    jSONObject.put("thumbDataHash", wXMediaMessage.thumbDataHash);
                }
                ShareConfigManager.getInstance().execute(new GetSignInfoThread(shareContent, ShareContentType.AUDIO, jSONObject, getSignInfoCallback));
            } catch (Throwable th) {
                Logger.m467e(TAG, "signAudio()...error", th);
            }
        }
    }

    public static void signMiniApp(ShareContent shareContent, WXMiniProgramObject wXMiniProgramObject, WXMediaMessage wXMediaMessage, GetSignInfoThread.GetSignInfoCallback getSignInfoCallback) {
        if (needSign(shareContent, getSignInfoCallback)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SchemaConstants.QUERY_KEY_TITLE, wXMediaMessage.title);
                if (!TextUtils.isEmpty(wXMediaMessage.description)) {
                    jSONObject.put("description", wXMediaMessage.description);
                }
                if (wXMediaMessage.thumbData != null && wXMediaMessage.thumbData.length > 0) {
                    wXMediaMessage.thumbDataHash = EncryptUtils.sha256(wXMediaMessage.thumbData);
                    jSONObject.put("thumbDataHash", wXMediaMessage.thumbDataHash);
                }
                if (!TextUtils.isEmpty(wXMiniProgramObject.userName)) {
                    jSONObject.put("userName", wXMiniProgramObject.userName);
                }
                if (!TextUtils.isEmpty(wXMiniProgramObject.path)) {
                    jSONObject.put("path", wXMiniProgramObject.path);
                }
                ShareConfigManager.getInstance().execute(new GetSignInfoThread(shareContent, ShareContentType.MINI_APP, jSONObject, getSignInfoCallback));
            } catch (Throwable th) {
                Logger.m467e(TAG, "signMiniApp()...error", th);
            }
        }
    }

    private static boolean needSign(ShareContent shareContent, GetSignInfoThread.GetSignInfoCallback getSignInfoCallback) {
        String strategyStr = ShareStrategy.getStrategyStr(shareContent.getShareStrategy());
        String shareItemTypeName = ShareChannelType.getShareItemTypeName(shareContent.getShareChanelType());
        boolean isChannelNeedCheckAndSign = ShareSdkManager.getInstance().isChannelNeedCheckAndSign(shareItemTypeName);
        Logger.m469i(TAG, "channel = " + shareItemTypeName + ", switch = " + isChannelNeedCheckAndSign + ", strategy = " + strategyStr);
        boolean z = false;
        boolean z2 = shareContent.getShareStrategy() == null || shareContent.getShareStrategy() == ShareStrategy.NORMAL;
        if (isChannelNeedCheckAndSign && z2) {
            z = true;
        }
        if (!z && getSignInfoCallback != null) {
            getSignInfoCallback.onSignResult(true, "");
        }
        return z;
    }
}
