# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/skill/SkillsAdapter$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/network/SkillItem;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.skill.SkillsAdapter  com.bytedance.trae.conversation.network.SkillItem)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/network/SkillItem;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/conversation/skill/SkillsAdapter;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/skill/SkillsAdapter$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/conversation/network/SkillItem;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/skill/SkillsAdapter;->$r8$lambda$XAP204xPymlw-GKzU-URD8FeVJI(Lcom/bytedance/trae/conversation/skill/SkillsAdapter; Lcom/bytedance/trae/conversation/network/SkillItem; Landroid/view/View;)V
    return-void 
.end method
