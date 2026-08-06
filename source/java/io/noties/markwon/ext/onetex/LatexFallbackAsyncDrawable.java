package io.noties.markwon.ext.onetex;

import android.graphics.drawable.Drawable;
import com.larus.business.markdown.api.model.ImageSpanStatus;
import com.lynx.tasm.behavior.PropsConstants;
import com.ss.android.download.api.constant.Downloads;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableLoader;
import io.noties.markwon.image.ImageSize;
import io.noties.markwon.image.ImageSizeResolver;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LatexFallbackAsyncDrawableSpan.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexFallbackAsyncDrawable;", "Lio/noties/markwon/image/AsyncDrawable;", Downloads.Impl.COLUMN_DESTINATION, "", "loader", "Lio/noties/markwon/image/AsyncDrawableLoader;", "imageSizeResolver", "Lio/noties/markwon/image/ImageSizeResolver;", "imageSize", "Lio/noties/markwon/image/ImageSize;", "(Ljava/lang/String;Lio/noties/markwon/image/AsyncDrawableLoader;Lio/noties/markwon/image/ImageSizeResolver;Lio/noties/markwon/image/ImageSize;)V", "imageStatus", "Lcom/larus/business/markdown/api/model/ImageSpanStatus;", "getImageStatus", "()Lcom/larus/business/markdown/api/model/ImageSpanStatus;", "setImageStatus", "(Lcom/larus/business/markdown/api/model/ImageSpanStatus;)V", "offsetX", "", "getOffsetX", "()I", "setOffsetX", "(I)V", "setPlaceholderResult", "", PropsConstants.PLACEHOLDER, "Landroid/graphics/drawable/Drawable;", "markdown-latex_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LatexFallbackAsyncDrawable extends AsyncDrawable {
    private ImageSpanStatus imageStatus;
    private int offsetX;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LatexFallbackAsyncDrawable(String str, AsyncDrawableLoader asyncDrawableLoader, ImageSizeResolver imageSizeResolver, ImageSize imageSize) {
        super(str, asyncDrawableLoader, imageSizeResolver, imageSize);
        Intrinsics.checkNotNullParameter(str, Downloads.Impl.COLUMN_DESTINATION);
        Intrinsics.checkNotNullParameter(asyncDrawableLoader, "loader");
        Intrinsics.checkNotNullParameter(imageSizeResolver, "imageSizeResolver");
        this.imageStatus = ImageSpanStatus.IDLE;
    }

    public final ImageSpanStatus getImageStatus() {
        return this.imageStatus;
    }

    public final void setImageStatus(ImageSpanStatus imageSpanStatus) {
        Intrinsics.checkNotNullParameter(imageSpanStatus, "<set-?>");
        this.imageStatus = imageSpanStatus;
    }

    public final int getOffsetX() {
        return this.offsetX;
    }

    public final void setOffsetX(int i) {
        this.offsetX = i;
    }

    public void setPlaceholderResult(Drawable placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, PropsConstants.PLACEHOLDER);
        super.setPlaceholderResult(placeholder);
        this.waitingForDimensions = true;
    }
}
