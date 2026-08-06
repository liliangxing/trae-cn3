package com.bytedance.trae.home.solo.setting.data;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.home.solo.setting.data.model.PayIdentity;
import com.bytedance.trae.home.solo.setting.data.model.PayStatusResponseDto;
import com.bytedance.trae.kmp.host.KmpHostInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: PayRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.setting.data.DefaultPayRepository$refresh$2", f = "PayRepository.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class DefaultPayRepository$refresh$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DefaultPayRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultPayRepository$refresh$2(DefaultPayRepository defaultPayRepository, Continuation<? super DefaultPayRepository$refresh$2> continuation) {
        super(2, continuation);
        this.this$0 = defaultPayRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultPayRepository$refresh$2 = new DefaultPayRepository$refresh$2(this.this$0, continuation);
        defaultPayRepository$refresh$2.L$0 = obj;
        return defaultPayRepository$refresh$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        MutableStateFlow mutableStateFlow;
        KmpHostInfo kmpHostInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                kmpHostInfo = this.this$0.hostInfo;
                if (!kmpHostInfo.isPublicCloud()) {
                    return Unit.INSTANCE;
                }
                DefaultPayRepository defaultPayRepository = this.this$0;
                Result.Companion companion = Result.Companion;
                this.label = 1;
                obj = defaultPayRepository.fetchPayStatus(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            obj2 = Result.constructor-impl((PayStatusResponseDto) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj2)) {
            obj2 = null;
        }
        PayStatusResponseDto payStatusResponseDto = (PayStatusResponseDto) obj2;
        if (payStatusResponseDto == null) {
            return Unit.INSTANCE;
        }
        String effectiveUserPayIdentityStr = payStatusResponseDto.getEffectiveUserPayIdentityStr();
        String obj3 = effectiveUserPayIdentityStr != null ? StringsKt.trim(effectiveUserPayIdentityStr).toString() : null;
        if (obj3 == null) {
            obj3 = "";
        }
        String str = obj3;
        if (str.length() == 0) {
            str = "Free";
        }
        mutableStateFlow = this.this$0._payIdentity;
        mutableStateFlow.setValue(new PayIdentity(str));
        return Unit.INSTANCE;
    }
}
