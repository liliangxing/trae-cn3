package coil3.network.bytedance.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: utils.common.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcoil3/network/bytedance/internal/CoilInterceptor;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 0}, xi = 48)
@DebugMetadata(c = "coil3.network.bytedance.internal.Utils_commonKt$getAllInterceptors$provideInterceptors$1", f = "utils.common.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
final class Utils_commonKt$getAllInterceptors$provideInterceptors$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends CoilInterceptor>>, Object> {
    final /* synthetic */ ICoilInterceptorProvider $service;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Utils_commonKt$getAllInterceptors$provideInterceptors$1(ICoilInterceptorProvider iCoilInterceptorProvider, Continuation<? super Utils_commonKt$getAllInterceptors$provideInterceptors$1> continuation) {
        super(2, continuation);
        this.$service = iCoilInterceptorProvider;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Utils_commonKt$getAllInterceptors$provideInterceptors$1(this.$service, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends CoilInterceptor>> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return this.$service.providerInterceptors();
    }
}
