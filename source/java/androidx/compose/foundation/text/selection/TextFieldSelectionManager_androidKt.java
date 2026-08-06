package androidx.compose.foundation.text.selection;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1;
import androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$2;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifier_androidKt;
import androidx.compose.p002ui.ComposedModifierKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TextFieldSelectionManager.android.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0000\u001a3\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f¢\u0006\u0002\b\u000f*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0015²\u0006\n\u0010\u0016\u001a\u00020\u0017X\u008a\u008e\u0002"}, d2 = {"isShiftPressed", "", "Landroidx/compose/ui/input/pointer/PointerEvent;", "(Landroidx/compose/ui/input/pointer/PointerEvent;)Z", "textFieldMagnifier", "Landroidx/compose/ui/Modifier;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "addBasicTextFieldTextContextMenuComponents", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "contextMenuState", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "itemsAvailability", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "foundation_release", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldSelectionManager_androidKt {
    public static final boolean isShiftPressed(PointerEvent pointerEvent) {
        return false;
    }

    public static final Modifier textFieldMagnifier(Modifier modifier, TextFieldSelectionManager textFieldSelectionManager) {
        return !Magnifier_androidKt.isPlatformMagnifierSupported$default(0, 1, null) ? modifier : ComposedModifierKt.composed$default(modifier, null, new TextFieldSelectionManager_androidKt$textFieldMagnifier$1(textFieldSelectionManager), 1, null);
    }

    public static final Modifier addBasicTextFieldTextContextMenuComponents(Modifier modifier, final TextFieldSelectionManager textFieldSelectionManager, final CoroutineScope coroutineScope) {
        return TextContextMenuModifier_androidKt.addTextContextMenuComponentsWithContext(modifier, new Function2() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj, Object obj2) {
                Unit addBasicTextFieldTextContextMenuComponents$lambda$8;
                addBasicTextFieldTextContextMenuComponents$lambda$8 = TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$8(TextFieldSelectionManager.this, coroutineScope, (TextContextMenuBuilderScope) obj, (Context) obj2);
                return addBasicTextFieldTextContextMenuComponents$lambda$8;
            }
        });
    }

    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem$default */
    static /* synthetic */ void m40xc4a00741(TextContextMenuBuilderScope textContextMenuBuilderScope, Context context, TextContextMenuItems textContextMenuItems, boolean z, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 8) != 0) {
            function0 = null;
        }
        m39x369fc5a4(textContextMenuBuilderScope, context, textContextMenuItems, z, function0, function02);
    }

    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem */
    private static final void m39x369fc5a4(TextContextMenuBuilderScope textContextMenuBuilderScope, Context context, TextContextMenuItems textContextMenuItems, boolean z, final Function0<Boolean> function0, final Function0<Unit> function02) {
        ContextMenu_androidKt.textItem(textContextMenuBuilderScope, context.getResources(), textContextMenuItems, z, new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                Unit m41x46c97193;
                m41x46c97193 = TextFieldSelectionManager_androidKt.m41x46c97193(function02, function0, (TextContextMenuSession) obj);
                return m41x46c97193;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldItem$lambda$0 */
    public static final Unit m41x46c97193(Function0 function0, Function0 function02, TextContextMenuSession textContextMenuSession) {
        function0.invoke();
        if (function02 != null ? ((Boolean) function02.invoke()).booleanValue() : true) {
            textContextMenuSession.close();
        }
        return Unit.INSTANCE;
    }

    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldSuspendItem */
    private static final void m42x7511f1be(TextContextMenuBuilderScope textContextMenuBuilderScope, final CoroutineScope coroutineScope, Context context, TextContextMenuItems textContextMenuItems, boolean z, final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        m40xc4a00741(textContextMenuBuilderScope, context, textContextMenuItems, z, null, new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda6
            public final Object invoke() {
                Unit m43x977e42ba;
                m43x977e42ba = TextFieldSelectionManager_androidKt.m43x977e42ba(coroutineScope, function1);
                return m43x977e42ba;
            }
        }, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$8$textFieldSuspendItem$lambda$1 */
    public static final Unit m43x977e42ba(CoroutineScope coroutineScope, Function1 function1) {
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new C0547x4bd70adf(function1, null), 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addBasicTextFieldTextContextMenuComponents$lambda$8(final TextFieldSelectionManager textFieldSelectionManager, final CoroutineScope coroutineScope, TextContextMenuBuilderScope textContextMenuBuilderScope, final Context context) {
        TextRange textRange;
        boolean editable = textFieldSelectionManager.getEditable();
        AnnotatedString transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release();
        String text = transformedText$foundation_release != null ? transformedText$foundation_release.getText() : null;
        TextRange latestSelection = textFieldSelectionManager.getLatestSelection();
        if (latestSelection != null) {
            long j = latestSelection.unbox-impl();
            OffsetMapping offsetMapping = textFieldSelectionManager.getOffsetMapping();
            textRange = TextRange.box-impl(TextRangeKt.TextRange(offsetMapping.originalToTransformed(TextRange.getStart-impl(j)), offsetMapping.originalToTransformed(TextRange.getEnd-impl(j))));
        } else {
            textRange = null;
        }
        PlatformSelectionBehaviors_androidKt.m2068addPlatformTextContextMenuItems71BSaZU(textContextMenuBuilderScope, context, editable, text, textRange, textFieldSelectionManager.getPlatformSelectionBehaviors(), new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7;
                addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7 = TextFieldSelectionManager_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7(TextFieldSelectionManager.this, coroutineScope, context, (TextContextMenuBuilderScope) obj);
                return addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7(final TextFieldSelectionManager textFieldSelectionManager, CoroutineScope coroutineScope, Context context, TextContextMenuBuilderScope textContextMenuBuilderScope) {
        textContextMenuBuilderScope.separator();
        m42x7511f1be(textContextMenuBuilderScope, coroutineScope, context, TextContextMenuItems.Cut, textFieldSelectionManager.canCut$foundation_release(), new C0544xdce13b49(textFieldSelectionManager, null));
        m42x7511f1be(textContextMenuBuilderScope, coroutineScope, context, TextContextMenuItems.Copy, textFieldSelectionManager.canCopy$foundation_release(), new C0545xdce13b4a(textFieldSelectionManager, null));
        m42x7511f1be(textContextMenuBuilderScope, coroutineScope, context, TextContextMenuItems.Paste, textFieldSelectionManager.canPaste$foundation_release(), new C0546xdce13b4b(textFieldSelectionManager, null));
        m39x369fc5a4(textContextMenuBuilderScope, context, TextContextMenuItems.SelectAll, textFieldSelectionManager.canSelectAll$foundation_release(), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda7
            public final Object invoke() {
                boolean m36x353faa13;
                m36x353faa13 = TextFieldSelectionManager_androidKt.m36x353faa13(TextFieldSelectionManager.this);
                return Boolean.valueOf(m36x353faa13);
            }
        }, new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda8
            public final Object invoke() {
                Unit m37x353faa14;
                m37x353faa14 = TextFieldSelectionManager_androidKt.m37x353faa14(TextFieldSelectionManager.this);
                return m37x353faa14;
            }
        });
        if (Build.VERSION.SDK_INT >= 26) {
            m40xc4a00741(textContextMenuBuilderScope, context, TextContextMenuItems.Autofill, textFieldSelectionManager.canAutofill$foundation_release(), null, new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit m38x353faa15;
                    m38x353faa15 = TextFieldSelectionManager_androidKt.m38x353faa15(TextFieldSelectionManager.this);
                    return m38x353faa15;
                }
            }, 8, null);
        }
        textContextMenuBuilderScope.separator();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7$lambda$6$lambda$3 */
    public static final boolean m36x353faa13(TextFieldSelectionManager textFieldSelectionManager) {
        return !textFieldSelectionManager.getTextToolbarShown$foundation_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7$lambda$6$lambda$4 */
    public static final Unit m37x353faa14(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.selectAll$foundation_release();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$8$lambda$7$lambda$6$lambda$5 */
    public static final Unit m38x353faa15(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.autofill$foundation_release();
        return Unit.INSTANCE;
    }

    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final TextFieldSelectionManager textFieldSelectionManager, final ContextMenuState contextMenuState, final State<MenuItemsAvailability> state) {
        return new Function1() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit contextMenuBuilder$lambda$15;
                contextMenuBuilder$lambda$15 = TextFieldSelectionManager_androidKt.contextMenuBuilder$lambda$15(State.this, textFieldSelectionManager, contextMenuState, (ContextMenuScope) obj);
                return contextMenuBuilder$lambda$15;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$15(State state, final TextFieldSelectionManager textFieldSelectionManager, ContextMenuState contextMenuState, ContextMenuScope contextMenuScope) {
        int m1609unboximpl = ((MenuItemsAvailability) state.getValue()).m1609unboximpl();
        contextMenuBuilder$lambda$15$textFieldItem$9(contextMenuScope, contextMenuState, TextContextMenuItems.Cut, MenuItemsAvailability.m1604getCanCutimpl(m1609unboximpl), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda10
            public final Object invoke() {
                Unit contextMenuBuilder$lambda$15$lambda$10;
                contextMenuBuilder$lambda$15$lambda$10 = TextFieldSelectionManager_androidKt.contextMenuBuilder$lambda$15$lambda$10(TextFieldSelectionManager.this);
                return contextMenuBuilder$lambda$15$lambda$10;
            }
        });
        contextMenuBuilder$lambda$15$textFieldItem$9(contextMenuScope, contextMenuState, TextContextMenuItems.Copy, MenuItemsAvailability.m1603getCanCopyimpl(m1609unboximpl), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda11
            public final Object invoke() {
                Unit contextMenuBuilder$lambda$15$lambda$11;
                contextMenuBuilder$lambda$15$lambda$11 = TextFieldSelectionManager_androidKt.contextMenuBuilder$lambda$15$lambda$11(TextFieldSelectionManager.this);
                return contextMenuBuilder$lambda$15$lambda$11;
            }
        });
        contextMenuBuilder$lambda$15$textFieldItem$9(contextMenuScope, contextMenuState, TextContextMenuItems.Paste, MenuItemsAvailability.m1605getCanPasteimpl(m1609unboximpl), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda12
            public final Object invoke() {
                Unit contextMenuBuilder$lambda$15$lambda$12;
                contextMenuBuilder$lambda$15$lambda$12 = TextFieldSelectionManager_androidKt.contextMenuBuilder$lambda$15$lambda$12(TextFieldSelectionManager.this);
                return contextMenuBuilder$lambda$15$lambda$12;
            }
        });
        contextMenuBuilder$lambda$15$textFieldItem$9(contextMenuScope, contextMenuState, TextContextMenuItems.SelectAll, MenuItemsAvailability.m1606getCanSelectAllimpl(m1609unboximpl), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit contextMenuBuilder$lambda$15$lambda$13;
                contextMenuBuilder$lambda$15$lambda$13 = TextFieldSelectionManager_androidKt.contextMenuBuilder$lambda$15$lambda$13(TextFieldSelectionManager.this);
                return contextMenuBuilder$lambda$15$lambda$13;
            }
        });
        if (Build.VERSION.SDK_INT >= 26) {
            contextMenuBuilder$lambda$15$textFieldItem$9(contextMenuScope, contextMenuState, TextContextMenuItems.Autofill, MenuItemsAvailability.m1602getCanAutofillimpl(m1609unboximpl), new Function0() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManager_androidKt$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit contextMenuBuilder$lambda$15$lambda$14;
                    contextMenuBuilder$lambda$15$lambda$14 = TextFieldSelectionManager_androidKt.contextMenuBuilder$lambda$15$lambda$14(TextFieldSelectionManager.this);
                    return contextMenuBuilder$lambda$15$lambda$14;
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$15$lambda$10(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.cut$foundation_release();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$15$lambda$11(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.copy$foundation_release(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$15$lambda$12(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.paste$foundation_release();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$15$lambda$13(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.selectAll$foundation_release();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$15$lambda$14(TextFieldSelectionManager textFieldSelectionManager) {
        textFieldSelectionManager.autofill$foundation_release();
        return Unit.INSTANCE;
    }

    private static final void contextMenuBuilder$lambda$15$textFieldItem$9(ContextMenuScope contextMenuScope, ContextMenuState contextMenuState, TextContextMenuItems textContextMenuItems, boolean z, Function0<Unit> function0) {
        if (z) {
            ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems), null, false, null, new ContextMenu_androidKt$TextItem$2(function0, contextMenuState), 14, null);
        }
    }
}
