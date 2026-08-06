package com.bytedance.push.monitor;

import android.app.NotificationChannel;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.common.push.BaseJson;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.interfaze.IMonitor;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.monitor.opentracing.ITracingMonitor;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.ug.bus.UgBusFramework;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MonitorImpl extends BaseJson implements IMonitor {
    private final String TAG = "MonitorImpl";
    private volatile ITracingMonitor service;

    private ITracingMonitor getService() {
        if (this.service == null && Configuration.get().mEnableLazy) {
            synchronized (this) {
                if (this.service == null) {
                    this.service = (ITracingMonitor) UgBusFramework.getService(ITracingMonitor.class);
                }
            }
        }
        return this.service;
    }

    public MonitorImpl() {
        if (Configuration.get().mEnableLazy) {
            return;
        }
        PushMonitor.setMonitorImpl(Configuration.get().mMonitor);
        this.service = (ITracingMonitor) UgBusFramework.getService(ITracingMonitor.class);
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void init() {
        InitializationMonitor.monitorInitOnApplication();
        if (Configuration.get().mEnableLazy || getService() == null) {
            return;
        }
        getService().endInit();
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorStart() {
        InitializationMonitor.start();
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorRegisterSender(int i) {
        SenderMonitor.doRegisterPush(i);
        if (getService() != null) {
            getService().startRegisterSender(i);
        }
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorSenderSupport(boolean z, String str) {
        SenderMonitor.monitorRegisterSenderResult(z, str);
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markUpdateSenderSuccess() {
        SenderMonitor.markUpdateSenderSuccess();
        if (getService() != null) {
            getService().endRequestSender(true, 0, null);
        }
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markUpdateSenderFailed(int i, int i2, String str, String str2) {
        SenderMonitor.markUpdateSenderFailed(i, i2, str, str2);
        if (getService() != null) {
            getService().endRequestSender(false, i, str2);
        }
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorRegisterSenderSuccess(int i) {
        SenderMonitor.doRegisterPushSuccess(i);
        if (getService() != null) {
            getService().endRegisterSender(true, i, 0, null);
        }
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorRegisterSenderFailed(int i, int i2, String str, String str2) {
        SenderMonitor.doRegisterPushFailed(i, i2, str, str2);
        if (getService() != null) {
            getService().endRegisterSender(false, i, i2, str + ", " + str2);
        }
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markOuterSwitchUploadSuccess() {
        SenderMonitor.markOuterSwitchUploadSuccess();
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markOuterSwitchUploadFailed(int i, String str) {
        SenderMonitor.markOuterSwitchUploadFailed(i, str);
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markOuterSwitchStatusSuccess() {
        SenderMonitor.markOuterSwitchStatusSuccess();
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void markOuterSwitchStatusFailed(int i, String str) {
        SenderMonitor.markOuterSwitchStatusFailed(i, str);
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorDecryptResult(int i, int i2) {
        SenderMonitor.monitorDecryptResult(i, i2);
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorShowEmpty(int i, String str, int i2, int i3) {
        SenderMonitor.monitorShowEmpty(i, str, i2, i3);
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorHarmonyOs4Compliance(boolean z, int i) {
        SenderMonitor.monitorHarmonyOs4Compliance(z, i);
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorEvent(String str, String str2) {
        SenderMonitor.monitorEvent(str, str2);
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorInitTimeCoast(final long j) {
        if (j <= 0 || !ToolUtils.isMainProcess(Configuration.get().mApplication)) {
            return;
        }
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.monitor.MonitorImpl.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject.put("time_cost", j);
                    jSONObject2.put("os_detail_type", RomVersionParamHelper.isHarmonyOs() ? "harmony" : "android");
                    jSONObject2.put("rom", com.ss.android.message.util.RomVersionParamHelper.getParameter());
                    jSONObject2.put("process", ToolUtils.getCurProcessNameSuffix(Configuration.get().mApplication));
                    jSONObject2.put("opt_init_time_cost", !PushCommonSupport.getInstance().getPushConfigurationService().keepOldInitTimeCost());
                    String harmonyOsVersion = RomVersionParamHelper.getHarmonyOsVersion();
                    if (!TextUtils.isEmpty(harmonyOsVersion)) {
                        jSONObject2.put("extra_rom_version", harmonyOsVersion);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                PushMonitor.monitorEvent(IPushService.EVENT_NAME_PUSH_INIT_EVENT, jSONObject2, jSONObject, null);
            }
        });
    }

    @Override // com.bytedance.push.interfaze.IMonitor
    public void monitorNotificationCreate(final NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.monitor.MonitorImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("channel_id", notificationChannel.getId());
                        jSONObject.put("channel_name", notificationChannel.getName());
                        jSONObject.put("importance", notificationChannel.getImportance());
                        JSONArray jSONArray = new JSONArray();
                        int i = 0;
                        for (StackTraceElement stackTraceElement : stackTrace) {
                            if (i < 5) {
                                i++;
                            } else {
                                JSONObject jSONObject2 = new JSONObject();
                                MonitorImpl.this.add(jSONObject2, "class_name", stackTraceElement.getClassName());
                                MonitorImpl.this.add(jSONObject2, "file_name", stackTraceElement.getFileName());
                                MonitorImpl.this.add(jSONObject2, "method_name", stackTraceElement.getMethodName());
                                MonitorImpl.this.add(jSONObject2, "line_number", stackTraceElement.getLineNumber());
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("stack_trace", jSONArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    PushSupporter.get().getMultiProcessMonitor().monitorEvent(IPushService.EVENT_NAME_CREATE_NOTIFICATION_CHANNEL_EVENT, jSONObject, (JSONObject) null, (JSONObject) null);
                }
            });
        }
    }
}
