# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;
.super Ljava/lang/Object;
.source "PureShowWidgetFullscreenActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$consumePayload(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenActivity$Companion  java.lang.String)com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenPayload
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;->consumePayload(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenPayload;
    move-result-object v0
    return-object v0
.end method

.method private final buildPayloadKey(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPayload  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->getWidgetId()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +005h
    const-string/jumbo v3, widget
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    const/16 v3, 58
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    invoke-virtual v4, Ljava/lang/String;->hashCode()I
    move-result v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final consumePayload(java.lang.String)com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetFullscreenPayload
    .registers 4
    # ins_size=2
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +004h
    const/4 v3, 0
    return-object v3
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->access$getPayloadCache$cp()Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;
    move-result-object v0
    monitor-enter v0
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->access$getPayloadCache$cp()Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;
    move-result-object v1
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenPayload;
    monitor-exit v0
    return-object v3
    move-exception v3
    monitor-exit v0
    throw v3
    :try_start_0x18
.end method

.method public final start$conversation_mainlandRelease(android.content.Context  com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPayload)void
    .registers 8
    # ins_size=3
    const-string v0, "context"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "payload"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->getWidgetCode()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    invoke-direct v5, v7, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion;->buildPayloadKey(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->access$getPayloadCache$cp()Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;
    move-result-object v2
    monitor-enter v2
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;->access$getPayloadCache$cp()Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity$Companion$payloadCache$1;
    move-result-object v3
    check-cast v3, Ljava/util/Map;
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenPayload;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->getTitle()Ljava/lang/String;
    move-result-object v7
    invoke-direct v4, v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenPayload;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v3, v1, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v2
    new-instance v7, Landroid/content/Intent;
    const-class v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetFullscreenActivity;
    invoke-direct v7, v6, v0, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    const-string v0, "extra_payload_key"
    invoke-virtual v7, v0, v1, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v7
    const-string v0, "putExtra(...)"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v6, Landroid/app/Activity;
    if-nez v0, +007h
    const/high16 v0, 268435456
    invoke-virtual v7, v0, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    invoke-virtual v6, v7, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
    move-exception v6
    monitor-exit v2
    throw v6
    :try_start_0x27
.end method
