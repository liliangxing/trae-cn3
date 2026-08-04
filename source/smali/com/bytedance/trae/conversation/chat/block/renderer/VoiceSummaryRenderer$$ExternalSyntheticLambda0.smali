# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Landroid/content/Context;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:Ljava/lang/String;


.method public synthetic constructor <init>(android.content.Context  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$$ExternalSyntheticLambda0;->f$0 Landroid/content/Context;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$$ExternalSyntheticLambda0;->f$0 Landroid/content/Context;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer$$ExternalSyntheticLambda0;->f$2 Ljava/lang/String;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryRenderer;->$r8$lambda$KSYhGc9gSTAM3NmizLRWX1G2Bzo(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String; Landroid/view/View;)V
    return-void 
.end method
