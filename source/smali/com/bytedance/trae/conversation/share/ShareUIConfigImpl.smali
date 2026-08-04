# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/share/ShareUIConfigImpl;
.super Lcom/bytedance/ug/sdk/share/keep/impl/UIConfigImpl;
.source "ShareUIConfigImpl.kt"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/ug/sdk/share/keep/impl/UIConfigImpl;-><init>()V
    return-void 
.end method

.method public getSharePanel(android.app.Activity)com.bytedance.ug.sdk.share.impl.ui.panel.ISharePanel
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/bytedance/ug/sdk/share/keep/impl/UIConfigImpl;->getSharePanel(Landroid/app/Activity;)Lcom/bytedance/ug/sdk/share/impl/ui/panel/ISharePanel;
    move-result-object v2
    const-string v0, "getSharePanel(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method
