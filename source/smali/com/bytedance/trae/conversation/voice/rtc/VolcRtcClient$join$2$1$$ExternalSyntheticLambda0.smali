# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/String;


.method public synthetic constructor <init>(java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1$$ExternalSyntheticLambda0;->f$0 Ljava/lang/String;
    check-cast v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$join$2$1;->$r8$lambda$-3lmdaq9VXC-t_QBtgUHCiUHFf8(Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v2
    return-object v2
.end method
