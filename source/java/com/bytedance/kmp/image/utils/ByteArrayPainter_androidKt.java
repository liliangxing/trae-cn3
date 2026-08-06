package com.bytedance.kmp.image.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ImageBitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayPainter.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"byteArrayToImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "byteArray", "", "kmpimage_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteArrayPainter_androidKt {
    public static final ImageBitmap byteArrayToImageBitmap(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        Intrinsics.checkNotNullExpressionValue(decodeByteArray, "decodeByteArray(byteArray, 0, byteArray.size)");
        return AndroidImageBitmap_androidKt.asImageBitmap(decodeByteArray);
    }
}
