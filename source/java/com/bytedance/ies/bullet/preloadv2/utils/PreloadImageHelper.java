package com.bytedance.ies.bullet.preloadv2.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: PreloadImageHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0002J*\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u001a\u0010\u0011\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u000f0\u0012J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/bullet/preloadv2/utils/PreloadImageHelper;", "", "()V", "frescoHasBeenInitialized", "", "getImageSize", "", "filePath", "", "makeDefaultRequest", "Lcom/facebook/imagepipeline/request/ImageRequest;", "uri", "Landroid/net/Uri;", "lowQuality", "request", "", "resUrl", "callback", "Lkotlin/Function1;", "Lcom/facebook/common/references/CloseableReference;", "Landroid/graphics/Bitmap;", "requireLowQuality", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PreloadImageHelper {
    public static final PreloadImageHelper INSTANCE = new PreloadImageHelper();

    private PreloadImageHelper() {
    }

    private final boolean frescoHasBeenInitialized() {
        return Fresco.hasBeenInitialized();
    }

    public final long getImageSize(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        long j = options.outWidth * options.outHeight * 4;
        PreloadLogger.INSTANCE.m43i("PreloadImageHelper.getImageSize " + j + ", width " + options.outWidth + ", height " + options.outHeight + ", " + filePath);
        return j;
    }

    private final boolean requireLowQuality(Uri uri) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            PreloadImageHelper preloadImageHelper = this;
            obj = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(uri.getQueryParameter("quality"), ViewVisibleBridge.INVISIBLE)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final void request(String resUrl, Function1<? super CloseableReference<Bitmap>, Unit> callback) {
        Intrinsics.checkNotNullParameter(resUrl, "resUrl");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!frescoHasBeenInitialized()) {
            callback.invoke((Object) null);
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        long currentTimeMillis = System.currentTimeMillis();
        PreloadLogger.INSTANCE.m41d("PreloadImageHelper, request begin " + resUrl);
        Uri parse = Uri.parse(resUrl);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        Intrinsics.checkNotNullExpressionValue(parse, "imageUri");
        ((DataSource) Fresco.getImagePipeline().getDataSourceSupplier(makeDefaultRequest(parse, requireLowQuality(parse)), (Object) null, ImageRequest.RequestLevel.FULL_FETCH).get()).subscribe(new BaseBitmapDataSubscriber() { // from class: com.bytedance.ies.bullet.preloadv2.utils.PreloadImageHelper$request$1$1
            protected void onNewResultImpl(Bitmap bitmap) {
                objectRef.element = bitmap != null ? Fresco.getImagePipelineFactory().getPlatformBitmapFactory().createBitmap(bitmap) : null;
                countDownLatch.countDown();
                if (booleanRef.element) {
                    PreloadLogger.INSTANCE.m41d("PreloadImageHelper, timeout, release closeable image");
                    CloseableReference closeableReference = (CloseableReference) objectRef.element;
                    if (closeableReference != null) {
                        closeableReference.close();
                    }
                }
            }

            protected void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
                objectRef.element = null;
                countDownLatch.countDown();
            }

            public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
                objectRef.element = null;
                countDownLatch.countDown();
            }
        }, new Executor() { // from class: com.bytedance.ies.bullet.preloadv2.utils.PreloadImageHelper$request$1$2
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        });
        countDownLatch.await(10L, TimeUnit.SECONDS);
        PreloadLogger.INSTANCE.m41d("PreloadImageHelper, request end " + resUrl + ", cost " + (System.currentTimeMillis() - currentTimeMillis));
        callback.invoke(objectRef.element);
        booleanRef.element = true;
    }

    static /* synthetic */ ImageRequest makeDefaultRequest$default(PreloadImageHelper preloadImageHelper, Uri uri, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return preloadImageHelper.makeDefaultRequest(uri, z);
    }

    private final ImageRequest makeDefaultRequest(Uri uri, boolean lowQuality) {
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(uri);
        newBuilderWithSource.disableMemoryCache();
        if (lowQuality) {
            newBuilderWithSource.setPostprocessor(new BasePostprocessor() { // from class: com.bytedance.ies.bullet.preloadv2.utils.PreloadImageHelper$makeDefaultRequest$1$1
                public CloseableReference<Bitmap> process(Bitmap sourceBitmap, PlatformBitmapFactory bitmapFactory) {
                    Intrinsics.checkNotNullParameter(sourceBitmap, "sourceBitmap");
                    Intrinsics.checkNotNullParameter(bitmapFactory, "bitmapFactory");
                    CloseableReference closeableReference = null;
                    try {
                        CloseableReference createBitmapInternal = bitmapFactory.createBitmapInternal(sourceBitmap.getWidth(), sourceBitmap.getHeight(), Bitmap.Config.RGB_565);
                        try {
                            new Canvas((Bitmap) createBitmapInternal.get()).drawBitmap(sourceBitmap, 0.0f, 0.0f, (Paint) null);
                            CloseableReference<Bitmap> cloneOrNull = CloseableReference.cloneOrNull(createBitmapInternal);
                            CloseableReference.closeSafely(createBitmapInternal);
                            return cloneOrNull;
                        } catch (Throwable unused) {
                            closeableReference = createBitmapInternal;
                            try {
                                PreloadLogger.INSTANCE.m42e("preload fail when makeDefaultRequest");
                                CloseableReference.closeSafely(closeableReference);
                                return super.process(sourceBitmap, bitmapFactory);
                            } catch (Throwable th) {
                                CloseableReference.closeSafely(closeableReference);
                                throw th;
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                }
            });
        }
        ImageRequest build = newBuilderWithSource.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilderWithSource(uri…      }\n        }.build()");
        return build;
    }
}
