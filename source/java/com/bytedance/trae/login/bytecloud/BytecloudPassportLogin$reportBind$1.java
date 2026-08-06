package com.bytedance.trae.login.bytecloud;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.trae.login.bytecloud.BytecloudPassportLogin;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
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
/* compiled from: BytecloudPassportLogin.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.bytecloud.BytecloudPassportLogin$reportBind$1", f = "BytecloudPassportLogin.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BytecloudPassportLogin$reportBind$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BytecloudPassportLogin$reportBind$1(Continuation<? super BytecloudPassportLogin$reportBind$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BytecloudPassportLogin$reportBind$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object bind;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = false;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String jwtToken = TraeAuthStorage.INSTANCE.getJwtToken();
                if (jwtToken.length() == 0) {
                    FLogger.INSTANCE.mo426e("BytecloudPassportLogin", "reportBind: cloudideToken is empty, skip");
                    return Unit.INSTANCE;
                }
                Map mapOf = MapsKt.mapOf(TuplesKt.to("X-Cloudide-Token", jwtToken));
                this.label = 1;
                bind = ((BytecloudPassportLogin.PassportBindApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "passport_bind", BytecloudPassportLogin.PassportBindApi.class, null, HostResolver.INSTANCE.getBaseUrl(HostType.ONLINE), mapOf, true, 4, null)).bind((Continuation) this);
                if (bind == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                bind = obj;
            }
            SsResponse ssResponse = (SsResponse) bind;
            int code = ssResponse != null ? ssResponse.code() : -1;
            if (200 <= code && code < 300) {
                z = true;
            }
            if (z) {
                FLogger.INSTANCE.mo428i("BytecloudPassportLogin", "reportBind: success, httpCode=" + code);
            } else {
                FLogger.INSTANCE.mo426e("BytecloudPassportLogin", "reportBind: failed, httpCode=" + code);
            }
        } catch (Exception e) {
            FLogger.INSTANCE.mo426e("BytecloudPassportLogin", "reportBind: exception=" + e.getMessage());
        }
        return Unit.INSTANCE;
    }
}
