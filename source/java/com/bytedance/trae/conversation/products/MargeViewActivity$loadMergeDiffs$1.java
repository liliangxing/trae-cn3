package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.model.MergeChangedFilesData;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MargeViewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MargeViewActivity$loadMergeDiffs$1", f = "MargeViewActivity.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MargeViewActivity$loadMergeDiffs$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ MergeChangedFilesData $mergeData;
    final /* synthetic */ String $taskName;
    int label;
    final /* synthetic */ MargeViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MargeViewActivity$loadMergeDiffs$1(String str, MergeChangedFilesData mergeChangedFilesData, String str2, MargeViewActivity margeViewActivity, Continuation<? super MargeViewActivity$loadMergeDiffs$1> continuation) {
        super(2, continuation);
        this.$chatSessionId = str;
        this.$mergeData = mergeChangedFilesData;
        this.$taskName = str2;
        this.this$0 = margeViewActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MargeViewActivity$loadMergeDiffs$1(this.$chatSessionId, this.$mergeData, this.$taskName, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = new MergeDiffManager().fetchMergeDiffs(this.$chatSessionId, this.$mergeData, this.$taskName, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.handleResult(this.$chatSessionId, this.$mergeData, this.$taskName, (HttpDataResult) obj);
        return Unit.INSTANCE;
    }
}
