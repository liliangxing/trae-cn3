# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda5;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
.field public final synthetic f$1:Ljava/util/List;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function0;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.ChatMessageAdapter  java.util.List  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda5;->f$1 Ljava/util/List;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda5;->f$2 Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda5;->f$0 Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda5;->f$1 Ljava/util/List;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda5;->f$2 Lkotlin/jvm/functions/Function0;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->$r8$lambda$cd8LKvRrhkYzK4Bo6drDwqeKhko(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Ljava/util/List; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
