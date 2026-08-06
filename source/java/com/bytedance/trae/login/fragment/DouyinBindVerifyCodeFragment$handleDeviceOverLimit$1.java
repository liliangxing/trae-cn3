package com.bytedance.trae.login.fragment;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.trae.login.C0820R;
import com.bytedance.trae.login.activity.DouyinBindPhoneActivity;
import com.bytedance.trae.login.databinding.TraeFragmentDouyinBindVerifyCodeBinding;
import com.bytedance.trae.login.tracker.LoginTracker;
import com.bytedance.trae.login.traeauth.ListDevicesResult;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
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
/* compiled from: DouyinBindVerifyCodeFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1", f = "DouyinBindVerifyCodeFragment.kt", i = {}, l = {390}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isNewUser;
    int label;
    final /* synthetic */ DouyinBindVerifyCodeFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, boolean z, Continuation<? super DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1> continuation) {
        super(2, continuation);
        this.this$0 = douyinBindVerifyCodeFragment;
        this.$isNewUser = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1(this.this$0, this.$isNewUser, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object withContext;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                withContext = BuildersKt.withContext(Dispatchers.getIO(), new DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$result$1(null), (Continuation) this);
                if (withContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                withContext = obj;
            }
            final ListDevicesResult listDevicesResult = (ListDevicesResult) withContext;
            final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment = this.this$0;
            final boolean z = this.$isNewUser;
            douyinBindVerifyCodeFragment.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2, Object obj3) {
                    Unit invokeSuspend$lambda$1;
                    invokeSuspend$lambda$1 = DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1.invokeSuspend$lambda$1(DouyinBindVerifyCodeFragment.this, listDevicesResult, z, (DouyinBindPhoneActivity) obj2, (TraeFragmentDouyinBindVerifyCodeBinding) obj3);
                    return invokeSuspend$lambda$1;
                }
            });
            return Unit.INSTANCE;
        } catch (Throwable th) {
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_DOUYIN_BIND_DEVICE_LIMIT, "douyin", null, "device_limit_list", null, th.getMessage(), null, null, null, SccResult.MESSAGE_FAIL, "device_limit_list", 468, null);
            LoginTracker.trackDouyinBindPhoneResult$default(LoginTracker.INSTANCE, false, "device_limit_list", null, th.getMessage(), 4, null);
            final DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment2 = this.this$0;
            douyinBindVerifyCodeFragment2.runOnHost(new Function2() { // from class: com.bytedance.trae.login.fragment.DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2, Object obj3) {
                    Unit invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = DouyinBindVerifyCodeFragment$handleDeviceOverLimit$1.invokeSuspend$lambda$0(DouyinBindVerifyCodeFragment.this, th, (DouyinBindPhoneActivity) obj2, (TraeFragmentDouyinBindVerifyCodeBinding) obj3);
                    return invokeSuspend$lambda$0;
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit invokeSuspend$lambda$0(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, Throwable th, DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        douyinBindVerifyCodeFragment.isSubmitting = false;
        douyinBindPhoneActivity.setBindLoading(false);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setEnabled(true);
        Context context = (Context) douyinBindPhoneActivity;
        String message = th.getMessage();
        if (message == null) {
            message = douyinBindVerifyCodeFragment.getString(C0820R.string.trae_douyin_bind_device_limit);
            Intrinsics.checkNotNullExpressionValue(message, "getString(...)");
        }
        Toast.makeText(context, message, 0).show();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(DouyinBindVerifyCodeFragment douyinBindVerifyCodeFragment, ListDevicesResult listDevicesResult, boolean z, DouyinBindPhoneActivity douyinBindPhoneActivity, TraeFragmentDouyinBindVerifyCodeBinding traeFragmentDouyinBindVerifyCodeBinding) {
        douyinBindPhoneActivity.setBindLoading(false);
        traeFragmentDouyinBindVerifyCodeBinding.verifyCodeInput.setEnabled(true);
        douyinBindVerifyCodeFragment.showDeviceOverLimitDialog(douyinBindPhoneActivity, listDevicesResult, z);
        return Unit.INSTANCE;
    }
}
