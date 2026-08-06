package ms.bd.p001c;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: ms.bd.c.y3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0236y3 implements SDKMonitor.IGetExtendParams {

    /* renamed from: a */
    public final /* synthetic */ JSONObject f474a;

    /* renamed from: b */
    public final /* synthetic */ String f475b;

    public C0236y3(JSONObject jSONObject, String str) {
        this.f474a = jSONObject;
        this.f475b = str;
    }

    public final Map getCommonParams() {
        HashMap hashMap = new HashMap();
        try {
            hashMap.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ffa594", new byte[]{120, 114, 23, 83, 21, 38, 100}), (String) (this.f474a.getBoolean((String) AbstractC0190p2.m166a(16777217, 0, 0L, "37a3b2", new byte[]{45, 35, 23, 85, 78, 32, 49})) ? AbstractC0190p2.m166a(16777217, 0, 0L, "1f64af", new byte[]{113}) : AbstractC0190p2.m166a(16777217, 0, 0L, "515e11", new byte[]{116})));
        } catch (JSONException unused) {
        }
        hashMap.put((String) AbstractC0190p2.m166a(16777217, 0, 0L, "ecc023", new byte[]{124, 110, 3, 80, 50, 37, 111, 70}), this.f475b);
        return hashMap;
    }

    public final String getSessionId() {
        return null;
    }
}
