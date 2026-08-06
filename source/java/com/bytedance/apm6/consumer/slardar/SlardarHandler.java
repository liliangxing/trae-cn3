package com.bytedance.apm6.consumer.slardar;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfig;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.header.HeaderUtils;
import com.bytedance.apm6.consumer.slardar.persistent.PersistentBuffer;
import com.bytedance.apm6.consumer.slardar.send.LogReportController;
import com.bytedance.apm6.consumer.slardar.send.LogSender;
import com.bytedance.apm6.consumer.slardar.send.NetworkSender;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutManager;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.monitor.MonitorableHandler;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.NetUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.common.utility.NetworkUtils;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SlardarHandler implements MonitorableHandler {
    private static volatile SlardarHandler sInstance = new SlardarHandler();
    private volatile boolean inited = false;
    private SlardarHandlerConfig mSlardarHandlerConfig;
    private PersistentBuffer persistentBuffer;

    public synchronized void setSlardarHandlerConfig(SlardarHandlerConfig slardarHandlerConfig) {
        this.mSlardarHandlerConfig = slardarHandlerConfig;
        if (slardarHandlerConfig != null) {
            LogReportController.getInstance().updateConfig(slardarHandlerConfig);
            LogReporter.getInstance().setLoopInterval(slardarHandlerConfig.getReportInterval());
            LogReporter.getInstance().setOnceReportMaxSizeBytes(slardarHandlerConfig.getOnceReportMaxSizeBytes());
            WeedOutManager.getInstance().setWeedOutConfig(slardarHandlerConfig.getMaxSizeMB(), slardarHandlerConfig.getKeepDays(), slardarHandlerConfig.getMaxSizeMBToday());
            NetworkSender.setCompressType(slardarHandlerConfig.getCompressType());
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "setSlardarHandlerConfig:" + slardarHandlerConfig);
        }
    }

    private SlardarHandler() {
    }

    public static SlardarHandler getInstance() {
        return sInstance;
    }

    @Override // com.bytedance.apm6.monitor.MonitorableHandler
    public void handle(Monitorable monitorable) {
        if (!this.inited) {
            ensureInited();
        }
        JSONObject jsonObject = monitorable.toJsonObject();
        if (Constants.EXCEPTION_TYPE.contains(monitorable.getLogType()) || "tracing".equals(monitorable.getLogType())) {
            addExtension(jsonObject, false);
        } else {
            if (!DowngradeController.getInstance().uploadEnabled(jsonObject, ApmContext.getAid())) {
                if (ApmContext.isDebugMode()) {
                    DoctorDataUtil.onDowngradeEvent(monitorable.getLogType(), jsonObject);
                    Logger.m119d(Constants.TAG, "push failed: event(aid=" + ApmContext.getAid() + " is downgraded: " + jsonObject.toString());
                    return;
                }
                return;
            }
            addExtension(jsonObject, true);
        }
        if (ApmContext.isDebugMode()) {
            DoctorDataUtil.onReceivedEvent(monitorable.getLogType(), jsonObject, true);
        }
        this.persistentBuffer.push(jsonObject);
    }

    public void pause() {
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "pause");
        }
        LogReporter.getInstance().pause();
        LogSender.getInstance().pause();
    }

    public void resume() {
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "resume");
        }
        LogReporter.getInstance().resume();
        LogSender.getInstance().resume();
    }

    private synchronized void ensureInited() {
        if (this.inited) {
            return;
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "Initializing SlardarHandler...");
        }
        if (ApmAlogHelper.getInnerLogger() != null) {
            ApmAlogHelper.getInnerLogger().m78d(Constants.TAG, "ensureInited");
        }
        HeaderManager.getInstance().init();
        DowngradeController.getInstance().init(ApmContext.getContext());
        SlardarHandlerConfigService slardarHandlerConfigService = (SlardarHandlerConfigService) ServiceManager.getService(SlardarHandlerConfigService.class);
        if (slardarHandlerConfigService != null) {
            setSlardarHandlerConfig(slardarHandlerConfigService.getConfig());
        }
        this.persistentBuffer = new PersistentBuffer(HeaderUtils.getUniqueHeaderId(), DiskEnvironmentHelper.getPersistentFile(), DiskEnvironmentHelper.getFlushDirectory());
        LogReporter.getInstance().setPersistentBuffer(this.persistentBuffer);
        WeedOutManager.getInstance().addStrategy(LogReporter.getInstance());
        WeedOutManager.getInstance().addStrategy(LogSender.getInstance());
        WeedOutManager.getInstance().init();
        LogReporter.getInstance().init();
        LogSender.getInstance().init();
        this.inited = true;
    }

    private void addExtension(JSONObject jSONObject, boolean z) {
        int mobileNetworkType;
        try {
            if (!TextUtils.isEmpty(ApmContext.getSessionId())) {
                jSONObject.put("session_id", ApmContext.getSessionId());
            }
            if (jSONObject.isNull("network_type")) {
                NetworkUtils.NetworkType networkTypeFast = NetworkUtils.getNetworkTypeFast(ApmContext.getContext());
                jSONObject.put("network_type", networkTypeFast.getValue());
                if ((networkTypeFast.is2G() || networkTypeFast.is3GOrHigher()) && (mobileNetworkType = NetUtils.getMobileNetworkType(ApmContext.getContext())) != -10000) {
                    jSONObject.put("network_type_code", mobileNetworkType);
                }
            }
            if (jSONObject.isNull("timestamp") || jSONObject.optLong("timestamp") <= 0) {
                jSONObject.put("timestamp", System.currentTimeMillis());
            }
            if (jSONObject.isNull("sid")) {
                jSONObject.put("sid", ApmContext.getStartId());
            }
            jSONObject.put("process_name", ApmContext.getCurrentProcessName());
            if (z) {
                jSONObject.put("seq_no", SeqNumGenerator.getInstance().next());
            }
        } catch (Exception e) {
            Log.e(Constants.TAG, "addExtension", e);
        }
    }
}
