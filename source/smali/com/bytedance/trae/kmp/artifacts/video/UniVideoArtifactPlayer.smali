# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;
.super Ljava/lang/Object;
.source "VideoArtifactPreview.kt"

.implements Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer;

.field public static final $stable:I
.field private final engine:Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
.field private listener:Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
.field private final playbackListener:Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;


.method public static synthetic $r8$lambda$jCQ3DHN_MZ-18J5VaifDQa_RRag(kotlin.jvm.functions.Function1  int  boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->seek$lambda$0(Lkotlin/jvm/functions/Function1; I Z)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.vcloud.uniplayer.UniAVEngine)void
    .registers 3
    # ins_size=2
    const-string v0, "engine"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->engine Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    new-instance v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;-><init>(Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;)V
    iput-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->playbackListener Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;
    check-cast v0, Lcom/bytedance/vcloud/uniplayer/PlaybackListener;
    invoke-interface v2, v0, Lcom/bytedance/vcloud/uniplayer/UniAVEngine;->addListener(Lcom/bytedance/vcloud/uniplayer/PlaybackListener;)V
    return-void 
.end method

.method public static final synthetic access$getListener$p(com.bytedance.trae.kmp.artifacts.video.UniVideoArtifactPlayer)com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer$Listener
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->listener Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
    return-object v0
.end method

.method private static final seek$lambda$0(kotlin.jvm.functions.Function1  int  boolean)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final getEngine()com.bytedance.vcloud.uniplayer.UniAVEngine
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->engine Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    return-object v0
.end method

.method public pause()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->engine Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    invoke-interface v0, Lcom/bytedance/vcloud/uniplayer/UniAVEngine;->pause()V
    return-void 
.end method

.method public play()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->engine Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    invoke-interface v0, Lcom/bytedance/vcloud/uniplayer/UniAVEngine;->play()V
    return-void 
.end method

.method public release()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->engine Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    iget-object v1, v2, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->playbackListener Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$playbackListener$1;
    check-cast v1, Lcom/bytedance/vcloud/uniplayer/PlaybackListener;
    invoke-interface v0, v1, Lcom/bytedance/vcloud/uniplayer/UniAVEngine;->removeListener(Lcom/bytedance/vcloud/uniplayer/PlaybackListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->engine Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    invoke-interface v0, Lcom/bytedance/vcloud/uniplayer/UniAVEngine;->release()V
    return-void 
.end method

.method public seek(long  kotlin.jvm.functions.Function1)int
    .registers 7
    # ins_size=4
    const-string v0, "completion"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->engine Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    sget-object v1, Lcom/bytedance/vcloud/uniplayer/SeekMode;->UniSeekModeAny Lcom/bytedance/vcloud/uniplayer/SeekMode;
    new-instance v2, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$$ExternalSyntheticLambda0;
    invoke-direct v2, v6, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-interface v0, v4, v5, v1, v2, Lcom/bytedance/vcloud/uniplayer/UniAVEngine;->seek(J Lcom/bytedance/vcloud/uniplayer/SeekMode; Lkotlin/jvm/functions/Function2;)I
    move-result v4
    return v4
.end method

.method public setListener(com.bytedance.trae.kmp.artifacts.video.VideoArtifactPlayer$Listener)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->listener Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPlayer$Listener;
    return-void 
.end method

.method public setSpeed(float)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->engine Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    invoke-interface v0, v2, Lcom/bytedance/vcloud/uniplayer/UniAVEngine;->setSpeed(F)V
    return-void 
.end method

.method public stop()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/kmp/artifacts/video/UniVideoArtifactPlayer;->engine Lcom/bytedance/vcloud/uniplayer/UniAVEngine;
    const/4 v1, 0
    invoke-interface v0, v1, Lcom/bytedance/vcloud/uniplayer/UniAVEngine;->stop(Z)V
    return-void 
.end method
