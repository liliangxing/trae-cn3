# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;
.super Ljava/lang/Object;
.source "ToolcallGroupRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field public static final BLOCK_TAG:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$Companion;
.field private keyCounter:I
.field private final managers:Ljava/util/Map;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;->managers Ljava/util/Map;
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup)android.view.View
    .registers 6
    # ins_size=3
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;-><init>()V
    iget v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;->keyCounter I
    add-int/lit8 v2, v1, 1
    iput v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;->keyCounter I
    invoke-virtual v0, v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;)Landroid/view/View;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/conversation/R$id;->tag_toolcall_group_key I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-virtual v4, v5, v2, Landroid/view/View;->setTag(I Ljava/lang/Object;)V
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;->managers Ljava/util/Map;
    new-instance v2, Ljava/lang/ref/WeakReference;
    invoke-direct v2, v0, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    invoke-interface v1, v5, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-object v4
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$ToolcallGroup)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tag_toolcall_group_key I
    invoke-virtual v2, v0, Landroid/view/View;->getTag(I)Ljava/lang/Object;
    move-result-object v2
    instance-of v0, v2, Ljava/lang/Integer;
    if-eqz v0, +005h
    check-cast v2, Ljava/lang/Integer;
    goto +2h
    const/4 v2, 0
    if-eqz v2, +020h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;->managers Ljava/util/Map;
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/ref/WeakReference;
    if-eqz v2, +00eh
    invoke-virtual v2, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;
    if-nez v2, +003h
    goto +4h
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;->update(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;)V
    return-void 
.end method
