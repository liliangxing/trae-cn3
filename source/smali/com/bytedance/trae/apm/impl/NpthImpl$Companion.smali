# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/NpthImpl$Companion;
.super Ljava/lang/Object;
.source "NpthImpl.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/NpthImpl$Companion;-><init>()V
    return-void 
.end method

.method public final getTAG()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/apm/impl/NpthImpl;->access$getTAG$cp()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
