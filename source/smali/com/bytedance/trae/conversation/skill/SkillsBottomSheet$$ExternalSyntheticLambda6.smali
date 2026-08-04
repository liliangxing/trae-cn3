# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
.field public final synthetic f$1:Landroid/widget/LinearLayout;
.field public final synthetic f$2:Landroid/widget/LinearLayout;
.field public final synthetic f$3:Landroid/widget/TextView;
.field public final synthetic f$4:Landroidx/recyclerview/widget/RecyclerView;
.field public final synthetic f$5:Landroid/widget/FrameLayout;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.skill.SkillsBottomSheet  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  androidx.recyclerview.widget.RecyclerView  android.widget.FrameLayout)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$1 Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$2 Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$3 Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$4 Landroidx/recyclerview/widget/RecyclerView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$5 Landroid/widget/FrameLayout;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    iget-object v0, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$1 Landroid/widget/LinearLayout;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$2 Landroid/widget/LinearLayout;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$3 Landroid/widget/TextView;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$4 Landroidx/recyclerview/widget/RecyclerView;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet$$ExternalSyntheticLambda6;->f$5 Landroid/widget/FrameLayout;
    move-object v6, v8
    check-cast v6, Ljava/util/List;
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet;->$r8$lambda$Ni4eUMurg_Nk5zarVRX50ABGKf0(Lcom/bytedance/trae/conversation/skill/SkillsBottomSheet; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/FrameLayout; Ljava/util/List;)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
