# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;
.super Ljava/lang/Object;
.source "SiteMessageApi.kt"

.field public static final $stable:I
.field private final action:Ljava/lang/String;
.field private final language:Ljava/lang/String;
.field private final notificationIds:Ljava/util/List;
.field private final platform:Ljava/lang/String;
.field private final updateAll:Ljava/lang/Boolean;
.field private final version:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean)void
    .registers 8
    # ins_size=7
    const-string v0, "notificationIds"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "action"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, version
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "platform"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "language"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->notificationIds Ljava/util/List;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->action Ljava/lang/String;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->version Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->platform Ljava/lang/String;
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->language Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->updateAll Ljava/lang/Boolean;
    return-void 
.end method

.method public synthetic constructor <init>(java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 4
    if-eqz v15, +008h
    sget-object v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->getVersion()Ljava/lang/String;
    move-result-object v10
    move-object v3, v10
    and-int/lit8 v10, v14, 8
    if-eqz v10, +004h
    const-string v11, "Android"
    move-object v4, v11
    and-int/lit8 v10, v14, 16
    if-eqz v10, +008h
    sget-object v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->getLanguage()Ljava/lang/String;
    move-result-object v12
    move-object v5, v12
    and-int/lit8 v10, v14, 32
    if-eqz v10, +003h
    const/4 v13, 0
    move-object v6, v13
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.home.solo.sitemessage.SiteMessageUpdateStatusBody  java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean  int  java.lang.Object)com.bytedance.trae.home.solo.sitemessage.SiteMessageUpdateStatusBody
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->notificationIds Ljava/util/List;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->action Ljava/lang/String;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->version Ljava/lang/String;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->platform Ljava/lang/String;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->language Ljava/lang/String;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->updateAll Ljava/lang/Boolean;
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->copy(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;
    move-result-object v4
    return-object v4
.end method

.method public final component1()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->notificationIds Ljava/util/List;
    return-object v0
.end method

.method public final component2()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->action Ljava/lang/String;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->version Ljava/lang/String;
    return-object v0
.end method

.method public final component4()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->platform Ljava/lang/String;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->language Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->updateAll Ljava/lang/Boolean;
    return-object v0
.end method

.method public final copy(java.util.List  java.lang.String  java.lang.String  java.lang.String  java.lang.String  java.lang.Boolean)com.bytedance.trae.home.solo.sitemessage.SiteMessageUpdateStatusBody
    .registers 15
    # ins_size=7
    const-string v0, "notificationIds"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "action"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, version
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "platform"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "language"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move-object v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->notificationIds Ljava/util/List;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->notificationIds Ljava/util/List;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->action Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->action Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->version Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->version Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->platform Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->platform Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->language Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->language Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->updateAll Ljava/lang/Boolean;
    iget-object v5, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->updateAll Ljava/lang/Boolean;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getAction()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->action Ljava/lang/String;
    return-object v0
.end method

.method public final getLanguage()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->language Ljava/lang/String;
    return-object v0
.end method

.method public final getNotificationIds()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->notificationIds Ljava/util/List;
    return-object v0
.end method

.method public final getPlatform()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->platform Ljava/lang/String;
    return-object v0
.end method

.method public final getUpdateAll()java.lang.Boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->updateAll Ljava/lang/Boolean;
    return-object v0
.end method

.method public final getVersion()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->version Ljava/lang/String;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->notificationIds Ljava/util/List;
    invoke-virtual v0, Ljava/lang/Object;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->action Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->version Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->platform Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->language Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->updateAll Ljava/lang/Boolean;
    if-nez v1, +004h
    const/4 v1, 0
    goto +5h
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "SiteMessageUpdateStatusBody(notificationIds="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->notificationIds Ljava/util/List;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", action="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->action Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", version="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->version Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", platform="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->platform Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", language="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->language Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", updateAll="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;->updateAll Ljava/lang/Boolean;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
