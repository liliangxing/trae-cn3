package com.bytedance.ug.sdk.share.impl.network.request;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.share.impl.cache.ShareCacheManager;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.network.constant.ApiConstants;
import com.bytedance.ug.sdk.share.impl.network.model.InitShareResponse;
import com.bytedance.ug.sdk.share.impl.network.utils.NetworkUtils;
import com.bytedance.ug.sdk.share.impl.utils.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class InitShareSdkThread implements Runnable {
    public static final int ERROR_NO_UNKNOWN = -1;
    private static final String TAG = "InitShareSdkThread";
    private InitShareSdkCallback mCallback;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface InitShareSdkCallback {
        void onFailed(int i, String str);

        void onSuccess(InitShareResponse initShareResponse);
    }

    public InitShareSdkThread(InitShareSdkCallback initShareSdkCallback) {
        this.mCallback = initShareSdkCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler = new Handler(Looper.getMainLooper());
        try {
            String executeGet = ShareConfigManager.getInstance().executeGet(20480, NetworkUtils.addCommonParams(NetworkUtils.addHost(ApiConstants.INIT_SHARE_SDK)));
            Logger.m469i(TAG, "share init response is " + executeGet);
            JSONObject jSONObject = new JSONObject(executeGet);
            String optString = jSONObject.optString("data");
            final InitShareResponse initShareResponse = (InitShareResponse) new GsonBuilder().create().fromJson(optString, InitShareResponse.class);
            final int optInt = jSONObject.optInt(CommonConstants.KEY_ERROR_NO, -1);
            final String optString2 = jSONObject.optString(CommonConstants.KEY_ERROR_TIPS, "unknown");
            Logger.m469i(TAG, "share init data parse success");
            if (!TextUtils.isEmpty(optString) && optInt == 0) {
                handler.post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.request.InitShareSdkThread.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (InitShareSdkThread.this.mCallback != null) {
                            InitShareSdkThread.this.mCallback.onSuccess(initShareResponse);
                        }
                    }
                });
                if (initShareResponse != null) {
                    if (initShareResponse.getTokenRegex() != null) {
                        ShareCacheManager.getInstance().setTokenRegex(initShareResponse.getTokenRegex());
                    }
                    if (initShareResponse.getTokenStrategy() != null) {
                        ShareCacheManager.getInstance().setTokenStrategy(new Gson().toJson(initShareResponse.getTokenStrategy()));
                    }
                    if (initShareResponse.getTokenActivityRegex() != null) {
                        ShareCacheManager.getInstance().setTokenActivityRegex(new Gson().toJson(initShareResponse.getTokenActivityRegex()));
                    }
                    if (initShareResponse.getTokenPicRegex() != null) {
                        ShareCacheManager.getInstance().setTokenPicRegex(new Gson().toJson(initShareResponse.getTokenPicRegex()));
                    }
                    if (initShareResponse.getTokenVideoRegex() != null) {
                        ShareCacheManager.getInstance().setTokenVideoRegex(new Gson().toJson(initShareResponse.getTokenVideoRegex()));
                    }
                    if (initShareResponse.getPanelList() != null) {
                        ShareCacheManager.getInstance().setPanelList(new Gson().toJson(initShareResponse.getPanelList()));
                    }
                    if (initShareResponse.getZlinkInfoList() != null && initShareResponse.getZlinkInfoList().size() > 0) {
                        ShareCacheManager.getInstance().setZlinkInfoList(new Gson().toJson(initShareResponse.getZlinkInfoList()));
                    }
                    if (initShareResponse.getInitSettings() != null) {
                        String json = new Gson().toJson(initShareResponse.getInitSettings().getCheckAndSignChannelList());
                        ShareCacheManager.getInstance().setAndroid12TokenDetectStrategy(new Gson().toJson(initShareResponse.getInitSettings().getAndroid12TokenDetectStrategy()));
                        ShareCacheManager.getInstance().setCheckAndSignChannelList(json);
                        ShareCacheManager.getInstance().setEnableUseTimon(initShareResponse.getInitSettings().getUseTimon());
                        return;
                    }
                    return;
                }
                return;
            }
            handler.post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.request.InitShareSdkThread.2
                @Override // java.lang.Runnable
                public void run() {
                    if (InitShareSdkThread.this.mCallback != null) {
                        InitShareSdkThread.this.mCallback.onFailed(optInt, optString2);
                    }
                }
            });
        } catch (Exception e) {
            handler.post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.request.InitShareSdkThread.3
                @Override // java.lang.Runnable
                public void run() {
                    if (InitShareSdkThread.this.mCallback != null) {
                        InitShareSdkThread.this.mCallback.onFailed(-1, e.toString());
                    }
                }
            });
            ShareConfigManager.getInstance().checkResponseException(e);
        }
    }
}
