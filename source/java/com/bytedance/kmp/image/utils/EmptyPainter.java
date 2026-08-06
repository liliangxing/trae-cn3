package com.bytedance.kmp.image.utils;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayPainter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0014R\u001a\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\n"}, d2 = {"Lcom/bytedance/kmp/image/utils/EmptyPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "()V", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EmptyPainter extends Painter {
    public static final EmptyPainter INSTANCE = new EmptyPainter();
    public static final int $stable = 8;

    protected void onDraw(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
    }

    private EmptyPainter() {
    }

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m675getIntrinsicSizeNHjbRc() {
        return Size.Companion.getUnspecified-NH-jbRc();
    }
}
