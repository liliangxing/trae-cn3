package com.bytedance.trae.conversation.products;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.sdk.account.api.AccountErrorCode;
import com.bytedance.trae.im.service.ChatSessionResponse;
import com.bytedance.trae.im.service.IChatSessionApi;
import com.bytedance.trae.login.api.ILoginService;
import com.bytedance.trae.network.TraeHttpConnection;
import com.bytedance.trae.network.response.BizResponse;
import com.bytedance.trae.network.response.HttpDataResult;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* compiled from: ArtifactListManager.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0086@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/products/ArtifactListManager;", "", "<init>", "()V", "fetchArtifactList", "Lcom/bytedance/trae/network/response/HttpDataResult;", "Lcom/bytedance/trae/conversation/products/ArtifactListResponse;", "cliType", "", "chatSessionId", "turnId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ArtifactListManager {
    /* JADX WARN: Removed duplicated region for block: B:14:0x012d A[Catch: all -> 0x0039, CancellationException -> 0x003d, TryCatch #2 {CancellationException -> 0x003d, all -> 0x0039, blocks: (B:11:0x0034, B:12:0x0129, B:14:0x012d, B:16:0x0137, B:19:0x0153, B:39:0x0108), top: B:7:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0137 A[Catch: all -> 0x0039, CancellationException -> 0x003d, TryCatch #2 {CancellationException -> 0x003d, all -> 0x0039, blocks: (B:11:0x0034, B:12:0x0129, B:14:0x012d, B:16:0x0137, B:19:0x0153, B:39:0x0108), top: B:7:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0153 A[Catch: all -> 0x0039, CancellationException -> 0x003d, TRY_LEAVE, TryCatch #2 {CancellationException -> 0x003d, all -> 0x0039, blocks: (B:11:0x0034, B:12:0x0129, B:14:0x012d, B:16:0x0137, B:19:0x0153, B:39:0x0108), top: B:7:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchArtifactList(String str, String str2, String str3, Continuation<? super HttpDataResult<ArtifactListResponse>> continuation) {
        ArtifactListManager$fetchArtifactList$1 artifactListManager$fetchArtifactList$1;
        int i;
        String str4;
        HttpDataResult.Success success;
        String str5;
        String str6 = str2;
        try {
            if (continuation instanceof ArtifactListManager$fetchArtifactList$1) {
                artifactListManager$fetchArtifactList$1 = (ArtifactListManager$fetchArtifactList$1) continuation;
                if ((artifactListManager$fetchArtifactList$1.label & Integer.MIN_VALUE) != 0) {
                    artifactListManager$fetchArtifactList$1.label -= Integer.MIN_VALUE;
                    Object obj = artifactListManager$fetchArtifactList$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = artifactListManager$fetchArtifactList$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        IChatSessionApi.Companion companion = IChatSessionApi.INSTANCE;
                        artifactListManager$fetchArtifactList$1.L$0 = str6;
                        str4 = str3;
                        artifactListManager$fetchArtifactList$1.L$1 = str4;
                        artifactListManager$fetchArtifactList$1.label = 1;
                        obj = companion.getChatSessionRawCall(str6, artifactListManager$fetchArtifactList$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            SsResponse ssResponse = (SsResponse) obj;
                            str5 = ssResponse == null ? (String) ssResponse.body() : null;
                            if (str5 != null) {
                                return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "Response body is null", new Exception("Response body is null"), (String) null, 8, (DefaultConstructorMarker) null);
                            }
                            return new HttpDataResult.Success(new BizResponse(0L, (String) null, (String) null, (String) null, (ArtifactListResponse) TraeHttpConnection.INSTANCE.getHttpGson().fromJson(str5, ArtifactListResponse.class), (String) null, 47, (DefaultConstructorMarker) null), (Throwable) null);
                        }
                        String str7 = (String) artifactListManager$fetchArtifactList$1.L$1;
                        String str8 = (String) artifactListManager$fetchArtifactList$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str4 = str7;
                        str6 = str8;
                    }
                    success = (HttpDataResult) obj;
                    if (!(success instanceof HttpDataResult.Success)) {
                        ChatSessionResponse chatSessionResponse = (ChatSessionResponse) success.getBizResp().getData();
                        String explorerUrl = chatSessionResponse != null ? chatSessionResponse.getExplorerUrl() : null;
                        if (explorerUrl == null) {
                            return new HttpDataResult.Error(AccountErrorCode.CommonError.COMMON_ERROR_REQUEST_API, "explorer_url is null", new Exception("explorer_url is null"), (String) null, 8, (DefaultConstructorMarker) null);
                        }
                        String str9 = "products-" + str4 + ".json";
                        String str10 = StringsKt.trimEnd(explorerUrl, new char[]{'/'}) + '/';
                        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
                        String xTToken = iLoginService != null ? iLoginService.getXTToken() : null;
                        if (xTToken == null) {
                            xTToken = "";
                        }
                        IArtifactListApi iArtifactListApi = (IArtifactListApi) TraeHttpConnection.createService$default(TraeHttpConnection.INSTANCE, "diff_view", IArtifactListApi.class, (Converter.Factory) null, str10, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("authorization", "Cloud-IDE-JWT " + xTToken)}), false, 36, (Object) null);
                        artifactListManager$fetchArtifactList$1.L$0 = null;
                        artifactListManager$fetchArtifactList$1.L$1 = null;
                        artifactListManager$fetchArtifactList$1.label = 2;
                        obj = iArtifactListApi.getArtifactList(str9, str6, artifactListManager$fetchArtifactList$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        SsResponse ssResponse2 = (SsResponse) obj;
                        if (ssResponse2 == null) {
                        }
                        if (str5 != null) {
                        }
                    } else {
                        if (success instanceof HttpDataResult.Error) {
                            return success;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            if (i != 0) {
            }
            success = (HttpDataResult) obj;
            if (!(success instanceof HttpDataResult.Success)) {
            }
        } catch (CancellationException e) {
            return new HttpDataResult.Error(-1001, "", e, (String) null, 8, (DefaultConstructorMarker) null);
        } catch (Throwable th) {
            String message = th.getMessage();
            return new HttpDataResult.Error(-1000, message != null ? message : "", th, (String) null, 8, (DefaultConstructorMarker) null);
        }
        artifactListManager$fetchArtifactList$1 = new ArtifactListManager$fetchArtifactList$1(this, continuation);
        Object obj2 = artifactListManager$fetchArtifactList$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = artifactListManager$fetchArtifactList$1.label;
    }
}
