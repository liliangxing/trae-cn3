package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.network.response.HttpDataResult;
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
/* compiled from: DiffViewActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.DiffViewActivity$loadDiffView$1", f = "DiffViewActivity.kt", i = {}, l = {160, 162, 169}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DiffViewActivity$loadDiffView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ String $cliType;
    final /* synthetic */ String $taskName;
    final /* synthetic */ String $turnId;
    int label;
    final /* synthetic */ DiffViewActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiffViewActivity$loadDiffView$1(String str, String str2, DiffViewActivity diffViewActivity, String str3, String str4, Continuation<? super DiffViewActivity$loadDiffView$1> continuation) {
        super(2, continuation);
        this.$cliType = str;
        this.$turnId = str2;
        this.this$0 = diffViewActivity;
        this.$taskName = str3;
        this.$chatSessionId = str4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiffViewActivity$loadDiffView$1(this.$cliType, this.$turnId, this.this$0, this.$taskName, this.$chatSessionId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String str;
        Object loadDiffFromUrl;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!Intrinsics.areEqual(this.$cliType, CliType.REMOTE.getValue())) {
                String str2 = "diffview/turn-" + this.$turnId + ".json";
                this.label = 1;
                obj = this.this$0.fetchDownloadUrlWithRetry(str2, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = (String) obj;
                if (str == null) {
                }
            } else {
                this.label = 3;
                obj = new DiffViewManager().fetchDiffView(this.$cliType, this.$chatSessionId, this.$turnId, (Continuation) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.this$0.handleDiffViewResult((HttpDataResult) obj, this.$taskName);
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            str = (String) obj;
            if (str == null) {
                this.label = 2;
                loadDiffFromUrl = this.this$0.loadDiffFromUrl(str, this.$cliType, this.$taskName, (Continuation) this);
                if (loadDiffFromUrl == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                this.this$0.showDiffError();
            }
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.handleDiffViewResult((HttpDataResult) obj, this.$taskName);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
