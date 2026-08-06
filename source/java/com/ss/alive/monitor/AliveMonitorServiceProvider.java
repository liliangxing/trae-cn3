package com.ss.alive.monitor;

import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ServiceProvider;
import com.bytedance.android.service.manager.alive.monitor.AliveMonitorService;
import com.bytedance.android.service.manager.alive.monitor.IMonitorCallback;
import com.ss.alive.monitor.support.AliveMonitoringSupport;
import org.json.JSONObject;

@ServiceProvider
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AliveMonitorServiceProvider implements AliveMonitorService {
    public void monitorAssociationStart(Context context) {
        AliveMonitoringSupport.getSupport().getAssociationStartMonitorService(context).startMonitor();
    }

    public void monitorAssociationStart(Context context, IMonitorCallback iMonitorCallback) {
        AliveMonitoringSupport.getSupport().getAssociationStartMonitorService(context).startMonitor(iMonitorCallback);
    }

    public boolean hasHookActivityManagerSuccess(Context context) {
        return AliveMonitoringSupport.getSupport().getAssociationStartMonitorService(context).hasHookActivityManagerSuccess();
    }

    public boolean hasHookActivityTaskManagerSuccess(Context context) {
        return AliveMonitoringSupport.getSupport().getAssociationStartMonitorService(context).hasHookActivityTaskManagerSuccess();
    }

    public void onUserActive() {
        AliveMonitoringSupport.getSupport().getAssociationStartMonitorEventService().onUserActive();
    }

    public JSONObject getProcessStartInfoObject(Context context) {
        return AliveMonitorManager.inst(context).getActivityThreadHandler().getProcessStartInfoObject();
    }

    public void startDetectProcessLaunchReason(Context context) {
        AliveMonitorManager.inst(context).hookActivityThread();
    }

    public boolean curProcessIsFirstProcess(Context context) {
        return AliveMonitorManager.inst(context).isFirstProcess();
    }
}
