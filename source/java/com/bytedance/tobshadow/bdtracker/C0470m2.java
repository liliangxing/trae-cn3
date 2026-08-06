package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.tobshadow.applog.DynamicValueCallback;
import com.bytedance.tobshadow.applog.log.GlobalLoggerImpl;
import com.bytedance.tobshadow.applog.store.p007kv.IKVStore;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.m2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0470m2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final Context f811e;

    /* renamed from: f */
    public final C0407d2 f812f;

    public C0470m2(Context context, C0407d2 c0407d2) {
        super(true, false);
        this.f811e = context;
        this.f812f = c0407d2;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "Oaid";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        IKVStore iKVStore = this.f812f.f505f;
        if (!r0.m325l()) {
            return true;
        }
        DynamicValueCallback<String> customOaidCallback = this.f812f.f502c.getCustomOaidCallback();
        if (customOaidCallback == null || TextUtils.isEmpty(customOaidCallback.get())) {
            GlobalLoggerImpl.global().debug("use default oaid", new Object[0]);
            Map m304a = C0404d.m304a(this.f811e);
            if (m304a == null) {
                return false;
            }
            jSONObject.put("oaid", new JSONObject(m304a));
            return true;
        }
        GlobalLoggerImpl.global().debug("use custom oaid", new Object[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("id", customOaidCallback.get());
        hashMap.put("req_id", UUID.randomUUID().toString());
        hashMap.put("take_ms", "1");
        hashMap.put(DBData.FIELD_TIME, "" + System.currentTimeMillis());
        hashMap.put("query_times", "1");
        hashMap.put("is_track_limited", "false");
        jSONObject.put("oaid", new JSONObject(hashMap));
        return true;
    }
}
