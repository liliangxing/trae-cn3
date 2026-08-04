# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;
.super Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;
.source "ContentSecurityMessageProcessor.kt"

.field private final detail:Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;


.method public constructor <init>(com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult$Blocked)void
    .registers 3
    # ins_size=2
    const-string v0, "detail"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->detail Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.tenant.ContentSecurityMessageProcessResult$Blocked  com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult$Blocked  int  java.lang.Object)com.bytedance.trae.im.service.tenant.ContentSecurityMessageProcessResult$Blocked
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->detail Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->copy(Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;)Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult$Blocked
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->detail Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult$Blocked)com.bytedance.trae.im.service.tenant.ContentSecurityMessageProcessResult$Blocked
    .registers 3
    # ins_size=2
    const-string v0, "detail"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;
    invoke-direct v0, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;-><init>(Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;
    iget-object v1, v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->detail Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    iget-object v4, v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->detail Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getDetail()com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult$Blocked
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->detail Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->detail Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Blocked(detail="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityMessageProcessResult$Blocked;->detail Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
