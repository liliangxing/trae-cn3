package com.larus.business.markdown.fresco;

import android.graphics.Rect;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.larus.business.markdown.fresco.FrescoAsyncDrawableLoader;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.ImageSize;
import io.noties.markwon.image.ImageSizeScaleUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomImageRequestInterceptor.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/business/markdown/fresco/CustomImageRequestInterceptor;", "Lcom/larus/business/markdown/fresco/FrescoAsyncDrawableLoader$ImageRequestInterceptor;", "defaultPlaceImageSize", "Landroid/graphics/Rect;", "maxContentWidth", "", "minWidthHeight", "cornerRadius", "(Landroid/graphics/Rect;Ljava/lang/Integer;II)V", "Ljava/lang/Integer;", "buildImageRequest", "", "drawable", "Lio/noties/markwon/image/AsyncDrawable;", "builder", "Lcom/facebook/imagepipeline/request/ImageRequestBuilder;", "markdown-fresco_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomImageRequestInterceptor implements FrescoAsyncDrawableLoader.ImageRequestInterceptor {
    private final int cornerRadius;
    private final Rect defaultPlaceImageSize;
    private final Integer maxContentWidth;
    private final int minWidthHeight;

    public CustomImageRequestInterceptor(Rect rect, Integer num, int i, int i2) {
        this.defaultPlaceImageSize = rect;
        this.maxContentWidth = num;
        this.minWidthHeight = i;
        this.cornerRadius = i2;
    }

    @Override // com.larus.business.markdown.fresco.FrescoAsyncDrawableLoader.ImageRequestInterceptor
    public void buildImageRequest(AsyncDrawable drawable, ImageRequestBuilder builder) {
        Rect rect;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (drawable.getImageSize() != null && this.maxContentWidth != null) {
            ImageSizeScaleUtils imageSizeScaleUtils = ImageSizeScaleUtils.INSTANCE;
            ImageSize imageSize = drawable.getImageSize();
            Intrinsics.checkNotNull(imageSize);
            Rect bounds = drawable.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "drawable.bounds");
            rect = ImageSizeScaleUtils.INSTANCE.handleScale(imageSizeScaleUtils.imageSizeToRect(imageSize, bounds, this.maxContentWidth.intValue(), 0.0f), this.maxContentWidth.intValue(), this.minWidthHeight);
        } else {
            rect = this.defaultPlaceImageSize;
        }
        builder.setPostprocessor(new CustomPostprocessor(rect, this.cornerRadius));
    }
}
