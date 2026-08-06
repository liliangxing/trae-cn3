package com.bytedance.ies.bullet.base;

import android.app.Application;
import com.bytedance.ies.bullet.core.common.DebugInfo;
import com.bytedance.ies.bullet.pool.PreRenderConfig;
import com.bytedance.ies.bullet.secure.HybridSecureConfig;
import com.bytedance.ies.bullet.service.base.IALog;
import com.bytedance.ies.bullet.service.base.IMonitorReportService;
import com.bytedance.ies.bullet.service.base.IPageConfig;
import com.bytedance.ies.bullet.service.base.IPageService;
import com.bytedance.ies.bullet.service.base.IPopUpService;
import com.bytedance.ies.bullet.service.base.IPopupConfig;
import com.bytedance.ies.bullet.service.base.IPreRenderConfig;
import com.bytedance.ies.bullet.service.base.IReporter;
import com.bytedance.ies.bullet.service.base.MonitorConfig;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.impl.ServiceMap;
import com.bytedance.ies.bullet.service.base.impl.ServiceProvider;
import com.bytedance.ies.bullet.service.base.lynx.ILynxConfig;
import com.bytedance.ies.bullet.service.base.resourceloader.config.ResourceLoaderConfig;
import com.bytedance.ies.bullet.service.base.settings.BulletSettingsConfig;
import com.bytedance.ies.bullet.service.monitor.MonitorReportService;
import com.bytedance.ies.bullet.service.page.PageService;
import com.bytedance.ies.bullet.service.popup.PopUpService;
import com.bytedance.ies.bullet.service.router.IRouterInterceptor;
import com.bytedance.ies.bullet.service.sdk.GlobalSchemaConfig;
import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InitializeConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J+\u0010F\u001a\u00020G\"\b\b\u0000\u0010H*\u00020I2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HH0K2\u0006\u0010L\u001a\u0002HH¢\u0006\u0002\u0010MJ,\u0010N\u001a\u00020G\"\b\b\u0000\u0010H*\u00020I2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HH0K2\f\u0010O\u001a\b\u0012\u0004\u0012\u0002HH0PJ\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\u001d\u0010S\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010T\u001a\u00020\u00122\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020WHÖ\u0001J\u000e\u0010X\u001a\u00020G2\u0006\u0010Y\u001a\u00020ZJ\u000e\u0010[\u001a\u00020G2\u0006\u0010\\\u001a\u00020\fJ\u000e\u0010]\u001a\u00020G2\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010^\u001a\u00020G2\u0006\u0010_\u001a\u00020`2\b\u0010\\\u001a\u0004\u0018\u00010aH\u0007J\u0012\u0010^\u001a\u00020G2\n\b\u0002\u0010\\\u001a\u0004\u0018\u00010aJ\u000e\u0010b\u001a\u00020G2\u0006\u0010\\\u001a\u00020cJ\u000e\u0010d\u001a\u00020G2\u0006\u0010\\\u001a\u00020eJ\u000e\u0010f\u001a\u00020G2\u0006\u0010\\\u001a\u00020gJ\u000e\u0010h\u001a\u00020G2\u0006\u0010\\\u001a\u00020%J\u000e\u0010i\u001a\u00020G2\u0006\u0010j\u001a\u00020+J\u000e\u0010k\u001a\u00020G2\u0006\u0010\\\u001a\u000201J\u000e\u0010l\u001a\u00020G2\u0006\u0010\\\u001a\u000207J\u000e\u0010m\u001a\u00020G2\u0006\u0010\\\u001a\u00020AJ\t\u0010n\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020=X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006o"}, d2 = {"Lcom/bytedance/ies/bullet/base/InitializeConfig;", "", "application", "Landroid/app/Application;", "bid", "", "(Landroid/app/Application;Ljava/lang/String;)V", "getApplication", "()Landroid/app/Application;", "getBid", "()Ljava/lang/String;", "debugInfo", "Lcom/bytedance/ies/bullet/core/common/DebugInfo;", "getDebugInfo$anniex_release", "()Lcom/bytedance/ies/bullet/core/common/DebugInfo;", "setDebugInfo$anniex_release", "(Lcom/bytedance/ies/bullet/core/common/DebugInfo;)V", "debuggable", "", "getDebuggable$anniex_release", "()Ljava/lang/Boolean;", "setDebuggable$anniex_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "lynxConfig", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxConfig;", "getLynxConfig", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxConfig;", "setLynxConfig", "(Lcom/bytedance/ies/bullet/service/base/lynx/ILynxConfig;)V", "preRenderConfig", "Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;", "getPreRenderConfig$anniex_release", "()Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;", "setPreRenderConfig$anniex_release", "(Lcom/bytedance/ies/bullet/service/base/IPreRenderConfig;)V", "resourceLoaderConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "getResourceLoaderConfig$anniex_release", "()Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;", "setResourceLoaderConfig$anniex_release", "(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;)V", "routerInterceptor", "Lcom/bytedance/ies/bullet/service/router/IRouterInterceptor;", "getRouterInterceptor$anniex_release", "()Lcom/bytedance/ies/bullet/service/router/IRouterInterceptor;", "setRouterInterceptor$anniex_release", "(Lcom/bytedance/ies/bullet/service/router/IRouterInterceptor;)V", "schemaConfig", "Lcom/bytedance/ies/bullet/service/sdk/GlobalSchemaConfig;", "getSchemaConfig$anniex_release", "()Lcom/bytedance/ies/bullet/service/sdk/GlobalSchemaConfig;", "setSchemaConfig$anniex_release", "(Lcom/bytedance/ies/bullet/service/sdk/GlobalSchemaConfig;)V", "secureConfig", "Lcom/bytedance/ies/bullet/secure/HybridSecureConfig;", "getSecureConfig$anniex_release", "()Lcom/bytedance/ies/bullet/secure/HybridSecureConfig;", "setSecureConfig$anniex_release", "(Lcom/bytedance/ies/bullet/secure/HybridSecureConfig;)V", "serviceMap", "Lcom/bytedance/ies/bullet/service/base/impl/ServiceMap;", "getServiceMap$anniex_release", "()Lcom/bytedance/ies/bullet/service/base/impl/ServiceMap;", "settingsConfig", "Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;", "getSettingsConfig$anniex_release", "()Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;", "setSettingsConfig$anniex_release", "(Lcom/bytedance/ies/bullet/service/base/settings/BulletSettingsConfig;)V", "addService", "", "T", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "cls", "Ljava/lang/Class;", "instance", "(Ljava/lang/Class;Lcom/bytedance/ies/bullet/service/base/api/IBulletService;)V", "addServiceProvider", "providerInstance", "Lcom/bytedance/ies/bullet/service/base/impl/ServiceProvider;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "setALog", IFrontierMonitor.KEY_LOG, "Lcom/bytedance/ies/bullet/service/base/IALog;", "setDebugInfo", "config", "setDebuggable", "setMonitorReportConfig", "report", "Lcom/bytedance/ies/bullet/service/base/IReporter;", "Lcom/bytedance/ies/bullet/service/base/MonitorConfig;", "setPageConfig", "Lcom/bytedance/ies/bullet/service/base/IPageConfig;", "setPopupConfig", "Lcom/bytedance/ies/bullet/service/base/IPopupConfig;", "setPreRenderConfig", "Lcom/bytedance/ies/bullet/pool/PreRenderConfig;", "setResourceLoaderConfig", "setRouterInterceptor", "interceptor", "setSchemaConfig", "setSecureConfig", "setSettingsConfig", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class InitializeConfig {
    private final Application application;
    private final String bid;
    private DebugInfo debugInfo;
    private Boolean debuggable;
    private ILynxConfig lynxConfig;
    private IPreRenderConfig preRenderConfig;
    private ResourceLoaderConfig resourceLoaderConfig;
    private IRouterInterceptor routerInterceptor;
    private GlobalSchemaConfig schemaConfig;
    private HybridSecureConfig secureConfig;
    private final ServiceMap serviceMap;
    private BulletSettingsConfig settingsConfig;

    public static /* synthetic */ InitializeConfig copy$default(InitializeConfig initializeConfig, Application application, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            application = initializeConfig.application;
        }
        if ((i & 2) != 0) {
            str = initializeConfig.bid;
        }
        return initializeConfig.copy(application, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBid() {
        return this.bid;
    }

    public final InitializeConfig copy(Application application, String bid) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(bid, "bid");
        return new InitializeConfig(application, bid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InitializeConfig)) {
            return false;
        }
        InitializeConfig initializeConfig = (InitializeConfig) other;
        return Intrinsics.areEqual(this.application, initializeConfig.application) && Intrinsics.areEqual(this.bid, initializeConfig.bid);
    }

    public int hashCode() {
        return (this.application.hashCode() * 31) + this.bid.hashCode();
    }

    public final void setALog(IALog log) {
        Intrinsics.checkNotNullParameter(log, IFrontierMonitor.KEY_LOG);
    }

    public String toString() {
        return "InitializeConfig(application=" + this.application + ", bid=" + this.bid + ')';
    }

    public InitializeConfig(Application application, String str) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(str, "bid");
        this.application = application;
        this.bid = str;
        this.serviceMap = new ServiceMap.Builder().bid(str).build();
    }

    public /* synthetic */ InitializeConfig(Application application, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(application, (i & 2) != 0 ? "default_bid" : str);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final String getBid() {
        return this.bid;
    }

    public final ILynxConfig getLynxConfig() {
        return this.lynxConfig;
    }

    public final void setLynxConfig(ILynxConfig iLynxConfig) {
        this.lynxConfig = iLynxConfig;
    }

    /* renamed from: getDebuggable$anniex_release, reason: from getter */
    public final Boolean getDebuggable() {
        return this.debuggable;
    }

    public final void setDebuggable$anniex_release(Boolean bool) {
        this.debuggable = bool;
    }

    /* renamed from: getDebugInfo$anniex_release, reason: from getter */
    public final DebugInfo getDebugInfo() {
        return this.debugInfo;
    }

    public final void setDebugInfo$anniex_release(DebugInfo debugInfo) {
        this.debugInfo = debugInfo;
    }

    /* renamed from: getRouterInterceptor$anniex_release, reason: from getter */
    public final IRouterInterceptor getRouterInterceptor() {
        return this.routerInterceptor;
    }

    public final void setRouterInterceptor$anniex_release(IRouterInterceptor iRouterInterceptor) {
        this.routerInterceptor = iRouterInterceptor;
    }

    /* renamed from: getPreRenderConfig$anniex_release, reason: from getter */
    public final IPreRenderConfig getPreRenderConfig() {
        return this.preRenderConfig;
    }

    public final void setPreRenderConfig$anniex_release(IPreRenderConfig iPreRenderConfig) {
        this.preRenderConfig = iPreRenderConfig;
    }

    /* renamed from: getResourceLoaderConfig$anniex_release, reason: from getter */
    public final ResourceLoaderConfig getResourceLoaderConfig() {
        return this.resourceLoaderConfig;
    }

    public final void setResourceLoaderConfig$anniex_release(ResourceLoaderConfig resourceLoaderConfig) {
        this.resourceLoaderConfig = resourceLoaderConfig;
    }

    /* renamed from: getSchemaConfig$anniex_release, reason: from getter */
    public final GlobalSchemaConfig getSchemaConfig() {
        return this.schemaConfig;
    }

    public final void setSchemaConfig$anniex_release(GlobalSchemaConfig globalSchemaConfig) {
        this.schemaConfig = globalSchemaConfig;
    }

    /* renamed from: getServiceMap$anniex_release, reason: from getter */
    public final ServiceMap getServiceMap() {
        return this.serviceMap;
    }

    /* renamed from: getSettingsConfig$anniex_release, reason: from getter */
    public final BulletSettingsConfig getSettingsConfig() {
        return this.settingsConfig;
    }

    public final void setSettingsConfig$anniex_release(BulletSettingsConfig bulletSettingsConfig) {
        this.settingsConfig = bulletSettingsConfig;
    }

    /* renamed from: getSecureConfig$anniex_release, reason: from getter */
    public final HybridSecureConfig getSecureConfig() {
        return this.secureConfig;
    }

    public final void setSecureConfig$anniex_release(HybridSecureConfig hybridSecureConfig) {
        this.secureConfig = hybridSecureConfig;
    }

    public final void setDebuggable(boolean debuggable) {
        this.debuggable = Boolean.valueOf(debuggable);
    }

    public final void setDebugInfo(DebugInfo config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.debugInfo = config;
    }

    public final void setRouterInterceptor(IRouterInterceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        this.routerInterceptor = interceptor;
    }

    public final void setPreRenderConfig(PreRenderConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.preRenderConfig = config;
    }

    public final void setResourceLoaderConfig(ResourceLoaderConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.resourceLoaderConfig = config;
    }

    public final <T extends IBulletService> void addService(Class<T> cls, T instance) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        Intrinsics.checkNotNullParameter(instance, "instance");
        ServiceMap serviceMap = this.serviceMap;
        String name = cls.getName();
        Intrinsics.checkNotNullExpressionValue(name, "cls.name");
        serviceMap.put(name, instance);
    }

    public final <T extends IBulletService> void addServiceProvider(Class<T> cls, ServiceProvider<T> providerInstance) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        Intrinsics.checkNotNullParameter(providerInstance, "providerInstance");
        ServiceMap serviceMap = this.serviceMap;
        String name = cls.getName();
        Intrinsics.checkNotNullExpressionValue(name, "cls.name");
        serviceMap.put(name, providerInstance);
    }

    @Deprecated(message = "不推荐使用 report", replaceWith = @ReplaceWith(expression = "setMonitorReportConfig", imports = {}))
    public final void setMonitorReportConfig(IReporter report, MonitorConfig config) {
        Intrinsics.checkNotNullParameter(report, "report");
        if (config == null) {
            config = new MonitorConfig(null, 1, null);
        }
        addService(IMonitorReportService.class, new MonitorReportService(report, config));
    }

    public static /* synthetic */ void setMonitorReportConfig$default(InitializeConfig initializeConfig, MonitorConfig monitorConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            monitorConfig = null;
        }
        initializeConfig.setMonitorReportConfig(monitorConfig);
    }

    public final void setMonitorReportConfig(MonitorConfig config) {
        if (config == null) {
            config = new MonitorConfig(null, 1, null);
        }
        addService(IMonitorReportService.class, new MonitorReportService(config));
    }

    public final void setPageConfig(IPageConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        addService(IPageService.class, new PageService(config));
    }

    public final void setPopupConfig(IPopupConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        addService(IPopUpService.class, new PopUpService(config));
    }

    public final void setSchemaConfig(GlobalSchemaConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.schemaConfig = config;
    }

    public final void setSettingsConfig(BulletSettingsConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.settingsConfig = config;
    }

    public final void setSecureConfig(HybridSecureConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.secureConfig = config;
    }
}
