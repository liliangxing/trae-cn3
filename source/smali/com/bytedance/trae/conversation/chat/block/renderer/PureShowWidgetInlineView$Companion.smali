# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;
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
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;-><init>()V
    return-void 
.end method

.method public final buildHeightCacheKey(com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPayload  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    const-string v0, "payload"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, widgetCode
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->getWidgetId()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +011h
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    goto +2h
    const/4 v3, 0
    if-nez v3, +005h
    const-string/jumbo v3, widget
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    const/16 v0, 58
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v4, Ljava/lang/String;->hashCode()I
    move-result v4
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final getCachedHeight(java.lang.String)java.lang.Integer
    .registers 3
    # ins_size=2
    if-nez v2, +004h
    const/4 v2, 0
    return-object v2
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;->getHEIGHT_CACHE()Ljava/util/LinkedHashMap;
    move-result-object v0
    invoke-virtual v0, v2, Ljava/util/LinkedHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Integer;
    return-object v2
.end method

.method public final getHEIGHT_CACHE()java.util.LinkedHashMap
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$getHEIGHT_CACHE$cp()Ljava/util/LinkedHashMap;
    move-result-object v0
    return-object v0
.end method

.method public final getHEIGHT_CHECK_DELAYS_MS()long[]
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;->access$getHEIGHT_CHECK_DELAYS_MS$cp()[J
    move-result-object v0
    return-object v0
.end method

.method public final putCachedHeight(java.lang.String  int)void
    .registers 4
    # ins_size=3
    if-eqz v2, +013h
    const/4 v0, 1
    if-gt v3, v0, +003h
    goto +eh
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView$Companion;->getHEIGHT_CACHE()Ljava/util/LinkedHashMap;
    move-result-object v0
    check-cast v0, Ljava/util/Map;
    invoke-interface v0, v2, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
