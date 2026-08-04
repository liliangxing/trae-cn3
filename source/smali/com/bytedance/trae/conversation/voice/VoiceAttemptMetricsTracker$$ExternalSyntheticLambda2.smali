# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/String;
    check-cast v2, Lorg/json/JSONObject;
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/voice/VoiceAttemptMetricsTracker;->$r8$lambda$bRXDNbkuk0wJGY2-ZeVrA7tKlos(Ljava/lang/String; Lorg/json/JSONObject;)Lkotlin/Unit;
    move-result-object v1
    return-object v1
.end method
