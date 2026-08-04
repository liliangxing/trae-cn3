# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment$Companion;
.super Ljava/lang/Object;
.source "FallbackDetailFragment.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment$Companion;-><init>()V
    return-void 
.end method

.method public final newInstance(java.lang.String  java.lang.String)com.bytedance.trae.conversation.chat.detail.FallbackDetailFragment
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;-><init>()V
    new-instance v1, Landroid/os/Bundle;
    invoke-direct v1, Landroid/os/Bundle;-><init>()V
    if-eqz v4, +007h
    const-string v2, "input"
    invoke-virtual v1, v2, v4, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    if-eqz v5, +007h
    const-string v4, "output"
    invoke-virtual v1, v4, v5, Landroid/os/Bundle;->putString(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;->setArguments(Landroid/os/Bundle;)V
    return-object v0
.end method
