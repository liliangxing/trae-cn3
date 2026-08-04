# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
.super Ljava/lang/Object;
.source "SiteMessageReadTracker.kt"

.field private final eventType:Ljava/lang/String;
.field private final messageId:I
.field private final timestamp:J


.method public constructor <init>(int  java.lang.String  long)void
    .registers 6
    # ins_size=5
    const-string v0, "eventType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->messageId I
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->eventType Ljava/lang/String;
    iput-wide v4, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->timestamp J
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker$PendingEvent  int  java.lang.String  long  int  java.lang.Object)com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker$PendingEvent
    .registers 7
    # ins_size=7
    and-int/lit8 v6, v5, 1
    if-eqz v6, +004h
    iget v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->messageId I
    and-int/lit8 v6, v5, 2
    if-eqz v6, +004h
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->eventType Ljava/lang/String;
    and-int/lit8 v5, v5, 4
    if-eqz v5, +004h
    iget-wide v3, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->timestamp J
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->copy(I Ljava/lang/String; J)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    move-result-object v0
    return-object v0
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->messageId I
    return v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->eventType Ljava/lang/String;
    return-object v0
.end method

.method public final component3()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->timestamp J
    return-wide v0
.end method

.method public final copy(int  java.lang.String  long)com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker$PendingEvent
    .registers 6
    # ins_size=5
    const-string v0, "eventType"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    invoke-direct v0, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;-><init>(I Ljava/lang/String; J)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 9
    # ins_size=2
    const/4 v0, 1
    if-ne v7, v8, +003h
    return v0
    instance-of v1, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;
    iget v1, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->messageId I
    iget v3, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->messageId I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->eventType Ljava/lang/String;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->eventType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-wide v3, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->timestamp J
    iget-wide v5, v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->timestamp J
    cmp-long v8, v3, v5
    if-eqz v8, +003h
    return v2
    return v0
.end method

.method public final getEventType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->eventType Ljava/lang/String;
    return-object v0
.end method

.method public final getMessageId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->messageId I
    return v0
.end method

.method public final getTimestamp()long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->timestamp J
    return-wide v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->messageId I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->eventType Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->timestamp J
    invoke-static v1, v2, Ljava/lang/Long;->hashCode(J)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "PendingEvent(messageId="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->messageId I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", eventType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->eventType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", timestamp="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-wide v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker$PendingEvent;->timestamp J
    invoke-virtual v0, v1, v2, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
