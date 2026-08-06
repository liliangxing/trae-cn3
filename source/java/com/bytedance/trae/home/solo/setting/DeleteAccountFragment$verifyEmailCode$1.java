package com.bytedance.trae.home.solo.setting;

import android.widget.TextView;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DeleteAccountFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.DeleteAccountFragment$verifyEmailCode$1", f = "DeleteAccountFragment.kt", i = {}, l = {294, 299}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeleteAccountFragment$verifyEmailCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    int label;
    final /* synthetic */ DeleteAccountFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteAccountFragment$verifyEmailCode$1(String str, DeleteAccountFragment deleteAccountFragment, Continuation<? super DeleteAccountFragment$verifyEmailCode$1> continuation) {
        super(2, continuation);
        this.$code = str;
        this.this$0 = deleteAccountFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeleteAccountFragment$verifyEmailCode$1(this.$code, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x00d0, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cb, code lost:
    
        if (r11 != null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        TextView textView;
        TextView textView2;
        Object performCancelCheckAndProceed;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        TextView textView3 = null;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = IAccountCancelApi.INSTANCE.verifyEmailCode(this.$code, (Continuation) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                EmailVerifyResponse emailVerifyResponse = (EmailVerifyResponse) obj;
                if (emailVerifyResponse.getErrorCode() != 0) {
                    DeleteAccountFragment deleteAccountFragment = this.this$0;
                    String description = emailVerifyResponse.getDescription();
                    if (description == null && (description = emailVerifyResponse.getMessage()) == null) {
                        description = this.this$0.getString(C0820R.string.trae_delete_verify_failed);
                        Intrinsics.checkNotNullExpressionValue(description, "getString(...)");
                    }
                    deleteAccountFragment.showToast(description);
                } else {
                    DeleteAccountFragment deleteAccountFragment2 = this.this$0;
                    VerifyTicketData data = emailVerifyResponse.getData();
                    deleteAccountFragment2.verifyToken = data != null ? data.getTicket() : null;
                    this.label = 2;
                    performCancelCheckAndProceed = this.this$0.performCancelCheckAndProceed((Continuation) this);
                    if (performCancelCheckAndProceed == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Exception e) {
                FLogger.INSTANCE.e("DeleteAccountFragment", "verifyEmailCode failed: " + e.getMessage());
                DeleteAccountFragment deleteAccountFragment3 = this.this$0;
                String string = deleteAccountFragment3.getString(C0820R.string.trae_delete_verify_failed);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                deleteAccountFragment3.showToast(string);
                this.this$0.isLoading = false;
                textView2 = this.this$0.btnVerify;
            }
        } finally {
            this.this$0.isLoading = false;
            textView = this.this$0.btnVerify;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnVerify");
            } else {
                textView3 = textView;
            }
            textView3.setEnabled(true);
        }
    }
}
