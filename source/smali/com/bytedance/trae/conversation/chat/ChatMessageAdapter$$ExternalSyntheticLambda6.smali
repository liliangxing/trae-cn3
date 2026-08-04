# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Ljava/lang/Runnable;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.ChatMessageAdapter  java.lang.String  java.lang.Runnable)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda6;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda6;->f$2 Ljava/lang/Runnable;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda6;->f$1 Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter$$ExternalSyntheticLambda6;->f$2 Ljava/lang/Runnable;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter;->$r8$lambda$2aMCnOhBMVvlNAjsnLQycQHGLX4(Lcom/bytedance/trae/conversation/chat/ChatMessageAdapter; Ljava/lang/String; Ljava/lang/Runnable;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
