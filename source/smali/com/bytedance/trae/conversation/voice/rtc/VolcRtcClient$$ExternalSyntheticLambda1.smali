# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Ljava/lang/String;
.field public final synthetic f$1:I
.field public final synthetic f$2:I


.method public synthetic constructor <init>(java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iput v2, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda1;->f$1 I
    iput v3, v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda1;->f$2 I
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda1;->f$0 Ljava/lang/String;
    iget v1, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda1;->f$1 I
    iget v2, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$$ExternalSyntheticLambda1;->f$2 I
    check-cast v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->$r8$lambda$wEhZokIWU_uBOTQtnLiIXKVja0A(Ljava/lang/String; I I Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
