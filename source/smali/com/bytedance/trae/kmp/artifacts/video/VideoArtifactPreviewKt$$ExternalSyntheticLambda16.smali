# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda16;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:I


.method public synthetic constructor <init>(int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda16;->f$0 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=3
    iget v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda16;->f$0 I
    check-cast v2, Landroidx/compose/runtime/Composer;
    check-cast v3, Ljava/lang/Integer;
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    invoke-static v0, v2, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$pKc-tJu76vqHO_Eo81gT_DexmOY(I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
