package androidx.compose.foundation.text.input.internal.selection;

import android.content.Context;
import android.os.Build;
import androidx.compose.foundation.contextmenu.ContextMenuScope;
import androidx.compose.foundation.contextmenu.ContextMenuState;
import androidx.compose.foundation.contextmenu.ContextMenuState_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.ContextMenu_androidKt$TextItem$1;
import androidx.compose.foundation.text.MenuItemsAvailability;
import androidx.compose.foundation.text.TextContextMenuItems;
import androidx.compose.foundation.text.contextmenu.builder.TextContextMenuBuilderScope;
import androidx.compose.foundation.text.contextmenu.data.TextContextMenuSession;
import androidx.compose.foundation.text.contextmenu.modifier.TextContextMenuModifier_androidKt;
import androidx.compose.foundation.text.selection.PlatformSelectionBehaviors_androidKt;
import androidx.compose.p002ui.Modifier;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.TextRange;
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

/* compiled from: TextFieldSelectionState.android.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f¢\u0006\u0002\b\u0004H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0000¨\u0006\u0012"}, d2 = {"contextMenuBuilder", "Lkotlin/Function1;", "Landroidx/compose/foundation/contextmenu/ContextMenuScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "state", "Landroidx/compose/foundation/contextmenu/ContextMenuState;", "itemsAvailability", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/text/MenuItemsAvailability;", "onMenuItemClicked", "Lkotlin/Function2;", "Landroidx/compose/foundation/text/TextContextMenuItems;", "addBasicTextFieldTextContextMenuComponents", "Landroidx/compose/ui/Modifier;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldSelectionState_androidKt {
    public static final Function1<ContextMenuScope, Unit> contextMenuBuilder(final TextFieldSelectionState textFieldSelectionState, final ContextMenuState contextMenuState, final State<MenuItemsAvailability> state, final Function2<? super TextFieldSelectionState, ? super TextContextMenuItems, Unit> function2) {
        return new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                Unit contextMenuBuilder$lambda$1;
                contextMenuBuilder$lambda$1 = TextFieldSelectionState_androidKt.contextMenuBuilder$lambda$1(State.this, contextMenuState, function2, textFieldSelectionState, (ContextMenuScope) obj);
                return contextMenuBuilder$lambda$1;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit contextMenuBuilder$lambda$1(State state, ContextMenuState contextMenuState, Function2 function2, TextFieldSelectionState textFieldSelectionState, ContextMenuScope contextMenuScope) {
        int m1609unboximpl = ((MenuItemsAvailability) state.getValue()).m1609unboximpl();
        contextMenuBuilder$lambda$1$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Cut, MenuItemsAvailability.m1604getCanCutimpl(m1609unboximpl));
        contextMenuBuilder$lambda$1$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Copy, MenuItemsAvailability.m1603getCanCopyimpl(m1609unboximpl));
        contextMenuBuilder$lambda$1$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Paste, MenuItemsAvailability.m1605getCanPasteimpl(m1609unboximpl));
        contextMenuBuilder$lambda$1$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.SelectAll, MenuItemsAvailability.m1606getCanSelectAllimpl(m1609unboximpl));
        if (Build.VERSION.SDK_INT >= 26) {
            contextMenuBuilder$lambda$1$textFieldItem(contextMenuScope, contextMenuState, function2, textFieldSelectionState, TextContextMenuItems.Autofill, MenuItemsAvailability.m1602getCanAutofillimpl(m1609unboximpl));
        }
        return Unit.INSTANCE;
    }

    public static final Modifier addBasicTextFieldTextContextMenuComponents(Modifier modifier, final TextFieldSelectionState textFieldSelectionState, final CoroutineScope coroutineScope) {
        return TextContextMenuModifier_androidKt.addTextContextMenuComponentsWithContext(modifier, new Function2() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2) {
                Unit addBasicTextFieldTextContextMenuComponents$lambda$10;
                addBasicTextFieldTextContextMenuComponents$lambda$10 = TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$10(TextFieldSelectionState.this, coroutineScope, (TextContextMenuBuilderScope) obj, (Context) obj2);
                return addBasicTextFieldTextContextMenuComponents$lambda$10;
            }
        });
    }

    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3$default */
    static /* synthetic */ void m26x48581597(TextContextMenuBuilderScope textContextMenuBuilderScope, Context context, TextFieldSelectionState textFieldSelectionState, TextContextMenuItems textContextMenuItems, boolean z, TextToolbarState textToolbarState, Function0 function0, Function0 function02, int i, Object obj) {
        m25x245e89fa(textContextMenuBuilderScope, context, textFieldSelectionState, textContextMenuItems, z, (i & 16) != 0 ? TextToolbarState.None : textToolbarState, (i & 32) != 0 ? null : function0, function02);
    }

    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3 */
    private static final void m25x245e89fa(TextContextMenuBuilderScope textContextMenuBuilderScope, Context context, final TextFieldSelectionState textFieldSelectionState, TextContextMenuItems textContextMenuItems, boolean z, final TextToolbarState textToolbarState, final Function0<Boolean> function0, final Function0<Unit> function02) {
        ContextMenu_androidKt.textItem(textContextMenuBuilderScope, context.getResources(), textContextMenuItems, z, new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                Unit m27x3a132dff;
                m27x3a132dff = TextFieldSelectionState_androidKt.m27x3a132dff(function02, function0, textFieldSelectionState, textToolbarState, (TextContextMenuSession) obj);
                return m27x3a132dff;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldItem$3$lambda$2 */
    public static final Unit m27x3a132dff(Function0 function0, Function0 function02, TextFieldSelectionState textFieldSelectionState, TextToolbarState textToolbarState, TextContextMenuSession textContextMenuSession) {
        function0.invoke();
        if (function02 != null ? ((Boolean) function02.invoke()).booleanValue() : true) {
            textContextMenuSession.close();
        }
        textFieldSelectionState.updateTextToolbarState(textToolbarState);
        return Unit.INSTANCE;
    }

    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldSuspendItem */
    private static final void m28x4a4bbd57(TextContextMenuBuilderScope textContextMenuBuilderScope, final CoroutineScope coroutineScope, Context context, TextFieldSelectionState textFieldSelectionState, TextContextMenuItems textContextMenuItems, boolean z, final Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        m26x48581597(textContextMenuBuilderScope, context, textFieldSelectionState, textContextMenuItems, z, null, null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$$ExternalSyntheticLambda7
            public final Object invoke() {
                Unit m29xcefd7344;
                m29xcefd7344 = TextFieldSelectionState_androidKt.m29xcefd7344(coroutineScope, function1);
                return m29xcefd7344;
            }
        }, 48, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$10$textFieldSuspendItem$lambda$4 */
    public static final Unit m29xcefd7344(CoroutineScope coroutineScope, Function1 function1) {
        BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, CoroutineStart.UNDISPATCHED, new C0503xc4270c03(function1, null), 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addBasicTextFieldTextContextMenuComponents$lambda$10(final TextFieldSelectionState textFieldSelectionState, final CoroutineScope coroutineScope, TextContextMenuBuilderScope textContextMenuBuilderScope, final Context context) {
        PlatformSelectionBehaviors_androidKt.m2068addPlatformTextContextMenuItems71BSaZU(textContextMenuBuilderScope, context, textFieldSelectionState.getEditable$foundation_release(), textFieldSelectionState.getTextFieldState().getVisualText().getText(), TextRange.box-impl(textFieldSelectionState.getTextFieldState().getVisualText().getSelection()), textFieldSelectionState.getPlatformSelectionBehaviors(), new Function1() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9;
                addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9 = TextFieldSelectionState_androidKt.addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9(TextFieldSelectionState.this, coroutineScope, context, (TextContextMenuBuilderScope) obj);
                return addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9(final TextFieldSelectionState textFieldSelectionState, CoroutineScope coroutineScope, Context context, TextContextMenuBuilderScope textContextMenuBuilderScope) {
        textContextMenuBuilderScope.separator();
        m28x4a4bbd57(textContextMenuBuilderScope, coroutineScope, context, textFieldSelectionState, TextContextMenuItems.Cut, textFieldSelectionState.canCut(), new C0500xe9d98d24(textFieldSelectionState, null));
        m28x4a4bbd57(textContextMenuBuilderScope, coroutineScope, context, textFieldSelectionState, TextContextMenuItems.Copy, textFieldSelectionState.canCopy(), new C0501xe9d98d25(textFieldSelectionState, null));
        m28x4a4bbd57(textContextMenuBuilderScope, coroutineScope, context, textFieldSelectionState, TextContextMenuItems.Paste, textFieldSelectionState.canPaste(), new C0502xe9d98d26(textFieldSelectionState, null));
        m25x245e89fa(textContextMenuBuilderScope, context, textFieldSelectionState, TextContextMenuItems.SelectAll, textFieldSelectionState.canSelectAll(), TextToolbarState.Selection, new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$$ExternalSyntheticLambda3
            public final Object invoke() {
                boolean m22x2e3644ae;
                m22x2e3644ae = TextFieldSelectionState_androidKt.m22x2e3644ae(TextFieldSelectionState.this);
                return Boolean.valueOf(m22x2e3644ae);
            }
        }, new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$$ExternalSyntheticLambda4
            public final Object invoke() {
                Unit m23x2e3644af;
                m23x2e3644af = TextFieldSelectionState_androidKt.m23x2e3644af(TextFieldSelectionState.this);
                return m23x2e3644af;
            }
        });
        if (Build.VERSION.SDK_INT >= 26) {
            m26x48581597(textContextMenuBuilderScope, context, textFieldSelectionState, TextContextMenuItems.Autofill, textFieldSelectionState.canAutofill(), null, null, new Function0() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$$ExternalSyntheticLambda5
                public final Object invoke() {
                    Unit m24x2e3644b0;
                    m24x2e3644b0 = TextFieldSelectionState_androidKt.m24x2e3644b0(TextFieldSelectionState.this);
                    return m24x2e3644b0;
                }
            }, 48, null);
        }
        textContextMenuBuilderScope.separator();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9$lambda$8$lambda$5 */
    public static final boolean m22x2e3644ae(TextFieldSelectionState textFieldSelectionState) {
        return !textFieldSelectionState.getTextToolbarShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9$lambda$8$lambda$6 */
    public static final Unit m23x2e3644af(TextFieldSelectionState textFieldSelectionState) {
        textFieldSelectionState.selectAll();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: addBasicTextFieldTextContextMenuComponents$lambda$10$lambda$9$lambda$8$lambda$7 */
    public static final Unit m24x2e3644b0(TextFieldSelectionState textFieldSelectionState) {
        textFieldSelectionState.autofill();
        return Unit.INSTANCE;
    }

    private static final void contextMenuBuilder$lambda$1$textFieldItem(ContextMenuScope contextMenuScope, final ContextMenuState contextMenuState, final Function2<? super TextFieldSelectionState, ? super TextContextMenuItems, Unit> function2, final TextFieldSelectionState textFieldSelectionState, final TextContextMenuItems textContextMenuItems, boolean z) {
        if (z) {
            ContextMenuScope.item$default(contextMenuScope, new ContextMenu_androidKt$TextItem$1(textContextMenuItems), null, false, null, new Function0<Unit>() { // from class: androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState_androidKt$contextMenuBuilder$lambda$1$textFieldItem$$inlined$TextItem$1
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1975invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m1975invoke() {
                    function2.invoke(textFieldSelectionState, textContextMenuItems);
                    ContextMenuState_androidKt.close(ContextMenuState.this);
                }
            }, 14, null);
        }
    }
}
