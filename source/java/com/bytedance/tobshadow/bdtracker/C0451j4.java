package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.sdk.account.platform.api.IWeiboService;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.tobshadow.applog.log.EventBus;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.j4 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0451j4 implements EventBus.DataFetcher {

    /* renamed from: a */
    public final /* synthetic */ HttpURLConnection f702a;

    /* renamed from: b */
    public final /* synthetic */ String f703b;

    /* renamed from: c */
    public final /* synthetic */ String f704c;

    /* renamed from: d */
    public final /* synthetic */ JSONObject f705d;

    /* renamed from: e */
    public final /* synthetic */ byte f706e;

    /* renamed from: f */
    public final /* synthetic */ long f707f;

    /* renamed from: g */
    public final /* synthetic */ C0444i4 f708g;

    public C0451j4(C0444i4 c0444i4, HttpURLConnection httpURLConnection, String str, String str2, JSONObject jSONObject, byte b, long j) {
        this.f708g = c0444i4;
        this.f702a = httpURLConnection;
        this.f703b = str;
        this.f704c = str2;
        this.f705d = jSONObject;
        this.f706e = b;
        this.f707f = j;
    }

    @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
    public Object fetch() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            Map<String, List<String>> requestProperties = this.f702a.getRequestProperties();
            if (!requestProperties.isEmpty()) {
                for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                    jSONObject2.put(entry.getKey(), TextUtils.join(IWeiboService.Scope.EMPTY_SCOPE, entry.getValue()));
                }
            }
            jSONObject.put("appId", this.f708g.f668b.f784m);
            jSONObject.put("nid", this.f703b);
            jSONObject.put(IWeixinService.ResponseConstants.URL, this.f704c);
            jSONObject.put("data", this.f705d);
            jSONObject.put("header", jSONObject2);
            jSONObject.put("method", (int) this.f706e);
            jSONObject.put(DBData.FIELD_TIME, this.f707f);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
