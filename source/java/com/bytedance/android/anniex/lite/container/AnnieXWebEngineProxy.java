package com.bytedance.android.anniex.lite.container;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.lite.AnnieXProcessCenter;
import com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy;
import com.bytedance.android.anniex.lite.flow.web.AnnieXWebDispatchManagerKt;
import com.bytedance.android.anniex.lite.flow.web.IAnnieXWebPreloadProvider;
import com.bytedance.android.anniex.lite.model.AnnieXContext;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.anniex.web.AnnieXWebKit;
import com.bytedance.android.anniex.web.api.IAnnieXWebLifecycle;
import com.bytedance.android.anniex.web.model.AnnieXWebModel;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.monitor.ContainerStandardMonitorWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXWebEngineProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\"\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\tH\u0002J:\u0010!\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00172\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020$\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010\tH\u0016J\b\u0010'\u001a\u00020\u0011H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020,H\u0016J\u001e\u0010-\u001a\u00020\u00112\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXWebEngineProxy;", "Lcom/bytedance/android/anniex/lite/base/IAnnieXEngineProxy;", "annieXContext", "Lcom/bytedance/android/anniex/lite/model/AnnieXContext;", "iContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "(Lcom/bytedance/android/anniex/lite/model/AnnieXContext;Lcom/bytedance/android/anniex/base/container/IContainer;)V", "annieXLifeCycle", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "annieXWebKit", "Lcom/bytedance/android/anniex/web/AnnieXWebKit;", "annieXWebModel", "Lcom/bytedance/android/anniex/web/model/AnnieXWebModel;", "loadContextProvider", "Lcom/bytedance/android/anniex/lite/flow/web/IAnnieXWebPreloadProvider;", "enterBackground", "", "enterForeground", "getAnnieXWebKit", "context", "Landroid/content/Context;", "bid", "", "getEnginView", "Landroid/view/View;", "getWebModel", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "sessionId", "initAnnieXContext", "initAnnieXWebKit", "lifecycle", "loadSchema", "renderData", "", "", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "release", "reload", "", "sendEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "sendUpdateRenderData", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXWebEngineProxy implements IAnnieXEngineProxy {
    private final AnnieXContext annieXContext;
    private WeakReference<AbsAnnieXLifecycle> annieXLifeCycle;
    private AnnieXWebKit annieXWebKit;
    private AnnieXWebModel annieXWebModel;
    private final IContainer iContainer;
    private IAnnieXWebPreloadProvider loadContextProvider;

    public AnnieXWebEngineProxy(AnnieXContext annieXContext, IContainer iContainer) {
        Intrinsics.checkNotNullParameter(annieXContext, "annieXContext");
        Intrinsics.checkNotNullParameter(iContainer, "iContainer");
        this.annieXContext = annieXContext;
        this.iContainer = iContainer;
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void updateData(String str) {
        IAnnieXEngineProxy.DefaultImpls.updateData(this, str);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void updateData(Map<String, ? extends Object> map) {
        IAnnieXEngineProxy.DefaultImpls.updateData(this, map);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void updateScreenMetrics(int i, int i2) {
        IAnnieXEngineProxy.DefaultImpls.updateScreenMetrics(this, i, i2);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void sendEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        AnnieXWebKit annieXWebKit = this.annieXWebKit;
        if (annieXWebKit != null) {
            annieXWebKit.sendEvent(event.getName(), event.getParams());
        }
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void enterForeground() {
        AnnieXWebKit annieXWebKit = this.annieXWebKit;
        if (annieXWebKit != null) {
            annieXWebKit.onShow();
        }
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void enterBackground() {
        AnnieXWebKit annieXWebKit = this.annieXWebKit;
        if (annieXWebKit != null) {
            annieXWebKit.onHide();
        }
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public View getEnginView() {
        AnnieXWebKit annieXWebKit = this.annieXWebKit;
        return (View) (annieXWebKit != null ? annieXWebKit.getRealView() : null);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void release() {
        AbsAnnieXLifecycle absAnnieXLifecycle;
        String str;
        Uri originalUri;
        AnnieXWebKit annieXWebKit = this.annieXWebKit;
        if (annieXWebKit != null) {
            annieXWebKit.destroy();
        }
        IAnnieXWebPreloadProvider iAnnieXWebPreloadProvider = this.loadContextProvider;
        if (iAnnieXWebPreloadProvider != null) {
            iAnnieXWebPreloadProvider.onRelease();
        }
        WeakReference<AbsAnnieXLifecycle> weakReference = this.annieXLifeCycle;
        if (weakReference == null || (absAnnieXLifecycle = weakReference.get()) == null) {
            return;
        }
        AnnieXWebModel annieXWebModel = this.annieXWebModel;
        if (annieXWebModel == null || (originalUri = annieXWebModel.getOriginalUri()) == null || (str = originalUri.toString()) == null) {
            str = "";
        }
        Intrinsics.checkNotNullExpressionValue(str, "this.annieXWebModel?.originalUri?.toString() ?: \"\"");
        absAnnieXLifecycle.onKitViewDestroy(str, this.iContainer);
    }

    private final void initAnnieXContext() {
        Uri parse = Uri.parse(this.annieXContext.getOriginSchema());
        String bid = this.annieXContext.getBid();
        String sessionId = this.annieXContext.getSessionId();
        Intrinsics.checkNotNullExpressionValue(parse, StrategyConstants.SCHEMA);
        this.annieXWebModel = getWebModel(bid, parse, sessionId);
    }

    static /* synthetic */ AnnieXWebModel getWebModel$default(AnnieXWebEngineProxy annieXWebEngineProxy, String str, Uri uri, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        return annieXWebEngineProxy.getWebModel(str, uri, str2);
    }

    private final AnnieXWebModel getWebModel(String bid, Uri schema, String sessionId) {
        AnnieXWebModel orCreateAnnieXWebModel;
        IAnnieXWebPreloadProvider iAnnieXWebPreloadProvider = this.loadContextProvider;
        return (iAnnieXWebPreloadProvider == null || (orCreateAnnieXWebModel = iAnnieXWebPreloadProvider.getOrCreateAnnieXWebModel(bid, schema, sessionId)) == null) ? AnnieXProcessCenter.INSTANCE.getOrCreateWebModel(bid, schema, sessionId) : orCreateAnnieXWebModel;
    }

    private final void initAnnieXWebKit(AbsAnnieXLifecycle lifecycle) {
        String str;
        this.loadContextProvider = AnnieXWebDispatchManagerKt.getWebLoadContextProvider(this.annieXContext.getSessionId());
        Context context = this.annieXContext.getContext();
        this.annieXWebKit = context != null ? getAnnieXWebKit(context, this.annieXContext.getBid()) : null;
        IAnnieXWebPreloadProvider iAnnieXWebPreloadProvider = this.loadContextProvider;
        if (iAnnieXWebPreloadProvider != null) {
            iAnnieXWebPreloadProvider.cancelPreload();
        }
        AnnieXWebKit annieXWebKit = this.annieXWebKit;
        if (annieXWebKit != null) {
            annieXWebKit.setViewScene$anniex_release(this.annieXContext.getScenes());
        }
        if (lifecycle != null) {
            AnnieXWebModel annieXWebModel = this.annieXWebModel;
            if (annieXWebModel == null || (str = annieXWebModel.getUrl()) == null) {
                str = "";
            }
            lifecycle.onKitViewCreate(str, this.iContainer);
        }
        initAnnieXContext();
        MonitorManager.INSTANCE.onClientComponent(this.annieXContext.getSessionId(), this.annieXContext.getScenes().getTag());
    }

    private final AnnieXWebKit getAnnieXWebKit(Context context, String bid) {
        AnnieXWebKit preloadEngine;
        AnnieXWebModel webViewModel;
        IAnnieXWebPreloadProvider iAnnieXWebPreloadProvider = this.loadContextProvider;
        if (iAnnieXWebPreloadProvider != null && (preloadEngine = iAnnieXWebPreloadProvider.getPreloadEngine()) != null) {
            String sessionId = preloadEngine.getSessionId();
            if (sessionId != null) {
                ContainerStandardMonitorWrapper.INSTANCE.addContext(sessionId, "is_from_engine", "true");
            }
            if (!IConditionCallKt.enableFlowUpdateContext() || (webViewModel = preloadEngine.getWebViewModel()) == null) {
                return preloadEngine;
            }
            webViewModel.getBulletContext().setContext(context);
            return preloadEngine;
        }
        return AnnieXProcessCenter.INSTANCE.getOrCreateEnginView(context, bid);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void loadSchema(String schema, Map<String, ? extends Object> renderData, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle lifecycle) {
        AnnieXWebKit annieXWebKit;
        Context context;
        ContextProviderFactory contextProviderFactory2;
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        initAnnieXWebKit(lifecycle);
        AnnieXWebModel annieXWebModel = this.annieXWebModel;
        if (annieXWebModel != null) {
            if (annieXWebModel != null) {
                Map<String, Object> globalProps = annieXWebModel.getGlobalProps();
                if (renderData != null) {
                    for (Map.Entry<String, ? extends Object> entry : renderData.entrySet()) {
                        if (globalProps != null) {
                            globalProps.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                Context context2 = this.annieXContext.getContext();
                if (context2 != null && (annieXWebKit = this.annieXWebKit) != null) {
                    if (annieXWebKit.getIsFromPreload()) {
                        SSWebView realView = annieXWebKit.getRealView();
                        if (realView != null && (context = realView.getContext()) != null) {
                            Intrinsics.checkNotNullExpressionValue(context, "context");
                            if (context instanceof MutableContextWrapper) {
                                ((MutableContextWrapper) context).setBaseContext(context2);
                            }
                        }
                        if (IConditionCallKt.enableFlowPageCloseFix() && contextProviderFactory != null) {
                            annieXWebKit.getContextProviderFactory().merge(contextProviderFactory);
                        }
                        if (lifecycle != null && (annieXWebKit.getPreloadStickLifeCycle() instanceof IStickWebLifeCycle)) {
                            IAnnieXWebLifecycle preloadStickLifeCycle = annieXWebKit.getPreloadStickLifeCycle();
                            Intrinsics.checkNotNull(preloadStickLifeCycle, "null cannot be cast to non-null type com.bytedance.android.anniex.lite.container.IStickWebLifeCycle");
                            ((IStickWebLifeCycle) preloadStickLifeCycle).flushStickLifeCycle(this.iContainer, lifecycle);
                        }
                        annieXWebKit.flushStatus$anniex_release();
                        sendUpdateRenderData(renderData);
                    } else {
                        AnnieXWebLifeCycleWrapper annieXWebLifeCycleWrapper = lifecycle != null ? new AnnieXWebLifeCycleWrapper(this.annieXContext, lifecycle, this.iContainer) : null;
                        if (contextProviderFactory == null) {
                            contextProviderFactory = new ContextProviderFactory();
                        }
                        annieXWebKit.loadUri(context2, annieXWebLifeCycleWrapper, annieXWebModel, contextProviderFactory);
                    }
                }
            }
            if (this.annieXWebKit == null && lifecycle != null) {
                lifecycle.onContainerError(null, 200, "create AnnieXWebkit error");
            }
            if (this.annieXContext.getContext() == null && lifecycle != null) {
                lifecycle.onContainerError(null, 500, "load uri error context = null");
            }
        } else if (lifecycle != null) {
            lifecycle.onContainerError(null, 100, "create AnnieX model error");
        }
        this.annieXLifeCycle = new WeakReference<>(lifecycle);
        AnnieXWebKit annieXWebKit2 = this.annieXWebKit;
        if (annieXWebKit2 == null || (contextProviderFactory2 = annieXWebKit2.getContextProviderFactory()) == null) {
            return;
        }
        this.iContainer.onEngineReady(contextProviderFactory2);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public boolean reload() {
        AnnieXWebKit annieXWebKit = this.annieXWebKit;
        if (annieXWebKit != null) {
            if (!(annieXWebKit.getCurrentUri() != null)) {
                annieXWebKit = null;
            }
            if (annieXWebKit != null) {
                annieXWebKit.reload();
                return true;
            }
        }
        return false;
    }

    private final void sendUpdateRenderData(Map<String, ? extends Object> renderData) {
        AnnieXWebKit annieXWebKit;
        if (renderData == null || (annieXWebKit = this.annieXWebKit) == null) {
            return;
        }
        annieXWebKit.sendEvent("annie.updateRenderData", renderData);
    }
}
