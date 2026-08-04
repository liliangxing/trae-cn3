# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ChatEventDeserializer;
.super Ljava/lang/Object;
.source "IMEvent.kt"

.implements Lcom/google/gson/JsonDeserializer;

.field private final gson:Lcom/google/gson/Gson;


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    return-void 
.end method

.method public deserialize(com.google.gson.JsonElement  java.lang.reflect.Type  com.google.gson.JsonDeserializationContext)com.bytedance.trae.im.service.ChatEvent
    .registers 54
    # ins_size=4
    move-object/from16 v1, v50
    const-string v0, "json"
    move-object/from16 v2, v51
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, typeOfT
    move-object/from16 v3, v52
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "context"
    move-object/from16 v3, v53
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v51, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v0
    const-string/jumbo v2, type
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +013h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v5
    xor-int/2addr v5, v3
    if-eqz v5, +003h
    goto +2h
    move-object v2, v4
    if-eqz v2, +008h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    move-object v6, v2
    goto +2h
    move-object v6, v4
    const-string/jumbo v2, seq
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    if-eqz v2, +016h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v5
    xor-int/2addr v5, v3
    if-eqz v5, +003h
    goto +2h
    move-object v2, v4
    if-eqz v2, +00bh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    goto +2h
    move-object v2, v4
    const-string v5, "new_tool_call"
    invoke-virtual v0, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    const/4 v7, 0
    if-eqz v5, +021h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v8
    if-nez v8, +00ah
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v8
    if-eqz v8, +004h
    move v8, v3
    goto +2h
    move v8, v7
    if-eqz v8, +003h
    goto +2h
    move-object v5, v4
    if-eqz v5, +00ch
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v5
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    move-object v9, v5
    goto +2h
    move-object v9, v4
    const-string v5, "clean_thought"
    invoke-virtual v0, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +021h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v8
    if-nez v8, +00ah
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v8
    if-eqz v8, +004h
    move v8, v3
    goto +2h
    move v8, v7
    if-eqz v8, +003h
    goto +2h
    move-object v5, v4
    if-eqz v5, +00ch
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v5
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    move-object v10, v5
    goto +2h
    move-object v10, v4
    const-string/jumbo v5, thought_first_data
    invoke-virtual v0, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +021h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v8
    if-nez v8, +00ah
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v8
    if-eqz v8, +004h
    move v8, v3
    goto +2h
    move v8, v7
    if-eqz v8, +003h
    goto +2h
    move-object v5, v4
    if-eqz v5, +00ch
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v5
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    move-object v11, v5
    goto +2h
    move-object v11, v4
    const-string/jumbo v5, toolcall_first_data
    invoke-virtual v0, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +021h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v8
    if-nez v8, +00ah
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v8
    if-eqz v8, +004h
    move v8, v3
    goto +2h
    move v8, v7
    if-eqz v8, +003h
    goto +2h
    move-object v5, v4
    if-eqz v5, +00ch
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v5
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    move-object v12, v5
    goto +2h
    move-object v12, v4
    const-string v5, "data"
    invoke-virtual v0, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v5
    xor-int/2addr v3, v5
    if-eqz v3, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v4
    const-string v5, "ImService"
    if-nez v3, +004h
    move-object v0, v4
    goto +2fh
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +029h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    goto +20h
    move-exception v0
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v13, "ChatEventDeserializer parse error: type="
    invoke-direct v8, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v13, ", e="
    invoke-virtual v8, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v5, v0, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    goto -2eh
    move-object v0, v3
    if-nez v0, +01eh
    new-instance v8, Ljava/lang/StringBuilder;
    const-string v13, "ChatEventDeserializer dataElement is null: type="
    invoke-direct v8, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v8, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    const-string v13, ", dataRaw="
    invoke-virtual v8, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-static v5, v3, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    if-eqz v6, +268h
    invoke-virtual v6, Ljava/lang/String;->hashCode()I
    move-result v3
    sparse-switch v3, +0000278h
    goto/16 +25fh
    const-string v3, "plan_item"
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +255h
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    if-nez v0, +024h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 8191
    const/16 v28, 0
    move-object v13, v0
    invoke-direct/range v13 ... v28, Lcom/bytedance/trae/im/service/ChatEventPayload$PlanItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ToolCallInfo; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +221h
    const-string v3, "fast_request_savings"
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +219h
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;
    if-nez v0, +010h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 7
    const/16 v18, 0
    move-object v13, v0
    invoke-direct/range v13 ... v18, Lcom/bytedance/trae/im/service/ChatEventPayload$FastRequestSavings;-><init>(Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/Long; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +1f9h
    const-string v3, "queuing"
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +1f1h
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    if-nez v0, +018h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 127
    const/16 v22, 0
    move-object v13, v0
    invoke-direct/range v13 ... v22, Lcom/bytedance/trae/im/service/ChatEventPayload$Queuing;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/FastRequestEvent; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +1c9h
    const-string v3, "notification"
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +1c1h
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    if-nez v0, +01ch
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 511
    const/16 v24, 0
    move-object v13, v0
    invoke-direct/range v13 ... v24, Lcom/bytedance/trae/im/service/ChatEventPayload$Notification;-><init>(Ljava/lang/String; Ljava/lang/Integer; Lcom/bytedance/trae/im/service/FastRequestEvent; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +195h
    const-string/jumbo v3, session_title_message
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +18ch
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v5, Lcom/bytedance/trae/im/service/ChatEventPayload$SessionTitle;
    invoke-virtual v3, v0, v5, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$SessionTitle;
    if-nez v0, +008h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$SessionTitle;
    const/4 v3, 3
    invoke-direct v0, v4, v4, v3, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$SessionTitle;-><init>(Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +174h
    const-string v3, "error"
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +16ch
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;
    if-nez v0, +012h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 15
    const/16 v19, 0
    move-object v13, v0
    invoke-direct/range v13 ... v19, Lcom/bytedance/trae/im/service/ChatEventPayload$Error;-><init>(Ljava/lang/Integer; Ljava/lang/String; Lcom/google/gson/JsonObject; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +14ah
    const-string v3, "done"
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +142h
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;
    if-nez v0, +012h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 15
    const/16 v19, 0
    move-object v13, v0
    invoke-direct/range v13 ... v19, Lcom/bytedance/trae/im/service/ChatEventPayload$Done;-><init>(Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +120h
    const-string v3, "metadata"
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +118h
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    if-nez v0, +04eh
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;
    move-object v13, v0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, -1
    const/16 v48, 1
    const/16 v49, 0
    invoke-direct/range v13 ... v49, Lcom/bytedance/trae/im/service/ChatEventPayload$Metadata;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/Object; Ljava/lang/Object; Lcom/bytedance/trae/im/service/DocReferences; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/UserMessageContext; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Object; Ljava/lang/Object; Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Long; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/String; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +0bah
    const-string/jumbo v3, token_usage
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +0b1h
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;
    if-nez v0, +01ch
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 511
    const/16 v24, 0
    move-object v13, v0
    invoke-direct/range v13 ... v24, Lcom/bytedance/trae/im/service/ChatEventPayload$TokenUsage;-><init>(Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; Ljava/lang/Integer; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto/16 +085h
    const-string/jumbo v3, timing_events
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +07ch
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;
    if-nez v0, +037h
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 511
    const/16 v24, 0
    move-object v13, v0
    invoke-direct/range v13 ... v24, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;-><init>(Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +1bh
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 511
    const/16 v24, 0
    move-object v13, v0
    invoke-direct/range v13 ... v24, Lcom/bytedance/trae/im/service/ChatEventPayload$TimingEvents;-><init>(Ljava/util/Map; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/Boolean; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    goto +35h
    const-string/jumbo v3, user_message
    invoke-virtual v6, v3, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +2dh
    iget-object v3, v1, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->gson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;
    invoke-virtual v3, v0, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;
    if-nez v0, +01eh
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 1023
    const/16 v25, 0
    move-object v13, v0
    invoke-direct/range v13 ... v25, Lcom/bytedance/trae/im/service/ChatEventPayload$UserMessage;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Lcom/google/gson/JsonElement; Ljava/lang/String; Ljava/lang/Long; Lcom/bytedance/trae/im/service/UserMessageContext; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-object v8, v0
    goto +9h
    new-instance v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;
    invoke-direct v3, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;-><init>(Lcom/google/gson/JsonElement;)V
    check-cast v3, Lcom/bytedance/trae/im/service/ChatEventPayload;
    move-object v8, v3
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v0
    move v7, v0
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEvent;
    move-object v5, v0
    invoke-direct/range v5 ... v12, Lcom/bytedance/trae/im/service/ChatEvent;-><init>(Ljava/lang/String; I Lcom/bytedance/trae/im/service/ChatEventPayload; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Boolean;)V
    return-object v0
    sparse-switch-payload -6c25686d -57cc1952 -44658425 -1ad284d1 2f2382 5c4d208 14760737 237a88eb 270d358e 5a567d26 7d4d3a69
    :try_start_0x118
    :try_start_0x34c
.end method

.method public bridge synthetic deserialize(com.google.gson.JsonElement  java.lang.reflect.Type  com.google.gson.JsonDeserializationContext)java.lang.Object
    .registers 4
    # ins_size=4
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/im/service/ChatEventDeserializer;->deserialize(Lcom/google/gson/JsonElement; Ljava/lang/reflect/Type; Lcom/google/gson/JsonDeserializationContext;)Lcom/bytedance/trae/im/service/ChatEvent;
    move-result-object v1
    return-object v1
.end method
