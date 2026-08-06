package androidx.compose.p001ui.text.platform.style;

import android.graphics.Paint;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;

/* compiled from: DrawStyleSpan.android.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"toAndroidJoin", "Landroid/graphics/Paint$Join;", "Landroidx/compose/ui/graphics/StrokeJoin;", "toAndroidJoin-Ww9F2mQ", "(I)Landroid/graphics/Paint$Join;", "toAndroidCap", "Landroid/graphics/Paint$Cap;", "Landroidx/compose/ui/graphics/StrokeCap;", "toAndroidCap-BeK7IIE", "(I)Landroid/graphics/Paint$Cap;", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class DrawStyleSpan_androidKt {
    /* renamed from: toAndroidJoin-Ww9F2mQ, reason: not valid java name */
    public static final Paint.Join m2418toAndroidJoinWw9F2mQ(int i) {
        return StrokeJoin.equals-impl0(i, StrokeJoin.Companion.getMiter-LxFBmk8()) ? Paint.Join.MITER : StrokeJoin.equals-impl0(i, StrokeJoin.Companion.getRound-LxFBmk8()) ? Paint.Join.ROUND : StrokeJoin.equals-impl0(i, StrokeJoin.Companion.getBevel-LxFBmk8()) ? Paint.Join.BEVEL : Paint.Join.MITER;
    }

    /* renamed from: toAndroidCap-BeK7IIE, reason: not valid java name */
    public static final Paint.Cap m2417toAndroidCapBeK7IIE(int i) {
        return StrokeCap.equals-impl0(i, StrokeCap.Companion.getButt-KaPHkGw()) ? Paint.Cap.BUTT : StrokeCap.equals-impl0(i, StrokeCap.Companion.getRound-KaPHkGw()) ? Paint.Cap.ROUND : StrokeCap.equals-impl0(i, StrokeCap.Companion.getSquare-KaPHkGw()) ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
    }
}
