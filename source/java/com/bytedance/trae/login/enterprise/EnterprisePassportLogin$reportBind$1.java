package com.bytedance.trae.login.enterprise;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.login.enterprise.EnterprisePassportLogin;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnterprisePassportLogin.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterprisePassportLogin$reportBind$1", f = "EnterprisePassportLogin.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterprisePassportLogin$reportBind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnterprisePassportLogin$reportBind$1(Continuation<? super EnterprisePassportLogin$reportBind$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EnterprisePassportLogin$reportBind$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object bindPassportUserId;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = false;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String jwtToken = TraeAuthStorage.INSTANCE.getJwtToken();
                if (jwtToken.length() == 0) {
                    FLogger.INSTANCE.mo426e("EnterprisePassportLogin", "reportBind: cloudideToken is empty, skip");
                    return Unit.INSTANCE;
                }
                Map mapOf = MapsKt.mapOf(TuplesKt.to("X-Cloudide-Token", jwtToken));
                this.label = 1;
                bindPassportUserId = ((EnterprisePassportLogin.EnterprisePassportBindApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "enterprise_passport_bind", EnterprisePassportLogin.EnterprisePassportBindApi.class, null, EnterpriseLoginConfig.INSTANCE.getBaseUrl(), mapOf, true, 4, null)).bindPassportUserId((Continuation) this);
                if (bindPassportUserId == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                bindPassportUserId = obj;
            }
            SsResponse ssResponse = (SsResponse) bindPassportUserId;
            int code = ssResponse != null ? ssResponse.code() : -1;
            if (200 <= code && code < 300) {
                z = true;
            }
            if (z) {
                FLogger.INSTANCE.mo428i("EnterprisePassportLogin", "reportBind: success, httpCode=" + code);
            } else {
                FLogger.INSTANCE.mo426e("EnterprisePassportLogin", "reportBind: failed, httpCode=" + code);
            }
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e("EnterprisePassportLogin", "reportBind: exception=" + e.getMessage());
        }
        return Unit.INSTANCE;
    }
}
