# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;
.super Ljava/lang/Object;
.source "VideoArtifactPreviewActivity.kt"

.implements Landroidx/lifecycle/ViewModelProvider$Factory;

.field private final request:Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
.field final synthetic this$0:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;


.method public constructor <init>(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity  com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, request
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;->this$0 Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v3, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;->request Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    return-void 
.end method

.method public static final synthetic access$getRequest$p(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory)com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;->request Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    return-object v0
.end method

.method public create(java.lang.Class)androidx.lifecycle.ViewModel
    .registers 5
    # ins_size=2
    const-string v0, "modelClass"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory;->request Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;
    new-instance v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;
    const/4 v2, 0
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory$create$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$VideoArtifactPreviewViewModelFactory; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function1;
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewViewModel;-><init>(Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest; Lkotlin/jvm/functions/Function1;)V
    check-cast v4, Landroidx/lifecycle/ViewModel;
    return-object v4
.end method
