package com.bytedance.sync;

import android.content.Context;
import android.os.Build;
import com.bytedance.sdk.account.bdplatform.model.BDPlatformConstants;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.sync.interfaze.ICommonService;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.utils.ToolUtils;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.ug.bus.UgBusFramework;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SyncEventCompat {
    private static SyncEventCompat mInstance;
    private Configuration mConfiguration;
    private Context mContext;

    public static SyncEventCompat inst() {
        if (mInstance == null) {
            synchronized (SyncEventCompat.class) {
                if (mInstance == null) {
                    mInstance = new SyncEventCompat();
                }
            }
        }
        return mInstance;
    }

    private void initEventCompat(Context context, Configuration configuration) {
        this.mContext = context;
        this.mConfiguration = configuration;
    }

    private void onEventV3(String str, JSONObject jSONObject) {
        if (this.mConfiguration.enableMultiProcess && !ToolUtils.isMainProcess(this.mContext)) {
            ((ICommonService) UgBusFramework.getService(ICommonService.class)).onNonMainEvent(str, jSONObject);
        } else {
            AppLogNewUtils.onEventV3(str, jSONObject);
        }
    }

    public static void init(Context context, Configuration configuration) {
        inst().initEventCompat(context, configuration);
    }

    public static void onEvent(String str, JSONObject jSONObject) {
        try {
            onCommonEvent(jSONObject);
            inst().onEventV3(str, jSONObject);
            LogUtils.m187i("onEventV3: eventName = " + str + " " + jSONObject.toString());
        } catch (Throwable th) {
            LogUtils.m186e("onEventV3 err: " + th);
        }
    }

    private static void onCommonEvent(JSONObject jSONObject) throws JSONException {
        jSONObject.put(Constant.KEY_AID, Integer.parseInt(((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config().aid));
        IDeviceInfoGetter iDeviceInfoGetter = (IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class);
        jSONObject.put("did", Long.parseLong(iDeviceInfoGetter.getDeviceInfo().did));
        jSONObject.put("encode_uid", iDeviceInfoGetter.getDeviceInfo().uid);
        jSONObject.put("platform", "android");
        jSONObject.put("platform_version", String.valueOf(Build.VERSION.SDK_INT));
        jSONObject.put(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, String.valueOf(-1));
        jSONObject.put(Constant.KEY_APP_VERSION, "");
        jSONObject.put("params_for_special", "bytesync_sdk");
    }
}
