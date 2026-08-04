# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;
.super Ljava/lang/Object;
.source "BlockRendererFactory.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;-><init>()V
    return-void 
.end method

.method public final getInstance()com.bytedance.trae.conversation.chat.block.renderer.BlockRendererFactory
    .registers 3
    # ins_size=1
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->access$getInstance$cp()Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    move-result-object v0
    if-nez v0, +01bh
    monitor-enter v2
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->access$getInstance$cp()Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    move-result-object v0
    if-nez v0, +00fh
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;-><init>()V
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->access$registerDefaults(Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory$Companion;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;->access$setInstance$cp(Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;)V
    monitor-exit v2
    goto +4h
    move-exception v0
    monitor-exit v2
    throw v0
    return-object v0
    :try_start_0x7
.end method
