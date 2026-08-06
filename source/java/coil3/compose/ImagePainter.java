package coil3.compose;

import android.os.Trace;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import coil3.Image;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: ImagePainter.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010\u0012\u001a\u00020\u0013*\u00020\u0014H\u0014J\f\u0010\u0015\u001a\u00020\r*\u00020\u0016H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcoil3/compose/ImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "image", "Lcoil3/Image;", "<init>", "(Lcoil3/Image;)V", "getImage", "()Lcoil3/Image;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "intrinsicWidth", "", "getIntrinsicWidth", "()F", "intrinsicHeight", "getIntrinsicHeight", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "toDimension", "", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ImagePainter extends Painter {
    public static final int $stable = 8;
    private final Image image;

    private final float toDimension(int i) {
        if (i >= 0) {
            return i;
        }
        return Float.NaN;
    }

    public final Image getImage() {
        return this.image;
    }

    public ImagePainter(Image image) {
        this.image = image;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m3193getIntrinsicSizeNHjbRc() {
        return SizeKt.Size(getIntrinsicWidth(), getIntrinsicHeight());
    }

    private final float getIntrinsicWidth() {
        return toDimension(this.image.getWidth());
    }

    private final float getIntrinsicHeight() {
        return toDimension(this.image.getHeight());
    }

    protected void onDraw(DrawScope drawScope) {
        Trace.beginSection("ImagePainter.onDraw");
        try {
            this.image.draw(ImagePainter_androidKt.getNativeCanvas(drawScope.getDrawContext().getCanvas()));
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}
