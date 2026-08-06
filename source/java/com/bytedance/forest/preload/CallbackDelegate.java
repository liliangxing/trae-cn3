package com.bytedance.forest.preload;

import android.net.Uri;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.forest.model.ResourceFrom;
import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.forest.utils.LogUtils;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PreLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0011\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0002\u0010\u000bJ\u0011\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0002H\u0002J\u001e\u0010%\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00022\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0002R.\u0010\f\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R0\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u0002`\u00040\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006'"}, d2 = {"Lcom/bytedance/forest/preload/CallbackDelegate;", "Lkotlin/Function1;", "Lcom/bytedance/forest/model/Response;", "", "Lcom/bytedance/forest/preload/ForestRequestCallback;", "url", "", "scene", "Lcom/bytedance/forest/model/Scene;", "onFinished", "Lkotlin/Function0;", "(Ljava/lang/String;Lcom/bytedance/forest/model/Scene;Lkotlin/jvm/functions/Function0;)V", "imageSource", "Ljava/lang/ref/SoftReference;", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "getImageSource", "()Ljava/lang/ref/SoftReference;", "setImageSource", "(Ljava/lang/ref/SoftReference;)V", "listeners", "", "getListeners", "()Ljava/util/List;", "setListeners", "(Ljava/util/List;)V", ApmTrafficStats.TTNET_RESPONSE, "getResponse", "()Lcom/bytedance/forest/model/Response;", "setResponse", "(Lcom/bytedance/forest/model/Response;)V", "getUrl", "()Ljava/lang/String;", "invoke", "result", "onPreloadFinished", "preDecodeBitmap", "onFinish", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class CallbackDelegate implements Function1<Response, Unit> {
    private volatile SoftReference<DataSource<CloseableReference<CloseableImage>>> imageSource;
    private List<Function1<Response, Unit>> listeners;
    private final Function0<Unit> onFinished;
    private Response response;
    private final Scene scene;
    private final String url;

    public CallbackDelegate(String str, Scene scene, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        Intrinsics.checkParameterIsNotNull(function0, "onFinished");
        this.url = str;
        this.scene = scene;
        this.onFinished = function0;
        this.listeners = new ArrayList();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Response) obj);
        return Unit.INSTANCE;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Response getResponse() {
        return this.response;
    }

    public final void setResponse(Response response) {
        this.response = response;
    }

    public final List<Function1<Response, Unit>> getListeners() {
        return this.listeners;
    }

    public final void setListeners(List<Function1<Response, Unit>> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.listeners = list;
    }

    public final SoftReference<DataSource<CloseableReference<CloseableImage>>> getImageSource() {
        return this.imageSource;
    }

    public final void setImageSource(SoftReference<DataSource<CloseableReference<CloseableImage>>> softReference) {
        this.imageSource = softReference;
    }

    public void invoke(final Response result) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(result, "result");
        LogUtils.e$default(LogUtils.INSTANCE, PreLoader.TAG, "preload result:" + result.getIsSucceed(), null, 4, null);
        result.setInMemoryBuffer$forest_release(null);
        if (this.scene == Scene.LYNX_IMAGE) {
            try {
                Result.Companion companion = Result.Companion;
                preDecodeBitmap(result, new Function0<Unit>() { // from class: com.bytedance.forest.preload.CallbackDelegate$invoke$$inlined$runCatching$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m528invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m528invoke() {
                        LogUtils logUtils = LogUtils.INSTANCE;
                        StringBuilder sb = new StringBuilder("image preload finished, image:");
                        Response response = CallbackDelegate.this.getResponse();
                        LogUtils.i$default(logUtils, PreLoader.TAG, sb.append(response != null ? response.getImage() : null).toString(), false, null, null, null, 60, null);
                    }
                });
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                LogUtils.i$default(LogUtils.INSTANCE, PreLoader.TAG, "image preload failed by " + th2, false, null, null, null, 60, null);
            }
        }
        onPreloadFinished(result);
    }

    private final void onPreloadFinished(Response result) {
        this.onFinished.invoke();
        synchronized (this) {
            this.response = result;
            if (!this.listeners.isEmpty()) {
                Iterator<T> it = this.listeners.iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(result);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void preDecodeBitmap(final Response result, final Function0<Unit> onFinish) {
        final Uri parse;
        String filePath;
        if (result.getIsSucceed() && (filePath = result.getFilePath()) != null && LoaderUtils.INSTANCE.isNotNullOrEmpty(filePath)) {
            parse = new Uri.Builder().scheme("file").authority("").path(result.getFilePath()).build();
        } else {
            parse = Uri.parse(result.getRequest().getOriginUrl());
        }
        DataSource dataSource = (DataSource) Fresco.getImagePipeline().getDataSourceSupplier(ImageRequestBuilder.newBuilderWithSource(parse).build(), (Object) null, ImageRequest.RequestLevel.FULL_FETCH).get();
        this.imageSource = new SoftReference<>(dataSource);
        dataSource.subscribe(new BaseDataSubscriber<CloseableReference<CloseableImage>>() { // from class: com.bytedance.forest.preload.CallbackDelegate$preDecodeBitmap$$inlined$let$lambda$1
            protected void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> source) {
                if (source != null) {
                    boolean z = true;
                    if (source.isFinished()) {
                        LogUtils.i$default(LogUtils.INSTANCE, PreLoader.TAG, "preDecode bitmap succeed, src = " + result.getRequest().getOriginUrl() + ", redirectTo: " + parse, false, null, null, null, 60, null);
                        CloseableReference closeableReference = (CloseableReference) source.getResult();
                        if (closeableReference != null && (closeableReference.get() instanceof CloseableBitmap)) {
                            if (!(closeableReference instanceof CloseableReference)) {
                                closeableReference = null;
                            }
                            if (closeableReference != null) {
                                result.setImageReference$forest_release(new SoftReference<>(closeableReference));
                                if (!result.getIsSucceed()) {
                                    result.setSucceed(true);
                                    Response response = result;
                                    Object obj = closeableReference.get();
                                    Intrinsics.checkExpressionValueIsNotNull(obj, "it.get()");
                                    if (!((CloseableBitmap) obj).isHitMemoryCache()) {
                                        Object obj2 = closeableReference.get();
                                        Intrinsics.checkExpressionValueIsNotNull(obj2, "it.get()");
                                        if (!((CloseableBitmap) obj2).isHitDiskCache()) {
                                            z = false;
                                        }
                                    }
                                    response.setCache(z);
                                    Object obj3 = closeableReference.get();
                                    Intrinsics.checkExpressionValueIsNotNull(obj3, "it.get()");
                                    if (((CloseableBitmap) obj3).isHitMemoryCache()) {
                                        result.setSuccessFetcher("FrescoMemoryFetcher");
                                        result.setFrom(ResourceFrom.MEMORY);
                                        result.setOriginFrom(ResourceFrom.CDN);
                                    } else {
                                        Object obj4 = closeableReference.get();
                                        Intrinsics.checkExpressionValueIsNotNull(obj4, "it.get()");
                                        if (((CloseableBitmap) obj4).isHitDiskCache()) {
                                            result.setSuccessFetcher("FrescoCDNFetcher");
                                            result.setFrom(ResourceFrom.CDN);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                onFinish.invoke();
            }

            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource2) {
                LogUtils.e$default(LogUtils.INSTANCE, PreLoader.TAG, "preload image failed, src = " + CallbackDelegate.this.getUrl() + ", redirectTo: " + parse, null, 4, null);
                onFinish.invoke();
            }

            public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource2) {
                LogUtils.e$default(LogUtils.INSTANCE, PreLoader.TAG, "preload image canceled, src = " + CallbackDelegate.this.getUrl() + ", redirectTo: " + parse, null, 4, null);
                onFinish.invoke();
            }
        }, new Executor() { // from class: com.bytedance.forest.preload.CallbackDelegate$preDecodeBitmap$1$2
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        });
    }
}
