package com.ss.alive.monitor.support;

import android.app.Application;
import android.content.Context;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorService;

/* loaded from: classes7.dex */
public interface IAliveMonitoringSupport {
    IAssociationStartMonitorEventService getAssociationStartMonitorEventService();

    IAssociationStartMonitorService getAssociationStartMonitorService(Context context);

    void onAttachBaseContext(Application application);
}
