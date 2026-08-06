package com.bytedance.trae.home.solo.setting;

import android.widget.Toast;
import androidx.appcompat.widget.SwitchCompat;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.C0820R;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
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
/* compiled from: AccountFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.AccountFragment$togglePrivacyMode$1", f = "AccountFragment.kt", i = {}, l = {538}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AccountFragment$togglePrivacyMode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $open;
    int label;
    final /* synthetic */ AccountFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountFragment$togglePrivacyMode$1(boolean z, AccountFragment accountFragment, Continuation<? super AccountFragment$togglePrivacyMode$1> continuation) {
        super(2, continuation);
        this.$open = z;
        this.this$0 = accountFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountFragment$togglePrivacyMode$1(this.$open, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        r5 = r0.booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if (r8 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0064, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        r2.setEnabled(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
    
        r2 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b9, code lost:
    
        if (r0 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c2, code lost:
    
        if (r8 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean isEnterpriseLogin;
        SwitchCompat switchCompat;
        ILoginService loginService;
        AccountInfo accountInfo;
        Boolean saasPrivacyMode;
        SwitchCompat switchCompat2;
        boolean isEnterpriseLogin2;
        SwitchCompat switchCompat3;
        AccountFragment accountFragment;
        ILoginService loginService2;
        Boolean saasPrivacyMode2;
        ILoginService loginService3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        SwitchCompat switchCompat4 = null;
        boolean z = true;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (IPrivacyModeApi.INSTANCE.toggle(this.$open, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception unused) {
                switchCompat2 = this.this$0.switchPrivacyMode;
                if (switchCompat2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
                    switchCompat2 = null;
                }
                switchCompat2.setChecked(!this.$open);
                if (this.this$0.isAdded()) {
                    Toast.makeText(this.this$0.requireContext(), C0820R.string.trae_setting_privacy_mode_toggle_failed, 0).show();
                }
                this.this$0.isSwitching = false;
                isEnterpriseLogin2 = this.this$0.isEnterpriseLogin();
                if (!isEnterpriseLogin2) {
                    switchCompat3 = this.this$0.switchPrivacyMode;
                } else {
                    accountFragment = this.this$0;
                    loginService2 = accountFragment.getLoginService();
                    if (loginService2 != null) {
                        AccountInfo accountInfo2 = loginService2.getAccountInfo();
                        if (accountInfo2 != null) {
                            saasPrivacyMode2 = accountInfo2.getSaasPrivacyMode();
                        }
                    }
                }
            }
            if (!isEnterpriseLogin) {
                switchCompat3 = this.this$0.switchPrivacyMode;
            } else {
                accountFragment = this.this$0;
                loginService3 = accountFragment.getLoginService();
                if (loginService3 != null) {
                    AccountInfo accountInfo3 = loginService3.getAccountInfo();
                    if (accountInfo3 != null) {
                        saasPrivacyMode2 = accountInfo3.getSaasPrivacyMode();
                    }
                }
                accountFragment.applyEnterprisePrivacyMode(z);
                return Unit.INSTANCE;
            }
        } finally {
            this.this$0.isSwitching = false;
            isEnterpriseLogin = this.this$0.isEnterpriseLogin();
            if (!isEnterpriseLogin) {
                switchCompat = this.this$0.switchPrivacyMode;
                if (switchCompat == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
                } else {
                    switchCompat4 = switchCompat;
                }
                switchCompat4.setEnabled(true);
            } else {
                AccountFragment accountFragment2 = this.this$0;
                loginService = accountFragment2.getLoginService();
                if (loginService != null && (accountInfo = loginService.getAccountInfo()) != null && (saasPrivacyMode = accountInfo.getSaasPrivacyMode()) != null) {
                    z = saasPrivacyMode.booleanValue();
                }
                accountFragment2.applyEnterprisePrivacyMode(z);
            }
        }
    }
}
