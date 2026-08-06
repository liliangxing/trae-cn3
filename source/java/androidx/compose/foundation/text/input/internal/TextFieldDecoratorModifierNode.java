package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import androidx.compose.foundation.FocusableNode;
import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.TransferableContent;
import androidx.compose.foundation.content.TransferableContent_androidKt;
import androidx.compose.foundation.content.internal.DragAndDropRequestPermission_androidKt;
import androidx.compose.foundation.content.internal.ReceiveContentConfiguration;
import androidx.compose.foundation.content.internal.ReceiveContentConfigurationKt;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.AutofillHighlightKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.KeyCommand;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import androidx.compose.foundation.text.input.internal.selection.TextToolbarState;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.autofill.ContentDataType;
import androidx.compose.p002ui.draganddrop.DragAndDropEvent;
import androidx.compose.p002ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.p002ui.focus.FocusDirection;
import androidx.compose.p002ui.focus.FocusManager;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.graphics.Color;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.input.key.KeyInputModifierNode;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.p002ui.modifier.ModifierLocalModifierNode;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.ObserverModifierNode;
import androidx.compose.ui.node.ObserverModifierNodeKt;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.PlatformTextInputModifierNode;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* compiled from: TextFieldDecoratorModifier.kt */
@Metadata(d1 = {"\u0000ÿ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001]\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000bBs\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u001b\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u0015\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\f\u0010l\u001a\u00020!*\u00020mH\u0016J\u000e\u0010n\u001a\u00020!H\u0082@¢\u0006\u0002\u0010oJr\u0010p\u001a\u00020!2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00152\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 J\f\u0010s\u001a\u00020!*\u00020tH\u0016J\b\u0010u\u001a\u00020!H\u0002J\b\u0010v\u001a\u00020!H\u0002J\b\u0010w\u001a\u00020!H\u0016J\b\u0010x\u001a\u00020!H\u0016J\u0010\u0010y\u001a\u00020!2\u0006\u0010z\u001a\u00020{H\u0016J,\u0010|\u001a\u00020!2\u0006\u0010}\u001a\u00020~2\u0007\u0010\u007f\u001a\u00030\u0080\u00012\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\t\u0010\u0085\u0001\u001a\u00020!H\u0016J\u001c\u0010\u0086\u0001\u001a\u00020\u00152\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u001c\u0010\u008b\u0001\u001a\u00020\u00152\b\u0010\u0087\u0001\u001a\u00030\u0088\u0001H\u0016¢\u0006\u0006\b\u008c\u0001\u0010\u008a\u0001J\t\u0010\u008d\u0001\u001a\u00020!H\u0016J\t\u0010\u008e\u0001\u001a\u00020!H\u0002J\u0011\u0010\u008f\u0001\u001a\u00020!2\u0006\u0010z\u001a\u00020{H\u0016J\u001c\u0010\u0090\u0001\u001a\u00020!2\b\u0010\u0091\u0001\u001a\u00030\u0082\u0001H\u0016¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0012\u0010\u0094\u0001\u001a\u00020!2\u0007\u0010\u0095\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0096\u0001\u001a\u00020!H\u0002J\n\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0002J\t\u0010\u0099\u0001\u001a\u00020!H\u0002J\u001c\u0010\u009a\u0001\u001a\u00020\u00152\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u001c\u0010\u009f\u0001\u001a\u00020\u00152\b\u0010\u009b\u0001\u001a\u00030\u009c\u0001H\u0002¢\u0006\u0006\b \u0001\u0010\u009e\u0001R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u0010\u0016\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00105\"\u0004\b9\u00107R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\u001b\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00105\"\u0004\bC\u00107R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010\u001e\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u00105\"\u0004\bH\u00107R\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u000e\u0010M\u001a\u00020NX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bW\u00105R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020[X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u00020]X\u0082\u0004¢\u0006\u0004\n\u0002\u0010^R\u0010\u0010_\u001a\u00020`X\u0082\u0004¢\u0006\u0004\n\u0002\u0010aR\u0010\u0010b\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0dX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010g\u001a\u00020\u00152\u0006\u0010f\u001a\u00020\u00158B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bh\u00105\"\u0004\bi\u00107R\u0014\u0010q\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u00105¨\u0006¡\u0001"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/platform/PlatformTextInputModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/input/key/KeyInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/ObserverModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "filter", "Landroidx/compose/foundation/text/input/InputTransformation;", "enabled", "", "readOnly", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActionHandler", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "singleLine", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "isPassword", "stylusHandwritingTrigger", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/InputTransformation;ZZLandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlinx/coroutines/flow/MutableSharedFlow;)V", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "setTextFieldState", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;)V", "getTextLayoutState", "()Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "setTextLayoutState", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;)V", "getTextFieldSelectionState", "()Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "setTextFieldSelectionState", "(Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;)V", "getFilter", "()Landroidx/compose/foundation/text/input/InputTransformation;", "setFilter", "(Landroidx/compose/foundation/text/input/InputTransformation;)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getReadOnly", "setReadOnly", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "setKeyboardOptions", "(Landroidx/compose/foundation/text/KeyboardOptions;)V", "getKeyboardActionHandler", "()Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "setKeyboardActionHandler", "(Landroidx/compose/foundation/text/input/KeyboardActionHandler;)V", "getSingleLine", "setSingleLine", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "setInteractionSource", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;)V", "setPassword", "getStylusHandwritingTrigger", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "setStylusHandwritingTrigger", "(Lkotlinx/coroutines/flow/MutableSharedFlow;)V", "focusableNode", "Landroidx/compose/foundation/FocusableNode;", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "dragEnterEvent", "Landroidx/compose/foundation/interaction/HoverInteraction$Enter;", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "isFocused", "toolbarAndHandlesVisibilityObserverJob", "Lkotlinx/coroutines/Job;", "textFieldKeyEventHandler", "Landroidx/compose/foundation/text/input/internal/TextFieldKeyEventHandler;", "keyboardActionScope", "androidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1", "Landroidx/compose/foundation/text/input/internal/TextFieldDecoratorModifierNode$keyboardActionScope$1;", "clipboardKeyCommandsHandler", "Landroidx/compose/foundation/text/input/internal/ClipboardKeyCommandsHandler;", "Lkotlin/jvm/functions/Function1;", "inputSessionJob", "receiveContentConfigurationProvider", "Lkotlin/Function0;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "<set-?>", "autofillHighlightOn", "getAutofillHighlightOn", "setAutofillHighlightOn", "autofillHighlightOn$delegate", "Landroidx/compose/runtime/MutableState;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "observeUntransformedTextChanges", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateNode", "shouldMergeDescendantSemantics", "getShouldMergeDescendantSemantics", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "requestFocus", "onIsFocusedUpdated", "onAttach", "onDetach", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "onPreKeyEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onPreKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onKeyEvent", "onKeyEvent-ZmokQxo", "onObservedReadsChanged", "updateWindowFocus", "onPlaced", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "startInputSession", "fromTap", "disposeInputSession", "requireKeyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "emitDragExitEvent", "onImeActionPerformed", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "onImeActionPerformed-KlQnJC8", "(I)Z", "defaultKeyboardActionWithResult", "defaultKeyboardActionWithResult-KlQnJC8", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldDecoratorModifierNode extends DelegatingNode implements DrawModifierNode, PlatformTextInputModifierNode, SemanticsModifierNode, GlobalPositionAwareModifierNode, PointerInputModifierNode, KeyInputModifierNode, CompositionLocalConsumerModifierNode, ModifierLocalModifierNode, ObserverModifierNode, LayoutAwareModifierNode {
    public static final int $stable = 8;

    /* renamed from: autofillHighlightOn$delegate, reason: from kotlin metadata */
    private final MutableState autofillHighlightOn;
    private final Function1<? super KeyCommand, ? extends Unit> clipboardKeyCommandsHandler;
    private final DragAndDropTargetModifierNode dragAndDropNode;
    private HoverInteraction.Enter dragEnterEvent;
    private boolean enabled;
    private InputTransformation filter;
    private final FocusableNode focusableNode;
    private Job inputSessionJob;
    private MutableInteractionSource interactionSource;
    private boolean isPassword;
    private KeyboardActionHandler keyboardActionHandler;
    private final TextFieldDecoratorModifierNode$keyboardActionScope$1 keyboardActionScope;
    private KeyboardOptions keyboardOptions;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private boolean readOnly;
    private final Function0<ReceiveContentConfiguration> receiveContentConfigurationProvider;
    private boolean singleLine;
    private MutableSharedFlow<Unit> stylusHandwritingTrigger;
    private final TextFieldKeyEventHandler textFieldKeyEventHandler;
    private TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private Job toolbarAndHandlesVisibilityObserverJob;
    private WindowInfo windowInfo;

    public boolean getShouldMergeDescendantSemantics() {
        return true;
    }

    public final TransformedTextFieldState getTextFieldState() {
        return this.textFieldState;
    }

    public final void setTextFieldState(TransformedTextFieldState transformedTextFieldState) {
        this.textFieldState = transformedTextFieldState;
    }

    public final TextLayoutState getTextLayoutState() {
        return this.textLayoutState;
    }

    public final void setTextLayoutState(TextLayoutState textLayoutState) {
        this.textLayoutState = textLayoutState;
    }

    public final TextFieldSelectionState getTextFieldSelectionState() {
        return this.textFieldSelectionState;
    }

    public final void setTextFieldSelectionState(TextFieldSelectionState textFieldSelectionState) {
        this.textFieldSelectionState = textFieldSelectionState;
    }

    public final InputTransformation getFilter() {
        return this.filter;
    }

    public final void setFilter(InputTransformation inputTransformation) {
        this.filter = inputTransformation;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final void setReadOnly(boolean z) {
        this.readOnly = z;
    }

    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public final void setKeyboardOptions(KeyboardOptions keyboardOptions) {
        this.keyboardOptions = keyboardOptions;
    }

    public final KeyboardActionHandler getKeyboardActionHandler() {
        return this.keyboardActionHandler;
    }

    public final void setKeyboardActionHandler(KeyboardActionHandler keyboardActionHandler) {
        this.keyboardActionHandler = keyboardActionHandler;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    public final void setSingleLine(boolean z) {
        this.singleLine = z;
    }

    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    public final void setInteractionSource(MutableInteractionSource mutableInteractionSource) {
        this.interactionSource = mutableInteractionSource;
    }

    /* renamed from: isPassword, reason: from getter */
    public final boolean getIsPassword() {
        return this.isPassword;
    }

    public final void setPassword(boolean z) {
        this.isPassword = z;
    }

    public final MutableSharedFlow<Unit> getStylusHandwritingTrigger() {
        return this.stylusHandwritingTrigger;
    }

    public final void setStylusHandwritingTrigger(MutableSharedFlow<Unit> mutableSharedFlow) {
        this.stylusHandwritingTrigger = mutableSharedFlow;
    }

    public TextFieldDecoratorModifierNode(TransformedTextFieldState transformedTextFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation inputTransformation, boolean z, boolean z2, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean z3, MutableInteractionSource mutableInteractionSource, boolean z4, MutableSharedFlow<Unit> mutableSharedFlow) {
        DragAndDropTargetModifierNode textFieldDragAndDropNode;
        MutableState mutableStateOf$default;
        this.textFieldState = transformedTextFieldState;
        this.textLayoutState = textLayoutState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.filter = inputTransformation;
        this.enabled = z;
        this.readOnly = z2;
        this.keyboardOptions = keyboardOptions;
        this.keyboardActionHandler = keyboardActionHandler;
        this.singleLine = z3;
        this.interactionSource = mutableInteractionSource;
        this.isPassword = z4;
        this.stylusHandwritingTrigger = mutableSharedFlow;
        textFieldSelectionState.setRequestAutofillAction(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda20
            public final Object invoke() {
                Unit _init_$lambda$0;
                _init_$lambda$0 = TextFieldDecoratorModifierNode._init_$lambda$0(TextFieldDecoratorModifierNode.this);
                return _init_$lambda$0;
            }
        });
        this.focusableNode = new FocusableNode(this.interactionSource, 0, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda22
            public final Object invoke(Object obj) {
                Unit focusableNode$lambda$2;
                focusableNode$lambda$2 = TextFieldDecoratorModifierNode.focusableNode$lambda$2(TextFieldDecoratorModifierNode.this, ((Boolean) obj).booleanValue());
                return focusableNode$lambda$2;
            }
        }, 2, null);
        this.pointerInputNode = delegate((DelegatableNode) SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1

            /* compiled from: TextFieldDecoratorModifier.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1", f = "TextFieldDecoratorModifier.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            static final class C04741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerInputScope $this_SuspendingPointerInputModifierNode;
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ TextFieldDecoratorModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C04741(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, PointerInputScope pointerInputScope, Continuation<? super C04741> continuation) {
                    super(2, continuation);
                    this.this$0 = textFieldDecoratorModifierNode;
                    this.$this_SuspendingPointerInputModifierNode = pointerInputScope;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c04741 = new C04741(this.this$0, this.$this_SuspendingPointerInputModifierNode, continuation);
                    c04741.L$0 = obj;
                    return c04741;
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
                    final TextFieldSelectionState textFieldSelectionState = this.this$0.getTextFieldSelectionState();
                    final TextFieldDecoratorModifierNode textFieldDecoratorModifierNode = this.this$0;
                    PointerInputScope pointerInputScope = this.$this_SuspendingPointerInputModifierNode;
                    Function0 function0 = 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: CONSTRUCTOR (r9v0 'function0' kotlin.jvm.functions.Function0) = 
                          (r7v0 'textFieldSelectionState' androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState A[DONT_INLINE])
                          (r6v0 'textFieldDecoratorModifierNode' androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode A[DONT_INLINE])
                         A[DECLARE_VAR, MD:(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode):void (m)] (LINE:234) call: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$$ExternalSyntheticLambda0.<init>(androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState, androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode):void type: CONSTRUCTOR in method: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1.1.invokeSuspend(java.lang.Object):java.lang.Object, file: /data/user/work/trae_cn3_decoded/build/apk/classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:304)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:781)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 19 more
                        */
                    /*
                        this = this;
                        kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r0 = r14.label
                        if (r0 != 0) goto L5b
                        kotlin.ResultKt.throwOnFailure(r15)
                        java.lang.Object r15 = r14.L$0
                        kotlinx.coroutines.CoroutineScope r15 = (kotlinx.coroutines.CoroutineScope) r15
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r0 = r14.this$0
                        androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState r7 = r0.getTextFieldSelectionState()
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode r6 = r14.this$0
                        androidx.compose.ui.input.pointer.PointerInputScope r8 = r14.$this_SuspendingPointerInputModifierNode
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$$ExternalSyntheticLambda0 r9 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$$ExternalSyntheticLambda0
                        r9.<init>(r7, r6)
                        r1 = 0
                        kotlinx.coroutines.CoroutineStart r2 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$1 r0 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$1
                        r10 = 0
                        r0.<init>(r7, r8, r10)
                        r3 = r0
                        kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                        r4 = 1
                        r5 = 0
                        r0 = r15
                        kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
                        r11 = 0
                        kotlinx.coroutines.CoroutineStart r12 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2 r0 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$2
                        r13 = 0
                        r1 = r0
                        r2 = r6
                        r3 = r7
                        r4 = r8
                        r5 = r9
                        r6 = r13
                        r1.<init>(r2, r3, r4, r5, r6)
                        r3 = r0
                        kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                        r4 = 1
                        r5 = 0
                        r0 = r15
                        r1 = r11
                        r2 = r12
                        kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
                        r1 = 0
                        kotlinx.coroutines.CoroutineStart r2 = kotlinx.coroutines.CoroutineStart.UNDISPATCHED
                        androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$3 r0 = new androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1$1$1$3
                        r0.<init>(r7, r8, r9, r10)
                        r3 = r0
                        kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                        r0 = r15
                        kotlinx.coroutines.BuildersKt.launch$default(r0, r1, r2, r3, r4, r5)
                        kotlin.Unit r15 = kotlin.Unit.INSTANCE
                        return r15
                    L5b:
                        java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r15.<init>(r0)
                        throw r15
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$pointerInputNode$1.C04741.invokeSuspend(java.lang.Object):java.lang.Object");
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final Unit invokeSuspend$lambda$1$lambda$0(TextFieldSelectionState textFieldSelectionState, TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
                    if (!textFieldSelectionState.getIsFocused()) {
                        textFieldDecoratorModifierNode.requestFocus();
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object coroutineScope = CoroutineScopeKt.coroutineScope(new C04741(TextFieldDecoratorModifierNode.this, pointerInputScope, null), continuation);
                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
            }
        }));
        textFieldDragAndDropNode = TextFieldDragAndDropNode_androidKt.textFieldDragAndDropNode(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda23
            public final Object invoke() {
                Set dragAndDropNode$lambda$3;
                dragAndDropNode$lambda$3 = TextFieldDecoratorModifierNode.dragAndDropNode$lambda$3(TextFieldDecoratorModifierNode.this);
                return dragAndDropNode$lambda$3;
            }
        }, new Function2() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda24
            public final Object invoke(Object obj, Object obj2) {
                boolean dragAndDropNode$lambda$4;
                dragAndDropNode$lambda$4 = TextFieldDecoratorModifierNode.dragAndDropNode$lambda$4(TextFieldDecoratorModifierNode.this, (ClipEntry) obj, (ClipMetadata) obj2);
                return Boolean.valueOf(dragAndDropNode$lambda$4);
            }
        }, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda25
            public final Object invoke(Object obj) {
                Unit dragAndDropNode$lambda$5;
                dragAndDropNode$lambda$5 = TextFieldDecoratorModifierNode.dragAndDropNode$lambda$5(TextFieldDecoratorModifierNode.this, (DragAndDropEvent) obj);
                return dragAndDropNode$lambda$5;
            }
        }, (r21 & 8) != 0 ? null : null, (r21 & 16) != 0 ? null : new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda26
            public final Object invoke(Object obj) {
                Unit dragAndDropNode$lambda$7;
                dragAndDropNode$lambda$7 = TextFieldDecoratorModifierNode.dragAndDropNode$lambda$7(TextFieldDecoratorModifierNode.this, (DragAndDropEvent) obj);
                return dragAndDropNode$lambda$7;
            }
        }, (r21 & 32) != 0 ? null : new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit dragAndDropNode$lambda$8;
                dragAndDropNode$lambda$8 = TextFieldDecoratorModifierNode.dragAndDropNode$lambda$8(TextFieldDecoratorModifierNode.this, (Offset) obj);
                return dragAndDropNode$lambda$8;
            }
        }, (r21 & 64) != 0 ? null : null, (r21 & Fields.SpotShadowColor) != 0 ? null : new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit dragAndDropNode$lambda$9;
                dragAndDropNode$lambda$9 = TextFieldDecoratorModifierNode.dragAndDropNode$lambda$9(TextFieldDecoratorModifierNode.this, (DragAndDropEvent) obj);
                return dragAndDropNode$lambda$9;
            }
        }, (r21 & Fields.RotationX) != 0 ? null : new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit dragAndDropNode$lambda$10;
                dragAndDropNode$lambda$10 = TextFieldDecoratorModifierNode.dragAndDropNode$lambda$10(TextFieldDecoratorModifierNode.this, (DragAndDropEvent) obj);
                return dragAndDropNode$lambda$10;
            }
        });
        this.dragAndDropNode = delegate((DelegatableNode) textFieldDragAndDropNode);
        this.textFieldKeyEventHandler = TextFieldKeyEventHandler_androidKt.createTextFieldKeyEventHandler();
        this.keyboardActionScope = new TextFieldDecoratorModifierNode$keyboardActionScope$1(this);
        this.clipboardKeyCommandsHandler = ClipboardKeyCommandsHandler.m1773constructorimpl(new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit clipboardKeyCommandsHandler$lambda$11;
                clipboardKeyCommandsHandler$lambda$11 = TextFieldDecoratorModifierNode.clipboardKeyCommandsHandler$lambda$11(TextFieldDecoratorModifierNode.this, (KeyCommand) obj);
                return clipboardKeyCommandsHandler$lambda$11;
            }
        });
        this.receiveContentConfigurationProvider = new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda21
            public final Object invoke() {
                ReceiveContentConfiguration receiveContentConfigurationProvider$lambda$12;
                receiveContentConfigurationProvider$lambda$12 = TextFieldDecoratorModifierNode.receiveContentConfigurationProvider$lambda$12(TextFieldDecoratorModifierNode.this);
                return receiveContentConfigurationProvider$lambda$12;
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.autofillHighlightOn = mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        DelegatableNodeKt.requestAutofill(textFieldDecoratorModifierNode);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit focusableNode$lambda$2(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, boolean z) {
        boolean z2 = textFieldDecoratorModifierNode.enabled && !textFieldDecoratorModifierNode.readOnly;
        if (!z) {
            textFieldDecoratorModifierNode.disposeInputSession();
            TransformedTextFieldState transformedTextFieldState = textFieldDecoratorModifierNode.textFieldState;
            TextFieldState textFieldState = transformedTextFieldState.textFieldState;
            InputTransformation inputTransformation = transformedTextFieldState.inputTransformation;
            TextFieldEditUndoBehavior textFieldEditUndoBehavior = TextFieldEditUndoBehavior.MergeIfPossible;
            textFieldState.getMainBuffer().getChangeTracker$foundation_release().clearChanges();
            TextFieldBuffer mainBuffer = textFieldState.getMainBuffer();
            mainBuffer.commitComposition$foundation_release();
            transformedTextFieldState.updateWedgeAffinity(mainBuffer);
            textFieldState.commitEditAsUser(inputTransformation, true, textFieldEditUndoBehavior);
            textFieldDecoratorModifierNode.textFieldState.collapseSelectionToMax();
        } else if (z2) {
            textFieldDecoratorModifierNode.startInputSession(false);
        }
        textFieldDecoratorModifierNode.updateWindowFocus();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Set dragAndDropNode$lambda$3(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        Set set;
        Set set2;
        if (ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode) != null) {
            set2 = TextFieldDecoratorModifierKt.MediaTypesAll;
            return set2;
        }
        set = TextFieldDecoratorModifierKt.MediaTypesText;
        return set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dragAndDropNode$lambda$5(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, DragAndDropEvent dragAndDropEvent) {
        if (ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode) != null) {
            DragAndDropRequestPermission_androidKt.dragAndDropRequestPermission(textFieldDecoratorModifierNode, dragAndDropEvent);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dragAndDropNode$lambda$7(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, DragAndDropEvent dragAndDropEvent) {
        ReceiveContentListener receiveContentListener;
        HoverInteraction.Enter enter = new HoverInteraction.Enter();
        textFieldDecoratorModifierNode.interactionSource.tryEmit(enter);
        textFieldDecoratorModifierNode.dragEnterEvent = enter;
        ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode);
        if (receiveContentConfiguration != null && (receiveContentListener = receiveContentConfiguration.getReceiveContentListener()) != null) {
            receiveContentListener.onDragEnter();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dragAndDropNode$lambda$8(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, Offset offset) {
        long m1893fromWindowToDecorationUv8p0NA = TextLayoutStateKt.m1893fromWindowToDecorationUv8p0NA(textFieldDecoratorModifierNode.textLayoutState, offset.m4603unboximpl());
        int m1883getOffsetForPosition3MmeM6k$default = TextLayoutState.m1883getOffsetForPosition3MmeM6k$default(textFieldDecoratorModifierNode.textLayoutState, m1893fromWindowToDecorationUv8p0NA, false, 2, null);
        if (m1883getOffsetForPosition3MmeM6k$default >= 0) {
            textFieldDecoratorModifierNode.textFieldState.m1906selectCharsIn5zctL8(TextRangeKt.TextRange(m1883getOffsetForPosition3MmeM6k$default));
        }
        textFieldDecoratorModifierNode.textFieldSelectionState.m1959updateHandleDraggingUv8p0NA(Handle.Cursor, m1893fromWindowToDecorationUv8p0NA);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dragAndDropNode$lambda$4(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, ClipEntry clipEntry, ClipMetadata clipMetadata) {
        ClipEntry clipEntry2;
        textFieldDecoratorModifierNode.emitDragExitEvent();
        textFieldDecoratorModifierNode.textFieldSelectionState.clearHandleDragging();
        String readPlainText = TransferableContent_androidKt.readPlainText(clipEntry);
        ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode);
        if (receiveContentConfiguration != null) {
            TransferableContent onReceive = receiveContentConfiguration.getReceiveContentListener().onReceive(new TransferableContent(clipEntry, clipMetadata, TransferableContent.Source.INSTANCE.m533getDragAndDropkB6V9T0(), null, 8, null));
            readPlainText = (onReceive == null || (clipEntry2 = onReceive.getClipEntry()) == null) ? null : TransferableContent_androidKt.readPlainText(clipEntry2);
        }
        if (readPlainText == null) {
            return true;
        }
        TransformedTextFieldState.replaceSelectedText$default(textFieldDecoratorModifierNode.textFieldState, readPlainText, false, null, false, 14, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dragAndDropNode$lambda$9(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, DragAndDropEvent dragAndDropEvent) {
        ReceiveContentListener receiveContentListener;
        textFieldDecoratorModifierNode.emitDragExitEvent();
        textFieldDecoratorModifierNode.textFieldSelectionState.clearHandleDragging();
        ReceiveContentConfiguration receiveContentConfiguration = ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode);
        if (receiveContentConfiguration != null && (receiveContentListener = receiveContentConfiguration.getReceiveContentListener()) != null) {
            receiveContentListener.onDragExit();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit dragAndDropNode$lambda$10(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, DragAndDropEvent dragAndDropEvent) {
        textFieldDecoratorModifierNode.emitDragExitEvent();
        return Unit.INSTANCE;
    }

    private final boolean isFocused() {
        if (!this.focusableNode.getFocusState().isFocused()) {
            return false;
        }
        WindowInfo windowInfo = this.windowInfo;
        return windowInfo != null && windowInfo.isWindowFocused();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clipboardKeyCommandsHandler$lambda$11(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, KeyCommand keyCommand) {
        BuildersKt.launch$default(textFieldDecoratorModifierNode.getCoroutineScope(), (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new TextFieldDecoratorModifierNode$clipboardKeyCommandsHandler$1$1(keyCommand, textFieldDecoratorModifierNode, null), 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReceiveContentConfiguration receiveContentConfigurationProvider$lambda$12(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        return ReceiveContentConfigurationKt.getReceiveContentConfiguration(textFieldDecoratorModifierNode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean getAutofillHighlightOn() {
        return ((Boolean) this.autofillHighlightOn.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAutofillHighlightOn(boolean z) {
        this.autofillHighlightOn.setValue(Boolean.valueOf(z));
    }

    public void draw(ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        if (getAutofillHighlightOn()) {
            DrawScope.m5411drawRectnJ9OG0$default(contentDrawScope, ((Color) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, AutofillHighlightKt.getLocalAutofillHighlightColor())).m4849unboximpl(), 0L, 0L, 0.0f, null, null, 0, 126, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object observeUntransformedTextChanges(Continuation<? super Unit> continuation) {
        Object collect = FlowKt.take(FlowKt.drop(SnapshotStateKt.snapshotFlow(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda19
            public final Object invoke() {
                String observeUntransformedTextChanges$lambda$13;
                observeUntransformedTextChanges$lambda$13 = TextFieldDecoratorModifierNode.observeUntransformedTextChanges$lambda$13(TextFieldDecoratorModifierNode.this);
                return observeUntransformedTextChanges$lambda$13;
            }
        }), 1), 1).collect(new FlowCollector() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$observeUntransformedTextChanges$3
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((String) obj, (Continuation<? super Unit>) continuation2);
            }

            public final Object emit(String str, Continuation<? super Unit> continuation2) {
                TextFieldDecoratorModifierNode.this.setAutofillHighlightOn(false);
                return Unit.INSTANCE;
            }
        }, continuation);
        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String observeUntransformedTextChanges$lambda$13(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        return textFieldDecoratorModifierNode.textFieldState.getUntransformedText().toString();
    }

    public final void updateNode(TransformedTextFieldState textFieldState, TextLayoutState textLayoutState, TextFieldSelectionState textFieldSelectionState, InputTransformation filter, boolean enabled, boolean readOnly, KeyboardOptions keyboardOptions, KeyboardActionHandler keyboardActionHandler, boolean singleLine, MutableInteractionSource interactionSource, boolean isPassword, MutableSharedFlow<Unit> stylusHandwritingTrigger) {
        TextFieldSelectionState textFieldSelectionState2;
        boolean z;
        Job job;
        boolean z2 = this.enabled;
        boolean z3 = z2 && !this.readOnly;
        TransformedTextFieldState transformedTextFieldState = this.textFieldState;
        KeyboardOptions keyboardOptions2 = this.keyboardOptions;
        TextFieldSelectionState textFieldSelectionState3 = this.textFieldSelectionState;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        boolean z4 = this.isPassword;
        MutableSharedFlow<Unit> mutableSharedFlow = this.stylusHandwritingTrigger;
        if (!enabled || readOnly) {
            textFieldSelectionState2 = textFieldSelectionState3;
            z = false;
        } else {
            textFieldSelectionState2 = textFieldSelectionState3;
            z = true;
        }
        this.textFieldState = textFieldState;
        this.textLayoutState = textLayoutState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.filter = filter;
        this.enabled = enabled;
        this.readOnly = readOnly;
        this.keyboardOptions = keyboardOptions;
        this.keyboardActionHandler = keyboardActionHandler;
        this.singleLine = singleLine;
        this.interactionSource = interactionSource;
        this.isPassword = isPassword;
        this.stylusHandwritingTrigger = stylusHandwritingTrigger;
        if (z != z3 || !Intrinsics.areEqual(textFieldState, transformedTextFieldState) || !Intrinsics.areEqual(keyboardOptions, keyboardOptions2) || !Intrinsics.areEqual(stylusHandwritingTrigger, mutableSharedFlow)) {
            if (z && isFocused()) {
                startInputSession(false);
            } else if (!z) {
                disposeInputSession();
            }
        }
        if (enabled != z2 || z != z3 || !ImeAction.equals-impl0(keyboardOptions.m1558getImeActionOrDefaulteUduSuo$foundation_release(), keyboardOptions2.m1558getImeActionOrDefaulteUduSuo$foundation_release()) || isPassword != z4) {
            SemanticsModifierNodeKt.invalidateSemantics(this);
        }
        if (!Intrinsics.areEqual(textFieldSelectionState, textFieldSelectionState2)) {
            this.pointerInputNode.resetPointerInputHandler();
            if (isAttached()) {
                textFieldSelectionState.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
                if (isFocused() && (job = this.toolbarAndHandlesVisibilityObserverJob) != null) {
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    this.toolbarAndHandlesVisibilityObserverJob = BuildersKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldDecoratorModifierNode$updateNode$1(textFieldSelectionState, null), 3, (Object) null);
                }
            }
            textFieldSelectionState.setRequestAutofillAction(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda11
                public final Object invoke() {
                    Unit updateNode$lambda$14;
                    updateNode$lambda$14 = TextFieldDecoratorModifierNode.updateNode$lambda$14(TextFieldDecoratorModifierNode.this);
                    return updateNode$lambda$14;
                }
            });
        }
        if (!Intrinsics.areEqual(interactionSource, mutableInteractionSource)) {
            this.pointerInputNode.resetPointerInputHandler();
            if (this.focusableNode.isAttached()) {
                this.focusableNode.update(interactionSource);
            }
        }
        if (enabled != z2) {
            if (enabled) {
                delegate((DelegatableNode) this.focusableNode);
                this.focusableNode.update(interactionSource);
            } else {
                undelegate((DelegatableNode) this.focusableNode);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateNode$lambda$14(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        DelegatableNodeKt.requestAutofill(textFieldDecoratorModifierNode);
        return Unit.INSTANCE;
    }

    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        TextFieldCharSequence outputText = this.textFieldState.getOutputText();
        long selection = outputText.getSelection();
        SemanticsPropertiesKt.setInputText(semanticsPropertyReceiver, new AnnotatedString(this.textFieldState.getUntransformedText().toString(), (List) null, 2, (DefaultConstructorMarker) null));
        SemanticsPropertiesKt.setEditableText(semanticsPropertyReceiver, new AnnotatedString(outputText.toString(), (List) null, 2, (DefaultConstructorMarker) null));
        SemanticsPropertiesKt.setTextSelectionRange-FDrldGo(semanticsPropertyReceiver, selection);
        if (!this.enabled) {
            SemanticsPropertiesKt.disabled(semanticsPropertyReceiver);
        }
        if (this.isPassword) {
            SemanticsPropertiesKt.password(semanticsPropertyReceiver);
        }
        final boolean z = this.enabled && !this.readOnly;
        SemanticsPropertiesKt.setEditable(semanticsPropertyReceiver, z);
        SemanticsPropertiesKt.setContentDataType(semanticsPropertyReceiver, ContentDataType.INSTANCE.getText());
        SemanticsPropertiesKt.onAutofillText$default(semanticsPropertyReceiver, (String) null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                boolean applySemantics$lambda$15;
                applySemantics$lambda$15 = TextFieldDecoratorModifierNode.applySemantics$lambda$15(z, this, (AnnotatedString) obj);
                return Boolean.valueOf(applySemantics$lambda$15);
            }
        }, 1, (Object) null);
        SemanticsPropertiesKt.getTextLayoutResult$default(semanticsPropertyReceiver, (String) null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda8
            public final Object invoke(Object obj) {
                boolean applySemantics$lambda$17;
                applySemantics$lambda$17 = TextFieldDecoratorModifierNode.applySemantics$lambda$17(TextFieldDecoratorModifierNode.this, (List) obj);
                return Boolean.valueOf(applySemantics$lambda$17);
            }
        }, 1, (Object) null);
        if (z) {
            SemanticsPropertiesKt.setText$default(semanticsPropertyReceiver, (String) null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda9
                public final Object invoke(Object obj) {
                    boolean applySemantics$lambda$18;
                    applySemantics$lambda$18 = TextFieldDecoratorModifierNode.applySemantics$lambda$18(z, this, (AnnotatedString) obj);
                    return Boolean.valueOf(applySemantics$lambda$18);
                }
            }, 1, (Object) null);
            SemanticsPropertiesKt.insertTextAtCursor$default(semanticsPropertyReceiver, (String) null, new Function1() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda10
                public final Object invoke(Object obj) {
                    boolean applySemantics$lambda$19;
                    applySemantics$lambda$19 = TextFieldDecoratorModifierNode.applySemantics$lambda$19(z, this, (AnnotatedString) obj);
                    return Boolean.valueOf(applySemantics$lambda$19);
                }
            }, 1, (Object) null);
        }
        SemanticsPropertiesKt.setSelection$default(semanticsPropertyReceiver, (String) null, new Function3() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda12
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                boolean applySemantics$lambda$20;
                applySemantics$lambda$20 = TextFieldDecoratorModifierNode.applySemantics$lambda$20(TextFieldDecoratorModifierNode.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), ((Boolean) obj3).booleanValue());
                return Boolean.valueOf(applySemantics$lambda$20);
            }
        }, 1, (Object) null);
        final int m1558getImeActionOrDefaulteUduSuo$foundation_release = this.keyboardOptions.m1558getImeActionOrDefaulteUduSuo$foundation_release();
        SemanticsPropertiesKt.onImeAction-9UiTYpY$default(semanticsPropertyReceiver, m1558getImeActionOrDefaulteUduSuo$foundation_release, (String) null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda13
            public final Object invoke() {
                boolean applySemantics$lambda$21;
                applySemantics$lambda$21 = TextFieldDecoratorModifierNode.applySemantics$lambda$21(TextFieldDecoratorModifierNode.this, m1558getImeActionOrDefaulteUduSuo$foundation_release);
                return Boolean.valueOf(applySemantics$lambda$21);
            }
        }, 2, (Object) null);
        SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, (String) null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda14
            public final Object invoke() {
                boolean applySemantics$lambda$22;
                applySemantics$lambda$22 = TextFieldDecoratorModifierNode.applySemantics$lambda$22(TextFieldDecoratorModifierNode.this);
                return Boolean.valueOf(applySemantics$lambda$22);
            }
        }, 1, (Object) null);
        SemanticsPropertiesKt.onLongClick$default(semanticsPropertyReceiver, (String) null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda15
            public final Object invoke() {
                boolean applySemantics$lambda$23;
                applySemantics$lambda$23 = TextFieldDecoratorModifierNode.applySemantics$lambda$23(TextFieldDecoratorModifierNode.this);
                return Boolean.valueOf(applySemantics$lambda$23);
            }
        }, 1, (Object) null);
        if (!TextRange.getCollapsed-impl(selection) && !this.isPassword) {
            SemanticsPropertiesKt.copyText$default(semanticsPropertyReceiver, (String) null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda16
                public final Object invoke() {
                    boolean applySemantics$lambda$24;
                    applySemantics$lambda$24 = TextFieldDecoratorModifierNode.applySemantics$lambda$24(TextFieldDecoratorModifierNode.this);
                    return Boolean.valueOf(applySemantics$lambda$24);
                }
            }, 1, (Object) null);
            if (this.enabled && !this.readOnly) {
                SemanticsPropertiesKt.cutText$default(semanticsPropertyReceiver, (String) null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda17
                    public final Object invoke() {
                        boolean applySemantics$lambda$25;
                        applySemantics$lambda$25 = TextFieldDecoratorModifierNode.applySemantics$lambda$25(TextFieldDecoratorModifierNode.this);
                        return Boolean.valueOf(applySemantics$lambda$25);
                    }
                }, 1, (Object) null);
            }
        }
        if (z) {
            SemanticsPropertiesKt.pasteText$default(semanticsPropertyReceiver, (String) null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda7
                public final Object invoke() {
                    boolean applySemantics$lambda$26;
                    applySemantics$lambda$26 = TextFieldDecoratorModifierNode.applySemantics$lambda$26(TextFieldDecoratorModifierNode.this);
                    return Boolean.valueOf(applySemantics$lambda$26);
                }
            }, 1, (Object) null);
        }
        InputTransformation inputTransformation = this.filter;
        if (inputTransformation != null) {
            inputTransformation.applySemantics(semanticsPropertyReceiver);
        }
        if (this.enabled) {
            this.focusableNode.applySemantics(semanticsPropertyReceiver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$15(boolean z, TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, AnnotatedString annotatedString) {
        if (!z) {
            return false;
        }
        textFieldDecoratorModifierNode.textFieldState.replaceAll((CharSequence) annotatedString);
        textFieldDecoratorModifierNode.setAutofillHighlightOn(true);
        BuildersKt.launch$default(textFieldDecoratorModifierNode.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldDecoratorModifierNode$applySemantics$1$1(textFieldDecoratorModifierNode, null), 3, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$17(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, List list) {
        TextLayoutResult layoutResult = textFieldDecoratorModifierNode.textLayoutState.getLayoutResult();
        if (layoutResult != null) {
            return list.add(layoutResult);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$18(boolean z, TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, AnnotatedString annotatedString) {
        if (!z) {
            return false;
        }
        textFieldDecoratorModifierNode.textFieldState.replaceAll((CharSequence) annotatedString);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$19(boolean z, TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, AnnotatedString annotatedString) {
        if (!z) {
            return false;
        }
        TransformedTextFieldState.replaceSelectedText$default(textFieldDecoratorModifierNode.textFieldState, (CharSequence) annotatedString, true, null, false, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$20(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, int i, int i2, boolean z) {
        TextFieldCharSequence visualText;
        if (z) {
            visualText = textFieldDecoratorModifierNode.textFieldState.getUntransformedText();
        } else {
            visualText = textFieldDecoratorModifierNode.textFieldState.getVisualText();
        }
        long selection = visualText.getSelection();
        if (!textFieldDecoratorModifierNode.enabled || Math.min(i, i2) < 0 || Math.max(i, i2) > visualText.length()) {
            return false;
        }
        if (i == TextRange.getStart-impl(selection) && i2 == TextRange.getEnd-impl(selection)) {
            return true;
        }
        long TextRange = TextRangeKt.TextRange(i, i2);
        if (z || i == i2) {
            textFieldDecoratorModifierNode.textFieldSelectionState.updateTextToolbarState(TextToolbarState.None);
        } else {
            textFieldDecoratorModifierNode.textFieldSelectionState.updateTextToolbarState(TextToolbarState.Selection);
        }
        if (z) {
            textFieldDecoratorModifierNode.textFieldState.m1907selectUntransformedCharsIn5zctL8(TextRange);
        } else {
            textFieldDecoratorModifierNode.textFieldState.m1906selectCharsIn5zctL8(TextRange);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$21(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, int i) {
        textFieldDecoratorModifierNode.m1864onImeActionPerformedKlQnJC8(i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$22(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        if (!textFieldDecoratorModifierNode.isFocused()) {
            textFieldDecoratorModifierNode.requestFocus();
            return true;
        }
        if (textFieldDecoratorModifierNode.readOnly) {
            return true;
        }
        textFieldDecoratorModifierNode.requireKeyboardController().show();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$23(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        if (!textFieldDecoratorModifierNode.isFocused()) {
            textFieldDecoratorModifierNode.requestFocus();
        }
        textFieldDecoratorModifierNode.textFieldSelectionState.updateTextToolbarState(TextToolbarState.Selection);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$24(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        BuildersKt.launch$default(textFieldDecoratorModifierNode.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldDecoratorModifierNode$applySemantics$9$1(textFieldDecoratorModifierNode, null), 3, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$25(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        BuildersKt.launch$default(textFieldDecoratorModifierNode.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldDecoratorModifierNode$applySemantics$10$1(textFieldDecoratorModifierNode, null), 3, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applySemantics$lambda$26(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        BuildersKt.launch$default(textFieldDecoratorModifierNode.getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldDecoratorModifierNode$applySemantics$11$1(textFieldDecoratorModifierNode, null), 3, (Object) null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestFocus() {
        if (this.focusableNode.isAttached()) {
            this.focusableNode.requestFocus();
        }
    }

    private final void onIsFocusedUpdated() {
        this.textFieldSelectionState.setFocused(isFocused());
        if (isFocused() && this.toolbarAndHandlesVisibilityObserverJob == null) {
            this.toolbarAndHandlesVisibilityObserverJob = BuildersKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldDecoratorModifierNode$onIsFocusedUpdated$1(this, null), 3, (Object) null);
        } else {
            if (isFocused()) {
                return;
            }
            Job job = this.toolbarAndHandlesVisibilityObserverJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.toolbarAndHandlesVisibilityObserverJob = null;
        }
    }

    public void onAttach() {
        onObservedReadsChanged();
        this.textFieldSelectionState.setReceiveContentConfiguration(this.receiveContentConfigurationProvider);
        if (this.enabled) {
            delegate((DelegatableNode) this.focusableNode);
        }
    }

    public void onDetach() {
        disposeInputSession();
        this.textFieldSelectionState.setReceiveContentConfiguration(null);
    }

    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.textLayoutState.setDecoratorNodeCoordinates(coordinates);
        if (this.enabled) {
            this.focusableNode.onGloballyPositioned(coordinates);
        }
    }

    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void m1865onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.pointerInputNode.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
    }

    public void onCancelPointerInput() {
        this.pointerInputNode.onCancelPointerInput();
    }

    @Override // androidx.compose.p002ui.input.key.KeyInputModifierNode
    /* renamed from: onPreKeyEvent-ZmokQxo */
    public boolean mo364onPreKeyEventZmokQxo(KeyEvent event) {
        return this.textFieldKeyEventHandler.mo1766onPreKeyEventMyFupTE(event, this.textFieldState, this.textFieldSelectionState, (FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager()), requireKeyboardController());
    }

    @Override // androidx.compose.p002ui.input.key.KeyInputModifierNode
    /* renamed from: onKeyEvent-ZmokQxo */
    public boolean mo362onKeyEventZmokQxo(KeyEvent event) {
        return this.textFieldKeyEventHandler.mo1765onKeyEvent8zsqlwg(event, this.textFieldState, this.textLayoutState, this.textFieldSelectionState, this.clipboardKeyCommandsHandler, requireKeyboardController(), this.enabled && !this.readOnly, this.singleLine, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean onKeyEvent_ZmokQxo$lambda$30;
                onKeyEvent_ZmokQxo$lambda$30 = TextFieldDecoratorModifierNode.onKeyEvent_ZmokQxo$lambda$30(TextFieldDecoratorModifierNode.this);
                return Boolean.valueOf(onKeyEvent_ZmokQxo$lambda$30);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onKeyEvent_ZmokQxo$lambda$30(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        return textFieldDecoratorModifierNode.m1864onImeActionPerformedKlQnJC8(textFieldDecoratorModifierNode.keyboardOptions.m1558getImeActionOrDefaulteUduSuo$foundation_release());
    }

    public void onObservedReadsChanged() {
        updateWindowFocus();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateWindowFocus() {
        ObserverModifierNodeKt.observeReads((Modifier.Node) this, new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda18
            public final Object invoke() {
                Unit updateWindowFocus$lambda$31;
                updateWindowFocus$lambda$31 = TextFieldDecoratorModifierNode.updateWindowFocus$lambda$31(TextFieldDecoratorModifierNode.this);
                return updateWindowFocus$lambda$31;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateWindowFocus$lambda$31(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode) {
        textFieldDecoratorModifierNode.windowInfo = (WindowInfo) CompositionLocalConsumerModifierNodeKt.currentValueOf(textFieldDecoratorModifierNode, CompositionLocalsKt.getLocalWindowInfo());
        textFieldDecoratorModifierNode.onIsFocusedUpdated();
        return Unit.INSTANCE;
    }

    public void onPlaced(LayoutCoordinates coordinates) {
        this.dragAndDropNode.onPlaced(coordinates);
    }

    /* renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void m1866onRemeasuredozmzZPI(long size) {
        this.dragAndDropNode.onRemeasured-ozmzZPI(size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startInputSession(boolean fromTap) {
        if (fromTap || this.keyboardOptions.getShowKeyboardOnFocusOrDefault$foundation_release()) {
            this.inputSessionJob = BuildersKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new TextFieldDecoratorModifierNode$startInputSession$1(this, ReceiveContentConfigurationKt.getReceiveContentConfiguration(this), null), 3, (Object) null);
        }
    }

    private final void disposeInputSession() {
        Job job = this.inputSessionJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.inputSessionJob = null;
        MutableSharedFlow<Unit> mutableSharedFlow = this.stylusHandwritingTrigger;
        if (mutableSharedFlow != null) {
            mutableSharedFlow.resetReplayCache();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SoftwareKeyboardController requireKeyboardController() {
        SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalSoftwareKeyboardController());
        if (softwareKeyboardController != null) {
            return softwareKeyboardController;
        }
        throw new IllegalStateException("No software keyboard controller".toString());
    }

    private final void emitDragExitEvent() {
        HoverInteraction.Enter enter = this.dragEnterEvent;
        if (enter != null) {
            this.interactionSource.tryEmit(new HoverInteraction.Exit(enter));
            this.dragEnterEvent = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onImeActionPerformed-KlQnJC8, reason: not valid java name */
    public final boolean m1864onImeActionPerformedKlQnJC8(final int imeAction) {
        KeyboardActionHandler keyboardActionHandler;
        if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getNone-eUduSuo()) || ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDefault-eUduSuo()) || (keyboardActionHandler = this.keyboardActionHandler) == null) {
            return m1863defaultKeyboardActionWithResultKlQnJC8(imeAction);
        }
        if (keyboardActionHandler == null) {
            return true;
        }
        keyboardActionHandler.onKeyboardAction(new Function0() { // from class: androidx.compose.foundation.text.input.internal.TextFieldDecoratorModifierNode$$ExternalSyntheticLambda5
            public final Object invoke() {
                Unit onImeActionPerformed_KlQnJC8$lambda$33;
                onImeActionPerformed_KlQnJC8$lambda$33 = TextFieldDecoratorModifierNode.onImeActionPerformed_KlQnJC8$lambda$33(TextFieldDecoratorModifierNode.this, imeAction);
                return onImeActionPerformed_KlQnJC8$lambda$33;
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onImeActionPerformed_KlQnJC8$lambda$33(TextFieldDecoratorModifierNode textFieldDecoratorModifierNode, int i) {
        textFieldDecoratorModifierNode.keyboardActionScope.mo1544defaultKeyboardActionKlQnJC8(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: defaultKeyboardActionWithResult-KlQnJC8, reason: not valid java name */
    public final boolean m1863defaultKeyboardActionWithResultKlQnJC8(int imeAction) {
        if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getNext-eUduSuo())) {
            ((FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager())).mo4476moveFocus3ESFkO8(FocusDirection.INSTANCE.m4468getNextdhqQ8s());
            return true;
        }
        if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getPrevious-eUduSuo())) {
            ((FocusManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalFocusManager())).mo4476moveFocus3ESFkO8(FocusDirection.INSTANCE.m4469getPreviousdhqQ8s());
            return true;
        }
        if (!ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDone-eUduSuo())) {
            return false;
        }
        requireKeyboardController().hide();
        return true;
    }
}
