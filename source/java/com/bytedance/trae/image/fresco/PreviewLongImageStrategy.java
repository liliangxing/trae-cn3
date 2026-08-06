package com.bytedance.trae.image.fresco;

import android.net.Uri;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IResizeStrategy.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/image/fresco/PreviewLongImageStrategy;", "Lcom/bytedance/trae/image/fresco/IResizeStrategy;", "<init>", "()V", "TAG", "", "enableLongImageAutoFit", "", "getResizeConfig", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "uri", "Landroid/net/Uri;", "viewWidth", "", "viewHeight", "imgWidth", "imgHeight", "hasAlpha", "imageFormat", "Lcom/facebook/imageformat/ImageFormat;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class PreviewLongImageStrategy implements IResizeStrategy {
    public static final PreviewLongImageStrategy INSTANCE = new PreviewLongImageStrategy();
    private static final String TAG = "PreviewLongImageStrategy";
    private static final boolean enableLongImageAutoFit = false;

    private PreviewLongImageStrategy() {
    }

    @Override // com.bytedance.trae.image.fresco.IResizeStrategy
    public ResizeOptions getResizeConfig(Uri uri, int viewWidth, int viewHeight, int imgWidth, int imgHeight, boolean hasAlpha, ImageFormat imageFormat) {
        String str;
        if (!enableLongImageAutoFit || uri == null || imgWidth <= 0 || imgHeight <= 0) {
            return null;
        }
        try {
            str = uri.getQueryParameter(FrescoUtils.BIZ_TAG);
        } catch (UnsupportedOperationException unused) {
            str = null;
        }
        if (!Intrinsics.areEqual(str, FrescoUtils.TAG_COMMON_PHOTO_DIALOG_PREVIEW)) {
            return null;
        }
        float f = imgHeight;
        if (f / imgWidth < 5.0f) {
            return null;
        }
        IResizeStrategyKt.log(TAG, uri, imgWidth, imgHeight, viewWidth, viewHeight);
        return new ResizeOptions(imgWidth, imgHeight, f);
    }
}
