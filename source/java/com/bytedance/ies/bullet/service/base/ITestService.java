package com.bytedance.ies.bullet.service.base;

import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.test.TEvent;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: ITestService.kt */
@Deprecated(message = "仅用于单元测试场景，线上业务请勿使用")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/ITestService;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getTestConfig", "", "key", "", "onEvent", "", "event", "Lcom/bytedance/ies/bullet/service/base/test/TEvent;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface ITestService extends IBulletService {
    Object getTestConfig(String key);

    void onEvent(TEvent event);
}
