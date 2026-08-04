# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;
.super Ljava/lang/Object;
.source "IShareLinkApi.kt"

.field private final status:Ljava/lang/String;


.method public constructor <init>(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, status
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;->status Ljava/lang/String;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.products.UpdateShareLinkStatusRequest  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.products.UpdateShareLinkStatusRequest
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;->status Ljava/lang/String;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;->copy(Ljava/lang/String;)Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;->status Ljava/lang/String;
    return-object v0
.end method

.method public final copy(java.lang.String)com.bytedance.trae.conversation.products.UpdateShareLinkStatusRequest
    .registers 3
    # ins_size=2
    const-string/jumbo v0, status
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;-><init>(Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;->status Ljava/lang/String;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;->status Ljava/lang/String;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;->status Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;->status Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "UpdateShareLinkStatusRequest(status="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;->status Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
