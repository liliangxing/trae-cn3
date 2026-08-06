package com.bytedance.trae.login.bytecloud;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BytecloudAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.bytecloud.BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1", f = "BytecloudAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $regionIndex;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1(int i, Continuation<? super BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1> continuation) {
        super(2, continuation);
        this.$regionIndex = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BytecloudAuthManager$checkBytedanceNetwork$3$result$1$1$ping$1(this.$regionIndex, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List list;
        boolean checkSingleUrl;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        BytecloudAuthManager bytecloudAuthManager = BytecloudAuthManager.INSTANCE;
        list = BytecloudAuthManager.INTERNAL_CHECK_LIST;
        checkSingleUrl = bytecloudAuthManager.checkSingleUrl((String) list.get(this.$regionIndex));
        return Boxing.boxBoolean(checkSingleUrl);
    }
}
