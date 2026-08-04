# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;
.super Ljava/lang/Object;
.source "ShareKeyConfigImpl.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic getWEIXIN_KEY_AVAILABLE$annotations()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public final getWEIXIN_KEY_AVAILABLE()boolean
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->access$getWEIXIN_KEY_AVAILABLE$cp()Z
    move-result v0
    return v0
.end method

.method public final setWEIXIN_KEY_AVAILABLE(boolean)void
    .registers 2
    # ins_size=2
    invoke-static v1, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->access$setWEIXIN_KEY_AVAILABLE$cp(Z)V
    return-void 
.end method
