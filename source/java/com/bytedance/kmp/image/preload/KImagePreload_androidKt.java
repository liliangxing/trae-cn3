package com.bytedance.kmp.image.preload;

import android.net.Uri;
import com.bytedance.kmp.image.options.AndroidFrescoImageConfigurator;
import com.bytedance.kmp.image.options.ImageBlurOption;
import com.bytedance.kmp.image.options.ImageOptions;
import com.bytedance.kmp.image.options.Priority;
import com.bytedance.kmp.image.preload.KImagePreload;
import com.bytedance.kmp.image.utils.ImageUtilsKt;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KImagePreload.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"preloadImg", "", "url", "", "imageOption", "Lcom/bytedance/kmp/image/options/ImageOptions;", "cacheStrategy", "Lcom/bytedance/kmp/image/preload/KImagePreload$CacheStrategy;", "kmpimage_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KImagePreload_androidKt {
    public static final void preloadImg(String str, ImageOptions imageOptions, KImagePreload.CacheStrategy cacheStrategy) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(imageOptions, "imageOption");
        Intrinsics.checkNotNullParameter(cacheStrategy, "cacheStrategy");
        imageOptions.doPlatformImageConfig$kmpimage_release(new AndroidFrescoImageConfigurator());
        AndroidFrescoImageConfigurator platformImageConfigurator$kmpimage_release = imageOptions.getPlatformImageConfigurator$kmpimage_release();
        ImageBlurOption blurOption$kmpimage_release = imageOptions.getBlurOption$kmpimage_release();
        Priority priority$kmpimage_release = imageOptions.getPriority$kmpimage_release();
        String tag$kmpimage_release = imageOptions.getTag$kmpimage_release();
        if (tag$kmpimage_release == null) {
            tag$kmpimage_release = "preloadImg";
        }
        ImageRequestBuilder blurHashOptions = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).setRequestPriority(ImageUtilsKt.toFrescoPriority(priority$kmpimage_release)).setBlurHashOptions(ImageUtilsKt.toBlurHashConfig(blurOption$kmpimage_release));
        Function1<ImageRequestBuilder, Unit> onRequestBuild$kmpimage_release = platformImageConfigurator$kmpimage_release.getOnRequestBuild$kmpimage_release();
        Intrinsics.checkNotNullExpressionValue(blurHashOptions, "builder");
        onRequestBuild$kmpimage_release.invoke(blurHashOptions);
        if (Intrinsics.areEqual(cacheStrategy, KImagePreload.CacheStrategy.Disk.INSTANCE)) {
            Fresco.getImagePipeline().prefetchToDiskCache(blurHashOptions.build(), tag$kmpimage_release);
        } else {
            if (Intrinsics.areEqual(cacheStrategy, KImagePreload.CacheStrategy.Memory.INSTANCE)) {
                Fresco.getImagePipeline().prefetchToBitmapCache(blurHashOptions.build(), tag$kmpimage_release);
                return;
            }
            throw new NotImplementedError((String) null, 1, (DefaultConstructorMarker) null);
        }
    }
}
