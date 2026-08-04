# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$Companion;
.super Ljava/lang/Object;
.source "ArtifactRepository.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository$Companion;-><init>()V
    return-void 
.end method

.method public final getJson()kotlinx.serialization.json.Json
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactRepository;->access$getJson$cp()Lkotlinx/serialization/json/Json;
    move-result-object v0
    return-object v0
.end method
