# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/GeneralActivityData;
.super Ljava/lang/Object;
.source "ICustomActivityApi.kt"

.field private final first:Lcom/bytedance/trae/conversation/network/ActivityItem;


.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/conversation/network/GeneralActivityData;-><init>(Lcom/bytedance/trae/conversation/network/ActivityItem; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.network.ActivityItem)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->first Lcom/bytedance/trae/conversation/network/ActivityItem;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.network.ActivityItem  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/GeneralActivityData;-><init>(Lcom/bytedance/trae/conversation/network/ActivityItem;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.network.GeneralActivityData  com.bytedance.trae.conversation.network.ActivityItem  int  java.lang.Object)com.bytedance.trae.conversation.network.GeneralActivityData
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->first Lcom/bytedance/trae/conversation/network/ActivityItem;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->copy(Lcom/bytedance/trae/conversation/network/ActivityItem;)Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.network.ActivityItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->first Lcom/bytedance/trae/conversation/network/ActivityItem;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.network.ActivityItem)com.bytedance.trae.conversation.network.GeneralActivityData
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/network/GeneralActivityData;-><init>(Lcom/bytedance/trae/conversation/network/ActivityItem;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->first Lcom/bytedance/trae/conversation/network/ActivityItem;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->first Lcom/bytedance/trae/conversation/network/ActivityItem;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getFirst()com.bytedance.trae.conversation.network.ActivityItem
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->first Lcom/bytedance/trae/conversation/network/ActivityItem;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->first Lcom/bytedance/trae/conversation/network/ActivityItem;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/ActivityItem;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "GeneralActivityData(first="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->first Lcom/bytedance/trae/conversation/network/ActivityItem;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
