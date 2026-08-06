package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.Shape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: TextFieldDefaults.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b)\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JP\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u009c\u0002\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020%2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00180'¢\u0006\u0002\b(2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010-\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u0010/\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00100\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\u0015\b\u0002\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0018\u0018\u00010'¢\u0006\u0002\b(2\b\b\u0002\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u00103\u001a\u0002042\u0013\b\u0002\u00105\u001a\r\u0012\u0004\u0012\u00020\u00180'¢\u0006\u0002\b(H\u0007¢\u0006\u0002\u00106J\r\u0010\u001e\u001a\u00020\u0013H\u0007¢\u0006\u0002\u00107JÂ\u0003\u0010\u001e\u001a\u00020\u00132\b\b\u0002\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u0002092\b\b\u0002\u0010;\u001a\u0002092\b\b\u0002\u0010<\u001a\u0002092\b\b\u0002\u0010=\u001a\u0002092\b\b\u0002\u0010>\u001a\u0002092\b\b\u0002\u0010?\u001a\u0002092\b\b\u0002\u0010@\u001a\u0002092\b\b\u0002\u0010A\u001a\u0002092\b\b\u0002\u0010B\u001a\u0002092\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010E\u001a\u0002092\b\b\u0002\u0010F\u001a\u0002092\b\b\u0002\u0010G\u001a\u0002092\b\b\u0002\u0010H\u001a\u0002092\b\b\u0002\u0010I\u001a\u0002092\b\b\u0002\u0010J\u001a\u0002092\b\b\u0002\u0010K\u001a\u0002092\b\b\u0002\u0010L\u001a\u0002092\b\b\u0002\u0010M\u001a\u0002092\b\b\u0002\u0010N\u001a\u0002092\b\b\u0002\u0010O\u001a\u0002092\b\b\u0002\u0010P\u001a\u0002092\b\b\u0002\u0010Q\u001a\u0002092\b\b\u0002\u0010R\u001a\u0002092\b\b\u0002\u0010S\u001a\u0002092\b\b\u0002\u0010T\u001a\u0002092\b\b\u0002\u0010U\u001a\u0002092\b\b\u0002\u0010V\u001a\u0002092\b\b\u0002\u0010W\u001a\u0002092\b\b\u0002\u0010X\u001a\u0002092\b\b\u0002\u0010Y\u001a\u0002092\b\b\u0002\u0010Z\u001a\u0002092\b\b\u0002\u0010[\u001a\u0002092\b\b\u0002\u0010\\\u001a\u0002092\b\b\u0002\u0010]\u001a\u0002092\b\b\u0002\u0010^\u001a\u0002092\b\b\u0002\u0010_\u001a\u0002092\b\b\u0002\u0010`\u001a\u0002092\b\b\u0002\u0010a\u001a\u0002092\b\b\u0002\u0010b\u001a\u0002092\b\b\u0002\u0010c\u001a\u0002092\b\b\u0002\u0010d\u001a\u000209H\u0007ø\u0001\u0000¢\u0006\u0004\be\u0010fJ8\u00103\u001a\u0002042\b\b\u0002\u0010g\u001a\u00020\u00042\b\b\u0002\u0010h\u001a\u00020\u00042\b\b\u0002\u0010i\u001a\u00020\u00042\b\b\u0002\u0010j\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\bk\u0010lR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u000f8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u00148AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006m"}, d2 = {"Landroidx/compose/material3/OutlinedTextFieldDefaults;", "", "()V", "FocusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "UnfocusedBorderThickness", "getUnfocusedBorderThickness-D9Ej5fM", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultOutlinedTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultOutlinedTextFieldColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "ContainerBox", "", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "focusedBorderThickness", "unfocusedBorderThickness", "ContainerBox-nbWgWpA", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "DecorationBox", "value", "", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "singleLine", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "prefix", "suffix", "supportingText", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "container", "(Ljava/lang/String;Lkotlin/jvm/functions/Function2;ZZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/interaction/InteractionSource;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "focusedTextColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextColor", "disabledTextColor", "errorTextColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "errorContainerColor", "cursorColor", "errorCursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "errorPlaceholderColor", "focusedSupportingTextColor", "unfocusedSupportingTextColor", "disabledSupportingTextColor", "errorSupportingTextColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "errorPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "errorSuffixColor", "colors-0hiis_0", "(JJJJJJJJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIIIIII)Landroidx/compose/material3/TextFieldColors;", "start", "top", "end", "bottom", "contentPadding-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/PaddingValues;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class OutlinedTextFieldDefaults {
    public static final int $stable = 0;
    public static final OutlinedTextFieldDefaults INSTANCE = new OutlinedTextFieldDefaults();
    private static final float MinHeight = Dp.constructor-impl(56);
    private static final float MinWidth = Dp.constructor-impl(280);
    private static final float UnfocusedBorderThickness = Dp.constructor-impl(1);
    private static final float FocusedBorderThickness = Dp.constructor-impl(2);

    private OutlinedTextFieldDefaults() {
    }

    public final Shape getShape(Composer composer, int i) {
        composer.startReplaceableGroup(-1066756961);
        ComposerKt.sourceInformation(composer, "C1409@77141L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1066756961, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:1409)");
        }
        Shape value = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return value;
    }

    /* renamed from: getMinHeight-D9Ej5fM */
    public final float m2774getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM */
    public final float m2775getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM */
    public final float m2776getUnfocusedBorderThicknessD9Ej5fM() {
        return UnfocusedBorderThickness;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM */
    public final float m2773getFocusedBorderThicknessD9Ej5fM() {
        return FocusedBorderThickness;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x012c, code lost:
    
        if ((r29 & 64) != 0) goto L243;
     */
    /* renamed from: ContainerBox-nbWgWpA */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m2770ContainerBoxnbWgWpA(final boolean z, final boolean z2, final InteractionSource interactionSource, final TextFieldColors textFieldColors, Shape shape, float f, float f2, Composer composer, final int i, final int i2) {
        int i3;
        Shape shape2;
        float f3;
        float f4;
        State m3188animateBorderStrokeAsStateNuRrP5Q;
        final Shape shape3;
        final float f5;
        final float f6;
        int i4;
        int i5;
        int i6;
        Composer startRestartGroup = composer.startRestartGroup(1461761386);
        ComposerKt.sourceInformation(startRestartGroup, "C(ContainerBox)P(1,4,3!1,5,2:c#ui.unit.Dp,6:c#ui.unit.Dp)1456@79023L5,1460@79190L203,1472@79535L51,1468@79402L216:TextFieldDefaults.kt#uh7d8r");
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
            i3 |= startRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= startRestartGroup.changed(interactionSource) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if ((i2 & 8) != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= startRestartGroup.changed(textFieldColors) ? Fields.CameraDistance : Fields.RotationZ;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (startRestartGroup.changed(shape2)) {
                    i6 = Fields.Clip;
                    i3 |= i6;
                }
            } else {
                shape2 = shape;
            }
            i6 = Fields.Shape;
            i3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                f3 = f;
                if (startRestartGroup.changed(f3)) {
                    i5 = Fields.RenderEffect;
                    i3 |= i5;
                }
            } else {
                f3 = f;
            }
            i5 = 65536;
            i3 |= i5;
        } else {
            f3 = f;
        }
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                f4 = f2;
                if (startRestartGroup.changed(f4)) {
                    i4 = 1048576;
                    i3 |= i4;
                }
            } else {
                f4 = f2;
            }
            i4 = Fields.BlendMode;
            i3 |= i4;
        } else {
            f4 = f2;
        }
        if ((i2 & Fields.SpotShadowColor) != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            i3 |= startRestartGroup.changed(this) ? 8388608 : 4194304;
        }
        if ((4793491 & i3) != 4793490 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startDefaults();
            if ((i & 1) == 0 || startRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 16) != 0) {
                    shape2 = ShapesKt.getValue(OutlinedTextFieldTokens.INSTANCE.getContainerShape(), startRestartGroup, 6);
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    f3 = FocusedBorderThickness;
                    i3 &= -458753;
                }
                if ((i2 & 64) != 0) {
                    f4 = UnfocusedBorderThickness;
                    i3 &= -3670017;
                }
                Shape shape4 = shape2;
                float f7 = f3;
                float f8 = f4;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1461761386, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.ContainerBox (TextFieldDefaults.kt:1459)");
                }
                int i7 = (i3 & 14) | (i3 & 112) | (i3 & 896) | (i3 & 7168);
                int i8 = i3 >> 3;
                m3188animateBorderStrokeAsStateNuRrP5Q = TextFieldDefaultsKt.m3188animateBorderStrokeAsStateNuRrP5Q(z, z2, interactionSource, textFieldColors, f7, f8, startRestartGroup, (57344 & i8) | i7 | (i8 & 458752));
                BoxKt.Box(BackgroundKt.m396backgroundbw27NRU(BorderKt.border(Modifier.INSTANCE, (BorderStroke) m3188animateBorderStrokeAsStateNuRrP5Q.getValue(), shape4), textFieldColors.containerColor$material3_release(z, z2, interactionSource, startRestartGroup, i7).getValue().m4849unboximpl(), shape4), startRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape3 = shape4;
                f5 = f7;
                f6 = f8;
            } else {
                startRestartGroup.skipToGroupEnd();
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
                if ((i2 & 32) != 0) {
                    i3 &= -458753;
                }
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            shape3 = shape2;
            f5 = f3;
            f6 = f4;
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$ContainerBox$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i9) {
                    OutlinedTextFieldDefaults.this.m2770ContainerBoxnbWgWpA(z, z2, interactionSource, textFieldColors, shape3, f5, f6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* renamed from: contentPadding-a9UjIt4$default */
    public static /* synthetic */ PaddingValues m2769contentPaddinga9UjIt4$default(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 2) != 0) {
            f2 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 4) != 0) {
            f3 = TextFieldImplKt.getTextFieldPadding();
        }
        if ((i & 8) != 0) {
            f4 = TextFieldImplKt.getTextFieldPadding();
        }
        return outlinedTextFieldDefaults.m2772contentPaddinga9UjIt4(f, f2, f3, f4);
    }

    /* renamed from: contentPadding-a9UjIt4 */
    public final PaddingValues m2772contentPaddinga9UjIt4(float start, float top, float end, float bottom) {
        return PaddingKt.m1060PaddingValuesa9UjIt4(start, top, end, bottom);
    }

    public final TextFieldColors colors(Composer composer, int i) {
        composer.startReplaceableGroup(-471651810);
        ComposerKt.sourceInformation(composer, "C(colors)1492@80238L11,1492@80250L30:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-471651810, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1492)");
        }
        TextFieldColors defaultOutlinedTextFieldColors = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i << 3) & 112);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultOutlinedTextFieldColors;
    }

    /* renamed from: colors-0hiis_0 */
    public final TextFieldColors m2771colors0hiis_0(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, TextSelectionColors textSelectionColors, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, Composer composer, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        composer.startReplaceableGroup(1767617725);
        ComposerKt.sourceInformation(composer, "C(colors)P(30:c#ui.graphics.Color,41:c#ui.graphics.Color,9:c#ui.graphics.Color,20:c#ui.graphics.Color,23:c#ui.graphics.Color,34:c#ui.graphics.Color,2:c#ui.graphics.Color,12:c#ui.graphics.Color,0:c#ui.graphics.Color,13:c#ui.graphics.Color,32,22:c#ui.graphics.Color,33:c#ui.graphics.Color,1:c#ui.graphics.Color,11:c#ui.graphics.Color,25:c#ui.graphics.Color,36:c#ui.graphics.Color,4:c#ui.graphics.Color,15:c#ui.graphics.Color,31:c#ui.graphics.Color,42:c#ui.graphics.Color,10:c#ui.graphics.Color,21:c#ui.graphics.Color,24:c#ui.graphics.Color,35:c#ui.graphics.Color,3:c#ui.graphics.Color,14:c#ui.graphics.Color,26:c#ui.graphics.Color,37:c#ui.graphics.Color,5:c#ui.graphics.Color,16:c#ui.graphics.Color,29:c#ui.graphics.Color,40:c#ui.graphics.Color,8:c#ui.graphics.Color,19:c#ui.graphics.Color,27:c#ui.graphics.Color,38:c#ui.graphics.Color,6:c#ui.graphics.Color,17:c#ui.graphics.Color,28:c#ui.graphics.Color,39:c#ui.graphics.Color,7:c#ui.graphics.Color,18:c#ui.graphics.Color)1593@87042L11,1593@87054L30:TextFieldDefaults.kt#uh7d8r");
        long m4875getUnspecified0d7_KjU = (i6 & 1) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j;
        long m4875getUnspecified0d7_KjU2 = (i6 & 2) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j2;
        long m4875getUnspecified0d7_KjU3 = (i6 & 4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j3;
        long m4875getUnspecified0d7_KjU4 = (i6 & 8) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j4;
        long m4875getUnspecified0d7_KjU5 = (i6 & 16) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j5;
        long m4875getUnspecified0d7_KjU6 = (i6 & 32) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j6;
        long m4875getUnspecified0d7_KjU7 = (i6 & 64) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j7;
        long m4875getUnspecified0d7_KjU8 = (i6 & Fields.SpotShadowColor) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j8;
        long m4875getUnspecified0d7_KjU9 = (i6 & Fields.RotationX) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j9;
        long m4875getUnspecified0d7_KjU10 = (i6 & Fields.RotationY) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j10;
        TextSelectionColors textSelectionColors2 = (i6 & Fields.RotationZ) != 0 ? null : textSelectionColors;
        long m4875getUnspecified0d7_KjU11 = (i6 & Fields.CameraDistance) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j11;
        long m4875getUnspecified0d7_KjU12 = (i6 & Fields.TransformOrigin) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j12;
        long m4875getUnspecified0d7_KjU13 = (i6 & Fields.Shape) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j13;
        long m4875getUnspecified0d7_KjU14 = (i6 & Fields.Clip) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j14;
        long m4875getUnspecified0d7_KjU15 = (32768 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j15;
        long m4875getUnspecified0d7_KjU16 = (65536 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j16;
        long m4875getUnspecified0d7_KjU17 = (131072 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j17;
        long m4875getUnspecified0d7_KjU18 = (262144 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j18;
        long m4875getUnspecified0d7_KjU19 = (524288 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j19;
        long m4875getUnspecified0d7_KjU20 = (1048576 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j20;
        long m4875getUnspecified0d7_KjU21 = (2097152 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j21;
        long m4875getUnspecified0d7_KjU22 = (4194304 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j22;
        long m4875getUnspecified0d7_KjU23 = (8388608 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j23;
        long m4875getUnspecified0d7_KjU24 = (16777216 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j24;
        long m4875getUnspecified0d7_KjU25 = (33554432 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j25;
        long m4875getUnspecified0d7_KjU26 = (67108864 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j26;
        long m4875getUnspecified0d7_KjU27 = (134217728 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j27;
        long m4875getUnspecified0d7_KjU28 = (268435456 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j28;
        long m4875getUnspecified0d7_KjU29 = (536870912 & i6) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j29;
        long m4875getUnspecified0d7_KjU30 = (i6 & 1073741824) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j30;
        long m4875getUnspecified0d7_KjU31 = (i7 & 1) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j31;
        long m4875getUnspecified0d7_KjU32 = (i7 & 2) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j32;
        long m4875getUnspecified0d7_KjU33 = (i7 & 4) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j33;
        long m4875getUnspecified0d7_KjU34 = (i7 & 8) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j34;
        long m4875getUnspecified0d7_KjU35 = (i7 & 16) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j35;
        long m4875getUnspecified0d7_KjU36 = (i7 & 32) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j36;
        long m4875getUnspecified0d7_KjU37 = (i7 & 64) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j37;
        long m4875getUnspecified0d7_KjU38 = (i7 & Fields.SpotShadowColor) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j38;
        long m4875getUnspecified0d7_KjU39 = (i7 & Fields.RotationX) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j39;
        long m4875getUnspecified0d7_KjU40 = (i7 & Fields.RotationY) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j40;
        long m4875getUnspecified0d7_KjU41 = (i7 & Fields.RotationZ) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j41;
        long m4875getUnspecified0d7_KjU42 = (i7 & Fields.CameraDistance) != 0 ? Color.INSTANCE.m4875getUnspecified0d7_KjU() : j42;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1767617725, i, i2, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1593)");
        }
        TextFieldColors m3115copyejIjP34 = getDefaultOutlinedTextFieldColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, (i5 >> 6) & 112).m3115copyejIjP34(m4875getUnspecified0d7_KjU, m4875getUnspecified0d7_KjU2, m4875getUnspecified0d7_KjU3, m4875getUnspecified0d7_KjU4, m4875getUnspecified0d7_KjU5, m4875getUnspecified0d7_KjU6, m4875getUnspecified0d7_KjU7, m4875getUnspecified0d7_KjU8, m4875getUnspecified0d7_KjU9, m4875getUnspecified0d7_KjU10, textSelectionColors2, m4875getUnspecified0d7_KjU11, m4875getUnspecified0d7_KjU12, m4875getUnspecified0d7_KjU13, m4875getUnspecified0d7_KjU14, m4875getUnspecified0d7_KjU15, m4875getUnspecified0d7_KjU16, m4875getUnspecified0d7_KjU17, m4875getUnspecified0d7_KjU18, m4875getUnspecified0d7_KjU19, m4875getUnspecified0d7_KjU20, m4875getUnspecified0d7_KjU21, m4875getUnspecified0d7_KjU22, m4875getUnspecified0d7_KjU23, m4875getUnspecified0d7_KjU24, m4875getUnspecified0d7_KjU25, m4875getUnspecified0d7_KjU26, m4875getUnspecified0d7_KjU27, m4875getUnspecified0d7_KjU28, m4875getUnspecified0d7_KjU29, m4875getUnspecified0d7_KjU30, m4875getUnspecified0d7_KjU31, m4875getUnspecified0d7_KjU32, m4875getUnspecified0d7_KjU33, m4875getUnspecified0d7_KjU34, m4875getUnspecified0d7_KjU35, m4875getUnspecified0d7_KjU36, m4875getUnspecified0d7_KjU37, m4875getUnspecified0d7_KjU38, m4875getUnspecified0d7_KjU39, m4875getUnspecified0d7_KjU40, m4875getUnspecified0d7_KjU41, m4875getUnspecified0d7_KjU42);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return m3115copyejIjP34;
    }

    public final TextFieldColors getDefaultOutlinedTextFieldColors(ColorScheme colorScheme, Composer composer, int i) {
        composer.startReplaceableGroup(-292363577);
        ComposerKt.sourceInformation(composer, "C*1654@90670L7,1688@93420L5:TextFieldDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-292363577, i, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1641)");
        }
        TextFieldColors defaultOutlinedTextFieldColorsCached = colorScheme.getDefaultOutlinedTextFieldColorsCached();
        if (defaultOutlinedTextFieldColorsCached == null) {
            long fromToken = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusInputColor());
            long fromToken2 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputColor());
            long m4838copywmQWz5c$default = Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            long fromToken3 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorInputColor());
            long m4874getTransparent0d7_KjU = Color.INSTANCE.m4874getTransparent0d7_KjU();
            long m4874getTransparent0d7_KjU2 = Color.INSTANCE.m4874getTransparent0d7_KjU();
            long m4874getTransparent0d7_KjU3 = Color.INSTANCE.m4874getTransparent0d7_KjU();
            long m4874getTransparent0d7_KjU4 = Color.INSTANCE.m4874getTransparent0d7_KjU();
            long fromToken4 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getCaretColor());
            long fromToken5 = ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorFocusCaretColor());
            ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = composer.consume(localTextSelectionColors);
            ComposerKt.sourceInformationMarkerEnd(composer);
            defaultOutlinedTextFieldColorsCached = new TextFieldColors(fromToken, fromToken2, m4838copywmQWz5c$default, fromToken3, m4874getTransparent0d7_KjU, m4874getTransparent0d7_KjU2, m4874getTransparent0d7_KjU3, m4874getTransparent0d7_KjU4, fromToken4, fromToken5, (TextSelectionColors) consume, ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getOutlineColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledOutlineColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorOutlineColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLeadingIconColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLeadingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLeadingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getTrailingIconColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledTrailingIconColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorTrailingIconColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusLabelColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getLabelColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledLabelColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorLabelColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getDisabledInputColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPlaceholderColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getFocusSupportingColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getSupportingColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedTextFieldTokens.INSTANCE.getDisabledSupportingColor(), composer, 6), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getErrorSupportingColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputPrefixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), Color.m4838copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedTextFieldTokens.INSTANCE.getInputSuffixColor()), null);
            colorScheme.setDefaultOutlinedTextFieldColorsCached$material3_release(defaultOutlinedTextFieldColorsCached);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultOutlinedTextFieldColorsCached;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x03d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void DecorationBox(final String str, final Function2<? super Composer, ? super Integer, Unit> function2, final boolean z, final boolean z2, final VisualTransformation visualTransformation, final InteractionSource interactionSource, boolean z3, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, Function2<? super Composer, ? super Integer, Unit> function25, Function2<? super Composer, ? super Integer, Unit> function26, Function2<? super Composer, ? super Integer, Unit> function27, Function2<? super Composer, ? super Integer, Unit> function28, TextFieldColors textFieldColors, PaddingValues paddingValues, Function2<? super Composer, ? super Integer, Unit> function29, Composer composer, final int i, final int i2, final int i3) {
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
        int i14;
        int i15;
        int i16;
        Function2<? super Composer, ? super Integer, Unit> function210;
        Function2<? super Composer, ? super Integer, Unit> function211;
        Function2<? super Composer, ? super Integer, Unit> function212;
        Function2<? super Composer, ? super Integer, Unit> function213;
        final TextFieldColors textFieldColors2;
        PaddingValues paddingValues2;
        boolean z4;
        Function2<? super Composer, ? super Integer, Unit> function214;
        Function2<? super Composer, ? super Integer, Unit> function215;
        Function2<? super Composer, ? super Integer, Unit> function216;
        Function2<? super Composer, ? super Integer, Unit> function217;
        int i17;
        boolean z5;
        PaddingValues paddingValues3;
        Function2<? super Composer, ? super Integer, Unit> function218;
        final Function2<? super Composer, ? super Integer, Unit> function219;
        final Function2<? super Composer, ? super Integer, Unit> function220;
        TextFieldColors textFieldColors3;
        final Function2<? super Composer, ? super Integer, Unit> function221;
        Function2<? super Composer, ? super Integer, Unit> function222;
        final Function2<? super Composer, ? super Integer, Unit> function223;
        final Function2<? super Composer, ? super Integer, Unit> function224;
        final Function2<? super Composer, ? super Integer, Unit> function225;
        final Function2<? super Composer, ? super Integer, Unit> function226;
        final boolean z6;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(-350442135);
        ComposerKt.sourceInformation(startRestartGroup, "C(DecorationBox)P(15,4,3,11,16,5,6,7,9,8,14,10,12,13!1,2)1778@99554L8,1789@99842L709:TextFieldDefaults.kt#uh7d8r");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 32 : 16;
            if ((i3 & 4) == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= startRestartGroup.changed(z) ? Fields.RotationX : 128;
            }
            i5 = i3 & 8;
            int i18 = Fields.CameraDistance;
            if (i5 == 0) {
                i4 |= 3072;
            } else if ((i & 3072) == 0) {
                i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                i6 = i3 & 16;
                int i19 = Fields.Shape;
                if (i6 != 0) {
                    i4 |= 24576;
                } else if ((i & 24576) == 0) {
                    i4 |= startRestartGroup.changed(visualTransformation) ? 16384 : 8192;
                    if ((i3 & 32) == 0) {
                        i4 |= 196608;
                    } else if ((i & 196608) == 0) {
                        i4 |= startRestartGroup.changed(interactionSource) ? 131072 : 65536;
                    }
                    i7 = i3 & 64;
                    if (i7 == 0) {
                        i4 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        i4 |= startRestartGroup.changed(z3) ? 1048576 : Fields.BlendMode;
                    }
                    i8 = i3 & Fields.SpotShadowColor;
                    if (i8 == 0) {
                        i4 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        i4 |= startRestartGroup.changedInstance(function22) ? 8388608 : 4194304;
                    }
                    i9 = i3 & Fields.RotationX;
                    if (i9 == 0) {
                        i4 |= 100663296;
                    } else if ((i & 100663296) == 0) {
                        i4 |= startRestartGroup.changedInstance(function23) ? 67108864 : 33554432;
                    }
                    i10 = i3 & Fields.RotationY;
                    if (i10 == 0) {
                        i4 |= 805306368;
                    } else if ((i & 805306368) == 0) {
                        i4 |= startRestartGroup.changedInstance(function24) ? 536870912 : 268435456;
                    }
                    i11 = i3 & Fields.RotationZ;
                    if (i11 == 0) {
                        i12 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        i12 = i2 | (startRestartGroup.changedInstance(function25) ? 4 : 2);
                    } else {
                        i12 = i2;
                    }
                    i13 = i3 & Fields.CameraDistance;
                    if (i13 == 0) {
                        i12 |= 48;
                    } else if ((i2 & 48) == 0) {
                        i12 |= startRestartGroup.changedInstance(function26) ? 32 : 16;
                    }
                    int i20 = i12;
                    i14 = i3 & Fields.TransformOrigin;
                    if (i14 == 0) {
                        i20 |= 384;
                    } else if ((i2 & 384) == 0) {
                        i20 |= startRestartGroup.changedInstance(function27) ? Fields.RotationX : 128;
                        i15 = i3 & Fields.Shape;
                        if (i15 != 0) {
                            i20 |= 3072;
                        } else if ((i2 & 3072) == 0) {
                            if (!startRestartGroup.changedInstance(function28)) {
                                i18 = 1024;
                            }
                            i20 |= i18;
                            if ((i2 & 24576) == 0) {
                                if ((i3 & Fields.Clip) == 0 && startRestartGroup.changed(textFieldColors)) {
                                    i19 = 16384;
                                }
                                i20 |= i19;
                            }
                            if ((i2 & 196608) == 0) {
                                i20 |= ((i3 & Fields.CompositingStrategy) == 0 && startRestartGroup.changed(paddingValues)) ? 131072 : 65536;
                            }
                            i16 = i3 & 65536;
                            if (i16 == 0) {
                                i20 |= 1572864;
                            } else if ((i2 & 1572864) == 0) {
                                i20 |= startRestartGroup.changedInstance(function29) ? 1048576 : Fields.BlendMode;
                            }
                            if ((i3 & Fields.RenderEffect) == 0) {
                                i20 |= 12582912;
                            } else if ((i2 & 12582912) == 0) {
                                i20 |= startRestartGroup.changed(this) ? 8388608 : 4194304;
                            }
                            if ((i4 & 306783379) == 306783378 || (4793491 & i20) != 4793490 || !startRestartGroup.getSkipping()) {
                                startRestartGroup.startDefaults();
                                if ((i & 1) != 0 || startRestartGroup.getDefaultsInvalid()) {
                                    final boolean z7 = i7 == 0 ? false : z3;
                                    function210 = i8 == 0 ? null : function22;
                                    function211 = i9 == 0 ? null : function23;
                                    Function2<? super Composer, ? super Integer, Unit> function227 = i10 == 0 ? null : function24;
                                    Function2<? super Composer, ? super Integer, Unit> function228 = i11 == 0 ? null : function25;
                                    Function2<? super Composer, ? super Integer, Unit> function229 = i13 == 0 ? null : function26;
                                    function212 = i14 == 0 ? null : function27;
                                    function213 = i15 == 0 ? function28 : null;
                                    if ((i3 & Fields.Clip) == 0) {
                                        textFieldColors2 = colors(startRestartGroup, (i20 >> 21) & 14);
                                        i20 &= -57345;
                                    } else {
                                        textFieldColors2 = textFieldColors;
                                    }
                                    if ((i3 & Fields.CompositingStrategy) == 0) {
                                        paddingValues2 = m2769contentPaddinga9UjIt4$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        i20 &= -458753;
                                    } else {
                                        paddingValues2 = paddingValues;
                                    }
                                    Function2<? super Composer, ? super Integer, Unit> function230 = function227;
                                    if (i16 == 0) {
                                        function214 = function229;
                                        Function2<? super Composer, ? super Integer, Unit> function231 = function228;
                                        z4 = z7;
                                        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(startRestartGroup, -1448570018, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$1
                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(2);
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i21) {
                                                ComposerKt.sourceInformation(composer2, "C1781@99680L135:TextFieldDefaults.kt#uh7d8r");
                                                if ((i21 & 3) != 2 || !composer2.getSkipping()) {
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-1448570018, i21, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox.<anonymous> (TextFieldDefaults.kt:1781)");
                                                    }
                                                    OutlinedTextFieldDefaults.INSTANCE.m2770ContainerBoxnbWgWpA(z, z7, interactionSource, textFieldColors2, null, 0.0f, 0.0f, composer2, 12582912, 112);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                        return;
                                                    }
                                                    return;
                                                }
                                                composer2.skipToGroupEnd();
                                            }
                                        });
                                        function215 = function230;
                                        function216 = function231;
                                        function217 = composableLambda;
                                    } else {
                                        Function2<? super Composer, ? super Integer, Unit> function232 = function228;
                                        z4 = z7;
                                        function214 = function229;
                                        function215 = function230;
                                        function216 = function232;
                                        function217 = function29;
                                    }
                                    i17 = i20;
                                    z5 = z4;
                                    paddingValues3 = paddingValues2;
                                    function218 = function214;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & Fields.Clip) != 0) {
                                        i20 &= -57345;
                                    }
                                    if ((32768 & i3) != 0) {
                                        i20 &= -458753;
                                    }
                                    z5 = z3;
                                    function210 = function22;
                                    function211 = function23;
                                    function215 = function24;
                                    function216 = function25;
                                    function212 = function27;
                                    function213 = function28;
                                    textFieldColors2 = textFieldColors;
                                    paddingValues3 = paddingValues;
                                    function217 = function29;
                                    i17 = i20;
                                    function218 = function26;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-350442135, i4, i17, "androidx.compose.material3.OutlinedTextFieldDefaults.DecorationBox (TextFieldDefaults.kt:1788)");
                                }
                                int i21 = i4 << 3;
                                int i22 = i4 >> 3;
                                int i23 = i4 >> 9;
                                int i24 = i17 << 21;
                                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function210, function211, function215, function216, function218, function212, function213, z2, z, z5, interactionSource, paddingValues3, textFieldColors2, function217, startRestartGroup, (i21 & 896) | (i21 & 112) | 6 | (i22 & 7168) | (i23 & 57344) | (i23 & 458752) | (i23 & 3670016) | (i24 & 29360128) | (i24 & 234881024) | (i24 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i23 & 7168) | (57344 & i22) | (458752 & i17) | ((i17 << 6) & 3670016) | ((i17 << 3) & 29360128), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function219 = function216;
                                function220 = function212;
                                textFieldColors3 = textFieldColors2;
                                function221 = function211;
                                function222 = function213;
                                function223 = function217;
                                function224 = function215;
                                function225 = function218;
                                function226 = function210;
                                z6 = z5;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                z6 = z3;
                                function226 = function22;
                                function221 = function23;
                                function224 = function24;
                                function219 = function25;
                                function225 = function26;
                                function220 = function27;
                                function222 = function28;
                                textFieldColors3 = textFieldColors;
                                paddingValues3 = paddingValues;
                                function223 = function29;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Function2<? super Composer, ? super Integer, Unit> function233 = function222;
                                final TextFieldColors textFieldColors4 = textFieldColors3;
                                final PaddingValues paddingValues4 = paddingValues3;
                                endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldDefaults$DecorationBox$2
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

                                    public final void invoke(Composer composer2, int i25) {
                                        OutlinedTextFieldDefaults.this.DecorationBox(str, function2, z, z2, visualTransformation, interactionSource, z6, function226, function221, function224, function219, function225, function220, function233, textFieldColors4, paddingValues4, function223, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
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
                        i16 = i3 & 65536;
                        if (i16 == 0) {
                        }
                        if ((i3 & Fields.RenderEffect) == 0) {
                        }
                        if ((i4 & 306783379) == 306783378) {
                        }
                        startRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                        }
                        if (i7 == 0) {
                        }
                        if (i8 == 0) {
                        }
                        if (i9 == 0) {
                        }
                        if (i10 == 0) {
                        }
                        if (i11 == 0) {
                        }
                        if (i13 == 0) {
                        }
                        if (i14 == 0) {
                        }
                        if (i15 == 0) {
                        }
                        if ((i3 & Fields.Clip) == 0) {
                        }
                        if ((i3 & Fields.CompositingStrategy) == 0) {
                        }
                        Function2<? super Composer, ? super Integer, Unit> function2302 = function227;
                        if (i16 == 0) {
                        }
                        i17 = i20;
                        z5 = z4;
                        paddingValues3 = paddingValues2;
                        function218 = function214;
                        startRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        int i212 = i4 << 3;
                        int i222 = i4 >> 3;
                        int i232 = i4 >> 9;
                        int i242 = i17 << 21;
                        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function210, function211, function215, function216, function218, function212, function213, z2, z, z5, interactionSource, paddingValues3, textFieldColors2, function217, startRestartGroup, (i212 & 896) | (i212 & 112) | 6 | (i222 & 7168) | (i232 & 57344) | (i232 & 458752) | (i232 & 3670016) | (i242 & 29360128) | (i242 & 234881024) | (i242 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i232 & 7168) | (57344 & i222) | (458752 & i17) | ((i17 << 6) & 3670016) | ((i17 << 3) & 29360128), 0);
                        if (ComposerKt.isTraceInProgress()) {
                        }
                        function219 = function216;
                        function220 = function212;
                        textFieldColors3 = textFieldColors2;
                        function221 = function211;
                        function222 = function213;
                        function223 = function217;
                        function224 = function215;
                        function225 = function218;
                        function226 = function210;
                        z6 = z5;
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i15 = i3 & Fields.Shape;
                    if (i15 != 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if ((i2 & 196608) == 0) {
                    }
                    i16 = i3 & 65536;
                    if (i16 == 0) {
                    }
                    if ((i3 & Fields.RenderEffect) == 0) {
                    }
                    if ((i4 & 306783379) == 306783378) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                    }
                    if (i7 == 0) {
                    }
                    if (i8 == 0) {
                    }
                    if (i9 == 0) {
                    }
                    if (i10 == 0) {
                    }
                    if (i11 == 0) {
                    }
                    if (i13 == 0) {
                    }
                    if (i14 == 0) {
                    }
                    if (i15 == 0) {
                    }
                    if ((i3 & Fields.Clip) == 0) {
                    }
                    if ((i3 & Fields.CompositingStrategy) == 0) {
                    }
                    Function2<? super Composer, ? super Integer, Unit> function23022 = function227;
                    if (i16 == 0) {
                    }
                    i17 = i20;
                    z5 = z4;
                    paddingValues3 = paddingValues2;
                    function218 = function214;
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    int i2122 = i4 << 3;
                    int i2222 = i4 >> 3;
                    int i2322 = i4 >> 9;
                    int i2422 = i17 << 21;
                    TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function210, function211, function215, function216, function218, function212, function213, z2, z, z5, interactionSource, paddingValues3, textFieldColors2, function217, startRestartGroup, (i2122 & 896) | (i2122 & 112) | 6 | (i2222 & 7168) | (i2322 & 57344) | (i2322 & 458752) | (i2322 & 3670016) | (i2422 & 29360128) | (i2422 & 234881024) | (i2422 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i2322 & 7168) | (57344 & i2222) | (458752 & i17) | ((i17 << 6) & 3670016) | ((i17 << 3) & 29360128), 0);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    function219 = function216;
                    function220 = function212;
                    textFieldColors3 = textFieldColors2;
                    function221 = function211;
                    function222 = function213;
                    function223 = function217;
                    function224 = function215;
                    function225 = function218;
                    function226 = function210;
                    z6 = z5;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                if ((i3 & 32) == 0) {
                }
                i7 = i3 & 64;
                if (i7 == 0) {
                }
                i8 = i3 & Fields.SpotShadowColor;
                if (i8 == 0) {
                }
                i9 = i3 & Fields.RotationX;
                if (i9 == 0) {
                }
                i10 = i3 & Fields.RotationY;
                if (i10 == 0) {
                }
                i11 = i3 & Fields.RotationZ;
                if (i11 == 0) {
                }
                i13 = i3 & Fields.CameraDistance;
                if (i13 == 0) {
                }
                int i202 = i12;
                i14 = i3 & Fields.TransformOrigin;
                if (i14 == 0) {
                }
                i15 = i3 & Fields.Shape;
                if (i15 != 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if ((i2 & 196608) == 0) {
                }
                i16 = i3 & 65536;
                if (i16 == 0) {
                }
                if ((i3 & Fields.RenderEffect) == 0) {
                }
                if ((i4 & 306783379) == 306783378) {
                }
                startRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                }
                if (i7 == 0) {
                }
                if (i8 == 0) {
                }
                if (i9 == 0) {
                }
                if (i10 == 0) {
                }
                if (i11 == 0) {
                }
                if (i13 == 0) {
                }
                if (i14 == 0) {
                }
                if (i15 == 0) {
                }
                if ((i3 & Fields.Clip) == 0) {
                }
                if ((i3 & Fields.CompositingStrategy) == 0) {
                }
                Function2<? super Composer, ? super Integer, Unit> function230222 = function227;
                if (i16 == 0) {
                }
                i17 = i202;
                z5 = z4;
                paddingValues3 = paddingValues2;
                function218 = function214;
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                int i21222 = i4 << 3;
                int i22222 = i4 >> 3;
                int i23222 = i4 >> 9;
                int i24222 = i17 << 21;
                TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function210, function211, function215, function216, function218, function212, function213, z2, z, z5, interactionSource, paddingValues3, textFieldColors2, function217, startRestartGroup, (i21222 & 896) | (i21222 & 112) | 6 | (i22222 & 7168) | (i23222 & 57344) | (i23222 & 458752) | (i23222 & 3670016) | (i24222 & 29360128) | (i24222 & 234881024) | (i24222 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i23222 & 7168) | (57344 & i22222) | (458752 & i17) | ((i17 << 6) & 3670016) | ((i17 << 3) & 29360128), 0);
                if (ComposerKt.isTraceInProgress()) {
                }
                function219 = function216;
                function220 = function212;
                textFieldColors3 = textFieldColors2;
                function221 = function211;
                function222 = function213;
                function223 = function217;
                function224 = function215;
                function225 = function218;
                function226 = function210;
                z6 = z5;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i6 = i3 & 16;
            int i192 = Fields.Shape;
            if (i6 != 0) {
            }
            if ((i3 & 32) == 0) {
            }
            i7 = i3 & 64;
            if (i7 == 0) {
            }
            i8 = i3 & Fields.SpotShadowColor;
            if (i8 == 0) {
            }
            i9 = i3 & Fields.RotationX;
            if (i9 == 0) {
            }
            i10 = i3 & Fields.RotationY;
            if (i10 == 0) {
            }
            i11 = i3 & Fields.RotationZ;
            if (i11 == 0) {
            }
            i13 = i3 & Fields.CameraDistance;
            if (i13 == 0) {
            }
            int i2022 = i12;
            i14 = i3 & Fields.TransformOrigin;
            if (i14 == 0) {
            }
            i15 = i3 & Fields.Shape;
            if (i15 != 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if ((i2 & 196608) == 0) {
            }
            i16 = i3 & 65536;
            if (i16 == 0) {
            }
            if ((i3 & Fields.RenderEffect) == 0) {
            }
            if ((i4 & 306783379) == 306783378) {
            }
            startRestartGroup.startDefaults();
            if ((i & 1) != 0) {
            }
            if (i7 == 0) {
            }
            if (i8 == 0) {
            }
            if (i9 == 0) {
            }
            if (i10 == 0) {
            }
            if (i11 == 0) {
            }
            if (i13 == 0) {
            }
            if (i14 == 0) {
            }
            if (i15 == 0) {
            }
            if ((i3 & Fields.Clip) == 0) {
            }
            if ((i3 & Fields.CompositingStrategy) == 0) {
            }
            Function2<? super Composer, ? super Integer, Unit> function2302222 = function227;
            if (i16 == 0) {
            }
            i17 = i2022;
            z5 = z4;
            paddingValues3 = paddingValues2;
            function218 = function214;
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            int i212222 = i4 << 3;
            int i222222 = i4 >> 3;
            int i232222 = i4 >> 9;
            int i242222 = i17 << 21;
            TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function210, function211, function215, function216, function218, function212, function213, z2, z, z5, interactionSource, paddingValues3, textFieldColors2, function217, startRestartGroup, (i212222 & 896) | (i212222 & 112) | 6 | (i222222 & 7168) | (i232222 & 57344) | (i232222 & 458752) | (i232222 & 3670016) | (i242222 & 29360128) | (i242222 & 234881024) | (i242222 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i232222 & 7168) | (57344 & i222222) | (458752 & i17) | ((i17 << 6) & 3670016) | ((i17 << 3) & 29360128), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            function219 = function216;
            function220 = function212;
            textFieldColors3 = textFieldColors2;
            function221 = function211;
            function222 = function213;
            function223 = function217;
            function224 = function215;
            function225 = function218;
            function226 = function210;
            z6 = z5;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        if ((i3 & 4) == 0) {
        }
        i5 = i3 & 8;
        int i182 = Fields.CameraDistance;
        if (i5 == 0) {
        }
        i6 = i3 & 16;
        int i1922 = Fields.Shape;
        if (i6 != 0) {
        }
        if ((i3 & 32) == 0) {
        }
        i7 = i3 & 64;
        if (i7 == 0) {
        }
        i8 = i3 & Fields.SpotShadowColor;
        if (i8 == 0) {
        }
        i9 = i3 & Fields.RotationX;
        if (i9 == 0) {
        }
        i10 = i3 & Fields.RotationY;
        if (i10 == 0) {
        }
        i11 = i3 & Fields.RotationZ;
        if (i11 == 0) {
        }
        i13 = i3 & Fields.CameraDistance;
        if (i13 == 0) {
        }
        int i20222 = i12;
        i14 = i3 & Fields.TransformOrigin;
        if (i14 == 0) {
        }
        i15 = i3 & Fields.Shape;
        if (i15 != 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if ((i2 & 196608) == 0) {
        }
        i16 = i3 & 65536;
        if (i16 == 0) {
        }
        if ((i3 & Fields.RenderEffect) == 0) {
        }
        if ((i4 & 306783379) == 306783378) {
        }
        startRestartGroup.startDefaults();
        if ((i & 1) != 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 == 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        if (i13 == 0) {
        }
        if (i14 == 0) {
        }
        if (i15 == 0) {
        }
        if ((i3 & Fields.Clip) == 0) {
        }
        if ((i3 & Fields.CompositingStrategy) == 0) {
        }
        Function2<? super Composer, ? super Integer, Unit> function23022222 = function227;
        if (i16 == 0) {
        }
        i17 = i20222;
        z5 = z4;
        paddingValues3 = paddingValues2;
        function218 = function214;
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        int i2122222 = i4 << 3;
        int i2222222 = i4 >> 3;
        int i2322222 = i4 >> 9;
        int i2422222 = i17 << 21;
        TextFieldImplKt.CommonDecorationBox(TextFieldType.Outlined, str, function2, visualTransformation, function210, function211, function215, function216, function218, function212, function213, z2, z, z5, interactionSource, paddingValues3, textFieldColors2, function217, startRestartGroup, (i2122222 & 896) | (i2122222 & 112) | 6 | (i2222222 & 7168) | (i2322222 & 57344) | (i2322222 & 458752) | (i2322222 & 3670016) | (i2422222 & 29360128) | (i2422222 & 234881024) | (i2422222 & 1879048192), (i4 & 896) | ((i17 >> 9) & 14) | ((i4 >> 6) & 112) | (i2322222 & 7168) | (57344 & i2222222) | (458752 & i17) | ((i17 << 6) & 3670016) | ((i17 << 3) & 29360128), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        function219 = function216;
        function220 = function212;
        textFieldColors3 = textFieldColors2;
        function221 = function211;
        function222 = function213;
        function223 = function217;
        function224 = function215;
        function225 = function218;
        function226 = function210;
        z6 = z5;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
