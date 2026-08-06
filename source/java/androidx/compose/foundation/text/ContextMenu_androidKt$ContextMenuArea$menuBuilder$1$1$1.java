package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContextMenu.android.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1", f = "ContextMenu.android.kt", i = {}, l = {110, 111, 112}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TextContextMenuItems $item;
    final /* synthetic */ TextFieldSelectionState $this_contextMenuBuilder;
    int label;

    /* compiled from: ContextMenu.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextContextMenuItems.values().length];
            try {
                iArr[TextContextMenuItems.Cut.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextContextMenuItems.Copy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextContextMenuItems.Paste.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TextContextMenuItems.SelectAll.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TextContextMenuItems.Autofill.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1(TextContextMenuItems textContextMenuItems, TextFieldSelectionState textFieldSelectionState, Continuation<? super ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1> continuation) {
        super(2, continuation);
        this.$item = textContextMenuItems;
        this.$this_contextMenuBuilder = textFieldSelectionState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContextMenu_androidKt$ContextMenuArea$menuBuilder$1$1$1(this.$item, this.$this_contextMenuBuilder, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = WhenMappings.$EnumSwitchMapping$0[this.$item.ordinal()];
            if (i2 == 1) {
                this.label = 1;
                if (this.$this_contextMenuBuilder.cut((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 2) {
                this.label = 2;
                if (this.$this_contextMenuBuilder.copy(false, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 3) {
                this.label = 3;
                if (this.$this_contextMenuBuilder.paste((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 4) {
                this.$this_contextMenuBuilder.selectAll();
            } else {
                if (i2 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                this.$this_contextMenuBuilder.autofill();
            }
        } else {
            if (i != 1 && i != 2 && i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
