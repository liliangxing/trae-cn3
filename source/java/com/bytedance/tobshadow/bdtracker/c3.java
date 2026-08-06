package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.log.LoggerImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/bytedance/tobshadow/applog/monitor/model/BaseTrace;", "Lcom/bytedance/tobshadow/applog/monitor/model/BaseAggregation;", "category", "", "getTraceParams", "Lorg/json/JSONObject;", "loadParams", "", "params", "name", "value", "", "Companion", "agent_liteChinaRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public interface c3 extends b3 {

    /* loaded from: classes5.dex */
    public static final class a {
        public static JSONObject a(c3 c3Var) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("metrics_category", c3Var.e());
                jSONObject.put("metrics_name", c3Var.b());
                jSONObject.put("metrics_value", c3Var.g());
                c3Var.a(jSONObject);
            } catch (Throwable th) {
                LoggerImpl.global().error("JSON handle failed", th, new Object[0]);
            }
            return jSONObject;
        }

        public static void a(JSONObject params) {
            Intrinsics.checkParameterIsNotNull(params, "params");
        }
    }

    void a(JSONObject jSONObject);

    String b();

    JSONObject d();

    String e();

    Object g();
}
