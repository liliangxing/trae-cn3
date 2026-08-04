# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/image/ImageInitiator;
.super Ljava/lang/Object;
.source "ImageInitiator.kt"

.implements Lcom/bytedance/trae/image/api/IImageInitiator;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public initFresco()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/image/fresco/FrescoExt;->INSTANCE Lcom/bytedance/trae/image/fresco/FrescoExt;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, Lcom/bytedance/trae/image/fresco/FrescoExt;->init(Landroid/content/Context;)V
    return-void 
.end method
