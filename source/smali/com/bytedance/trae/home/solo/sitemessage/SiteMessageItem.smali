# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
.super Ljava/lang/Object;
.source "SiteMessageApi.kt"

.field public static final $stable:I
.field private final data:Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
.field private final draftId:Ljava/lang/Integer;
.field private final effectiveTime:Ljava/lang/String;
.field private final id:I
.field private final isRead:Ljava/lang/Boolean;
.field private final notificationType:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(int  java.lang.Integer  java.lang.String  java.lang.String  java.lang.Boolean  com.bytedance.trae.home.solo.sitemessage.NotificationData)void
    .registers 8
    # ins_size=7
    const-string v0, "data"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->id I
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->draftId Ljava/lang/Integer;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->notificationType Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->effectiveTime Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead Ljava/lang/Boolean;
    iput-object v7, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    return-void 
.end method

.method public synthetic constructor <init>(int  java.lang.Integer  java.lang.String  java.lang.String  java.lang.Boolean  com.bytedance.trae.home.solo.sitemessage.NotificationData  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 18
    # ins_size=9
    and-int/lit8 v0, v16, 2
    const/4 v1, 0
    if-eqz v0, +004h
    move-object v4, v1
    goto +2h
    move-object v4, v11
    and-int/lit8 v0, v16, 4
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v12
    and-int/lit8 v0, v16, 8
    if-eqz v0, +004h
    move-object v6, v1
    goto +2h
    move-object v6, v13
    and-int/lit8 v0, v16, 16
    if-eqz v0, +004h
    move-object v7, v1
    goto +2h
    move-object v7, v14
    move-object v2, v9
    move v3, v10
    move-object v8, v15
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;-><init>(I Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.sitemessage.SiteMessageItem  int  java.lang.Integer  java.lang.String  java.lang.String  java.lang.Boolean  com.bytedance.trae.home.solo.sitemessage.NotificationData  int  java.lang.Object)com.bytedance.trae.home.solo.sitemessage.SiteMessageItem
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget v5, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->id I
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->draftId Ljava/lang/Integer;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->notificationType Ljava/lang/String;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->effectiveTime Ljava/lang/String;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead Ljava/lang/Boolean;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    move-object v3, v10
    move-object v6, v4
    move v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->copy(I Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    move-result-object v4
    return-object v4
.end method

.method public final component1()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->id I
    return v0
.end method

.method public final component2()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->draftId Ljava/lang/Integer;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->notificationType Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->effectiveTime Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead Ljava/lang/Boolean;
    return-object v0
.end method

.method public final component6()com.bytedance.trae.home.solo.sitemessage.NotificationData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    return-object v0
.end method

.method public final copy(int  java.lang.Integer  java.lang.String  java.lang.String  java.lang.Boolean  com.bytedance.trae.home.solo.sitemessage.NotificationData)com.bytedance.trae.home.solo.sitemessage.SiteMessageItem
    .registers 15
    # ins_size=7
    const-string v0, "data"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    move-object v1, v0
    move v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move-object v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;-><init>(I Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;
    iget v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->id I
    iget v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->id I
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->draftId Ljava/lang/Integer;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->draftId Ljava/lang/Integer;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->notificationType Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->notificationType Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->effectiveTime Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->effectiveTime Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead Ljava/lang/Boolean;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead Ljava/lang/Boolean;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getActionTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;->getButton()Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;->getLabel()Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;->getLocalized()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getActionUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;->getButton()Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;->getUrl()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getBody()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;->getContent()Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;->getLocalized()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final getCommandArgs()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;->getButton()Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;->getCommandArgs()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getCommandId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;->getButton()Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;->getCommandId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public final getData()com.bytedance.trae.home.solo.sitemessage.NotificationData
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    return-object v0
.end method

.method public final getDraftId()java.lang.Integer
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->draftId Ljava/lang/Integer;
    return-object v0
.end method

.method public final getEffectiveTime()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->effectiveTime Ljava/lang/String;
    return-object v0
.end method

.method public final getId()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->id I
    return v0
.end method

.method public final getNotificationType()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->notificationType Ljava/lang/String;
    return-object v0
.end method

.method public final getOpenInBrowser()boolean
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;->getButton()Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;
    move-result-object v0
    if-eqz v0, +010h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;->getOpenInBrowser()Ljava/lang/Boolean;
    move-result-object v0
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public final getTitle()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;->getTitle()Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;->getLocalized()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->id I
    invoke-static v0, Ljava/lang/Integer;->hashCode(I)I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->draftId Ljava/lang/Integer;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->notificationType Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->effectiveTime Ljava/lang/String;
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead Ljava/lang/Boolean;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isRead()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead Ljava/lang/Boolean;
    return-object v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SiteMessageItem(id="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->id I
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", draftId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->draftId Ljava/lang/Integer;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", notificationType="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->notificationType Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", effectiveTime="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->effectiveTime Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isRead="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->isRead Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", data="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;->data Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
