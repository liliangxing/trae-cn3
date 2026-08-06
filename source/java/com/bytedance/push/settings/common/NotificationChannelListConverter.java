package com.bytedance.push.settings.common;

import com.bytedance.common.push.BaseJson;
import com.bytedance.push.settings.IDefaultValueProvider;
import com.bytedance.push.settings.ITypeConverter;
import com.bytedance.push.settings.notification.NotificationChannelSerializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class NotificationChannelListConverter extends BaseJson implements ITypeConverter<Map<String, NotificationChannelSerializable>>, IDefaultValueProvider<Map<String, NotificationChannelSerializable>> {
    @Override // com.bytedance.push.settings.ITypeConverter
    public Map<String, NotificationChannelSerializable> to(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String str2 = (String) jSONObject.get(next);
                NotificationChannelSerializable notificationChannelSerializable = new NotificationChannelSerializable();
                notificationChannelSerializable.fromString(str2);
                hashMap.put(next, notificationChannelSerializable);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return hashMap;
    }

    @Override // com.bytedance.push.settings.ITypeConverter
    public String from(Map<String, NotificationChannelSerializable> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, NotificationChannelSerializable> entry : map.entrySet()) {
            add(jSONObject, entry.getKey(), entry.getValue().toStr());
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.push.settings.IDefaultValueProvider
    public Map<String, NotificationChannelSerializable> create() {
        return new HashMap();
    }
}
