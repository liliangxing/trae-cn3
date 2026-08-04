# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lcom/bytedance/trae/kmp/network/KmpBaseUrlOverrideProvider;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final overrideBaseUrlOrNull(com.bytedance.trae.kmp.network.KmpHostType)java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v1, Lcom/bytedance/trae/kmp/network/AndroidKmpHostResolverBridge;->$r8$lambda$7x-AgWXxPnVWtoEg9RVrh687Tks(Lcom/bytedance/trae/kmp/network/KmpHostType;)Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method
