package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.C1656ha;
import com.xiaomi.push.NotificationBuilderC1568du;
import java.util.Map;

/* renamed from: com.xiaomi.push.service.ab */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AbstractC1744ab {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract NotificationBuilderC1568du m3574a(Context context, int i, String str, Map<String, String> map);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void m3575a(C1656ha c1656ha, Map<String, String> map, int i, Notification notification);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract void m3576a(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean m3577a(Context context, int i, String str, Map<String, String> map);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean m3578a(Map<String, String> map, int i, Notification notification);
}
