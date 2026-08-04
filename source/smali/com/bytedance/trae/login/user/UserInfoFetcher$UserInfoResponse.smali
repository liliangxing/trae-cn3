# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
.super Ljava/lang/Object;
.source "UserInfoFetcher.kt"

.field private final response:Lcom/bytedance/trae/login/traeauth/TraeResponse;
.field private final ssResponse:Lcom/bytedance/retrofit2/SsResponse;


.method public constructor <init>(com.bytedance.trae.login.traeauth.TraeResponse  com.bytedance.retrofit2.SsResponse)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, response
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->response Lcom/bytedance/trae/login/traeauth/TraeResponse;
    iput-object v3, v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.user.UserInfoFetcher$UserInfoResponse  com.bytedance.trae.login.traeauth.TraeResponse  com.bytedance.retrofit2.SsResponse  int  java.lang.Object)com.bytedance.trae.login.user.UserInfoFetcher$UserInfoResponse
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->response Lcom/bytedance/trae/login/traeauth/TraeResponse;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->copy(Lcom/bytedance/trae/login/traeauth/TraeResponse; Lcom/bytedance/retrofit2/SsResponse;)Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.login.traeauth.TraeResponse
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->response Lcom/bytedance/trae/login/traeauth/TraeResponse;
    return-object v0
.end method

.method public final component2()com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.login.traeauth.TraeResponse  com.bytedance.retrofit2.SsResponse)com.bytedance.trae.login.user.UserInfoFetcher$UserInfoResponse
    .registers 4
    # ins_size=3
    const-string/jumbo v0, response
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;-><init>(Lcom/bytedance/trae/login/traeauth/TraeResponse; Lcom/bytedance/retrofit2/SsResponse;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;
    iget-object v1, v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->response Lcom/bytedance/trae/login/traeauth/TraeResponse;
    iget-object v3, v5, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->response Lcom/bytedance/trae/login/traeauth/TraeResponse;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    iget-object v5, v5, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getResponse()com.bytedance.trae.login.traeauth.TraeResponse
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->response Lcom/bytedance/trae/login/traeauth/TraeResponse;
    return-object v0
.end method

.method public final getResponseMetadata()com.bytedance.trae.login.traeauth.TraeResponseMetadata
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->response Lcom/bytedance/trae/login/traeauth/TraeResponse;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResponseMetadata()Lcom/bytedance/trae/login/traeauth/TraeResponseMetadata;
    move-result-object v0
    return-object v0
.end method

.method public final getResult()com.bytedance.trae.login.user.TraeUserInfoResult
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->response Lcom/bytedance/trae/login/traeauth/TraeResponse;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->getResult()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/user/TraeUserInfoResult;
    return-object v0
.end method

.method public final getSsResponse()com.bytedance.retrofit2.SsResponse
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->response Lcom/bytedance/trae/login/traeauth/TraeResponse;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeResponse;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UserInfoResponse(response="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->response Lcom/bytedance/trae/login/traeauth/TraeResponse;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", ssResponse="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/user/UserInfoFetcher$UserInfoResponse;->ssResponse Lcom/bytedance/retrofit2/SsResponse;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
