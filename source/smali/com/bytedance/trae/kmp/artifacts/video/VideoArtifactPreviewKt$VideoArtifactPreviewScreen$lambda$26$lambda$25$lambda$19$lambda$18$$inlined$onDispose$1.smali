# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18$$inlined$onDispose$1;
.super Ljava/lang/Object;
.source "Effects.kt"

.implements Landroidx/compose/runtime/DisposableEffectResult;

.field final synthetic $onDetachPlayer$inlined:Lkotlin/jvm/functions/Function1;
.field final synthetic $player$inlined:Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;


.method public constructor <init>(kotlin.jvm.functions.Function1  com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18$$inlined$onDispose$1;->$onDetachPlayer$inlined Lkotlin/jvm/functions/Function1;
    iput-object v2, v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18$$inlined$onDispose$1;->$player$inlined Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public dispose()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18$$inlined$onDispose$1;->$onDetachPlayer$inlined Lkotlin/jvm/functions/Function1;
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewKt$VideoArtifactPreviewScreen$lambda$26$lambda$25$lambda$19$lambda$18$$inlined$onDispose$1;->$player$inlined Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method
