# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/widget/ProgressBar;
.field public final synthetic f$1:Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
.field public final synthetic f$2:Ljava/lang/String;
.field public final synthetic f$3:Landroid/widget/ImageView;


.method public synthetic constructor <init>(android.widget.ProgressBar  com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationBottomSheet  java.lang.String  android.widget.ImageView)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;->f$0 Landroid/widget/ProgressBar;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;->f$1 Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;->f$2 Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;->f$3 Landroid/widget/ImageView;
    return-void 
.end method

.method public final run()void
    .registers 5
    # ins_size=1
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;->f$0 Landroid/widget/ProgressBar;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;->f$1 Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;->f$2 Ljava/lang/String;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet$$ExternalSyntheticLambda6;->f$3 Landroid/widget/ImageView;
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet;->$r8$lambda$-KY7SxzYgMZMXDTEikdyf_JEBls(Landroid/widget/ProgressBar; Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationBottomSheet; Ljava/lang/String; Landroid/widget/ImageView;)V
    return-void 
.end method
