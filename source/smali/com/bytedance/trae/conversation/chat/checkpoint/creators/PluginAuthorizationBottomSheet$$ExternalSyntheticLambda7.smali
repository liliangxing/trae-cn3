# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda7;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
.field public final synthetic f$1:Landroid/widget/ProgressBar;
.field public final synthetic f$2:Landroid/widget/ImageView;


.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  android.widget.ProgressBar  android.widget.ImageView)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda7;->f$1 Landroid/widget/ProgressBar;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda7;->f$2 Landroid/widget/ImageView;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda7;->f$0 Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda7;->f$1 Landroid/widget/ProgressBar;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda7;->f$2 Landroid/widget/ImageView;
    check-cast v4, Ljava/lang/String;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->$r8$lambda$KT3MIZuKrtUFnRsrkkEw2c7O4EY(Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Landroid/widget/ProgressBar; Landroid/widget/ImageView; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
