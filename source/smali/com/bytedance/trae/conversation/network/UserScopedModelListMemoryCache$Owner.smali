# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;
.super Ljava/lang/Object;
.source "UserScopedModelListMemoryCache.kt"

.field private final generation:J
.field private final userId:Ljava/lang/String;


.method public constructor <init>(java.lang.String  long)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, userId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->userId Ljava/lang/String;
    iput-wide v3, v1, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->generation J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache$Owner  java.lang.String  long  int  java.lang.Object)com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache$Owner
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->userId Ljava/lang/String;
    and-int/lit8 v4, v4, 2
    if-eqz v4, +004h
    iget-wide v2, v0, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->generation J
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->copy(Ljava/lang/String; J)Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->userId Ljava/lang/String;
    return-object v0
.end method

.method public final component2()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->generation J
    return-wide v0
.end method

.method public final copy(java.lang.String  long)com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache$Owner
    .registers 5
    # ins_size=4
    const-string/jumbo v0, userId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;-><init>(Ljava/lang/String; J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->userId Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->userId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->generation J
    iget-wide v5, v8, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->generation J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getGeneration()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->generation J
    return-wide v0
.end method

.method public final getUserId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->userId Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->userId Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->generation J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Owner(userId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->userId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", generation="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner;->generation J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
