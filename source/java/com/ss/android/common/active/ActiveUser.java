package com.ss.android.common.active;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.common.applog.AppLog;
import com.ss.android.common.applog.AppLogNewMonitor;
import com.ss.android.common.applog.NetUtil;
import com.ss.android.common.applog.NetUtilWrapper;
import com.ss.android.common.util.BDNetworkTagManagerHelper;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.GaidGetter;
import com.ss.android.deviceregister.base.DrHelperWithRegion;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.deviceregister.utils.HardwareUtils;
import com.vivo.push.PushClient;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TimeZone;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ActiveUser {
    private static final String KEY_MESSAGE = "message";
    private static final String STATUS_OK = "success";
    private static final String TAG = "ActiveUser";
    private static boolean sActiveSuccess;
    private static volatile long sStartTime;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface RequestCallback {
        void onResult(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean activeUser(Context context, String[] strArr, boolean z, boolean z2) {
        try {
            boolean isTouristMode = DeviceRegisterManager.isTouristMode();
            StringBuilder sb = new StringBuilder();
            if (!z && !isTouristMode) {
                try {
                    Pair<String, Boolean> gaid = GaidGetter.getGaid(context);
                    if (gaid != null) {
                        addParams(sb, RegistrationHeaderHelper.KEY_GOOGLE_AID_LIMIT, gaid.second != null && ((Boolean) gaid.second).booleanValue() ? PushClient.DEFAULT_REQUEST_ID : "0", true);
                        addParams(sb, "google_aid", (String) gaid.first, true);
                    }
                } catch (Exception e) {
                    TLog.m81w("ActiveUser prepare app_alert param exception: " + e);
                }
            }
            float rawOffset = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
            if (rawOffset < -12.0f) {
                rawOffset = -12.0f;
            }
            if (rawOffset > 12.0f) {
                rawOffset = 12.0f;
            }
            addParams(sb, "timezone", rawOffset + "", false);
            IAppTraitCallback appTraitCallback = DeviceRegisterManager.getAppTraitCallback();
            if (appTraitCallback != null) {
                addParams(sb, "app_trait", appTraitCallback.get(context), true);
            }
            String fakePackage = RegistrationHeaderHelper.getFakePackage();
            if (!TextUtils.isEmpty(fakePackage)) {
                addParams(sb, "package", fakePackage, true);
                addParams(sb, RegistrationHeaderHelper.KEY_REAL_PACKAGE_NAME, context.getPackageName(), true);
            }
            addParams(sb, "carrier", HardwareUtils.getCarrier(context), true);
            addParams(sb, "mcc_mnc", HardwareUtils.getMccMnc(context), true);
            addParams(sb, RegistrationHeaderHelper.KEY_SIM_REGION, HardwareUtils.getSimRegion(context), true);
            addParams(sb, "custom_bt", String.valueOf(getBootTime()), true);
            if (RegistrationHeaderHelper.reportPhoneDetailInfo()) {
                DrHelperWithRegion.appendActiveUserParam(context, sb);
            }
            addParams(sb, "app_version_minor", AppLog.getAppVersionMinor(), true);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            NetUtil.putCommonParamsWithLevel(linkedHashMap, true, Level.L0);
            for (String str : strArr) {
                StringBuilder sb2 = new StringBuilder(str);
                sb2.append(sb.toString());
                NetUtil.activePutCommonParams(sb2, linkedHashMap);
                String addQuery = addQuery(sb2.toString(), "req_id", DeviceRegisterManager.getRequestId());
                TLog.m77i("request : " + addQuery);
                HashMap hashMap = new HashMap();
                BDNetworkTagManagerHelper.addHeader(hashMap, z2);
                try {
                    String str2 = NetworkClient.getDefault().get(NetUtilWrapper.encryptUrl(addQuery), hashMap, (NetworkClient.ReqContext) null);
                    TLog.m73d("NetworkClient.getDefault().get response:" + str2);
                    if (!StringUtils.isEmpty(str2)) {
                        if ("success".equals(new JSONObject(str2).optString("message"))) {
                            return true;
                        }
                    } else {
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                    }
                } catch (Throwable unused) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                }
            }
        } catch (Exception e2) {
            TLog.m81w("ActiveUser NetworkClient.getDefault().get exception:" + e2);
        }
        return false;
    }

    private static long getBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private static String addQuery(String str, String str2, String str3) {
        try {
            return TextUtils.isEmpty(str2) ? str : Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build().toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private static void addParams(StringBuilder sb, String str, String str2, boolean z) {
        if (sb == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (sb.toString().indexOf(63) < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        StringBuilder append = sb.append(str).append("=");
        if (z) {
            str2 = Uri.encode(str2);
        }
        append.append(str2);
    }

    public static void requestActive(Context context, String[] strArr, boolean z, boolean z2) {
        if (z2 && sActiveSuccess) {
            return;
        }
        new ActiveThread(context, strArr, z, !sActiveSuccess, new RequestCallback() { // from class: com.ss.android.common.active.ActiveUser.1
            @Override // com.ss.android.common.active.ActiveUser.RequestCallback
            public void onResult(boolean z3) {
                if (!z3 || ActiveUser.sActiveSuccess) {
                    return;
                }
                boolean unused = ActiveUser.sActiveSuccess = z3;
            }
        }).start();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ActiveThread extends Thread {
        private final boolean childMode;
        private final RequestCallback mCallback;
        private Context mContext;
        private final boolean mIgnoreFrequencyControl;
        private long mStartTime = System.currentTimeMillis();
        private String[] mUrl;

        public ActiveThread(Context context, String[] strArr, boolean z, boolean z2, RequestCallback requestCallback) {
            this.mContext = context;
            this.mUrl = strArr;
            this.childMode = z;
            this.mCallback = requestCallback;
            this.mIgnoreFrequencyControl = z2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (ActiveUser.sStartTime <= 0) {
                long unused = ActiveUser.sStartTime = this.mStartTime;
            }
            boolean activeUser = ActiveUser.activeUser(this.mContext, this.mUrl, this.childMode, this.mIgnoreFrequencyControl);
            RequestCallback requestCallback = this.mCallback;
            if (requestCallback != null) {
                requestCallback.onResult(activeUser);
            }
            if (activeUser) {
                System.currentTimeMillis();
                if (ActiveUser.sStartTime > 0) {
                    long unused2 = ActiveUser.sStartTime = 0L;
                }
            }
        }
    }
}
