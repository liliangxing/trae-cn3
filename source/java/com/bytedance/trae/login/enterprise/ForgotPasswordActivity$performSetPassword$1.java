package com.bytedance.trae.login.enterprise;

import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.logger.FLogger;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ForgotPasswordActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.enterprise.ForgotPasswordActivity$performSetPassword$1", f = "ForgotPasswordActivity.kt", i = {}, l = {351}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForgotPasswordActivity$performSetPassword$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newPassword;
    int label;
    final /* synthetic */ ForgotPasswordActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForgotPasswordActivity$performSetPassword$1(ForgotPasswordActivity forgotPasswordActivity, String str, Continuation<? super ForgotPasswordActivity$performSetPassword$1> continuation) {
        super(2, continuation);
        this.this$0 = forgotPasswordActivity;
        this.$newPassword = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ForgotPasswordActivity$performSetPassword$1(this.this$0, this.$newPassword, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String string;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C08411(this.this$0, this.$newPassword, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.goToStep4();
        } catch (EnterpriseAuthException e) {
            FLogger.INSTANCE.mo426e("ForgotPasswordActivity", "setUserPassword failed: " + e.getMessage());
            this.this$0.setStep3Loading(false);
            ForgotPasswordActivity forgotPasswordActivity = this.this$0;
            String userMessage = e.getUserMessage();
            if (userMessage == null) {
                userMessage = "";
            }
            forgotPasswordActivity.showStep3Error(userMessage);
        } catch (Exception e2) {
            FLogger.INSTANCE.mo426e("ForgotPasswordActivity", "setUserPassword unexpected error: " + e2.getMessage());
            this.this$0.setStep3Loading(false);
            ForgotPasswordActivity forgotPasswordActivity2 = this.this$0;
            if (e2 instanceof IOException) {
                string = forgotPasswordActivity2.getString(C0882R.string.trae_enterprise_error_network);
            } else {
                string = forgotPasswordActivity2.getString(C0882R.string.trae_enterprise_error_service);
            }
            Intrinsics.checkNotNull(string);
            forgotPasswordActivity2.showStep3Error(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ForgotPasswordActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.enterprise.ForgotPasswordActivity$performSetPassword$1$1", f = "ForgotPasswordActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$performSetPassword$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $newPassword;
        int label;
        final /* synthetic */ ForgotPasswordActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08411(ForgotPasswordActivity forgotPasswordActivity, String str, Continuation<? super C08411> continuation) {
            super(2, continuation);
            this.this$0 = forgotPasswordActivity;
            this.$newPassword = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08411(this.this$0, this.$newPassword, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            String str2;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            EnterpriseAuthManager enterpriseAuthManager = EnterpriseAuthManager.INSTANCE;
            str = this.this$0.email;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("email");
                str = null;
            }
            String str3 = this.$newPassword;
            str2 = this.this$0.verificationCode;
            enterpriseAuthManager.setUserPassword(str, str3, str2);
            return Unit.INSTANCE;
        }
    }
}
