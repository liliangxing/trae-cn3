package com.bytedance.trae.push.impl;

import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.trae.push.api.TraeNotificationBody;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PushUtils.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"transToNotificationBody", "Lcom/bytedance/android/service/manager/push/notification/NotificationBody;", "Lcom/bytedance/trae/push/api/TraeNotificationBody;", "impl_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PushUtilsKt {
    public static final NotificationBody transToNotificationBody(TraeNotificationBody traeNotificationBody) {
        Intrinsics.checkNotNullParameter(traeNotificationBody, "<this>");
        NotificationBody build = new NotificationBody.Builder().id(traeNotificationBody.getId()).showWhen(traeNotificationBody.getShowWhen()).title(traeNotificationBody.getTitle()).content(traeNotificationBody.getContent()).groupId(traeNotificationBody.getGroupId()).channelId(traeNotificationBody.getChannelId()).redBadgeNum(traeNotificationBody.getRedBadgeNum()).imageType(traeNotificationBody.getImageType()).imageUrl(traeNotificationBody.getImageUrl()).useLED(traeNotificationBody.getUseLED()).useSound(traeNotificationBody.getUseSound()).useVibrator(traeNotificationBody.getUseVibrator()).androidGroup(traeNotificationBody.getAndroidGroup()).groupFoldNum(traeNotificationBody.getGroupFoldNum()).setImageBitmap(traeNotificationBody.getImageBitmap()).setSound(traeNotificationBody.getSound()).setBdPushStr(traeNotificationBody.getBdPushStr()).setIconBitmap(traeNotificationBody.getIconBitmap()).setAppName(traeNotificationBody.getAppName()).setOpenUrl(traeNotificationBody.getOpenUrl()).setChannelImportance(traeNotificationBody.getChannelImportance()).setNotificationCategory(traeNotificationBody.getNotificationCategory()).setAvatarDisplayMode(traeNotificationBody.getAvatarDisplayMode()).setForceSameWithIos(traeNotificationBody.getForceSameWithIos()).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }
}
