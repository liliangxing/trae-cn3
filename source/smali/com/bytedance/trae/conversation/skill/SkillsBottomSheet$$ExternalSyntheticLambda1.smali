# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.skill.SkillsBottomSheet)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    check-cast v2, Lcom/bytedance/trae/conversation/network/SkillItem;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->$r8$lambda$KbGfV2D2Llm3EXD6gt9oZtW8n3U(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Lcom/bytedance/trae/conversation/network/SkillItem;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
