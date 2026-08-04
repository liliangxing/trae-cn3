# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Lcom/ss/bytertc/engine/RTCRoom;


.method public synthetic constructor <init>(com.ss.bytertc.engine.RTCRoom)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda4;->f$0 Lcom/ss/bytertc/engine/RTCRoom;
    return-void 
.end method

.method public final run()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda4;->f$0 Lcom/ss/bytertc/engine/RTCRoom;
    invoke-static v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->$r8$lambda$4aTOTVYsKVX623YU0idNMYqhEtw(Lcom/ss/bytertc/engine/RTCRoom;)V
    return-void 
.end method
