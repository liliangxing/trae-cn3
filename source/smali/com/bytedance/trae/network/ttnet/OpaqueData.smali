# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/OpaqueData;
.super Ljava/lang/Object;
.source "OpaqueData.kt"

.field public static final Companion:Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/network/ttnet/OpaqueData;->Companion Lcom/bytedance/trae/network/ttnet/OpaqueData$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method
