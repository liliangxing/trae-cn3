package com.bytedance.ug.sdk.deeplink;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ug.sdk.deeplink.interfaces.INetwork;
import com.bytedance.ug.sdk.deeplink.utils.CommonUtils;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.NetworkUtils;
import com.bytedance.ug.sdk.deeplink.utils.SharedPreferencesHelper;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import com.bytedance.ug.sdk.deeplink.utils.ZLinkToolUtils;
import com.ss.android.deviceregister.DeviceRegisterManager;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HuaWeiReferrerHelper {
    public static final String TAG = "HuaWeiReferrerHelper";
    private final AtomicBoolean isUpLoadingOrSucceed;

    private HuaWeiReferrerHelper() {
        this.isUpLoadingOrSucceed = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class InstanceHolder {
        private static final HuaWeiReferrerHelper huaWeiReferrerHelper = new HuaWeiReferrerHelper();

        private InstanceHolder() {
        }
    }

    public static HuaWeiReferrerHelper getInstance() {
        return InstanceHolder.huaWeiReferrerHelper;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0102 A[Catch: all -> 0x011a, TRY_ENTER, TryCatch #3 {all -> 0x011a, blocks: (B:43:0x0102, B:55:0x0109), top: B:41:0x0100 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0109 A[Catch: all -> 0x011a, TRY_LEAVE, TryCatch #3 {all -> 0x011a, blocks: (B:43:0x0102, B:55:0x0109), top: B:41:0x0100 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void getReferrerAndUpload(Context context) {
        String str;
        ContentResolver contentResolver;
        Cursor query;
        Exception exc;
        String str2;
        String str3;
        String str4;
        IZlinkDepend zlinkDepend;
        String str5;
        String str6;
        INetwork iNetwork;
        String str7;
        String str8 = ViewVisibleBridge.INVISIBLE;
        str = "null";
        if (context == null) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        if (CommonUtils.isHuaWei() && CommonUtils.isFirstStartAfterInstalled(applicationContext, CommonConstants.KEY_NOT_FIRST_INSTALLED_FOR_HR) && !this.isUpLoadingOrSucceed.getAndSet(true)) {
            SharedPreferencesHelper sharedPreferencesHelper = SharedPreferencesHelper.getInstance(applicationContext);
            if ((sharedPreferencesHelper != null ? sharedPreferencesHelper.getBoolean(CommonConstants.HW_REFERRER_UPLOAD, false) : false) || (contentResolver = applicationContext.getContentResolver()) == null || (query = contentResolver.query(Uri.parse(CommonConstants.HW_REFERRER_PROVIDER_URL), null, null, new String[]{applicationContext.getPackageName()}, null)) == null) {
                return;
            }
            try {
                try {
                    query.moveToFirst();
                    str3 = query.getString(0);
                    try {
                        str4 = query.getString(1);
                        try {
                            str8 = query.getString(2);
                            str = query.getColumnCount() > 4 ? query.getString(4) : "null";
                        } catch (Exception e) {
                            exc = e;
                            str2 = str8;
                            str8 = str4;
                            exc.printStackTrace();
                            Logger.m446d(TAG, "The cursor operation occurs exception and exception is : " + exc.getMessage());
                            query.close();
                            str4 = str8;
                            str8 = str2;
                            zlinkDepend = HostCommonServices.getZlinkDepend();
                            if (zlinkDepend == null) {
                            }
                            Uri.Builder buildUpon = Uri.parse(CommonConstants.REFERRER_UPLOAD_URL).buildUpon();
                            buildUpon.appendQueryParameter("referrer", str3);
                            buildUpon.appendQueryParameter("click_time", str4);
                            buildUpon.appendQueryParameter("install_time", str8);
                            buildUpon.appendQueryParameter("track_id", str);
                            buildUpon.appendQueryParameter("ad_platform", CommonConstants.HW_AD_PLATFORM);
                            buildUpon.appendQueryParameter("app_id", str5);
                            buildUpon.appendQueryParameter(CommonConstants.KEY_DID, str6);
                            String builder = buildUpon.toString();
                            iNetwork = (INetwork) ZlinkProviderManager.getProvider(INetwork.class);
                            long currentTimeMillis = System.currentTimeMillis();
                            str7 = null;
                            if (iNetwork != null) {
                            }
                            if (TextUtils.isEmpty(str7)) {
                            }
                        }
                    } catch (Exception e2) {
                        exc = e2;
                        str2 = ViewVisibleBridge.INVISIBLE;
                    }
                } catch (Exception e3) {
                    exc = e3;
                    str2 = ViewVisibleBridge.INVISIBLE;
                    str3 = "null";
                }
                zlinkDepend = HostCommonServices.getZlinkDepend();
                if (zlinkDepend == null) {
                    str5 = zlinkDepend.getAppId();
                    str6 = zlinkDepend.getDeviceId();
                } else {
                    str5 = "";
                    str6 = "";
                }
                Uri.Builder buildUpon2 = Uri.parse(CommonConstants.REFERRER_UPLOAD_URL).buildUpon();
                buildUpon2.appendQueryParameter("referrer", str3);
                buildUpon2.appendQueryParameter("click_time", str4);
                buildUpon2.appendQueryParameter("install_time", str8);
                buildUpon2.appendQueryParameter("track_id", str);
                buildUpon2.appendQueryParameter("ad_platform", CommonConstants.HW_AD_PLATFORM);
                buildUpon2.appendQueryParameter("app_id", str5);
                buildUpon2.appendQueryParameter(CommonConstants.KEY_DID, str6);
                String builder2 = buildUpon2.toString();
                iNetwork = (INetwork) ZlinkProviderManager.getProvider(INetwork.class);
                long currentTimeMillis2 = System.currentTimeMillis();
                str7 = null;
                try {
                    if (iNetwork != null) {
                        Logger.m446d(TAG, "the INetwork is null so the request couldn't be sent !");
                    } else {
                        str7 = NetworkUtils.getInstance().executeGetRequest(builder2, new HashMap(), true, 2000L);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger.m446d(TAG, "the network request occurs exception and the exception is : " + th.getMessage());
                }
                if (TextUtils.isEmpty(str7)) {
                    this.isUpLoadingOrSucceed.set(true);
                    sendEvent(str3, currentTimeMillis2, true);
                    if (sharedPreferencesHelper != null) {
                        sharedPreferencesHelper.putBoolean(CommonConstants.HW_REFERRER_UPLOAD, true);
                        return;
                    }
                    return;
                }
                this.isUpLoadingOrSucceed.set(false);
                sendEvent(str3, currentTimeMillis2, false);
                Logger.m446d(TAG, "the network request return by the response is null !");
            } finally {
                query.close();
            }
        }
    }

    private void sendEvent(String str, long j, boolean z) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        JSONObject jSONObject = new JSONObject();
        try {
            int i = 1;
            JSONObject put = jSONObject.put(EventConstants.PARAM_PARAM_VALID, !TextUtils.isEmpty(str) ? 1 : 0);
            if (!z) {
                i = 0;
            }
            put.put("result", i).put(EventConstants.PARAM_TIME_CONSUME, currentTimeMillis);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        EventUtil.sendHuaweiReferResultEvent(jSONObject);
    }

    private String getRawDataForSpecialRow(Cursor cursor) {
        int columnCount;
        if (cursor == null || (columnCount = cursor.getColumnCount()) <= 0) {
            return null;
        }
        for (int i = 0; i < columnCount; i++) {
            cursor.getColumnName(i);
            cursor.getString(i);
        }
        return null;
    }

    public void referrerAndUploadForHuaWeiWithDid(final Context context) {
        if (context == null || !HostCommonServices.isEnableHuaWeiReferrer()) {
            return;
        }
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        if (zlinkDepend != null && TextUtils.isEmpty(zlinkDepend.getDeviceId())) {
            addDidCallBack(context);
        } else {
            ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.deeplink.HuaWeiReferrerHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    HuaWeiReferrerHelper.getInstance().getReferrerAndUpload(context);
                }
            });
        }
    }

    private void addDidCallBack(Context context) {
        if (ZLinkToolUtils.isMainProcess(context)) {
            try {
                try {
                    DeviceRegisterManager.addOnDeviceConfigUpdateListener(DeviceIdUpdateListener.getInstance());
                } catch (NoClassDefFoundError unused) {
                    AppLog.addDataObserver(DeviceIdObserver.getInstance());
                }
            } catch (NoClassDefFoundError unused2) {
            }
        }
    }
}
