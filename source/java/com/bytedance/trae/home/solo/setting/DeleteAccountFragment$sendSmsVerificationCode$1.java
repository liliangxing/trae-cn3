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
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.DeleteAccountFragment$sendSmsVerificationCode$1", f = "DeleteAccountFragment.kt", i = {}, l = {323}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeleteAccountFragment$sendSmsVerificationCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $mobile;
    int label;
    final /* synthetic */ DeleteAccountFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteAccountFragment$sendSmsVerificationCode$1(String str, DeleteAccountFragment deleteAccountFragment, Continuation<? super DeleteAccountFragment$sendSmsVerificationCode$1> continuation) {
        super(2, continuation);
        this.$mobile = str;
        this.this$0 = deleteAccountFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeleteAccountFragment$sendSmsVerificationCode$1(this.$mobile, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0084, code lost:
    
        if (r10 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0086, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("btnSmsSendCode");
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008b, code lost:
    
        r4.setEnabled(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x008a, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c8, code lost:
    
        if (r10 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i;
        TextView textView;
        int i2;
        TextView textView2;
        int i3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        TextView textView3 = null;
        try {
            try {
                if (i4 == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = IAccountCancelApi.INSTANCE.sendSmsCode(this.$mobile, (Continuation) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                SmsSendCodeResponse smsSendCodeResponse = (SmsSendCodeResponse) obj;
                if (smsSendCodeResponse.getErrorCode() != 0) {
                    DeleteAccountFragment deleteAccountFragment = this.this$0;
                    String description = smsSendCodeResponse.getDescription();
                    if (description == null && (description = smsSendCodeResponse.getMessage()) == null) {
                        description = this.this$0.getString(C0820R.string.trae_delete_send_code_failed);
                        Intrinsics.checkNotNullExpressionValue(description, "getString(...)");
                    }
                    deleteAccountFragment.showToast(description);
                } else {
                    DeleteAccountFragment deleteAccountFragment2 = this.this$0;
                    String string = deleteAccountFragment2.getString(C0820R.string.trae_delete_send_code_success);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    deleteAccountFragment2.showToast(string);
                    this.this$0.startSmsSendCodeCountdown();
                }
                this.this$0.isLoading = false;
                i3 = this.this$0.sendCodeCountdown;
                if (i3 <= 0) {
                    textView2 = this.this$0.btnSmsSendCode;
                }
            } catch (Exception e) {
                FLogger.INSTANCE.e("DeleteAccountFragment", "sendSmsCode failed: " + e.getMessage());
                DeleteAccountFragment deleteAccountFragment3 = this.this$0;
                String string2 = deleteAccountFragment3.getString(C0820R.string.trae_delete_send_code_failed);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                deleteAccountFragment3.showToast(string2);
                this.this$0.isLoading = false;
                i2 = this.this$0.sendCodeCountdown;
                if (i2 <= 0) {
                    textView2 = this.this$0.btnSmsSendCode;
                }
            }
            return Unit.INSTANCE;
        } catch (Throwable th) {
            this.this$0.isLoading = false;
            i = this.this$0.sendCodeCountdown;
            if (i <= 0) {
                textView = this.this$0.btnSmsSendCode;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnSmsSendCode");
                } else {
                    textView3 = textView;
                }
                textView3.setEnabled(true);
            }
            throw th;
        }
    }
}
