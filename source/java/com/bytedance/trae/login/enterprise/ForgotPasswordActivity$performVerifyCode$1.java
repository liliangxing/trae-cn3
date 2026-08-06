package com.bytedance.trae.login.enterprise;

import com.bytedance.trae.login.widget.VerifyCodeInputView;
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
@DebugMetadata(c = "com.bytedance.trae.login.enterprise.ForgotPasswordActivity$performVerifyCode$1", f = "ForgotPasswordActivity.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ForgotPasswordActivity$performVerifyCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $code;
    int label;
    final /* synthetic */ ForgotPasswordActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForgotPasswordActivity$performVerifyCode$1(ForgotPasswordActivity forgotPasswordActivity, String str, Continuation<? super ForgotPasswordActivity$performVerifyCode$1> continuation) {
        super(2, continuation);
        this.this$0 = forgotPasswordActivity;
        this.$code = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ForgotPasswordActivity$performVerifyCode$1(this.this$0, this.$code, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        VerifyCodeInputView verifyCodeInputView;
        VerifyCodeInputView verifyCodeInputView2;
        String string;
        VerifyCodeInputView verifyCodeInputView3;
        VerifyCodeInputView verifyCodeInputView4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        VerifyCodeInputView verifyCodeInputView5 = null;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getIO(), new C08421(this.$code, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.verificationCode = this.$code;
            this.this$0.goToStep3();
        } catch (EnterpriseAuthException e) {
            FLogger.INSTANCE.mo426e("ForgotPasswordActivity", "getCodeInfo failed: " + e.getMessage());
            this.this$0.setStep2Loading(false);
            verifyCodeInputView3 = this.this$0.verifyCodeInput;
            if (verifyCodeInputView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
                verifyCodeInputView3 = null;
            }
            verifyCodeInputView3.setText("");
            verifyCodeInputView4 = this.this$0.verifyCodeInput;
            if (verifyCodeInputView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
            } else {
                verifyCodeInputView5 = verifyCodeInputView4;
            }
            verifyCodeInputView5.requestFocus();
            ForgotPasswordActivity forgotPasswordActivity = this.this$0;
            String userMessage = e.getUserMessage();
            forgotPasswordActivity.showStep2Error(userMessage != null ? userMessage : "");
        } catch (Exception e2) {
            FLogger.INSTANCE.mo426e("ForgotPasswordActivity", "getCodeInfo unexpected error: " + e2.getMessage());
            this.this$0.setStep2Loading(false);
            verifyCodeInputView = this.this$0.verifyCodeInput;
            if (verifyCodeInputView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
                verifyCodeInputView = null;
            }
            verifyCodeInputView.setText("");
            verifyCodeInputView2 = this.this$0.verifyCodeInput;
            if (verifyCodeInputView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("verifyCodeInput");
            } else {
                verifyCodeInputView5 = verifyCodeInputView2;
            }
            verifyCodeInputView5.requestFocus();
            ForgotPasswordActivity forgotPasswordActivity2 = this.this$0;
            if (e2 instanceof IOException) {
                string = forgotPasswordActivity2.getString(C0882R.string.trae_enterprise_error_network);
            } else {
                string = forgotPasswordActivity2.getString(C0882R.string.trae_enterprise_error_service);
            }
            Intrinsics.checkNotNull(string);
            forgotPasswordActivity2.showStep2Error(string);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ForgotPasswordActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/trae/login/enterprise/GetCodeInfoResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.enterprise.ForgotPasswordActivity$performVerifyCode$1$1", f = "ForgotPasswordActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.enterprise.ForgotPasswordActivity$performVerifyCode$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GetCodeInfoResult>, Object> {
        final /* synthetic */ String $code;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08421(String str, Continuation<? super C08421> continuation) {
            super(2, continuation);
            this.$code = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08421(this.$code, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super GetCodeInfoResult> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return EnterpriseAuthManager.INSTANCE.getCodeInfo(this.$code);
        }
    }
}
