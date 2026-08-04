# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/ss/bytertc/engine/type/NetworkQualityStats;
.field public final synthetic f$1:[Lcom/ss/bytertc/engine/type/NetworkQualityStats;


.method public synthetic constructor <init>(com.ss.bytertc.engine.type.NetworkQualityStats  com.ss.bytertc.engine.type.NetworkQualityStats[])void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda4;->f$0 Lcom/ss/bytertc/engine/type/NetworkQualityStats;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda4;->f$1 [Lcom/ss/bytertc/engine/type/NetworkQualityStats;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda4;->f$0 Lcom/ss/bytertc/engine/type/NetworkQualityStats;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda4;->f$1 [Lcom/ss/bytertc/engine/type/NetworkQualityStats;
    check-cast v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->$r8$lambda$wtHPgpK5eiRbikojFsXzu9cRUoQ(Lcom/ss/bytertc/engine/type/NetworkQualityStats; [Lcom/ss/bytertc/engine/type/NetworkQualityStats; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
