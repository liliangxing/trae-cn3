package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.GitBatchDiffRequest;
import com.bytedance.trae.im.service.GitBatchDiffResponse;
import com.bytedance.trae.im.service.IGitBatchDiffApi;
import com.bytedance.trae.network.response.BizResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: MergeDiffManager.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/network/response/BizResponse;", "Lcom/bytedance/trae/im/service/GitBatchDiffResponse;", "Lcom/bytedance/trae/im/service/IGitBatchDiffApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.MergeDiffManager$fetchMergeDiffs$batchResult$1", f = "MergeDiffManager.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class MergeDiffManager$fetchMergeDiffs$batchResult$1 extends SuspendLambda implements Function2<IGitBatchDiffApi, Continuation<? super BizResponse<GitBatchDiffResponse>>, Object> {
    final /* synthetic */ String $baseRef;
    final /* synthetic */ List<String> $filePaths;
    final /* synthetic */ String $headRef;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MergeDiffManager$fetchMergeDiffs$batchResult$1(String str, String str2, List<String> list, Continuation<? super MergeDiffManager$fetchMergeDiffs$batchResult$1> continuation) {
        super(2, continuation);
        this.$baseRef = str;
        this.$headRef = str2;
        this.$filePaths = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> mergeDiffManager$fetchMergeDiffs$batchResult$1 = new MergeDiffManager$fetchMergeDiffs$batchResult$1(this.$baseRef, this.$headRef, this.$filePaths, continuation);
        mergeDiffManager$fetchMergeDiffs$batchResult$1.L$0 = obj;
        return mergeDiffManager$fetchMergeDiffs$batchResult$1;
    }

    public final Object invoke(IGitBatchDiffApi iGitBatchDiffApi, Continuation<? super BizResponse<GitBatchDiffResponse>> continuation) {
        return create(iGitBatchDiffApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            IGitBatchDiffApi iGitBatchDiffApi = (IGitBatchDiffApi) this.L$0;
            String str = this.$baseRef;
            String str2 = this.$headRef;
            List<String> list = this.$filePaths;
            if (list.isEmpty()) {
                list = null;
            }
            this.label = 1;
            obj = iGitBatchDiffApi.batchDiff(new GitBatchDiffRequest(str, str2, list), (Continuation) this);
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
