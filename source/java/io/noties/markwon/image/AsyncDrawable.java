package io.noties.markwon.image;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class AsyncDrawable extends Drawable {
    protected int canvasWidth;
    private final String destination;
    private final ImageSize imageSize;
    private final ImageSizeResolver imageSizeResolver;
    private final AsyncDrawableLoader loader;
    private Drawable result;
    private float textSize;
    protected boolean waitingForDimensions;
    protected Drawable.Callback wrapCallBack;
    private boolean wasPlayingBefore = false;
    protected boolean isPlaceHolder = false;
    protected boolean isError = false;
    protected boolean justPlaceHolder = false;

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public AsyncDrawable(String str, AsyncDrawableLoader asyncDrawableLoader, ImageSizeResolver imageSizeResolver, ImageSize imageSize) {
        this.destination = str;
        this.loader = asyncDrawableLoader;
        this.imageSizeResolver = imageSizeResolver;
        this.imageSize = imageSize;
    }

    public String getDestination() {
        return this.destination;
    }

    public ImageSize getImageSize() {
        return this.imageSize;
    }

    public ImageSizeResolver getImageSizeResolver() {
        return this.imageSizeResolver;
    }

    public boolean hasKnownDimensions() {
        return this.canvasWidth > 0;
    }

    public int getLastKnownCanvasWidth() {
        return this.canvasWidth;
    }

    public float getLastKnowTextSize() {
        return this.textSize;
    }

    public Drawable getResult() {
        return this.result;
    }

    public boolean hasResult() {
        return this.result != null;
    }

    public boolean isAttached() {
        return getCallback() != null;
    }

    public boolean isPlaceHolder() {
        return this.isPlaceHolder;
    }

    public boolean isError() {
        return this.isError;
    }

    public boolean justPlaceHolder() {
        return this.justPlaceHolder;
    }

    public void setJustPlaceHolder(boolean z) {
        this.justPlaceHolder = z;
    }

    public void setCallback2(Drawable.Callback callback) {
        this.wrapCallBack = callback == null ? null : new WrappedCallback(callback);
        super.setCallback(callback);
        if (this.wrapCallBack != null) {
            Drawable drawable = this.result;
            if (drawable != null && drawable.getCallback() == null) {
                this.result.setCallback(this.wrapCallBack);
            }
            boolean z = !this.justPlaceHolder && (this.result == null || this.isPlaceHolder);
            Drawable drawable2 = this.result;
            if (drawable2 != null) {
                drawable2.setCallback(this.wrapCallBack);
                Object obj = this.result;
                if ((obj instanceof Animatable) && this.wasPlayingBefore) {
                    ((Animatable) obj).start();
                }
            }
            if (z) {
                this.loader.load(this);
                return;
            }
            return;
        }
        Drawable drawable3 = this.result;
        if (drawable3 != null) {
            drawable3.setCallback(null);
            Object obj2 = this.result;
            if (obj2 instanceof Animatable) {
                Animatable animatable = (Animatable) obj2;
                boolean isRunning = animatable.isRunning();
                this.wasPlayingBefore = isRunning;
                if (isRunning) {
                    animatable.stop();
                }
            }
        }
        this.loader.cancel(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setPlaceholder() {
        Drawable placeholder = this.loader.placeholder(this);
        if (placeholder != 0) {
            setPlaceholderResult(placeholder);
            if (placeholder instanceof Animatable) {
                ((Animatable) placeholder).start();
            }
        }
    }

    public void setPlaceholderResult(Drawable drawable) {
        Drawable drawable2 = this.result;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.isPlaceHolder = true;
        Rect bounds = drawable.getBounds();
        if (bounds.isEmpty()) {
            Rect intrinsicBounds = DrawableUtils.intrinsicBounds(drawable);
            if (intrinsicBounds.isEmpty()) {
                drawable.setBounds(0, 0, 1, 1);
            } else {
                drawable.setBounds(intrinsicBounds);
            }
            setBounds(drawable.getBounds());
            setResult(drawable);
        } else {
            this.result = drawable;
            drawable.setCallback(this.wrapCallBack);
            setBounds(bounds);
            this.waitingForDimensions = false;
        }
        this.isPlaceHolder = true;
    }

    public void setErrorResult(Drawable drawable) {
        if (this.justPlaceHolder) {
            return;
        }
        setResult(drawable);
        this.isError = true;
    }

    public void setResult(Drawable drawable) {
        if (!this.justPlaceHolder || this.isPlaceHolder) {
            this.wasPlayingBefore = false;
            Drawable drawable2 = this.result;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                Object obj = this.result;
                if (obj instanceof Animatable) {
                    Animatable animatable = (Animatable) obj;
                    if (animatable.isRunning()) {
                        animatable.stop();
                    }
                }
            }
            this.result = drawable;
            initBounds();
            this.isError = false;
            this.isPlaceHolder = false;
        }
    }

    public void clearResult() {
        Drawable drawable = this.result;
        if (drawable != null) {
            drawable.setCallback(null);
            this.result = null;
            setBounds(0, 0, 0, 0);
        }
        this.isPlaceHolder = false;
        this.isError = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initBounds() {
        if (this.canvasWidth == 0) {
            this.waitingForDimensions = true;
            setBounds(noDimensionsBounds(this.result));
            return;
        }
        this.waitingForDimensions = false;
        Rect resolveBounds = resolveBounds();
        this.result.setBounds(resolveBounds);
        this.result.setCallback(this.wrapCallBack);
        setBounds(resolveBounds);
    }

    private static Rect noDimensionsBounds(Drawable drawable) {
        if (drawable != null) {
            Rect bounds = drawable.getBounds();
            if (!bounds.isEmpty()) {
                return bounds;
            }
            Rect intrinsicBounds = DrawableUtils.intrinsicBounds(drawable);
            if (!intrinsicBounds.isEmpty()) {
                return intrinsicBounds;
            }
        }
        return new Rect(0, 0, 1, 1);
    }

    public void initWithKnownDimensions(int i, float f) {
        this.canvasWidth = i;
        this.textSize = f;
        if (this.waitingForDimensions) {
            initBounds();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (hasResult()) {
            this.result.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.result;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (hasResult()) {
            return this.result.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (hasResult()) {
            return this.result.getIntrinsicWidth();
        }
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (hasResult()) {
            return this.result.getIntrinsicHeight();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Rect resolveBounds() {
        return this.imageSizeResolver.resolveImageSize(this);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        invalidateSelf();
    }

    public String toString() {
        return "AsyncDrawable{destination='" + this.destination + "', imageSize=" + this.imageSize + ", result=" + this.result + ", canvasWidth=" + this.canvasWidth + ", textSize=" + this.textSize + ", waitingForDimensions=" + this.waitingForDimensions + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.result;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    public void reload() {
        this.loader.cancel(this);
        setPlaceholder();
        this.loader.load(this);
    }

    /* loaded from: classes6.dex */
    private class WrappedCallback implements Drawable.Callback {
        private final Drawable.Callback callback;

        WrappedCallback(Drawable.Callback callback) {
            this.callback = callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            this.callback.invalidateDrawable(AsyncDrawable.this);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.callback.scheduleDrawable(AsyncDrawable.this, runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.callback.unscheduleDrawable(AsyncDrawable.this, runnable);
        }
    }
}
