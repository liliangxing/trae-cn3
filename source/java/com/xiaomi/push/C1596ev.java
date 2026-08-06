package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.push.ev */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1596ev {

    /* renamed from: a */
    private XmlPullParser f1679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1596ev() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f1679a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public AbstractC1615fn m2480a(byte[] bArr, AbstractC1600ez abstractC1600ez) {
        this.f1679a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f1679a.next();
        int eventType = this.f1679a.getEventType();
        String name = this.f1679a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name.equals("message")) {
            return C1623fv.m2639a(this.f1679a);
        }
        if (name.equals("iq")) {
            return C1623fv.m2638a(this.f1679a, abstractC1600ez);
        }
        if (name.equals("presence")) {
            return C1623fv.m2640a(this.f1679a);
        }
        if (this.f1679a.getName().equals("stream")) {
            return null;
        }
        if (this.f1679a.getName().equals("error")) {
            throw new C1609fh(C1623fv.m2641a(this.f1679a));
        }
        if (this.f1679a.getName().equals("warning")) {
            this.f1679a.next();
            this.f1679a.getName().equals("multi-login");
            return null;
        }
        this.f1679a.getName().equals("bind");
        return null;
    }
}
