package com.bytedance.ies.bullet.lynx.resource.forest;

import android.net.Uri;
import bolts.Task;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.component.DynamicComponentFetcher;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestDynamicComponentProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0004H\u0002R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/forest/ForestDynamicComponentProvider;", "Lcom/lynx/tasm/component/DynamicComponentFetcher;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "downloadEngine", "", "sessionId", "(Ljava/lang/String;Ljava/lang/String;)V", "FOREST_SYNC_LOAD", "TAG", "getDownloadEngine", "()Ljava/lang/String;", "getSessionId", "loadDynamicComponent", "", "url", "handler", "Lcom/lynx/tasm/component/DynamicComponentFetcher$LoadedHandler;", "loadResource", "cbThread", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestDynamicComponentProvider implements DynamicComponentFetcher, ForestInfoHelper {
    private final String FOREST_SYNC_LOAD;
    private final String TAG;
    private final String downloadEngine;
    private final String sessionId;

    public ForestDynamicComponentProvider(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "downloadEngine");
        this.downloadEngine = str;
        this.sessionId = str2;
        this.FOREST_SYNC_LOAD = "forest_sync_load";
        this.TAG = "ForestDynamicComponentProvider";
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(Uri uri) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean delayPreload(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.delayPreload(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(Uri uri) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String forestDownloadEngine(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.forestDownloadEngine(this, schemaModelUnion);
    }

    public final String getDownloadEngine() {
        return this.downloadEngine;
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public ProcessedResponse<TemplateBundle> getTemplateBundleResponse(Response response) {
        return ForestInfoHelper.DefaultImpls.getTemplateBundleResponse(this, response);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean hasGeckoModelInfo(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.hasGeckoModelInfo(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(Uri uri) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String preloadScope(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.preloadScope(this, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.sessionID(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String sessionID(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.sessionID(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(Uri uri) {
        return ForestInfoHelper.DefaultImpls.useForest(this, uri);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(BulletContext bulletContext) {
        return ForestInfoHelper.DefaultImpls.useForest(this, bulletContext);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(IServiceToken iServiceToken) {
        return ForestInfoHelper.DefaultImpls.useForest(this, iServiceToken);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public boolean useForest(SchemaModelUnion schemaModelUnion) {
        return ForestInfoHelper.DefaultImpls.useForest(this, schemaModelUnion);
    }

    public void loadDynamicComponent(String url, DynamicComponentFetcher.LoadedHandler handler) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (handler != null) {
            if (url.length() == 0) {
                return;
            }
            RLLogger.INSTANCE.m24w("ForestDynamicComponentProvider start to load " + url);
            String queryParameter = Uri.parse(url).getQueryParameter(this.FOREST_SYNC_LOAD);
            if (queryParameter == null) {
                queryParameter = ViewVisibleBridge.INVISIBLE;
            }
            loadResource(url, handler, queryParameter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadResource(final String url, final DynamicComponentFetcher.LoadedHandler handler, final String cbThread) {
        r0.loadAsync((r22 & 1) != 0 ? ForestLoader.INSTANCE.getDefault() : null, url, (r22 & 4) != 0 ? null : this.downloadEngine, Scene.LYNX_COMPONENT, this.sessionId, (r22 & 32) != 0 ? null : null, (r22 & 64) != 0 ? false : false, (r22 & 128) != 0 ? null : null, new Function1<Response, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.forest.ForestDynamicComponentProvider$loadResource$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Response) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(final Response response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSucceed()) {
                    final DynamicComponentFetcher.LoadedHandler loadedHandler = handler;
                    final ForestDynamicComponentProvider forestDynamicComponentProvider = this;
                    final String str = url;
                    final String str2 = cbThread;
                    Callable callable = new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.forest.ForestDynamicComponentProvider$loadResource$1$resolveCb$1
                        @Override // java.util.concurrent.Callable
                        public /* bridge */ /* synthetic */ Object call() {
                            call();
                            return Unit.INSTANCE;
                        }

                        @Override // java.util.concurrent.Callable
                        public final void call() {
                            String str3;
                            try {
                                byte[] provideBytes = response.provideBytes();
                                boolean z = false;
                                if (provideBytes != null) {
                                    if (!(provideBytes.length == 0)) {
                                        z = true;
                                    }
                                }
                                if (z) {
                                    loadedHandler.onComponentLoaded(provideBytes, (Throwable) null);
                                    return;
                                }
                                if (forestDynamicComponentProvider.getTemplateBundleResponse(response) != null) {
                                    forestDynamicComponentProvider.loadResource(str, loadedHandler, str2);
                                    HybridLogger hybridLogger = HybridLogger.INSTANCE;
                                    str3 = forestDynamicComponentProvider.TAG;
                                    HybridLogger.i$default(hybridLogger, str3, "reload dynamic resource", null, null, 12, null);
                                    return;
                                }
                                loadedHandler.onComponentLoaded((byte[]) null, new Throwable("Forest stream empty"));
                            } catch (Throwable th) {
                                loadedHandler.onComponentLoaded((byte[]) null, th);
                            }
                        }
                    };
                    if (Intrinsics.areEqual(cbThread, "1")) {
                        callable.call();
                        return;
                    } else {
                        Task.call(callable, Task.BACKGROUND_EXECUTOR);
                        return;
                    }
                }
                handler.onComponentLoaded((byte[]) null, new IllegalStateException(response.getErrorInfo().toString()));
            }
        });
    }
}
