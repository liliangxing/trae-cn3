package com.bytedance.trae.conversation.network;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: ThirdPartyTokenRepository.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\"\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\fH§@¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/network/IThirdPartyTokenApi;", "", "setThirdPartyToken", "Lcom/bytedance/retrofit2/SsResponse;", "", ReportConst.ValidationReport.BODY, "Lcom/bytedance/trae/conversation/network/SetThirdPartyTokenRequest;", "(Lcom/bytedance/trae/conversation/network/SetThirdPartyTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getThirdPartyToken", "Lcom/bytedance/trae/conversation/network/GetThirdPartyTokenRequest;", "(Lcom/bytedance/trae/conversation/network/GetThirdPartyTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnectThirdPartyToken", "Lcom/bytedance/trae/conversation/network/DisconnectThirdPartyTokenRequest;", "(Lcom/bytedance/trae/conversation/network/DisconnectThirdPartyTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IThirdPartyTokenApi {
    @POST("cloudide/api/v3/trae/DisconnectThirdPartyToken")
    Object disconnectThirdPartyToken(@Body DisconnectThirdPartyTokenRequest disconnectThirdPartyTokenRequest, Continuation<? super SsResponse<String>> continuation);

    @POST("cloudide/api/v3/trae/GetThirdPartyToken")
    Object getThirdPartyToken(@Body GetThirdPartyTokenRequest getThirdPartyTokenRequest, Continuation<? super SsResponse<String>> continuation);

    @POST("cloudide/api/v3/trae/SetThirdPartyToken")
    Object setThirdPartyToken(@Body SetThirdPartyTokenRequest setThirdPartyTokenRequest, Continuation<? super SsResponse<String>> continuation);
}
