# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;
.super Ljava/lang/Object;
.source "CustomTagStyle.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;-><init>()V
    return-void 
.end method

.method public final fromMessagePartType(java.lang.String  com.bytedance.trae.im.model.MessagePart)com.bytedance.trae.conversation.widget.CustomTagStyle
    .registers 5
    # ins_size=3
    const/4 v0, 0
    if-eqz v3, +08ah
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v1
    sparse-switch v1, +0000085h
    goto/16 +081h
    const-string v1, "file"
    invoke-virtual v3, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +004h
    goto/16 +077h
    const-string v3, ""
    if-eqz v4, +020h
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +01ah
    const-string v1, "name"
    invoke-virtual v4, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +012h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    move-object v0, v4
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +003h
    goto +2h
    move-object v4, v3
    const/16 v0, 46
    invoke-static v4, v0, v3, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v4, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v3, v4, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v4, toLowerCase(...)
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->access$getCODE_EXTENSIONS$cp()Ljava/util/Set;
    move-result-object v4
    invoke-interface v4, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->CODE Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    goto +34h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->FILE Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    goto +31h
    const-string v4, "code"
    invoke-virtual v3, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +28h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->CODE Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    goto +25h
    const-string/jumbo v4, terminal
    invoke-virtual v3, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +1bh
    sget-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->TERMINAL Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    goto +18h
    const-string v4, "folder"
    invoke-virtual v3, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +fh
    sget-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->FOLDER Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    goto +ch
    const-string v4, "agent_review_marker"
    invoke-virtual v3, v4, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->TYPE_CREATE_MR Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    return-object v0
    sparse-switch-payload -76b1f0b9 -4ba2e392 -46686d84 2eaded 2ff57c
.end method

.method public final fromSlashCommandPartType(java.lang.String)com.bytedance.trae.conversation.widget.CustomTagStyle
    .registers 3
    # ins_size=2
    const-string v0, "plan"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->SPEC Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    goto +fh
    const-string/jumbo v0, spec
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->SPEC Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->SLASH_COMMAND Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    return-object v2
.end method
