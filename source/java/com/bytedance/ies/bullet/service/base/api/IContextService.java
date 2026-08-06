package com.bytedance.ies.bullet.service.base.api;

import com.bytedance.ies.bullet.service.context.TypedMap;
import kotlin.Deprecated;
import kotlin.Metadata;

/* compiled from: IServiceCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u0004H'¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/IContextService;", "", "getMonitorInfo", "Lcom/bytedance/ies/bullet/service/context/TypedMap;", "", "sessionId", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IContextService {
    @Deprecated(message = "避免Rifle BreakChange故保留，返回恒为 null")
    TypedMap<String, Object> getMonitorInfo(String sessionId);
}
