package com.bytedance.trae.login.bytecloud;

import com.bytedance.memory.shrink.HprofMemoryConstants;
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

/* compiled from: BytecloudAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.bytecloud.BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$enableSso$1", f = "BytecloudAuthManager.kt", i = {}, l = {HprofMemoryConstants.HPROF_HEAPDUMP_ROOT_VM_INTERNAL}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.login.bytecloud.BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$enableSso$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class C0828x76103e2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $regionIndex;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0828x76103e2(int i, Continuation<? super C0828x76103e2> continuation) {
        super(2, continuation);
        this.$regionIndex = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0828x76103e2(this.$regionIndex, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            BytecloudAuthManager bytecloudAuthManager = BytecloudAuthManager.INSTANCE;
            list = BytecloudAuthManager.ENABLE_SSO_HOSTS;
            this.label = 1;
            obj = bytecloudAuthManager.fetchEnableSsoFromHost((String) list.get(this.$regionIndex), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
