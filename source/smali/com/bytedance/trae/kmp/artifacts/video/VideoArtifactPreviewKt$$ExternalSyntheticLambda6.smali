# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$3:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$4:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$5:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$6:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$7:Landroidx/compose/ui/Modifier;
.field public final synthetic f$8:I
.field public final synthetic f$9:I


.method public synthetic constructor <init>(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewState  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  androidx.compose.ui.Modifier  int  int)void
    .registers 11
    # ins_size=11
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$1 Lkotlin/jvm/functions/Function1;
    iput-object v3, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$2 Lkotlin/jvm/functions/Function1;
    iput-object v4, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$3 Lkotlin/jvm/functions/Function0;
    iput-object v5, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$4 Lkotlin/jvm/functions/Function0;
    iput-object v6, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$5 Lkotlin/jvm/functions/Function1;
    iput-object v7, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$6 Lkotlin/jvm/functions/Function0;
    iput-object v8, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$7 Landroidx/compose/ui/Modifier;
    iput v9, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$8 I
    iput v10, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$9 I
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=3
    iget-object v0, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState;
    iget-object v1, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$1 Lkotlin/jvm/functions/Function1;
    iget-object v2, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$2 Lkotlin/jvm/functions/Function1;
    iget-object v3, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$3 Lkotlin/jvm/functions/Function0;
    iget-object v4, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$4 Lkotlin/jvm/functions/Function0;
    iget-object v5, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$5 Lkotlin/jvm/functions/Function1;
    iget-object v6, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$6 Lkotlin/jvm/functions/Function0;
    iget-object v7, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$7 Landroidx/compose/ui/Modifier;
    iget v8, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$8 I
    iget v9, v12, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$$ExternalSyntheticLambda6;->f$9 I
    move-object v10, v13
    check-cast v10, Landroidx/compose/runtime/Composer;
    check-cast v14, Ljava/lang/Integer;
    invoke-virtual v14, Ljava/lang/Integer;->intValue()I
    move-result v11
    invoke-static/range v0 ... v11, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt;->$r8$lambda$N64agJmVKZ4_VYGCNSpFX9HI0Xc(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewState; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Landroidx/compose/ui/Modifier; I I Landroidx/compose/runtime/Composer; I)Lkotlin/Unit;
    move-result-object v13
    return-object v13
.end method
