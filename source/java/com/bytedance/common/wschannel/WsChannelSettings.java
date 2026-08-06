package com.bytedance.common.wschannel;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* loaded from: classes3.dex */
public class WsChannelSettings {
    private static final String TAG = "com.bytedance.common.wschannel.WsChannelSettings";
    private static volatile WsChannelSettings mInstance;
    private static OkOpaqueCallback sOkOpaqueCallback;
    private final WsChannelMultiProcessSharedProvider.MultiProcessShared multiProcessShared;

    /* loaded from: classes3.dex */
    public interface OkOpaqueCallback {
        Map<String, String> onCallToWSPayloadOpaque(Map<String, String> map);

        Map<String, String> onCallToWsRequestOpaque(String str, Map<String, List<String>> map);
    }

    private WsChannelSettings(Context context) {
        this.multiProcessShared = WsChannelMultiProcessSharedProvider.getMultiprocessShared(context.getApplicationContext());
    }

    public static WsChannelSettings inst(Context context) {
        if (mInstance == null) {
            synchronized (WsChannelSettings.class) {
                if (mInstance == null) {
                    mInstance = new WsChannelSettings(context);
                }
            }
        }
        return mInstance;
    }

    public boolean isEnableOfflineDetect() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_ENABLE_OFFLINE_DETECT, false);
    }

    public void setEnableOfflineDetect(boolean z) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_ENABLE_OFFLINE_DETECT, z).commit();
    }

    public static void setOkOpaqueCallback(OkOpaqueCallback okOpaqueCallback) {
        sOkOpaqueCallback = okOpaqueCallback;
    }

    public static OkOpaqueCallback getOkOpaqueCallback() {
        return sOkOpaqueCallback;
    }

    public boolean isEnable() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_FRONTIER_ENABLED, true);
    }

    public void setEnable(boolean z) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_FRONTIER_ENABLED, z).commit();
    }

    public String getWsApp() {
        return this.multiProcessShared.getString(WsConstants.KEY_WS_APPS, "");
    }

    public void setWsApp(String str) {
        this.multiProcessShared.edit().putString(WsConstants.KEY_WS_APPS, str).commit();
    }

    public boolean isOkChannelEnable() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_OK_IMPL_ENABLE, true);
    }

    public void setOKChannelEnable(boolean z) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_OK_IMPL_ENABLE, z).commit();
    }

    public long getSocketReadLimitSize() {
        return this.multiProcessShared.getLong(WsConstants.KEY_IO_LIMIT, WsConstants.DEFAULT_IO_LIMIT);
    }

    public void setSocketReadLimitSize(long j) {
        if (j <= 0) {
            return;
        }
        this.multiProcessShared.edit().putLong(WsConstants.KEY_IO_LIMIT, j).commit();
    }

    public void setRetrySendMsgDelay(long j) {
        this.multiProcessShared.edit().putLong(WsConstants.KEY_RETRY_SEND_MSG_DELAY, j).commit();
    }

    public long getRetryDelay() {
        return this.multiProcessShared.getLong(WsConstants.KEY_RETRY_SEND_MSG_DELAY, 0L);
    }

    public void setReportAppStateEnable(boolean z) {
        this.multiProcessShared.edit().putBoolean(WsConstants.KEY_ENABLE_REPORT_APP_STATE, z).apply();
    }

    public boolean isReportAppStateEnable() {
        return this.multiProcessShared.getBoolean(WsConstants.KEY_ENABLE_REPORT_APP_STATE, false);
    }

    public void setAutoConnectDisabledChannelIds(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next().intValue());
            }
            this.multiProcessShared.edit().putString(WsConstants.KEY_AUTO_CONNECT_DISABLED, jSONArray.toString()).commit();
            if (Logger.debug()) {
                Logger.d(TAG, "setAutoConnectDisabledChannelIds: " + jSONArray);
            }
        } catch (Exception e) {
            Logger.e(TAG, e.getMessage());
        }
    }

    public ArrayList<Integer> getAutoConnectDisabledChannelIds() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        String string = this.multiProcessShared.getString(WsConstants.KEY_AUTO_CONNECT_DISABLED, "");
        if (TextUtils.isEmpty(string)) {
            return arrayList;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Integer.valueOf(jSONArray.getInt(i)));
            }
            if (Logger.debug()) {
                Logger.d(TAG, "getAutoConnectDisabledChannelIds: " + arrayList);
            }
        } catch (JSONException e) {
            Logger.e(TAG, e.getMessage());
        }
        return arrayList;
    }
}
