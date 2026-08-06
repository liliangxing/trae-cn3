package com.xiaomi.push.service;

import com.xiaomi.push.C1612fk;
import com.xiaomi.push.C1622fu;
import com.xiaomi.push.C1624fw;
import com.xiaomi.push.InterfaceC1621ft;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.xiaomi.push.service.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1780i implements InterfaceC1621ft {
    /* renamed from: a */
    public void m3860a() {
        C1622fu.m2631a().m2636a("all", "xm:chat", this);
    }

    /* renamed from: a */
    public static C1612fk m3859a(XmlPullParser xmlPullParser) {
        String[] strArr;
        String[] strArr2;
        String str;
        ArrayList arrayList;
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                strArr3[i] = xmlPullParser.getAttributeName(i);
                strArr4[i] = C1624fw.m2650b(xmlPullParser.getAttributeValue(i));
            }
            strArr = strArr3;
            str = null;
            arrayList = null;
            strArr2 = strArr4;
        } else {
            strArr = null;
            strArr2 = null;
            str = null;
            arrayList = null;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new C1612fk(name, namespace, strArr, strArr2, str, arrayList);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                C1612fk m3859a = m3859a(xmlPullParser);
                if (m3859a != null) {
                    arrayList.add(m3859a);
                }
            }
        }
    }

    /* renamed from: b */
    public C1612fk m3861b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        if (eventType == 2) {
            return m3859a(xmlPullParser);
        }
        return null;
    }
}
