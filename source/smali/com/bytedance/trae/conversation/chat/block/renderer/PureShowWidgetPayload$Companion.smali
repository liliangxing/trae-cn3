# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload$Companion;
.super Ljava/lang/Object;
.source "PureShowWidgetInlineView.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload$Companion;-><init>()V
    return-void 
.end method

.method public final from(com.bytedance.trae.im.model.ParsedToolCallInfo)com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPayload
    .registers 10
    # ins_size=2
    const-string/jumbo v0, toolCallInfo
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v0
    new-instance v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    const-string/jumbo v1, widget_code
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineViewKt;->access$readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    move-object v2, v1
    const-string/jumbo v1, widget_id
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineViewKt;->access$readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +008h
    invoke-virtual v9, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getId()Ljava/lang/String;
    move-result-object v9
    move-object v3, v9
    goto +2h
    move-object v3, v1
    const-string/jumbo v9, title
    invoke-static v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineViewKt;->access$readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    const-string v9, "mode"
    invoke-static v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineViewKt;->access$readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    const-string v9, "loading_messages"
    invoke-static v0, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineViewKt;->access$readStringArray(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/util/List;
    move-result-object v6
    move-object v1, v7
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    return-object v7
.end method
