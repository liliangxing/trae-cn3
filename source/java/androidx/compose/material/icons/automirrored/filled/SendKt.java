package androidx.compose.material.icons.automirrored.filled;

import androidx.compose.material.icons.Icons;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.SolidColor;
import androidx.compose.p002ui.graphics.StrokeCap;
import androidx.compose.p002ui.graphics.StrokeJoin;
import androidx.compose.p002ui.graphics.vector.ImageVector;
import androidx.compose.p002ui.graphics.vector.PathBuilder;
import androidx.compose.p002ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Send.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_send", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Send", "Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;", "getSend", "(Landroidx/compose/material/icons/Icons$AutoMirrored$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SendKt {
    private static ImageVector _send;

    public static final ImageVector getSend(Icons.AutoMirrored.Filled filled) {
        ImageVector.Builder m5575addPathoIyEayM;
        ImageVector imageVector = _send;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("AutoMirrored.Filled.Send", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, true, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null);
        int m5211getButtKaPHkGw = StrokeCap.INSTANCE.m5211getButtKaPHkGw();
        int m5221getBevelLxFBmk8 = StrokeJoin.INSTANCE.m5221getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(2.01f, 21.0f);
        pathBuilder.lineTo(23.0f, 12.0f);
        pathBuilder.lineTo(2.01f, 3.0f);
        pathBuilder.lineTo(2.0f, 10.0f);
        pathBuilder.lineToRelative(15.0f, 2.0f);
        pathBuilder.lineToRelative(-15.0f, 2.0f);
        pathBuilder.close();
        m5575addPathoIyEayM = builder.m5575addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & Fields.SpotShadowColor) != 0 ? 0.0f : 1.0f, (r30 & Fields.RotationX) != 0 ? VectorKt.getDefaultStrokeLineCap() : m5211getButtKaPHkGw, (r30 & Fields.RotationY) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m5221getBevelLxFBmk8, (r30 & Fields.RotationZ) != 0 ? 4.0f : 1.0f, (r30 & Fields.CameraDistance) != 0 ? 0.0f : 0.0f, (r30 & Fields.TransformOrigin) == 0 ? 0.0f : 1.0f, (r30 & Fields.Shape) == 0 ? 0.0f : 0.0f);
        ImageVector build = m5575addPathoIyEayM.build();
        _send = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
