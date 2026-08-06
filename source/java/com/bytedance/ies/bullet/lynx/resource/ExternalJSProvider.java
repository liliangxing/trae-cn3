package com.bytedance.ies.bullet.lynx.resource;

import android.net.Uri;
import android.text.TextUtils;
import bolts.Task;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestExternalJSProvider;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.provider.LynxResourceCallback;
import com.lynx.tasm.provider.LynxResourceProvider;
import com.lynx.tasm.provider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExternalJSProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ$\u0010\u0012\u001a\u00020\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/ExternalJSProvider;", "Lcom/lynx/tasm/provider/LynxResourceProvider;", "", "", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "service", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;)V", "forestProvider", "Lcom/bytedance/ies/bullet/lynx/resource/forest/ForestExternalJSProvider;", "mWeakToken", "Ljava/lang/ref/WeakReference;", "getService", "()Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "useForest", "", "request", "", "Lcom/lynx/tasm/provider/LynxResourceRequest;", "callback", "Lcom/lynx/tasm/provider/LynxResourceCallback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ExternalJSProvider extends LynxResourceProvider<Object, byte[]> implements ForestInfoHelper {
    private final ForestExternalJSProvider forestProvider;
    private WeakReference<IServiceToken> mWeakToken;
    private final BaseBulletService service;
    private final boolean useForest;

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

    public final BaseBulletService getService() {
        return this.service;
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

    public ExternalJSProvider(IServiceToken iServiceToken, BaseBulletService baseBulletService) {
        Intrinsics.checkNotNullParameter(iServiceToken, "token");
        Intrinsics.checkNotNullParameter(baseBulletService, "service");
        this.service = baseBulletService;
        this.mWeakToken = new WeakReference<>(iServiceToken);
        this.useForest = useForest(iServiceToken);
        this.forestProvider = new ForestExternalJSProvider(forestDownloadEngine(iServiceToken), sessionID(iServiceToken));
    }

    public void request(com.lynx.tasm.provider.LynxResourceRequest<Object> request, final LynxResourceCallback<byte[]> callback) {
        IServiceToken iServiceToken;
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.useForest) {
            this.forestProvider.request(request, callback);
            return;
        }
        String url = request.getUrl();
        if (!(!TextUtils.isEmpty(url))) {
            url = null;
        }
        if (url != null) {
            ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.service.getBid(), null, 2, null);
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            taskConfig.setResTag("external_js");
            TaskContext.Companion companion = TaskContext.INSTANCE;
            WeakReference<IServiceToken> weakReference = this.mWeakToken;
            taskConfig.setTaskContext(companion.from((weakReference == null || (iServiceToken = weakReference.get()) == null) ? null : iServiceToken.getAllDependency()));
            try {
                Uri parse = Uri.parse(url);
                Intrinsics.checkNotNullExpressionValue(parse, "uri");
                String cDN$default = ExtKt.getCDN$default(parse, null, 1, null);
                if (cDN$default != null) {
                    taskConfig.setCdnUrl(cDN$default);
                }
                String queryParameter = parse.getQueryParameter("channel");
                if (queryParameter != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "it");
                    taskConfig.setChannel(queryParameter);
                }
                String queryParameter2 = parse.getQueryParameter(SchemaConstants.QUERY_KEY_BUNDLE);
                if (queryParameter2 != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter2, "it");
                    taskConfig.setBundle(queryParameter2);
                }
                String queryParameter3 = parse.getQueryParameter("dynamic");
                if (queryParameter3 != null) {
                    Intrinsics.checkNotNullExpressionValue(queryParameter3, "it");
                    taskConfig.setDynamic(Integer.valueOf(Integer.parseInt(queryParameter3)));
                }
            } catch (Throwable th) {
                BulletLogger.INSTANCE.printReject(th, "ExternalJSProvider parse url error", "XLynxKit");
                LynxResourceResponse failed = LynxResourceResponse.failed(-1, th);
                Intrinsics.checkNotNull(failed, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.ByteArray>");
                callback.onResponse(failed);
            }
            Unit unit = Unit.INSTANCE;
            with$default.loadAsync(url, taskConfig, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.ExternalJSProvider$request$2$2
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
                    final LynxResourceCallback<byte[]> lynxResourceCallback = callback;
                    Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.ExternalJSProvider$request$2$2.1
                        @Override // java.util.concurrent.Callable
                        public /* bridge */ /* synthetic */ Object call() {
                            call();
                            return Unit.INSTANCE;
                        }

                        @Override // java.util.concurrent.Callable
                        public final void call() {
                            byte[] provideByteArray = ResourceInfo.this.provideByteArray();
                            boolean z = false;
                            if (provideByteArray != null) {
                                if (!(provideByteArray.length == 0)) {
                                    z = true;
                                }
                            }
                            if (z) {
                                lynxResourceCallback.onResponse(LynxResourceResponse.success(provideByteArray));
                                BulletLogger.INSTANCE.printLog("get external js resource success", LogLevel.I, "XLynxKit ExternalJSProvider");
                                return;
                            }
                            LynxResourceCallback<byte[]> lynxResourceCallback2 = lynxResourceCallback;
                            LynxResourceResponse failed2 = LynxResourceResponse.failed(-1, new Error("InputStream is null"));
                            Intrinsics.checkNotNull(failed2, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.ByteArray>");
                            lynxResourceCallback2.onResponse(failed2);
                            BulletLogger.INSTANCE.printLog("get external js resource failed: InputStream is null", LogLevel.E, "XLynxKit ExternalJSProvider");
                        }
                    }, Task.BACKGROUND_EXECUTOR);
                }
            }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.ExternalJSProvider$request$2$3
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
                    Intrinsics.checkNotNullParameter(th2, "err");
                    LynxResourceCallback<byte[]> lynxResourceCallback = callback;
                    LynxResourceResponse failed2 = LynxResourceResponse.failed(-1, th2);
                    Intrinsics.checkNotNull(failed2, "null cannot be cast to non-null type com.lynx.tasm.provider.LynxResourceResponse<kotlin.ByteArray>");
                    lynxResourceCallback.onResponse(failed2);
                    BulletLogger.INSTANCE.printLog("get external js resource failed: " + th2.getMessage(), LogLevel.E, "XLynxKit ExternalJSProvider");
                }
            });
        }
    }
}
