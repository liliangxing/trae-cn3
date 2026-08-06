package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.ClipKt;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p002ui.layout.MultiContentMeasurePolicyKt;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TabRow.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a¤\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u0080\u0001\u0010\u001f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u009a\u0001\u0010$\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a \u0001\u0010'\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2,\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0006\u0010\f\u001a\u00020\rH\u0003ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001a¤\u0001\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00012.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b+\u0010\u001e\u001a\u0080\u0001\u0010,\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u001e\b\u0002\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010#\u001a\u0090\u0001\u0010.\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2.\b\u0002\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b/\u0010#\u001an\u00100\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u0019¢\u0006\u0002\b!2\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001a~\u00103\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2,\u0010\u0012\u001a(\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0002\b\u00192\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001c\u001a\r\u0012\u0004\u0012\u00020\u00070\u001b¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00102\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00065"}, d2 = {"ScrollableTabRowMinimumTabWidth", "Landroidx/compose/ui/unit/Dp;", "F", "ScrollableTabRowScrollSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "PrimaryScrollableTabRow", "", "selectedTabIndex", "", "modifier", "Landroidx/compose/ui/Modifier;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "edgePadding", "indicator", "Lkotlin/Function1;", "", "Landroidx/compose/material3/TabPosition;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "tabPositions", "Landroidx/compose/runtime/Composable;", "divider", "Lkotlin/Function0;", "tabs", "PrimaryScrollableTabRow-qhFBPw4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/foundation/ScrollState;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "PrimaryTabRow", "Landroidx/compose/material3/TabIndicatorScope;", "Lkotlin/ExtensionFunctionType;", "PrimaryTabRow-pAZo6Ak", "(ILandroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRow", "ScrollableTabRow-sKfQg0A", "(ILandroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ScrollableTabRowImp", "ScrollableTabRowImp-qhFBPw4", "(ILkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;II)V", "SecondaryScrollableTabRow", "SecondaryScrollableTabRow-qhFBPw4", "SecondaryTabRow", "SecondaryTabRow-pAZo6Ak", "TabRow", "TabRow-pAZo6Ak", "TabRowImpl", "TabRowImpl-DTcfvLk", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabRowWithSubcomposeImpl", "TabRowWithSubcomposeImpl-DTcfvLk", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TabRowKt {
    private static final float ScrollableTabRowMinimumTabWidth = Dp.constructor-impl(90);
    private static final AnimationSpec<Float> ScrollableTabRowScrollSpec = AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null);

    /* JADX WARN: Removed duplicated region for block: B:104:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0082  */
    /* renamed from: PrimaryTabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3100PrimaryTabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long j3;
        long j4;
        int i5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier.Companion companion;
        long j5;
        ComposableLambda composableLambda;
        Function2<? super Composer, ? super Integer, Unit> m2426getLambda1$material3_release;
        Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1884787284);
        ComposerKt.sourceInformation(startRestartGroup, "C(PrimaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)150@7456L21,151@7520L19,166@7964L76:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i9 = i3 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i8 = Fields.RotationX;
                        i4 |= i8;
                    }
                } else {
                    j3 = j;
                }
                i8 = Fields.SpotShadowColor;
                i4 |= i8;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i7 = Fields.CameraDistance;
                        i4 |= i7;
                    }
                } else {
                    j4 = j2;
                }
                i7 = Fields.RotationZ;
                i4 |= i7;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                function32 = function3;
                i4 |= startRestartGroup.changedInstance(function32) ? Fields.Clip : Fields.Shape;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((196608 & i2) == 0) {
                    function23 = function2;
                    i4 |= startRestartGroup.changedInstance(function23) ? Fields.RenderEffect : 65536;
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : Fields.BlendMode;
                        if ((i4 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i9 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j5 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                } else {
                                    j5 = j4;
                                }
                                composableLambda = i5 != 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, -2021049253, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((TabIndicatorScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, int i10) {
                                        int i11;
                                        ComposerKt.sourceInformation(composer2, "C153@7624L204:TabRow.kt#uh7d8r");
                                        if ((i10 & 6) == 0) {
                                            i11 = ((i10 & 8) == 0 ? composer2.changed(tabIndicatorScope) : composer2.changedInstance(tabIndicatorScope) ? 4 : 2) | i10;
                                        } else {
                                            i11 = i10;
                                        }
                                        if ((i11 & 19) != 18 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-2021049253, i11, -1, "androidx.compose.material3.PrimaryTabRow.<anonymous> (TabRow.kt:153)");
                                            }
                                            TabRowDefaults.INSTANCE.m3096PrimaryIndicator10LGxhE(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, true), Dp.Companion.getUnspecified-D9Ej5fM(), 0.0f, 0L, null, composer2, 196656, 28);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }) : function32;
                                if (i6 != 0) {
                                    m2426getLambda1$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2426getLambda1$material3_release();
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1884787284, i4, -1, "androidx.compose.material3.PrimaryTabRow (TabRow.kt:165)");
                                    }
                                    int i10 = i4 >> 3;
                                    m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2426getLambda1$material3_release, function22, startRestartGroup, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (i10 & 458752));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = companion;
                                    function32 = composableLambda;
                                    function23 = m2426getLambda1$material3_release;
                                    j4 = j5;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                companion = modifier;
                                j5 = j4;
                                composableLambda = function32;
                            }
                            m2426getLambda1$material3_release = function23;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i102 = i4 >> 3;
                            m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2426getLambda1$material3_release, function22, startRestartGroup, (i102 & 14) | (i102 & 112) | (i102 & 896) | (i102 & 7168) | (57344 & i102) | (i102 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = companion;
                            function32 = composableLambda;
                            function23 = m2426getLambda1$material3_release;
                            j4 = j5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final long j6 = j3;
                            final long j7 = j4;
                            final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryTabRow$2
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

                                public final void invoke(Composer composer2, int i11) {
                                    TabRowKt.m3100PrimaryTabRowpAZo6Ak(i, modifier3, j6, j7, function33, function24, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    m2426getLambda1$material3_release = function23;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1022 = i4 >> 3;
                    m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2426getLambda1$material3_release, function22, startRestartGroup, (i1022 & 14) | (i1022 & 112) | (i1022 & 896) | (i1022 & 7168) | (57344 & i1022) | (i1022 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = companion;
                    function32 = composableLambda;
                    function23 = m2426getLambda1$material3_release;
                    j4 = j5;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function2;
                if ((i3 & 64) == 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                m2426getLambda1$material3_release = function23;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i10222 = i4 >> 3;
                m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2426getLambda1$material3_release, function22, startRestartGroup, (i10222 & 14) | (i10222 & 112) | (i10222 & 896) | (i10222 & 7168) | (57344 & i10222) | (i10222 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = companion;
                function32 = composableLambda;
                function23 = m2426getLambda1$material3_release;
                j4 = j5;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function23 = function2;
            if ((i3 & 64) == 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            m2426getLambda1$material3_release = function23;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i102222 = i4 >> 3;
            m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2426getLambda1$material3_release, function22, startRestartGroup, (i102222 & 14) | (i102222 & 112) | (i102222 & 896) | (i102222 & 7168) | (57344 & i102222) | (i102222 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = companion;
            function32 = composableLambda;
            function23 = m2426getLambda1$material3_release;
            j4 = j5;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        function32 = function3;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        function23 = function2;
        if ((i3 & 64) == 0) {
        }
        if ((i4 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        m2426getLambda1$material3_release = function23;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1022222 = i4 >> 3;
        m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2426getLambda1$material3_release, function22, startRestartGroup, (i1022222 & 14) | (i1022222 & 112) | (i1022222 & 896) | (i1022222 & 7168) | (57344 & i1022222) | (i1022222 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = companion;
        function32 = composableLambda;
        function23 = m2426getLambda1$material3_release;
        j4 = j5;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0082  */
    /* renamed from: SecondaryTabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3104SecondaryTabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long j3;
        long j4;
        int i5;
        Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier.Companion companion;
        long j5;
        ComposableLambda composableLambda;
        Function2<? super Composer, ? super Integer, Unit> m2427getLambda2$material3_release;
        Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1909540706);
        ComposerKt.sourceInformation(startRestartGroup, "C(SecondaryTabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)207@10434L23,208@10500L21,219@10867L76:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i9 = i3 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i8 = Fields.RotationX;
                        i4 |= i8;
                    }
                } else {
                    j3 = j;
                }
                i8 = Fields.SpotShadowColor;
                i4 |= i8;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i7 = Fields.CameraDistance;
                        i4 |= i7;
                    }
                } else {
                    j4 = j2;
                }
                i7 = Fields.RotationZ;
                i4 |= i7;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                function32 = function3;
                i4 |= startRestartGroup.changedInstance(function32) ? Fields.Clip : Fields.Shape;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((196608 & i2) == 0) {
                    function23 = function2;
                    i4 |= startRestartGroup.changedInstance(function23) ? Fields.RenderEffect : 65536;
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : Fields.BlendMode;
                        if ((i4 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i9 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j5 = TabRowDefaults.INSTANCE.getSecondaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                } else {
                                    j5 = j4;
                                }
                                composableLambda = i5 != 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, 286693261, true, new Function3<TabIndicatorScope, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((TabIndicatorScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(TabIndicatorScope tabIndicatorScope, Composer composer2, int i10) {
                                        ComposerKt.sourceInformation(composer2, "C210@10618L113:TabRow.kt#uh7d8r");
                                        if ((i10 & 6) == 0) {
                                            i10 |= (i10 & 8) == 0 ? composer2.changed(tabIndicatorScope) : composer2.changedInstance(tabIndicatorScope) ? 4 : 2;
                                        }
                                        if ((i10 & 19) != 18 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(286693261, i10, -1, "androidx.compose.material3.SecondaryTabRow.<anonymous> (TabRow.kt:210)");
                                            }
                                            TabRowDefaults.INSTANCE.m3097SecondaryIndicator9IZ8Weo(tabIndicatorScope.tabIndicatorOffset(Modifier.INSTANCE, i, false), 0.0f, 0L, composer2, 3072, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }) : function32;
                                if (i6 != 0) {
                                    m2427getLambda2$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2427getLambda2$material3_release();
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1909540706, i4, -1, "androidx.compose.material3.SecondaryTabRow (TabRow.kt:218)");
                                    }
                                    int i10 = i4 >> 3;
                                    m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2427getLambda2$material3_release, function22, startRestartGroup, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (i10 & 458752));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = companion;
                                    function32 = composableLambda;
                                    function23 = m2427getLambda2$material3_release;
                                    j4 = j5;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                companion = modifier;
                                j5 = j4;
                                composableLambda = function32;
                            }
                            m2427getLambda2$material3_release = function23;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i102 = i4 >> 3;
                            m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2427getLambda2$material3_release, function22, startRestartGroup, (i102 & 14) | (i102 & 112) | (i102 & 896) | (i102 & 7168) | (57344 & i102) | (i102 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = companion;
                            function32 = composableLambda;
                            function23 = m2427getLambda2$material3_release;
                            j4 = j5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final long j6 = j3;
                            final long j7 = j4;
                            final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function33 = function32;
                            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryTabRow$2
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

                                public final void invoke(Composer composer2, int i11) {
                                    TabRowKt.m3104SecondaryTabRowpAZo6Ak(i, modifier3, j6, j7, function33, function24, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    m2427getLambda2$material3_release = function23;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1022 = i4 >> 3;
                    m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2427getLambda2$material3_release, function22, startRestartGroup, (i1022 & 14) | (i1022 & 112) | (i1022 & 896) | (i1022 & 7168) | (57344 & i1022) | (i1022 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = companion;
                    function32 = composableLambda;
                    function23 = m2427getLambda2$material3_release;
                    j4 = j5;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function2;
                if ((i3 & 64) == 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                m2427getLambda2$material3_release = function23;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i10222 = i4 >> 3;
                m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2427getLambda2$material3_release, function22, startRestartGroup, (i10222 & 14) | (i10222 & 112) | (i10222 & 896) | (i10222 & 7168) | (57344 & i10222) | (i10222 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = companion;
                function32 = composableLambda;
                function23 = m2427getLambda2$material3_release;
                j4 = j5;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function23 = function2;
            if ((i3 & 64) == 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            m2427getLambda2$material3_release = function23;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i102222 = i4 >> 3;
            m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2427getLambda2$material3_release, function22, startRestartGroup, (i102222 & 14) | (i102222 & 112) | (i102222 & 896) | (i102222 & 7168) | (57344 & i102222) | (i102222 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = companion;
            function32 = composableLambda;
            function23 = m2427getLambda2$material3_release;
            j4 = j5;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        function32 = function3;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        function23 = function2;
        if ((i3 & 64) == 0) {
        }
        if ((i4 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        m2427getLambda2$material3_release = function23;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1022222 = i4 >> 3;
        m3106TabRowImplDTcfvLk(companion, j3, j5, composableLambda, m2427getLambda2$material3_release, function22, startRestartGroup, (i1022222 & 14) | (i1022222 & 112) | (i1022222 & 896) | (i1022222 & 7168) | (57344 & i1022222) | (i1022222 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = companion;
        function32 = composableLambda;
        function23 = m2427getLambda2$material3_release;
        j4 = j5;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0082  */
    /* renamed from: TabRow-pAZo6Ak, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3105TabRowpAZo6Ak(final int i, Modifier modifier, long j, long j2, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long j3;
        long j4;
        int i5;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier.Companion companion;
        long j5;
        ComposableLambda composableLambda;
        Function2<? super Composer, ? super Integer, Unit> m2428getLambda3$material3_release;
        Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i7;
        int i8;
        Composer startRestartGroup = composer.startRestartGroup(-1199178586);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRow)P(5,4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)299@15165L21,300@15229L19,313@15685L90:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i9 = i3 & 2;
        if (i9 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i8 = Fields.RotationX;
                        i4 |= i8;
                    }
                } else {
                    j3 = j;
                }
                i8 = Fields.SpotShadowColor;
                i4 |= i8;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i7 = Fields.CameraDistance;
                        i4 |= i7;
                    }
                } else {
                    j4 = j2;
                }
                i7 = Fields.RotationZ;
                i4 |= i7;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                function32 = function3;
                i4 |= startRestartGroup.changedInstance(function32) ? Fields.Clip : Fields.Shape;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((196608 & i2) == 0) {
                    function23 = function2;
                    i4 |= startRestartGroup.changedInstance(function23) ? Fields.RenderEffect : 65536;
                    if ((i3 & 64) == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 1048576 : Fields.BlendMode;
                        if ((i4 & 599187) == 599186 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                companion = i9 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    j5 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                    i4 &= -7169;
                                } else {
                                    j5 = j4;
                                }
                                composableLambda = i5 != 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, -2052073983, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(3);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                        invoke((List<TabPosition>) obj, (Composer) obj2, ((Number) obj3).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(List<TabPosition> list, Composer composer2, int i10) {
                                        ComposerKt.sourceInformation(composer2, "C303@15430L109:TabRow.kt#uh7d8r");
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-2052073983, i10, -1, "androidx.compose.material3.TabRow.<anonymous> (TabRow.kt:302)");
                                        }
                                        if (i < list.size()) {
                                            TabRowDefaults.INSTANCE.m3097SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), 0.0f, 0L, composer2, 3072, 6);
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }) : function32;
                                if (i6 != 0) {
                                    m2428getLambda3$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2428getLambda3$material3_release();
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1199178586, i4, -1, "androidx.compose.material3.TabRow (TabRow.kt:312)");
                                    }
                                    int i10 = i4 >> 3;
                                    m3107TabRowWithSubcomposeImplDTcfvLk(companion, j3, j5, composableLambda, m2428getLambda3$material3_release, function22, startRestartGroup, (i10 & 14) | (i10 & 112) | (i10 & 896) | (i10 & 7168) | (57344 & i10) | (i10 & 458752));
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = companion;
                                    function32 = composableLambda;
                                    function23 = m2428getLambda3$material3_release;
                                    j4 = j5;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                companion = modifier;
                                j5 = j4;
                                composableLambda = function32;
                            }
                            m2428getLambda3$material3_release = function23;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            int i102 = i4 >> 3;
                            m3107TabRowWithSubcomposeImplDTcfvLk(companion, j3, j5, composableLambda, m2428getLambda3$material3_release, function22, startRestartGroup, (i102 & 14) | (i102 & 112) | (i102 & 896) | (i102 & 7168) | (57344 & i102) | (i102 & 458752));
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            modifier2 = companion;
                            function32 = composableLambda;
                            function23 = m2428getLambda3$material3_release;
                            j4 = j5;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final long j6 = j3;
                            final long j7 = j4;
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32;
                            final Function2<? super Composer, ? super Integer, Unit> function24 = function23;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRow$2
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

                                public final void invoke(Composer composer2, int i11) {
                                    TabRowKt.m3105TabRowpAZo6Ak(i, modifier3, j6, j7, function33, function24, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 599187) == 599186) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    m2428getLambda3$material3_release = function23;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i1022 = i4 >> 3;
                    m3107TabRowWithSubcomposeImplDTcfvLk(companion, j3, j5, composableLambda, m2428getLambda3$material3_release, function22, startRestartGroup, (i1022 & 14) | (i1022 & 112) | (i1022 & 896) | (i1022 & 7168) | (57344 & i1022) | (i1022 & 458752));
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier2 = companion;
                    function32 = composableLambda;
                    function23 = m2428getLambda3$material3_release;
                    j4 = j5;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function23 = function2;
                if ((i3 & 64) == 0) {
                }
                if ((i4 & 599187) == 599186) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i9 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                m2428getLambda3$material3_release = function23;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i10222 = i4 >> 3;
                m3107TabRowWithSubcomposeImplDTcfvLk(companion, j3, j5, composableLambda, m2428getLambda3$material3_release, function22, startRestartGroup, (i10222 & 14) | (i10222 & 112) | (i10222 & 896) | (i10222 & 7168) | (57344 & i10222) | (i10222 & 458752));
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier2 = companion;
                function32 = composableLambda;
                function23 = m2428getLambda3$material3_release;
                j4 = j5;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            function32 = function3;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function23 = function2;
            if ((i3 & 64) == 0) {
            }
            if ((i4 & 599187) == 599186) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i9 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            m2428getLambda3$material3_release = function23;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i102222 = i4 >> 3;
            m3107TabRowWithSubcomposeImplDTcfvLk(companion, j3, j5, composableLambda, m2428getLambda3$material3_release, function22, startRestartGroup, (i102222 & 14) | (i102222 & 112) | (i102222 & 896) | (i102222 & 7168) | (57344 & i102222) | (i102222 & 458752));
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier2 = companion;
            function32 = composableLambda;
            function23 = m2428getLambda3$material3_release;
            j4 = j5;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        function32 = function3;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        function23 = function2;
        if ((i3 & 64) == 0) {
        }
        if ((i4 & 599187) == 599186) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i9 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        m2428getLambda3$material3_release = function23;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i1022222 = i4 >> 3;
        m3107TabRowWithSubcomposeImplDTcfvLk(companion, j3, j5, composableLambda, m2428getLambda3$material3_release, function22, startRestartGroup, (i1022222 & 14) | (i1022222 & 112) | (i1022222 & 896) | (i1022222 & 7168) | (57344 & i1022222) | (i1022222 & 458752));
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier2 = companion;
        function32 = composableLambda;
        function23 = m2428getLambda3$material3_release;
        j4 = j5;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabRowImpl-DTcfvLk, reason: not valid java name */
    public static final void m3106TabRowImplDTcfvLk(final Modifier modifier, final long j, final long j2, final Function3<? super TabIndicatorScope, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1757425411);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)366@17359L4073:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? Fields.RenderEffect : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1757425411, i2, -1, "androidx.compose.material3.TabRowImpl (TabRow.kt:365)");
            }
            int i3 = i2 << 3;
            SurfaceKt.m3043SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -65106680, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1
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
                    ComposerKt.sourceInformation(composer2, "C371@17511L1344,416@19062L2364,409@18865L2561:TabRow.kt#uh7d8r");
                    if ((i4 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-65106680, i4, -1, "androidx.compose.material3.TabRowImpl.<anonymous> (TabRow.kt:371)");
                        }
                        composer2.startReplaceableGroup(474062752);
                        ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                        Object rememberedValue = composer2.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = new TabRowKt$TabRowImpl$1$scope$1$1();
                            composer2.updateRememberedValue(rememberedValue);
                        }
                        final TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = (TabRowKt$TabRowImpl$1$scope$1$1) rememberedValue;
                        composer2.endReplaceableGroup();
                        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                        final Function3<TabIndicatorScope, Composer, Integer, Unit> function32 = function3;
                        List listOf = CollectionsKt.listOf(new Function2[]{function22, function2, ComposableLambdaKt.composableLambda(composer2, 1236693605, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i5) {
                                ComposerKt.sourceInformation(composer3, "C414@19023L11:TabRow.kt#uh7d8r");
                                if ((i5 & 3) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1236693605, i5, -1, "androidx.compose.material3.TabRowImpl.<anonymous>.<anonymous> (TabRow.kt:414)");
                                }
                                function32.invoke(tabRowKt$TabRowImpl$1$scope$1$1, composer3, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        })});
                        composer2.startReplaceableGroup(474064303);
                        ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (MultiContentMeasurePolicy) new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1
                                @Override // androidx.compose.p002ui.layout.MultiContentMeasurePolicy
                                /* renamed from: measure-3p2s80s */
                                public final MeasureResult mo992measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j3) {
                                    MeasureScope measureScope2 = measureScope;
                                    List<? extends Measurable> list2 = list.get(0);
                                    List<? extends Measurable> list3 = list.get(1);
                                    int i5 = 2;
                                    List<? extends Measurable> list4 = list.get(2);
                                    int i6 = Constraints.getMaxWidth-impl(j3);
                                    int size = list2.size();
                                    final Ref.IntRef intRef = new Ref.IntRef();
                                    if (size > 0) {
                                        intRef.element = i6 / size;
                                    }
                                    int i7 = 0;
                                    int size2 = list2.size();
                                    for (int i8 = 0; i8 < size2; i8++) {
                                        i7 = Integer.valueOf(Math.max(list2.get(i8).maxIntrinsicHeight(intRef.element), i7.intValue()));
                                    }
                                    final int intValue = i7.intValue();
                                    TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$12 = TabRowKt$TabRowImpl$1$scope$1$1.this;
                                    ArrayList arrayList = new ArrayList(size);
                                    int i9 = 0;
                                    while (i9 < size) {
                                        arrayList.add(new TabPosition(Dp.constructor-impl(measureScope2.toDp-u2uoSUM(intRef.element) * i9), measureScope2.toDp-u2uoSUM(intRef.element), ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(measureScope2.toDp-u2uoSUM(Math.min(list2.get(i9).maxIntrinsicWidth(intValue), intRef.element)) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * i5))), Dp.box-impl(Dp.constructor-impl(24))).unbox-impl(), null));
                                        i9++;
                                        measureScope2 = measureScope;
                                        i5 = 2;
                                    }
                                    tabRowKt$TabRowImpl$1$scope$1$12.setTabPositions(arrayList);
                                    ArrayList arrayList2 = new ArrayList(list2.size());
                                    int size3 = list2.size();
                                    for (int i10 = 0; i10 < size3; i10++) {
                                        arrayList2.add(list2.get(i10).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA(j3, intRef.element, intRef.element, intValue, intValue)));
                                    }
                                    final ArrayList arrayList3 = arrayList2;
                                    ArrayList arrayList4 = new ArrayList(list3.size());
                                    int size4 = list3.size();
                                    for (int i11 = 0; i11 < size4; i11++) {
                                        arrayList4.add(list3.get(i11).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j3, 0, 0, 0, 0, 11, (Object) null)));
                                    }
                                    final ArrayList arrayList5 = arrayList4;
                                    ArrayList arrayList6 = new ArrayList(list4.size());
                                    int size5 = list4.size();
                                    for (int i12 = 0; i12 < size5; i12++) {
                                        arrayList6.add(list4.get(i12).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j3, intRef.element, intRef.element, 0, intValue, 4, (Object) null)));
                                    }
                                    final ArrayList arrayList7 = arrayList6;
                                    return MeasureScope.layout$default(measureScope, i6, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            List<Placeable> list5 = arrayList3;
                                            Ref.IntRef intRef2 = intRef;
                                            int size6 = list5.size();
                                            for (int i13 = 0; i13 < size6; i13++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, list5.get(i13), i13 * intRef2.element, 0, 0.0f, 4, null);
                                            }
                                            List<Placeable> list6 = arrayList5;
                                            int i14 = intValue;
                                            int size7 = list6.size();
                                            for (int i15 = 0; i15 < size7; i15++) {
                                                Placeable placeable = list6.get(i15);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i14 - placeable.getHeight(), 0.0f, 4, null);
                                            }
                                            List<Placeable> list7 = arrayList7;
                                            int i16 = intValue;
                                            int size8 = list7.size();
                                            for (int i17 = 0; i17 < size8; i17++) {
                                                Placeable placeable2 = list7.get(i17);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, 0, i16 - placeable2.getHeight(), 0.0f, 4, null);
                                            }
                                        }
                                    }, 4, null);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue2;
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(1399185516);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
                        Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
                        composer2.startReplaceableGroup(1157296644);
                        ComposerKt.sourceInformation(composer2, "CC(remember)P(1):Composables.kt#9igjgp");
                        boolean changed = composer2.changed(multiContentMeasurePolicy);
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue3;
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
                        Updater.m4116setimpl(m4109constructorimpl, measurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        combineAsVirtualLayouts.invoke(composer2, 0);
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
            }), startRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$2
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
                    TabRowKt.m3106TabRowImplDTcfvLk(Modifier.this, j, j2, function3, function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: TabRowWithSubcomposeImpl-DTcfvLk, reason: not valid java name */
    public static final void m3107TabRowWithSubcomposeImplDTcfvLk(final Modifier modifier, final long j, final long j2, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-160898917);
        ComposerKt.sourceInformation(startRestartGroup, "C(TabRowWithSubcomposeImpl)P(4,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3)583@24853L2206:TabRow.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changed(j2) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function3) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? Fields.RenderEffect : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160898917, i2, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl (TabRow.kt:582)");
            }
            int i3 = i2 << 3;
            SurfaceKt.m3043SurfaceT9BRK9s(SelectableGroupKt.selectableGroup(modifier), null, j, j2, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1617702432, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1
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
                    ComposerKt.sourceInformation(composer2, "C588@25035L2018,588@24993L2060:TabRow.kt#uh7d8r");
                    if ((i4 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1617702432, i4, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous> (TabRow.kt:588)");
                    }
                    Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    composer2.startReplaceableGroup(-1028159188);
                    ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                    boolean changed = composer2.changed(function22) | composer2.changed(function2) | composer2.changed(function3);
                    final Function2<Composer, Integer, Unit> function23 = function22;
                    final Function2<Composer, Integer, Unit> function24 = function2;
                    final Function3<List<TabPosition>, Composer, Integer, Unit> function32 = function3;
                    Object rememberedValue = composer2.rememberedValue();
                    if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m3113invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m3113invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j3) {
                                final int i5 = Constraints.getMaxWidth-impl(j3);
                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function23);
                                int size = subcompose.size();
                                final Ref.IntRef intRef = new Ref.IntRef();
                                if (size > 0) {
                                    intRef.element = i5 / size;
                                }
                                int i6 = 0;
                                int size2 = subcompose.size();
                                for (int i7 = 0; i7 < size2; i7++) {
                                    i6 = Integer.valueOf(Math.max(subcompose.get(i7).maxIntrinsicHeight(intRef.element), i6.intValue()));
                                }
                                final int intValue = i6.intValue();
                                ArrayList arrayList = new ArrayList(subcompose.size());
                                int size3 = subcompose.size();
                                for (int i8 = 0; i8 < size3; i8++) {
                                    arrayList.add(subcompose.get(i8).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA(j3, intRef.element, intRef.element, intValue, intValue)));
                                }
                                final ArrayList arrayList2 = arrayList;
                                ArrayList arrayList3 = new ArrayList(size);
                                for (int i9 = 0; i9 < size; i9++) {
                                    arrayList3.add(new TabPosition(Dp.constructor-impl(subcomposeMeasureScope.toDp-u2uoSUM(intRef.element) * i9), subcomposeMeasureScope.toDp-u2uoSUM(intRef.element), ComparisonsKt.maxOf(Dp.box-impl(Dp.constructor-impl(subcomposeMeasureScope.toDp-u2uoSUM(Math.min(subcompose.get(i9).maxIntrinsicWidth(intValue), intRef.element)) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * 2))), Dp.box-impl(Dp.constructor-impl(24))).unbox-impl(), null));
                                }
                                final ArrayList arrayList4 = arrayList3;
                                final Function2<Composer, Integer, Unit> function25 = function24;
                                final Function3<List<TabPosition>, Composer, Integer, Unit> function33 = function32;
                                return MeasureScope.layout$default(subcomposeMeasureScope, i5, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$1$1$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        List<Placeable> list = arrayList2;
                                        Ref.IntRef intRef2 = intRef;
                                        int size4 = list.size();
                                        for (int i10 = 0; i10 < size4; i10++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i10), i10 * intRef2.element, 0, 0.0f, 4, null);
                                        }
                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function25);
                                        long j4 = j3;
                                        int i11 = intValue;
                                        int size5 = subcompose2.size();
                                        for (int i12 = 0; i12 < size5; i12++) {
                                            Placeable mo6318measureBRTryo0 = subcompose2.get(i12).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j4, 0, 0, 0, 0, 11, (Object) null));
                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo0, 0, i11 - mo6318measureBRTryo0.getHeight(), 0.0f, 4, null);
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                        final List<TabPosition> list2 = arrayList4;
                                        List<Measurable> subcompose3 = subcomposeMeasureScope2.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(1621992604, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.TabRowWithSubcomposeImpl.1.1.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i13) {
                                                ComposerKt.sourceInformation(composer3, "C631@26859L23:TabRow.kt#uh7d8r");
                                                if ((i13 & 3) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(1621992604, i13, -1, "androidx.compose.material3.TabRowWithSubcomposeImpl.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:631)");
                                                }
                                                function34.invoke(list2, composer3, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i13 = i5;
                                        int i14 = intValue;
                                        int size6 = subcompose3.size();
                                        for (int i15 = 0; i15 < size6; i15++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i15).mo6318measureBRTryo0(Constraints.Companion.fixed-JhjzzOo(i13, i14)), 0, 0, 0.0f, 4, null);
                                        }
                                    }
                                }, 4, null);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue);
                    }
                    composer2.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(fillMaxWidth$default, (Function2) rememberedValue, composer2, 6, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, (i3 & 896) | 12582912 | (i3 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$TabRowWithSubcomposeImpl$2
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
                    TabRowKt.m3107TabRowWithSubcomposeImplDTcfvLk(Modifier.this, j, j2, function3, function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017d  */
    /* renamed from: PrimaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3099PrimaryScrollableTabRowqhFBPw4(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        int i7;
        ScrollState scrollState2;
        Function2<? super Composer, ? super Integer, Unit> m2429getLambda4$material3_release;
        Modifier modifier2;
        ScrollState scrollState3;
        float f3;
        long j5;
        long j6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        Composer composer2;
        final Modifier modifier3;
        final ScrollState scrollState4;
        final long j7;
        final long j8;
        final float f4;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(-1763241113);
        ComposerKt.sourceInformation(startRestartGroup, "C(PrimaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)677@29409L21,678@29475L21,679@29539L19,695@30196L327:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i11 = i3 & 2;
        if (i11 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0 && startRestartGroup.changed(scrollState)) {
                    i10 = Fields.RotationX;
                    i4 |= i10;
                }
                i10 = Fields.SpotShadowColor;
                i4 |= i10;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = Fields.CameraDistance;
                        i4 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = Fields.RotationZ;
                i4 |= i9;
            } else {
                j3 = j;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i8 = Fields.Clip;
                        i4 |= i8;
                    }
                } else {
                    j4 = j2;
                }
                i8 = Fields.Shape;
                i4 |= i8;
            } else {
                j4 = j2;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= 196608;
            } else if ((196608 & i2) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i4 |= startRestartGroup.changedInstance(function3) ? 1048576 : Fields.BlendMode;
                }
                i7 = i3 & Fields.SpotShadowColor;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i3 & Fields.RotationX) != 0) {
                    i4 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                    if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i11 == 0 ? Modifier.INSTANCE : modifier;
                            if ((i3 & 4) == 0) {
                                scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollState2 = scrollState;
                            }
                            if ((i3 & 8) != 0) {
                                j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                i4 &= -7169;
                            }
                            if ((i3 & 16) != 0) {
                                j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                i4 &= -57345;
                            }
                            float m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM = i5 == 0 ? TabRowDefaults.INSTANCE.m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM() : f2;
                            ComposableLambda composableLambda = i6 == 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, 438091970, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    invoke((List<TabPosition>) obj, (Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(List<TabPosition> list, Composer composer3, int i12) {
                                    ComposerKt.sourceInformation(composer3, "C683@29809L75,684@29912L138:TabRow.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(438091970, i12, -1, "androidx.compose.material3.PrimaryScrollableTabRow.<anonymous> (TabRow.kt:682)");
                                    }
                                    if (i < list.size()) {
                                        TabRowDefaults.INSTANCE.m3096PrimaryIndicator10LGxhE(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), invoke$lambda$0(AnimateAsStateKt.m271animateDpAsStateAjpBEmI(list.get(i).getContentWidth(), null, null, null, composer3, 0, 14)), 0.0f, 0L, null, composer3, 196608, 28);
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }

                                private static final float invoke$lambda$0(State<Dp> state) {
                                    return state.getValue().unbox-impl();
                                }
                            }) : function3;
                            m2429getLambda4$material3_release = i7 == 0 ? ComposableSingletons$TabRowKt.INSTANCE.m2429getLambda4$material3_release() : function2;
                            modifier2 = companion;
                            scrollState3 = scrollState2;
                            f3 = m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j5 = j3;
                            j6 = j4;
                            function32 = composableLambda;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                            modifier2 = modifier;
                            scrollState3 = scrollState;
                            function32 = function3;
                            m2429getLambda4$material3_release = function2;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1763241113, i4, -1, "androidx.compose.material3.PrimaryScrollableTabRow (TabRow.kt:694)");
                        }
                        int i12 = i4 >> 3;
                        composer2 = startRestartGroup;
                        m3102ScrollableTabRowImpqhFBPw4(i, function32, modifier2, j5, j6, f3, m2429getLambda4$material3_release, function22, scrollState3, startRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | ((i4 << 3) & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i12) | (i12 & 29360128) | ((i4 << 18) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        scrollState4 = scrollState3;
                        j7 = j5;
                        j8 = j6;
                        f4 = f3;
                        function33 = function32;
                        function23 = m2429getLambda4$material3_release;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        scrollState4 = scrollState;
                        function33 = function3;
                        j7 = j3;
                        j8 = j4;
                        f4 = f2;
                        composer2 = startRestartGroup;
                        function23 = function2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$PrimaryScrollableTabRow$2
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

                            public final void invoke(Composer composer3, int i13) {
                                TabRowKt.m3099PrimaryScrollableTabRowqhFBPw4(i, modifier3, scrollState4, j7, j8, f4, function33, function23, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i4 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i11 == 0) {
                }
                if ((i3 & 4) == 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                modifier2 = companion;
                scrollState3 = scrollState2;
                f3 = m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                j5 = j3;
                j6 = j4;
                function32 = composableLambda;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i122 = i4 >> 3;
                composer2 = startRestartGroup;
                m3102ScrollableTabRowImpqhFBPw4(i, function32, modifier2, j5, j6, f3, m2429getLambda4$material3_release, function22, scrollState3, startRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | ((i4 << 3) & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i122) | (i122 & 29360128) | ((i4 << 18) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                scrollState4 = scrollState3;
                j7 = j5;
                j8 = j6;
                f4 = f3;
                function33 = function32;
                function23 = m2429getLambda4$material3_release;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & Fields.SpotShadowColor;
            if (i7 != 0) {
            }
            if ((i3 & Fields.RotationX) != 0) {
            }
            if ((i4 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i11 == 0) {
            }
            if ((i3 & 4) == 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            modifier2 = companion;
            scrollState3 = scrollState2;
            f3 = m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM;
            j5 = j3;
            j6 = j4;
            function32 = composableLambda;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1222 = i4 >> 3;
            composer2 = startRestartGroup;
            m3102ScrollableTabRowImpqhFBPw4(i, function32, modifier2, j5, j6, f3, m2429getLambda4$material3_release, function22, scrollState3, startRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | ((i4 << 3) & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i1222) | (i1222 & 29360128) | ((i4 << 18) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            scrollState4 = scrollState3;
            j7 = j5;
            j8 = j6;
            f4 = f3;
            function33 = function32;
            function23 = m2429getLambda4$material3_release;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 384) == 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & Fields.SpotShadowColor;
        if (i7 != 0) {
        }
        if ((i3 & Fields.RotationX) != 0) {
        }
        if ((i4 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i11 == 0) {
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        modifier2 = companion;
        scrollState3 = scrollState2;
        f3 = m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        j5 = j3;
        j6 = j4;
        function32 = composableLambda;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i12222 = i4 >> 3;
        composer2 = startRestartGroup;
        m3102ScrollableTabRowImpqhFBPw4(i, function32, modifier2, j5, j6, f3, m2429getLambda4$material3_release, function22, scrollState3, startRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | ((i4 << 3) & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i12222) | (i12222 & 29360128) | ((i4 << 18) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        scrollState4 = scrollState3;
        j7 = j5;
        j8 = j6;
        f4 = f3;
        function33 = function32;
        function23 = m2429getLambda4$material3_release;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017d  */
    /* renamed from: SecondaryScrollableTabRow-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3103SecondaryScrollableTabRowqhFBPw4(final int i, Modifier modifier, ScrollState scrollState, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        int i7;
        ScrollState scrollState2;
        Function2<? super Composer, ? super Integer, Unit> m2430getLambda5$material3_release;
        Modifier modifier2;
        ScrollState scrollState3;
        float f3;
        long j5;
        long j6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        Composer composer2;
        final Modifier modifier3;
        final ScrollState scrollState4;
        final long j7;
        final long j8;
        final float f4;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        int i10;
        Composer startRestartGroup = composer.startRestartGroup(1821940917);
        ComposerKt.sourceInformation(startRestartGroup, "C(SecondaryScrollableTabRow)P(7,5,6,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)749@33144L21,750@33210L23,751@33276L21,763@33731L326:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i11 = i3 & 2;
        if (i11 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i2 & 384) == 0) {
                if ((i3 & 4) == 0 && startRestartGroup.changed(scrollState)) {
                    i10 = Fields.RotationX;
                    i4 |= i10;
                }
                i10 = Fields.SpotShadowColor;
                i4 |= i10;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = Fields.CameraDistance;
                        i4 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = Fields.RotationZ;
                i4 |= i9;
            } else {
                j3 = j;
            }
            if ((i2 & 24576) != 0) {
                if ((i3 & 16) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i8 = Fields.Clip;
                        i4 |= i8;
                    }
                } else {
                    j4 = j2;
                }
                i8 = Fields.Shape;
                i4 |= i8;
            } else {
                j4 = j2;
            }
            i5 = i3 & 32;
            if (i5 == 0) {
                i4 |= 196608;
            } else if ((196608 & i2) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                i6 = i3 & 64;
                if (i6 != 0) {
                    i4 |= 1572864;
                } else if ((i2 & 1572864) == 0) {
                    i4 |= startRestartGroup.changedInstance(function3) ? 1048576 : Fields.BlendMode;
                }
                i7 = i3 & Fields.SpotShadowColor;
                if (i7 != 0) {
                    i4 |= 12582912;
                } else if ((i2 & 12582912) == 0) {
                    i4 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                }
                if ((i3 & Fields.RotationX) != 0) {
                    i4 |= 100663296;
                } else if ((i2 & 100663296) == 0) {
                    i4 |= startRestartGroup.changedInstance(function22) ? 67108864 : 33554432;
                    if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i11 == 0 ? Modifier.INSTANCE : modifier;
                            if ((i3 & 4) == 0) {
                                scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                i4 &= -897;
                            } else {
                                scrollState2 = scrollState;
                            }
                            if ((i3 & 8) != 0) {
                                j3 = TabRowDefaults.INSTANCE.getSecondaryContainerColor(startRestartGroup, 6);
                                i4 &= -7169;
                            }
                            if ((i3 & 16) != 0) {
                                j4 = TabRowDefaults.INSTANCE.getSecondaryContentColor(startRestartGroup, 6);
                                i4 &= -57345;
                            }
                            float m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM = i5 == 0 ? TabRowDefaults.INSTANCE.m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM() : f2;
                            ComposableLambda composableLambda = i6 == 0 ? ComposableLambdaKt.composableLambda(startRestartGroup, -115843248, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    invoke((List<TabPosition>) obj, (Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(List<TabPosition> list, Composer composer3, int i12) {
                                    ComposerKt.sourceInformation(composer3, "C754@33494L101:TabRow.kt#uh7d8r");
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-115843248, i12, -1, "androidx.compose.material3.SecondaryScrollableTabRow.<anonymous> (TabRow.kt:754)");
                                    }
                                    TabRowDefaults.INSTANCE.m3097SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }) : function3;
                            m2430getLambda5$material3_release = i7 == 0 ? ComposableSingletons$TabRowKt.INSTANCE.m2430getLambda5$material3_release() : function2;
                            modifier2 = companion;
                            scrollState3 = scrollState2;
                            f3 = m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                            j5 = j3;
                            j6 = j4;
                            function32 = composableLambda;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            if ((i3 & 8) != 0) {
                                i4 &= -7169;
                            }
                            if ((i3 & 16) != 0) {
                                i4 &= -57345;
                            }
                            modifier2 = modifier;
                            scrollState3 = scrollState;
                            function32 = function3;
                            m2430getLambda5$material3_release = function2;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1821940917, i4, -1, "androidx.compose.material3.SecondaryScrollableTabRow (TabRow.kt:762)");
                        }
                        int i12 = i4 >> 3;
                        composer2 = startRestartGroup;
                        m3102ScrollableTabRowImpqhFBPw4(i, function32, modifier2, j5, j6, f3, m2430getLambda5$material3_release, function22, scrollState3, startRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | ((i4 << 3) & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i12) | (i12 & 29360128) | ((i4 << 18) & 234881024), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier2;
                        scrollState4 = scrollState3;
                        j7 = j5;
                        j8 = j6;
                        f4 = f3;
                        function33 = function32;
                        function23 = m2430getLambda5$material3_release;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        scrollState4 = scrollState;
                        function33 = function3;
                        j7 = j3;
                        j8 = j4;
                        f4 = f2;
                        composer2 = startRestartGroup;
                        function23 = function2;
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$SecondaryScrollableTabRow$2
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

                            public final void invoke(Composer composer3, int i13) {
                                TabRowKt.m3103SecondaryScrollableTabRowqhFBPw4(i, modifier3, scrollState4, j7, j8, f4, function33, function23, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                            }
                        });
                        return;
                    }
                    return;
                }
                if ((i4 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i11 == 0) {
                }
                if ((i3 & 4) == 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                modifier2 = companion;
                scrollState3 = scrollState2;
                f3 = m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM;
                j5 = j3;
                j6 = j4;
                function32 = composableLambda;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i122 = i4 >> 3;
                composer2 = startRestartGroup;
                m3102ScrollableTabRowImpqhFBPw4(i, function32, modifier2, j5, j6, f3, m2430getLambda5$material3_release, function22, scrollState3, startRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | ((i4 << 3) & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i122) | (i122 & 29360128) | ((i4 << 18) & 234881024), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                scrollState4 = scrollState3;
                j7 = j5;
                j8 = j6;
                f4 = f3;
                function33 = function32;
                function23 = m2430getLambda5$material3_release;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            f2 = f;
            i6 = i3 & 64;
            if (i6 != 0) {
            }
            i7 = i3 & Fields.SpotShadowColor;
            if (i7 != 0) {
            }
            if ((i3 & Fields.RotationX) != 0) {
            }
            if ((i4 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i11 == 0) {
            }
            if ((i3 & 4) == 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            modifier2 = companion;
            scrollState3 = scrollState2;
            f3 = m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM;
            j5 = j3;
            j6 = j4;
            function32 = composableLambda;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i1222 = i4 >> 3;
            composer2 = startRestartGroup;
            m3102ScrollableTabRowImpqhFBPw4(i, function32, modifier2, j5, j6, f3, m2430getLambda5$material3_release, function22, scrollState3, startRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | ((i4 << 3) & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i1222) | (i1222 & 29360128) | ((i4 << 18) & 234881024), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            scrollState4 = scrollState3;
            j7 = j5;
            j8 = j6;
            f4 = f3;
            function33 = function32;
            function23 = m2430getLambda5$material3_release;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i2 & 384) == 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        if ((i2 & 24576) != 0) {
        }
        i5 = i3 & 32;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 64;
        if (i6 != 0) {
        }
        i7 = i3 & Fields.SpotShadowColor;
        if (i7 != 0) {
        }
        if ((i3 & Fields.RotationX) != 0) {
        }
        if ((i4 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i11 == 0) {
        }
        if ((i3 & 4) == 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        modifier2 = companion;
        scrollState3 = scrollState2;
        f3 = m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM;
        j5 = j3;
        j6 = j4;
        function32 = composableLambda;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i12222 = i4 >> 3;
        composer2 = startRestartGroup;
        m3102ScrollableTabRowImpqhFBPw4(i, function32, modifier2, j5, j6, f3, m2430getLambda5$material3_release, function22, scrollState3, startRestartGroup, (i4 & 14) | ((i4 >> 15) & 112) | ((i4 << 3) & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i12222) | (i12222 & 29360128) | ((i4 << 18) & 234881024), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        scrollState4 = scrollState3;
        j7 = j5;
        j8 = j6;
        f4 = f3;
        function33 = function32;
        function23 = m2430getLambda5$material3_release;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00a1  */
    /* renamed from: ScrollableTabRow-sKfQg0A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3101ScrollableTabRowsKfQg0A(final int i, Modifier modifier, long j, long j2, float f, Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i2, final int i3) {
        int i4;
        long j3;
        long j4;
        int i5;
        float f2;
        int i6;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function23;
        Modifier modifier2;
        Composer composer2;
        final Modifier modifier3;
        final long j5;
        final long j6;
        final float f3;
        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-497821003);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollableTabRow)P(6,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp,4)816@36583L21,817@36647L19,838@37409L21,829@37100L336:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i10 = i3 & 2;
        if (i10 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            if ((i2 & 384) != 0) {
                if ((i3 & 4) == 0) {
                    j3 = j;
                    if (startRestartGroup.changed(j3)) {
                        i9 = Fields.RotationX;
                        i4 |= i9;
                    }
                } else {
                    j3 = j;
                }
                i9 = Fields.SpotShadowColor;
                i4 |= i9;
            } else {
                j3 = j;
            }
            if ((i2 & 3072) != 0) {
                if ((i3 & 8) == 0) {
                    j4 = j2;
                    if (startRestartGroup.changed(j4)) {
                        i8 = Fields.CameraDistance;
                        i4 |= i8;
                    }
                } else {
                    j4 = j2;
                }
                i8 = Fields.RotationZ;
                i4 |= i8;
            } else {
                j4 = j2;
            }
            i5 = i3 & 16;
            if (i5 == 0) {
                i4 |= 24576;
            } else if ((i2 & 24576) == 0) {
                f2 = f;
                i4 |= startRestartGroup.changed(f2) ? Fields.Clip : Fields.Shape;
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((196608 & i2) == 0) {
                    function32 = function3;
                    i4 |= startRestartGroup.changedInstance(function32) ? Fields.RenderEffect : 65536;
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function2) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i3 & Fields.SpotShadowColor) == 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        if ((i4 & 4793491) == 4793490 || !startRestartGroup.getSkipping()) {
                            startRestartGroup.startDefaults();
                            if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                Modifier.Companion companion = i10 != 0 ? Modifier.INSTANCE : modifier;
                                if ((i3 & 4) != 0) {
                                    j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                    j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                }
                                if (i5 != 0) {
                                    f2 = TabRowDefaults.INSTANCE.m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                }
                                if (i6 != 0) {
                                    function32 = ComposableLambdaKt.composableLambda(startRestartGroup, -913748678, true, new Function3<List<? extends TabPosition>, Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(3);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                            invoke((List<TabPosition>) obj, (Composer) obj2, ((Number) obj3).intValue());
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(List<TabPosition> list, Composer composer3, int i11) {
                                            ComposerKt.sourceInformation(composer3, "C820@36863L101:TabRow.kt#uh7d8r");
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-913748678, i11, -1, "androidx.compose.material3.ScrollableTabRow.<anonymous> (TabRow.kt:820)");
                                            }
                                            TabRowDefaults.INSTANCE.m3097SecondaryIndicator9IZ8Weo(TabRowDefaults.INSTANCE.tabIndicatorOffset(Modifier.INSTANCE, list.get(i)), 0.0f, 0L, composer3, 3072, 6);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                            }
                                        }
                                    });
                                }
                                if (i7 != 0) {
                                    modifier2 = companion;
                                    function23 = ComposableSingletons$TabRowKt.INSTANCE.m2431getLambda6$material3_release();
                                } else {
                                    function23 = function2;
                                    modifier2 = companion;
                                }
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                if ((i3 & 4) != 0) {
                                    i4 &= -897;
                                }
                                if ((i3 & 8) != 0) {
                                    i4 &= -7169;
                                }
                                modifier2 = modifier;
                                function23 = function2;
                            }
                            long j7 = j3;
                            long j8 = j4;
                            float f4 = f2;
                            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function32;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-497821003, i4, -1, "androidx.compose.material3.ScrollableTabRow (TabRow.kt:828)");
                            }
                            int i11 = i4 << 3;
                            composer2 = startRestartGroup;
                            m3102ScrollableTabRowImpqhFBPw4(i, function34, modifier2, j7, j8, f4, function23, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i4 & 14) | ((i4 >> 12) & 112) | (i11 & 896) | (i11 & 7168) | (57344 & i11) | (i11 & 458752) | (3670016 & i4) | (i4 & 29360128), 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier2;
                            j5 = j7;
                            j6 = j8;
                            f3 = f4;
                            function33 = function34;
                            function24 = function23;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            modifier3 = modifier;
                            j5 = j3;
                            j6 = j4;
                            f3 = f2;
                            function33 = function32;
                            composer2 = startRestartGroup;
                            function24 = function2;
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRow$2
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

                                public final void invoke(Composer composer3, int i12) {
                                    TabRowKt.m3101ScrollableTabRowsKfQg0A(i, modifier3, j5, j6, f3, function33, function24, function22, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    if ((i4 & 4793491) == 4793490) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if ((i3 & 4) != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    long j72 = j3;
                    long j82 = j4;
                    float f42 = f2;
                    Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function342 = function32;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i112 = i4 << 3;
                    composer2 = startRestartGroup;
                    m3102ScrollableTabRowImpqhFBPw4(i, function342, modifier2, j72, j82, f42, function23, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i4 & 14) | ((i4 >> 12) & 112) | (i112 & 896) | (i112 & 7168) | (57344 & i112) | (i112 & 458752) | (3670016 & i4) | (i4 & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    modifier3 = modifier2;
                    j5 = j72;
                    j6 = j82;
                    f3 = f42;
                    function33 = function342;
                    function24 = function23;
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function32 = function3;
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i3 & Fields.SpotShadowColor) == 0) {
                }
                if ((i4 & 4793491) == 4793490) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i10 != 0) {
                }
                if ((i3 & 4) != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                long j722 = j3;
                long j822 = j4;
                float f422 = f2;
                Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3422 = function32;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i1122 = i4 << 3;
                composer2 = startRestartGroup;
                m3102ScrollableTabRowImpqhFBPw4(i, function3422, modifier2, j722, j822, f422, function23, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i4 & 14) | ((i4 >> 12) & 112) | (i1122 & 896) | (i1122 & 7168) | (57344 & i1122) | (i1122 & 458752) | (3670016 & i4) | (i4 & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                modifier3 = modifier2;
                j5 = j722;
                j6 = j822;
                f3 = f422;
                function33 = function3422;
                function24 = function23;
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            f2 = f;
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            function32 = function3;
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i3 & Fields.SpotShadowColor) == 0) {
            }
            if ((i4 & 4793491) == 4793490) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i10 != 0) {
            }
            if ((i3 & 4) != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            long j7222 = j3;
            long j8222 = j4;
            float f4222 = f2;
            Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34222 = function32;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i11222 = i4 << 3;
            composer2 = startRestartGroup;
            m3102ScrollableTabRowImpqhFBPw4(i, function34222, modifier2, j7222, j8222, f4222, function23, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i4 & 14) | ((i4 >> 12) & 112) | (i11222 & 896) | (i11222 & 7168) | (57344 & i11222) | (i11222 & 458752) | (3670016 & i4) | (i4 & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            modifier3 = modifier2;
            j5 = j7222;
            j6 = j8222;
            f3 = f4222;
            function33 = function34222;
            function24 = function23;
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        if ((i2 & 384) != 0) {
        }
        if ((i2 & 3072) != 0) {
        }
        i5 = i3 & 16;
        if (i5 == 0) {
        }
        f2 = f;
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        function32 = function3;
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i3 & Fields.SpotShadowColor) == 0) {
        }
        if ((i4 & 4793491) == 4793490) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i10 != 0) {
        }
        if ((i3 & 4) != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        long j72222 = j3;
        long j82222 = j4;
        float f42222 = f2;
        Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function342222 = function32;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i112222 = i4 << 3;
        composer2 = startRestartGroup;
        m3102ScrollableTabRowImpqhFBPw4(i, function342222, modifier2, j72222, j82222, f42222, function23, function22, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i4 & 14) | ((i4 >> 12) & 112) | (i112222 & 896) | (i112222 & 7168) | (57344 & i112222) | (i112222 & 458752) | (3670016 & i4) | (i4 & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier2;
        j5 = j72222;
        j6 = j82222;
        f3 = f42222;
        function33 = function342222;
        function24 = function23;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e1  */
    /* renamed from: ScrollableTabRowImp-qhFBPw4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m3102ScrollableTabRowImpqhFBPw4(final int i, final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function3, Modifier modifier, long j, long j2, float f, Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final ScrollState scrollState, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        Modifier modifier2;
        long j3;
        long j4;
        int i6;
        float f2;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> m2432getLambda7$material3_release;
        Function2<? super Composer, ? super Integer, Unit> function23;
        ScopeUpdateScope endRestartGroup;
        int i8;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-1696166011);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScrollableTabRowImp)P(7,4,5,0:c#ui.graphics.Color,1:c#ui.graphics.Color,3:c#ui.unit.Dp!1,8)847@37660L21,848@37724L19,856@37975L3984:TabRow.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i2 & 3072) == 0) {
                    if ((i3 & 8) == 0) {
                        j3 = j;
                        if (startRestartGroup.changed(j3)) {
                            i9 = Fields.CameraDistance;
                            i4 |= i9;
                        }
                    } else {
                        j3 = j;
                    }
                    i9 = Fields.RotationZ;
                    i4 |= i9;
                } else {
                    j3 = j;
                }
                if ((i2 & 24576) == 0) {
                    if ((i3 & 16) == 0) {
                        j4 = j2;
                        if (startRestartGroup.changed(j4)) {
                            i8 = Fields.Clip;
                            i4 |= i8;
                        }
                    } else {
                        j4 = j2;
                    }
                    i8 = Fields.Shape;
                    i4 |= i8;
                } else {
                    j4 = j2;
                }
                i6 = i3 & 32;
                if (i6 != 0) {
                    i4 |= 196608;
                } else if ((196608 & i2) == 0) {
                    f2 = f;
                    i4 |= startRestartGroup.changed(f2) ? Fields.RenderEffect : 65536;
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i4 |= startRestartGroup.changedInstance(function2) ? 1048576 : Fields.BlendMode;
                    }
                    if ((i3 & Fields.SpotShadowColor) == 0) {
                        i4 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                        if ((i3 & Fields.RotationX) != 0) {
                            i4 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i4 |= startRestartGroup.changed(scrollState) ? 67108864 : 33554432;
                            if ((i4 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    if (i5 != 0) {
                                        modifier2 = Modifier.INSTANCE;
                                    }
                                    if ((i3 & 8) != 0) {
                                        j3 = TabRowDefaults.INSTANCE.getPrimaryContainerColor(startRestartGroup, 6);
                                        i4 &= -7169;
                                    }
                                    if ((i3 & 16) != 0) {
                                        j4 = TabRowDefaults.INSTANCE.getPrimaryContentColor(startRestartGroup, 6);
                                        i4 &= -57345;
                                    }
                                    if (i6 != 0) {
                                        f2 = TabRowDefaults.INSTANCE.m3098getScrollableTabRowEdgeStartPaddingD9Ej5fM();
                                    }
                                    if (i7 != 0) {
                                        m2432getLambda7$material3_release = ComposableSingletons$TabRowKt.INSTANCE.m2432getLambda7$material3_release();
                                        final float f3 = f2;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1696166011, i4, -1, "androidx.compose.material3.ScrollableTabRowImp (TabRow.kt:855)");
                                        }
                                        final Function2<? super Composer, ? super Integer, Unit> function24 = m2432getLambda7$material3_release;
                                        int i10 = ((i4 >> 6) & 14) | 12582912;
                                        int i11 = i4 >> 3;
                                        SurfaceKt.m3043SurfaceT9BRK9s(modifier2, null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                                            public final void invoke(Composer composer2, int i12) {
                                                ComposerKt.sourceInformation(composer2, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                                                if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1178901494, i12, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                                                    }
                                                    composer2.startReplaceableGroup(773894976);
                                                    ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                                    composer2.startReplaceableGroup(-492369756);
                                                    ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                                                    Object rememberedValue = composer2.rememberedValue();
                                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                        Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                                                        composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                                        rememberedValue = compositionScopedCoroutineScopeCanceller;
                                                    }
                                                    composer2.endReplaceableGroup();
                                                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                                    composer2.endReplaceableGroup();
                                                    composer2.startReplaceableGroup(121290627);
                                                    ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                                                    boolean changed = composer2.changed(ScrollState.this) | composer2.changed(coroutineScope);
                                                    ScrollState scrollState2 = ScrollState.this;
                                                    Object rememberedValue2 = composer2.rememberedValue();
                                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                                        composer2.updateRememberedValue(rememberedValue2);
                                                    }
                                                    final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                                    composer2.endReplaceableGroup();
                                                    Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                                    composer2.startReplaceableGroup(121291080);
                                                    ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                                                    boolean changed2 = composer2.changed(f3) | composer2.changed(function22) | composer2.changed(function24) | composer2.changed(function3) | composer2.changedInstance(scrollableTabData) | composer2.changed(i);
                                                    final float f4 = f3;
                                                    final Function2<Composer, Integer, Unit> function25 = function22;
                                                    final Function2<Composer, Integer, Unit> function26 = function24;
                                                    final int i13 = i;
                                                    final Function3<List<TabPosition>, Composer, Integer, Unit> function32 = function3;
                                                    Object rememberedValue3 = composer2.rememberedValue();
                                                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                                            /* JADX INFO: Access modifiers changed from: package-private */
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                                return m3111invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                                            }

                                                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                                            public final MeasureResult m3111invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j5) {
                                                                float f5;
                                                                f5 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                                int i14 = subcomposeMeasureScope.roundToPx-0680j_4(f5);
                                                                final int i15 = subcomposeMeasureScope.roundToPx-0680j_4(f4);
                                                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                                int i16 = 0;
                                                                int size = subcompose.size();
                                                                for (int i17 = 0; i17 < size; i17++) {
                                                                    i16 = Integer.valueOf(Math.max(i16.intValue(), subcompose.get(i17).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                                                }
                                                                final int intValue = i16.intValue();
                                                                long j6 = Constraints.copy-Zbe2FdA$default(j5, i14, 0, intValue, intValue, 2, (Object) null);
                                                                final ArrayList arrayList = new ArrayList();
                                                                final ArrayList arrayList2 = new ArrayList();
                                                                int size2 = subcompose.size();
                                                                for (int i18 = 0; i18 < size2; i18++) {
                                                                    Measurable measurable = subcompose.get(i18);
                                                                    Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j6);
                                                                    float f6 = Dp.constructor-impl(subcomposeMeasureScope.toDp-u2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo6318measureBRTryo0.getHeight()), mo6318measureBRTryo0.getWidth())) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * 2));
                                                                    arrayList.add(mo6318measureBRTryo0);
                                                                    arrayList2.add(Dp.box-impl(f6));
                                                                }
                                                                Integer valueOf = Integer.valueOf(i15 * 2);
                                                                int size3 = arrayList.size();
                                                                for (int i19 = 0; i19 < size3; i19++) {
                                                                    valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i19)).getWidth());
                                                                }
                                                                final int intValue2 = valueOf.intValue();
                                                                final Function2<Composer, Integer, Unit> function27 = function26;
                                                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                                final int i20 = i13;
                                                                final Function3<List<TabPosition>, Composer, Integer, Unit> function33 = function32;
                                                                return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                                        invoke((Placeable.PlacementScope) obj);
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                                                        final ArrayList arrayList3 = new ArrayList();
                                                                        int i21 = i15;
                                                                        List<Placeable> list = arrayList;
                                                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                                        List<Dp> list2 = arrayList2;
                                                                        int size4 = list.size();
                                                                        for (int i22 = 0; i22 < size4; i22++) {
                                                                            Placeable placeable = list.get(i22);
                                                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.toDp-u2uoSUM(i21), subcomposeMeasureScope2.toDp-u2uoSUM(placeable.getWidth()), list2.get(i22).unbox-impl(), null));
                                                                            i21 += placeable.getWidth();
                                                                        }
                                                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                                        long j7 = j5;
                                                                        int i23 = intValue2;
                                                                        int i24 = intValue;
                                                                        int i25 = 0;
                                                                        for (int size5 = subcompose2.size(); i25 < size5; size5 = size5) {
                                                                            Placeable mo6318measureBRTryo02 = subcompose2.get(i25).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j7, i23, i23, 0, 0, 8, (Object) null));
                                                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo02, 0, i24 - mo6318measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                                            i25++;
                                                                        }
                                                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                                        TabSlots tabSlots = TabSlots.Indicator;
                                                                        final Function3<List<TabPosition>, Composer, Integer, Unit> function34 = function33;
                                                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                            /* JADX WARN: Multi-variable type inference failed */
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                                                return Unit.INSTANCE;
                                                                            }

                                                                            public final void invoke(Composer composer3, int i26) {
                                                                                ComposerKt.sourceInformation(composer3, "C942@41500L23:TabRow.kt#uh7d8r");
                                                                                if ((i26 & 3) == 2 && composer3.getSkipping()) {
                                                                                    composer3.skipToGroupEnd();
                                                                                    return;
                                                                                }
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventStart(358596038, i26, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                                                }
                                                                                function34.invoke(arrayList3, composer3, 0);
                                                                                if (ComposerKt.isTraceInProgress()) {
                                                                                    ComposerKt.traceEventEnd();
                                                                                }
                                                                            }
                                                                        }));
                                                                        int i26 = intValue2;
                                                                        int i27 = intValue;
                                                                        int size6 = subcompose3.size();
                                                                        for (int i28 = 0; i28 < size6; i28++) {
                                                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo6318measureBRTryo0(Constraints.Companion.fixed-JhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                                                        }
                                                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i15, arrayList3, i20);
                                                                    }
                                                                }, 4, null);
                                                            }
                                                        };
                                                        composer2.updateRememberedValue(rememberedValue3);
                                                    }
                                                    composer2.endReplaceableGroup();
                                                    SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer2, 0, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        }), startRestartGroup, i10 | (i11 & 896) | (i11 & 7168), 114);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        f2 = f3;
                                        function23 = m2432getLambda7$material3_release;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 8) != 0) {
                                        i4 &= -7169;
                                    }
                                    if ((i3 & 16) != 0) {
                                        i4 &= -57345;
                                    }
                                }
                                m2432getLambda7$material3_release = function2;
                                final float f32 = f2;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final Function2<? super Composer, ? super Integer, Unit> function242 = m2432getLambda7$material3_release;
                                int i102 = ((i4 >> 6) & 14) | 12582912;
                                int i112 = i4 >> 3;
                                SurfaceKt.m3043SurfaceT9BRK9s(modifier2, null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                                    public final void invoke(Composer composer2, int i12) {
                                        ComposerKt.sourceInformation(composer2, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                                        if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1178901494, i12, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                                            }
                                            composer2.startReplaceableGroup(773894976);
                                            ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                            composer2.startReplaceableGroup(-492369756);
                                            ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                                            Object rememberedValue = composer2.rememberedValue();
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                                                composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                                rememberedValue = compositionScopedCoroutineScopeCanceller;
                                            }
                                            composer2.endReplaceableGroup();
                                            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                            composer2.endReplaceableGroup();
                                            composer2.startReplaceableGroup(121290627);
                                            ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                                            boolean changed = composer2.changed(ScrollState.this) | composer2.changed(coroutineScope);
                                            ScrollState scrollState2 = ScrollState.this;
                                            Object rememberedValue2 = composer2.rememberedValue();
                                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                                composer2.updateRememberedValue(rememberedValue2);
                                            }
                                            final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                            composer2.endReplaceableGroup();
                                            Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                            composer2.startReplaceableGroup(121291080);
                                            ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                                            boolean changed2 = composer2.changed(f32) | composer2.changed(function22) | composer2.changed(function242) | composer2.changed(function3) | composer2.changedInstance(scrollableTabData) | composer2.changed(i);
                                            final float f4 = f32;
                                            final Function2<? super Composer, ? super Integer, Unit> function25 = function22;
                                            final Function2<? super Composer, ? super Integer, Unit> function26 = function242;
                                            final int i13 = i;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32 = function3;
                                            Object rememberedValue3 = composer2.rememberedValue();
                                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                        return m3111invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                                    }

                                                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                                    public final MeasureResult m3111invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j5) {
                                                        float f5;
                                                        f5 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                        int i14 = subcomposeMeasureScope.roundToPx-0680j_4(f5);
                                                        final int i15 = subcomposeMeasureScope.roundToPx-0680j_4(f4);
                                                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function25);
                                                        int i16 = 0;
                                                        int size = subcompose.size();
                                                        for (int i17 = 0; i17 < size; i17++) {
                                                            i16 = Integer.valueOf(Math.max(i16.intValue(), subcompose.get(i17).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                                        }
                                                        final int intValue = i16.intValue();
                                                        long j6 = Constraints.copy-Zbe2FdA$default(j5, i14, 0, intValue, intValue, 2, (Object) null);
                                                        final List<Placeable> arrayList = new ArrayList();
                                                        final List<Dp> arrayList2 = new ArrayList();
                                                        int size2 = subcompose.size();
                                                        for (int i18 = 0; i18 < size2; i18++) {
                                                            Measurable measurable = subcompose.get(i18);
                                                            Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j6);
                                                            float f6 = Dp.constructor-impl(subcomposeMeasureScope.toDp-u2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo6318measureBRTryo0.getHeight()), mo6318measureBRTryo0.getWidth())) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * 2));
                                                            arrayList.add(mo6318measureBRTryo0);
                                                            arrayList2.add(Dp.box-impl(f6));
                                                        }
                                                        Integer valueOf = Integer.valueOf(i15 * 2);
                                                        int size3 = arrayList.size();
                                                        for (int i19 = 0; i19 < size3; i19++) {
                                                            valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i19)).getWidth());
                                                        }
                                                        final int intValue2 = valueOf.intValue();
                                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                        final int i20 = i13;
                                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32;
                                                        return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(1);
                                                            }

                                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                                invoke((Placeable.PlacementScope) obj);
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                                final List<TabPosition> arrayList3 = new ArrayList();
                                                                int i21 = i15;
                                                                List<Placeable> list = arrayList;
                                                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                                List<Dp> list2 = arrayList2;
                                                                int size4 = list.size();
                                                                for (int i22 = 0; i22 < size4; i22++) {
                                                                    Placeable placeable = list.get(i22);
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                                    arrayList3.add(new TabPosition(subcomposeMeasureScope2.toDp-u2uoSUM(i21), subcomposeMeasureScope2.toDp-u2uoSUM(placeable.getWidth()), list2.get(i22).unbox-impl(), null));
                                                                    i21 += placeable.getWidth();
                                                                }
                                                                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                                long j7 = j5;
                                                                int i23 = intValue2;
                                                                int i24 = intValue;
                                                                int i25 = 0;
                                                                for (int size5 = subcompose2.size(); i25 < size5; size5 = size5) {
                                                                    Placeable mo6318measureBRTryo02 = subcompose2.get(i25).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j7, i23, i23, 0, 0, 8, (Object) null));
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo02, 0, i24 - mo6318measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                                    i25++;
                                                                }
                                                                SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                                TabSlots tabSlots = TabSlots.Indicator;
                                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                                                List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                    {
                                                                        super(2);
                                                                    }

                                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                                        return Unit.INSTANCE;
                                                                    }

                                                                    public final void invoke(Composer composer3, int i26) {
                                                                        ComposerKt.sourceInformation(composer3, "C942@41500L23:TabRow.kt#uh7d8r");
                                                                        if ((i26 & 3) == 2 && composer3.getSkipping()) {
                                                                            composer3.skipToGroupEnd();
                                                                            return;
                                                                        }
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventStart(358596038, i26, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                                        }
                                                                        function34.invoke(arrayList3, composer3, 0);
                                                                        if (ComposerKt.isTraceInProgress()) {
                                                                            ComposerKt.traceEventEnd();
                                                                        }
                                                                    }
                                                                }));
                                                                int i26 = intValue2;
                                                                int i27 = intValue;
                                                                int size6 = subcompose3.size();
                                                                for (int i28 = 0; i28 < size6; i28++) {
                                                                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo6318measureBRTryo0(Constraints.Companion.fixed-JhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                                                }
                                                                scrollableTabData2.onLaidOut(subcomposeMeasureScope, i15, arrayList3, i20);
                                                            }
                                                        }, 4, null);
                                                    }
                                                };
                                                composer2.updateRememberedValue(rememberedValue3);
                                            }
                                            composer2.endReplaceableGroup();
                                            SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer2, 0, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }), startRestartGroup, i102 | (i112 & 896) | (i112 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                f2 = f32;
                                function23 = m2432getLambda7$material3_release;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                function23 = function2;
                            }
                            final Modifier modifier3 = modifier2;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final long j5 = j3;
                                final long j6 = j4;
                                final float f4 = f2;
                                final Function2<? super Composer, ? super Integer, Unit> function25 = function23;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$2
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

                                    public final void invoke(Composer composer2, int i12) {
                                        TabRowKt.m3102ScrollableTabRowImpqhFBPw4(i, function3, modifier3, j5, j6, f4, function25, function22, scrollState, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i4 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if ((i3 & 8) != 0) {
                        }
                        if ((i3 & 16) != 0) {
                        }
                        if (i6 != 0) {
                        }
                        if (i7 != 0) {
                        }
                        m2432getLambda7$material3_release = function2;
                        final float f322 = f2;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> function2422 = m2432getLambda7$material3_release;
                        int i1022 = ((i4 >> 6) & 14) | 12582912;
                        int i1122 = i4 >> 3;
                        SurfaceKt.m3043SurfaceT9BRK9s(modifier2, null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                            public final void invoke(Composer composer2, int i12) {
                                ComposerKt.sourceInformation(composer2, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                                if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1178901494, i12, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                                    }
                                    composer2.startReplaceableGroup(773894976);
                                    ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                    composer2.startReplaceableGroup(-492369756);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                                    Object rememberedValue = composer2.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                                        composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                        rememberedValue = compositionScopedCoroutineScopeCanceller;
                                    }
                                    composer2.endReplaceableGroup();
                                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                    composer2.endReplaceableGroup();
                                    composer2.startReplaceableGroup(121290627);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                                    boolean changed = composer2.changed(ScrollState.this) | composer2.changed(coroutineScope);
                                    ScrollState scrollState2 = ScrollState.this;
                                    Object rememberedValue2 = composer2.rememberedValue();
                                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                        composer2.updateRememberedValue(rememberedValue2);
                                    }
                                    final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                    composer2.endReplaceableGroup();
                                    Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                    composer2.startReplaceableGroup(121291080);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                                    boolean changed2 = composer2.changed(f322) | composer2.changed(function22) | composer2.changed(function2422) | composer2.changed(function3) | composer2.changedInstance(scrollableTabData) | composer2.changed(i);
                                    final float f42 = f322;
                                    final Function2<? super Composer, ? super Integer, Unit> function252 = function22;
                                    final Function2<? super Composer, ? super Integer, Unit> function26 = function2422;
                                    final int i13 = i;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32 = function3;
                                    Object rememberedValue3 = composer2.rememberedValue();
                                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                return m3111invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                            }

                                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                            public final MeasureResult m3111invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j52) {
                                                float f5;
                                                f5 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                                int i14 = subcomposeMeasureScope.roundToPx-0680j_4(f5);
                                                final int i15 = subcomposeMeasureScope.roundToPx-0680j_4(f42);
                                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function252);
                                                int i16 = 0;
                                                int size = subcompose.size();
                                                for (int i17 = 0; i17 < size; i17++) {
                                                    i16 = Integer.valueOf(Math.max(i16.intValue(), subcompose.get(i17).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                                }
                                                final int intValue = i16.intValue();
                                                long j62 = Constraints.copy-Zbe2FdA$default(j52, i14, 0, intValue, intValue, 2, (Object) null);
                                                final List<Placeable> arrayList = new ArrayList();
                                                final List<Dp> arrayList2 = new ArrayList();
                                                int size2 = subcompose.size();
                                                for (int i18 = 0; i18 < size2; i18++) {
                                                    Measurable measurable = subcompose.get(i18);
                                                    Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j62);
                                                    float f6 = Dp.constructor-impl(subcomposeMeasureScope.toDp-u2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo6318measureBRTryo0.getHeight()), mo6318measureBRTryo0.getWidth())) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * 2));
                                                    arrayList.add(mo6318measureBRTryo0);
                                                    arrayList2.add(Dp.box-impl(f6));
                                                }
                                                Integer valueOf = Integer.valueOf(i15 * 2);
                                                int size3 = arrayList.size();
                                                for (int i19 = 0; i19 < size3; i19++) {
                                                    valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i19)).getWidth());
                                                }
                                                final int intValue2 = valueOf.intValue();
                                                final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                                final int i20 = i13;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32;
                                                return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                        invoke((Placeable.PlacementScope) obj);
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                                        final List<TabPosition> arrayList3 = new ArrayList();
                                                        int i21 = i15;
                                                        List<Placeable> list = arrayList;
                                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                        List<Dp> list2 = arrayList2;
                                                        int size4 = list.size();
                                                        for (int i22 = 0; i22 < size4; i22++) {
                                                            Placeable placeable = list.get(i22);
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.toDp-u2uoSUM(i21), subcomposeMeasureScope2.toDp-u2uoSUM(placeable.getWidth()), list2.get(i22).unbox-impl(), null));
                                                            i21 += placeable.getWidth();
                                                        }
                                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                        long j7 = j52;
                                                        int i23 = intValue2;
                                                        int i24 = intValue;
                                                        int i25 = 0;
                                                        for (int size5 = subcompose2.size(); i25 < size5; size5 = size5) {
                                                            Placeable mo6318measureBRTryo02 = subcompose2.get(i25).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j7, i23, i23, 0, 0, 8, (Object) null));
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo02, 0, i24 - mo6318measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                            i25++;
                                                        }
                                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                        TabSlots tabSlots = TabSlots.Indicator;
                                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            /* JADX WARN: Multi-variable type inference failed */
                                                            {
                                                                super(2);
                                                            }

                                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer3, int i26) {
                                                                ComposerKt.sourceInformation(composer3, "C942@41500L23:TabRow.kt#uh7d8r");
                                                                if ((i26 & 3) == 2 && composer3.getSkipping()) {
                                                                    composer3.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(358596038, i26, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                                }
                                                                function34.invoke(arrayList3, composer3, 0);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }));
                                                        int i26 = intValue2;
                                                        int i27 = intValue;
                                                        int size6 = subcompose3.size();
                                                        for (int i28 = 0; i28 < size6; i28++) {
                                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo6318measureBRTryo0(Constraints.Companion.fixed-JhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                                        }
                                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i15, arrayList3, i20);
                                                    }
                                                }, 4, null);
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue3);
                                    }
                                    composer2.endReplaceableGroup();
                                    SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer2, 0, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, i1022 | (i1122 & 896) | (i1122 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        f2 = f322;
                        function23 = m2432getLambda7$material3_release;
                        final Modifier modifier32 = modifier2;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    if ((i3 & Fields.RotationX) != 0) {
                    }
                    if ((i4 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if ((i3 & 8) != 0) {
                    }
                    if ((i3 & 16) != 0) {
                    }
                    if (i6 != 0) {
                    }
                    if (i7 != 0) {
                    }
                    m2432getLambda7$material3_release = function2;
                    final float f3222 = f2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> function24222 = m2432getLambda7$material3_release;
                    int i10222 = ((i4 >> 6) & 14) | 12582912;
                    int i11222 = i4 >> 3;
                    SurfaceKt.m3043SurfaceT9BRK9s(modifier2, null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                        public final void invoke(Composer composer2, int i12) {
                            ComposerKt.sourceInformation(composer2, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                            if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1178901494, i12, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                                }
                                composer2.startReplaceableGroup(773894976);
                                ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                                composer2.startReplaceableGroup(-492369756);
                                ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                                Object rememberedValue = composer2.rememberedValue();
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                                    composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                                }
                                composer2.endReplaceableGroup();
                                CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                composer2.endReplaceableGroup();
                                composer2.startReplaceableGroup(121290627);
                                ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                                boolean changed = composer2.changed(ScrollState.this) | composer2.changed(coroutineScope);
                                ScrollState scrollState2 = ScrollState.this;
                                Object rememberedValue2 = composer2.rememberedValue();
                                if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                    composer2.updateRememberedValue(rememberedValue2);
                                }
                                final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                                composer2.endReplaceableGroup();
                                Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                                composer2.startReplaceableGroup(121291080);
                                ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                                boolean changed2 = composer2.changed(f3222) | composer2.changed(function22) | composer2.changed(function24222) | composer2.changed(function3) | composer2.changedInstance(scrollableTabData) | composer2.changed(i);
                                final float f42 = f3222;
                                final Function2<? super Composer, ? super Integer, Unit> function252 = function22;
                                final Function2<? super Composer, ? super Integer, Unit> function26 = function24222;
                                final int i13 = i;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32 = function3;
                                Object rememberedValue3 = composer2.rememberedValue();
                                if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(2);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                            return m3111invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                        }

                                        /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                        public final MeasureResult m3111invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j52) {
                                            float f5;
                                            f5 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                            int i14 = subcomposeMeasureScope.roundToPx-0680j_4(f5);
                                            final int i15 = subcomposeMeasureScope.roundToPx-0680j_4(f42);
                                            List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function252);
                                            int i16 = 0;
                                            int size = subcompose.size();
                                            for (int i17 = 0; i17 < size; i17++) {
                                                i16 = Integer.valueOf(Math.max(i16.intValue(), subcompose.get(i17).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                            }
                                            final int intValue = i16.intValue();
                                            long j62 = Constraints.copy-Zbe2FdA$default(j52, i14, 0, intValue, intValue, 2, (Object) null);
                                            final List<Placeable> arrayList = new ArrayList();
                                            final List<Dp> arrayList2 = new ArrayList();
                                            int size2 = subcompose.size();
                                            for (int i18 = 0; i18 < size2; i18++) {
                                                Measurable measurable = subcompose.get(i18);
                                                Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j62);
                                                float f6 = Dp.constructor-impl(subcomposeMeasureScope.toDp-u2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo6318measureBRTryo0.getHeight()), mo6318measureBRTryo0.getWidth())) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * 2));
                                                arrayList.add(mo6318measureBRTryo0);
                                                arrayList2.add(Dp.box-impl(f6));
                                            }
                                            Integer valueOf = Integer.valueOf(i15 * 2);
                                            int size3 = arrayList.size();
                                            for (int i19 = 0; i19 < size3; i19++) {
                                                valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i19)).getWidth());
                                            }
                                            final int intValue2 = valueOf.intValue();
                                            final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                            final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                            final int i20 = i13;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32;
                                            return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(1);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                    invoke((Placeable.PlacementScope) obj);
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Placeable.PlacementScope placementScope) {
                                                    final List<TabPosition> arrayList3 = new ArrayList();
                                                    int i21 = i15;
                                                    List<Placeable> list = arrayList;
                                                    SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                    List<Dp> list2 = arrayList2;
                                                    int size4 = list.size();
                                                    for (int i22 = 0; i22 < size4; i22++) {
                                                        Placeable placeable = list.get(i22);
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                        arrayList3.add(new TabPosition(subcomposeMeasureScope2.toDp-u2uoSUM(i21), subcomposeMeasureScope2.toDp-u2uoSUM(placeable.getWidth()), list2.get(i22).unbox-impl(), null));
                                                        i21 += placeable.getWidth();
                                                    }
                                                    List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                    long j7 = j52;
                                                    int i23 = intValue2;
                                                    int i24 = intValue;
                                                    int i25 = 0;
                                                    for (int size5 = subcompose2.size(); i25 < size5; size5 = size5) {
                                                        Placeable mo6318measureBRTryo02 = subcompose2.get(i25).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j7, i23, i23, 0, 0, 8, (Object) null));
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo02, 0, i24 - mo6318measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                        i25++;
                                                    }
                                                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                    TabSlots tabSlots = TabSlots.Indicator;
                                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                                    List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        {
                                                            super(2);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(Composer composer3, int i26) {
                                                            ComposerKt.sourceInformation(composer3, "C942@41500L23:TabRow.kt#uh7d8r");
                                                            if ((i26 & 3) == 2 && composer3.getSkipping()) {
                                                                composer3.skipToGroupEnd();
                                                                return;
                                                            }
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(358596038, i26, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                            }
                                                            function34.invoke(arrayList3, composer3, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                            }
                                                        }
                                                    }));
                                                    int i26 = intValue2;
                                                    int i27 = intValue;
                                                    int size6 = subcompose3.size();
                                                    for (int i28 = 0; i28 < size6; i28++) {
                                                        Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo6318measureBRTryo0(Constraints.Companion.fixed-JhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                                    }
                                                    scrollableTabData2.onLaidOut(subcomposeMeasureScope, i15, arrayList3, i20);
                                                }
                                            }, 4, null);
                                        }
                                    };
                                    composer2.updateRememberedValue(rememberedValue3);
                                }
                                composer2.endReplaceableGroup();
                                SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer2, 0, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, i10222 | (i11222 & 896) | (i11222 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    f2 = f3222;
                    function23 = m2432getLambda7$material3_release;
                    final Modifier modifier322 = modifier2;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                f2 = f;
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                if ((i3 & Fields.SpotShadowColor) == 0) {
                }
                if ((i3 & Fields.RotationX) != 0) {
                }
                if ((i4 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i5 != 0) {
                }
                if ((i3 & 8) != 0) {
                }
                if ((i3 & 16) != 0) {
                }
                if (i6 != 0) {
                }
                if (i7 != 0) {
                }
                m2432getLambda7$material3_release = function2;
                final float f32222 = f2;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function2<? super Composer, ? super Integer, Unit> function242222 = m2432getLambda7$material3_release;
                int i102222 = ((i4 >> 6) & 14) | 12582912;
                int i112222 = i4 >> 3;
                SurfaceKt.m3043SurfaceT9BRK9s(modifier2, null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                    public final void invoke(Composer composer2, int i12) {
                        ComposerKt.sourceInformation(composer2, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                        if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1178901494, i12, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                            }
                            composer2.startReplaceableGroup(773894976);
                            ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                            composer2.startReplaceableGroup(-492369756);
                            ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                            Object rememberedValue = composer2.rememberedValue();
                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                                composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                rememberedValue = compositionScopedCoroutineScopeCanceller;
                            }
                            composer2.endReplaceableGroup();
                            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                            composer2.endReplaceableGroup();
                            composer2.startReplaceableGroup(121290627);
                            ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                            boolean changed = composer2.changed(ScrollState.this) | composer2.changed(coroutineScope);
                            ScrollState scrollState2 = ScrollState.this;
                            Object rememberedValue2 = composer2.rememberedValue();
                            if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                                composer2.updateRememberedValue(rememberedValue2);
                            }
                            final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                            composer2.endReplaceableGroup();
                            Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                            composer2.startReplaceableGroup(121291080);
                            ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                            boolean changed2 = composer2.changed(f32222) | composer2.changed(function22) | composer2.changed(function242222) | composer2.changed(function3) | composer2.changedInstance(scrollableTabData) | composer2.changed(i);
                            final float f42 = f32222;
                            final Function2<? super Composer, ? super Integer, Unit> function252 = function22;
                            final Function2<? super Composer, ? super Integer, Unit> function26 = function242222;
                            final int i13 = i;
                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32 = function3;
                            Object rememberedValue3 = composer2.rememberedValue();
                            if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        return m3111invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                    }

                                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                    public final MeasureResult m3111invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j52) {
                                        float f5;
                                        f5 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                        int i14 = subcomposeMeasureScope.roundToPx-0680j_4(f5);
                                        final int i15 = subcomposeMeasureScope.roundToPx-0680j_4(f42);
                                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function252);
                                        int i16 = 0;
                                        int size = subcompose.size();
                                        for (int i17 = 0; i17 < size; i17++) {
                                            i16 = Integer.valueOf(Math.max(i16.intValue(), subcompose.get(i17).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                        }
                                        final int intValue = i16.intValue();
                                        long j62 = Constraints.copy-Zbe2FdA$default(j52, i14, 0, intValue, intValue, 2, (Object) null);
                                        final List<Placeable> arrayList = new ArrayList();
                                        final List<Dp> arrayList2 = new ArrayList();
                                        int size2 = subcompose.size();
                                        for (int i18 = 0; i18 < size2; i18++) {
                                            Measurable measurable = subcompose.get(i18);
                                            Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j62);
                                            float f6 = Dp.constructor-impl(subcomposeMeasureScope.toDp-u2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo6318measureBRTryo0.getHeight()), mo6318measureBRTryo0.getWidth())) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * 2));
                                            arrayList.add(mo6318measureBRTryo0);
                                            arrayList2.add(Dp.box-impl(f6));
                                        }
                                        Integer valueOf = Integer.valueOf(i15 * 2);
                                        int size3 = arrayList.size();
                                        for (int i19 = 0; i19 < size3; i19++) {
                                            valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i19)).getWidth());
                                        }
                                        final int intValue2 = valueOf.intValue();
                                        final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                        final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                        final int i20 = i13;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32;
                                        return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((Placeable.PlacementScope) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Placeable.PlacementScope placementScope) {
                                                final List<TabPosition> arrayList3 = new ArrayList();
                                                int i21 = i15;
                                                List<Placeable> list = arrayList;
                                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                                List<Dp> list2 = arrayList2;
                                                int size4 = list.size();
                                                for (int i22 = 0; i22 < size4; i22++) {
                                                    Placeable placeable = list.get(i22);
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                    arrayList3.add(new TabPosition(subcomposeMeasureScope2.toDp-u2uoSUM(i21), subcomposeMeasureScope2.toDp-u2uoSUM(placeable.getWidth()), list2.get(i22).unbox-impl(), null));
                                                    i21 += placeable.getWidth();
                                                }
                                                List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                                long j7 = j52;
                                                int i23 = intValue2;
                                                int i24 = intValue;
                                                int i25 = 0;
                                                for (int size5 = subcompose2.size(); i25 < size5; size5 = size5) {
                                                    Placeable mo6318measureBRTryo02 = subcompose2.get(i25).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j7, i23, i23, 0, 0, 8, (Object) null));
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo02, 0, i24 - mo6318measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                    i25++;
                                                }
                                                SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                                TabSlots tabSlots = TabSlots.Indicator;
                                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                                List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(2);
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i26) {
                                                        ComposerKt.sourceInformation(composer3, "C942@41500L23:TabRow.kt#uh7d8r");
                                                        if ((i26 & 3) == 2 && composer3.getSkipping()) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(358596038, i26, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                        }
                                                        function34.invoke(arrayList3, composer3, 0);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }));
                                                int i26 = intValue2;
                                                int i27 = intValue;
                                                int size6 = subcompose3.size();
                                                for (int i28 = 0; i28 < size6; i28++) {
                                                    Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo6318measureBRTryo0(Constraints.Companion.fixed-JhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                                }
                                                scrollableTabData2.onLaidOut(subcomposeMeasureScope, i15, arrayList3, i20);
                                            }
                                        }, 4, null);
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue3);
                            }
                            composer2.endReplaceableGroup();
                            SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer2, 0, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, i102222 | (i112222 & 896) | (i112222 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                }
                f2 = f32222;
                function23 = m2432getLambda7$material3_release;
                final Modifier modifier3222 = modifier2;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            modifier2 = modifier;
            if ((i2 & 3072) == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            i6 = i3 & 32;
            if (i6 != 0) {
            }
            f2 = f;
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            if ((i3 & Fields.SpotShadowColor) == 0) {
            }
            if ((i3 & Fields.RotationX) != 0) {
            }
            if ((i4 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i5 != 0) {
            }
            if ((i3 & 8) != 0) {
            }
            if ((i3 & 16) != 0) {
            }
            if (i6 != 0) {
            }
            if (i7 != 0) {
            }
            m2432getLambda7$material3_release = function2;
            final float f322222 = f2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function2<? super Composer, ? super Integer, Unit> function2422222 = m2432getLambda7$material3_release;
            int i1022222 = ((i4 >> 6) & 14) | 12582912;
            int i1122222 = i4 >> 3;
            SurfaceKt.m3043SurfaceT9BRK9s(modifier2, null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

                public final void invoke(Composer composer2, int i12) {
                    ComposerKt.sourceInformation(composer2, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                    if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1178901494, i12, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                        }
                        composer2.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                        composer2.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                        Object rememberedValue = composer2.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                            composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                            rememberedValue = compositionScopedCoroutineScopeCanceller;
                        }
                        composer2.endReplaceableGroup();
                        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                        composer2.endReplaceableGroup();
                        composer2.startReplaceableGroup(121290627);
                        ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                        boolean changed = composer2.changed(ScrollState.this) | composer2.changed(coroutineScope);
                        ScrollState scrollState2 = ScrollState.this;
                        Object rememberedValue2 = composer2.rememberedValue();
                        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                            composer2.updateRememberedValue(rememberedValue2);
                        }
                        final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                        composer2.endReplaceableGroup();
                        Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                        composer2.startReplaceableGroup(121291080);
                        ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                        boolean changed2 = composer2.changed(f322222) | composer2.changed(function22) | composer2.changed(function2422222) | composer2.changed(function3) | composer2.changedInstance(scrollableTabData) | composer2.changed(i);
                        final float f42 = f322222;
                        final Function2<? super Composer, ? super Integer, Unit> function252 = function22;
                        final Function2<? super Composer, ? super Integer, Unit> function26 = function2422222;
                        final int i13 = i;
                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32 = function3;
                        Object rememberedValue3 = composer2.rememberedValue();
                        if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    return m3111invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                                }

                                /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                                public final MeasureResult m3111invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j52) {
                                    float f5;
                                    f5 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                    int i14 = subcomposeMeasureScope.roundToPx-0680j_4(f5);
                                    final int i15 = subcomposeMeasureScope.roundToPx-0680j_4(f42);
                                    List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function252);
                                    int i16 = 0;
                                    int size = subcompose.size();
                                    for (int i17 = 0; i17 < size; i17++) {
                                        i16 = Integer.valueOf(Math.max(i16.intValue(), subcompose.get(i17).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                    }
                                    final int intValue = i16.intValue();
                                    long j62 = Constraints.copy-Zbe2FdA$default(j52, i14, 0, intValue, intValue, 2, (Object) null);
                                    final List<Placeable> arrayList = new ArrayList();
                                    final List<Dp> arrayList2 = new ArrayList();
                                    int size2 = subcompose.size();
                                    for (int i18 = 0; i18 < size2; i18++) {
                                        Measurable measurable = subcompose.get(i18);
                                        Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j62);
                                        float f6 = Dp.constructor-impl(subcomposeMeasureScope.toDp-u2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo6318measureBRTryo0.getHeight()), mo6318measureBRTryo0.getWidth())) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * 2));
                                        arrayList.add(mo6318measureBRTryo0);
                                        arrayList2.add(Dp.box-impl(f6));
                                    }
                                    Integer valueOf = Integer.valueOf(i15 * 2);
                                    int size3 = arrayList.size();
                                    for (int i19 = 0; i19 < size3; i19++) {
                                        valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i19)).getWidth());
                                    }
                                    final int intValue2 = valueOf.intValue();
                                    final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                    final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                    final int i20 = i13;
                                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32;
                                    return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            final List<TabPosition> arrayList3 = new ArrayList();
                                            int i21 = i15;
                                            List<Placeable> list = arrayList;
                                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                            List<Dp> list2 = arrayList2;
                                            int size4 = list.size();
                                            for (int i22 = 0; i22 < size4; i22++) {
                                                Placeable placeable = list.get(i22);
                                                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                                arrayList3.add(new TabPosition(subcomposeMeasureScope2.toDp-u2uoSUM(i21), subcomposeMeasureScope2.toDp-u2uoSUM(placeable.getWidth()), list2.get(i22).unbox-impl(), null));
                                                i21 += placeable.getWidth();
                                            }
                                            List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                            long j7 = j52;
                                            int i23 = intValue2;
                                            int i24 = intValue;
                                            int i25 = 0;
                                            for (int size5 = subcompose2.size(); i25 < size5; size5 = size5) {
                                                Placeable mo6318measureBRTryo02 = subcompose2.get(i25).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j7, i23, i23, 0, 0, 8, (Object) null));
                                                Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo02, 0, i24 - mo6318measureBRTryo02.getHeight(), 0.0f, 4, null);
                                                i25++;
                                            }
                                            SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                            TabSlots tabSlots = TabSlots.Indicator;
                                            final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                            List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                /* JADX WARN: Multi-variable type inference failed */
                                                {
                                                    super(2);
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i26) {
                                                    ComposerKt.sourceInformation(composer3, "C942@41500L23:TabRow.kt#uh7d8r");
                                                    if ((i26 & 3) == 2 && composer3.getSkipping()) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(358596038, i26, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                    }
                                                    function34.invoke(arrayList3, composer3, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }));
                                            int i26 = intValue2;
                                            int i27 = intValue;
                                            int size6 = subcompose3.size();
                                            for (int i28 = 0; i28 < size6; i28++) {
                                                Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo6318measureBRTryo0(Constraints.Companion.fixed-JhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                            }
                                            scrollableTabData2.onLaidOut(subcomposeMeasureScope, i15, arrayList3, i20);
                                        }
                                    }, 4, null);
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue3);
                        }
                        composer2.endReplaceableGroup();
                        SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer2, 0, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, i1022222 | (i1122222 & 896) | (i1122222 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
            }
            f2 = f322222;
            function23 = m2432getLambda7$material3_release;
            final Modifier modifier32222 = modifier2;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        modifier2 = modifier;
        if ((i2 & 3072) == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        i6 = i3 & 32;
        if (i6 != 0) {
        }
        f2 = f;
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        if ((i3 & Fields.SpotShadowColor) == 0) {
        }
        if ((i3 & Fields.RotationX) != 0) {
        }
        if ((i4 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i5 != 0) {
        }
        if ((i3 & 8) != 0) {
        }
        if ((i3 & 16) != 0) {
        }
        if (i6 != 0) {
        }
        if (i7 != 0) {
        }
        m2432getLambda7$material3_release = function2;
        final float f3222222 = f2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function2<? super Composer, ? super Integer, Unit> function24222222 = m2432getLambda7$material3_release;
        int i10222222 = ((i4 >> 6) & 14) | 12582912;
        int i11222222 = i4 >> 3;
        SurfaceKt.m3043SurfaceT9BRK9s(modifier2, null, j3, j4, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1178901494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1
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

            public final void invoke(Composer composer2, int i12) {
                ComposerKt.sourceInformation(composer2, "C861@38118L24,862@38175L185,875@38628L3325,868@38369L3584:TabRow.kt#uh7d8r");
                if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1178901494, i12, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous> (TabRow.kt:861)");
                    }
                    composer2.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation(composer2, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                    composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation(composer2, "CC(remember):Composables.kt#9igjgp");
                    Object rememberedValue = composer2.rememberedValue();
                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                        Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer2));
                        composer2.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                        rememberedValue = compositionScopedCoroutineScopeCanceller;
                    }
                    composer2.endReplaceableGroup();
                    CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                    composer2.endReplaceableGroup();
                    composer2.startReplaceableGroup(121290627);
                    ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                    boolean changed = composer2.changed(ScrollState.this) | composer2.changed(coroutineScope);
                    ScrollState scrollState2 = ScrollState.this;
                    Object rememberedValue2 = composer2.rememberedValue();
                    if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new ScrollableTabData(scrollState2, coroutineScope);
                        composer2.updateRememberedValue(rememberedValue2);
                    }
                    final ScrollableTabData scrollableTabData = (ScrollableTabData) rememberedValue2;
                    composer2.endReplaceableGroup();
                    Modifier clipToBounds = ClipKt.clipToBounds(SelectableGroupKt.selectableGroup(ScrollKt.horizontalScroll$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getCenterStart(), false, 2, null), ScrollState.this, false, null, false, 14, null)));
                    composer2.startReplaceableGroup(121291080);
                    ComposerKt.sourceInformation(composer2, "CC(remember):TabRow.kt#9igjgp");
                    boolean changed2 = composer2.changed(f3222222) | composer2.changed(function22) | composer2.changed(function24222222) | composer2.changed(function3) | composer2.changedInstance(scrollableTabData) | composer2.changed(i);
                    final float f42 = f3222222;
                    final Function2<? super Composer, ? super Integer, Unit> function252 = function22;
                    final Function2<? super Composer, ? super Integer, Unit> function26 = function24222222;
                    final int i13 = i;
                    final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function32 = function3;
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changed2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue3 = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                return m3111invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).unbox-impl());
                            }

                            /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                            public final MeasureResult m3111invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, final long j52) {
                                float f5;
                                f5 = TabRowKt.ScrollableTabRowMinimumTabWidth;
                                int i14 = subcomposeMeasureScope.roundToPx-0680j_4(f5);
                                final int i15 = subcomposeMeasureScope.roundToPx-0680j_4(f42);
                                List<Measurable> subcompose = subcomposeMeasureScope.subcompose(TabSlots.Tabs, function252);
                                int i16 = 0;
                                int size = subcompose.size();
                                for (int i17 = 0; i17 < size; i17++) {
                                    i16 = Integer.valueOf(Math.max(i16.intValue(), subcompose.get(i17).maxIntrinsicHeight(Integer.MAX_VALUE)));
                                }
                                final int intValue = i16.intValue();
                                long j62 = Constraints.copy-Zbe2FdA$default(j52, i14, 0, intValue, intValue, 2, (Object) null);
                                final List<Placeable> arrayList = new ArrayList();
                                final List<Dp> arrayList2 = new ArrayList();
                                int size2 = subcompose.size();
                                for (int i18 = 0; i18 < size2; i18++) {
                                    Measurable measurable = subcompose.get(i18);
                                    Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(j62);
                                    float f6 = Dp.constructor-impl(subcomposeMeasureScope.toDp-u2uoSUM(Math.min(measurable.maxIntrinsicWidth(mo6318measureBRTryo0.getHeight()), mo6318measureBRTryo0.getWidth())) - Dp.constructor-impl(TabKt.getHorizontalTextPadding() * 2));
                                    arrayList.add(mo6318measureBRTryo0);
                                    arrayList2.add(Dp.box-impl(f6));
                                }
                                Integer valueOf = Integer.valueOf(i15 * 2);
                                int size3 = arrayList.size();
                                for (int i19 = 0; i19 < size3; i19++) {
                                    valueOf = Integer.valueOf(valueOf.intValue() + ((Placeable) arrayList.get(i19)).getWidth());
                                }
                                final int intValue2 = valueOf.intValue();
                                final Function2<? super Composer, ? super Integer, Unit> function27 = function26;
                                final ScrollableTabData scrollableTabData2 = scrollableTabData;
                                final int i20 = i13;
                                final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function33 = function32;
                                return MeasureScope.layout$default(subcomposeMeasureScope, intValue2, intValue, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TabRowKt$ScrollableTabRowImp$1$1$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((Placeable.PlacementScope) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Placeable.PlacementScope placementScope) {
                                        final List<TabPosition> arrayList3 = new ArrayList();
                                        int i21 = i15;
                                        List<Placeable> list = arrayList;
                                        SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                        List<Dp> list2 = arrayList2;
                                        int size4 = list.size();
                                        for (int i22 = 0; i22 < size4; i22++) {
                                            Placeable placeable = list.get(i22);
                                            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i21, 0, 0.0f, 4, null);
                                            arrayList3.add(new TabPosition(subcomposeMeasureScope2.toDp-u2uoSUM(i21), subcomposeMeasureScope2.toDp-u2uoSUM(placeable.getWidth()), list2.get(i22).unbox-impl(), null));
                                            i21 += placeable.getWidth();
                                        }
                                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(TabSlots.Divider, function27);
                                        long j7 = j52;
                                        int i23 = intValue2;
                                        int i24 = intValue;
                                        int i25 = 0;
                                        for (int size5 = subcompose2.size(); i25 < size5; size5 = size5) {
                                            Placeable mo6318measureBRTryo02 = subcompose2.get(i25).mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j7, i23, i23, 0, 0, 8, (Object) null));
                                            Placeable.PlacementScope.placeRelative$default(placementScope, mo6318measureBRTryo02, 0, i24 - mo6318measureBRTryo02.getHeight(), 0.0f, 4, null);
                                            i25++;
                                        }
                                        SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                                        TabSlots tabSlots = TabSlots.Indicator;
                                        final Function3<? super List<TabPosition>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                        List<Measurable> subcompose3 = subcomposeMeasureScope3.subcompose(tabSlots, ComposableLambdaKt.composableLambdaInstance(358596038, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.TabRowKt.ScrollableTabRowImp.1.1.1.2.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            /* JADX WARN: Multi-variable type inference failed */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i26) {
                                                ComposerKt.sourceInformation(composer3, "C942@41500L23:TabRow.kt#uh7d8r");
                                                if ((i26 & 3) == 2 && composer3.getSkipping()) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(358596038, i26, -1, "androidx.compose.material3.ScrollableTabRowImp.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TabRow.kt:942)");
                                                }
                                                function34.invoke(arrayList3, composer3, 0);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }));
                                        int i26 = intValue2;
                                        int i27 = intValue;
                                        int size6 = subcompose3.size();
                                        for (int i28 = 0; i28 < size6; i28++) {
                                            Placeable.PlacementScope.placeRelative$default(placementScope, subcompose3.get(i28).mo6318measureBRTryo0(Constraints.Companion.fixed-JhjzzOo(i26, i27)), 0, 0, 0.0f, 4, null);
                                        }
                                        scrollableTabData2.onLaidOut(subcomposeMeasureScope, i15, arrayList3, i20);
                                    }
                                }, 4, null);
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    composer2.endReplaceableGroup();
                    SubcomposeLayoutKt.SubcomposeLayout(clipToBounds, (Function2) rememberedValue3, composer2, 0, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, i10222222 | (i11222222 & 896) | (i11222222 & 7168), 114);
        if (ComposerKt.isTraceInProgress()) {
        }
        f2 = f3222222;
        function23 = m2432getLambda7$material3_release;
        final Modifier modifier322222 = modifier2;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
