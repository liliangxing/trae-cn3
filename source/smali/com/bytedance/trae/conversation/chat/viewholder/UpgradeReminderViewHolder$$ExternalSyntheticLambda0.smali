# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function1;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$$ExternalSyntheticLambda0;->f$0 Lkotlin/jvm/functions/Function1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;->$r8$lambda$U1Gd4OwMMkVq4c31JhBW29O8sUY(Lkotlin/jvm/functions/Function1; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method
