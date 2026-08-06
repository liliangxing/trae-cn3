package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: SiteMessageRepository.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository$updateStatus$1", f = "SiteMessageRepository.kt", i = {}, l = {108}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class SiteMessageRepository$updateStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $action;
    final /* synthetic */ List<Integer> $ids;
    final /* synthetic */ Function0<Unit> $onFailure;
    final /* synthetic */ Function0<Unit> $onSuccess;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SiteMessageRepository$updateStatus$1(List<Integer> list, String str, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super SiteMessageRepository$updateStatus$1> continuation) {
        super(2, continuation);
        this.$ids = list;
        this.$action = str;
        this.$onSuccess = function0;
        this.$onFailure = function02;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SiteMessageRepository$updateStatus$1(this.$ids, this.$action, this.$onSuccess, this.$onFailure, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (ISiteMessageApi.INSTANCE.createService().updateStatus(new SiteMessageUpdateStatusBody(this.$ids, this.$action, null, null, null, null, 60, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Function0<Unit> function0 = this.$onSuccess;
            if (function0 != null) {
                function0.invoke();
            }
        } catch (Exception unused) {
            Function0<Unit> function02 = this.$onFailure;
            if (function02 != null) {
                function02.invoke();
            }
        }
        return Unit.INSTANCE;
    }
}
