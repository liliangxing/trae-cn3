package com.bytedance.kmp.image.options;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImagePlaceholder.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\f\u0010\u0013\u001a\u00020\u0010*\u00020\u0011H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0014"}, d2 = {"Lcom/bytedance/kmp/image/options/PlaceholderScalePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "realPainter", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/layout/ContentScale;)V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "computeDrawSize", "srcSize", "dstSize", "computeDrawSize-x8L_9b0", "(JJ)J", "drawPainter", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "painter", "onDraw", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PlaceholderScalePainter extends Painter {
    public static final int $stable = 8;
    private final ContentScale contentScale;
    private final Painter realPainter;

    public PlaceholderScalePainter(Painter painter, ContentScale contentScale) {
        Intrinsics.checkNotNullParameter(painter, "realPainter");
        Intrinsics.checkNotNullParameter(contentScale, "contentScale");
        this.realPainter = painter;
        this.contentScale = contentScale;
    }

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m668getIntrinsicSizeNHjbRc() {
        return this.realPainter.getIntrinsicSize-NH-jbRc();
    }

    protected void onDraw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        drawPainter(drawScope, this.realPainter);
    }

    private final void drawPainter(DrawScope drawScope, Painter painter) {
        if (painter == null) {
            return;
        }
        long j = drawScope.getSize-NH-jbRc();
        long m667computeDrawSizex8L_9b0 = m667computeDrawSizex8L_9b0(painter.getIntrinsicSize-NH-jbRc(), j);
        if ((j == 9205357640488583168L) || Size.isEmpty-impl(j)) {
            Painter.draw-x_KDEd0$default(painter, drawScope, m667computeDrawSizex8L_9b0, 0.0f, (ColorFilter) null, 6, (Object) null);
            return;
        }
        float f = 2;
        float intBitsToFloat = (Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (m667computeDrawSizex8L_9b0 >> 32))) / f;
        float intBitsToFloat2 = (Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (4294967295L & m667computeDrawSizex8L_9b0))) / f;
        drawScope.getDrawContext().getTransform().inset(intBitsToFloat, intBitsToFloat2, intBitsToFloat, intBitsToFloat2);
        try {
            Painter.draw-x_KDEd0$default(painter, drawScope, m667computeDrawSizex8L_9b0, 0.0f, (ColorFilter) null, 6, (Object) null);
        } finally {
            float f2 = -intBitsToFloat;
            float f3 = -intBitsToFloat2;
            drawScope.getDrawContext().getTransform().inset(f2, f3, f2, f3);
        }
    }

    /* renamed from: computeDrawSize-x8L_9b0, reason: not valid java name */
    private final long m667computeDrawSizex8L_9b0(long srcSize, long dstSize) {
        if (!(srcSize == 9205357640488583168L) && !Size.isEmpty-impl(srcSize)) {
            if (!(dstSize == 9205357640488583168L) && !Size.isEmpty-impl(dstSize)) {
                return ScaleFactorKt.times-UQTWf7w(srcSize, this.contentScale.computeScaleFactor-H7hwNQA(srcSize, dstSize));
            }
        }
        return dstSize;
    }
}
