package com.bytedance.trae.conversation.skill;

import com.bytedance.trae.conversation.network.IGetSkillListApi;
import com.bytedance.trae.conversation.network.ListSkillsData;
import com.bytedance.trae.conversation.network.RemoteResponse;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: SkillsViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/network/RemoteResponse;", "Lcom/bytedance/trae/conversation/network/ListSkillsData;", "Lcom/bytedance/trae/conversation/network/IGetSkillListApi;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.skill.SkillsViewModel$fetchSkills$1$result$1", f = "SkillsViewModel.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
final class SkillsViewModel$fetchSkills$1$result$1 extends SuspendLambda implements Function2<IGetSkillListApi, Continuation<? super RemoteResponse<ListSkillsData>>, Object> {
    final /* synthetic */ Map<String, String> $query;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SkillsViewModel$fetchSkills$1$result$1(Map<String, String> map, Continuation<? super SkillsViewModel$fetchSkills$1$result$1> continuation) {
        super(2, continuation);
        this.$query = map;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> skillsViewModel$fetchSkills$1$result$1 = new SkillsViewModel$fetchSkills$1$result$1(this.$query, continuation);
        skillsViewModel$fetchSkills$1$result$1.L$0 = obj;
        return skillsViewModel$fetchSkills$1$result$1;
    }

    public final Object invoke(IGetSkillListApi iGetSkillListApi, Continuation<? super RemoteResponse<ListSkillsData>> continuation) {
        return create(iGetSkillListApi, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ((IGetSkillListApi) this.L$0).listSkills(this.$query, (Continuation) this);
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
