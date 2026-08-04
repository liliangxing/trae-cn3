# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/util/List;


.method public synthetic constructor <init>(java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda0;->f$0 Ljava/util/List;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator$$ExternalSyntheticLambda0;->f$0 Ljava/util/List;
    check-cast v2, Landroid/content/Context;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/RunMCPCardCreator;->$r8$lambda$nhX0V2pXQ8E7qCHLsKHSoW382-4(Ljava/util/List; Landroid/content/Context;)Landroid/widget/LinearLayout;
    move-result-object v2
    return-object v2
.end method
