package com.bytedance.ies.bullet.lynx.resource.forest;

import android.net.Uri;
import android.text.TextUtils;
import bolts.Task;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.postprocessor.ProcessedResponse;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.forest.ForestInfoHelper;
import com.bytedance.ies.bullet.forest.ForestLoader;
import com.bytedance.ies.bullet.forest.TemplateBundleProcessor;
import com.bytedance.ies.bullet.kit.resourceloader.config.TaskContext;
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
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ForestTemplateResourceProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\"\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\"\u0010\u0016\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0014H\u0016R\u000e\u0010\t\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/resource/forest/ForestTemplateResourceProvider;", "Lcom/lynx/tasm/resourceprovider/template/LynxTemplateResourceFetcher;", "Lcom/bytedance/ies/bullet/forest/ForestInfoHelper;", "downloadEngine", "", "sessionId", "token", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "FOREST_SYNC_LOAD", "getDownloadEngine", "()Ljava/lang/String;", "getSessionId", "getToken", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "fetchSSRData", "", "request", "Lcom/lynx/tasm/resourceprovider/LynxResourceRequest;", "callback", "Lcom/lynx/tasm/resourceprovider/LynxResourceCallback;", "", "fetchTemplate", "Lcom/lynx/tasm/resourceprovider/template/TemplateProviderResult;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForestTemplateResourceProvider extends LynxTemplateResourceFetcher implements ForestInfoHelper {
    private final String FOREST_SYNC_LOAD;
    private final String downloadEngine;
    private final String sessionId;
    private final IServiceToken token;

    public /* synthetic */ ForestTemplateResourceProvider(String str, String str2, IServiceToken iServiceToken, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : iServiceToken);
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

    public final IServiceToken getToken() {
        return this.token;
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

    public ForestTemplateResourceProvider(String str, String str2, IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(str, "downloadEngine");
        this.downloadEngine = str;
        this.sessionId = str2;
        this.token = iServiceToken;
        this.FOREST_SYNC_LOAD = "forest_sync_load";
    }

    public void fetchTemplate(LynxResourceRequest request, final LynxResourceCallback<TemplateProviderResult> callback) {
        final LynxResourceRequest.LynxResourceType resourceType = request != null ? request.getResourceType() : null;
        final String queryParameter = Uri.parse(request != null ? request.getUrl() : null).getQueryParameter(this.FOREST_SYNC_LOAD);
        if (queryParameter == null) {
            queryParameter = ViewVisibleBridge.INVISIBLE;
        }
        String url = request != null ? request.getUrl() : null;
        String str = TextUtils.isEmpty(url) ^ true ? url : null;
        if (str != null) {
            ForestLoader forestLoader = ForestLoader.INSTANCE;
            String str2 = this.downloadEngine;
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            taskConfig.setResTag(getResTag(resourceType));
            IServiceToken iServiceToken = this.token;
            if (iServiceToken != null) {
                taskConfig.setTaskContext(TaskContext.INSTANCE.from(iServiceToken.getAllDependency()));
            }
            forestLoader.loadAsyncWithProcessor((r24 & 1) != 0 ? forestLoader.getDefault() : null, str, (r24 & 4) != 0 ? null : str2, getSceneType(resourceType), this.sessionId, (r24 & 32) != 0 ? null : taskConfig, (r24 & 64) != 0 ? false : false, new TemplateBundleProcessor(null, false, 3, null), (r24 & 256) != 0 ? null : null, new Function1<ProcessedResponse<TemplateBundle>, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.forest.ForestTemplateResourceProvider$fetchTemplate$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((ProcessedResponse<TemplateBundle>) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(final ProcessedResponse<TemplateBundle> processedResponse) {
                    Intrinsics.checkNotNullParameter(processedResponse, "response");
                    if (processedResponse.isSucceed()) {
                        final ForestTemplateResourceProvider forestTemplateResourceProvider = this;
                        final LynxResourceCallback<TemplateProviderResult> lynxResourceCallback = callback;
                        final LynxResourceRequest.LynxResourceType lynxResourceType = resourceType;
                        Callable callable = new Callable() { // from class: com.bytedance.ies.bullet.lynx.resource.forest.ForestTemplateResourceProvider$fetchTemplate$2$2$resolveCb$1
                            /* JADX WARN: Removed duplicated region for block: B:12:0x0092 A[ADDED_TO_REGION] */
                            /* JADX WARN: Removed duplicated region for block: B:15:0x009d  */
                            @Override // java.util.concurrent.Callable
                            /* renamed from: call-xLWZpok, reason: not valid java name and merged with bridge method [inline-methods] */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Result<? extends Unit> call() {
                                Object obj;
                                LynxResourceCallback<TemplateProviderResult> lynxResourceCallback2;
                                LynxResourceRequest.LynxResourceType lynxResourceType2;
                                Throwable th;
                                TemplateBundle templateBundle;
                                Unit unit;
                                ForestTemplateResourceProvider forestTemplateResourceProvider2 = ForestTemplateResourceProvider.this;
                                ProcessedResponse<TemplateBundle> processedResponse2 = processedResponse;
                                LynxResourceCallback<TemplateProviderResult> lynxResourceCallback3 = lynxResourceCallback;
                                LynxResourceRequest.LynxResourceType lynxResourceType3 = lynxResourceType;
                                try {
                                    Result.Companion companion = Result.Companion;
                                    ProcessedResponse<TemplateBundle> templateBundleResponse = forestTemplateResourceProvider2.getTemplateBundleResponse((Response) processedResponse2);
                                    templateBundle = templateBundleResponse != null ? (TemplateBundle) templateBundleResponse.provideProcessedData() : null;
                                } catch (Throwable th2) {
                                    Result.Companion companion2 = Result.Companion;
                                    obj = Result.constructor-impl(ResultKt.createFailure(th2));
                                }
                                if (templateBundle != null) {
                                    if (lynxResourceCallback3 != null) {
                                        lynxResourceCallback3.onResponse(LynxResourceResponse.onSuccess(TemplateProviderResult.fromTemplateBundle(templateBundle)));
                                        unit = Unit.INSTANCE;
                                        obj = Result.constructor-impl(unit);
                                        lynxResourceCallback2 = lynxResourceCallback;
                                        lynxResourceType2 = lynxResourceType;
                                        th = Result.exceptionOrNull-impl(obj);
                                        if (th != null && lynxResourceCallback2 != null) {
                                            lynxResourceCallback2.onResponse(LynxResourceResponse.onFailed(new Error((lynxResourceType2 != null ? lynxResourceType2.name() : null) + " load error, " + th.getMessage())));
                                        }
                                        return Result.box-impl(obj);
                                    }
                                    unit = null;
                                    obj = Result.constructor-impl(unit);
                                    lynxResourceCallback2 = lynxResourceCallback;
                                    lynxResourceType2 = lynxResourceType;
                                    th = Result.exceptionOrNull-impl(obj);
                                    if (th != null) {
                                        lynxResourceCallback2.onResponse(LynxResourceResponse.onFailed(new Error((lynxResourceType2 != null ? lynxResourceType2.name() : null) + " load error, " + th.getMessage())));
                                    }
                                    return Result.box-impl(obj);
                                }
                                byte[] provideBytes = processedResponse2.provideBytes();
                                if ((provideBytes != null ? provideBytes.length : -1) > 0) {
                                    if (lynxResourceCallback3 != null) {
                                        lynxResourceCallback3.onResponse(LynxResourceResponse.onSuccess(TemplateProviderResult.fromBinary(provideBytes)));
                                        unit = Unit.INSTANCE;
                                        obj = Result.constructor-impl(unit);
                                        lynxResourceCallback2 = lynxResourceCallback;
                                        lynxResourceType2 = lynxResourceType;
                                        th = Result.exceptionOrNull-impl(obj);
                                        if (th != null) {
                                        }
                                        return Result.box-impl(obj);
                                    }
                                    unit = null;
                                    obj = Result.constructor-impl(unit);
                                    lynxResourceCallback2 = lynxResourceCallback;
                                    lynxResourceType2 = lynxResourceType;
                                    th = Result.exceptionOrNull-impl(obj);
                                    if (th != null) {
                                    }
                                    return Result.box-impl(obj);
                                }
                                if (lynxResourceCallback3 != null) {
                                    lynxResourceCallback3.onResponse(LynxResourceResponse.onFailed(new Error((lynxResourceType3 != null ? lynxResourceType3.name() : null) + " load error, bytes is empty")));
                                    unit = Unit.INSTANCE;
                                    obj = Result.constructor-impl(unit);
                                    lynxResourceCallback2 = lynxResourceCallback;
                                    lynxResourceType2 = lynxResourceType;
                                    th = Result.exceptionOrNull-impl(obj);
                                    if (th != null) {
                                    }
                                    return Result.box-impl(obj);
                                }
                                unit = null;
                                obj = Result.constructor-impl(unit);
                                lynxResourceCallback2 = lynxResourceCallback;
                                lynxResourceType2 = lynxResourceType;
                                th = Result.exceptionOrNull-impl(obj);
                                if (th != null) {
                                }
                                return Result.box-impl(obj);
                            }
                        };
                        if (resourceType == LynxResourceRequest.LynxResourceType.LynxResourceTypeDynamicComponent) {
                            if (Intrinsics.areEqual(queryParameter, "1")) {
                                callable.call();
                                return;
                            } else {
                                Task.call(callable, Task.BACKGROUND_EXECUTOR);
                                return;
                            }
                        }
                        callable.call();
                        return;
                    }
                    LynxResourceCallback<TemplateProviderResult> lynxResourceCallback2 = callback;
                    if (lynxResourceCallback2 != null) {
                        StringBuilder sb = new StringBuilder();
                        LynxResourceRequest.LynxResourceType lynxResourceType2 = resourceType;
                        lynxResourceCallback2.onResponse(LynxResourceResponse.onFailed(new Error(sb.append(lynxResourceType2 != null ? lynxResourceType2.name() : null).append(" load error, ").append(processedResponse.getErrorInfo()).toString())));
                    }
                }
            });
        }
    }

    public void fetchSSRData(LynxResourceRequest request, final LynxResourceCallback<byte[]> callback) {
        final LynxResourceRequest.LynxResourceType resourceType = request != null ? request.getResourceType() : null;
        String url = request != null ? request.getUrl() : null;
        String str = TextUtils.isEmpty(url) ^ true ? url : null;
        if (str != null) {
            ForestLoader forestLoader = ForestLoader.INSTANCE;
            String str2 = this.downloadEngine;
            TaskConfig taskConfig = new TaskConfig(null, 1, null);
            taskConfig.setResTag(getResTag(resourceType));
            IServiceToken iServiceToken = this.token;
            if (iServiceToken != null) {
                taskConfig.setTaskContext(TaskContext.INSTANCE.from(iServiceToken.getAllDependency()));
            }
            forestLoader.loadAsync((r22 & 1) != 0 ? forestLoader.getDefault() : null, str, (r22 & 4) != 0 ? null : str2, getSceneType(resourceType), this.sessionId, (r22 & 32) != 0 ? null : taskConfig, (r22 & 64) != 0 ? false : false, (r22 & 128) != 0 ? null : null, new Function1<Response, Unit>() { // from class: com.bytedance.ies.bullet.lynx.resource.forest.ForestTemplateResourceProvider$fetchSSRData$2$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Response) obj);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Removed duplicated region for block: B:14:0x0075 A[ADDED_TO_REGION] */
                /* JADX WARN: Removed duplicated region for block: B:22:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final void invoke(Response response) {
                    Object obj;
                    Throwable th;
                    byte[] provideBytes;
                    Unit unit;
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (response.isSucceed()) {
                        LynxResourceCallback<byte[]> lynxResourceCallback = callback;
                        LynxResourceRequest.LynxResourceType lynxResourceType = resourceType;
                        try {
                            Result.Companion companion = Result.Companion;
                            provideBytes = response.provideBytes();
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.Companion;
                            obj = Result.constructor-impl(ResultKt.createFailure(th2));
                        }
                        if ((provideBytes != null ? provideBytes.length : -1) > 0) {
                            if (lynxResourceCallback != null) {
                                lynxResourceCallback.onResponse(LynxResourceResponse.onSuccess(provideBytes));
                                unit = Unit.INSTANCE;
                                obj = Result.constructor-impl(unit);
                                LynxResourceCallback<byte[]> lynxResourceCallback2 = callback;
                                LynxResourceRequest.LynxResourceType lynxResourceType2 = resourceType;
                                th = Result.exceptionOrNull-impl(obj);
                                if (th != null || lynxResourceCallback2 == null) {
                                    return;
                                }
                                lynxResourceCallback2.onResponse(LynxResourceResponse.onFailed(new Error((lynxResourceType2 != null ? lynxResourceType2.name() : null) + " load error, " + th.getMessage())));
                                return;
                            }
                            unit = null;
                            obj = Result.constructor-impl(unit);
                            LynxResourceCallback<byte[]> lynxResourceCallback22 = callback;
                            LynxResourceRequest.LynxResourceType lynxResourceType22 = resourceType;
                            th = Result.exceptionOrNull-impl(obj);
                            if (th != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        if (lynxResourceCallback != null) {
                            lynxResourceCallback.onResponse(LynxResourceResponse.onFailed(new Error((lynxResourceType != null ? lynxResourceType.name() : null) + " load error, bytes is empty")));
                            unit = Unit.INSTANCE;
                            obj = Result.constructor-impl(unit);
                            LynxResourceCallback<byte[]> lynxResourceCallback222 = callback;
                            LynxResourceRequest.LynxResourceType lynxResourceType222 = resourceType;
                            th = Result.exceptionOrNull-impl(obj);
                            if (th != null) {
                            }
                        }
                        unit = null;
                        obj = Result.constructor-impl(unit);
                        LynxResourceCallback<byte[]> lynxResourceCallback2222 = callback;
                        LynxResourceRequest.LynxResourceType lynxResourceType2222 = resourceType;
                        th = Result.exceptionOrNull-impl(obj);
                        if (th != null) {
                        }
                    } else {
                        LynxResourceCallback<byte[]> lynxResourceCallback3 = callback;
                        if (lynxResourceCallback3 != null) {
                            StringBuilder sb = new StringBuilder();
                            LynxResourceRequest.LynxResourceType lynxResourceType3 = resourceType;
                            lynxResourceCallback3.onResponse(LynxResourceResponse.onFailed(new Error(sb.append(lynxResourceType3 != null ? lynxResourceType3.name() : null).append(" load error, ").append(response.getErrorInfo()).toString())));
                        }
                    }
                }
            });
        }
    }
}
