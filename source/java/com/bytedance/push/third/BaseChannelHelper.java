package com.bytedance.push.third;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import com.bytedance.common.push.interfaze.RequestResultCallback;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.helper.EnsureExceptionHelper;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.interfaze.ISDKMonitor;
import com.bytedance.push.third.pushchannelsupport.AvalilablePushChannelSupportHelper;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.Singleton;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.setting.PushSetting;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class BaseChannelHelper {
    public static final int FRT_PUSH = 15;
    public static final int LOCAL_PUSH = 2;
    public static final int M_I = 1;
    public static final int SYNC_PUSH = 21;
    private static final String TAG = "BaseChannelHelper";
    public static final int UM_PUSH_MINI = 23;
    private static final int UNREGISTER_ALL_SENDER = -9307;
    public static final int U_M = 6;
    public static final int WAKEUP_PUSH = 20;
    protected static final Set<Integer> mAllowPushSet = new CopyOnWriteArraySet();
    protected Map<Integer, Singleton<IPushChannel>> mPushChannelMap = new HashMap();

    public String getCurBusinessSysAlertTypeForCustomDialog() {
        return "unknown";
    }

    public Pair<String, String> getPushConfig(int i, Configuration configuration) {
        return null;
    }

    public int getTryRegisterChannelId() {
        return -1;
    }

    public boolean isNeedUnzip(int i) {
        return false;
    }

    public boolean isSupportSystemPushPermissionDialog() {
        return false;
    }

    public abstract boolean isSysChannel(int i);

    public boolean needDisableWhenStrictMode(int i) {
        return i == 6 || i == 1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public boolean requestHwNotificationPermission(String str, RequestResultCallback requestResultCallback) {
        return false;
    }

    public boolean requestMiRemoveVoipNotification(Context context) {
        return false;
    }

    public void requestNotificationPermissionByBusinessAlert(String str, View view, boolean z, RequestResultCallback requestResultCallback) {
    }

    public void requestNotificationPermissionByBusinessAlert(String str, RequestResultCallback requestResultCallback) {
    }

    public void setPushTokenListener(IPushService.PushTokenCallback pushTokenCallback, int i) {
    }

    public BaseChannelHelper() {
        initChannels();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initChannels() {
        if (this.mPushChannelMap.size() == 0) {
            this.mPushChannelMap.put(15, new PushChannel(15, "com.bytedance.push.frontier.FrontierPushAdapter", "frontierPush", new AvalilablePushChannelSupportHelper(AppProvider.getApp())));
            this.mPushChannelMap.put(21, new PushChannel(21, "com.bytedance.push.sync.SyncPushAdapter", "sync", new AvalilablePushChannelSupportHelper(AppProvider.getApp())));
        }
    }

    public IPushAdapter getAdapterInstance(int i) {
        IPushChannel channel = getChannel(Integer.valueOf(i));
        if (channel == null) {
            return null;
        }
        return channel.getAdapterInstance();
    }

    public int getChannelId(String str) {
        Logger.m268d("bdpush", "getChannelId is called:" + str);
        if (this.mPushChannelMap == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        for (Integer num : this.mPushChannelMap.keySet()) {
            IPushChannel channel = getChannel(num);
            if (channel != null && str.equals(channel.getChannelClassName())) {
                return num.intValue();
            }
        }
        return -1;
    }

    private IPushChannel getChannel(Integer num) {
        Map<Integer, Singleton<IPushChannel>> map;
        if (num == null || (map = this.mPushChannelMap) == null) {
            getChannelFailedEvent(num, this.mPushChannelMap);
            return null;
        }
        Singleton<IPushChannel> singleton = map.get(num);
        if (singleton != null) {
            return singleton.get(new Object[0]);
        }
        getChannelFailedEvent(num, this.mPushChannelMap);
        return null;
    }

    private void getChannelFailedEvent(Integer num, Map<Integer, Singleton<IPushChannel>> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (num == null) {
                jSONObject.put("channelId", "null");
            } else {
                jSONObject.put("channelId", num);
            }
            if (map == null) {
                jSONObject.put("errMsg", "pushChannelMap is null");
            } else {
                jSONObject.put("errMsg", map.keySet());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((ISDKMonitor) UgBusFramework.getService(ISDKMonitor.class)).monitorEvent("get_channel_failed", jSONObject, null, null);
    }

    public Set<Integer> getChannels() {
        Map<Integer, Singleton<IPushChannel>> map = this.mPushChannelMap;
        if (map == null) {
            return null;
        }
        return map.keySet();
    }

    public boolean isLocalSupportChannel(int i) {
        IPushChannel channel = getChannel(Integer.valueOf(i));
        Logger.m274i(TAG, "[isLocalSupportChannel]channelId:" + i + " iPushChannel:" + channel);
        if (channel == null) {
            Logger.m278w(TAG, "[isLocalSupportChannel]channelId:" + i + " return not support because pushChannel is null");
            return false;
        }
        if (!isSysChannel(i) && PushSupporter.get().getProcessManagerService().needDisableChannelWhenStrictMode().contains(Integer.valueOf(i))) {
            Logger.m278w(TAG, "[isLocalSupportChannel]channelId:" + i + " return not support because needDisableChannelWhenStrictMode");
            return false;
        }
        boolean isSupport = channel.isSupport();
        Logger.m278w(TAG, "[isLocalSupportChannel]channelId:" + i + " pushChannelSupport:" + isSupport);
        return isSupport;
    }

    public JSONArray buildApplogHeader() {
        JSONArray jSONArray = new JSONArray();
        Logger.m274i(TAG, "[buildApplogHeader]");
        try {
            for (Integer num : this.mPushChannelMap.keySet()) {
                boolean isLocalSupportChannel = isLocalSupportChannel(num.intValue());
                Logger.m274i(TAG, "[buildApplogHeader]channelId:" + num + " localSupportChannel:" + isLocalSupportChannel);
                if (isLocalSupportChannel) {
                    jSONArray.put(num);
                }
            }
        } catch (Throwable th) {
            Logger.m272e(TAG, "buildApplogHeader:  ", th);
            StringBuilder sb = new StringBuilder();
            try {
                Iterator<Integer> it = this.mPushChannelMap.keySet().iterator();
                while (it.hasNext()) {
                    sb.append(String.format(" %s ", it.next()));
                }
            } catch (Throwable th2) {
                sb = new StringBuilder("error when convert mPushChannelMap to str:" + th2.getLocalizedMessage());
            }
            EnsureExceptionHelper.ensureNotReachHere(th, String.format("error when buildApplogHeader,mPushChannelMap.keySet() is %s", sb));
        }
        return jSONArray;
    }

    public boolean hasSupportChannel(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !"[]".equals(str)) {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    if (jSONArray.optInt(0) == UNREGISTER_ALL_SENDER) {
                        return true;
                    }
                    String jSONArray2 = buildApplogHeader().toString();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (jSONArray2.contains(jSONArray.optInt(i) + "")) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void handlerApplogConfig(String str, boolean z) {
        JSONArray jSONArray;
        if (z) {
            PushSetting.getInstance().setPushChannelsJsonArray(str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Logger.m267d("support:" + str);
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        if (jSONArray == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.m268d(TAG, "handlerApplogConfig: jsonArray = " + jSONArray);
        }
        mAllowPushSet.clear();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            int optInt = jSONArray.optInt(i);
            if (optInt > 0) {
                mAllowPushSet.add(Integer.valueOf(optInt));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void initAllowPushSet() {
        if (Logger.debug()) {
            Logger.m268d(TAG, "initAllowPushSet: mAllowPushSet = " + mAllowPushSet);
        }
        if (mAllowPushSet.isEmpty()) {
            handlerApplogConfig(PushSetting.getInstance().getPushChannelsJsonArray(), false);
        }
    }

    public static boolean isServerSupportChannel(int i) {
        initAllowPushSet();
        return mAllowPushSet.contains(Integer.valueOf(i));
    }

    public String getSenderNameById(int i) {
        IPushChannel channel = getChannel(Integer.valueOf(i));
        return channel != null ? channel.getSenderName() : "unknown";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean requestNotificationPermissionBySysAlertForOp() {
        Application app = AppProvider.getApp();
        IPushAdapter adapterInstance = PushChannelHelper.inst(app).getAdapterInstance(10);
        if (adapterInstance != 0 && adapterInstance.isPushAvailable(app, 10) && (adapterInstance instanceof BasePushAdapter)) {
            try {
                return ((BasePushAdapter) adapterInstance).requestOpNotificationPermission(10);
            } catch (Throwable th) {
                Logger.m271e("PushChannelHelper", "requestNotificationPermissionBySysAlertForOp error" + Log.getStackTraceString(th));
            }
        }
        Logger.m278w("PushChannelHelper", "requestNotificationPermissionBySysAlertForOp is not support on cur device");
        return false;
    }

    public void resetPushChannels() {
        Map<Integer, Singleton<IPushChannel>> map = this.mPushChannelMap;
        if (map == null) {
            return;
        }
        Iterator<Map.Entry<Integer, Singleton<IPushChannel>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            PushChannel pushChannel = (PushChannel) it.next().getValue();
            pushChannel.resetInstance();
            pushChannel.resetInitStatus();
        }
    }
}
