# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/settings/BusinessSettings;
.super Ljava/lang/Object;
.source "ICNBusinessSettings.kt"

.field private final fastPassNotifyCount:J
.field private fastPassNotifyInterval:J


.method public constructor <init>(long  long)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/settings/BusinessSettings;->fastPassNotifyCount J
    iput-wide v3, v0, Lcom/bytedance/trae/conversation/settings/BusinessSettings;->fastPassNotifyInterval J
    return-void 
.end method

.method public final getFastPassNotifyCount()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/settings/BusinessSettings;->fastPassNotifyCount J
    return-wide v0
.end method

.method public final getFastPassNotifyInterval()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/conversation/settings/BusinessSettings;->fastPassNotifyInterval J
    return-wide v0
.end method

.method public final setFastPassNotifyInterval(long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/settings/BusinessSettings;->fastPassNotifyInterval J
    return-void 
.end method
