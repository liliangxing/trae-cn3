package com.bytedance.ug.sdk.share.impl.network.request;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.network.constant.ApiConstants;
import com.bytedance.ug.sdk.share.impl.network.model.GetSignInfoResponse;
import com.bytedance.ug.sdk.share.impl.network.utils.NetworkUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GetSignInfoThread implements Runnable {
    private static final String TAG = "GetSignInfoThread";
    private final GetSignInfoCallback mCallback;
    private final ShareContent mShareContent;
    private final JSONObject mShareContentSignObj;
    private final ShareContentType mShareContentType;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface GetSignInfoCallback {
        void onSignResult(boolean z, String str);
    }

    public GetSignInfoThread(ShareContent shareContent, ShareContentType shareContentType, JSONObject jSONObject, GetSignInfoCallback getSignInfoCallback) {
        this.mShareContent = shareContent;
        this.mShareContentType = shareContentType;
        this.mShareContentSignObj = jSONObject;
        this.mCallback = getSignInfoCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject;
        try {
            ShareContent shareContent = this.mShareContent;
            if (shareContent != null && shareContent.getShareChanelType() != null && this.mShareContentType != null && (jSONObject = this.mShareContentSignObj) != null && jSONObject.length() > 0) {
                String addHost = NetworkUtils.addHost(ApiConstants.GET_SIGN_INFO);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("share_channel", ShareChannelType.getShareItemTypeName(this.mShareContent.getShareChanelType()));
                jSONObject2.put("share_type", this.mShareContentType.getTypeName());
                jSONObject2.put("share_content", this.mShareContentSignObj);
                String executePost = ShareConfigManager.getInstance().executePost(20480, NetworkUtils.addCommonParams(addHost), jSONObject2);
                if (TextUtils.isEmpty(executePost)) {
                    callFailedOnMainThread(new Throwable("response == null"));
                    return;
                }
                GetSignInfoResponse getSignInfoResponse = (GetSignInfoResponse) new GsonBuilder().create().fromJson(executePost, GetSignInfoResponse.class);
                if (getSignInfoResponse == null) {
                    callFailedOnMainThread(new Throwable("GetSignInfoResponse == null"));
                    return;
                } else {
                    callSuccessOnMainThread(getSignInfoResponse);
                    return;
                }
            }
            callFailedOnMainThread(new Throwable("params error"));
        } catch (Throwable th) {
            callFailedOnMainThread(th);
            ShareConfigManager.getInstance().checkResponseException(th);
        }
    }

    private void callSuccessOnMainThread(final GetSignInfoResponse getSignInfoResponse) {
        Logger.m469i(TAG, "callSuccessOnMainThread()...");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.request.GetSignInfoThread.1
            @Override // java.lang.Runnable
            public void run() {
                if (GetSignInfoThread.this.mCallback != null) {
                    boolean z = true;
                    if (getSignInfoResponse.getStatus() == 0 && getSignInfoResponse.getSignInfo() != null && !TextUtils.isEmpty(getSignInfoResponse.getSignInfo().getSignature())) {
                        GetSignInfoThread.this.mCallback.onSignResult(true, getSignInfoResponse.getSignInfo().getSignature());
                        return;
                    }
                    if (getSignInfoResponse.getSignInfo() != null && !getSignInfoResponse.getSignInfo().continueShare()) {
                        z = false;
                    }
                    Logger.m469i(GetSignInfoThread.TAG, "sign failed, continueShare = " + z);
                    GetSignInfoThread.this.mCallback.onSignResult(z, "");
                }
            }
        });
        ShareEvent.sendShareSignResultEvent(this.mShareContent, this.mShareContentType, getSignInfoResponse, "");
    }

    private void callFailedOnMainThread(Throwable th) {
        Logger.m467e(TAG, "callFailedOnMainThread()...", th);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.request.GetSignInfoThread.2
            @Override // java.lang.Runnable
            public void run() {
                if (GetSignInfoThread.this.mCallback != null) {
                    GetSignInfoThread.this.mCallback.onSignResult(true, "");
                }
            }
        });
        ShareEvent.sendShareSignResultEvent(this.mShareContent, this.mShareContentType, null, th.toString());
    }
}
