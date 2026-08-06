package coil3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;

/* compiled from: Image.android.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001b\u0010\u0004\u001a\u00020\u0005*\u00060\u0001j\u0002`\u00062\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u00060\u0001j\u0002`\u0006*\u00020\u000b¢\u0006\u0002\u0010\f\u001a+\u0010\r\u001a\u00060\u0001j\u0002`\u0006*\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013\u001a\n\u0010\u0004\u001a\u00020\u000b*\u00020\u0014\u001a\u0012\u0010\u0004\u001a\u00020\u000b*\u00020\u00142\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\u0015\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017*\n\u0010\u0000\"\u00020\u00012\u00020\u0001*\n\u0010\u0002\"\u00020\u00032\u00020\u0003¨\u0006\u0018"}, d2 = {"Bitmap", "Landroid/graphics/Bitmap;", "Canvas", "Landroid/graphics/Canvas;", "asImage", "Lcoil3/BitmapImage;", "Lcoil3/Bitmap;", "shareable", "", "(Landroid/graphics/Bitmap;Z)Lcoil3/BitmapImage;", "toBitmap", "Lcoil3/Image;", "(Lcoil3/Image;)Landroid/graphics/Bitmap;", "toBitmapReal", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "(Lcoil3/Image;IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;", "Landroid/graphics/drawable/Drawable;", "asDrawable", "resources", "Landroid/content/res/Resources;", "coil-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Image_androidKt {
    public static final BitmapImage asImage(Bitmap bitmap, boolean z) {
        return new BitmapImage(bitmap, true);
    }

    public static final Bitmap toBitmap(Image image) {
        return toBitmapReal(image, image.getWidth(), image.getHeight(), Bitmap.Config.ARGB_8888);
    }

    public static final Bitmap toBitmapReal(Image image, int i, int i2, Bitmap.Config config) {
        if (image instanceof BitmapImage) {
            BitmapImage bitmapImage = (BitmapImage) image;
            if (bitmapImage.getBitmap().getWidth() == i && bitmapImage.getBitmap().getHeight() == i2 && bitmapImage.getBitmap().getConfig() == config) {
                return bitmapImage.getBitmap();
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        image.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static final Image asImage(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return asImage(((BitmapDrawable) drawable).getBitmap(), true);
        }
        return new DrawableImage(drawable, false);
    }

    public static final Image asImage(Drawable drawable, boolean z) {
        if (drawable instanceof BitmapDrawable) {
            return asImage(((BitmapDrawable) drawable).getBitmap(), z);
        }
        return new DrawableImage(drawable, z);
    }

    public static final Drawable asDrawable(Image image, Resources resources) {
        return image instanceof DrawableImage ? ((DrawableImage) image).getDrawable() : image instanceof BitmapImage ? new BitmapDrawable(resources, ((BitmapImage) image).getBitmap()) : new ImageDrawable(image);
    }
}
