# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function3;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=4
    check-cast v1, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    check-cast v2, Ljava/util/Map;
    check-cast v3, Ljava/lang/String;
    invoke-static v1, v2, v3, Lcom/bytedance/trae/kmp/network/NativeKmpHttpHeaderProvider;->$r8$lambda$LwXylvH4NlCLg16jHyNyZFjL23U(Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Ljava/util/Map; Ljava/lang/String;)Ljava/util/Map;
    move-result-object v1
    return-object v1
.end method
