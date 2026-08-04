# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/view/View$OnClickListener;

.field public final synthetic f$0:Landroid/view/View;
.field public final synthetic f$1:Landroid/widget/TextView;
.field public final synthetic f$10:Landroid/view/View;
.field public final synthetic f$2:Landroid/view/View;
.field public final synthetic f$3:Ljava/lang/String;
.field public final synthetic f$4:Landroid/content/Context;
.field public final synthetic f$5:Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;
.field public final synthetic f$6:Landroid/view/View;
.field public final synthetic f$7:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$8:Landroid/content/res/ColorStateList;
.field public final synthetic f$9:Landroid/view/View;


.method public synthetic constructor <init>(android.view.View  android.widget.TextView  android.view.View  java.lang.String  android.content.Context  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator  android.view.View  kotlin.jvm.functions.Function1  android.content.res.ColorStateList  android.view.View  android.view.View)void
    .registers 12
    # ins_size=12
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$0 Landroid/view/View;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$1 Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$2 Landroid/view/View;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$3 Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$4 Landroid/content/Context;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$5 Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$6 Landroid/view/View;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$7 Lkotlin/jvm/functions/Function1;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$8 Landroid/content/res/ColorStateList;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$9 Landroid/view/View;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$10 Landroid/view/View;
    return-void 
.end method

.method public final onClick(android.view.View)void
    .registers 14
    # ins_size=2
    iget-object v0, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$0 Landroid/view/View;
    iget-object v1, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$1 Landroid/widget/TextView;
    iget-object v2, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$2 Landroid/view/View;
    iget-object v3, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$3 Ljava/lang/String;
    iget-object v4, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$4 Landroid/content/Context;
    iget-object v5, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$5 Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;
    iget-object v6, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$6 Landroid/view/View;
    iget-object v7, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$7 Lkotlin/jvm/functions/Function1;
    iget-object v8, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$8 Landroid/content/res/ColorStateList;
    iget-object v9, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$9 Landroid/view/View;
    iget-object v10, v12, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$$ExternalSyntheticLambda13;->f$10 Landroid/view/View;
    move-object v11, v13
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator;->$r8$lambda$BnW1i2miPiojtG0vpgY11K7juZc(Landroid/view/View; Landroid/widget/TextView; Landroid/view/View; Ljava/lang/String; Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator; Landroid/view/View; Lkotlin/jvm/functions/Function1; Landroid/content/res/ColorStateList; Landroid/view/View; Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method
