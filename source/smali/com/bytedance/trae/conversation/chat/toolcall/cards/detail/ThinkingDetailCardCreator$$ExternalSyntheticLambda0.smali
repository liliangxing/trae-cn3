# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Z


.method public synthetic constructor <init>(java.lang.String  boolean)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$$ExternalSyntheticLambda0;->f$1 Z
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator$$ExternalSyntheticLambda0;->f$1 Z
    check-cast v3, Landroid/content/Context;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/ThinkingDetailCardCreator;->$r8$lambda$nZUsB_vzb1XQDUaj0z6EMBw73Og(Ljava/lang/String; Z Landroid/content/Context;)Landroid/view/View;
    move-result-object v3
    return-object v3
.end method
