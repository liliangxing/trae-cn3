package com.bytedance.trae.conversation.plugin.authorization;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.sdk.account.api.OauthTokenTriggerScene;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginConnectorOAuthManager.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u0004\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010\u0004\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;", "", "startOAuth", "Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartResponse;", OauthTokenTriggerScene.REQUEST, "Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartRequest;", "(Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pollAuth", "Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthPollResponse;", "Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthPollRequest;", "(Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthPollRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listConnectorConnections", "Lcom/bytedance/trae/conversation/plugin/authorization/ListConnectorConnectionsResponse;", "Lcom/bytedance/trae/conversation/plugin/authorization/ListConnectorConnectionsRequest;", "(Lcom/bytedance/trae/conversation/plugin/authorization/ListConnectorConnectionsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface IConnectorOAuthApi {
    @POST("trae/api/v3/ListConnectorConnections")
    Object listConnectorConnections(@Body ListConnectorConnectionsRequest listConnectorConnectionsRequest, Continuation<? super ListConnectorConnectionsResponse> continuation);

    @POST("trae/api/v3/connector/auth/poll")
    Object pollAuth(@Body ConnectorOAuthPollRequest connectorOAuthPollRequest, Continuation<? super ConnectorOAuthPollResponse> continuation);

    @POST("trae/api/v3/connector/oauth/start")
    Object startOAuth(@Body ConnectorOAuthStartRequest connectorOAuthStartRequest, Continuation<? super ConnectorOAuthStartResponse> continuation);
}
