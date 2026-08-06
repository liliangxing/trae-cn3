package com.bytedance.trae.conversation;

import com.bytedance.trae.im.service.CliListSource;
import com.bytedance.trae.im.service.CliMutationResponse;
import com.bytedance.trae.im.service.ListClisResponse;
import com.bytedance.trae.im.service.OnboardingStateResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: CliListRepository.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H¦@¢\u0006\u0002\u0010\nJ$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u0006\u0010\r\u001a\u00020\u000eH¦@¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/CliListService;", "", "listClis", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/ListClisResponse;", "source", "Lcom/bytedance/trae/im/service/CliListSource;", "(Lcom/bytedance/trae/im/service/CliListSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnboardingState", "Lcom/bytedance/trae/im/service/OnboardingStateResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameCli", "Lcom/bytedance/trae/im/service/CliMutationResponse;", "cliId", "", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterCli", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CliListService {
    Object getOnboardingState(Continuation<? super HttpDataResult<OnboardingStateResponse>> continuation);

    Object listClis(CliListSource cliListSource, Continuation<? super HttpDataResult<ListClisResponse>> continuation);

    Object renameCli(String str, String str2, Continuation<? super HttpDataResult<CliMutationResponse>> continuation);

    Object unregisterCli(String str, Continuation<? super HttpDataResult<CliMutationResponse>> continuation);
}
