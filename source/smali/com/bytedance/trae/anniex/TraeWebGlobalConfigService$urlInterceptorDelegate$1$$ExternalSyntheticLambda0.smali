# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function4;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object  java.lang.Object  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    check-cast v1, Landroid/webkit/WebView;
    check-cast v2, Ljava/lang/String;
    check-cast v3, Ljava/util/Map;
    check-cast v4, Lkotlin/jvm/functions/Function2;
    invoke-static v1, v2, v3, v4, Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService$urlInterceptorDelegate$1;->$r8$lambda$xci-75dAQOba_O2ZP5jzAwHFoT0(Landroid/webkit/WebView; Ljava/lang/String; Ljava/util/Map; Lkotlin/jvm/functions/Function2;)Lkotlin/Unit;
    move-result-object v1
    return-object v1
.end method
