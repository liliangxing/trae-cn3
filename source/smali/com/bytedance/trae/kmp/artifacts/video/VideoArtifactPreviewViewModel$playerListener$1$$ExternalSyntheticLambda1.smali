# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    invoke-static v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel$playerListener$1;->$r8$lambda$DroLhKLii2uELPrAt4tWVkmx-0o(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;)Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    move-result-object v1
    return-object v1
.end method
