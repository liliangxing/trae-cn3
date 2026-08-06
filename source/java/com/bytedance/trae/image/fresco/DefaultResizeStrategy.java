package com.bytedance.trae.image.fresco;

import android.net.Uri;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import kotlin.Metadata;

/* compiled from: IResizeStrategy.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/image/fresco/DefaultResizeStrategy;", "Lcom/bytedance/trae/image/fresco/IResizeStrategy;", "<init>", "()V", "TAG", "", "imageResizeOpt", "", "getResizeConfig", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "uri", "Landroid/net/Uri;", "viewWidth", "", "viewHeight", "imgWidth", "imgHeight", "hasAlpha", "imageFormat", "Lcom/facebook/imageformat/ImageFormat;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DefaultResizeStrategy implements IResizeStrategy {
    public static final DefaultResizeStrategy INSTANCE = new DefaultResizeStrategy();
    private static final String TAG = "DefaultResizeStrategy";
    private static final boolean imageResizeOpt = false;

    private DefaultResizeStrategy() {
    }

    @Override // com.bytedance.trae.image.fresco.IResizeStrategy
    public ResizeOptions getResizeConfig(Uri uri, int viewWidth, int viewHeight, int imgWidth, int imgHeight, boolean hasAlpha, ImageFormat imageFormat) {
        if (!imageResizeOpt || uri == null || viewWidth <= 1 || viewHeight <= 1 || imgWidth <= 0 || imgHeight <= 0 || imgWidth <= viewWidth || imgHeight <= viewHeight) {
            return null;
        }
        IResizeStrategyKt.log(TAG, uri, imgWidth, imgHeight, viewWidth, viewHeight);
        float f = imgWidth;
        float f2 = f / viewWidth;
        float f3 = imgHeight;
        float f4 = f3 / viewHeight;
        if (f2 > f4) {
            viewWidth = (int) (f / f4);
        } else {
            viewHeight = (int) (f3 / f2);
        }
        return new ResizeOptions(viewWidth, viewHeight);
    }
}
