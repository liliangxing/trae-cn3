# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HostEntry$Companion;
.super Ljava/lang/Object;
.source "HostResolver.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/network/HostEntry$Companion;-><init>()V
    return-void 
.end method

.method public final builder()com.bytedance.trae.network.HostEntry$Builder
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/network/HostEntry$Builder;
    invoke-direct v0, Lcom/bytedance/trae/network/HostEntry$Builder;-><init>()V
    return-object v0
.end method
