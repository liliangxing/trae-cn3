# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ShareWebViewActivity$showSharePanel$shareModel$1;
.super Lcom/bytedance/ug/sdk/share/api/callback/ShareEventCallback$EmptyShareEventCallBack;
.source "ShareWebViewActivity.kt"


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/ug/sdk/share/api/callback/ShareEventCallback$EmptyShareEventCallBack;-><init>()V
    return-void 
.end method

.method public final onPermissionDeniedEvent(com.bytedance.ug.sdk.share.api.entity.ShareContent  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public final onPermissionGrantedEvent(com.bytedance.ug.sdk.share.api.entity.ShareContent  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public final onPermissionShow(com.bytedance.ug.sdk.share.api.entity.ShareContent  java.lang.String)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public onShareResultEvent(com.bytedance.ug.sdk.share.api.entity.ShareResult)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public final onTokenDialogBtnClick(com.bytedance.ug.sdk.share.impl.model.ShareTokenType  com.bytedance.ug.sdk.share.api.entity.ShareContent)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public final onTokenDialogDismiss(com.bytedance.ug.sdk.share.impl.model.ShareTokenType  com.bytedance.ug.sdk.share.api.entity.ShareContent)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public final onTokenDialogShow(com.bytedance.ug.sdk.share.impl.model.ShareTokenType  com.bytedance.ug.sdk.share.api.entity.ShareContent)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public final onTokenGuideDialogBtnClick(com.bytedance.ug.sdk.share.impl.model.ShareTokenType  com.bytedance.ug.sdk.share.api.entity.ShareContent)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public final onTokenGuideDialogDismiss(com.bytedance.ug.sdk.share.impl.model.ShareTokenType  com.bytedance.ug.sdk.share.api.entity.ShareContent)void
    .registers 3
    # ins_size=3
    return-void 
.end method

.method public final onTokenGuideDialogShow(com.bytedance.ug.sdk.share.impl.model.ShareTokenType  com.bytedance.ug.sdk.share.api.entity.ShareContent)void
    .registers 3
    # ins_size=3
    return-void 
.end method
