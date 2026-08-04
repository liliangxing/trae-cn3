# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/ParsedToolCallResult;
.super Ljava/lang/Object;
.source "ParsedChatMessage.kt"

.field private final data:Lcom/google/gson/JsonObject;
.field private final errorMessage:Ljava/lang/String;
.field private final isTruncated:Ljava/lang/Boolean;
.field private final status:Ljava/lang/String;


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
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/im/model/ParsedToolCallResult;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  com.google.gson.JsonObject  java.lang.Boolean)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->status Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->errorMessage Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->data Lcom/google/gson/JsonObject;
    iput-object v4, v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->isTruncated Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  com.google.gson.JsonObject  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
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
    invoke-direct v1, v2, v3, v4, v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.model.ParsedToolCallResult  java.lang.String  java.lang.String  com.google.gson.JsonObject  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.im.model.ParsedToolCallResult
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->status Ljava/lang/String;
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->errorMessage Ljava/lang/String;
    and-int/lit8 v6, v5, 4
    if-eqz v6, +004h
    iget-object v3, v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->data Lcom/google/gson/JsonObject;
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    iget-object v4, v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->isTruncated Ljava/lang/Boolean;
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->copy(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/Boolean;)Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    move-result-object v0
    return-object v0
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->status Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->errorMessage Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->data Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final component4()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->isTruncated Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  com.google.gson.JsonObject  java.lang.Boolean)com.bytedance.trae.im.model.ParsedToolCallResult
    .registers 6
    # ins_size=5
    new-instance v0, Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/Boolean;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->status Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->status Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->errorMessage Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->errorMessage Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->data Lcom/google/gson/JsonObject;
    iget-object v3, v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->data Lcom/google/gson/JsonObject;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->isTruncated Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->isTruncated Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getData()com.google.gson.JsonObject
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->data Lcom/google/gson/JsonObject;
    return-object v0
.end method

.method public final getErrorMessage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->errorMessage Ljava/lang/String;
    return-object v0
.end method

.method public final getStatus()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->status Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->status Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->errorMessage Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->data Lcom/google/gson/JsonObject;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/google/gson/JsonObject;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->isTruncated Ljava/lang/Boolean;
    if-nez v2, +003h
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isTruncated()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->isTruncated Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ParsedToolCallResult(status="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->status Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", errorMessage="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->errorMessage Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->data Lcom/google/gson/JsonObject;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isTruncated="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/model/ParsedToolCallResult;->isTruncated Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
