package com.bytedance.trae.home.solo.setting;

import androidx.appcompat.widget.SwitchCompat;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
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
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.AccountFragment$fetchPrivacyModeStatus$1", f = "AccountFragment.kt", i = {}, l = {517}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AccountFragment$fetchPrivacyModeStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AccountFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountFragment$fetchPrivacyModeStatus$1(AccountFragment accountFragment, Continuation<? super AccountFragment$fetchPrivacyModeStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = accountFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountFragment$fetchPrivacyModeStatus$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0061, code lost:
    
        if (r5 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        r4.this$0.applyEditablePrivacyMode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x008c, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0087, code lost:
    
        if (r5 != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean isEnterpriseLogin;
        boolean isEnterpriseLogin2;
        boolean isEnterpriseLogin3;
        boolean isEnterpriseLogin4;
        SwitchCompat switchCompat;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.isSwitching = true;
                this.label = 1;
                obj = IPrivacyModeApi.INSTANCE.query((Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PrivacyModeQueryResponse privacyModeQueryResponse = (PrivacyModeQueryResponse) obj;
            isEnterpriseLogin3 = this.this$0.isEnterpriseLogin();
            if (!isEnterpriseLogin3) {
                switchCompat = this.this$0.switchPrivacyMode;
                if (switchCompat == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("switchPrivacyMode");
                    switchCompat = null;
                }
                switchCompat.setChecked(Intrinsics.areEqual(privacyModeQueryResponse.getPrivacyStatus(), "open"));
            }
            this.this$0.isSwitching = false;
            isEnterpriseLogin4 = this.this$0.isEnterpriseLogin();
        } catch (Exception unused) {
            this.this$0.isSwitching = false;
            isEnterpriseLogin2 = this.this$0.isEnterpriseLogin();
        } catch (Throwable th) {
            this.this$0.isSwitching = false;
            isEnterpriseLogin = this.this$0.isEnterpriseLogin();
            if (!isEnterpriseLogin) {
                this.this$0.applyEditablePrivacyMode();
            }
            throw th;
        }
    }
}
