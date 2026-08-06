package io.noties.markwon.image;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.bytedance.webx.core.webview.WebViewContainer;
import io.noties.markwon.html.tag.ImageGridHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncGridDrawable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001dB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0014J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u001e"}, d2 = {"Lio/noties/markwon/image/AsyncGridDrawable;", "Lio/noties/markwon/image/AsyncDrawable;", "destination", "", "loader", "Lio/noties/markwon/image/AsyncDrawableLoader;", "spanCount", "", ImageGridHandler.Index, "margin", "maxWidth", "(Ljava/lang/String;Lio/noties/markwon/image/AsyncDrawableLoader;IIII)V", "getIndex", "()I", "getMargin", "marginLeft", "getMarginLeft", "marginTop", "getMarginTop", "getMaxWidth", "getSpanCount", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "initBounds", "setPlaceholderResult", "placeholder", "Landroid/graphics/drawable/Drawable;", "GridImageSizeResolver", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class AsyncGridDrawable extends AsyncDrawable {
    private final int index;
    private final int margin;
    private final int marginLeft;
    private final int marginTop;
    private final int maxWidth;
    private final int spanCount;

    public final int getSpanCount() {
        return this.spanCount;
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getMargin() {
        return this.margin;
    }

    public /* synthetic */ AsyncGridDrawable(String str, AsyncDrawableLoader asyncDrawableLoader, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, asyncDrawableLoader, i, i2, i3, (i5 & 32) != 0 ? -1 : i4);
    }

    public final int getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AsyncGridDrawable(String str, AsyncDrawableLoader asyncDrawableLoader, int i, int i2, int i3, int i4) {
        super(str, asyncDrawableLoader, new GridImageSizeResolver(i, i3, i4), null);
        Intrinsics.checkParameterIsNotNull(str, "destination");
        Intrinsics.checkParameterIsNotNull(asyncDrawableLoader, "loader");
        this.spanCount = i;
        this.index = i2;
        this.margin = i3;
        this.maxWidth = i4;
        this.marginLeft = i2 % i != 0 ? i3 : 0;
        this.marginTop = i2 / i == 0 ? 0 : i3;
    }

    public final int getMarginLeft() {
        return this.marginLeft;
    }

    public final int getMarginTop() {
        return this.marginTop;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.noties.markwon.image.AsyncDrawable
    public void initBounds() {
        if (this.maxWidth <= 0 && this.canvasWidth == 0) {
            super.initBounds();
            return;
        }
        this.waitingForDimensions = false;
        Rect resolveBounds = resolveBounds();
        Intrinsics.checkExpressionValueIsNotNull(resolveBounds, "resolveBounds()");
        Drawable result = getResult();
        Intrinsics.checkExpressionValueIsNotNull(result, "result");
        result.setBounds(resolveBounds);
        Drawable result2 = getResult();
        Intrinsics.checkExpressionValueIsNotNull(result2, "result");
        result2.setCallback(this.wrapCallBack);
        setBounds(resolveBounds.left, resolveBounds.top, resolveBounds.right + this.marginLeft, resolveBounds.bottom + this.marginTop);
        invalidateSelf();
    }

    @Override // io.noties.markwon.image.AsyncDrawable
    public void setPlaceholderResult(Drawable placeholder) {
        Intrinsics.checkParameterIsNotNull(placeholder, "placeholder");
        this.isPlaceHolder = true;
        super.setResult(placeholder);
        this.isPlaceHolder = true;
    }

    @Override // io.noties.markwon.image.AsyncDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        if (hasResult()) {
            int save = canvas.save();
            try {
                canvas.translate(this.marginLeft, this.marginTop);
                super.draw(canvas);
                return;
            } finally {
                canvas.restoreToCount(save);
            }
        }
        super.draw(canvas);
    }

    /* compiled from: AsyncGridDrawable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000f"}, d2 = {"Lio/noties/markwon/image/AsyncGridDrawable$GridImageSizeResolver;", "Lio/noties/markwon/image/ImageSizeResolver;", "spanCount", "", "margin", "maxWidth", "(III)V", "getMargin", "()I", "getMaxWidth", "getSpanCount", "resolveImageSize", "Landroid/graphics/Rect;", "drawable", "Lio/noties/markwon/image/AsyncDrawable;", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static final class GridImageSizeResolver extends ImageSizeResolver {
        private final int margin;
        private final int maxWidth;
        private final int spanCount;

        public final int getSpanCount() {
            return this.spanCount;
        }

        public final int getMargin() {
            return this.margin;
        }

        public final int getMaxWidth() {
            return this.maxWidth;
        }

        public GridImageSizeResolver(int i, int i2, int i3) {
            this.spanCount = i;
            this.margin = i2;
            this.maxWidth = i3;
        }

        @Override // io.noties.markwon.image.ImageSizeResolver
        public Rect resolveImageSize(AsyncDrawable drawable) {
            Intrinsics.checkParameterIsNotNull(drawable, "drawable");
            int i = this.maxWidth;
            if (i <= 0) {
                i = drawable.getLastKnownCanvasWidth();
            }
            int i2 = this.spanCount;
            int i3 = (i - ((i2 - 1) * this.margin)) / i2;
            return new Rect(0, 0, i3, i3);
        }
    }
}
