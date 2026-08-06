package com.bytedance.news.common.service.manager;

import java.util.Map;

/* loaded from: classes4.dex */
public interface IServiceProxy<T> {
    void collectService(Map<String, String> map);

    T newInstance();
}
