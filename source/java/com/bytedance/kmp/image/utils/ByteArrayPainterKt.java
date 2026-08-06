package com.bytedance.kmp.image.utils;

import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayPainter.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"byteArrayPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "byteArray", "", "kmpimage_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ByteArrayPainterKt {
    public static final Painter byteArrayPainter(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "byteArray");
        if (bArr.length == 0) {
            System.out.println((Object) "byteArray is Empty");
            return EmptyPainter.INSTANCE;
        }
        return new BitmapPainter(ByteArrayPainter_androidKt.byteArrayToImageBitmap(bArr), 0L, 0L, 6, (DefaultConstructorMarker) null);
    }
}
