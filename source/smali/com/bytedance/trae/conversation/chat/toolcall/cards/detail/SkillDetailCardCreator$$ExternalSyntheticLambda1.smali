# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator  java.lang.String  com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator$Companion$SkillDetailParsed)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;
    check-cast v4, Landroid/content/Context;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator;->$r8$lambda$X0qmeui4D_EN_C-MOS1EJKkDRpg(Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed; Landroid/content/Context;)Landroid/view/View;
    move-result-object v4
    return-object v4
.end method
