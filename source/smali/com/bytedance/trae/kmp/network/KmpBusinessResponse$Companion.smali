# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;
.super Ljava/lang/Object;
.source "KmpBusinessResponse.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;-><init>()V
    return-void 
.end method

.method public final serializer(kotlinx.serialization.KSerializer)kotlinx.serialization.KSerializer
    .registers 3
    # ins_size=2
    const-string/jumbo v0, typeSerial0
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;
    invoke-direct v0, v2, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$$serializer;-><init>(Lkotlinx/serialization/KSerializer;)V
    check-cast v0, Lkotlinx/serialization/KSerializer;
    return-object v0
.end method
