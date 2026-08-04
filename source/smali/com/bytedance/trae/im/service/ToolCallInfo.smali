# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ToolCallInfo;
.super Ljava/lang/Object;
.source "IMEvent.kt"

.field private final alreadyEmittedGeneratingEvent:Ljava/lang/Boolean;
.field private final alreadyEmittedRunEvent:Ljava/lang/Boolean;
.field private final id:Ljava/lang/String;
.field private final meta:Lcom/google/gson/JsonElement;
.field private final name:Ljava/lang/String;
.field private final params:Lcom/google/gson/JsonElement;
.field private final result:Lcom/google/gson/JsonElement;


.method public constructor <init>()void
    .registers 11
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 127
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/im/service/ToolCallInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Ljava/lang/Boolean; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(java.lang.String  java.lang.String  com.google.gson.JsonElement  com.google.gson.JsonElement  com.google.gson.JsonElement  java.lang.Boolean  java.lang.Boolean)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/im/service/ToolCallInfo;->id Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/im/service/ToolCallInfo;->name Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/im/service/ToolCallInfo;->params Lcom/google/gson/JsonElement;
    iput-object v4, v0, Lcom/bytedance/trae/im/service/ToolCallInfo;->result Lcom/google/gson/JsonElement;
    iput-object v5, v0, Lcom/bytedance/trae/im/service/ToolCallInfo;->meta Lcom/google/gson/JsonElement;
    iput-object v6, v0, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedGeneratingEvent Ljava/lang/Boolean;
    iput-object v7, v0, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedRunEvent Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  java.lang.String  com.google.gson.JsonElement  com.google.gson.JsonElement  com.google.gson.JsonElement  java.lang.Boolean  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=10
    and-int/lit8 v15, v14, 1
    const/4 v0, 0
    if-eqz v15, +004h
    move-object v15, v0
    goto +2h
    move-object v15, v7
    and-int/lit8 v7, v14, 2
    if-eqz v7, +004h
    move-object v1, v0
    goto +2h
    move-object v1, v8
    and-int/lit8 v7, v14, 4
    if-eqz v7, +004h
    move-object v2, v0
    goto +2h
    move-object v2, v9
    and-int/lit8 v7, v14, 8
    if-eqz v7, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v10
    and-int/lit8 v7, v14, 16
    if-eqz v7, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v11
    and-int/lit8 v7, v14, 32
    if-eqz v7, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v12
    and-int/lit8 v7, v14, 64
    if-eqz v7, +004h
    move-object v14, v0
    goto +2h
    move-object v14, v13
    move-object v7, v6
    move-object v8, v15
    move-object v9, v1
    move-object v10, v2
    move-object v11, v3
    move-object v12, v4
    move-object v13, v5
    invoke-direct/range v7 ... v14, Lcom/bytedance/trae/im/service/ToolCallInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.ToolCallInfo  java.lang.String  java.lang.String  com.google.gson.JsonElement  com.google.gson.JsonElement  com.google.gson.JsonElement  java.lang.Boolean  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.im.service.ToolCallInfo
    .registers 15
    # ins_size=10
    and-int/lit8 v14, v13, 1
    if-eqz v14, +004h
    iget-object v6, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->id Ljava/lang/String;
    and-int/lit8 v14, v13, 2
    if-eqz v14, +004h
    iget-object v7, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->name Ljava/lang/String;
    move-object v14, v7
    and-int/lit8 v7, v13, 4
    if-eqz v7, +004h
    iget-object v8, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->params Lcom/google/gson/JsonElement;
    move-object v0, v8
    and-int/lit8 v7, v13, 8
    if-eqz v7, +004h
    iget-object v9, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->result Lcom/google/gson/JsonElement;
    move-object v1, v9
    and-int/lit8 v7, v13, 16
    if-eqz v7, +004h
    iget-object v10, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->meta Lcom/google/gson/JsonElement;
    move-object v2, v10
    and-int/lit8 v7, v13, 32
    if-eqz v7, +004h
    iget-object v11, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedGeneratingEvent Ljava/lang/Boolean;
    move-object v3, v11
    and-int/lit8 v7, v13, 64
    if-eqz v7, +004h
    iget-object v12, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedRunEvent Ljava/lang/Boolean;
    move-object v4, v12
    move-object v7, v5
    move-object v8, v6
    move-object v9, v14
    move-object v10, v0
    move-object v11, v1
    move-object v12, v2
    move-object v13, v3
    move-object v14, v4
    invoke-virtual/range v7 ... v14, Lcom/bytedance/trae/im/service/ToolCallInfo;->copy(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Ljava/lang/Boolean; Ljava/lang/Boolean;)Lcom/bytedance/trae/im/service/ToolCallInfo;
    move-result-object v5
    return-object v5
.end method

.method public final component1()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->id Ljava/lang/String;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->name Ljava/lang/String;
    return-object v0
.end method

.method public final component3()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->params Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public final component4()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->result Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public final component5()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->meta Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public final component6()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedGeneratingEvent Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component7()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedRunEvent Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(java.lang.String  java.lang.String  com.google.gson.JsonElement  com.google.gson.JsonElement  com.google.gson.JsonElement  java.lang.Boolean  java.lang.Boolean)com.bytedance.trae.im.service.ToolCallInfo
    .registers 17
    # ins_size=8
    new-instance v8, Lcom/bytedance/trae/im/service/ToolCallInfo;
    move-object v0, v8
    move-object v1, v10
    move-object v2, v11
    move-object v3, v12
    move-object v4, v13
    move-object v5, v14
    move-object v6, v15
    move-object/from16 v7, v16
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/im/service/ToolCallInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    return-object v8
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/im/service/ToolCallInfo;
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ToolCallInfo;->id Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->id Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ToolCallInfo;->name Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->name Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ToolCallInfo;->params Lcom/google/gson/JsonElement;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->params Lcom/google/gson/JsonElement;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ToolCallInfo;->result Lcom/google/gson/JsonElement;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->result Lcom/google/gson/JsonElement;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ToolCallInfo;->meta Lcom/google/gson/JsonElement;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->meta Lcom/google/gson/JsonElement;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedGeneratingEvent Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedGeneratingEvent Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedRunEvent Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedRunEvent Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAlreadyEmittedGeneratingEvent()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedGeneratingEvent Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getAlreadyEmittedRunEvent()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedRunEvent Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->id Ljava/lang/String;
    return-object v0
.end method

.method public final getMeta()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->meta Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public final getName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->name Ljava/lang/String;
    return-object v0
.end method

.method public final getParams()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->params Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public final getResult()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ToolCallInfo;->result Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/im/service/ToolCallInfo;->id Ljava/lang/String;
    const/4 v1, 0
    if-nez v0, +004h
    move v0, v1
    goto +5h
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ToolCallInfo;->name Ljava/lang/String;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ToolCallInfo;->params Lcom/google/gson/JsonElement;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ToolCallInfo;->result Lcom/google/gson/JsonElement;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ToolCallInfo;->meta Lcom/google/gson/JsonElement;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedGeneratingEvent Ljava/lang/Boolean;
    if-nez v2, +004h
    move v2, v1
    goto +5h
    invoke-virtual v2, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v2, v3, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedRunEvent Ljava/lang/Boolean;
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
    const-string v1, "ToolCallInfo(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->id Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", name="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->name Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", params="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->params Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", result="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->result Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", meta="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->meta Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", alreadyEmittedGeneratingEvent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedGeneratingEvent Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", alreadyEmittedRunEvent="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ToolCallInfo;->alreadyEmittedRunEvent Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
