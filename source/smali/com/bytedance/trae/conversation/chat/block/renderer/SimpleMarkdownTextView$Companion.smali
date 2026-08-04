# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView$Companion;
.super Ljava/lang/Object;
.source "SimpleMarkdownTextView.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView$Companion;-><init>()V
    return-void 
.end method

.method public final getDefaultHeaderConfig()com.bytedance.trae.conversation.chat.block.renderer.HeaderStyleConfig
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;->access$getDefaultHeaderConfig$cp()Lcom/bytedance/trae/conversation/chat/block/renderer/HeaderStyleConfig;
    move-result-object v0
    return-object v0
.end method
