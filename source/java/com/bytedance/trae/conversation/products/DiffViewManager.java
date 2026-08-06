package com.bytedance.trae.conversation.products;

import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.DiffViewResponse;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.im.service.IDiffViewApi;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.response.HttpDataResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* compiled from: DiffViewManager.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/DiffViewManager;", "", "<init>", "()V", "fetchDiffView", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/im/service/DiffViewResponse;", "cliType", "", "chatSessionId", "turnId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DiffViewManager {
    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchDiffView(String str, String str2, String str3, Continuation<? super HttpDataResult<DiffViewResponse>> continuation) {
        DiffViewManager$fetchDiffView$1 diffViewManager$fetchDiffView$1;
        int i;
        HttpDataResult.Success success;
        if (continuation instanceof DiffViewManager$fetchDiffView$1) {
            diffViewManager$fetchDiffView$1 = (DiffViewManager$fetchDiffView$1) continuation;
            if ((diffViewManager$fetchDiffView$1.label & Integer.MIN_VALUE) != 0) {
                diffViewManager$fetchDiffView$1.label -= Integer.MIN_VALUE;
                Object obj = diffViewManager$fetchDiffView$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = diffViewManager$fetchDiffView$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    IChatSessionApi.Companion companion = IChatSessionApi.INSTANCE;
                    diffViewManager$fetchDiffView$1.L$0 = str2;
                    diffViewManager$fetchDiffView$1.L$1 = str3;
                    diffViewManager$fetchDiffView$1.label = 1;
                    obj = companion.getChatSessionRawCall(str2, diffViewManager$fetchDiffView$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i == 2) {
                            ResultKt.throwOnFailure(obj);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    str3 = (String) diffViewManager$fetchDiffView$1.L$1;
                    str2 = (String) diffViewManager$fetchDiffView$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                success = (HttpDataResult) obj;
                if (!(success instanceof HttpDataResult.Success)) {
                    ChatSessionResponse chatSessionResponse = (ChatSessionResponse) success.getBizResp().getData();
                    String explorerUrl = chatSessionResponse != null ? chatSessionResponse.getExplorerUrl() : null;
                    if (explorerUrl == null) {
                        return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "explorer_url is null", new Exception("explorer_url is null"), (String) null, 8, (DefaultConstructorMarker) null);
                    }
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = "turn-" + str3 + ".json";
                    String str4 = StringsKt.trimEnd(explorerUrl, new char[]{'/'}) + '/';
                    ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                    String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
                    if (xTToken == null) {
                        xTToken = "";
                    }
                    Map<String, String> mutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("authorization", "Cloud-IDE-JWT " + xTToken)});
                    IDiffViewApi.Companion companion2 = IDiffViewApi.INSTANCE;
                    DiffViewManager$fetchDiffView$2 diffViewManager$fetchDiffView$2 = new DiffViewManager$fetchDiffView$2(objectRef, str2, null);
                    diffViewManager$fetchDiffView$1.L$0 = null;
                    diffViewManager$fetchDiffView$1.L$1 = null;
                    diffViewManager$fetchDiffView$1.label = 2;
                    obj = companion2.safeCall(str4, mutableMapOf, diffViewManager$fetchDiffView$2, diffViewManager$fetchDiffView$1);
                    return obj == coroutine_suspended ? coroutine_suspended : obj;
                }
                if (success instanceof HttpDataResult.Error) {
                    return success;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        diffViewManager$fetchDiffView$1 = new DiffViewManager$fetchDiffView$1(this, continuation);
        Object obj2 = diffViewManager$fetchDiffView$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = diffViewManager$fetchDiffView$1.label;
        if (i != 0) {
        }
        success = (HttpDataResult) obj2;
        if (!(success instanceof HttpDataResult.Success)) {
        }
    }
}
