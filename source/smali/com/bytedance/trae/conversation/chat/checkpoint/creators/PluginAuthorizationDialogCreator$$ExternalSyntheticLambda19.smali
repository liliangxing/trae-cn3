# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:Landroid/view/View;
.field public final synthetic f$2:Landroid/view/View;
.field public final synthetic f$3:Landroid/view/View;
.field public final synthetic f$4:Landroid/view/View;


.method public synthetic constructor <init>(java.lang.String  android.view.View  android.view.View  android.view.View  android.view.View)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;->f$0 Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;->f$1 Landroid/view/View;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;->f$2 Landroid/view/View;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;->f$3 Landroid/view/View;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;->f$4 Landroid/view/View;
    return-void 
.end method

.method public final run()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;->f$0 Ljava/lang/String;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;->f$1 Landroid/view/View;
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;->f$2 Landroid/view/View;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;->f$3 Landroid/view/View;
    iget-object v4, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda19;->f$4 Landroid/view/View;
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->$r8$lambda$YGAaQAuwMY89p52M_M4FKqkjh8I(Ljava/lang/String; Landroid/view/View; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method
