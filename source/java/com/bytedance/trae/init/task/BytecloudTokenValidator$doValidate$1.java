package com.bytedance.trae.init.task;

import com.bytedance.trae.conversation.network.ThirdPartyTokenException;
import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.concurrent.atomic.AtomicBoolean;
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
/* compiled from: BytecloudTokenValidator.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.init.task.BytecloudTokenValidator$doValidate$1", f = "BytecloudTokenValidator.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BytecloudTokenValidator$doValidate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BytecloudTokenValidator$doValidate$1(Continuation<? super BytecloudTokenValidator$doValidate$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BytecloudTokenValidator$doValidate$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        int extractHttpStatusCode;
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        AtomicBoolean atomicBoolean3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    FLogger.INSTANCE.i("BytecloudTokenValidator", "doValidate: calling GetThirdPartyToken(bytecloud)");
                    this.label = 1;
                    if (ThirdPartyTokenRepository.INSTANCE.getThirdPartyToken(ThirdPartyTokenRepository.TYPE_BYTECLOUD, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                FLogger.INSTANCE.i("BytecloudTokenValidator", "doValidate: success, bytecloud token valid");
                BytecloudTokenValidator.INSTANCE.saveLastCheckAt(System.currentTimeMillis());
            } catch (ThirdPartyTokenException.HttpError e) {
                FLogger.INSTANCE.e("BytecloudTokenValidator", "doValidate: http error status=" + e.getStatusCode());
                if (e.getStatusCode() == 401) {
                    BytecloudTokenValidator.INSTANCE.handleUnauthorizedSession(null);
                }
            } catch (ThirdPartyTokenException.ServerError e2) {
                FLogger.INSTANCE.e("BytecloudTokenValidator", "doValidate: server error code=" + e2.getCode() + ", msg=" + e2.getServerMessage());
                if (Intrinsics.areEqual(e2.getCode(), "20330") || e2.getStatusCode() == 401) {
                    BytecloudTokenValidator.INSTANCE.handleUnauthorizedSession(e2.getServerMessage());
                }
            } catch (Exception e3) {
                extractHttpStatusCode = BytecloudTokenValidator.INSTANCE.extractHttpStatusCode(e3);
                if (extractHttpStatusCode == 401) {
                    BytecloudTokenValidator.INSTANCE.handleUnauthorizedSession(null);
                    Unit unit = Unit.INSTANCE;
                    atomicBoolean = BytecloudTokenValidator.validating;
                    atomicBoolean.set(false);
                    return unit;
                }
                FLogger.INSTANCE.w("BytecloudTokenValidator", "doValidate: exception (ignored): " + e3.getMessage());
            }
            atomicBoolean3 = BytecloudTokenValidator.validating;
            atomicBoolean3.set(false);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            atomicBoolean2 = BytecloudTokenValidator.validating;
            atomicBoolean2.set(false);
            throw th;
        }
    }
}
