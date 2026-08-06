package com.bytedance.trae;

import com.bytedance.trae.apm.api.IApm;
import com.bytedance.trae.apm.impl.ApmImpl;
import com.bytedance.trae.apm.impl.LoggerImpl;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.applog.impl.ApplogImpl;
import com.bytedance.trae.applog.init.IAppLogInitiator;
import com.bytedance.trae.applog.task.AppLogInitiator;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.image.ImageInitiator;
import com.bytedance.trae.image.api.IImageInitiator;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.login.service.LoginServiceImpl;
import com.bytedance.trae.platform.ITraeSdkCommonDepend;
import com.bytedance.trae.push.api.IPushService;
import com.bytedance.trae.push.impl.IPushServiceImpl;
import com.bytedance.trae.service.AppHostImpl;
import com.bytedance.trae.service.TraeSdkCommonDependImpl;
import com.bytedance.trae.utils.logger.ILogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.framework.services.ServiceProvider;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ServiceUtils {
    public static void bindService() {
        ServiceManager.get().bind(AppHost.class, new ServiceProvider<AppHost>() { // from class: com.bytedance.trae.ServiceUtils.1
            /* renamed from: get, reason: merged with bridge method [inline-methods] */
            public AppHost m1097get() {
                return new AppHostImpl();
            }
        }).asSingleton();
        ServiceManager.get().bind(ITraeSdkCommonDepend.class, new ServiceProvider<ITraeSdkCommonDepend>() { // from class: com.bytedance.trae.ServiceUtils.2
            /* renamed from: get, reason: merged with bridge method [inline-methods] */
            public ITraeSdkCommonDepend m1098get() {
                return new TraeSdkCommonDependImpl();
            }
        }).asSingleton();
        ServiceManager.get().bind(IAppLogInitiator.class, new ServiceProvider<IAppLogInitiator>() { // from class: com.bytedance.trae.ServiceUtils.3
            /* renamed from: get, reason: merged with bridge method [inline-methods] */
            public IAppLogInitiator m1099get() {
                return new AppLogInitiator();
            }
        }).asSingleton();
        ServiceManager.get().bind(ILoginService.class, new ServiceProvider<ILoginService>() { // from class: com.bytedance.trae.ServiceUtils.4
            /* renamed from: get, reason: merged with bridge method [inline-methods] */
            public ILoginService m1100get() {
                return new LoginServiceImpl();
            }
        }).asSingleton();
        ServiceManager.get().bind(IApplog.class, new ServiceProvider<IApplog>() { // from class: com.bytedance.trae.ServiceUtils.5
            /* renamed from: get, reason: merged with bridge method [inline-methods] */
            public IApplog m1101get() {
                return new ApplogImpl();
            }
        }).asSingleton();
        ServiceManager.get().bind(IImageInitiator.class, new ServiceProvider<IImageInitiator>() { // from class: com.bytedance.trae.ServiceUtils.6
            /* renamed from: get, reason: merged with bridge method [inline-methods] */
            public IImageInitiator m1102get() {
                return new ImageInitiator();
            }
        }).asSingleton();
        ServiceManager.get().bind(IPushService.class, new ServiceProvider<IPushService>() { // from class: com.bytedance.trae.ServiceUtils.7
            /* renamed from: get, reason: merged with bridge method [inline-methods] */
            public IPushService m1103get() {
                return new IPushServiceImpl();
            }
        }).asSingleton();
        ServiceManager.get().bind(IApm.class, new ServiceProvider<IApm>() { // from class: com.bytedance.trae.ServiceUtils.8
            /* renamed from: get, reason: merged with bridge method [inline-methods] */
            public IApm m1104get() {
                return new ApmImpl();
            }
        }).asSingleton();
        ServiceManager.get().bind(ILogger.class, new ServiceProvider<ILogger>() { // from class: com.bytedance.trae.ServiceUtils.9
            /* renamed from: get, reason: merged with bridge method [inline-methods] */
            public ILogger m1105get() {
                return new LoggerImpl();
            }
        }).asSingleton();
    }
}
