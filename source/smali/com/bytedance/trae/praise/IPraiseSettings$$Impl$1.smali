# Decompiled TRAE business class
# Source DEX: classes4.dex
.class 0x0 Lcom/bytedance/trae/praise/IPraiseSettings$$Impl$1;
.super Ljava/lang/Object;
.source "IPraiseSettings$$Impl.java"

.implements Lcom/bytedance/news/common/settings/internal/InstanceCreator;

.field final synthetic this$0:Lcom/bytedance/trae/praise/IPraiseSettings$$Impl;


.method constructor <init>(com.bytedance.trae.praise.IPraiseSettings$$Impl)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/praise/IPraiseSettings$$Impl$1;->this$0 Lcom/bytedance/trae/praise/IPraiseSettings$$Impl;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public create(java.lang.Class)java.lang.Object
    .registers 2
    # ins_size=2
    const/4 v1, 0
    return-object v1
.end method
