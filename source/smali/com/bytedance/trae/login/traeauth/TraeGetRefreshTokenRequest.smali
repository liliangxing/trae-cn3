# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;
.super Ljava/lang/Object;
.source "TraeAuthModels.kt"

.field private final clientId:Ljava/lang/String;
.field private final deviceId:Ljava/lang/String;
.field private final deviceInfo:Lcom/bytedance/trae/login/traeauth/DeviceInfo;
.field private final deviceProof:Lcom/bytedance/trae/login/traeauth/DeviceProof;


.method public constructor <init>()void
    .registers 8
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 15
    const/4 v6, 0
    move-object v0, v7
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/DeviceInfo; Lcom/bytedance/trae/login/traeauth/DeviceProof; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.login.traeauth.DeviceInfo  com.bytedance.trae.login.traeauth.DeviceProof)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->clientId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceInfo Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    iput-object v4, v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceProof Lcom/bytedance/trae/login/traeauth/DeviceProof;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.login.traeauth.DeviceInfo  com.bytedance.trae.login.traeauth.DeviceProof  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 1
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v2, v0
    and-int/lit8 v7, v6, 2
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v7, v6, 4
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/DeviceInfo; Lcom/bytedance/trae/login/traeauth/DeviceProof;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.login.traeauth.TraeGetRefreshTokenRequest  java.lang.String  java.lang.String  com.bytedance.trae.login.traeauth.DeviceInfo  com.bytedance.trae.login.traeauth.DeviceProof  int  java.lang.Object)com.bytedance.trae.login.traeauth.TraeGetRefreshTokenRequest
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->clientId Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceId Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceInfo Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceProof Lcom/bytedance/trae/login/traeauth/DeviceProof;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->copy(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/DeviceInfo; Lcom/bytedance/trae/login/traeauth/DeviceProof;)Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->clientId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceId Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.bytedance.trae.login.traeauth.DeviceInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceInfo Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.login.traeauth.DeviceProof
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceProof Lcom/bytedance/trae/login/traeauth/DeviceProof;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  com.bytedance.trae.login.traeauth.DeviceInfo  com.bytedance.trae.login.traeauth.DeviceProof)com.bytedance.trae.login.traeauth.TraeGetRefreshTokenRequest
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/login/traeauth/DeviceInfo; Lcom/bytedance/trae/login/traeauth/DeviceProof;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->clientId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->clientId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceInfo Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    iget-object v3, v5, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceInfo Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceProof Lcom/bytedance/trae/login/traeauth/DeviceProof;
    iget-object v5, v5, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceProof Lcom/bytedance/trae/login/traeauth/DeviceProof;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getClientId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->clientId Ljava/lang/String;
    return-object v0
.end method

.method public final getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceId Ljava/lang/String;
    return-object v0
.end method

.method public final getDeviceInfo()com.bytedance.trae.login.traeauth.DeviceInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceInfo Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    return-object v0
.end method

.method public final getDeviceProof()com.bytedance.trae.login.traeauth.DeviceProof
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceProof Lcom/bytedance/trae/login/traeauth/DeviceProof;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->clientId Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceId Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceInfo Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/DeviceInfo;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceProof Lcom/bytedance/trae/login/traeauth/DeviceProof;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Lcom/bytedance/trae/login/traeauth/DeviceProof;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "TraeGetRefreshTokenRequest(clientId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->clientId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deviceId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deviceInfo="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceInfo Lcom/bytedance/trae/login/traeauth/DeviceInfo;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deviceProof="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/login/traeauth/TraeGetRefreshTokenRequest;->deviceProof Lcom/bytedance/trae/login/traeauth/DeviceProof;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
