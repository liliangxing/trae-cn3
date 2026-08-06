package com.bytedance.reparo;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import com.bytedance.reparo.core.utils.NetworkUtils;
import com.bytedance.reparo.secondary.Logger;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class ReparoConfigExternalAdapter extends IReparoConfig {
    private static final String META_KEY_MARS_APP_ID = "MARS_APP_ID";
    private static final String META_KEY_UPDATE_VERSION_CODE = "UPDATE_VERSION_CODE";
    private static final String TAG = "FrankieConfigExternalAdapter";
    private static final String UNKNOWN = "unknown";

    public abstract String getAppKey();

    public abstract String getAppSecretKey();

    @Override // com.bytedance.reparo.IReparoConfig
    public String getAppId() {
        Application application = getApplication();
        try {
            Bundle bundle = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData;
            if (bundle == null) {
                throw new IllegalStateException(String.format("app id is empty, need to set %s in meta-data in AndroidManifest.xml", META_KEY_MARS_APP_ID));
            }
            String valueOf = String.valueOf(bundle.get(META_KEY_MARS_APP_ID));
            if (TextUtils.isEmpty(valueOf)) {
                throw new IllegalStateException(String.format("app id is empty, need to set %s in meta-data in AndroidManifest.xml", META_KEY_MARS_APP_ID));
            }
            return valueOf;
        } catch (Throwable th) {
            Logger.m327e(TAG, "get app id failed. ", th);
            return "unknown";
        }
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public String getUpdateVersionCode() {
        Application application = getApplication();
        try {
            Bundle bundle = application.getPackageManager().getApplicationInfo(application.getPackageName(), 128).metaData;
            if (bundle == null) {
                throw new IllegalStateException(String.format("update version code is empty, need to set %s in meta-data in AndroidManifest.xml", META_KEY_UPDATE_VERSION_CODE));
            }
            String valueOf = String.valueOf(bundle.get(META_KEY_UPDATE_VERSION_CODE));
            if (TextUtils.isEmpty(valueOf)) {
                throw new IllegalStateException(String.format("update version code is empty, need to set %s in meta-data in AndroidManifest.xml", META_KEY_UPDATE_VERSION_CODE));
            }
            return valueOf;
        } catch (Throwable th) {
            Logger.m327e(TAG, "get update version code failed. ", th);
            return "unknown";
        }
    }

    @Override // com.bytedance.reparo.IReparoConfig
    public final String executePatchRequest(int i, String str, byte[] bArr, String str2) throws Exception {
        String buildUrlParameters = buildUrlParameters(str);
        MediaType parse = MediaType.parse(str2);
        String str3 = new String(bArr);
        Request.Builder url = new Request.Builder().url(buildUrlParameters);
        NetworkUtils.getInstance().sign(url, str3, getAppKey(), getAppSecretKey());
        return NetworkUtils.getInstance().getClient().newCall(url.addHeader(XBridgeAPIRequestUtils.CONTENT_TYPE, str2).post(RequestBody.create(parse, str3)).build()).execute().body().string();
    }

    private String buildUrlParameters(String str) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter(CommonConstants.KEY_DID, getDeviceId()).appendQueryParameter("channel", getChannel()).appendQueryParameter(CommonConstants.KEY_AID, getAppId()).appendQueryParameter(CommonConstants.KEY_DEVICE_PLATFORM, "android").appendQueryParameter("os_api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("version_code", String.valueOf(getVersionCode())).appendQueryParameter("update_version_code", getUpdateVersionCode());
        try {
            String str2 = Build.VERSION.RELEASE;
            if (str2 != null && str2.length() > 10) {
                str2 = str2.substring(0, 10);
            }
            buildUpon.appendQueryParameter(CommonConstants.KEY_OS_VERSION, str2);
        } catch (Exception e) {
            Logger.m327e(TAG, e.getMessage(), e);
        }
        return buildUpon.build().toString();
    }

    public long getVersionCode() {
        long j;
        try {
            Application application = getApplication();
            PackageInfo packageInfo = application.getPackageManager().getPackageInfo(application.getPackageName(), 0);
            if (Build.VERSION.SDK_INT >= 28) {
                j = packageInfo.getLongVersionCode();
            } else {
                j = packageInfo.versionCode;
            }
            return j;
        } catch (Throwable unused) {
            return -1L;
        }
    }
}
