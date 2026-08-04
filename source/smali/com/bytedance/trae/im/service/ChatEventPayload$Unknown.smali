# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;
.super Lcom/bytedance/trae/im/service/ChatEventPayload;
.source "IMEvent.kt"

.field private final raw:Lcom/google/gson/JsonElement;


.method public constructor <init>(com.google.gson.JsonElement)void
    .registers 3
    # ins_size=2
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;->raw Lcom/google/gson/JsonElement;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.im.service.ChatEventPayload$Unknown  com.google.gson.JsonElement  int  java.lang.Object)com.bytedance.trae.im.service.ChatEventPayload$Unknown
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;->raw Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;->copy(Lcom/google/gson/JsonElement;)Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;->raw Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public final copy(com.google.gson.JsonElement)com.bytedance.trae.im.service.ChatEventPayload$Unknown
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;
    invoke-direct v0, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;-><init>(Lcom/google/gson/JsonElement;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;
    iget-object v1, v3, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;->raw Lcom/google/gson/JsonElement;
    iget-object v4, v4, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;->raw Lcom/google/gson/JsonElement;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getRaw()com.google.gson.JsonElement
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;->raw Lcom/google/gson/JsonElement;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;->raw Lcom/google/gson/JsonElement;
    if-nez v0, +004h
    const/4 v0, 0
    goto +5h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "Unknown(raw="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/im/service/ChatEventPayload$Unknown;->raw Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
