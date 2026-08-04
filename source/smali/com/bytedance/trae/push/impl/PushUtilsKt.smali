# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/impl/PushUtilsKt;
.super Ljava/lang/Object;
.source "PushUtils.kt"


.method public static final transToNotificationBody(com.bytedance.trae.push.api.TraeNotificationBody)com.bytedance.android.service.manager.push.notification.NotificationBody
    .registers 4
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    invoke-direct v0, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;-><init>()V
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getId()J
    move-result-wide v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->id(J)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getShowWhen()Z
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->showWhen(Z)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getTitle()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->title(Ljava/lang/String;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getContent()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->content(Ljava/lang/String;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getGroupId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->groupId(Ljava/lang/String;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getChannelId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->channelId(Ljava/lang/String;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getRedBadgeNum()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->redBadgeNum(I)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getImageType()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->imageType(I)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getImageUrl()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->imageUrl(Ljava/lang/String;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getUseLED()Z
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->useLED(Z)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getUseSound()Z
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->useSound(Z)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getUseVibrator()Z
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->useVibrator(Z)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getAndroidGroup()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->androidGroup(Ljava/lang/String;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getGroupFoldNum()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->groupFoldNum(I)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getImageBitmap()Landroid/graphics/Bitmap;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->setImageBitmap(Landroid/graphics/Bitmap;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getSound()Landroid/net/Uri;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->setSound(Landroid/net/Uri;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getBdPushStr()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->setBdPushStr(Ljava/lang/String;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getIconBitmap()Landroid/graphics/Bitmap;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->setIconBitmap(Landroid/graphics/Bitmap;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getAppName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->setAppName(Ljava/lang/String;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getOpenUrl()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->setOpenUrl(Ljava/lang/String;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getChannelImportance()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->setChannelImportance(I)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getNotificationCategory()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->setNotificationCategory(Ljava/lang/String;)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getAvatarDisplayMode()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->setAvatarDisplayMode(I)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/push/api/TraeNotificationBody;->getForceSameWithIos()Z
    move-result v3
    invoke-virtual v0, v3, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->setForceSameWithIos(Z)Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/android/service/manager/push/notification/NotificationBody$Builder;->build()Lcom/bytedance/android/service/manager/push/notification/NotificationBody;
    move-result-object v3
    const-string v0, "build(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method
