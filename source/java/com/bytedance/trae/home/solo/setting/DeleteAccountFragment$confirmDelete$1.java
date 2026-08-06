package com.bytedance.trae.home.solo.setting;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.home.solo.setting.DeleteAccountFragment;
import com.bytedance.trae.home.solo.setting.IAccountCancelApi;
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
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.DeleteAccountFragment$confirmDelete$1", f = "DeleteAccountFragment.kt", i = {}, l = {463, 468}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeleteAccountFragment$confirmDelete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DeleteAccountFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeleteAccountFragment$confirmDelete$1(DeleteAccountFragment deleteAccountFragment, Continuation<? super DeleteAccountFragment$confirmDelete$1> continuation) {
        super(2, continuation);
        this.this$0 = deleteAccountFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeleteAccountFragment$confirmDelete$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        String str3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                try {
                } catch (Exception e) {
                    FLogger.INSTANCE.e("DeleteAccountFragment", "confirmDelete failed: " + e.getMessage());
                    DeleteAccountFragment deleteAccountFragment = this.this$0;
                    String string = deleteAccountFragment.getString(C0820R.string.trae_delete_failed);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    deleteAccountFragment.showToast(string);
                }
            } catch (Exception e2) {
                FLogger.INSTANCE.w("DeleteAccountFragment", "deleteUserData failed: " + e2.getMessage());
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IAccountCancelApi.Companion companion = IAccountCancelApi.INSTANCE;
                str = this.this$0.valueTicket;
                str2 = this.this$0.verifyToken;
                str3 = this.this$0.cancelTicket;
                this.label = 1;
                obj = companion.confirm(str, str2, str3, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.this$0.showStep(DeleteAccountFragment.Step.SUBMITTED);
                    this.this$0.startFinishCountdown();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            CancelConfirmResponse cancelConfirmResponse = (CancelConfirmResponse) obj;
            if (cancelConfirmResponse.getErrorCode() != 0) {
                DeleteAccountFragment deleteAccountFragment2 = this.this$0;
                String description = cancelConfirmResponse.getDescription();
                if (description == null && (description = cancelConfirmResponse.getMessage()) == null) {
                    description = this.this$0.getString(C0820R.string.trae_delete_failed);
                    Intrinsics.checkNotNullExpressionValue(description, "getString(...)");
                }
                deleteAccountFragment2.showToast(description);
                return Unit.INSTANCE;
            }
            this.label = 2;
            if (IAccountCancelApi.INSTANCE.deleteUserData((Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.this$0.showStep(DeleteAccountFragment.Step.SUBMITTED);
            this.this$0.startFinishCountdown();
            return Unit.INSTANCE;
        } finally {
            this.this$0.isLoading = false;
        }
    }
}
