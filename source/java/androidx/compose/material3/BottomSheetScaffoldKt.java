package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.Strings;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.layout.SubcomposeLayoutKt;
import androidx.compose.p002ui.layout.SubcomposeMeasureScope;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001a\u008a\u0002\u0010\u0000\u001a\u00020\u00012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u0019\b\u0002\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u001aÀ\u0001\u0010\"\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052&\u0010#\u001a\"\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052&\u0010'\u001a\"\u0012\u0013\u0012\u00110(¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u00052\u0006\u0010\u000b\u001a\u00020\f2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00162\u0006\u0010,\u001a\u00020-2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0003ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a¶\u0001\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020-2'\u00102\u001a#\u0012\u0013\u0012\u001103¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(4\u0012\n\u0012\b\u0012\u0004\u0012\u000206050\u00032\u0006\u00107\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020\f2\u0013\u0010;\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0016¢\u0006\u0002\b\u00052\u001c\u0010\u001e\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006H\u0003ø\u0001\u0000¢\u0006\u0004\b<\u0010=\u001a!\u0010>\u001a\u00020\n2\b\b\u0002\u0010?\u001a\u00020-2\b\b\u0002\u0010@\u001a\u00020\u001bH\u0007¢\u0006\u0002\u0010A\u001a7\u0010B\u001a\u00020-2\b\b\u0002\u0010C\u001a\u0002062\u0014\b\u0002\u0010D\u001a\u000e\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0002\u0010E\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010F\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material3/BottomSheetScaffoldState;", "sheetPeekHeight", "Landroidx/compose/ui/unit/Dp;", "sheetMaxWidth", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetContainerColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "sheetDragHandle", "Lkotlin/Function0;", "sheetSwipeEnabled", "", "topBar", "snackbarHost", "Landroidx/compose/material3/SnackbarHostState;", "containerColor", "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-sdMYb0k", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "", "sheetState", "Landroidx/compose/material3/SheetState;", "BottomSheetScaffoldLayout-PxNyym8", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;FLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "StandardBottomSheet", "state", "calculateAnchors", "Landroidx/compose/ui/unit/IntSize;", "sheetSize", "Landroidx/compose/material3/DraggableAnchors;", "Landroidx/compose/material3/SheetValue;", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-XcniZvE", "(Landroidx/compose/material3/SheetState;Lkotlin/jvm/functions/Function1;FFZLandroidx/compose/ui/graphics/Shape;JJFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "rememberBottomSheetScaffoldState", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "rememberStandardBottomSheetState", "initialValue", "confirmValueChange", "skipHiddenState", "(Landroidx/compose/material3/SheetValue;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BottomSheetScaffoldKt {
    /* JADX WARN: Removed duplicated region for block: B:102:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02f8  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* renamed from: BottomSheetScaffold-sdMYb0k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2229BottomSheetScaffoldsdMYb0k(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, BottomSheetScaffoldState bottomSheetScaffoldState, float f, float f2, Shape shape, long j, long j2, float f3, float f4, Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function2<? super Composer, ? super Integer, Unit> function22, Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, long j3, long j4, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function33, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        Modifier modifier2;
        BottomSheetScaffoldState bottomSheetScaffoldState2;
        float m2227getSheetMaxWidthD9Ej5fM;
        BottomSheetScaffoldState bottomSheetScaffoldState3;
        int i14;
        Shape shape2;
        int i15;
        long j5;
        long j6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i16;
        long j7;
        Modifier modifier3;
        long j8;
        long j9;
        int i17;
        int i18;
        float f5;
        Function2<? super Composer, ? super Integer, Unit> function24;
        boolean z2;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function34;
        final BottomSheetScaffoldState bottomSheetScaffoldState4;
        float f6;
        float f7;
        long j10;
        Shape shape3;
        Modifier modifier4;
        boolean z3;
        Object rememberedValue;
        final Shape shape4;
        final float f8;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final boolean z4;
        final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function35;
        final float f9;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        final long j11;
        final long j12;
        final long j13;
        final BottomSheetScaffoldState bottomSheetScaffoldState5;
        final float f10;
        final float f11;
        final Modifier modifier5;
        final long j14;
        ScopeUpdateScope endRestartGroup;
        int i19;
        int i20;
        Composer startRestartGroup = composer.startRestartGroup(-1523924135);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffold)P(6,3,4,10:c#ui.unit.Dp,9:c#ui.unit.Dp,12,5:c#ui.graphics.Color,7:c#ui.graphics.Color,14:c#ui.unit.Dp,11:c#ui.unit.Dp,8,13,16,15,0:c#ui.graphics.Color,2:c#ui.graphics.Color)103@5431L34,106@5633L13,107@5701L14,108@5748L36,115@6205L11,116@6252L31,*119@6379L7,130@6700L50,122@6436L1811:BottomSheetScaffold.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changedInstance(function3) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i21 = i3 & 2;
        if (i21 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i & 384) == 0) {
                if ((i3 & 4) == 0 && startRestartGroup.changed(bottomSheetScaffoldState)) {
                    i20 = Fields.RotationX;
                    i4 |= i20;
                }
                i20 = Fields.SpotShadowColor;
                i4 |= i20;
            }
            i5 = i3 & 8;
            int i22 = Fields.CameraDistance;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(f) ? 2048 : 1024;
                i6 = i3 & 16;
                int i23 = Fields.Shape;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changed(f2) ? 16384 : 8192;
                    if ((i & 196608) == 0) {
                        i4 |= ((i3 & 32) == 0 && startRestartGroup.changed(shape)) ? Fields.RenderEffect : 65536;
                    }
                    if ((i & 1572864) == 0) {
                        i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(j)) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i & 12582912) == 0) {
                        if ((i3 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(j2)) {
                            i19 = 8388608;
                            i4 |= i19;
                        }
                        i19 = 4194304;
                        i4 |= i19;
                    }
                    i7 = i3 & Fields.RotationX;
                    if (i7 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
                    }
                    i8 = i3 & Fields.RotationY;
                    if (i8 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i4 |= startRestartGroup.changed(f4) ? 536870912 : 268435456;
                    }
                    i9 = i3 & Fields.RotationZ;
                    if (i9 == 0) {
                        i10 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i10 = i2 | (startRestartGroup.changedInstance(function2) ? 4 : 2);
                    } else {
                        i10 = i2;
                    }
                    i11 = i3 & Fields.CameraDistance;
                    if (i11 == 0) {
                        i10 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i10 |= startRestartGroup.changed(z) ? 32 : 16;
                    }
                    int i24 = i10;
                    i12 = i3 & Fields.TransformOrigin;
                    if (i12 == 0) {
                        i24 |= 384;
                    } else if ((i2 & 384) == 0) {
                        i24 |= startRestartGroup.changedInstance(function22) ? Fields.RotationX : Fields.SpotShadowColor;
                        i13 = i3 & Fields.Shape;
                        if (i13 != 0) {
                            i24 |= 3072;
                        } else if ((i2 & 3072) == 0) {
                            if (!startRestartGroup.changedInstance(function32)) {
                                i22 = 1024;
                            }
                            i24 |= i22;
                            if ((i2 & 24576) == 0) {
                                if ((i3 & Fields.Clip) == 0 && startRestartGroup.changed(j3)) {
                                    i23 = 16384;
                                }
                                i24 |= i23;
                            }
                            if ((i2 & 196608) == 0) {
                                i24 |= ((i3 & Fields.CompositingStrategy) == 0 && startRestartGroup.changed(j4)) ? Fields.RenderEffect : 65536;
                            }
                            if ((i3 & 65536) == 0) {
                                i24 |= 1572864;
                            } else if ((i2 & 1572864) == 0) {
                                i24 |= startRestartGroup.changedInstance(function33) ? 1048576 : Fields.BlendMode;
                            }
                            if ((i4 & 306783379) == 306783378 || (599187 & i24) != 599186 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    Modifier.Companion companion = i21 == 0 ? Modifier.INSTANCE : modifier;
                                    if ((i3 & 4) == 0) {
                                        modifier2 = companion;
                                        bottomSheetScaffoldState2 = rememberBottomSheetScaffoldState(null, null, startRestartGroup, 0, 3);
                                        i4 &= -897;
                                    } else {
                                        modifier2 = companion;
                                        bottomSheetScaffoldState2 = bottomSheetScaffoldState;
                                    }
                                    float m2228getSheetPeekHeightD9Ej5fM = i5 == 0 ? BottomSheetDefaults.INSTANCE.m2228getSheetPeekHeightD9Ej5fM() : f;
                                    m2227getSheetMaxWidthD9Ej5fM = i6 == 0 ? BottomSheetDefaults.INSTANCE.m2227getSheetMaxWidthD9Ej5fM() : f2;
                                    if ((i3 & 32) == 0) {
                                        bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                                        i14 = 6;
                                        shape2 = BottomSheetDefaults.INSTANCE.getExpandedShape(startRestartGroup, 6);
                                        i4 &= -458753;
                                    } else {
                                        bottomSheetScaffoldState3 = bottomSheetScaffoldState2;
                                        i14 = 6;
                                        shape2 = shape;
                                    }
                                    float f12 = m2228getSheetPeekHeightD9Ej5fM;
                                    if ((i3 & 64) == 0) {
                                        i15 = i4 & (-3670017);
                                        j5 = BottomSheetDefaults.INSTANCE.getContainerColor(startRestartGroup, i14);
                                    } else {
                                        i15 = i4;
                                        j5 = j;
                                    }
                                    Shape shape5 = shape2;
                                    if ((i3 & Fields.SpotShadowColor) == 0) {
                                        j6 = ColorSchemeKt.m2381contentColorForek8zF_U(j5, startRestartGroup, (i15 >> 18) & 14);
                                        i15 &= -29360129;
                                    } else {
                                        j6 = j2;
                                    }
                                    float m2226getElevationD9Ej5fM = i7 == 0 ? BottomSheetDefaults.INSTANCE.m2226getElevationD9Ej5fM() : f3;
                                    float m2226getElevationD9Ej5fM2 = i8 == 0 ? BottomSheetDefaults.INSTANCE.m2226getElevationD9Ej5fM() : f4;
                                    Function2<? super Composer, ? super Integer, Unit> m2405getLambda1$material3_release = i9 == 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m2405getLambda1$material3_release() : function2;
                                    boolean z5 = i11 == 0 ? true : z;
                                    function23 = i12 == 0 ? null : function22;
                                    Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> m2406getLambda2$material3_release = i13 == 0 ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m2406getLambda2$material3_release() : function32;
                                    if ((i3 & Fields.Clip) == 0) {
                                        i16 = i24 & (-57345);
                                        j7 = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6).getSurface();
                                    } else {
                                        i16 = i24;
                                        j7 = j3;
                                    }
                                    if ((i3 & Fields.CompositingStrategy) == 0) {
                                        float f13 = m2226getElevationD9Ej5fM;
                                        long m2381contentColorForek8zF_U = ColorSchemeKt.m2381contentColorForek8zF_U(j7, startRestartGroup, (i16 >> 12) & 14);
                                        i18 = (-458753) & i16;
                                        function34 = m2406getLambda2$material3_release;
                                        i17 = i15;
                                        j8 = m2381contentColorForek8zF_U;
                                        modifier3 = modifier2;
                                        f7 = f13;
                                        z2 = z5;
                                        j9 = j7;
                                        f5 = m2226getElevationD9Ej5fM2;
                                        function24 = m2405getLambda1$material3_release;
                                        j10 = j5;
                                        bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
                                        f6 = f12;
                                    } else {
                                        float f14 = m2226getElevationD9Ej5fM;
                                        modifier3 = modifier2;
                                        j8 = j4;
                                        j9 = j7;
                                        i17 = i15;
                                        i18 = i16;
                                        f5 = m2226getElevationD9Ej5fM2;
                                        function24 = m2405getLambda1$material3_release;
                                        z2 = z5;
                                        function34 = m2406getLambda2$material3_release;
                                        bottomSheetScaffoldState4 = bottomSheetScaffoldState3;
                                        f6 = f12;
                                        f7 = f14;
                                        j10 = j5;
                                    }
                                    shape3 = shape5;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 4) != 0) {
                                        i4 &= -897;
                                    }
                                    if ((i3 & 32) != 0) {
                                        i4 &= -458753;
                                    }
                                    if ((i3 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & Fields.SpotShadowColor) != 0) {
                                        i4 &= -29360129;
                                    }
                                    if ((i3 & Fields.Clip) != 0) {
                                        i24 &= -57345;
                                    }
                                    if ((i3 & Fields.CompositingStrategy) != 0) {
                                        i24 &= -458753;
                                    }
                                    modifier3 = modifier;
                                    bottomSheetScaffoldState4 = bottomSheetScaffoldState;
                                    f6 = f;
                                    m2227getSheetMaxWidthD9Ej5fM = f2;
                                    j10 = j;
                                    j6 = j2;
                                    f7 = f3;
                                    function24 = function2;
                                    z2 = z;
                                    function23 = function22;
                                    function34 = function32;
                                    j9 = j3;
                                    j8 = j4;
                                    i17 = i4;
                                    i18 = i24;
                                    shape3 = shape;
                                    f5 = f4;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    modifier4 = modifier3;
                                } else {
                                    modifier4 = modifier3;
                                    ComposerKt.traceEventStart(-1523924135, i17, i18, "androidx.compose.material3.BottomSheetScaffold (BottomSheetScaffold.kt:118)");
                                }
                                ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                int i25 = i18;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final int i26 = ((Density) consume).roundToPx-0680j_4(f6);
                                SheetState bottomSheetState = bottomSheetScaffoldState4.getBottomSheetState();
                                final BottomSheetScaffoldState bottomSheetScaffoldState6 = bottomSheetScaffoldState4;
                                final float f15 = f6;
                                final float f16 = m2227getSheetMaxWidthD9Ej5fM;
                                final boolean z6 = z2;
                                final Shape shape6 = shape3;
                                final long j15 = j10;
                                final long j16 = j6;
                                final float f17 = f7;
                                final float f18 = f5;
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function24;
                                Shape shape7 = shape3;
                                z3 = true;
                                ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(final int i27, Composer composer2, int i28) {
                                        int i29;
                                        ComposerKt.sourceInformation(composer2, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                                        if ((i28 & 6) == 0) {
                                            i29 = i28 | (composer2.changed(i27) ? 4 : 2);
                                        } else {
                                            i29 = i28;
                                        }
                                        if ((i29 & 19) != 18 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-680109608, i29, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                                            }
                                            SheetState bottomSheetState2 = BottomSheetScaffoldState.this.getBottomSheetState();
                                            composer2.startReplaceableGroup(1237684821);
                                            ComposerKt.sourceInformation(composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                                            boolean changed = ((i29 & 14) == 4) | composer2.changed(BottomSheetScaffoldState.this) | composer2.changed(i26);
                                            final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                            final int i30 = i26;
                                            Object rememberedValue2 = composer2.rememberedValue();
                                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        return m2234invokeozmzZPI(((IntSize) obj).unbox-impl());
                                                    }

                                                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                                    public final DraggableAnchors<SheetValue> m2234invokeozmzZPI(long j17) {
                                                        final int i31 = IntSize.getHeight-impl(j17);
                                                        final BottomSheetScaffoldState bottomSheetScaffoldState8 = BottomSheetScaffoldState.this;
                                                        final int i32 = i27;
                                                        final int i33 = i30;
                                                        return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                                invoke((DraggableAnchorsConfig<SheetValue>) obj);
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                                if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                                    draggableAnchorsConfig.m48at(SheetValue.PartiallyExpanded, i32 - i33);
                                                                }
                                                                if (i31 != i33) {
                                                                    draggableAnchorsConfig.m48at(SheetValue.Expanded, Math.max(i32 - i31, 0));
                                                                }
                                                                if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                                                    return;
                                                                }
                                                                draggableAnchorsConfig.m48at(SheetValue.Hidden, i32);
                                                            }
                                                        });
                                                    }
                                                };
                                                composer2.updateRememberedValue(rememberedValue2);
                                            }
                                            composer2.endReplaceableGroup();
                                            BottomSheetScaffoldKt.m2231StandardBottomSheetXcniZvE(bottomSheetState2, (Function1) rememberedValue2, f15, f16, z6, shape6, j15, j16, f17, f18, function27, function3, composer2, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                });
                                long j17 = j10;
                                ComposableLambda composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                                    public final void invoke(Composer composer2, int i27) {
                                        ComposerKt.sourceInformation(composer2, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                                        if ((i27 & 3) == 2 && composer2.getSkipping()) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(88659390, i27, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                                        }
                                        function34.invoke(bottomSheetScaffoldState4.getSnackbarHostState(), composer2, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                });
                                startRestartGroup.startReplaceableGroup(-1567544379);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                                if ((((i17 & 896) ^ 384) > 256 || !startRestartGroup.changed(bottomSheetScaffoldState4)) && (i17 & 384) != 256) {
                                    z3 = false;
                                }
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z3 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        {
                                            super(0);
                                        }

                                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                        public final Float m2235invoke() {
                                            return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                Function0 function0 = (Function0) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                int i27 = ((i17 >> 3) & 14) | 27648 | ((i25 >> 3) & 112) | ((i25 >> 12) & 896) | ((i17 << 6) & 458752);
                                int i28 = i25 << 12;
                                m2230BottomSheetScaffoldLayoutPxNyym8(modifier4, function23, function33, composableLambda, composableLambda2, f6, function0, bottomSheetState, j9, j8, startRestartGroup, i27 | (234881024 & i28) | (i28 & 1879048192));
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                shape4 = shape7;
                                f8 = f6;
                                function25 = function24;
                                z4 = z2;
                                function35 = function34;
                                f9 = m2227getSheetMaxWidthD9Ej5fM;
                                function26 = function23;
                                j11 = j6;
                                j12 = j9;
                                j13 = j8;
                                bottomSheetScaffoldState5 = bottomSheetScaffoldState4;
                                f10 = f7;
                                f11 = f5;
                                modifier5 = modifier4;
                                j14 = j17;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier5 = modifier;
                                bottomSheetScaffoldState5 = bottomSheetScaffoldState;
                                f8 = f;
                                f9 = f2;
                                shape4 = shape;
                                j14 = j;
                                j11 = j2;
                                f10 = f3;
                                f11 = f4;
                                function25 = function2;
                                z4 = z;
                                function26 = function22;
                                function35 = function32;
                                j12 = j3;
                                j13 = j4;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$4
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

                                    public final void invoke(Composer composer2, int i29) {
                                        BottomSheetScaffoldKt.m2229BottomSheetScaffoldsdMYb0k(function3, modifier5, bottomSheetScaffoldState5, f8, f9, shape4, j14, j11, f10, f11, function25, z4, function26, function35, j12, j13, function33, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        if ((i2 & 196608) == 0) {
                        }
                        if ((i3 & 65536) == 0) {
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i21 == 0) {
                        }
                        if ((i3 & 4) == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if ((i3 & 32) == 0) {
                        }
                        float f122 = m2228getSheetPeekHeightD9Ej5fM;
                        if ((i3 & 64) == 0) {
                        }
                        Shape shape52 = shape2;
                        if ((i3 & Fields.SpotShadowColor) == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if ((i3 & Fields.Clip) == 0) {
                        }
                        if ((i3 & Fields.CompositingStrategy) == 0) {
                        }
                        shape3 = shape52;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
                        int i252 = i18;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume2 = startRestartGroup.consume(localDensity2);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        final int i262 = ((Density) consume2).roundToPx-0680j_4(f6);
                        SheetState bottomSheetState2 = bottomSheetScaffoldState4.getBottomSheetState();
                        final BottomSheetScaffoldState bottomSheetScaffoldState62 = bottomSheetScaffoldState4;
                        final float f152 = f6;
                        final float f162 = m2227getSheetMaxWidthD9Ej5fM;
                        final boolean z62 = z2;
                        final Shape shape62 = shape3;
                        final long j152 = j10;
                        final long j162 = j6;
                        final float f172 = f7;
                        final float f182 = f5;
                        final Function2<? super Composer, ? super Integer, Unit> function272 = function24;
                        Shape shape72 = shape3;
                        z3 = true;
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(3);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(final int i272, Composer composer2, int i282) {
                                int i29;
                                ComposerKt.sourceInformation(composer2, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                                if ((i282 & 6) == 0) {
                                    i29 = i282 | (composer2.changed(i272) ? 4 : 2);
                                } else {
                                    i29 = i282;
                                }
                                if ((i29 & 19) != 18 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-680109608, i29, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                                    }
                                    SheetState bottomSheetState22 = BottomSheetScaffoldState.this.getBottomSheetState();
                                    composer2.startReplaceableGroup(1237684821);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                                    boolean changed = ((i29 & 14) == 4) | composer2.changed(BottomSheetScaffoldState.this) | composer2.changed(i262);
                                    final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                    final int i30 = i262;
                                    Object rememberedValue2 = composer2.rememberedValue();
                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                return m2234invokeozmzZPI(((IntSize) obj).unbox-impl());
                                            }

                                            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                            public final DraggableAnchors<SheetValue> m2234invokeozmzZPI(long j172) {
                                                final int i31 = IntSize.getHeight-impl(j172);
                                                final BottomSheetScaffoldState bottomSheetScaffoldState8 = BottomSheetScaffoldState.this;
                                                final int i32 = i272;
                                                final int i33 = i30;
                                                return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        invoke((DraggableAnchorsConfig<SheetValue>) obj);
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                        if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                            draggableAnchorsConfig.m48at(SheetValue.PartiallyExpanded, i32 - i33);
                                                        }
                                                        if (i31 != i33) {
                                                            draggableAnchorsConfig.m48at(SheetValue.Expanded, Math.max(i32 - i31, 0));
                                                        }
                                                        if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                                            return;
                                                        }
                                                        draggableAnchorsConfig.m48at(SheetValue.Hidden, i32);
                                                    }
                                                });
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue2);
                                    }
                                    composer2.endReplaceableGroup();
                                    BottomSheetScaffoldKt.m2231StandardBottomSheetXcniZvE(bottomSheetState22, (Function1) rememberedValue2, f152, f162, z62, shape62, j152, j162, f172, f182, function272, function3, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        });
                        long j172 = j10;
                        ComposableLambda composableLambda22 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                            public final void invoke(Composer composer2, int i272) {
                                ComposerKt.sourceInformation(composer2, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                                if ((i272 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(88659390, i272, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                                }
                                function34.invoke(bottomSheetScaffoldState4.getSnackbarHostState(), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        });
                        startRestartGroup.startReplaceableGroup(-1567544379);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                        if (((i17 & 896) ^ 384) > 256) {
                        }
                        z3 = false;
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z3) {
                        }
                        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(0);
                            }

                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Float m2235invoke() {
                                return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        Function0 function02 = (Function0) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        int i272 = ((i17 >> 3) & 14) | 27648 | ((i252 >> 3) & 112) | ((i252 >> 12) & 896) | ((i17 << 6) & 458752);
                        int i282 = i252 << 12;
                        m2230BottomSheetScaffoldLayoutPxNyym8(modifier4, function23, function33, composableLambda3, composableLambda22, f6, function02, bottomSheetState2, j9, j8, startRestartGroup, i272 | (234881024 & i282) | (i282 & 1879048192));
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        shape4 = shape72;
                        f8 = f6;
                        function25 = function24;
                        z4 = z2;
                        function35 = function34;
                        f9 = m2227getSheetMaxWidthD9Ej5fM;
                        function26 = function23;
                        j11 = j6;
                        j12 = j9;
                        j13 = j8;
                        bottomSheetScaffoldState5 = bottomSheetScaffoldState4;
                        f10 = f7;
                        f11 = f5;
                        modifier5 = modifier4;
                        j14 = j172;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i13 = i3 & Fields.Shape;
                    if (i13 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & 196608) == 0) {
                    }
                    if ((i3 & 65536) == 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i21 == 0) {
                    }
                    if ((i3 & 4) == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if ((i3 & 32) == 0) {
                    }
                    float f1222 = m2228getSheetPeekHeightD9Ej5fM;
                    if ((i3 & 64) == 0) {
                    }
                    Shape shape522 = shape2;
                    if ((i3 & Fields.SpotShadowColor) == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if ((i3 & Fields.Clip) == 0) {
                    }
                    if ((i3 & Fields.CompositingStrategy) == 0) {
                    }
                    shape3 = shape522;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    ProvidableCompositionLocal localDensity22 = CompositionLocalsKt.getLocalDensity();
                    int i2522 = i18;
                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    Object consume22 = startRestartGroup.consume(localDensity22);
                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                    final int i2622 = ((Density) consume22).roundToPx-0680j_4(f6);
                    SheetState bottomSheetState22 = bottomSheetScaffoldState4.getBottomSheetState();
                    final BottomSheetScaffoldState bottomSheetScaffoldState622 = bottomSheetScaffoldState4;
                    final float f1522 = f6;
                    final float f1622 = m2227getSheetMaxWidthD9Ej5fM;
                    final boolean z622 = z2;
                    final Shape shape622 = shape3;
                    final long j1522 = j10;
                    final long j1622 = j6;
                    final float f1722 = f7;
                    final float f1822 = f5;
                    final Function2<? super Composer, ? super Integer, Unit> function2722 = function24;
                    Shape shape722 = shape3;
                    z3 = true;
                    ComposableLambda composableLambda32 = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(final int i2722, Composer composer2, int i2822) {
                            int i29;
                            ComposerKt.sourceInformation(composer2, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                            if ((i2822 & 6) == 0) {
                                i29 = i2822 | (composer2.changed(i2722) ? 4 : 2);
                            } else {
                                i29 = i2822;
                            }
                            if ((i29 & 19) != 18 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-680109608, i29, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                                }
                                SheetState bottomSheetState222 = BottomSheetScaffoldState.this.getBottomSheetState();
                                composer2.startReplaceableGroup(1237684821);
                                ComposerKt.sourceInformation(composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                                boolean changed = ((i29 & 14) == 4) | composer2.changed(BottomSheetScaffoldState.this) | composer2.changed(i2622);
                                final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                                final int i30 = i2622;
                                Object rememberedValue2 = composer2.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            return m2234invokeozmzZPI(((IntSize) obj).unbox-impl());
                                        }

                                        /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                        public final DraggableAnchors<SheetValue> m2234invokeozmzZPI(long j1722) {
                                            final int i31 = IntSize.getHeight-impl(j1722);
                                            final BottomSheetScaffoldState bottomSheetScaffoldState8 = BottomSheetScaffoldState.this;
                                            final int i32 = i2722;
                                            final int i33 = i30;
                                            return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    invoke((DraggableAnchorsConfig<SheetValue>) obj);
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                    if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                        draggableAnchorsConfig.m48at(SheetValue.PartiallyExpanded, i32 - i33);
                                                    }
                                                    if (i31 != i33) {
                                                        draggableAnchorsConfig.m48at(SheetValue.Expanded, Math.max(i32 - i31, 0));
                                                    }
                                                    if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                                        return;
                                                    }
                                                    draggableAnchorsConfig.m48at(SheetValue.Hidden, i32);
                                                }
                                            });
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue2);
                                }
                                composer2.endReplaceableGroup();
                                BottomSheetScaffoldKt.m2231StandardBottomSheetXcniZvE(bottomSheetState222, (Function1) rememberedValue2, f1522, f1622, z622, shape622, j1522, j1622, f1722, f1822, function2722, function3, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                    long j1722 = j10;
                    ComposableLambda composableLambda222 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                        public final void invoke(Composer composer2, int i2722) {
                            ComposerKt.sourceInformation(composer2, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                            if ((i2722 & 3) == 2 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(88659390, i2722, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                            }
                            function34.invoke(bottomSheetScaffoldState4.getSnackbarHostState(), composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    });
                    startRestartGroup.startReplaceableGroup(-1567544379);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                    if (((i17 & 896) ^ 384) > 256) {
                    }
                    z3 = false;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z3) {
                    }
                    rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(0);
                        }

                        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                        public final Float m2235invoke() {
                            return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    Function0 function022 = (Function0) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    int i2722 = ((i17 >> 3) & 14) | 27648 | ((i2522 >> 3) & 112) | ((i2522 >> 12) & 896) | ((i17 << 6) & 458752);
                    int i2822 = i2522 << 12;
                    m2230BottomSheetScaffoldLayoutPxNyym8(modifier4, function23, function33, composableLambda32, composableLambda222, f6, function022, bottomSheetState22, j9, j8, startRestartGroup, i2722 | (234881024 & i2822) | (i2822 & 1879048192));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    shape4 = shape722;
                    f8 = f6;
                    function25 = function24;
                    z4 = z2;
                    function35 = function34;
                    f9 = m2227getSheetMaxWidthD9Ej5fM;
                    function26 = function23;
                    j11 = j6;
                    j12 = j9;
                    j13 = j8;
                    bottomSheetScaffoldState5 = bottomSheetScaffoldState4;
                    f10 = f7;
                    f11 = f5;
                    modifier5 = modifier4;
                    j14 = j1722;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i & 196608) == 0) {
                }
                if ((i & 1572864) == 0) {
                }
                if ((i & 12582912) == 0) {
                }
                i7 = i3 & Fields.RotationX;
                if (i7 == 0) {
                }
                i8 = i3 & Fields.RotationY;
                if (i8 == 0) {
                }
                i9 = i3 & Fields.RotationZ;
                if (i9 == 0) {
                }
                i11 = i3 & Fields.CameraDistance;
                if (i11 == 0) {
                }
                int i242 = i10;
                i12 = i3 & Fields.TransformOrigin;
                if (i12 == 0) {
                }
                i13 = i3 & Fields.Shape;
                if (i13 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & 196608) == 0) {
                }
                if ((i3 & 65536) == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i21 == 0) {
                }
                if ((i3 & 4) == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if ((i3 & 32) == 0) {
                }
                float f12222 = m2228getSheetPeekHeightD9Ej5fM;
                if ((i3 & 64) == 0) {
                }
                Shape shape5222 = shape2;
                if ((i3 & Fields.SpotShadowColor) == 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i11 == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                if ((i3 & Fields.Clip) == 0) {
                }
                if ((i3 & Fields.CompositingStrategy) == 0) {
                }
                shape3 = shape5222;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                ProvidableCompositionLocal localDensity222 = CompositionLocalsKt.getLocalDensity();
                int i25222 = i18;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume222 = startRestartGroup.consume(localDensity222);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                final int i26222 = ((Density) consume222).roundToPx-0680j_4(f6);
                SheetState bottomSheetState222 = bottomSheetScaffoldState4.getBottomSheetState();
                final BottomSheetScaffoldState bottomSheetScaffoldState6222 = bottomSheetScaffoldState4;
                final float f15222 = f6;
                final float f16222 = m2227getSheetMaxWidthD9Ej5fM;
                final boolean z6222 = z2;
                final Shape shape6222 = shape3;
                final long j15222 = j10;
                final long j16222 = j6;
                final float f17222 = f7;
                final float f18222 = f5;
                final Function2<? super Composer, ? super Integer, Unit> function27222 = function24;
                Shape shape7222 = shape3;
                z3 = true;
                ComposableLambda composableLambda322 = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(final int i27222, Composer composer2, int i28222) {
                        int i29;
                        ComposerKt.sourceInformation(composer2, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                        if ((i28222 & 6) == 0) {
                            i29 = i28222 | (composer2.changed(i27222) ? 4 : 2);
                        } else {
                            i29 = i28222;
                        }
                        if ((i29 & 19) != 18 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-680109608, i29, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                            }
                            SheetState bottomSheetState2222 = BottomSheetScaffoldState.this.getBottomSheetState();
                            composer2.startReplaceableGroup(1237684821);
                            ComposerKt.sourceInformation(composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                            boolean changed = ((i29 & 14) == 4) | composer2.changed(BottomSheetScaffoldState.this) | composer2.changed(i26222);
                            final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                            final int i30 = i26222;
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        return m2234invokeozmzZPI(((IntSize) obj).unbox-impl());
                                    }

                                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                    public final DraggableAnchors<SheetValue> m2234invokeozmzZPI(long j17222) {
                                        final int i31 = IntSize.getHeight-impl(j17222);
                                        final BottomSheetScaffoldState bottomSheetScaffoldState8 = BottomSheetScaffoldState.this;
                                        final int i32 = i27222;
                                        final int i33 = i30;
                                        return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((DraggableAnchorsConfig<SheetValue>) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                                if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                    draggableAnchorsConfig.m48at(SheetValue.PartiallyExpanded, i32 - i33);
                                                }
                                                if (i31 != i33) {
                                                    draggableAnchorsConfig.m48at(SheetValue.Expanded, Math.max(i32 - i31, 0));
                                                }
                                                if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                                    return;
                                                }
                                                draggableAnchorsConfig.m48at(SheetValue.Hidden, i32);
                                            }
                                        });
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            composer2.endReplaceableGroup();
                            BottomSheetScaffoldKt.m2231StandardBottomSheetXcniZvE(bottomSheetState2222, (Function1) rememberedValue2, f15222, f16222, z6222, shape6222, j15222, j16222, f17222, f18222, function27222, function3, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                long j17222 = j10;
                ComposableLambda composableLambda2222 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                    public final void invoke(Composer composer2, int i27222) {
                        ComposerKt.sourceInformation(composer2, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                        if ((i27222 & 3) == 2 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(88659390, i27222, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                        }
                        function34.invoke(bottomSheetScaffoldState4.getSnackbarHostState(), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                });
                startRestartGroup.startReplaceableGroup(-1567544379);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                if (((i17 & 896) ^ 384) > 256) {
                }
                z3 = false;
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z3) {
                }
                rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Float m2235invoke() {
                        return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
                Function0 function0222 = (Function0) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                int i27222 = ((i17 >> 3) & 14) | 27648 | ((i25222 >> 3) & 112) | ((i25222 >> 12) & 896) | ((i17 << 6) & 458752);
                int i28222 = i25222 << 12;
                m2230BottomSheetScaffoldLayoutPxNyym8(modifier4, function23, function33, composableLambda322, composableLambda2222, f6, function0222, bottomSheetState222, j9, j8, startRestartGroup, i27222 | (234881024 & i28222) | (i28222 & 1879048192));
                if (ComposerKt.isTraceInProgress()) {
                }
                shape4 = shape7222;
                f8 = f6;
                function25 = function24;
                z4 = z2;
                function35 = function34;
                f9 = m2227getSheetMaxWidthD9Ej5fM;
                function26 = function23;
                j11 = j6;
                j12 = j9;
                j13 = j8;
                bottomSheetScaffoldState5 = bottomSheetScaffoldState4;
                f10 = f7;
                f11 = f5;
                modifier5 = modifier4;
                j14 = j17222;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i6 = i3 & 16;
            int i232 = Fields.Shape;
            if (i6 != 0) {
            }
            if ((i & 196608) == 0) {
            }
            if ((i & 1572864) == 0) {
            }
            if ((i & 12582912) == 0) {
            }
            i7 = i3 & Fields.RotationX;
            if (i7 == 0) {
            }
            i8 = i3 & Fields.RotationY;
            if (i8 == 0) {
            }
            i9 = i3 & Fields.RotationZ;
            if (i9 == 0) {
            }
            i11 = i3 & Fields.CameraDistance;
            if (i11 == 0) {
            }
            int i2422 = i10;
            i12 = i3 & Fields.TransformOrigin;
            if (i12 == 0) {
            }
            i13 = i3 & Fields.Shape;
            if (i13 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & 196608) == 0) {
            }
            if ((i3 & 65536) == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i21 == 0) {
            }
            if ((i3 & 4) == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if ((i3 & 32) == 0) {
            }
            float f122222 = m2228getSheetPeekHeightD9Ej5fM;
            if ((i3 & 64) == 0) {
            }
            Shape shape52222 = shape2;
            if ((i3 & Fields.SpotShadowColor) == 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i11 == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            if ((i3 & Fields.Clip) == 0) {
            }
            if ((i3 & Fields.CompositingStrategy) == 0) {
            }
            shape3 = shape52222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            ProvidableCompositionLocal localDensity2222 = CompositionLocalsKt.getLocalDensity();
            int i252222 = i18;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume2222 = startRestartGroup.consume(localDensity2222);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final int i262222 = ((Density) consume2222).roundToPx-0680j_4(f6);
            SheetState bottomSheetState2222 = bottomSheetScaffoldState4.getBottomSheetState();
            final BottomSheetScaffoldState bottomSheetScaffoldState62222 = bottomSheetScaffoldState4;
            final float f152222 = f6;
            final float f162222 = m2227getSheetMaxWidthD9Ej5fM;
            final boolean z62222 = z2;
            final Shape shape62222 = shape3;
            final long j152222 = j10;
            final long j162222 = j6;
            final float f172222 = f7;
            final float f182222 = f5;
            final Function2<? super Composer, ? super Integer, Unit> function272222 = function24;
            Shape shape72222 = shape3;
            z3 = true;
            ComposableLambda composableLambda3222 = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final int i272222, Composer composer2, int i282222) {
                    int i29;
                    ComposerKt.sourceInformation(composer2, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                    if ((i282222 & 6) == 0) {
                        i29 = i282222 | (composer2.changed(i272222) ? 4 : 2);
                    } else {
                        i29 = i282222;
                    }
                    if ((i29 & 19) != 18 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-680109608, i29, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                        }
                        SheetState bottomSheetState22222 = BottomSheetScaffoldState.this.getBottomSheetState();
                        composer2.startReplaceableGroup(1237684821);
                        ComposerKt.sourceInformation(composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                        boolean changed = ((i29 & 14) == 4) | composer2.changed(BottomSheetScaffoldState.this) | composer2.changed(i262222);
                        final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                        final int i30 = i262222;
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return m2234invokeozmzZPI(((IntSize) obj).unbox-impl());
                                }

                                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final DraggableAnchors<SheetValue> m2234invokeozmzZPI(long j172222) {
                                    final int i31 = IntSize.getHeight-impl(j172222);
                                    final BottomSheetScaffoldState bottomSheetScaffoldState8 = BottomSheetScaffoldState.this;
                                    final int i32 = i272222;
                                    final int i33 = i30;
                                    return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((DraggableAnchorsConfig<SheetValue>) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                            if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                                draggableAnchorsConfig.m48at(SheetValue.PartiallyExpanded, i32 - i33);
                                            }
                                            if (i31 != i33) {
                                                draggableAnchorsConfig.m48at(SheetValue.Expanded, Math.max(i32 - i31, 0));
                                            }
                                            if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                                return;
                                            }
                                            draggableAnchorsConfig.m48at(SheetValue.Hidden, i32);
                                        }
                                    });
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        composer2.endReplaceableGroup();
                        BottomSheetScaffoldKt.m2231StandardBottomSheetXcniZvE(bottomSheetState22222, (Function1) rememberedValue2, f152222, f162222, z62222, shape62222, j152222, j162222, f172222, f182222, function272222, function3, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            long j172222 = j10;
            ComposableLambda composableLambda22222 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

                public final void invoke(Composer composer2, int i272222) {
                    ComposerKt.sourceInformation(composer2, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                    if ((i272222 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(88659390, i272222, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                    }
                    function34.invoke(bottomSheetScaffoldState4.getSnackbarHostState(), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            });
            startRestartGroup.startReplaceableGroup(-1567544379);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            if (((i17 & 896) ^ 384) > 256) {
            }
            z3 = false;
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z3) {
            }
            rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Float m2235invoke() {
                    return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            Function0 function02222 = (Function0) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            int i272222 = ((i17 >> 3) & 14) | 27648 | ((i252222 >> 3) & 112) | ((i252222 >> 12) & 896) | ((i17 << 6) & 458752);
            int i282222 = i252222 << 12;
            m2230BottomSheetScaffoldLayoutPxNyym8(modifier4, function23, function33, composableLambda3222, composableLambda22222, f6, function02222, bottomSheetState2222, j9, j8, startRestartGroup, i272222 | (234881024 & i282222) | (i282222 & 1879048192));
            if (ComposerKt.isTraceInProgress()) {
            }
            shape4 = shape72222;
            f8 = f6;
            function25 = function24;
            z4 = z2;
            function35 = function34;
            f9 = m2227getSheetMaxWidthD9Ej5fM;
            function26 = function23;
            j11 = j6;
            j12 = j9;
            j13 = j8;
            bottomSheetScaffoldState5 = bottomSheetScaffoldState4;
            f10 = f7;
            f11 = f5;
            modifier5 = modifier4;
            j14 = j172222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i & 384) == 0) {
        }
        i5 = i3 & 8;
        int i222 = Fields.CameraDistance;
        if (i5 == 0) {
        }
        i6 = i3 & 16;
        int i2322 = Fields.Shape;
        if (i6 != 0) {
        }
        if ((i & 196608) == 0) {
        }
        if ((i & 1572864) == 0) {
        }
        if ((i & 12582912) == 0) {
        }
        i7 = i3 & Fields.RotationX;
        if (i7 == 0) {
        }
        i8 = i3 & Fields.RotationY;
        if (i8 == 0) {
        }
        i9 = i3 & Fields.RotationZ;
        if (i9 == 0) {
        }
        i11 = i3 & Fields.CameraDistance;
        if (i11 == 0) {
        }
        int i24222 = i10;
        i12 = i3 & Fields.TransformOrigin;
        if (i12 == 0) {
        }
        i13 = i3 & Fields.Shape;
        if (i13 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & 196608) == 0) {
        }
        if ((i3 & 65536) == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i21 == 0) {
        }
        if ((i3 & 4) == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if ((i3 & 32) == 0) {
        }
        float f1222222 = m2228getSheetPeekHeightD9Ej5fM;
        if ((i3 & 64) == 0) {
        }
        Shape shape522222 = shape2;
        if ((i3 & Fields.SpotShadowColor) == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i11 == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        if ((i3 & Fields.Clip) == 0) {
        }
        if ((i3 & Fields.CompositingStrategy) == 0) {
        }
        shape3 = shape522222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal localDensity22222 = CompositionLocalsKt.getLocalDensity();
        int i2522222 = i18;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22222 = startRestartGroup.consume(localDensity22222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        final int i2622222 = ((Density) consume22222).roundToPx-0680j_4(f6);
        SheetState bottomSheetState22222 = bottomSheetScaffoldState4.getBottomSheetState();
        final BottomSheetScaffoldState bottomSheetScaffoldState622222 = bottomSheetScaffoldState4;
        final float f1522222 = f6;
        final float f1622222 = m2227getSheetMaxWidthD9Ej5fM;
        final boolean z622222 = z2;
        final Shape shape622222 = shape3;
        final long j1522222 = j10;
        final long j1622222 = j6;
        final float f1722222 = f7;
        final float f1822222 = f5;
        final Function2<? super Composer, ? super Integer, Unit> function2722222 = function24;
        Shape shape722222 = shape3;
        z3 = true;
        ComposableLambda composableLambda32222 = ComposableLambdaKt.composableLambda(startRestartGroup, -680109608, true, new Function3<Integer, Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke(((Number) obj).intValue(), (Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final int i2722222, Composer composer2, int i2822222) {
                int i29;
                ComposerKt.sourceInformation(composer2, "C140@7195L686,135@6935L1296:BottomSheetScaffold.kt#uh7d8r");
                if ((i2822222 & 6) == 0) {
                    i29 = i2822222 | (composer2.changed(i2722222) ? 4 : 2);
                } else {
                    i29 = i2822222;
                }
                if ((i29 & 19) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-680109608, i29, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:135)");
                    }
                    SheetState bottomSheetState222222 = BottomSheetScaffoldState.this.getBottomSheetState();
                    composer2.startReplaceableGroup(1237684821);
                    ComposerKt.sourceInformation(composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                    boolean changed = ((i29 & 14) == 4) | composer2.changed(BottomSheetScaffoldState.this) | composer2.changed(i2622222);
                    final BottomSheetScaffoldState bottomSheetScaffoldState7 = BottomSheetScaffoldState.this;
                    final int i30 = i2622222;
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = (Function1) new Function1<IntSize, DraggableAnchors<SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                return m2234invokeozmzZPI(((IntSize) obj).unbox-impl());
                            }

                            /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                            public final DraggableAnchors<SheetValue> m2234invokeozmzZPI(long j1722222) {
                                final int i31 = IntSize.getHeight-impl(j1722222);
                                final BottomSheetScaffoldState bottomSheetScaffoldState8 = BottomSheetScaffoldState.this;
                                final int i32 = i2722222;
                                final int i33 = i30;
                                return AnchoredDraggableKt.DraggableAnchors(new Function1<DraggableAnchorsConfig<SheetValue>, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((DraggableAnchorsConfig<SheetValue>) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(DraggableAnchorsConfig<SheetValue> draggableAnchorsConfig) {
                                        if (!BottomSheetScaffoldState.this.getBottomSheetState().getSkipPartiallyExpanded()) {
                                            draggableAnchorsConfig.m48at(SheetValue.PartiallyExpanded, i32 - i33);
                                        }
                                        if (i31 != i33) {
                                            draggableAnchorsConfig.m48at(SheetValue.Expanded, Math.max(i32 - i31, 0));
                                        }
                                        if (BottomSheetScaffoldState.this.getBottomSheetState().getSkipHiddenState()) {
                                            return;
                                        }
                                        draggableAnchorsConfig.m48at(SheetValue.Hidden, i32);
                                    }
                                });
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    composer2.endReplaceableGroup();
                    BottomSheetScaffoldKt.m2231StandardBottomSheetXcniZvE(bottomSheetState222222, (Function1) rememberedValue2, f1522222, f1622222, z622222, shape622222, j1522222, j1622222, f1722222, f1822222, function2722222, function3, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        });
        long j1722222 = j10;
        ComposableLambda composableLambda222222 = ComposableLambdaKt.composableLambda(startRestartGroup, 88659390, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$2
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

            public final void invoke(Composer composer2, int i2722222) {
                ComposerKt.sourceInformation(composer2, "C127@6578L45:BottomSheetScaffold.kt#uh7d8r");
                if ((i2722222 & 3) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(88659390, i2722222, -1, "androidx.compose.material3.BottomSheetScaffold.<anonymous> (BottomSheetScaffold.kt:127)");
                }
                function34.invoke(bottomSheetScaffoldState4.getSnackbarHostState(), composer2, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        });
        startRestartGroup.startReplaceableGroup(-1567544379);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        if (((i17 & 896) ^ 384) > 256) {
        }
        z3 = false;
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z3) {
        }
        rememberedValue = (Function0) new Function0<Float>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffold$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2235invoke() {
                return Float.valueOf(BottomSheetScaffoldState.this.getBottomSheetState().requireOffset());
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        Function0 function022222 = (Function0) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        int i2722222 = ((i17 >> 3) & 14) | 27648 | ((i2522222 >> 3) & 112) | ((i2522222 >> 12) & 896) | ((i17 << 6) & 458752);
        int i2822222 = i2522222 << 12;
        m2230BottomSheetScaffoldLayoutPxNyym8(modifier4, function23, function33, composableLambda32222, composableLambda222222, f6, function022222, bottomSheetState22222, j9, j8, startRestartGroup, i2722222 | (234881024 & i2822222) | (i2822222 & 1879048192));
        if (ComposerKt.isTraceInProgress()) {
        }
        shape4 = shape722222;
        f8 = f6;
        function25 = function24;
        z4 = z2;
        function35 = function34;
        f9 = m2227getSheetMaxWidthD9Ej5fM;
        function26 = function23;
        j11 = j6;
        j12 = j9;
        j13 = j8;
        bottomSheetScaffoldState5 = bottomSheetScaffoldState4;
        f10 = f7;
        f11 = f5;
        modifier5 = modifier4;
        j14 = j1722222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState sheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1474606134);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetScaffoldState)189@9008L34,190@9087L32,192@9161L196:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            sheetState = rememberStandardBottomSheetState(null, null, false, composer, 0, 7);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(667326536);
            ComposerKt.sourceInformation(composer, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(rememberedValue);
            }
            snackbarHostState = (SnackbarHostState) rememberedValue;
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, i, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:191)");
        }
        composer.startReplaceableGroup(667326610);
        ComposerKt.sourceInformation(composer, "CC(remember):BottomSheetScaffold.kt#9igjgp");
        boolean z = ((((i & 14) ^ 6) > 4 && composer.changed(sheetState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer.changed(snackbarHostState)) || (i & 48) == 32);
        Object rememberedValue2 = composer.rememberedValue();
        if (z || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new BottomSheetScaffoldState(sheetState, snackbarHostState);
            composer.updateRememberedValue(rememberedValue2);
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) rememberedValue2;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    public static final SheetState rememberStandardBottomSheetState(SheetValue sheetValue, Function1<? super SheetValue, Boolean> function1, boolean z, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(678511581);
        ComposerKt.sourceInformation(composer, "C(rememberStandardBottomSheetState)P(1)214@9987L76:BottomSheetScaffold.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            sheetValue = SheetValue.PartiallyExpanded;
        }
        SheetValue sheetValue2 = sheetValue;
        if ((i2 & 2) != 0) {
            function1 = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$rememberStandardBottomSheetState$1
                public final Boolean invoke(SheetValue sheetValue3) {
                    return true;
                }
            };
        }
        Function1<? super SheetValue, Boolean> function12 = function1;
        if ((i2 & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, i, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:214)");
        }
        SheetState rememberSheetState = SheetDefaultsKt.rememberSheetState(false, function12, sheetValue2, z2, composer, (i & 112) | 6 | ((i << 6) & 896) | ((i << 3) & 7168), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return rememberSheetState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: StandardBottomSheet-XcniZvE, reason: not valid java name */
    public static final void m2231StandardBottomSheetXcniZvE(final SheetState sheetState, final Function1<? super IntSize, ? extends DraggableAnchors<SheetValue>> function1, final float f, final float f2, final boolean z, final Shape shape, final long j, final long j2, final float f3, final float f4, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        Composer startRestartGroup = composer.startRestartGroup(424459667);
        ComposerKt.sourceInformation(startRestartGroup, "C(StandardBottomSheet)P(10!1,5:c#ui.unit.Dp,8:c#ui.unit.Dp,9,7,1:c#ui.graphics.Color,3:c#ui.graphics.Color,11:c#ui.unit.Dp,6:c#ui.unit.Dp,4)232@10554L24,242@10826L326,255@11381L491,236@10628L3850:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(sheetState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(f) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(f2) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changed(z) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i3 |= startRestartGroup.changed(shape) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= startRestartGroup.changed(j) ? 1048576 : Fields.BlendMode;
        }
        if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changed(j2) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= startRestartGroup.changed(f4) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (startRestartGroup.changedInstance(function2) ? 4 : 2);
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        int i5 = i4;
        if ((i3 & 306783379) != 306783378 || (i5 & 19) != 18 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(424459667, i3, i5, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:231)");
            }
            startRestartGroup.startReplaceableGroup(773894976);
            ComposerKt.sourceInformation(startRestartGroup, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            startRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            startRestartGroup.endReplaceableGroup();
            final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
            startRestartGroup.endReplaceableGroup();
            Orientation orientation = Orientation.Vertical;
            Modifier m1111requiredHeightInVpY3zN4$default = SizeKt.m1111requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m1127widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, f2, 1, null), 0.0f, 1, null), f, 0.0f, 2, null);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3_release = sheetState.getAnchoredDraggableState$material3_release();
            startRestartGroup.startReplaceableGroup(1603483798);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean changed = startRestartGroup.changed(anchoredDraggableState$material3_release);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState, orientation, new Function1<Float, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke(((Number) obj).floatValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* compiled from: BottomSheetScaffold.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                    @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$1 */
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                    public static final class C05801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ float $it;
                        final /* synthetic */ SheetState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C05801(SheetState sheetState, float f, Continuation<? super C05801> continuation) {
                            super(2, continuation);
                            this.$state = sheetState;
                            this.$it = f;
                        }

                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C05801(this.$state, this.$it, continuation);
                        }

                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                        }

                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                this.label = 1;
                                if (this.$state.settle$material3_release(this.$it, (Continuation) this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    public final void invoke(float f5) {
                        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new C05801(sheetState, f5, null), 3, (Object) null);
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            Modifier anchoredDraggable$default = AnchoredDraggableKt.anchoredDraggable$default(NestedScrollModifierKt.nestedScroll$default(m1111requiredHeightInVpY3zN4$default, (NestedScrollConnection) rememberedValue2, null, 2, null), sheetState.getAnchoredDraggableState$material3_release(), orientation, z, false, null, 24, null);
            startRestartGroup.startReplaceableGroup(1603484353);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z2 = ((i3 & 112) == 32) | ((i3 & 14) == 4);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1

                    /* compiled from: BottomSheetScaffold.kt */
                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[SheetValue.values().length];
                            try {
                                iArr[SheetValue.Hidden.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[SheetValue.Expanded.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m2238invokeozmzZPI(((IntSize) obj).unbox-impl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                    public final void m2238invokeozmzZPI(long j3) {
                        SheetValue sheetValue;
                        DraggableAnchors<SheetValue> draggableAnchors = (DraggableAnchors) function1.invoke(IntSize.box-impl(j3));
                        int i6 = WhenMappings.$EnumSwitchMapping$0[sheetState.getAnchoredDraggableState$material3_release().getTargetValue().ordinal()];
                        if (i6 == 1 || i6 == 2) {
                            sheetValue = SheetValue.PartiallyExpanded;
                        } else {
                            if (i6 != 3) {
                                throw new NoWhenBranchMatchedException();
                            }
                            sheetValue = draggableAnchors.hasAnchorFor(SheetValue.Expanded) ? SheetValue.Expanded : SheetValue.PartiallyExpanded;
                        }
                        sheetState.getAnchoredDraggableState$material3_release().updateAnchors(draggableAnchors, sheetValue);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            int i6 = i3 >> 12;
            SurfaceKt.m3043SurfaceT9BRK9s(OnRemeasuredModifierKt.onSizeChanged(anchoredDraggable$default, (Function1) rememberedValue3), shape, j, j2, f3, f4, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1070542936, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3
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

                public final void invoke(Composer composer2, int i7) {
                    ComposerKt.sourceInformation(composer2, "C271@12066L2406:BottomSheetScaffold.kt#uh7d8r");
                    if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1070542936, i7, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous> (BottomSheetScaffold.kt:271)");
                        }
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Function2<Composer, Integer, Unit> function22 = function2;
                        final SheetState sheetState2 = sheetState;
                        final boolean z3 = z;
                        final CoroutineScope coroutineScope2 = coroutineScope;
                        Function3<ColumnScope, Composer, Integer, Unit> function32 = function3;
                        composer2.startReplaceableGroup(-483455358);
                        ComposerKt.sourceInformation(composer2, "CC(Column)P(2,3,1)77@3865L61,78@3931L133:Column.kt#2w3rfo");
                        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(fillMaxWidth$default);
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
                        Updater.m4116setimpl(m4109constructorimpl, columnMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, 276693656, "C79@3979L9:Column.kt#2w3rfo");
                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, -176229282, "C314@14453L9:BottomSheetScaffold.kt#uh7d8r");
                        composer2.startReplaceableGroup(-176229282);
                        ComposerKt.sourceInformation(composer2, "274@12205L54,275@12301L48,276@12390L47,280@12599L1755,277@12454L1972");
                        if (function22 != null) {
                            Strings.Companion companion = Strings.INSTANCE;
                            final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_bottom_sheet_collapse_description), composer2, 0);
                            Strings.Companion companion2 = Strings.INSTANCE;
                            final String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_bottom_sheet_dismiss_description), composer2, 0);
                            Strings.Companion companion3 = Strings.INSTANCE;
                            final String m3033getStringNWtq283 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_bottom_sheet_expand_description), composer2, 0);
                            Modifier align = columnScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterHorizontally());
                            composer2.startReplaceableGroup(-176228795);
                            ComposerKt.sourceInformation(composer2, "CC(remember):BottomSheetScaffold.kt#9igjgp");
                            boolean changed2 = composer2.changed(sheetState2) | composer2.changed(z3) | composer2.changed(m3033getStringNWtq283) | composer2.changedInstance(coroutineScope2) | composer2.changed(m3033getStringNWtq28) | composer2.changed(m3033getStringNWtq282);
                            Object rememberedValue4 = composer2.rememberedValue();
                            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue4 = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1
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
                                        final SheetState sheetState3 = SheetState.this;
                                        boolean z4 = z3;
                                        String str = m3033getStringNWtq283;
                                        String str2 = m3033getStringNWtq28;
                                        String str3 = m3033getStringNWtq282;
                                        final CoroutineScope coroutineScope3 = coroutineScope2;
                                        if (sheetState3.getAnchoredDraggableState$material3_release().getAnchors().getSize() <= 1 || !z4) {
                                            return;
                                        }
                                        if (sheetState3.getCurrentValue() == SheetValue.PartiallyExpanded) {
                                            if (((Boolean) sheetState3.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.Expanded)).booleanValue()) {
                                                SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* compiled from: BottomSheetScaffold.kt */
                                                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                    @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1$1", f = "BottomSheetScaffold.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {})
                                                    /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$1$1 */
                                                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                                    public static final class C05811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                        final /* synthetic */ SheetState $this_with;
                                                        int label;

                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        C05811(SheetState sheetState, Continuation<? super C05811> continuation) {
                                                            super(2, continuation);
                                                            this.$this_with = sheetState;
                                                        }

                                                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                            return new C05811(this.$this_with, continuation);
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                                        }

                                                        public final Object invokeSuspend(Object obj) {
                                                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                            int i = this.label;
                                                            if (i == 0) {
                                                                ResultKt.throwOnFailure(obj);
                                                                this.label = 1;
                                                                if (this.$this_with.expand((Continuation) this) == coroutine_suspended) {
                                                                    return coroutine_suspended;
                                                                }
                                                            } else {
                                                                if (i != 1) {
                                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                                }
                                                                ResultKt.throwOnFailure(obj);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    }

                                                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                    public final Boolean m2239invoke() {
                                                        BuildersKt.launch$default(coroutineScope3, (CoroutineContext) null, (CoroutineStart) null, new C05811(sheetState3, null), 3, (Object) null);
                                                        return true;
                                                    }
                                                });
                                            }
                                        } else if (((Boolean) sheetState3.getAnchoredDraggableState$material3_release().getConfirmValueChange$material3_release().invoke(SheetValue.PartiallyExpanded)).booleanValue()) {
                                            SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2
                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* compiled from: BottomSheetScaffold.kt */
                                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                                @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2$1", f = "BottomSheetScaffold.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
                                                /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$2$1 */
                                                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                                public static final class C05821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                    final /* synthetic */ SheetState $this_with;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    C05821(SheetState sheetState, Continuation<? super C05821> continuation) {
                                                        super(2, continuation);
                                                        this.$this_with = sheetState;
                                                    }

                                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                        return new C05821(this.$this_with, continuation);
                                                    }

                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                                    }

                                                    public final Object invokeSuspend(Object obj) {
                                                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            ResultKt.throwOnFailure(obj);
                                                            this.label = 1;
                                                            if (this.$this_with.partialExpand((Continuation) this) == coroutine_suspended) {
                                                                return coroutine_suspended;
                                                            }
                                                        } else {
                                                            if (i != 1) {
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                            }
                                                            ResultKt.throwOnFailure(obj);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                }

                                                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                                public final Boolean m2240invoke() {
                                                    BuildersKt.launch$default(coroutineScope3, (CoroutineContext) null, (CoroutineStart) null, new C05821(sheetState3, null), 3, (Object) null);
                                                    return true;
                                                }
                                            });
                                        }
                                        if (sheetState3.getSkipHiddenState()) {
                                            return;
                                        }
                                        SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str3, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* compiled from: BottomSheetScaffold.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3$1", f = "BottomSheetScaffold.kt", i = {}, l = {304}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3$1$1$1$1$3$1 */
                                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                            public static final class C05831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ SheetState $this_with;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                C05831(SheetState sheetState, Continuation<? super C05831> continuation) {
                                                    super(2, continuation);
                                                    this.$this_with = sheetState;
                                                }

                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new C05831(this.$this_with, continuation);
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                                }

                                                public final Object invokeSuspend(Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        this.label = 1;
                                                        if (this.$this_with.hide((Continuation) this) == coroutine_suspended) {
                                                            return coroutine_suspended;
                                                        }
                                                    } else {
                                                        if (i != 1) {
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                        ResultKt.throwOnFailure(obj);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            }

                                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                                            public final Boolean m2241invoke() {
                                                BuildersKt.launch$default(coroutineScope3, (CoroutineContext) null, (CoroutineStart) null, new C05831(sheetState3, null), 3, (Object) null);
                                                return true;
                                            }
                                        });
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue4);
                            }
                            composer2.endReplaceableGroup();
                            Modifier semantics = SemanticsModifierKt.semantics(align, true, (Function1) rememberedValue4);
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(semantics);
                            if (!(composer2.getApplier() instanceof Applier)) {
                                ComposablesKt.invalidApplier();
                            }
                            composer2.startReusableNode();
                            if (composer2.getInserting()) {
                                composer2.createNode(constructor2);
                            } else {
                                composer2.useNode();
                            }
                            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer2);
                            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1084283499, "C311@14396L12:BottomSheetScaffold.kt#uh7d8r");
                            function22.invoke(composer2, 0);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            composer2.endReplaceableGroup();
                            composer2.endNode();
                            composer2.endReplaceableGroup();
                            composer2.endReplaceableGroup();
                        }
                        composer2.endReplaceableGroup();
                        function32.invoke(columnScopeInstance, composer2, 6);
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
            }), startRestartGroup, (i6 & 112) | 12582912 | (i6 & 896) | (i6 & 7168) | (57344 & i6) | (i6 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$4
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

                public final void invoke(Composer composer2, int i7) {
                    BottomSheetScaffoldKt.m2231StandardBottomSheetXcniZvE(SheetState.this, function1, f, f2, z, shape, j, j2, f3, f4, function2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-PxNyym8, reason: not valid java name */
    public static final void m2230BottomSheetScaffoldLayoutPxNyym8(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final float f, final Function0<Float> function0, final SheetState sheetState, final long j, final long j2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1120561936);
        ComposerKt.sourceInformation(startRestartGroup, "C(BottomSheetScaffoldLayout)P(4,9!2,8,6:c#ui.unit.Dp,5,7,2:c#ui.graphics.Color,3:c#ui.graphics.Color)334@15050L7,335@15073L44,335@15062L55,338@15139L1965,338@15122L1982:BottomSheetScaffold.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function32) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changed(f) ? Fields.RenderEffect : 65536;
        }
        if ((i & 1572864) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 1048576 : Fields.BlendMode;
        }
        if ((i & 12582912) == 0) {
            i2 |= startRestartGroup.changed(sheetState) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i2 |= startRestartGroup.changed(j) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= startRestartGroup.changed(j2) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) != 306783378 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1120561936, i2, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:332)");
            }
            ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final Density density = (Density) consume;
            startRestartGroup.startReplaceableGroup(-99158096);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            int i3 = 29360128 & i2;
            boolean changed = (i3 == 8388608) | startRestartGroup.changed(density);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2236invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2236invoke() {
                        SheetState.this.setDensity$material3_release(density);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) rememberedValue, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-99158030);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):BottomSheetScaffold.kt#9igjgp");
            boolean z = ((i2 & 7168) == 2048) | ((i2 & 112) == 32) | ((i2 & 14) == 4) | ((234881024 & i2) == 67108864) | ((1879048192 & i2) == 536870912) | ((i2 & 896) == 256) | ((458752 & i2) == 131072) | ((57344 & i2) == 16384) | ((i2 & 3670016) == 1048576) | (i3 == 8388608);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (z || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m2237invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2237invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, long j3) {
                        final int i4 = Constraints.getMaxWidth-impl(j3);
                        final int i5 = Constraints.getMaxHeight-impl(j3);
                        long j4 = Constraints.copy-Zbe2FdA$default(j3, 0, 0, 0, 0, 10, (Object) null);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot = BottomSheetScaffoldLayoutSlot.Sheet;
                        final Function3<Integer, Composer, Integer, Unit> function33 = function32;
                        final Placeable mo6318measureBRTryo0 = subcomposeMeasureScope.subcompose(bottomSheetScaffoldLayoutSlot, ComposableLambdaKt.composableLambdaInstance(-1192048628, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$sheetPlaceable$1
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
                                ComposerKt.sourceInformation(composer2, "C344@15421L25:BottomSheetScaffold.kt#uh7d8r");
                                if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1192048628, i6, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:344)");
                                }
                                function33.invoke(Integer.valueOf(i5), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        })).get(0).mo6318measureBRTryo0(j4);
                        final Function2<Composer, Integer, Unit> function23 = function2;
                        final Placeable mo6318measureBRTryo02 = function23 != null ? subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(-873203005, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$topBarPlaceable$1$1
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
                                ComposerKt.sourceInformation(composer2, "C348@15594L8:BottomSheetScaffold.kt#uh7d8r");
                                if ((i6 & 3) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-873203005, i6, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:348)");
                                }
                                function23.invoke(composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        })).get(0).mo6318measureBRTryo0(j4) : null;
                        int height = mo6318measureBRTryo02 != null ? mo6318measureBRTryo02.getHeight() : 0;
                        long j5 = Constraints.copy-Zbe2FdA$default(j4, 0, 0, 0, i5 - height, 7, (Object) null);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot2 = BottomSheetScaffoldLayoutSlot.Body;
                        final Modifier modifier2 = modifier;
                        final long j6 = j;
                        final long j7 = j2;
                        final Function3<PaddingValues, Composer, Integer, Unit> function34 = function3;
                        final int i6 = height;
                        final float f2 = f;
                        final Placeable mo6318measureBRTryo03 = subcomposeMeasureScope.subcompose(bottomSheetScaffoldLayoutSlot2, ComposableLambdaKt.composableLambdaInstance(-1459220575, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$bodyPlaceable$1
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

                            public final void invoke(Composer composer2, int i7) {
                                ComposerKt.sourceInformation(composer2, "C355@15900L194:BottomSheetScaffold.kt#uh7d8r");
                                if ((i7 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1459220575, i7, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:355)");
                                    }
                                    Modifier modifier3 = Modifier.this;
                                    long j8 = j6;
                                    long j9 = j7;
                                    final Function3<PaddingValues, Composer, Integer, Unit> function35 = function34;
                                    final float f3 = f2;
                                    SurfaceKt.m3043SurfaceT9BRK9s(modifier3, null, j8, j9, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(composer2, 1725620860, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$bodyPlaceable$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Composer composer3, int i8) {
                                            ComposerKt.sourceInformation(composer3, "C359@16047L45:BottomSheetScaffold.kt#uh7d8r");
                                            if ((i8 & 3) == 2 && composer3.getSkipping()) {
                                                composer3.skipToGroupEnd();
                                                return;
                                            }
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1725620860, i8, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BottomSheetScaffold.kt:359)");
                                            }
                                            function35.invoke(PaddingKt.m1061PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f3, 7, null), composer3, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    }), composer2, 12582912, 114);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        })).get(0).mo6318measureBRTryo0(j5);
                        final Placeable mo6318measureBRTryo04 = subcomposeMeasureScope.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, function22).get(0).mo6318measureBRTryo0(j4);
                        final Function0<Float> function02 = function0;
                        final SheetState sheetState2 = sheetState;
                        return MeasureScope.layout$default(subcomposeMeasureScope, i4, i5, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1.1

                            /* compiled from: BottomSheetScaffold.kt */
                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$1$WhenMappings */
                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[SheetValue.values().length];
                                    try {
                                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[SheetValue.Expanded.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[SheetValue.Hidden.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                int height2;
                                int roundToInt = MathKt.roundToInt(((Number) function02.invoke()).floatValue());
                                int max = Integer.max(0, (i4 - mo6318measureBRTryo0.getWidth()) / 2);
                                int width = (i4 - mo6318measureBRTryo04.getWidth()) / 2;
                                int i7 = WhenMappings.$EnumSwitchMapping$0[sheetState2.getCurrentValue().ordinal()];
                                if (i7 == 1) {
                                    height2 = roundToInt - mo6318measureBRTryo04.getHeight();
                                } else {
                                    if (i7 != 2 && i7 != 3) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    height2 = i5 - mo6318measureBRTryo04.getHeight();
                                }
                                int i8 = height2;
                                Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo03, 0, i6, 0.0f, 4, null);
                                Placeable placeable = mo6318measureBRTryo02;
                                if (placeable != null) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
                                }
                                Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo0, max, roundToInt, 0.0f, 4, null);
                                Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo04, width, i8, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) rememberedValue2, startRestartGroup, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$3
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

                public final void invoke(Composer composer2, int i4) {
                    BottomSheetScaffoldKt.m2230BottomSheetScaffoldLayoutPxNyym8(Modifier.this, function2, function3, function32, function22, f, function0, sheetState, j, j2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
