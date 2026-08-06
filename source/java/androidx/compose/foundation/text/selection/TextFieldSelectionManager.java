package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.internal.ClipboardUtils_androidKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.HandleState;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextFieldCursor_androidKt;
import androidx.compose.foundation.text.TextLayoutHelperKt;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.foundation.text.UndoManager;
import androidx.compose.foundation.text.ValidatingOffsetMappingKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuGesturesModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuToolbarHandlerModifierKt;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequester;
import androidx.compose.foundation.text.contextmenu.modifier.ToolbarRequesterImpl;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.focus.FocusRequester;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.hapticfeedback.HapticFeedback;
import androidx.compose.p002ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.Clipboard;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.TextToolbarStatus;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.PasswordVisualTransformation;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u009c\u0001\u001a\u00020\u00112\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010hH\u0002¢\u0006\u0003\b\u009e\u0001J\u0019\u0010\u009f\u0001\u001a\u00030\u0095\u00012\u0007\u0010 \u0001\u001a\u00020XH\u0000¢\u0006\u0003\b¡\u0001J\u0010\u0010¢\u0001\u001a\u00030\u0095\u0001H\u0000¢\u0006\u0003\b£\u0001J\u001a\u0010¤\u0001\u001a\u00020\u00112\t\b\u0002\u0010¥\u0001\u001a\u00020XH\u0000¢\u0006\u0003\b¦\u0001J\u000f\u0010§\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\b¨\u0001J\u001c\u0010©\u0001\u001a\u00020\u00112\u000b\b\u0002\u0010ª\u0001\u001a\u0004\u0018\u00010eH\u0000¢\u0006\u0003\b«\u0001J\u001b\u0010¬\u0001\u001a\u00020\u00112\u0007\u0010\u00ad\u0001\u001a\u00020hH\u0000¢\u0006\u0006\b®\u0001\u0010¯\u0001J\u001b\u0010°\u0001\u001a\u00020\u00112\u0007\u0010\u00ad\u0001\u001a\u00020hH\u0000¢\u0006\u0006\b±\u0001\u0010¯\u0001J\u000f\u0010²\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\b³\u0001J\u000f\u0010½\u0001\u001a\u00020XH\u0000¢\u0006\u0003\b¾\u0001J\u0013\u0010¿\u0001\u001a\u00020\u0011H\u0080@¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J\u0010\u0010Â\u0001\u001a\u00020\u0011H\u0082@¢\u0006\u0003\u0010Á\u0001J\u000f\u0010Ã\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÄ\u0001J\u000f\u0010Å\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÆ\u0001J\u000f\u0010Ç\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÈ\u0001J\u000f\u0010É\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÊ\u0001J\u001d\u0010Ë\u0001\u001a\u0005\u0018\u00010Ì\u00012\t\b\u0002\u0010Í\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÎ\u0001J\u0012\u0010Ï\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0000¢\u0006\u0003\bÐ\u0001J\u0012\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0000¢\u0006\u0003\bÒ\u0001J\u000f\u0010Ó\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bÔ\u0001J\u000f\u0010Õ\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bÖ\u0001J\u001b\u0010×\u0001\u001a\u00020e2\u0007\u0010 \u0001\u001a\u00020XH\u0000¢\u0006\u0006\bØ\u0001\u0010Ù\u0001J\u0019\u0010Ú\u0001\u001a\u00030Û\u00012\u0007\u0010 \u0001\u001a\u00020XH\u0000¢\u0006\u0003\bÜ\u0001J\u001c\u0010Ý\u0001\u001a\u00020e2\b\u0010Þ\u0001\u001a\u00030ß\u0001H\u0000¢\u0006\u0006\bà\u0001\u0010á\u0001J\u0012\u0010â\u0001\u001a\u00020\u00112\u0007\u0010ã\u0001\u001a\u00020XH\u0002J\u000f\u0010ä\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bå\u0001J\f\u0010æ\u0001\u001a\u0005\u0018\u00010Ì\u0001H\u0002J\u000f\u0010ç\u0001\u001a\u00020\u0011H\u0000¢\u0006\u0003\bè\u0001J\u0019\u0010é\u0001\u001a\u00020\u00112\u0007\u0010ª\u0001\u001a\u00020e¢\u0006\u0006\bê\u0001\u0010¯\u0001J\u000f\u0010ë\u0001\u001a\u00020XH\u0000¢\u0006\u0003\bì\u0001J\n\u0010í\u0001\u001a\u00030î\u0001H\u0002JH\u0010ï\u0001\u001a\u00020h2\u0006\u0010\u001e\u001a\u00020\u00102\u0007\u0010ð\u0001\u001a\u00020e2\u0007\u0010ñ\u0001\u001a\u00020X2\u0007\u0010 \u0001\u001a\u00020X2\b\u0010ò\u0001\u001a\u00030ó\u00012\u0007\u0010ô\u0001\u001a\u00020XH\u0002¢\u0006\u0006\bõ\u0001\u0010ö\u0001J\u0013\u0010÷\u0001\u001a\u00020\u00112\b\u0010ø\u0001\u001a\u00030ù\u0001H\u0002J$\u0010ú\u0001\u001a\u00020\u00102\u0007\u0010û\u0001\u001a\u00020$2\u0007\u0010\u009d\u0001\u001a\u00020hH\u0002¢\u0006\u0006\bü\u0001\u0010ý\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00108@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010#\u001a\u0004\u0018\u00010$8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010.X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010K\u001a\u0004\u0018\u00010LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\u001c\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR+\u0010Y\u001a\u00020X2\u0006\u0010W\u001a\u00020X8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R+\u0010`\u001a\u00020X2\u0006\u0010W\u001a\u00020X8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bc\u0010_\u001a\u0004\ba\u0010[\"\u0004\bb\u0010]R\u0010\u0010d\u001a\u00020eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010fR\u0010\u0010g\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u00020eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010fR/\u0010k\u001a\u0004\u0018\u00010j2\b\u0010W\u001a\u0004\u0018\u00010j8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bp\u0010_\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR/\u0010q\u001a\u0004\u0018\u00010e2\b\u0010W\u001a\u0004\u0018\u00010e8F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bv\u0010_\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u000e\u0010w\u001a\u00020xX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010y\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010|\u001a\u0004\u0018\u00010hX\u0080\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R7\u0010\u0082\u0001\u001a\u0005\u0018\u00010\u0081\u00012\t\u0010W\u001a\u0005\u0018\u00010\u0081\u00018B@BX\u0082\u008e\u0002¢\u0006\u0017\n\u0005\b\u0087\u0001\u0010_\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R,\u0010\u0088\u0001\u001a\u00030\u0089\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u001a\n\u0000\u0012\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0015\u0010\u0090\u0001\u001a\u00030\u0091\u00018F¢\u0006\b\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0018\u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001R\u0018\u0010\u0098\u0001\u001a\u00030\u0099\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001d\u0010´\u0001\u001a\u00020XX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bµ\u0001\u0010[\"\u0005\b¶\u0001\u0010]R\u001e\u0010·\u0001\u001a\u00020X8@X\u0080\u0004¢\u0006\u000f\u0012\u0006\b¸\u0001\u0010\u008b\u0001\u001a\u0005\b¹\u0001\u0010[R\u0016\u0010º\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bº\u0001\u0010[R\u0016\u0010»\u0001\u001a\u00020X8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010[¨\u0006þ\u0001"}, d2 = {"Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "", "undoManager", "Landroidx/compose/foundation/text/UndoManager;", "<init>", "(Landroidx/compose/foundation/text/UndoManager;)V", "getUndoManager", "()Landroidx/compose/foundation/text/UndoManager;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "getOffsetMapping$foundation_release", "()Landroidx/compose/ui/text/input/OffsetMapping;", "setOffsetMapping$foundation_release", "(Landroidx/compose/ui/text/input/OffsetMapping;)V", "onValueChange", "Lkotlin/Function1;", "Landroidx/compose/ui/text/input/TextFieldValue;", "", "getOnValueChange$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnValueChange$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "state", "Landroidx/compose/foundation/text/LegacyTextFieldState;", "getState$foundation_release", "()Landroidx/compose/foundation/text/LegacyTextFieldState;", "setState$foundation_release", "(Landroidx/compose/foundation/text/LegacyTextFieldState;)V", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "getValue$foundation_release", "()Landroidx/compose/ui/text/input/TextFieldValue;", "setValue$foundation_release", "(Landroidx/compose/ui/text/input/TextFieldValue;)V", "transformedText", "Landroidx/compose/ui/text/AnnotatedString;", "getTransformedText$foundation_release", "()Landroidx/compose/ui/text/AnnotatedString;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "getVisualTransformation$foundation_release", "()Landroidx/compose/ui/text/input/VisualTransformation;", "setVisualTransformation$foundation_release", "(Landroidx/compose/ui/text/input/VisualTransformation;)V", "requestAutofillAction", "Lkotlin/Function0;", "getRequestAutofillAction$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setRequestAutofillAction$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "clipboard", "Landroidx/compose/ui/platform/Clipboard;", "getClipboard$foundation_release", "()Landroidx/compose/ui/platform/Clipboard;", "setClipboard$foundation_release", "(Landroidx/compose/ui/platform/Clipboard;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope$foundation_release", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope$foundation_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "platformSelectionBehaviors", "Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "getPlatformSelectionBehaviors$foundation_release", "()Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;", "setPlatformSelectionBehaviors$foundation_release", "(Landroidx/compose/foundation/text/selection/PlatformSelectionBehaviors;)V", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "setTextToolbar", "(Landroidx/compose/ui/platform/TextToolbar;)V", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "setHapticFeedBack", "(Landroidx/compose/ui/hapticfeedback/HapticFeedback;)V", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "setFocusRequester", "(Landroidx/compose/ui/focus/FocusRequester;)V", "<set-?>", "", "editable", "getEditable", "()Z", "setEditable", "(Z)V", "editable$delegate", "Landroidx/compose/runtime/MutableState;", "enabled", "getEnabled", "setEnabled", "enabled$delegate", "dragBeginPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "dragBeginSelection", "Landroidx/compose/ui/text/TextRange;", "dragTotalDistance", "Landroidx/compose/foundation/text/Handle;", "draggingHandle", "getDraggingHandle", "()Landroidx/compose/foundation/text/Handle;", "setDraggingHandle", "(Landroidx/compose/foundation/text/Handle;)V", "draggingHandle$delegate", "currentDragPosition", "getCurrentDragPosition-_m7T9-E", "()Landroidx/compose/ui/geometry/Offset;", "setCurrentDragPosition-_kEHs6E", "(Landroidx/compose/ui/geometry/Offset;)V", "currentDragPosition$delegate", "previousRawDragOffset", "", "oldValue", "previousSelectionLayout", "Landroidx/compose/foundation/text/selection/SelectionLayout;", "latestSelection", "getLatestSelection-MzsxiRA$foundation_release", "()Landroidx/compose/ui/text/TextRange;", "setLatestSelection-OEnZFl4$foundation_release", "(Landroidx/compose/ui/text/TextRange;)V", "Landroidx/compose/ui/platform/ClipEntry;", "clipEntry", "getClipEntry", "()Landroidx/compose/ui/platform/ClipEntry;", "setClipEntry", "(Landroidx/compose/ui/platform/ClipEntry;)V", "clipEntry$delegate", "toolbarRequester", "Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "getToolbarRequester$foundation_release$annotations", "()V", "getToolbarRequester$foundation_release", "()Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;", "setToolbarRequester$foundation_release", "(Landroidx/compose/foundation/text/contextmenu/modifier/ToolbarRequester;)V", "contextMenuAreaModifier", "Landroidx/compose/ui/Modifier;", "getContextMenuAreaModifier", "()Landroidx/compose/ui/Modifier;", "touchSelectionObserver", "Landroidx/compose/foundation/text/TextDragObserver;", "getTouchSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/TextDragObserver;", "mouseSelectionObserver", "Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "getMouseSelectionObserver$foundation_release", "()Landroidx/compose/foundation/text/selection/MouseSelectionObserver;", "maybeSuggestSelection", "selection", "maybeSuggestSelection-OEnZFl4", "handleDragObserver", "isStartHandle", "handleDragObserver$foundation_release", "cursorDragObserver", "cursorDragObserver$foundation_release", "enterSelectionMode", "showFloatingToolbar", "enterSelectionMode$foundation_release", "exitSelectionMode", "exitSelectionMode$foundation_release", "deselect", "position", "deselect-_kEHs6E$foundation_release", "setSelectionPreviewHighlight", "range", "setSelectionPreviewHighlight-5zc-tL8$foundation_release", "(J)V", "setDeletionPreviewHighlight", "setDeletionPreviewHighlight-5zc-tL8$foundation_release", "clearPreviewHighlight", "clearPreviewHighlight$foundation_release", "textToolbarShownViaProvider", "getTextToolbarShownViaProvider$foundation_release", "setTextToolbarShownViaProvider$foundation_release", "textToolbarShown", "getTextToolbarShown$foundation_release$annotations", "getTextToolbarShown$foundation_release", "isPassword", "hasSelection", "getHasSelection", "canCopy", "canCopy$foundation_release", "updateClipboardEntry", "updateClipboardEntry$foundation_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyPlatformSelectionBehaviorsOnShowContextMenu", "canPaste", "canPaste$foundation_release", "canCut", "canCut$foundation_release", "canSelectAll", "canSelectAll$foundation_release", "canAutofill", "canAutofill$foundation_release", "copy", "Lkotlinx/coroutines/Job;", "cancelSelection", "copy$foundation_release", "paste", "paste$foundation_release", "cut", "cut$foundation_release", "selectAll", "selectAll$foundation_release", "autofill", "autofill$foundation_release", "getHandlePosition", "getHandlePosition-tuRUvjQ$foundation_release", "(Z)J", "getHandleLineHeight", "", "getHandleLineHeight$foundation_release", "getCursorPosition", "density", "Landroidx/compose/ui/unit/Density;", "getCursorPosition-tuRUvjQ$foundation_release", "(Landroidx/compose/ui/unit/Density;)J", "updateFloatingToolbar", "show", "showSelectionToolbar", "showSelectionToolbar$foundation_release", "showSelectionToolbarViaTextToolbar", "hideSelectionToolbar", "hideSelectionToolbar$foundation_release", "selectWordAtPositionIfNotAlreadySelected", "selectWordAtPositionIfNotAlreadySelected-k-4lQ0M", "isTextChanged", "isTextChanged$foundation_release", "getContentRect", "Landroidx/compose/ui/geometry/Rect;", "updateSelection", "currentPosition", "isStartOfSelection", "adjustment", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "isTouchBasedSelection", "updateSelection-8UEBfa8", "(Landroidx/compose/ui/text/input/TextFieldValue;JZZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)J", "setHandleState", "handleState", "Landroidx/compose/foundation/text/HandleState;", "createTextFieldValue", "annotatedString", "createTextFieldValue-FDrldGo", "(Landroidx/compose/ui/text/AnnotatedString;J)Landroidx/compose/ui/text/input/TextFieldValue;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldSelectionManager {
    public static final int $stable = 8;

    /* renamed from: clipEntry$delegate, reason: from kotlin metadata */
    private final MutableState clipEntry;
    private Clipboard clipboard;
    private CoroutineScope coroutineScope;

    /* renamed from: currentDragPosition$delegate, reason: from kotlin metadata */
    private final MutableState currentDragPosition;
    private long dragBeginPosition;
    private TextRange dragBeginSelection;
    private long dragTotalDistance;

    /* renamed from: draggingHandle$delegate, reason: from kotlin metadata */
    private final MutableState draggingHandle;

    /* renamed from: editable$delegate, reason: from kotlin metadata */
    private final MutableState editable;

    /* renamed from: enabled$delegate, reason: from kotlin metadata */
    private final MutableState enabled;
    private FocusRequester focusRequester;
    private HapticFeedback hapticFeedBack;
    private TextRange latestSelection;
    private final MouseSelectionObserver mouseSelectionObserver;
    private OffsetMapping offsetMapping;
    private TextFieldValue oldValue;
    private Function1<? super TextFieldValue, Unit> onValueChange;
    private PlatformSelectionBehaviors platformSelectionBehaviors;
    private int previousRawDragOffset;
    private SelectionLayout previousSelectionLayout;
    private Function0<Unit> requestAutofillAction;
    private LegacyTextFieldState state;
    private TextToolbar textToolbar;
    private boolean textToolbarShownViaProvider;
    private ToolbarRequester toolbarRequester;
    private final TextDragObserver touchSelectionObserver;
    private final UndoManager undoManager;
    private final MutableState<TextFieldValue> valueState;
    private VisualTransformation visualTransformation;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TextFieldSelectionManager() {
        this(r0, 1, r0);
        UndoManager undoManager = null;
    }

    public static /* synthetic */ void getTextToolbarShown$foundation_release$annotations() {
    }

    public static /* synthetic */ void getToolbarRequester$foundation_release$annotations() {
    }

    public TextFieldSelectionManager(UndoManager undoManager) {
        MutableState<TextFieldValue> mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        this.undoManager = undoManager;
        this.offsetMapping = ValidatingOffsetMappingKt.getValidatingEmptyOffsetMappingIdentity();
        this.onValueChange = new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onValueChange$lambda$0;
                onValueChange$lambda$0 = TextFieldSelectionManager.onValueChange$lambda$0((TextFieldValue) obj);
                return onValueChange$lambda$0;
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null), null, 2, null);
        this.valueState = mutableStateOf$default;
        this.visualTransformation = VisualTransformation.Companion.getNone();
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.editable = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        this.enabled = mutableStateOf$default3;
        this.dragBeginPosition = Offset.INSTANCE.m4609getZeroF1C5BW0();
        this.dragTotalDistance = Offset.INSTANCE.m4609getZeroF1C5BW0();
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.draggingHandle = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.currentDragPosition = mutableStateOf$default5;
        this.previousRawDragOffset = -1;
        this.oldValue = new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null);
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.clipEntry = mutableStateOf$default6;
        this.toolbarRequester = new ToolbarRequesterImpl();
        this.touchSelectionObserver = new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$touchSelectionObserver$1
            private boolean isLongPressSelectionOnly = true;

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1623onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1625onStartk4lQ0M(long startPoint) {
                long m2146updateSelection8UEBfa8;
                long j;
                TextLayoutResultProxy layoutResult;
                TextFieldValue m2142createTextFieldValueFDrldGo;
                TextLayoutResultProxy layoutResult2;
                if (TextFieldSelectionManager.this.getEnabled() && TextFieldSelectionManager.this.getDraggingHandle() == null) {
                    TextFieldSelectionManager.this.setDraggingHandle(Handle.SelectionEnd);
                    TextFieldSelectionManager.this.previousRawDragOffset = -1;
                    this.isLongPressSelectionOnly = true;
                    TextFieldSelectionManager.this.hideSelectionToolbar$foundation_release();
                    LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                    if (!((state == null || (layoutResult2 = state.getLayoutResult()) == null || !layoutResult2.m1665isPositionOnTextk4lQ0M(startPoint)) ? false : true)) {
                        LegacyTextFieldState state2 = TextFieldSelectionManager.this.getState();
                        if (state2 != null && (layoutResult = state2.getLayoutResult()) != null) {
                            TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                            int transformedToOriginal = textFieldSelectionManager.getOffsetMapping().transformedToOriginal(TextLayoutResultProxy.m1663getOffsetForPosition3MmeM6k$default(layoutResult, startPoint, false, 2, null));
                            m2142createTextFieldValueFDrldGo = textFieldSelectionManager.m2142createTextFieldValueFDrldGo(textFieldSelectionManager.getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal));
                            textFieldSelectionManager.enterSelectionMode$foundation_release(false);
                            HapticFeedback hapticFeedBack = textFieldSelectionManager.getHapticFeedBack();
                            if (hapticFeedBack != null) {
                                hapticFeedBack.mo5617performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5634getTextHandleMove5zf0vsI());
                            }
                            textFieldSelectionManager.getOnValueChange$foundation_release().invoke(m2142createTextFieldValueFDrldGo);
                            textFieldSelectionManager.m2154setLatestSelectionOEnZFl4$foundation_release(TextRange.box-impl(m2142createTextFieldValueFDrldGo.getSelection-d9O1mEE()));
                        }
                        this.isLongPressSelectionOnly = false;
                    } else {
                        if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                            return;
                        }
                        TextFieldSelectionManager.this.enterSelectionMode$foundation_release(false);
                        TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                        m2146updateSelection8UEBfa8 = textFieldSelectionManager2.m2146updateSelection8UEBfa8(TextFieldValue.copy-3r_uNRQ$default(textFieldSelectionManager2.getValue$foundation_release(), (AnnotatedString) null, TextRange.Companion.getZero-d9O1mEE(), (TextRange) null, 5, (Object) null), startPoint, true, false, SelectionAdjustment.INSTANCE.getWord(), true);
                        TextFieldSelectionManager.this.dragBeginSelection = TextRange.box-impl(m2146updateSelection8UEBfa8);
                    }
                    TextFieldSelectionManager.this.setHandleState(HandleState.None);
                    TextFieldSelectionManager.this.dragBeginPosition = startPoint;
                    TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                    j = textFieldSelectionManager3.dragBeginPosition;
                    textFieldSelectionManager3.m2145setCurrentDragPosition_kEHs6E(Offset.m4582boximpl(j));
                    TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m4609getZeroF1C5BW0();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x0113  */
            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void mo1624onDragk4lQ0M(long delta) {
                long j;
                TextLayoutResultProxy layoutResult;
                long j2;
                long j3;
                TextRange textRange;
                TextRange textRange2;
                long j4;
                int m1664getOffsetForPosition3MmeM6k;
                TextRange textRange3;
                long m2146updateSelection8UEBfa8;
                TextRange textRange4;
                long j5;
                SelectionAdjustment word;
                if (TextFieldSelectionManager.this.getEnabled()) {
                    if (TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) {
                        return;
                    }
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    j = textFieldSelectionManager.dragTotalDistance;
                    textFieldSelectionManager.dragTotalDistance = Offset.m4598plusMKHz9U(j, delta);
                    LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                    if (state != null && (layoutResult = state.getLayoutResult()) != null) {
                        TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                        j2 = textFieldSelectionManager2.dragBeginPosition;
                        j3 = textFieldSelectionManager2.dragTotalDistance;
                        textFieldSelectionManager2.m2145setCurrentDragPosition_kEHs6E(Offset.m4582boximpl(Offset.m4598plusMKHz9U(j2, j3)));
                        textRange = textFieldSelectionManager2.dragBeginSelection;
                        if (textRange == null) {
                            Offset m2148getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m2148getCurrentDragPosition_m7T9E();
                            Intrinsics.checkNotNull(m2148getCurrentDragPosition_m7T9E);
                            if (!layoutResult.m1665isPositionOnTextk4lQ0M(m2148getCurrentDragPosition_m7T9E.m4603unboximpl())) {
                                OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                                j5 = textFieldSelectionManager2.dragBeginPosition;
                                int transformedToOriginal = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1663getOffsetForPosition3MmeM6k$default(layoutResult, j5, false, 2, null));
                                OffsetMapping offsetMapping2 = textFieldSelectionManager2.getOffsetMapping();
                                Offset m2148getCurrentDragPosition_m7T9E2 = textFieldSelectionManager2.m2148getCurrentDragPosition_m7T9E();
                                Intrinsics.checkNotNull(m2148getCurrentDragPosition_m7T9E2);
                                if (transformedToOriginal == offsetMapping2.transformedToOriginal(TextLayoutResultProxy.m1663getOffsetForPosition3MmeM6k$default(layoutResult, m2148getCurrentDragPosition_m7T9E2.m4603unboximpl(), false, 2, null))) {
                                    word = SelectionAdjustment.INSTANCE.getNone();
                                } else {
                                    word = SelectionAdjustment.INSTANCE.getWord();
                                }
                                SelectionAdjustment selectionAdjustment = word;
                                TextFieldValue value$foundation_release = textFieldSelectionManager2.getValue$foundation_release();
                                Offset m2148getCurrentDragPosition_m7T9E3 = textFieldSelectionManager2.m2148getCurrentDragPosition_m7T9E();
                                Intrinsics.checkNotNull(m2148getCurrentDragPosition_m7T9E3);
                                m2146updateSelection8UEBfa8 = textFieldSelectionManager2.m2146updateSelection8UEBfa8(value$foundation_release, m2148getCurrentDragPosition_m7T9E3.m4603unboximpl(), false, false, selectionAdjustment, true);
                                textRange4 = textFieldSelectionManager2.dragBeginSelection;
                                if (!TextRange.equals-impl(m2146updateSelection8UEBfa8, textRange4)) {
                                    this.isLongPressSelectionOnly = false;
                                }
                            }
                        }
                        textRange2 = textFieldSelectionManager2.dragBeginSelection;
                        if (textRange2 != null) {
                            m1664getOffsetForPosition3MmeM6k = TextRange.getStart-impl(textRange2.unbox-impl());
                        } else {
                            j4 = textFieldSelectionManager2.dragBeginPosition;
                            m1664getOffsetForPosition3MmeM6k = layoutResult.m1664getOffsetForPosition3MmeM6k(j4, false);
                        }
                        Offset m2148getCurrentDragPosition_m7T9E4 = textFieldSelectionManager2.m2148getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m2148getCurrentDragPosition_m7T9E4);
                        int m1664getOffsetForPosition3MmeM6k2 = layoutResult.m1664getOffsetForPosition3MmeM6k(m2148getCurrentDragPosition_m7T9E4.m4603unboximpl(), false);
                        textRange3 = textFieldSelectionManager2.dragBeginSelection;
                        if (textRange3 == null && m1664getOffsetForPosition3MmeM6k == m1664getOffsetForPosition3MmeM6k2) {
                            return;
                        }
                        TextFieldValue value$foundation_release2 = textFieldSelectionManager2.getValue$foundation_release();
                        Offset m2148getCurrentDragPosition_m7T9E5 = textFieldSelectionManager2.m2148getCurrentDragPosition_m7T9E();
                        Intrinsics.checkNotNull(m2148getCurrentDragPosition_m7T9E5);
                        m2146updateSelection8UEBfa8 = textFieldSelectionManager2.m2146updateSelection8UEBfa8(value$foundation_release2, m2148getCurrentDragPosition_m7T9E5.m4603unboximpl(), false, false, SelectionAdjustment.INSTANCE.getWord(), true);
                        textRange4 = textFieldSelectionManager2.dragBeginSelection;
                        if (!TextRange.equals-impl(m2146updateSelection8UEBfa8, textRange4)) {
                        }
                    }
                    TextFieldSelectionManager.this.updateFloatingToolbar(false);
                }
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                onEnd();
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
                onEnd();
            }

            private final void onEnd() {
                TextRange textRange;
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m2145setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
                boolean z = TextRange.getCollapsed-impl(TextFieldSelectionManager.this.getValue$foundation_release().getSelection-d9O1mEE());
                TextFieldSelectionManager.this.setHandleState(z ? HandleState.Cursor : HandleState.Selection);
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state != null) {
                    state.setShowSelectionHandleStart(!z && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, true));
                }
                LegacyTextFieldState state2 = TextFieldSelectionManager.this.getState();
                if (state2 != null) {
                    state2.setShowSelectionHandleEnd(!z && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, false));
                }
                LegacyTextFieldState state3 = TextFieldSelectionManager.this.getState();
                if (state3 != null) {
                    state3.setShowCursorHandle(z && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(TextFieldSelectionManager.this, true));
                }
                if (this.isLongPressSelectionOnly) {
                    TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                    textRange = textFieldSelectionManager.dragBeginSelection;
                    textFieldSelectionManager.m2144maybeSuggestSelectionOEnZFl4(textRange);
                }
                TextFieldSelectionManager.this.dragBeginSelection = null;
            }
        };
        this.mouseSelectionObserver = new MouseSelectionObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$mouseSelectionObserver$1
            private TextRange initialSelection;
            private boolean isDoubleOrTripleClickSelectionOnly = true;

            /* renamed from: isDoubleOrTripleClickSelectionOnly, reason: from getter */
            public final boolean getIsDoubleOrTripleClickSelectionOnly() {
                return this.isDoubleOrTripleClickSelectionOnly;
            }

            public final void setDoubleOrTripleClickSelectionOnly(boolean z) {
                this.isDoubleOrTripleClickSelectionOnly = z;
            }

            public final TextRange getInitialSelection() {
                return this.initialSelection;
            }

            public final void setInitialSelection(TextRange textRange) {
                this.initialSelection = textRange;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtend-k-4lQ0M */
            public boolean mo1964onExtendk4lQ0M(long downPosition) {
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || state.getLayoutResult() == null || !TextFieldSelectionManager.this.getEnabled()) {
                    return false;
                }
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), downPosition, false, SelectionAdjustment.INSTANCE.getNone());
                return true;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onExtendDrag-k-4lQ0M */
            public boolean mo1965onExtendDragk4lQ0M(long dragPosition) {
                LegacyTextFieldState state;
                if (TextFieldSelectionManager.this.getEnabled()) {
                    if (!(TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) && (state = TextFieldSelectionManager.this.getState()) != null && state.getLayoutResult() != null) {
                        updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), dragPosition, false, SelectionAdjustment.INSTANCE.getNone());
                        return true;
                    }
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onStart-9KIMszo */
            public boolean mo1966onStart9KIMszo(long downPosition, SelectionAdjustment adjustment, int clickCount) {
                LegacyTextFieldState state;
                long j;
                if (TextFieldSelectionManager.this.getEnabled()) {
                    if (!(TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) && (state = TextFieldSelectionManager.this.getState()) != null && state.getLayoutResult() != null) {
                        FocusRequester focusRequester = TextFieldSelectionManager.this.getFocusRequester();
                        if (focusRequester != null) {
                            FocusRequester.m4495requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
                        }
                        TextFieldSelectionManager.this.dragBeginPosition = downPosition;
                        TextFieldSelectionManager.this.previousRawDragOffset = -1;
                        TextFieldSelectionManager.enterSelectionMode$foundation_release$default(TextFieldSelectionManager.this, false, 1, null);
                        TextFieldValue value$foundation_release = TextFieldSelectionManager.this.getValue$foundation_release();
                        j = TextFieldSelectionManager.this.dragBeginPosition;
                        long updateMouseSelection = updateMouseSelection(value$foundation_release, j, true, adjustment);
                        if (clickCount >= 2) {
                            this.isDoubleOrTripleClickSelectionOnly = true;
                            this.initialSelection = TextRange.box-impl(updateMouseSelection);
                        }
                        return true;
                    }
                }
                return false;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            /* renamed from: onDrag-3MmeM6k */
            public boolean mo1963onDrag3MmeM6k(long dragPosition, SelectionAdjustment adjustment) {
                LegacyTextFieldState state;
                if (TextFieldSelectionManager.this.getEnabled()) {
                    if (!(TextFieldSelectionManager.this.getValue$foundation_release().getText().length() == 0) && (state = TextFieldSelectionManager.this.getState()) != null && state.getLayoutResult() != null) {
                        updateMouseSelection(TextFieldSelectionManager.this.getValue$foundation_release(), dragPosition, false, adjustment);
                        return true;
                    }
                }
                return false;
            }

            public final long updateMouseSelection(TextFieldValue value, long currentPosition, boolean isStartOfSelection, SelectionAdjustment adjustment) {
                long m2146updateSelection8UEBfa8;
                m2146updateSelection8UEBfa8 = TextFieldSelectionManager.this.m2146updateSelection8UEBfa8(value, currentPosition, isStartOfSelection, false, adjustment, false);
                if (!TextRange.equals-impl(m2146updateSelection8UEBfa8, this.initialSelection)) {
                    this.isDoubleOrTripleClickSelectionOnly = false;
                }
                TextFieldSelectionManager.this.setHandleState(TextRange.getCollapsed-impl(m2146updateSelection8UEBfa8) ? HandleState.Cursor : HandleState.Selection);
                return m2146updateSelection8UEBfa8;
            }

            @Override // androidx.compose.foundation.text.selection.MouseSelectionObserver
            public void onDragDone() {
                if (this.isDoubleOrTripleClickSelectionOnly) {
                    TextFieldSelectionManager.this.m2144maybeSuggestSelectionOEnZFl4(this.initialSelection);
                }
            }
        };
    }

    public /* synthetic */ TextFieldSelectionManager(UndoManager undoManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : undoManager);
    }

    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    /* renamed from: getOffsetMapping$foundation_release, reason: from getter */
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    public final void setOffsetMapping$foundation_release(OffsetMapping offsetMapping) {
        this.offsetMapping = offsetMapping;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onValueChange$lambda$0(TextFieldValue textFieldValue) {
        return Unit.INSTANCE;
    }

    public final Function1<TextFieldValue, Unit> getOnValueChange$foundation_release() {
        return this.onValueChange;
    }

    public final void setOnValueChange$foundation_release(Function1<? super TextFieldValue, Unit> function1) {
        this.onValueChange = function1;
    }

    /* renamed from: getState$foundation_release, reason: from getter */
    public final LegacyTextFieldState getState() {
        return this.state;
    }

    public final void setState$foundation_release(LegacyTextFieldState legacyTextFieldState) {
        this.state = legacyTextFieldState;
    }

    public final TextFieldValue getValue$foundation_release() {
        return this.valueState.getValue();
    }

    public final void setValue$foundation_release(TextFieldValue textFieldValue) {
        this.valueState.setValue(textFieldValue);
        this.latestSelection = TextRange.box-impl(textFieldValue.getSelection-d9O1mEE());
    }

    public final AnnotatedString getTransformedText$foundation_release() {
        TextDelegate textDelegate;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (textDelegate = legacyTextFieldState.getTextDelegate()) == null) {
            return null;
        }
        return textDelegate.getText();
    }

    /* renamed from: getVisualTransformation$foundation_release, reason: from getter */
    public final VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public final void setVisualTransformation$foundation_release(VisualTransformation visualTransformation) {
        this.visualTransformation = visualTransformation;
    }

    public final Function0<Unit> getRequestAutofillAction$foundation_release() {
        return this.requestAutofillAction;
    }

    public final void setRequestAutofillAction$foundation_release(Function0<Unit> function0) {
        this.requestAutofillAction = function0;
    }

    /* renamed from: getClipboard$foundation_release, reason: from getter */
    public final Clipboard getClipboard() {
        return this.clipboard;
    }

    public final void setClipboard$foundation_release(Clipboard clipboard) {
        this.clipboard = clipboard;
    }

    /* renamed from: getCoroutineScope$foundation_release, reason: from getter */
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope$foundation_release(CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
    }

    /* renamed from: getPlatformSelectionBehaviors$foundation_release, reason: from getter */
    public final PlatformSelectionBehaviors getPlatformSelectionBehaviors() {
        return this.platformSelectionBehaviors;
    }

    public final void setPlatformSelectionBehaviors$foundation_release(PlatformSelectionBehaviors platformSelectionBehaviors) {
        this.platformSelectionBehaviors = platformSelectionBehaviors;
    }

    public final TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    public final void setTextToolbar(TextToolbar textToolbar) {
        this.textToolbar = textToolbar;
    }

    public final HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public final void setHapticFeedBack(HapticFeedback hapticFeedback) {
        this.hapticFeedBack = hapticFeedback;
    }

    public final FocusRequester getFocusRequester() {
        return this.focusRequester;
    }

    public final void setFocusRequester(FocusRequester focusRequester) {
        this.focusRequester = focusRequester;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEditable() {
        return ((Boolean) this.editable.getValue()).booleanValue();
    }

    public final void setEditable(boolean z) {
        this.editable.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEnabled() {
        return ((Boolean) this.enabled.getValue()).booleanValue();
    }

    public final void setEnabled(boolean z) {
        this.enabled.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDraggingHandle(Handle handle) {
        this.draggingHandle.setValue(handle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Handle getDraggingHandle() {
        return (Handle) this.draggingHandle.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCurrentDragPosition-_kEHs6E, reason: not valid java name */
    public final void m2145setCurrentDragPosition_kEHs6E(Offset offset) {
        this.currentDragPosition.setValue(offset);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getCurrentDragPosition-_m7T9-E, reason: not valid java name */
    public final Offset m2148getCurrentDragPosition_m7T9E() {
        return (Offset) this.currentDragPosition.getValue();
    }

    /* renamed from: getLatestSelection-MzsxiRA$foundation_release, reason: not valid java name and from getter */
    public final TextRange getLatestSelection() {
        return this.latestSelection;
    }

    /* renamed from: setLatestSelection-OEnZFl4$foundation_release, reason: not valid java name */
    public final void m2154setLatestSelectionOEnZFl4$foundation_release(TextRange textRange) {
        this.latestSelection = textRange;
    }

    private final ClipEntry getClipEntry() {
        return (ClipEntry) this.clipEntry.getValue();
    }

    private final void setClipEntry(ClipEntry clipEntry) {
        this.clipEntry.setValue(clipEntry);
    }

    /* renamed from: getToolbarRequester$foundation_release, reason: from getter */
    public final ToolbarRequester getToolbarRequester() {
        return this.toolbarRequester;
    }

    public final void setToolbarRequester$foundation_release(ToolbarRequester toolbarRequester) {
        this.toolbarRequester = toolbarRequester;
    }

    public final Modifier getContextMenuAreaModifier() {
        return !getEnabled() ? Modifier.INSTANCE : TextContextMenuToolbarHandlerModifierKt.textContextMenuToolbarHandler(TextContextMenuGesturesModifierKt.textContextMenuGestures(Modifier.INSTANCE, new TextFieldSelectionManager$contextMenuAreaModifier$1(this, null)), this.toolbarRequester, new TextFieldSelectionManager$contextMenuAreaModifier$2(this, null), new TextFieldSelectionManager$contextMenuAreaModifier$3(this, null), new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Rect _get_contextMenuAreaModifier_$lambda$1;
                _get_contextMenuAreaModifier_$lambda$1 = TextFieldSelectionManager._get_contextMenuAreaModifier_$lambda$1(TextFieldSelectionManager.this, (LayoutCoordinates) obj);
                return _get_contextMenuAreaModifier_$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect _get_contextMenuAreaModifier_$lambda$1(TextFieldSelectionManager textFieldSelectionManager, LayoutCoordinates layoutCoordinates) {
        Rect contentRect = textFieldSelectionManager.getContentRect();
        LegacyTextFieldState legacyTextFieldState = textFieldSelectionManager.state;
        LayoutCoordinates layoutCoordinates2 = legacyTextFieldState != null ? legacyTextFieldState.getLayoutCoordinates() : null;
        if (layoutCoordinates2 != null) {
            return TextContextMenuToolbarHandlerModifierKt.translateRootToDestination(contentRect, layoutCoordinates2, layoutCoordinates);
        }
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Required value was null.");
        throw new KotlinNothingValueException();
    }

    /* renamed from: getTouchSelectionObserver$foundation_release, reason: from getter */
    public final TextDragObserver getTouchSelectionObserver() {
        return this.touchSelectionObserver;
    }

    /* renamed from: getMouseSelectionObserver$foundation_release, reason: from getter */
    public final MouseSelectionObserver getMouseSelectionObserver() {
        return this.mouseSelectionObserver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: maybeSuggestSelection-OEnZFl4, reason: not valid java name */
    public final void m2144maybeSuggestSelectionOEnZFl4(TextRange selection) {
        PlatformSelectionBehaviors platformSelectionBehaviors;
        AnnotatedString transformedText$foundation_release;
        String text;
        CoroutineScope coroutineScope;
        if (selection == null || (platformSelectionBehaviors = this.platformSelectionBehaviors) == null || (transformedText$foundation_release = getTransformedText$foundation_release()) == null || (text = transformedText$foundation_release.getText()) == null) {
            return;
        }
        OffsetMapping offsetMapping = this.offsetMapping;
        long TextRange = TextRangeKt.TextRange(offsetMapping.originalToTransformed(TextRange.getStart-impl(selection.unbox-impl())), offsetMapping.originalToTransformed(TextRange.getEnd-impl(selection.unbox-impl())));
        if (!(text.length() > 0) || TextRange.getCollapsed-impl(TextRange) || (coroutineScope = this.coroutineScope) == null) {
            return;
        }
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new TextFieldSelectionManager$maybeSuggestSelection$1(platformSelectionBehaviors, text, TextRange, selection, this, offsetMapping, null), 3, (Object) null);
    }

    public final TextDragObserver handleDragObserver$foundation_release(final boolean isStartHandle) {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$handleDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1625onStartk4lQ0M(long startPoint) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1623onDownk4lQ0M(long point) {
                TextLayoutResultProxy layoutResult;
                TextFieldSelectionManager.this.setDraggingHandle(isStartHandle ? Handle.SelectionStart : Handle.SelectionEnd);
                long m2081getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m2081getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m2150getHandlePositiontuRUvjQ$foundation_release(isStartHandle));
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long m1667translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m1667translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m2081getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m1667translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m2145setCurrentDragPosition_kEHs6E(Offset.m4582boximpl(m1667translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m4609getZeroF1C5BW0();
                TextFieldSelectionManager.this.previousRawDragOffset = -1;
                LegacyTextFieldState state2 = TextFieldSelectionManager.this.getState();
                if (state2 != null) {
                    state2.setInTouchMode(true);
                }
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m2145setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1624onDragk4lQ0M(long delta) {
                long j;
                long j2;
                long j3;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m4598plusMKHz9U(j, delta);
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager2.dragBeginPosition;
                j3 = TextFieldSelectionManager.this.dragTotalDistance;
                textFieldSelectionManager2.m2145setCurrentDragPosition_kEHs6E(Offset.m4582boximpl(Offset.m4598plusMKHz9U(j2, j3)));
                TextFieldSelectionManager textFieldSelectionManager3 = TextFieldSelectionManager.this;
                TextFieldValue value$foundation_release = textFieldSelectionManager3.getValue$foundation_release();
                Offset m2148getCurrentDragPosition_m7T9E = TextFieldSelectionManager.this.m2148getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m2148getCurrentDragPosition_m7T9E);
                textFieldSelectionManager3.m2146updateSelection8UEBfa8(value$foundation_release, m2148getCurrentDragPosition_m7T9E.m4603unboximpl(), false, isStartHandle, SelectionAdjustment.INSTANCE.getCharacterWithWordAccelerate(), true);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m2145setCurrentDragPosition_kEHs6E(null);
                TextFieldSelectionManager.this.updateFloatingToolbar(true);
            }
        };
    }

    public final TextDragObserver cursorDragObserver$foundation_release() {
        return new TextDragObserver() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager$cursorDragObserver$1
            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onCancel() {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDown-k-4lQ0M */
            public void mo1623onDownk4lQ0M(long point) {
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onUp() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m2145setCurrentDragPosition_kEHs6E(null);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onStart-k-4lQ0M */
            public void mo1625onStartk4lQ0M(long startPoint) {
                TextLayoutResultProxy layoutResult;
                long m2081getAdjustedCoordinatesk4lQ0M = SelectionHandlesKt.m2081getAdjustedCoordinatesk4lQ0M(TextFieldSelectionManager.this.m2150getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                long m1667translateInnerToDecorationCoordinatesMKHz9U$foundation_release = layoutResult.m1667translateInnerToDecorationCoordinatesMKHz9U$foundation_release(m2081getAdjustedCoordinatesk4lQ0M);
                TextFieldSelectionManager.this.dragBeginPosition = m1667translateInnerToDecorationCoordinatesMKHz9U$foundation_release;
                TextFieldSelectionManager.this.m2145setCurrentDragPosition_kEHs6E(Offset.m4582boximpl(m1667translateInnerToDecorationCoordinatesMKHz9U$foundation_release));
                TextFieldSelectionManager.this.dragTotalDistance = Offset.INSTANCE.m4609getZeroF1C5BW0();
                TextFieldSelectionManager.this.setDraggingHandle(Handle.Cursor);
                TextFieldSelectionManager.this.updateFloatingToolbar(false);
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            /* renamed from: onDrag-k-4lQ0M */
            public void mo1624onDragk4lQ0M(long delta) {
                long j;
                TextLayoutResultProxy layoutResult;
                long j2;
                long j3;
                TextFieldValue m2142createTextFieldValueFDrldGo;
                HapticFeedback hapticFeedBack;
                TextFieldSelectionManager textFieldSelectionManager = TextFieldSelectionManager.this;
                j = textFieldSelectionManager.dragTotalDistance;
                textFieldSelectionManager.dragTotalDistance = Offset.m4598plusMKHz9U(j, delta);
                LegacyTextFieldState state = TextFieldSelectionManager.this.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return;
                }
                TextFieldSelectionManager textFieldSelectionManager2 = TextFieldSelectionManager.this;
                j2 = textFieldSelectionManager2.dragBeginPosition;
                j3 = textFieldSelectionManager2.dragTotalDistance;
                textFieldSelectionManager2.m2145setCurrentDragPosition_kEHs6E(Offset.m4582boximpl(Offset.m4598plusMKHz9U(j2, j3)));
                OffsetMapping offsetMapping = textFieldSelectionManager2.getOffsetMapping();
                Offset m2148getCurrentDragPosition_m7T9E = textFieldSelectionManager2.m2148getCurrentDragPosition_m7T9E();
                Intrinsics.checkNotNull(m2148getCurrentDragPosition_m7T9E);
                int transformedToOriginal = offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1663getOffsetForPosition3MmeM6k$default(layoutResult, m2148getCurrentDragPosition_m7T9E.m4603unboximpl(), false, 2, null));
                long TextRange = TextRangeKt.TextRange(transformedToOriginal, transformedToOriginal);
                if (TextRange.equals-impl0(TextRange, textFieldSelectionManager2.getValue$foundation_release().getSelection-d9O1mEE())) {
                    return;
                }
                LegacyTextFieldState state2 = textFieldSelectionManager2.getState();
                boolean z = false;
                if (state2 != null && !state2.isInTouchMode()) {
                    z = true;
                }
                if (!z && (hapticFeedBack = textFieldSelectionManager2.getHapticFeedBack()) != null) {
                    hapticFeedBack.mo5617performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5634getTextHandleMove5zf0vsI());
                }
                Function1<TextFieldValue, Unit> onValueChange$foundation_release = textFieldSelectionManager2.getOnValueChange$foundation_release();
                m2142createTextFieldValueFDrldGo = textFieldSelectionManager2.m2142createTextFieldValueFDrldGo(textFieldSelectionManager2.getValue$foundation_release().getAnnotatedString(), TextRange);
                onValueChange$foundation_release.invoke(m2142createTextFieldValueFDrldGo);
                textFieldSelectionManager2.m2154setLatestSelectionOEnZFl4$foundation_release(TextRange.box-impl(TextRange));
            }

            @Override // androidx.compose.foundation.text.TextDragObserver
            public void onStop() {
                TextFieldSelectionManager.this.setDraggingHandle(null);
                TextFieldSelectionManager.this.m2145setCurrentDragPosition_kEHs6E(null);
            }
        };
    }

    public static /* synthetic */ void enterSelectionMode$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        textFieldSelectionManager.enterSelectionMode$foundation_release(z);
    }

    public final void enterSelectionMode$foundation_release(boolean showFloatingToolbar) {
        FocusRequester focusRequester;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (((legacyTextFieldState == null || legacyTextFieldState.getHasFocus()) ? false : true) && (focusRequester = this.focusRequester) != null) {
            FocusRequester.m4495requestFocus3ESFkO8$default(focusRequester, 0, 1, null);
        }
        this.oldValue = getValue$foundation_release();
        updateFloatingToolbar(showFloatingToolbar);
        setHandleState(HandleState.Selection);
    }

    public final void exitSelectionMode$foundation_release() {
        updateFloatingToolbar(false);
        setHandleState(HandleState.None);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release$default, reason: not valid java name */
    public static /* synthetic */ void m2143deselect_kEHs6E$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, Offset offset, int i, Object obj) {
        if ((i & 1) != 0) {
            offset = null;
        }
        textFieldSelectionManager.m2147deselect_kEHs6E$foundation_release(offset);
    }

    /* renamed from: deselect-_kEHs6E$foundation_release, reason: not valid java name */
    public final void m2147deselect_kEHs6E$foundation_release(Offset position) {
        HandleState handleState;
        int i;
        if (!TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE())) {
            LegacyTextFieldState legacyTextFieldState = this.state;
            TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
            if (position != null && layoutResult != null) {
                i = this.offsetMapping.transformedToOriginal(TextLayoutResultProxy.m1663getOffsetForPosition3MmeM6k$default(layoutResult, position.m4603unboximpl(), false, 2, null));
            } else {
                i = TextRange.getMax-impl(getValue$foundation_release().getSelection-d9O1mEE());
            }
            TextFieldValue textFieldValue = TextFieldValue.copy-3r_uNRQ$default(getValue$foundation_release(), (AnnotatedString) null, TextRangeKt.TextRange(i), (TextRange) null, 5, (Object) null);
            this.onValueChange.invoke(textFieldValue);
            this.latestSelection = TextRange.box-impl(textFieldValue.getSelection-d9O1mEE());
        }
        if (position != null) {
            if (getValue$foundation_release().getText().length() > 0) {
                handleState = HandleState.Cursor;
                setHandleState(handleState);
                updateFloatingToolbar(false);
            }
        }
        handleState = HandleState.None;
        setHandleState(handleState);
        updateFloatingToolbar(false);
    }

    /* renamed from: setSelectionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m2155setSelectionPreviewHighlight5zctL8$foundation_release(long range) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1567setSelectionPreviewHighlightRange5zctL8(range);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1564setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.getZero-d9O1mEE());
        }
        if (TextRange.getCollapsed-impl(range)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    /* renamed from: setDeletionPreviewHighlight-5zc-tL8$foundation_release, reason: not valid java name */
    public final void m2153setDeletionPreviewHighlight5zctL8$foundation_release(long range) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1564setDeletionPreviewHighlightRange5zctL8(range);
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1567setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.getZero-d9O1mEE());
        }
        if (TextRange.getCollapsed-impl(range)) {
            return;
        }
        exitSelectionMode$foundation_release();
    }

    public final void clearPreviewHighlight$foundation_release() {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.m1564setDeletionPreviewHighlightRange5zctL8(TextRange.Companion.getZero-d9O1mEE());
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.m1567setSelectionPreviewHighlightRange5zctL8(TextRange.Companion.getZero-d9O1mEE());
        }
    }

    /* renamed from: getTextToolbarShownViaProvider$foundation_release, reason: from getter */
    public final boolean getTextToolbarShownViaProvider() {
        return this.textToolbarShownViaProvider;
    }

    public final void setTextToolbarShownViaProvider$foundation_release(boolean z) {
        this.textToolbarShownViaProvider = z;
    }

    public final boolean getTextToolbarShown$foundation_release() {
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            return this.textToolbarShownViaProvider;
        }
        TextToolbar textToolbar = this.textToolbar;
        return (textToolbar != null ? textToolbar.getStatus() : null) == TextToolbarStatus.Shown;
    }

    private final boolean isPassword() {
        return this.visualTransformation instanceof PasswordVisualTransformation;
    }

    private final boolean getHasSelection() {
        return !TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE());
    }

    public final boolean canCopy$foundation_release() {
        return getHasSelection() && !isPassword();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateClipboardEntry$foundation_release(Continuation<? super Unit> continuation) {
        TextFieldSelectionManager$updateClipboardEntry$1 textFieldSelectionManager$updateClipboardEntry$1;
        int i;
        ClipEntry clipEntry;
        TextFieldSelectionManager textFieldSelectionManager;
        if (continuation instanceof TextFieldSelectionManager$updateClipboardEntry$1) {
            textFieldSelectionManager$updateClipboardEntry$1 = (TextFieldSelectionManager$updateClipboardEntry$1) continuation;
            if ((textFieldSelectionManager$updateClipboardEntry$1.label & Integer.MIN_VALUE) != 0) {
                textFieldSelectionManager$updateClipboardEntry$1.label -= Integer.MIN_VALUE;
                Object obj = textFieldSelectionManager$updateClipboardEntry$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = textFieldSelectionManager$updateClipboardEntry$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Clipboard clipboard = this.clipboard;
                    if (clipboard == null) {
                        clipEntry = null;
                        textFieldSelectionManager = this;
                        textFieldSelectionManager.setClipEntry(clipEntry);
                        return Unit.INSTANCE;
                    }
                    textFieldSelectionManager$updateClipboardEntry$1.L$0 = this;
                    textFieldSelectionManager$updateClipboardEntry$1.label = 1;
                    obj = clipboard.getClipEntry(textFieldSelectionManager$updateClipboardEntry$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    textFieldSelectionManager = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    textFieldSelectionManager = (TextFieldSelectionManager) textFieldSelectionManager$updateClipboardEntry$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                clipEntry = (ClipEntry) obj;
                textFieldSelectionManager.setClipEntry(clipEntry);
                return Unit.INSTANCE;
            }
        }
        textFieldSelectionManager$updateClipboardEntry$1 = new TextFieldSelectionManager$updateClipboardEntry$1(this, continuation);
        Object obj2 = textFieldSelectionManager$updateClipboardEntry$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = textFieldSelectionManager$updateClipboardEntry$1.label;
        if (i != 0) {
        }
        clipEntry = (ClipEntry) obj2;
        textFieldSelectionManager.setClipEntry(clipEntry);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object notifyPlatformSelectionBehaviorsOnShowContextMenu(Continuation<? super Unit> continuation) {
        C0536xe731fd58 c0536xe731fd58;
        int i;
        String text;
        TextRange textRange;
        if (continuation instanceof C0536xe731fd58) {
            c0536xe731fd58 = (C0536xe731fd58) continuation;
            if ((c0536xe731fd58.label & Integer.MIN_VALUE) != 0) {
                c0536xe731fd58.label -= Integer.MIN_VALUE;
                Object obj = c0536xe731fd58.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = c0536xe731fd58.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
                    if (transformedText$foundation_release != null && (text = transformedText$foundation_release.getText()) != null && (textRange = this.latestSelection) != null) {
                        long j = textRange.unbox-impl();
                        PlatformSelectionBehaviors platformSelectionBehaviors = this.platformSelectionBehaviors;
                        if (platformSelectionBehaviors != null) {
                            long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.getStart-impl(j)), this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(j)));
                            c0536xe731fd58.label = 1;
                            if (platformSelectionBehaviors.mo2060onShowContextMenuSbBc2M(text, TextRange, c0536xe731fd58) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
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
        c0536xe731fd58 = new C0536xe731fd58(this, continuation);
        Object obj2 = c0536xe731fd58.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = c0536xe731fd58.label;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }

    public final boolean canPaste$foundation_release() {
        if (!getEditable()) {
            return false;
        }
        ClipEntry clipEntry = getClipEntry();
        return clipEntry != null && ClipboardUtils_androidKt.hasText(clipEntry);
    }

    public final boolean canCut$foundation_release() {
        return getHasSelection() && getEditable() && !isPassword();
    }

    public final boolean canSelectAll$foundation_release() {
        return TextRange.getLength-impl(getValue$foundation_release().getSelection-d9O1mEE()) != getValue$foundation_release().getText().length();
    }

    public final boolean canAutofill$foundation_release() {
        return getEditable() && TextRange.getCollapsed-impl(getValue$foundation_release().getSelection-d9O1mEE());
    }

    public static /* synthetic */ Job copy$foundation_release$default(TextFieldSelectionManager textFieldSelectionManager, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return textFieldSelectionManager.copy$foundation_release(z);
    }

    public final Job copy$foundation_release(boolean cancelSelection) {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$copy$1(this, cancelSelection, null), 1, (Object) null);
        }
        return null;
    }

    public final Job paste$foundation_release() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$paste$1(this, null), 1, (Object) null);
        }
        return null;
    }

    public final Job cut$foundation_release() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$cut$1(this, null), 1, (Object) null);
        }
        return null;
    }

    public final void selectAll$foundation_release() {
        TextFieldValue m2142createTextFieldValueFDrldGo = m2142createTextFieldValueFDrldGo(getValue$foundation_release().getAnnotatedString(), TextRangeKt.TextRange(0, getValue$foundation_release().getText().length()));
        this.onValueChange.invoke(m2142createTextFieldValueFDrldGo);
        this.latestSelection = TextRange.box-impl(m2142createTextFieldValueFDrldGo.getSelection-d9O1mEE());
        this.oldValue = TextFieldValue.copy-3r_uNRQ$default(this.oldValue, (AnnotatedString) null, m2142createTextFieldValueFDrldGo.getSelection-d9O1mEE(), (TextRange) null, 5, (Object) null);
        enterSelectionMode$foundation_release(true);
    }

    public final void autofill$foundation_release() {
        Function0<Unit> function0 = this.requestAutofillAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: getHandlePosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m2150getHandlePositiontuRUvjQ$foundation_release(boolean isStartHandle) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
        }
        AnnotatedString transformedText$foundation_release = getTransformedText$foundation_release();
        if (transformedText$foundation_release == null) {
            return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
        }
        if (!Intrinsics.areEqual(transformedText$foundation_release.getText(), value.getLayoutInput().getText().getText())) {
            return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
        }
        long j = getValue$foundation_release().getSelection-d9O1mEE();
        return TextSelectionDelegateKt.getSelectionHandleCoordinates(value, this.offsetMapping.originalToTransformed(isStartHandle ? TextRange.getStart-impl(j) : TextRange.getEnd-impl(j)), isStartHandle, TextRange.getReversed-impl(getValue$foundation_release().getSelection-d9O1mEE()));
    }

    public final float getHandleLineHeight$foundation_release(boolean isStartHandle) {
        TextLayoutResultProxy layoutResult;
        TextLayoutResult value;
        int i = isStartHandle ? TextRange.getStart-impl(getValue$foundation_release().getSelection-d9O1mEE()) : TextRange.getEnd-impl(getValue$foundation_release().getSelection-d9O1mEE());
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || (value = layoutResult.getValue()) == null) {
            return 0.0f;
        }
        return TextLayoutHelperKt.getLineHeight(value, i);
    }

    /* renamed from: getCursorPosition-tuRUvjQ$foundation_release, reason: not valid java name */
    public final long m2149getCursorPositiontuRUvjQ$foundation_release(Density density) {
        int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.getStart-impl(getValue$foundation_release().getSelection-d9O1mEE()));
        LegacyTextFieldState legacyTextFieldState = this.state;
        TextLayoutResultProxy layoutResult = legacyTextFieldState != null ? legacyTextFieldState.getLayoutResult() : null;
        Intrinsics.checkNotNull(layoutResult);
        TextLayoutResult value = layoutResult.getValue();
        Rect cursorRect = value.getCursorRect(RangesKt.coerceIn(originalToTransformed, 0, value.getLayoutInput().getText().length()));
        return Offset.m4585constructorimpl((Float.floatToRawIntBits(cursorRect.getLeft() + (density.toPx-0680j_4(TextFieldCursor_androidKt.getDefaultCursorThickness()) / 2)) << 32) | (Float.floatToRawIntBits(cursorRect.getBottom()) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFloatingToolbar(boolean show) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            legacyTextFieldState.setShowFloatingToolbar(show);
        }
        if (show) {
            showSelectionToolbar$foundation_release();
        } else {
            hideSelectionToolbar$foundation_release();
        }
    }

    public final void showSelectionToolbar$foundation_release() {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            if (getEnabled()) {
                LegacyTextFieldState legacyTextFieldState = this.state;
                boolean z = false;
                if (legacyTextFieldState != null && !legacyTextFieldState.isInTouchMode()) {
                    z = true;
                }
                if (!z) {
                    Unit unit = Unit.INSTANCE;
                    companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                    if (ComposeFoundationFlags.isNewContextMenuEnabled) {
                        this.toolbarRequester.show();
                    } else {
                        showSelectionToolbarViaTextToolbar();
                    }
                }
            }
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
        }
    }

    private final Job showSelectionToolbarViaTextToolbar() {
        CoroutineScope coroutineScope = this.coroutineScope;
        if (coroutineScope != null) {
            return BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new TextFieldSelectionManager$showSelectionToolbarViaTextToolbar$1(this, null), 1, (Object) null);
        }
        return null;
    }

    public final void hideSelectionToolbar$foundation_release() {
        TextToolbar textToolbar;
        if (ComposeFoundationFlags.isNewContextMenuEnabled) {
            this.toolbarRequester.hide();
            return;
        }
        TextToolbar textToolbar2 = this.textToolbar;
        if ((textToolbar2 != null ? textToolbar2.getStatus() : null) != TextToolbarStatus.Shown || (textToolbar = this.textToolbar) == null) {
            return;
        }
        textToolbar.hide();
    }

    /* renamed from: selectWordAtPositionIfNotAlreadySelected-k-4lQ0M, reason: not valid java name */
    public final void m2152selectWordAtPositionIfNotAlreadySelectedk4lQ0M(long position) {
        TextLayoutResultProxy layoutResult;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null || TextLayoutHelperKt.m1661isPositionInsideSelectionuaM50fQ(layoutResult.getValue(), layoutResult.m1666translateDecorationToInnerCoordinatesMKHz9U$foundation_release(position), TextRange.box-impl(getValue$foundation_release().getSelection-d9O1mEE()))) {
            return;
        }
        m2146updateSelection8UEBfa8(getValue$foundation_release(), position, true, false, SelectionAdjustment.INSTANCE.getWord(), false);
    }

    public final boolean isTextChanged$foundation_release() {
        return !Intrinsics.areEqual(this.oldValue.getText(), getValue$foundation_release().getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect getContentRect() {
        long j;
        float f;
        LayoutCoordinates layoutCoordinates;
        TextLayoutResult value;
        Rect cursorRect;
        LayoutCoordinates layoutCoordinates2;
        TextLayoutResult value2;
        Rect cursorRect2;
        LayoutCoordinates layoutCoordinates3;
        LayoutCoordinates layoutCoordinates4;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (!(!legacyTextFieldState.getIsLayoutResultStale())) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                int originalToTransformed = this.offsetMapping.originalToTransformed(TextRange.getStart-impl(getValue$foundation_release().getSelection-d9O1mEE()));
                int originalToTransformed2 = this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(getValue$foundation_release().getSelection-d9O1mEE()));
                LegacyTextFieldState legacyTextFieldState2 = this.state;
                long m4609getZeroF1C5BW0 = (legacyTextFieldState2 == null || (layoutCoordinates4 = legacyTextFieldState2.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m4609getZeroF1C5BW0() : layoutCoordinates4.mo6342localToRootMKHz9U(m2150getHandlePositiontuRUvjQ$foundation_release(true));
                LegacyTextFieldState legacyTextFieldState3 = this.state;
                long m4609getZeroF1C5BW02 = (legacyTextFieldState3 == null || (layoutCoordinates3 = legacyTextFieldState3.getLayoutCoordinates()) == null) ? Offset.INSTANCE.m4609getZeroF1C5BW0() : layoutCoordinates3.mo6342localToRootMKHz9U(m2150getHandlePositiontuRUvjQ$foundation_release(false));
                LegacyTextFieldState legacyTextFieldState4 = this.state;
                float f2 = 0.0f;
                if (legacyTextFieldState4 == null || (layoutCoordinates2 = legacyTextFieldState4.getLayoutCoordinates()) == null) {
                    j = m4609getZeroF1C5BW02;
                    f = 0.0f;
                } else {
                    TextLayoutResultProxy layoutResult = legacyTextFieldState.getLayoutResult();
                    j = m4609getZeroF1C5BW02;
                    f = Float.intBitsToFloat((int) (layoutCoordinates2.mo6342localToRootMKHz9U(Offset.m4585constructorimpl((Float.floatToRawIntBits((layoutResult == null || (value2 = layoutResult.getValue()) == null || (cursorRect2 = value2.getCursorRect(originalToTransformed)) == null) ? 0.0f : cursorRect2.getTop()) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32))) & 4294967295L));
                }
                LegacyTextFieldState legacyTextFieldState5 = this.state;
                if (legacyTextFieldState5 != null && (layoutCoordinates = legacyTextFieldState5.getLayoutCoordinates()) != null) {
                    TextLayoutResultProxy layoutResult2 = legacyTextFieldState.getLayoutResult();
                    f2 = Float.intBitsToFloat((int) (layoutCoordinates.mo6342localToRootMKHz9U(Offset.m4585constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits((layoutResult2 == null || (value = layoutResult2.getValue()) == null || (cursorRect = value.getCursorRect(originalToTransformed2)) == null) ? 0.0f : cursorRect.getTop()) & 4294967295L))) & 4294967295L));
                }
                int i = (int) (m4609getZeroF1C5BW0 >> 32);
                int i2 = (int) (j >> 32);
                return new Rect(Math.min(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.min(f, f2), Math.max(Float.intBitsToFloat(i), Float.intBitsToFloat(i2)), Math.max(Float.intBitsToFloat((int) (m4609getZeroF1C5BW0 & 4294967295L)), Float.intBitsToFloat((int) (j & 4294967295L))) + (Dp.constructor-impl(25) * legacyTextFieldState.getTextDelegate().getDensity().getDensity()));
            }
        }
        return Rect.INSTANCE.getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateSelection-8UEBfa8, reason: not valid java name */
    public final long m2146updateSelection8UEBfa8(TextFieldValue value, long currentPosition, boolean isStartOfSelection, boolean isStartHandle, SelectionAdjustment adjustment, boolean isTouchBasedSelection) {
        TextLayoutResultProxy layoutResult;
        HapticFeedback hapticFeedback;
        int i;
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState == null || (layoutResult = legacyTextFieldState.getLayoutResult()) == null) {
            return TextRange.Companion.getZero-d9O1mEE();
        }
        long TextRange = TextRangeKt.TextRange(this.offsetMapping.originalToTransformed(TextRange.getStart-impl(value.getSelection-d9O1mEE())), this.offsetMapping.originalToTransformed(TextRange.getEnd-impl(value.getSelection-d9O1mEE())));
        boolean z = false;
        int m1664getOffsetForPosition3MmeM6k = layoutResult.m1664getOffsetForPosition3MmeM6k(currentPosition, false);
        int i2 = (isStartHandle || isStartOfSelection) ? m1664getOffsetForPosition3MmeM6k : TextRange.getStart-impl(TextRange);
        int i3 = (!isStartHandle || isStartOfSelection) ? m1664getOffsetForPosition3MmeM6k : TextRange.getEnd-impl(TextRange);
        SelectionLayout selectionLayout = this.previousSelectionLayout;
        int i4 = -1;
        if (!isStartOfSelection && selectionLayout != null && (i = this.previousRawDragOffset) != -1) {
            i4 = i;
        }
        SelectionLayout m2084getTextFieldSelectionLayoutRcvTLA = SelectionLayoutKt.m2084getTextFieldSelectionLayoutRcvTLA(layoutResult.getValue(), i2, i3, i4, TextRange, isStartOfSelection, isStartHandle);
        if (!m2084getTextFieldSelectionLayoutRcvTLA.shouldRecomputeSelection(selectionLayout)) {
            return value.getSelection-d9O1mEE();
        }
        this.previousSelectionLayout = m2084getTextFieldSelectionLayoutRcvTLA;
        this.previousRawDragOffset = m1664getOffsetForPosition3MmeM6k;
        Selection adjust = adjustment.adjust(m2084getTextFieldSelectionLayoutRcvTLA);
        long TextRange2 = TextRangeKt.TextRange(this.offsetMapping.transformedToOriginal(adjust.getStart().getOffset()), this.offsetMapping.transformedToOriginal(adjust.getEnd().getOffset()));
        if (TextRange.equals-impl0(TextRange2, value.getSelection-d9O1mEE())) {
            return value.getSelection-d9O1mEE();
        }
        boolean z2 = TextRange.getReversed-impl(TextRange2) != TextRange.getReversed-impl(value.getSelection-d9O1mEE()) && TextRange.equals-impl0(TextRangeKt.TextRange(TextRange.getEnd-impl(TextRange2), TextRange.getStart-impl(TextRange2)), value.getSelection-d9O1mEE());
        boolean z3 = TextRange.getCollapsed-impl(TextRange2) && TextRange.getCollapsed-impl(value.getSelection-d9O1mEE());
        if (isTouchBasedSelection) {
            if ((value.getText().length() > 0) && !z2 && !z3 && (hapticFeedback = this.hapticFeedBack) != null) {
                hapticFeedback.mo5617performHapticFeedbackCdsT49E(HapticFeedbackType.INSTANCE.m5634getTextHandleMove5zf0vsI());
            }
        }
        this.onValueChange.invoke(m2142createTextFieldValueFDrldGo(value.getAnnotatedString(), TextRange2));
        this.latestSelection = TextRange.box-impl(TextRange2);
        if (!isTouchBasedSelection) {
            updateFloatingToolbar(!TextRange.getCollapsed-impl(TextRange2));
        }
        LegacyTextFieldState legacyTextFieldState2 = this.state;
        if (legacyTextFieldState2 != null) {
            legacyTextFieldState2.setInTouchMode(isTouchBasedSelection);
        }
        LegacyTextFieldState legacyTextFieldState3 = this.state;
        if (legacyTextFieldState3 != null) {
            legacyTextFieldState3.setShowSelectionHandleStart(!TextRange.getCollapsed-impl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true));
        }
        LegacyTextFieldState legacyTextFieldState4 = this.state;
        if (legacyTextFieldState4 != null) {
            legacyTextFieldState4.setShowSelectionHandleEnd(!TextRange.getCollapsed-impl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, false));
        }
        LegacyTextFieldState legacyTextFieldState5 = this.state;
        if (legacyTextFieldState5 != null) {
            if (TextRange.getCollapsed-impl(TextRange2) && TextFieldSelectionManagerKt.isSelectionHandleInVisibleBound(this, true)) {
                z = true;
            }
            legacyTextFieldState5.setShowCursorHandle(z);
        }
        return TextRange2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHandleState(HandleState handleState) {
        LegacyTextFieldState legacyTextFieldState = this.state;
        if (legacyTextFieldState != null) {
            if (legacyTextFieldState.getHandleState() == handleState) {
                legacyTextFieldState = null;
            }
            if (legacyTextFieldState != null) {
                legacyTextFieldState.setHandleState(handleState);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: createTextFieldValue-FDrldGo, reason: not valid java name */
    public final TextFieldValue m2142createTextFieldValueFDrldGo(AnnotatedString annotatedString, long selection) {
        return new TextFieldValue(annotatedString, selection, (TextRange) null, 4, (DefaultConstructorMarker) null);
    }
}
