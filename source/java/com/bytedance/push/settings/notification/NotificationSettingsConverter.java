package com.bytedance.push.settings.notification;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;

/* loaded from: classes4.dex */
public class NotificationSettingsConverter implements ITypeConverter<NotificationSettings>, IDefaultValueProvider<NotificationSettings> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public NotificationSettings create() {
        return new NotificationSettings();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    public NotificationSettings to(String str) {
        return new NotificationSettings(str);
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(NotificationSettings notificationSettings) {
        return notificationSettings.toJsonString();
    }
}
