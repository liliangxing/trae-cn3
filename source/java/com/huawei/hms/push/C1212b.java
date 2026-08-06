package com.huawei.hms.push;

import android.text.TextUtils;
import com.huawei.hms.push.notification.SubscribedItem;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseUtil.java */
/* renamed from: com.huawei.hms.push.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1212b {
    /* renamed from: a */
    public static List<SubscribedItem> m1935a(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                int i = jSONObject.getInt(next);
                SubscribedItem subscribedItem = new SubscribedItem();
                subscribedItem.setEntityId(next);
                subscribedItem.setResultCode(i);
                arrayList.add(subscribedItem);
            }
            return arrayList;
        } catch (JSONException unused) {
            HMSLog.m2118e("PushBaseUtils", "trans subscribedItem list occurs exception");
            return Collections.emptyList();
        }
    }
}
