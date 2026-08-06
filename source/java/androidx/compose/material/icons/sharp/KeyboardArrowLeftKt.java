package androidx.compose.material.icons.sharp;

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
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KeyboardArrowLeft.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_keyboardArrowLeft", "Landroidx/compose/ui/graphics/vector/ImageVector;", "KeyboardArrowLeft", "Landroidx/compose/material/icons/Icons$Sharp;", "getKeyboardArrowLeft$annotations", "(Landroidx/compose/material/icons/Icons$Sharp;)V", "getKeyboardArrowLeft", "(Landroidx/compose/material/icons/Icons$Sharp;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class KeyboardArrowLeftKt {
    private static ImageVector _keyboardArrowLeft;

    @Deprecated(message = "Use the AutoMirrored version at Icons.AutoMirrored.Sharp.KeyboardArrowLeft", replaceWith = @ReplaceWith(expression = "Icons.AutoMirrored.Sharp.KeyboardArrowLeft", imports = {"androidx.compose.material.icons.automirrored.sharp.KeyboardArrowLeft"}))
    public static /* synthetic */ void getKeyboardArrowLeft$annotations(Icons.Sharp sharp) {
    }

    public static final ImageVector getKeyboardArrowLeft(Icons.Sharp sharp) {
        ImageVector.Builder m5575addPathoIyEayM;
        ImageVector imageVector = _keyboardArrowLeft;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Sharp.KeyboardArrowLeft", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null);
        int m5211getButtKaPHkGw = StrokeCap.INSTANCE.m5211getButtKaPHkGw();
        int m5221getBevelLxFBmk8 = StrokeJoin.INSTANCE.m5221getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(15.41f, 16.59f);
        pathBuilder.lineTo(10.83f, 12.0f);
        pathBuilder.lineToRelative(4.58f, -4.59f);
        pathBuilder.lineTo(14.0f, 6.0f);
        pathBuilder.lineToRelative(-6.0f, 6.0f);
        pathBuilder.lineToRelative(6.0f, 6.0f);
        pathBuilder.lineToRelative(1.41f, -1.41f);
        pathBuilder.close();
        m5575addPathoIyEayM = builder.m5575addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & Fields.SpotShadowColor) != 0 ? 0.0f : 1.0f, (r30 & Fields.RotationX) != 0 ? VectorKt.getDefaultStrokeLineCap() : m5211getButtKaPHkGw, (r30 & Fields.RotationY) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m5221getBevelLxFBmk8, (r30 & Fields.RotationZ) != 0 ? 4.0f : 1.0f, (r30 & Fields.CameraDistance) != 0 ? 0.0f : 0.0f, (r30 & Fields.TransformOrigin) == 0 ? 0.0f : 1.0f, (r30 & Fields.Shape) == 0 ? 0.0f : 0.0f);
        ImageVector build = m5575addPathoIyEayM.build();
        _keyboardArrowLeft = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
