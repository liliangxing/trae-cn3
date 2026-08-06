package com.bytedance.common.support;

import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.impl.PushCommonParamService;
import com.bytedance.common.support.impl.PushConfigurationService;
import com.bytedance.common.support.impl.SecurityService;
import com.bytedance.common.support.service.IPushCommonParamService;
import com.bytedance.common.support.service.IPushConfigurationService;
import com.bytedance.common.support.service.ISecurityService;
import com.bytedance.push.monitor.DefaultCommonPushSdkMonitorServiceImpl;
import com.bytedance.push.monitor.ICommonPushSdkMonitorService;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PushCommonSupport implements IPushCommonSupport {
    private static volatile IPushCommonParamService pushCommonParamService;
    private static IPushCommonSupport pushCommonSupport;
    private static volatile IPushConfigurationService pushConfigurationService;
    private static volatile ISecurityService securityService;
    private volatile ICommonPushSdkMonitorService pushSdkMonitorService;

    public static IPushCommonSupport getInstance() {
        if (pushCommonSupport == null) {
            synchronized (PushCommonSupport.class) {
                if (pushCommonSupport == null) {
                    pushCommonSupport = new PushCommonSupport();
                }
            }
        }
        return pushCommonSupport;
    }

    private PushCommonSupport() {
    }

    @Override // com.bytedance.common.support.IPushCommonSupport
    public IPushConfigurationService getPushConfigurationService() {
        if (pushConfigurationService == null) {
            synchronized (this) {
                if (pushConfigurationService == null) {
                    pushConfigurationService = new PushConfigurationService();
                }
            }
        }
        return pushConfigurationService;
    }

    @Override // com.bytedance.common.support.IPushCommonSupport
    public IPushCommonParamService getPushCommonParamService() {
        if (pushCommonParamService == null) {
            synchronized (this) {
                if (pushCommonParamService == null) {
                    pushCommonParamService = new PushCommonParamService();
                }
            }
        }
        return pushCommonParamService;
    }

    @Override // com.bytedance.common.support.IPushCommonSupport
    public ISecurityService getSecurityService() {
        if (securityService == null) {
            synchronized (this) {
                if (securityService == null) {
                    securityService = new SecurityService();
                }
            }
        }
        return securityService;
    }

    @Override // com.bytedance.common.support.IPushCommonSupport
    public ICommonPushSdkMonitorService getICommonPushSdkMonitorService() {
        if (this.pushSdkMonitorService == null) {
            synchronized (this) {
                if (this.pushSdkMonitorService == null) {
                    try {
                        Object invoke = Class.forName("com.bytedance.android.service.manager.PushServiceManager").getMethod("get", new Class[0]).invoke(null, new Object[0]);
                        Object invoke2 = invoke.getClass().getMethod("getPushExternalService", new Class[0]).invoke(invoke, new Object[0]);
                        this.pushSdkMonitorService = (ICommonPushSdkMonitorService) invoke2.getClass().getMethod("getPushSdkMonitorService", new Class[0]).invoke(invoke2, new Object[0]);
                    } catch (Throwable th) {
                        th.printStackTrace();
                        Logger.e("PushCommonSupport", "error when getPushSdkMonitorService,use default");
                        this.pushSdkMonitorService = new DefaultCommonPushSdkMonitorServiceImpl();
                    }
                }
            }
        }
        return this.pushSdkMonitorService;
    }

    @Override // com.bytedance.common.support.IPushCommonSupport
    public IPushCommonConfiguration getIPushCommonConfiguration() {
        return getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration;
    }
}
