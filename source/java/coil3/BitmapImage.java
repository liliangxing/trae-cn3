package coil3;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import coil3.util.BitmapsKt;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Image.android.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0004j\u0002`\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u00060\u001cj\u0002`\u001bH\u0016¢\u0006\u0002\u0010\u001dR\u0017\u0010\u0002\u001a\u00060\u0004j\u0002`\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcoil3/BitmapImage;", "Lcoil3/Image;", "bitmap", "Lcoil3/Bitmap;", "Landroid/graphics/Bitmap;", "shareable", "", "<init>", "(Landroid/graphics/Bitmap;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "getShareable", "()Z", "size", "", "getSize", "()J", "width", "", "getWidth", "()I", "height", "getHeight", WebViewContainer.EVENT_draw, "", "canvas", "Lcoil3/Canvas;", "Landroid/graphics/Canvas;", "(Landroid/graphics/Canvas;)V", "coil-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BitmapImage implements Image {
    private final Bitmap bitmap;
    private final boolean shareable;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BitmapImage)) {
            return false;
        }
        BitmapImage bitmapImage = (BitmapImage) obj;
        return Intrinsics.areEqual(this.bitmap, bitmapImage.bitmap) && this.shareable == bitmapImage.shareable;
    }

    public int hashCode() {
        return (this.bitmap.hashCode() * 31) + Boolean.hashCode(this.shareable);
    }

    public String toString() {
        return "BitmapImage(bitmap=" + this.bitmap + ", shareable=" + this.shareable + ')';
    }

    public BitmapImage(Bitmap bitmap, boolean z) {
        this.bitmap = bitmap;
        this.shareable = z;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    @Override // coil3.Image
    public boolean getShareable() {
        return this.shareable;
    }

    @Override // coil3.Image
    public long getSize() {
        return BitmapsKt.getAllocationByteCountCompat(this.bitmap);
    }

    @Override // coil3.Image
    public int getWidth() {
        return this.bitmap.getWidth();
    }

    @Override // coil3.Image
    public int getHeight() {
        return this.bitmap.getHeight();
    }

    @Override // coil3.Image
    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.bitmap, 0.0f, 0.0f, (Paint) null);
    }
}
