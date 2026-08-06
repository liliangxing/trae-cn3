package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.ClipKt;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.p002ui.graphics.GraphicsLayerScope;
import androidx.compose.p002ui.layout.LayoutIdKt;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.OnRemeasuredModifierKt;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: NavigationBar.kt */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u001ab\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00140\u001e¢\u0006\u0002\b ¢\u0006\u0002\b!H\u0007ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001aq\u0010$\u001a\u00020\u00142\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010&¢\u0006\u0002\b 2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0&H\u0003¢\u0006\u0002\u0010.\u001a\u0083\u0001\u0010/\u001a\u00020\u0014*\u00020\u001f2\u0006\u00100\u001a\u00020+2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00140&2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\b 2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u00102\u001a\u00020+2\u0015\b\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010&¢\u0006\u0002\b 2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u000206H\u0007¢\u0006\u0002\u00107\u001a8\u00108\u001a\u000209*\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\u001aP\u0010C\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\b\u0010>\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020@2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\b\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0010\u0010\n\"\u0016\u0010\u0011\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0012\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006G²\u0006\n\u0010H\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010I\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020\fX\u008a\u008e\u0002"}, d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "()F", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationBarHeight", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemLayout", NavigationBarKt.IndicatorRippleLayoutIdTag, "Lkotlin/Function0;", NavigationBarKt.IndicatorLayoutIdTag, NavigationBarKt.IconLayoutIdTag, NavigationBarKt.LabelLayoutIdTag, "alwaysShowLabel", "", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NavigationBarItem", "selected", "onClick", "enabled", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor", "itemWidth"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class NavigationBarKt {
    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPadding;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight = NavigationBarTokens.INSTANCE.m3724getContainerHeightD9Ej5fM();
    private static final float NavigationBarItemHorizontalPadding = Dp.constructor-impl(8);
    private static final float NavigationBarIndicatorToLabelPadding = Dp.constructor-impl(4);
    private static final float IndicatorVerticalOffset = Dp.constructor-impl(12);

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0099  */
    /* renamed from: NavigationBar-HsRjFd4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m2725NavigationBarHsRjFd4(Modifier modifier, long j, long j2, float f, WindowInsets windowInsets, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        long j3;
        long j4;
        float f2;
        WindowInsets windowInsets2;
        Modifier.Companion companion;
        final WindowInsets windowInsets3;
        float f3;
        ScopeUpdateScope endRestartGroup;
        int i4;
        int i5;
        Composer startRestartGroup = composer.startRestartGroup(1596802123);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationBar)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,5)103@4868L14,104@4924L11,106@5082L12,109@5149L583:NavigationBar.kt#uh7d8r");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                j3 = j;
                if (startRestartGroup.changed(j3)) {
                    i5 = 32;
                    i3 |= i5;
                }
            } else {
                j3 = j;
            }
            i5 = 16;
            i3 |= i5;
        } else {
            j3 = j;
        }
        if ((i & 384) == 0) {
            j4 = j2;
            i3 |= ((i2 & 4) == 0 && startRestartGroup.changed(j4)) ? Fields.RotationX : Fields.SpotShadowColor;
        } else {
            j4 = j2;
        }
        int i7 = i2 & 8;
        if (i7 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            f2 = f;
            i3 |= startRestartGroup.changed(f2) ? Fields.CameraDistance : Fields.RotationZ;
            if ((i & 24576) != 0) {
                if ((i2 & 16) == 0) {
                    windowInsets2 = windowInsets;
                    if (startRestartGroup.changed(windowInsets2)) {
                        i4 = Fields.Clip;
                        i3 |= i4;
                    }
                } else {
                    windowInsets2 = windowInsets;
                }
                i4 = Fields.Shape;
                i3 |= i4;
            } else {
                windowInsets2 = windowInsets;
            }
            if ((i2 & 32) == 0) {
                i3 |= 196608;
            } else if ((i & 196608) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? Fields.RenderEffect : 65536;
            }
            if ((74899 & i3) == 74898 || !startRestartGroup.getSkipping()) {
                startRestartGroup.startDefaults();
                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                    companion = i6 == 0 ? Modifier.INSTANCE : modifier2;
                    if ((i2 & 2) != 0) {
                        j3 = NavigationBarDefaults.INSTANCE.getContainerColor(startRestartGroup, 6);
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        j4 = ColorSchemeKt.m2380contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 6), j3);
                        i3 &= -897;
                    }
                    if (i7 != 0) {
                        f2 = NavigationBarDefaults.INSTANCE.m2712getElevationD9Ej5fM();
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        windowInsets3 = NavigationBarDefaults.INSTANCE.getWindowInsets(startRestartGroup, 6);
                        f3 = f2;
                        long j5 = j4;
                        int i8 = i3;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1596802123, i8, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:108)");
                        }
                        int i9 = (i8 & 14) | 12582912;
                        int i10 = i8 << 3;
                        int i11 = i9 | (i10 & 896) | (i10 & 7168) | (i10 & 57344);
                        WindowInsets windowInsets4 = windowInsets3;
                        SurfaceKt.m3043SurfaceT9BRK9s(companion, null, j3, j5, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 105663120, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$1
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
                                float f4;
                                ComposerKt.sourceInformation(composer2, "C115@5312L414:NavigationBar.kt#uh7d8r");
                                if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(105663120, i12, -1, "androidx.compose.material3.NavigationBar.<anonymous> (NavigationBar.kt:115)");
                                    }
                                    Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                                    f4 = NavigationBarKt.NavigationBarHeight;
                                    Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m1105defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f4, 1, null));
                                    Arrangement.HorizontalOrVertical m909spacedBy0680j_4 = Arrangement.INSTANCE.m909spacedBy0680j_4(NavigationBarKt.getNavigationBarItemHorizontalPadding());
                                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                                    composer2.startReplaceableGroup(693286680);
                                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m909spacedBy0680j_4, centerVertically, composer2, 54);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(selectableGroup);
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
                                    Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                                    function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
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
                        }), startRestartGroup, i11, 98);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        windowInsets2 = windowInsets4;
                        j4 = j5;
                    }
                } else {
                    startRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                    }
                    companion = modifier2;
                }
                f3 = f2;
                windowInsets3 = windowInsets2;
                long j52 = j4;
                int i82 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i92 = (i82 & 14) | 12582912;
                int i102 = i82 << 3;
                int i112 = i92 | (i102 & 896) | (i102 & 7168) | (i102 & 57344);
                WindowInsets windowInsets42 = windowInsets3;
                SurfaceKt.m3043SurfaceT9BRK9s(companion, null, j3, j52, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 105663120, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$1
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
                        float f4;
                        ComposerKt.sourceInformation(composer2, "C115@5312L414:NavigationBar.kt#uh7d8r");
                        if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(105663120, i12, -1, "androidx.compose.material3.NavigationBar.<anonymous> (NavigationBar.kt:115)");
                            }
                            Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                            f4 = NavigationBarKt.NavigationBarHeight;
                            Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m1105defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f4, 1, null));
                            Arrangement.HorizontalOrVertical m909spacedBy0680j_4 = Arrangement.INSTANCE.m909spacedBy0680j_4(NavigationBarKt.getNavigationBarItemHorizontalPadding());
                            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                            Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                            composer2.startReplaceableGroup(693286680);
                            ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m909spacedBy0680j_4, centerVertically, composer2, 54);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                            Function0 constructor = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(selectableGroup);
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
                            Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                            }
                            modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                            function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
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
                }), startRestartGroup, i112, 98);
                if (ComposerKt.isTraceInProgress()) {
                }
                windowInsets2 = windowInsets42;
                j4 = j52;
            } else {
                startRestartGroup.skipToGroupEnd();
                companion = modifier2;
                f3 = f2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                final Modifier modifier3 = companion;
                final long j6 = j3;
                final long j7 = j4;
                final float f4 = f3;
                final WindowInsets windowInsets5 = windowInsets2;
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$2
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
                        NavigationBarKt.m2725NavigationBarHsRjFd4(Modifier.this, j6, j7, f4, windowInsets5, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        f2 = f;
        if ((i & 24576) != 0) {
        }
        if ((i2 & 32) == 0) {
        }
        if ((74899 & i3) == 74898) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i6 == 0) {
        }
        if ((i2 & 2) != 0) {
        }
        if ((i2 & 4) != 0) {
        }
        if (i7 != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        f3 = f2;
        windowInsets3 = windowInsets2;
        long j522 = j4;
        int i822 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i922 = (i822 & 14) | 12582912;
        int i1022 = i822 << 3;
        int i1122 = i922 | (i1022 & 896) | (i1022 & 7168) | (i1022 & 57344);
        WindowInsets windowInsets422 = windowInsets3;
        SurfaceKt.m3043SurfaceT9BRK9s(companion, null, j3, j522, f3, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, 105663120, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBar$1
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
                float f42;
                ComposerKt.sourceInformation(composer2, "C115@5312L414:NavigationBar.kt#uh7d8r");
                if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(105663120, i12, -1, "androidx.compose.material3.NavigationBar.<anonymous> (NavigationBar.kt:115)");
                    }
                    Modifier windowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), WindowInsets.this);
                    f42 = NavigationBarKt.NavigationBarHeight;
                    Modifier selectableGroup = SelectableGroupKt.selectableGroup(SizeKt.m1105defaultMinSizeVpY3zN4$default(windowInsetsPadding, 0.0f, f42, 1, null));
                    Arrangement.HorizontalOrVertical m909spacedBy0680j_4 = Arrangement.INSTANCE.m909spacedBy0680j_4(NavigationBarKt.getNavigationBarItemHorizontalPadding());
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    Function3<RowScope, Composer, Integer, Unit> function32 = function3;
                    composer2.startReplaceableGroup(693286680);
                    ComposerKt.sourceInformation(composer2, "CC(Row)P(2,1,3)90@4553L58,91@4616L130:Row.kt#2w3rfo");
                    MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m909spacedBy0680j_4, centerVertically, composer2, 54);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(selectableGroup);
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
                    Updater.m4116setimpl(m4109constructorimpl, rowMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -326681643, "C92@4661L9:Row.kt#2w3rfo");
                    function32.invoke(RowScopeInstance.INSTANCE, composer2, 6);
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
        }), startRestartGroup, i1122, 98);
        if (ComposerKt.isTraceInProgress()) {
        }
        windowInsets2 = windowInsets422;
        j4 = j522;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0432, code lost:
    
        if (r6 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L186;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0473  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void NavigationBarItem(final RowScope rowScope, final boolean z, final Function0<Unit> function0, final Function2<? super Composer, ? super Integer, Unit> function2, Modifier modifier, boolean z2, Function2<? super Composer, ? super Integer, Unit> function22, boolean z3, NavigationBarItemColors navigationBarItemColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        int i5;
        Function2<? super Composer, ? super Integer, Unit> function23;
        int i6;
        boolean z4;
        int i7;
        final MutableInteractionSource mutableInteractionSource2;
        NavigationBarItemColors navigationBarItemColors2;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier2;
        final NavigationBarItemColors navigationBarItemColors3;
        boolean z5;
        final boolean z6;
        final Function2<? super Composer, ? super Integer, Unit> function24;
        int i8;
        Object rememberedValue;
        Object rememberedValue2;
        int currentCompositeKeyHash;
        Composer m4109constructorimpl;
        boolean changed;
        Object rememberedValue3;
        boolean changed2;
        Object obj;
        final NavigationBarItemColors navigationBarItemColors4;
        final boolean z7;
        final boolean z8;
        final Function2<? super Composer, ? super Integer, Unit> function25;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        int i9;
        Composer startRestartGroup = composer.startRestartGroup(-663510974);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationBarItem)P(8,7,3,6,2,5)171@7961L8,172@8021L39,195@9011L33,209@9453L52,197@9050L2789:NavigationBar.kt#uh7d8r");
        if ((Integer.MIN_VALUE & i2) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(rowScope) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 1) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 2) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changedInstance(function0) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 4) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changedInstance(function2) ? Fields.CameraDistance : Fields.RotationZ;
        }
        int i10 = i2 & 8;
        if (i10 != 0) {
            i3 |= 24576;
        } else if ((i & 24576) == 0) {
            i3 |= startRestartGroup.changed(modifier) ? Fields.Clip : Fields.Shape;
            i4 = i2 & 16;
            if (i4 == 0) {
                i3 |= 196608;
            } else if ((196608 & i) == 0) {
                i3 |= startRestartGroup.changed(z2) ? Fields.RenderEffect : 65536;
                i5 = i2 & 32;
                if (i5 != 0) {
                    i3 |= 1572864;
                } else if ((1572864 & i) == 0) {
                    function23 = function22;
                    i3 |= startRestartGroup.changedInstance(function23) ? 1048576 : Fields.BlendMode;
                    i6 = i2 & 64;
                    if (i6 == 0) {
                        i3 |= 12582912;
                        z4 = z3;
                    } else {
                        z4 = z3;
                        if ((i & 12582912) == 0) {
                            i3 |= startRestartGroup.changed(z4) ? 8388608 : 4194304;
                        }
                    }
                    if ((i & 100663296) == 0) {
                        if ((i2 & Fields.SpotShadowColor) == 0 && startRestartGroup.changed(navigationBarItemColors)) {
                            i9 = 67108864;
                            i3 |= i9;
                        }
                        i9 = 33554432;
                        i3 |= i9;
                    }
                    i7 = i2 & Fields.RotationX;
                    if (i7 == 0) {
                        i3 |= 805306368;
                        mutableInteractionSource2 = mutableInteractionSource;
                    } else {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if ((i & 805306368) == 0) {
                            i3 |= startRestartGroup.changed(mutableInteractionSource2) ? 536870912 : 268435456;
                        }
                    }
                    if ((i3 & 306783379) == 306783378 || !startRestartGroup.getSkipping()) {
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                            Modifier.Companion companion = i10 == 0 ? Modifier.INSTANCE : modifier;
                            boolean z9 = i4 == 0 ? true : z2;
                            Function2<? super Composer, ? super Integer, Unit> function26 = i5 == 0 ? null : function22;
                            if (i6 != 0) {
                                z4 = true;
                            }
                            if ((i2 & Fields.SpotShadowColor) == 0) {
                                navigationBarItemColors2 = NavigationBarItemDefaults.INSTANCE.colors(startRestartGroup, 6);
                                i3 &= -234881025;
                            } else {
                                navigationBarItemColors2 = navigationBarItemColors;
                            }
                            if (i7 == 0) {
                                startRestartGroup.startReplaceableGroup(-280425562);
                                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue4 = InteractionSourceKt.MutableInteractionSource();
                                    startRestartGroup.updateRememberedValue(rememberedValue4);
                                }
                                startRestartGroup.endReplaceableGroup();
                                mutableInteractionSource3 = (MutableInteractionSource) rememberedValue4;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            modifier2 = companion;
                            navigationBarItemColors3 = navigationBarItemColors2;
                            z5 = z4;
                            z6 = z9;
                            function24 = function26;
                            i8 = i3;
                        } else {
                            startRestartGroup.skipToGroupEnd();
                            if ((i2 & Fields.SpotShadowColor) != 0) {
                                i3 &= -234881025;
                            }
                            modifier2 = modifier;
                            function24 = function22;
                            navigationBarItemColors3 = navigationBarItemColors;
                            mutableInteractionSource3 = mutableInteractionSource;
                            i8 = i3;
                            z5 = z4;
                            z6 = z2;
                        }
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-663510974, i8, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:173)");
                        }
                        final NavigationBarItemColors navigationBarItemColors5 = navigationBarItemColors3;
                        final boolean z10 = z6;
                        final Function2<? super Composer, ? super Integer, Unit> function27 = function24;
                        final boolean z11 = z5;
                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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

                            public final void invoke(Composer composer2, int i11) {
                                ComposerKt.sourceInformation(composer2, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                                if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1419576100, i11, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                                    }
                                    State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z10, composer2, 0);
                                    Modifier.Companion clearAndSetSemantics = function27 != null && (z11 || z) ? SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
                                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                            invoke((SemanticsPropertyReceiver) obj2);
                                            return Unit.INSTANCE;
                                        }
                                    }) : Modifier.INSTANCE;
                                    Function2<Composer, Integer, Unit> function28 = function2;
                                    composer2.startReplaceableGroup(733328855);
                                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                                    MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                                    composer2.startReplaceableGroup(-1323940314);
                                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
                                    if (!(composer2.getApplier() instanceof Applier)) {
                                        ComposablesKt.invalidApplier();
                                    }
                                    composer2.startReusableNode();
                                    if (composer2.getInserting()) {
                                        composer2.createNode(constructor);
                                    } else {
                                        composer2.useNode();
                                    }
                                    Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer2);
                                    Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                    Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                    if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash);
                                    }
                                    modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                                    composer2.startReplaceableGroup(2058660585);
                                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(composer2, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
                                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(invoke$lambda$0(iconColor$material3_release))), function28, composer2, ProvidedValue.$stable | 0);
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

                            private static final long invoke$lambda$0(State<Color> state) {
                                return state.getValue().m4849unboximpl();
                            }
                        });
                        ComposableLambda composableLambda2 = function24 == null ? ComposableLambdaKt.composableLambda(startRestartGroup, 1644987592, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledLabel$1$1
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

                            public final void invoke(Composer composer2, int i11) {
                                ComposerKt.sourceInformation(composer2, "C185@8666L10,186@8758L49,187@8820L152:NavigationBar.kt#uh7d8r");
                                if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1644987592, i11, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:185)");
                                    }
                                    ProvideContentColorTextStyleKt.m2813ProvideContentColorTextStyle3JVO9M(invoke$lambda$0(NavigationBarItemColors.this.textColor$material3_release(z, z6, composer2, 0)), TypographyKt.fromToken(MaterialTheme.INSTANCE.getTypography(composer2, 6), NavigationBarTokens.INSTANCE.getLabelTextFont()), function24, composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }

                            private static final long invoke$lambda$0(State<Color> state) {
                                return state.getValue().m4849unboximpl();
                            }
                        }) : null;
                        startRestartGroup.startReplaceableGroup(-280424572);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                        rememberedValue = startRestartGroup.rememberedValue();
                        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                            rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
                            startRestartGroup.updateRememberedValue(rememberedValue);
                        }
                        final MutableIntState mutableIntState = (MutableIntState) rememberedValue;
                        startRestartGroup.endReplaceableGroup();
                        Modifier modifier4 = modifier2;
                        int i11 = i8;
                        Modifier weight$default = RowScope.weight$default(rowScope, SizeKt.m1105defaultMinSizeVpY3zN4$default(SelectableKt.m1432selectableO2vRcR0(modifier2, z, mutableInteractionSource3, null, z6, Role.box-impl(Role.Companion.getTab-o7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                        startRestartGroup.startReplaceableGroup(-280424130);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                        rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue2 = (Function1) new Function1<IntSize, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$2$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    m2730invokeozmzZPI(((IntSize) obj2).unbox-impl());
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke-ozmzZPI, reason: not valid java name */
                                public final void m2730invokeozmzZPI(long j) {
                                    MutableIntState.this.setIntValue(IntSize.getWidth-impl(j));
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        }
                        startRestartGroup.endReplaceableGroup();
                        Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(weight$default, (Function1) rememberedValue2);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        startRestartGroup.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, true, startRestartGroup, 54);
                        startRestartGroup.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                        Function0 constructor = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(onSizeChanged);
                        if (!(startRestartGroup.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        startRestartGroup.startReusableNode();
                        if (startRestartGroup.getInserting()) {
                            startRestartGroup.useNode();
                        } else {
                            startRestartGroup.createNode(constructor);
                        }
                        m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (!m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                        }
                        modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                        startRestartGroup.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
                        final NavigationBarItemColors navigationBarItemColors6 = navigationBarItemColors3;
                        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
                        final State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                        ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        Object consume = startRestartGroup.consume(localDensity);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        long Offset = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState) - r4.roundToPx-0680j_4(NavigationBarTokens.INSTANCE.m3722getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume).toPx-0680j_4(IndicatorVerticalOffset));
                        Unit unit = Unit.INSTANCE;
                        startRestartGroup.startReplaceableGroup(1035150713);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                        changed = startRestartGroup.changed(Offset) | ((1879048192 & i11) != 536870912);
                        rememberedValue3 = startRestartGroup.rememberedValue();
                        if (!changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, Offset, null);
                            startRestartGroup.updateRememberedValue(rememberedValue3);
                        }
                        final MappedInteractionSource mappedInteractionSource = (MappedInteractionSource) rememberedValue3;
                        startRestartGroup.endReplaceableGroup();
                        ComposableLambda composableLambda3 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke((Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i12) {
                                ComposerKt.sourceInformation(composer2, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                                if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(691730997, i12, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                                    }
                                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m2177rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        });
                        ComposableLambda composableLambda4 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                                invoke((Composer) obj2, ((Number) obj3).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i12) {
                                ComposerKt.sourceInformation(composer2, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                                if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-474426875, i12, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                                    }
                                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                                    composer2.startReplaceableGroup(1844203561);
                                    ComposerKt.sourceInformation(composer2, "CC(remember):NavigationBar.kt#9igjgp");
                                    boolean changed3 = composer2.changed(animateFloatAsState);
                                    final State<Float> state = animateFloatAsState;
                                    Object rememberedValue5 = composer2.rememberedValue();
                                    if (changed3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue5 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                                invoke((GraphicsLayerScope) obj2);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                                graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                            }
                                        };
                                        composer2.updateRememberedValue(rememberedValue5);
                                    }
                                    composer2.endReplaceableGroup();
                                    BoxKt.Box(BackgroundKt.m396backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue5), navigationBarItemColors6.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer2.skipToGroupEnd();
                            }
                        });
                        startRestartGroup.startReplaceableGroup(1035152133);
                        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                        changed2 = startRestartGroup.changed(animateFloatAsState);
                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                        if (!changed2) {
                            obj = rememberedValue5;
                        }
                        Function0<Float> function02 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                            public final Float m2731invoke() {
                                return animateFloatAsState.getValue();
                            }
                        };
                        startRestartGroup.updateRememberedValue(function02);
                        obj = function02;
                        startRestartGroup.endReplaceableGroup();
                        NavigationBarItemLayout(composableLambda3, composableLambda4, composableLambda, composableLambda2, z5, (Function0) obj, startRestartGroup, ((i11 >> 9) & 57344) | 438);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceableGroup();
                        startRestartGroup.endReplaceableGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        navigationBarItemColors4 = navigationBarItemColors6;
                        z7 = z6;
                        z8 = z5;
                        function25 = function28;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier3 = modifier4;
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        modifier3 = modifier;
                        z7 = z2;
                        function25 = function23;
                        z8 = z4;
                        navigationBarItemColors4 = navigationBarItemColors;
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$4
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

                            public final void invoke(Composer composer2, int i12) {
                                NavigationBarKt.NavigationBarItem(RowScope.this, z, function0, function2, modifier3, z7, function25, z8, navigationBarItemColors4, mutableInteractionSource2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                        return;
                    }
                    return;
                }
                function23 = function22;
                i6 = i2 & 64;
                if (i6 == 0) {
                }
                if ((i & 100663296) == 0) {
                }
                i7 = i2 & Fields.RotationX;
                if (i7 == 0) {
                }
                if ((i3 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i10 == 0) {
                }
                if (i4 == 0) {
                }
                if (i5 == 0) {
                }
                if (i6 != 0) {
                }
                if ((i2 & Fields.SpotShadowColor) == 0) {
                }
                if (i7 == 0) {
                }
                modifier2 = companion;
                navigationBarItemColors3 = navigationBarItemColors2;
                z5 = z4;
                z6 = z9;
                function24 = function26;
                i8 = i3;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final NavigationBarItemColors navigationBarItemColors52 = navigationBarItemColors3;
                final boolean z102 = z6;
                final Function2<? super Composer, ? super Integer, Unit> function272 = function24;
                final boolean z112 = z5;
                ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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

                    public final void invoke(Composer composer2, int i112) {
                        ComposerKt.sourceInformation(composer2, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                        if ((i112 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1419576100, i112, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                            }
                            State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z102, composer2, 0);
                            Modifier.Companion clearAndSetSemantics = function272 != null && (z112 || z) ? SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
                                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((SemanticsPropertyReceiver) obj2);
                                    return Unit.INSTANCE;
                                }
                            }) : Modifier.INSTANCE;
                            Function2<Composer, Integer, Unit> function282 = function2;
                            composer2.startReplaceableGroup(733328855);
                            ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                            MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                            composer2.startReplaceableGroup(-1323940314);
                            ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
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
                            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                            }
                            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                            composer2.startReplaceableGroup(2058660585);
                            ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composer2, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
                            CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(invoke$lambda$0(iconColor$material3_release))), function282, composer2, ProvidedValue.$stable | 0);
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

                    private static final long invoke$lambda$0(State<Color> state) {
                        return state.getValue().m4849unboximpl();
                    }
                });
                if (function24 == null) {
                }
                startRestartGroup.startReplaceableGroup(-280424572);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                }
                final MutableIntState mutableIntState2 = (MutableIntState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                Modifier modifier42 = modifier2;
                int i112 = i8;
                Modifier weight$default2 = RowScope.weight$default(rowScope, SizeKt.m1105defaultMinSizeVpY3zN4$default(SelectableKt.m1432selectableO2vRcR0(modifier2, z, mutableInteractionSource3, null, z6, Role.box-impl(Role.Companion.getTab-o7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
                startRestartGroup.startReplaceableGroup(-280424130);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                }
                startRestartGroup.endReplaceableGroup();
                Modifier onSizeChanged2 = OnRemeasuredModifierKt.onSizeChanged(weight$default2, (Function1) rememberedValue2);
                Alignment center2 = Alignment.INSTANCE.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, true, startRestartGroup, 54);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(onSizeChanged2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                }
                m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m4109constructorimpl.getInserting()) {
                }
                m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
                modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
                final NavigationBarItemColors navigationBarItemColors62 = navigationBarItemColors3;
                Function2<? super Composer, ? super Integer, Unit> function282 = function24;
                final State<Float> animateFloatAsState2 = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
                ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(localDensity2);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                long Offset2 = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState2) - r4.roundToPx-0680j_4(NavigationBarTokens.INSTANCE.m3722getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume2).toPx-0680j_4(IndicatorVerticalOffset));
                Unit unit2 = Unit.INSTANCE;
                startRestartGroup.startReplaceableGroup(1035150713);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                changed = startRestartGroup.changed(Offset2) | ((1879048192 & i112) != 536870912);
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (!changed) {
                }
                rememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, Offset2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
                final MappedInteractionSource mappedInteractionSource2 = (MappedInteractionSource) rememberedValue3;
                startRestartGroup.endReplaceableGroup();
                ComposableLambda composableLambda32 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i12) {
                        ComposerKt.sourceInformation(composer2, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                        if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(691730997, i12, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                            }
                            BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m2177rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                ComposableLambda composableLambda42 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        invoke((Composer) obj2, ((Number) obj3).intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i12) {
                        ComposerKt.sourceInformation(composer2, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                        if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-474426875, i12, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                            }
                            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                            composer2.startReplaceableGroup(1844203561);
                            ComposerKt.sourceInformation(composer2, "CC(remember):NavigationBar.kt#9igjgp");
                            boolean changed3 = composer2.changed(animateFloatAsState2);
                            final State<Float> state = animateFloatAsState2;
                            Object rememberedValue52 = composer2.rememberedValue();
                            if (changed3 || rememberedValue52 == Composer.INSTANCE.getEmpty()) {
                                rememberedValue52 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                        invoke((GraphicsLayerScope) obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                        graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                    }
                                };
                                composer2.updateRememberedValue(rememberedValue52);
                            }
                            composer2.endReplaceableGroup();
                            BoxKt.Box(BackgroundKt.m396backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue52), navigationBarItemColors62.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer2.skipToGroupEnd();
                    }
                });
                startRestartGroup.startReplaceableGroup(1035152133);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                changed2 = startRestartGroup.changed(animateFloatAsState2);
                Object rememberedValue52 = startRestartGroup.rememberedValue();
                if (!changed2) {
                }
                Function0<Float> function022 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Float m2731invoke() {
                        return animateFloatAsState2.getValue();
                    }
                };
                startRestartGroup.updateRememberedValue(function022);
                obj = function022;
                startRestartGroup.endReplaceableGroup();
                NavigationBarItemLayout(composableLambda32, composableLambda42, composableLambda5, composableLambda2, z5, (Function0) obj, startRestartGroup, ((i112 >> 9) & 57344) | 438);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                }
                navigationBarItemColors4 = navigationBarItemColors62;
                z7 = z6;
                z8 = z5;
                function25 = function282;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier3 = modifier42;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i5 = i2 & 32;
            if (i5 != 0) {
            }
            function23 = function22;
            i6 = i2 & 64;
            if (i6 == 0) {
            }
            if ((i & 100663296) == 0) {
            }
            i7 = i2 & Fields.RotationX;
            if (i7 == 0) {
            }
            if ((i3 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i10 == 0) {
            }
            if (i4 == 0) {
            }
            if (i5 == 0) {
            }
            if (i6 != 0) {
            }
            if ((i2 & Fields.SpotShadowColor) == 0) {
            }
            if (i7 == 0) {
            }
            modifier2 = companion;
            navigationBarItemColors3 = navigationBarItemColors2;
            z5 = z4;
            z6 = z9;
            function24 = function26;
            i8 = i3;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final NavigationBarItemColors navigationBarItemColors522 = navigationBarItemColors3;
            final boolean z1022 = z6;
            final Function2<? super Composer, ? super Integer, Unit> function2722 = function24;
            final boolean z1122 = z5;
            ComposableLambda composableLambda52 = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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

                public final void invoke(Composer composer2, int i1122) {
                    ComposerKt.sourceInformation(composer2, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                    if ((i1122 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1419576100, i1122, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                        }
                        State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z1022, composer2, 0);
                        Modifier.Companion clearAndSetSemantics = function2722 != null && (z1122 || z) ? SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
                            public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((SemanticsPropertyReceiver) obj2);
                                return Unit.INSTANCE;
                            }
                        }) : Modifier.INSTANCE;
                        Function2<Composer, Integer, Unit> function2822 = function2;
                        composer2.startReplaceableGroup(733328855);
                        ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                        MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(-1323940314);
                        ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap22 = composer2.getCurrentCompositionLocalMap();
                        Function0 constructor22 = ComposeUiNode.Companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor22);
                        } else {
                            composer2.useNode();
                        }
                        Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer2);
                        Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy22, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap22, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Function2 setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                        if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
                        }
                        modifierMaterializerOf22.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composer2, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
                        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(invoke$lambda$0(iconColor$material3_release))), function2822, composer2, ProvidedValue.$stable | 0);
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

                private static final long invoke$lambda$0(State<Color> state) {
                    return state.getValue().m4849unboximpl();
                }
            });
            if (function24 == null) {
            }
            startRestartGroup.startReplaceableGroup(-280424572);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            }
            final MutableIntState mutableIntState22 = (MutableIntState) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            Modifier modifier422 = modifier2;
            int i1122 = i8;
            Modifier weight$default22 = RowScope.weight$default(rowScope, SizeKt.m1105defaultMinSizeVpY3zN4$default(SelectableKt.m1432selectableO2vRcR0(modifier2, z, mutableInteractionSource3, null, z6, Role.box-impl(Role.Companion.getTab-o7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
            startRestartGroup.startReplaceableGroup(-280424130);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            }
            startRestartGroup.endReplaceableGroup();
            Modifier onSizeChanged22 = OnRemeasuredModifierKt.onSizeChanged(weight$default22, (Function1) rememberedValue2);
            Alignment center22 = Alignment.INSTANCE.getCenter();
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy22 = BoxKt.rememberBoxMeasurePolicy(center22, true, startRestartGroup, 54);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor22 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf22 = LayoutKt.modifierMaterializerOf(onSizeChanged22);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
            }
            m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy22, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap22, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash22 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (!m4109constructorimpl.getInserting()) {
            }
            m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash22);
            modifierMaterializerOf22.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance22 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
            final NavigationBarItemColors navigationBarItemColors622 = navigationBarItemColors3;
            Function2<? super Composer, ? super Integer, Unit> function2822 = function24;
            final State<Float> animateFloatAsState22 = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
            ProvidableCompositionLocal localDensity22 = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume22 = startRestartGroup.consume(localDensity22);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            long Offset22 = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState22) - r4.roundToPx-0680j_4(NavigationBarTokens.INSTANCE.m3722getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume22).toPx-0680j_4(IndicatorVerticalOffset));
            Unit unit22 = Unit.INSTANCE;
            startRestartGroup.startReplaceableGroup(1035150713);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            changed = startRestartGroup.changed(Offset22) | ((1879048192 & i1122) != 536870912);
            rememberedValue3 = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, Offset22, null);
            startRestartGroup.updateRememberedValue(rememberedValue3);
            final MappedInteractionSource mappedInteractionSource22 = (MappedInteractionSource) rememberedValue3;
            startRestartGroup.endReplaceableGroup();
            ComposableLambda composableLambda322 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i12) {
                    ComposerKt.sourceInformation(composer2, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                    if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(691730997, i12, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                        }
                        BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m2177rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            ComposableLambda composableLambda422 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i12) {
                    ComposerKt.sourceInformation(composer2, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                    if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-474426875, i12, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                        }
                        Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                        composer2.startReplaceableGroup(1844203561);
                        ComposerKt.sourceInformation(composer2, "CC(remember):NavigationBar.kt#9igjgp");
                        boolean changed3 = composer2.changed(animateFloatAsState22);
                        final State<Float> state = animateFloatAsState22;
                        Object rememberedValue522 = composer2.rememberedValue();
                        if (changed3 || rememberedValue522 == Composer.INSTANCE.getEmpty()) {
                            rememberedValue522 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((GraphicsLayerScope) obj2);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                    graphicsLayerScope.setAlpha(state.getValue().floatValue());
                                }
                            };
                            composer2.updateRememberedValue(rememberedValue522);
                        }
                        composer2.endReplaceableGroup();
                        BoxKt.Box(BackgroundKt.m396backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue522), navigationBarItemColors622.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            });
            startRestartGroup.startReplaceableGroup(1035152133);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            changed2 = startRestartGroup.changed(animateFloatAsState22);
            Object rememberedValue522 = startRestartGroup.rememberedValue();
            if (!changed2) {
            }
            Function0<Float> function0222 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Float m2731invoke() {
                    return animateFloatAsState22.getValue();
                }
            };
            startRestartGroup.updateRememberedValue(function0222);
            obj = function0222;
            startRestartGroup.endReplaceableGroup();
            NavigationBarItemLayout(composableLambda322, composableLambda422, composableLambda52, composableLambda2, z5, (Function0) obj, startRestartGroup, ((i1122 >> 9) & 57344) | 438);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
            }
            navigationBarItemColors4 = navigationBarItemColors622;
            z7 = z6;
            z8 = z5;
            function25 = function2822;
            mutableInteractionSource2 = mutableInteractionSource3;
            modifier3 = modifier422;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i4 = i2 & 16;
        if (i4 == 0) {
        }
        i5 = i2 & 32;
        if (i5 != 0) {
        }
        function23 = function22;
        i6 = i2 & 64;
        if (i6 == 0) {
        }
        if ((i & 100663296) == 0) {
        }
        i7 = i2 & Fields.RotationX;
        if (i7 == 0) {
        }
        if ((i3 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i10 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 != 0) {
        }
        if ((i2 & Fields.SpotShadowColor) == 0) {
        }
        if (i7 == 0) {
        }
        modifier2 = companion;
        navigationBarItemColors3 = navigationBarItemColors2;
        z5 = z4;
        z6 = z9;
        function24 = function26;
        i8 = i3;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final NavigationBarItemColors navigationBarItemColors5222 = navigationBarItemColors3;
        final boolean z10222 = z6;
        final Function2<? super Composer, ? super Integer, Unit> function27222 = function24;
        final boolean z11222 = z5;
        ComposableLambda composableLambda522 = ComposableLambdaKt.composableLambda(startRestartGroup, -1419576100, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1
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

            public final void invoke(Composer composer2, int i11222) {
                ComposerKt.sourceInformation(composer2, "C175@8132L49,178@8351L185:NavigationBar.kt#uh7d8r");
                if ((i11222 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1419576100, i11222, -1, "androidx.compose.material3.NavigationBarItem.<anonymous> (NavigationBar.kt:175)");
                    }
                    State<Color> iconColor$material3_release = NavigationBarItemColors.this.iconColor$material3_release(z, z10222, composer2, 0);
                    Modifier.Companion clearAndSetSemantics = function27222 != null && (z11222 || z) ? SemanticsModifierKt.clearAndSetSemantics(Modifier.INSTANCE, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$styledIcon$1.1
                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((SemanticsPropertyReceiver) obj2);
                            return Unit.INSTANCE;
                        }
                    }) : Modifier.INSTANCE;
                    Function2<Composer, Integer, Unit> function28222 = function2;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composer2, 0);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap222 = composer2.getCurrentCompositionLocalMap();
                    Function0 constructor222 = ComposeUiNode.Companion.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(clearAndSetSemantics);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor222);
                    } else {
                        composer2.useNode();
                    }
                    Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer2);
                    Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash222);
                    }
                    modifierMaterializerOf222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1844200723, "C179@8448L78:NavigationBar.kt#uh7d8r");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m4829boximpl(invoke$lambda$0(iconColor$material3_release))), function28222, composer2, ProvidedValue.$stable | 0);
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

            private static final long invoke$lambda$0(State<Color> state) {
                return state.getValue().m4849unboximpl();
            }
        });
        if (function24 == null) {
        }
        startRestartGroup.startReplaceableGroup(-280424572);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        final MutableIntState mutableIntState222 = (MutableIntState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        Modifier modifier4222 = modifier2;
        int i11222 = i8;
        Modifier weight$default222 = RowScope.weight$default(rowScope, SizeKt.m1105defaultMinSizeVpY3zN4$default(SelectableKt.m1432selectableO2vRcR0(modifier2, z, mutableInteractionSource3, null, z6, Role.box-impl(Role.Companion.getTab-o7Vup1c()), function0), 0.0f, NavigationBarHeight, 1, null), 1.0f, false, 2, null);
        startRestartGroup.startReplaceableGroup(-280424130);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        startRestartGroup.endReplaceableGroup();
        Modifier onSizeChanged222 = OnRemeasuredModifierKt.onSizeChanged(weight$default222, (Function1) rememberedValue2);
        Alignment center222 = Alignment.INSTANCE.getCenter();
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy rememberBoxMeasurePolicy222 = BoxKt.rememberBoxMeasurePolicy(center222, true, startRestartGroup, 54);
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap222 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor222 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf222 = LayoutKt.modifierMaterializerOf(onSizeChanged222);
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy222, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap222, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash222 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m4109constructorimpl.getInserting()) {
        }
        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash222);
        modifierMaterializerOf222.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance222 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1035149946, "C215@9646L145,*224@10075L7,231@10375L120,267@11795L27,261@11545L288:NavigationBar.kt#uh7d8r");
        final NavigationBarItemColors navigationBarItemColors6222 = navigationBarItemColors3;
        Function2<? super Composer, ? super Integer, Unit> function28222 = function24;
        final State<Float> animateFloatAsState222 = AnimateAsStateKt.animateFloatAsState(!z ? 1.0f : 0.0f, AnimationSpecKt.tween$default(100, 0, null, 6, null), 0.0f, null, null, startRestartGroup, 48, 28);
        ProvidableCompositionLocal localDensity222 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume222 = startRestartGroup.consume(localDensity222);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        long Offset222 = OffsetKt.Offset((NavigationBarItem$lambda$3(mutableIntState222) - r4.roundToPx-0680j_4(NavigationBarTokens.INSTANCE.m3722getActiveIndicatorWidthD9Ej5fM())) / 2, ((Density) consume222).toPx-0680j_4(IndicatorVerticalOffset));
        Unit unit222 = Unit.INSTANCE;
        startRestartGroup.startReplaceableGroup(1035150713);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
        changed = startRestartGroup.changed(Offset222) | ((1879048192 & i11222) != 536870912);
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue3 = new MappedInteractionSource(mutableInteractionSource3, Offset222, null);
        startRestartGroup.updateRememberedValue(rememberedValue3);
        final MappedInteractionSource mappedInteractionSource222 = (MappedInteractionSource) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        ComposableLambda composableLambda3222 = ComposableLambdaKt.composableLambda(startRestartGroup, 691730997, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicatorRipple$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i12) {
                ComposerKt.sourceInformation(composer2, "C242@10910L5,245@11056L16,239@10755L353:NavigationBar.kt#uh7d8r");
                if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(691730997, i12, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:238)");
                    }
                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId(Modifier.INSTANCE, "indicatorRipple"), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), MappedInteractionSource.this, RippleKt.m2177rememberRipple9IZ8Weo(false, 0.0f, 0L, composer2, 0, 7)), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        });
        ComposableLambda composableLambda4222 = ComposableLambdaKt.composableLambda(startRestartGroup, -474426875, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                invoke((Composer) obj2, ((Number) obj3).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i12) {
                ComposerKt.sourceInformation(composer2, "C253@11286L35,256@11483L5,250@11169L356:NavigationBar.kt#uh7d8r");
                if ((i12 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-474426875, i12, -1, "androidx.compose.material3.NavigationBarItem.<anonymous>.<anonymous> (NavigationBar.kt:250)");
                    }
                    Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "indicator");
                    composer2.startReplaceableGroup(1844203561);
                    ComposerKt.sourceInformation(composer2, "CC(remember):NavigationBar.kt#9igjgp");
                    boolean changed3 = composer2.changed(animateFloatAsState222);
                    final State<Float> state = animateFloatAsState222;
                    Object rememberedValue5222 = composer2.rememberedValue();
                    if (changed3 || rememberedValue5222 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue5222 = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$indicator$1$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((GraphicsLayerScope) obj2);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                                graphicsLayerScope.setAlpha(state.getValue().floatValue());
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue5222);
                    }
                    composer2.endReplaceableGroup();
                    BoxKt.Box(BackgroundKt.m396backgroundbw27NRU(GraphicsLayerModifierKt.graphicsLayer(layoutId, (Function1) rememberedValue5222), navigationBarItemColors6222.getSelectedIndicatorColor(), ShapesKt.getValue(NavigationBarTokens.INSTANCE.getActiveIndicatorShape(), composer2, 6)), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        });
        startRestartGroup.startReplaceableGroup(1035152133);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
        changed2 = startRestartGroup.changed(animateFloatAsState222);
        Object rememberedValue5222 = startRestartGroup.rememberedValue();
        if (!changed2) {
        }
        Function0<Float> function02222 = new Function0<Float>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItem$3$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Float m2731invoke() {
                return animateFloatAsState222.getValue();
            }
        };
        startRestartGroup.updateRememberedValue(function02222);
        obj = function02222;
        startRestartGroup.endReplaceableGroup();
        NavigationBarItemLayout(composableLambda3222, composableLambda4222, composableLambda522, composableLambda2, z5, (Function0) obj, startRestartGroup, ((i11222 >> 9) & 57344) | 438);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        navigationBarItemColors4 = navigationBarItemColors6222;
        z7 = z6;
        z8 = z5;
        function25 = function28222;
        mutableInteractionSource2 = mutableInteractionSource3;
        modifier3 = modifier4222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    private static final int NavigationBarItem$lambda$3(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NavigationBarItemLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final Function0<Float> function0, Composer composer, final int i) {
        int i2;
        Object obj;
        Composer startRestartGroup = composer.startRestartGroup(-1427075886);
        ComposerKt.sourceInformation(startRestartGroup, "C(NavigationBarItemLayout)P(4,3,2,5)520@22742L1945,506@22286L2401:NavigationBar.kt#uh7d8r");
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
            i2 |= startRestartGroup.changedInstance(function24) ? 2048 : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            i2 |= startRestartGroup.changed(z) ? 16384 : Fields.Shape;
        }
        if ((196608 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 131072 : 65536;
        }
        if ((74899 & i2) != 74898 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1427075886, i2, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:505)");
            }
            startRestartGroup.startReplaceableGroup(-1250032035);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
            int i3 = 458752 & i2;
            int i4 = 57344 & i2;
            boolean z2 = (i3 == 131072) | ((i2 & 7168) == 2048) | (i4 == 16384);
            MeasurePolicy rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new MeasurePolicy() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$2$1
                    @Override // androidx.compose.p002ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo147measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        float f;
                        Measurable measurable;
                        Placeable placeable;
                        MeasureResult m2729placeLabelAndIconzUg2_y0;
                        MeasureResult m2728placeIconX9ElhV4;
                        float floatValue = ((Number) function0.invoke()).floatValue();
                        long j2 = Constraints.copy-Zbe2FdA$default(j, 0, 0, 0, 0, 10, (Object) null);
                        int size = list.size();
                        for (int i5 = 0; i5 < size; i5++) {
                            Measurable measurable2 = list.get(i5);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "icon")) {
                                Placeable mo6318measureBRTryo0 = measurable2.mo6318measureBRTryo0(j2);
                                int width = mo6318measureBRTryo0.getWidth();
                                f = NavigationBarKt.IndicatorHorizontalPadding;
                                float f2 = 2;
                                int i6 = width + measureScope.roundToPx-0680j_4(Dp.constructor-impl(f * f2));
                                int roundToInt = MathKt.roundToInt(i6 * floatValue);
                                int height = mo6318measureBRTryo0.getHeight() + measureScope.roundToPx-0680j_4(Dp.constructor-impl(NavigationBarKt.getIndicatorVerticalPadding() * f2));
                                int size2 = list.size();
                                for (int i7 = 0; i7 < size2; i7++) {
                                    Measurable measurable3 = list.get(i7);
                                    if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable3), "indicatorRipple")) {
                                        Placeable mo6318measureBRTryo02 = measurable3.mo6318measureBRTryo0(Constraints.Companion.fixed-JhjzzOo(i6, height));
                                        int size3 = list.size();
                                        int i8 = 0;
                                        while (true) {
                                            if (i8 >= size3) {
                                                measurable = null;
                                                break;
                                            }
                                            measurable = list.get(i8);
                                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "indicator")) {
                                                break;
                                            }
                                            i8++;
                                        }
                                        Measurable measurable4 = measurable;
                                        Placeable mo6318measureBRTryo03 = measurable4 != null ? measurable4.mo6318measureBRTryo0(Constraints.Companion.fixed-JhjzzOo(roundToInt, height)) : null;
                                        if (function24 != null) {
                                            int size4 = list.size();
                                            for (int i9 = 0; i9 < size4; i9++) {
                                                Measurable measurable5 = list.get(i9);
                                                if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable5), "label")) {
                                                    placeable = measurable5.mo6318measureBRTryo0(j2);
                                                }
                                            }
                                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                        }
                                        placeable = null;
                                        if (function24 == null) {
                                            m2728placeIconX9ElhV4 = NavigationBarKt.m2728placeIconX9ElhV4(measureScope, mo6318measureBRTryo0, mo6318measureBRTryo02, mo6318measureBRTryo03, j);
                                            return m2728placeIconX9ElhV4;
                                        }
                                        Intrinsics.checkNotNull(placeable);
                                        m2729placeLabelAndIconzUg2_y0 = NavigationBarKt.m2729placeLabelAndIconzUg2_y0(measureScope, placeable, mo6318measureBRTryo0, mo6318measureBRTryo02, mo6318measureBRTryo03, j, z, floatValue);
                                        return m2729placeLabelAndIconzUg2_y0;
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
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
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1836184647, "C507@22303L17,508@22329L11,510@22350L50:NavigationBar.kt#uh7d8r");
            function2.invoke(startRestartGroup, Integer.valueOf(i2 & 14));
            function22.invoke(startRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            Modifier layoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, IconLayoutIdTag);
            startRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(layoutId);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m4109constructorimpl2 = Updater.m4109constructorimpl(startRestartGroup);
            Updater.m4116setimpl(m4109constructorimpl2, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m4109constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m4109constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 610171585, "C510@22392L6:NavigationBar.kt#uh7d8r");
            function23.invoke(startRestartGroup, Integer.valueOf((i2 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-1250032367);
            ComposerKt.sourceInformation(startRestartGroup, "516@22556L60,513@22443L281");
            if (function24 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(Modifier.INSTANCE, LabelLayoutIdTag);
                startRestartGroup.startReplaceableGroup(1836184900);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):NavigationBar.kt#9igjgp");
                boolean z3 = (i4 == 16384) | (i3 == 131072);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (z3 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    obj = (Function1) new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$1$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            invoke((GraphicsLayerScope) obj2);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                            graphicsLayerScope.setAlpha(z ? 1.0f : ((Number) function0.invoke()).floatValue());
                        }
                    };
                    startRestartGroup.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue2;
                }
                startRestartGroup.endReplaceableGroup();
                Modifier m1066paddingVpY3zN4$default = PaddingKt.m1066paddingVpY3zN4$default(GraphicsLayerModifierKt.graphicsLayer(layoutId2, (Function1) obj), Dp.constructor-impl(NavigationBarItemHorizontalPadding / 2), 0.0f, 2, null);
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor3 = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(m1066paddingVpY3zN4$default);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m4109constructorimpl3 = Updater.m4109constructorimpl(startRestartGroup);
                Updater.m4116setimpl(m4109constructorimpl3, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl3, currentCompositionLocalMap3, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4109constructorimpl3.getInserting() || !Intrinsics.areEqual(m4109constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m4109constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m4109constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 610171908, "C518@22715L7:NavigationBar.kt#uh7d8r");
                function24.invoke(startRestartGroup, Integer.valueOf((i2 >> 9) & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$NavigationBarItemLayout$3
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
                    NavigationBarKt.NavigationBarItemLayout(function2, function22, function23, function24, z, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-X9ElhV4, reason: not valid java name */
    public static final MeasureResult m2728placeIconX9ElhV4(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, long j) {
        final int i = Constraints.getMaxWidth-impl(j);
        final int i2 = ConstraintsKt.constrainHeight-K40F9xA(j, measureScope.roundToPx-0680j_4(NavigationBarHeight));
        final int width = (i - placeable.getWidth()) / 2;
        final int height = (i2 - placeable.getHeight()) / 2;
        final int width2 = (i - placeable2.getWidth()) / 2;
        final int height2 = (i2 - placeable2.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, i, i2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeIcon$1
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
                Placeable placeable4 = Placeable.this;
                if (placeable4 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, (i - placeable4.getWidth()) / 2, (i2 - placeable4.getHeight()) / 2, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, height, 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, width2, height2, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-zUg2_y0, reason: not valid java name */
    public static final MeasureResult m2729placeLabelAndIconzUg2_y0(final MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, long j, final boolean z, final float f) {
        float height = placeable2.getHeight();
        float f2 = IndicatorVerticalPadding;
        float f3 = height + measureScope.toPx-0680j_4(f2);
        float f4 = NavigationBarIndicatorToLabelPadding;
        float f5 = f3 + measureScope.toPx-0680j_4(f4) + placeable.getHeight();
        float f6 = 2;
        final float coerceAtLeast = RangesKt.coerceAtLeast((Constraints.getMinHeight-impl(j) - f5) / f6, measureScope.toPx-0680j_4(f2));
        float f7 = f5 + (coerceAtLeast * f6);
        final float height2 = ((z ? coerceAtLeast : (f7 - placeable2.getHeight()) / f6) - coerceAtLeast) * (1 - f);
        final float height3 = placeable2.getHeight() + coerceAtLeast + measureScope.toPx-0680j_4(f2) + measureScope.toPx-0680j_4(f4);
        final int i = Constraints.getMaxWidth-impl(j);
        final int width = (i - placeable.getWidth()) / 2;
        final int width2 = (i - placeable2.getWidth()) / 2;
        final int width3 = (i - placeable3.getWidth()) / 2;
        final float f8 = coerceAtLeast - measureScope.toPx-0680j_4(f2);
        return MeasureScope.layout$default(measureScope, i, MathKt.roundToInt(f7), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.NavigationBarKt$placeLabelAndIcon$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x003d, code lost:
            
                if ((r3 == 0.0f) == false) goto L12;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable placeable5 = Placeable.this;
                if (placeable5 != null) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, (i - placeable5.getWidth()) / 2, MathKt.roundToInt((coerceAtLeast - measureScope.roundToPx-0680j_4(NavigationBarKt.getIndicatorVerticalPadding())) + height2), 0.0f, 4, null);
                }
                if (!z) {
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, MathKt.roundToInt(height3 + height2), 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, width2, MathKt.roundToInt(coerceAtLeast + height2), 0.0f, 4, null);
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, width3, MathKt.roundToInt(f8 + height2), 0.0f, 4, null);
            }
        }, 4, null);
    }

    static {
        float f = 2;
        IndicatorHorizontalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationBarTokens.INSTANCE.m3722getActiveIndicatorWidthD9Ej5fM() - NavigationBarTokens.INSTANCE.m3725getIconSizeD9Ej5fM()) / f);
        IndicatorVerticalPadding = Dp.constructor-impl(Dp.constructor-impl(NavigationBarTokens.INSTANCE.m3721getActiveIndicatorHeightD9Ej5fM() - NavigationBarTokens.INSTANCE.m3725getIconSizeD9Ej5fM()) / f);
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarItemHorizontalPadding;
    }

    public static final float getNavigationBarIndicatorToLabelPadding() {
        return NavigationBarIndicatorToLabelPadding;
    }

    public static final float getIndicatorVerticalPadding() {
        return IndicatorVerticalPadding;
    }
}
