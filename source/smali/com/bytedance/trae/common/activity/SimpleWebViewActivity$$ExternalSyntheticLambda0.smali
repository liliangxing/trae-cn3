# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/widget/PopupMenu$OnMenuItemClickListener;

.field public final synthetic f$0:Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
.field public final synthetic f$1:Ljava/lang/String;


.method public synthetic constructor <init>(com.bytedance.trae.common.activity.SimpleWebViewActivity  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
    iput-object v2, v0, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    return-void 
.end method

.method public final onMenuItemClick(android.view.MenuItem)boolean
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;
    iget-object v1, v2, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/common/activity/SimpleWebViewActivity;->$r8$lambda$px3AAOJji4Z1HL4_4FncIitMkaU(Lcom/bytedance/trae/common/activity/SimpleWebViewActivity; Ljava/lang/String; Landroid/view/MenuItem;)Z
    move-result v3
    return v3
.end method
