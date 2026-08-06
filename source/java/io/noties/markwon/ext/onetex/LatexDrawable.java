package io.noties.markwon.ext.onetex;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.core.graphics.Insets;
import com.edu.onetex.latex.graphic.Graphics2D;
import com.edu.onetex.latex.icon.LaTeXIcon;
import com.lynx.tasm.behavior.PropsConstants;
import io.noties.markwon.ext.onetex.LatexMathTheme;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: LatexDrawable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\u0018\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\u0006\u0010(\u001a\u00020\u000bJ\b\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-H\u0014J\u0010\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0012\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u000102H\u0016R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "texIndex", "", PropsConstants.BACKGROUND, "padding", "Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding;", "gravity", "texIcon", "Lcom/edu/onetex/latex/icon/LaTeXIcon;", "maxWidth", "useBitmapCache", "", "latexBitmapCacheSize", "(Landroid/content/Context;ILandroid/graphics/drawable/Drawable;Lio/noties/markwon/ext/onetex/LatexMathTheme$Padding;ILcom/edu/onetex/latex/icon/LaTeXIcon;IZI)V", "additionalAlpha", "availableWidth", "", "getAvailableWidth", "()F", "setAvailableWidth", "(F)V", "g2", "Lcom/edu/onetex/latex/graphic/Graphics2D;", "iconHeight", "iconWidth", "paint", "Landroid/graphics/Paint;", "texKey", "", "addAlphaToColorWithOriginalAlpha", PropsConstants.COLOR, "draw", "", "canvas", "Landroid/graphics/Canvas;", "getIntrinsicHeight", "getIntrinsicWidth", "getLaTeXIcon", "getOpacity", "internalRealDraw", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "Companion", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class LatexDrawable extends Drawable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ImageCache imageCache = new ImageCache(5000);
    private int additionalAlpha;
    private float availableWidth;
    private final Drawable background;
    private final Graphics2D g2;
    private final int gravity;
    private final int iconHeight;
    private final int iconWidth;
    private final int latexBitmapCacheSize;
    private final int maxWidth;
    private final LatexMathTheme.Padding padding;
    private final Paint paint;
    private final LaTeXIcon texIcon;
    private final String texKey;
    private final boolean useBitmapCache;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public LatexDrawable(Context context, int i, Drawable drawable, LatexMathTheme.Padding padding, int i2, LaTeXIcon laTeXIcon, int i3, boolean z, int i4) {
        Pair pair;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(laTeXIcon, "texIcon");
        this.background = drawable;
        this.padding = padding;
        this.gravity = i2;
        this.texIcon = laTeXIcon;
        this.maxWidth = i3;
        this.useBitmapCache = z;
        this.latexBitmapCacheSize = i4;
        this.texKey = "$ texKey——>content:" + laTeXIcon.getLatexParam().getContent() + "-color:" + laTeXIcon.getLatexParam().getForegroundColor() + "-texSize:" + laTeXIcon.getLatexParam().getTextSizeSize().getSize() + "unit" + laTeXIcon.getLatexParam().getTextSizeSize().getUnit() + "-texIndex:" + i + " $";
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.paint = paint;
        this.g2 = new Graphics2D(context, (Canvas) null, 2, (DefaultConstructorMarker) null);
        this.additionalAlpha = 255;
        if (padding != null) {
            Insets of = Insets.of(padding.toRect());
            Intrinsics.checkExpressionValueIsNotNull(of, "Insets.of(it.toRect())");
            laTeXIcon.setInsets(of);
        }
        this.iconWidth = laTeXIcon.getWidth();
        this.iconHeight = laTeXIcon.getHeight();
        int width = laTeXIcon.getWidth();
        if (1 <= i3 && width > i3) {
            float width2 = i3 / laTeXIcon.getWidth();
            pair = TuplesKt.to(Float.valueOf(laTeXIcon.getWidth() * width2), Float.valueOf(laTeXIcon.getHeight() * width2));
        } else {
            pair = TuplesKt.to(Float.valueOf(laTeXIcon.getWidth()), Float.valueOf(laTeXIcon.getHeight()));
        }
        setBounds(0, 0, (int) ((Number) pair.component1()).floatValue(), (int) ((Number) pair.component2()).floatValue());
        if (!z || i4 <= 0) {
            return;
        }
        ImageCache imageCache2 = imageCache;
        if (imageCache2.maxSize() != i4) {
            imageCache2.resize(i4);
        }
    }

    /* compiled from: LatexDrawable.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/noties/markwon/ext/onetex/LatexDrawable$Companion;", "", "()V", "imageCache", "Lio/noties/markwon/ext/onetex/ImageCache;", "getImageCache", "()Lio/noties/markwon/ext/onetex/ImageCache;", "markwon-ext-onetex_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ImageCache getImageCache() {
            return LatexDrawable.imageCache;
        }
    }

    public final float getAvailableWidth() {
        return this.availableWidth;
    }

    public final void setAvailableWidth(float f) {
        this.availableWidth = f;
    }

    /* renamed from: getLaTeXIcon, reason: from getter */
    public final LaTeXIcon getTexIcon() {
        return this.texIcon;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect bounds) {
        Intrinsics.checkParameterIsNotNull(bounds, "bounds");
        super.onBoundsChange(bounds);
        Drawable drawable = this.background;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        if (!this.useBitmapCache) {
            internalRealDraw(canvas);
            return;
        }
        if (getBounds().width() <= 0 || getBounds().height() <= 0) {
            return;
        }
        ImageCache imageCache2 = imageCache;
        Bitmap bitmap = (Bitmap) imageCache2.get(this.texKey);
        if (bitmap != null && !bitmap.isRecycled()) {
            Paint paint = this.paint;
            paint.setAlpha(this.additionalAlpha);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return;
        }
        SystemClock.elapsedRealtime();
        Bitmap createBitmap = Bitmap.createBitmap(getBounds().width(), getBounds().height(), Bitmap.Config.ARGB_8888);
        internalRealDraw(new Canvas(createBitmap));
        Paint paint2 = this.paint;
        paint2.setAlpha(this.additionalAlpha);
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint2);
        imageCache2.put(this.texKey, createBitmap);
    }

    private final void internalRealDraw(Canvas canvas) {
        int i;
        int i2;
        Rect bounds = getBounds();
        Intrinsics.checkExpressionValueIsNotNull(bounds, "bounds");
        int save = canvas.save();
        try {
            Drawable drawable = this.background;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            int width = bounds.width();
            int height = bounds.height();
            float f = this.availableWidth;
            if (f > 0.0f) {
                float f2 = width;
                if (f2 > f) {
                    height = (int) ((height * f) / f2);
                    width = (int) f;
                }
            }
            int i3 = this.iconWidth;
            float coerceAtMost = (i3 <= 0 || (i2 = this.iconHeight) <= 0 || (i3 <= width && i2 <= height)) ? 1.0f : RangesKt.coerceAtMost(width / i3, height / i2);
            int i4 = (int) ((this.iconWidth * coerceAtMost) + 0.5f);
            int i5 = (height - ((int) ((this.iconHeight * coerceAtMost) + 0.5f))) / 2;
            int i6 = this.gravity;
            if (i6 != 17) {
                i = i6 != 8388613 ? 0 : width - i4;
            } else {
                i = (width - i4) / 2;
            }
            if (i5 != 0 || i != 0) {
                canvas.translate(i, i5);
            }
            if (Float.compare(coerceAtMost, 1.0f) != 0) {
                canvas.scale(coerceAtMost, coerceAtMost);
            }
            this.g2.setCanvas(canvas);
            if (this.useBitmapCache) {
                LaTeXIcon laTeXIcon = this.texIcon;
                laTeXIcon.setForeground(laTeXIcon.getLatexParam().getForegroundColor());
            } else {
                try {
                    this.texIcon.setForeground(addAlphaToColorWithOriginalAlpha(this.texIcon.getLatexParam().getForegroundColor(), this.additionalAlpha));
                } catch (Exception e) {
                    LaTeXIcon laTeXIcon2 = this.texIcon;
                    laTeXIcon2.setForeground(laTeXIcon2.getLatexParam().getForegroundColor());
                    e.printStackTrace();
                }
            }
            this.texIcon.paintIcon(this.g2, 0, 0);
            LaTexHelper.INSTANCE.onRender(this.texIcon.getLatexParam().getContent());
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.iconWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.iconHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.additionalAlpha = alpha;
    }

    private final int addAlphaToColorWithOriginalAlpha(int color, int additionalAlpha) {
        return (color & 255) | (RangesKt.coerceIn((int) ((((color >>> 24) / 255.0f) * (additionalAlpha / 255.0f)) * 255), 0, 255) << 24) | (((color >> 16) & 255) << 16) | (((color >> 8) & 255) << 8);
    }
}
