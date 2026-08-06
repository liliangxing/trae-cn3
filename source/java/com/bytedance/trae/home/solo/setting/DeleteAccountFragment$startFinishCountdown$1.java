package com.bytedance.trae.home.solo.setting;

import android.widget.TextView;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeleteAccountFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.DeleteAccountFragment$startFinishCountdown$1", f = "DeleteAccountFragment.kt", i = {}, l = {490}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeleteAccountFragment$startFinishCountdown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $countdown;
    int label;
    final /* synthetic */ DeleteAccountFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteAccountFragment$startFinishCountdown$1(Ref.IntRef intRef, DeleteAccountFragment deleteAccountFragment, Continuation<? super DeleteAccountFragment$startFinishCountdown$1> continuation) {
        super(2, continuation);
        this.$countdown = intRef;
        this.this$0 = deleteAccountFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeleteAccountFragment$startFinishCountdown$1(this.$countdown, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0042  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x002d -> B:5:0x0030). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DeleteAccountFragment$startFinishCountdown$1 deleteAccountFragment$startFinishCountdown$1;
        TextView textView;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            deleteAccountFragment$startFinishCountdown$1 = this;
            if (deleteAccountFragment$startFinishCountdown$1.$countdown.element > 0) {
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            deleteAccountFragment$startFinishCountdown$1 = this;
            deleteAccountFragment$startFinishCountdown$1.$countdown.element--;
            if (!deleteAccountFragment$startFinishCountdown$1.this$0.isAdded()) {
                textView = deleteAccountFragment$startFinishCountdown$1.this$0.btnOkCountdown;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnOkCountdown");
                    textView = null;
                }
                textView.setText(deleteAccountFragment$startFinishCountdown$1.this$0.getString(C0820R.string.trae_delete_ok_countdown, new Object[]{Boxing.boxInt(deleteAccountFragment$startFinishCountdown$1.$countdown.element)}));
                if (deleteAccountFragment$startFinishCountdown$1.$countdown.element > 0) {
                    deleteAccountFragment$startFinishCountdown$1.this$0.navigateToLogin();
                    return Unit.INSTANCE;
                }
                deleteAccountFragment$startFinishCountdown$1.label = 1;
                if (DelayKt.delay(1000L, (Continuation) deleteAccountFragment$startFinishCountdown$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                deleteAccountFragment$startFinishCountdown$1.$countdown.element--;
                if (!deleteAccountFragment$startFinishCountdown$1.this$0.isAdded()) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
