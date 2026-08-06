package com.bytedance.push.statistics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.text.TextUtils;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.push.interfaze.IEventSender;
import com.bytedance.push.interfaze.ISDKMonitor;
import com.bytedance.push.log.ILogger;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.settings.StatisticsSettings;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.push.utils.Singleton;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushCommonSetting;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ProcessStatsConfigProvider implements IConfigProvider {
    private static final String F_SP_NAME = "ttpush_statistics_";
    private static final String KEY_BG_DURATION = "bg_duration";
    private static final String KEY_FG_DURATION = "fg_duration";
    private static final String KEY_PROCESS = "process";
    private static final String KEY_SESSION = "session";
    private static final String SP_KEY_PREFIX = "push_stats_";
    private final Context mContext;
    private long mEntryBackgroundTimeStamp;
    private final IEventSender mEventSender;
    private final ILogger mLogger;
    private final Singleton<String> mSession;

    private long keepBiggerThanOneMinute(long j) {
        if (j < 60000) {
            return 60000L;
        }
        return j;
    }

    public ProcessStatsConfigProvider(Context context, ILogger iLogger) {
        this(context, iLogger, null);
    }

    public ProcessStatsConfigProvider(Context context, ILogger iLogger, IEventSender iEventSender) {
        this.mSession = new Singleton<String>() { // from class: com.bytedance.push.statistics.ProcessStatsConfigProvider.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bytedance.push.utils.Singleton
            public String create(Object... objArr) {
                return UUID.randomUUID().toString();
            }
        };
        this.mContext = context;
        this.mLogger = iLogger;
        this.mEventSender = iEventSender;
    }

    @Override // com.bytedance.push.statistics.IConfigProvider
    public long getForegroundInterval() {
        long j;
        if (ToolUtils.isMainProcess(this.mContext)) {
            j = ((StatisticsSettings) SettingsManager.obtain(this.mContext, StatisticsSettings.class)).statsForegroundInterval();
        } else {
            j = this.mContext.getSharedPreferences("push_multi_process_config", 4).getLong(StatisticsSettings.KEY_STATS_FOREGROUND, getDefaultForegroundInterval());
        }
        return keepBiggerThanOneMinute(j);
    }

    @Override // com.bytedance.push.statistics.IConfigProvider
    public long getBackgroundInterval() {
        long j;
        if (ToolUtils.isMainProcess(this.mContext)) {
            j = ((StatisticsSettings) SettingsManager.obtain(this.mContext, StatisticsSettings.class)).statsBackgroundInterval();
        } else {
            j = this.mContext.getSharedPreferences("push_multi_process_config", 4).getLong(StatisticsSettings.KEY_STATS_BACKGROUND, getDefaultBackgroundInterval());
        }
        return keepBiggerThanOneMinute(j);
    }

    @Override // com.bytedance.push.statistics.IConfigProvider
    public void submitAndUpload(final boolean z) {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.statistics.ProcessStatsConfigProvider.2
            @Override // java.lang.Runnable
            public void run() {
                ProcessStatsConfigProvider.this.submitAndUploadSync(z);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.bytedance.push.statistics.IConfigProvider
    public void submitAndUploadSync(boolean z) {
        String str;
        SharedPreferences.Editor editor;
        Iterator<Map.Entry<String, ?>> it;
        String key;
        long optLong;
        String str2;
        String str3 = KEY_FG_DURATION;
        int i = 0;
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(F_SP_NAME + ToolUtils.getCurProcessName(this.mContext), 0);
        ISDKMonitor iSDKMonitor = (ISDKMonitor) UgBusFramework.getService(ISDKMonitor.class);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Map<String, ?> all = sharedPreferences.getAll();
        if (all == null) {
            return;
        }
        String processSuffix = getProcessSuffix();
        Iterator<Map.Entry<String, ?>> it2 = all.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<String, ?> next = it2.next();
            try {
                key = next.getKey();
            } catch (Exception e) {
                e = e;
                str = str3;
                editor = edit;
                it = it2;
            }
            if (key != null && key.startsWith(SP_KEY_PREFIX)) {
                Object value = next.getValue();
                if (value instanceof String) {
                    JSONObject jSONObject = new JSONObject();
                    JSONObject jSONObject2 = new JSONObject((String) value);
                    String optString = jSONObject2.optString(KEY_SESSION);
                    if (!TextUtils.isEmpty(optString) && (z || !TextUtils.equals(optString, this.mSession.get(new Object[i])))) {
                        long optLong2 = jSONObject2.optLong(KEY_BG_DURATION);
                        SharedPreferences.Editor editor2 = edit;
                        try {
                            optLong = jSONObject2.optLong(str3);
                            jSONObject.put(KEY_BG_DURATION, optLong2);
                            jSONObject.put(str3, optLong);
                            it = it2;
                            str2 = str3;
                            try {
                                this.mLogger.mo245d("push_proc_stat", "save to monitor: " + jSONObject2);
                                i = 0;
                                try {
                                    iSDKMonitor.monitorStatusAndDuration("push_alive_stats" + processSuffix, 0, jSONObject, jSONObject2);
                                    editor = editor2;
                                } catch (Exception e2) {
                                    e = e2;
                                    editor = editor2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                editor = editor2;
                                str = str2;
                                i = 0;
                                e.printStackTrace();
                                edit = editor;
                                str3 = str;
                                it2 = it;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            str = str3;
                            it = it2;
                            editor = editor2;
                        }
                        try {
                            editor.remove(key);
                            if (this.mEventSender != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(KEY_PROCESS, ToolUtils.getCurProcessName(this.mContext));
                                jSONObject3.put(KEY_SESSION, optString);
                                jSONObject.put(KEY_BG_DURATION, optLong2);
                                str = str2;
                                try {
                                    jSONObject.put(str, optLong);
                                    this.mEventSender.onEventV3("pushsdk_alive_stats", jSONObject3);
                                } catch (Exception e5) {
                                    e = e5;
                                    e.printStackTrace();
                                    edit = editor;
                                    str3 = str;
                                    it2 = it;
                                }
                            } else {
                                str = str2;
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = str2;
                            e.printStackTrace();
                            edit = editor;
                            str3 = str;
                            it2 = it;
                        }
                    }
                } else {
                    str = str3;
                    editor = edit;
                    it = it2;
                }
                edit = editor;
                str3 = str;
                it2 = it;
            }
            return;
        }
        edit.apply();
    }

    private String getProcessSuffix() {
        String curProcessName = ToolUtils.getCurProcessName(this.mContext);
        return (curProcessName == null || !curProcessName.contains(":")) ? "" : RomVersionParamHelper.SEPARATOR + curProcessName.split(":")[1];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calcBlockDuration(AliveData aliveData, JSONObject jSONObject) {
        try {
            if (TextUtils.isEmpty(getProcessSuffix())) {
                return;
            }
            if (aliveData.isBlock()) {
                ISDKMonitor iSDKMonitor = (ISDKMonitor) UgBusFramework.getService(ISDKMonitor.class);
                String processSuffix = getProcessSuffix();
                JSONObject jSONObject2 = new JSONObject();
                String str = "1";
                jSONObject2.put("foreground", aliveData.isForeground ? "1" : ViewVisibleBridge.INVISIBLE);
                jSONObject2.put("screenOn", aliveData.isScreenOn ? "1" : ViewVisibleBridge.INVISIBLE);
                if (!aliveData.isUsbCharging) {
                    str = ViewVisibleBridge.INVISIBLE;
                }
                jSONObject2.put("usbCharging", str);
                jSONObject2.put("blockTimeStamp", this.mEntryBackgroundTimeStamp + aliveData.delay);
                iSDKMonitor.monitorStatusAndDuration("push_block_stats" + processSuffix, 0, jSONObject2, null);
                this.mEntryBackgroundTimeStamp = 0L;
            } else {
                if (!isAppForeground() && !isScreenOn() && !isUsbCharging()) {
                    this.mEntryBackgroundTimeStamp += aliveData.delay;
                }
                this.mEntryBackgroundTimeStamp = 0L;
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.push.statistics.IConfigProvider
    public void save(final AliveData aliveData, final boolean z, final boolean z2) {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.push.statistics.ProcessStatsConfigProvider.3
            /* JADX WARN: Removed duplicated region for block: B:19:0x0109  */
            /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                JSONObject jSONObject;
                JSONException e;
                SharedPreferences sharedPreferences = ProcessStatsConfigProvider.this.mContext.getSharedPreferences(ProcessStatsConfigProvider.F_SP_NAME + ToolUtils.getCurProcessName(ProcessStatsConfigProvider.this.mContext), 0);
                AliveData aliveData2 = aliveData;
                if (aliveData2 == null) {
                    return;
                }
                aliveData2.session = (String) ProcessStatsConfigProvider.this.mSession.get(new Object[0]);
                String str = ProcessStatsConfigProvider.SP_KEY_PREFIX + aliveData.session;
                JSONObject jSONObject2 = null;
                String string = sharedPreferences.getString(str, null);
                if (string != null) {
                    try {
                        jSONObject2 = new JSONObject(string);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                try {
                } catch (JSONException e3) {
                    jSONObject = jSONObject2;
                    e = e3;
                }
                if (jSONObject2 == null) {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put(ProcessStatsConfigProvider.KEY_SESSION, aliveData.session);
                        jSONObject.put(ProcessStatsConfigProvider.KEY_PROCESS, ToolUtils.getCurProcessName(ProcessStatsConfigProvider.this.mContext));
                        if (aliveData.isBackground) {
                            jSONObject.put(ProcessStatsConfigProvider.KEY_BG_DURATION, aliveData.getAliveTime());
                        } else {
                            jSONObject.put(ProcessStatsConfigProvider.KEY_FG_DURATION, aliveData.getAliveTime());
                        }
                        ProcessStatsConfigProvider.this.calcBlockDuration(aliveData, jSONObject);
                    } catch (JSONException e4) {
                        e = e4;
                        e.printStackTrace();
                        jSONObject2 = jSONObject;
                        ProcessStatsConfigProvider.this.mLogger.mo245d("push_proc_stat", "save: " + jSONObject2);
                        sharedPreferences.edit().putString(str, jSONObject2.toString()).apply();
                        if (z) {
                        }
                    }
                    jSONObject2 = jSONObject;
                    ProcessStatsConfigProvider.this.mLogger.mo245d("push_proc_stat", "save: " + jSONObject2);
                    sharedPreferences.edit().putString(str, jSONObject2.toString()).apply();
                    if (z) {
                        ProcessStatsConfigProvider.this.submitAndUploadSync(z2);
                        return;
                    }
                    return;
                }
                if (aliveData.isBackground) {
                    jSONObject2.put(ProcessStatsConfigProvider.KEY_BG_DURATION, jSONObject2.optLong(ProcessStatsConfigProvider.KEY_BG_DURATION) + aliveData.getAliveTime());
                } else {
                    jSONObject2.put(ProcessStatsConfigProvider.KEY_FG_DURATION, jSONObject2.optLong(ProcessStatsConfigProvider.KEY_FG_DURATION) + aliveData.getAliveTime());
                }
                ProcessStatsConfigProvider.this.calcBlockDuration(aliveData, jSONObject2);
                ProcessStatsConfigProvider.this.mLogger.mo245d("push_proc_stat", "save: " + jSONObject2);
                sharedPreferences.edit().putString(str, jSONObject2.toString()).apply();
                if (z) {
                }
            }
        });
    }

    @Override // com.bytedance.push.statistics.IConfigProvider
    public long getDefaultBackgroundInterval() {
        return keepBiggerThanOneMinute(StatisticsSettings.DEFAULT_STATS_INTERVAL);
    }

    @Override // com.bytedance.push.statistics.IConfigProvider
    public long getDefaultForegroundInterval() {
        return keepBiggerThanOneMinute(StatisticsSettings.DEFAULT_STATS_INTERVAL);
    }

    @Override // com.bytedance.push.statistics.IConfigProvider
    public boolean isAppForeground() {
        return PushCommonSetting.getInstance().isAppForeground();
    }

    @Override // com.bytedance.push.statistics.IConfigProvider
    public boolean isScreenOn() {
        try {
            return ((PowerManager) this.mContext.getSystemService("power")).isInteractive();
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // com.bytedance.push.statistics.IConfigProvider
    public boolean isUsbCharging() {
        try {
            Intent registerReceiver = PushCommonSupport.getInstance().getIPushCommonConfiguration().registerReceiver(this.mContext, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                if (registerReceiver.getIntExtra("plugged", -1) == 2) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // com.bytedance.push.statistics.IConfigProvider
    public boolean isMainProcess() {
        return TextUtils.isEmpty(getProcessSuffix());
    }
}
