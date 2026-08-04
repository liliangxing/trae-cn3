# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$Companion;
.super Ljava/lang/Object;
.source "VideoArtifactPreviewActivity.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity$Companion;-><init>()V
    return-void 
.end method

.method public final start(android.content.Context  com.bytedance.trae.kmp.artifacts.artifact.ArtifactOpenRequest)void
    .registers 6
    # ins_size=3
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, request
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Landroid/content/Intent;
    const-class v1, Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;
    invoke-direct v0, v4, v1, Landroid/content/Intent;-><init>(Landroid/content/Context; Ljava/lang/Class;)V
    invoke-static Lcom/bytedance/trae/kmp/artifacts/video/VideoArtifactPreviewActivity;->access$getJson$cp()Lkotlinx/serialization/json/Json;
    move-result-object v1
    check-cast v1, Lkotlinx/serialization/StringFormat;
    invoke-interface v1, Lkotlinx/serialization/StringFormat;->getSerializersModule()Lkotlinx/serialization/modules/SerializersModule;
    sget-object v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest;->Companion Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactOpenRequest$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v2
    check-cast v2, Lkotlinx/serialization/SerializationStrategy;
    invoke-interface v1, v2, v5, Lkotlinx/serialization/StringFormat;->encodeToString(Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v1, video_artifact_open_request
    invoke-virtual v0, v1, v5, Landroid/content/Intent;->putExtra(Ljava/lang/String; Ljava/lang/String;)Landroid/content/Intent;
    move-result-object v5
    invoke-virtual v4, v5, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    return-void 
.end method
