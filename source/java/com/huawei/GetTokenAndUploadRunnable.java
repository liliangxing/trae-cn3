package com.huawei;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.utils.Util;
import com.p032hw.HWPushAdapter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class GetTokenAndUploadRunnable implements Runnable {
    private final Context mContext;
    private final int mPushType;
    private String mToken;

    public GetTokenAndUploadRunnable(Context context) {
        this.mContext = context;
        this.mPushType = HWPushAdapter.getHwPush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetTokenAndUploadRunnable(Context context, String str) {
        this(context);
        this.mToken = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = this.mToken;
            if (TextUtils.isEmpty(str)) {
                str = tryGetTokenOrMonitor();
            }
            if (TextUtils.isEmpty(str)) {
                Logger.e(HWPushAdapter.TAG, "get huawei token error!!");
            } else {
                Logger.i(HWPushAdapter.TAG, "get token success : " + str);
                doUploadToken(str);
            }
        } catch (ApiException e) {
            int statusCode = e.getStatusCode();
            PushSupporter.logger().e(HWPushAdapter.TAG, "getToken error，errCode = " + statusCode + " please visit : https://developer.huawei.com/consumer/cn/doc/development/HMS-References/status");
            getTokenError(String.valueOf(statusCode));
        } catch (Exception e2) {
            e2.printStackTrace();
            getTokenError("");
        }
    }

    private int getAppIdFromManifest() {
        int parseInt;
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!((PushOnlineSettings) SettingsManager.obtain(this.mContext, PushOnlineSettings.class)).useHwManifestAppId()) {
            Logger.w(HWPushAdapter.TAG, "useHwManifestAppId is false, not read hw appid from manifest");
            return -1;
        }
        Bundle bundle = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128).metaData;
        int i = bundle.getInt("APPKEY");
        Matcher matcher = Pattern.compile("=([0-9]+)").matcher(bundle.getString("com.huawei.hms.client.appid"));
        if (matcher.find() && (parseInt = Integer.parseInt(matcher.group(1))) == i) {
            return parseInt;
        }
        return -1;
    }

    private String tryGetTokenOrMonitor() throws ApiException {
        String appId;
        int isHuaweiMobileServicesAvailable = HMSUtils.isHuaweiMobileServicesAvailable(this.mContext);
        if (isHuaweiMobileServicesAvailable != 0) {
            Logger.w(HWPushAdapter.TAG, "hms not available:" + isHuaweiMobileServicesAvailable);
            PushSupporter.monitor().monitorRegisterSenderFailed(this.mPushType, 109, String.valueOf(isHuaweiMobileServicesAvailable), "hms not available");
            return null;
        }
        int appIdFromManifest = getAppIdFromManifest();
        Logger.i(HWPushAdapter.TAG, "AppIdFromManifest:" + appIdFromManifest);
        if (appIdFromManifest > 0) {
            appId = String.valueOf(appIdFromManifest);
        } else {
            Logger.i(HWPushAdapter.TAG, "read app id by huawei utils");
            appId = Util.getAppId(this.mContext);
        }
        String token = HmsInstanceId.getInstance(this.mContext).getToken(appId, HmsMessaging.DEFAULT_TOKEN_SCOPE);
        if (!TextUtils.isEmpty(token) || !RomUtils.getInstance().isHigherEmui10()) {
            return token;
        }
        getTokenError("");
        return null;
    }

    private void doUploadToken(String str) {
        PushSupporter.thirdService().registerSenderSuccessAndUploadToken(this.mContext, this.mPushType, str);
    }

    private void getTokenError(String str) {
        PushSupporter.monitor().monitorRegisterSenderFailed(this.mPushType, 102, str, "get token error");
    }
}
