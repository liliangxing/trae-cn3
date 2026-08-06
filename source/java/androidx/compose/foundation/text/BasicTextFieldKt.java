package androidx.compose.foundation.text;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.foundation.text.handwriting.StylusHandwritingKt;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.CodepointTransformation;
import androidx.compose.foundation.text.input.internal.SingleLineCodepointTransformation;
import androidx.compose.foundation.text.input.internal.TextFieldCoreModifier;
import androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifier;
import androidx.compose.foundation.text.input.internal.TextFieldTextLayoutModifier;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldHandleState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt;
import androidx.compose.foundation.text.selection.AndroidSelectionHandles_androidKt;
import androidx.compose.foundation.text.selection.OffsetProvider;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.foundation.text.selection.SelectedTextType;
import androidx.compose.p002ui.Alignment;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.draw.ClipKt;
import androidx.compose.p002ui.graphics.Brush;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.SolidColor;
import androidx.compose.p002ui.hapticfeedback.HapticFeedback;
import androidx.compose.p002ui.input.pointer.PointerIcon;
import androidx.compose.p002ui.input.pointer.PointerIconKt;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p002ui.layout.MeasurePolicy;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* compiled from: BasicTextField.kt */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aÛ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001228\b\u0002\u0010\u0013\u001a2\u0012\u0004\u0012\u00020\u0015\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%H\u0007¢\u0006\u0002\u0010&\u001añ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u001228\b\u0002\u0010\u0013\u001a2\u0012\u0004\u0012\u00020\u0015\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0014¢\u0006\u0002\b\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020\u0005*\u00020\u00052\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002\u001a\u0015\u00100\u001a\u00020\u00012\u0006\u00101\u001a\u00020-H\u0001¢\u0006\u0002\u00102\u001a\u0015\u00103\u001a\u00020\u00012\u0006\u00101\u001a\u00020-H\u0001¢\u0006\u0002\u00102\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010G\u001aî\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u00020H2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010I\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u0002092\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010J\u001aâ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u00108\u001a\u00020H2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\u00072\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010B\u001a\u00020C2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010;2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f23\b\u0002\u0010D\u001a-\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\bE¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u00010;¢\u0006\u0002\bEH\u0007¢\u0006\u0002\u0010K\"\u000e\u00104\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0004\n\u0002\u00107¨\u0006L²\u0006\n\u0010M\u001a\u00020NX\u008a\u0084\u0002²\u0006\n\u0010O\u001a\u00020NX\u008a\u0084\u0002²\u0006\n\u0010P\u001a\u00020NX\u008a\u0084\u0002²\u0006\n\u0010Q\u001a\u00020HX\u008a\u008e\u0002²\u0006\n\u0010R\u001a\u000209X\u008a\u008e\u0002"}, d2 = {"BasicTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "lineLimits", "Landroidx/compose/foundation/text/input/TextFieldLineLimits;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;Landroidx/compose/runtime/Composer;III)V", "codepointTransformation", "Landroidx/compose/foundation/text/input/internal/CodepointTransformation;", "isPassword", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Landroidx/compose/foundation/text/input/TextFieldLineLimits;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/internal/CodepointTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/text/input/TextFieldDecorator;Landroidx/compose/foundation/ScrollState;ZLandroidx/compose/runtime/Composer;III)V", "addContextMenuComponents", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "TextFieldCursorHandle", "selectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/runtime/Composer;I)V", "TextFieldSelectionHandles", "DefaultTextFieldDecorator", "MinTouchTargetSizeForHandles", "Landroidx/compose/ui/unit/DpSize;", "J", "value", "", "onValueChange", "Lkotlin/Function1;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "minLines", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "decorationBox", "Landroidx/compose/runtime/Composable;", "innerTextField", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/ui/text/input/TextFieldValue;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "foundation_release", "cursorHandleState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldHandleState;", "startHandleState", "endHandleState", "textFieldValueState", "lastTextValue"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class BasicTextFieldKt {
    private static final TextFieldDecorator DefaultTextFieldDecorator = BasicTextFieldKt$DefaultTextFieldDecorator$1.INSTANCE;
    private static final long MinTouchTargetSizeForHandles;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$0(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, OutputTransformation outputTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, int i, int i2, int i3, Composer composer, int i4) {
        BasicTextField(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, textFieldLineLimits, (Function2<? super Density, ? super Function0<TextLayoutResult>, Unit>) function2, mutableInteractionSource, brush, outputTransformation, textFieldDecorator, scrollState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$17(TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2 function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, boolean z3, int i, int i2, int i3, Composer composer, int i4) {
        BasicTextField(textFieldState, modifier, z, z2, inputTransformation, textStyle, keyboardOptions, keyboardActionHandler, textFieldLineLimits, function2, mutableInteractionSource, brush, codepointTransformation, outputTransformation, textFieldDecorator, scrollState, z3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$47(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i3, int i4, int i5, Composer composer, int i6) {
        BasicTextField(str, (Function1<? super String, Unit>) function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, i2, visualTransformation, (Function1<? super TextLayoutResult, Unit>) function12, mutableInteractionSource, brush, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$52(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i3, int i4, int i5, Composer composer, int i6) {
        BasicTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, i2, visualTransformation, (Function1<? super TextLayoutResult, Unit>) function12, mutableInteractionSource, brush, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) function3, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$56(String str, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        BasicTextField(str, function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, visualTransformation, function12, mutableInteractionSource, brush, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$60(TextFieldValue textFieldValue, Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, int i2, int i3, int i4, Composer composer, int i5) {
        BasicTextField(textFieldValue, function1, modifier, z, z2, textStyle, keyboardOptions, keyboardActions, z3, i, visualTransformation, function12, mutableInteractionSource, brush, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldCursorHandle$lambda$23(TextFieldSelectionState textFieldSelectionState, int i, Composer composer, int i2) {
        TextFieldCursorHandle(textFieldSelectionState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldSelectionHandles$lambda$34(TextFieldSelectionState textFieldSelectionState, int i, Composer composer, int i2) {
        TextFieldSelectionHandles(textFieldSelectionState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, OutputTransformation outputTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, Composer composer, final int i, final int i2, final int i3) {
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
        int i17;
        int i18;
        int i19;
        Composer composer2;
        final Modifier modifier2;
        final boolean z3;
        final boolean z4;
        final InputTransformation inputTransformation2;
        final TextStyle textStyle2;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActionHandler keyboardActionHandler2;
        final TextFieldLineLimits textFieldLineLimits2;
        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final OutputTransformation outputTransformation2;
        final TextFieldDecorator textFieldDecorator2;
        final ScrollState scrollState2;
        ScopeUpdateScope endRestartGroup;
        boolean z5;
        boolean z6;
        Modifier modifier3;
        ScrollState scrollState3;
        int i20;
        OutputTransformation outputTransformation3;
        TextFieldDecorator textFieldDecorator3;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        MutableInteractionSource mutableInteractionSource3;
        KeyboardOptions keyboardOptions3;
        KeyboardActionHandler keyboardActionHandler3;
        TextFieldLineLimits textFieldLineLimits3;
        InputTransformation inputTransformation3;
        TextStyle textStyle3;
        Composer startRestartGroup = composer.startRestartGroup(469439921);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,lineLimits,onTextLayout,interactionSource,cursorBrush,outputTransformation,decorator,scrollState)202@12315L610:BasicTextField.kt#423gt5");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(textFieldState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i21 = i3 & 2;
        if (i21 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i5 = i3 & 4;
            int i22 = Fields.SpotShadowColor;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= startRestartGroup.changed(z) ? Fields.RotationX : 128;
                i6 = i3 & 8;
                int i23 = Fields.CameraDistance;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= startRestartGroup.changed(z2) ? 2048 : 1024;
                    i7 = i3 & 16;
                    int i24 = Fields.Shape;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i4 |= startRestartGroup.changed(inputTransformation) ? 16384 : 8192;
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= 196608;
                        } else if ((i & 196608) == 0) {
                            i4 |= startRestartGroup.changed(textStyle) ? Fields.RenderEffect : 65536;
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(keyboardOptions) ? 1048576 : Fields.BlendMode;
                        }
                        i10 = i3 & Fields.SpotShadowColor;
                        if (i10 != 0) {
                            i4 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i4 |= startRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                        }
                        i11 = i3 & Fields.RotationX;
                        if (i11 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i4 |= startRestartGroup.changed(textFieldLineLimits) ? 67108864 : 33554432;
                        }
                        i12 = i3 & Fields.RotationY;
                        if (i12 != 0) {
                            i4 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i4 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                        }
                        i13 = i3 & Fields.RotationZ;
                        if (i13 != 0) {
                            i14 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i14 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                        } else {
                            i14 = i2;
                        }
                        i15 = i3 & Fields.CameraDistance;
                        if (i15 != 0) {
                            i14 |= 48;
                        } else if ((i2 & 48) == 0) {
                            i14 |= startRestartGroup.changed(brush) ? 32 : 16;
                        }
                        i16 = i14;
                        i17 = i3 & Fields.TransformOrigin;
                        if (i17 != 0) {
                            i16 |= 384;
                        } else if ((i2 & 384) == 0) {
                            if (startRestartGroup.changed(outputTransformation)) {
                                i22 = Fields.RotationX;
                            }
                            i16 |= i22;
                            i18 = i3 & Fields.Shape;
                            if (i18 == 0) {
                                i16 |= 3072;
                                i19 = i18;
                            } else {
                                i19 = i18;
                                if ((i2 & 3072) == 0) {
                                    if (!((i2 & Fields.TransformOrigin) == 0 ? startRestartGroup.changed(textFieldDecorator) : startRestartGroup.changedInstance(textFieldDecorator))) {
                                        i23 = 1024;
                                    }
                                    i16 |= i23;
                                }
                            }
                            if ((i2 & 24576) == 0) {
                                if ((i3 & Fields.Clip) == 0 && startRestartGroup.changed(scrollState)) {
                                    i24 = 16384;
                                }
                                i16 |= i24;
                            }
                            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i16 & 9363) != 9362, i4 & 1)) {
                                startRestartGroup.startDefaults();
                                ComposerKt.sourceInformation(startRestartGroup, "198@12169L21");
                                if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                    startRestartGroup.skipToGroupEnd();
                                    if ((i3 & Fields.Clip) != 0) {
                                        i16 &= -57345;
                                    }
                                    modifier3 = modifier;
                                    z5 = z;
                                    z6 = z2;
                                    inputTransformation3 = inputTransformation;
                                    textStyle3 = textStyle;
                                    keyboardOptions3 = keyboardOptions;
                                    keyboardActionHandler3 = keyboardActionHandler;
                                    textFieldLineLimits3 = textFieldLineLimits;
                                    mutableInteractionSource3 = mutableInteractionSource;
                                    brush2 = brush;
                                    outputTransformation3 = outputTransformation;
                                    textFieldDecorator3 = textFieldDecorator;
                                    scrollState3 = scrollState;
                                    i20 = i16;
                                    function23 = function2;
                                } else {
                                    Modifier.Companion companion = i21 != 0 ? Modifier.INSTANCE : modifier;
                                    z5 = i5 != 0 ? true : z;
                                    z6 = i6 != 0 ? false : z2;
                                    InputTransformation inputTransformation4 = i7 != 0 ? null : inputTransformation;
                                    TextStyle textStyle4 = i8 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                    KeyboardOptions keyboardOptions4 = i9 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                    KeyboardActionHandler keyboardActionHandler4 = i10 != 0 ? null : keyboardActionHandler;
                                    TextFieldLineLimits textFieldLineLimits4 = i11 != 0 ? TextFieldLineLimits.INSTANCE.getDefault() : textFieldLineLimits;
                                    Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = i12 != 0 ? null : function2;
                                    MutableInteractionSource mutableInteractionSource4 = i13 != 0 ? null : mutableInteractionSource;
                                    SolidColor cursorBrush = i15 != 0 ? BasicTextFieldDefaults.INSTANCE.getCursorBrush() : brush;
                                    OutputTransformation outputTransformation4 = i17 != 0 ? null : outputTransformation;
                                    TextFieldDecorator textFieldDecorator4 = i19 == 0 ? textFieldDecorator : null;
                                    Modifier modifier4 = companion;
                                    if ((i3 & Fields.Clip) != 0) {
                                        scrollState3 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                        i20 = i16 & (-57345);
                                        outputTransformation3 = outputTransformation4;
                                        textFieldDecorator3 = textFieldDecorator4;
                                        modifier3 = modifier4;
                                    } else {
                                        modifier3 = modifier4;
                                        scrollState3 = scrollState;
                                        i20 = i16;
                                        outputTransformation3 = outputTransformation4;
                                        textFieldDecorator3 = textFieldDecorator4;
                                    }
                                    function23 = function24;
                                    mutableInteractionSource3 = mutableInteractionSource4;
                                    brush2 = cursorBrush;
                                    keyboardOptions3 = keyboardOptions4;
                                    keyboardActionHandler3 = keyboardActionHandler4;
                                    textFieldLineLimits3 = textFieldLineLimits4;
                                    inputTransformation3 = inputTransformation4;
                                    textStyle3 = textStyle4;
                                }
                                startRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    composer2 = startRestartGroup;
                                    ComposerKt.traceEventStart(469439921, i4, i20, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:201)");
                                } else {
                                    composer2 = startRestartGroup;
                                }
                                int i25 = i20 << 3;
                                BasicTextField(textFieldState, modifier3, z5, z6, inputTransformation3, textStyle3, keyboardOptions3, keyboardActionHandler3, textFieldLineLimits3, function23, mutableInteractionSource3, brush2, null, outputTransformation3, textFieldDecorator3, scrollState3, false, composer2, (i4 & 14) | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (57344 & i4) | (458752 & i4) | (3670016 & i4) | (29360128 & i4) | (234881024 & i4) | (i4 & 1879048192), (i20 & 14) | 384 | (i20 & 112) | (i25 & 7168) | (57344 & i25) | (i25 & 458752), 65536);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                modifier2 = modifier3;
                                textStyle2 = textStyle3;
                                z3 = z5;
                                outputTransformation2 = outputTransformation3;
                                textFieldDecorator2 = textFieldDecorator3;
                                scrollState2 = scrollState3;
                                keyboardOptions2 = keyboardOptions3;
                                z4 = z6;
                                mutableInteractionSource2 = mutableInteractionSource3;
                                function22 = function23;
                                textFieldLineLimits2 = textFieldLineLimits3;
                                keyboardActionHandler2 = keyboardActionHandler3;
                                inputTransformation2 = inputTransformation3;
                            } else {
                                composer2 = startRestartGroup;
                                composer2.skipToGroupEnd();
                                modifier2 = modifier;
                                z3 = z;
                                z4 = z2;
                                inputTransformation2 = inputTransformation;
                                textStyle2 = textStyle;
                                keyboardOptions2 = keyboardOptions;
                                keyboardActionHandler2 = keyboardActionHandler;
                                textFieldLineLimits2 = textFieldLineLimits;
                                function22 = function2;
                                mutableInteractionSource2 = mutableInteractionSource;
                                brush2 = brush;
                                outputTransformation2 = outputTransformation;
                                textFieldDecorator2 = textFieldDecorator;
                                scrollState2 = scrollState;
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                                endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda2
                                    public final Object invoke(Object obj, Object obj2) {
                                        Unit BasicTextField$lambda$0;
                                        BasicTextField$lambda$0 = BasicTextFieldKt.BasicTextField$lambda$0(TextFieldState.this, modifier2, z3, z4, inputTransformation2, textStyle2, keyboardOptions2, keyboardActionHandler2, textFieldLineLimits2, function22, mutableInteractionSource2, brush2, outputTransformation2, textFieldDecorator2, scrollState2, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                        return BasicTextField$lambda$0;
                                    }
                                });
                                return;
                            }
                            return;
                        }
                        i18 = i3 & Fields.Shape;
                        if (i18 == 0) {
                        }
                        if ((i2 & 24576) == 0) {
                        }
                        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i16 & 9363) != 9362, i4 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
                        if (endRestartGroup == null) {
                        }
                    }
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    i10 = i3 & Fields.SpotShadowColor;
                    if (i10 != 0) {
                    }
                    i11 = i3 & Fields.RotationX;
                    if (i11 != 0) {
                    }
                    i12 = i3 & Fields.RotationY;
                    if (i12 != 0) {
                    }
                    i13 = i3 & Fields.RotationZ;
                    if (i13 != 0) {
                    }
                    i15 = i3 & Fields.CameraDistance;
                    if (i15 != 0) {
                    }
                    i16 = i14;
                    i17 = i3 & Fields.TransformOrigin;
                    if (i17 != 0) {
                    }
                    i18 = i3 & Fields.Shape;
                    if (i18 == 0) {
                    }
                    if ((i2 & 24576) == 0) {
                    }
                    if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i16 & 9363) != 9362, i4 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i7 = i3 & 16;
                int i242 = Fields.Shape;
                if (i7 == 0) {
                }
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                i10 = i3 & Fields.SpotShadowColor;
                if (i10 != 0) {
                }
                i11 = i3 & Fields.RotationX;
                if (i11 != 0) {
                }
                i12 = i3 & Fields.RotationY;
                if (i12 != 0) {
                }
                i13 = i3 & Fields.RotationZ;
                if (i13 != 0) {
                }
                i15 = i3 & Fields.CameraDistance;
                if (i15 != 0) {
                }
                i16 = i14;
                i17 = i3 & Fields.TransformOrigin;
                if (i17 != 0) {
                }
                i18 = i3 & Fields.Shape;
                if (i18 == 0) {
                }
                if ((i2 & 24576) == 0) {
                }
                if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i16 & 9363) != 9362, i4 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i6 = i3 & 8;
            int i232 = Fields.CameraDistance;
            if (i6 != 0) {
            }
            i7 = i3 & 16;
            int i2422 = Fields.Shape;
            if (i7 == 0) {
            }
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            i10 = i3 & Fields.SpotShadowColor;
            if (i10 != 0) {
            }
            i11 = i3 & Fields.RotationX;
            if (i11 != 0) {
            }
            i12 = i3 & Fields.RotationY;
            if (i12 != 0) {
            }
            i13 = i3 & Fields.RotationZ;
            if (i13 != 0) {
            }
            i15 = i3 & Fields.CameraDistance;
            if (i15 != 0) {
            }
            i16 = i14;
            i17 = i3 & Fields.TransformOrigin;
            if (i17 != 0) {
            }
            i18 = i3 & Fields.Shape;
            if (i18 == 0) {
            }
            if ((i2 & 24576) == 0) {
            }
            if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i16 & 9363) != 9362, i4 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i5 = i3 & 4;
        int i222 = Fields.SpotShadowColor;
        if (i5 == 0) {
        }
        i6 = i3 & 8;
        int i2322 = Fields.CameraDistance;
        if (i6 != 0) {
        }
        i7 = i3 & 16;
        int i24222 = Fields.Shape;
        if (i7 == 0) {
        }
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        i10 = i3 & Fields.SpotShadowColor;
        if (i10 != 0) {
        }
        i11 = i3 & Fields.RotationX;
        if (i11 != 0) {
        }
        i12 = i3 & Fields.RotationY;
        if (i12 != 0) {
        }
        i13 = i3 & Fields.RotationZ;
        if (i13 != 0) {
        }
        i15 = i3 & Fields.CameraDistance;
        if (i15 != 0) {
        }
        i16 = i14;
        i17 = i3 & Fields.TransformOrigin;
        if (i17 != 0) {
        }
        i18 = i3 & Fields.Shape;
        if (i18 == 0) {
        }
        if ((i2 & 24576) == 0) {
        }
        if (!startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (i16 & 9363) != 9362, i4 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x088e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:192:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0865  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:324:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:352:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:373:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0232  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final TextFieldState textFieldState, Modifier modifier, boolean z, boolean z2, InputTransformation inputTransformation, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, TextFieldLineLimits textFieldLineLimits, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function2, MutableInteractionSource mutableInteractionSource, Brush brush, CodepointTransformation codepointTransformation, OutputTransformation outputTransformation, TextFieldDecorator textFieldDecorator, ScrollState scrollState, boolean z3, Composer composer, final int i, final int i2, final int i3) {
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
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        Modifier modifier2;
        final boolean z4;
        boolean z5;
        final InputTransformation inputTransformation2;
        final TextStyle textStyle2;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActionHandler keyboardActionHandler2;
        final TextFieldLineLimits textFieldLineLimits2;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function22;
        MutableInteractionSource mutableInteractionSource2;
        Brush brush2;
        CodepointTransformation codepointTransformation2;
        final OutputTransformation outputTransformation2;
        final TextFieldDecorator textFieldDecorator2;
        final ScrollState scrollState2;
        final boolean z6;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        boolean z7;
        TextStyle textStyle3;
        KeyboardActionHandler keyboardActionHandler3;
        CodepointTransformation codepointTransformation3;
        TextFieldDecorator textFieldDecorator3;
        ScrollState scrollState3;
        int i23;
        InputTransformation inputTransformation3;
        OutputTransformation outputTransformation3;
        boolean z8;
        Brush brush3;
        MutableInteractionSource mutableInteractionSource3;
        Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function23;
        TextFieldLineLimits textFieldLineLimits3;
        KeyboardOptions keyboardOptions3;
        TextFieldLineLimits textFieldLineLimits4;
        MutableInteractionSource mutableInteractionSource4;
        final boolean z9;
        Modifier modifier3;
        KeyboardActionHandler keyboardActionHandler4;
        MutableInteractionSource mutableInteractionSource5;
        SingleLineCodepointTransformation singleLineCodepointTransformation;
        OutputTransformation outputTransformation4;
        OutputTransformation outputTransformation5;
        final PlatformSelectionBehaviors platformSelectionBehaviors;
        int i24;
        Composer startRestartGroup = composer.startRestartGroup(965149429);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField)N(state,modifier,enabled,readOnly,inputTransformation,textStyle,keyboardOptions,onKeyboardAction,lineLimits,onTextLayout,interactionSource,cursorBrush,codepointTransformation,outputTransformation,decorator,scrollState,isPassword)252@14291L7,253@14346L7,259@14716L25,260@14790L25,264@15134L107,269@15278L846,287@16322L48,294@16698L24,303@17116L35,304@17194L7,306@17244L617,321@17914L7,322@17968L7,325@18014L2132,370@20163L510,370@20152L521,386@20721L51,386@20679L93,394@21074L1339,450@24077L3165:BasicTextField.kt#423gt5");
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 6) == 0) {
            i4 = (startRestartGroup.changed(textFieldState) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        int i25 = i3 & 2;
        if (i25 != 0) {
            i4 |= 48;
        } else if ((i & 48) == 0) {
            i4 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i5 = i3 & 4;
            if (i5 == 0) {
                i4 |= 384;
            } else if ((i & 384) == 0) {
                i4 |= startRestartGroup.changed(z) ? Fields.RotationX : Fields.SpotShadowColor;
                i6 = i3 & 8;
                int i26 = Fields.RotationZ;
                if (i6 != 0) {
                    i4 |= 3072;
                } else if ((i & 3072) == 0) {
                    i4 |= startRestartGroup.changed(z2) ? Fields.CameraDistance : 1024;
                    i7 = i3 & 16;
                    if (i7 == 0) {
                        i4 |= 24576;
                    } else if ((i & 24576) == 0) {
                        i4 |= startRestartGroup.changed(inputTransformation) ? Fields.Clip : Fields.Shape;
                        i8 = i3 & 32;
                        if (i8 != 0) {
                            i4 |= 196608;
                        } else if ((i & 196608) == 0) {
                            i4 |= startRestartGroup.changed(textStyle) ? Fields.RenderEffect : 65536;
                        }
                        i9 = i3 & 64;
                        if (i9 != 0) {
                            i4 |= 1572864;
                        } else if ((i & 1572864) == 0) {
                            i4 |= startRestartGroup.changed(keyboardOptions) ? 1048576 : Fields.BlendMode;
                        }
                        i10 = i3 & Fields.SpotShadowColor;
                        if (i10 != 0) {
                            i4 |= 12582912;
                        } else if ((i & 12582912) == 0) {
                            i4 |= startRestartGroup.changed(keyboardActionHandler) ? 8388608 : 4194304;
                        }
                        i11 = i3 & Fields.RotationX;
                        if (i11 != 0) {
                            i4 |= 100663296;
                        } else if ((i & 100663296) == 0) {
                            i4 |= startRestartGroup.changed(textFieldLineLimits) ? 67108864 : 33554432;
                        }
                        i12 = i3 & Fields.RotationY;
                        if (i12 != 0) {
                            i4 |= 805306368;
                        } else if ((i & 805306368) == 0) {
                            i4 |= startRestartGroup.changedInstance(function2) ? 536870912 : 268435456;
                        }
                        i13 = i3 & Fields.RotationZ;
                        if (i13 != 0) {
                            i14 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            i14 = i2 | (startRestartGroup.changed(mutableInteractionSource) ? 4 : 2);
                        } else {
                            i14 = i2;
                        }
                        i15 = i3 & Fields.CameraDistance;
                        if (i15 != 0) {
                            i14 |= 48;
                        } else if ((i2 & 48) == 0) {
                            i14 |= startRestartGroup.changed(brush) ? 32 : 16;
                        }
                        i16 = i14;
                        i17 = i3 & Fields.TransformOrigin;
                        if (i17 != 0) {
                            i16 |= 384;
                        } else if ((i2 & 384) == 0) {
                            i16 |= startRestartGroup.changed(codepointTransformation) ? Fields.RotationX : Fields.SpotShadowColor;
                            i18 = i3 & Fields.Shape;
                            if (i18 == 0) {
                                i16 |= 3072;
                                i19 = i18;
                            } else {
                                i19 = i18;
                                if ((i2 & 3072) == 0) {
                                    if (startRestartGroup.changed(outputTransformation)) {
                                        i26 = Fields.CameraDistance;
                                    }
                                    i16 |= i26;
                                    i20 = i3 & Fields.Clip;
                                    if (i20 != 0) {
                                        i16 |= 24576;
                                        i21 = i20;
                                    } else {
                                        i21 = i20;
                                        if ((i2 & 24576) == 0) {
                                            i16 |= (i2 & Fields.CompositingStrategy) == 0 ? startRestartGroup.changed(textFieldDecorator) : startRestartGroup.changedInstance(textFieldDecorator) ? Fields.Clip : Fields.Shape;
                                        }
                                    }
                                    if ((196608 & i2) == 0) {
                                        if ((i3 & Fields.CompositingStrategy) == 0 && startRestartGroup.changed(scrollState)) {
                                            i24 = Fields.RenderEffect;
                                            i16 |= i24;
                                        }
                                        i24 = 65536;
                                        i16 |= i24;
                                    }
                                    i22 = i3 & 65536;
                                    if (i22 != 0) {
                                        i16 |= 1572864;
                                    } else if ((i2 & 1572864) == 0) {
                                        i16 |= startRestartGroup.changed(z3) ? 1048576 : Fields.BlendMode;
                                    }
                                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (599187 & i16) != 599186, i4 & 1)) {
                                        startRestartGroup.startDefaults();
                                        ComposerKt.sourceInformation(startRestartGroup, "247@14085L21");
                                        if ((i & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                            startRestartGroup.skipToGroupEnd();
                                            if ((i3 & Fields.CompositingStrategy) != 0) {
                                                i16 &= -458753;
                                            }
                                            companion = modifier;
                                            z7 = z;
                                            z5 = z2;
                                            inputTransformation3 = inputTransformation;
                                            textStyle3 = textStyle;
                                            keyboardOptions3 = keyboardOptions;
                                            keyboardActionHandler3 = keyboardActionHandler;
                                            textFieldLineLimits3 = textFieldLineLimits;
                                            function23 = function2;
                                            mutableInteractionSource3 = mutableInteractionSource;
                                            codepointTransformation3 = codepointTransformation;
                                            outputTransformation3 = outputTransformation;
                                            textFieldDecorator3 = textFieldDecorator;
                                            scrollState3 = scrollState;
                                            z8 = z3;
                                            i23 = i16;
                                            brush3 = brush;
                                        } else {
                                            companion = i25 != 0 ? Modifier.INSTANCE : modifier;
                                            z7 = i5 != 0 ? true : z;
                                            z5 = i6 != 0 ? false : z2;
                                            InputTransformation inputTransformation4 = i7 != 0 ? null : inputTransformation;
                                            textStyle3 = i8 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                            KeyboardOptions keyboardOptions4 = i9 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                            keyboardActionHandler3 = i10 != 0 ? null : keyboardActionHandler;
                                            TextFieldLineLimits textFieldLineLimits5 = i11 != 0 ? TextFieldLineLimits.INSTANCE.getDefault() : textFieldLineLimits;
                                            Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function24 = i12 != 0 ? null : function2;
                                            MutableInteractionSource mutableInteractionSource6 = i13 != 0 ? null : mutableInteractionSource;
                                            SolidColor cursorBrush = i15 != 0 ? BasicTextFieldDefaults.INSTANCE.getCursorBrush() : brush;
                                            codepointTransformation3 = i17 != 0 ? null : codepointTransformation;
                                            OutputTransformation outputTransformation6 = i19 != 0 ? null : outputTransformation;
                                            textFieldDecorator3 = i21 != 0 ? null : textFieldDecorator;
                                            if ((i3 & Fields.CompositingStrategy) != 0) {
                                                scrollState3 = ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1);
                                                i16 &= -458753;
                                            } else {
                                                scrollState3 = scrollState;
                                            }
                                            i23 = i16;
                                            inputTransformation3 = inputTransformation4;
                                            outputTransformation3 = outputTransformation6;
                                            z8 = i22 != 0 ? false : z3;
                                            brush3 = cursorBrush;
                                            mutableInteractionSource3 = mutableInteractionSource6;
                                            function23 = function24;
                                            textFieldLineLimits3 = textFieldLineLimits5;
                                            keyboardOptions3 = keyboardOptions4;
                                        }
                                        startRestartGroup.endDefaults();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(965149429, i4, i23, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:251)");
                                        }
                                        ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
                                        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function25 = function23;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume = startRestartGroup.consume(localDensity);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final Density density = (Density) consume;
                                        final Brush brush4 = brush3;
                                        ProvidableCompositionLocal localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume2 = startRestartGroup.consume(localLayoutDirection);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        LayoutDirection layoutDirection = (LayoutDirection) consume2;
                                        final boolean areEqual = Intrinsics.areEqual(textFieldLineLimits3, TextFieldLineLimits.SingleLine.INSTANCE);
                                        if (mutableInteractionSource3 == null) {
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                            startRestartGroup.startReplaceGroup(-2038064986);
                                            ComposerKt.sourceInformation(startRestartGroup, "257@14551L39");
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -204291364, "CC(remember):BasicTextField.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            textFieldLineLimits4 = textFieldLineLimits3;
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            mutableInteractionSource3 = (MutableInteractionSource) rememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            textFieldLineLimits4 = textFieldLineLimits3;
                                            mutableInteractionSource4 = mutableInteractionSource3;
                                            startRestartGroup.startReplaceGroup(-204292015);
                                        }
                                        startRestartGroup.endReplaceGroup();
                                        final Orientation orientation = areEqual ? Orientation.Horizontal : Orientation.Vertical;
                                        MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource3;
                                        boolean booleanValue = FocusInteractionKt.collectIsFocusedAsState(mutableInteractionSource7, startRestartGroup, 0).getValue().booleanValue();
                                        final boolean booleanValue2 = HoverInteractionKt.collectIsHoveredAsState(mutableInteractionSource7, startRestartGroup, 0).getValue().booleanValue();
                                        if (booleanValue) {
                                            startRestartGroup.startReplaceGroup(-204274364);
                                            ComposerKt.sourceInformation(startRestartGroup, "263@15075L7");
                                            ProvidableCompositionLocal localWindowInfo = CompositionLocalsKt.getLocalWindowInfo();
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                            Object consume3 = startRestartGroup.consume(localWindowInfo);
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                            boolean isWindowFocused = ((WindowInfo) consume3).isWindowFocused();
                                            startRestartGroup.endReplaceGroup();
                                            z9 = isWindowFocused;
                                        } else {
                                            startRestartGroup.startReplaceGroup(-2037536751);
                                            startRestartGroup.endReplaceGroup();
                                            z9 = false;
                                        }
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -204272640, "CC(remember):BasicTextField.kt#9igjgp");
                                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                                        if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                            modifier3 = companion;
                                            keyboardActionHandler4 = keyboardActionHandler3;
                                            mutableInteractionSource5 = mutableInteractionSource3;
                                            rememberedValue2 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_LATEST, 2, (Object) null);
                                            startRestartGroup.updateRememberedValue(rememberedValue2);
                                        } else {
                                            modifier3 = companion;
                                            keyboardActionHandler4 = keyboardActionHandler3;
                                            mutableInteractionSource5 = mutableInteractionSource3;
                                        }
                                        final MutableSharedFlow mutableSharedFlow = (MutableSharedFlow) rememberedValue2;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -204267293, "CC(remember):BasicTextField.kt#9igjgp");
                                        boolean z10 = ((i4 & 14) == 4) | ((i23 & 896) == 256) | ((i23 & 7168) == 2048);
                                        Object rememberedValue3 = startRestartGroup.rememberedValue();
                                        if (z10 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                            if (codepointTransformation3 == null) {
                                                SingleLineCodepointTransformation singleLineCodepointTransformation2 = SingleLineCodepointTransformation.INSTANCE;
                                                if (!areEqual) {
                                                    singleLineCodepointTransformation2 = null;
                                                }
                                                singleLineCodepointTransformation = singleLineCodepointTransformation2;
                                            } else {
                                                singleLineCodepointTransformation = codepointTransformation3;
                                            }
                                            outputTransformation4 = outputTransformation3;
                                            rememberedValue3 = new TransformedTextFieldState(textFieldState, inputTransformation3, singleLineCodepointTransformation, outputTransformation4);
                                            startRestartGroup.updateRememberedValue(rememberedValue3);
                                        } else {
                                            outputTransformation4 = outputTransformation3;
                                        }
                                        final TransformedTextFieldState transformedTextFieldState = (TransformedTextFieldState) rememberedValue3;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -204234683, "CC(remember):BasicTextField.kt#9igjgp");
                                        boolean changed = startRestartGroup.changed(transformedTextFieldState);
                                        Object rememberedValue4 = startRestartGroup.rememberedValue();
                                        if (changed || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue4 = new TextLayoutState();
                                            startRestartGroup.updateRememberedValue(rememberedValue4);
                                        }
                                        final TextLayoutState textLayoutState = (TextLayoutState) rememberedValue4;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final KeyboardOptions fillUnspecifiedValuesWith$foundation_release = keyboardOptions3.fillUnspecifiedValuesWith$foundation_release(inputTransformation3 != null ? inputTransformation3.getKeyboardOptions() : null);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
                                        Object rememberedValue5 = startRestartGroup.rememberedValue();
                                        if (rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue5 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup);
                                            startRestartGroup.updateRememberedValue(rememberedValue5);
                                        }
                                        CoroutineScope coroutineScope = (CoroutineScope) rememberedValue5;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        if (ComposeFoundationFlags.isSmartSelectionEnabled) {
                                            startRestartGroup.startReplaceGroup(-2035764848);
                                            ComposerKt.sourceInformation(startRestartGroup, "299@16959L85");
                                            LocaleList localeList = textStyle3.getLocaleList();
                                            if (localeList == null) {
                                                localeList = LocaleList.Companion.getCurrent();
                                            }
                                            outputTransformation5 = outputTransformation4;
                                            codepointTransformation2 = codepointTransformation3;
                                            PlatformSelectionBehaviors rememberPlatformSelectionBehaviors = PlatformSelectionBehaviors_androidKt.rememberPlatformSelectionBehaviors(SelectedTextType.EditableText, localeList, startRestartGroup, 6);
                                            startRestartGroup.endReplaceGroup();
                                            platformSelectionBehaviors = rememberPlatformSelectionBehaviors;
                                        } else {
                                            outputTransformation5 = outputTransformation4;
                                            codepointTransformation2 = codepointTransformation3;
                                            startRestartGroup.startReplaceGroup(-2035576399);
                                            startRestartGroup.endReplaceGroup();
                                            platformSelectionBehaviors = null;
                                        }
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -204209288, "CC(remember):BasicTextField.kt#9igjgp");
                                        Object rememberedValue6 = startRestartGroup.rememberedValue();
                                        if (rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue6 = new ToolbarRequesterImpl();
                                            startRestartGroup.updateRememberedValue(rememberedValue6);
                                        }
                                        final ToolbarRequesterImpl toolbarRequesterImpl = (ToolbarRequesterImpl) rememberedValue6;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ProvidableCompositionLocal localClipboard = CompositionLocalsKt.getLocalClipboard();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume4 = startRestartGroup.consume(localClipboard);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final Clipboard clipboard = (Clipboard) consume4;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -204204610, "CC(remember):BasicTextField.kt#9igjgp");
                                        boolean changed2 = startRestartGroup.changed(transformedTextFieldState);
                                        Object rememberedValue7 = startRestartGroup.rememberedValue();
                                        if (changed2 || rememberedValue7 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue7 = new TextFieldSelectionState(transformedTextFieldState, textLayoutState, density, z7, z5, z9, z8, toolbarRequesterImpl, coroutineScope, platformSelectionBehaviors, clipboard);
                                            startRestartGroup.updateRememberedValue(rememberedValue7);
                                        }
                                        final TextFieldSelectionState textFieldSelectionState = (TextFieldSelectionState) rememberedValue7;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ProvidableCompositionLocal localHapticFeedback = CompositionLocalsKt.getLocalHapticFeedback();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume5 = startRestartGroup.consume(localHapticFeedback);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        final HapticFeedback hapticFeedback = (HapticFeedback) consume5;
                                        KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                        ProvidableCompositionLocal localTextToolbar = CompositionLocalsKt.getLocalTextToolbar();
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                                        Object consume6 = startRestartGroup.consume(localTextToolbar);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        TextToolbar textToolbar = (TextToolbar) consume6;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -204178455, "CC(remember):BasicTextField.kt#9igjgp");
                                        boolean changed3 = startRestartGroup.changed(coroutineScope) | startRestartGroup.changed(textToolbar);
                                        Object rememberedValue8 = startRestartGroup.rememberedValue();
                                        if (changed3 || rememberedValue8 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue8 = new BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1(textToolbar, coroutineScope);
                                            startRestartGroup.updateRememberedValue(rememberedValue8);
                                        }
                                        final BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 basicTextFieldKt$BasicTextField$textToolbarHandler$1$1 = (BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1) rememberedValue8;
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -204111309, "CC(remember):BasicTextField.kt#9igjgp");
                                        boolean changed4 = startRestartGroup.changed(transformedTextFieldState) | ((57344 & i4) == 16384) | startRestartGroup.changedInstance(textFieldSelectionState) | startRestartGroup.changedInstance(hapticFeedback) | startRestartGroup.changedInstance(clipboard) | startRestartGroup.changed(basicTextFieldKt$BasicTextField$textToolbarHandler$1$1) | startRestartGroup.changed(density) | ((i4 & 896) == 256) | ((i4 & 7168) == 2048) | ((3670016 & i23) == 1048576);
                                        Object rememberedValue9 = startRestartGroup.rememberedValue();
                                        if (changed4 || rememberedValue9 == Composer.INSTANCE.getEmpty()) {
                                            final InputTransformation inputTransformation5 = inputTransformation3;
                                            final boolean z11 = z7;
                                            final boolean z12 = z5;
                                            final boolean z13 = z8;
                                            rememberedValue9 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda5
                                                public final Object invoke() {
                                                    Unit BasicTextField$lambda$10$lambda$9;
                                                    BasicTextField$lambda$10$lambda$9 = BasicTextFieldKt.BasicTextField$lambda$10$lambda$9(TransformedTextFieldState.this, inputTransformation5, textFieldSelectionState, hapticFeedback, clipboard, basicTextFieldKt$BasicTextField$textToolbarHandler$1$1, density, z11, z12, z13);
                                                    return BasicTextField$lambda$10$lambda$9;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue9);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        EffectsKt.SideEffect((Function0) rememberedValue9, startRestartGroup, 0);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -204093912, "CC(remember):BasicTextField.kt#9igjgp");
                                        boolean changedInstance = startRestartGroup.changedInstance(textFieldSelectionState);
                                        Object rememberedValue10 = startRestartGroup.rememberedValue();
                                        if (changedInstance || rememberedValue10 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue10 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda6
                                                public final Object invoke(Object obj) {
                                                    DisposableEffectResult BasicTextField$lambda$13$lambda$12;
                                                    BasicTextField$lambda$13$lambda$12 = BasicTextFieldKt.BasicTextField$lambda$13$lambda$12(TextFieldSelectionState.this, (DisposableEffectScope) obj);
                                                    return BasicTextField$lambda$13$lambda$12;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue10);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        EffectsKt.DisposableEffect(textFieldSelectionState, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) rememberedValue10, startRestartGroup, 0);
                                        final boolean z14 = (z8 || KeyboardType.equals-impl0(keyboardOptions5.getKeyboardType(), KeyboardType.Companion.getPassword-PjHm6EE()) || KeyboardType.equals-impl0(keyboardOptions5.getKeyboardType(), KeyboardType.Companion.getNumberPassword-PjHm6EE())) ? false : true;
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -204081328, "CC(remember):BasicTextField.kt#9igjgp");
                                        boolean changed5 = startRestartGroup.changed(z14) | startRestartGroup.changedInstance(mutableSharedFlow);
                                        Object rememberedValue11 = startRestartGroup.rememberedValue();
                                        if (changed5 || rememberedValue11 == Composer.INSTANCE.getEmpty()) {
                                            rememberedValue11 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda7
                                                public final Object invoke() {
                                                    Unit BasicTextField$lambda$15$lambda$14;
                                                    BasicTextField$lambda$15$lambda$14 = BasicTextFieldKt.BasicTextField$lambda$15$lambda$14(z14, mutableSharedFlow);
                                                    return BasicTextField$lambda$15$lambda$14;
                                                }
                                            };
                                            startRestartGroup.updateRememberedValue(rememberedValue11);
                                        }
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        modifier2 = modifier3;
                                        Modifier addContextMenuComponents = addContextMenuComponents(PointerIconKt.pointerHoverIcon$default(ScrollableKt.scrollable$default(StylusHandwritingKt.stylusHandwriting(modifier2, z7, z14, (Function0) rememberedValue11).then((Modifier) new TextFieldDecoratorModifier(transformedTextFieldState, textLayoutState, textFieldSelectionState, inputTransformation3, z7, z5, fillUnspecifiedValuesWith$foundation_release, keyboardActionHandler4, areEqual, mutableInteractionSource5, z8, mutableSharedFlow)), scrollState3, orientation, z7 && textFieldSelectionState.getDirectDragGestureInitiator() == TextFieldSelectionState.InputType.None, ScrollableDefaults.INSTANCE.reverseDirection(layoutDirection, orientation, false), null, mutableInteractionSource5, 16, null), PointerIcon.INSTANCE.getText(), false, 2, null), textFieldSelectionState, coroutineScope);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                        int hashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(startRestartGroup, 0));
                                        CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                                        Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, addContextMenuComponents);
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
                                        ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1520421984, "C451@24194L3042,451@24144L3092:BasicTextField.kt#423gt5");
                                        final TextFieldDecorator textFieldDecorator4 = textFieldDecorator3;
                                        final TextFieldLineLimits textFieldLineLimits6 = textFieldLineLimits4;
                                        final TextStyle textStyle4 = textStyle3;
                                        final boolean z15 = z7;
                                        final boolean z16 = z5;
                                        final ScrollState scrollState4 = scrollState3;
                                        ContextMenu_androidKt.ContextMenuArea(textFieldSelectionState, z7, ComposableLambdaKt.rememberComposableLambda(-673241599, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1
                                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                invoke((Composer) obj, ((Number) obj2).intValue());
                                                return Unit.INSTANCE;
                                            }

                                            public final void invoke(Composer composer2, int i27) {
                                                ComposerKt.sourceInformation(composer2, "C453@24310L2916,453@24299L2927:BasicTextField.kt#423gt5");
                                                if (!composer2.shouldExecute((i27 & 3) != 2, i27 & 1)) {
                                                    composer2.skipToGroupEnd();
                                                    return;
                                                }
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventStart(-673241599, i27, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous> (BasicTextField.kt:452)");
                                                }
                                                TextFieldDecorator textFieldDecorator5 = TextFieldDecorator.this;
                                                if (textFieldDecorator5 == null) {
                                                    textFieldDecorator5 = BasicTextFieldKt.DefaultTextFieldDecorator;
                                                }
                                                final TextFieldLineLimits textFieldLineLimits7 = textFieldLineLimits6;
                                                final TextLayoutState textLayoutState2 = textLayoutState;
                                                final TextStyle textStyle5 = textStyle4;
                                                final boolean z17 = z9;
                                                final boolean z18 = booleanValue2;
                                                final TransformedTextFieldState transformedTextFieldState2 = transformedTextFieldState;
                                                final TextFieldSelectionState textFieldSelectionState2 = textFieldSelectionState;
                                                final Brush brush5 = brush4;
                                                final boolean z19 = z15;
                                                final boolean z20 = z16;
                                                final ScrollState scrollState5 = scrollState4;
                                                final Orientation orientation2 = orientation;
                                                final ToolbarRequesterImpl toolbarRequesterImpl2 = toolbarRequesterImpl;
                                                final PlatformSelectionBehaviors platformSelectionBehaviors2 = platformSelectionBehaviors;
                                                final boolean z21 = areEqual;
                                                final Function2<Density, Function0<TextLayoutResult>, Unit> function26 = function25;
                                                final KeyboardOptions keyboardOptions6 = fillUnspecifiedValuesWith$foundation_release;
                                                textFieldDecorator5.Decoration(ComposableLambdaKt.rememberComposableLambda(1969169726, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$4$1.1
                                                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                                        invoke((Composer) obj, ((Number) obj2).intValue());
                                                        return Unit.INSTANCE;
                                                    }

                                                    public final void invoke(Composer composer3, int i28) {
                                                        int i29;
                                                        int i30;
                                                        ComposerKt.sourceInformation(composer3, "C464@24671L2541:BasicTextField.kt#423gt5");
                                                        if (!composer3.shouldExecute((i28 & 3) != 2, i28 & 1)) {
                                                            composer3.skipToGroupEnd();
                                                            return;
                                                        }
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventStart(1969169726, i28, -1, "androidx.compose.foundation.text.BasicTextField.<anonymous>.<anonymous>.<anonymous> (BasicTextField.kt:454)");
                                                        }
                                                        TextFieldLineLimits textFieldLineLimits8 = TextFieldLineLimits.this;
                                                        if (textFieldLineLimits8 instanceof TextFieldLineLimits.MultiLine) {
                                                            i29 = ((TextFieldLineLimits.MultiLine) textFieldLineLimits8).getMinHeightInLines();
                                                            i30 = ((TextFieldLineLimits.MultiLine) TextFieldLineLimits.this).getMaxHeightInLines();
                                                        } else {
                                                            i29 = 1;
                                                            i30 = 1;
                                                        }
                                                        Modifier then = ClipKt.clipToBounds(TextFieldSizeKt.textFieldMinSize(HeightInLinesModifierKt.heightInLines(SizeKt.m1108heightInVpY3zN4$default(Modifier.INSTANCE, textLayoutState2.m1885getMinHeightForSingleLineFieldD9Ej5fM(), 0.0f, 2, null), textStyle5, i29, i30), textStyle5)).then((Modifier) new TextFieldCoreModifier(z17, z18, textLayoutState2, transformedTextFieldState2, textFieldSelectionState2, brush5, z19 && !z20, scrollState5, orientation2, toolbarRequesterImpl2, platformSelectionBehaviors2));
                                                        TextLayoutState textLayoutState3 = textLayoutState2;
                                                        TransformedTextFieldState transformedTextFieldState3 = transformedTextFieldState2;
                                                        TextStyle textStyle6 = textStyle5;
                                                        boolean z22 = z21;
                                                        Function2<Density, Function0<TextLayoutResult>, Unit> function27 = function26;
                                                        KeyboardOptions keyboardOptions7 = keyboardOptions6;
                                                        boolean z23 = z19;
                                                        boolean z24 = z17;
                                                        TextFieldSelectionState textFieldSelectionState3 = textFieldSelectionState2;
                                                        boolean z25 = z20;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true);
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -1159599143, "CC(Layout)P(!1,2)80@3267L27,83@3433L360:Layout.kt#80mrfh");
                                                        int hashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer3, 0));
                                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                                        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, then);
                                                        Function0 constructor2 = ComposeUiNode.Companion.getConstructor();
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                                                        if (!(composer3.getApplier() instanceof Applier)) {
                                                            ComposablesKt.invalidApplier();
                                                        }
                                                        composer3.startReusableNode();
                                                        if (composer3.getInserting()) {
                                                            composer3.createNode(constructor2);
                                                        } else {
                                                            composer3.useNode();
                                                        }
                                                        Composer m4109constructorimpl2 = Updater.m4109constructorimpl(composer3);
                                                        Updater.m4116setimpl(m4109constructorimpl2, maybeCachedBoxMeasurePolicy2, (Function2<? super T, ? super MeasurePolicy, Unit>) ComposeUiNode.Companion.getSetMeasurePolicy());
                                                        Updater.m4116setimpl(m4109constructorimpl2, currentCompositionLocalMap2, (Function2<? super T, ? super CompositionLocalMap, Unit>) ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                                                        Function2 setCompositeKeyHash2 = ComposeUiNode.Companion.getSetCompositeKeyHash();
                                                        if (m4109constructorimpl2.getInserting() || !Intrinsics.areEqual(m4109constructorimpl2.rememberedValue(), Integer.valueOf(hashCode2))) {
                                                            m4109constructorimpl2.updateRememberedValue(Integer.valueOf(hashCode2));
                                                            m4109constructorimpl2.apply(Integer.valueOf(hashCode2), setCompositeKeyHash2);
                                                        }
                                                        Updater.m4116setimpl(m4109constructorimpl2, materializeModifier2, (Function2<? super T, ? super Modifier, Unit>) ComposeUiNode.Companion.getSetModifier());
                                                        ComposerKt.sourceInformationMarkerStart(composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                                        ComposerKt.sourceInformationMarkerStart(composer3, -811364182, "C491@26181L530:BasicTextField.kt#423gt5");
                                                        BoxKt.Box((Modifier) new TextFieldTextLayoutModifier(textLayoutState3, transformedTextFieldState3, textStyle6, z22, function27, keyboardOptions7), composer3, 0);
                                                        if (z23 && z24 && textFieldSelectionState3.isInTouchMode()) {
                                                            composer3.startReplaceGroup(-810654004);
                                                            ComposerKt.sourceInformation(composer3, "508@26946L67");
                                                            BasicTextFieldKt.TextFieldSelectionHandles(textFieldSelectionState3, composer3, 0);
                                                            if (!z25) {
                                                                composer3.startReplaceGroup(-810526873);
                                                                ComposerKt.sourceInformation(composer3, "510@27083L63");
                                                                BasicTextFieldKt.TextFieldCursorHandle(textFieldSelectionState3, composer3, 0);
                                                                composer3.endReplaceGroup();
                                                            } else {
                                                                composer3.startReplaceGroup(-810412514);
                                                                composer3.endReplaceGroup();
                                                            }
                                                            composer3.endReplaceGroup();
                                                        } else {
                                                            composer3.startReplaceGroup(-810390690);
                                                            composer3.endReplaceGroup();
                                                        }
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        composer3.endNode();
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                                        if (ComposerKt.isTraceInProgress()) {
                                                            ComposerKt.traceEventEnd();
                                                        }
                                                    }
                                                }, composer2, 54), composer2, 6);
                                                if (ComposerKt.isTraceInProgress()) {
                                                    ComposerKt.traceEventEnd();
                                                }
                                            }
                                        }, startRestartGroup, 54), startRestartGroup, ((i4 >> 3) & 112) | 384);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        startRestartGroup.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        function22 = function25;
                                        brush2 = brush4;
                                        mutableInteractionSource2 = mutableInteractionSource4;
                                        inputTransformation2 = inputTransformation3;
                                        z4 = z7;
                                        z6 = z8;
                                        textFieldDecorator2 = textFieldDecorator3;
                                        textStyle2 = textStyle3;
                                        scrollState2 = scrollState3;
                                        textFieldLineLimits2 = textFieldLineLimits4;
                                        outputTransformation2 = outputTransformation5;
                                        keyboardActionHandler2 = keyboardActionHandler4;
                                        keyboardOptions2 = keyboardOptions5;
                                    } else {
                                        startRestartGroup.skipToGroupEnd();
                                        modifier2 = modifier;
                                        z4 = z;
                                        z5 = z2;
                                        inputTransformation2 = inputTransformation;
                                        textStyle2 = textStyle;
                                        keyboardOptions2 = keyboardOptions;
                                        keyboardActionHandler2 = keyboardActionHandler;
                                        textFieldLineLimits2 = textFieldLineLimits;
                                        function22 = function2;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush2 = brush;
                                        codepointTransformation2 = codepointTransformation;
                                        outputTransformation2 = outputTransformation;
                                        textFieldDecorator2 = textFieldDecorator;
                                        scrollState2 = scrollState;
                                        z6 = z3;
                                    }
                                    endRestartGroup = startRestartGroup.endRestartGroup();
                                    if (endRestartGroup != null) {
                                        final Modifier modifier4 = modifier2;
                                        final boolean z17 = z5;
                                        final Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> function26 = function22;
                                        final MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource2;
                                        final Brush brush5 = brush2;
                                        final CodepointTransformation codepointTransformation4 = codepointTransformation2;
                                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda8
                                            public final Object invoke(Object obj, Object obj2) {
                                                Unit BasicTextField$lambda$17;
                                                BasicTextField$lambda$17 = BasicTextFieldKt.BasicTextField$lambda$17(TextFieldState.this, modifier4, z4, z17, inputTransformation2, textStyle2, keyboardOptions2, keyboardActionHandler2, textFieldLineLimits2, function26, mutableInteractionSource8, brush5, codepointTransformation4, outputTransformation2, textFieldDecorator2, scrollState2, z6, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                                return BasicTextField$lambda$17;
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                            }
                            i20 = i3 & Fields.Clip;
                            if (i20 != 0) {
                            }
                            if ((196608 & i2) == 0) {
                            }
                            i22 = i3 & 65536;
                            if (i22 != 0) {
                            }
                            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (599187 & i16) != 599186, i4 & 1)) {
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i18 = i3 & Fields.Shape;
                        if (i18 == 0) {
                        }
                        i20 = i3 & Fields.Clip;
                        if (i20 != 0) {
                        }
                        if ((196608 & i2) == 0) {
                        }
                        i22 = i3 & 65536;
                        if (i22 != 0) {
                        }
                        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (599187 & i16) != 599186, i4 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                        }
                    }
                    i8 = i3 & 32;
                    if (i8 != 0) {
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                    }
                    i10 = i3 & Fields.SpotShadowColor;
                    if (i10 != 0) {
                    }
                    i11 = i3 & Fields.RotationX;
                    if (i11 != 0) {
                    }
                    i12 = i3 & Fields.RotationY;
                    if (i12 != 0) {
                    }
                    i13 = i3 & Fields.RotationZ;
                    if (i13 != 0) {
                    }
                    i15 = i3 & Fields.CameraDistance;
                    if (i15 != 0) {
                    }
                    i16 = i14;
                    i17 = i3 & Fields.TransformOrigin;
                    if (i17 != 0) {
                    }
                    i18 = i3 & Fields.Shape;
                    if (i18 == 0) {
                    }
                    i20 = i3 & Fields.Clip;
                    if (i20 != 0) {
                    }
                    if ((196608 & i2) == 0) {
                    }
                    i22 = i3 & 65536;
                    if (i22 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (599187 & i16) != 599186, i4 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                i7 = i3 & 16;
                if (i7 == 0) {
                }
                i8 = i3 & 32;
                if (i8 != 0) {
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                }
                i10 = i3 & Fields.SpotShadowColor;
                if (i10 != 0) {
                }
                i11 = i3 & Fields.RotationX;
                if (i11 != 0) {
                }
                i12 = i3 & Fields.RotationY;
                if (i12 != 0) {
                }
                i13 = i3 & Fields.RotationZ;
                if (i13 != 0) {
                }
                i15 = i3 & Fields.CameraDistance;
                if (i15 != 0) {
                }
                i16 = i14;
                i17 = i3 & Fields.TransformOrigin;
                if (i17 != 0) {
                }
                i18 = i3 & Fields.Shape;
                if (i18 == 0) {
                }
                i20 = i3 & Fields.Clip;
                if (i20 != 0) {
                }
                if ((196608 & i2) == 0) {
                }
                i22 = i3 & 65536;
                if (i22 != 0) {
                }
                if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (599187 & i16) != 599186, i4 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i6 = i3 & 8;
            int i262 = Fields.RotationZ;
            if (i6 != 0) {
            }
            i7 = i3 & 16;
            if (i7 == 0) {
            }
            i8 = i3 & 32;
            if (i8 != 0) {
            }
            i9 = i3 & 64;
            if (i9 != 0) {
            }
            i10 = i3 & Fields.SpotShadowColor;
            if (i10 != 0) {
            }
            i11 = i3 & Fields.RotationX;
            if (i11 != 0) {
            }
            i12 = i3 & Fields.RotationY;
            if (i12 != 0) {
            }
            i13 = i3 & Fields.RotationZ;
            if (i13 != 0) {
            }
            i15 = i3 & Fields.CameraDistance;
            if (i15 != 0) {
            }
            i16 = i14;
            i17 = i3 & Fields.TransformOrigin;
            if (i17 != 0) {
            }
            i18 = i3 & Fields.Shape;
            if (i18 == 0) {
            }
            i20 = i3 & Fields.Clip;
            if (i20 != 0) {
            }
            if ((196608 & i2) == 0) {
            }
            i22 = i3 & 65536;
            if (i22 != 0) {
            }
            if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (599187 & i16) != 599186, i4 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i5 = i3 & 4;
        if (i5 == 0) {
        }
        i6 = i3 & 8;
        int i2622 = Fields.RotationZ;
        if (i6 != 0) {
        }
        i7 = i3 & 16;
        if (i7 == 0) {
        }
        i8 = i3 & 32;
        if (i8 != 0) {
        }
        i9 = i3 & 64;
        if (i9 != 0) {
        }
        i10 = i3 & Fields.SpotShadowColor;
        if (i10 != 0) {
        }
        i11 = i3 & Fields.RotationX;
        if (i11 != 0) {
        }
        i12 = i3 & Fields.RotationY;
        if (i12 != 0) {
        }
        i13 = i3 & Fields.RotationZ;
        if (i13 != 0) {
        }
        i15 = i3 & Fields.CameraDistance;
        if (i15 != 0) {
        }
        i16 = i14;
        i17 = i3 & Fields.TransformOrigin;
        if (i17 != 0) {
        }
        i18 = i3 & Fields.Shape;
        if (i18 == 0) {
        }
        i20 = i3 & Fields.Clip;
        if (i20 != 0) {
        }
        if ((196608 & i2) == 0) {
        }
        i22 = i3 & 65536;
        if (i22 != 0) {
        }
        if (startRestartGroup.shouldExecute((i4 & 306783379) == 306783378 || (599187 & i16) != 599186, i4 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$10$lambda$9(TransformedTextFieldState transformedTextFieldState, InputTransformation inputTransformation, TextFieldSelectionState textFieldSelectionState, HapticFeedback hapticFeedback, Clipboard clipboard, BasicTextFieldKt$BasicTextField$textToolbarHandler$1$1 basicTextFieldKt$BasicTextField$textToolbarHandler$1$1, Density density, boolean z, boolean z2, boolean z3) {
        transformedTextFieldState.update(inputTransformation);
        textFieldSelectionState.update(hapticFeedback, clipboard, basicTextFieldKt$BasicTextField$textToolbarHandler$1$1, density, z, z2, z3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$15$lambda$14(boolean z, MutableSharedFlow mutableSharedFlow) {
        if (z) {
            mutableSharedFlow.tryEmit(Unit.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    private static final Modifier addContextMenuComponents(Modifier modifier, TextFieldSelectionState textFieldSelectionState, CoroutineScope coroutineScope) {
        return ComposeFoundationFlags.isNewContextMenuEnabled ? TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents(modifier, textFieldSelectionState, coroutineScope) : modifier;
    }

    public static final void TextFieldCursorHandle(final TextFieldSelectionState textFieldSelectionState, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(1991581797);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldCursorHandle)N(selectionState)532@27794L128:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1991581797, i2, -1, "androidx.compose.foundation.text.TextFieldCursorHandle (BasicTextField.kt:529)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1645300795, "CC(remember):BasicTextField.kt#9igjgp");
            boolean changed = startRestartGroup.changed(textFieldSelectionState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda18
                    public final Object invoke() {
                        TextFieldHandleState cursorHandleState$foundation_release;
                        cursorHandleState$foundation_release = TextFieldSelectionState.this.getCursorHandleState$foundation_release(false);
                        return cursorHandleState$foundation_release;
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (TextFieldCursorHandle$lambda$20((State) rememberedValue).getVisible()) {
                startRestartGroup.startReplaceGroup(535453998);
                ComposerKt.sourceInformation(startRestartGroup, "537@28011L100,541@28190L87,536@27968L383");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1645293879, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0, reason: not valid java name */
                        public final long mo1503provideF1C5BW0() {
                            return TextFieldSelectionState.this.getCursorHandleState$foundation_release(true).m1932getPositionF1C5BW0();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1645288164, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance2 = startRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldCursorHandle$2$1
                        @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object cursorHandleGestures = TextFieldSelectionState.this.cursorHandleGestures(pointerInputScope, continuation);
                            return cursorHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? cursorHandleGestures : Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidCursorHandle_androidKt.m1479CursorHandleUSBMPiE(offsetProvider, SuspendingPointerInputFilterKt.pointerInput(companion, textFieldSelectionState, (PointerInputEventHandler) rememberedValue3), MinTouchTargetSizeForHandles, startRestartGroup, 384, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(535837437);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda19
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextFieldCursorHandle$lambda$23;
                    TextFieldCursorHandle$lambda$23 = BasicTextFieldKt.TextFieldCursorHandle$lambda$23(TextFieldSelectionState.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextFieldCursorHandle$lambda$23;
                }
            });
        }
    }

    public static final void TextFieldSelectionHandles(final TextFieldSelectionState textFieldSelectionState, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(2025287684);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldSelectionHandles)N(selectionState)553@28557L240,582@29612L241:BasicTextField.kt#423gt5");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changedInstance(textFieldSelectionState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!startRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2025287684, i2, -1, "androidx.compose.foundation.text.TextFieldSelectionHandles (BasicTextField.kt:550)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 681285748, "CC(remember):BasicTextField.kt#9igjgp");
            boolean changed = startRestartGroup.changed(textFieldSelectionState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        TextFieldHandleState selectionHandleState$foundation_release;
                        selectionHandleState$foundation_release = TextFieldSelectionState.this.getSelectionHandleState$foundation_release(true, false);
                        return selectionHandleState$foundation_release;
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            State state = (State) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (TextFieldSelectionHandles$lambda$26(state).getVisible()) {
                startRestartGroup.startReplaceGroup(-354691912);
                ComposerKt.sourceInformation(startRestartGroup, "563@28888L167,572@29282L94,562@28842L662");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 681296267, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance = startRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$1$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0 */
                        public final long mo1503provideF1C5BW0() {
                            return TextFieldSelectionState.this.getSelectionHandleState$foundation_release(true, true).m1932getPositionF1C5BW0();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ResolvedTextDirection direction = TextFieldSelectionHandles$lambda$26(state).getDirection();
                boolean handlesCrossed = TextFieldSelectionHandles$lambda$26(state).getHandlesCrossed();
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 681308802, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance2 = startRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$2$1
                        @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object selectionHandleGestures = TextFieldSelectionState.this.selectionHandleGestures(pointerInputScope, true, continuation);
                            return selectionHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? selectionHandleGestures : Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidSelectionHandles_androidKt.m2045SelectionHandlewLIcFTc(offsetProvider, true, direction, handlesCrossed, MinTouchTargetSizeForHandles, TextFieldSelectionHandles$lambda$26(state).getLineHeight(), SuspendingPointerInputFilterKt.pointerInput(companion, textFieldSelectionState, (PointerInputEventHandler) rememberedValue3), startRestartGroup, 24624, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-354040354);
                startRestartGroup.endReplaceGroup();
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 681319509, "CC(remember):BasicTextField.kt#9igjgp");
            boolean changed2 = startRestartGroup.changed(textFieldSelectionState);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda11
                    public final Object invoke() {
                        TextFieldHandleState selectionHandleState$foundation_release;
                        selectionHandleState$foundation_release = TextFieldSelectionState.this.getSelectionHandleState$foundation_release(false, false);
                        return selectionHandleState$foundation_release;
                    }
                });
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            State state2 = (State) rememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            if (TextFieldSelectionHandles$lambda$31(state2).getVisible()) {
                startRestartGroup.startReplaceGroup(-353646437);
                ComposerKt.sourceInformation(startRestartGroup, "592@29942L168,601@30334L95,591@29896L659");
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 681329996, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance3 = startRestartGroup.changedInstance(textFieldSelectionState);
                OffsetProvider rememberedValue5 = startRestartGroup.rememberedValue();
                if (changedInstance3 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue5 = new OffsetProvider() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$3$1
                        @Override // androidx.compose.foundation.text.selection.OffsetProvider
                        /* renamed from: provide-F1C5BW0 */
                        public final long mo1503provideF1C5BW0() {
                            return TextFieldSelectionState.this.getSelectionHandleState$foundation_release(false, true).m1932getPositionF1C5BW0();
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue5);
                }
                OffsetProvider offsetProvider2 = (OffsetProvider) rememberedValue5;
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                ResolvedTextDirection direction2 = TextFieldSelectionHandles$lambda$31(state2).getDirection();
                boolean handlesCrossed2 = TextFieldSelectionHandles$lambda$31(state2).getHandlesCrossed();
                Modifier.Companion companion2 = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(startRestartGroup, 681342467, "CC(remember):BasicTextField.kt#9igjgp");
                boolean changedInstance4 = startRestartGroup.changedInstance(textFieldSelectionState);
                PointerInputEventHandler rememberedValue6 = startRestartGroup.rememberedValue();
                if (changedInstance4 || rememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue6 = new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$TextFieldSelectionHandles$4$1
                        @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
                        public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                            Object selectionHandleGestures = TextFieldSelectionState.this.selectionHandleGestures(pointerInputScope, false, continuation);
                            return selectionHandleGestures == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? selectionHandleGestures : Unit.INSTANCE;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                AndroidSelectionHandles_androidKt.m2045SelectionHandlewLIcFTc(offsetProvider2, false, direction2, handlesCrossed2, MinTouchTargetSizeForHandles, TextFieldSelectionHandles$lambda$31(state2).getLineHeight(), SuspendingPointerInputFilterKt.pointerInput(companion2, textFieldSelectionState, (PointerInputEventHandler) rememberedValue6), startRestartGroup, 24624, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-352997762);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda13
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextFieldSelectionHandles$lambda$34;
                    TextFieldSelectionHandles$lambda$34 = BasicTextFieldKt.TextFieldSelectionHandles$lambda$34(TextFieldSelectionState.this, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextFieldSelectionHandles$lambda$34;
                }
            });
        }
    }

    static {
        float f = 40;
        MinTouchTargetSizeForHandles = DpKt.DpSize-YgX7TsA(Dp.constructor-impl(f), Dp.constructor-impl(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$36$lambda$35(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x04c8  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final String str, final Function1<? super String, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4, final int i5) {
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
        Modifier modifier2;
        boolean z4;
        boolean z5;
        TextStyle textStyle2;
        KeyboardOptions keyboardOptions2;
        KeyboardActions keyboardActions2;
        boolean z6;
        int i21;
        int i22;
        VisualTransformation visualTransformation2;
        Function1<? super TextLayoutResult, Unit> function13;
        MutableInteractionSource mutableInteractionSource2;
        Brush brush2;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        ScopeUpdateScope endRestartGroup;
        Modifier.Companion companion;
        boolean z7;
        KeyboardActions keyboardActions3;
        int i23;
        boolean z8;
        Function1<? super TextLayoutResult, Unit> function14;
        Function1<? super TextLayoutResult, Unit> function15;
        int i24;
        SolidColor solidColor;
        Function1<? super TextLayoutResult, Unit> function16;
        VisualTransformation visualTransformation3;
        boolean z9;
        TextStyle textStyle3;
        int i25;
        int i26;
        KeyboardOptions keyboardOptions3;
        boolean z10;
        boolean z11;
        Object mutableStateOf$default;
        int i27;
        KeyboardOptions keyboardOptions4;
        Object obj;
        int i28;
        Composer startRestartGroup = composer.startRestartGroup(2026950908);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)740@38542L57,746@38895L242,746@38884L253,757@39458L41,761@39576L373,759@39505L1033:BasicTextField.kt#423gt5");
        if ((i5 & 1) != 0) {
            i6 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i3;
        } else {
            i6 = i3;
        }
        if ((i5 & 2) != 0) {
            i6 |= 48;
        } else if ((i3 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i29 = i5 & 4;
        if (i29 != 0) {
            i6 |= 384;
        } else if ((i3 & 384) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
            i7 = i5 & 8;
            int i30 = Fields.CameraDistance;
            if (i7 == 0) {
                i6 |= 3072;
            } else if ((i3 & 3072) == 0) {
                i6 |= startRestartGroup.changed(z) ? 2048 : 1024;
                i8 = i5 & 16;
                int i31 = Fields.Clip;
                if (i8 != 0) {
                    i6 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    i6 |= startRestartGroup.changed(z2) ? 16384 : 8192;
                    i9 = i5 & 32;
                    if (i9 == 0) {
                        i6 |= 196608;
                    } else if ((i3 & 196608) == 0) {
                        i6 |= startRestartGroup.changed(textStyle) ? Fields.RenderEffect : 65536;
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                        i6 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        i6 |= startRestartGroup.changed(keyboardOptions) ? 1048576 : Fields.BlendMode;
                    }
                    i11 = i5 & Fields.SpotShadowColor;
                    if (i11 == 0) {
                        i6 |= 12582912;
                    } else if ((i3 & 12582912) == 0) {
                        i6 |= startRestartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                    }
                    i12 = i5 & Fields.RotationX;
                    if (i12 == 0) {
                        i6 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i6 |= startRestartGroup.changed(z3) ? 67108864 : 33554432;
                    }
                    if ((i3 & 805306368) == 0) {
                        if ((i5 & Fields.RotationY) == 0 && startRestartGroup.changed(i)) {
                            i28 = 536870912;
                            i6 |= i28;
                        }
                        i28 = 268435456;
                        i6 |= i28;
                    }
                    i13 = i5 & Fields.RotationZ;
                    if (i13 == 0) {
                        i14 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        i14 = i4 | (startRestartGroup.changed(i2) ? 4 : 2);
                    } else {
                        i14 = i4;
                    }
                    i15 = i5 & Fields.CameraDistance;
                    if (i15 == 0) {
                        i14 |= 48;
                    } else if ((i4 & 48) == 0) {
                        i14 |= startRestartGroup.changed(visualTransformation) ? 32 : 16;
                    }
                    i16 = i14;
                    i17 = i5 & Fields.TransformOrigin;
                    if (i17 == 0) {
                        i16 |= 384;
                    } else if ((i4 & 384) == 0) {
                        i16 |= startRestartGroup.changedInstance(function12) ? Fields.RotationX : Fields.SpotShadowColor;
                        i18 = i5 & Fields.Shape;
                        if (i18 != 0) {
                            i16 |= 3072;
                        } else if ((i4 & 3072) == 0) {
                            if (!startRestartGroup.changed(mutableInteractionSource)) {
                                i30 = 1024;
                            }
                            i16 |= i30;
                            i19 = i5 & Fields.Clip;
                            if (i19 == 0) {
                                i16 |= 24576;
                            } else if ((i4 & 24576) == 0) {
                                if (!startRestartGroup.changed(brush)) {
                                    i31 = 8192;
                                }
                                i16 |= i31;
                                i20 = i5 & Fields.CompositingStrategy;
                                if (i20 != 0) {
                                    i16 |= 196608;
                                } else if ((i4 & 196608) == 0) {
                                    i16 |= startRestartGroup.changedInstance(function3) ? Fields.RenderEffect : 65536;
                                }
                                if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "732@38127L2");
                                    if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i5 & Fields.RotationY) != 0) {
                                            i6 &= -1879048193;
                                        }
                                        companion = modifier;
                                        z7 = z;
                                        z9 = z2;
                                        textStyle3 = textStyle;
                                        keyboardActions3 = keyboardActions;
                                        z10 = z3;
                                        i26 = i2;
                                        visualTransformation3 = visualTransformation;
                                        function16 = function12;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush2 = brush;
                                        function32 = function3;
                                        i25 = i6;
                                        keyboardOptions3 = keyboardOptions;
                                    } else {
                                        companion = i29 != 0 ? Modifier.INSTANCE : modifier;
                                        z7 = i7 != 0 ? true : z;
                                        boolean z12 = i8 != 0 ? false : z2;
                                        TextStyle textStyle4 = i9 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                        KeyboardOptions keyboardOptions5 = i10 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        keyboardActions3 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z13 = i12 != 0 ? false : z3;
                                        if ((i5 & Fields.RotationY) != 0) {
                                            i23 = z13 ? 1 : Integer.MAX_VALUE;
                                            i6 &= -1879048193;
                                        } else {
                                            i23 = i;
                                        }
                                        int i32 = i13 != 0 ? 1 : i2;
                                        VisualTransformation none = i15 != 0 ? VisualTransformation.Companion.getNone() : visualTransformation;
                                        if (i17 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2015310786, "CC(remember):BasicTextField.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            z8 = z13;
                                            Object obj2 = rememberedValue;
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                Object obj3 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda14
                                                    public final Object invoke(Object obj4) {
                                                        Unit BasicTextField$lambda$36$lambda$35;
                                                        BasicTextField$lambda$36$lambda$35 = BasicTextFieldKt.BasicTextField$lambda$36$lambda$35((TextLayoutResult) obj4);
                                                        return BasicTextField$lambda$36$lambda$35;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(obj3);
                                                obj2 = obj3;
                                            }
                                            function14 = (Function1) obj2;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            z8 = z13;
                                            function14 = function12;
                                        }
                                        MutableInteractionSource mutableInteractionSource3 = i18 != 0 ? null : mutableInteractionSource;
                                        if (i19 != 0) {
                                            function15 = function14;
                                            i24 = i23;
                                            solidColor = new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null);
                                        } else {
                                            function15 = function14;
                                            i24 = i23;
                                            solidColor = brush;
                                        }
                                        if (i20 != 0) {
                                            i = i24;
                                            function16 = function15;
                                            brush2 = solidColor;
                                            function32 = ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$759698998$foundation_release();
                                        } else {
                                            i = i24;
                                            function16 = function15;
                                            function32 = function3;
                                            brush2 = solidColor;
                                        }
                                        visualTransformation3 = none;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        z9 = z12;
                                        textStyle3 = textStyle4;
                                        i25 = i6;
                                        i26 = i32;
                                        keyboardOptions3 = keyboardOptions5;
                                        z10 = z8;
                                    }
                                    startRestartGroup.endDefaults();
                                    int i33 = i26;
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(2026950908, i25, i16, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:737)");
                                    }
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2015297451, "CC(remember):BasicTextField.kt#9igjgp");
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue(str, 0L, (TextRange) null, 6, (DefaultConstructorMarker) null), null, 2, null);
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    final MutableState mutableState = (MutableState) rememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    final TextFieldValue textFieldValue = TextFieldValue.copy-3r_uNRQ$default(BasicTextField$lambda$38(mutableState), str, 0L, (TextRange) null, 6, (Object) null);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2015285970, "CC(remember):BasicTextField.kt#9igjgp");
                                    boolean changed = startRestartGroup.changed(textFieldValue);
                                    boolean z14 = z9;
                                    Object rememberedValue3 = startRestartGroup.rememberedValue();
                                    if (changed || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue3 = new Function0() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda15
                                            public final Object invoke() {
                                                Unit BasicTextField$lambda$41$lambda$40;
                                                BasicTextField$lambda$41$lambda$40 = BasicTextFieldKt.BasicTextField$lambda$41$lambda$40(textFieldValue, mutableState);
                                                return BasicTextField$lambda$41$lambda$40;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue3);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    EffectsKt.SideEffect((Function0) rememberedValue3, startRestartGroup, 0);
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2015268155, "CC(remember):BasicTextField.kt#9igjgp");
                                    boolean z15 = (i25 & 14) == 4;
                                    Object rememberedValue4 = startRestartGroup.rememberedValue();
                                    if (z15 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                        z11 = z7;
                                        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str, null, 2, null);
                                        startRestartGroup.updateRememberedValue(mutableStateOf$default);
                                    } else {
                                        z11 = z7;
                                        mutableStateOf$default = rememberedValue4;
                                    }
                                    final MutableState mutableState2 = (MutableState) mutableStateOf$default;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    ImeOptions imeOptions$foundation_release = keyboardOptions3.toImeOptions$foundation_release(z10);
                                    boolean z16 = !z10;
                                    int i34 = z10 ? 1 : i33;
                                    if (z10) {
                                        keyboardOptions4 = keyboardOptions3;
                                        i27 = 1;
                                    } else {
                                        i27 = i;
                                        keyboardOptions4 = keyboardOptions3;
                                    }
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -2015264047, "CC(remember):BasicTextField.kt#9igjgp");
                                    boolean z17 = z10;
                                    boolean changed2 = startRestartGroup.changed(mutableState2) | ((i25 & 112) == 32);
                                    Object rememberedValue5 = startRestartGroup.rememberedValue();
                                    if (changed2 || rememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                        Function1 function17 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda16
                                            public final Object invoke(Object obj4) {
                                                Unit BasicTextField$lambda$46$lambda$45;
                                                BasicTextField$lambda$46$lambda$45 = BasicTextFieldKt.BasicTextField$lambda$46$lambda$45(function1, mutableState, mutableState2, (TextFieldValue) obj4);
                                                return BasicTextField$lambda$46$lambda$45;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(function17);
                                        obj = function17;
                                    } else {
                                        obj = rememberedValue5;
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    int i35 = i16 << 9;
                                    CoreTextFieldKt.CoreTextField(textFieldValue, (Function1) obj, companion, textStyle3, visualTransformation3, function16, mutableInteractionSource2, brush2, z16, i27, i34, imeOptions$foundation_release, keyboardActions3, z11, z14, function32, null, startRestartGroup, (i25 & 896) | ((i25 >> 6) & 7168) | (57344 & i35) | (458752 & i35) | (3670016 & i35) | (i35 & 29360128), ((i25 >> 15) & 896) | (i25 & 7168) | (57344 & i25) | (458752 & i16), 65536);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    z5 = z14;
                                    z4 = z11;
                                    keyboardOptions2 = keyboardOptions4;
                                    i22 = i33;
                                    textStyle2 = textStyle3;
                                    keyboardActions2 = keyboardActions3;
                                    visualTransformation2 = visualTransformation3;
                                    function13 = function16;
                                    z6 = z17;
                                    i21 = i;
                                    modifier2 = companion;
                                } else {
                                    startRestartGroup.skipToGroupEnd();
                                    modifier2 = modifier;
                                    z4 = z;
                                    z5 = z2;
                                    textStyle2 = textStyle;
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActions2 = keyboardActions;
                                    z6 = z3;
                                    i21 = i;
                                    i22 = i2;
                                    visualTransformation2 = visualTransformation;
                                    function13 = function12;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    brush2 = brush;
                                    function32 = function3;
                                }
                                endRestartGroup = startRestartGroup.endRestartGroup();
                                if (endRestartGroup != null) {
                                    final Modifier modifier3 = modifier2;
                                    final boolean z18 = z4;
                                    final boolean z19 = z5;
                                    final TextStyle textStyle5 = textStyle2;
                                    final KeyboardOptions keyboardOptions6 = keyboardOptions2;
                                    final KeyboardActions keyboardActions4 = keyboardActions2;
                                    final boolean z20 = z6;
                                    final int i36 = i21;
                                    final int i37 = i22;
                                    final VisualTransformation visualTransformation4 = visualTransformation2;
                                    final Function1<? super TextLayoutResult, Unit> function18 = function13;
                                    final MutableInteractionSource mutableInteractionSource4 = mutableInteractionSource2;
                                    final Brush brush3 = brush2;
                                    final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33 = function32;
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda17
                                        public final Object invoke(Object obj4, Object obj5) {
                                            Unit BasicTextField$lambda$47;
                                            BasicTextField$lambda$47 = BasicTextFieldKt.BasicTextField$lambda$47(str, function1, modifier3, z18, z19, textStyle5, keyboardOptions6, keyboardActions4, z20, i36, i37, visualTransformation4, function18, mutableInteractionSource4, brush3, function33, i3, i4, i5, (Composer) obj4, ((Integer) obj5).intValue());
                                            return BasicTextField$lambda$47;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i20 = i5 & Fields.CompositingStrategy;
                            if (i20 != 0) {
                            }
                            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
                            }
                            endRestartGroup = startRestartGroup.endRestartGroup();
                            if (endRestartGroup != null) {
                            }
                        }
                        i19 = i5 & Fields.Clip;
                        if (i19 == 0) {
                        }
                        i20 = i5 & Fields.CompositingStrategy;
                        if (i20 != 0) {
                        }
                        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
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
                    if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
                    }
                    endRestartGroup = startRestartGroup.endRestartGroup();
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
                if ((i3 & 805306368) == 0) {
                }
                i13 = i5 & Fields.RotationZ;
                if (i13 == 0) {
                }
                i15 = i5 & Fields.CameraDistance;
                if (i15 == 0) {
                }
                i16 = i14;
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
                if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
                }
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i8 = i5 & 16;
            int i312 = Fields.Clip;
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
            if ((i3 & 805306368) == 0) {
            }
            i13 = i5 & Fields.RotationZ;
            if (i13 == 0) {
            }
            i15 = i5 & Fields.CameraDistance;
            if (i15 == 0) {
            }
            i16 = i14;
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
            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
            }
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i7 = i5 & 8;
        int i302 = Fields.CameraDistance;
        if (i7 == 0) {
        }
        i8 = i5 & 16;
        int i3122 = Fields.Clip;
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
        if ((i3 & 805306368) == 0) {
        }
        i13 = i5 & Fields.RotationZ;
        if (i13 == 0) {
        }
        i15 = i5 & Fields.CameraDistance;
        if (i15 == 0) {
        }
        i16 = i14;
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
        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
        }
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    private static final TextFieldValue BasicTextField$lambda$38(MutableState<TextFieldValue> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$41$lambda$40(TextFieldValue textFieldValue, MutableState mutableState) {
        if (!TextRange.equals-impl0(textFieldValue.getSelection-d9O1mEE(), BasicTextField$lambda$38(mutableState).getSelection-d9O1mEE()) || !Intrinsics.areEqual(textFieldValue.getComposition-MzsxiRA(), BasicTextField$lambda$38(mutableState).getComposition-MzsxiRA())) {
            mutableState.setValue(textFieldValue);
        }
        return Unit.INSTANCE;
    }

    private static final String BasicTextField$lambda$43(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$46$lambda$45(Function1 function1, MutableState mutableState, MutableState mutableState2, TextFieldValue textFieldValue) {
        mutableState.setValue(textFieldValue);
        boolean z = !Intrinsics.areEqual(BasicTextField$lambda$43(mutableState2), textFieldValue.getText());
        mutableState2.setValue(textFieldValue.getText());
        if (z) {
            function1.invoke(textFieldValue.getText());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$49$lambda$48(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x040a  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void BasicTextField(final TextFieldValue textFieldValue, final Function1<? super TextFieldValue, Unit> function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, int i2, VisualTransformation visualTransformation, Function1<? super TextLayoutResult, Unit> function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i3, final int i4, final int i5) {
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
        Composer composer2;
        final Modifier modifier2;
        final boolean z4;
        final boolean z5;
        final TextStyle textStyle2;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions2;
        final boolean z6;
        final int i21;
        final int i22;
        final VisualTransformation visualTransformation2;
        final Function1<? super TextLayoutResult, Unit> function13;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32;
        ScopeUpdateScope endRestartGroup;
        int i23;
        boolean z7;
        Function1<? super TextLayoutResult, Unit> function14;
        Function1<? super TextLayoutResult, Unit> function15;
        int i24;
        SolidColor solidColor;
        Modifier modifier3;
        Function1<? super TextLayoutResult, Unit> function16;
        Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function33;
        Brush brush3;
        int i25;
        VisualTransformation visualTransformation3;
        int i26;
        KeyboardActions keyboardActions3;
        MutableInteractionSource mutableInteractionSource3;
        boolean z8;
        boolean z9;
        TextStyle textStyle3;
        KeyboardOptions keyboardOptions3;
        boolean z10;
        int i27;
        int i28;
        Composer startRestartGroup = composer.startRestartGroup(-971111025);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,minLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)897@47431L90,895@47369L741:BasicTextField.kt#423gt5");
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
        int i29 = i5 & 4;
        if (i29 != 0) {
            i6 |= 384;
        } else if ((i3 & 384) == 0) {
            i6 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
            i7 = i5 & 8;
            int i30 = Fields.CameraDistance;
            if (i7 == 0) {
                i6 |= 3072;
            } else if ((i3 & 3072) == 0) {
                i6 |= startRestartGroup.changed(z) ? 2048 : 1024;
                i8 = i5 & 16;
                int i31 = Fields.Clip;
                if (i8 != 0) {
                    i6 |= 24576;
                } else if ((i3 & 24576) == 0) {
                    i6 |= startRestartGroup.changed(z2) ? 16384 : 8192;
                    i9 = i5 & 32;
                    if (i9 == 0) {
                        i6 |= 196608;
                    } else if ((i3 & 196608) == 0) {
                        i6 |= startRestartGroup.changed(textStyle) ? Fields.RenderEffect : 65536;
                    }
                    i10 = i5 & 64;
                    if (i10 == 0) {
                        i6 |= 1572864;
                    } else if ((i3 & 1572864) == 0) {
                        i6 |= startRestartGroup.changed(keyboardOptions) ? 1048576 : Fields.BlendMode;
                    }
                    i11 = i5 & Fields.SpotShadowColor;
                    if (i11 == 0) {
                        i6 |= 12582912;
                    } else if ((i3 & 12582912) == 0) {
                        i6 |= startRestartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                    }
                    i12 = i5 & Fields.RotationX;
                    if (i12 == 0) {
                        i6 |= 100663296;
                    } else if ((i3 & 100663296) == 0) {
                        i6 |= startRestartGroup.changed(z3) ? 67108864 : 33554432;
                    }
                    if ((i3 & 805306368) == 0) {
                        if ((i5 & Fields.RotationY) == 0 && startRestartGroup.changed(i)) {
                            i28 = 536870912;
                            i6 |= i28;
                        }
                        i28 = 268435456;
                        i6 |= i28;
                    }
                    i13 = i5 & Fields.RotationZ;
                    if (i13 == 0) {
                        i14 = i4 | 6;
                    } else if ((i4 & 6) == 0) {
                        i14 = i4 | (startRestartGroup.changed(i2) ? 4 : 2);
                    } else {
                        i14 = i4;
                    }
                    i15 = i5 & Fields.CameraDistance;
                    if (i15 == 0) {
                        i14 |= 48;
                    } else if ((i4 & 48) == 0) {
                        i14 |= startRestartGroup.changed(visualTransformation) ? 32 : 16;
                    }
                    i16 = i14;
                    i17 = i5 & Fields.TransformOrigin;
                    if (i17 == 0) {
                        i16 |= 384;
                    } else if ((i4 & 384) == 0) {
                        i16 |= startRestartGroup.changedInstance(function12) ? Fields.RotationX : Fields.SpotShadowColor;
                        i18 = i5 & Fields.Shape;
                        if (i18 != 0) {
                            i16 |= 3072;
                        } else if ((i4 & 3072) == 0) {
                            if (!startRestartGroup.changed(mutableInteractionSource)) {
                                i30 = 1024;
                            }
                            i16 |= i30;
                            i19 = i5 & Fields.Clip;
                            if (i19 == 0) {
                                i16 |= 24576;
                            } else if ((i4 & 24576) == 0) {
                                if (!startRestartGroup.changed(brush)) {
                                    i31 = 8192;
                                }
                                i16 |= i31;
                                i20 = i5 & Fields.CompositingStrategy;
                                if (i20 != 0) {
                                    i16 |= 196608;
                                } else if ((i4 & 196608) == 0) {
                                    i16 |= startRestartGroup.changedInstance(function3) ? Fields.RenderEffect : 65536;
                                }
                                if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
                                    startRestartGroup.startDefaults();
                                    ComposerKt.sourceInformation(startRestartGroup, "889@47108L2");
                                    if ((i3 & 1) != 0 && !startRestartGroup.getDefaultsInvalid()) {
                                        startRestartGroup.skipToGroupEnd();
                                        if ((i5 & Fields.RotationY) != 0) {
                                            i6 &= -1879048193;
                                        }
                                        modifier3 = modifier;
                                        z8 = z;
                                        z9 = z2;
                                        textStyle3 = textStyle;
                                        keyboardOptions3 = keyboardOptions;
                                        keyboardActions3 = keyboardActions;
                                        z10 = z3;
                                        i26 = i;
                                        i25 = i2;
                                        visualTransformation3 = visualTransformation;
                                        function16 = function12;
                                        mutableInteractionSource3 = mutableInteractionSource;
                                        brush3 = brush;
                                        function33 = function3;
                                        i27 = i6;
                                    } else {
                                        Modifier.Companion companion = i29 != 0 ? Modifier.INSTANCE : modifier;
                                        boolean z11 = i7 != 0 ? true : z;
                                        boolean z12 = i8 != 0 ? false : z2;
                                        TextStyle textStyle4 = i9 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                        KeyboardOptions keyboardOptions4 = i10 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActions keyboardActions4 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z13 = i12 != 0 ? false : z3;
                                        Modifier modifier4 = companion;
                                        if ((i5 & Fields.RotationY) != 0) {
                                            i23 = z13 ? 1 : Integer.MAX_VALUE;
                                            i6 &= -1879048193;
                                        } else {
                                            i23 = i;
                                        }
                                        int i32 = i13 != 0 ? 1 : i2;
                                        VisualTransformation none = i15 != 0 ? VisualTransformation.Companion.getNone() : visualTransformation;
                                        if (i17 != 0) {
                                            z7 = z13;
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1229772271, "CC(remember):BasicTextField.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda9
                                                    public final Object invoke(Object obj) {
                                                        Unit BasicTextField$lambda$49$lambda$48;
                                                        BasicTextField$lambda$49$lambda$48 = BasicTextFieldKt.BasicTextField$lambda$49$lambda$48((TextLayoutResult) obj);
                                                        return BasicTextField$lambda$49$lambda$48;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            function14 = (Function1) rememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            z7 = z13;
                                            function14 = function12;
                                        }
                                        MutableInteractionSource mutableInteractionSource4 = i18 != 0 ? null : mutableInteractionSource;
                                        if (i19 != 0) {
                                            function15 = function14;
                                            i24 = i6;
                                            solidColor = new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null);
                                        } else {
                                            function15 = function14;
                                            i24 = i6;
                                            solidColor = brush;
                                        }
                                        if (i20 != 0) {
                                            modifier3 = modifier4;
                                            function16 = function15;
                                            brush3 = solidColor;
                                            function33 = ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$486633673$foundation_release();
                                        } else {
                                            modifier3 = modifier4;
                                            function16 = function15;
                                            function33 = function3;
                                            brush3 = solidColor;
                                        }
                                        i25 = i32;
                                        visualTransformation3 = none;
                                        i26 = i23;
                                        keyboardActions3 = keyboardActions4;
                                        mutableInteractionSource3 = mutableInteractionSource4;
                                        z8 = z11;
                                        z9 = z12;
                                        textStyle3 = textStyle4;
                                        keyboardOptions3 = keyboardOptions4;
                                        z10 = z7;
                                        i27 = i24;
                                    }
                                    startRestartGroup.endDefaults();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-971111025, i27, i16, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:894)");
                                    }
                                    ImeOptions imeOptions$foundation_release = keyboardOptions3.toImeOptions$foundation_release(z10);
                                    boolean z14 = !z10;
                                    int i33 = z10 ? 1 : i25;
                                    int i34 = z10 ? 1 : i26;
                                    ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1229761847, "CC(remember):BasicTextField.kt#9igjgp");
                                    int i35 = i27 & 14;
                                    boolean z15 = (i35 == 4) | ((i27 & 112) == 32);
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (z15 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda10
                                            public final Object invoke(Object obj) {
                                                Unit BasicTextField$lambda$51$lambda$50;
                                                BasicTextField$lambda$51$lambda$50 = BasicTextFieldKt.BasicTextField$lambda$51$lambda$50(textFieldValue, function1, (TextFieldValue) obj);
                                                return BasicTextField$lambda$51$lambda$50;
                                            }
                                        };
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    Function1 function17 = (Function1) rememberedValue2;
                                    ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                    int i36 = i16 << 9;
                                    composer2 = startRestartGroup;
                                    boolean z16 = z10;
                                    KeyboardOptions keyboardOptions5 = keyboardOptions3;
                                    CoreTextFieldKt.CoreTextField(textFieldValue, function17, modifier3, textStyle3, visualTransformation3, function16, mutableInteractionSource3, brush3, z14, i34, i33, imeOptions$foundation_release, keyboardActions3, z8, z9, function33, null, composer2, i35 | (i27 & 896) | ((i27 >> 6) & 7168) | (57344 & i36) | (458752 & i36) | (3670016 & i36) | (i36 & 29360128), (i27 & 57344) | ((i27 >> 15) & 896) | (i27 & 7168) | (458752 & i16), 65536);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                    modifier2 = modifier3;
                                    z4 = z8;
                                    z5 = z9;
                                    textStyle2 = textStyle3;
                                    keyboardActions2 = keyboardActions3;
                                    i21 = i26;
                                    i22 = i25;
                                    visualTransformation2 = visualTransformation3;
                                    z6 = z16;
                                    keyboardOptions2 = keyboardOptions5;
                                    function13 = function16;
                                    mutableInteractionSource2 = mutableInteractionSource3;
                                    brush2 = brush3;
                                    function32 = function33;
                                } else {
                                    composer2 = startRestartGroup;
                                    composer2.skipToGroupEnd();
                                    modifier2 = modifier;
                                    z4 = z;
                                    z5 = z2;
                                    textStyle2 = textStyle;
                                    keyboardOptions2 = keyboardOptions;
                                    keyboardActions2 = keyboardActions;
                                    z6 = z3;
                                    i21 = i;
                                    i22 = i2;
                                    visualTransformation2 = visualTransformation;
                                    function13 = function12;
                                    mutableInteractionSource2 = mutableInteractionSource;
                                    brush2 = brush;
                                    function32 = function3;
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup != null) {
                                    endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda12
                                        public final Object invoke(Object obj, Object obj2) {
                                            Unit BasicTextField$lambda$52;
                                            BasicTextField$lambda$52 = BasicTextFieldKt.BasicTextField$lambda$52(textFieldValue, function1, modifier2, z4, z5, textStyle2, keyboardOptions2, keyboardActions2, z6, i21, i22, visualTransformation2, function13, mutableInteractionSource2, brush2, function32, i3, i4, i5, (Composer) obj, ((Integer) obj2).intValue());
                                            return BasicTextField$lambda$52;
                                        }
                                    });
                                    return;
                                }
                                return;
                            }
                            i20 = i5 & Fields.CompositingStrategy;
                            if (i20 != 0) {
                            }
                            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
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
                        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
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
                    if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
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
                if ((i3 & 805306368) == 0) {
                }
                i13 = i5 & Fields.RotationZ;
                if (i13 == 0) {
                }
                i15 = i5 & Fields.CameraDistance;
                if (i15 == 0) {
                }
                i16 = i14;
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
                if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            i8 = i5 & 16;
            int i312 = Fields.Clip;
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
            if ((i3 & 805306368) == 0) {
            }
            i13 = i5 & Fields.RotationZ;
            if (i13 == 0) {
            }
            i15 = i5 & Fields.CameraDistance;
            if (i15 == 0) {
            }
            i16 = i14;
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
            if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i7 = i5 & 8;
        int i302 = Fields.CameraDistance;
        if (i7 == 0) {
        }
        i8 = i5 & 16;
        int i3122 = Fields.Clip;
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
        if ((i3 & 805306368) == 0) {
        }
        i13 = i5 & Fields.RotationZ;
        if (i13 == 0) {
        }
        i15 = i5 & Fields.CameraDistance;
        if (i15 == 0) {
        }
        i16 = i14;
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
        if (startRestartGroup.shouldExecute((i6 & 306783379) == 306783378 || (74899 & i16) != 74898, i6 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$51$lambda$50(TextFieldValue textFieldValue, Function1 function1, TextFieldValue textFieldValue2) {
        if (!Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
            function1.invoke(textFieldValue2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$54$lambda$53(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f3  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void BasicTextField(final String str, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, Composer composer, final int i2, final int i3, final int i4) {
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
        int i19;
        int i20;
        Composer composer2;
        final Modifier modifier2;
        final boolean z4;
        final boolean z5;
        final TextStyle textStyle2;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions2;
        final boolean z6;
        final int i21;
        final VisualTransformation visualTransformation2;
        final Function1 function13;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final Function3 function32;
        ScopeUpdateScope endRestartGroup;
        Function1 function14;
        MutableInteractionSource mutableInteractionSource3;
        SolidColor solidColor;
        Composer startRestartGroup = composer.startRestartGroup(74291967);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)933@48746L2,934@48800L39,939@49041L580:BasicTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(str) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 384) == 0) {
                i5 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                int i22 = Fields.CameraDistance;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(z) ? 2048 : 1024;
                    i8 = i4 & 16;
                    int i23 = Fields.Clip;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i5 |= startRestartGroup.changed(z2) ? 16384 : 8192;
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
                            i5 |= startRestartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                        }
                        i12 = i4 & Fields.RotationX;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z3) ? 67108864 : 33554432;
                        }
                        i13 = i4 & Fields.RotationY;
                        if (i13 != 0) {
                            i5 |= 805306368;
                        } else if ((i2 & 805306368) == 0) {
                            i5 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
                        }
                        i14 = i4 & Fields.RotationZ;
                        if (i14 != 0) {
                            i15 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i15 = i3 | (startRestartGroup.changed(visualTransformation) ? 4 : 2);
                        } else {
                            i15 = i3;
                        }
                        i16 = i4 & Fields.CameraDistance;
                        if (i16 != 0) {
                            i15 |= 48;
                        } else if ((i3 & 48) == 0) {
                            i15 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
                        }
                        i17 = i15;
                        i18 = i4 & Fields.TransformOrigin;
                        if (i18 != 0) {
                            i17 |= 384;
                        } else if ((i3 & 384) == 0) {
                            i17 |= startRestartGroup.changed(mutableInteractionSource) ? Fields.RotationX : Fields.SpotShadowColor;
                            i19 = i4 & Fields.Shape;
                            if (i19 == 0) {
                                i17 |= 3072;
                            } else if ((i3 & 3072) == 0) {
                                if (!startRestartGroup.changed(brush)) {
                                    i22 = 1024;
                                }
                                i17 |= i22;
                                i20 = i4 & Fields.Clip;
                                if (i20 != 0) {
                                    i17 |= 24576;
                                } else if ((i3 & 24576) == 0) {
                                    if (!startRestartGroup.changedInstance(function3)) {
                                        i23 = 8192;
                                    }
                                    i17 |= i23;
                                    if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                                        composer2 = startRestartGroup;
                                        composer2.skipToGroupEnd();
                                        modifier2 = modifier;
                                        z4 = z;
                                        z5 = z2;
                                        textStyle2 = textStyle;
                                        keyboardOptions2 = keyboardOptions;
                                        keyboardActions2 = keyboardActions;
                                        z6 = z3;
                                        i21 = i;
                                        visualTransformation2 = visualTransformation;
                                        function13 = function12;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush2 = brush;
                                        function32 = function3;
                                    } else {
                                        Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier;
                                        boolean z7 = i7 != 0 ? true : z;
                                        boolean z8 = i8 != 0 ? false : z2;
                                        TextStyle textStyle3 = i9 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                        KeyboardOptions keyboardOptions3 = i10 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActions keyboardActions3 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z9 = i12 != 0 ? false : z3;
                                        int i24 = i13 != 0 ? Integer.MAX_VALUE : i;
                                        VisualTransformation none = i14 != 0 ? VisualTransformation.Companion.getNone() : visualTransformation;
                                        if (i16 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1619843519, "CC(remember):BasicTextField.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda20
                                                    public final Object invoke(Object obj) {
                                                        Unit BasicTextField$lambda$54$lambda$53;
                                                        BasicTextField$lambda$54$lambda$53 = BasicTextFieldKt.BasicTextField$lambda$54$lambda$53((TextLayoutResult) obj);
                                                        return BasicTextField$lambda$54$lambda$53;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            function14 = (Function1) rememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            function14 = function12;
                                        }
                                        if (i18 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -1619841754, "CC(remember):BasicTextField.kt#9igjgp");
                                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            mutableInteractionSource3 = (MutableInteractionSource) rememberedValue2;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        }
                                        if (i19 != 0) {
                                            composer2 = startRestartGroup;
                                            solidColor = new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null);
                                        } else {
                                            composer2 = startRestartGroup;
                                            solidColor = brush;
                                        }
                                        Function3 lambda$444370233$foundation_release = i20 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.getLambda$444370233$foundation_release() : function3;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(74291967, i5, i17, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:938)");
                                        }
                                        int i25 = (i5 & 14) | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192);
                                        int i26 = i17 << 3;
                                        BasicTextField(str, (Function1<? super String, Unit>) function1, companion, z7, z8, textStyle3, keyboardOptions3, keyboardActions3, z9, i24, 1, none, (Function1<? super TextLayoutResult, Unit>) function14, mutableInteractionSource3, solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) lambda$444370233$foundation_release, composer2, i25, (i26 & 112) | 6 | (i26 & 896) | (i26 & 7168) | (57344 & i26) | (i26 & 458752), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        brush2 = solidColor;
                                        visualTransformation2 = none;
                                        function32 = lambda$444370233$foundation_release;
                                        modifier2 = companion;
                                        keyboardActions2 = keyboardActions3;
                                        z5 = z8;
                                        textStyle2 = textStyle3;
                                        z6 = z9;
                                        i21 = i24;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        keyboardOptions2 = keyboardOptions3;
                                        boolean z10 = z7;
                                        function13 = function14;
                                        z4 = z10;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda1
                                            public final Object invoke(Object obj, Object obj2) {
                                                Unit BasicTextField$lambda$56;
                                                BasicTextField$lambda$56 = BasicTextFieldKt.BasicTextField$lambda$56(str, function1, modifier2, z4, z5, textStyle2, keyboardOptions2, keyboardActions2, z6, i21, visualTransformation2, function13, mutableInteractionSource2, brush2, function32, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                                return BasicTextField$lambda$56;
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i20 = i4 & Fields.Clip;
                            if (i20 != 0) {
                            }
                            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i19 = i4 & Fields.Shape;
                        if (i19 == 0) {
                        }
                        i20 = i4 & Fields.Clip;
                        if (i20 != 0) {
                        }
                        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
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
                    i19 = i4 & Fields.Shape;
                    if (i19 == 0) {
                    }
                    i20 = i4 & Fields.Clip;
                    if (i20 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                int i232 = Fields.Clip;
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
                i19 = i4 & Fields.Shape;
                if (i19 == 0) {
                }
                i20 = i4 & Fields.Clip;
                if (i20 != 0) {
                }
                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            int i222 = Fields.CameraDistance;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            int i2322 = Fields.Clip;
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
            i19 = i4 & Fields.Shape;
            if (i19 == 0) {
            }
            i20 = i4 & Fields.Clip;
            if (i20 != 0) {
            }
            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i2222 = Fields.CameraDistance;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        int i23222 = Fields.Clip;
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
        i19 = i4 & Fields.Shape;
        if (i19 == 0) {
        }
        i20 = i4 & Fields.Clip;
        if (i20 != 0) {
        }
        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BasicTextField$lambda$58$lambda$57(TextLayoutResult textLayoutResult) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01f3  */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final /* synthetic */ void BasicTextField(final TextFieldValue textFieldValue, final Function1 function1, Modifier modifier, boolean z, boolean z2, TextStyle textStyle, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, boolean z3, int i, VisualTransformation visualTransformation, Function1 function12, MutableInteractionSource mutableInteractionSource, Brush brush, Function3 function3, Composer composer, final int i2, final int i3, final int i4) {
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
        int i19;
        int i20;
        Composer composer2;
        final Modifier modifier2;
        final boolean z4;
        final boolean z5;
        final TextStyle textStyle2;
        final KeyboardOptions keyboardOptions2;
        final KeyboardActions keyboardActions2;
        final boolean z6;
        final int i21;
        final VisualTransformation visualTransformation2;
        final Function1 function13;
        final MutableInteractionSource mutableInteractionSource2;
        final Brush brush2;
        final Function3 function32;
        ScopeUpdateScope endRestartGroup;
        Function1 function14;
        MutableInteractionSource mutableInteractionSource3;
        SolidColor solidColor;
        Composer startRestartGroup = composer.startRestartGroup(1742344466);
        ComposerKt.sourceInformation(startRestartGroup, "C(BasicTextField)N(value,onValueChange,modifier,enabled,readOnly,textStyle,keyboardOptions,keyboardActions,singleLine,maxLines,visualTransformation,onTextLayout,interactionSource,cursorBrush,decorationBox)973@50273L2,974@50327L39,979@50568L580:BasicTextField.kt#423gt5");
        if ((i4 & 1) != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i5 = (startRestartGroup.changed(textFieldValue) ? 4 : 2) | i2;
        } else {
            i5 = i2;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i2 & 48) == 0) {
            i5 |= startRestartGroup.changedInstance(function1) ? 32 : 16;
            i6 = i4 & 4;
            if (i6 == 0) {
                i5 |= 384;
            } else if ((i2 & 384) == 0) {
                i5 |= startRestartGroup.changed(modifier) ? Fields.RotationX : Fields.SpotShadowColor;
                i7 = i4 & 8;
                int i22 = Fields.CameraDistance;
                if (i7 != 0) {
                    i5 |= 3072;
                } else if ((i2 & 3072) == 0) {
                    i5 |= startRestartGroup.changed(z) ? 2048 : 1024;
                    i8 = i4 & 16;
                    int i23 = Fields.Clip;
                    if (i8 == 0) {
                        i5 |= 24576;
                    } else if ((i2 & 24576) == 0) {
                        i5 |= startRestartGroup.changed(z2) ? 16384 : 8192;
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
                            i5 |= startRestartGroup.changed(keyboardActions) ? 8388608 : 4194304;
                        }
                        i12 = i4 & Fields.RotationX;
                        if (i12 != 0) {
                            i5 |= 100663296;
                        } else if ((i2 & 100663296) == 0) {
                            i5 |= startRestartGroup.changed(z3) ? 67108864 : 33554432;
                        }
                        i13 = i4 & Fields.RotationY;
                        if (i13 != 0) {
                            i5 |= 805306368;
                        } else if ((i2 & 805306368) == 0) {
                            i5 |= startRestartGroup.changed(i) ? 536870912 : 268435456;
                        }
                        i14 = i4 & Fields.RotationZ;
                        if (i14 != 0) {
                            i15 = i3 | 6;
                        } else if ((i3 & 6) == 0) {
                            i15 = i3 | (startRestartGroup.changed(visualTransformation) ? 4 : 2);
                        } else {
                            i15 = i3;
                        }
                        i16 = i4 & Fields.CameraDistance;
                        if (i16 != 0) {
                            i15 |= 48;
                        } else if ((i3 & 48) == 0) {
                            i15 |= startRestartGroup.changedInstance(function12) ? 32 : 16;
                        }
                        i17 = i15;
                        i18 = i4 & Fields.TransformOrigin;
                        if (i18 != 0) {
                            i17 |= 384;
                        } else if ((i3 & 384) == 0) {
                            i17 |= startRestartGroup.changed(mutableInteractionSource) ? Fields.RotationX : Fields.SpotShadowColor;
                            i19 = i4 & Fields.Shape;
                            if (i19 == 0) {
                                i17 |= 3072;
                            } else if ((i3 & 3072) == 0) {
                                if (!startRestartGroup.changed(brush)) {
                                    i22 = 1024;
                                }
                                i17 |= i22;
                                i20 = i4 & Fields.Clip;
                                if (i20 != 0) {
                                    i17 |= 24576;
                                } else if ((i3 & 24576) == 0) {
                                    if (!startRestartGroup.changedInstance(function3)) {
                                        i23 = 8192;
                                    }
                                    i17 |= i23;
                                    if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                                        composer2 = startRestartGroup;
                                        composer2.skipToGroupEnd();
                                        modifier2 = modifier;
                                        z4 = z;
                                        z5 = z2;
                                        textStyle2 = textStyle;
                                        keyboardOptions2 = keyboardOptions;
                                        keyboardActions2 = keyboardActions;
                                        z6 = z3;
                                        i21 = i;
                                        visualTransformation2 = visualTransformation;
                                        function13 = function12;
                                        mutableInteractionSource2 = mutableInteractionSource;
                                        brush2 = brush;
                                        function32 = function3;
                                    } else {
                                        Modifier.Companion companion = i6 != 0 ? Modifier.INSTANCE : modifier;
                                        boolean z7 = i7 != 0 ? true : z;
                                        boolean z8 = i8 != 0 ? false : z2;
                                        TextStyle textStyle3 = i9 != 0 ? TextStyle.Companion.getDefault() : textStyle;
                                        KeyboardOptions keyboardOptions3 = i10 != 0 ? KeyboardOptions.INSTANCE.getDefault() : keyboardOptions;
                                        KeyboardActions keyboardActions3 = i11 != 0 ? KeyboardActions.INSTANCE.getDefault() : keyboardActions;
                                        boolean z9 = i12 != 0 ? false : z3;
                                        int i24 = i13 != 0 ? Integer.MAX_VALUE : i;
                                        VisualTransformation none = i14 != 0 ? VisualTransformation.Companion.getNone() : visualTransformation;
                                        if (i16 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -644192876, "CC(remember):BasicTextField.kt#9igjgp");
                                            Object rememberedValue = startRestartGroup.rememberedValue();
                                            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue = new Function1() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda3
                                                    public final Object invoke(Object obj) {
                                                        Unit BasicTextField$lambda$58$lambda$57;
                                                        BasicTextField$lambda$58$lambda$57 = BasicTextFieldKt.BasicTextField$lambda$58$lambda$57((TextLayoutResult) obj);
                                                        return BasicTextField$lambda$58$lambda$57;
                                                    }
                                                };
                                                startRestartGroup.updateRememberedValue(rememberedValue);
                                            }
                                            function14 = (Function1) rememberedValue;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            function14 = function12;
                                        }
                                        if (i18 != 0) {
                                            ComposerKt.sourceInformationMarkerStart(startRestartGroup, -644191111, "CC(remember):BasicTextField.kt#9igjgp");
                                            Object rememberedValue2 = startRestartGroup.rememberedValue();
                                            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                                rememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                                startRestartGroup.updateRememberedValue(rememberedValue2);
                                            }
                                            mutableInteractionSource3 = (MutableInteractionSource) rememberedValue2;
                                            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
                                        } else {
                                            mutableInteractionSource3 = mutableInteractionSource;
                                        }
                                        if (i19 != 0) {
                                            composer2 = startRestartGroup;
                                            solidColor = new SolidColor(Color.INSTANCE.m4865getBlack0d7_KjU(), null);
                                        } else {
                                            composer2 = startRestartGroup;
                                            solidColor = brush;
                                        }
                                        Function3 m1524getLambda$665310900$foundation_release = i20 != 0 ? ComposableSingletons$BasicTextFieldKt.INSTANCE.m1524getLambda$665310900$foundation_release() : function3;
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1742344466, i5, i17, "androidx.compose.foundation.text.BasicTextField (BasicTextField.kt:978)");
                                        }
                                        int i25 = (i5 & 14) | (i5 & 112) | (i5 & 896) | (i5 & 7168) | (57344 & i5) | (458752 & i5) | (3670016 & i5) | (29360128 & i5) | (234881024 & i5) | (i5 & 1879048192);
                                        int i26 = i17 << 3;
                                        BasicTextField(textFieldValue, (Function1<? super TextFieldValue, Unit>) function1, companion, z7, z8, textStyle3, keyboardOptions3, keyboardActions3, z9, i24, 1, none, (Function1<? super TextLayoutResult, Unit>) function14, mutableInteractionSource3, solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) m1524getLambda$665310900$foundation_release, composer2, i25, (i26 & 112) | 6 | (i26 & 896) | (i26 & 7168) | (57344 & i26) | (i26 & 458752), 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                        }
                                        brush2 = solidColor;
                                        visualTransformation2 = none;
                                        function32 = m1524getLambda$665310900$foundation_release;
                                        modifier2 = companion;
                                        keyboardActions2 = keyboardActions3;
                                        z5 = z8;
                                        textStyle2 = textStyle3;
                                        z6 = z9;
                                        i21 = i24;
                                        mutableInteractionSource2 = mutableInteractionSource3;
                                        keyboardOptions2 = keyboardOptions3;
                                        boolean z10 = z7;
                                        function13 = function14;
                                        z4 = z10;
                                    }
                                    endRestartGroup = composer2.endRestartGroup();
                                    if (endRestartGroup == null) {
                                        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$$ExternalSyntheticLambda4
                                            public final Object invoke(Object obj, Object obj2) {
                                                Unit BasicTextField$lambda$60;
                                                BasicTextField$lambda$60 = BasicTextFieldKt.BasicTextField$lambda$60(textFieldValue, function1, modifier2, z4, z5, textStyle2, keyboardOptions2, keyboardActions2, z6, i21, visualTransformation2, function13, mutableInteractionSource2, brush2, function32, i2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                                                return BasicTextField$lambda$60;
                                            }
                                        });
                                        return;
                                    }
                                    return;
                                }
                                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                                }
                                endRestartGroup = composer2.endRestartGroup();
                                if (endRestartGroup == null) {
                                }
                            }
                            i20 = i4 & Fields.Clip;
                            if (i20 != 0) {
                            }
                            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                            }
                            endRestartGroup = composer2.endRestartGroup();
                            if (endRestartGroup == null) {
                            }
                        }
                        i19 = i4 & Fields.Shape;
                        if (i19 == 0) {
                        }
                        i20 = i4 & Fields.Clip;
                        if (i20 != 0) {
                        }
                        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                        }
                        endRestartGroup = composer2.endRestartGroup();
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
                    i19 = i4 & Fields.Shape;
                    if (i19 == 0) {
                    }
                    i20 = i4 & Fields.Clip;
                    if (i20 != 0) {
                    }
                    if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                    }
                    endRestartGroup = composer2.endRestartGroup();
                    if (endRestartGroup == null) {
                    }
                }
                i8 = i4 & 16;
                int i232 = Fields.Clip;
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
                i19 = i4 & Fields.Shape;
                if (i19 == 0) {
                }
                i20 = i4 & Fields.Clip;
                if (i20 != 0) {
                }
                if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
                }
                endRestartGroup = composer2.endRestartGroup();
                if (endRestartGroup == null) {
                }
            }
            i7 = i4 & 8;
            int i222 = Fields.CameraDistance;
            if (i7 != 0) {
            }
            i8 = i4 & 16;
            int i2322 = Fields.Clip;
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
            i19 = i4 & Fields.Shape;
            if (i19 == 0) {
            }
            i20 = i4 & Fields.Clip;
            if (i20 != 0) {
            }
            if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        i6 = i4 & 4;
        if (i6 == 0) {
        }
        i7 = i4 & 8;
        int i2222 = Fields.CameraDistance;
        if (i7 != 0) {
        }
        i8 = i4 & 16;
        int i23222 = Fields.Clip;
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
        i19 = i4 & Fields.Shape;
        if (i19 == 0) {
        }
        i20 = i4 & Fields.Clip;
        if (i20 != 0) {
        }
        if (startRestartGroup.shouldExecute((i5 & 306783379) == 306783378 || (i17 & 9363) != 9362, i5 & 1)) {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult BasicTextField$lambda$13$lambda$12(final TextFieldSelectionState textFieldSelectionState, DisposableEffectScope disposableEffectScope) {
        return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.BasicTextFieldKt$BasicTextField$lambda$13$lambda$12$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                TextFieldSelectionState.this.dispose();
            }
        };
    }

    private static final TextFieldHandleState TextFieldCursorHandle$lambda$20(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$26(State<TextFieldHandleState> state) {
        return state.getValue();
    }

    private static final TextFieldHandleState TextFieldSelectionHandles$lambda$31(State<TextFieldHandleState> state) {
        return state.getValue();
    }
}
