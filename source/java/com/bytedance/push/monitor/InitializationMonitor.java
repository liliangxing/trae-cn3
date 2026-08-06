package com.bytedance.push.monitor;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
class InitializationMonitor {
    private static final int CATEGORY_NOT_TIMEOUT = 0;
    private static final int CATEGORY_TIMEOUT_30 = 201;
    private static final int MSG_HANDLE_APPLOG_UPDATE_TIMEOUT = 2;
    private static Handler sHandler;
    private static long sInitTime;
    private static final WeakHandler.IHandler handler = new WeakHandler.IHandler() { // from class: com.bytedance.push.monitor.InitializationMonitor.1
        public void handleMsg(Message message) {
            InitializationMonitor.handleMsg(message);
        }
    };
    private static final AtomicBoolean sHasCallHandleUpdate = new AtomicBoolean(false);

    InitializationMonitor() {
    }

    private static Handler getHandler() {
        if (sHandler == null) {
            sHandler = new WeakHandler(PushMonitor.getLooper(), handler);
        }
        return sHandler;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void monitorInitOnApplication() {
        if (ToolUtils.isMainProcess(AppProvider.getApp())) {
            sInitTime = ToolUtils.currentTimeMillis();
            getHandler().sendEmptyMessageDelayed(2, Configuration.get().initTimeout);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onMonitorTimeout(int i, long j) {
        String str = i != 201 ? "init success" : "not invoke start() method/not invoke start() when 30s passed";
        if (i == 0) {
            Logger.m274i(IPushService.TAG_PUSH_MONITOR, "Push init error:".concat(str));
        } else {
            Logger.m271e(IPushService.TAG_PUSH_MONITOR, "Push init error:".concat(str));
        }
        sendToMonitor(i, j, str);
    }

    private static void sendToMonitor(int i, long j, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("delta", j);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        PushMonitor.monitorEvent(IPushMonitor.EVENT_APPLOG_CALLBACK_TIMEOUT, jSONObject, jSONObject2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void start() {
        if (sHasCallHandleUpdate.compareAndSet(false, true)) {
            if (getHandler().hasMessages(2)) {
                getHandler().removeMessages(2);
            }
            onMonitorTimeout(0, ToolUtils.currentTimeMillis() - sInitTime);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleMsg(Message message) {
        if (message == null) {
            return;
        }
        Runnable runnable = message.what != 2 ? null : new Runnable() { // from class: com.bytedance.push.monitor.InitializationMonitor.2
            @Override // java.lang.Runnable
            public void run() {
                if (PushSupporter.get().getConfiguration().mIsPreInstallVersion && TextUtils.isEmpty(PushSetting.getInstance().getDeviceId())) {
                    return;
                }
                InitializationMonitor.onMonitorTimeout(201, ToolUtils.currentTimeMillis() - InitializationMonitor.sInitTime);
            }
        };
        if (runnable != null) {
            ThreadPlus.submitRunnable(runnable);
        }
    }
}
