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
import com.bytedance.ies.bullet.lynx.resource.forest.ForestTemplateResourceProvider;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.resourceprovider.LynxResourceCallback;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import com.lynx.tasm.resourceprovider.LynxResourceResponse;
import com.lynx.tasm.resourceprovider.template.LynxTemplateResourceFetcher;
import com.lynx.tasm.resourceprovider.template.TemplateProviderResult;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultTemplateResourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0016J\"\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/DefaultTemplateResourceProvider;", "Lcom/lynx/tasm/resourceprovider/template/LynxTemplateResourceFetcher;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "FOREST_SYNC_LOAD", "", "forestProvider", "Lcom/bytedance/ies/bullet/lynx/resource/forest/ForestTemplateResourceProvider;", "mWeakToken", "Ljava/lang/ref/WeakReference;", "useForest", "", "fetchSSRData", "", "request", "Lcom/lynx/tasm/resourceprovider/LynxResourceRequest;", "callback", "Lcom/lynx/tasm/resourceprovider/LynxResourceCallback;", "", "fetchTemplate", "Lcom/lynx/tasm/resourceprovider/template/TemplateProviderResult;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultTemplateResourceProvider extends LynxTemplateResourceFetcher implements ForestInfoHelper {
    private final String FOREST_SYNC_LOAD;
    private final ForestTemplateResourceProvider forestProvider;
    private WeakReference<IServiceToken> mWeakToken;
    private final IServiceToken token;
    private final boolean useForest;

    public DefaultTemplateResourceProvider(IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(iServiceToken, "token");
        this.token = iServiceToken;
        this.mWeakToken = new WeakReference<>(iServiceToken);
        this.useForest = useForest(iServiceToken);
        this.FOREST_SYNC_LOAD = "forest_sync_load";
        this.forestProvider = new ForestTemplateResourceProvider(forestDownloadEngine(iServiceToken), sessionID(iServiceToken), iServiceToken);
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

    public void fetchTemplate(LynxResourceRequest request, final LynxResourceCallback<TemplateProviderResult> callback) {
        IServiceToken iServiceToken;
        IServiceToken iServiceToken2;
        Map<Class<?>, Object> map = null;
        final LynxResourceRequest.LynxResourceType resourceType = request != null ? request.getResourceType() : null;
        final String queryParameter = Uri.parse(request != null ? request.getUrl() : null).getQueryParameter(this.FOREST_SYNC_LOAD);
        if (queryParameter == null) {
            queryParameter = ViewVisibleBridge.INVISIBLE;
        }
        if (this.useForest) {
            this.forestProvider.fetchTemplate(request, callback);
            return;
        }
        String url = request != null ? request.getUrl() : null;
        if (!(!TextUtils.isEmpty(url))) {
            url = null;
        }
        if (url != null) {
            ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
            WeakReference<IServiceToken> weakReference = this.mWeakToken;
            ResourceLoaderService with$default = ResourceLoader.with$default(resourceLoader, (weakReference == null || (iServiceToken2 = weakReference.get()) == null) ? null : iServiceToken2.getMBid(), null, 2, null);
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            taskConfig.setResTag(getResTag(resourceType));
            TaskContext.Companion companion = TaskContext.INSTANCE;
            WeakReference<IServiceToken> weakReference2 = this.mWeakToken;
            if (weakReference2 != null && (iServiceToken = weakReference2.get()) != null) {
                map = iServiceToken.getAllDependency();
            }
            taskConfig.setTaskContext(companion.from(map));
            Unit unit = Unit.INSTANCE;
            with$default.loadAsync(url, taskConfig, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider$fetchTemplate$2$2
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
                    final LynxResourceCallback<TemplateProviderResult> lynxResourceCallback = callback;
                    Callable callable = new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider$fetchTemplate$2$2$resolveCb$1
                        @Override // java.util.concurrent.Callable
                        public final Task<Unit> call() {
                            try {
                                InputStream provideInputStream = ResourceInfo.this.provideInputStream();
                                if (provideInputStream != null) {
                                    ByteArrayOutputStream byteArrayOutputStream = provideInputStream;
                                    final LynxResourceCallback<TemplateProviderResult> lynxResourceCallback2 = lynxResourceCallback;
                                    try {
                                        InputStream inputStream = byteArrayOutputStream;
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        try {
                                            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                                            ByteStreamsKt.copyTo$default(inputStream, byteArrayOutputStream2, 0, 2, (Object) null);
                                            final byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                            Task<Unit> call = Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider$fetchTemplate$2$2$resolveCb$1$1$1$1
                                                @Override // java.util.concurrent.Callable
                                                public final Unit call() {
                                                    LynxResourceCallback<TemplateProviderResult> lynxResourceCallback3 = lynxResourceCallback2;
                                                    if (lynxResourceCallback3 == null) {
                                                        return null;
                                                    }
                                                    lynxResourceCallback3.onResponse(LynxResourceResponse.onSuccess(TemplateProviderResult.fromBinary(byteArray)));
                                                    return Unit.INSTANCE;
                                                }
                                            }, Task.UI_THREAD_EXECUTOR);
                                            CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                                            CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                                            return call;
                                        } finally {
                                        }
                                    } finally {
                                    }
                                } else {
                                    final LynxResourceCallback<TemplateProviderResult> lynxResourceCallback3 = lynxResourceCallback;
                                    return Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider$fetchTemplate$2$2$resolveCb$1.2
                                        @Override // java.util.concurrent.Callable
                                        public final Unit call() {
                                            LynxResourceCallback<TemplateProviderResult> lynxResourceCallback4 = lynxResourceCallback3;
                                            if (lynxResourceCallback4 == null) {
                                                return null;
                                            }
                                            lynxResourceCallback4.onResponse(LynxResourceResponse.onFailed(new Error("file not found")));
                                            return Unit.INSTANCE;
                                        }
                                    }, Task.UI_THREAD_EXECUTOR);
                                }
                            } catch (Throwable th) {
                                final LynxResourceCallback<TemplateProviderResult> lynxResourceCallback4 = lynxResourceCallback;
                                return Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider$fetchTemplate$2$2$resolveCb$1.3
                                    @Override // java.util.concurrent.Callable
                                    public final Unit call() {
                                        LynxResourceCallback<TemplateProviderResult> lynxResourceCallback5 = lynxResourceCallback4;
                                        if (lynxResourceCallback5 == null) {
                                            return null;
                                        }
                                        lynxResourceCallback5.onResponse(LynxResourceResponse.onFailed(new Error("stream write error, " + th.getMessage())));
                                        return Unit.INSTANCE;
                                    }
                                }, Task.UI_THREAD_EXECUTOR);
                            }
                        }
                    };
                    if (Intrinsics.areEqual(queryParameter, "1") && resourceType == LynxResourceRequest.LynxResourceType.LynxResourceTypeDynamicComponent) {
                        callable.call();
                    } else {
                        Task.call(callable, Task.BACKGROUND_EXECUTOR);
                    }
                }
            }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider$fetchTemplate$2$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "it");
                    LynxResourceCallback<TemplateProviderResult> lynxResourceCallback = callback;
                    if (lynxResourceCallback != null) {
                        StringBuilder sb = new StringBuilder();
                        LynxResourceRequest.LynxResourceType lynxResourceType = resourceType;
                        lynxResourceCallback.onResponse(LynxResourceResponse.onFailed(new Error(sb.append(lynxResourceType != null ? lynxResourceType.name() : null).append(" load error, ").append(th.getMessage()).toString())));
                    }
                }
            });
        }
    }

    public void fetchSSRData(LynxResourceRequest request, final LynxResourceCallback<byte[]> callback) {
        IServiceToken iServiceToken;
        IServiceToken iServiceToken2;
        Map<Class<?>, Object> map = null;
        final LynxResourceRequest.LynxResourceType resourceType = request != null ? request.getResourceType() : null;
        if (this.useForest) {
            this.forestProvider.fetchSSRData(request, callback);
            return;
        }
        String url = request != null ? request.getUrl() : null;
        if (!(!TextUtils.isEmpty(url))) {
            url = null;
        }
        if (url != null) {
            ResourceLoader resourceLoader = ResourceLoader.INSTANCE;
            WeakReference<IServiceToken> weakReference = this.mWeakToken;
            ResourceLoaderService with$default = ResourceLoader.with$default(resourceLoader, (weakReference == null || (iServiceToken2 = weakReference.get()) == null) ? null : iServiceToken2.getMBid(), null, 2, null);
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            taskConfig.setResTag(getResTag(resourceType));
            TaskContext.Companion companion = TaskContext.INSTANCE;
            WeakReference<IServiceToken> weakReference2 = this.mWeakToken;
            if (weakReference2 != null && (iServiceToken = weakReference2.get()) != null) {
                map = iServiceToken.getAllDependency();
            }
            taskConfig.setTaskContext(companion.from(map));
            Unit unit = Unit.INSTANCE;
            with$default.loadAsync(url, taskConfig, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider$fetchSSRData$2$2
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
                    Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider$fetchSSRData$2$2.1
                        @Override // java.util.concurrent.Callable
                        public final Task<Unit> call() {
                            try {
                                InputStream provideInputStream = ResourceInfo.this.provideInputStream();
                                if (provideInputStream != null) {
                                    ByteArrayOutputStream byteArrayOutputStream = provideInputStream;
                                    final LynxResourceCallback<byte[]> lynxResourceCallback2 = lynxResourceCallback;
                                    try {
                                        InputStream inputStream = byteArrayOutputStream;
                                        byteArrayOutputStream = new ByteArrayOutputStream();
                                        try {
                                            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                                            ByteStreamsKt.copyTo$default(inputStream, byteArrayOutputStream2, 0, 2, (Object) null);
                                            final byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                            Task<Unit> call = Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider$fetchSSRData$2$2$1$1$1$1
                                                @Override // java.util.concurrent.Callable
                                                public final Unit call() {
                                                    LynxResourceCallback<byte[]> lynxResourceCallback3 = lynxResourceCallback2;
                                                    if (lynxResourceCallback3 == null) {
                                                        return null;
                                                    }
                                                    lynxResourceCallback3.onResponse(LynxResourceResponse.onSuccess(byteArray));
                                                    return Unit.INSTANCE;
                                                }
                                            }, Task.UI_THREAD_EXECUTOR);
                                            CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                                            CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                                            return call;
                                        } finally {
                                        }
                                    } finally {
                                    }
                                } else {
                                    final LynxResourceCallback<byte[]> lynxResourceCallback3 = lynxResourceCallback;
                                    return Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider.fetchSSRData.2.2.1.2
                                        @Override // java.util.concurrent.Callable
                                        public final Unit call() {
                                            LynxResourceCallback<byte[]> lynxResourceCallback4 = lynxResourceCallback3;
                                            if (lynxResourceCallback4 == null) {
                                                return null;
                                            }
                                            lynxResourceCallback4.onResponse(LynxResourceResponse.onFailed(new Error("file not found")));
                                            return Unit.INSTANCE;
                                        }
                                    }, Task.UI_THREAD_EXECUTOR);
                                }
                            } catch (Throwable th) {
                                final LynxResourceCallback<byte[]> lynxResourceCallback4 = lynxResourceCallback;
                                return Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider.fetchSSRData.2.2.1.3
                                    @Override // java.util.concurrent.Callable
                                    public final Unit call() {
                                        LynxResourceCallback<byte[]> lynxResourceCallback5 = lynxResourceCallback4;
                                        if (lynxResourceCallback5 == null) {
                                            return null;
                                        }
                                        lynxResourceCallback5.onResponse(LynxResourceResponse.onFailed(new Error("stream write error, " + th.getMessage())));
                                        return Unit.INSTANCE;
                                    }
                                }, Task.UI_THREAD_EXECUTOR);
                            }
                        }
                    }, Task.BACKGROUND_EXECUTOR);
                }
            }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateResourceProvider$fetchSSRData$2$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Throwable) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(Throwable th) {
                    Intrinsics.checkNotNullParameter(th, "it");
                    LynxResourceCallback<byte[]> lynxResourceCallback = callback;
                    if (lynxResourceCallback != null) {
                        StringBuilder sb = new StringBuilder();
                        LynxResourceRequest.LynxResourceType lynxResourceType = resourceType;
                        lynxResourceCallback.onResponse(LynxResourceResponse.onFailed(new Error(sb.append(lynxResourceType != null ? lynxResourceType.name() : null).append(" load error, ").append(th.getMessage()).toString())));
                    }
                }
            });
        }
    }
}
