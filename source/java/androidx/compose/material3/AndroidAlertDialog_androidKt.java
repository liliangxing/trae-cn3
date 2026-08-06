package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import androidx.compose.ui.window.SecureFlagPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidAlertDialog.android.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aß\u0001\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0015\b\u0002\u0010\f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\b\t2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001aB\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u001d\u001aB\u0010\u001e\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\b\tH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"ButtonsCrossAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonsMainAxisSpacing", "AlertDialog", "", "onDismissRequest", "Lkotlin/Function0;", "confirmButton", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "dismissButton", "icon", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "iconContentColor", "titleContentColor", "textContentColor", "tonalElevation", "properties", "Landroidx/compose/ui/window/DialogProperties;", "AlertDialog-Oix01E0", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJJJFLandroidx/compose/ui/window/DialogProperties;Landroidx/compose/runtime/Composer;III)V", "content", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/window/DialogProperties;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BasicAlertDialog", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AndroidAlertDialog_androidKt {
    private static final float ButtonsMainAxisSpacing = Dp.constructor-impl(8);
    private static final float ButtonsCrossAxisSpacing = Dp.constructor-impl(12);

    /* JADX WARN: Removed duplicated region for block: B:109:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01df  */
    /* renamed from: AlertDialog-Oix01E0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2196AlertDialogOix01E0(final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Shape shape, long j, long j2, long j3, long j4, float f, DialogProperties dialogProperties, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        int i7;
        int i8;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i9;
        Function2<? super Composer, ? super Integer, Unit> function27;
        Shape shape2;
        int i10;
        int i11;
        int i12;
        Function2<? super Composer, ? super Integer, Unit> function28;
        Function2<? super Composer, ? super Integer, Unit> function29;
        Function2<? super Composer, ? super Integer, Unit> function210;
        long j5;
        long j6;
        long j7;
        long j8;
        float m2184getTonalElevationD9Ej5fM;
        DialogProperties dialogProperties2;
        float f2;
        DialogProperties dialogProperties3;
        final Function2<? super Composer, ? super Integer, Unit> function211;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function212;
        final long j9;
        ScopeUpdateScope endRestartGroup;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(-2081346864);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialog)P(6!1,5,2,3,11,9,8,1:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color,10:c#ui.graphics.Color,13:c#ui.unit.Dp)85@4239L5,86@4294L14,87@4360L16,88@4429L17,89@4498L16,92@4635L1119:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
                i6 = i3 & 8;
                int i14 = Fields.CameraDistance;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 2048 : 1024;
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? Fields.Clip : Fields.Shape;
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= 196608;
                            function26 = function24;
                        } else {
                            function26 = function24;
                            if ((i & 196608) == 0) {
                                i4 |= startRestartGroup.changedInstance(function26) ? Fields.RenderEffect : 65536;
                            }
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                            function27 = function25;
                        } else {
                            function27 = function25;
                            if ((i & 1572864) == 0) {
                                i4 |= startRestartGroup.changedInstance(function27) ? 1048576 : Fields.BlendMode;
                            }
                        }
                        if ((i & 12582912) == 0) {
                            if ((i3 & Fields.SpotShadowColor) == 0) {
                                shape2 = shape;
                                if (startRestartGroup.changed(shape2)) {
                                    i13 = 8388608;
                                    i4 |= i13;
                                }
                            } else {
                                shape2 = shape;
                            }
                            i13 = 4194304;
                            i4 |= i13;
                        } else {
                            shape2 = shape;
                        }
                        if ((i & 100663296) == 0) {
                            i4 |= ((i3 & Fields.RotationX) == 0 && startRestartGroup.changed(j)) ? 67108864 : 33554432;
                        }
                        if ((805306368 & i) == 0) {
                            i4 |= ((i3 & Fields.RotationY) == 0 && startRestartGroup.changed(j2)) ? 536870912 : 268435456;
                        }
                        if ((i2 & 6) == 0) {
                            i10 = i2 | (((i3 & Fields.RotationZ) == 0 && startRestartGroup.changed(j3)) ? 4 : 2);
                        } else {
                            i10 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            i10 |= ((i3 & Fields.CameraDistance) == 0 && startRestartGroup.changed(j4)) ? 32 : 16;
                        }
                        i11 = i3 & Fields.TransformOrigin;
                        if (i11 != 0) {
                            i10 |= 384;
                        } else if ((i2 & 384) == 0) {
                            i10 |= startRestartGroup.changed(f) ? Fields.RotationX : Fields.SpotShadowColor;
                            i12 = i3 & Fields.Shape;
                            if (i12 == 0) {
                                i10 |= 3072;
                            } else if ((i2 & 3072) == 0) {
                                if (!startRestartGroup.changed(dialogProperties)) {
                                    i14 = 1024;
                                }
                                i10 |= i14;
                                if ((i4 & 306783379) != 306783378 && (i10 & 1171) == 1170 && startRestartGroup.getSkipping()) {
                                    startRestartGroup.skipToGroupEnd();
                                    function211 = function22;
                                    function212 = function23;
                                    j5 = j;
                                    j7 = j3;
                                    j8 = j4;
                                    f2 = f;
                                    dialogProperties3 = dialogProperties;
                                    modifier3 = modifier2;
                                    j9 = j2;
                                } else {
                                    startRestartGroup.startDefaults();
                                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                        if (i5 != 0) {
                                            modifier2 = Modifier.INSTANCE;
                                        }
                                        function28 = i6 != 0 ? null : function22;
                                        function29 = i7 != 0 ? null : function23;
                                        if (i8 != 0) {
                                            function26 = null;
                                        }
                                        function210 = i9 == 0 ? function27 : null;
                                        if ((i3 & Fields.SpotShadowColor) != 0) {
                                            i4 &= -29360129;
                                            shape2 = AlertDialogDefaults.INSTANCE.getShape(startRestartGroup, 6);
                                        }
                                        if ((i3 & Fields.RotationX) != 0) {
                                            j5 = AlertDialogDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                                            i4 &= -234881025;
                                        } else {
                                            j5 = j;
                                        }
                                        if ((i3 & Fields.RotationY) != 0) {
                                            j6 = AlertDialogDefaults.INSTANCE.getIconContentColor(startRestartGroup, 6);
                                            i4 &= -1879048193;
                                        } else {
                                            j6 = j2;
                                        }
                                        if ((i3 & Fields.RotationZ) != 0) {
                                            j7 = AlertDialogDefaults.INSTANCE.getTitleContentColor(startRestartGroup, 6);
                                            i10 &= -15;
                                        } else {
                                            j7 = j3;
                                        }
                                        if ((i3 & Fields.CameraDistance) != 0) {
                                            j8 = AlertDialogDefaults.INSTANCE.getTextContentColor(startRestartGroup, 6);
                                            i10 &= -113;
                                        } else {
                                            j8 = j4;
                                        }
                                        m2184getTonalElevationD9Ej5fM = i11 != 0 ? AlertDialogDefaults.INSTANCE.m2184getTonalElevationD9Ej5fM() : f;
                                        dialogProperties2 = i12 != 0 ? new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null) : dialogProperties;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i3 & Fields.SpotShadowColor) != 0) {
                                            i4 &= -29360129;
                                        }
                                        if ((i3 & Fields.RotationX) != 0) {
                                            i4 &= -234881025;
                                        }
                                        if ((i3 & Fields.RotationY) != 0) {
                                            i4 &= -1879048193;
                                        }
                                        if ((i3 & Fields.RotationZ) != 0) {
                                            i10 &= -15;
                                        }
                                        if ((i3 & Fields.CameraDistance) != 0) {
                                            i10 &= -113;
                                        }
                                        function28 = function22;
                                        function29 = function23;
                                        j5 = j;
                                        j6 = j2;
                                        j7 = j3;
                                        j8 = j4;
                                        m2184getTonalElevationD9Ej5fM = f;
                                        dialogProperties2 = dialogProperties;
                                        function210 = function27;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-2081346864, i4, i10, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:92)");
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function213 = function29;
                                    final Function2<? super Composer, ? super Integer, Unit> function214 = function26;
                                    final Function2<? super Composer, ? super Integer, Unit> function215 = function210;
                                    final Shape shape3 = shape2;
                                    final long j10 = j5;
                                    final float f3 = m2184getTonalElevationD9Ej5fM;
                                    final long j11 = j6;
                                    final long j12 = j7;
                                    final long j13 = j8;
                                    final Function2<? super Composer, ? super Integer, Unit> function216 = function28;
                                    BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i15) {
                                            ComposerKt.sourceInformation(composer2, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                                                }
                                                final Function2<Composer, Integer, Unit> function217 = function216;
                                                final Function2<Composer, Integer, Unit> function218 = function2;
                                                AlertDialogKt.m2185AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer2, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i16) {
                                                        float f4;
                                                        float f5;
                                                        ComposerKt.sourceInformation(composer3, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                                        if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                                            }
                                                            f4 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                                            f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                                            final Function2<Composer, Integer, Unit> function219 = function217;
                                                            final Function2<Composer, Integer, Unit> function220 = function218;
                                                            AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f4, f5, ComposableLambdaKt.composableLambda(composer3, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(2);
                                                                }

                                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                                    return Unit.INSTANCE;
                                                                }

                                                                public final void invoke(Composer composer4, int i17) {
                                                                    ComposerKt.sourceInformation(composer4, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                                    if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                                        }
                                                                        Function2<Composer, Integer, Unit> function221 = function219;
                                                                        composer4.startReplaceableGroup(-1969500671);
                                                                        ComposerKt.sourceInformation(composer4, "103@4991L8");
                                                                        if (function221 != null) {
                                                                            function221.invoke(composer4, 0);
                                                                            Unit unit = Unit.INSTANCE;
                                                                        }
                                                                        composer4.endReplaceableGroup();
                                                                        function220.invoke(composer4, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                            return;
                                                                        }
                                                                        return;
                                                                    }
                                                                    composer4.skipToGroupEnd();
                                                                }
                                                            }), composer3, 438);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer3.skipToGroupEnd();
                                                    }
                                                }), null, function213, function214, function215, shape3, j10, f3, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6), j11, j12, j13, composer2, 6, 0, 2);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer2.skipToGroupEnd();
                                        }
                                    }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    f2 = f3;
                                    function27 = function210;
                                    dialogProperties3 = dialogProperties2;
                                    function211 = function28;
                                    modifier3 = modifier2;
                                    function212 = function29;
                                    j9 = j6;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    final Function2<? super Composer, ? super Integer, Unit> function217 = function26;
                                    final Function2<? super Composer, ? super Integer, Unit> function218 = function27;
                                    final Shape shape4 = shape2;
                                    final long j14 = j5;
                                    final long j15 = j7;
                                    final long j16 = j8;
                                    final float f4 = f2;
                                    final DialogProperties dialogProperties4 = dialogProperties3;
                                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$2
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer2, int i15) {
                                            AndroidAlertDialog_androidKt.m2196AlertDialogOix01E0(function0, function2, modifier3, function211, function212, function217, function218, shape4, j14, j9, j15, j16, f4, dialogProperties4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            if ((i4 & 306783379) != 306783378) {
                            }
                            startRestartGroup.startDefaults();
                            if ((i & 1) != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 != 0) {
                            }
                            if (i7 != 0) {
                            }
                            if (i8 != 0) {
                            }
                            if (i9 == 0) {
                            }
                            if ((i3 & Fields.SpotShadowColor) != 0) {
                            }
                            if ((i3 & Fields.RotationX) != 0) {
                            }
                            if ((i3 & Fields.RotationY) != 0) {
                            }
                            if ((i3 & Fields.RotationZ) != 0) {
                            }
                            if ((i3 & Fields.CameraDistance) != 0) {
                            }
                            if (i11 != 0) {
                            }
                            if (i12 != 0) {
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function2132 = function29;
                            final Function2<? super Composer, ? super Integer, Unit> function2142 = function26;
                            final Function2<? super Composer, ? super Integer, Unit> function2152 = function210;
                            final Shape shape32 = shape2;
                            final long j102 = j5;
                            final float f32 = m2184getTonalElevationD9Ej5fM;
                            final long j112 = j6;
                            final long j122 = j7;
                            final long j132 = j8;
                            final Function2<? super Composer, ? super Integer, Unit> function2162 = function28;
                            BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i15) {
                                    ComposerKt.sourceInformation(composer2, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                                    if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                                        }
                                        final Function2<? super Composer, ? super Integer, Unit> function2172 = function2162;
                                        final Function2<? super Composer, ? super Integer, Unit> function2182 = function2;
                                        AlertDialogKt.m2185AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer2, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i16) {
                                                float f42;
                                                float f5;
                                                ComposerKt.sourceInformation(composer3, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                                if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                                    }
                                                    f42 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                                    f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                                    final Function2<? super Composer, ? super Integer, Unit> function219 = function2172;
                                                    final Function2<? super Composer, ? super Integer, Unit> function220 = function2182;
                                                    AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f42, f5, ComposableLambdaKt.composableLambda(composer3, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer4, int i17) {
                                                            ComposerKt.sourceInformation(composer4, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                            if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                                }
                                                                Function2<Composer, Integer, Unit> function221 = function219;
                                                                composer4.startReplaceableGroup(-1969500671);
                                                                ComposerKt.sourceInformation(composer4, "103@4991L8");
                                                                if (function221 != null) {
                                                                    function221.invoke(composer4, 0);
                                                                    Unit unit = Unit.INSTANCE;
                                                                }
                                                                composer4.endReplaceableGroup();
                                                                function220.invoke(composer4, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                    return;
                                                                }
                                                                return;
                                                            }
                                                            composer4.skipToGroupEnd();
                                                        }
                                                    }), composer3, 438);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer3.skipToGroupEnd();
                                            }
                                        }), null, function2132, function2142, function2152, shape32, j102, f32, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6), j112, j122, j132, composer2, 6, 0, 2);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            f2 = f32;
                            function27 = function210;
                            dialogProperties3 = dialogProperties2;
                            function211 = function28;
                            modifier3 = modifier2;
                            function212 = function29;
                            j9 = j6;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i12 = i3 & Fields.Shape;
                        if (i12 == 0) {
                        }
                        if ((i4 & 306783379) != 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        if (i8 != 0) {
                        }
                        if (i9 == 0) {
                        }
                        if ((i3 & Fields.SpotShadowColor) != 0) {
                        }
                        if ((i3 & Fields.RotationX) != 0) {
                        }
                        if ((i3 & Fields.RotationY) != 0) {
                        }
                        if ((i3 & Fields.RotationZ) != 0) {
                        }
                        if ((i3 & Fields.CameraDistance) != 0) {
                        }
                        if (i11 != 0) {
                        }
                        if (i12 != 0) {
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function21322 = function29;
                        final Function2<? super Composer, ? super Integer, Unit> function21422 = function26;
                        final Function2<? super Composer, ? super Integer, Unit> function21522 = function210;
                        final Shape shape322 = shape2;
                        final long j1022 = j5;
                        final float f322 = m2184getTonalElevationD9Ej5fM;
                        final long j1122 = j6;
                        final long j1222 = j7;
                        final long j1322 = j8;
                        final Function2<? super Composer, ? super Integer, Unit> function21622 = function28;
                        BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i15) {
                                ComposerKt.sourceInformation(composer2, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                                    }
                                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function21622;
                                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function2;
                                    AlertDialogKt.m2185AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer2, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i16) {
                                            float f42;
                                            float f5;
                                            ComposerKt.sourceInformation(composer3, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                            if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                                }
                                                f42 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                                f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                                final Function2<? super Composer, ? super Integer, Unit> function219 = function2172;
                                                final Function2<? super Composer, ? super Integer, Unit> function220 = function2182;
                                                AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f42, f5, ComposableLambdaKt.composableLambda(composer3, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer4, int i17) {
                                                        ComposerKt.sourceInformation(composer4, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                        if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                            }
                                                            Function2<Composer, Integer, Unit> function221 = function219;
                                                            composer4.startReplaceableGroup(-1969500671);
                                                            ComposerKt.sourceInformation(composer4, "103@4991L8");
                                                            if (function221 != null) {
                                                                function221.invoke(composer4, 0);
                                                                Unit unit = Unit.INSTANCE;
                                                            }
                                                            composer4.endReplaceableGroup();
                                                            function220.invoke(composer4, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer4.skipToGroupEnd();
                                                    }
                                                }), composer3, 438);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer3.skipToGroupEnd();
                                        }
                                    }), null, function21322, function21422, function21522, shape322, j1022, f322, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6), j1122, j1222, j1322, composer2, 6, 0, 2);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f2 = f322;
                        function27 = function210;
                        dialogProperties3 = dialogProperties2;
                        function211 = function28;
                        modifier3 = modifier2;
                        function212 = function29;
                        j9 = j6;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    if ((i & 12582912) == 0) {
                    }
                    if ((i & 100663296) == 0) {
                    }
                    if ((805306368 & i) == 0) {
                    }
                    if ((i2 & 6) == 0) {
                    }
                    if ((i2 & 48) == 0) {
                    }
                    i11 = i3 & Fields.TransformOrigin;
                    if (i11 != 0) {
                    }
                    i12 = i3 & Fields.Shape;
                    if (i12 == 0) {
                    }
                    if ((i4 & 306783379) != 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    if (i9 == 0) {
                    }
                    if ((i3 & Fields.SpotShadowColor) != 0) {
                    }
                    if ((i3 & Fields.RotationX) != 0) {
                    }
                    if ((i3 & Fields.RotationY) != 0) {
                    }
                    if ((i3 & Fields.RotationZ) != 0) {
                    }
                    if ((i3 & Fields.CameraDistance) != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function213222 = function29;
                    final Function2<? super Composer, ? super Integer, Unit> function214222 = function26;
                    final Function2<? super Composer, ? super Integer, Unit> function215222 = function210;
                    final Shape shape3222 = shape2;
                    final long j10222 = j5;
                    final float f3222 = m2184getTonalElevationD9Ej5fM;
                    final long j11222 = j6;
                    final long j12222 = j7;
                    final long j13222 = j8;
                    final Function2<? super Composer, ? super Integer, Unit> function216222 = function28;
                    BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i15) {
                            ComposerKt.sourceInformation(composer2, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                            if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function2172 = function216222;
                                final Function2<? super Composer, ? super Integer, Unit> function2182 = function2;
                                AlertDialogKt.m2185AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer2, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer3, int i16) {
                                        float f42;
                                        float f5;
                                        ComposerKt.sourceInformation(composer3, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                        if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                            }
                                            f42 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                            f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                            final Function2<? super Composer, ? super Integer, Unit> function219 = function2172;
                                            final Function2<? super Composer, ? super Integer, Unit> function220 = function2182;
                                            AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f42, f5, ComposableLambdaKt.composableLambda(composer3, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer4, int i17) {
                                                    ComposerKt.sourceInformation(composer4, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                    if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                        }
                                                        Function2<Composer, Integer, Unit> function221 = function219;
                                                        composer4.startReplaceableGroup(-1969500671);
                                                        ComposerKt.sourceInformation(composer4, "103@4991L8");
                                                        if (function221 != null) {
                                                            function221.invoke(composer4, 0);
                                                            Unit unit = Unit.INSTANCE;
                                                        }
                                                        composer4.endReplaceableGroup();
                                                        function220.invoke(composer4, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer4.skipToGroupEnd();
                                                }
                                            }), composer3, 438);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer3.skipToGroupEnd();
                                    }
                                }), null, function213222, function214222, function215222, shape3222, j10222, f3222, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6), j11222, j12222, j13222, composer2, 6, 0, 2);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f2 = f3222;
                    function27 = function210;
                    dialogProperties3 = dialogProperties2;
                    function211 = function28;
                    modifier3 = modifier2;
                    function212 = function29;
                    j9 = j6;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                if ((i & 12582912) == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                if ((805306368 & i) == 0) {
                }
                if ((i2 & 6) == 0) {
                }
                if ((i2 & 48) == 0) {
                }
                i11 = i3 & Fields.TransformOrigin;
                if (i11 != 0) {
                }
                i12 = i3 & Fields.Shape;
                if (i12 == 0) {
                }
                if ((i4 & 306783379) != 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                if (i8 != 0) {
                }
                if (i9 == 0) {
                }
                if ((i3 & Fields.SpotShadowColor) != 0) {
                }
                if ((i3 & Fields.RotationX) != 0) {
                }
                if ((i3 & Fields.RotationY) != 0) {
                }
                if ((i3 & Fields.RotationZ) != 0) {
                }
                if ((i3 & Fields.CameraDistance) != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function2132222 = function29;
                final Function2<? super Composer, ? super Integer, Unit> function2142222 = function26;
                final Function2<? super Composer, ? super Integer, Unit> function2152222 = function210;
                final Shape shape32222 = shape2;
                final long j102222 = j5;
                final float f32222 = m2184getTonalElevationD9Ej5fM;
                final long j112222 = j6;
                final long j122222 = j7;
                final long j132222 = j8;
                final Function2<? super Composer, ? super Integer, Unit> function2162222 = function28;
                BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i15) {
                        ComposerKt.sourceInformation(composer2, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                        if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                            }
                            final Function2<? super Composer, ? super Integer, Unit> function2172 = function2162222;
                            final Function2<? super Composer, ? super Integer, Unit> function2182 = function2;
                            AlertDialogKt.m2185AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer2, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i16) {
                                    float f42;
                                    float f5;
                                    ComposerKt.sourceInformation(composer3, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                    if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                        }
                                        f42 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                        f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                        final Function2<? super Composer, ? super Integer, Unit> function219 = function2172;
                                        final Function2<? super Composer, ? super Integer, Unit> function220 = function2182;
                                        AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f42, f5, ComposableLambdaKt.composableLambda(composer3, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer4, int i17) {
                                                ComposerKt.sourceInformation(composer4, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                                if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                    }
                                                    Function2<Composer, Integer, Unit> function221 = function219;
                                                    composer4.startReplaceableGroup(-1969500671);
                                                    ComposerKt.sourceInformation(composer4, "103@4991L8");
                                                    if (function221 != null) {
                                                        function221.invoke(composer4, 0);
                                                        Unit unit = Unit.INSTANCE;
                                                    }
                                                    composer4.endReplaceableGroup();
                                                    function220.invoke(composer4, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer4.skipToGroupEnd();
                                            }
                                        }), composer3, 438);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), null, function2132222, function2142222, function2152222, shape32222, j102222, f32222, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6), j112222, j122222, j132222, composer2, 6, 0, 2);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                f2 = f32222;
                function27 = function210;
                dialogProperties3 = dialogProperties2;
                function211 = function28;
                modifier3 = modifier2;
                function212 = function29;
                j9 = j6;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            modifier2 = modifier;
            i6 = i3 & 8;
            int i142 = Fields.CameraDistance;
            if (i6 != 0) {
            }
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            if ((i & 12582912) == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            if ((805306368 & i) == 0) {
            }
            if ((i2 & 6) == 0) {
            }
            if ((i2 & 48) == 0) {
            }
            i11 = i3 & Fields.TransformOrigin;
            if (i11 != 0) {
            }
            i12 = i3 & Fields.Shape;
            if (i12 == 0) {
            }
            if ((i4 & 306783379) != 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i9 == 0) {
            }
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            if ((i3 & Fields.RotationX) != 0) {
            }
            if ((i3 & Fields.RotationY) != 0) {
            }
            if ((i3 & Fields.RotationZ) != 0) {
            }
            if ((i3 & Fields.CameraDistance) != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function21322222 = function29;
            final Function2<? super Composer, ? super Integer, Unit> function21422222 = function26;
            final Function2<? super Composer, ? super Integer, Unit> function21522222 = function210;
            final Shape shape322222 = shape2;
            final long j1022222 = j5;
            final float f322222 = m2184getTonalElevationD9Ej5fM;
            final long j1122222 = j6;
            final long j1222222 = j7;
            final long j1322222 = j8;
            final Function2<? super Composer, ? super Integer, Unit> function21622222 = function28;
            BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i15) {
                    ComposerKt.sourceInformation(composer2, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                    if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function2172 = function21622222;
                        final Function2<? super Composer, ? super Integer, Unit> function2182 = function2;
                        AlertDialogKt.m2185AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer2, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i16) {
                                float f42;
                                float f5;
                                ComposerKt.sourceInformation(composer3, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                                if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                    }
                                    f42 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                    f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                    final Function2<? super Composer, ? super Integer, Unit> function219 = function2172;
                                    final Function2<? super Composer, ? super Integer, Unit> function220 = function2182;
                                    AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f42, f5, ComposableLambdaKt.composableLambda(composer3, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer4, int i17) {
                                            ComposerKt.sourceInformation(composer4, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                            if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                                }
                                                Function2<Composer, Integer, Unit> function221 = function219;
                                                composer4.startReplaceableGroup(-1969500671);
                                                ComposerKt.sourceInformation(composer4, "103@4991L8");
                                                if (function221 != null) {
                                                    function221.invoke(composer4, 0);
                                                    Unit unit = Unit.INSTANCE;
                                                }
                                                composer4.endReplaceableGroup();
                                                function220.invoke(composer4, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                    return;
                                                }
                                                return;
                                            }
                                            composer4.skipToGroupEnd();
                                        }
                                    }), composer3, 438);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), null, function21322222, function21422222, function21522222, shape322222, j1022222, f322222, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6), j1122222, j1222222, j1322222, composer2, 6, 0, 2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            f2 = f322222;
            function27 = function210;
            dialogProperties3 = dialogProperties2;
            function211 = function28;
            modifier3 = modifier2;
            function212 = function29;
            j9 = j6;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        i6 = i3 & 8;
        int i1422 = Fields.CameraDistance;
        if (i6 != 0) {
        }
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        if ((i & 12582912) == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        if ((805306368 & i) == 0) {
        }
        if ((i2 & 6) == 0) {
        }
        if ((i2 & 48) == 0) {
        }
        i11 = i3 & Fields.TransformOrigin;
        if (i11 != 0) {
        }
        i12 = i3 & Fields.Shape;
        if (i12 == 0) {
        }
        if ((i4 & 306783379) != 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i9 == 0) {
        }
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        if ((i3 & Fields.RotationX) != 0) {
        }
        if ((i3 & Fields.RotationY) != 0) {
        }
        if ((i3 & Fields.RotationZ) != 0) {
        }
        if ((i3 & Fields.CameraDistance) != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function213222222 = function29;
        final Function2<? super Composer, ? super Integer, Unit> function214222222 = function26;
        final Function2<? super Composer, ? super Integer, Unit> function215222222 = function210;
        final Shape shape3222222 = shape2;
        final long j10222222 = j5;
        final float f3222222 = m2184getTonalElevationD9Ej5fM;
        final long j11222222 = j6;
        final long j12222222 = j7;
        final long j13222222 = j8;
        final Function2<? super Composer, ? super Integer, Unit> function216222222 = function28;
        BasicAlertDialog(function0, modifier2, dialogProperties2, ComposableLambdaKt.composableLambda(startRestartGroup, 461081686, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i15) {
                ComposerKt.sourceInformation(composer2, "C117@5603L5,97@4755L997:AndroidAlertDialog.android.kt#uh7d8r");
                if ((i15 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(461081686, i15, -1, "androidx.compose.material3.AlertDialog.<anonymous> (AndroidAlertDialog.android.kt:97)");
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function2172 = function216222222;
                    final Function2<? super Composer, ? super Integer, Unit> function2182 = function2;
                    AlertDialogKt.m2185AlertDialogContent4hvqGtA(ComposableLambdaKt.composableLambda(composer2, -3244296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i16) {
                            float f42;
                            float f5;
                            ComposerKt.sourceInformation(composer3, "C99@4807L238:AndroidAlertDialog.android.kt#uh7d8r");
                            if ((i16 & 3) != 2 || !composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-3244296, i16, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:99)");
                                }
                                f42 = AndroidAlertDialog_androidKt.ButtonsMainAxisSpacing;
                                f5 = AndroidAlertDialog_androidKt.ButtonsCrossAxisSpacing;
                                final Function2<? super Composer, ? super Integer, Unit> function219 = function2172;
                                final Function2<? super Composer, ? super Integer, Unit> function220 = function2182;
                                AlertDialogKt.m2186AlertDialogFlowRowixp7dh8(f42, f5, ComposableLambdaKt.composableLambda(composer3, -909933713, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt.AlertDialog.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer4, int i17) {
                                        ComposerKt.sourceInformation(composer4, "C104@5016L15:AndroidAlertDialog.android.kt#uh7d8r");
                                        if ((i17 & 3) != 2 || !composer4.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-909933713, i17, -1, "androidx.compose.material3.AlertDialog.<anonymous>.<anonymous>.<anonymous> (AndroidAlertDialog.android.kt:103)");
                                            }
                                            Function2<Composer, Integer, Unit> function221 = function219;
                                            composer4.startReplaceableGroup(-1969500671);
                                            ComposerKt.sourceInformation(composer4, "103@4991L8");
                                            if (function221 != null) {
                                                function221.invoke(composer4, 0);
                                                Unit unit = Unit.INSTANCE;
                                            }
                                            composer4.endReplaceableGroup();
                                            function220.invoke(composer4, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer4.skipToGroupEnd();
                                    }
                                }), composer3, 438);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer3.skipToGroupEnd();
                        }
                    }), null, function213222222, function214222222, function215222222, shape3222222, j10222222, f3222222, ColorSchemeKt.getValue(DialogTokens.INSTANCE.getActionLabelTextColor(), composer2, 6), j11222222, j12222222, j13222222, composer2, 6, 0, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (i4 & 14) | 3072 | ((i4 >> 3) & 112) | ((i10 >> 3) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        f2 = f3222222;
        function27 = function210;
        dialogProperties3 = dialogProperties2;
        function211 = function28;
        modifier3 = modifier2;
        function212 = function29;
        j9 = j6;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicAlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        DialogProperties dialogProperties2;
        final Modifier modifier3;
        final DialogProperties dialogProperties3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-543157267);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicAlertDialog)P(2,1,3)156@7271L452:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                dialogProperties2 = dialogProperties;
                i3 |= startRestartGroup.changed(dialogProperties2) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? Fields.CameraDistance : Fields.RotationZ;
                }
                if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    modifier3 = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    DialogProperties dialogProperties4 = i4 != 0 ? new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null) : dialogProperties2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-543157267, i3, -1, "androidx.compose.material3.BasicAlertDialog (AndroidAlertDialog.android.kt:155)");
                    }
                    AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.composableLambda(startRestartGroup, -777289724, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            ComposerKt.sourceInformation(composer2, "C160@7401L25,164@7591L37,161@7435L282:AndroidAlertDialog.android.kt#uh7d8r");
                            if ((i6 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-777289724, i6, -1, "androidx.compose.material3.BasicAlertDialog.<anonymous> (AndroidAlertDialog.android.kt:160)");
                                }
                                Strings.Companion companion = Strings.INSTANCE;
                                final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_dialog), composer2, 0);
                                Modifier m1124sizeInqDBjuR0$default = SizeKt.m1124sizeInqDBjuR0$default(Modifier.this, AlertDialogKt.getDialogMinWidth(), 0.0f, AlertDialogKt.getDialogMaxWidth(), 0.0f, 10, null);
                                Modifier.Companion companion2 = Modifier.INSTANCE;
                                composer2.startReplaceableGroup(-874813489);
                                ComposerKt.sourceInformation(composer2, "CC(remember):AndroidAlertDialog.android.kt#9igjgp");
                                boolean changed = composer2.changed(m3033getStringNWtq28);
                                Object rememberedValue = composer2.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((SemanticsPropertyReceiver) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq28);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue);
                                }
                                composer2.endReplaceableGroup();
                                Modifier then = m1124sizeInqDBjuR0$default.then(SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue, 1, (Object) null));
                                Function2<Composer, Integer, Unit> function22 = function2;
                                composer2.startReplaceableGroup(733328855);
                                ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                                composer2.startReplaceableGroup(-1323940314);
                                ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                                if (!(composer2.getApplier() instanceof Applier)) {
                                    ComposablesKt.invalidApplier();
                                }
                                composer2.startReusableNode();
                                if (composer2.getInserting()) {
                                    composer2.createNode(constructor);
                                } else {
                                    composer2.useNode();
                                }
                                Composer m4109constructorimpl = Updater.m4109constructorimpl(composer2);
                                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                }
                                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                                composer2.startReplaceableGroup(2058660585);
                                ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(composer2, -1196659109, "C167@7698L9:AndroidAlertDialog.android.kt#uh7d8r");
                                function22.invoke(composer2, 0);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                ComposerKt.sourceInformationMarkerEnd(composer2);
                                composer2.endReplaceableGroup();
                                composer2.endNode();
                                composer2.endReplaceableGroup();
                                composer2.endReplaceableGroup();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties3 = dialogProperties4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    dialogProperties3 = dialogProperties2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            AndroidAlertDialog_androidKt.BasicAlertDialog(function0, modifier4, dialogProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            dialogProperties2 = dialogProperties;
            if ((i2 & 8) != 0) {
            }
            if ((i3 & 1171) == 1170) {
            }
            if (i5 != 0) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.composableLambda(startRestartGroup, -777289724, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    ComposerKt.sourceInformation(composer2, "C160@7401L25,164@7591L37,161@7435L282:AndroidAlertDialog.android.kt#uh7d8r");
                    if ((i6 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-777289724, i6, -1, "androidx.compose.material3.BasicAlertDialog.<anonymous> (AndroidAlertDialog.android.kt:160)");
                        }
                        Strings.Companion companion = Strings.INSTANCE;
                        final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_dialog), composer2, 0);
                        Modifier m1124sizeInqDBjuR0$default = SizeKt.m1124sizeInqDBjuR0$default(Modifier.this, AlertDialogKt.getDialogMinWidth(), 0.0f, AlertDialogKt.getDialogMaxWidth(), 0.0f, 10, null);
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        composer2.startReplaceableGroup(-874813489);
                        ComposerKt.sourceInformation(composer2, "CC(remember):AndroidAlertDialog.android.kt#9igjgp");
                        boolean changed = composer2.changed(m3033getStringNWtq28);
                        Object rememberedValue = composer2.rememberedValue();
                        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((SemanticsPropertyReceiver) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq28);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        composer2.endReplaceableGroup();
                        Modifier then = m1124sizeInqDBjuR0$default.then(SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue, 1, (Object) null));
                        Function2<Composer, Integer, Unit> function22 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer2.useNode();
                        }
                        Composer m4109constructorimpl = Updater.m4109constructorimpl(composer2);
                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -1196659109, "C167@7698L9:AndroidAlertDialog.android.kt#uh7d8r");
                        function22.invoke(composer2, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceableGroup();
                        composer2.endNode();
                        composer2.endReplaceableGroup();
                        composer2.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            dialogProperties3 = dialogProperties4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        dialogProperties2 = dialogProperties;
        if ((i2 & 8) != 0) {
        }
        if ((i3 & 1171) == 1170) {
        }
        if (i5 != 0) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        AndroidDialog_androidKt.Dialog(function0, dialogProperties4, ComposableLambdaKt.composableLambda(startRestartGroup, -777289724, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i6) {
                ComposerKt.sourceInformation(composer2, "C160@7401L25,164@7591L37,161@7435L282:AndroidAlertDialog.android.kt#uh7d8r");
                if ((i6 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-777289724, i6, -1, "androidx.compose.material3.BasicAlertDialog.<anonymous> (AndroidAlertDialog.android.kt:160)");
                    }
                    Strings.Companion companion = Strings.INSTANCE;
                    final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_dialog), composer2, 0);
                    Modifier m1124sizeInqDBjuR0$default = SizeKt.m1124sizeInqDBjuR0$default(Modifier.this, AlertDialogKt.getDialogMinWidth(), 0.0f, AlertDialogKt.getDialogMaxWidth(), 0.0f, 10, null);
                    Modifier.Companion companion2 = Modifier.INSTANCE;
                    composer2.startReplaceableGroup(-874813489);
                    ComposerKt.sourceInformation(composer2, "CC(remember):AndroidAlertDialog.android.kt#9igjgp");
                    boolean changed = composer2.changed(m3033getStringNWtq28);
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$BasicAlertDialog$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, m3033getStringNWtq28);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    Modifier then = m1124sizeInqDBjuR0$default.then(SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue, 1, (Object) null));
                    Function2<Composer, Integer, Unit> function22 = function2;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composer2, 48);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(then);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer m4109constructorimpl = Updater.m4109constructorimpl(composer2);
                    Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -1196659109, "C167@7698L9:AndroidAlertDialog.android.kt#uh7d8r");
                    function22.invoke(composer2, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (i3 & 14) | 384 | ((i3 >> 3) & 112), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        dialogProperties3 = dialogProperties4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0051  */
    @Deprecated(message = "Use BasicAlertDialog instead", replaceWith = @ReplaceWith(expression = "BasicAlertDialog(onDismissRequest, modifier, properties, content)", imports = {}))
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void AlertDialog(final Function0<Unit> function0, Modifier modifier, DialogProperties dialogProperties, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        DialogProperties dialogProperties2;
        Modifier.Companion companion;
        final DialogProperties dialogProperties3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(63450171);
        ComposerKt.sourceInformation(startRestartGroup, "C(AlertDialog)P(2,1,3)209@9397L65:AndroidAlertDialog.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                dialogProperties2 = dialogProperties;
                i3 |= startRestartGroup.changed(dialogProperties2) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i2 & 8) != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    i3 |= startRestartGroup.changedInstance(function2) ? Fields.CameraDistance : Fields.RotationZ;
                }
                if ((i3 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                    companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                    DialogProperties dialogProperties4 = i4 != 0 ? new DialogProperties(false, false, (SecureFlagPolicy) null, 7, (DefaultConstructorMarker) null) : dialogProperties2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(63450171, i3, -1, "androidx.compose.material3.AlertDialog (AndroidAlertDialog.android.kt:209)");
                    }
                    BasicAlertDialog(function0, companion, dialogProperties4, function2, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    dialogProperties3 = dialogProperties4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    dialogProperties3 = dialogProperties2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier3 = companion;
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AndroidAlertDialog_androidKt$AlertDialog$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i6) {
                            AndroidAlertDialog_androidKt.AlertDialog(function0, modifier3, dialogProperties3, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            dialogProperties2 = dialogProperties;
            if ((i2 & 8) != 0) {
            }
            if ((i3 & 1171) == 1170) {
            }
            if (i5 != 0) {
            }
            if (i4 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            BasicAlertDialog(function0, companion, dialogProperties4, function2, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            dialogProperties3 = dialogProperties4;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        dialogProperties2 = dialogProperties;
        if ((i2 & 8) != 0) {
        }
        if ((i3 & 1171) == 1170) {
        }
        if (i5 != 0) {
        }
        if (i4 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        BasicAlertDialog(function0, companion, dialogProperties4, function2, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        dialogProperties3 = dialogProperties4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
