# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda9;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/ConversationActivity;
.field public final synthetic f$1:Lkotlin/jvm/internal/Ref$ObjectRef;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.ConversationActivity  kotlin.jvm.internal.Ref$ObjectRef)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda9;->f$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda9;->f$1 Lkotlin/jvm/internal/Ref$ObjectRef;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda9;->f$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$$ExternalSyntheticLambda9;->f$1 Lkotlin/jvm/internal/Ref$ObjectRef;
    check-cast v3, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity;->$r8$lambda$UTR7uur_lDsSbmQBwXRhgmm2PhM(Lcom/bytedance/trae/conversation/ConversationActivity; Lkotlin/jvm/internal/Ref$ObjectRef; Lcom/bytedance/trae/conversation/devices/MobileDevice;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
