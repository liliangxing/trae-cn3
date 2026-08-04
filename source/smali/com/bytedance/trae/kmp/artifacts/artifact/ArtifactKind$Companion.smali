# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind$Companion;
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
    invoke-direct v0, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind$Companion;-><init>()V
    return-void 
.end method

.method private final synthetic get$cachedSerializer()kotlinx.serialization.KSerializer
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind;->access$get$cachedSerializer$delegate$cp()Lkotlin/Lazy;
    move-result-object v0
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlinx/serialization/KSerializer;
    return-object v0
.end method

.method public final serializer()kotlinx.serialization.KSerializer
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/kmp/artifacts/artifact/ArtifactKind$Companion;->get$cachedSerializer()Lkotlinx/serialization/KSerializer;
    move-result-object v0
    return-object v0
.end method
