package com.bytedance.ug.sdk.share.impl.network.request;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.network.constant.ApiConstants;
import com.bytedance.ug.sdk.share.impl.network.model.FetchTokenResponse;
import com.bytedance.ug.sdk.share.impl.network.model.TokenRefluxInfo;
import com.bytedance.ug.sdk.share.impl.network.utils.NetworkUtils;
import com.bytedance.ug.sdk.share.impl.network.utils.TokenParseManager;
import com.google.gson.GsonBuilder;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class FetchTokenInfoThread implements Runnable {
    public static final String CLIPBOARD_TOKEN = "clipboard";
    public static final int ERROR_NO_UNKNOWN = -1;
    public static final int ERROR_OTHER_APP_TOKEN = 1001;
    public static final int ERROR_TOKEN_EXPIRED = 2;
    public static final int ERROR_TOKEN_FAILED = 1;
    public static final String IMAGE_TOKEN = "image";
    public static final String VIDEO_TOKEN = "video";
    private FetchTokenCallback mCallback;
    private String mCommand;
    private String mFrom;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface FetchTokenCallback {
        void onFailed(int i, String str);

        void onSuccess(String str);
    }

    public FetchTokenInfoThread(String str, String str2, FetchTokenCallback fetchTokenCallback) {
        this.mCommand = str;
        this.mCallback = fetchTokenCallback;
        this.mFrom = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Handler handler = new Handler(Looper.getMainLooper());
        try {
            String tokenRefluxUrl = getTokenRefluxUrl();
            if (TextUtils.isEmpty(tokenRefluxUrl)) {
                tokenRefluxUrl = NetworkUtils.addHost(ApiConstants.FETCH_TOKEN_INFO);
            }
            StringBuilder sb = new StringBuilder(tokenRefluxUrl);
            sb.append("?");
            sb.append("&token=");
            sb.append(this.mCommand);
            sb.append("&from=");
            sb.append(this.mFrom);
            NetworkUtils.appendCommonParams(sb);
            final FetchTokenResponse fetchTokenResponse = (FetchTokenResponse) new GsonBuilder().create().fromJson(ShareConfigManager.getInstance().executeGet(20480, sb.toString()), FetchTokenResponse.class);
            if (fetchTokenResponse != null && fetchTokenResponse.getStatus() == 0 && fetchTokenResponse.getData() != null) {
                handler.post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.request.FetchTokenInfoThread.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FetchTokenResponse fetchTokenResponse2;
                        if (FetchTokenInfoThread.this.mCallback == null || (fetchTokenResponse2 = fetchTokenResponse) == null || fetchTokenResponse2.getData() == null) {
                            if (FetchTokenInfoThread.this.mCallback != null) {
                                FetchTokenInfoThread.this.mCallback.onFailed(-2, null);
                                return;
                            }
                            return;
                        }
                        FetchTokenInfoThread.this.mCallback.onSuccess(fetchTokenResponse.getData().toString());
                    }
                });
            } else {
                handler.post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.request.FetchTokenInfoThread.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (FetchTokenInfoThread.this.mCallback != null) {
                            FetchTokenCallback fetchTokenCallback = FetchTokenInfoThread.this.mCallback;
                            FetchTokenResponse fetchTokenResponse2 = fetchTokenResponse;
                            int status = fetchTokenResponse2 != null ? fetchTokenResponse2.getStatus() : -1;
                            FetchTokenResponse fetchTokenResponse3 = fetchTokenResponse;
                            fetchTokenCallback.onFailed(status, fetchTokenResponse3 != null ? fetchTokenResponse3.getMessage() : null);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            handler.post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.network.request.FetchTokenInfoThread.3
                @Override // java.lang.Runnable
                public void run() {
                    if (FetchTokenInfoThread.this.mCallback != null) {
                        FetchTokenInfoThread.this.mCallback.onFailed(-1, null);
                    }
                }
            });
            ShareConfigManager.getInstance().checkResponseException(th);
        }
    }

    private String getTokenRefluxUrl() {
        List<TokenRefluxInfo> tokenVideoRegex;
        if (CLIPBOARD_TOKEN.equals(this.mFrom)) {
            tokenVideoRegex = ShareSdkManager.getInstance().getTokenActivityRegex();
        } else if ("image".equals(this.mFrom)) {
            tokenVideoRegex = ShareSdkManager.getInstance().getTokenPicRegex();
        } else {
            tokenVideoRegex = VIDEO_TOKEN.equals(this.mFrom) ? ShareSdkManager.getInstance().getTokenVideoRegex() : null;
        }
        if (tokenVideoRegex != null && tokenVideoRegex.size() > 0) {
            for (TokenRefluxInfo tokenRefluxInfo : tokenVideoRegex) {
                if (!TextUtils.isEmpty(TokenParseManager.getInstance().checkTokenRegex(this.mCommand, tokenRefluxInfo.getToken()))) {
                    return tokenRefluxInfo.getReflexUrl();
                }
            }
        }
        return null;
    }
}
