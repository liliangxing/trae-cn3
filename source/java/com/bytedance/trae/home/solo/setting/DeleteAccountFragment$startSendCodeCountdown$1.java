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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeleteAccountFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.DeleteAccountFragment$startSendCodeCountdown$1", f = "DeleteAccountFragment.kt", i = {}, l = {273}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeleteAccountFragment$startSendCodeCountdown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeleteAccountFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteAccountFragment$startSendCodeCountdown$1(DeleteAccountFragment deleteAccountFragment, Continuation<? super DeleteAccountFragment$startSendCodeCountdown$1> continuation) {
        super(2, continuation);
        this.this$0 = deleteAccountFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeleteAccountFragment$startSendCodeCountdown$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005b -> B:5:0x005e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        DeleteAccountFragment$startSendCodeCountdown$1 deleteAccountFragment$startSendCodeCountdown$1;
        int i;
        TextView textView;
        TextView textView2;
        TextView textView3;
        int i2;
        int i3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            deleteAccountFragment$startSendCodeCountdown$1 = this;
            i = deleteAccountFragment$startSendCodeCountdown$1.this$0.sendCodeCountdown;
            TextView textView4 = null;
            if (i <= 0) {
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            deleteAccountFragment$startSendCodeCountdown$1 = this;
            i3 = deleteAccountFragment$startSendCodeCountdown$1.this$0.sendCodeCountdown;
            deleteAccountFragment$startSendCodeCountdown$1.this$0.sendCodeCountdown = i3 - 1;
            i = deleteAccountFragment$startSendCodeCountdown$1.this$0.sendCodeCountdown;
            TextView textView42 = null;
            if (i <= 0) {
                textView3 = deleteAccountFragment$startSendCodeCountdown$1.this$0.btnSendCode;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
                } else {
                    textView42 = textView3;
                }
                DeleteAccountFragment deleteAccountFragment = deleteAccountFragment$startSendCodeCountdown$1.this$0;
                int i5 = C0820R.string.trae_delete_resend_code;
                i2 = deleteAccountFragment$startSendCodeCountdown$1.this$0.sendCodeCountdown;
                textView42.setText(deleteAccountFragment.getString(i5, new Object[]{Boxing.boxInt(i2)}));
                deleteAccountFragment$startSendCodeCountdown$1.label = 1;
                if (DelayKt.delay(1000L, (Continuation) deleteAccountFragment$startSendCodeCountdown$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i3 = deleteAccountFragment$startSendCodeCountdown$1.this$0.sendCodeCountdown;
                deleteAccountFragment$startSendCodeCountdown$1.this$0.sendCodeCountdown = i3 - 1;
                i = deleteAccountFragment$startSendCodeCountdown$1.this$0.sendCodeCountdown;
                TextView textView422 = null;
                if (i <= 0) {
                    if (!deleteAccountFragment$startSendCodeCountdown$1.this$0.isAdded()) {
                        return Unit.INSTANCE;
                    }
                    textView = deleteAccountFragment$startSendCodeCountdown$1.this$0.btnSendCode;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
                        textView = null;
                    }
                    textView.setText(deleteAccountFragment$startSendCodeCountdown$1.this$0.getString(C0820R.string.trae_delete_send_code));
                    textView2 = deleteAccountFragment$startSendCodeCountdown$1.this$0.btnSendCode;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("btnSendCode");
                    } else {
                        textView422 = textView2;
                    }
                    textView422.setEnabled(true);
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
