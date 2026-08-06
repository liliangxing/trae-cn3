package com.bytedance.trae.login.fragment;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.login.fragment.VerifyCodeViewModel;
import com.bytedance.trae.login.traeauth.ListDevicesResult;
import com.bytedance.trae.login.traeauth.TraeAuthException;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* compiled from: VerifyCodeViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.fragment.VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1", f = "VerifyCodeViewModel.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $extras;
    int label;
    final /* synthetic */ VerifyCodeViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1(VerifyCodeViewModel verifyCodeViewModel, Map<String, ? extends Object> map, Continuation<? super VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1> continuation) {
        super(2, continuation);
        this.this$0 = verifyCodeViewModel;
        this.$extras = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1(this.this$0, this.$extras, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        MutableLiveData mutableLiveData3;
        Object withContext;
        MutableLiveData mutableLiveData4;
        MutableLiveData mutableLiveData5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                withContext = BuildersKt.withContext(Dispatchers.getIO(), new VerifyCodeViewModel$submitCode$1$onDeviceOverLimit$1$result$1(null), (Continuation) this);
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
            mutableLiveData4 = this.this$0._loginExtras;
            mutableLiveData4.setValue(this.$extras);
            mutableLiveData5 = this.this$0._loginState;
            mutableLiveData5.setValue(new VerifyCodeViewModel.LoginState.DeviceOverLimit((ListDevicesResult) withContext));
        } catch (Throwable th) {
            IApplog.Companion companion = IApplog.Companion;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ISignalReportConstants.KEY_REASON, "device_over_limit_list_failed");
            jSONObject.put("login_platform", TraeAuthManager.PLATFORM_PHONE);
            Unit unit = Unit.INSTANCE;
            companion.reportEvent("icube_login_failure", jSONObject);
            if (th instanceof TraeAuthException) {
                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, "list_device", TraeAuthManager.PLATFORM_PHONE, null, null, null, "list_device_error", null, th.getHttpCode(), null, null, null, 1872, null);
            } else {
                TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, "list_device", TraeAuthManager.PLATFORM_PHONE, null, null, "-1", "list_device_error", null, null, null, null, null, 1984, null);
            }
            mutableLiveData = this.this$0._loginState;
            mutableLiveData.postValue(new VerifyCodeViewModel.LoginState.Error(-1, ""));
            this.this$0.clearCodeInput();
            mutableLiveData2 = this.this$0._countdownSeconds;
            Integer num = (Integer) mutableLiveData2.getValue();
            boolean z = num != null && num.intValue() == 0;
            mutableLiveData3 = this.this$0._isResendEnabled;
            mutableLiveData3.postValue(Boxing.boxBoolean(z));
        }
        return Unit.INSTANCE;
    }
}
