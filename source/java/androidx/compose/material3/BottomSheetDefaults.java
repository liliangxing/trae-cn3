package androidx.compose.material3;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.Strings;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.material3.tokens.SheetBottomTokens;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: SheetDefaults.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u0017\u0010\u0003\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\u00048Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0016\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0017\u0010\nR\u0011\u0010\u0018\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/material3/BottomSheetDefaults;", "", "()V", "ContainerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ExpandedShape", "Landroidx/compose/ui/graphics/Shape;", "getExpandedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "HiddenShape", "getHiddenShape", "ScrimColor", "getScrimColor", "SheetMaxWidth", "getSheetMaxWidth-D9Ej5fM", "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "DragHandle", "", "modifier", "Landroidx/compose/ui/Modifier;", "width", "height", "shape", "color", "DragHandle-lgZ2HuY", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;JLandroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BottomSheetDefaults {
    public static final int $stable = 0;
    public static final BottomSheetDefaults INSTANCE = new BottomSheetDefaults();
    private static final float Elevation = SheetBottomTokens.INSTANCE.m3884getDockedModalContainerElevationD9Ej5fM();
    private static final float SheetPeekHeight = Dp.constructor-impl(56);
    private static final float SheetMaxWidth = Dp.constructor-impl(640);

    private BottomSheetDefaults() {
    }

    public final Shape getHiddenShape(Composer composer, int i) {
        composer.startReplaceableGroup(-1971658024);
        ComposerKt.sourceInformation(composer, "C348@13417L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1971658024, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-HiddenShape> (SheetDefaults.kt:348)");
        }
        Shape value = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedMinimizedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final Shape getExpandedShape(Composer composer, int i) {
        composer.startReplaceableGroup(1683783414);
        ComposerKt.sourceInformation(composer, "C353@13627L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1683783414, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ExpandedShape> (SheetDefaults.kt:353)");
        }
        Shape value = ShapesKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    public final long getContainerColor(Composer composer, int i) {
        composer.startReplaceableGroup(433375448);
        ComposerKt.sourceInformation(composer, "C358@13802L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(433375448, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ContainerColor> (SheetDefaults.kt:358)");
        }
        long value = ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    /* renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m2226getElevationD9Ej5fM() {
        return Elevation;
    }

    public final long getScrimColor(Composer composer, int i) {
        composer.startReplaceableGroup(-2040719176);
        ComposerKt.sourceInformation(composer, "C366@14098L5:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2040719176, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-ScrimColor> (SheetDefaults.kt:366)");
        }
        long m4838copywmQWz5c$default = Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(ScrimTokens.INSTANCE.getContainerColor(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m4838copywmQWz5c$default;
    }

    /* renamed from: getSheetPeekHeight-D9Ej5fM, reason: not valid java name */
    public final float m2228getSheetPeekHeightD9Ej5fM() {
        return SheetPeekHeight;
    }

    /* renamed from: getSheetMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m2227getSheetMaxWidthD9Ej5fM() {
        return SheetMaxWidth;
    }

    public final WindowInsets getWindowInsets(Composer composer, int i) {
        composer.startReplaceableGroup(-511309409);
        ComposerKt.sourceInformation(composer, "C383@14561L29:SheetDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-511309409, i, -1, "androidx.compose.material3.BottomSheetDefaults.<get-windowInsets> (SheetDefaults.kt:383)");
        }
        WindowInsets m1152onlybOOhFvg = WindowInsetsKt.m1152onlybOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.INSTANCE, composer, 6), WindowInsetsSides.INSTANCE.m1181getVerticalJoeWqyM());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m1152onlybOOhFvg;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0051  */
    /* renamed from: DragHandle-lgZ2HuY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2225DragHandlelgZ2HuY(Modifier modifier, float f, float f2, Shape shape, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final float f3;
        int i4;
        float f4;
        Shape shape2;
        long j2;
        final Modifier.Companion companion;
        float f5;
        boolean changed;
        Object rememberedValue;
        final Shape shape3;
        final float f6;
        final float f7;
        final long j3;
        ScopeUpdateScope endRestartGroup;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(-1364277227);
        ComposerKt.sourceInformation(startRestartGroup, "C(DragHandle)P(2,4:c#ui.unit.Dp,1:c#ui.unit.Dp,3,0:c#ui.graphics.Color)393@14974L6,394@15056L5,397@15168L51,401@15359L46,398@15228L437:SheetDefaults.kt#uh7d8r");
        int i7 = i2 & 1;
        if (i7 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            f3 = f;
            i3 |= startRestartGroup.changed(f3) ? 32 : 16;
            i4 = i2 & 4;
            if (i4 == 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                f4 = f2;
                i3 |= startRestartGroup.changed(f4) ? Fields.RotationX : Fields.SpotShadowColor;
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        shape2 = shape;
                        if (startRestartGroup.changed(shape2)) {
                            i6 = Fields.CameraDistance;
                            i3 |= i6;
                        }
                    } else {
                        shape2 = shape;
                    }
                    i6 = Fields.RotationZ;
                    i3 |= i6;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        j2 = j;
                        if (startRestartGroup.changed(j2)) {
                            i5 = Fields.Clip;
                            i3 |= i5;
                        }
                    } else {
                        j2 = j;
                    }
                    i5 = Fields.Shape;
                    i3 |= i5;
                } else {
                    j2 = j;
                }
                if ((i3 & 9363) == 9362 || !startRestartGroup.getSkipping()) {
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                        companion = i7 != 0 ? Modifier.INSTANCE : modifier2;
                        if (i8 != 0) {
                            f3 = SheetBottomTokens.INSTANCE.m3883getDockedDragHandleWidthD9Ej5fM();
                        }
                        if (i4 != 0) {
                            f4 = SheetBottomTokens.INSTANCE.m3882getDockedDragHandleHeightD9Ej5fM();
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shape2 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, 6).getExtraLarge();
                        }
                        if ((i2 & 16) != 0) {
                            j2 = Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(SheetBottomTokens.INSTANCE.getDockedDragHandleColor(), startRestartGroup, 6), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
                            i3 &= -57345;
                        }
                    } else {
                        startRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                        companion = modifier2;
                    }
                    int i9 = i3;
                    final float f8 = f4;
                    Shape shape4 = shape2;
                    long j4 = j2;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1364277227, i9, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle (SheetDefaults.kt:396)");
                    }
                    Strings.Companion companion2 = Strings.INSTANCE;
                    final String m3033getStringNWtq28 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_bottom_sheet_drag_handle_description), startRestartGroup, 0);
                    f5 = SheetDefaultsKt.DragHandleVerticalPadding;
                    Modifier m1066paddingVpY3zN4$default = PaddingKt.m1066paddingVpY3zN4$default(companion, 0.0f, f5, 1, null);
                    startRestartGroup.startReplaceableGroup(-363350248);
                    ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SheetDefaults.kt#9igjgp");
                    changed = startRestartGroup.changed(m3033getStringNWtq28);
                    rememberedValue = startRestartGroup.rememberedValue();
                    if (!changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$1$1
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
                                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m3033getStringNWtq28);
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    startRestartGroup.endReplaceableGroup();
                    int i10 = i9 >> 6;
                    SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(m1066paddingVpY3zN4$default, false, (Function1) rememberedValue, 1, (Object) null), shape4, j4, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1039573072, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11) {
                            ComposerKt.sourceInformation(composer2, "C405@15484L171:SheetDefaults.kt#uh7d8r");
                            if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1039573072, i11, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle.<anonymous> (SheetDefaults.kt:405)");
                                }
                                BoxKt.Box(SizeKt.m1122sizeVpY3zN4(Modifier.INSTANCE, f3, f8), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            composer2.skipToGroupEnd();
                        }
                    }), startRestartGroup, (i10 & 112) | 12582912 | (i10 & 896), 120);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape3 = shape4;
                    f6 = f8;
                    f7 = f3;
                    j3 = j4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                    f7 = f3;
                    f6 = f4;
                    shape3 = shape2;
                    j3 = j2;
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11) {
                            BottomSheetDefaults.this.m2225DragHandlelgZ2HuY(companion, f7, f6, shape3, j3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                    return;
                }
                return;
            }
            f4 = f2;
            if ((i & 3072) == 0) {
            }
            if ((i & 24576) == 0) {
            }
            if ((i3 & 9363) == 9362) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 != 0) {
            }
            if (i8 != 0) {
            }
            if (i4 != 0) {
            }
            if ((i2 & 8) != 0) {
            }
            if ((i2 & 16) != 0) {
            }
            int i92 = i3;
            final float f82 = f4;
            Shape shape42 = shape2;
            long j42 = j2;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            Strings.Companion companion22 = Strings.INSTANCE;
            final String m3033getStringNWtq282 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_bottom_sheet_drag_handle_description), startRestartGroup, 0);
            f5 = SheetDefaultsKt.DragHandleVerticalPadding;
            Modifier m1066paddingVpY3zN4$default2 = PaddingKt.m1066paddingVpY3zN4$default(companion, 0.0f, f5, 1, null);
            startRestartGroup.startReplaceableGroup(-363350248);
            ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SheetDefaults.kt#9igjgp");
            changed = startRestartGroup.changed(m3033getStringNWtq282);
            rememberedValue = startRestartGroup.rememberedValue();
            if (!changed) {
            }
            rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$1$1
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
                    SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m3033getStringNWtq282);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue);
            startRestartGroup.endReplaceableGroup();
            int i102 = i92 >> 6;
            SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(m1066paddingVpY3zN4$default2, false, (Function1) rememberedValue, 1, (Object) null), shape42, j42, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1039573072, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11) {
                    ComposerKt.sourceInformation(composer2, "C405@15484L171:SheetDefaults.kt#uh7d8r");
                    if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1039573072, i11, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle.<anonymous> (SheetDefaults.kt:405)");
                        }
                        BoxKt.Box(SizeKt.m1122sizeVpY3zN4(Modifier.INSTANCE, f3, f82), composer2, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }), startRestartGroup, (i102 & 112) | 12582912 | (i102 & 896), 120);
            if (ComposerKt.isTraceInProgress()) {
            }
            shape3 = shape42;
            f6 = f82;
            f7 = f3;
            j3 = j42;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        f3 = f;
        i4 = i2 & 4;
        if (i4 == 0) {
        }
        f4 = f2;
        if ((i & 3072) == 0) {
        }
        if ((i & 24576) == 0) {
        }
        if ((i3 & 9363) == 9362) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 != 0) {
        }
        if (i8 != 0) {
        }
        if (i4 != 0) {
        }
        if ((i2 & 8) != 0) {
        }
        if ((i2 & 16) != 0) {
        }
        int i922 = i3;
        final float f822 = f4;
        Shape shape422 = shape2;
        long j422 = j2;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        Strings.Companion companion222 = Strings.INSTANCE;
        final String m3033getStringNWtq2822 = Strings_androidKt.m3033getStringNWtq28(Strings.m2964constructorimpl(C0675R.string.m3c_bottom_sheet_drag_handle_description), startRestartGroup, 0);
        f5 = SheetDefaultsKt.DragHandleVerticalPadding;
        Modifier m1066paddingVpY3zN4$default22 = PaddingKt.m1066paddingVpY3zN4$default(companion, 0.0f, f5, 1, null);
        startRestartGroup.startReplaceableGroup(-363350248);
        ComposerKt.sourceInformation(startRestartGroup, "CC(remember):SheetDefaults.kt#9igjgp");
        changed = startRestartGroup.changed(m3033getStringNWtq2822);
        rememberedValue = startRestartGroup.rememberedValue();
        if (!changed) {
        }
        rememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$1$1
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
                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, m3033getStringNWtq2822);
            }
        };
        startRestartGroup.updateRememberedValue(rememberedValue);
        startRestartGroup.endReplaceableGroup();
        int i1022 = i922 >> 6;
        SurfaceKt.m3043SurfaceT9BRK9s(SemanticsModifierKt.semantics$default(m1066paddingVpY3zN4$default22, false, (Function1) rememberedValue, 1, (Object) null), shape422, j422, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.composableLambda(startRestartGroup, -1039573072, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetDefaults$DragHandle$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i11) {
                ComposerKt.sourceInformation(composer2, "C405@15484L171:SheetDefaults.kt#uh7d8r");
                if ((i11 & 3) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1039573072, i11, -1, "androidx.compose.material3.BottomSheetDefaults.DragHandle.<anonymous> (SheetDefaults.kt:405)");
                    }
                    BoxKt.Box(SizeKt.m1122sizeVpY3zN4(Modifier.INSTANCE, f3, f822), composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), startRestartGroup, (i1022 & 112) | 12582912 | (i1022 & 896), 120);
        if (ComposerKt.isTraceInProgress()) {
        }
        shape3 = shape422;
        f6 = f822;
        f7 = f3;
        j3 = j422;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
