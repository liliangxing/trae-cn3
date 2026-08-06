package com.bytedance.trae.image.fresco;

import android.net.Uri;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import kotlin.Metadata;

/* compiled from: IResizeStrategy.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/image/fresco/IResizeStrategy;", "", "getResizeConfig", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "uri", "Landroid/net/Uri;", "viewWidth", "", "viewHeight", "imgWidth", "imgHeight", "hasAlpha", "", "imageFormat", "Lcom/facebook/imageformat/ImageFormat;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IResizeStrategy {
    ResizeOptions getResizeConfig(Uri uri, int viewWidth, int viewHeight, int imgWidth, int imgHeight, boolean hasAlpha, ImageFormat imageFormat);
}
