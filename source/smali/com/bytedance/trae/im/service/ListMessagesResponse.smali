# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ListMessagesResponse;
.super Ljava/lang/Object;
.source "IListMessagesService.kt"

.field private final messages:Ljava/util/List;
.field private final nextPageToken:Ljava/lang/String;
.field private final total:Ljava/lang/Integer;


.method public constructor <init>()void
    .registers 7
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 7
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/im/service/ListMessagesResponse;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.util.List  java.lang.String  java.lang.Integer)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;->messages Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;->nextPageToken Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;->total Ljava/lang/Integer;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.lang.String  java.lang.Integer  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=6
    and-int/lit8 v6, v5, 1
    const/4 v0, 0
    if-eqz v6, +003h
    move-object v2, v0
    and-int/lit8 v6, v5, 2
    if-eqz v6, +003h
    move-object v3, v0
    and-int/lit8 v5, v5, 4
    if-eqz v5, +003h
    move-object v4, v0
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/im/service/ListMessagesResponse;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/Integer;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.ListMessagesResponse  java.util.List  java.lang.String  java.lang.Integer  int  java.lang.Object)com.bytedance.trae.im.service.ListMessagesResponse
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 1
    if-eqz v5, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;->messages Ljava/util/List;
    and-int/lit8 v5, v4, 2
    if-eqz v5, +004h
    iget-object v2, v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;->nextPageToken Ljava/lang/String;
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    iget-object v3, v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;->total Ljava/lang/Integer;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/im/service/ListMessagesResponse;->copy(Ljava/util/List; Ljava/lang/String; Ljava/lang/Integer;)Lcom/bytedance/trae/im/service/ListMessagesResponse;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ListMessagesResponse;->messages Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ListMessagesResponse;->nextPageToken Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ListMessagesResponse;->total Ljava/lang/Integer;
    return-object v0
.end method

.method public final copy(java.util.List  java.lang.String  java.lang.Integer)com.bytedance.trae.im.service.ListMessagesResponse
    .registers 5
    # ins_size=4
    new-instance v0, Lcom/bytedance/trae/im/service/ListMessagesResponse;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/im/service/ListMessagesResponse;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/Integer;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/ListMessagesResponse;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/ListMessagesResponse;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ListMessagesResponse;->messages Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ListMessagesResponse;->messages Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ListMessagesResponse;->nextPageToken Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ListMessagesResponse;->nextPageToken Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ListMessagesResponse;->total Ljava/lang/Integer;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/ListMessagesResponse;->total Ljava/lang/Integer;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getMessages()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ListMessagesResponse;->messages Ljava/util/List;
    return-object v0
.end method

.method public final getNextPageToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ListMessagesResponse;->nextPageToken Ljava/lang/String;
    return-object v0
.end method

.method public final getTotal()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ListMessagesResponse;->total Ljava/lang/Integer;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/ListMessagesResponse;->messages Ljava/util/List;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ListMessagesResponse;->nextPageToken Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ListMessagesResponse;->total Ljava/lang/Integer;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ListMessagesResponse(messages="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ListMessagesResponse;->messages Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", nextPageToken="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ListMessagesResponse;->nextPageToken Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", total="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ListMessagesResponse;->total Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
