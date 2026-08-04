# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;
.super Ljava/lang/Object;
.source "Models.kt"

.field private final needAuthorization:Z


.method public constructor <init>()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-direct v3, v2, v0, v1, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;-><init>(Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;->needAuthorization Z
    return-void 
.end method

.method public synthetic constructor <init>(boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;-><init>(Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.CheckAuthorizationData  boolean  int  java.lang.Object)com.bytedance.trae.conversation.network.CheckAuthorizationData
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;->needAuthorization Z
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;->copy(Z)Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;->needAuthorization Z
    return v0
.end method

.method public final copy(boolean)com.bytedance.trae.conversation.network.CheckAuthorizationData
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;-><init>(Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;->needAuthorization Z
    iget-boolean v4, v4, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;->needAuthorization Z
    if-eq v1, v4, +003h
    return v2
    return v0
.end method

.method public final getNeedAuthorization()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;->needAuthorization Z
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;->needAuthorization Z
    invoke-static v0, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "CheckAuthorizationData(needAuthorization="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/network/CheckAuthorizationData;->needAuthorization Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
