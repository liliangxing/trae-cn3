# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
.field public final synthetic f$1:Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$4:Landroidx/compose/ui/Modifier;
.field public final synthetic f$5:I
.field public final synthetic f$6:I


.method public synthetic constructor <init>(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState$Ready  com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  androidx.compose.ui.Modifier  int  int)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$1 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$2 Lkotlin/jvm/functions/Function0;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$3 Lkotlin/jvm/functions/Function1;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$4 Landroidx/compose/ui/Modifier;
    iput v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$5 I
    iput v7, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$6 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=3
    iget-object v0, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready;
    iget-object v1, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$1 Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    iget-object v2, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$2 Lkotlin/jvm/functions/Function0;
    iget-object v3, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$3 Lkotlin/jvm/functions/Function1;
    iget-object v4, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$4 Landroidx/compose/ui/Modifier;
    iget v5, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$5 I
    iget v6, v9, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda24;->f$6 I
    move-object v7, v10
    check-cast v7, Landroidx/compose/runtime/Composer;
    check-cast v11, Ljava/lang/Integer;
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v8
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$WnTXWyV1acZ66S4TEbKKth54dTk(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState$Ready; Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v10
    return-object v10
.end method
