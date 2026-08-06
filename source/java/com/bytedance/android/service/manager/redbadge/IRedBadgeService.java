package com.bytedance.android.service.manager.redbadge;

import android.content.Context;

/* loaded from: classes3.dex */
public interface IRedBadgeService {
    boolean addRedBadgeNumber(Context context, int i);

    boolean applyCount(Context context, int i);

    int getCurRedBadgeNumber(Context context);

    boolean isSupportAddRedBadgeNumber(int i);

    boolean isSupportGetCurRedBadgeNumber();

    boolean isSupportReduceRedBadgeNumber(int i);

    boolean reduceRedBadgeNumber(Context context, int i);

    boolean removeCount(Context context);
}
