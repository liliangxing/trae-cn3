package com.bytedance.ies.bullet.service.base;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.json.JSONObject;

/* compiled from: MonitorConfig.kt */
@Deprecated(message = "Monitor SDK已内置，无需注入", replaceWith = @ReplaceWith(expression = "monitorConfig.intercept", imports = {}))
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/IReporter;", "", "report", "", "serviceName", "", "status", "", "duration", "Lorg/json/JSONObject;", "logExtra", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IReporter {
    void report(String serviceName, int status, JSONObject duration, JSONObject logExtra);
}
