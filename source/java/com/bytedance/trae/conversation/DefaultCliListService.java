package com.bytedance.trae.conversation;

import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.trae.im.service.CliListSource;
import com.bytedance.trae.im.service.CliMutationResponse;
import com.bytedance.trae.im.service.IListClisService;
import com.bytedance.trae.im.service.ListClisResponse;
import com.bytedance.trae.im.service.OnboardingStateResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CliListRepository.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H\u0096@¢\u0006\u0002\u0010\fJ$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/DefaultCliListService;", "Lcom/bytedance/trae/conversation/CliListService;", "<init>", "()V", "listClis", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/ListClisResponse;", TimonPipeline.KEY_SOURCE, "Lcom/bytedance/trae/im/service/CliListSource;", "(Lcom/bytedance/trae/im/service/CliListSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOnboardingState", "Lcom/bytedance/trae/im/service/OnboardingStateResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "renameCli", "Lcom/bytedance/trae/im/service/CliMutationResponse;", "cliId", "", "name", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregisterCli", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DefaultCliListService implements CliListService {
    public static final DefaultCliListService INSTANCE = new DefaultCliListService();

    private DefaultCliListService() {
    }

    @Override // com.bytedance.trae.conversation.CliListService
    public Object listClis(CliListSource cliListSource, Continuation<? super HttpDataResult<ListClisResponse>> continuation) {
        return IListClisService.INSTANCE.safeCall(new DefaultCliListService$listClis$2(cliListSource, null), continuation);
    }

    @Override // com.bytedance.trae.conversation.CliListService
    public Object getOnboardingState(Continuation<? super HttpDataResult<OnboardingStateResponse>> continuation) {
        return IListClisService.INSTANCE.safeCall(new DefaultCliListService$getOnboardingState$2(null), continuation);
    }

    @Override // com.bytedance.trae.conversation.CliListService
    public Object renameCli(String str, String str2, Continuation<? super HttpDataResult<CliMutationResponse>> continuation) {
        return IListClisService.INSTANCE.safeCall(new DefaultCliListService$renameCli$2(str, str2, null), continuation);
    }

    @Override // com.bytedance.trae.conversation.CliListService
    public Object unregisterCli(String str, Continuation<? super HttpDataResult<CliMutationResponse>> continuation) {
        return IListClisService.INSTANCE.safeCall(new DefaultCliListService$unregisterCli$2(str, null), continuation);
    }
}
