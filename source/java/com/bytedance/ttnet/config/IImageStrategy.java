package com.bytedance.ttnet.config;

import com.bytedance.common.utility.NetworkUtils;
import java.util.List;

/* loaded from: classes4.dex */
public interface IImageStrategy {
    int getFailedTimes();

    long getHostInBlackInterval();

    int getLimitImageNumbers();

    NetworkUtils.NetworkType getNetWorkType();

    int getSwitch();

    List<String> getUrlListForUrl(String str);
}
