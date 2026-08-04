# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer$DefaultImpls;
.super Ljava/lang/Object;
.source "IBlockRenderer.kt"


.method public static update(com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer  android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
