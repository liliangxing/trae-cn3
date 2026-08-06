package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1494ba;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/* renamed from: com.xiaomi.push.service.y */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1797y {

    /* renamed from: a */
    private static Object f3258a = new Object();

    /* renamed from: a */
    private static Map<String, Queue<String>> f3259a = new HashMap();

    /* renamed from: a */
    public static boolean m4093a(XMPushService xMPushService, String str, String str2) {
        synchronized (f3258a) {
            SharedPreferences sharedPreferences = xMPushService.getSharedPreferences("push_message_ids", 0);
            Queue<String> queue = f3259a.get(str);
            if (queue == null) {
                String[] split = sharedPreferences.getString(str, "").split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                LinkedList linkedList = new LinkedList();
                for (String str3 : split) {
                    linkedList.add(str3);
                }
                f3259a.put(str, linkedList);
                queue = linkedList;
            }
            if (queue.contains(str2)) {
                return true;
            }
            queue.add(str2);
            if (queue.size() > 25) {
                queue.poll();
            }
            String m1627a = C1494ba.m1627a(queue, Constants.ACCEPT_TIME_SEPARATOR_SP);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(str, m1627a);
            edit.commit();
            return false;
        }
    }
}
