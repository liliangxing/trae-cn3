# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/share/ShareImageConfigImpl;
.super Ljava/lang/Object;
.source "ShareImageConfigImpl.kt"

.implements Lcom/bytedance/ug/sdk/share/api/depend/IShareImageConfig;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getImageBitmap(java.lang.String  com.bytedance.ug.sdk.share.api.callback.GetImageCallback)void
    .registers 4
    # ins_size=3
    const-string v0, "imageUrl"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "callback"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    return-void 
.end method
