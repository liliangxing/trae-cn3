package com.bytedance.notification.supporter.impl;

import com.bytedance.notification.supporter.service.INotificationClickService;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class NotificationClickServiceImpl implements INotificationClickService {
    private Set<Long> mBannerClickedList = new HashSet();

    @Override // com.bytedance.notification.supporter.service.INotificationClickService
    public void onBannerClick(long j) {
        this.mBannerClickedList.add(Long.valueOf(j));
    }

    @Override // com.bytedance.notification.supporter.service.INotificationClickService
    public boolean isClickByBanner(long j) {
        return this.mBannerClickedList.contains(Long.valueOf(j));
    }
}
