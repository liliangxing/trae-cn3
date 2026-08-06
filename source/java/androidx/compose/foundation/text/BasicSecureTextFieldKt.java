package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.input.TextObfuscationMode_androidKt;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.autofill.ContentType;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.graphics.Brush;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.SolidColor;
import androidx.compose.p002ui.input.key.KeyEvent;
import androidx.compose.p002ui.input.key.KeyInputModifierKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BasicSecureTextField.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0004\b&\u0010'\u001a\u001a\u0010(\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\n2\b\u0010)\u001a\u0004\u0018\u00010\nH\u0002\u001a \u0010-\u001a\u00020\u00012\u0011\u0010.\u001a\r\u0012\u0004\u0012\u00020\u00010\u0014¢\u0006\u0002\b/H\u0003¢\u0006\u0002\u00100\u001aÇ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b1\u00102\u001aÑ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001028\b\u0002\u0010\u0011\u001a2\u0012\u0004\u0012\u00020\u0013\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0002\b\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0007¢\u0006\u0004\b3\u00104\"\u000e\u0010*\u001a\u00020+X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020#X\u0082T¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "", "scrollState", "Landroidx/compose/foundation/ScrollState;", "BasicSecureTextField-ltb6GB4", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "then", "next", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "DefaultObfuscationCharacter", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "BasicSecureTextField-egD4TGM", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BasicSecureTextFieldKt {
    private static final char DefaultObfuscationCharacter = 8226;
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicSecureTextField_Jb9bMDk$lambda$11(TextFieldState textFieldState, Modifier modifier, boolean z, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, int i2, int i3, int i4, Composer composer, int i5) {
        m1486BasicSecureTextFieldJb9bMDk(textFieldState, modifier, z, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, function2, mutableInteractionSource, brush, textFieldDecorator, i, c, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicSecureTextField_egD4TGM$lambda$12(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, int i2, int i3, int i4, Composer composer, int i5) {
        m1487BasicSecureTextFieldegD4TGM(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, function2, mutableInteractionSource, brush, textFieldDecorator, i, c, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicSecureTextField_ltb6GB4$lambda$8(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, ScrollState scrollState, int i2, int i3, int i4, Composer composer, int i5) {
        m1488BasicSecureTextFieldltb6GB4(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, function2, mutableInteractionSource, brush, textFieldDecorator, i, c, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DisableCutCopy$lambda$10(Function2 function2, int i, Composer composer, int i2) {
        DisableCutCopy(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f4  */
    /* renamed from: BasicSecureTextField-ltb6GB4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1488BasicSecureTextFieldltb6GB4(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, ScrollState scrollState, Composer composer, final int i2, final int i3, final int i4) {
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
        int i17;
        int i18;
        Modifier.Companion companion;
        final boolean z3;
        final boolean z4;
        final InputTransformation inputTransformation2;
        final TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        KeyboardActionHandler keyboardActionHandler2;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        MutableInteractionSource mutableInteractionSource2;
        Brush brush2;
        TextFieldDecorator textFieldDecorator2;
        int i19;
        char c2;
        ScrollState scrollState2;
        ScopeUpdateScope endRestartGroup;
        boolean z5;
        boolean z6;
        int i20;
        TextFieldDecorator textFieldDecorator3;
        char c3;
        InputTransformation inputTransformation3;
        MutableInteractionSource mutableInteractionSource3;
        Brush brush3;
        KeyboardActionHandler keyboardActionHandler3;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        TextStyle textStyle3;
        KeyboardOptions keyboardOptions3;
        Brush brush4;
        TextFieldDecorator textFieldDecorator4;
        boolean z7;
        CodepointTransformation codepointTransformation;
        Modifier.Companion companion2;
        int i21;
        Composer startRestartGroup = composer.startRestartGroup(1568790509);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicSecureTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter,scrollState)140@8345L46,141@8428L60,142@8535L130,142@8493L172,155@9098L129,155@9059L168,162@9271L424,176@9771L38,177@9841L288,191@10367L891,191@10352L906:BasicSecureTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(textFieldState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i22 = i4 & 2;
        if (i22 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 384) == 0) {
                i5 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                int i23 = Fields.CameraDistance;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                    i8 = i4 & 16;
                    int i24 = Fields.Shape;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i5 |= startRestartGroup.changed(inputTransformation) ? 16384 : 8192;
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= 196608;
                        } else if ((i2 & 196608) == 0) {
                            i5 |= startRestartGroup.changed(textStyle) ? Fields.RenderEffect : 65536;
                        }
                        i10 = i4 & 64;
                        if (i10 != 0) {
                            i5 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(keyboardOptions) ? 1048576 : Fields.BlendMode;
                        }
                        i11 = i4 & Fields.SpotShadowColor;
                        if (i11 != 0) {
                            i5 |= 12582912;
                        } else if ((i2 & 12582912) == 0) {
                            i5 |= startRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                        }
                        i12 = i4 & Fields.RotationX;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                        }
                        i13 = i4 & Fields.RotationY;
                        if (i13 != 0) {
                            i5 |= 805306368;
                        } else if ((i2 & 805306368) == 0) {
                            i5 |= startRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                        }
                        i14 = i4 & Fields.RotationZ;
                        if (i14 != 0) {
                            i15 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i15 = i3 | (startRestartGroup.changed(brush) ? 4 : 2);
                        } else {
                            i15 = i3;
                        }
                        i16 = i4 & Fields.CameraDistance;
                        if (i16 != 0) {
                            i15 |= 48;
                        } else if ((i3 & 48) == 0) {
                            i15 |= (i3 & 64) == 0 ? startRestartGroup.changed(textFieldDecorator) : startRestartGroup.changedInstance(textFieldDecorator) ? 32 : 16;
                        }
                        if ((i3 & 384) == 0) {
                            if ((i4 & Fields.TransformOrigin) == 0 && startRestartGroup.changed(i)) {
                                i21 = Fields.RotationX;
                                i15 |= i21;
                            }
                            i21 = Fields.SpotShadowColor;
                            i15 |= i21;
                        }
                        i17 = i15;
                        i18 = i4 & Fields.Shape;
                        if (i18 != 0) {
                            i17 |= 3072;
                        } else if ((i3 & 3072) == 0) {
                            if (!startRestartGroup.changed(c)) {
                                i23 = 1024;
                            }
                            i17 |= i23;
                            if ((i3 & 24576) == 0) {
                                if ((i4 & Fields.Clip) == 0 && startRestartGroup.changed(scrollState)) {
                                    i24 = 16384;
                                }
                                i17 |= i24;
                            }
                            if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "138@8287L21");
                                if ((i2 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i4 & Fields.TransformOrigin) != 0) {
                                        i17 &= -897;
                                    }
                                    if ((i4 & Fields.Clip) != 0) {
                                        i17 &= -57345;
                                    }
                                    companion = modifier;
                                    z5 = z;
                                    z6 = z2;
                                    textStyle3 = textStyle;
                                    keyboardOptions3 = keyboardOptions;
                                    keyboardActionHandler3 = keyboardActionHandler;
                                    function23 = function2;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    brush3 = brush;
                                    textFieldDecorator3 = textFieldDecorator;
                                    i19 = i;
                                    c3 = c;
                                    scrollState2 = scrollState;
                                    i20 = i17;
                                    inputTransformation3 = inputTransformation;
                                } else {
                                    companion = i22 != 0 ? Modifier.INSTANCE : modifier;
                                    z5 = i6 != 0 ? true : z;
                                    z6 = i7 != 0 ? false : z2;
                                    InputTransformation inputTransformation4 = i8 != 0 ? null : inputTransformation;
                                    TextStyle textStyle4 = i9 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                    KeyboardOptions secureTextField$foundation_release = i10 != 0 ? KeyboardOptions.INSTANCE.getSecureTextField$foundation_release() : keyboardOptions;
                                    KeyboardActionHandler keyboardActionHandler4 = i11 != 0 ? null : keyboardActionHandler;
                                    Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = i12 != 0 ? null : function2;
                                    MutableInteractionSource mutableInteractionSource4 = i13 != 0 ? null : mutableInteractionSource;
                                    SolidColor solidColor = i14 != 0 ? new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null) : brush;
                                    TextFieldDecorator textFieldDecorator5 = i16 != 0 ? null : textFieldDecorator;
                                    if ((i4 & Fields.TransformOrigin) != 0) {
                                        i19 = TextObfuscationMode_androidKt.getDefault(TextObfuscationMode.INSTANCE);
                                        i17 &= -897;
                                    } else {
                                        i19 = i;
                                    }
                                    char c4 = i18 != 0 ? DefaultObfuscationCharacter : c;
                                    if ((i4 & Fields.Clip) != 0) {
                                        i20 = i17 & (-57345);
                                        textFieldDecorator3 = textFieldDecorator5;
                                        c3 = c4;
                                        inputTransformation3 = inputTransformation4;
                                        scrollState2 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                    } else {
                                        scrollState2 = scrollState;
                                        i20 = i17;
                                        textFieldDecorator3 = textFieldDecorator5;
                                        c3 = c4;
                                        inputTransformation3 = inputTransformation4;
                                    }
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    brush3 = solidColor;
                                    keyboardActionHandler3 = keyboardActionHandler4;
                                    function23 = function24;
                                    textStyle3 = textStyle4;
                                    keyboardOptions3 = secureTextField$foundation_release;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    textFieldDecorator4 = textFieldDecorator3;
                                    brush4 = brush3;
                                    ComposerKt.traceEventStart(1568790509, i5, i20, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:139)");
                                } else {
                                    brush4 = brush3;
                                    textFieldDecorator4 = textFieldDecorator3;
                                }
                                final State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Character.valueOf(c3), startRestartGroup, (i20 >> 9) & 14);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74193289, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                char c5 = c3;
                                if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = new SecureTextFieldController(rememberUpdatedState);
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                final SecureTextFieldController secureTextFieldController = (SecureTextFieldController) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74196783, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                boolean changedInstance = startRestartGroup.changedInstance(secureTextFieldController);
                                final MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                BasicSecureTextFieldKt$BasicSecureTextField$1$1 rememberedValue2 = startRestartGroup.rememberedValue();
                                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = new BasicSecureTextFieldKt$BasicSecureTextField$1$1(secureTextFieldController, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                EffectsKt.LaunchedEffect(secureTextFieldController, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 0);
                                if (TextObfuscationMode.m1756equalsimpl0(i19, TextObfuscationMode.INSTANCE.m1761getRevealLastTypedvTwcZD0())) {
                                    startRestartGroup.startReplaceGroup(74209068);
                                    ComposerKt.sourceInformation(startRestartGroup, "152@8922L31");
                                    z7 = BasicSecureTextField_androidKt.platformAllowsRevealLastTyped(startRestartGroup, 0);
                                    startRestartGroup.endReplaceGroup();
                                } else {
                                    startRestartGroup.startReplaceGroup(-1994484951);
                                    startRestartGroup.endReplaceGroup();
                                    z7 = false;
                                }
                                Boolean valueOf = Boolean.valueOf(z7);
                                final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function25 = function23;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74214798, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                boolean changed = startRestartGroup.changed(z7) | startRestartGroup.changedInstance(secureTextFieldController);
                                final KeyboardActionHandler keyboardActionHandler5 = keyboardActionHandler3;
                                BasicSecureTextFieldKt$BasicSecureTextField$2$1 rememberedValue3 = startRestartGroup.rememberedValue();
                                if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = new BasicSecureTextFieldKt$BasicSecureTextField$2$1(z7, secureTextFieldController, null);
                                    startRestartGroup.updateRememberedValue(rememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                EffectsKt.LaunchedEffect(valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue3, startRestartGroup, 0);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74220629, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                boolean z8 = (((i20 & 896) ^ 384) > 256 && startRestartGroup.changed(i19)) || (i20 & 384) == 256;
                                Object rememberedValue4 = startRestartGroup.rememberedValue();
                                if (z8 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                    if (TextObfuscationMode.m1756equalsimpl0(i19, TextObfuscationMode.INSTANCE.m1761getRevealLastTypedvTwcZD0())) {
                                        codepointTransformation = secureTextFieldController.getCodepointTransformation();
                                    } else {
                                        codepointTransformation = TextObfuscationMode.m1756equalsimpl0(i19, TextObfuscationMode.INSTANCE.m1760getHiddenvTwcZD0()) ? new CodepointTransformation() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda1
                                            @Override // androidx.compose.foundation.text.input.internal.CodepointTransformation
                                            public final int transform(int i25, int i26) {
                                                int BasicSecureTextField_ltb6GB4$lambda$4$lambda$3;
                                                BasicSecureTextField_ltb6GB4$lambda$4$lambda$3 = BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$4$lambda$3(State.this, i25, i26);
                                                return BasicSecureTextField_ltb6GB4$lambda$4$lambda$3;
                                            }
                                        } : null;
                                    }
                                    startRestartGroup.updateRememberedValue(codepointTransformation);
                                    rememberedValue4 = codepointTransformation;
                                }
                                final CodepointTransformation codepointTransformation2 = (CodepointTransformation) rememberedValue4;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74236243, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                Object rememberedValue5 = startRestartGroup.rememberedValue();
                                if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda2
                                        public final Object invoke(Object obj) {
                                            Unit BasicSecureTextField_ltb6GB4$lambda$6$lambda$5;
                                            BasicSecureTextField_ltb6GB4$lambda$6$lambda$5 = BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$6$lambda$5((SemanticsPropertyReceiver) obj);
                                            return BasicSecureTextField_ltb6GB4$lambda$6$lambda$5;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue5);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Modifier semantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue5, 1, (Object) null);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 74238733, "CC(remember):BasicSecureTextField.kt#9igjgp");
                                C0374xa6999c3f rememberedValue6 = startRestartGroup.rememberedValue();
                                if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue6 = new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$secureTextFieldModifier$2$1
                                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                            return m1489invokeZmokQxo(((KeyEvent) obj).m5979unboximpl());
                                        }

                                        /* renamed from: invoke-ZmokQxo, reason: not valid java name */
                                        public final Boolean m1489invokeZmokQxo(android.view.KeyEvent keyEvent) {
                                            KeyCommand mo1542mapZmokQxo = KeyMapping_androidKt.getPlatformDefaultKeyMapping().mo1542mapZmokQxo(keyEvent);
                                            return Boolean.valueOf(mo1542mapZmokQxo == KeyCommand.COPY || mo1542mapZmokQxo == KeyCommand.CUT);
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue6);
                                }
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Modifier onPreviewKeyEvent = KeyInputModifierKt.onPreviewKeyEvent(semantics$default, (Function1) rememberedValue6);
                                if (z7) {
                                    companion2 = secureTextFieldController.getFocusChangeModifier();
                                } else {
                                    companion2 = Modifier.INSTANCE;
                                }
                                final Modifier then = onPreviewKeyEvent.then(companion2);
                                final boolean z9 = z7;
                                final InputTransformation inputTransformation5 = inputTransformation3;
                                final boolean z10 = z5;
                                final boolean z11 = z6;
                                final TextStyle textStyle5 = textStyle3;
                                final KeyboardOptions keyboardOptions4 = keyboardOptions3;
                                final Brush brush5 = brush4;
                                final TextFieldDecorator textFieldDecorator6 = textFieldDecorator4;
                                final ScrollState scrollState3 = scrollState2;
                                DisableCutCopy(ComposableLambdaKt.rememberComposableLambda(135148049, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$BasicSecureTextField$3
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i25) {
                                        InputTransformation inputTransformation6;
                                        ComposerKt.sourceInformation(composer2, "C192@10377L875:BasicSecureTextField.kt#423gt5");
                                        if (!composer2.shouldExecute((i25 & 3) != 2, i25 & 1)) {
                                            composer2.skipToGroupEnd();
                                            return;
                                        }
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(135148049, i25, -1, "androidx.compose.foundation.text.BasicSecureTextField.<anonymous> (BasicSecureTextField.kt:192)");
                                        }
                                        if (z9) {
                                            inputTransformation6 = BasicSecureTextFieldKt.then(inputTransformation5, secureTextFieldController.getPasswordInputTransformation());
                                        } else {
                                            inputTransformation6 = inputTransformation5;
                                        }
                                        BasicTextFieldKt.BasicTextField(textFieldState, then, z10, z11, inputTransformation6, textStyle5, keyboardOptions4, keyboardActionHandler5, TextFieldLineLimits.SingleLine.INSTANCE, function25, mutableInteractionSource5, brush5, codepointTransformation2, null, textFieldDecorator6, scrollState3, true, composer2, 100663296, 1572864, Fields.Shape);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                    }
                                }, startRestartGroup, 54), startRestartGroup, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                textFieldDecorator2 = textFieldDecorator4;
                                brush2 = brush4;
                                c2 = c5;
                                keyboardActionHandler2 = keyboardActionHandler5;
                                inputTransformation2 = inputTransformation3;
                                textStyle2 = textStyle3;
                                keyboardOptions2 = keyboardOptions3;
                                z3 = z5;
                                z4 = z6;
                                mutableInteractionSource2 = mutableInteractionSource5;
                                function22 = function25;
                            } else {
                                startRestartGroup.skipToGroupEnd();
                                companion = modifier;
                                z3 = z;
                                z4 = z2;
                                inputTransformation2 = inputTransformation;
                                textStyle2 = textStyle;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActionHandler2 = keyboardActionHandler;
                                function22 = function2;
                                mutableInteractionSource2 = mutableInteractionSource;
                                brush2 = brush;
                                textFieldDecorator2 = textFieldDecorator;
                                i19 = i;
                                c2 = c;
                                scrollState2 = scrollState;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier2 = companion;
                                final KeyboardOptions keyboardOptions5 = keyboardOptions2;
                                final KeyboardActionHandler keyboardActionHandler6 = keyboardActionHandler2;
                                final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function26 = function22;
                                final MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource2;
                                final Brush brush6 = brush2;
                                final TextFieldDecorator textFieldDecorator7 = textFieldDecorator2;
                                final int i25 = i19;
                                final char c6 = c2;
                                final ScrollState scrollState4 = scrollState2;
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda3
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicSecureTextField_ltb6GB4$lambda$8;
                                        BasicSecureTextField_ltb6GB4$lambda$8 = BasicSecureTextFieldKt.BasicSecureTextField_ltb6GB4$lambda$8(TextFieldState.this, modifier2, z3, z4, inputTransformation2, textStyle2, keyboardOptions5, keyboardActionHandler6, function26, mutableInteractionSource6, brush6, textFieldDecorator7, i25, c6, scrollState4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicSecureTextField_ltb6GB4$lambda$8;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if ((i3 & 24576) == 0) {
                        }
                        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 != 0) {
                    }
                    i11 = i4 & Fields.SpotShadowColor;
                    if (i11 != 0) {
                    }
                    i12 = i4 & Fields.RotationX;
                    if (i12 != 0) {
                    }
                    i13 = i4 & Fields.RotationY;
                    if (i13 != 0) {
                    }
                    i14 = i4 & Fields.RotationZ;
                    if (i14 != 0) {
                    }
                    i16 = i4 & Fields.CameraDistance;
                    if (i16 != 0) {
                    }
                    if ((i3 & 384) == 0) {
                    }
                    i17 = i15;
                    i18 = i4 & Fields.Shape;
                    if (i18 != 0) {
                    }
                    if ((i3 & 24576) == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                int i242 = Fields.Shape;
                if (i8 == 0) {
                }
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                }
                i11 = i4 & Fields.SpotShadowColor;
                if (i11 != 0) {
                }
                i12 = i4 & Fields.RotationX;
                if (i12 != 0) {
                }
                i13 = i4 & Fields.RotationY;
                if (i13 != 0) {
                }
                i14 = i4 & Fields.RotationZ;
                if (i14 != 0) {
                }
                i16 = i4 & Fields.CameraDistance;
                if (i16 != 0) {
                }
                if ((i3 & 384) == 0) {
                }
                i17 = i15;
                i18 = i4 & Fields.Shape;
                if (i18 != 0) {
                }
                if ((i3 & 24576) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            int i232 = Fields.CameraDistance;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            int i2422 = Fields.Shape;
            if (i8 == 0) {
            }
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            i11 = i4 & Fields.SpotShadowColor;
            if (i11 != 0) {
            }
            i12 = i4 & Fields.RotationX;
            if (i12 != 0) {
            }
            i13 = i4 & Fields.RotationY;
            if (i13 != 0) {
            }
            i14 = i4 & Fields.RotationZ;
            if (i14 != 0) {
            }
            i16 = i4 & Fields.CameraDistance;
            if (i16 != 0) {
            }
            if ((i3 & 384) == 0) {
            }
            i17 = i15;
            i18 = i4 & Fields.Shape;
            if (i18 != 0) {
            }
            if ((i3 & 24576) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i2322 = Fields.CameraDistance;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        int i24222 = Fields.Shape;
        if (i8 == 0) {
        }
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        i11 = i4 & Fields.SpotShadowColor;
        if (i11 != 0) {
        }
        i12 = i4 & Fields.RotationX;
        if (i12 != 0) {
        }
        i13 = i4 & Fields.RotationY;
        if (i13 != 0) {
        }
        i14 = i4 & Fields.RotationZ;
        if (i14 != 0) {
        }
        i16 = i4 & Fields.CameraDistance;
        if (i16 != 0) {
        }
        if ((i3 & 384) == 0) {
        }
        i17 = i15;
        i18 = i4 & Fields.Shape;
        if (i18 != 0) {
        }
        if ((i3 & 24576) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BasicSecureTextField_ltb6GB4$lambda$4$lambda$3(State state, int i, int i2) {
        return ((Character) state.getValue()).charValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicSecureTextField_ltb6GB4$lambda$6$lambda$5(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.setContentType(semanticsPropertyReceiver, ContentType.INSTANCE.getPassword());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputTransformation then(InputTransformation inputTransformation, InputTransformation inputTransformation2) {
        return inputTransformation == null ? inputTransformation2 : inputTransformation2 == null ? inputTransformation : InputTransformationKt.then(inputTransformation, inputTransformation2);
    }

    private static final void DisableCutCopy(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1141174275);
        ComposerKt.sourceInformation(startRestartGroup, "C(DisableCutCopy)N(content)312@14862L7,314@14908L877,335@15790L80:BasicSecureTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1141174275, i2, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:311)");
            }
            ProvidableCompositionLocal localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = startRestartGroup.consume(localTextToolbar);
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            final TextToolbar textToolbar = (TextToolbar) consume;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1451823856, "CC(remember):BasicSecureTextField.kt#9igjgp");
            boolean changed = startRestartGroup.changed(textToolbar);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new TextToolbar(textToolbar) { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1
                    private final /* synthetic */ TextToolbar $$delegate_0;
                    final /* synthetic */ TextToolbar $currentToolbar;

                    public TextToolbarStatus getStatus() {
                        return this.$$delegate_0.getStatus();
                    }

                    public void hide() {
                        this.$$delegate_0.hide();
                    }

                    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested) {
                        this.$$delegate_0.showMenu(rect, onCopyRequested, onPasteRequested, onCutRequested, onSelectAllRequested);
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.$currentToolbar = textToolbar;
                        this.$$delegate_0 = textToolbar;
                    }

                    public void showMenu(Rect rect, Function0<Unit> onCopyRequested, Function0<Unit> onPasteRequested, Function0<Unit> onCutRequested, Function0<Unit> onSelectAllRequested, Function0<Unit> onAutofillRequested) {
                        this.$currentToolbar.showMenu(rect, (Function0) null, onPasteRequested, (Function0) null, onSelectAllRequested, onAutofillRequested);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>) CompositionLocalsKt.getLocalTextToolbar().provides((BasicSecureTextFieldKt$DisableCutCopy$copyDisabledToolbar$1$1) rememberedValue), function2, startRestartGroup, ((i2 << 3) & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit DisableCutCopy$lambda$10;
                    DisableCutCopy$lambda$10 = BasicSecureTextFieldKt.DisableCutCopy$lambda$10(function2, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DisableCutCopy$lambda$10;
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload that takes in readOnly parameter.")
    /* renamed from: BasicSecureTextField-Jb9bMDk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1486BasicSecureTextFieldJb9bMDk(final TextFieldState textFieldState, Modifier modifier, boolean z, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, Composer composer, final int i2, final int i3, final int i4) {
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
        int i17;
        int i18;
        Modifier.Companion companion;
        final boolean z2;
        final InputTransformation inputTransformation2;
        final TextStyle textStyle2;
        final KeyboardOptions keyboardOptions2;
        KeyboardActionHandler keyboardActionHandler2;
        final Function2 function22;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final TextFieldDecorator textFieldDecorator2;
        final int i19;
        final char c2;
        ScopeUpdateScope endRestartGroup;
        Composer startRestartGroup = composer.startRestartGroup(1399310985);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicSecureTextField)N(state,modifier,enabled,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter)364@17059L564:BasicSecureTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(textFieldState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i20 = i4 & 2;
        if (i20 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i6 = i4 & 4;
            int i21 = Fields.SpotShadowColor;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 384) == 0) {
                i5 |= startRestartGroup.changed(z) ? Fields.RotationX : 128;
                i7 = i4 & 8;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(inputTransformation) ? Fields.CameraDistance : Fields.RotationZ;
                    i8 = i4 & 16;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i5 |= startRestartGroup.changed(textStyle) ? Fields.Clip : Fields.Shape;
                        i9 = i4 & 32;
                        if (i9 != 0) {
                            i5 |= 196608;
                        } else if ((i2 & 196608) == 0) {
                            i5 |= startRestartGroup.changed(keyboardOptions) ? Fields.RenderEffect : 65536;
                        }
                        i10 = i4 & 64;
                        if (i10 != 0) {
                            i5 |= 1572864;
                        } else if ((i2 & 1572864) == 0) {
                            i5 |= startRestartGroup.changed(keyboardActionHandler) ? 1048576 : Fields.BlendMode;
                        }
                        i11 = i4 & Fields.SpotShadowColor;
                        if (i11 != 0) {
                            i5 |= 12582912;
                        } else if ((i2 & 12582912) == 0) {
                            i5 |= startRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
                        }
                        i12 = i4 & Fields.RotationX;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(mutableInteractionSource) ? 67108864 : 33554432;
                        }
                        i13 = i4 & Fields.RotationY;
                        if (i13 != 0) {
                            i5 |= 805306368;
                        } else if ((i2 & 805306368) == 0) {
                            i5 |= startRestartGroup.changed(brush) ? 536870912 : 268435456;
                        }
                        i14 = i4 & Fields.RotationZ;
                        if (i14 != 0) {
                            i15 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i15 = i3 | ((i3 & 8) == 0 ? startRestartGroup.changed(textFieldDecorator) : startRestartGroup.changedInstance(textFieldDecorator) ? 4 : 2);
                        } else {
                            i15 = i3;
                        }
                        i16 = i4 & Fields.CameraDistance;
                        if (i16 != 0) {
                            i15 |= 48;
                        } else if ((i3 & 48) == 0) {
                            i15 |= startRestartGroup.changed(i) ? 32 : 16;
                        }
                        i17 = i15;
                        i18 = i4 & Fields.TransformOrigin;
                        if (i18 != 0) {
                            i17 |= 384;
                        } else if ((i3 & 384) == 0) {
                            if (startRestartGroup.changed(c)) {
                                i21 = Fields.RotationX;
                            }
                            i17 |= i21;
                            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 147) != 146, i5 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                companion = modifier;
                                z2 = z;
                                inputTransformation2 = inputTransformation;
                                textStyle2 = textStyle;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActionHandler2 = keyboardActionHandler;
                                function22 = function2;
                                mutableInteractionSource2 = mutableInteractionSource;
                                brush2 = brush;
                                textFieldDecorator2 = textFieldDecorator;
                                i19 = i;
                                c2 = c;
                            } else {
                                companion = i20 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z3 = i6 != 0 ? true : z;
                                InputTransformation inputTransformation3 = i7 != 0 ? null : inputTransformation;
                                TextStyle textStyle3 = i8 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                KeyboardOptions secureTextField$foundation_release = i9 != 0 ? KeyboardOptions.INSTANCE.getSecureTextField$foundation_release() : keyboardOptions;
                                keyboardActionHandler2 = i10 != 0 ? null : keyboardActionHandler;
                                Function2 function23 = i11 != 0 ? null : function2;
                                MutableInteractionSource mutableInteractionSource3 = i12 != 0 ? null : mutableInteractionSource;
                                SolidColor solidColor = i13 != 0 ? new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null) : brush;
                                textFieldDecorator2 = i14 == 0 ? textFieldDecorator : null;
                                int m1761getRevealLastTypedvTwcZD0 = i16 != 0 ? TextObfuscationMode.INSTANCE.m1761getRevealLastTypedvTwcZD0() : i;
                                char c3 = i18 != 0 ? DefaultObfuscationCharacter : c;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1399310985, i5, i17, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:363)");
                                }
                                int i22 = i5 << 3;
                                int i23 = i17 << 3;
                                m1488BasicSecureTextFieldltb6GB4(textFieldState, companion, z3, false, inputTransformation3, textStyle3, secureTextField$foundation_release, keyboardActionHandler2, function23, mutableInteractionSource3, solidColor, textFieldDecorator2, m1761getRevealLastTypedvTwcZD0, c3, null, startRestartGroup, (i5 & 14) | 3072 | (i5 & 112) | (i5 & 896) | (57344 & i22) | (458752 & i22) | (3670016 & i22) | (29360128 & i22) | (234881024 & i22) | (i22 & 1879048192), ((i5 >> 27) & 14) | (i23 & 112) | (i23 & 896) | (i23 & 7168), Fields.Clip);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function22 = function23;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                c2 = c3;
                                z2 = z3;
                                textStyle2 = textStyle3;
                                keyboardOptions2 = secureTextField$foundation_release;
                                brush2 = solidColor;
                                inputTransformation2 = inputTransformation3;
                                i19 = m1761getRevealLastTypedvTwcZD0;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier2 = companion;
                                final KeyboardActionHandler keyboardActionHandler3 = keyboardActionHandler2;
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda5
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicSecureTextField_Jb9bMDk$lambda$11;
                                        BasicSecureTextField_Jb9bMDk$lambda$11 = BasicSecureTextFieldKt.BasicSecureTextField_Jb9bMDk$lambda$11(TextFieldState.this, modifier2, z2, inputTransformation2, textStyle2, keyboardOptions2, keyboardActionHandler3, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i19, c2, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicSecureTextField_Jb9bMDk$lambda$11;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 147) != 146, i5 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i9 = i4 & 32;
                    if (i9 != 0) {
                    }
                    i10 = i4 & 64;
                    if (i10 != 0) {
                    }
                    i11 = i4 & Fields.SpotShadowColor;
                    if (i11 != 0) {
                    }
                    i12 = i4 & Fields.RotationX;
                    if (i12 != 0) {
                    }
                    i13 = i4 & Fields.RotationY;
                    if (i13 != 0) {
                    }
                    i14 = i4 & Fields.RotationZ;
                    if (i14 != 0) {
                    }
                    i16 = i4 & Fields.CameraDistance;
                    if (i16 != 0) {
                    }
                    i17 = i15;
                    i18 = i4 & Fields.TransformOrigin;
                    if (i18 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 147) != 146, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                if (i8 == 0) {
                }
                i9 = i4 & 32;
                if (i9 != 0) {
                }
                i10 = i4 & 64;
                if (i10 != 0) {
                }
                i11 = i4 & Fields.SpotShadowColor;
                if (i11 != 0) {
                }
                i12 = i4 & Fields.RotationX;
                if (i12 != 0) {
                }
                i13 = i4 & Fields.RotationY;
                if (i13 != 0) {
                }
                i14 = i4 & Fields.RotationZ;
                if (i14 != 0) {
                }
                i16 = i4 & Fields.CameraDistance;
                if (i16 != 0) {
                }
                i17 = i15;
                i18 = i4 & Fields.TransformOrigin;
                if (i18 != 0) {
                }
                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 147) != 146, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            if (i8 == 0) {
            }
            i9 = i4 & 32;
            if (i9 != 0) {
            }
            i10 = i4 & 64;
            if (i10 != 0) {
            }
            i11 = i4 & Fields.SpotShadowColor;
            if (i11 != 0) {
            }
            i12 = i4 & Fields.RotationX;
            if (i12 != 0) {
            }
            i13 = i4 & Fields.RotationY;
            if (i13 != 0) {
            }
            i14 = i4 & Fields.RotationZ;
            if (i14 != 0) {
            }
            i16 = i4 & Fields.CameraDistance;
            if (i16 != 0) {
            }
            i17 = i15;
            i18 = i4 & Fields.TransformOrigin;
            if (i18 != 0) {
            }
            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 147) != 146, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i6 = i4 & 4;
        int i212 = Fields.SpotShadowColor;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        if (i8 == 0) {
        }
        i9 = i4 & 32;
        if (i9 != 0) {
        }
        i10 = i4 & 64;
        if (i10 != 0) {
        }
        i11 = i4 & Fields.SpotShadowColor;
        if (i11 != 0) {
        }
        i12 = i4 & Fields.RotationX;
        if (i12 != 0) {
        }
        i13 = i4 & Fields.RotationY;
        if (i13 != 0) {
        }
        i14 = i4 & Fields.RotationZ;
        if (i14 != 0) {
        }
        i16 = i4 & Fields.CameraDistance;
        if (i16 != 0) {
        }
        i17 = i15;
        i18 = i4 & Fields.TransformOrigin;
        if (i18 != 0) {
        }
        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 147) != 146, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:92:? A[RETURN, SYNTHETIC] */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Please use the overload that takes in scrollState parameter.")
    /* renamed from: BasicSecureTextField-egD4TGM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void m1487BasicSecureTextFieldegD4TGM(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, TextFieldDecorator textFieldDecorator, int i, char c, Composer composer, final int i2, final int i3, final int i4) {
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
        int i17;
        int i18;
        Modifier.Companion companion;
        final boolean z3;
        final boolean z4;
        final InputTransformation inputTransformation2;
        final TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        final KeyboardActionHandler keyboardActionHandler2;
        final Function2 function22;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final TextFieldDecorator textFieldDecorator2;
        int i19;
        char c2;
        ScopeUpdateScope endRestartGroup;
        boolean z5;
        KeyboardActionHandler keyboardActionHandler3;
        SolidColor solidColor;
        Composer startRestartGroup = composer.startRestartGroup(-817513499);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicSecureTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,onTextLayout,interactionSource,cursorBrush,decorator,textObfuscationMode:c#foundation.text.input.TextObfuscationMode,textObfuscationCharacter)421@19275L21,406@18694L609:BasicSecureTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(textFieldState) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        int i20 = i4 & 2;
        if (i20 != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i6 = i4 & 4;
            int i21 = Fields.SpotShadowColor;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 384) == 0) {
                i5 |= startRestartGroup.changed(z) ? Fields.RotationX : 128;
                i7 = i4 & 16;
                if (i7 != 0) {
                    i5 |= 24576;
                } else if ((i2 & 24576) == 0) {
                    i5 |= startRestartGroup.changed(inputTransformation) ? Fields.Clip : Fields.Shape;
                    i8 = i4 & 32;
                    if (i8 == 0) {
                        i5 |= 196608;
                    } else if ((i2 & 196608) == 0) {
                        i5 |= startRestartGroup.changed(textStyle) ? Fields.RenderEffect : 65536;
                    }
                    i9 = i4 & 64;
                    if (i9 == 0) {
                        i5 |= 1572864;
                    } else if ((i2 & 1572864) == 0) {
                        i5 |= startRestartGroup.changed(keyboardOptions) ? 1048576 : Fields.BlendMode;
                    }
                    i10 = i4 & Fields.SpotShadowColor;
                    if (i10 == 0) {
                        i5 |= 12582912;
                    } else if ((i2 & 12582912) == 0) {
                        i5 |= startRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                    }
                    i11 = i4 & Fields.RotationX;
                    if (i11 == 0) {
                        i5 |= 100663296;
                    } else if ((i2 & 100663296) == 0) {
                        i5 |= startRestartGroup.changedInstance(function2) ? 67108864 : 33554432;
                    }
                    i12 = i4 & Fields.RotationY;
                    if (i12 == 0) {
                        i5 |= 805306368;
                    } else if ((i2 & 805306368) == 0) {
                        i5 |= startRestartGroup.changed(mutableInteractionSource) ? 536870912 : 268435456;
                    }
                    i13 = i4 & Fields.RotationZ;
                    if (i13 == 0) {
                        i14 = i3 | 6;
                    } else if ((i3 & 6) == 0) {
                        i14 = i3 | (startRestartGroup.changed(brush) ? 4 : 2);
                    } else {
                        i14 = i3;
                    }
                    i15 = i4 & Fields.CameraDistance;
                    if (i15 == 0) {
                        i14 |= 48;
                    } else if ((i3 & 48) == 0) {
                        i14 |= (i3 & 64) == 0 ? startRestartGroup.changed(textFieldDecorator) : startRestartGroup.changedInstance(textFieldDecorator) ? 32 : 16;
                    }
                    i16 = i14;
                    i17 = i4 & Fields.TransformOrigin;
                    if (i17 == 0) {
                        i16 |= 384;
                    } else if ((i3 & 384) == 0) {
                        if (startRestartGroup.changed(i)) {
                            i21 = Fields.RotationX;
                        }
                        i16 |= i21;
                        i18 = i4 & Fields.Shape;
                        if (i18 != 0) {
                            i16 |= 3072;
                        } else if ((i3 & 3072) == 0) {
                            i16 |= startRestartGroup.changed(c) ? Fields.CameraDistance : Fields.RotationZ;
                            if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i16 & 1171) != 1170, i5 & 1)) {
                                startRestartGroup.skipToGroupEnd();
                                companion = modifier;
                                z3 = z;
                                z4 = z2;
                                inputTransformation2 = inputTransformation;
                                textStyle2 = textStyle;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActionHandler2 = keyboardActionHandler;
                                function22 = function2;
                                mutableInteractionSource2 = mutableInteractionSource;
                                brush2 = brush;
                                textFieldDecorator2 = textFieldDecorator;
                                i19 = i;
                                c2 = c;
                            } else {
                                companion = i20 != 0 ? Modifier.INSTANCE : modifier;
                                boolean z6 = i6 != 0 ? true : z;
                                boolean z7 = (i4 & 8) != 0 ? false : z2;
                                InputTransformation inputTransformation3 = i7 != 0 ? null : inputTransformation;
                                TextStyle textStyle3 = i8 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                keyboardOptions2 = i9 != 0 ? KeyboardOptions.INSTANCE.getSecureTextField$foundation_release() : keyboardOptions;
                                KeyboardActionHandler keyboardActionHandler4 = i10 != 0 ? null : keyboardActionHandler;
                                Function2 function23 = i11 != 0 ? null : function2;
                                MutableInteractionSource mutableInteractionSource3 = i12 != 0 ? null : mutableInteractionSource;
                                if (i13 != 0) {
                                    z5 = z7;
                                    keyboardActionHandler3 = keyboardActionHandler4;
                                    solidColor = new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null);
                                } else {
                                    z5 = z7;
                                    keyboardActionHandler3 = keyboardActionHandler4;
                                    solidColor = brush;
                                }
                                TextFieldDecorator textFieldDecorator3 = i15 == 0 ? textFieldDecorator : null;
                                int m1761getRevealLastTypedvTwcZD0 = i17 != 0 ? TextObfuscationMode.INSTANCE.m1761getRevealLastTypedvTwcZD0() : i;
                                char c3 = i18 != 0 ? DefaultObfuscationCharacter : c;
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-817513499, i5, i16, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:405)");
                                }
                                m1488BasicSecureTextFieldltb6GB4(textFieldState, companion, z6, false, inputTransformation3, textStyle3, keyboardOptions2, keyboardActionHandler3, function23, mutableInteractionSource3, solidColor, textFieldDecorator3, m1761getRevealLastTypedvTwcZD0, c3, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), startRestartGroup, (i5 & 14) | 3072 | (i5 & 112) | (i5 & 896) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192), (i16 & 14) | (i16 & 112) | (i16 & 896) | (i16 & 7168), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function22 = function23;
                                brush2 = solidColor;
                                c2 = c3;
                                textFieldDecorator2 = textFieldDecorator3;
                                textStyle2 = textStyle3;
                                z4 = z5;
                                keyboardActionHandler2 = keyboardActionHandler3;
                                i19 = m1761getRevealLastTypedvTwcZD0;
                                inputTransformation2 = inputTransformation3;
                                boolean z8 = z6;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                z3 = z8;
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup == null) {
                                final Modifier modifier2 = companion;
                                final KeyboardOptions keyboardOptions3 = keyboardOptions2;
                                final int i22 = i19;
                                final char c4 = c2;
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicSecureTextFieldKt$$ExternalSyntheticLambda4
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicSecureTextField_egD4TGM$lambda$12;
                                        BasicSecureTextField_egD4TGM$lambda$12 = BasicSecureTextFieldKt.BasicSecureTextField_egD4TGM$lambda$12(TextFieldState.this, modifier2, z3, z4, inputTransformation2, textStyle2, keyboardOptions3, keyboardActionHandler2, function22, mutableInteractionSource2, brush2, textFieldDecorator2, i22, c4, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicSecureTextField_egD4TGM$lambda$12;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i16 & 1171) != 1170, i5 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i18 = i4 & Fields.Shape;
                    if (i18 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i16 & 1171) != 1170, i5 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i8 = i4 & 32;
                if (i8 == 0) {
                }
                i9 = i4 & 64;
                if (i9 == 0) {
                }
                i10 = i4 & Fields.SpotShadowColor;
                if (i10 == 0) {
                }
                i11 = i4 & Fields.RotationX;
                if (i11 == 0) {
                }
                i12 = i4 & Fields.RotationY;
                if (i12 == 0) {
                }
                i13 = i4 & Fields.RotationZ;
                if (i13 == 0) {
                }
                i15 = i4 & Fields.CameraDistance;
                if (i15 == 0) {
                }
                i16 = i14;
                i17 = i4 & Fields.TransformOrigin;
                if (i17 == 0) {
                }
                i18 = i4 & Fields.Shape;
                if (i18 != 0) {
                }
                if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i16 & 1171) != 1170, i5 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i7 = i4 & 16;
            if (i7 != 0) {
            }
            i8 = i4 & 32;
            if (i8 == 0) {
            }
            i9 = i4 & 64;
            if (i9 == 0) {
            }
            i10 = i4 & Fields.SpotShadowColor;
            if (i10 == 0) {
            }
            i11 = i4 & Fields.RotationX;
            if (i11 == 0) {
            }
            i12 = i4 & Fields.RotationY;
            if (i12 == 0) {
            }
            i13 = i4 & Fields.RotationZ;
            if (i13 == 0) {
            }
            i15 = i4 & Fields.CameraDistance;
            if (i15 == 0) {
            }
            i16 = i14;
            i17 = i4 & Fields.TransformOrigin;
            if (i17 == 0) {
            }
            i18 = i4 & Fields.Shape;
            if (i18 != 0) {
            }
            if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i16 & 1171) != 1170, i5 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i6 = i4 & 4;
        int i212 = Fields.SpotShadowColor;
        if (i6 == 0) {
        }
        i7 = i4 & 16;
        if (i7 != 0) {
        }
        i8 = i4 & 32;
        if (i8 == 0) {
        }
        i9 = i4 & 64;
        if (i9 == 0) {
        }
        i10 = i4 & Fields.SpotShadowColor;
        if (i10 == 0) {
        }
        i11 = i4 & Fields.RotationX;
        if (i11 == 0) {
        }
        i12 = i4 & Fields.RotationY;
        if (i12 == 0) {
        }
        i13 = i4 & Fields.RotationZ;
        if (i13 == 0) {
        }
        i15 = i4 & Fields.CameraDistance;
        if (i15 == 0) {
        }
        i16 = i14;
        i17 = i4 & Fields.TransformOrigin;
        if (i17 == 0) {
        }
        i18 = i4 & Fields.Shape;
        if (i18 != 0) {
        }
        if (startRestartGroup.shouldExecute((i5 & 306782355) == 306782354 || (i16 & 1171) != 1170, i5 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }
}
