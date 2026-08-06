package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.p002ui.layout.SubcomposeLayoutKt;
import androidx.compose.p002ui.layout.SubcomposeMeasureScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Scaffold.kt */
@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u0087\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001f\u001a\u00020 2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a±\u0001\u0010$\u001a\u00020\u00142\b\b\u0002\u0010%\u001a\u00020&2\u0013\b\u0002\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0013\b\u0002\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\b\b\u0002\u0010)\u001a\u00020\u00162\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020+2\b\b\u0002\u0010\u001f\u001a\u00020 2\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\b\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\b-\u0010.\u001a\u0087\u0001\u0010/\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001f\u001a\u00020 2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b0\u0010#\u001a\u0087\u0001\u00101\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00140\u001b¢\u0006\u0002\b\u00192\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0011\u0010\u001e\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u00192\u0006\u0010\u001f\u001a\u00020 2\u0011\u0010!\u001a\r\u0012\u0004\u0012\u00020\u00140\u0018¢\u0006\u0002\b\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u0010#\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"1\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "<set-?>", "", "ScaffoldSubcomposeInMeasureFix", "getScaffoldSubcomposeInMeasureFix$annotations", "()V", "getScaffoldSubcomposeInMeasureFix", "()Z", "setScaffoldSubcomposeInMeasureFix", "(Z)V", "ScaffoldSubcomposeInMeasureFix$delegate", "Landroidx/compose/runtime/MutableState;", "LegacyScaffoldLayout", "", "fabPosition", "Landroidx/compose/material3/FabPosition;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "snackbar", "fab", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "bottomBar", "LegacyScaffoldLayout-FMILGgc", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scaffold", "modifier", "Landroidx/compose/ui/Modifier;", "snackbarHost", "floatingActionButton", "floatingActionButtonPosition", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "Scaffold-TvnljyQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;IJJLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ScaffoldLayout", "ScaffoldLayout-FMILGgc", "ScaffoldLayoutWithMeasureFix", "ScaffoldLayoutWithMeasureFix-FMILGgc", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ScaffoldKt {
    private static final float FabSpacing;
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement;
    private static final MutableState ScaffoldSubcomposeInMeasureFix$delegate;

    public static /* synthetic */ void getScaffoldSubcomposeInMeasureFix$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0283  */
    /* renamed from: Scaffold-TvnljyQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2829ScaffoldTvnljyQ(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, int i, long j, long j2, WindowInsets windowInsets, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i2, final int i3) {
        int i4;
        Function2<? super Composer, ? super Integer, Unit> function25;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function26;
        int i6;
        int i7;
        Function2<? super Composer, ? super Integer, Unit> function27;
        int i8;
        int i9;
        long j3;
        Modifier.Companion companion;
        Function2<? super Composer, ? super Integer, Unit> m2418getLambda1$material3_release;
        Function2<? super Composer, ? super Integer, Unit> m2419getLambda2$material3_release;
        Function2<? super Composer, ? super Integer, Unit> m2420getLambda3$material3_release;
        Function2<? super Composer, ? super Integer, Unit> m2421getLambda4$material3_release;
        int m2581getEndERTFSPs;
        int i10;
        long j4;
        final WindowInsets contentWindowInsets;
        int i11;
        long j5;
        boolean z;
        Object rememberedValue;
        boolean changed;
        Object rememberedValue2;
        long j6;
        final Function2<? super Composer, ? super Integer, Unit> function28;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        WindowInsets windowInsets2;
        long j7;
        Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        int i12;
        Composer startRestartGroup = composer.startRestartGroup(-1219521777);
        ComposerKt.sourceInformation(startRestartGroup, "C(Scaffold)P(7,9!1,8,5,6:c#material3.FabPosition,1:c#ui.graphics.Color,3:c#ui.graphics.Color,4)92@4736L11,93@4786L31,94@4876L19,97@4971L86,101@5129L212,100@5062L664:Scaffold.kt#uh7d8r");
        int i13 = i3 & 1;
        if (i13 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (startRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        int i14 = i3 & 2;
        if (i14 != 0) {
            i4 |= 48;
        } else if ((i2 & 48) == 0) {
            function25 = function2;
            i4 |= startRestartGroup.changedInstance(function25) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i2 & 384) == 0) {
                function26 = function22;
                i4 |= startRestartGroup.changedInstance(function26) ? Fields.RotationX : Fields.SpotShadowColor;
                i6 = i3 & 8;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i4 |= startRestartGroup.changedInstance(function23) ? Fields.CameraDistance : Fields.RotationZ;
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        function27 = function24;
                        i4 |= startRestartGroup.changedInstance(function27) ? Fields.Clip : Fields.Shape;
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= 196608;
                        } else if ((i2 & 196608) == 0) {
                            i4 |= startRestartGroup.changed(i) ? Fields.RenderEffect : 65536;
                        }
                        if ((i2 & 1572864) == 0) {
                            i9 = i7;
                            i4 |= ((i3 & 64) == 0 && startRestartGroup.changed(j)) ? 1048576 : Fields.BlendMode;
                        } else {
                            i9 = i7;
                        }
                        if ((i2 & 12582912) == 0) {
                            j3 = j2;
                            i4 |= ((i3 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(j3)) ? 8388608 : 4194304;
                        } else {
                            j3 = j2;
                        }
                        if ((i2 & 100663296) == 0) {
                            if ((i3 & Fields.RotationX) == 0 && startRestartGroup.changed(windowInsets)) {
                                i12 = 67108864;
                                i4 |= i12;
                            }
                            i12 = 33554432;
                            i4 |= i12;
                        }
                        if ((i3 & Fields.RotationY) != 0) {
                            i4 |= 805306368;
                        } else if ((i2 & 805306368) == 0) {
                            i4 |= startRestartGroup.changedInstance(function3) ? 536870912 : 268435456;
                            if ((i4 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i2 & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    companion = i13 == 0 ? Modifier.INSTANCE : modifier;
                                    m2418getLambda1$material3_release = i14 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m2418getLambda1$material3_release() : function25;
                                    m2419getLambda2$material3_release = i5 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m2419getLambda2$material3_release() : function26;
                                    m2420getLambda3$material3_release = i6 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m2420getLambda3$material3_release() : function23;
                                    m2421getLambda4$material3_release = i9 == 0 ? ComposableSingletons$ScaffoldKt.INSTANCE.m2421getLambda4$material3_release() : function27;
                                    m2581getEndERTFSPs = i8 == 0 ? FabPosition.INSTANCE.m2581getEndERTFSPs() : i;
                                    if ((i3 & 64) == 0) {
                                        i10 = i4 & (-3670017);
                                        j4 = MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6).getBackground();
                                    } else {
                                        i10 = i4;
                                        j4 = j;
                                    }
                                    if ((i3 & Fields.SpotShadowColor) != 0) {
                                        j3 = ColorSchemeKt.m2381contentColorForek8zF_U(j4, startRestartGroup, (i10 >> 18) & 14);
                                        i10 &= -29360129;
                                    }
                                    if ((i3 & Fields.RotationX) != 0) {
                                        contentWindowInsets = ScaffoldDefaults.INSTANCE.getContentWindowInsets(startRestartGroup, 6);
                                        i10 &= -234881025;
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1219521777, i10, -1, "androidx.compose.material3.Scaffold (Scaffold.kt:96)");
                                        }
                                        startRestartGroup.startReplaceableGroup(-889185358);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                                        i11 = (234881024 & i10) ^ 100663296;
                                        if (i11 > 67108864 || !startRestartGroup.changed(contentWindowInsets)) {
                                            j5 = j3;
                                            if ((i10 & 100663296) != 67108864) {
                                                z = false;
                                                rememberedValue = startRestartGroup.rememberedValue();
                                                if (!z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue = new MutableWindowInsets(contentWindowInsets);
                                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                                }
                                                final MutableWindowInsets mutableWindowInsets = (MutableWindowInsets) rememberedValue;
                                                startRestartGroup.endReplaceableGroup();
                                                startRestartGroup.startReplaceableGroup(-889185200);
                                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                                                changed = startRestartGroup.changed(mutableWindowInsets) | ((i11 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i10) == 67108864);
                                                rememberedValue2 = startRestartGroup.rememberedValue();
                                                if (!changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                    rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                            invoke((WindowInsets) obj);
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(WindowInsets windowInsets3) {
                                                            MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets3));
                                                        }
                                                    };
                                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                                }
                                                startRestartGroup.endReplaceableGroup();
                                                final int i15 = m2581getEndERTFSPs;
                                                final Function2<? super Composer, ? super Integer, Unit> function211 = m2418getLambda1$material3_release;
                                                final Function2<? super Composer, ? super Integer, Unit> function212 = m2420getLambda3$material3_release;
                                                final Function2<? super Composer, ? super Integer, Unit> function213 = m2421getLambda4$material3_release;
                                                final Function2<? super Composer, ? super Integer, Unit> function214 = m2419getLambda2$material3_release;
                                                int i16 = i10 >> 12;
                                                SurfaceKt.m3043SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j4, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                                                    public final void invoke(Composer composer2, int i17) {
                                                        ComposerKt.sourceInformation(composer2, "C107@5422L298:Scaffold.kt#uh7d8r");
                                                        if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventStart(-1979205334, i17, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:107)");
                                                            }
                                                            ScaffoldKt.m2830ScaffoldLayoutFMILGgc(i15, function211, function3, function212, function213, mutableWindowInsets, function214, composer2, 0);
                                                            if (ComposerKt.isTraceInProgress()) {
                                                                ComposerKt.traceEventEnd();
                                                                return;
                                                            }
                                                            return;
                                                        }
                                                        composer2.skipToGroupEnd();
                                                    }
                                                }), startRestartGroup, (i16 & 896) | 12582912 | (i16 & 7168), 114);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                                j6 = j4;
                                                function28 = m2419getLambda2$material3_release;
                                                function29 = m2420getLambda3$material3_release;
                                                function210 = m2421getLambda4$material3_release;
                                                windowInsets2 = contentWindowInsets;
                                                j7 = j5;
                                                function25 = m2418getLambda1$material3_release;
                                                modifier2 = companion;
                                            }
                                        } else {
                                            j5 = j3;
                                        }
                                        z = true;
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (!z) {
                                        }
                                        rememberedValue = new MutableWindowInsets(contentWindowInsets);
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                        final MutableWindowInsets mutableWindowInsets2 = (MutableWindowInsets) rememberedValue;
                                        startRestartGroup.endReplaceableGroup();
                                        startRestartGroup.startReplaceableGroup(-889185200);
                                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                                        changed = startRestartGroup.changed(mutableWindowInsets2) | ((i11 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i10) == 67108864);
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (!changed) {
                                        }
                                        rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((WindowInsets) obj);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(WindowInsets windowInsets3) {
                                                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets3));
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                        startRestartGroup.endReplaceableGroup();
                                        final int i152 = m2581getEndERTFSPs;
                                        final Function2<? super Composer, ? super Integer, Unit> function2112 = m2418getLambda1$material3_release;
                                        final Function2<? super Composer, ? super Integer, Unit> function2122 = m2420getLambda3$material3_release;
                                        final Function2<? super Composer, ? super Integer, Unit> function2132 = m2421getLambda4$material3_release;
                                        final Function2<? super Composer, ? super Integer, Unit> function2142 = m2419getLambda2$material3_release;
                                        int i162 = i10 >> 12;
                                        SurfaceKt.m3043SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j4, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                                            public final void invoke(Composer composer2, int i17) {
                                                ComposerKt.sourceInformation(composer2, "C107@5422L298:Scaffold.kt#uh7d8r");
                                                if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1979205334, i17, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:107)");
                                                    }
                                                    ScaffoldKt.m2830ScaffoldLayoutFMILGgc(i152, function2112, function3, function2122, function2132, mutableWindowInsets2, function2142, composer2, 0);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        }), startRestartGroup, (i162 & 896) | 12582912 | (i162 & 7168), 114);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        j6 = j4;
                                        function28 = m2419getLambda2$material3_release;
                                        function29 = m2420getLambda3$material3_release;
                                        function210 = m2421getLambda4$material3_release;
                                        windowInsets2 = contentWindowInsets;
                                        j7 = j5;
                                        function25 = m2418getLambda1$material3_release;
                                        modifier2 = companion;
                                    }
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & 64) != 0) {
                                        i4 &= -3670017;
                                    }
                                    if ((i3 & Fields.SpotShadowColor) != 0) {
                                        i4 &= -29360129;
                                    }
                                    if ((i3 & Fields.RotationX) != 0) {
                                        i4 &= -234881025;
                                    }
                                    companion = modifier;
                                    i10 = i4;
                                    m2418getLambda1$material3_release = function25;
                                    m2419getLambda2$material3_release = function26;
                                    m2421getLambda4$material3_release = function27;
                                    m2420getLambda3$material3_release = function23;
                                    m2581getEndERTFSPs = i;
                                    j4 = j;
                                }
                                contentWindowInsets = windowInsets;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                startRestartGroup.startReplaceableGroup(-889185358);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                                i11 = (234881024 & i10) ^ 100663296;
                                if (i11 > 67108864) {
                                }
                                j5 = j3;
                                if ((i10 & 100663296) != 67108864) {
                                }
                                z = true;
                                rememberedValue = startRestartGroup.rememberedValue();
                                if (!z) {
                                }
                                rememberedValue = new MutableWindowInsets(contentWindowInsets);
                                startRestartGroup.updateRememberedValue(rememberedValue);
                                final MutableWindowInsets mutableWindowInsets22 = (MutableWindowInsets) rememberedValue;
                                startRestartGroup.endReplaceableGroup();
                                startRestartGroup.startReplaceableGroup(-889185200);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                                changed = startRestartGroup.changed(mutableWindowInsets22) | ((i11 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i10) == 67108864);
                                rememberedValue2 = startRestartGroup.rememberedValue();
                                if (!changed) {
                                }
                                rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((WindowInsets) obj);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(WindowInsets windowInsets3) {
                                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets3));
                                    }
                                };
                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                startRestartGroup.endReplaceableGroup();
                                final int i1522 = m2581getEndERTFSPs;
                                final Function2<? super Composer, ? super Integer, Unit> function21122 = m2418getLambda1$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function21222 = m2420getLambda3$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function21322 = m2421getLambda4$material3_release;
                                final Function2<? super Composer, ? super Integer, Unit> function21422 = m2419getLambda2$material3_release;
                                int i1622 = i10 >> 12;
                                SurfaceKt.m3043SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j4, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                                    public final void invoke(Composer composer2, int i17) {
                                        ComposerKt.sourceInformation(composer2, "C107@5422L298:Scaffold.kt#uh7d8r");
                                        if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-1979205334, i17, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:107)");
                                            }
                                            ScaffoldKt.m2830ScaffoldLayoutFMILGgc(i1522, function21122, function3, function21222, function21322, mutableWindowInsets22, function21422, composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }), startRestartGroup, (i1622 & 896) | 12582912 | (i1622 & 7168), 114);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                j6 = j4;
                                function28 = m2419getLambda2$material3_release;
                                function29 = m2420getLambda3$material3_release;
                                function210 = m2421getLambda4$material3_release;
                                windowInsets2 = contentWindowInsets;
                                j7 = j5;
                                function25 = m2418getLambda1$material3_release;
                                modifier2 = companion;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                modifier2 = modifier;
                                function29 = function23;
                                windowInsets2 = windowInsets;
                                function28 = function26;
                                function210 = function27;
                                m2581getEndERTFSPs = i;
                                j7 = j3;
                                j6 = j;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier3 = modifier2;
                                final Function2<? super Composer, ? super Integer, Unit> function215 = function25;
                                final int i17 = m2581getEndERTFSPs;
                                final long j8 = j6;
                                final long j9 = j7;
                                final WindowInsets windowInsets3 = windowInsets2;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$3
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

                                    public final void invoke(Composer composer2, int i18) {
                                        ScaffoldKt.m2829ScaffoldTvnljyQ(Modifier.this, function215, function28, function29, function210, i17, j8, j9, windowInsets3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i2 & 1) != 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i5 == 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if ((i3 & 64) == 0) {
                        }
                        if ((i3 & Fields.SpotShadowColor) != 0) {
                        }
                        if ((i3 & Fields.RotationX) != 0) {
                        }
                        contentWindowInsets = windowInsets;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        startRestartGroup.startReplaceableGroup(-889185358);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                        i11 = (234881024 & i10) ^ 100663296;
                        if (i11 > 67108864) {
                        }
                        j5 = j3;
                        if ((i10 & 100663296) != 67108864) {
                        }
                        z = true;
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (!z) {
                        }
                        rememberedValue = new MutableWindowInsets(contentWindowInsets);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                        final MutableWindowInsets mutableWindowInsets222 = (MutableWindowInsets) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.startReplaceableGroup(-889185200);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                        changed = startRestartGroup.changed(mutableWindowInsets222) | ((i11 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i10) == 67108864);
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (!changed) {
                        }
                        rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((WindowInsets) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(WindowInsets windowInsets32) {
                                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets32));
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                        startRestartGroup.endReplaceableGroup();
                        final int i15222 = m2581getEndERTFSPs;
                        final Function2<? super Composer, ? super Integer, Unit> function211222 = m2418getLambda1$material3_release;
                        final Function2<? super Composer, ? super Integer, Unit> function212222 = m2420getLambda3$material3_release;
                        final Function2<? super Composer, ? super Integer, Unit> function213222 = m2421getLambda4$material3_release;
                        final Function2<? super Composer, ? super Integer, Unit> function214222 = m2419getLambda2$material3_release;
                        int i16222 = i10 >> 12;
                        SurfaceKt.m3043SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j4, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                            public final void invoke(Composer composer2, int i172) {
                                ComposerKt.sourceInformation(composer2, "C107@5422L298:Scaffold.kt#uh7d8r");
                                if ((i172 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1979205334, i172, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:107)");
                                    }
                                    ScaffoldKt.m2830ScaffoldLayoutFMILGgc(i15222, function211222, function3, function212222, function213222, mutableWindowInsets222, function214222, composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, (i16222 & 896) | 12582912 | (i16222 & 7168), 114);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        j6 = j4;
                        function28 = m2419getLambda2$material3_release;
                        function29 = m2420getLambda3$material3_release;
                        function210 = m2421getLambda4$material3_release;
                        windowInsets2 = contentWindowInsets;
                        j7 = j5;
                        function25 = m2418getLambda1$material3_release;
                        modifier2 = companion;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    function27 = function24;
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    if ((i2 & 1572864) == 0) {
                    }
                    if ((i2 & 12582912) == 0) {
                    }
                    if ((i2 & 100663296) == 0) {
                    }
                    if ((i3 & Fields.RotationY) != 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i5 == 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if ((i3 & 64) == 0) {
                    }
                    if ((i3 & Fields.SpotShadowColor) != 0) {
                    }
                    if ((i3 & Fields.RotationX) != 0) {
                    }
                    contentWindowInsets = windowInsets;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    startRestartGroup.startReplaceableGroup(-889185358);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                    i11 = (234881024 & i10) ^ 100663296;
                    if (i11 > 67108864) {
                    }
                    j5 = j3;
                    if ((i10 & 100663296) != 67108864) {
                    }
                    z = true;
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!z) {
                    }
                    rememberedValue = new MutableWindowInsets(contentWindowInsets);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                    final MutableWindowInsets mutableWindowInsets2222 = (MutableWindowInsets) rememberedValue;
                    startRestartGroup.endReplaceableGroup();
                    startRestartGroup.startReplaceableGroup(-889185200);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                    changed = startRestartGroup.changed(mutableWindowInsets2222) | ((i11 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i10) == 67108864);
                    rememberedValue2 = startRestartGroup.rememberedValue();
                    if (!changed) {
                    }
                    rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((WindowInsets) obj);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(WindowInsets windowInsets32) {
                            MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets32));
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                    startRestartGroup.endReplaceableGroup();
                    final int i152222 = m2581getEndERTFSPs;
                    final Function2<? super Composer, ? super Integer, Unit> function2112222 = m2418getLambda1$material3_release;
                    final Function2<? super Composer, ? super Integer, Unit> function2122222 = m2420getLambda3$material3_release;
                    final Function2<? super Composer, ? super Integer, Unit> function2132222 = m2421getLambda4$material3_release;
                    final Function2<? super Composer, ? super Integer, Unit> function2142222 = m2419getLambda2$material3_release;
                    int i162222 = i10 >> 12;
                    SurfaceKt.m3043SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j4, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                        public final void invoke(Composer composer2, int i172) {
                            ComposerKt.sourceInformation(composer2, "C107@5422L298:Scaffold.kt#uh7d8r");
                            if ((i172 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1979205334, i172, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:107)");
                                }
                                ScaffoldKt.m2830ScaffoldLayoutFMILGgc(i152222, function2112222, function3, function2122222, function2132222, mutableWindowInsets2222, function2142222, composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i162222 & 896) | 12582912 | (i162222 & 7168), 114);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    j6 = j4;
                    function28 = m2419getLambda2$material3_release;
                    function29 = m2420getLambda3$material3_release;
                    function210 = m2421getLambda4$material3_release;
                    windowInsets2 = contentWindowInsets;
                    j7 = j5;
                    function25 = m2418getLambda1$material3_release;
                    modifier2 = companion;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                function27 = function24;
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                if ((i2 & 1572864) == 0) {
                }
                if ((i2 & 12582912) == 0) {
                }
                if ((i2 & 100663296) == 0) {
                }
                if ((i3 & Fields.RotationY) != 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 == 0) {
                }
                if (i9 == 0) {
                }
                if (i8 == 0) {
                }
                if ((i3 & 64) == 0) {
                }
                if ((i3 & Fields.SpotShadowColor) != 0) {
                }
                if ((i3 & Fields.RotationX) != 0) {
                }
                contentWindowInsets = windowInsets;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                startRestartGroup.startReplaceableGroup(-889185358);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                i11 = (234881024 & i10) ^ 100663296;
                if (i11 > 67108864) {
                }
                j5 = j3;
                if ((i10 & 100663296) != 67108864) {
                }
                z = true;
                rememberedValue = startRestartGroup.rememberedValue();
                if (!z) {
                }
                rememberedValue = new MutableWindowInsets(contentWindowInsets);
                startRestartGroup.updateRememberedValue(rememberedValue);
                final MutableWindowInsets mutableWindowInsets22222 = (MutableWindowInsets) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(-889185200);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
                changed = startRestartGroup.changed(mutableWindowInsets22222) | ((i11 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i10) == 67108864);
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((WindowInsets) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(WindowInsets windowInsets32) {
                        MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets32));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
                startRestartGroup.endReplaceableGroup();
                final int i1522222 = m2581getEndERTFSPs;
                final Function2<? super Composer, ? super Integer, Unit> function21122222 = m2418getLambda1$material3_release;
                final Function2<? super Composer, ? super Integer, Unit> function21222222 = m2420getLambda3$material3_release;
                final Function2<? super Composer, ? super Integer, Unit> function21322222 = m2421getLambda4$material3_release;
                final Function2<? super Composer, ? super Integer, Unit> function21422222 = m2419getLambda2$material3_release;
                int i1622222 = i10 >> 12;
                SurfaceKt.m3043SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j4, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                    public final void invoke(Composer composer2, int i172) {
                        ComposerKt.sourceInformation(composer2, "C107@5422L298:Scaffold.kt#uh7d8r");
                        if ((i172 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1979205334, i172, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:107)");
                            }
                            ScaffoldKt.m2830ScaffoldLayoutFMILGgc(i1522222, function21122222, function3, function21222222, function21322222, mutableWindowInsets22222, function21422222, composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, (i1622222 & 896) | 12582912 | (i1622222 & 7168), 114);
                if (ComposerKt.isTraceInProgress()) {
                }
                j6 = j4;
                function28 = m2419getLambda2$material3_release;
                function29 = m2420getLambda3$material3_release;
                function210 = m2421getLambda4$material3_release;
                windowInsets2 = contentWindowInsets;
                j7 = j5;
                function25 = m2418getLambda1$material3_release;
                modifier2 = companion;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function26 = function22;
            i6 = i3 & 8;
            if (i6 != 0) {
            }
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            function27 = function24;
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            if ((i2 & 1572864) == 0) {
            }
            if ((i2 & 12582912) == 0) {
            }
            if ((i2 & 100663296) == 0) {
            }
            if ((i3 & Fields.RotationY) != 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 == 0) {
            }
            if (i9 == 0) {
            }
            if (i8 == 0) {
            }
            if ((i3 & 64) == 0) {
            }
            if ((i3 & Fields.SpotShadowColor) != 0) {
            }
            if ((i3 & Fields.RotationX) != 0) {
            }
            contentWindowInsets = windowInsets;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            startRestartGroup.startReplaceableGroup(-889185358);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
            i11 = (234881024 & i10) ^ 100663296;
            if (i11 > 67108864) {
            }
            j5 = j3;
            if ((i10 & 100663296) != 67108864) {
            }
            z = true;
            rememberedValue = startRestartGroup.rememberedValue();
            if (!z) {
            }
            rememberedValue = new MutableWindowInsets(contentWindowInsets);
            startRestartGroup.updateRememberedValue(rememberedValue);
            final MutableWindowInsets mutableWindowInsets222222 = (MutableWindowInsets) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-889185200);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
            changed = startRestartGroup.changed(mutableWindowInsets222222) | ((i11 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i10) == 67108864);
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((WindowInsets) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(WindowInsets windowInsets32) {
                    MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets32));
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue2);
            startRestartGroup.endReplaceableGroup();
            final int i15222222 = m2581getEndERTFSPs;
            final Function2<? super Composer, ? super Integer, Unit> function211222222 = m2418getLambda1$material3_release;
            final Function2<? super Composer, ? super Integer, Unit> function212222222 = m2420getLambda3$material3_release;
            final Function2<? super Composer, ? super Integer, Unit> function213222222 = m2421getLambda4$material3_release;
            final Function2<? super Composer, ? super Integer, Unit> function214222222 = m2419getLambda2$material3_release;
            int i16222222 = i10 >> 12;
            SurfaceKt.m3043SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j4, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

                public final void invoke(Composer composer2, int i172) {
                    ComposerKt.sourceInformation(composer2, "C107@5422L298:Scaffold.kt#uh7d8r");
                    if ((i172 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1979205334, i172, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:107)");
                        }
                        ScaffoldKt.m2830ScaffoldLayoutFMILGgc(i15222222, function211222222, function3, function212222222, function213222222, mutableWindowInsets222222, function214222222, composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (i16222222 & 896) | 12582912 | (i16222222 & 7168), 114);
            if (ComposerKt.isTraceInProgress()) {
            }
            j6 = j4;
            function28 = m2419getLambda2$material3_release;
            function29 = m2420getLambda3$material3_release;
            function210 = m2421getLambda4$material3_release;
            windowInsets2 = contentWindowInsets;
            j7 = j5;
            function25 = m2418getLambda1$material3_release;
            modifier2 = companion;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        function25 = function2;
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        function26 = function22;
        i6 = i3 & 8;
        if (i6 != 0) {
        }
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        function27 = function24;
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        if ((i2 & 1572864) == 0) {
        }
        if ((i2 & 12582912) == 0) {
        }
        if ((i2 & 100663296) == 0) {
        }
        if ((i3 & Fields.RotationY) != 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i2 & 1) != 0) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i9 == 0) {
        }
        if (i8 == 0) {
        }
        if ((i3 & 64) == 0) {
        }
        if ((i3 & Fields.SpotShadowColor) != 0) {
        }
        if ((i3 & Fields.RotationX) != 0) {
        }
        contentWindowInsets = windowInsets;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        startRestartGroup.startReplaceableGroup(-889185358);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
        i11 = (234881024 & i10) ^ 100663296;
        if (i11 > 67108864) {
        }
        j5 = j3;
        if ((i10 & 100663296) != 67108864) {
        }
        z = true;
        rememberedValue = startRestartGroup.rememberedValue();
        if (!z) {
        }
        rememberedValue = new MutableWindowInsets(contentWindowInsets);
        startRestartGroup.updateRememberedValue(rememberedValue);
        final MutableWindowInsets mutableWindowInsets2222222 = (MutableWindowInsets) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(-889185200);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
        changed = startRestartGroup.changed(mutableWindowInsets2222222) | ((i11 <= 67108864 && startRestartGroup.changed(contentWindowInsets)) || (100663296 & i10) == 67108864);
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue2 = (Function1) new Function1<WindowInsets, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((WindowInsets) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(WindowInsets windowInsets32) {
                MutableWindowInsets.this.setInsets(WindowInsetsKt.exclude(contentWindowInsets, windowInsets32));
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue2);
        startRestartGroup.endReplaceableGroup();
        final int i152222222 = m2581getEndERTFSPs;
        final Function2<? super Composer, ? super Integer, Unit> function2112222222 = m2418getLambda1$material3_release;
        final Function2<? super Composer, ? super Integer, Unit> function2122222222 = m2420getLambda3$material3_release;
        final Function2<? super Composer, ? super Integer, Unit> function2132222222 = m2421getLambda4$material3_release;
        final Function2<? super Composer, ? super Integer, Unit> function2142222222 = m2419getLambda2$material3_release;
        int i162222222 = i10 >> 12;
        SurfaceKt.m3043SurfaceT9BRK9s(WindowInsetsPaddingKt.onConsumedWindowInsetsChanged(companion, (Function1) rememberedValue2), null, j4, j5, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1979205334, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$Scaffold$2
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

            public final void invoke(Composer composer2, int i172) {
                ComposerKt.sourceInformation(composer2, "C107@5422L298:Scaffold.kt#uh7d8r");
                if ((i172 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1979205334, i172, -1, "androidx.compose.material3.Scaffold.<anonymous> (Scaffold.kt:107)");
                    }
                    ScaffoldKt.m2830ScaffoldLayoutFMILGgc(i152222222, function2112222222, function3, function2122222222, function2132222222, mutableWindowInsets2222222, function2142222222, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (i162222222 & 896) | 12582912 | (i162222222 & 7168), 114);
        if (ComposerKt.isTraceInProgress()) {
        }
        j6 = j4;
        function28 = m2419getLambda2$material3_release;
        function29 = m2420getLambda3$material3_release;
        function210 = m2421getLambda4$material3_release;
        windowInsets2 = contentWindowInsets;
        j7 = j5;
        function25 = m2418getLambda1$material3_release;
        modifier2 = companion;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m2830ScaffoldLayoutFMILGgc(final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Composer startRestartGroup = composer.startRestartGroup(-975511942);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2):Scaffold.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i2 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i2) == 0) {
            i3 |= startRestartGroup.changed(windowInsets) ? Fields.RenderEffect : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 1048576 : Fields.BlendMode;
        }
        if ((599187 & i3) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-975511942, i3, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:141)");
            }
            if (getScaffoldSubcomposeInMeasureFix()) {
                startRestartGroup.startReplaceableGroup(-915303637);
                ComposerKt.sourceInformation(startRestartGroup, "143@6712L283");
                m2831ScaffoldLayoutWithMeasureFixFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016));
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-915303332);
                ComposerKt.sourceInformation(startRestartGroup, "153@7017L275");
                m2828LegacyScaffoldLayoutFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, startRestartGroup, (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (i3 & 3670016));
                startRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1
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
                    ScaffoldKt.m2830ScaffoldLayoutFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayoutWithMeasureFix-FMILGgc, reason: not valid java name */
    public static final void m2831ScaffoldLayoutWithMeasureFixFMILGgc(final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        int i4;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-2037614249);
        ComposerKt.sourceInformation(startRestartGroup, "C(ScaffoldLayoutWithMeasureFix)P(4:c#material3.FabPosition,6,1,5,3,2)178@7738L6567,178@7721L6584:Scaffold.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 2048 : Fields.RotationZ;
        }
        if ((i2 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i2) == 0) {
            i3 |= startRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 1048576 : Fields.BlendMode;
        }
        if ((i3 & 599187) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2037614249, i3, -1, "androidx.compose.material3.ScaffoldLayoutWithMeasureFix (Scaffold.kt:177)");
            }
            startRestartGroup.startReplaceableGroup(-273325894);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
            boolean z = ((i3 & 112) == 32) | ((i3 & 7168) == 2048) | ((458752 & i3) == 131072) | ((57344 & i3) == 16384) | ((i3 & 14) == 4) | ((3670016 & i3) == 1048576) | ((i3 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                i4 = 0;
                obj = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        return m2837invoke0kLqBqw((SubcomposeMeasureScope) obj2, ((Constraints) obj3).unbox-impl());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2837invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        Object obj2;
                        Object obj3;
                        Object obj4;
                        final FabPlacement fabPlacement;
                        Object obj5;
                        Integer num;
                        int i5;
                        int intValue;
                        float f;
                        int i6;
                        int bottom;
                        float f2;
                        Object obj6;
                        Object obj7;
                        int i7;
                        float f3;
                        float f4;
                        int i8;
                        float f5;
                        float f6;
                        final int i9 = Constraints.getMaxWidth-impl(j);
                        final int i10 = Constraints.getMaxHeight-impl(j);
                        long j2 = Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
                        List<Measurable> subcompose = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.TopBar, function2);
                        ArrayList arrayList = new ArrayList(subcompose.size());
                        int size = subcompose.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            arrayList.add(subcompose.get(i11).mo6318measureBRTryo0(j2));
                        }
                        final ArrayList arrayList2 = arrayList;
                        if (arrayList2.isEmpty()) {
                            obj2 = null;
                        } else {
                            obj2 = arrayList2.get(0);
                            int height = ((Placeable) obj2).getHeight();
                            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                            if (1 <= lastIndex) {
                                int i12 = 1;
                                while (true) {
                                    Object obj8 = arrayList2.get(i12);
                                    int height2 = ((Placeable) obj8).getHeight();
                                    if (height < height2) {
                                        obj2 = obj8;
                                        height = height2;
                                    }
                                    if (i12 == lastIndex) {
                                        break;
                                    }
                                    i12++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) obj2;
                        final int height3 = placeable != null ? placeable.getHeight() : 0;
                        List<Measurable> subcompose2 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Snackbar, function22);
                        WindowInsets windowInsets2 = windowInsets;
                        ArrayList arrayList3 = new ArrayList(subcompose2.size());
                        int size2 = subcompose2.size();
                        int i13 = 0;
                        while (i13 < size2) {
                            SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                            arrayList3.add(subcompose2.get(i13).mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U(j2, (-windowInsets2.getLeft(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection())) - windowInsets2.getRight(subcomposeMeasureScope2, subcomposeMeasureScope.getLayoutDirection()), -windowInsets2.getBottom(subcomposeMeasureScope2))));
                            i13++;
                            subcompose2 = subcompose2;
                        }
                        final ArrayList arrayList4 = arrayList3;
                        if (arrayList4.isEmpty()) {
                            obj3 = null;
                        } else {
                            obj3 = arrayList4.get(0);
                            int height4 = ((Placeable) obj3).getHeight();
                            int lastIndex2 = CollectionsKt.getLastIndex(arrayList4);
                            if (1 <= lastIndex2) {
                                Object obj9 = obj3;
                                int i14 = height4;
                                int i15 = 1;
                                while (true) {
                                    Object obj10 = arrayList4.get(i15);
                                    int height5 = ((Placeable) obj10).getHeight();
                                    if (i14 < height5) {
                                        obj9 = obj10;
                                        i14 = height5;
                                    }
                                    if (i15 == lastIndex2) {
                                        break;
                                    }
                                    i15++;
                                }
                                obj3 = obj9;
                            }
                        }
                        Placeable placeable2 = (Placeable) obj3;
                        int height6 = placeable2 != null ? placeable2.getHeight() : 0;
                        if (arrayList4.isEmpty()) {
                            obj4 = null;
                        } else {
                            obj4 = arrayList4.get(0);
                            int width = ((Placeable) obj4).getWidth();
                            int lastIndex3 = CollectionsKt.getLastIndex(arrayList4);
                            if (1 <= lastIndex3) {
                                Object obj11 = obj4;
                                int i16 = width;
                                int i17 = 1;
                                while (true) {
                                    Object obj12 = arrayList4.get(i17);
                                    int width2 = ((Placeable) obj12).getWidth();
                                    if (i16 < width2) {
                                        obj11 = obj12;
                                        i16 = width2;
                                    }
                                    if (i17 == lastIndex3) {
                                        break;
                                    }
                                    i17++;
                                }
                                obj4 = obj11;
                            }
                        }
                        Placeable placeable3 = (Placeable) obj4;
                        int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                        List<Measurable> subcompose3 = subcomposeMeasureScope.subcompose(ScaffoldLayoutContent.Fab, function23);
                        WindowInsets windowInsets3 = windowInsets;
                        ArrayList arrayList5 = new ArrayList(subcompose3.size());
                        int size3 = subcompose3.size();
                        int i18 = 0;
                        while (i18 < size3) {
                            Measurable measurable = subcompose3.get(i18);
                            SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope;
                            List<Measurable> list = subcompose3;
                            int i19 = size3;
                            int right = (-windowInsets3.getLeft(subcomposeMeasureScope3, subcomposeMeasureScope.getLayoutDirection())) - windowInsets3.getRight(subcomposeMeasureScope3, subcomposeMeasureScope.getLayoutDirection());
                            int i20 = -windowInsets3.getBottom(subcomposeMeasureScope3);
                            WindowInsets windowInsets4 = windowInsets3;
                            Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U(j2, right, i20));
                            if (!((mo6318measureBRTryo0.getHeight() == 0 || mo6318measureBRTryo0.getWidth() == 0) ? false : true)) {
                                mo6318measureBRTryo0 = null;
                            }
                            if (mo6318measureBRTryo0 != null) {
                                arrayList5.add(mo6318measureBRTryo0);
                            }
                            i18++;
                            windowInsets3 = windowInsets4;
                            subcompose3 = list;
                            size3 = i19;
                        }
                        final ArrayList arrayList6 = arrayList5;
                        if (!arrayList6.isEmpty()) {
                            if (arrayList6.isEmpty()) {
                                obj6 = null;
                            } else {
                                obj6 = arrayList6.get(0);
                                int width4 = ((Placeable) obj6).getWidth();
                                int lastIndex4 = CollectionsKt.getLastIndex(arrayList6);
                                if (1 <= lastIndex4) {
                                    int i21 = width4;
                                    int i22 = 1;
                                    while (true) {
                                        Object obj13 = arrayList6.get(i22);
                                        int width5 = ((Placeable) obj13).getWidth();
                                        if (i21 < width5) {
                                            obj6 = obj13;
                                            i21 = width5;
                                        }
                                        if (i22 == lastIndex4) {
                                            break;
                                        }
                                        i22++;
                                    }
                                }
                            }
                            Intrinsics.checkNotNull(obj6);
                            int width6 = ((Placeable) obj6).getWidth();
                            if (arrayList6.isEmpty()) {
                                obj7 = null;
                            } else {
                                obj7 = arrayList6.get(0);
                                int height7 = ((Placeable) obj7).getHeight();
                                int lastIndex5 = CollectionsKt.getLastIndex(arrayList6);
                                if (1 <= lastIndex5) {
                                    Object obj14 = obj7;
                                    int i23 = height7;
                                    int i24 = 1;
                                    while (true) {
                                        Object obj15 = arrayList6.get(i24);
                                        Object obj16 = obj14;
                                        int height8 = ((Placeable) obj15).getHeight();
                                        if (i23 < height8) {
                                            i23 = height8;
                                            obj14 = obj15;
                                        } else {
                                            obj14 = obj16;
                                        }
                                        if (i24 == lastIndex5) {
                                            break;
                                        }
                                        i24++;
                                    }
                                    obj7 = obj14;
                                }
                            }
                            Intrinsics.checkNotNull(obj7);
                            int height9 = ((Placeable) obj7).getHeight();
                            int i25 = i;
                            if (FabPosition.m2576equalsimpl0(i25, FabPosition.INSTANCE.m2583getStartERTFSPs())) {
                                if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                    f6 = ScaffoldKt.FabSpacing;
                                    i7 = subcomposeMeasureScope.roundToPx-0680j_4(f6);
                                    fabPlacement = new FabPlacement(i7, width6, height9);
                                } else {
                                    f5 = ScaffoldKt.FabSpacing;
                                    i8 = subcomposeMeasureScope.roundToPx-0680j_4(f5);
                                    i7 = (i9 - i8) - width6;
                                    fabPlacement = new FabPlacement(i7, width6, height9);
                                }
                            } else {
                                if (FabPosition.m2576equalsimpl0(i25, FabPosition.INSTANCE.m2581getEndERTFSPs()) ? true : FabPosition.m2576equalsimpl0(i25, FabPosition.INSTANCE.m2582getEndOverlayERTFSPs())) {
                                    if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.Ltr) {
                                        f4 = ScaffoldKt.FabSpacing;
                                        i8 = subcomposeMeasureScope.roundToPx-0680j_4(f4);
                                        i7 = (i9 - i8) - width6;
                                    } else {
                                        f3 = ScaffoldKt.FabSpacing;
                                        i7 = subcomposeMeasureScope.roundToPx-0680j_4(f3);
                                    }
                                } else {
                                    i7 = (i9 - width6) / 2;
                                }
                                fabPlacement = new FabPlacement(i7, width6, height9);
                            }
                        } else {
                            fabPlacement = null;
                        }
                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                        final Function2<Composer, Integer, Unit> function25 = function24;
                        List<Measurable> subcompose4 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(1843374446, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bottomBarPlaceables$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj17, Object obj18) {
                                invoke((Composer) obj17, ((Number) obj18).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i26) {
                                ComposerKt.sourceInformation(composer2, "C258@11166L132:Scaffold.kt#uh7d8r");
                                if ((i26 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1843374446, i26, -1, "androidx.compose.material3.ScaffoldLayoutWithMeasureFix.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:258)");
                                    }
                                    CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this), function25, composer2, ProvidedValue.$stable | 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }));
                        ArrayList arrayList7 = new ArrayList(subcompose4.size());
                        int size4 = subcompose4.size();
                        int i26 = 0;
                        while (i26 < size4) {
                            arrayList7.add(subcompose4.get(i26).mo6318measureBRTryo0(j2));
                            i26++;
                            subcompose4 = subcompose4;
                        }
                        final ArrayList arrayList8 = arrayList7;
                        if (arrayList8.isEmpty()) {
                            obj5 = null;
                        } else {
                            obj5 = arrayList8.get(0);
                            int height10 = ((Placeable) obj5).getHeight();
                            int lastIndex6 = CollectionsKt.getLastIndex(arrayList8);
                            if (1 <= lastIndex6) {
                                int i27 = 1;
                                while (true) {
                                    Object obj17 = arrayList8.get(i27);
                                    Object obj18 = obj5;
                                    int height11 = ((Placeable) obj17).getHeight();
                                    if (height10 < height11) {
                                        height10 = height11;
                                        obj5 = obj17;
                                    } else {
                                        obj5 = obj18;
                                    }
                                    if (i27 == lastIndex6) {
                                        break;
                                    }
                                    i27++;
                                }
                            }
                        }
                        Placeable placeable4 = (Placeable) obj5;
                        Integer valueOf = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                        if (fabPlacement != null) {
                            int i28 = i;
                            WindowInsets windowInsets5 = windowInsets;
                            if (valueOf == null || FabPosition.m2576equalsimpl0(i28, FabPosition.INSTANCE.m2582getEndOverlayERTFSPs())) {
                                int height12 = fabPlacement.getHeight();
                                f = ScaffoldKt.FabSpacing;
                                i6 = height12 + subcomposeMeasureScope.roundToPx-0680j_4(f);
                                bottom = windowInsets5.getBottom(subcomposeMeasureScope);
                            } else {
                                i6 = valueOf.intValue() + fabPlacement.getHeight();
                                f2 = ScaffoldKt.FabSpacing;
                                bottom = subcomposeMeasureScope.roundToPx-0680j_4(f2);
                            }
                            num = Integer.valueOf(i6 + bottom);
                        } else {
                            num = null;
                        }
                        if (height6 != 0) {
                            if (num != null) {
                                intValue = num.intValue();
                            } else {
                                intValue = valueOf != null ? valueOf.intValue() : windowInsets.getBottom(subcomposeMeasureScope);
                            }
                            i5 = height6 + intValue;
                        } else {
                            i5 = 0;
                        }
                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets6 = windowInsets;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        final int i29 = width3;
                        final Integer num2 = valueOf;
                        final FabPlacement fabPlacement2 = fabPlacement;
                        List<Measurable> subcompose5 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(1655277373, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1$bodyContentPlaceables$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj19, Object obj20) {
                                invoke((Composer) obj19, ((Number) obj20).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i30) {
                                float f7;
                                float bottom2;
                                Integer num3;
                                ComposerKt.sourceInformation(composer2, "C302@13090L21:Scaffold.kt#uh7d8r");
                                if ((i30 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1655277373, i30, -1, "androidx.compose.material3.ScaffoldLayoutWithMeasureFix.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:285)");
                                    }
                                    PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope);
                                    if (arrayList2.isEmpty()) {
                                        f7 = asPaddingValues.getTop();
                                    } else {
                                        f7 = subcomposeMeasureScope.toDp-u2uoSUM(height3);
                                    }
                                    if (arrayList8.isEmpty() || (num3 = num2) == null) {
                                        bottom2 = asPaddingValues.getBottom();
                                    } else {
                                        bottom2 = subcomposeMeasureScope.toDp-u2uoSUM(num3.intValue());
                                    }
                                    function32.invoke(PaddingKt.m1060PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), f7, PaddingKt.calculateEndPadding(asPaddingValues, subcomposeMeasureScope.getLayoutDirection()), bottom2), composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }));
                        ArrayList arrayList9 = new ArrayList(subcompose5.size());
                        int size5 = subcompose5.size();
                        for (int i30 = 0; i30 < size5; i30++) {
                            arrayList9.add(subcompose5.get(i30).mo6318measureBRTryo0(j2));
                        }
                        final ArrayList arrayList10 = arrayList9;
                        final WindowInsets windowInsets7 = windowInsets;
                        final int i31 = i5;
                        final Integer num3 = valueOf;
                        final Integer num4 = num;
                        return MeasureScope.layout$default(subcomposeMeasureScope, i9, i10, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj19) {
                                invoke((Placeable.PlacementScope) obj19);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                List<Placeable> list2 = arrayList10;
                                int size6 = list2.size();
                                for (int i32 = 0; i32 < size6; i32++) {
                                    Placeable.PlacementScope.place$default(placementScope, list2.get(i32), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list3 = arrayList2;
                                int size7 = list3.size();
                                for (int i33 = 0; i33 < size7; i33++) {
                                    Placeable.PlacementScope.place$default(placementScope, list3.get(i33), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list4 = arrayList4;
                                int i34 = i9;
                                int i35 = i29;
                                WindowInsets windowInsets8 = windowInsets7;
                                SubcomposeMeasureScope subcomposeMeasureScope4 = subcomposeMeasureScope;
                                int i36 = i10;
                                int i37 = i31;
                                int size8 = list4.size();
                                for (int i38 = 0; i38 < size8; i38++) {
                                    Placeable.PlacementScope.place$default(placementScope, list4.get(i38), ((i34 - i35) / 2) + windowInsets8.getLeft(subcomposeMeasureScope4, subcomposeMeasureScope4.getLayoutDirection()), i36 - i37, 0.0f, 4, null);
                                }
                                List<Placeable> list5 = arrayList8;
                                int i39 = i10;
                                Integer num5 = num3;
                                int size9 = list5.size();
                                for (int i40 = 0; i40 < size9; i40++) {
                                    Placeable.PlacementScope.place$default(placementScope, list5.get(i40), 0, i39 - (num5 != null ? num5.intValue() : 0), 0.0f, 4, null);
                                }
                                FabPlacement fabPlacement3 = fabPlacement2;
                                if (fabPlacement3 != null) {
                                    List<Placeable> list6 = arrayList6;
                                    int i41 = i10;
                                    Integer num6 = num4;
                                    int size10 = list6.size();
                                    for (int i42 = 0; i42 < size10; i42++) {
                                        Placeable placeable5 = list6.get(i42);
                                        int left = fabPlacement3.getLeft();
                                        Intrinsics.checkNotNull(num6);
                                        Placeable.PlacementScope.place$default(placementScope, placeable5, left, i41 - num6.intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
                i4 = 0;
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) obj, startRestartGroup, i4, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayoutWithMeasureFix$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    ScaffoldKt.m2831ScaffoldLayoutWithMeasureFixFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LegacyScaffoldLayout-FMILGgc, reason: not valid java name */
    public static final void m2828LegacyScaffoldLayoutFMILGgc(final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        int i4;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(1307205667);
        ComposerKt.sourceInformation(startRestartGroup, "C(LegacyScaffoldLayout)P(4:c#material3.FabPosition,6,1,5,3,2)348@14737L6941,348@14720L6958:Scaffold.kt#uh7d8r");
        if ((i2 & 6) == 0) {
            i3 = (startRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function3) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function22) ? 2048 : Fields.RotationZ;
        }
        if ((i2 & 24576) == 0) {
            i3 |= startRestartGroup.changedInstance(function23) ? Fields.Clip : Fields.Shape;
        }
        if ((196608 & i2) == 0) {
            i3 |= startRestartGroup.changed(windowInsets) ? 131072 : 65536;
        }
        if ((i2 & 1572864) == 0) {
            i3 |= startRestartGroup.changedInstance(function24) ? 1048576 : Fields.BlendMode;
        }
        if ((i3 & 599187) != 599186 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1307205667, i3, -1, "androidx.compose.material3.LegacyScaffoldLayout (Scaffold.kt:347)");
            }
            startRestartGroup.startReplaceableGroup(1646578117);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):Scaffold.kt#9igjgp");
            boolean z = ((i3 & 112) == 32) | ((i3 & 7168) == 2048) | ((458752 & i3) == 131072) | ((57344 & i3) == 16384) | ((i3 & 14) == 4) | ((3670016 & i3) == 1048576) | ((i3 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z || rememberedValue == Composer.INSTANCE.getEmpty()) {
                i4 = 0;
                obj = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ScaffoldKt$LegacyScaffoldLayout$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        return m2835invoke0kLqBqw((SubcomposeMeasureScope) obj2, ((Constraints) obj3).unbox-impl());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m2835invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        final int i5 = Constraints.getMaxWidth-impl(j);
                        final int i6 = Constraints.getMaxHeight-impl(j);
                        final long j2 = Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
                        final Function2<Composer, Integer, Unit> function25 = function2;
                        final Function2<Composer, Integer, Unit> function26 = function22;
                        final Function2<Composer, Integer, Unit> function27 = function23;
                        final int i7 = i;
                        final WindowInsets windowInsets2 = windowInsets;
                        final Function2<Composer, Integer, Unit> function28 = function24;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.layout$default(subcomposeMeasureScope, i5, i6, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$LegacyScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((Placeable.PlacementScope) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Object obj2;
                                Object obj3;
                                Object obj4;
                                final FabPlacement fabPlacement;
                                int i8;
                                Object obj5;
                                Integer num;
                                int i9;
                                int intValue;
                                float f;
                                int i10;
                                float f2;
                                Object obj6;
                                Object obj7;
                                int i11;
                                float f3;
                                int i12;
                                float f4;
                                int i13;
                                float f5;
                                float f6;
                                List<Measurable> subcompose = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.TopBar, function25);
                                long j3 = j2;
                                ArrayList arrayList = new ArrayList(subcompose.size());
                                int size = subcompose.size();
                                for (int i14 = 0; i14 < size; i14++) {
                                    arrayList.add(subcompose.get(i14).mo6318measureBRTryo0(j3));
                                }
                                final ArrayList arrayList2 = arrayList;
                                if (arrayList2.isEmpty()) {
                                    obj2 = null;
                                } else {
                                    obj2 = arrayList2.get(0);
                                    int height = ((Placeable) obj2).getHeight();
                                    int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                                    if (1 <= lastIndex) {
                                        int i15 = 1;
                                        while (true) {
                                            Object obj8 = arrayList2.get(i15);
                                            int height2 = ((Placeable) obj8).getHeight();
                                            if (height < height2) {
                                                obj2 = obj8;
                                                height = height2;
                                            }
                                            if (i15 == lastIndex) {
                                                break;
                                            } else {
                                                i15++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable = (Placeable) obj2;
                                final int height3 = placeable != null ? placeable.getHeight() : 0;
                                List<Measurable> subcompose2 = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.Snackbar, function26);
                                WindowInsets windowInsets3 = windowInsets2;
                                SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeMeasureScope.this;
                                long j4 = j2;
                                ArrayList arrayList3 = new ArrayList(subcompose2.size());
                                int size2 = subcompose2.size();
                                for (int i16 = 0; i16 < size2; i16++) {
                                    SubcomposeMeasureScope subcomposeMeasureScope3 = subcomposeMeasureScope2;
                                    arrayList3.add(subcompose2.get(i16).mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U(j4, (-windowInsets3.getLeft(subcomposeMeasureScope3, subcomposeMeasureScope2.getLayoutDirection())) - windowInsets3.getRight(subcomposeMeasureScope3, subcomposeMeasureScope2.getLayoutDirection()), -windowInsets3.getBottom(subcomposeMeasureScope3))));
                                }
                                ArrayList arrayList4 = arrayList3;
                                if (arrayList4.isEmpty()) {
                                    obj3 = null;
                                } else {
                                    obj3 = arrayList4.get(0);
                                    int height4 = ((Placeable) obj3).getHeight();
                                    int lastIndex2 = CollectionsKt.getLastIndex(arrayList4);
                                    if (1 <= lastIndex2) {
                                        int i17 = 1;
                                        while (true) {
                                            Object obj9 = arrayList4.get(i17);
                                            int height5 = ((Placeable) obj9).getHeight();
                                            if (height4 < height5) {
                                                obj3 = obj9;
                                                height4 = height5;
                                            }
                                            if (i17 == lastIndex2) {
                                                break;
                                            } else {
                                                i17++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable2 = (Placeable) obj3;
                                int height6 = placeable2 != null ? placeable2.getHeight() : 0;
                                if (arrayList4.isEmpty()) {
                                    obj4 = null;
                                } else {
                                    obj4 = arrayList4.get(0);
                                    int width = ((Placeable) obj4).getWidth();
                                    int lastIndex3 = CollectionsKt.getLastIndex(arrayList4);
                                    if (1 <= lastIndex3) {
                                        int i18 = 1;
                                        while (true) {
                                            Object obj10 = arrayList4.get(i18);
                                            int width2 = ((Placeable) obj10).getWidth();
                                            if (width < width2) {
                                                obj4 = obj10;
                                                width = width2;
                                            }
                                            if (i18 == lastIndex3) {
                                                break;
                                            } else {
                                                i18++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable3 = (Placeable) obj4;
                                int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                                List<Measurable> subcompose3 = SubcomposeMeasureScope.this.subcompose(ScaffoldLayoutContent.Fab, function27);
                                WindowInsets windowInsets4 = windowInsets2;
                                SubcomposeMeasureScope subcomposeMeasureScope4 = SubcomposeMeasureScope.this;
                                long j5 = j2;
                                ArrayList arrayList5 = new ArrayList(subcompose3.size());
                                int size3 = subcompose3.size();
                                int i19 = 0;
                                while (i19 < size3) {
                                    Measurable measurable = subcompose3.get(i19);
                                    SubcomposeMeasureScope subcomposeMeasureScope5 = subcomposeMeasureScope4;
                                    List<Measurable> list = subcompose3;
                                    int i20 = size3;
                                    int right = (-windowInsets4.getLeft(subcomposeMeasureScope5, subcomposeMeasureScope4.getLayoutDirection())) - windowInsets4.getRight(subcomposeMeasureScope5, subcomposeMeasureScope4.getLayoutDirection());
                                    int i21 = -windowInsets4.getBottom(subcomposeMeasureScope5);
                                    WindowInsets windowInsets5 = windowInsets4;
                                    Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U(j5, right, i21));
                                    if (!((mo6318measureBRTryo0.getHeight() == 0 || mo6318measureBRTryo0.getWidth() == 0) ? false : true)) {
                                        mo6318measureBRTryo0 = null;
                                    }
                                    if (mo6318measureBRTryo0 != null) {
                                        arrayList5.add(mo6318measureBRTryo0);
                                    }
                                    i19++;
                                    windowInsets4 = windowInsets5;
                                    subcompose3 = list;
                                    size3 = i20;
                                }
                                ArrayList arrayList6 = arrayList5;
                                if (!arrayList6.isEmpty()) {
                                    if (arrayList6.isEmpty()) {
                                        obj6 = null;
                                    } else {
                                        obj6 = arrayList6.get(0);
                                        int width4 = ((Placeable) obj6).getWidth();
                                        int lastIndex4 = CollectionsKt.getLastIndex(arrayList6);
                                        if (1 <= lastIndex4) {
                                            int i22 = 1;
                                            while (true) {
                                                Object obj11 = arrayList6.get(i22);
                                                int width5 = ((Placeable) obj11).getWidth();
                                                if (width4 < width5) {
                                                    obj6 = obj11;
                                                    width4 = width5;
                                                }
                                                if (i22 == lastIndex4) {
                                                    break;
                                                } else {
                                                    i22++;
                                                }
                                            }
                                        }
                                    }
                                    Intrinsics.checkNotNull(obj6);
                                    int width6 = ((Placeable) obj6).getWidth();
                                    if (arrayList6.isEmpty()) {
                                        obj7 = null;
                                    } else {
                                        obj7 = arrayList6.get(0);
                                        int height7 = ((Placeable) obj7).getHeight();
                                        int lastIndex5 = CollectionsKt.getLastIndex(arrayList6);
                                        if (1 <= lastIndex5) {
                                            int i23 = 1;
                                            while (true) {
                                                Object obj12 = arrayList6.get(i23);
                                                int height8 = ((Placeable) obj12).getHeight();
                                                if (height7 < height8) {
                                                    obj7 = obj12;
                                                    height7 = height8;
                                                }
                                                if (i23 == lastIndex5) {
                                                    break;
                                                } else {
                                                    i23++;
                                                }
                                            }
                                        }
                                    }
                                    Intrinsics.checkNotNull(obj7);
                                    int height9 = ((Placeable) obj7).getHeight();
                                    int i24 = i7;
                                    if (FabPosition.m2576equalsimpl0(i24, FabPosition.INSTANCE.m2583getStartERTFSPs())) {
                                        if (SubcomposeMeasureScope.this.getLayoutDirection() == LayoutDirection.Ltr) {
                                            SubcomposeMeasureScope subcomposeMeasureScope6 = SubcomposeMeasureScope.this;
                                            f6 = ScaffoldKt.FabSpacing;
                                            i11 = subcomposeMeasureScope6.roundToPx-0680j_4(f6);
                                            fabPlacement = new FabPlacement(i11, width6, height9);
                                        } else {
                                            i12 = i5;
                                            SubcomposeMeasureScope subcomposeMeasureScope7 = SubcomposeMeasureScope.this;
                                            f5 = ScaffoldKt.FabSpacing;
                                            i13 = subcomposeMeasureScope7.roundToPx-0680j_4(f5);
                                            i11 = (i12 - i13) - width6;
                                            fabPlacement = new FabPlacement(i11, width6, height9);
                                        }
                                    } else {
                                        if (FabPosition.m2576equalsimpl0(i24, FabPosition.INSTANCE.m2581getEndERTFSPs())) {
                                            if (SubcomposeMeasureScope.this.getLayoutDirection() == LayoutDirection.Ltr) {
                                                i12 = i5;
                                                SubcomposeMeasureScope subcomposeMeasureScope8 = SubcomposeMeasureScope.this;
                                                f4 = ScaffoldKt.FabSpacing;
                                                i13 = subcomposeMeasureScope8.roundToPx-0680j_4(f4);
                                                i11 = (i12 - i13) - width6;
                                            } else {
                                                SubcomposeMeasureScope subcomposeMeasureScope9 = SubcomposeMeasureScope.this;
                                                f3 = ScaffoldKt.FabSpacing;
                                                i11 = subcomposeMeasureScope9.roundToPx-0680j_4(f3);
                                            }
                                        } else {
                                            i11 = (i5 - width6) / 2;
                                        }
                                        fabPlacement = new FabPlacement(i11, width6, height9);
                                    }
                                } else {
                                    fabPlacement = null;
                                }
                                SubcomposeMeasureScope subcomposeMeasureScope10 = SubcomposeMeasureScope.this;
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function29 = function28;
                                List<Measurable> subcompose4 = subcomposeMeasureScope10.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(-791102355, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$LegacyScaffoldLayout$1$1$1$bottomBarPlaceables$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj13, Object obj14) {
                                        invoke((Composer) obj13, ((Number) obj14).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i25) {
                                        ComposerKt.sourceInformation(composer2, "C429@18457L144:Scaffold.kt#uh7d8r");
                                        if ((i25 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-791102355, i25, -1, "androidx.compose.material3.LegacyScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:429)");
                                            }
                                            CompositionLocalKt.CompositionLocalProvider(ScaffoldKt.getLocalFabPlacement().provides(FabPlacement.this), function29, composer2, ProvidedValue.$stable | 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }));
                                long j6 = j2;
                                ArrayList arrayList7 = new ArrayList(subcompose4.size());
                                int size4 = subcompose4.size();
                                for (int i25 = 0; i25 < size4; i25++) {
                                    arrayList7.add(subcompose4.get(i25).mo6318measureBRTryo0(j6));
                                }
                                final ArrayList arrayList8 = arrayList7;
                                if (arrayList8.isEmpty()) {
                                    obj5 = null;
                                    i8 = 0;
                                } else {
                                    i8 = 0;
                                    obj5 = arrayList8.get(0);
                                    int height10 = ((Placeable) obj5).getHeight();
                                    int lastIndex6 = CollectionsKt.getLastIndex(arrayList8);
                                    if (1 <= lastIndex6) {
                                        int i26 = height10;
                                        Object obj13 = obj5;
                                        int i27 = 1;
                                        while (true) {
                                            Object obj14 = arrayList8.get(i27);
                                            int height11 = ((Placeable) obj14).getHeight();
                                            if (i26 < height11) {
                                                obj13 = obj14;
                                                i26 = height11;
                                            }
                                            if (i27 == lastIndex6) {
                                                break;
                                            } else {
                                                i27++;
                                            }
                                        }
                                        obj5 = obj13;
                                    }
                                }
                                Placeable placeable4 = (Placeable) obj5;
                                Integer valueOf = placeable4 != null ? Integer.valueOf(placeable4.getHeight()) : null;
                                if (fabPlacement != null) {
                                    SubcomposeMeasureScope subcomposeMeasureScope11 = SubcomposeMeasureScope.this;
                                    WindowInsets windowInsets6 = windowInsets2;
                                    if (valueOf == null) {
                                        int height12 = fabPlacement.getHeight();
                                        f2 = ScaffoldKt.FabSpacing;
                                        i10 = height12 + subcomposeMeasureScope11.roundToPx-0680j_4(f2) + windowInsets6.getBottom(subcomposeMeasureScope11);
                                    } else {
                                        int intValue2 = valueOf.intValue() + fabPlacement.getHeight();
                                        f = ScaffoldKt.FabSpacing;
                                        i10 = intValue2 + subcomposeMeasureScope11.roundToPx-0680j_4(f);
                                    }
                                    num = Integer.valueOf(i10);
                                } else {
                                    num = null;
                                }
                                if (height6 != 0) {
                                    if (num != null) {
                                        intValue = num.intValue();
                                    } else {
                                        intValue = valueOf != null ? valueOf.intValue() : windowInsets2.getBottom(SubcomposeMeasureScope.this);
                                    }
                                    i9 = height6 + intValue;
                                } else {
                                    i9 = i8;
                                }
                                SubcomposeMeasureScope subcomposeMeasureScope12 = SubcomposeMeasureScope.this;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final WindowInsets windowInsets7 = windowInsets2;
                                final SubcomposeMeasureScope subcomposeMeasureScope13 = SubcomposeMeasureScope.this;
                                final Function3<PaddingValues, Composer, Integer, Unit> function33 = function32;
                                FabPlacement fabPlacement2 = fabPlacement;
                                ArrayList arrayList9 = arrayList8;
                                final Integer num2 = valueOf;
                                int i28 = i8;
                                List<Measurable> subcompose5 = subcomposeMeasureScope12.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(495329982, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$LegacyScaffoldLayout$1$1$1$bodyContentPlaceables$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj15, Object obj16) {
                                        invoke((Composer) obj15, ((Number) obj16).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i29) {
                                        float f7;
                                        float bottom;
                                        Integer num3;
                                        ComposerKt.sourceInformation(composer2, "C473@20504L21:Scaffold.kt#uh7d8r");
                                        if ((i29 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(495329982, i29, -1, "androidx.compose.material3.LegacyScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:456)");
                                            }
                                            PaddingValues asPaddingValues = WindowInsetsKt.asPaddingValues(WindowInsets.this, subcomposeMeasureScope13);
                                            if (arrayList2.isEmpty()) {
                                                f7 = asPaddingValues.getTop();
                                            } else {
                                                f7 = subcomposeMeasureScope13.toDp-u2uoSUM(height3);
                                            }
                                            if (arrayList8.isEmpty() || (num3 = num2) == null) {
                                                bottom = asPaddingValues.getBottom();
                                            } else {
                                                bottom = subcomposeMeasureScope13.toDp-u2uoSUM(num3.intValue());
                                            }
                                            function33.invoke(PaddingKt.m1060PaddingValuesa9UjIt4(PaddingKt.calculateStartPadding(asPaddingValues, subcomposeMeasureScope13.getLayoutDirection()), f7, PaddingKt.calculateEndPadding(asPaddingValues, subcomposeMeasureScope13.getLayoutDirection()), bottom), composer2, 0);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }));
                                long j7 = j2;
                                ArrayList arrayList10 = new ArrayList(subcompose5.size());
                                int size5 = subcompose5.size();
                                for (int i29 = i28; i29 < size5; i29++) {
                                    arrayList10.add(subcompose5.get(i29).mo6318measureBRTryo0(j7));
                                }
                                ArrayList arrayList11 = arrayList10;
                                int size6 = arrayList11.size();
                                for (int i30 = i28; i30 < size6; i30++) {
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList11.get(i30), 0, 0, 0.0f, 4, null);
                                }
                                int size7 = arrayList2.size();
                                for (int i31 = i28; i31 < size7; i31++) {
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList2.get(i31), 0, 0, 0.0f, 4, null);
                                }
                                int i32 = i5;
                                WindowInsets windowInsets8 = windowInsets2;
                                SubcomposeMeasureScope subcomposeMeasureScope14 = SubcomposeMeasureScope.this;
                                int i33 = i6;
                                int size8 = arrayList4.size();
                                for (int i34 = i28; i34 < size8; i34++) {
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList4.get(i34), ((i32 - width3) / 2) + windowInsets8.getLeft(subcomposeMeasureScope14, subcomposeMeasureScope14.getLayoutDirection()), i33 - i9, 0.0f, 4, null);
                                }
                                int i35 = i6;
                                int size9 = arrayList9.size();
                                int i36 = i28;
                                while (i36 < size9) {
                                    ArrayList arrayList12 = arrayList9;
                                    Placeable.PlacementScope.place$default(placementScope, (Placeable) arrayList12.get(i36), 0, i35 - (valueOf != null ? valueOf.intValue() : i28), 0.0f, 4, null);
                                    i36++;
                                    arrayList9 = arrayList12;
                                }
                                if (fabPlacement2 != null) {
                                    int i37 = i6;
                                    int size10 = arrayList6.size();
                                    for (int i38 = i28; i38 < size10; i38++) {
                                        Placeable placeable5 = (Placeable) arrayList6.get(i38);
                                        int left = fabPlacement2.getLeft();
                                        Intrinsics.checkNotNull(num);
                                        Placeable.PlacementScope.place$default(placementScope, placeable5, left, i37 - num.intValue(), 0.0f, 4, null);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                            }
                        }, 4, null);
                    }
                };
                startRestartGroup.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
                i4 = 0;
            }
            startRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) obj, startRestartGroup, i4, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$LegacyScaffoldLayout$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i5) {
                    ScaffoldKt.m2828LegacyScaffoldLayoutFMILGgc(i, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    static {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        ScaffoldSubcomposeInMeasureFix$delegate = mutableStateOf$default;
        LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material3.ScaffoldKt$LocalFabPlacement$1
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final FabPlacement m2836invoke() {
                return null;
            }
        });
        FabSpacing = Dp.constructor-impl(16);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean getScaffoldSubcomposeInMeasureFix() {
        return ((Boolean) ScaffoldSubcomposeInMeasureFix$delegate.getValue()).booleanValue();
    }

    public static final void setScaffoldSubcomposeInMeasureFix(boolean z) {
        ScaffoldSubcomposeInMeasureFix$delegate.setValue(Boolean.valueOf(z));
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
