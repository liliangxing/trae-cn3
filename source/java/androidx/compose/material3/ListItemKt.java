package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.layout.AlignmentLineKt;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.MultiContentMeasurePolicy;
import androidx.compose.p002ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a©\u0001\u0010\u0016\u001a\u00020\u00172\u0011\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u0015\b\u0002\u0010\u001d\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010\u001e\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0015\b\u0002\u0010 \u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001at\u0010'\u001a\u00020\u00172\u0013\u0010(\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0011\u0010*\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001a2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001a2\u0013\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0019¢\u0006\u0002\b\u001aH\u0003¢\u0006\u0002\u0010-\u001a5\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a`\u00106\u001a\u000207*\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010:2\b\u0010>\u001a\u0004\u0018\u00010:2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a`\u0010G\u001a\u000207*\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010:2\b\u0010>\u001a\u0004\u0018\u00010:2\u0006\u0010H\u001a\u00020I2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0002ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001af\u0010L\u001a\u00020M*\u0002082\u0006\u0010N\u001a\u0002072\u0006\u0010O\u001a\u0002072\b\u00109\u001a\u0004\u0018\u00010:2\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010:2\b\u0010=\u001a\u0004\u0018\u00010:2\b\u0010>\u001a\u0004\u0018\u00010:2\u0006\u0010P\u001a\u00020Q2\u0006\u0010H\u001a\u00020I2\u0006\u0010A\u001a\u00020BH\u0002\"\u001e\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001e\u0010\u0007\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\u0005\"\u001e\u0010\n\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\u0005\"\u001e\u0010\r\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\u0005\"\u001e\u0010\u0010\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0005\"\u001e\u0010\u0013\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b\u0014\u0010\u0003\u001a\u0004\b\u0015\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006R"}, d2 = {"LeadingContentEndPadding", "Landroidx/compose/ui/unit/Dp;", "getLeadingContentEndPadding$annotations", "()V", "getLeadingContentEndPadding", "()F", "F", "ListItemEndPadding", "getListItemEndPadding$annotations", "getListItemEndPadding", "ListItemStartPadding", "getListItemStartPadding$annotations", "getListItemStartPadding", "ListItemThreeLineVerticalPadding", "getListItemThreeLineVerticalPadding$annotations", "getListItemThreeLineVerticalPadding", "ListItemVerticalPadding", "getListItemVerticalPadding$annotations", "getListItemVerticalPadding", "TrailingContentStartPadding", "getTrailingContentStartPadding$annotations", "getTrailingContentStartPadding", "ListItem", "", "headlineContent", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "overlineContent", "supportingContent", "leadingContent", "trailingContent", "colors", "Landroidx/compose/material3/ListItemColors;", "tonalElevation", "shadowElevation", "ListItem-HXNGIdc", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/ListItemColors;FFLandroidx/compose/runtime/Composer;II)V", "ListItemLayout", "leading", "trailing", "headline", "overline", "supporting", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ProvideTextStyleFromToken", "color", "Landroidx/compose/ui/graphics/Color;", "textToken", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "content", "ProvideTextStyleFromToken-3J-VO9M", "(JLandroidx/compose/material3/tokens/TypographyKeyTokens;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "", "Landroidx/compose/ui/layout/MeasureScope;", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "headlinePlaceable", "overlinePlaceable", "supportingPlaceable", "listItemType", "Landroidx/compose/material3/ListItemType;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "calculateHeight-N4Jib3Y", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;ILandroidx/compose/foundation/layout/PaddingValues;J)I", "calculateWidth", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateWidth-xygx4p4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/foundation/layout/PaddingValues;J)I", "place", "Landroidx/compose/ui/layout/MeasureResult;", "width", "height", "isThreeLine", "", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ListItemKt {
    private static final float LeadingContentEndPadding;
    private static final float ListItemEndPadding;
    private static final float ListItemStartPadding;
    private static final float TrailingContentStartPadding;
    private static final float ListItemVerticalPadding = Dp.constructor-impl(8);
    private static final float ListItemThreeLineVerticalPadding = Dp.constructor-impl(12);

    public static /* synthetic */ void getLeadingContentEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemEndPadding$annotations() {
    }

    public static /* synthetic */ void getListItemStartPadding$annotations() {
    }

    public static /* synthetic */ void getListItemThreeLineVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getListItemVerticalPadding$annotations() {
    }

    public static /* synthetic */ void getTrailingContentStartPadding$annotations() {
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02a9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01aa  */
    /* renamed from: ListItem-HXNGIdc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2664ListItemHXNGIdc(final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, ListItemColors listItemColors, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        final Function2<? super Composer, ? super Integer, Unit> function26;
        int i5;
        final Function2<? super Composer, ? super Integer, Unit> function27;
        int i6;
        Function2<? super Composer, ? super Integer, Unit> function28;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        float f3;
        Modifier.Companion companion;
        final Function2<? super Composer, ? super Integer, Unit> function29;
        final Function2<? super Composer, ? super Integer, Unit> function210;
        int i12;
        int i13;
        ListItemColors listItemColors2;
        float m2663getElevationD9Ej5fM;
        float m2663getElevationD9Ej5fM2;
        int i14;
        final ListItemColors listItemColors3;
        Function2<? super Composer, ? super Integer, Unit> function211;
        ComposableLambda composableLambda;
        Function2<? super Composer, ? super Integer, Unit> function212;
        ComposableLambda composableLambda2;
        Function2<? super Composer, ? super Integer, Unit> function213;
        final Function2<? super Composer, ? super Integer, Unit> function214;
        final Function2<? super Composer, ? super Integer, Unit> function215;
        ListItemColors listItemColors4;
        float f4;
        final Function2<? super Composer, ? super Integer, Unit> function216;
        Modifier modifier2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-1647707763);
        ComposerKt.sourceInformation(startRestartGroup, "C(ListItem)P(1,3,4,6,2,8!1,7:c#ui.unit.Dp,5:c#ui.unit.Dp)89@4308L8,144@6169L5,140@6019L637:ListItem.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i15 = i2 & 2;
        if (i15 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                function26 = function22;
                i3 |= startRestartGroup.changedInstance(function26) ? Fields.RotationX : Fields.SpotShadowColor;
                i5 = i2 & 8;
                if (i5 != 0) {
                    i3 |= 3072;
                } else if ((i & 3072) == 0) {
                    function27 = function23;
                    i3 |= startRestartGroup.changedInstance(function27) ? Fields.CameraDistance : Fields.RotationZ;
                    i6 = i2 & 16;
                    if (i6 == 0) {
                        i3 |= 24576;
                    } else if ((i & 24576) == 0) {
                        function28 = function24;
                        i3 |= startRestartGroup.changedInstance(function28) ? Fields.Clip : Fields.Shape;
                        i7 = i2 & 32;
                        if (i7 != 0) {
                            i3 |= 196608;
                        } else if ((196608 & i) == 0) {
                            i3 |= startRestartGroup.changedInstance(function25) ? Fields.RenderEffect : 65536;
                            if ((i & 1572864) == 0) {
                                i3 |= ((i2 & 64) == 0 && startRestartGroup.changed(listItemColors)) ? 1048576 : Fields.BlendMode;
                            }
                            i8 = i2 & Fields.SpotShadowColor;
                            if (i8 == 0) {
                                i3 |= 12582912;
                            } else if ((i & 12582912) == 0) {
                                i9 = i8;
                                i3 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
                                i10 = i2 & Fields.RotationX;
                                if (i10 != 0) {
                                    i3 |= 100663296;
                                } else if ((i & 100663296) == 0) {
                                    i11 = i10;
                                    f3 = f2;
                                    i3 |= startRestartGroup.changed(f3) ? 67108864 : 33554432;
                                    if ((i3 & 38347923) == 38347922 || !startRestartGroup.getSkipping()) {
                                        startRestartGroup.startDefaults();
                                        ComposableLambda composableLambda3 = null;
                                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                            companion = i15 == 0 ? Modifier.INSTANCE : modifier;
                                            if (i4 != 0) {
                                                function26 = null;
                                            }
                                            if (i5 != 0) {
                                                function27 = null;
                                            }
                                            function29 = i6 == 0 ? null : function28;
                                            function210 = i7 == 0 ? null : function25;
                                            if ((i2 & 64) == 0) {
                                                i12 = i9;
                                                i13 = i11;
                                                listItemColors2 = ListItemDefaults.INSTANCE.m2662colorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, startRestartGroup, 805306368, 511);
                                                i3 &= -3670017;
                                            } else {
                                                i12 = i9;
                                                i13 = i11;
                                                listItemColors2 = listItemColors;
                                            }
                                            m2663getElevationD9Ej5fM = i12 == 0 ? ListItemDefaults.INSTANCE.m2663getElevationD9Ej5fM() : f;
                                            m2663getElevationD9Ej5fM2 = i13 == 0 ? ListItemDefaults.INSTANCE.m2663getElevationD9Ej5fM() : f2;
                                            ListItemColors listItemColors5 = listItemColors2;
                                            i14 = i3;
                                            listItemColors3 = listItemColors5;
                                        } else {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i2 & 64) != 0) {
                                                i3 &= -3670017;
                                            }
                                            companion = modifier;
                                            function210 = function25;
                                            m2663getElevationD9Ej5fM = f;
                                            i14 = i3;
                                            function29 = function28;
                                            m2663getElevationD9Ej5fM2 = f3;
                                            listItemColors3 = listItemColors;
                                        }
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1647707763, i14, -1, "androidx.compose.material3.ListItem (ListItem.kt:92)");
                                        }
                                        final ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(startRestartGroup, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
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

                                            public final void invoke(Composer composer2, int i16) {
                                                ComposerKt.sourceInformation(composer2, "C94@4498L160:ListItem.kt#uh7d8r");
                                                if ((i16 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-403249643, i16, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                                                    }
                                                    ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2657headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer2, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        });
                                        ComposableLambda composableLambda5 = function27 == null ? ComposableLambdaKt.composableLambda(startRestartGroup, -1020860251, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedSupportingContent$1$1
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

                                            public final void invoke(Composer composer2, int i16) {
                                                ComposerKt.sourceInformation(composer2, "C102@4776L156:ListItem.kt#uh7d8r");
                                                if ((i16 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1020860251, i16, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:102)");
                                                    }
                                                    ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2660supportingColor0d7_KjU$material3_release(), ListTokens.INSTANCE.getListItemSupportingTextFont(), function27, composer2, 48);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        }) : null;
                                        if (function26 == null) {
                                            function211 = function26;
                                            composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -764441232, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedOverlineContent$1$1
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

                                                public final void invoke(Composer composer2, int i16) {
                                                    ComposerKt.sourceInformation(composer2, "C111@5056L148:ListItem.kt#uh7d8r");
                                                    if ((i16 & 3) != 2 || !composer2.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-764441232, i16, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:111)");
                                                        }
                                                        ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2659overlineColor0d7_KjU$material3_release(), ListTokens.INSTANCE.getListItemOverlineFont(), function26, composer2, 48);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    composer2.skipToGroupEnd();
                                                }
                                            });
                                        } else {
                                            function211 = function26;
                                            composableLambda = null;
                                        }
                                        if (function29 == null) {
                                            function212 = function29;
                                            composableLambda2 = ComposableLambdaKt.composableLambda(startRestartGroup, 1400509200, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedLeadingContent$1$1
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

                                                public final void invoke(Composer composer2, int i16) {
                                                    ComposerKt.sourceInformation(composer2, "C120@5326L250:ListItem.kt#uh7d8r");
                                                    if ((i16 & 3) != 2 || !composer2.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1400509200, i16, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:120)");
                                                        }
                                                        Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, ListItemKt.getLeadingContentEndPadding(), 0.0f, 11, null);
                                                        ListItemColors listItemColors6 = ListItemColors.this;
                                                        Function2<Composer, Integer, Unit> function217 = function29;
                                                        composer2.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                                        composer2.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
                                                        ComposerKt.sourceInformationMarkerStart(composer2, 2011888581, "C121@5398L164:ListItem.kt#uh7d8r");
                                                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(listItemColors6.m2658leadingIconColorvNxB06k$material3_release(true))), function217, composer2, ProvidedValue.$stable | 0);
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
                                            });
                                        } else {
                                            function212 = function29;
                                            composableLambda2 = null;
                                        }
                                        if (function210 == null) {
                                            function213 = function210;
                                            composableLambda3 = ComposableLambdaKt.composableLambda(startRestartGroup, 1512306332, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedTrailingContent$1$1
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

                                                public final void invoke(Composer composer2, int i16) {
                                                    ComposerKt.sourceInformation(composer2, "C130@5700L297:ListItem.kt#uh7d8r");
                                                    if ((i16 & 3) != 2 || !composer2.getSkipping()) {
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1512306332, i16, -1, "androidx.compose.material3.ListItem.<anonymous>.<anonymous> (ListItem.kt:130)");
                                                        }
                                                        Modifier m1068paddingqDBjuR0$default = PaddingKt.m1068paddingqDBjuR0$default(Modifier.INSTANCE, ListItemKt.getTrailingContentStartPadding(), 0.0f, 0.0f, 0.0f, 14, null);
                                                        ListItemColors listItemColors6 = ListItemColors.this;
                                                        Function2<Composer, Integer, Unit> function217 = function210;
                                                        composer2.startReplaceableGroup(733328855);
                                                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                                        composer2.startReplaceableGroup(-1323940314);
                                                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                                        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m1068paddingqDBjuR0$default);
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
                                                        ComposerKt.sourceInformationMarkerStart(composer2, 2011888960, "C131@5777L206:ListItem.kt#uh7d8r");
                                                        ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(listItemColors6.m2661trailingIconColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemTrailingSupportingTextFont(), function217, composer2, 48);
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
                                            });
                                        } else {
                                            function213 = function210;
                                        }
                                        final ComposableLambda composableLambda6 = composableLambda2;
                                        final ComposableLambda composableLambda7 = composableLambda3;
                                        final ComposableLambda composableLambda8 = composableLambda;
                                        final ComposableLambda composableLambda9 = composableLambda5;
                                        int i16 = i14 >> 9;
                                        SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                                invoke((SemanticsPropertyReceiver) obj);
                                                return Unit.INSTANCE;
                                            }
                                        }).then(companion), ListItemDefaults.INSTANCE.getShape(startRestartGroup, 6), listItemColors3.getContainerColor(), listItemColors3.m2657headlineColorvNxB06k$material3_release(true), m2663getElevationD9Ej5fM, m2663getElevationD9Ej5fM2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
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
                                                ComposerKt.sourceInformation(composer2, "C150@6378L272:ListItem.kt#uh7d8r");
                                                if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(1502590376, i17, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                                                    }
                                                    ListItemKt.ListItemLayout(composableLambda6, composableLambda7, composableLambda4, composableLambda8, composableLambda9, composer2, 384);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        }), startRestartGroup, (57344 & i16) | 12582912 | (i16 & 458752), 64);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        function26 = function211;
                                        function214 = function213;
                                        f3 = m2663getElevationD9Ej5fM2;
                                        function215 = function27;
                                        listItemColors4 = listItemColors3;
                                        f4 = m2663getElevationD9Ej5fM;
                                        function216 = function212;
                                        modifier2 = companion;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        modifier2 = modifier;
                                        function214 = function25;
                                        listItemColors4 = listItemColors;
                                        function215 = function27;
                                        function216 = function28;
                                        f4 = f;
                                    }
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        final Modifier modifier3 = modifier2;
                                        final Function2<? super Composer, ? super Integer, Unit> function217 = function26;
                                        final ListItemColors listItemColors6 = listItemColors4;
                                        final float f5 = f4;
                                        final float f6 = f3;
                                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$3
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
                                                ListItemKt.m2664ListItemHXNGIdc(function2, modifier3, function217, function215, function216, function214, listItemColors6, f5, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i11 = i10;
                                f3 = f2;
                                if ((i3 & 38347923) == 38347922) {
                                }
                                startRestartGroup.startDefaults();
                                ComposableLambda composableLambda32 = null;
                                if ((i & 1) != 0) {
                                }
                                if (i15 == 0) {
                                }
                                if (i4 != 0) {
                                }
                                if (i5 != 0) {
                                }
                                if (i6 == 0) {
                                }
                                if (i7 == 0) {
                                }
                                if ((i2 & 64) == 0) {
                                }
                                if (i12 == 0) {
                                }
                                if (i13 == 0) {
                                }
                                ListItemColors listItemColors52 = listItemColors2;
                                i14 = i3;
                                listItemColors3 = listItemColors52;
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                final Function2<? super Composer, ? super Integer, Unit> composableLambda42 = ComposableLambdaKt.composableLambda(startRestartGroup, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
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

                                    public final void invoke(Composer composer2, int i162) {
                                        ComposerKt.sourceInformation(composer2, "C94@4498L160:ListItem.kt#uh7d8r");
                                        if ((i162 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(-403249643, i162, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                                            }
                                            ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2657headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer2, 48);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                });
                                if (function27 == null) {
                                }
                                if (function26 == null) {
                                }
                                if (function29 == null) {
                                }
                                if (function210 == null) {
                                }
                                final Function2<? super Composer, ? super Integer, Unit> composableLambda62 = composableLambda2;
                                final Function2<? super Composer, ? super Integer, Unit> composableLambda72 = composableLambda32;
                                final Function2<? super Composer, ? super Integer, Unit> composableLambda82 = composableLambda;
                                final Function2<? super Composer, ? super Integer, Unit> composableLambda92 = composableLambda5;
                                int i162 = i14 >> 9;
                                SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        invoke((SemanticsPropertyReceiver) obj);
                                        return Unit.INSTANCE;
                                    }
                                }).then(companion), ListItemDefaults.INSTANCE.getShape(startRestartGroup, 6), listItemColors3.getContainerColor(), listItemColors3.m2657headlineColorvNxB06k$material3_release(true), m2663getElevationD9Ej5fM, m2663getElevationD9Ej5fM2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
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
                                        ComposerKt.sourceInformation(composer2, "C150@6378L272:ListItem.kt#uh7d8r");
                                        if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventStart(1502590376, i17, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                                            }
                                            ListItemKt.ListItemLayout(composableLambda62, composableLambda72, composableLambda42, composableLambda82, composableLambda92, composer2, 384);
                                            if (ComposerKt.isTraceInProgress()) {
                                                ComposerKt.traceEventEnd();
                                                return;
                                            }
                                            return;
                                        }
                                        composer2.skipToGroupEnd();
                                    }
                                }), startRestartGroup, (57344 & i162) | 12582912 | (i162 & 458752), 64);
                                if (ComposerKt.isTraceInProgress()) {
                                }
                                function26 = function211;
                                function214 = function213;
                                f3 = m2663getElevationD9Ej5fM2;
                                function215 = function27;
                                listItemColors4 = listItemColors3;
                                f4 = m2663getElevationD9Ej5fM;
                                function216 = function212;
                                modifier2 = companion;
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i9 = i8;
                            i10 = i2 & Fields.RotationX;
                            if (i10 != 0) {
                            }
                            i11 = i10;
                            f3 = f2;
                            if ((i3 & 38347923) == 38347922) {
                            }
                            startRestartGroup.startDefaults();
                            ComposableLambda composableLambda322 = null;
                            if ((i & 1) != 0) {
                            }
                            if (i15 == 0) {
                            }
                            if (i4 != 0) {
                            }
                            if (i5 != 0) {
                            }
                            if (i6 == 0) {
                            }
                            if (i7 == 0) {
                            }
                            if ((i2 & 64) == 0) {
                            }
                            if (i12 == 0) {
                            }
                            if (i13 == 0) {
                            }
                            ListItemColors listItemColors522 = listItemColors2;
                            i14 = i3;
                            listItemColors3 = listItemColors522;
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda422 = ComposableLambdaKt.composableLambda(startRestartGroup, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
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

                                public final void invoke(Composer composer2, int i1622) {
                                    ComposerKt.sourceInformation(composer2, "C94@4498L160:ListItem.kt#uh7d8r");
                                    if ((i1622 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-403249643, i1622, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                                        }
                                        ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2657headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer2, 48);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            });
                            if (function27 == null) {
                            }
                            if (function26 == null) {
                            }
                            if (function29 == null) {
                            }
                            if (function210 == null) {
                            }
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda622 = composableLambda2;
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda722 = composableLambda322;
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda822 = composableLambda;
                            final Function2<? super Composer, ? super Integer, Unit> composableLambda922 = composableLambda5;
                            int i1622 = i14 >> 9;
                            SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((SemanticsPropertyReceiver) obj);
                                    return Unit.INSTANCE;
                                }
                            }).then(companion), ListItemDefaults.INSTANCE.getShape(startRestartGroup, 6), listItemColors3.getContainerColor(), listItemColors3.m2657headlineColorvNxB06k$material3_release(true), m2663getElevationD9Ej5fM, m2663getElevationD9Ej5fM2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
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
                                    ComposerKt.sourceInformation(composer2, "C150@6378L272:ListItem.kt#uh7d8r");
                                    if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1502590376, i17, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                                        }
                                        ListItemKt.ListItemLayout(composableLambda622, composableLambda722, composableLambda422, composableLambda822, composableLambda922, composer2, 384);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer2.skipToGroupEnd();
                                }
                            }), startRestartGroup, (57344 & i1622) | 12582912 | (i1622 & 458752), 64);
                            if (ComposerKt.isTraceInProgress()) {
                            }
                            function26 = function211;
                            function214 = function213;
                            f3 = m2663getElevationD9Ej5fM2;
                            function215 = function27;
                            listItemColors4 = listItemColors3;
                            f4 = m2663getElevationD9Ej5fM;
                            function216 = function212;
                            modifier2 = companion;
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        if ((i & 1572864) == 0) {
                        }
                        i8 = i2 & Fields.SpotShadowColor;
                        if (i8 == 0) {
                        }
                        i9 = i8;
                        i10 = i2 & Fields.RotationX;
                        if (i10 != 0) {
                        }
                        i11 = i10;
                        f3 = f2;
                        if ((i3 & 38347923) == 38347922) {
                        }
                        startRestartGroup.startDefaults();
                        ComposableLambda composableLambda3222 = null;
                        if ((i & 1) != 0) {
                        }
                        if (i15 == 0) {
                        }
                        if (i4 != 0) {
                        }
                        if (i5 != 0) {
                        }
                        if (i6 == 0) {
                        }
                        if (i7 == 0) {
                        }
                        if ((i2 & 64) == 0) {
                        }
                        if (i12 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        ListItemColors listItemColors5222 = listItemColors2;
                        i14 = i3;
                        listItemColors3 = listItemColors5222;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda4222 = ComposableLambdaKt.composableLambda(startRestartGroup, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
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

                            public final void invoke(Composer composer2, int i16222) {
                                ComposerKt.sourceInformation(composer2, "C94@4498L160:ListItem.kt#uh7d8r");
                                if ((i16222 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-403249643, i16222, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                                    }
                                    ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2657headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer2, 48);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        });
                        if (function27 == null) {
                        }
                        if (function26 == null) {
                        }
                        if (function29 == null) {
                        }
                        if (function210 == null) {
                        }
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda6222 = composableLambda2;
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda7222 = composableLambda3222;
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda8222 = composableLambda;
                        final Function2<? super Composer, ? super Integer, Unit> composableLambda9222 = composableLambda5;
                        int i16222 = i14 >> 9;
                        SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((SemanticsPropertyReceiver) obj);
                                return Unit.INSTANCE;
                            }
                        }).then(companion), ListItemDefaults.INSTANCE.getShape(startRestartGroup, 6), listItemColors3.getContainerColor(), listItemColors3.m2657headlineColorvNxB06k$material3_release(true), m2663getElevationD9Ej5fM, m2663getElevationD9Ej5fM2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
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
                                ComposerKt.sourceInformation(composer2, "C150@6378L272:ListItem.kt#uh7d8r");
                                if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1502590376, i17, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                                    }
                                    ListItemKt.ListItemLayout(composableLambda6222, composableLambda7222, composableLambda4222, composableLambda8222, composableLambda9222, composer2, 384);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        }), startRestartGroup, (57344 & i16222) | 12582912 | (i16222 & 458752), 64);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function26 = function211;
                        function214 = function213;
                        f3 = m2663getElevationD9Ej5fM2;
                        function215 = function27;
                        listItemColors4 = listItemColors3;
                        f4 = m2663getElevationD9Ej5fM;
                        function216 = function212;
                        modifier2 = companion;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    function28 = function24;
                    i7 = i2 & 32;
                    if (i7 != 0) {
                    }
                    if ((i & 1572864) == 0) {
                    }
                    i8 = i2 & Fields.SpotShadowColor;
                    if (i8 == 0) {
                    }
                    i9 = i8;
                    i10 = i2 & Fields.RotationX;
                    if (i10 != 0) {
                    }
                    i11 = i10;
                    f3 = f2;
                    if ((i3 & 38347923) == 38347922) {
                    }
                    startRestartGroup.startDefaults();
                    ComposableLambda composableLambda32222 = null;
                    if ((i & 1) != 0) {
                    }
                    if (i15 == 0) {
                    }
                    if (i4 != 0) {
                    }
                    if (i5 != 0) {
                    }
                    if (i6 == 0) {
                    }
                    if (i7 == 0) {
                    }
                    if ((i2 & 64) == 0) {
                    }
                    if (i12 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    ListItemColors listItemColors52222 = listItemColors2;
                    i14 = i3;
                    listItemColors3 = listItemColors52222;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda42222 = ComposableLambdaKt.composableLambda(startRestartGroup, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
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

                        public final void invoke(Composer composer2, int i162222) {
                            ComposerKt.sourceInformation(composer2, "C94@4498L160:ListItem.kt#uh7d8r");
                            if ((i162222 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-403249643, i162222, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                                }
                                ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2657headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer2, 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    });
                    if (function27 == null) {
                    }
                    if (function26 == null) {
                    }
                    if (function29 == null) {
                    }
                    if (function210 == null) {
                    }
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda62222 = composableLambda2;
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda72222 = composableLambda32222;
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda82222 = composableLambda;
                    final Function2<? super Composer, ? super Integer, Unit> composableLambda92222 = composableLambda5;
                    int i162222 = i14 >> 9;
                    SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.INSTANCE;
                        }
                    }).then(companion), ListItemDefaults.INSTANCE.getShape(startRestartGroup, 6), listItemColors3.getContainerColor(), listItemColors3.m2657headlineColorvNxB06k$material3_release(true), m2663getElevationD9Ej5fM, m2663getElevationD9Ej5fM2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
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
                            ComposerKt.sourceInformation(composer2, "C150@6378L272:ListItem.kt#uh7d8r");
                            if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1502590376, i17, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                                }
                                ListItemKt.ListItemLayout(composableLambda62222, composableLambda72222, composableLambda42222, composableLambda82222, composableLambda92222, composer2, 384);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, (57344 & i162222) | 12582912 | (i162222 & 458752), 64);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function26 = function211;
                    function214 = function213;
                    f3 = m2663getElevationD9Ej5fM2;
                    function215 = function27;
                    listItemColors4 = listItemColors3;
                    f4 = m2663getElevationD9Ej5fM;
                    function216 = function212;
                    modifier2 = companion;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                function27 = function23;
                i6 = i2 & 16;
                if (i6 == 0) {
                }
                function28 = function24;
                i7 = i2 & 32;
                if (i7 != 0) {
                }
                if ((i & 1572864) == 0) {
                }
                i8 = i2 & Fields.SpotShadowColor;
                if (i8 == 0) {
                }
                i9 = i8;
                i10 = i2 & Fields.RotationX;
                if (i10 != 0) {
                }
                i11 = i10;
                f3 = f2;
                if ((i3 & 38347923) == 38347922) {
                }
                startRestartGroup.startDefaults();
                ComposableLambda composableLambda322222 = null;
                if ((i & 1) != 0) {
                }
                if (i15 == 0) {
                }
                if (i4 != 0) {
                }
                if (i5 != 0) {
                }
                if (i6 == 0) {
                }
                if (i7 == 0) {
                }
                if ((i2 & 64) == 0) {
                }
                if (i12 == 0) {
                }
                if (i13 == 0) {
                }
                ListItemColors listItemColors522222 = listItemColors2;
                i14 = i3;
                listItemColors3 = listItemColors522222;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final Function2<? super Composer, ? super Integer, Unit> composableLambda422222 = ComposableLambdaKt.composableLambda(startRestartGroup, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
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

                    public final void invoke(Composer composer2, int i1622222) {
                        ComposerKt.sourceInformation(composer2, "C94@4498L160:ListItem.kt#uh7d8r");
                        if ((i1622222 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-403249643, i1622222, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                            }
                            ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2657headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer2, 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                if (function27 == null) {
                }
                if (function26 == null) {
                }
                if (function29 == null) {
                }
                if (function210 == null) {
                }
                final Function2<? super Composer, ? super Integer, Unit> composableLambda622222 = composableLambda2;
                final Function2<? super Composer, ? super Integer, Unit> composableLambda722222 = composableLambda322222;
                final Function2<? super Composer, ? super Integer, Unit> composableLambda822222 = composableLambda;
                final Function2<? super Composer, ? super Integer, Unit> composableLambda922222 = composableLambda5;
                int i1622222 = i14 >> 9;
                SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.INSTANCE;
                    }
                }).then(companion), ListItemDefaults.INSTANCE.getShape(startRestartGroup, 6), listItemColors3.getContainerColor(), listItemColors3.m2657headlineColorvNxB06k$material3_release(true), m2663getElevationD9Ej5fM, m2663getElevationD9Ej5fM2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
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
                        ComposerKt.sourceInformation(composer2, "C150@6378L272:ListItem.kt#uh7d8r");
                        if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1502590376, i17, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                            }
                            ListItemKt.ListItemLayout(composableLambda622222, composableLambda722222, composableLambda422222, composableLambda822222, composableLambda922222, composer2, 384);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                }), startRestartGroup, (57344 & i1622222) | 12582912 | (i1622222 & 458752), 64);
                if (ComposerKt.isTraceInProgress()) {
                }
                function26 = function211;
                function214 = function213;
                f3 = m2663getElevationD9Ej5fM2;
                function215 = function27;
                listItemColors4 = listItemColors3;
                f4 = m2663getElevationD9Ej5fM;
                function216 = function212;
                modifier2 = companion;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            function26 = function22;
            i5 = i2 & 8;
            if (i5 != 0) {
            }
            function27 = function23;
            i6 = i2 & 16;
            if (i6 == 0) {
            }
            function28 = function24;
            i7 = i2 & 32;
            if (i7 != 0) {
            }
            if ((i & 1572864) == 0) {
            }
            i8 = i2 & Fields.SpotShadowColor;
            if (i8 == 0) {
            }
            i9 = i8;
            i10 = i2 & Fields.RotationX;
            if (i10 != 0) {
            }
            i11 = i10;
            f3 = f2;
            if ((i3 & 38347923) == 38347922) {
            }
            startRestartGroup.startDefaults();
            ComposableLambda composableLambda3222222 = null;
            if ((i & 1) != 0) {
            }
            if (i15 == 0) {
            }
            if (i4 != 0) {
            }
            if (i5 != 0) {
            }
            if (i6 == 0) {
            }
            if (i7 == 0) {
            }
            if ((i2 & 64) == 0) {
            }
            if (i12 == 0) {
            }
            if (i13 == 0) {
            }
            ListItemColors listItemColors5222222 = listItemColors2;
            i14 = i3;
            listItemColors3 = listItemColors5222222;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final Function2<? super Composer, ? super Integer, Unit> composableLambda4222222 = ComposableLambdaKt.composableLambda(startRestartGroup, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
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

                public final void invoke(Composer composer2, int i16222222) {
                    ComposerKt.sourceInformation(composer2, "C94@4498L160:ListItem.kt#uh7d8r");
                    if ((i16222222 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-403249643, i16222222, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                        }
                        ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2657headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer2, 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            if (function27 == null) {
            }
            if (function26 == null) {
            }
            if (function29 == null) {
            }
            if (function210 == null) {
            }
            final Function2<? super Composer, ? super Integer, Unit> composableLambda6222222 = composableLambda2;
            final Function2<? super Composer, ? super Integer, Unit> composableLambda7222222 = composableLambda3222222;
            final Function2<? super Composer, ? super Integer, Unit> composableLambda8222222 = composableLambda;
            final Function2<? super Composer, ? super Integer, Unit> composableLambda9222222 = composableLambda5;
            int i16222222 = i14 >> 9;
            SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return Unit.INSTANCE;
                }
            }).then(companion), ListItemDefaults.INSTANCE.getShape(startRestartGroup, 6), listItemColors3.getContainerColor(), listItemColors3.m2657headlineColorvNxB06k$material3_release(true), m2663getElevationD9Ej5fM, m2663getElevationD9Ej5fM2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
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
                    ComposerKt.sourceInformation(composer2, "C150@6378L272:ListItem.kt#uh7d8r");
                    if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1502590376, i17, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                        }
                        ListItemKt.ListItemLayout(composableLambda6222222, composableLambda7222222, composableLambda4222222, composableLambda8222222, composableLambda9222222, composer2, 384);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (57344 & i16222222) | 12582912 | (i16222222 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
            }
            function26 = function211;
            function214 = function213;
            f3 = m2663getElevationD9Ej5fM2;
            function215 = function27;
            listItemColors4 = listItemColors3;
            f4 = m2663getElevationD9Ej5fM;
            function216 = function212;
            modifier2 = companion;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        function26 = function22;
        i5 = i2 & 8;
        if (i5 != 0) {
        }
        function27 = function23;
        i6 = i2 & 16;
        if (i6 == 0) {
        }
        function28 = function24;
        i7 = i2 & 32;
        if (i7 != 0) {
        }
        if ((i & 1572864) == 0) {
        }
        i8 = i2 & Fields.SpotShadowColor;
        if (i8 == 0) {
        }
        i9 = i8;
        i10 = i2 & Fields.RotationX;
        if (i10 != 0) {
        }
        i11 = i10;
        f3 = f2;
        if ((i3 & 38347923) == 38347922) {
        }
        startRestartGroup.startDefaults();
        ComposableLambda composableLambda32222222 = null;
        if ((i & 1) != 0) {
        }
        if (i15 == 0) {
        }
        if (i4 != 0) {
        }
        if (i5 != 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if ((i2 & 64) == 0) {
        }
        if (i12 == 0) {
        }
        if (i13 == 0) {
        }
        ListItemColors listItemColors52222222 = listItemColors2;
        i14 = i3;
        listItemColors3 = listItemColors52222222;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final Function2<? super Composer, ? super Integer, Unit> composableLambda42222222 = ComposableLambdaKt.composableLambda(startRestartGroup, -403249643, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$decoratedHeadlineContent$1
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

            public final void invoke(Composer composer2, int i162222222) {
                ComposerKt.sourceInformation(composer2, "C94@4498L160:ListItem.kt#uh7d8r");
                if ((i162222222 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-403249643, i162222222, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:94)");
                    }
                    ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(ListItemColors.this.m2657headlineColorvNxB06k$material3_release(true), ListTokens.INSTANCE.getListItemLabelTextFont(), function2, composer2, 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        });
        if (function27 == null) {
        }
        if (function26 == null) {
        }
        if (function29 == null) {
        }
        if (function210 == null) {
        }
        final Function2<? super Composer, ? super Integer, Unit> composableLambda62222222 = composableLambda2;
        final Function2<? super Composer, ? super Integer, Unit> composableLambda72222222 = composableLambda32222222;
        final Function2<? super Composer, ? super Integer, Unit> composableLambda82222222 = composableLambda;
        final Function2<? super Composer, ? super Integer, Unit> composableLambda92222222 = composableLambda5;
        int i162222222 = i14 >> 9;
        SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics(Modifier.INSTANCE, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$1
            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((SemanticsPropertyReceiver) obj);
                return Unit.INSTANCE;
            }
        }).then(companion), ListItemDefaults.INSTANCE.getShape(startRestartGroup, 6), listItemColors3.getContainerColor(), listItemColors3.m2657headlineColorvNxB06k$material3_release(true), m2663getElevationD9Ej5fM, m2663getElevationD9Ej5fM2, null, ComposableLambdaKt.composableLambda(startRestartGroup, 1502590376, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItem$2
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
                ComposerKt.sourceInformation(composer2, "C150@6378L272:ListItem.kt#uh7d8r");
                if ((i17 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1502590376, i17, -1, "androidx.compose.material3.ListItem.<anonymous> (ListItem.kt:150)");
                    }
                    ListItemKt.ListItemLayout(composableLambda62222222, composableLambda72222222, composableLambda42222222, composableLambda82222222, composableLambda92222222, composer2, 384);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (57344 & i162222222) | 12582912 | (i162222222 & 458752), 64);
        if (ComposerKt.isTraceInProgress()) {
        }
        function26 = function211;
        function214 = function213;
        f3 = m2663getElevationD9Ej5fM2;
        function215 = function27;
        listItemColors4 = listItemColors3;
        f4 = m2663getElevationD9Ej5fM;
        function216 = function212;
        modifier2 = companion;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ListItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final Function2<? super Composer, ? super Integer, Unit> function25, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2052297037);
        ComposerKt.sourceInformation(startRestartGroup, "C(ListItemLayout)P(1,4)168@6954L7,177@7152L3807,169@6966L3993:ListItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function23) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i & 3072) == 0) {
            i2 |= startRestartGroup.changedInstance(function24) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changedInstance(function25) ? Fields.Clip : Fields.Shape;
        }
        if ((i2 & 9363) != 9362 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2052297037, i2, -1, "androidx.compose.material3.ListItemLayout (ListItem.kt:167)");
            }
            ProvidableCompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final LayoutDirection layoutDirection = (LayoutDirection) consume;
            Function2[] function2Arr = new Function2[5];
            function2Arr[0] = function23;
            function2Arr[1] = function24 == null ? ComposableSingletons$ListItemKt.INSTANCE.m2412getLambda1$material3_release() : function24;
            function2Arr[2] = function25 == null ? ComposableSingletons$ListItemKt.INSTANCE.m2413getLambda2$material3_release() : function25;
            function2Arr[3] = function2 == null ? ComposableSingletons$ListItemKt.INSTANCE.m2414getLambda3$material3_release() : function2;
            function2Arr[4] = function22 == null ? ComposableSingletons$ListItemKt.INSTANCE.m2415getLambda4$material3_release() : function22;
            List listOf = CollectionsKt.listOf(function2Arr);
            startRestartGroup.startReplaceableGroup(1361340338);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ListItem.kt#9igjgp");
            boolean changed = startRestartGroup.changed(layoutDirection);
            MultiContentMeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.ListItemKt$ListItemLayout$1$1
                    @Override // androidx.compose.p002ui.layout.MultiContentMeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo992measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
                        int m2670calculateWidthxygx4p4;
                        int m2669calculateHeightN4Jib3Y;
                        MeasureResult place;
                        List<? extends Measurable> list2 = list.get(0);
                        List<? extends Measurable> list3 = list.get(1);
                        List<? extends Measurable> list4 = list.get(2);
                        List<? extends Measurable> list5 = list.get(3);
                        List<? extends Measurable> list6 = list.get(4);
                        long j2 = ConstraintsKt.offset-NN6Ew-U(Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null), -measureScope.roundToPx-0680j_4(Dp.constructor-impl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())), -measureScope.roundToPx-0680j_4(Dp.constructor-impl(ListItemKt.getListItemVerticalPadding() * 2)));
                        Measurable measurable = (Measurable) CollectionsKt.firstOrNull(list5);
                        Placeable mo6318measureBRTryo0 = measurable != null ? measurable.mo6318measureBRTryo0(j2) : null;
                        int widthOrZero = TextFieldImplKt.widthOrZero(mo6318measureBRTryo0) + 0;
                        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull(list6);
                        Placeable mo6318measureBRTryo02 = measurable2 != null ? measurable2.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(j2, -widthOrZero, 0, 2, (Object) null)) : null;
                        int widthOrZero2 = widthOrZero + TextFieldImplKt.widthOrZero(mo6318measureBRTryo02);
                        Measurable measurable3 = (Measurable) CollectionsKt.firstOrNull(list2);
                        Placeable mo6318measureBRTryo03 = measurable3 != null ? measurable3.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U$default(j2, -widthOrZero2, 0, 2, (Object) null)) : null;
                        int heightOrZero = TextFieldImplKt.heightOrZero(mo6318measureBRTryo03) + 0;
                        Measurable measurable4 = (Measurable) CollectionsKt.firstOrNull(list4);
                        Placeable mo6318measureBRTryo04 = measurable4 != null ? measurable4.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U(j2, -widthOrZero2, -heightOrZero)) : null;
                        int heightOrZero2 = heightOrZero + TextFieldImplKt.heightOrZero(mo6318measureBRTryo04);
                        boolean z = (mo6318measureBRTryo04 == null || mo6318measureBRTryo04.get(AlignmentLineKt.getFirstBaseline()) == mo6318measureBRTryo04.get(AlignmentLineKt.getLastBaseline())) ? false : true;
                        Measurable measurable5 = (Measurable) CollectionsKt.firstOrNull(list3);
                        Placeable mo6318measureBRTryo05 = measurable5 != null ? measurable5.mo6318measureBRTryo0(ConstraintsKt.offset-NN6Ew-U(j2, -widthOrZero2, -heightOrZero2)) : null;
                        int m2680getListItemTypeZLSjz4$material3_release = ListItemType.INSTANCE.m2680getListItemTypeZLSjz4$material3_release(mo6318measureBRTryo05 != null, mo6318measureBRTryo04 != null, z);
                        boolean m2675equalsimpl0 = ListItemType.m2675equalsimpl0(m2680getListItemTypeZLSjz4$material3_release, ListItemType.INSTANCE.m2682getThreeLineAlXitO8());
                        PaddingValues m1060PaddingValuesa9UjIt4 = PaddingKt.m1060PaddingValuesa9UjIt4(ListItemKt.getListItemStartPadding(), m2675equalsimpl0 ? ListItemKt.getListItemThreeLineVerticalPadding() : ListItemKt.getListItemVerticalPadding(), ListItemKt.getListItemEndPadding(), m2675equalsimpl0 ? ListItemKt.getListItemThreeLineVerticalPadding() : ListItemKt.getListItemVerticalPadding());
                        Placeable placeable = mo6318measureBRTryo0;
                        Placeable placeable2 = mo6318measureBRTryo02;
                        Placeable placeable3 = mo6318measureBRTryo03;
                        Placeable placeable4 = mo6318measureBRTryo05;
                        Placeable placeable5 = mo6318measureBRTryo04;
                        m2670calculateWidthxygx4p4 = ListItemKt.m2670calculateWidthxygx4p4(measureScope, placeable, placeable2, placeable3, placeable4, placeable5, layoutDirection, m1060PaddingValuesa9UjIt4, j);
                        m2669calculateHeightN4Jib3Y = ListItemKt.m2669calculateHeightN4Jib3Y(measureScope, placeable, placeable2, placeable3, placeable4, placeable5, m2680getListItemTypeZLSjz4$material3_release, m1060PaddingValuesa9UjIt4, j);
                        place = ListItemKt.place(measureScope, m2670calculateWidthxygx4p4, m2669calculateHeightN4Jib3Y, mo6318measureBRTryo0, mo6318measureBRTryo02, mo6318measureBRTryo03, mo6318measureBRTryo05, mo6318measureBRTryo04, m2675equalsimpl0, layoutDirection, m1060PaddingValuesa9UjIt4);
                        return place;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1399185516);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)171@6874L62,168@6760L182:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
            Function2<Composer, Integer, Unit> combineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listOf);
            startRestartGroup.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(multiContentMeasurePolicy);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue2;
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, measurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            combineAsVirtualLayouts.invoke(startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItemLayout$2
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

                public final void invoke(Composer composer2, int i3) {
                    ListItemKt.ListItemLayout(function2, function22, function23, function24, function25, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-xygx4p4, reason: not valid java name */
    public static final int m2670calculateWidthxygx4p4(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, LayoutDirection layoutDirection, PaddingValues paddingValues, long j) {
        if (Constraints.getHasBoundedWidth-impl(j)) {
            return Constraints.getMaxWidth-impl(j);
        }
        int i = measureScope.roundToPx-0680j_4(Dp.constructor-impl(paddingValues.mo998calculateLeftPaddingu2uoSUM(layoutDirection) + paddingValues.mo999calculateRightPaddingu2uoSUM(layoutDirection)));
        return i + TextFieldImplKt.widthOrZero(placeable) + Math.max(TextFieldImplKt.widthOrZero(placeable3), Math.max(TextFieldImplKt.widthOrZero(placeable4), TextFieldImplKt.widthOrZero(placeable5))) + TextFieldImplKt.widthOrZero(placeable2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-N4Jib3Y, reason: not valid java name */
    public static final int m2669calculateHeightN4Jib3Y(MeasureScope measureScope, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, int i, PaddingValues paddingValues, long j) {
        float m3716getListItemTwoLineContainerHeightD9Ej5fM;
        if (ListItemType.m2675equalsimpl0(i, ListItemType.INSTANCE.m2681getOneLineAlXitO8())) {
            m3716getListItemTwoLineContainerHeightD9Ej5fM = ListTokens.INSTANCE.m3712getListItemOneLineContainerHeightD9Ej5fM();
        } else {
            m3716getListItemTwoLineContainerHeightD9Ej5fM = ListItemType.m2675equalsimpl0(i, ListItemType.INSTANCE.m2683getTwoLineAlXitO8()) ? ListTokens.INSTANCE.m3716getListItemTwoLineContainerHeightD9Ej5fM() : ListTokens.INSTANCE.m3714getListItemThreeLineContainerHeightD9Ej5fM();
        }
        return RangesKt.coerceAtMost(Math.max(Math.max(Constraints.getMinHeight-impl(j), measureScope.roundToPx-0680j_4(m3716getListItemTwoLineContainerHeightD9Ej5fM)), measureScope.roundToPx-0680j_4(Dp.constructor-impl(paddingValues.getTop() + paddingValues.getBottom())) + Math.max(TextFieldImplKt.heightOrZero(placeable), Math.max(TextFieldImplKt.heightOrZero(placeable3) + TextFieldImplKt.heightOrZero(placeable4) + TextFieldImplKt.heightOrZero(placeable5), TextFieldImplKt.heightOrZero(placeable2)))), Constraints.getMaxHeight-impl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult place(final MeasureScope measureScope, final int i, final int i2, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, final Placeable placeable5, final boolean z, final LayoutDirection layoutDirection, final PaddingValues paddingValues) {
        return MeasureScope.layout$default(measureScope, i, i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ListItemKt$place$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                int i3 = MeasureScope.this.roundToPx-0680j_4(PaddingKt.calculateStartPadding(paddingValues, layoutDirection));
                int i4 = MeasureScope.this.roundToPx-0680j_4(PaddingKt.calculateEndPadding(paddingValues, layoutDirection));
                int i5 = MeasureScope.this.roundToPx-0680j_4(paddingValues.getTop());
                Placeable placeable6 = placeable;
                if (placeable6 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable6, i3, z ? i5 : Alignment.INSTANCE.getCenterVertically().align(placeable6.getHeight(), i2), 0.0f, 4, null);
                }
                Placeable placeable7 = placeable2;
                if (placeable7 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable7, (i - i4) - placeable7.getWidth(), z ? i5 : Alignment.INSTANCE.getCenterVertically().align(placeable7.getHeight(), i2), 0.0f, 4, null);
                }
                int widthOrZero = i3 + TextFieldImplKt.widthOrZero(placeable);
                if (!z) {
                    i5 = Alignment.INSTANCE.getCenterVertically().align(TextFieldImplKt.heightOrZero(placeable3) + TextFieldImplKt.heightOrZero(placeable4) + TextFieldImplKt.heightOrZero(placeable5), i2);
                }
                Placeable placeable8 = placeable4;
                if (placeable8 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable8, widthOrZero, i5, 0.0f, 4, null);
                }
                int heightOrZero = i5 + TextFieldImplKt.heightOrZero(placeable4);
                Placeable placeable9 = placeable3;
                if (placeable9 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable9, widthOrZero, heightOrZero, 0.0f, 4, null);
                }
                int heightOrZero2 = heightOrZero + TextFieldImplKt.heightOrZero(placeable3);
                Placeable placeable10 = placeable5;
                if (placeable10 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable10, widthOrZero, heightOrZero2, 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ProvideTextStyleFromToken-3J-VO9M, reason: not valid java name */
    public static final void m2665ProvideTextStyleFromToken3JVO9M(final long j, final TypographyKeyTokens typographyKeyTokens, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1133967795);
        ComposerKt.sourceInformation(startRestartGroup, "C(ProvideTextStyleFromToken)P(0:c#ui.graphics.Color,2)520@20833L10,518@20747L142:ListItem.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(typographyKeyTokens) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function2) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1133967795, i2, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:518)");
            }
            ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(j, TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(startRestartGroup, 6), typographyKeyTokens), function2, startRestartGroup, (i2 & 14) | (i2 & 896));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ProvideTextStyleFromToken$1
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

                public final void invoke(Composer composer2, int i3) {
                    ListItemKt.m2665ProvideTextStyleFromToken3JVO9M(j, typographyKeyTokens, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final float getListItemVerticalPadding() {
        return ListItemVerticalPadding;
    }

    public static final float getListItemThreeLineVerticalPadding() {
        return ListItemThreeLineVerticalPadding;
    }

    public static final float getListItemStartPadding() {
        return ListItemStartPadding;
    }

    public static final float getListItemEndPadding() {
        return ListItemEndPadding;
    }

    public static final float getLeadingContentEndPadding() {
        return LeadingContentEndPadding;
    }

    public static final float getTrailingContentStartPadding() {
        return TrailingContentStartPadding;
    }

    static {
        float f = 16;
        ListItemStartPadding = Dp.constructor-impl(f);
        ListItemEndPadding = Dp.constructor-impl(f);
        LeadingContentEndPadding = Dp.constructor-impl(f);
        TrailingContentStartPadding = Dp.constructor-impl(f);
    }
}
