# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/ConversationActivity;
.field public final synthetic f$1:Z
.field public final synthetic f$2:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.ConversationActivity  boolean  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1$$ExternalSyntheticLambda0;->f$1 Z
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iget-boolean v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1$$ExternalSyntheticLambda0;->f$1 Z
    iget-object v2, v3, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$observeViewModel$4$1;->$r8$lambda$3IdNu1VwS30kJeLoFMcSY676AnQ(Lcom/bytedance/trae/conversation/ConversationActivity; Z Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
