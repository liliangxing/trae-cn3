# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda15;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$1:I


.method public synthetic constructor <init>(kotlin.jvm.functions.Function0  int)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda15;->f$0 Lkotlin/jvm/functions/Function0;
    iput v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda15;->f$1 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda15;->f$0 Lkotlin/jvm/functions/Function0;
    iget v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda15;->f$1 I
    check-cast v3, Landroidx/compose/runtime/Composer;
    check-cast v4, Ljava/lang/Integer;
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v4
    invoke-static v0, v1, v3, v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$24BWWUPUT3T1gVE66C6Tv0XuYp8(Lkotlin/jvm/functions/Function0; I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
