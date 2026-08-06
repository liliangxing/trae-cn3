package com.larus.business.markdown.fresco;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.vmsdk.inspector_new.server.http.HttpStatus;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.huawei.agconnect.exception.AGCServerException;
import com.larus.business.markdown.api.SpanUtilsKt;
import com.larus.business.markdown.api.depend.IMarkdownLogger;
import com.larus.business.markdown.api.depend.IMarkdownLoggerKt;
import com.larus.business.markdown.api.extplugin.image.ImageStatusDrawableProvider;
import com.larus.business.markdown.api.model.ImageSpanStatus;
import com.lynx.tasm.DefaultLogicExecutor;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.CustomAsyncDrawable;
import io.noties.markwon.image.DrawableUtils;
import io.noties.markwon.image.ImageSizeScaleUtils;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: FrescoAsyncDrawableLoader.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u0003012Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012:\b\u0002\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000f¢\u0006\u0002\u0010\u0017J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001dH\u0016J\u001c\u0010!\u001a\u0006\u0012\u0002\b\u00030\u001e2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010 \u001a\u00020\u001dH\u0016J \u0010(\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u001d2\u0006\u0010)\u001a\u00020*H\u0002J\"\u0010+\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u001d2\b\u0010,\u001a\u0004\u0018\u00010'2\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u0003R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00030\u00030\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001e0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/business/markdown/fresco/FrescoAsyncDrawableLoader;", "Lio/noties/markwon/image/AsyncDrawableLoader;", "context", "Landroid/content/Context;", "threadExecutor", "Ljava/util/concurrent/ExecutorService;", "mainHandler", "Landroid/os/Handler;", "cornerRadius", "", "imageRequestInterceptor", "Lcom/larus/business/markdown/fresco/FrescoAsyncDrawableLoader$ImageRequestInterceptor;", "imageStatusDrawableProvider", "Lcom/larus/business/markdown/api/extplugin/image/ImageStatusDrawableProvider;", "imageRenewExecutor", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "url", "Lcom/larus/business/markdown/fresco/FrescoAsyncDrawableLoader$UrlUpdateCallback;", "urlUpdateCallback", "", "(Landroid/content/Context;Ljava/util/concurrent/ExecutorService;Landroid/os/Handler;ILcom/larus/business/markdown/fresco/FrescoAsyncDrawableLoader$ImageRequestInterceptor;Lcom/larus/business/markdown/api/extplugin/image/ImageStatusDrawableProvider;Lkotlin/jvm/functions/Function2;)V", "contextRef", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "requests", "", "Lio/noties/markwon/image/AsyncDrawable;", "Lcom/facebook/datasource/DataSource;", "cancel", "drawable", "execute", "asyncDrawable", "isValidImageUrl", "", "load", "placeholder", "Landroid/graphics/drawable/Drawable;", "setErrorResult", "e", "", "setResult", "result", "state", "Lcom/larus/business/markdown/api/model/ImageSpanStatus;", "updateContext", "Companion", "ImageRequestInterceptor", "UrlUpdateCallback", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class FrescoAsyncDrawableLoader extends AsyncDrawableLoader {
    private static final Set<Integer> ILLEGAL_STATUS_CODES = SetsKt.setOf(new Integer[]{Integer.valueOf(AGCServerException.AUTHENTICATION_INVALID), 401, Integer.valueOf(AGCServerException.AUTHENTICATION_FAILED), Integer.valueOf(HttpStatus.HTTP_NOT_FOUND)});
    private WeakReference<Context> contextRef;
    private final int cornerRadius;
    private final Function2<String, UrlUpdateCallback, Unit> imageRenewExecutor;
    private final ImageRequestInterceptor imageRequestInterceptor;
    private final ImageStatusDrawableProvider imageStatusDrawableProvider;
    private final Handler mainHandler;
    private final Map<AsyncDrawable, DataSource<?>> requests;
    private final ExecutorService threadExecutor;

    /* compiled from: FrescoAsyncDrawableLoader.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/larus/business/markdown/fresco/FrescoAsyncDrawableLoader$ImageRequestInterceptor;", "", "buildImageRequest", "", "drawable", "Lio/noties/markwon/image/AsyncDrawable;", "builder", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface ImageRequestInterceptor {
        void buildImageRequest(AsyncDrawable drawable, ImageRequestBuilder builder);
    }

    /* compiled from: FrescoAsyncDrawableLoader.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/larus/business/markdown/fresco/FrescoAsyncDrawableLoader$UrlUpdateCallback;", "", "onUpdateUrl", "", "url", "", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface UrlUpdateCallback {
        void onUpdateUrl(String url);
    }

    public /* synthetic */ FrescoAsyncDrawableLoader(Context context, ExecutorService executorService, Handler handler, int i, ImageRequestInterceptor imageRequestInterceptor, ImageStatusDrawableProvider imageStatusDrawableProvider, Function2 function2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, executorService, handler, i, imageRequestInterceptor, imageStatusDrawableProvider, (i2 & 64) != 0 ? null : function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FrescoAsyncDrawableLoader(Context context, ExecutorService executorService, Handler handler, int i, ImageRequestInterceptor imageRequestInterceptor, ImageStatusDrawableProvider imageStatusDrawableProvider, Function2<? super String, ? super UrlUpdateCallback, Unit> function2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executorService, "threadExecutor");
        Intrinsics.checkNotNullParameter(handler, "mainHandler");
        Intrinsics.checkNotNullParameter(imageStatusDrawableProvider, "imageStatusDrawableProvider");
        this.threadExecutor = executorService;
        this.mainHandler = handler;
        this.cornerRadius = i;
        this.imageRequestInterceptor = imageRequestInterceptor;
        this.imageStatusDrawableProvider = imageStatusDrawableProvider;
        this.imageRenewExecutor = function2;
        this.contextRef = new WeakReference<>(context);
        this.requests = new LinkedHashMap();
    }

    public final void updateContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextRef = new WeakReference<>(context);
    }

    @Override // io.noties.markwon.image.AsyncDrawableLoader
    public void load(final AsyncDrawable drawable) {
        Unit unit;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this.requests.get(drawable) == null) {
            String destination = drawable.getDestination();
            Intrinsics.checkNotNullExpressionValue(destination, "drawable.destination");
            if (isValidImageUrl(destination)) {
                Function2<String, UrlUpdateCallback, Unit> function2 = this.imageRenewExecutor;
                if (function2 != null) {
                    function2.invoke(destination, new UrlUpdateCallback() { // from class: com.larus.business.markdown.fresco.FrescoAsyncDrawableLoader$load$1
                        @Override // com.larus.business.markdown.fresco.FrescoAsyncDrawableLoader.UrlUpdateCallback
                        public void onUpdateUrl(String url) {
                            Map map;
                            DataSource execute;
                            Intrinsics.checkNotNullParameter(url, "url");
                            map = FrescoAsyncDrawableLoader.this.requests;
                            AsyncDrawable asyncDrawable = drawable;
                            execute = FrescoAsyncDrawableLoader.this.execute(asyncDrawable, url);
                            map.put(asyncDrawable, execute);
                        }
                    });
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    this.requests.put(drawable, execute(drawable, destination));
                    return;
                }
                return;
            }
            setErrorResult(destination, drawable, new IllegalImageUrlException(destination));
        }
    }

    private final boolean isValidImageUrl(String url) {
        Uri parse = Uri.parse(url);
        if (!Intrinsics.areEqual(parse.getScheme(), "http") && !Intrinsics.areEqual(parse.getScheme(), "https")) {
            return false;
        }
        String authority = parse.getAuthority();
        if (authority == null || StringsKt.isBlank(authority)) {
            return false;
        }
        String path = parse.getPath();
        return !(path == null || StringsKt.isBlank(path));
    }

    @Override // io.noties.markwon.image.AsyncDrawableLoader
    public void cancel(AsyncDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        DataSource<?> remove = this.requests.remove(drawable);
        if (remove != null) {
            remove.close();
        }
    }

    @Override // io.noties.markwon.image.AsyncDrawableLoader
    public Drawable placeholder(AsyncDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        ImageStatusDrawableProvider imageStatusDrawableProvider = this.imageStatusDrawableProvider;
        Context context = this.contextRef.get();
        if (context == null) {
            return null;
        }
        String destination = drawable.getDestination();
        Intrinsics.checkNotNullExpressionValue(destination, "drawable.destination");
        return imageStatusDrawableProvider.getDrawable(context, destination, ImageSpanStatus.LOADING, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DataSource<?> execute(final AsyncDrawable asyncDrawable, final String url) {
        CustomAsyncDrawable customAsyncDrawable = asyncDrawable instanceof CustomAsyncDrawable ? (CustomAsyncDrawable) asyncDrawable : null;
        if (customAsyncDrawable != null) {
            customAsyncDrawable.setImageStatus(ImageSpanStatus.LOADING);
        }
        BaseBitmapDataSubscriber baseBitmapDataSubscriber = new BaseBitmapDataSubscriber() { // from class: com.larus.business.markdown.fresco.FrescoAsyncDrawableLoader$execute$dataSubscriber$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
            public void onNewResultImpl(Bitmap bitmap) {
                WeakReference weakReference;
                if (bitmap != null) {
                    weakReference = FrescoAsyncDrawableLoader.this.contextRef;
                    Context context = (Context) weakReference.get();
                    FrescoAsyncDrawableLoader.this.setResult(asyncDrawable, new BitmapDrawable(context != null ? context.getResources() : null, bitmap.copy(SpanUtilsKt.orDefault$default(bitmap.getConfig(), null, 1, null), false)), ImageSpanStatus.SUCC);
                    return;
                }
                FrescoAsyncDrawableLoader.this.setErrorResult(url, asyncDrawable, new IllegalArgumentException("no_bmp"));
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                FrescoAsyncDrawableLoader frescoAsyncDrawableLoader = FrescoAsyncDrawableLoader.this;
                String str = url;
                AsyncDrawable asyncDrawable2 = asyncDrawable;
                IllegalStateException failureCause = dataSource.getFailureCause();
                if (failureCause == null) {
                    failureCause = new IllegalStateException("no_cause");
                }
                frescoAsyncDrawableLoader.setErrorResult(str, asyncDrawable2, failureCause);
            }
        };
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url));
        ImageRequestInterceptor imageRequestInterceptor = this.imageRequestInterceptor;
        if (imageRequestInterceptor != null) {
            Intrinsics.checkNotNullExpressionValue(newBuilderWithSource, "it");
            imageRequestInterceptor.buildImageRequest(asyncDrawable, newBuilderWithSource);
        }
        DataSource<CloseableReference<CloseableImage>> fetchDecodedImage = Fresco.getImagePipeline().fetchDecodedImage(newBuilderWithSource.build(), null);
        fetchDecodedImage.subscribe(baseBitmapDataSubscriber, UiThreadImmediateExecutorService.getInstance());
        Intrinsics.checkNotNullExpressionValue(fetchDecodedImage, "dataSource");
        return fetchDecodedImage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setErrorResult(String url, AsyncDrawable drawable, Throwable e) {
        ImageSpanStatus imageSpanStatus;
        if ((e instanceof DecodeException) || (e instanceof IllegalImageUrlException)) {
            imageSpanStatus = ImageSpanStatus.FAIL_NO_RETRY;
        } else if ((e instanceof CronetIOException) && ILLEGAL_STATUS_CODES.contains(Integer.valueOf(((CronetIOException) e).getStatusCode()))) {
            imageSpanStatus = ImageSpanStatus.FAIL_NO_RETRY;
        } else {
            imageSpanStatus = ImageSpanStatus.FAIL;
        }
        ImageStatusDrawableProvider imageStatusDrawableProvider = this.imageStatusDrawableProvider;
        Context context = this.contextRef.get();
        if (context == null) {
            return;
        }
        setResult(drawable, imageStatusDrawableProvider.getDrawable(context, url, imageSpanStatus, e), imageSpanStatus);
        IMarkdownLogger markdownLoggerDelegate = IMarkdownLoggerKt.getMarkdownLoggerDelegate();
        if (markdownLoggerDelegate != null) {
            markdownLoggerDelegate.mo2529e("image_load", "status:" + imageSpanStatus + "; url:" + url + "; throwable:" + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setResult(final AsyncDrawable asyncDrawable, final Drawable result, ImageSpanStatus state) {
        this.requests.remove(asyncDrawable);
        CustomAsyncDrawable customAsyncDrawable = asyncDrawable instanceof CustomAsyncDrawable ? (CustomAsyncDrawable) asyncDrawable : null;
        if (customAsyncDrawable != null) {
            customAsyncDrawable.setImageStatus(state);
        }
        if (result != null) {
            Rect bounds = result.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "result.bounds");
            if (bounds.isEmpty()) {
                DrawableUtils.applyIntrinsicBounds(result);
            }
            if (asyncDrawable.isAttached()) {
                if (state == ImageSpanStatus.SUCC) {
                    asyncDrawable.setResult(result);
                    asyncDrawable.invalidateSelf();
                } else {
                    this.threadExecutor.execute(new Runnable() { // from class: com.larus.business.markdown.fresco.FrescoAsyncDrawableLoader$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            FrescoAsyncDrawableLoader.setResult$lambda$3(result, asyncDrawable, this);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setResult$lambda$3(Drawable drawable, final AsyncDrawable asyncDrawable, FrescoAsyncDrawableLoader frescoAsyncDrawableLoader) {
        Intrinsics.checkNotNullParameter(asyncDrawable, "$asyncDrawable");
        Intrinsics.checkNotNullParameter(frescoAsyncDrawableLoader, "this$0");
        ImageSizeScaleUtils imageSizeScaleUtils = ImageSizeScaleUtils.INSTANCE;
        Bitmap convertToBitmap = ImageSizeScaleUtils.INSTANCE.convertToBitmap(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Rect bounds = asyncDrawable.getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "asyncDrawable.bounds");
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(ImageSizeScaleUtils.INSTANCE.createRoundedBmp(imageSizeScaleUtils.createScaledBmp(convertToBitmap, bounds), frescoAsyncDrawableLoader.cornerRadius));
        frescoAsyncDrawableLoader.mainHandler.post(new Runnable() { // from class: com.larus.business.markdown.fresco.FrescoAsyncDrawableLoader$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                FrescoAsyncDrawableLoader.setResult$lambda$3$lambda$2(AsyncDrawable.this, bitmapDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setResult$lambda$3$lambda$2(AsyncDrawable asyncDrawable, BitmapDrawable bitmapDrawable) {
        Intrinsics.checkNotNullParameter(asyncDrawable, "$asyncDrawable");
        Intrinsics.checkNotNullParameter(bitmapDrawable, "$finalDrawable");
        asyncDrawable.setErrorResult(bitmapDrawable);
        asyncDrawable.invalidateSelf();
    }
}
