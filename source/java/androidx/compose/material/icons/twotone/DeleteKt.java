package androidx.compose.material.icons.twotone;

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

/* compiled from: Delete.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_delete", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Delete", "Landroidx/compose/material/icons/Icons$TwoTone;", "getDelete", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DeleteKt {
    private static ImageVector _delete;

    public static final ImageVector getDelete(Icons.TwoTone twoTone) {
        ImageVector.Builder m5575addPathoIyEayM;
        ImageVector imageVector = _delete;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Delete", Dp.constructor-impl(24.0f), Dp.constructor-impl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null);
        int m5211getButtKaPHkGw = StrokeCap.INSTANCE.m5211getButtKaPHkGw();
        int m5221getBevelLxFBmk8 = StrokeJoin.INSTANCE.m5221getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(8.0f, 9.0f);
        pathBuilder.horizontalLineToRelative(8.0f);
        pathBuilder.verticalLineToRelative(10.0f);
        pathBuilder.horizontalLineTo(8.0f);
        pathBuilder.close();
        builder.m5575addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 0.3f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 0.3f, (r30 & Fields.SpotShadowColor) != 0 ? 0.0f : 1.0f, (r30 & Fields.RotationX) != 0 ? VectorKt.getDefaultStrokeLineCap() : m5211getButtKaPHkGw, (r30 & Fields.RotationY) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m5221getBevelLxFBmk8, (r30 & Fields.RotationZ) != 0 ? 4.0f : 1.0f, (r30 & Fields.CameraDistance) != 0 ? 0.0f : 0.0f, (r30 & Fields.TransformOrigin) == 0 ? 0.0f : 1.0f, (r30 & Fields.Shape) == 0 ? 0.0f : 0.0f);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null);
        int m5211getButtKaPHkGw2 = StrokeCap.INSTANCE.m5211getButtKaPHkGw();
        int m5221getBevelLxFBmk82 = StrokeJoin.INSTANCE.m5221getBevelLxFBmk8();
        PathBuilder pathBuilder2 = new PathBuilder();
        pathBuilder2.moveTo(15.5f, 4.0f);
        pathBuilder2.lineToRelative(-1.0f, -1.0f);
        pathBuilder2.horizontalLineToRelative(-5.0f);
        pathBuilder2.lineToRelative(-1.0f, 1.0f);
        pathBuilder2.horizontalLineTo(5.0f);
        pathBuilder2.verticalLineToRelative(2.0f);
        pathBuilder2.horizontalLineToRelative(14.0f);
        pathBuilder2.verticalLineTo(4.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(6.0f, 19.0f);
        pathBuilder2.curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f);
        pathBuilder2.horizontalLineToRelative(8.0f);
        pathBuilder2.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilder2.verticalLineTo(7.0f);
        pathBuilder2.horizontalLineTo(6.0f);
        pathBuilder2.verticalLineToRelative(12.0f);
        pathBuilder2.close();
        pathBuilder2.moveTo(8.0f, 9.0f);
        pathBuilder2.horizontalLineToRelative(8.0f);
        pathBuilder2.verticalLineToRelative(10.0f);
        pathBuilder2.horizontalLineTo(8.0f);
        pathBuilder2.verticalLineTo(9.0f);
        pathBuilder2.close();
        m5575addPathoIyEayM = builder.m5575addPathoIyEayM(pathBuilder2.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType2, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor2, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & Fields.SpotShadowColor) != 0 ? 0.0f : 1.0f, (r30 & Fields.RotationX) != 0 ? VectorKt.getDefaultStrokeLineCap() : m5211getButtKaPHkGw2, (r30 & Fields.RotationY) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m5221getBevelLxFBmk82, (r30 & Fields.RotationZ) != 0 ? 4.0f : 1.0f, (r30 & Fields.CameraDistance) != 0 ? 0.0f : 0.0f, (r30 & Fields.TransformOrigin) == 0 ? 0.0f : 1.0f, (r30 & Fields.Shape) == 0 ? 0.0f : 0.0f);
        ImageVector build = m5575addPathoIyEayM.build();
        _delete = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
