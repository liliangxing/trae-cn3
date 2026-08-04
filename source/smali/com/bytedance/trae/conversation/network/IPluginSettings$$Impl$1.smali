# Decompiled TRAE business class
# Source DEX: classes5.dex
.class 0x0 Lcom/bytedance/trae/conversation/network/IPluginSettings$$Impl$1;
.super Ljava/lang/Object;
.source "IPluginSettings$$Impl.java"

.implements Lcom/bytedance/news/common/settings/internal/InstanceCreator;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/network/IPluginSettings$$Impl;


.method constructor <init>(com.bytedance.trae.conversation.network.IPluginSettings$$Impl)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/IPluginSettings$$Impl$1;->this$0 Lcom/bytedance/trae/conversation/network/IPluginSettings$$Impl;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public create(java.lang.Class)java.lang.Object
    .registers 2
    # ins_size=2
    const/4 v1, 0
    return-object v1
.end method
