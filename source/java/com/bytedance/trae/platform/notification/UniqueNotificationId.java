package com.bytedance.trae.platform.notification;

import kotlin.Metadata;

/* compiled from: UniqueNotificationId.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/platform/notification/UniqueNotificationId;", "", "<init>", "()V", "REALTIME_ID", "", "ONE_PART_MUSIC_ID", "ONE_PART_NEWS_PLAY_ID", "ONE_PART_AI_NOTE_ID", "DORA_ID", "BAIDU_NAVI_ID", "UGC_CREATION_ID", "platform_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UniqueNotificationId {

    @NotificationId(description = "baidu navigation")
    public static final int BAIDU_NAVI_ID = 106;

    @NotificationId(description = "dora")
    public static final int DORA_ID = 105;
    public static final UniqueNotificationId INSTANCE = new UniqueNotificationId();

    @NotificationId(description = "one-party application ai not")
    public static final int ONE_PART_AI_NOTE_ID = 104;

    @NotificationId(description = "one-party application music")
    public static final int ONE_PART_MUSIC_ID = 102;

    @NotificationId(description = "one-party application news play")
    public static final int ONE_PART_NEWS_PLAY_ID = 103;

    @NotificationId(description = "realtime call")
    public static final int REALTIME_ID = 101;

    @NotificationId(description = "ugc creation")
    public static final int UGC_CREATION_ID = 107;

    private UniqueNotificationId() {
    }
}
