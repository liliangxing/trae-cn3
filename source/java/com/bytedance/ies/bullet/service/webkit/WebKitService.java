package com.bytedance.ies.bullet.service.webkit;

import android.app.Application;
import android.content.Context;
import com.bytedance.ies.bullet.core.BulletEnv;
import com.bytedance.ies.bullet.kit.web.WebKitView;
import com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitDelegate;
import com.bytedance.ies.bullet.kit.web.impl.DefaultWebKitServiceConfig;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.IKitConfig;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import com.bytedance.ies.bullet.service.base.web.IWebKitService;
import com.bytedance.ies.bullet.service.base.web.IWebPreCreateService;
import com.bytedance.ies.bullet.service.base.web.IWebViewDelegate;
import com.bytedance.ies.bullet.service.base.web.IWebXExtensionService;
import com.bytedance.ies.bullet.service.base.web.WebKitServiceConfig;
import com.bytedance.ies.bullet.service.base.web.WebPreCreateServiceConfig;
import com.bytedance.ies.bullet.service.base.web.WebViewDelegateConfig;
import com.bytedance.ies.bullet.web.api.AbsWebKitDelegateProvider;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.bytedance.webx.WebXEnv;
import com.bytedance.webx.core.webview.WebviewManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WebKitService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$2\b\u0010\u0003\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010)\u001a\u00020*2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0017J\b\u0010+\u001a\u00020\u000bH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ies/bullet/service/webkit/WebKitService;", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "Lcom/bytedance/ies/bullet/service/base/web/IWebKitService;", "config", "Lcom/bytedance/ies/bullet/service/base/IKitConfig;", "provider", "Lcom/bytedance/ies/bullet/service/webkit/IWebKitDelegateProvider;", "(Lcom/bytedance/ies/bullet/service/base/IKitConfig;Lcom/bytedance/ies/bullet/service/webkit/IWebKitDelegateProvider;)V", "hasInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isTTWeb", "", "()Z", "setTTWeb", "(Z)V", "kitConfig", "getKitConfig", "()Lcom/bytedance/ies/bullet/service/base/IKitConfig;", "setKitConfig", "(Lcom/bytedance/ies/bullet/service/base/IKitConfig;)V", "beginSection", "", "sectionName", "", "createKitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "createKitViewWithSessionId", "sessionId", "createWebDelegate", "Lcom/bytedance/ies/bullet/service/base/web/IWebViewDelegate;", "Lcom/bytedance/ies/bullet/service/base/web/WebViewDelegateConfig;", "endSection", EventConstants.PARAM_SOURCE_INIT, "application", "Landroid/content/Context;", "Lcom/bytedance/ies/bullet/service/base/web/WebKitServiceConfig;", "initKit", "initWebX", "appContext", "provideDelegate", "Lcom/bytedance/ies/bullet/service/webkit/AbsWebKitDelegate;", "ready", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WebKitService extends BaseBulletService implements IWebKitService {
    private AtomicBoolean hasInitialized;
    private boolean isTTWeb;
    private IKitConfig kitConfig;
    private final IWebKitDelegateProvider provider;

    /* JADX WARN: Multi-variable type inference failed */
    public WebKitService() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public void beginSection(String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public void endSection(String sectionName) {
        Intrinsics.checkNotNullParameter(sectionName, "sectionName");
    }

    public /* synthetic */ WebKitService(IKitConfig iKitConfig, IWebKitDelegateProvider iWebKitDelegateProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : iKitConfig, (i & 2) != 0 ? null : iWebKitDelegateProvider);
    }

    public WebKitService(DefaultWebKitServiceConfig defaultWebKitServiceConfig, IWebKitDelegateProvider iWebKitDelegateProvider) {
        this.provider = iWebKitDelegateProvider;
        this.hasInitialized = new AtomicBoolean(false);
        this.kitConfig = defaultWebKitServiceConfig == null ? new DefaultWebKitServiceConfig() : defaultWebKitServiceConfig;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public IKitConfig getKitConfig() {
        return this.kitConfig;
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public void setKitConfig(IKitConfig iKitConfig) {
        Intrinsics.checkNotNullParameter(iKitConfig, "<set-?>");
        this.kitConfig = iKitConfig;
    }

    /* renamed from: isTTWeb, reason: from getter */
    public final boolean getIsTTWeb() {
        return this.isTTWeb;
    }

    public final void setTTWeb(boolean z) {
        this.isTTWeb = z;
    }

    public final AbsWebKitDelegate provideDelegate(IServiceToken context) {
        AbsWebKitDelegate provideWebKitDelegate;
        Intrinsics.checkNotNullParameter(context, "context");
        IWebKitDelegateProvider iWebKitDelegateProvider = this.provider;
        return (iWebKitDelegateProvider == null || (provideWebKitDelegate = iWebKitDelegateProvider.provideWebKitDelegate(this, context)) == null) ? new DefaultWebKitDelegate(this) : provideWebKitDelegate;
    }

    public final AbsWebKitDelegate provideDelegate(IServiceToken context, String sessionId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        IWebKitDelegateProvider iWebKitDelegateProvider = this.provider;
        if (iWebKitDelegateProvider != null && (iWebKitDelegateProvider instanceof AbsWebKitDelegateProvider)) {
            return ((AbsWebKitDelegateProvider) iWebKitDelegateProvider).provideWebKitDelegate(this, context, sessionId);
        }
        if (iWebKitDelegateProvider != null) {
            return iWebKitDelegateProvider.provideWebKitDelegate(this, context);
        }
        return new DefaultWebKitDelegate(this, sessionId);
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public void initKit(IServiceToken context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Application application = BulletEnv.INSTANCE.getInstance().getApplication();
        if (application != null) {
            initWebX(application, getKitConfig());
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public boolean ready() {
        return this.hasInitialized.get();
    }

    @Override // com.bytedance.ies.bullet.service.base.IKitService
    public IKitViewService createKitView(IServiceToken context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new WebKitView(context, this);
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitService
    public IKitViewService createKitViewWithSessionId(String sessionId, IServiceToken context) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(context, "context");
        return new WebKitView(context, this, sessionId);
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitService
    public void init(Context application, WebKitServiceConfig config) {
        Intrinsics.checkNotNullParameter(application, "application");
        initWebX(application, config != null ? config : getKitConfig());
    }

    @Override // com.bytedance.ies.bullet.service.base.web.IWebKitService
    public IWebViewDelegate createWebDelegate(WebViewDelegateConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new WebViewDelegate(this, config);
    }

    private final void initWebX(Context appContext, IKitConfig config) {
        IWebPreCreateService iWebPreCreateService;
        BulletLogger.INSTANCE.printLog("initWebX: " + appContext + ", " + config, LogLevel.I, "XWebKit");
        if (this.hasInitialized.get()) {
            return;
        }
        this.hasInitialized.set(true);
        WebXEnv.initGlobal(appContext);
        WebXEnv.initInstance("webx_webkit", WebviewManager.class, new WebXEnv.InitBuilder() { // from class: com.bytedance.ies.bullet.service.webkit.WebKitService$initWebX$1
            protected void onInit(WebXEnv.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                IWebXExtensionService iWebXExtensionService = (IWebXExtensionService) WebKitService.this.getService(IWebXExtensionService.class);
                if (iWebXExtensionService != null) {
                    iWebXExtensionService.addExtension(builder);
                }
            }
        });
        IWebXExtensionService iWebXExtensionService = (IWebXExtensionService) getService(IWebXExtensionService.class);
        if (iWebXExtensionService != null) {
            iWebXExtensionService.initExtension();
        }
        if (!(config instanceof WebKitServiceConfig)) {
            config = null;
        }
        Intrinsics.checkNotNull(config, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.web.WebKitServiceConfig");
        WebPreCreateServiceConfig webPreCreateServiceConfig = ((WebKitServiceConfig) config).getWebPreCreateServiceConfig();
        if (webPreCreateServiceConfig == null || (iWebPreCreateService = (IWebPreCreateService) StandardServiceManager.INSTANCE.get(IWebPreCreateService.class)) == null) {
            return;
        }
        iWebPreCreateService.init(appContext, webPreCreateServiceConfig);
    }
}
