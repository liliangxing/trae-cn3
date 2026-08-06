package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.animation.core.AnimationConstants;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.relocation.BringIntoViewRequester;
import androidx.compose.foundation.relocation.BringIntoViewRequesterKt;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.internal.CoreTextFieldSemanticsModifier;
import androidx.compose.foundation.text.input.internal.LegacyAdaptingPlatformTextInputModifierNodeKt;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter;
import androidx.compose.foundation.text.input.internal.LegacyPlatformTextInputServiceAdapter_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.foundation.text.selection.SelectionGesturesKt;
import androidx.compose.foundation.text.selection.SelectionHandleAnchor;
import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.DrawModifierKt;
import androidx.compose.p002ui.focus.FocusManager;
import androidx.compose.p002ui.focus.FocusRequester;
import androidx.compose.p002ui.focus.FocusState;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.graphics.Brush;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.SolidColor;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.hapticfeedback.HapticFeedback;
import androidx.compose.p002ui.input.key.KeyEvent;
import androidx.compose.p002ui.input.key.KeyInputModifierKt;
import androidx.compose.p002ui.input.pointer.PointerIcon;
import androidx.compose.p002ui.input.pointer.PointerIconKt;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.p002ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScope;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: CoreTextField.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aú\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00132\b\b\u0002\u0010\u001c\u001a\u00020\u001323\b\u0002\u0010\u001d\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u001f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$H\u0001¢\u0006\u0002\u0010%\u001a0\u0010&\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00010\u001e¢\u0006\u0002\b\u001fH\u0003¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020\u0007*\u00020\u00072\u0006\u0010,\u001a\u00020-2\u0006\u0010'\u001a\u00020(H\u0002\u001a \u0010.\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0013H\u0000\u001a0\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u0002042\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u00105\u001a\u000206H\u0002\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-H\u0002\u001a2\u00108\u001a\u00020\u0001*\u0002092\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\r2\u0006\u00105\u001a\u000206H\u0080@¢\u0006\u0002\u0010=\u001a\u001d\u0010>\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010@\u001a\u0015\u0010A\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\u0010B\u001a \u0010C\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000206H\u0002\u001a\u001c\u0010D\u001a\u00020\u0007*\u00020\u00072\u0006\u0010E\u001a\u00020(2\u0006\u0010F\u001a\u00020GH\u0002¨\u0006H²\u0006\n\u0010I\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"CoreTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "onTextLayout", "Landroidx/compose/ui/text/TextLayoutResult;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "softWrap", "", "maxLines", "", "minLines", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "enabled", "readOnly", "decorationBox", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "innerTextField", "textScrollerPosition", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;ZIILandroidx/compose/ui/text/input/ImeOptions;Landroidx/compose/foundation/text/KeyboardActions;ZZLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/text/TextFieldScrollerPosition;Landroidx/compose/runtime/Composer;III)V", "CoreTextFieldRootBox", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "previewKeyEventToDeselectOnBack", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "tapToFocus", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "allowKeyboard", "startInputSession", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "endInputSession", "bringSelectionEndIntoView", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "textDelegate", "Landroidx/compose/foundation/text/TextDelegate;", "textLayoutResult", "(Landroidx/compose/foundation/relocation/BringIntoViewRequester;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/foundation/text/TextDelegate;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/text/input/OffsetMapping;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "SelectionToolbarAndHandles", "show", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;ZLandroidx/compose/runtime/Composer;I)V", "TextFieldCursorHandle", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "notifyFocusedRect", "addContextMenuComponents", "textFieldSelectionManager", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release", "writeable"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class CoreTextFieldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$41(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3 function3, TextFieldScrollerPosition textFieldScrollerPosition, int i3, int i4, int i5, Composer composer, int i6) {
        CoreTextField(textFieldValue, function1, modifier, textStyle, visualTransformation, function12, mutableInteractionSource, brush, z, i, i2, imeOptions, keyboardActions, z2, z3, function3, textFieldScrollerPosition, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextFieldRootBox$lambda$43(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, Function2 function2, int i, Composer composer, int i2) {
        CoreTextFieldRootBox(modifier, textFieldSelectionManager, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionToolbarAndHandles$lambda$49(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Composer composer, int i2) {
        SelectionToolbarAndHandles(textFieldSelectionManager, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldCursorHandle$lambda$55(TextFieldSelectionManager textFieldSelectionManager, int i, Composer composer, int i2) {
        TextFieldCursorHandle(textFieldSelectionManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CoreTextField$lambda$1$lambda$0(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x075e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0791 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x07c5  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x081e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0847  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0851  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0865  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x08bc  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x08cb  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0900  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0913  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0922  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x096a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x099f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x09cb  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x09d3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x09e7  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0a12  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0a43  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0a7a  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0ac7  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0b2b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0b44  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0bb3  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0bfd  */
    /* JADX WARN: Removed duplicated region for block: B:266:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0b4d  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0a15  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x09cd  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0915  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x08be  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0853  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0849  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x07d7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0bd5  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:390:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:428:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:435:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0225  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void CoreTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, TextStyle textStyle, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, boolean z, int i, int i2, ImeOptions imeOptions, KeyboardActions keyboardActions, boolean z2, boolean z3, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, TextFieldScrollerPosition textFieldScrollerPosition, Composer composer, final int i3, final int i4, final int i5) {
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
        int i19;
        int i20;
        int i21;
        Composer composer2;
        final Modifier modifier2;
        final TextStyle textStyle2;
        final VisualTransformation visualTransformation2;
        final Function1<? super TextLayoutResult, Unit> function13;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final boolean z4;
        final int i22;
        final int i23;
        final ImeOptions imeOptions2;
        final KeyboardActions keyboardActions2;
        final boolean z5;
        final boolean z6;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        final TextFieldScrollerPosition textFieldScrollerPosition2;
        ScopeUpdateScope endRestartGroup;
        Modifier modifier3;
        Function1<? super TextLayoutResult, Unit> function14;
        Function1<? super TextLayoutResult, Unit> function15;
        VisualTransformation visualTransformation3;
        SolidColor solidColor;
        ImeOptions imeOptions3;
        Function1<? super TextLayoutResult, Unit> function16;
        TextFieldScrollerPosition textFieldScrollerPosition3;
        boolean z7;
        Brush brush3;
        int i24;
        KeyboardActions keyboardActions3;
        TextStyle textStyle3;
        boolean z8;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33;
        MutableInteractionSource mutableInteractionSource3;
        Modifier modifier4;
        VisualTransformation visualTransformation4;
        int i25;
        ImeOptions imeOptions4;
        boolean z9;
        TextInputService textInputService;
        int i26;
        ImeOptions imeOptions5;
        int i27;
        TextFieldScrollerPosition textFieldScrollerPosition4;
        String str;
        final ImeOptions imeOptions6;
        int i28;
        int i29;
        boolean z10;
        boolean changedInstance;
        Object rememberedValue;
        Modifier textFieldFocusModifier;
        Modifier modifier5;
        boolean z11;
        boolean z12;
        Object rememberedValue2;
        boolean changedInstance2;
        Object rememberedValue3;
        boolean changedInstance3;
        Object rememberedValue4;
        boolean changedInstance4;
        Object rememberedValue5;
        final TextFieldValue textFieldValue2;
        boolean changedInstance5;
        Object rememberedValue6;
        boolean changedInstance6;
        Object rememberedValue7;
        boolean changedInstance7;
        Object rememberedValue8;
        final boolean z13;
        boolean changed;
        Object rememberedValue9;
        boolean changedInstance8;
        Object rememberedValue10;
        boolean z14;
        Modifier.Companion companion;
        int i30;
        Composer startRestartGroup = composer.startRestartGroup(31062401);
        ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextField)N(value,onValueChange,modifier,textStyle,visualTransformation,onTextLayout,interactionSource,cursorBrush,softWrap,maxLines,minLines,imeOptions,keyboardActions,enabled,readOnly,decorationBox,textScrollerPosition)212@12013L29,213@12083L58,214@12187L72,219@12317L7,220@12378L7,221@12446L7,222@12511L7,223@12556L7,224@12625L7,245@13467L277,257@14049L21,259@14095L453,288@14948L26,291@15041L24,292@15099L37,294@15156L51,300@15445L7,302@15540L7,303@15597L7,319@16182L1514,354@17803L42,355@17871L971,355@17850L992,381@18912L28,382@19008L992,411@20291L577,429@20939L1606,482@23157L48,482@23131L74,484@23240L503,484@23211L532,516@24417L987,533@25467L7,535@25536L151,567@26896L5409,567@26843L5462:CoreTextField.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i6 = (startRestartGroup.changed(textFieldValue) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i31 = i5 & 4;
        if (i31 != 0) {
            i6 |= 384;
        } else if ((i3 & 384) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
            i7 = i5 & 8;
            int i32 = Fields.RotationZ;
            if (i7 == 0) {
                i6 |= 3072;
            } else if ((i3 & 3072) == 0) {
                i6 |= startRestartGroup.changed(textStyle) ? Fields.CameraDistance : 1024;
                i8 = i5 & 16;
                if (i8 != 0) {
                    i6 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    i6 |= startRestartGroup.changed(visualTransformation) ? Fields.Clip : Fields.Shape;
                    i9 = i5 & 32;
                    if (i9 == 0) {
                        i6 |= 196608;
                    } else if ((i3 & 196608) == 0) {
                        i6 |= startRestartGroup.changedInstance(function12) ? Fields.RenderEffect : 65536;
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                        i6 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        i6 |= startRestartGroup.changed(mutableInteractionSource) ? 1048576 : Fields.BlendMode;
                    }
                    i11 = i5 & Fields.SpotShadowColor;
                    if (i11 == 0) {
                        i6 |= 12582912;
                    } else if ((i3 & 12582912) == 0) {
                        i6 |= startRestartGroup.changed(brush) ? 8388608 : 4194304;
                    }
                    i12 = i5 & Fields.RotationX;
                    if (i12 == 0) {
                        i6 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i6 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
                    }
                    i13 = i5 & Fields.RotationY;
                    if (i13 == 0) {
                        i6 |= 805306368;
                    } else if ((i3 & 805306368) == 0) {
                        i6 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
                    }
                    i14 = i5 & Fields.RotationZ;
                    if (i14 == 0) {
                        i15 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        i15 = i4 | (startRestartGroup.changed(i2) ? 4 : 2);
                    } else {
                        i15 = i4;
                    }
                    if ((i4 & 48) == 0) {
                        if ((i5 & Fields.CameraDistance) == 0 && startRestartGroup.changed(imeOptions)) {
                            i30 = 32;
                            i15 |= i30;
                        }
                        i30 = 16;
                        i15 |= i30;
                    }
                    i16 = i15;
                    i17 = i5 & Fields.TransformOrigin;
                    if (i17 == 0) {
                        i16 |= 384;
                    } else if ((i4 & 384) == 0) {
                        i16 |= startRestartGroup.changed(keyboardActions) ? Fields.RotationX : Fields.SpotShadowColor;
                        i18 = i5 & Fields.Shape;
                        if (i18 != 0) {
                            i16 |= 3072;
                        } else if ((i4 & 3072) == 0) {
                            if (startRestartGroup.changed(z2)) {
                                i32 = Fields.CameraDistance;
                            }
                            i16 |= i32;
                            i19 = i5 & Fields.Clip;
                            if (i19 == 0) {
                                i16 |= 24576;
                            } else if ((i4 & 24576) == 0) {
                                i16 |= startRestartGroup.changed(z3) ? Fields.Clip : Fields.Shape;
                                i20 = i5 & Fields.CompositingStrategy;
                                if (i20 != 0) {
                                    i16 |= 196608;
                                } else if ((i4 & 196608) == 0) {
                                    i16 |= startRestartGroup.changedInstance(function3) ? Fields.RenderEffect : 65536;
                                }
                                i21 = i5 & 65536;
                                if (i21 != 0) {
                                    i16 |= 1572864;
                                } else if ((i4 & 1572864) == 0) {
                                    i16 |= startRestartGroup.changed(textFieldScrollerPosition) ? 1048576 : Fields.BlendMode;
                                }
                                if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (599187 & i16) != 599186, i6 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "197@11338L2");
                                    if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i5 & Fields.CameraDistance) != 0) {
                                            i16 &= -113;
                                        }
                                        modifier4 = modifier;
                                        textStyle3 = textStyle;
                                        visualTransformation4 = visualTransformation;
                                        function16 = function12;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        brush3 = brush;
                                        z7 = z;
                                        i25 = i;
                                        i24 = i2;
                                        imeOptions4 = imeOptions;
                                        keyboardActions3 = keyboardActions;
                                        z9 = z2;
                                        z8 = z3;
                                        function33 = function3;
                                        textFieldScrollerPosition3 = textFieldScrollerPosition;
                                    } else {
                                        Modifier.Companion companion2 = i31 != 0 ? Modifier.INSTANCE : modifier;
                                        TextStyle textStyle4 = i7 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                        VisualTransformation none = i8 != 0 ? VisualTransformation.Companion.getNone() : visualTransformation;
                                        if (i9 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213793597, "CC(remember):CoreTextField.kt#9igjgp");
                                            Object rememberedValue11 = startRestartGroup.rememberedValue();
                                            modifier3 = companion2;
                                            Object obj = rememberedValue11;
                                            if (rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                                Object obj2 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda10
                                                    public final Object invoke(Object obj3) {
                                                        Unit CoreTextField$lambda$1$lambda$0;
                                                        CoreTextField$lambda$1$lambda$0 = CoreTextFieldKt.CoreTextField$lambda$1$lambda$0((TextLayoutResult) obj3);
                                                        return CoreTextField$lambda$1$lambda$0;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(obj2);
                                                obj = obj2;
                                            }
                                            function14 = (Function1) obj;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            modifier3 = companion2;
                                            function14 = function12;
                                        }
                                        MutableInteractionSource mutableInteractionSource4 = i10 != 0 ? null : mutableInteractionSource;
                                        if (i11 != 0) {
                                            visualTransformation3 = none;
                                            function15 = function14;
                                            solidColor = new SolidColor(Color.INSTANCE.m4875getUnspecified0d7_KjU(), null);
                                        } else {
                                            function15 = function14;
                                            visualTransformation3 = none;
                                            solidColor = brush;
                                        }
                                        boolean z15 = i12 != 0 ? true : z;
                                        int i33 = i13 != 0 ? Integer.MAX_VALUE : i;
                                        int i34 = i14 != 0 ? 1 : i2;
                                        if ((i5 & Fields.CameraDistance) != 0) {
                                            imeOptions3 = ImeOptions.Companion.getDefault();
                                            i16 &= -113;
                                        } else {
                                            imeOptions3 = imeOptions;
                                        }
                                        KeyboardActions keyboardActions4 = i17 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z16 = i18 != 0 ? true : z2;
                                        boolean z17 = i19 != 0 ? false : z3;
                                        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> lambda$559628295$foundation_release = i20 != 0 ? ComposableSingletons$CoreTextFieldKt.INSTANCE.getLambda$559628295$foundation_release() : function3;
                                        function16 = function15;
                                        if (i21 != 0) {
                                            z7 = z15;
                                            brush3 = solidColor;
                                            i24 = i34;
                                            keyboardActions3 = keyboardActions4;
                                            textStyle3 = textStyle4;
                                            z8 = z17;
                                            function33 = lambda$559628295$foundation_release;
                                            mutableInteractionSource3 = mutableInteractionSource4;
                                            textFieldScrollerPosition3 = null;
                                        } else {
                                            textFieldScrollerPosition3 = textFieldScrollerPosition;
                                            z7 = z15;
                                            brush3 = solidColor;
                                            i24 = i34;
                                            keyboardActions3 = keyboardActions4;
                                            textStyle3 = textStyle4;
                                            z8 = z17;
                                            function33 = lambda$559628295$foundation_release;
                                            mutableInteractionSource3 = mutableInteractionSource4;
                                        }
                                        modifier4 = modifier3;
                                        visualTransformation4 = visualTransformation3;
                                        i25 = i33;
                                        boolean z18 = z16;
                                        imeOptions4 = imeOptions3;
                                        z9 = z18;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(31062401, i6, i16, "androidx.compose.foundation.text.CoreTextField (CoreTextField.kt:211)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213771970, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object rememberedValue12 = startRestartGroup.rememberedValue();
                                    if (rememberedValue12 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue12 = new FocusRequester();
                                        startRestartGroup.updateRememberedValue(rememberedValue12);
                                    }
                                    final FocusRequester focusRequester = (FocusRequester) rememberedValue12;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213769701, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object rememberedValue13 = startRestartGroup.rememberedValue();
                                    if (rememberedValue13 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue13 = LegacyPlatformTextInputServiceAdapter_androidKt.createLegacyPlatformTextInputServiceAdapter();
                                        startRestartGroup.updateRememberedValue(rememberedValue13);
                                    }
                                    final LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter = (LegacyPlatformTextInputServiceAdapter) rememberedValue13;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213766359, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object rememberedValue14 = startRestartGroup.rememberedValue();
                                    if (rememberedValue14 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue14 = new TextInputService(legacyPlatformTextInputServiceAdapter);
                                        startRestartGroup.updateRememberedValue(rememberedValue14);
                                    }
                                    TextInputService textInputService2 = (TextInputService) rememberedValue14;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume = startRestartGroup.consume(localDensity);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final Density density = (Density) consume;
                                    ProvidableCompositionLocal localFontFamilyResolver = CompositionLocalsKt.getLocalFontFamilyResolver();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume2 = startRestartGroup.consume(localFontFamilyResolver);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    FontFamily.Resolver resolver = (FontFamily.Resolver) consume2;
                                    Modifier modifier6 = modifier4;
                                    ProvidableCompositionLocal<TextSelectionColors> localTextSelectionColors = TextSelectionColorsKt.getLocalTextSelectionColors();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume3 = startRestartGroup.consume(localTextSelectionColors);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    long backgroundColor = ((TextSelectionColors) consume3).getBackgroundColor();
                                    ProvidableCompositionLocal localFocusManager = CompositionLocalsKt.getLocalFocusManager();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume4 = startRestartGroup.consume(localFocusManager);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    FocusManager focusManager = (FocusManager) consume4;
                                    MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource3;
                                    ProvidableCompositionLocal localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume5 = startRestartGroup.consume(localWindowInfo);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final WindowInfo windowInfo = (WindowInfo) consume5;
                                    ProvidableCompositionLocal localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume6 = startRestartGroup.consume(localSoftwareKeyboardController);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) consume6;
                                    final Orientation orientation = i25 == 1 && !z7 && imeOptions4.getSingleLine() ? Orientation.Horizontal : Orientation.Vertical;
                                    if (textFieldScrollerPosition3 != null) {
                                        textInputService = textInputService2;
                                        i26 = i16;
                                        imeOptions5 = imeOptions4;
                                        i27 = i25;
                                        startRestartGroup.startReplaceGroup(-213745070);
                                        startRestartGroup.endReplaceGroup();
                                        textFieldScrollerPosition4 = textFieldScrollerPosition3;
                                    } else {
                                        i27 = i25;
                                        startRestartGroup.startReplaceGroup(-213743954);
                                        ComposerKt.sourceInformation(startRestartGroup, "231@12956L70,231@12885L141");
                                        imeOptions5 = imeOptions4;
                                        Object[] objArr = {orientation};
                                        Saver<TextFieldScrollerPosition, Object> saver = TextFieldScrollerPosition.INSTANCE.getSaver();
                                        textInputService = textInputService2;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213741753, "CC(remember):CoreTextField.kt#9igjgp");
                                        boolean changed2 = startRestartGroup.changed(orientation.ordinal());
                                        i26 = i16;
                                        Object rememberedValue15 = startRestartGroup.rememberedValue();
                                        if (changed2 || rememberedValue15 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue15 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda13
                                                public final Object invoke() {
                                                    TextFieldScrollerPosition CoreTextField$lambda$6$lambda$5;
                                                    CoreTextField$lambda$6$lambda$5 = CoreTextFieldKt.CoreTextField$lambda$6$lambda$5(Orientation.this);
                                                    return CoreTextField$lambda$6$lambda$5;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue15);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        TextFieldScrollerPosition textFieldScrollerPosition5 = (TextFieldScrollerPosition) RememberSaveableKt.m4242rememberSaveable(objArr, (Saver) saver, (Function0) rememberedValue15, startRestartGroup, 0);
                                        startRestartGroup.endReplaceGroup();
                                        textFieldScrollerPosition4 = textFieldScrollerPosition5;
                                    }
                                    if (textFieldScrollerPosition4.getOrientation() != orientation) {
                                        throw new IllegalArgumentException("Mismatching scroller orientation; ".concat(orientation == Orientation.Vertical ? "only single-line, non-wrap text fields can scroll horizontally" : "single-line, non-wrap text fields can only scroll horizontally"));
                                    }
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213725194, "CC(remember):CoreTextField.kt#9igjgp");
                                    int i35 = i6 & 14;
                                    boolean z19 = ((i6 & 57344) == 16384) | (i35 == 4);
                                    Object rememberedValue16 = startRestartGroup.rememberedValue();
                                    if (z19 || rememberedValue16 == Composer.INSTANCE.getEmpty()) {
                                        TransformedText filterWithValidation = ValidatingOffsetMappingKt.filterWithValidation(visualTransformation4, textFieldValue.getAnnotatedString());
                                        TextRange textRange = textFieldValue.getComposition-MzsxiRA();
                                        if (textRange == null || (rememberedValue16 = TextFieldDelegate.INSTANCE.m1631applyCompositionDecoration72CqOWE(textRange.unbox-impl(), filterWithValidation)) == null) {
                                            rememberedValue16 = filterWithValidation;
                                        }
                                        startRestartGroup.updateRememberedValue(rememberedValue16);
                                    }
                                    TransformedText transformedText = (TransformedText) rememberedValue16;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    AnnotatedString text = transformedText.getText();
                                    final OffsetMapping offsetMapping = transformedText.getOffsetMapping();
                                    final TextFieldScrollerPosition textFieldScrollerPosition6 = textFieldScrollerPosition4;
                                    RecomposeScope currentRecomposeScope = ComposablesKt.getCurrentRecomposeScope(startRestartGroup, 0);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213704922, "CC(remember):CoreTextField.kt#9igjgp");
                                    boolean changed3 = startRestartGroup.changed(softwareKeyboardController);
                                    Object rememberedValue17 = startRestartGroup.rememberedValue();
                                    if (changed3 || rememberedValue17 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue17 = new LegacyTextFieldState(new TextDelegate(text, textStyle3, 0, 0, z7, 0, density, resolver, null, AnimationConstants.DefaultDurationMillis, null), currentRecomposeScope, softwareKeyboardController);
                                        startRestartGroup.updateRememberedValue(rememberedValue17);
                                    }
                                    final LegacyTextFieldState legacyTextFieldState = (LegacyTextFieldState) rememberedValue17;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    legacyTextFieldState.m1568updatefnh65Uc(textFieldValue.getAnnotatedString(), text, textStyle3, z7, density, resolver, function1, keyboardActions3, focusManager, backgroundColor);
                                    legacyTextFieldState.getProcessor().reset(textFieldValue, legacyTextFieldState.getInputSession());
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213678053, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object rememberedValue18 = startRestartGroup.rememberedValue();
                                    if (rememberedValue18 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue18 = new UndoManager(0, 1, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue18);
                                    }
                                    UndoManager undoManager = (UndoManager) rememberedValue18;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    UndoManager.snapshotIfNeeded$default(undoManager, textFieldValue, 0L, 2, null);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                                    Object rememberedValue19 = startRestartGroup.rememberedValue();
                                    if (rememberedValue19 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue19 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                        startRestartGroup.updateRememberedValue(rememberedValue19);
                                    }
                                    final CoroutineScope coroutineScope = (CoroutineScope) rememberedValue19;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213673210, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object rememberedValue20 = startRestartGroup.rememberedValue();
                                    if (rememberedValue20 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue20 = BringIntoViewRequesterKt.BringIntoViewRequester();
                                        startRestartGroup.updateRememberedValue(rememberedValue20);
                                    }
                                    final BringIntoViewRequester bringIntoViewRequester = (BringIntoViewRequester) rememberedValue20;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213671372, "CC(remember):CoreTextField.kt#9igjgp");
                                    Object rememberedValue21 = startRestartGroup.rememberedValue();
                                    if (rememberedValue21 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue21 = new TextFieldSelectionManager(undoManager);
                                        startRestartGroup.updateRememberedValue(rememberedValue21);
                                    }
                                    final TextFieldSelectionManager textFieldSelectionManager = (TextFieldSelectionManager) rememberedValue21;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    textFieldSelectionManager.setOffsetMapping$foundation_release(offsetMapping);
                                    textFieldSelectionManager.setVisualTransformation$foundation_release(visualTransformation4);
                                    textFieldSelectionManager.setOnValueChange$foundation_release(legacyTextFieldState.getOnValueChange());
                                    textFieldSelectionManager.setState$foundation_release(legacyTextFieldState);
                                    textFieldSelectionManager.setValue$foundation_release(textFieldValue);
                                    ProvidableCompositionLocal localClipboard = CompositionLocalsKt.getLocalClipboard();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume7 = startRestartGroup.consume(localClipboard);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    textFieldSelectionManager.setClipboard$foundation_release((Clipboard) consume7);
                                    textFieldSelectionManager.setCoroutineScope$foundation_release(coroutineScope);
                                    ProvidableCompositionLocal localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume8 = startRestartGroup.consume(localTextToolbar);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    textFieldSelectionManager.setTextToolbar((TextToolbar) consume8);
                                    ProvidableCompositionLocal localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                    Object consume9 = startRestartGroup.consume(localHapticFeedback);
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    textFieldSelectionManager.setHapticFeedBack((HapticFeedback) consume9);
                                    textFieldSelectionManager.setFocusRequester(focusRequester);
                                    textFieldSelectionManager.setEditable(!z8);
                                    textFieldSelectionManager.setEnabled(z9);
                                    if (ComposeFoundationFlags.isSmartSelectionEnabled) {
                                        startRestartGroup.startReplaceGroup(1966776937);
                                        ComposerKt.sourceInformation(startRestartGroup, "310@15872L87");
                                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                        textFieldSelectionManager.setPlatformSelectionBehaviors$foundation_release(PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, textStyle3.getLocaleList(), startRestartGroup, 6));
                                        startRestartGroup.endReplaceGroup();
                                    } else {
                                        str = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                                        startRestartGroup.startReplaceGroup(1966923009);
                                        startRestartGroup.endReplaceGroup();
                                    }
                                    Modifier.Companion companion3 = Modifier.INSTANCE;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213637077, "CC(remember):CoreTextField.kt#9igjgp");
                                    int i36 = i26;
                                    int i37 = i36 & 7168;
                                    final VisualTransformation visualTransformation5 = visualTransformation4;
                                    int i38 = 57344 & i36;
                                    final TextInputService textInputService3 = textInputService;
                                    boolean changedInstance9 = (i35 == 4) | startRestartGroup.changedInstance(legacyTextFieldState) | (i37 == 2048) | (i38 == 16384) | startRestartGroup.changedInstance(textInputService3);
                                    int i39 = (i36 & 112) ^ 48;
                                    if (i39 > 32) {
                                        imeOptions6 = imeOptions5;
                                        if (startRestartGroup.changed(imeOptions6)) {
                                            i29 = i36;
                                            i28 = i38;
                                            z10 = true;
                                            changedInstance = changedInstance9 | z10 | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(bringIntoViewRequester) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            if (!changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                final boolean z20 = z9;
                                                final boolean z21 = z8;
                                                final ImeOptions imeOptions7 = imeOptions6;
                                                rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda14
                                                    public final Object invoke(Object obj3) {
                                                        Unit CoreTextField$lambda$15$lambda$14;
                                                        CoreTextField$lambda$15$lambda$14 = CoreTextFieldKt.CoreTextField$lambda$15$lambda$14(LegacyTextFieldState.this, z20, z21, textInputService3, textFieldValue, imeOptions7, offsetMapping, textFieldSelectionManager, coroutineScope, bringIntoViewRequester, (FocusState) obj3);
                                                        return CoreTextField$lambda$15$lambda$14;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion3, z9, focusRequester, mutableInteractionSource5, (Function1) rememberedValue);
                                            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z9 || z8) ? false : true), startRestartGroup, 0);
                                            Unit unit = Unit.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213583572, "CC(remember):CoreTextField.kt#9igjgp");
                                            boolean changed4 = startRestartGroup.changed(rememberUpdatedState) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService3) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                            if (i39 > 32 || !startRestartGroup.changed(imeOptions6)) {
                                                modifier5 = textFieldFocusModifier;
                                                if ((i29 & 48) != 32) {
                                                    z11 = false;
                                                    z12 = z11 | changed4;
                                                    rememberedValue2 = startRestartGroup.rememberedValue();
                                                    if (!z12 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue2 = (Function2) new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState, textInputService3, textFieldSelectionManager, imeOptions6, null);
                                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
                                                    Modifier.Companion companion4 = Modifier.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213551203, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                                                    rememberedValue3 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda15
                                                            public final Object invoke(Object obj3) {
                                                                Unit CoreTextField$lambda$19$lambda$18;
                                                                CoreTextField$lambda$19$lambda$18 = CoreTextFieldKt.CoreTextField$lambda$19$lambda$18(LegacyTextFieldState.this, ((Boolean) obj3).booleanValue());
                                                                return CoreTextField$lambda$19$lambda$18;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    Modifier updateSelectionTouchMode = SelectionGesturesKt.updateSelectionTouchMode(companion4, (Function1) rememberedValue3);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213547167, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i28 != 16384) | (i37 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                                    rememberedValue4 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                                        final boolean z22 = z8;
                                                        final boolean z23 = z9;
                                                        rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1
                                                            public final Object invoke(Object obj3) {
                                                                Unit CoreTextField$lambda$22$lambda$21;
                                                                CoreTextField$lambda$22$lambda$21 = CoreTextFieldKt.CoreTextField$lambda$22$lambda$21(LegacyTextFieldState.this, focusRequester, z22, z23, textFieldSelectionManager, offsetMapping, (Offset) obj3);
                                                                return CoreTextField$lambda$22$lambda$21;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    Modifier pointerHoverIcon$default = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode, mutableInteractionSource5, z9, (Function1) rememberedValue4), textFieldSelectionManager.getMouseSelectionObserver(), textFieldSelectionManager.getTouchSelectionObserver()), PointerIcon.INSTANCE.getText(), false, 2, null);
                                                    Modifier.Companion companion5 = Modifier.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213506526, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i35 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                    rememberedValue5 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance4 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                                        textFieldValue2 = textFieldValue;
                                                        rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda2
                                                            public final Object invoke(Object obj3) {
                                                                Unit CoreTextField$lambda$26$lambda$25;
                                                                CoreTextField$lambda$26$lambda$25 = CoreTextFieldKt.CoreTextField$lambda$26$lambda$25(LegacyTextFieldState.this, textFieldValue2, offsetMapping, (DrawScope) obj3);
                                                                return CoreTextField$lambda$26$lambda$25;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue5);
                                                    } else {
                                                        textFieldValue2 = textFieldValue;
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    final Modifier drawBehind = DrawModifierKt.drawBehind(companion5, (Function1) rememberedValue5);
                                                    Modifier.Companion companion6 = Modifier.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213484761, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance5 = (i37 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i35 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                    rememberedValue6 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance5 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                                        final boolean z24 = z9;
                                                        rememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda3
                                                            public final Object invoke(Object obj3) {
                                                                Unit CoreTextField$lambda$30$lambda$29;
                                                                CoreTextField$lambda$30$lambda$29 = CoreTextFieldKt.CoreTextField$lambda$30$lambda$29(LegacyTextFieldState.this, z24, windowInfo, textFieldSelectionManager, textFieldValue, offsetMapping, (LayoutCoordinates) obj3);
                                                                return CoreTextField$lambda$30$lambda$29;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue6);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    final Modifier onGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion6, (Function1) rememberedValue6);
                                                    ModifierNodeElement coreTextFieldSemanticsModifier = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState, z8, z9, visualTransformation5 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager, imeOptions6, focusRequester);
                                                    final Modifier cursor = TextFieldCursorKt.cursor(Modifier.INSTANCE, legacyTextFieldState, textFieldValue, offsetMapping, brush3, (z9 || z8 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213415343, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance6 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                                    rememberedValue7 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance6 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue7 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4
                                                            public final Object invoke(Object obj3) {
                                                                DisposableEffectResult CoreTextField$lambda$33$lambda$32;
                                                                CoreTextField$lambda$33$lambda$32 = CoreTextFieldKt.CoreTextField$lambda$33$lambda$32(TextFieldSelectionManager.this, (DisposableEffectScope) obj3);
                                                                return CoreTextField$lambda$33$lambda$32;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue7);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue7, startRestartGroup, 0);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213412232, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance7 = (i35 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService3) | ((i39 <= 32 && startRestartGroup.changed(imeOptions6)) || (i29 & 48) == 32);
                                                    rememberedValue8 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance7 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue8 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda5
                                                            public final Object invoke(Object obj3) {
                                                                DisposableEffectResult CoreTextField$lambda$36$lambda$35;
                                                                CoreTextField$lambda$36$lambda$35 = CoreTextFieldKt.CoreTextField$lambda$36$lambda$35(LegacyTextFieldState.this, textInputService3, textFieldValue2, imeOptions6, (DisposableEffectScope) obj3);
                                                                return CoreTextField$lambda$36$lambda$35;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue8);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    EffectsKt.DisposableEffect(imeOptions6, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue8, startRestartGroup, (i29 >> 3) & 14);
                                                    final int i40 = i27;
                                                    Modifier m1646textFieldKeyInput2WJ9YEU = TextFieldKeyInputKt.m1646textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, legacyTextFieldState, textFieldSelectionManager, textFieldValue, legacyTextFieldState.getOnValueChange(), !z8, i40 != 1, offsetMapping, undoManager, imeOptions6.getImeAction-eUduSuo());
                                                    z13 = KeyboardType.equals-impl0(imeOptions6.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getPassword-PjHm6EE()) && !KeyboardType.equals-impl0(imeOptions6.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getNumberPassword-PjHm6EE());
                                                    Modifier.Companion companion7 = Modifier.INSTANCE;
                                                    boolean CoreTextField$lambda$16 = CoreTextField$lambda$16(rememberUpdatedState);
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213374084, "CC(remember):CoreTextField.kt#9igjgp");
                                                    ImeOptions imeOptions8 = imeOptions6;
                                                    changed = startRestartGroup.changed(z13) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                                    rememberedValue9 = startRestartGroup.rememberedValue();
                                                    if (!changed || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue9 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6
                                                            public final Object invoke() {
                                                                Unit CoreTextField$lambda$38$lambda$37;
                                                                CoreTextField$lambda$38$lambda$37 = CoreTextFieldKt.CoreTextField$lambda$38$lambda$37(z13, legacyPlatformTextInputServiceAdapter);
                                                                return CoreTextField$lambda$38$lambda$37;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue9);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    Modifier stylusHandwriting = StylusHandwritingKt.stylusHandwriting(companion7, CoreTextField$lambda$16, z13, (Function0) rememberedValue9);
                                                    ProvidableCompositionLocal<Color> localAutofillHighlightColor = AutofillHighlightKt.getLocalAutofillHighlightColor();
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str);
                                                    Object consume10 = startRestartGroup.consume(localAutofillHighlightColor);
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    final long m4849unboximpl = ((Color) consume10).m4849unboximpl();
                                                    Modifier.Companion companion8 = Modifier.INSTANCE;
                                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213339112, "CC(remember):CoreTextField.kt#9igjgp");
                                                    changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changed(m4849unboximpl);
                                                    rememberedValue10 = startRestartGroup.rememberedValue();
                                                    if (!changedInstance8 || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                                        rememberedValue10 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda11
                                                            public final Object invoke(Object obj3) {
                                                                Unit CoreTextField$lambda$40$lambda$39;
                                                                CoreTextField$lambda$40$lambda$39 = CoreTextFieldKt.CoreTextField$lambda$40$lambda$39(LegacyTextFieldState.this, m4849unboximpl, (DrawScope) obj3);
                                                                return CoreTextField$lambda$40$lambda$39;
                                                            }
                                                        };
                                                        startRestartGroup.updateRememberedValue(rememberedValue10);
                                                    }
                                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                    Modifier addContextMenuComponents = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier6.then(DrawModifierKt.drawBehind(companion8, (Function1) rememberedValue10)), legacyPlatformTextInputServiceAdapter, legacyTextFieldState, textFieldSelectionManager).then(stylusHandwriting).then(modifier5), legacyTextFieldState, focusManager), legacyTextFieldState, textFieldSelectionManager).then(m1646textFieldKeyInput2WJ9YEU), textFieldScrollerPosition6, mutableInteractionSource5, z9).then(pointerHoverIcon$default).then((Modifier) coreTextFieldSemanticsModifier), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                                            invoke((LayoutCoordinates) obj3);
                                                            return Unit.INSTANCE;
                                                        }

                                                        public final void invoke(LayoutCoordinates layoutCoordinates) {
                                                            TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                            if (layoutResult != null) {
                                                                layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                            }
                                                        }
                                                    }), textFieldSelectionManager, coroutineScope);
                                                    z14 = !z9 && legacyTextFieldState.getHasFocus() && legacyTextFieldState.isInTouchMode() && windowInfo.isWindowFocused();
                                                    if (!z14) {
                                                        companion = TextFieldSelectionManager_androidKt.textFieldMagnifier(Modifier.INSTANCE, textFieldSelectionManager);
                                                    } else {
                                                        companion = Modifier.INSTANCE;
                                                    }
                                                    final Modifier modifier7 = companion;
                                                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function34 = function33;
                                                    final TextStyle textStyle5 = textStyle3;
                                                    final int i41 = i24;
                                                    boolean z25 = z9;
                                                    final boolean z26 = z14;
                                                    final boolean z27 = z8;
                                                    final Function1<? super TextLayoutResult, Unit> function17 = function16;
                                                    composer2 = startRestartGroup;
                                                    CoreTextFieldRootBox(addContextMenuComponents, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5

                                                        /* JADX INFO: Access modifiers changed from: package-private */
                                                        /* compiled from: CoreTextField.kt */
                                                        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                                                        /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1 */
                                                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                                        public static final class C03951 implements Function2<Composer, Integer, Unit> {
                                                            final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
                                                            final /* synthetic */ Modifier $cursorModifier;
                                                            final /* synthetic */ Density $density;
                                                            final /* synthetic */ Modifier $drawModifier;
                                                            final /* synthetic */ Modifier $magnifierModifier;
                                                            final /* synthetic */ TextFieldSelectionManager $manager;
                                                            final /* synthetic */ int $maxLines;
                                                            final /* synthetic */ int $minLines;
                                                            final /* synthetic */ OffsetMapping $offsetMapping;
                                                            final /* synthetic */ Modifier $onPositionedModifier;
                                                            final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
                                                            final /* synthetic */ boolean $readOnly;
                                                            final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
                                                            final /* synthetic */ boolean $showHandleAndMagnifier;
                                                            final /* synthetic */ LegacyTextFieldState $state;
                                                            final /* synthetic */ TextStyle $textStyle;
                                                            final /* synthetic */ TextFieldValue $value;
                                                            final /* synthetic */ VisualTransformation $visualTransformation;

                                                            C03951(LegacyTextFieldState legacyTextFieldState, TextStyle textStyle, int i, int i2, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, Function1<? super TextLayoutResult, Unit> function1, OffsetMapping offsetMapping, Density density) {
                                                                this.$state = legacyTextFieldState;
                                                                this.$textStyle = textStyle;
                                                                this.$minLines = i;
                                                                this.$maxLines = i2;
                                                                this.$scrollerPosition = textFieldScrollerPosition;
                                                                this.$value = textFieldValue;
                                                                this.$visualTransformation = visualTransformation;
                                                                this.$cursorModifier = modifier;
                                                                this.$drawModifier = modifier2;
                                                                this.$onPositionedModifier = modifier3;
                                                                this.$magnifierModifier = modifier4;
                                                                this.$bringIntoViewRequester = bringIntoViewRequester;
                                                                this.$manager = textFieldSelectionManager;
                                                                this.$showHandleAndMagnifier = z;
                                                                this.$readOnly = z2;
                                                                this.$onTextLayout = function1;
                                                                this.$offsetMapping = offsetMapping;
                                                                this.$density = density;
                                                            }

                                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer, int i) {
                                                                ComposerKt.sourceInformation(composer, "C582@27771L22,591@28158L4131,591@28122L4167:CoreTextField.kt#423gt5");
                                                                if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
                                                                    composer.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-44346382, i, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:571)");
                                                                }
                                                                Modifier heightInLines = HeightInLinesModifierKt.heightInLines(SizeKt.m1108heightInVpY3zN4$default(Modifier.INSTANCE, this.$state.m1561getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), this.$textStyle, this.$minLines, this.$maxLines);
                                                                TextFieldScrollerPosition textFieldScrollerPosition = this.$scrollerPosition;
                                                                TextFieldValue textFieldValue = this.$value;
                                                                VisualTransformation visualTransformation = this.$visualTransformation;
                                                                ComposerKt.sourceInformationMarkerStart(composer, 332827112, "CC(remember):CoreTextField.kt#9igjgp");
                                                                boolean changedInstance = composer.changedInstance(this.$state);
                                                                final LegacyTextFieldState legacyTextFieldState = this.$state;
                                                                Object rememberedValue = composer.rememberedValue();
                                                                if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                                    rememberedValue = 
                                                                    /*  JADX ERROR: Method code generation error
                                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0066: CONSTRUCTOR (r7v1 'rememberedValue' java.lang.Object) = (r6v1 'legacyTextFieldState' androidx.compose.foundation.text.LegacyTextFieldState A[DONT_INLINE]) A[MD:(androidx.compose.foundation.text.LegacyTextFieldState):void (m)] (LINE:583) call: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0.<init>(androidx.compose.foundation.text.LegacyTextFieldState):void type: CONSTRUCTOR in method: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1.invoke(androidx.compose.runtime.Composer, int):void, file: /data/user/work/trae_cn3_decoded/build/apk/classes.dex
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                                        	... 25 more
                                                                        */
                                                                    /*
                                                                        this = this;
                                                                        java.lang.String r0 = "C582@27771L22,591@28158L4131,591@28122L4167:CoreTextField.kt#423gt5"
                                                                        androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
                                                                        r0 = r15 & 3
                                                                        r1 = 0
                                                                        r2 = 1
                                                                        r3 = 2
                                                                        if (r0 == r3) goto Le
                                                                        r0 = r2
                                                                        goto Lf
                                                                    Le:
                                                                        r0 = r1
                                                                    Lf:
                                                                        r4 = r15 & 1
                                                                        boolean r0 = r14.shouldExecute(r0, r4)
                                                                        if (r0 == 0) goto Lcb
                                                                        boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                                        if (r0 == 0) goto L26
                                                                        r0 = -1
                                                                        java.lang.String r4 = "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:571)"
                                                                        r5 = -44346382(0xfffffffffd5b53f2, float:-1.822105E37)
                                                                        androidx.compose.runtime.ComposerKt.traceEventStart(r5, r15, r0, r4)
                                                                    L26:
                                                                        androidx.compose.ui.Modifier$Companion r15 = androidx.compose.p002ui.Modifier.INSTANCE
                                                                        androidx.compose.ui.Modifier r15 = (androidx.compose.p002ui.Modifier) r15
                                                                        androidx.compose.foundation.text.LegacyTextFieldState r0 = r13.$state
                                                                        float r0 = r0.m1561getMinHeightForSingleLineFieldD9Ej5fM()
                                                                        r4 = 0
                                                                        r5 = 0
                                                                        androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.m1108heightInVpY3zN4$default(r15, r0, r4, r3, r5)
                                                                        androidx.compose.ui.text.TextStyle r0 = r13.$textStyle
                                                                        int r3 = r13.$minLines
                                                                        int r4 = r13.$maxLines
                                                                        androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.HeightInLinesModifierKt.heightInLines(r15, r0, r3, r4)
                                                                        androidx.compose.foundation.text.TextFieldScrollerPosition r0 = r13.$scrollerPosition
                                                                        androidx.compose.ui.text.input.TextFieldValue r3 = r13.$value
                                                                        androidx.compose.ui.text.input.VisualTransformation r4 = r13.$visualTransformation
                                                                        r5 = 332827112(0x13d689e8, float:5.415718E-27)
                                                                        java.lang.String r6 = "CC(remember):CoreTextField.kt#9igjgp"
                                                                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r6)
                                                                        androidx.compose.foundation.text.LegacyTextFieldState r5 = r13.$state
                                                                        boolean r5 = r14.changedInstance(r5)
                                                                        androidx.compose.foundation.text.LegacyTextFieldState r6 = r13.$state
                                                                        java.lang.Object r7 = r14.rememberedValue()
                                                                        if (r5 != 0) goto L64
                                                                        androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.INSTANCE
                                                                        java.lang.Object r5 = r5.getEmpty()
                                                                        if (r7 != r5) goto L6c
                                                                    L64:
                                                                        androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0 r7 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0
                                                                        r7.<init>(r6)
                                                                        r14.updateRememberedValue(r7)
                                                                    L6c:
                                                                        kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
                                                                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
                                                                        androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.TextFieldScroll_androidKt.textFieldScroll(r15, r0, r3, r4, r7)
                                                                        androidx.compose.ui.Modifier r0 = r13.$cursorModifier
                                                                        androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                                        androidx.compose.ui.Modifier r0 = r13.$drawModifier
                                                                        androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                                        androidx.compose.ui.text.TextStyle r0 = r13.$textStyle
                                                                        androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.TextFieldSizeKt.textFieldMinSize(r15, r0)
                                                                        androidx.compose.ui.Modifier r0 = r13.$onPositionedModifier
                                                                        androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                                        androidx.compose.ui.Modifier r0 = r13.$magnifierModifier
                                                                        androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                                        androidx.compose.foundation.relocation.BringIntoViewRequester r0 = r13.$bringIntoViewRequester
                                                                        androidx.compose.ui.Modifier r15 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.bringIntoViewRequester(r15, r0)
                                                                        androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1
                                                                        androidx.compose.foundation.text.selection.TextFieldSelectionManager r4 = r13.$manager
                                                                        androidx.compose.foundation.text.LegacyTextFieldState r5 = r13.$state
                                                                        boolean r6 = r13.$showHandleAndMagnifier
                                                                        boolean r7 = r13.$readOnly
                                                                        kotlin.jvm.functions.Function1<androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r8 = r13.$onTextLayout
                                                                        androidx.compose.ui.text.input.TextFieldValue r9 = r13.$value
                                                                        androidx.compose.ui.text.input.OffsetMapping r10 = r13.$offsetMapping
                                                                        androidx.compose.ui.unit.Density r11 = r13.$density
                                                                        int r12 = r13.$maxLines
                                                                        r3 = r0
                                                                        r3.<init>()
                                                                        r3 = 54
                                                                        r4 = 1412697320(0x54340ce8, float:3.09324258E12)
                                                                        androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r2, r0, r14, r3)
                                                                        kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
                                                                        r2 = 48
                                                                        androidx.compose.foundation.text.selection.SimpleLayoutKt.SimpleLayout(r15, r0, r14, r2, r1)
                                                                        boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                                        if (r14 == 0) goto Lce
                                                                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                                                                        goto Lce
                                                                    Lcb:
                                                                        r14.skipToGroupEnd()
                                                                    Lce:
                                                                        return
                                                                    */
                                                                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.C03951.invoke(androidx.compose.runtime.Composer, int):void");
                                                                }
                                                            }

                                                            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                                                                invoke((Composer) obj3, ((Number) obj4).intValue());
                                                                return Unit.INSTANCE;
                                                            }

                                                            public final void invoke(Composer composer3, int i42) {
                                                                ComposerKt.sourceInformation(composer3, "C568@26920L5379,568@26906L5393:CoreTextField.kt#423gt5");
                                                                if (!composer3.shouldExecute((i42 & 3) != 2, i42 & 1)) {
                                                                    composer3.skipToGroupEnd();
                                                                    return;
                                                                }
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventStart(-814563849, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:568)");
                                                                }
                                                                function34.invoke(ComposableLambdaKt.rememberComposableLambda(-44346382, true, new C03951(legacyTextFieldState, textStyle5, i41, i40, textFieldScrollerPosition6, textFieldValue, visualTransformation5, cursor, drawBehind, onGloballyPositioned, modifier7, bringIntoViewRequester, textFieldSelectionManager, z26, z27, function17, offsetMapping, density), composer3, 54), composer3, 6);
                                                                if (ComposerKt.isTraceInProgress()) {
                                                                    ComposerKt.traceEventEnd();
                                                                }
                                                            }
                                                        }, composer2, 54), composer2, 384);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                        imeOptions2 = imeOptions8;
                                                        textStyle2 = textStyle3;
                                                        mutableInteractionSource2 = mutableInteractionSource5;
                                                        z5 = z25;
                                                        function13 = function16;
                                                        brush2 = brush3;
                                                        i22 = i40;
                                                        visualTransformation2 = visualTransformation5;
                                                        z4 = z7;
                                                        i23 = i24;
                                                        keyboardActions2 = keyboardActions3;
                                                        z6 = z8;
                                                        function32 = function33;
                                                        textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                        modifier2 = modifier6;
                                                    }
                                                } else {
                                                    modifier5 = textFieldFocusModifier;
                                                }
                                                z11 = true;
                                                z12 = z11 | changed4;
                                                rememberedValue2 = startRestartGroup.rememberedValue();
                                                if (!z12) {
                                                }
                                                rememberedValue2 = (Function2) new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState, textInputService3, textFieldSelectionManager, imeOptions6, null);
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
                                                Modifier.Companion companion42 = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213551203, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                                                rememberedValue3 = startRestartGroup.rememberedValue();
                                                if (!changedInstance2) {
                                                }
                                                rememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda15
                                                    public final Object invoke(Object obj3) {
                                                        Unit CoreTextField$lambda$19$lambda$18;
                                                        CoreTextField$lambda$19$lambda$18 = CoreTextFieldKt.CoreTextField$lambda$19$lambda$18(LegacyTextFieldState.this, ((Boolean) obj3).booleanValue());
                                                        return CoreTextField$lambda$19$lambda$18;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue3);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                Modifier updateSelectionTouchMode2 = SelectionGesturesKt.updateSelectionTouchMode(companion42, (Function1) rememberedValue3);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213547167, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i28 != 16384) | (i37 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                                rememberedValue4 = startRestartGroup.rememberedValue();
                                                if (!changedInstance3) {
                                                }
                                                final boolean z222 = z8;
                                                final boolean z232 = z9;
                                                rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1
                                                    public final Object invoke(Object obj3) {
                                                        Unit CoreTextField$lambda$22$lambda$21;
                                                        CoreTextField$lambda$22$lambda$21 = CoreTextFieldKt.CoreTextField$lambda$22$lambda$21(LegacyTextFieldState.this, focusRequester, z222, z232, textFieldSelectionManager, offsetMapping, (Offset) obj3);
                                                        return CoreTextField$lambda$22$lambda$21;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue4);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                Modifier pointerHoverIcon$default2 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode2, mutableInteractionSource5, z9, (Function1) rememberedValue4), textFieldSelectionManager.getMouseSelectionObserver(), textFieldSelectionManager.getTouchSelectionObserver()), PointerIcon.INSTANCE.getText(), false, 2, null);
                                                Modifier.Companion companion52 = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213506526, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i35 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                rememberedValue5 = startRestartGroup.rememberedValue();
                                                if (changedInstance4) {
                                                }
                                                textFieldValue2 = textFieldValue;
                                                rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda2
                                                    public final Object invoke(Object obj3) {
                                                        Unit CoreTextField$lambda$26$lambda$25;
                                                        CoreTextField$lambda$26$lambda$25 = CoreTextFieldKt.CoreTextField$lambda$26$lambda$25(LegacyTextFieldState.this, textFieldValue2, offsetMapping, (DrawScope) obj3);
                                                        return CoreTextField$lambda$26$lambda$25;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue5);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                final Modifier drawBehind2 = DrawModifierKt.drawBehind(companion52, (Function1) rememberedValue5);
                                                Modifier.Companion companion62 = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213484761, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance5 = (i37 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i35 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                                rememberedValue6 = startRestartGroup.rememberedValue();
                                                if (!changedInstance5) {
                                                }
                                                final boolean z242 = z9;
                                                rememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda3
                                                    public final Object invoke(Object obj3) {
                                                        Unit CoreTextField$lambda$30$lambda$29;
                                                        CoreTextField$lambda$30$lambda$29 = CoreTextFieldKt.CoreTextField$lambda$30$lambda$29(LegacyTextFieldState.this, z242, windowInfo, textFieldSelectionManager, textFieldValue, offsetMapping, (LayoutCoordinates) obj3);
                                                        return CoreTextField$lambda$30$lambda$29;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue6);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                final Modifier onGloballyPositioned2 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion62, (Function1) rememberedValue6);
                                                ModifierNodeElement coreTextFieldSemanticsModifier2 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState, z8, z9, visualTransformation5 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager, imeOptions6, focusRequester);
                                                final Modifier cursor2 = TextFieldCursorKt.cursor(Modifier.INSTANCE, legacyTextFieldState, textFieldValue, offsetMapping, brush3, (z9 || z8 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213415343, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance6 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                                rememberedValue7 = startRestartGroup.rememberedValue();
                                                if (!changedInstance6) {
                                                }
                                                rememberedValue7 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4
                                                    public final Object invoke(Object obj3) {
                                                        DisposableEffectResult CoreTextField$lambda$33$lambda$32;
                                                        CoreTextField$lambda$33$lambda$32 = CoreTextFieldKt.CoreTextField$lambda$33$lambda$32(TextFieldSelectionManager.this, (DisposableEffectScope) obj3);
                                                        return CoreTextField$lambda$33$lambda$32;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue7);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue7, startRestartGroup, 0);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213412232, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance7 = (i35 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService3) | ((i39 <= 32 && startRestartGroup.changed(imeOptions6)) || (i29 & 48) == 32);
                                                rememberedValue8 = startRestartGroup.rememberedValue();
                                                if (!changedInstance7) {
                                                }
                                                rememberedValue8 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda5
                                                    public final Object invoke(Object obj3) {
                                                        DisposableEffectResult CoreTextField$lambda$36$lambda$35;
                                                        CoreTextField$lambda$36$lambda$35 = CoreTextFieldKt.CoreTextField$lambda$36$lambda$35(LegacyTextFieldState.this, textInputService3, textFieldValue2, imeOptions6, (DisposableEffectScope) obj3);
                                                        return CoreTextField$lambda$36$lambda$35;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue8);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                EffectsKt.DisposableEffect(imeOptions6, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue8, startRestartGroup, (i29 >> 3) & 14);
                                                final int i402 = i27;
                                                Modifier m1646textFieldKeyInput2WJ9YEU2 = TextFieldKeyInputKt.m1646textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, legacyTextFieldState, textFieldSelectionManager, textFieldValue, legacyTextFieldState.getOnValueChange(), !z8, i402 != 1, offsetMapping, undoManager, imeOptions6.getImeAction-eUduSuo());
                                                if (KeyboardType.equals-impl0(imeOptions6.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getPassword-PjHm6EE())) {
                                                }
                                                Modifier.Companion companion72 = Modifier.INSTANCE;
                                                boolean CoreTextField$lambda$162 = CoreTextField$lambda$16(rememberUpdatedState);
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213374084, "CC(remember):CoreTextField.kt#9igjgp");
                                                ImeOptions imeOptions82 = imeOptions6;
                                                changed = startRestartGroup.changed(z13) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                                rememberedValue9 = startRestartGroup.rememberedValue();
                                                if (!changed) {
                                                }
                                                rememberedValue9 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6
                                                    public final Object invoke() {
                                                        Unit CoreTextField$lambda$38$lambda$37;
                                                        CoreTextField$lambda$38$lambda$37 = CoreTextFieldKt.CoreTextField$lambda$38$lambda$37(z13, legacyPlatformTextInputServiceAdapter);
                                                        return CoreTextField$lambda$38$lambda$37;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue9);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                Modifier stylusHandwriting2 = StylusHandwritingKt.stylusHandwriting(companion72, CoreTextField$lambda$162, z13, (Function0) rememberedValue9);
                                                ProvidableCompositionLocal<Color> localAutofillHighlightColor2 = AutofillHighlightKt.getLocalAutofillHighlightColor();
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str);
                                                Object consume102 = startRestartGroup.consume(localAutofillHighlightColor2);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                final long m4849unboximpl2 = ((Color) consume102).m4849unboximpl();
                                                Modifier.Companion companion82 = Modifier.INSTANCE;
                                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213339112, "CC(remember):CoreTextField.kt#9igjgp");
                                                changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changed(m4849unboximpl2);
                                                rememberedValue10 = startRestartGroup.rememberedValue();
                                                if (!changedInstance8) {
                                                }
                                                rememberedValue10 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda11
                                                    public final Object invoke(Object obj3) {
                                                        Unit CoreTextField$lambda$40$lambda$39;
                                                        CoreTextField$lambda$40$lambda$39 = CoreTextFieldKt.CoreTextField$lambda$40$lambda$39(LegacyTextFieldState.this, m4849unboximpl2, (DrawScope) obj3);
                                                        return CoreTextField$lambda$40$lambda$39;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue10);
                                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                                Modifier addContextMenuComponents2 = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier6.then(DrawModifierKt.drawBehind(companion82, (Function1) rememberedValue10)), legacyPlatformTextInputServiceAdapter, legacyTextFieldState, textFieldSelectionManager).then(stylusHandwriting2).then(modifier5), legacyTextFieldState, focusManager), legacyTextFieldState, textFieldSelectionManager).then(m1646textFieldKeyInput2WJ9YEU2), textFieldScrollerPosition6, mutableInteractionSource5, z9).then(pointerHoverIcon$default2).then((Modifier) coreTextFieldSemanticsModifier2), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                                        invoke((LayoutCoordinates) obj3);
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(LayoutCoordinates layoutCoordinates) {
                                                        TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                        if (layoutResult != null) {
                                                            layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                        }
                                                    }
                                                }), textFieldSelectionManager, coroutineScope);
                                                if (z9) {
                                                }
                                                if (!z14) {
                                                }
                                                final Modifier modifier72 = companion;
                                                final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function342 = function33;
                                                final TextStyle textStyle52 = textStyle3;
                                                final int i412 = i24;
                                                boolean z252 = z9;
                                                final boolean z262 = z14;
                                                final boolean z272 = z8;
                                                final Function1<? super TextLayoutResult, Unit> function172 = function16;
                                                composer2 = startRestartGroup;
                                                CoreTextFieldRootBox(addContextMenuComponents2, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5

                                                    /* JADX INFO: Access modifiers changed from: package-private */
                                                    /* compiled from: CoreTextField.kt */
                                                    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                                                    /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1 */
                                                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                                    public static final class C03951 implements Function2<Composer, Integer, Unit> {
                                                        final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
                                                        final /* synthetic */ Modifier $cursorModifier;
                                                        final /* synthetic */ Density $density;
                                                        final /* synthetic */ Modifier $drawModifier;
                                                        final /* synthetic */ Modifier $magnifierModifier;
                                                        final /* synthetic */ TextFieldSelectionManager $manager;
                                                        final /* synthetic */ int $maxLines;
                                                        final /* synthetic */ int $minLines;
                                                        final /* synthetic */ OffsetMapping $offsetMapping;
                                                        final /* synthetic */ Modifier $onPositionedModifier;
                                                        final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
                                                        final /* synthetic */ boolean $readOnly;
                                                        final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
                                                        final /* synthetic */ boolean $showHandleAndMagnifier;
                                                        final /* synthetic */ LegacyTextFieldState $state;
                                                        final /* synthetic */ TextStyle $textStyle;
                                                        final /* synthetic */ TextFieldValue $value;
                                                        final /* synthetic */ VisualTransformation $visualTransformation;

                                                        C03951(LegacyTextFieldState legacyTextFieldState, TextStyle textStyle, int i, int i2, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, Function1<? super TextLayoutResult, Unit> function1, OffsetMapping offsetMapping, Density density) {
                                                            this.$state = legacyTextFieldState;
                                                            this.$textStyle = textStyle;
                                                            this.$minLines = i;
                                                            this.$maxLines = i2;
                                                            this.$scrollerPosition = textFieldScrollerPosition;
                                                            this.$value = textFieldValue;
                                                            this.$visualTransformation = visualTransformation;
                                                            this.$cursorModifier = modifier;
                                                            this.$drawModifier = modifier2;
                                                            this.$onPositionedModifier = modifier3;
                                                            this.$magnifierModifier = modifier4;
                                                            this.$bringIntoViewRequester = bringIntoViewRequester;
                                                            this.$manager = textFieldSelectionManager;
                                                            this.$showHandleAndMagnifier = z;
                                                            this.$readOnly = z2;
                                                            this.$onTextLayout = function1;
                                                            this.$offsetMapping = offsetMapping;
                                                            this.$density = density;
                                                        }

                                                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                            invoke((Composer) obj, ((Number) obj2).intValue());
                                                            return Unit.INSTANCE;
                                                        }

                                                        /*  JADX ERROR: Method code generation error
                                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0066: CONSTRUCTOR (r7v1 'rememberedValue' java.lang.Object) = (r6v1 'legacyTextFieldState' androidx.compose.foundation.text.LegacyTextFieldState A[DONT_INLINE]) A[MD:(androidx.compose.foundation.text.LegacyTextFieldState):void (m)] (LINE:583) call: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0.<init>(androidx.compose.foundation.text.LegacyTextFieldState):void type: CONSTRUCTOR in method: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1.invoke(androidx.compose.runtime.Composer, int):void, file: /data/user/work/trae_cn3_decoded/build/apk/classes.dex
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                            	... 20 more
                                                            */
                                                        public final void invoke(androidx.compose.runtime.Composer r14, int r15) {
                                                            /*
                                                                r13 = this;
                                                                java.lang.String r0 = "C582@27771L22,591@28158L4131,591@28122L4167:CoreTextField.kt#423gt5"
                                                                androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
                                                                r0 = r15 & 3
                                                                r1 = 0
                                                                r2 = 1
                                                                r3 = 2
                                                                if (r0 == r3) goto Le
                                                                r0 = r2
                                                                goto Lf
                                                            Le:
                                                                r0 = r1
                                                            Lf:
                                                                r4 = r15 & 1
                                                                boolean r0 = r14.shouldExecute(r0, r4)
                                                                if (r0 == 0) goto Lcb
                                                                boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                                if (r0 == 0) goto L26
                                                                r0 = -1
                                                                java.lang.String r4 = "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:571)"
                                                                r5 = -44346382(0xfffffffffd5b53f2, float:-1.822105E37)
                                                                androidx.compose.runtime.ComposerKt.traceEventStart(r5, r15, r0, r4)
                                                            L26:
                                                                androidx.compose.ui.Modifier$Companion r15 = androidx.compose.p002ui.Modifier.INSTANCE
                                                                androidx.compose.ui.Modifier r15 = (androidx.compose.p002ui.Modifier) r15
                                                                androidx.compose.foundation.text.LegacyTextFieldState r0 = r13.$state
                                                                float r0 = r0.m1561getMinHeightForSingleLineFieldD9Ej5fM()
                                                                r4 = 0
                                                                r5 = 0
                                                                androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.m1108heightInVpY3zN4$default(r15, r0, r4, r3, r5)
                                                                androidx.compose.ui.text.TextStyle r0 = r13.$textStyle
                                                                int r3 = r13.$minLines
                                                                int r4 = r13.$maxLines
                                                                androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.HeightInLinesModifierKt.heightInLines(r15, r0, r3, r4)
                                                                androidx.compose.foundation.text.TextFieldScrollerPosition r0 = r13.$scrollerPosition
                                                                androidx.compose.ui.text.input.TextFieldValue r3 = r13.$value
                                                                androidx.compose.ui.text.input.VisualTransformation r4 = r13.$visualTransformation
                                                                r5 = 332827112(0x13d689e8, float:5.415718E-27)
                                                                java.lang.String r6 = "CC(remember):CoreTextField.kt#9igjgp"
                                                                androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r6)
                                                                androidx.compose.foundation.text.LegacyTextFieldState r5 = r13.$state
                                                                boolean r5 = r14.changedInstance(r5)
                                                                androidx.compose.foundation.text.LegacyTextFieldState r6 = r13.$state
                                                                java.lang.Object r7 = r14.rememberedValue()
                                                                if (r5 != 0) goto L64
                                                                androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.INSTANCE
                                                                java.lang.Object r5 = r5.getEmpty()
                                                                if (r7 != r5) goto L6c
                                                            L64:
                                                                androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0 r7 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0
                                                                r7.<init>(r6)
                                                                r14.updateRememberedValue(r7)
                                                            L6c:
                                                                kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
                                                                androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
                                                                androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.TextFieldScroll_androidKt.textFieldScroll(r15, r0, r3, r4, r7)
                                                                androidx.compose.ui.Modifier r0 = r13.$cursorModifier
                                                                androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                                androidx.compose.ui.Modifier r0 = r13.$drawModifier
                                                                androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                                androidx.compose.ui.text.TextStyle r0 = r13.$textStyle
                                                                androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.TextFieldSizeKt.textFieldMinSize(r15, r0)
                                                                androidx.compose.ui.Modifier r0 = r13.$onPositionedModifier
                                                                androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                                androidx.compose.ui.Modifier r0 = r13.$magnifierModifier
                                                                androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                                androidx.compose.foundation.relocation.BringIntoViewRequester r0 = r13.$bringIntoViewRequester
                                                                androidx.compose.ui.Modifier r15 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.bringIntoViewRequester(r15, r0)
                                                                androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1
                                                                androidx.compose.foundation.text.selection.TextFieldSelectionManager r4 = r13.$manager
                                                                androidx.compose.foundation.text.LegacyTextFieldState r5 = r13.$state
                                                                boolean r6 = r13.$showHandleAndMagnifier
                                                                boolean r7 = r13.$readOnly
                                                                kotlin.jvm.functions.Function1<androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r8 = r13.$onTextLayout
                                                                androidx.compose.ui.text.input.TextFieldValue r9 = r13.$value
                                                                androidx.compose.ui.text.input.OffsetMapping r10 = r13.$offsetMapping
                                                                androidx.compose.ui.unit.Density r11 = r13.$density
                                                                int r12 = r13.$maxLines
                                                                r3 = r0
                                                                r3.<init>()
                                                                r3 = 54
                                                                r4 = 1412697320(0x54340ce8, float:3.09324258E12)
                                                                androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r2, r0, r14, r3)
                                                                kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
                                                                r2 = 48
                                                                androidx.compose.foundation.text.selection.SimpleLayoutKt.SimpleLayout(r15, r0, r14, r2, r1)
                                                                boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                                if (r14 == 0) goto Lce
                                                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                                                                goto Lce
                                                            Lcb:
                                                                r14.skipToGroupEnd()
                                                            Lce:
                                                                return
                                                            */
                                                            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.C03951.invoke(androidx.compose.runtime.Composer, int):void");
                                                        }
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                                                        invoke((Composer) obj3, ((Number) obj4).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i42) {
                                                        ComposerKt.sourceInformation(composer3, "C568@26920L5379,568@26906L5393:CoreTextField.kt#423gt5");
                                                        if (!composer3.shouldExecute((i42 & 3) != 2, i42 & 1)) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(-814563849, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:568)");
                                                        }
                                                        function342.invoke(ComposableLambdaKt.rememberComposableLambda(-44346382, true, new C03951(legacyTextFieldState, textStyle52, i412, i402, textFieldScrollerPosition6, textFieldValue, visualTransformation5, cursor2, drawBehind2, onGloballyPositioned2, modifier72, bringIntoViewRequester, textFieldSelectionManager, z262, z272, function172, offsetMapping, density), composer3, 54), composer3, 6);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer2, 54), composer2, 384);
                                                if (ComposerKt.isTraceInProgress()) {
                                                }
                                                imeOptions2 = imeOptions82;
                                                textStyle2 = textStyle3;
                                                mutableInteractionSource2 = mutableInteractionSource5;
                                                z5 = z252;
                                                function13 = function16;
                                                brush2 = brush3;
                                                i22 = i402;
                                                visualTransformation2 = visualTransformation5;
                                                z4 = z7;
                                                i23 = i24;
                                                keyboardActions2 = keyboardActions3;
                                                z6 = z8;
                                                function32 = function33;
                                                textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                                modifier2 = modifier6;
                                            }
                                        } else {
                                            imeOptions6 = imeOptions5;
                                        }
                                        i28 = i38;
                                        i29 = i36;
                                        if ((i36 & 48) != 32) {
                                            z10 = false;
                                            changedInstance = changedInstance9 | z10 | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(bringIntoViewRequester) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                            rememberedValue = startRestartGroup.rememberedValue();
                                            if (!changedInstance) {
                                            }
                                            final boolean z202 = z9;
                                            final boolean z212 = z8;
                                            final ImeOptions imeOptions72 = imeOptions6;
                                            rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda14
                                                public final Object invoke(Object obj3) {
                                                    Unit CoreTextField$lambda$15$lambda$14;
                                                    CoreTextField$lambda$15$lambda$14 = CoreTextFieldKt.CoreTextField$lambda$15$lambda$14(LegacyTextFieldState.this, z202, z212, textInputService3, textFieldValue, imeOptions72, offsetMapping, textFieldSelectionManager, coroutineScope, bringIntoViewRequester, (FocusState) obj3);
                                                    return CoreTextField$lambda$15$lambda$14;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion3, z9, focusRequester, mutableInteractionSource5, (Function1) rememberedValue);
                                            State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z9 || z8) ? false : true), startRestartGroup, 0);
                                            Unit unit2 = Unit.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213583572, "CC(remember):CoreTextField.kt#9igjgp");
                                            boolean changed42 = startRestartGroup.changed(rememberUpdatedState2) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService3) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                            if (i39 > 32) {
                                            }
                                            modifier5 = textFieldFocusModifier;
                                            if ((i29 & 48) != 32) {
                                            }
                                            z11 = true;
                                            z12 = z11 | changed42;
                                            rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (!z12) {
                                            }
                                            rememberedValue2 = (Function2) new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState2, textInputService3, textFieldSelectionManager, imeOptions6, null);
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
                                            Modifier.Companion companion422 = Modifier.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213551203, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                                            rememberedValue3 = startRestartGroup.rememberedValue();
                                            if (!changedInstance2) {
                                            }
                                            rememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda15
                                                public final Object invoke(Object obj3) {
                                                    Unit CoreTextField$lambda$19$lambda$18;
                                                    CoreTextField$lambda$19$lambda$18 = CoreTextFieldKt.CoreTextField$lambda$19$lambda$18(LegacyTextFieldState.this, ((Boolean) obj3).booleanValue());
                                                    return CoreTextField$lambda$19$lambda$18;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier updateSelectionTouchMode22 = SelectionGesturesKt.updateSelectionTouchMode(companion422, (Function1) rememberedValue3);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213547167, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i28 != 16384) | (i37 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                            rememberedValue4 = startRestartGroup.rememberedValue();
                                            if (!changedInstance3) {
                                            }
                                            final boolean z2222 = z8;
                                            final boolean z2322 = z9;
                                            rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1
                                                public final Object invoke(Object obj3) {
                                                    Unit CoreTextField$lambda$22$lambda$21;
                                                    CoreTextField$lambda$22$lambda$21 = CoreTextFieldKt.CoreTextField$lambda$22$lambda$21(LegacyTextFieldState.this, focusRequester, z2222, z2322, textFieldSelectionManager, offsetMapping, (Offset) obj3);
                                                    return CoreTextField$lambda$22$lambda$21;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue4);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier pointerHoverIcon$default22 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode22, mutableInteractionSource5, z9, (Function1) rememberedValue4), textFieldSelectionManager.getMouseSelectionObserver(), textFieldSelectionManager.getTouchSelectionObserver()), PointerIcon.INSTANCE.getText(), false, 2, null);
                                            Modifier.Companion companion522 = Modifier.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213506526, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i35 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                            rememberedValue5 = startRestartGroup.rememberedValue();
                                            if (changedInstance4) {
                                            }
                                            textFieldValue2 = textFieldValue;
                                            rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda2
                                                public final Object invoke(Object obj3) {
                                                    Unit CoreTextField$lambda$26$lambda$25;
                                                    CoreTextField$lambda$26$lambda$25 = CoreTextFieldKt.CoreTextField$lambda$26$lambda$25(LegacyTextFieldState.this, textFieldValue2, offsetMapping, (DrawScope) obj3);
                                                    return CoreTextField$lambda$26$lambda$25;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue5);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final Modifier drawBehind22 = DrawModifierKt.drawBehind(companion522, (Function1) rememberedValue5);
                                            Modifier.Companion companion622 = Modifier.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213484761, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance5 = (i37 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i35 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                            rememberedValue6 = startRestartGroup.rememberedValue();
                                            if (!changedInstance5) {
                                            }
                                            final boolean z2422 = z9;
                                            rememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda3
                                                public final Object invoke(Object obj3) {
                                                    Unit CoreTextField$lambda$30$lambda$29;
                                                    CoreTextField$lambda$30$lambda$29 = CoreTextFieldKt.CoreTextField$lambda$30$lambda$29(LegacyTextFieldState.this, z2422, windowInfo, textFieldSelectionManager, textFieldValue, offsetMapping, (LayoutCoordinates) obj3);
                                                    return CoreTextField$lambda$30$lambda$29;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue6);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final Modifier onGloballyPositioned22 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion622, (Function1) rememberedValue6);
                                            ModifierNodeElement coreTextFieldSemanticsModifier22 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState, z8, z9, visualTransformation5 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager, imeOptions6, focusRequester);
                                            final Modifier cursor22 = TextFieldCursorKt.cursor(Modifier.INSTANCE, legacyTextFieldState, textFieldValue, offsetMapping, brush3, (z9 || z8 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213415343, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance6 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                            rememberedValue7 = startRestartGroup.rememberedValue();
                                            if (!changedInstance6) {
                                            }
                                            rememberedValue7 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4
                                                public final Object invoke(Object obj3) {
                                                    DisposableEffectResult CoreTextField$lambda$33$lambda$32;
                                                    CoreTextField$lambda$33$lambda$32 = CoreTextFieldKt.CoreTextField$lambda$33$lambda$32(TextFieldSelectionManager.this, (DisposableEffectScope) obj3);
                                                    return CoreTextField$lambda$33$lambda$32;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue7);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue7, startRestartGroup, 0);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213412232, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance7 = (i35 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService3) | ((i39 <= 32 && startRestartGroup.changed(imeOptions6)) || (i29 & 48) == 32);
                                            rememberedValue8 = startRestartGroup.rememberedValue();
                                            if (!changedInstance7) {
                                            }
                                            rememberedValue8 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda5
                                                public final Object invoke(Object obj3) {
                                                    DisposableEffectResult CoreTextField$lambda$36$lambda$35;
                                                    CoreTextField$lambda$36$lambda$35 = CoreTextFieldKt.CoreTextField$lambda$36$lambda$35(LegacyTextFieldState.this, textInputService3, textFieldValue2, imeOptions6, (DisposableEffectScope) obj3);
                                                    return CoreTextField$lambda$36$lambda$35;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue8);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            EffectsKt.DisposableEffect(imeOptions6, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue8, startRestartGroup, (i29 >> 3) & 14);
                                            final int i4022 = i27;
                                            Modifier m1646textFieldKeyInput2WJ9YEU22 = TextFieldKeyInputKt.m1646textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, legacyTextFieldState, textFieldSelectionManager, textFieldValue, legacyTextFieldState.getOnValueChange(), !z8, i4022 != 1, offsetMapping, undoManager, imeOptions6.getImeAction-eUduSuo());
                                            if (KeyboardType.equals-impl0(imeOptions6.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getPassword-PjHm6EE())) {
                                            }
                                            Modifier.Companion companion722 = Modifier.INSTANCE;
                                            boolean CoreTextField$lambda$1622 = CoreTextField$lambda$16(rememberUpdatedState2);
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213374084, "CC(remember):CoreTextField.kt#9igjgp");
                                            ImeOptions imeOptions822 = imeOptions6;
                                            changed = startRestartGroup.changed(z13) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                            rememberedValue9 = startRestartGroup.rememberedValue();
                                            if (!changed) {
                                            }
                                            rememberedValue9 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6
                                                public final Object invoke() {
                                                    Unit CoreTextField$lambda$38$lambda$37;
                                                    CoreTextField$lambda$38$lambda$37 = CoreTextFieldKt.CoreTextField$lambda$38$lambda$37(z13, legacyPlatformTextInputServiceAdapter);
                                                    return CoreTextField$lambda$38$lambda$37;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue9);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier stylusHandwriting22 = StylusHandwritingKt.stylusHandwriting(companion722, CoreTextField$lambda$1622, z13, (Function0) rememberedValue9);
                                            ProvidableCompositionLocal<Color> localAutofillHighlightColor22 = AutofillHighlightKt.getLocalAutofillHighlightColor();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str);
                                            Object consume1022 = startRestartGroup.consume(localAutofillHighlightColor22);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            final long m4849unboximpl22 = ((Color) consume1022).m4849unboximpl();
                                            Modifier.Companion companion822 = Modifier.INSTANCE;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213339112, "CC(remember):CoreTextField.kt#9igjgp");
                                            changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changed(m4849unboximpl22);
                                            rememberedValue10 = startRestartGroup.rememberedValue();
                                            if (!changedInstance8) {
                                            }
                                            rememberedValue10 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda11
                                                public final Object invoke(Object obj3) {
                                                    Unit CoreTextField$lambda$40$lambda$39;
                                                    CoreTextField$lambda$40$lambda$39 = CoreTextFieldKt.CoreTextField$lambda$40$lambda$39(LegacyTextFieldState.this, m4849unboximpl22, (DrawScope) obj3);
                                                    return CoreTextField$lambda$40$lambda$39;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue10);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            Modifier addContextMenuComponents22 = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier6.then(DrawModifierKt.drawBehind(companion822, (Function1) rememberedValue10)), legacyPlatformTextInputServiceAdapter, legacyTextFieldState, textFieldSelectionManager).then(stylusHandwriting22).then(modifier5), legacyTextFieldState, focusManager), legacyTextFieldState, textFieldSelectionManager).then(m1646textFieldKeyInput2WJ9YEU22), textFieldScrollerPosition6, mutableInteractionSource5, z9).then(pointerHoverIcon$default22).then((Modifier) coreTextFieldSemanticsModifier22), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                                    invoke((LayoutCoordinates) obj3);
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(LayoutCoordinates layoutCoordinates) {
                                                    TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                    if (layoutResult != null) {
                                                        layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                    }
                                                }
                                            }), textFieldSelectionManager, coroutineScope);
                                            if (z9) {
                                            }
                                            if (!z14) {
                                            }
                                            final Modifier modifier722 = companion;
                                            final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3422 = function33;
                                            final TextStyle textStyle522 = textStyle3;
                                            final int i4122 = i24;
                                            boolean z2522 = z9;
                                            final boolean z2622 = z14;
                                            final boolean z2722 = z8;
                                            final Function1<? super TextLayoutResult, Unit> function1722 = function16;
                                            composer2 = startRestartGroup;
                                            CoreTextFieldRootBox(addContextMenuComponents22, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5

                                                /* JADX INFO: Access modifiers changed from: package-private */
                                                /* compiled from: CoreTextField.kt */
                                                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                                                /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1 */
                                                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                                public static final class C03951 implements Function2<Composer, Integer, Unit> {
                                                    final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
                                                    final /* synthetic */ Modifier $cursorModifier;
                                                    final /* synthetic */ Density $density;
                                                    final /* synthetic */ Modifier $drawModifier;
                                                    final /* synthetic */ Modifier $magnifierModifier;
                                                    final /* synthetic */ TextFieldSelectionManager $manager;
                                                    final /* synthetic */ int $maxLines;
                                                    final /* synthetic */ int $minLines;
                                                    final /* synthetic */ OffsetMapping $offsetMapping;
                                                    final /* synthetic */ Modifier $onPositionedModifier;
                                                    final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
                                                    final /* synthetic */ boolean $readOnly;
                                                    final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
                                                    final /* synthetic */ boolean $showHandleAndMagnifier;
                                                    final /* synthetic */ LegacyTextFieldState $state;
                                                    final /* synthetic */ TextStyle $textStyle;
                                                    final /* synthetic */ TextFieldValue $value;
                                                    final /* synthetic */ VisualTransformation $visualTransformation;

                                                    C03951(LegacyTextFieldState legacyTextFieldState, TextStyle textStyle, int i, int i2, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, Function1<? super TextLayoutResult, Unit> function1, OffsetMapping offsetMapping, Density density) {
                                                        this.$state = legacyTextFieldState;
                                                        this.$textStyle = textStyle;
                                                        this.$minLines = i;
                                                        this.$maxLines = i2;
                                                        this.$scrollerPosition = textFieldScrollerPosition;
                                                        this.$value = textFieldValue;
                                                        this.$visualTransformation = visualTransformation;
                                                        this.$cursorModifier = modifier;
                                                        this.$drawModifier = modifier2;
                                                        this.$onPositionedModifier = modifier3;
                                                        this.$magnifierModifier = modifier4;
                                                        this.$bringIntoViewRequester = bringIntoViewRequester;
                                                        this.$manager = textFieldSelectionManager;
                                                        this.$showHandleAndMagnifier = z;
                                                        this.$readOnly = z2;
                                                        this.$onTextLayout = function1;
                                                        this.$offsetMapping = offsetMapping;
                                                        this.$density = density;
                                                    }

                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    /*  JADX ERROR: Method code generation error
                                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0066: CONSTRUCTOR (r7v1 'rememberedValue' java.lang.Object) = (r6v1 'legacyTextFieldState' androidx.compose.foundation.text.LegacyTextFieldState A[DONT_INLINE]) A[MD:(androidx.compose.foundation.text.LegacyTextFieldState):void (m)] (LINE:583) call: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0.<init>(androidx.compose.foundation.text.LegacyTextFieldState):void type: CONSTRUCTOR in method: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1.invoke(androidx.compose.runtime.Composer, int):void, file: /data/user/work/trae_cn3_decoded/build/apk/classes.dex
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                        	... 19 more
                                                        */
                                                    public final void invoke(androidx.compose.runtime.Composer r14, int r15) {
                                                        /*
                                                            r13 = this;
                                                            java.lang.String r0 = "C582@27771L22,591@28158L4131,591@28122L4167:CoreTextField.kt#423gt5"
                                                            androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
                                                            r0 = r15 & 3
                                                            r1 = 0
                                                            r2 = 1
                                                            r3 = 2
                                                            if (r0 == r3) goto Le
                                                            r0 = r2
                                                            goto Lf
                                                        Le:
                                                            r0 = r1
                                                        Lf:
                                                            r4 = r15 & 1
                                                            boolean r0 = r14.shouldExecute(r0, r4)
                                                            if (r0 == 0) goto Lcb
                                                            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                            if (r0 == 0) goto L26
                                                            r0 = -1
                                                            java.lang.String r4 = "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:571)"
                                                            r5 = -44346382(0xfffffffffd5b53f2, float:-1.822105E37)
                                                            androidx.compose.runtime.ComposerKt.traceEventStart(r5, r15, r0, r4)
                                                        L26:
                                                            androidx.compose.ui.Modifier$Companion r15 = androidx.compose.p002ui.Modifier.INSTANCE
                                                            androidx.compose.ui.Modifier r15 = (androidx.compose.p002ui.Modifier) r15
                                                            androidx.compose.foundation.text.LegacyTextFieldState r0 = r13.$state
                                                            float r0 = r0.m1561getMinHeightForSingleLineFieldD9Ej5fM()
                                                            r4 = 0
                                                            r5 = 0
                                                            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.m1108heightInVpY3zN4$default(r15, r0, r4, r3, r5)
                                                            androidx.compose.ui.text.TextStyle r0 = r13.$textStyle
                                                            int r3 = r13.$minLines
                                                            int r4 = r13.$maxLines
                                                            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.HeightInLinesModifierKt.heightInLines(r15, r0, r3, r4)
                                                            androidx.compose.foundation.text.TextFieldScrollerPosition r0 = r13.$scrollerPosition
                                                            androidx.compose.ui.text.input.TextFieldValue r3 = r13.$value
                                                            androidx.compose.ui.text.input.VisualTransformation r4 = r13.$visualTransformation
                                                            r5 = 332827112(0x13d689e8, float:5.415718E-27)
                                                            java.lang.String r6 = "CC(remember):CoreTextField.kt#9igjgp"
                                                            androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r6)
                                                            androidx.compose.foundation.text.LegacyTextFieldState r5 = r13.$state
                                                            boolean r5 = r14.changedInstance(r5)
                                                            androidx.compose.foundation.text.LegacyTextFieldState r6 = r13.$state
                                                            java.lang.Object r7 = r14.rememberedValue()
                                                            if (r5 != 0) goto L64
                                                            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.INSTANCE
                                                            java.lang.Object r5 = r5.getEmpty()
                                                            if (r7 != r5) goto L6c
                                                        L64:
                                                            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0 r7 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0
                                                            r7.<init>(r6)
                                                            r14.updateRememberedValue(r7)
                                                        L6c:
                                                            kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
                                                            androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
                                                            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.TextFieldScroll_androidKt.textFieldScroll(r15, r0, r3, r4, r7)
                                                            androidx.compose.ui.Modifier r0 = r13.$cursorModifier
                                                            androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                            androidx.compose.ui.Modifier r0 = r13.$drawModifier
                                                            androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                            androidx.compose.ui.text.TextStyle r0 = r13.$textStyle
                                                            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.TextFieldSizeKt.textFieldMinSize(r15, r0)
                                                            androidx.compose.ui.Modifier r0 = r13.$onPositionedModifier
                                                            androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                            androidx.compose.ui.Modifier r0 = r13.$magnifierModifier
                                                            androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                            androidx.compose.foundation.relocation.BringIntoViewRequester r0 = r13.$bringIntoViewRequester
                                                            androidx.compose.ui.Modifier r15 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.bringIntoViewRequester(r15, r0)
                                                            androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1
                                                            androidx.compose.foundation.text.selection.TextFieldSelectionManager r4 = r13.$manager
                                                            androidx.compose.foundation.text.LegacyTextFieldState r5 = r13.$state
                                                            boolean r6 = r13.$showHandleAndMagnifier
                                                            boolean r7 = r13.$readOnly
                                                            kotlin.jvm.functions.Function1<androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r8 = r13.$onTextLayout
                                                            androidx.compose.ui.text.input.TextFieldValue r9 = r13.$value
                                                            androidx.compose.ui.text.input.OffsetMapping r10 = r13.$offsetMapping
                                                            androidx.compose.ui.unit.Density r11 = r13.$density
                                                            int r12 = r13.$maxLines
                                                            r3 = r0
                                                            r3.<init>()
                                                            r3 = 54
                                                            r4 = 1412697320(0x54340ce8, float:3.09324258E12)
                                                            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r2, r0, r14, r3)
                                                            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
                                                            r2 = 48
                                                            androidx.compose.foundation.text.selection.SimpleLayoutKt.SimpleLayout(r15, r0, r14, r2, r1)
                                                            boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                            if (r14 == 0) goto Lce
                                                            androidx.compose.runtime.ComposerKt.traceEventEnd()
                                                            goto Lce
                                                        Lcb:
                                                            r14.skipToGroupEnd()
                                                        Lce:
                                                            return
                                                        */
                                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.C03951.invoke(androidx.compose.runtime.Composer, int):void");
                                                    }
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                                                    invoke((Composer) obj3, ((Number) obj4).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                public final void invoke(Composer composer3, int i42) {
                                                    ComposerKt.sourceInformation(composer3, "C568@26920L5379,568@26906L5393:CoreTextField.kt#423gt5");
                                                    if (!composer3.shouldExecute((i42 & 3) != 2, i42 & 1)) {
                                                        composer3.skipToGroupEnd();
                                                        return;
                                                    }
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventStart(-814563849, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:568)");
                                                    }
                                                    function3422.invoke(ComposableLambdaKt.rememberComposableLambda(-44346382, true, new C03951(legacyTextFieldState, textStyle522, i4122, i4022, textFieldScrollerPosition6, textFieldValue, visualTransformation5, cursor22, drawBehind22, onGloballyPositioned22, modifier722, bringIntoViewRequester, textFieldSelectionManager, z2622, z2722, function1722, offsetMapping, density), composer3, 54), composer3, 6);
                                                    if (ComposerKt.isTraceInProgress()) {
                                                        ComposerKt.traceEventEnd();
                                                    }
                                                }
                                            }, composer2, 54), composer2, 384);
                                            if (ComposerKt.isTraceInProgress()) {
                                            }
                                            imeOptions2 = imeOptions822;
                                            textStyle2 = textStyle3;
                                            mutableInteractionSource2 = mutableInteractionSource5;
                                            z5 = z2522;
                                            function13 = function16;
                                            brush2 = brush3;
                                            i22 = i4022;
                                            visualTransformation2 = visualTransformation5;
                                            z4 = z7;
                                            i23 = i24;
                                            keyboardActions2 = keyboardActions3;
                                            z6 = z8;
                                            function32 = function33;
                                            textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                            modifier2 = modifier6;
                                        }
                                        z10 = true;
                                        changedInstance = changedInstance9 | z10 | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(coroutineScope) | startRestartGroup.changedInstance(bringIntoViewRequester) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                        rememberedValue = startRestartGroup.rememberedValue();
                                        if (!changedInstance) {
                                        }
                                        final boolean z2022 = z9;
                                        final boolean z2122 = z8;
                                        final ImeOptions imeOptions722 = imeOptions6;
                                        rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda14
                                            public final Object invoke(Object obj3) {
                                                Unit CoreTextField$lambda$15$lambda$14;
                                                CoreTextField$lambda$15$lambda$14 = CoreTextFieldKt.CoreTextField$lambda$15$lambda$14(LegacyTextFieldState.this, z2022, z2122, textInputService3, textFieldValue, imeOptions722, offsetMapping, textFieldSelectionManager, coroutineScope, bringIntoViewRequester, (FocusState) obj3);
                                                return CoreTextField$lambda$15$lambda$14;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        textFieldFocusModifier = TextFieldGestureModifiersKt.textFieldFocusModifier(companion3, z9, focusRequester, mutableInteractionSource5, (Function1) rememberedValue);
                                        State rememberUpdatedState22 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf((z9 || z8) ? false : true), startRestartGroup, 0);
                                        Unit unit22 = Unit.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213583572, "CC(remember):CoreTextField.kt#9igjgp");
                                        boolean changed422 = startRestartGroup.changed(rememberUpdatedState22) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService3) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                        if (i39 > 32) {
                                        }
                                        modifier5 = textFieldFocusModifier;
                                        if ((i29 & 48) != 32) {
                                        }
                                        z11 = true;
                                        z12 = z11 | changed422;
                                        rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (!z12) {
                                        }
                                        rememberedValue2 = (Function2) new CoreTextFieldKt$CoreTextField$2$1(legacyTextFieldState, rememberUpdatedState22, textInputService3, textFieldSelectionManager, imeOptions6, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        EffectsKt.LaunchedEffect(unit22, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) rememberedValue2, startRestartGroup, 6);
                                        Modifier.Companion companion4222 = Modifier.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213551203, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance2 = startRestartGroup.changedInstance(legacyTextFieldState);
                                        rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (!changedInstance2) {
                                        }
                                        rememberedValue3 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda15
                                            public final Object invoke(Object obj3) {
                                                Unit CoreTextField$lambda$19$lambda$18;
                                                CoreTextField$lambda$19$lambda$18 = CoreTextFieldKt.CoreTextField$lambda$19$lambda$18(LegacyTextFieldState.this, ((Boolean) obj3).booleanValue());
                                                return CoreTextField$lambda$19$lambda$18;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier updateSelectionTouchMode222 = SelectionGesturesKt.updateSelectionTouchMode(companion4222, (Function1) rememberedValue3);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213547167, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance3 = startRestartGroup.changedInstance(legacyTextFieldState) | (i28 != 16384) | (i37 != 2048) | startRestartGroup.changedInstance(offsetMapping) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                        rememberedValue4 = startRestartGroup.rememberedValue();
                                        if (!changedInstance3) {
                                        }
                                        final boolean z22222 = z8;
                                        final boolean z23222 = z9;
                                        rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj3) {
                                                Unit CoreTextField$lambda$22$lambda$21;
                                                CoreTextField$lambda$22$lambda$21 = CoreTextFieldKt.CoreTextField$lambda$22$lambda$21(LegacyTextFieldState.this, focusRequester, z22222, z23222, textFieldSelectionManager, offsetMapping, (Offset) obj3);
                                                return CoreTextField$lambda$22$lambda$21;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier pointerHoverIcon$default222 = PointerIconKt.pointerHoverIcon$default(SelectionGesturesKt.selectionGestureInput(TextFieldPressGestureFilterKt.tapPressTextFieldModifier(updateSelectionTouchMode222, mutableInteractionSource5, z9, (Function1) rememberedValue4), textFieldSelectionManager.getMouseSelectionObserver(), textFieldSelectionManager.getTouchSelectionObserver()), PointerIcon.INSTANCE.getText(), false, 2, null);
                                        Modifier.Companion companion5222 = Modifier.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213506526, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance4 = startRestartGroup.changedInstance(legacyTextFieldState) | (i35 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                        rememberedValue5 = startRestartGroup.rememberedValue();
                                        if (changedInstance4) {
                                        }
                                        textFieldValue2 = textFieldValue;
                                        rememberedValue5 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda2
                                            public final Object invoke(Object obj3) {
                                                Unit CoreTextField$lambda$26$lambda$25;
                                                CoreTextField$lambda$26$lambda$25 = CoreTextFieldKt.CoreTextField$lambda$26$lambda$25(LegacyTextFieldState.this, textFieldValue2, offsetMapping, (DrawScope) obj3);
                                                return CoreTextField$lambda$26$lambda$25;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue5);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final Modifier drawBehind222 = DrawModifierKt.drawBehind(companion5222, (Function1) rememberedValue5);
                                        Modifier.Companion companion6222 = Modifier.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213484761, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance5 = (i37 != 2048) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changed(windowInfo) | startRestartGroup.changedInstance(textFieldSelectionManager) | (i35 != 4) | startRestartGroup.changedInstance(offsetMapping);
                                        rememberedValue6 = startRestartGroup.rememberedValue();
                                        if (!changedInstance5) {
                                        }
                                        final boolean z24222 = z9;
                                        rememberedValue6 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda3
                                            public final Object invoke(Object obj3) {
                                                Unit CoreTextField$lambda$30$lambda$29;
                                                CoreTextField$lambda$30$lambda$29 = CoreTextFieldKt.CoreTextField$lambda$30$lambda$29(LegacyTextFieldState.this, z24222, windowInfo, textFieldSelectionManager, textFieldValue, offsetMapping, (LayoutCoordinates) obj3);
                                                return CoreTextField$lambda$30$lambda$29;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue6);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final Modifier onGloballyPositioned222 = OnGloballyPositionedModifierKt.onGloballyPositioned(companion6222, (Function1) rememberedValue6);
                                        ModifierNodeElement coreTextFieldSemanticsModifier222 = new CoreTextFieldSemanticsModifier(transformedText, textFieldValue, legacyTextFieldState, z8, z9, visualTransformation5 instanceof PasswordVisualTransformation, offsetMapping, textFieldSelectionManager, imeOptions6, focusRequester);
                                        final Modifier cursor222 = TextFieldCursorKt.cursor(Modifier.INSTANCE, legacyTextFieldState, textFieldValue, offsetMapping, brush3, (z9 || z8 || !windowInfo.isWindowFocused() || legacyTextFieldState.hasHighlight()) ? false : true);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213415343, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance6 = startRestartGroup.changedInstance(textFieldSelectionManager);
                                        rememberedValue7 = startRestartGroup.rememberedValue();
                                        if (!changedInstance6) {
                                        }
                                        rememberedValue7 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda4
                                            public final Object invoke(Object obj3) {
                                                DisposableEffectResult CoreTextField$lambda$33$lambda$32;
                                                CoreTextField$lambda$33$lambda$32 = CoreTextFieldKt.CoreTextField$lambda$33$lambda$32(TextFieldSelectionManager.this, (DisposableEffectScope) obj3);
                                                return CoreTextField$lambda$33$lambda$32;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue7);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        EffectsKt.DisposableEffect(textFieldSelectionManager, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue7, startRestartGroup, 0);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213412232, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance7 = (i35 != 4) | startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changedInstance(textInputService3) | ((i39 <= 32 && startRestartGroup.changed(imeOptions6)) || (i29 & 48) == 32);
                                        rememberedValue8 = startRestartGroup.rememberedValue();
                                        if (!changedInstance7) {
                                        }
                                        rememberedValue8 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda5
                                            public final Object invoke(Object obj3) {
                                                DisposableEffectResult CoreTextField$lambda$36$lambda$35;
                                                CoreTextField$lambda$36$lambda$35 = CoreTextFieldKt.CoreTextField$lambda$36$lambda$35(LegacyTextFieldState.this, textInputService3, textFieldValue2, imeOptions6, (DisposableEffectScope) obj3);
                                                return CoreTextField$lambda$36$lambda$35;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue8);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        EffectsKt.DisposableEffect(imeOptions6, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue8, startRestartGroup, (i29 >> 3) & 14);
                                        final int i40222 = i27;
                                        Modifier m1646textFieldKeyInput2WJ9YEU222 = TextFieldKeyInputKt.m1646textFieldKeyInput2WJ9YEU(Modifier.INSTANCE, legacyTextFieldState, textFieldSelectionManager, textFieldValue, legacyTextFieldState.getOnValueChange(), !z8, i40222 != 1, offsetMapping, undoManager, imeOptions6.getImeAction-eUduSuo());
                                        if (KeyboardType.equals-impl0(imeOptions6.getKeyboardType-PjHm6EE(), KeyboardType.Companion.getPassword-PjHm6EE())) {
                                        }
                                        Modifier.Companion companion7222 = Modifier.INSTANCE;
                                        boolean CoreTextField$lambda$16222 = CoreTextField$lambda$16(rememberUpdatedState22);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213374084, "CC(remember):CoreTextField.kt#9igjgp");
                                        ImeOptions imeOptions8222 = imeOptions6;
                                        changed = startRestartGroup.changed(z13) | startRestartGroup.changedInstance(legacyPlatformTextInputServiceAdapter);
                                        rememberedValue9 = startRestartGroup.rememberedValue();
                                        if (!changed) {
                                        }
                                        rememberedValue9 = new Function0() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda6
                                            public final Object invoke() {
                                                Unit CoreTextField$lambda$38$lambda$37;
                                                CoreTextField$lambda$38$lambda$37 = CoreTextFieldKt.CoreTextField$lambda$38$lambda$37(z13, legacyPlatformTextInputServiceAdapter);
                                                return CoreTextField$lambda$38$lambda$37;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue9);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier stylusHandwriting222 = StylusHandwritingKt.stylusHandwriting(companion7222, CoreTextField$lambda$16222, z13, (Function0) rememberedValue9);
                                        ProvidableCompositionLocal<Color> localAutofillHighlightColor222 = AutofillHighlightKt.getLocalAutofillHighlightColor();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, str);
                                        Object consume10222 = startRestartGroup.consume(localAutofillHighlightColor222);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final long m4849unboximpl222 = ((Color) consume10222).m4849unboximpl();
                                        Modifier.Companion companion8222 = Modifier.INSTANCE;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -213339112, "CC(remember):CoreTextField.kt#9igjgp");
                                        changedInstance8 = startRestartGroup.changedInstance(legacyTextFieldState) | startRestartGroup.changed(m4849unboximpl222);
                                        rememberedValue10 = startRestartGroup.rememberedValue();
                                        if (!changedInstance8) {
                                        }
                                        rememberedValue10 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda11
                                            public final Object invoke(Object obj3) {
                                                Unit CoreTextField$lambda$40$lambda$39;
                                                CoreTextField$lambda$40$lambda$39 = CoreTextFieldKt.CoreTextField$lambda$40$lambda$39(LegacyTextFieldState.this, m4849unboximpl222, (DrawScope) obj3);
                                                return CoreTextField$lambda$40$lambda$39;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue10);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        Modifier addContextMenuComponents222 = addContextMenuComponents(OnGloballyPositionedModifierKt.onGloballyPositioned(TextFieldScrollKt.textFieldScrollable(previewKeyEventToDeselectOnBack(TextFieldFocusModifier_androidKt.interceptDPadAndMoveFocus(LegacyAdaptingPlatformTextInputModifierNodeKt.legacyTextInputAdapter(modifier6.then(DrawModifierKt.drawBehind(companion8222, (Function1) rememberedValue10)), legacyPlatformTextInputServiceAdapter, legacyTextFieldState, textFieldSelectionManager).then(stylusHandwriting222).then(modifier5), legacyTextFieldState, focusManager), legacyTextFieldState, textFieldSelectionManager).then(m1646textFieldKeyInput2WJ9YEU222), textFieldScrollerPosition6, mutableInteractionSource5, z9).then(pointerHoverIcon$default222).then((Modifier) coreTextFieldSemanticsModifier222), new Function1<LayoutCoordinates, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$decorationBoxModifier$1
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                                                invoke((LayoutCoordinates) obj3);
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(LayoutCoordinates layoutCoordinates) {
                                                TextLayoutResultProxy layoutResult = LegacyTextFieldState.this.getLayoutResult();
                                                if (layoutResult != null) {
                                                    layoutResult.setDecorationBoxCoordinates(layoutCoordinates);
                                                }
                                            }
                                        }), textFieldSelectionManager, coroutineScope);
                                        if (z9) {
                                        }
                                        if (!z14) {
                                        }
                                        final Modifier modifier7222 = companion;
                                        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function34222 = function33;
                                        final TextStyle textStyle5222 = textStyle3;
                                        final int i41222 = i24;
                                        boolean z25222 = z9;
                                        final boolean z26222 = z14;
                                        final boolean z27222 = z8;
                                        final Function1<? super TextLayoutResult, Unit> function17222 = function16;
                                        composer2 = startRestartGroup;
                                        CoreTextFieldRootBox(addContextMenuComponents222, textFieldSelectionManager, ComposableLambdaKt.rememberComposableLambda(-814563849, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* compiled from: CoreTextField.kt */
                                            @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                                            /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1 */
                                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                            public static final class C03951 implements Function2<Composer, Integer, Unit> {
                                                final /* synthetic */ BringIntoViewRequester $bringIntoViewRequester;
                                                final /* synthetic */ Modifier $cursorModifier;
                                                final /* synthetic */ Density $density;
                                                final /* synthetic */ Modifier $drawModifier;
                                                final /* synthetic */ Modifier $magnifierModifier;
                                                final /* synthetic */ TextFieldSelectionManager $manager;
                                                final /* synthetic */ int $maxLines;
                                                final /* synthetic */ int $minLines;
                                                final /* synthetic */ OffsetMapping $offsetMapping;
                                                final /* synthetic */ Modifier $onPositionedModifier;
                                                final /* synthetic */ Function1<TextLayoutResult, Unit> $onTextLayout;
                                                final /* synthetic */ boolean $readOnly;
                                                final /* synthetic */ TextFieldScrollerPosition $scrollerPosition;
                                                final /* synthetic */ boolean $showHandleAndMagnifier;
                                                final /* synthetic */ LegacyTextFieldState $state;
                                                final /* synthetic */ TextStyle $textStyle;
                                                final /* synthetic */ TextFieldValue $value;
                                                final /* synthetic */ VisualTransformation $visualTransformation;

                                                C03951(LegacyTextFieldState legacyTextFieldState, TextStyle textStyle, int i, int i2, TextFieldScrollerPosition textFieldScrollerPosition, TextFieldValue textFieldValue, VisualTransformation visualTransformation, Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4, BringIntoViewRequester bringIntoViewRequester, TextFieldSelectionManager textFieldSelectionManager, boolean z, boolean z2, Function1<? super TextLayoutResult, Unit> function1, OffsetMapping offsetMapping, Density density) {
                                                    this.$state = legacyTextFieldState;
                                                    this.$textStyle = textStyle;
                                                    this.$minLines = i;
                                                    this.$maxLines = i2;
                                                    this.$scrollerPosition = textFieldScrollerPosition;
                                                    this.$value = textFieldValue;
                                                    this.$visualTransformation = visualTransformation;
                                                    this.$cursorModifier = modifier;
                                                    this.$drawModifier = modifier2;
                                                    this.$onPositionedModifier = modifier3;
                                                    this.$magnifierModifier = modifier4;
                                                    this.$bringIntoViewRequester = bringIntoViewRequester;
                                                    this.$manager = textFieldSelectionManager;
                                                    this.$showHandleAndMagnifier = z;
                                                    this.$readOnly = z2;
                                                    this.$onTextLayout = function1;
                                                    this.$offsetMapping = offsetMapping;
                                                    this.$density = density;
                                                }

                                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                                    return Unit.INSTANCE;
                                                }

                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0066: CONSTRUCTOR (r7v1 'rememberedValue' java.lang.Object) = (r6v1 'legacyTextFieldState' androidx.compose.foundation.text.LegacyTextFieldState A[DONT_INLINE]) A[MD:(androidx.compose.foundation.text.LegacyTextFieldState):void (m)] (LINE:583) call: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0.<init>(androidx.compose.foundation.text.LegacyTextFieldState):void type: CONSTRUCTOR in method: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.1.invoke(androidx.compose.runtime.Composer, int):void, file: /data/user/work/trae_cn3_decoded/build/apk/classes.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                                    	... 18 more
                                                    */
                                                public final void invoke(androidx.compose.runtime.Composer r14, int r15) {
                                                    /*
                                                        r13 = this;
                                                        java.lang.String r0 = "C582@27771L22,591@28158L4131,591@28122L4167:CoreTextField.kt#423gt5"
                                                        androidx.compose.runtime.ComposerKt.sourceInformation(r14, r0)
                                                        r0 = r15 & 3
                                                        r1 = 0
                                                        r2 = 1
                                                        r3 = 2
                                                        if (r0 == r3) goto Le
                                                        r0 = r2
                                                        goto Lf
                                                    Le:
                                                        r0 = r1
                                                    Lf:
                                                        r4 = r15 & 1
                                                        boolean r0 = r14.shouldExecute(r0, r4)
                                                        if (r0 == 0) goto Lcb
                                                        boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                        if (r0 == 0) goto L26
                                                        r0 = -1
                                                        java.lang.String r4 = "androidx.compose.foundation.text.CoreTextField.<anonymous>.<anonymous> (CoreTextField.kt:571)"
                                                        r5 = -44346382(0xfffffffffd5b53f2, float:-1.822105E37)
                                                        androidx.compose.runtime.ComposerKt.traceEventStart(r5, r15, r0, r4)
                                                    L26:
                                                        androidx.compose.ui.Modifier$Companion r15 = androidx.compose.p002ui.Modifier.INSTANCE
                                                        androidx.compose.ui.Modifier r15 = (androidx.compose.p002ui.Modifier) r15
                                                        androidx.compose.foundation.text.LegacyTextFieldState r0 = r13.$state
                                                        float r0 = r0.m1561getMinHeightForSingleLineFieldD9Ej5fM()
                                                        r4 = 0
                                                        r5 = 0
                                                        androidx.compose.ui.Modifier r15 = androidx.compose.foundation.layout.SizeKt.m1108heightInVpY3zN4$default(r15, r0, r4, r3, r5)
                                                        androidx.compose.ui.text.TextStyle r0 = r13.$textStyle
                                                        int r3 = r13.$minLines
                                                        int r4 = r13.$maxLines
                                                        androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.HeightInLinesModifierKt.heightInLines(r15, r0, r3, r4)
                                                        androidx.compose.foundation.text.TextFieldScrollerPosition r0 = r13.$scrollerPosition
                                                        androidx.compose.ui.text.input.TextFieldValue r3 = r13.$value
                                                        androidx.compose.ui.text.input.VisualTransformation r4 = r13.$visualTransformation
                                                        r5 = 332827112(0x13d689e8, float:5.415718E-27)
                                                        java.lang.String r6 = "CC(remember):CoreTextField.kt#9igjgp"
                                                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerStart(r14, r5, r6)
                                                        androidx.compose.foundation.text.LegacyTextFieldState r5 = r13.$state
                                                        boolean r5 = r14.changedInstance(r5)
                                                        androidx.compose.foundation.text.LegacyTextFieldState r6 = r13.$state
                                                        java.lang.Object r7 = r14.rememberedValue()
                                                        if (r5 != 0) goto L64
                                                        androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.INSTANCE
                                                        java.lang.Object r5 = r5.getEmpty()
                                                        if (r7 != r5) goto L6c
                                                    L64:
                                                        androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0 r7 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$$ExternalSyntheticLambda0
                                                        r7.<init>(r6)
                                                        r14.updateRememberedValue(r7)
                                                    L6c:
                                                        kotlin.jvm.functions.Function0 r7 = (kotlin.jvm.functions.Function0) r7
                                                        androidx.compose.runtime.ComposerKt.sourceInformationMarkerEnd(r14)
                                                        androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.TextFieldScroll_androidKt.textFieldScroll(r15, r0, r3, r4, r7)
                                                        androidx.compose.ui.Modifier r0 = r13.$cursorModifier
                                                        androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                        androidx.compose.ui.Modifier r0 = r13.$drawModifier
                                                        androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                        androidx.compose.ui.text.TextStyle r0 = r13.$textStyle
                                                        androidx.compose.ui.Modifier r15 = androidx.compose.foundation.text.TextFieldSizeKt.textFieldMinSize(r15, r0)
                                                        androidx.compose.ui.Modifier r0 = r13.$onPositionedModifier
                                                        androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                        androidx.compose.ui.Modifier r0 = r13.$magnifierModifier
                                                        androidx.compose.ui.Modifier r15 = r15.then(r0)
                                                        androidx.compose.foundation.relocation.BringIntoViewRequester r0 = r13.$bringIntoViewRequester
                                                        androidx.compose.ui.Modifier r15 = androidx.compose.foundation.relocation.BringIntoViewRequesterKt.bringIntoViewRequester(r15, r0)
                                                        androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1 r0 = new androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5$1$1
                                                        androidx.compose.foundation.text.selection.TextFieldSelectionManager r4 = r13.$manager
                                                        androidx.compose.foundation.text.LegacyTextFieldState r5 = r13.$state
                                                        boolean r6 = r13.$showHandleAndMagnifier
                                                        boolean r7 = r13.$readOnly
                                                        kotlin.jvm.functions.Function1<androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r8 = r13.$onTextLayout
                                                        androidx.compose.ui.text.input.TextFieldValue r9 = r13.$value
                                                        androidx.compose.ui.text.input.OffsetMapping r10 = r13.$offsetMapping
                                                        androidx.compose.ui.unit.Density r11 = r13.$density
                                                        int r12 = r13.$maxLines
                                                        r3 = r0
                                                        r3.<init>()
                                                        r3 = 54
                                                        r4 = 1412697320(0x54340ce8, float:3.09324258E12)
                                                        androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.rememberComposableLambda(r4, r2, r0, r14, r3)
                                                        kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
                                                        r2 = 48
                                                        androidx.compose.foundation.text.selection.SimpleLayoutKt.SimpleLayout(r15, r0, r14, r2, r1)
                                                        boolean r14 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                                        if (r14 == 0) goto Lce
                                                        androidx.compose.runtime.ComposerKt.traceEventEnd()
                                                        goto Lce
                                                    Lcb:
                                                        r14.skipToGroupEnd()
                                                    Lce:
                                                        return
                                                    */
                                                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$5.C03951.invoke(androidx.compose.runtime.Composer, int):void");
                                                }
                                            }

                                            public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                                                invoke((Composer) obj3, ((Number) obj4).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer3, int i42) {
                                                ComposerKt.sourceInformation(composer3, "C568@26920L5379,568@26906L5393:CoreTextField.kt#423gt5");
                                                if (!composer3.shouldExecute((i42 & 3) != 2, i42 & 1)) {
                                                    composer3.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-814563849, i42, -1, "androidx.compose.foundation.text.CoreTextField.<anonymous> (CoreTextField.kt:568)");
                                                }
                                                function34222.invoke(ComposableLambdaKt.rememberComposableLambda(-44346382, true, new C03951(legacyTextFieldState, textStyle5222, i41222, i40222, textFieldScrollerPosition6, textFieldValue, visualTransformation5, cursor222, drawBehind222, onGloballyPositioned222, modifier7222, bringIntoViewRequester, textFieldSelectionManager, z26222, z27222, function17222, offsetMapping, density), composer3, 54), composer3, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, composer2, 54), composer2, 384);
                                        if (ComposerKt.isTraceInProgress()) {
                                        }
                                        imeOptions2 = imeOptions8222;
                                        textStyle2 = textStyle3;
                                        mutableInteractionSource2 = mutableInteractionSource5;
                                        z5 = z25222;
                                        function13 = function16;
                                        brush2 = brush3;
                                        i22 = i40222;
                                        visualTransformation2 = visualTransformation5;
                                        z4 = z7;
                                        i23 = i24;
                                        keyboardActions2 = keyboardActions3;
                                        z6 = z8;
                                        function32 = function33;
                                        textFieldScrollerPosition2 = textFieldScrollerPosition3;
                                        modifier2 = modifier6;
                                    } else {
                                        composer2 = startRestartGroup;
                                        composer2.skipToGroupEnd();
                                        modifier2 = modifier;
                                        textStyle2 = textStyle;
                                        visualTransformation2 = visualTransformation;
                                        function13 = function12;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush2 = brush;
                                        z4 = z;
                                        i22 = i;
                                        i23 = i2;
                                        imeOptions2 = imeOptions;
                                        keyboardActions2 = keyboardActions;
                                        z5 = z2;
                                        z6 = z3;
                                        function32 = function3;
                                        textFieldScrollerPosition2 = textFieldScrollerPosition;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda12
                                            public final Object invoke(Object obj3, Object obj4) {
                                                Unit CoreTextField$lambda$41;
                                                CoreTextField$lambda$41 = CoreTextFieldKt.CoreTextField$lambda$41(textFieldValue, function1, modifier2, textStyle2, visualTransformation2, function13, mutableInteractionSource2, brush2, z4, i22, i23, imeOptions2, keyboardActions2, z5, z6, function32, textFieldScrollerPosition2, i3, i4, i5, (Composer) obj3, ((Integer) obj4).intValue());
                                                return CoreTextField$lambda$41;
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                i20 = i5 & Fields.CompositingStrategy;
                                if (i20 != 0) {
                                }
                                i21 = i5 & 65536;
                                if (i21 != 0) {
                                }
                                if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (599187 & i16) != 599186, i6 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                }
                            }
                            i19 = i5 & Fields.Clip;
                            if (i19 == 0) {
                            }
                            i20 = i5 & Fields.CompositingStrategy;
                            if (i20 != 0) {
                            }
                            i21 = i5 & 65536;
                            if (i21 != 0) {
                            }
                            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (599187 & i16) != 599186, i6 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i18 = i5 & Fields.Shape;
                        if (i18 != 0) {
                        }
                        i19 = i5 & Fields.Clip;
                        if (i19 == 0) {
                        }
                        i20 = i5 & Fields.CompositingStrategy;
                        if (i20 != 0) {
                        }
                        i21 = i5 & 65536;
                        if (i21 != 0) {
                        }
                        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (599187 & i16) != 599186, i6 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i9 = i5 & 32;
                    if (i9 == 0) {
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                    }
                    i11 = i5 & Fields.SpotShadowColor;
                    if (i11 == 0) {
                    }
                    i12 = i5 & Fields.RotationX;
                    if (i12 == 0) {
                    }
                    i13 = i5 & Fields.RotationY;
                    if (i13 == 0) {
                    }
                    i14 = i5 & Fields.RotationZ;
                    if (i14 == 0) {
                    }
                    if ((i4 & 48) == 0) {
                    }
                    i16 = i15;
                    i17 = i5 & Fields.TransformOrigin;
                    if (i17 == 0) {
                    }
                    i18 = i5 & Fields.Shape;
                    if (i18 != 0) {
                    }
                    i19 = i5 & Fields.Clip;
                    if (i19 == 0) {
                    }
                    i20 = i5 & Fields.CompositingStrategy;
                    if (i20 != 0) {
                    }
                    i21 = i5 & 65536;
                    if (i21 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (599187 & i16) != 599186, i6 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i8 = i5 & 16;
                if (i8 != 0) {
                }
                i9 = i5 & 32;
                if (i9 == 0) {
                }
                i10 = i5 & 64;
                if (i10 == 0) {
                }
                i11 = i5 & Fields.SpotShadowColor;
                if (i11 == 0) {
                }
                i12 = i5 & Fields.RotationX;
                if (i12 == 0) {
                }
                i13 = i5 & Fields.RotationY;
                if (i13 == 0) {
                }
                i14 = i5 & Fields.RotationZ;
                if (i14 == 0) {
                }
                if ((i4 & 48) == 0) {
                }
                i16 = i15;
                i17 = i5 & Fields.TransformOrigin;
                if (i17 == 0) {
                }
                i18 = i5 & Fields.Shape;
                if (i18 != 0) {
                }
                i19 = i5 & Fields.Clip;
                if (i19 == 0) {
                }
                i20 = i5 & Fields.CompositingStrategy;
                if (i20 != 0) {
                }
                i21 = i5 & 65536;
                if (i21 != 0) {
                }
                if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (599187 & i16) != 599186, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i7 = i5 & 8;
            int i322 = Fields.RotationZ;
            if (i7 == 0) {
            }
            i8 = i5 & 16;
            if (i8 != 0) {
            }
            i9 = i5 & 32;
            if (i9 == 0) {
            }
            i10 = i5 & 64;
            if (i10 == 0) {
            }
            i11 = i5 & Fields.SpotShadowColor;
            if (i11 == 0) {
            }
            i12 = i5 & Fields.RotationX;
            if (i12 == 0) {
            }
            i13 = i5 & Fields.RotationY;
            if (i13 == 0) {
            }
            i14 = i5 & Fields.RotationZ;
            if (i14 == 0) {
            }
            if ((i4 & 48) == 0) {
            }
            i16 = i15;
            i17 = i5 & Fields.TransformOrigin;
            if (i17 == 0) {
            }
            i18 = i5 & Fields.Shape;
            if (i18 != 0) {
            }
            i19 = i5 & Fields.Clip;
            if (i19 == 0) {
            }
            i20 = i5 & Fields.CompositingStrategy;
            if (i20 != 0) {
            }
            i21 = i5 & 65536;
            if (i21 != 0) {
            }
            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (599187 & i16) != 599186, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TextFieldScrollerPosition CoreTextField$lambda$6$lambda$5(Orientation orientation) {
            return new TextFieldScrollerPosition(orientation, 0.0f, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit CoreTextField$lambda$15$lambda$14(LegacyTextFieldState legacyTextFieldState, boolean z, boolean z2, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope, BringIntoViewRequester bringIntoViewRequester, FocusState focusState) {
            TextLayoutResultProxy layoutResult;
            if (legacyTextFieldState.getHasFocus() == focusState.isFocused()) {
                return Unit.INSTANCE;
            }
            legacyTextFieldState.setHasFocus(focusState.isFocused());
            if (legacyTextFieldState.getHasFocus() && z && !z2) {
                startInputSession(textInputService, legacyTextFieldState, textFieldValue, imeOptions, offsetMapping);
            } else {
                endInputSession(legacyTextFieldState);
            }
            if (focusState.isFocused() && (layoutResult = legacyTextFieldState.getLayoutResult()) != null) {
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new CoreTextFieldKt$CoreTextField$focusModifier$1$1$1$1(bringIntoViewRequester, textFieldValue, legacyTextFieldState, layoutResult, offsetMapping, null), 3, (Object) null);
            }
            if (!focusState.isFocused()) {
                TextFieldSelectionManager.m2143deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit CoreTextField$lambda$19$lambda$18(LegacyTextFieldState legacyTextFieldState, boolean z) {
            legacyTextFieldState.setInTouchMode(z);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit CoreTextField$lambda$22$lambda$21(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z, boolean z2, TextFieldSelectionManager textFieldSelectionManager, OffsetMapping offsetMapping, Offset offset) {
            tapToFocus(legacyTextFieldState, focusRequester, !z);
            if (legacyTextFieldState.getHasFocus() && z2) {
                if (legacyTextFieldState.getHandleState() != HandleState.Selection) {
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    if (layoutResult != null) {
                        TextFieldDelegate.INSTANCE.m1634setCursorOffsetULxng0E$foundation_release(offset.m4603unboximpl(), layoutResult, legacyTextFieldState.getProcessor(), offsetMapping, legacyTextFieldState.getOnValueChange());
                        if (legacyTextFieldState.getTextDelegate().getText().length() > 0) {
                            legacyTextFieldState.setHandleState(HandleState.Cursor);
                        }
                    }
                } else {
                    textFieldSelectionManager.m2147deselect_kEHs6E$foundation_release(offset);
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit CoreTextField$lambda$26$lambda$25(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping, DrawScope drawScope) {
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult != null) {
                TextFieldDelegate.INSTANCE.m1632drawQ1vqE60$foundation_release(drawScope.getDrawContext().getCanvas(), textFieldValue, legacyTextFieldState.m1563getSelectionPreviewHighlightRanged9O1mEE(), legacyTextFieldState.m1560getDeletionPreviewHighlightRanged9O1mEE(), offsetMapping, layoutResult.getValue(), legacyTextFieldState.getHighlightPaint(), legacyTextFieldState.getSelectionBackgroundColor());
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit CoreTextField$lambda$30$lambda$29(LegacyTextFieldState legacyTextFieldState, boolean z, WindowInfo windowInfo, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, OffsetMapping offsetMapping, LayoutCoordinates layoutCoordinates) {
            TextInputSession inputSession;
            legacyTextFieldState.setLayoutCoordinates(layoutCoordinates);
            TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
            if (layoutResult != null) {
                layoutResult.setInnerTextFieldCoordinates(layoutCoordinates);
            }
            if (z) {
                if (legacyTextFieldState.getHandleState() == HandleState.Selection) {
                    if (legacyTextFieldState.getShowFloatingToolbar() && windowInfo.isWindowFocused()) {
                        textFieldSelectionManager.showSelectionToolbar$foundation_release();
                    } else {
                        textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                    }
                    legacyTextFieldState.setShowSelectionHandleStart(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                    legacyTextFieldState.setShowSelectionHandleEnd(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, false));
                    legacyTextFieldState.setShowCursorHandle(TextRange.getCollapsed-impl(textFieldValue.getSelection-d9O1mEE()));
                } else if (legacyTextFieldState.getHandleState() == HandleState.Cursor) {
                    legacyTextFieldState.setShowCursorHandle(TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(textFieldSelectionManager, true));
                }
                notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
                TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                if (layoutResult2 != null && (inputSession = legacyTextFieldState.getInputSession()) != null && legacyTextFieldState.getHasFocus()) {
                    TextFieldDelegate.INSTANCE.updateTextLayoutResult$foundation_release(inputSession, textFieldValue, offsetMapping, layoutResult2);
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final DisposableEffectResult CoreTextField$lambda$36$lambda$35(LegacyTextFieldState legacyTextFieldState, TextInputService textInputService, TextFieldValue textFieldValue, ImeOptions imeOptions, DisposableEffectScope disposableEffectScope) {
            if (legacyTextFieldState.getHasFocus()) {
                legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.restartInput$foundation_release(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
            }
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$36$lambda$35$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit CoreTextField$lambda$38$lambda$37(boolean z, LegacyPlatformTextInputServiceAdapter legacyPlatformTextInputServiceAdapter) {
            if (z) {
                legacyPlatformTextInputServiceAdapter.startStylusHandwriting();
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit CoreTextField$lambda$40$lambda$39(LegacyTextFieldState legacyTextFieldState, long j, DrawScope drawScope) {
            if (legacyTextFieldState.getAutofillHighlightOn() || legacyTextFieldState.getJustAutofilled()) {
                DrawScope.m5411drawRectnJ9OG0$default(drawScope, j, 0L, 0L, 0.0f, null, null, 0, 126, null);
            }
            return Unit.INSTANCE;
        }

        private static final void CoreTextFieldRootBox(final Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
            int i2;
            Composer startRestartGroup = composer.startRestartGroup(2036174316);
            ComposerKt.sourceInformation(startRestartGroup, "C(CoreTextFieldRootBox)N(modifier,manager,content)682@32464L83:CoreTextField.kt#423gt5");
            if ((i & 6) == 0) {
                i2 = (startRestartGroup.changed(modifier) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= startRestartGroup.changedInstance(textFieldSelectionManager) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                i2 |= startRestartGroup.changedInstance(function2) ? Fields.RotationX : Fields.SpotShadowColor;
            }
            if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
                startRestartGroup.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2036174316, i2, -1, "androidx.compose.foundation.text.CoreTextFieldRootBox (CoreTextField.kt:681)");
                }
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier);
                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                Updater.m4116setimpl(m4109constructorimpl, maybeCachedBoxMeasurePolicy, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m4116setimpl(m4109constructorimpl, currentCompositionLocalMap, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (m4109constructorimpl.getInserting() || !Intrinsics.areEqual(m4109constructorimpl.rememberedValue(), Integer.valueOf(hashCode))) {
                    m4109constructorimpl.updateRememberedValue(Integer.valueOf(hashCode));
                    m4109constructorimpl.apply(Integer.valueOf(hashCode), setCompositeKeyHash);
                }
                Updater.m4116setimpl(m4109constructorimpl, materializeModifier, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1799443472, "C682@32512L33:CoreTextField.kt#423gt5");
                int i3 = i2 >> 3;
                ContextMenu_androidKt.ContextMenuArea(textFieldSelectionManager, function2, startRestartGroup, (i3 & 112) | (i3 & 14));
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                startRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2) {
                        Unit CoreTextFieldRootBox$lambda$43;
                        CoreTextFieldRootBox$lambda$43 = CoreTextFieldKt.CoreTextFieldRootBox$lambda$43(Modifier.this, textFieldSelectionManager, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                        return CoreTextFieldRootBox$lambda$43;
                    }
                });
            }
        }

        private static final Modifier previewKeyEventToDeselectOnBack(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldSelectionManager textFieldSelectionManager) {
            return KeyInputModifierKt.onPreviewKeyEvent(modifier, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$previewKeyEventToDeselectOnBack$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m1538invokeZmokQxo(((KeyEvent) obj).m5979unboximpl());
                }

                /* renamed from: invoke-ZmokQxo, reason: not valid java name */
                public final Boolean m1538invokeZmokQxo(android.view.KeyEvent keyEvent) {
                    boolean z;
                    if (LegacyTextFieldState.this.getHandleState() == HandleState.Selection && KeyEventHelpers_androidKt.m1541cancelsTextSelectionZmokQxo(keyEvent)) {
                        z = true;
                        TextFieldSelectionManager.m2143deselect_kEHs6E$foundation_release$default(textFieldSelectionManager, null, 1, null);
                    } else {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            });
        }

        public static final void tapToFocus(LegacyTextFieldState legacyTextFieldState, FocusRequester focusRequester, boolean z) {
            SoftwareKeyboardController keyboardController;
            if (!legacyTextFieldState.getHasFocus()) {
                FocusRequester.m4495requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
            } else {
                if (!z || (keyboardController = legacyTextFieldState.getKeyboardController()) == null) {
                    return;
                }
                keyboardController.show();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void startInputSession(TextInputService textInputService, LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, ImeOptions imeOptions, OffsetMapping offsetMapping) {
            legacyTextFieldState.setInputSession(TextFieldDelegate.INSTANCE.onFocus$foundation_release(textInputService, textFieldValue, legacyTextFieldState.getProcessor(), imeOptions, legacyTextFieldState.getOnValueChange(), legacyTextFieldState.getOnImeActionPerformed()));
            notifyFocusedRect(legacyTextFieldState, textFieldValue, offsetMapping);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void endInputSession(LegacyTextFieldState legacyTextFieldState) {
            TextInputSession inputSession = legacyTextFieldState.getInputSession();
            if (inputSession != null) {
                TextFieldDelegate.INSTANCE.onBlur$foundation_release(inputSession, legacyTextFieldState.getProcessor(), legacyTextFieldState.getOnValueChange());
            }
            legacyTextFieldState.setInputSession(null);
        }

        public static final Object bringSelectionEndIntoView(BringIntoViewRequester bringIntoViewRequester, TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, OffsetMapping offsetMapping, Continuation<? super Unit> continuation) {
            Rect rect;
            int originalToTransformed = offsetMapping.originalToTransformed(TextRange.getMax-impl(textFieldValue.getSelection-d9O1mEE()));
            if (originalToTransformed < textLayoutResult.getLayoutInput().getText().length()) {
                rect = textLayoutResult.getBoundingBox(originalToTransformed);
            } else if (originalToTransformed != 0) {
                rect = textLayoutResult.getBoundingBox(originalToTransformed - 1);
            } else {
                rect = new Rect(0.0f, 0.0f, 1.0f, (int) (TextFieldDelegateKt.computeSizeForDefaultText$default(textDelegate.getStyle(), textDelegate.getDensity(), textDelegate.getFontFamilyResolver(), null, 0, 24, null) & 4294967295L));
            }
            Object bringIntoView = bringIntoViewRequester.bringIntoView(rect, continuation);
            return bringIntoView == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? bringIntoView : Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void SelectionToolbarAndHandles(final TextFieldSelectionManager textFieldSelectionManager, final boolean z, Composer composer, final int i) {
            int i2;
            TextLayoutResultProxy layoutResult;
            TextLayoutResult value;
            Composer startRestartGroup = composer.startRestartGroup(626339208);
            ComposerKt.sourceInformation(startRestartGroup, "C(SelectionToolbarAndHandles)N(manager,show):CoreTextField.kt#423gt5");
            if ((i & 6) == 0) {
                i2 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= startRestartGroup.changed(z) ? 32 : 16;
            }
            if (!startRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
                startRestartGroup.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(626339208, i2, -1, "androidx.compose.foundation.text.SelectionToolbarAndHandles (CoreTextField.kt:1034)");
                }
                if (z) {
                    startRestartGroup.startReplaceGroup(1529773841);
                    ComposerKt.sourceInformation(startRestartGroup, "");
                    LegacyTextFieldState state = textFieldSelectionManager.getState();
                    TextLayoutResult textLayoutResult = null;
                    if (state != null && (layoutResult = state.getLayoutResult()) != null && (value = layoutResult.getValue()) != null) {
                        if (!(textFieldSelectionManager.getState() != null ? r6.getIsLayoutResultStale() : true)) {
                            textLayoutResult = value;
                        }
                    }
                    if (textLayoutResult == null) {
                        startRestartGroup.startReplaceGroup(1530097387);
                    } else {
                        startRestartGroup.startReplaceGroup(1530097388);
                        ComposerKt.sourceInformation(startRestartGroup, "");
                        if (!TextRange.getCollapsed-impl(textFieldSelectionManager.getValue$foundation_release().getSelection-d9O1mEE())) {
                            startRestartGroup.startReplaceGroup(2109807302);
                            ComposerKt.sourceInformation(startRestartGroup, "");
                            int originalToTransformed = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.getStart-impl(textFieldSelectionManager.getValue$foundation_release().getSelection-d9O1mEE()));
                            int originalToTransformed2 = textFieldSelectionManager.getOffsetMapping().originalToTransformed(TextRange.getEnd-impl(textFieldSelectionManager.getValue$foundation_release().getSelection-d9O1mEE()));
                            ResolvedTextDirection bidiRunDirection = textLayoutResult.getBidiRunDirection(originalToTransformed);
                            ResolvedTextDirection bidiRunDirection2 = textLayoutResult.getBidiRunDirection(Math.max(originalToTransformed2 - 1, 0));
                            LegacyTextFieldState state2 = textFieldSelectionManager.getState();
                            if (state2 != null && state2.getShowSelectionHandleStart()) {
                                startRestartGroup.startReplaceGroup(2110225306);
                                ComposerKt.sourceInformation(startRestartGroup, "1050@47759L220");
                                TextFieldSelectionManagerKt.TextFieldSelectionHandle(true, bidiRunDirection, textFieldSelectionManager, startRestartGroup, ((i2 << 6) & 896) | 6);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(2110490542);
                                startRestartGroup.endReplaceGroup();
                            }
                            LegacyTextFieldState state3 = textFieldSelectionManager.getState();
                            if (state3 != null && state3.getShowSelectionHandleEnd()) {
                                startRestartGroup.startReplaceGroup(2110574459);
                                ComposerKt.sourceInformation(startRestartGroup, "1057@48111L219");
                                TextFieldSelectionManagerKt.TextFieldSelectionHandle(false, bidiRunDirection2, textFieldSelectionManager, startRestartGroup, ((i2 << 6) & 896) | 6);
                                startRestartGroup.endReplaceGroup();
                            } else {
                                startRestartGroup.startReplaceGroup(2110838734);
                                startRestartGroup.endReplaceGroup();
                            }
                            startRestartGroup.endReplaceGroup();
                        } else {
                            startRestartGroup.startReplaceGroup(2110860558);
                            startRestartGroup.endReplaceGroup();
                        }
                        LegacyTextFieldState state4 = textFieldSelectionManager.getState();
                        if (state4 != null) {
                            if (textFieldSelectionManager.isTextChanged$foundation_release()) {
                                state4.setShowFloatingToolbar(false);
                            }
                            if (state4.getHasFocus()) {
                                if (state4.getShowFloatingToolbar()) {
                                    textFieldSelectionManager.showSelectionToolbar$foundation_release();
                                } else {
                                    textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    startRestartGroup.endReplaceGroup();
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(1989076778);
                    startRestartGroup.endReplaceGroup();
                    textFieldSelectionManager.hideSelectionToolbar$foundation_release();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda9
                    public final Object invoke(Object obj, Object obj2) {
                        Unit SelectionToolbarAndHandles$lambda$49;
                        SelectionToolbarAndHandles$lambda$49 = CoreTextFieldKt.SelectionToolbarAndHandles$lambda$49(TextFieldSelectionManager.this, z, i, (Composer) obj, ((Integer) obj2).intValue());
                        return SelectionToolbarAndHandles$lambda$49;
                    }
                });
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0153  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void TextFieldCursorHandle(final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
            int i2;
            boolean z;
            Composer startRestartGroup = composer.startRestartGroup(-1436003720);
            ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle)N(manager):CoreTextField.kt#423gt5");
            if ((i & 6) == 0) {
                i2 = (startRestartGroup.changedInstance(textFieldSelectionManager) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
                startRestartGroup.skipToGroupEnd();
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1436003720, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (CoreTextField.kt:1081)");
                }
                LegacyTextFieldState state = textFieldSelectionManager.getState();
                if (state != null && state.getShowCursorHandle()) {
                    CharSequence transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release();
                    if (transformedText$foundation_release != null) {
                        if (transformedText$foundation_release.length() > 0) {
                            z = true;
                            if (z) {
                                startRestartGroup.startReplaceGroup(-2112330600);
                                ComposerKt.sourceInformation(startRestartGroup, "1083@49274L50,1084@49387L7,1086@49447L12,1088@49532L645,1100@50209L385,1085@49404L1201");
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1315066198, "CC(remember):CoreTextField.kt#9igjgp");
                                boolean changed = startRestartGroup.changed(textFieldSelectionManager);
                                Object rememberedValue = startRestartGroup.rememberedValue();
                                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue = textFieldSelectionManager.cursorDragObserver$foundation_release();
                                    startRestartGroup.updateRememberedValue(rememberedValue);
                                }
                                final TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                Object consume = startRestartGroup.consume(localDensity);
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                final long m2149getCursorPositiontuRUvjQ$foundation_release = textFieldSelectionManager.m2149getCursorPositiontuRUvjQ$foundation_release((Density) consume);
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1315060700, "CC(remember):CoreTextField.kt#9igjgp");
                                boolean changed2 = startRestartGroup.changed(m2149getCursorPositiontuRUvjQ$foundation_release);
                                Object rememberedValue2 = startRestartGroup.rememberedValue();
                                if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue2 = (OffsetProvider) new OffsetProvider() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$1$1
                                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                                        /* renamed from: provide-F1C5BW0 */
                                        public final long mo1503provideF1C5BW0() {
                                            return m2149getCursorPositiontuRUvjQ$foundation_release;
                                        }
                                    };
                                    startRestartGroup.updateRememberedValue(rememberedValue2);
                                }
                                OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
                                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                Modifier.Companion companion = Modifier.INSTANCE;
                                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1315057347, "CC(remember):CoreTextField.kt#9igjgp");
                                boolean changedInstance = startRestartGroup.changedInstance(textDragObserver) | startRestartGroup.changedInstance(textFieldSelectionManager);
                                Object rememberedValue3 = startRestartGroup.rememberedValue();
                                if (changedInstance || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    rememberedValue3 = (PointerInputEventHandler) new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1

                                        /* compiled from: CoreTextField.kt */
                                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                                        @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1", f = "CoreTextField.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                        /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1 */
                                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                        static final class C03961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                            final /* synthetic */ TextFieldSelectionManager $manager;
                                            final /* synthetic */ TextDragObserver $observer;
                                            final /* synthetic */ PointerInputScope $this_pointerInput;
                                            private /* synthetic */ Object L$0;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            C03961(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super C03961> continuation) {
                                                super(2, continuation);
                                                this.$this_pointerInput = pointerInputScope;
                                                this.$observer = textDragObserver;
                                                this.$manager = textFieldSelectionManager;
                                            }

                                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                Continuation<Unit> c03961 = new C03961(this.$this_pointerInput, this.$observer, this.$manager, continuation);
                                                c03961.L$0 = obj;
                                                return c03961;
                                            }

                                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                            }

                                            public final Object invokeSuspend(Object obj) {
                                                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                if (this.label != 0) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                ResultKt.throwOnFailure(obj);
                                                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new AnonymousClass1(this.$this_pointerInput, this.$observer, null), 1, (Object) null);
                                                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new AnonymousClass2(this.$this_pointerInput, this.$manager, null), 1, (Object) null);
                                                return Unit.INSTANCE;
                                            }

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* compiled from: CoreTextField.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1", f = "CoreTextField.kt", i = {}, l = {1094}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$1, reason: invalid class name */
                                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                            public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ TextDragObserver $observer;
                                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(PointerInputScope pointerInputScope, TextDragObserver textDragObserver, Continuation<? super AnonymousClass1> continuation) {
                                                    super(2, continuation);
                                                    this.$this_pointerInput = pointerInputScope;
                                                    this.$observer = textDragObserver;
                                                }

                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass1(this.$this_pointerInput, this.$observer, continuation);
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
                                                        if (LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(this.$this_pointerInput, this.$observer, (Continuation) this) == coroutine_suspended) {
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

                                            /* JADX INFO: Access modifiers changed from: package-private */
                                            /* compiled from: CoreTextField.kt */
                                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
                                            @DebugMetadata(c = "androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2", f = "CoreTextField.kt", i = {}, l = {1097}, m = "invokeSuspend", n = {}, s = {})
                                            /* renamed from: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2, reason: invalid class name */
                                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
                                            public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                                final /* synthetic */ TextFieldSelectionManager $manager;
                                                final /* synthetic */ PointerInputScope $this_pointerInput;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass2(PointerInputScope pointerInputScope, TextFieldSelectionManager textFieldSelectionManager, Continuation<? super AnonymousClass2> continuation) {
                                                    super(2, continuation);
                                                    this.$this_pointerInput = pointerInputScope;
                                                    this.$manager = textFieldSelectionManager;
                                                }

                                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                                    return new AnonymousClass2(this.$this_pointerInput, this.$manager, continuation);
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                                    return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
                                                }

                                                public final Object invokeSuspend(Object obj) {
                                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        ResultKt.throwOnFailure(obj);
                                                        PointerInputScope pointerInputScope = this.$this_pointerInput;
                                                        final TextFieldSelectionManager textFieldSelectionManager = this.$manager;
                                                        this.label = 1;
                                                        if (TapGestureDetectorKt.detectTapGestures$default(pointerInputScope, null, null, null, 
                                                        /*  JADX ERROR: Method code generation error
                                                            jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0, state: NOT_LOADED
                                                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                                                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                                                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1117)
                                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:884)
                                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                                            	at jadx.core.codegen.ConditionGen.addCompare(ConditionGen.java:129)
                                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:57)
                                                            	at jadx.core.codegen.ConditionGen.add(ConditionGen.java:46)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:115)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
                                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                            */
                                                        /*
                                                            this = this;
                                                            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                                            int r1 = r10.label
                                                            r2 = 1
                                                            if (r1 == 0) goto L17
                                                            if (r1 != r2) goto Lf
                                                            kotlin.ResultKt.throwOnFailure(r11)
                                                            goto L39
                                                        Lf:
                                                            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                                                            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                                            r11.<init>(r0)
                                                            throw r11
                                                        L17:
                                                            kotlin.ResultKt.throwOnFailure(r11)
                                                            androidx.compose.ui.input.pointer.PointerInputScope r1 = r10.$this_pointerInput
                                                            r11 = 0
                                                            r3 = 0
                                                            r4 = 0
                                                            androidx.compose.foundation.text.selection.TextFieldSelectionManager r5 = r10.$manager
                                                            androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0 r6 = new androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1$1$2$$ExternalSyntheticLambda0
                                                            r6.<init>(r5)
                                                            r7 = r10
                                                            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                                                            r8 = 7
                                                            r9 = 0
                                                            r10.label = r2
                                                            r2 = r11
                                                            r5 = r6
                                                            r6 = r7
                                                            r7 = r8
                                                            r8 = r9
                                                            java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.detectTapGestures$default(r1, r2, r3, r4, r5, r6, r7, r8)
                                                            if (r11 != r0) goto L39
                                                            return r0
                                                        L39:
                                                            kotlin.Unit r11 = kotlin.Unit.INSTANCE
                                                            return r11
                                                        */
                                                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.CoreTextFieldKt$TextFieldCursorHandle$2$1.C03961.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
                                                    }

                                                    /* JADX INFO: Access modifiers changed from: private */
                                                    public static final Unit invokeSuspend$lambda$0(TextFieldSelectionManager textFieldSelectionManager, Offset offset) {
                                                        textFieldSelectionManager.showSelectionToolbar$foundation_release();
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                            }

                                            @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
                                            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                                                Object coroutineScope = CoroutineScopeKt.coroutineScope(new C03961(pointerInputScope, TextDragObserver.this, textFieldSelectionManager, null), continuation);
                                                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    Modifier pointerInput = SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (PointerInputEventHandler) rememberedValue3);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1315035943, "CC(remember):CoreTextField.kt#9igjgp");
                                    boolean changed3 = startRestartGroup.changed(m2149getCursorPositiontuRUvjQ$foundation_release);
                                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (changed3 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue4 = new Function1() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda7
                                            public final Object invoke(Object obj) {
                                                Unit TextFieldCursorHandle$lambda$54$lambda$53;
                                                TextFieldCursorHandle$lambda$54$lambda$53 = CoreTextFieldKt.TextFieldCursorHandle$lambda$54$lambda$53(m2149getCursorPositiontuRUvjQ$foundation_release, (SemanticsPropertyReceiver) obj);
                                                return TextFieldCursorHandle$lambda$54$lambda$53;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue4);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    AndroidCursorHandle_androidKt.m1479CursorHandleUSBMPiE(offsetProvider, SemanticsModifierKt.semantics$default(pointerInput, false, (Function1) rememberedValue4, 1, (Object) null), 0L, startRestartGroup, 0, 4);
                                    startRestartGroup.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }
                        }
                        z = false;
                        if (z) {
                        }
                    }
                    startRestartGroup.startReplaceGroup(-2111021718);
                    startRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$$ExternalSyntheticLambda8
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TextFieldCursorHandle$lambda$55;
                            TextFieldCursorHandle$lambda$55 = CoreTextFieldKt.TextFieldCursorHandle$lambda$55(TextFieldSelectionManager.this, i, (Composer) obj, ((Integer) obj2).intValue());
                            return TextFieldCursorHandle$lambda$55;
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit TextFieldCursorHandle$lambda$54$lambda$53(long j, SemanticsPropertyReceiver semanticsPropertyReceiver) {
                semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, j, SelectionHandleAnchor.Middle, true, null));
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void notifyFocusedRect(LegacyTextFieldState legacyTextFieldState, TextFieldValue textFieldValue, OffsetMapping offsetMapping) {
                Snapshot.Companion companion = Snapshot.INSTANCE;
                Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                try {
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    if (layoutResult == null) {
                        return;
                    }
                    TextInputSession inputSession = legacyTextFieldState.getInputSession();
                    if (inputSession == null) {
                        return;
                    }
                    LayoutCoordinates layoutCoordinates = legacyTextFieldState.getLayoutCoordinates();
                    if (layoutCoordinates == null) {
                        return;
                    }
                    TextFieldDelegate.INSTANCE.notifyFocusedRect$foundation_release(textFieldValue, legacyTextFieldState.getTextDelegate(), layoutResult.getValue(), layoutCoordinates, inputSession, legacyTextFieldState.getHasFocus(), offsetMapping);
                    Unit unit = Unit.INSTANCE;
                } finally {
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                }
            }

            private static final Modifier addContextMenuComponents(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope) {
                return ComposeFoundationFlags.isNewContextMenuEnabled ? TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents(modifier, textFieldSelectionManager, coroutineScope) : modifier;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean CoreTextField$lambda$16(State<Boolean> state) {
                return state.getValue().booleanValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final DisposableEffectResult CoreTextField$lambda$33$lambda$32(final TextFieldSelectionManager textFieldSelectionManager, DisposableEffectScope disposableEffectScope) {
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.CoreTextFieldKt$CoreTextField$lambda$33$lambda$32$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    }
                };
            }
        }
