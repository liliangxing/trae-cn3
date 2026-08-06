package com.ss.alive.monitor.support;

import android.app.Application;
import android.content.Context;
import com.bytedance.common.support.PushCommonSupport;
import com.ss.alive.monitor.services.impl.AssociationStartMonitorEventServiceImpl;
import com.ss.alive.monitor.services.impl.AssociationStartMonitorServiceImpl;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorEventService;
import com.ss.alive.monitor.services.interfaze.IAssociationStartMonitorService;
import com.ss.android.message.AppProvider;
import com.ss.android.message.util.ToolUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AliveMonitoringSupport implements IAliveMonitoringSupport {
    private static volatile IAssociationStartMonitorEventService iAssociationStartMonitorEventService;
    private static volatile IAssociationStartMonitorService iAssociationStartMonitorService;
    private static volatile IAliveMonitoringSupport mMonitoringSupport;
    private Context mContext;

    public static IAliveMonitoringSupport getSupport() {
        if (mMonitoringSupport == null) {
            synchronized (AliveMonitoringSupport.class) {
                if (mMonitoringSupport == null) {
                    mMonitoringSupport = new AliveMonitoringSupport();
                }
            }
        }
        return mMonitoringSupport;
    }

    private AliveMonitoringSupport() {
    }

    @Override // com.ss.alive.monitor.support.IAliveMonitoringSupport
    @Deprecated
    public void onAttachBaseContext(Application application) {
        if (application == null) {
            return;
        }
        if (ToolUtils.isMainProcess(application) || ToolUtils.isMessageProcess(application) || ToolUtils.isPushServiceProcess(application) || ToolUtils.isSmpProcess(application)) {
            AppProvider.initApp(application);
        }
        if (ToolUtils.isSmpProcess(application)) {
            getAssociationStartMonitorService(application).startMonitor();
        }
    }

    @Override // com.ss.alive.monitor.support.IAliveMonitoringSupport
    public IAssociationStartMonitorService getAssociationStartMonitorService(Context context) {
        this.mContext = context;
        if (iAssociationStartMonitorService == null) {
            synchronized (this) {
                if (iAssociationStartMonitorService == null) {
                    iAssociationStartMonitorService = new AssociationStartMonitorServiceImpl(context);
                }
            }
        }
        return iAssociationStartMonitorService;
    }

    @Override // com.ss.alive.monitor.support.IAliveMonitoringSupport
    public IAssociationStartMonitorEventService getAssociationStartMonitorEventService() {
        if (iAssociationStartMonitorEventService == null) {
            synchronized (this) {
                if (iAssociationStartMonitorEventService == null) {
                    Context context = this.mContext;
                    if (context == null) {
                        context = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication;
                    }
                    iAssociationStartMonitorEventService = new AssociationStartMonitorEventServiceImpl(context);
                }
            }
        }
        return iAssociationStartMonitorEventService;
    }
}
