# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$Companion;
.super Ljava/lang/Object;
.source "ArtifactModels.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$Companion;-><init>()V
    return-void 
.end method

.method public final serializer()kotlinx.serialization.KSerializer
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;->INSTANCE Lcom/bytedance/trae/kmp/artifacts/artifact/DownloadUrlDto$$serializer;
    check-cast v0, Lkotlinx/serialization/KSerializer;
    return-object v0
.end method
