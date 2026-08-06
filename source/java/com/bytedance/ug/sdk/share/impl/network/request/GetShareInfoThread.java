package com.bytedance.ug.sdk.share.impl.network.request;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.network.constant.ApiConstants;
import com.bytedance.ug.sdk.share.impl.network.model.GetShareInfoResponse;
import com.bytedance.ug.sdk.share.impl.network.utils.NetworkUtils;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class GetShareInfoThread implements Runnable {
    public static final int ERROR_NO_UNKNOWN = -1;
    private GetShareInfoCallback mCallback;
    private JSONObject mData;
    private String mPanelId;
    private String mResourceId;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface GetShareInfoCallback {
        void onFailed(int i, String str);

        void onSuccess(GetShareInfoResponse getShareInfoResponse);
    }

    public GetShareInfoThread(String str, String str2, JSONObject jSONObject, GetShareInfoCallback getShareInfoCallback) {
        this.mCallback = getShareInfoCallback;
        this.mPanelId = str;
        this.mResourceId = str2;
        this.mData = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler = new Handler(Looper.getMainLooper());
        try {
            String shareInfoUrl = ShareSdkManager.getInstance().getShareInfoUrl(this.mPanelId);
            if (TextUtils.isEmpty(shareInfoUrl)) {
                shareInfoUrl = NetworkUtils.addHost(ApiConstants.GET_SHARE_INFO);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("share_panel_id", this.mPanelId);
            jSONObject.put("resource_id", this.mResourceId);
            JSONObject jSONObject2 = this.mData;
            if (jSONObject2 != null) {
                jSONObject.put("data", jSONObject2.toString());
            }
            final GetShareInfoResponse getShareInfoResponse = (GetShareInfoResponse) new GsonBuilder().create().fromJson(ShareConfigManager.getInstance().executePost(20480, NetworkUtils.addCommonParams(shareInfoUrl), jSONObject), GetShareInfoResponse.class);
            final int status = getShareInfoResponse != null ? getShareInfoResponse.getStatus() : -1;
            final String tips = getShareInfoResponse != null ? getShareInfoResponse.getTips() : "unknown";
            handler.post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.request.GetShareInfoThread.1
                @Override // java.lang.Runnable
                public void run() {
                    if (GetShareInfoThread.this.mCallback != null) {
                        if (status != 0 || getShareInfoResponse.getShareInfoList() == null) {
                            GetShareInfoThread.this.mCallback.onFailed(status, tips);
                        } else {
                            GetShareInfoThread.this.mCallback.onSuccess(getShareInfoResponse);
                        }
                    }
                }
            });
        } catch (Throwable th) {
            handler.post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.request.GetShareInfoThread.2
                @Override // java.lang.Runnable
                public void run() {
                    if (GetShareInfoThread.this.mCallback != null) {
                        GetShareInfoThread.this.mCallback.onFailed(-1, th.toString());
                    }
                }
            });
            ShareConfigManager.getInstance().checkResponseException(th);
        }
    }
}
