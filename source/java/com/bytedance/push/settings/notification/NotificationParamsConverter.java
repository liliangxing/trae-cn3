package com.bytedance.push.settings.notification;

import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.utils.GsonUtils;
import com.bytedance.push.utils.Logger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class NotificationParamsConverter implements ITypeConverter<NotificationParamsModel>, IDefaultValueProvider<NotificationParamsModel> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public NotificationParamsModel create() {
        return new NotificationParamsModel();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.push.settings.ITypeConverter
    /* renamed from: to */
    public NotificationParamsModel mo236to(String str) {
        NotificationParamsModel notificationParamsModel = (NotificationParamsModel) GsonUtils.from(str, NotificationParamsModel.class);
        if (notificationParamsModel != null) {
            return notificationParamsModel;
        }
        Logger.m271e(getClass().getSimpleName(), "NotificationParamsModel is null");
        return create();
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(NotificationParamsModel notificationParamsModel) {
        return GsonUtils.toJson(notificationParamsModel);
    }
}
