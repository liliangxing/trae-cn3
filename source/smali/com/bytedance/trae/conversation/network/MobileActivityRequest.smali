# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/MobileActivityRequest;
.super Ljava/lang/Object;
.source "ICustomActivityApi.kt"

.field private final version:I


.method public constructor <init>()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-direct v3, v2, v0, v1, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;-><init>(I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;->version I
    return-void 
.end method

.method public synthetic constructor <init>(int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    const/4 v3, 1
    and-int/2addr v2, v3
    if-eqz v2, +003h
    move v1, v3
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;-><init>(I)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.MobileActivityRequest  int  int  java.lang.Object)com.bytedance.trae.conversation.network.MobileActivityRequest
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget v1, v0, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;->version I
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;->copy(I)Lcom/bytedance/trae/conversation/network/MobileActivityRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;->version I
    return v0
.end method

.method public final copy(int)com.bytedance.trae.conversation.network.MobileActivityRequest
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;-><init>(I)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;
    iget v1, v3, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;->version I
    iget v4, v4, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;->version I
    if-eq v1, v4, +003h
    return v2
    return v0
.end method

.method public final getVersion()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;->version I
    return v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;->version I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "MobileActivityRequest(version="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;->version I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
