# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/CliDto$Companion;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto$Companion;-><init>()V
    return-void 
.end method

.method public final serializer()kotlinx.serialization.KSerializer
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/CliDto$$serializer;
    check-cast v0, Lkotlinx/serialization/KSerializer;
    return-object v0
.end method
