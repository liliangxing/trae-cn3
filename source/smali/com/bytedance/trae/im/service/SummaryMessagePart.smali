# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/SummaryMessagePart;
.super Ljava/lang/Object;
.source "ICreateAgentTask.kt"

.field private final data:Lcom/bytedance/trae/im/service/SummaryMessageData;
.field private final type:Ljava/lang/String;


.method public constructor <init>(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "content"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/SummaryMessageData;
    invoke-direct v0, v3, Lcom/bytedance/trae/im/service/SummaryMessageData;-><init>(Ljava/lang/String;)V
    const/4 v3, 1
    const/4 v1, 0
    invoke-direct v2, v1, v0, v3, v1, Lcom/bytedance/trae/im/service/SummaryMessagePart;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/service/SummaryMessageData; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  com.bytedance.trae.im.service.SummaryMessageData)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "data"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/SummaryMessagePart;->type Ljava/lang/String;
    iput-object v3, v1, Lcom/bytedance/trae/im/service/SummaryMessagePart;->data Lcom/bytedance/trae/im/service/SummaryMessageData;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  com.bytedance.trae.im.service.SummaryMessageData  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +005h
    const-string/jumbo v1, text
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/im/service/SummaryMessagePart;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/service/SummaryMessageData;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.SummaryMessagePart  java.lang.String  com.bytedance.trae.im.service.SummaryMessageData  int  java.lang.Object)com.bytedance.trae.im.service.SummaryMessagePart
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/SummaryMessagePart;->type Ljava/lang/String;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/SummaryMessagePart;->data Lcom/bytedance/trae/im/service/SummaryMessageData;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/service/SummaryMessagePart;->copy(Ljava/lang/String; Lcom/bytedance/trae/im/service/SummaryMessageData;)Lcom/bytedance/trae/im/service/SummaryMessagePart;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SummaryMessagePart;->type Ljava/lang/String;
    return-object v0
.end method

.method public final component2()com.bytedance.trae.im.service.SummaryMessageData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SummaryMessagePart;->data Lcom/bytedance/trae/im/service/SummaryMessageData;
    return-object v0
.end method

.method public final copy(java.lang.String  com.bytedance.trae.im.service.SummaryMessageData)com.bytedance.trae.im.service.SummaryMessagePart
    .registers 4
    # ins_size=3
    const-string/jumbo v0, type
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "data"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/im/service/SummaryMessagePart;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/im/service/SummaryMessagePart;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/service/SummaryMessageData;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/SummaryMessagePart;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/SummaryMessagePart;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SummaryMessagePart;->type Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/SummaryMessagePart;->type Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/SummaryMessagePart;->data Lcom/bytedance/trae/im/service/SummaryMessageData;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/SummaryMessagePart;->data Lcom/bytedance/trae/im/service/SummaryMessageData;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getData()com.bytedance.trae.im.service.SummaryMessageData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SummaryMessagePart;->data Lcom/bytedance/trae/im/service/SummaryMessageData;
    return-object v0
.end method

.method public final getType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/SummaryMessagePart;->type Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/im/service/SummaryMessagePart;->type Ljava/lang/String;
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SummaryMessagePart;->data Lcom/bytedance/trae/im/service/SummaryMessageData;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/SummaryMessageData;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final toJsonArray()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toJson(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SummaryMessagePart(type="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SummaryMessagePart;->type Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/SummaryMessagePart;->data Lcom/bytedance/trae/im/service/SummaryMessageData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
