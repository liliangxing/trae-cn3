# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "BrainstormVoiceHistorySheet.kt"

.field private final badgeContainer:Landroid/view/View;
.field private final badgeIcon:Landroid/widget/ImageView;
.field private final badgeText:Landroid/widget/TextView;
.field private final contentView:Landroid/widget/TextView;


.method public constructor <init>(android.view.View)void
    .registers 4
    # ins_size=2
    const-string v0, "itemView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_voice_history_content I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->contentView Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->subtask_badge_container I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->badgeContainer Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_subtask_status_icon I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->badgeIcon Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_subtask_status_text I
    invoke-virtual v3, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/TextView;
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->badgeText Landroid/widget/TextView;
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet$HistoryRow$AssistantText)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, row
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->contentView Landroid/widget/TextView;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;->getContent()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$HistoryRow$AssistantText;->getStatus()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskProtocolKt;->mapHeadStatusToTerminal(Ljava/lang/String;)Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;
    move-result-object v3
    if-nez v3, +004h
    const/4 v3, -1
    goto +9h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/subtask/SubTaskRenderState;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 1
    const/4 v1, 0
    if-eq v3, v0, +021h
    const/4 v0, 2
    if-eq v3, v0, +00ah
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->badgeContainer Landroid/view/View;
    const/16 v0, 8
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    goto +28h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->badgeContainer Landroid/view/View;
    invoke-virtual v3, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->badgeIcon Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_subtask_failed I
    invoke-virtual v3, v0, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->badgeText Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_subtask_failed I
    invoke-virtual v3, v0, Landroid/widget/TextView;->setText(I)V
    goto +14h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->badgeContainer Landroid/view/View;
    invoke-virtual v3, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->badgeIcon Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_subtask_done I
    invoke-virtual v3, v0, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$AssistantRowVH;->badgeText Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_subtask_done I
    invoke-virtual v3, v0, Landroid/widget/TextView;->setText(I)V
    return-void 
.end method
