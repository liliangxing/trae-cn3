package com.bytedance.ies.bullet.lynx.resource;

import android.net.Uri;
import bolts.Task;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.kit.resourceloader.loggger.RLLogger;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestDynamicComponentProvider;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.component.DynamicComponentFetcher;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultDynamicComponentFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\r\u001a\u00020\tJ\u001c\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/DefaultDynamicComponentFetcher;", "Lcom/lynx/tasm/component/DynamicComponentFetcher;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "mContextWrapper", "Ljava/lang/ref/WeakReference;", "mForestProvider", "Lcom/bytedance/ies/bullet/lynx/resource/forest/ForestDynamicComponentProvider;", "useForest", "", "getContext", "getForestProvider", "loadDynamicComponent", "", "url", "", "handler", "Lcom/lynx/tasm/component/DynamicComponentFetcher$LoadedHandler;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class DefaultDynamicComponentFetcher implements DynamicComponentFetcher, ForestInfoHelper {
    private static final String KEY_RL_CALLBACK_TYPE = "dynamic_component_rl_callback_type";
    private static final String VALUE_RL_CALLBACK_TYPE_ASYNC = "async";
    private static final String VALUE_RL_CALLBACK_TYPE_DEFAULT = "async";
    private static final String VALUE_RL_CALLBACK_TYPE_SYNC = "sync";
    private final WeakReference<IServiceToken> mContextWrapper;
    private final ForestDynamicComponentProvider mForestProvider;
    private final boolean useForest;

    public DefaultDynamicComponentFetcher(IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(iServiceToken, "context");
        this.useForest = useForest(iServiceToken);
        this.mForestProvider = new ForestDynamicComponentProvider(forestDownloadEngine(iServiceToken), sessionID(iServiceToken));
        this.mContextWrapper = new WeakReference<>(iServiceToken);
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

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public String getResTag(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getResTag(this, lynxResourceType);
    }

    @Override // com.bytedance.ies.bullet.forest.ForestInfoHelper
    public Scene getSceneType(LynxResourceRequest.LynxResourceType lynxResourceType) {
        return ForestInfoHelper.DefaultImpls.getSceneType(this, lynxResourceType);
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

    private final IServiceToken getContext() {
        WeakReference<IServiceToken> weakReference = this.mContextWrapper;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    /* renamed from: getForestProvider, reason: from getter */
    public final ForestDynamicComponentProvider getMForestProvider() {
        return this.mForestProvider;
    }

    public void loadDynamicComponent(String url, final DynamicComponentFetcher.LoadedHandler handler) {
        if (handler == null) {
            return;
        }
        if (url == null) {
            handler.onComponentLoaded((byte[]) null, new Throwable("url is null"));
            return;
        }
        RLLogger.INSTANCE.m24w("DefaultDynamicComponentFetcher start to load " + url);
        if (this.useForest) {
            this.mForestProvider.loadDynamicComponent(url, handler);
            return;
        }
        Uri parse = Uri.parse(url);
        final String queryParameter = parse.getQueryParameter(KEY_RL_CALLBACK_TYPE);
        if (queryParameter == null) {
            queryParameter = "async";
        }
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        TaskContext.Companion companion = TaskContext.INSTANCE;
        IServiceToken context = getContext();
        taskConfig.setTaskContext(companion.from(context != null ? context.getAllDependency() : null));
        taskConfig.setResTag("component");
        try {
            Intrinsics.checkNotNullExpressionValue(parse, "uri");
            String cDN$default = ExtKt.getCDN$default(parse, null, 1, null);
            if (cDN$default != null) {
                taskConfig.setCdnUrl(cDN$default);
            }
            String queryParameter2 = parse.getQueryParameter("channel");
            if (queryParameter2 != null) {
                Intrinsics.checkNotNullExpressionValue(queryParameter2, "it");
                taskConfig.setChannel(queryParameter2);
            }
            String queryParameter3 = parse.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
            if (queryParameter3 != null) {
                Intrinsics.checkNotNullExpressionValue(queryParameter3, "it");
                taskConfig.setBundle(queryParameter3);
            }
            taskConfig.setDynamic(1);
            String queryParameter4 = parse.getQueryParameter("dynamic");
            if (queryParameter4 != null) {
                Intrinsics.checkNotNullExpressionValue(queryParameter4, "it");
                taskConfig.setDynamic(Integer.valueOf(Integer.parseInt(queryParameter4)));
            }
        } catch (Throwable th) {
            BulletLogger.INSTANCE.printReject(th, "DefaultDynamicComponentFetcher parse url error", "XLynxKit");
        }
        ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
        IServiceToken context2 = getContext();
        ResourceLoader.with$default(resourceLoader, context2 != null ? context2.getMBid() : null, null, 2, null).loadAsync(url, taskConfig, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultDynamicComponentFetcher$loadDynamicComponent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ResourceInfo) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(final ResourceInfo resourceInfo) {
                Intrinsics.checkNotNullParameter(resourceInfo, "it");
                final DynamicComponentFetcher.LoadedHandler loadedHandler = handler;
                Callable callable = new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultDynamicComponentFetcher$loadDynamicComponent$1$resolveCb$1
                    @Override // java.util.concurrent.Callable
                    public /* bridge */ /* synthetic */ Object call() {
                        call();
                        return Unit.INSTANCE;
                    }

                    @Override // java.util.concurrent.Callable
                    public final void call() {
                        try {
                            byte[] provideByteArray = ResourceInfo.this.provideByteArray();
                            boolean z = false;
                            if (provideByteArray != null) {
                                if (!(provideByteArray.length == 0)) {
                                    z = true;
                                }
                            }
                            if (z) {
                                loadedHandler.onComponentLoaded(provideByteArray, (Throwable) null);
                            } else {
                                loadedHandler.onComponentLoaded((byte[]) null, new Throwable("ResourceLoader stream empty"));
                            }
                        } catch (Throwable th2) {
                            loadedHandler.onComponentLoaded((byte[]) null, th2);
                        }
                    }
                };
                if (Intrinsics.areEqual(queryParameter, "sync")) {
                    callable.call();
                } else {
                    Task.call(callable, Task.BACKGROUND_EXECUTOR);
                }
            }
        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultDynamicComponentFetcher$loadDynamicComponent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Throwable th2) {
                Intrinsics.checkNotNullParameter(th2, "it");
                handler.onComponentLoaded((byte[]) null, th2);
            }
        });
    }
}
