package com.bytedance.android.anniex.lite.container;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.anniex.api.AnnieXApi;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.lite.AnnieXLynxProcessCenter;
import com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy;
import com.bytedance.android.anniex.lite.base.IAnnieXLynxPreloadProvider;
import com.bytedance.android.anniex.lite.flow.AnnieXLynxDispatchManagerKt;
import com.bytedance.android.anniex.lite.model.AnnieXContext;
import com.bytedance.android.anniex.model.AnnieXLynxModel;
import com.bytedance.android.anniex.monitor.MonitorManager;
import com.bytedance.android.anniex.p026ui.AnnieXLynxView;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.lynx.service.BaseLynxGlobalConfigService;
import com.bytedance.ies.bullet.kit.lynx.service.ILynxGlobalConfigService;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxEngineProxy.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J:\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00172\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010$\u001a\u00020\u0011H\u0016J\b\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)H\u0016J\u001e\u0010*\u001a\u00020\u00112\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020 \u0018\u00010\u001fH\u0002J\u0010\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0017H\u0016J\u001c\u0010+\u001a\u00020\u00112\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020 0\u001fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/bytedance/android/anniex/lite/container/AnnieXLynxEngineProxy;", "Lcom/bytedance/android/anniex/lite/base/IAnnieXEngineProxy;", "annieXContext", "Lcom/bytedance/android/anniex/lite/model/AnnieXContext;", "iContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "(Lcom/bytedance/android/anniex/lite/model/AnnieXContext;Lcom/bytedance/android/anniex/base/container/IContainer;)V", "annieXLifeCycle", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/android/anniex/base/lifecycle/AbsAnnieXLifecycle;", "annieXLynxModel", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "annieXLynxView", "Lcom/bytedance/android/anniex/ui/AnnieXLynxView;", "loadContextProvider", "Lcom/bytedance/android/anniex/lite/base/IAnnieXLynxPreloadProvider;", "enterBackground", "", "enterForeground", "getEnginView", "Landroid/view/View;", "getLynxModel", "bid", "", StrategyConstants.SCHEMA, "Landroid/net/Uri;", "sessionId", "initAnnieXContext", "initAnnieXLynxView", "loadSchema", "renderData", "", "", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "lifecycle", "release", "reload", "", "sendEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "sendUpdateRenderData", "updateData", Constants.KEY_DATA, "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXLynxEngineProxy implements IAnnieXEngineProxy {
    private final AnnieXContext annieXContext;
    private WeakReference<AbsAnnieXLifecycle> annieXLifeCycle;
    private AnnieXLynxModel annieXLynxModel;
    private AnnieXLynxView annieXLynxView;
    private final IContainer iContainer;
    private IAnnieXLynxPreloadProvider loadContextProvider;

    public AnnieXLynxEngineProxy(AnnieXContext annieXContext, IContainer iContainer) {
        Intrinsics.checkNotNullParameter(annieXContext, "annieXContext");
        Intrinsics.checkNotNullParameter(iContainer, "iContainer");
        this.annieXContext = annieXContext;
        this.iContainer = iContainer;
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void updateScreenMetrics(int i, int i2) {
        IAnnieXEngineProxy.DefaultImpls.updateScreenMetrics(this, i, i2);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void sendEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
        AnnieXLynxView annieXLynxView = this.annieXLynxView;
        if (annieXLynxView != null) {
            AnnieXLynxView.sendEvent$default(annieXLynxView, event.getName(), event.getParams(), false, 4, null);
        }
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void enterForeground() {
        AnnieXLynxView annieXLynxView = this.annieXLynxView;
        if (annieXLynxView != null) {
            annieXLynxView.onShow();
        }
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void enterBackground() {
        AnnieXLynxView annieXLynxView = this.annieXLynxView;
        if (annieXLynxView != null) {
            annieXLynxView.onHide();
        }
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public View getEnginView() {
        return (View) this.annieXLynxView;
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void updateData(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
        AnnieXLynxView annieXLynxView = this.annieXLynxView;
        if (annieXLynxView != null) {
            annieXLynxView.updateData(data);
        }
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void updateData(String data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
        AnnieXLynxView annieXLynxView = this.annieXLynxView;
        if (annieXLynxView != null) {
            annieXLynxView.updateData(data);
        }
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void release() {
        AbsAnnieXLifecycle absAnnieXLifecycle;
        String str;
        Uri originalUri;
        AnnieXLynxView annieXLynxView = this.annieXLynxView;
        if (annieXLynxView != null) {
            annieXLynxView.destroy();
        }
        IAnnieXLynxPreloadProvider iAnnieXLynxPreloadProvider = this.loadContextProvider;
        if (iAnnieXLynxPreloadProvider != null) {
            iAnnieXLynxPreloadProvider.onRelease();
        }
        WeakReference<AbsAnnieXLifecycle> weakReference = this.annieXLifeCycle;
        if (weakReference != null && (absAnnieXLifecycle = weakReference.get()) != null) {
            AnnieXLynxModel annieXLynxModel = this.annieXLynxModel;
            if (annieXLynxModel == null || (originalUri = annieXLynxModel.getOriginalUri()) == null || (str = originalUri.toString()) == null) {
                str = "";
            }
            Intrinsics.checkNotNullExpressionValue(str, "this.annieXLynxModel?.or…inalUri?.toString() ?: \"\"");
            absAnnieXLifecycle.onKitViewDestroy(str, this.iContainer);
        }
        this.annieXLifeCycle = null;
    }

    private final void initAnnieXContext() {
        Uri parse = Uri.parse(this.annieXContext.getOriginSchema());
        this.loadContextProvider = AnnieXLynxDispatchManagerKt.getLynxLoadContextProvider(this.annieXContext.getSessionId());
        String bid = this.annieXContext.getBid();
        Intrinsics.checkNotNullExpressionValue(parse, StrategyConstants.SCHEMA);
        this.annieXLynxModel = getLynxModel(bid, parse, this.annieXContext.getSessionId());
    }

    static /* synthetic */ AnnieXLynxModel getLynxModel$default(AnnieXLynxEngineProxy annieXLynxEngineProxy, String str, Uri uri, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "default_bid";
        }
        return annieXLynxEngineProxy.getLynxModel(str, uri, str2);
    }

    private final AnnieXLynxModel getLynxModel(String bid, Uri schema, String sessionId) {
        AnnieXLynxModel orCreateAnnieXLynxModel;
        IAnnieXLynxPreloadProvider iAnnieXLynxPreloadProvider = this.loadContextProvider;
        return (iAnnieXLynxPreloadProvider == null || (orCreateAnnieXLynxModel = iAnnieXLynxPreloadProvider.getOrCreateAnnieXLynxModel(bid, schema, sessionId)) == null) ? AnnieXLynxProcessCenter.INSTANCE.getOrCreateLynxModel(bid, schema, sessionId) : orCreateAnnieXLynxModel;
    }

    private final void initAnnieXLynxView() {
        Context context;
        initAnnieXContext();
        AnnieXLynxModel annieXLynxModel = this.annieXLynxModel;
        AnnieXLynxView annieXLynxView = null;
        if (annieXLynxModel != null && (context = this.annieXContext.getContext()) != null) {
            annieXLynxView = AnnieXApi.createLynxViewFromEngine$default(AnnieXApi.INSTANCE, context, annieXLynxModel, null, 4, null);
        }
        this.annieXLynxView = annieXLynxView;
        IAnnieXLynxPreloadProvider iAnnieXLynxPreloadProvider = this.loadContextProvider;
        if (iAnnieXLynxPreloadProvider != null) {
            iAnnieXLynxPreloadProvider.cancelPreload();
        }
        AnnieXLynxView annieXLynxView2 = this.annieXLynxView;
        if (annieXLynxView2 != null) {
            annieXLynxView2.setViewScene$anniex_release(this.annieXContext.getScenes());
        }
        MonitorManager.INSTANCE.onClientComponent(this.annieXContext.getSessionId(), this.annieXContext.getScenes().getTag());
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public void loadSchema(String schema, Map<String, ? extends Object> renderData, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle lifecycle) {
        ContextProviderFactory bridgeContextProviderFactory$anniex_release;
        String str;
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        initAnnieXLynxView();
        BaseLynxGlobalConfigService baseLynxGlobalConfigService = ServiceCenter.Companion.instance().get(this.annieXContext.getBid(), ILynxGlobalConfigService.class);
        BaseLynxGlobalConfigService baseLynxGlobalConfigService2 = baseLynxGlobalConfigService instanceof BaseLynxGlobalConfigService ? baseLynxGlobalConfigService : null;
        if (!IConditionCallKt.getEnableLitePageBidOpt()) {
            baseLynxGlobalConfigService2 = null;
        }
        if (this.annieXLynxModel == null && lifecycle != null) {
            lifecycle.onContainerError(null, 100, "create AnnieX model error");
        }
        if (this.annieXLynxView == null && lifecycle != null) {
            lifecycle.onContainerError(null, 200, "create AnnieXWebkit error");
        }
        if (lifecycle != null) {
            AnnieXLynxModel annieXLynxModel = this.annieXLynxModel;
            if (annieXLynxModel == null || (str = annieXLynxModel.getUrl()) == null) {
                str = "";
            }
            lifecycle.onKitViewCreate(str, this.iContainer);
        }
        AnnieXLynxView annieXLynxView = this.annieXLynxView;
        boolean z = false;
        if (annieXLynxView != null && annieXLynxView.getIsFromEngine()) {
            z = true;
        }
        if (z) {
            AnnieXLynxModel annieXLynxModel2 = this.annieXLynxModel;
            if (annieXLynxModel2 != null) {
                AnnieXLynxView annieXLynxView2 = this.annieXLynxView;
                if (annieXLynxView2 != null) {
                    annieXLynxView2.flushAllStickyEvents(lifecycle != null ? new AnnieXLynxLifeCycleWrapper(this.annieXContext, lifecycle, this.iContainer) : null, contextProviderFactory, annieXLynxModel2);
                }
                sendUpdateRenderData(renderData);
            }
        } else {
            AnnieXLynxModel annieXLynxModel3 = this.annieXLynxModel;
            if (annieXLynxModel3 != null) {
                TemplateData globalProps = annieXLynxModel3.getGlobalProps();
                if (renderData != null) {
                    for (Map.Entry<String, ? extends Object> entry : renderData.entrySet()) {
                        if (globalProps != null) {
                            globalProps.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (globalProps != null) {
                    globalProps.markConcurrent();
                }
                TemplateBundle templateBundleByUrl = baseLynxGlobalConfigService2 != null ? baseLynxGlobalConfigService2.getTemplateBundleByUrl(schema) : null;
                if (templateBundleByUrl != null && contextProviderFactory != null) {
                    contextProviderFactory.registerHolder(TemplateBundle.class, templateBundleByUrl);
                }
                AnnieXLynxView annieXLynxView3 = this.annieXLynxView;
                if (annieXLynxView3 != null) {
                    annieXLynxView3.load(annieXLynxModel3, contextProviderFactory, lifecycle != null ? new AnnieXLynxLifeCycleWrapper(this.annieXContext, lifecycle, this.iContainer) : null);
                }
            }
        }
        this.annieXLifeCycle = new WeakReference<>(lifecycle);
        AnnieXLynxView annieXLynxView4 = this.annieXLynxView;
        if (annieXLynxView4 == null || (bridgeContextProviderFactory$anniex_release = annieXLynxView4.getBridgeContextProviderFactory$anniex_release()) == null) {
            return;
        }
        this.iContainer.onEngineReady(bridgeContextProviderFactory$anniex_release);
    }

    @Override // com.bytedance.android.anniex.lite.base.IAnnieXEngineProxy
    public boolean reload() {
        AbsAnnieXLifecycle absAnnieXLifecycle;
        String str;
        Uri originalUri;
        AnnieXLynxView annieXLynxView = this.annieXLynxView;
        if (annieXLynxView != null) {
            if (!((annieXLynxView == null || this.annieXLynxModel == null) ? false : true)) {
                annieXLynxView = null;
            }
            AnnieXLynxView annieXLynxView2 = annieXLynxView;
            if (annieXLynxView2 != null) {
                AnnieXLynxModel annieXLynxModel = this.annieXLynxModel;
                Intrinsics.checkNotNull(annieXLynxModel);
                AnnieXLynxView.reloadTemplate$default(annieXLynxView2, annieXLynxModel, null, null, 6, null);
                WeakReference<AbsAnnieXLifecycle> weakReference = this.annieXLifeCycle;
                if (weakReference != null && (absAnnieXLifecycle = weakReference.get()) != null) {
                    AnnieXLynxModel annieXLynxModel2 = this.annieXLynxModel;
                    if (annieXLynxModel2 == null || (originalUri = annieXLynxModel2.getOriginalUri()) == null || (str = originalUri.toString()) == null) {
                        str = "";
                    }
                    Intrinsics.checkNotNullExpressionValue(str, "this.annieXLynxModel?.or…inalUri?.toString() ?: \"\"");
                    absAnnieXLifecycle.onLoadSuccess(str, this.iContainer);
                }
                return true;
            }
        }
        return false;
    }

    private final void sendUpdateRenderData(Map<String, ? extends Object> renderData) {
        AnnieXLynxView annieXLynxView;
        if (renderData == null || (annieXLynxView = this.annieXLynxView) == null) {
            return;
        }
        AnnieXLynxView.sendEvent$default(annieXLynxView, "annie.updateRenderData", renderData, false, 4, null);
    }
}
