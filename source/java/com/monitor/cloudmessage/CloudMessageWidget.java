package com.monitor.cloudmessage;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.BaseApmWidget;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.IMonitorLogManager;
import com.bytedance.services.apm.api.IMonitorLogQueryCallback;
import com.bytedance.services.apm.api.WidgetParams;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.monitor.cloudmessage.broadcast_receiver.NetworkBroadcastReceiver;
import com.monitor.cloudmessage.callback.IMonitorLogConsumer;
import com.monitor.cloudmessage.upload.net.CloudMessageUploadService;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CloudMessageWidget extends BaseApmWidget implements IResponseConfigListener, IMonitorLogConsumer {
    private static final String CLOSE_CLOUD_REQUEST = "close_cloud_request";
    private static final long DELAY_MILLS = 2000;
    private Context mContext;
    private NetworkBroadcastReceiver mNetworkBroadcastReceiver;
    private boolean mHasReady = false;
    private List<String> mUploadTypeListInDefaultReportType = Arrays.asList("timer", "count", "disk", "memory", MonitorConstants.CPU, "fps", "traffic", "start", "page_load", "image_monitor", "api_all", "api_error", "common_log", "service_monitor", "performance_monitor", "ui_action");

    public String getTag() {
        return "CloudMessageWidget";
    }

    public boolean isOnlyMainProcess() {
        return true;
    }

    public void init(Context context) {
        super.init(context);
        this.mContext = context;
        CloudMessageManager.init(context);
        ((IConfigManager) ServiceManager.getService(IConfigManager.class)).registerResponseConfigListener(this);
        CloudMessageManager.setMonitorLogConsumerSafely(this);
        ActivityLifeObserver.getInstance().register(this);
        registerConfigService();
    }

    public void start() {
        super.start();
    }

    public void stop() {
        super.stop();
    }

    public void onReady() {
        super.onReady();
        if (this.mHasReady) {
            return;
        }
        this.mHasReady = true;
        if (getServiceSwitch(CLOSE_CLOUD_REQUEST) || !ApmContext.isMainProcess()) {
            return;
        }
        this.mNetworkBroadcastReceiver = new NetworkBroadcastReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        m24xd7f0958c(this.mContext, this.mNetworkBroadcastReceiver, intentFilter);
        AsyncEventManager.getInstance().post(new Runnable() { // from class: com.monitor.cloudmessage.CloudMessageWidget.1
            @Override // java.lang.Runnable
            public void run() {
                CloudMessageManager.getInstance().fetchCommandImmediately();
            }
        });
    }

    public void destroy() {
        super.destroy();
        try {
            NetworkBroadcastReceiver networkBroadcastReceiver = this.mNetworkBroadcastReceiver;
            if (networkBroadcastReceiver != null) {
                m25x82eec3a5(this.mContext, networkBroadcastReceiver);
            }
        } catch (Exception unused) {
        }
    }

    public void notifyParams(WidgetParams widgetParams) {
        if (widgetParams == null || CollectionUtils.isEmpty(widgetParams.getReportDomain())) {
            return;
        }
        try {
            URL url = new URL((String) widgetParams.getReportDomain().get(0));
            CloudMessageUploadService.UPLOAD_URL = String.format("%s://%s/%s", url.getProtocol(), url.getHost(), CloudMessageUploadService.API_PATH);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void onResponse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        if (CloudMessageManager.isFetchDataWithSocket() || (optJSONArray = jSONObject.optJSONArray("cloud_commands")) == null) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            CloudMessageManager.getInstance().handleCloudMessage(optJSONArray.optString(i));
        }
    }

    @Override // com.monitor.cloudmessage.callback.IMonitorLogConsumer
    public String[] parseLogType(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("upload_type");
        int i = 0;
        if (optJSONArray == null) {
            String[] strArr = new String[this.mUploadTypeListInDefaultReportType.size()];
            while (i < this.mUploadTypeListInDefaultReportType.size()) {
                strArr[i] = this.mUploadTypeListInDefaultReportType.get(i);
                i++;
            }
            return strArr;
        }
        String[] strArr2 = new String[optJSONArray.length()];
        while (i < optJSONArray.length()) {
            strArr2[i] = optJSONArray.optString(i);
            i++;
        }
        return strArr2;
    }

    @Override // com.monitor.cloudmessage.callback.IMonitorLogConsumer
    public void handleLogData(long j, long j2, String str, IMonitorLogQueryCallback iMonitorLogQueryCallback) {
        ((IMonitorLogManager) ServiceManager.getService(IMonitorLogManager.class)).getLegacyLog(j * 1000, j2 * 1000, str, iMonitorLogQueryCallback);
    }

    @Override // com.monitor.cloudmessage.callback.IMonitorLogConsumer
    public void notifyLogDataConsumed(String str, String str2) {
        ((IMonitorLogManager) ServiceManager.getService(IMonitorLogManager.class)).deleteLegacyLogByIds(str, str2);
    }

    public void onBackground(Activity activity) {
        super.onBackground(activity);
        if (getServiceSwitch(CLOSE_CLOUD_REQUEST) || !ApmContext.isMainProcess()) {
            return;
        }
        AsyncEventManager.getInstance().postDelay(new Runnable() { // from class: com.monitor.cloudmessage.CloudMessageWidget.2
            @Override // java.lang.Runnable
            public void run() {
                CloudMessageManager.getInstance().fetchCommandImmediately();
            }
        }, DELAY_MILLS);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_monitor_cloudmessage_CloudMessageWidget_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m24xd7f0958c(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_monitor_cloudmessage_CloudMessageWidget_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m25x82eec3a5(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
