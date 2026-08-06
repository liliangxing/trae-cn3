package com.bytedance.trae.conversation.ideproject;

import com.bytedance.trae.conversation.network.IGetProjectApi;
import com.bytedance.trae.conversation.network.ListProjectsData;
import com.bytedance.trae.conversation.network.ProjectItem;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IDEProjectBottomSheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.ideproject.IDEProjectBottomSheet$fetchProjects$1", f = "IDEProjectBottomSheet.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IDEProjectBottomSheet$fetchProjects$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cliId;
    int label;
    final /* synthetic */ IDEProjectBottomSheet this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IDEProjectBottomSheet$fetchProjects$1(IDEProjectBottomSheet iDEProjectBottomSheet, String str, Continuation<? super IDEProjectBottomSheet$fetchProjects$1> continuation) {
        super(2, continuation);
        this.this$0 = iDEProjectBottomSheet;
        this.$cliId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IDEProjectBottomSheet$fetchProjects$1(this.this$0, this.$cliId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ListProjectsData listProjectsData;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        List<ProjectItem> list = null;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = IGetProjectApi.Companion.safeCall$default(IGetProjectApi.INSTANCE, null, new IDEProjectBottomSheet$fetchProjects$1$result$1(this.$cliId, null), (Continuation) this, 1, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        HttpDataResult.Success success = (HttpDataResult) obj;
        if (!this.this$0.isAdded()) {
            return Unit.INSTANCE;
        }
        if (success instanceof HttpDataResult.Success) {
            IDEProjectListPolicy iDEProjectListPolicy = IDEProjectListPolicy.INSTANCE;
            BizResponse bizResp = success.getBizResp();
            if (bizResp != null && (listProjectsData = (ListProjectsData) bizResp.getData()) != null) {
                list = listProjectsData.getProjects();
            }
            if (list == null) {
                list = CollectionsKt.emptyList();
            }
            List<ProjectItem> visibleProjects = iDEProjectListPolicy.visibleProjects(list);
            if (visibleProjects.isEmpty()) {
                this.this$0.showEmpty();
            } else {
                this.this$0.showContent(visibleProjects);
            }
        } else if (success instanceof HttpDataResult.Error) {
            this.this$0.showEmpty();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}
