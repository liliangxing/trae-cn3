package com.bytedance.ies.bullet.lynx.resource;

import android.net.Uri;
import bolts.Task;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoader;
import com.bytedance.ies.bullet.kit.resourceloader.ResourceLoaderService;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
import com.bytedance.ies.bullet.lynx.resource.forest.ForestTemplateProvider;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.provider.AbsTemplateProvider;
import com.lynx.tasm.resourceprovider.LynxResourceRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultTemplateProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/DefaultTemplateProvider;", "Lcom/lynx/tasm/provider/AbsTemplateProvider;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "_token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "forestProvider", "Lcom/bytedance/ies/bullet/lynx/resource/forest/ForestTemplateProvider;", "token", "loadTemplate", "", "url", "", "callback", "Lcom/lynx/tasm/provider/AbsTemplateProvider$Callback;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultTemplateProvider extends AbsTemplateProvider implements ForestInfoHelper {
    private final ForestTemplateProvider forestProvider;
    private final IServiceToken token;

    public DefaultTemplateProvider(IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(iServiceToken, "_token");
        this.token = iServiceToken;
        this.forestProvider = new ForestTemplateProvider(iServiceToken);
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

    public void loadTemplate(String url, final AbsTemplateProvider.Callback callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (useForest(this.token)) {
            this.forestProvider.loadTemplate(url, callback);
            return;
        }
        ResourceLoaderService with$default = ResourceLoader.with$default(ResourceLoader.INSTANCE, this.token.getMBid(), null, 2, null);
        TaskConfig taskConfig = new TaskConfig(null, 1, null);
        taskConfig.setResTag("template");
        taskConfig.setTaskContext(TaskContext.INSTANCE.from(this.token.getAllDependency()));
        Unit unit = Unit.INSTANCE;
        with$default.loadAsync(url, taskConfig, new Function1<ResourceInfo, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateProvider$loadTemplate$2
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
                final AbsTemplateProvider.Callback callback2 = callback;
                Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateProvider$loadTemplate$2.1
                    @Override // java.util.concurrent.Callable
                    public final Task<Unit> call() {
                        try {
                            InputStream provideInputStream = ResourceInfo.this.provideInputStream();
                            if (provideInputStream != null) {
                                ByteArrayOutputStream byteArrayOutputStream = provideInputStream;
                                final AbsTemplateProvider.Callback callback3 = callback2;
                                try {
                                    InputStream inputStream = byteArrayOutputStream;
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                    try {
                                        ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                                        ByteStreamsKt.copyTo$default(inputStream, byteArrayOutputStream2, 0, 2, (Object) null);
                                        final byte[] byteArray = byteArrayOutputStream2.toByteArray();
                                        Task<Unit> call = Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateProvider$loadTemplate$2$1$1$1$1
                                            @Override // java.util.concurrent.Callable
                                            public final Unit call() {
                                                AbsTemplateProvider.Callback callback4 = callback3;
                                                if (callback4 == null) {
                                                    return null;
                                                }
                                                callback4.onSuccess(byteArray);
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
                                final AbsTemplateProvider.Callback callback4 = callback2;
                                return Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateProvider.loadTemplate.2.1.2
                                    @Override // java.util.concurrent.Callable
                                    public final Unit call() {
                                        AbsTemplateProvider.Callback callback5 = callback4;
                                        if (callback5 == null) {
                                            return null;
                                        }
                                        callback5.onFailed("file not found");
                                        return Unit.INSTANCE;
                                    }
                                }, Task.UI_THREAD_EXECUTOR);
                            }
                        } catch (Throwable th) {
                            final AbsTemplateProvider.Callback callback5 = callback2;
                            return Task.call(new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateProvider.loadTemplate.2.1.3
                                @Override // java.util.concurrent.Callable
                                public final Unit call() {
                                    AbsTemplateProvider.Callback callback6 = callback5;
                                    if (callback6 == null) {
                                        return null;
                                    }
                                    callback6.onFailed("stream write error, " + th.getMessage());
                                    return Unit.INSTANCE;
                                }
                            }, Task.UI_THREAD_EXECUTOR);
                        }
                    }
                }, Task.BACKGROUND_EXECUTOR);
            }
        }, new Function1<Throwable, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.DefaultTemplateProvider$loadTemplate$3
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
                AbsTemplateProvider.Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onFailed("template load error, " + th.getMessage());
                }
            }
        });
    }
}
