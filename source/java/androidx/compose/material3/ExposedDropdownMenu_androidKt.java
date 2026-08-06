package androidx.compose.material3;

import android.content.res.Configuration;
import android.view.View;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.material3.Strings;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.focus.FocusRequester;
import androidx.compose.p002ui.focus.FocusRequesterModifierKt;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.geometry.RectKt;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.RectHelper_androidKt;
import androidx.compose.p002ui.input.pointer.C0769xe3d9cdbd;
import androidx.compose.p002ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.layout.LayoutCoordinatesKt;
import androidx.compose.p002ui.layout.LayoutKt;
import androidx.compose.p002ui.layout.LayoutModifierKt;
import androidx.compose.p002ui.layout.Measurable;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.MeasureResult;
import androidx.compose.p002ui.layout.MeasureScope;
import androidx.compose.p002ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.p002ui.layout.Placeable;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: ExposedDropdownMenu.android.kt */
@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aQ\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\r¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0003¢\u0006\u0002\u0010\u0017\u001a\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002\u001a2\u0010\u001e\u001a\u00020\n*\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 H\u0002\u001a\u000e\u0010\"\u001a\u00020\u001b*\u0004\u0018\u00010#H\u0002\u001a\f\u0010$\u001a\u00020\u001b*\u00020\u0012H\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006%²\u0006\f\u0010&\u001a\u0004\u0018\u00010#X\u008a\u008e\u0002²\u0006\n\u0010'\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u0010(\u001a\u00020\u0019X\u008a\u008e\u0002"}, d2 = {"ExposedDropdownMenuItemHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ExposedDropdownMenuBox", "", "expanded", "", "onExpandedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/material3/ExposedDropdownMenuBoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "SoftKeyboardListener", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "Lkotlin/Function0;", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "calculateMaxHeight", "", "windowBounds", "Landroidx/compose/ui/geometry/Rect;", "anchorBounds", "verticalMargin", "expandable", "expandedDescription", "", "collapsedDescription", "getAnchorBounds", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getWindowBounds", "material3_release", "anchorCoordinates", "anchorWidth", "menuMaxHeight"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ExposedDropdownMenu_androidKt {
    private static final float ExposedDropdownMenuItemHorizontalPadding = Dp.constructor-impl(16);

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void ExposedDropdownMenuBox(final boolean z, final Function1<? super Boolean, Unit> function1, Modifier modifier, final Function3<? super ExposedDropdownMenuBoxScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final View view;
        Density density;
        final int i5;
        Object rememberedValue;
        MutableState mutableState;
        Object rememberedValue2;
        Object rememberedValue3;
        MutableIntState mutableIntState;
        Object rememberedValue4;
        final FocusRequester focusRequester;
        int i6;
        boolean changed;
        Object rememberedValue5;
        final MutableIntState mutableIntState2;
        final MutableState mutableState2;
        FocusRequester focusRequester2;
        String str;
        int i7;
        Density density2;
        View view2;
        int i8;
        int currentCompositeKeyHash;
        Composer m4109constructorimpl;
        boolean z2;
        Object rememberedValue6;
        final Modifier modifier3;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(2067579792);
        ComposerKt.sourceInformation(startRestartGroup, "C(ExposedDropdownMenuBox)P(1,3,2)116@5545L7,117@5578L7,118@5617L7,122@5730L53,123@5807L33,124@5866L33,126@5926L29,127@5986L31,128@6049L32,130@6099L1761,166@7866L45,180@8254L59,180@8243L70:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            modifier2 = modifier;
            i3 |= startRestartGroup.changed(modifier2) ? Fields.RotationX : Fields.SpotShadowColor;
            if ((i2 & 8) == 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                i3 |= startRestartGroup.changedInstance(function3) ? Fields.CameraDistance : Fields.RotationZ;
            }
            i4 = i3;
            if ((i4 & 1171) == 1170 || !startRestartGroup.getSkipping()) {
                Modifier modifier4 = i9 == 0 ? Modifier.INSTANCE : modifier2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2067579792, i4, -1, "androidx.compose.material3.ExposedDropdownMenuBox (ExposedDropdownMenu.android.kt:115)");
                }
                ProvidableCompositionLocal localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = startRestartGroup.consume(localConfiguration);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Configuration configuration = (Configuration) consume;
                ProvidableCompositionLocal localView = AndroidCompositionLocals_androidKt.getLocalView();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume2 = startRestartGroup.consume(localView);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                view = (View) consume2;
                ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume3 = startRestartGroup.consume(localDensity);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                density = (Density) consume3;
                i5 = density.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
                startRestartGroup.startReplaceableGroup(983580452);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue = startRestartGroup.rememberedValue();
                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                    rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                mutableState = (MutableState) rememberedValue;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(983580529);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = SnapshotIntStateKt.mutableIntStateOf(0);
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                final MutableIntState mutableIntState3 = (MutableIntState) rememberedValue2;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(983580588);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue3 = startRestartGroup.rememberedValue();
                if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = SnapshotIntStateKt.mutableIntStateOf(0);
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                mutableIntState = (MutableIntState) rememberedValue3;
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(983580648);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                rememberedValue4 = startRestartGroup.rememberedValue();
                if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue4 = new FocusRequester();
                    startRestartGroup.updateRememberedValue(rememberedValue4);
                }
                focusRequester = (FocusRequester) rememberedValue4;
                startRestartGroup.endReplaceableGroup();
                Strings.Companion companion = Strings.INSTANCE;
                final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_dropdown_menu_expanded), startRestartGroup, 0);
                Strings.Companion companion2 = Strings.INSTANCE;
                final String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_dropdown_menu_collapsed), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(983580821);
                ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
                int i10 = i4 & 14;
                boolean z3 = i10 != 4;
                i6 = i10;
                changed = startRestartGroup.changed(configuration) | ((i4 & 112) != 32) | z3 | startRestartGroup.changed(view) | startRestartGroup.changed(density);
                rememberedValue5 = startRestartGroup.rememberedValue();
                if (!changed || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    mutableIntState2 = mutableIntState;
                    mutableState2 = mutableState;
                    i6 = i6;
                    focusRequester2 = focusRequester;
                    str = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
                    i7 = i5;
                    density2 = density;
                    view2 = view;
                    i8 = i4;
                    ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        public Modifier menuAnchor(Modifier modifier5) {
                            Modifier expandable;
                            final View view3 = view;
                            final int i11 = i5;
                            final MutableState<LayoutCoordinates> mutableState3 = mutableState2;
                            final MutableIntState mutableIntState4 = mutableIntState3;
                            final MutableIntState mutableIntState5 = mutableIntState2;
                            Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier5, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((LayoutCoordinates) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LayoutCoordinates layoutCoordinates) {
                                    Rect windowBounds;
                                    LayoutCoordinates ExposedDropdownMenuBox$lambda$2;
                                    Rect anchorBounds;
                                    int calculateMaxHeight;
                                    mutableState3.setValue(layoutCoordinates);
                                    mutableIntState4.setIntValue(IntSize.getWidth-impl(layoutCoordinates.mo6339getSizeYbymL2g()));
                                    MutableIntState mutableIntState6 = mutableIntState5;
                                    windowBounds = ExposedDropdownMenu_androidKt.getWindowBounds(view3.getRootView());
                                    ExposedDropdownMenuBox$lambda$2 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(mutableState3);
                                    anchorBounds = ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenuBox$lambda$2);
                                    calculateMaxHeight = ExposedDropdownMenu_androidKt.calculateMaxHeight(windowBounds, anchorBounds, i11);
                                    mutableIntState6.setIntValue(calculateMaxHeight);
                                }
                            });
                            boolean z4 = z;
                            final Function1<Boolean, Unit> function12 = function1;
                            final boolean z5 = z;
                            expandable = ExposedDropdownMenu_androidKt.expandable(onGloballyPositioned, z4, new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m2571invoke();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: collision with other method in class */
                                public final void m2571invoke() {
                                    function12.invoke(Boolean.valueOf(!z5));
                                }
                            }, m3033getStringNWtq28, m3033getStringNWtq282);
                            return FocusRequesterModifierKt.focusRequester(expandable, focusRequester);
                        }

                        @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
                        public Modifier exposedDropdownSize(Modifier modifier5, final boolean z4) {
                            final MutableIntState mutableIntState4 = mutableIntState3;
                            final MutableIntState mutableIntState5 = mutableIntState2;
                            return LayoutModifierKt.layout(modifier5, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    return m2570invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
                                }

                                /* renamed from: invoke-3p2s80s, reason: not valid java name */
                                public final MeasureResult m2570invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                                    int ExposedDropdownMenuBox$lambda$5;
                                    int ExposedDropdownMenuBox$lambda$8;
                                    ExposedDropdownMenuBox$lambda$5 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$5(mutableIntState4);
                                    int i11 = ConstraintsKt.constrainWidth-K40F9xA(j, ExposedDropdownMenuBox$lambda$5);
                                    ExposedDropdownMenuBox$lambda$8 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$8(mutableIntState5);
                                    int i12 = ConstraintsKt.constrainHeight-K40F9xA(j, ExposedDropdownMenuBox$lambda$8);
                                    int i13 = z4 ? i11 : Constraints.getMinWidth-impl(j);
                                    if (!z4) {
                                        i11 = Constraints.getMaxWidth-impl(j);
                                    }
                                    final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j, i13, i11, 0, i12, 4, (Object) null));
                                    return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), mo6318measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1.1
                                        {
                                            super(1);
                                        }

                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            invoke((Placeable.PlacementScope) obj);
                                            return Unit.INSTANCE;
                                        }

                                        public final void invoke(Placeable.PlacementScope placementScope) {
                                            Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                                        }
                                    }, 4, null);
                                }
                            });
                        }
                    };
                    startRestartGroup.updateRememberedValue(exposedDropdownMenuBoxScope);
                    rememberedValue5 = exposedDropdownMenuBoxScope;
                } else {
                    mutableState2 = mutableState;
                    density2 = density;
                    view2 = view;
                    i8 = i4;
                    focusRequester2 = focusRequester;
                    mutableIntState2 = mutableIntState;
                    str = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
                    i7 = i5;
                }
                ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) rememberedValue5;
                startRestartGroup.endReplaceableGroup();
                int i11 = i8 >> 6;
                int i12 = i11 & 14;
                startRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                int i13 = i12 >> 3;
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, (i13 & 112) | (i13 & 14));
                startRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier4);
                int i14 = ((((i12 << 3) & 112) << 9) & 7168) | 6;
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (!startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
                Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                modifierMaterializerOf.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i14 >> 3) & 112));
                startRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1004943029, "C167@7896L9:ExposedDropdownMenu.android.kt#uh7d8r");
                function3.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1, startRestartGroup, Integer.valueOf(i11 & 112));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(983582639);
                ComposerKt.sourceInformation(startRestartGroup, "171@7977L254,171@7941L290");
                if (z) {
                    startRestartGroup.startReplaceableGroup(983582699);
                    ComposerKt.sourceInformation(startRestartGroup, str);
                    final View view3 = view2;
                    final int i15 = i7;
                    boolean changedInstance = startRestartGroup.changedInstance(view3) | startRestartGroup.changed(i15);
                    Object rememberedValue7 = startRestartGroup.rememberedValue();
                    if (changedInstance || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        final MutableIntState mutableIntState4 = mutableIntState2;
                        final MutableState mutableState3 = mutableState2;
                        rememberedValue7 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$2$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            public /* bridge */ /* synthetic */ Object invoke() {
                                m2568invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m2568invoke() {
                                Rect windowBounds;
                                LayoutCoordinates ExposedDropdownMenuBox$lambda$2;
                                Rect anchorBounds;
                                int calculateMaxHeight;
                                MutableIntState mutableIntState5 = mutableIntState4;
                                windowBounds = ExposedDropdownMenu_androidKt.getWindowBounds(view3.getRootView());
                                ExposedDropdownMenuBox$lambda$2 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(mutableState3);
                                anchorBounds = ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenuBox$lambda$2);
                                calculateMaxHeight = ExposedDropdownMenu_androidKt.calculateMaxHeight(windowBounds, anchorBounds, i15);
                                mutableIntState5.setIntValue(calculateMaxHeight);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue7);
                    }
                    startRestartGroup.endReplaceableGroup();
                    SoftKeyboardListener(view3, density2, (Function0) rememberedValue7, startRestartGroup, 0);
                }
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.startReplaceableGroup(983582976);
                ComposerKt.sourceInformation(startRestartGroup, str);
                z2 = i6 != 4;
                rememberedValue6 = startRestartGroup.rememberedValue();
                if (!z2 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    final FocusRequester focusRequester3 = focusRequester2;
                    rememberedValue6 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        public /* bridge */ /* synthetic */ Object invoke() {
                            m2569invoke();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: collision with other method in class */
                        public final void m2569invoke() {
                            if (z) {
                                focusRequester3.requestFocus();
                            }
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                startRestartGroup.endReplaceableGroup();
                EffectsKt.SideEffect((Function0) rememberedValue6, startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            } else {
                startRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$4
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
                        ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox(z, function1, modifier3, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
                return;
            }
            return;
        }
        modifier2 = modifier;
        if ((i2 & 8) == 0) {
        }
        i4 = i3;
        if ((i4 & 1171) == 1170) {
        }
        if (i9 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        ProvidableCompositionLocal localConfiguration2 = AndroidCompositionLocals_androidKt.getLocalConfiguration();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume4 = startRestartGroup.consume(localConfiguration2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        Configuration configuration2 = (Configuration) consume4;
        ProvidableCompositionLocal localView2 = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume22 = startRestartGroup.consume(localView2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        view = (View) consume22;
        ProvidableCompositionLocal localDensity2 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume32 = startRestartGroup.consume(localDensity2);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        density = (Density) consume32;
        i5 = density.roundToPx-0680j_4(MenuKt.getMenuVerticalMargin());
        startRestartGroup.startReplaceableGroup(983580452);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
        }
        mutableState = (MutableState) rememberedValue;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(983580529);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue2 = startRestartGroup.rememberedValue();
        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
        }
        final MutableIntState mutableIntState32 = (MutableIntState) rememberedValue2;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(983580588);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue3 = startRestartGroup.rememberedValue();
        if (rememberedValue3 == Composer.INSTANCE.getEmpty()) {
        }
        mutableIntState = (MutableIntState) rememberedValue3;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(983580648);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        rememberedValue4 = startRestartGroup.rememberedValue();
        if (rememberedValue4 == Composer.INSTANCE.getEmpty()) {
        }
        focusRequester = (FocusRequester) rememberedValue4;
        startRestartGroup.endReplaceableGroup();
        Strings.Companion companion3 = Strings.INSTANCE;
        final String m3033getStringNWtq283 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_dropdown_menu_expanded), startRestartGroup, 0);
        Strings.Companion companion22 = Strings.INSTANCE;
        final String m3033getStringNWtq2822 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_dropdown_menu_collapsed), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(983580821);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        int i102 = i4 & 14;
        if (i102 != 4) {
        }
        i6 = i102;
        if ((i4 & 112) != 32) {
        }
        changed = startRestartGroup.changed(configuration2) | ((i4 & 112) != 32) | z3 | startRestartGroup.changed(view) | startRestartGroup.changed(density);
        rememberedValue5 = startRestartGroup.rememberedValue();
        if (changed) {
        }
        mutableIntState2 = mutableIntState;
        mutableState2 = mutableState;
        i6 = i6;
        focusRequester2 = focusRequester;
        str = "CC(remember):ExposedDropdownMenu.android.kt#9igjgp";
        i7 = i5;
        density2 = density;
        view2 = view;
        i8 = i4;
        ExposedDropdownMenuBoxScope exposedDropdownMenuBoxScope2 = new ExposedDropdownMenuBoxScope() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1
            @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
            public Modifier menuAnchor(Modifier modifier5) {
                Modifier expandable;
                final View view32 = view;
                final int i112 = i5;
                final MutableState<LayoutCoordinates> mutableState32 = mutableState2;
                final MutableIntState mutableIntState42 = mutableIntState32;
                final MutableIntState mutableIntState5 = mutableIntState2;
                Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(modifier5, new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((LayoutCoordinates) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                        Rect windowBounds;
                        LayoutCoordinates ExposedDropdownMenuBox$lambda$2;
                        Rect anchorBounds;
                        int calculateMaxHeight;
                        mutableState32.setValue(layoutCoordinates);
                        mutableIntState42.setIntValue(IntSize.getWidth-impl(layoutCoordinates.mo6339getSizeYbymL2g()));
                        MutableIntState mutableIntState6 = mutableIntState5;
                        windowBounds = ExposedDropdownMenu_androidKt.getWindowBounds(view32.getRootView());
                        ExposedDropdownMenuBox$lambda$2 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$2(mutableState32);
                        anchorBounds = ExposedDropdownMenu_androidKt.getAnchorBounds(ExposedDropdownMenuBox$lambda$2);
                        calculateMaxHeight = ExposedDropdownMenu_androidKt.calculateMaxHeight(windowBounds, anchorBounds, i112);
                        mutableIntState6.setIntValue(calculateMaxHeight);
                    }
                });
                boolean z4 = z;
                final Function1<? super Boolean, Unit> function12 = function1;
                final boolean z5 = z;
                expandable = ExposedDropdownMenu_androidKt.expandable(onGloballyPositioned, z4, new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$menuAnchor$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    public /* bridge */ /* synthetic */ Object invoke() {
                        m2571invoke();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: collision with other method in class */
                    public final void m2571invoke() {
                        function12.invoke(Boolean.valueOf(!z5));
                    }
                }, m3033getStringNWtq283, m3033getStringNWtq2822);
                return FocusRequesterModifierKt.focusRequester(expandable, focusRequester);
            }

            @Override // androidx.compose.material3.ExposedDropdownMenuBoxScope
            public Modifier exposedDropdownSize(Modifier modifier5, final boolean z4) {
                final MutableIntState mutableIntState42 = mutableIntState32;
                final MutableIntState mutableIntState5 = mutableIntState2;
                return LayoutModifierKt.layout(modifier5, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return m2570invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).unbox-impl());
                    }

                    /* renamed from: invoke-3p2s80s, reason: not valid java name */
                    public final MeasureResult m2570invoke3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
                        int ExposedDropdownMenuBox$lambda$5;
                        int ExposedDropdownMenuBox$lambda$8;
                        ExposedDropdownMenuBox$lambda$5 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$5(mutableIntState42);
                        int i112 = ConstraintsKt.constrainWidth-K40F9xA(j, ExposedDropdownMenuBox$lambda$5);
                        ExposedDropdownMenuBox$lambda$8 = ExposedDropdownMenu_androidKt.ExposedDropdownMenuBox$lambda$8(mutableIntState5);
                        int i122 = ConstraintsKt.constrainHeight-K40F9xA(j, ExposedDropdownMenuBox$lambda$8);
                        int i132 = z4 ? i112 : Constraints.getMinWidth-impl(j);
                        if (!z4) {
                            i112 = Constraints.getMaxWidth-impl(j);
                        }
                        final Placeable mo6318measureBRTryo0 = measurable.mo6318measureBRTryo0(Constraints.copy-Zbe2FdA$default(j, i132, i112, 0, i122, 4, (Object) null));
                        return MeasureScope.layout$default(measureScope, mo6318measureBRTryo0.getWidth(), mo6318measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1$exposedDropdownSize$1.1
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Placeable.PlacementScope.place$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                });
            }
        };
        startRestartGroup.updateRememberedValue(exposedDropdownMenuBoxScope2);
        rememberedValue5 = exposedDropdownMenuBoxScope2;
        ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1 exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$12 = (ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$1) rememberedValue5;
        startRestartGroup.endReplaceableGroup();
        int i112 = i8 >> 6;
        int i122 = i112 & 14;
        startRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        int i132 = i122 >> 3;
        MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, startRestartGroup, (i132 & 112) | (i132 & 14));
        startRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(startRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifier4);
        int i142 = ((((i122 << 3) & 112) << 9) & 7168) | 6;
        if (!(startRestartGroup.getApplier() instanceof Applier)) {
        }
        startRestartGroup.startReusableNode();
        if (!startRestartGroup.getInserting()) {
        }
        m4109constructorimpl = Updater.m4109constructorimpl(startRestartGroup);
        Updater.m4116setimpl(m4109constructorimpl, rememberBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
        Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
        if (!m4109constructorimpl.getInserting()) {
        }
        m4109constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m4109constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash2);
        modifierMaterializerOf2.invoke(SkippableUpdater.m4078boximpl(SkippableUpdater.m4079constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i142 >> 3) & 112));
        startRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1004943029, "C167@7896L9:ExposedDropdownMenu.android.kt#uh7d8r");
        function3.invoke(exposedDropdownMenu_androidKt$ExposedDropdownMenuBox$scope$1$12, startRestartGroup, Integer.valueOf(i112 & 112));
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(983582639);
        ComposerKt.sourceInformation(startRestartGroup, "171@7977L254,171@7941L290");
        if (z) {
        }
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.startReplaceableGroup(983582976);
        ComposerKt.sourceInformation(startRestartGroup, str);
        if (i6 != 4) {
        }
        rememberedValue6 = startRestartGroup.rememberedValue();
        if (!z2) {
        }
        final FocusRequester focusRequester32 = focusRequester2;
        rememberedValue6 = (Function0) new Function0<Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$ExposedDropdownMenuBox$3$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m2569invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m2569invoke() {
                if (z) {
                    focusRequester32.requestFocus();
                }
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue6);
        startRestartGroup.endReplaceableGroup();
        EffectsKt.SideEffect((Function0) rememberedValue6, startRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        modifier3 = modifier4;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutCoordinates ExposedDropdownMenuBox$lambda$2(MutableState<LayoutCoordinates> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$5(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ExposedDropdownMenuBox$lambda$8(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SoftKeyboardListener(final View view, final Density density, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1319522472);
        ComposerKt.sourceInformation(startRestartGroup, "C(SoftKeyboardListener)P(2)193@8669L1413,193@8637L1445:ExposedDropdownMenu.android.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(view) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(density) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 256 : Fields.SpotShadowColor;
        }
        if ((i2 & 147) != 146 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1319522472, i2, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:190)");
            }
            startRestartGroup.startReplaceableGroup(-491766155);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(view) | ((i2 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                        final ViewOnAttachStateChangeListenerC0632xa756564b viewOnAttachStateChangeListenerC0632xa756564b = new ViewOnAttachStateChangeListenerC0632xa756564b(view, function0);
                        return new DisposableEffectResult() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$invoke$$inlined$onDispose$1
                            @Override // androidx.compose.runtime.DisposableEffectResult
                            public void dispose() {
                                ViewOnAttachStateChangeListenerC0632xa756564b.this.dispose();
                            }
                        };
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(view, density, (Function1) rememberedValue, startRestartGroup, (i2 & 14) | (i2 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$SoftKeyboardListener$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ExposedDropdownMenu_androidKt.SoftKeyboardListener(view, density, function0, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier expandable(Modifier modifier, final boolean z, final Function0<Unit> function0, final String str, final String str2) {
        Modifier then;
        then = modifier.then((Modifier) new SuspendPointerInputElement(function0, null, null, new C0769xe3d9cdbd(new ExposedDropdownMenu_androidKt$expandable$1(function0, null)), 6, null));
        return SemanticsModifierKt.semantics$default(then, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$2
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
                SemanticsPropertiesKt.setStateDescription(semanticsPropertyReceiver, z ? str : str2);
                SemanticsPropertiesKt.setRole-kuIjeqM(semanticsPropertyReceiver, Role.Companion.getDropdownList-o7Vup1c());
                final Function0<Unit> function02 = function0;
                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0<Boolean>() { // from class: androidx.compose.material3.ExposedDropdownMenu_androidKt$expandable$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                    public final Boolean m2572invoke() {
                        function02.invoke();
                        return true;
                    }
                }, 1, (Object) null);
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int calculateMaxHeight(Rect rect, Rect rect2, int i) {
        int roundToInt;
        if (rect2 == null) {
            return 0;
        }
        float f = i;
        float top = rect.getTop() + f;
        float bottom = rect.getBottom() - f;
        if (rect2.getTop() > rect.getBottom() || rect2.getBottom() < rect.getTop()) {
            roundToInt = MathKt.roundToInt(bottom - top);
        } else {
            roundToInt = MathKt.roundToInt(Math.max(rect2.getTop() - top, bottom - rect2.getBottom()));
        }
        return Math.max(roundToInt, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getWindowBounds(View view) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return RectHelper_androidKt.toComposeRect(rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect getAnchorBounds(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates == null ? Rect.INSTANCE.getZero() : RectKt.m4633Recttz77jQw(LayoutCoordinatesKt.positionInWindow(layoutCoordinates), IntSizeKt.toSize-ozmzZPI(layoutCoordinates.mo6339getSizeYbymL2g()));
    }
}
