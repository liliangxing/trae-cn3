# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/RegisterAppResponse;
.super Ljava/lang/Object;
.source "RegisterAppApi.kt"

.field private final app:Lcom/bytedance/trae/network/AppInfo;


.method public constructor <init>(com.bytedance.trae.network.AppInfo)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/network/RegisterAppResponse;->app Lcom/bytedance/trae/network/AppInfo;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.network.RegisterAppResponse  com.bytedance.trae.network.AppInfo  int  java.lang.Object)com.bytedance.trae.network.RegisterAppResponse
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/network/RegisterAppResponse;->app Lcom/bytedance/trae/network/AppInfo;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/RegisterAppResponse;->copy(Lcom/bytedance/trae/network/AppInfo;)Lcom/bytedance/trae/network/RegisterAppResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.network.AppInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppResponse;->app Lcom/bytedance/trae/network/AppInfo;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.network.AppInfo)com.bytedance.trae.network.RegisterAppResponse
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/network/RegisterAppResponse;
    invoke-direct v0, v2, Lcom/bytedance/trae/network/RegisterAppResponse;-><init>(Lcom/bytedance/trae/network/AppInfo;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/network/RegisterAppResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/network/RegisterAppResponse;
    iget-object v1, v3, Lcom/bytedance/trae/network/RegisterAppResponse;->app Lcom/bytedance/trae/network/AppInfo;
    iget-object v4, v4, Lcom/bytedance/trae/network/RegisterAppResponse;->app Lcom/bytedance/trae/network/AppInfo;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getApp()com.bytedance.trae.network.AppInfo
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppResponse;->app Lcom/bytedance/trae/network/AppInfo;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/network/RegisterAppResponse;->app Lcom/bytedance/trae/network/AppInfo;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/network/AppInfo;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "RegisterAppResponse(app="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/network/RegisterAppResponse;->app Lcom/bytedance/trae/network/AppInfo;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
