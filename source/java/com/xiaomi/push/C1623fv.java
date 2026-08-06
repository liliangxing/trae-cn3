package com.xiaomi.push;

import android.text.TextUtils;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.utils.LynxConstants;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.vivo.push.PushClient;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1613fl;
import com.xiaomi.push.C1617fp;
import com.xiaomi.push.C1619fr;
import com.xiaomi.push.service.C1755am;
import com.xiaomi.push.service.C1760ar;
import com.xiaomi.push.service.C1780i;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.push.fv */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1623fv {

    /* renamed from: a */
    private static XmlPullParser f1852a;

    /* renamed from: a */
    public static AbstractC1615fn m2639a(XmlPullParser xmlPullParser) {
        String str;
        boolean z = false;
        String str2 = null;
        if (PushClient.DEFAULT_REQUEST_ID.equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", FrescoMonitorConst.URI_QUERY_PARAM_FROM);
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
            C1755am.b m3705a = C1755am.m3702a().m3705a(attributeValue, attributeValue4);
            if (m3705a == null) {
                m3705a = C1755am.m3702a().m3705a(attributeValue, attributeValue3);
            }
            if (m3705a == null) {
                throw new C1609fh("the channel id is wrong while receiving a encrypted message");
            }
            AbstractC1615fn abstractC1615fn = null;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!"s".equals(xmlPullParser.getName())) {
                        throw new C1609fh("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new C1609fh("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                        C1614fm c1614fm = new C1614fm();
                        c1614fm.m2614l(attributeValue);
                        c1614fm.m2585b(true);
                        c1614fm.m2618n(attributeValue3);
                        c1614fm.m2616m(attributeValue4);
                        c1614fm.m2612k(attributeValue2);
                        c1614fm.m2593f(attributeValue5);
                        C1612fk c1612fk = new C1612fk("s", null, null, null);
                        c1612fk.m2569a(text);
                        c1614fm.m2607a(c1612fk);
                        return c1614fm;
                    }
                    m2644a(C1760ar.m3746a(C1760ar.m3745a(m3705a.f3006h, attributeValue2), text));
                    f1852a.next();
                    abstractC1615fn = m2639a(f1852a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z = true;
                }
            }
            if (abstractC1615fn != null) {
                return abstractC1615fn;
            }
            throw new C1609fh("error while receiving a encrypted message with wrong format");
        }
        C1614fm c1614fm2 = new C1614fm();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        c1614fm2.m2612k(attributeValue6);
        c1614fm2.m2616m(xmlPullParser.getAttributeValue("", "to"));
        c1614fm2.m2618n(xmlPullParser.getAttributeValue("", FrescoMonitorConst.URI_QUERY_PARAM_FROM));
        c1614fm2.m2614l(xmlPullParser.getAttributeValue("", "chid"));
        c1614fm2.m2580a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                c1614fm2.m2584b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                c1614fm2.m2587c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                c1614fm2.m2589d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                c1614fm2.m2591e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        c1614fm2.m2582a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        c1614fm2.m2593f(xmlPullParser.getAttributeValue("", DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE));
        String m2645b = m2645b(xmlPullParser);
        if (m2645b != null && !"".equals(m2645b.trim())) {
            c1614fm2.m2599j(m2645b);
        } else {
            AbstractC1615fn.m2601q();
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    m2645b(xmlPullParser);
                    c1614fm2.m2595g(m2643a(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String m2643a = m2643a(xmlPullParser);
                    if (!TextUtils.isEmpty(attributeValue11)) {
                        c1614fm2.m2581a(m2643a, attributeValue11);
                    } else {
                        c1614fm2.m2597h(m2643a);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    c1614fm2.m2608a(m2642a(xmlPullParser));
                } else {
                    c1614fm2.m2607a(m2637a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        c1614fm2.m2598i(str2);
        return c1614fm2;
    }

    /* renamed from: a */
    private static void m2644a(byte[] bArr) {
        if (f1852a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                f1852a = newPullParser;
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        f1852a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    /* renamed from: a */
    private static String m2643a(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    /* renamed from: a */
    public static C1617fp m2640a(XmlPullParser xmlPullParser) {
        C1617fp.b bVar = C1617fp.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = C1617fp.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        C1617fp c1617fp = new C1617fp(bVar);
        c1617fp.m2616m(xmlPullParser.getAttributeValue("", "to"));
        c1617fp.m2618n(xmlPullParser.getAttributeValue("", FrescoMonitorConst.URI_QUERY_PARAM_FROM));
        c1617fp.m2614l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        c1617fp.m2612k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    c1617fp.m2625a(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        c1617fp.m2622a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        c1617fp.m2622a(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        c1617fp.m2623a(C1617fp.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    c1617fp.m2608a(m2642a(xmlPullParser));
                } else {
                    c1617fp.m2607a(m2637a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return c1617fp;
    }

    /* renamed from: a */
    public static C1613fl m2638a(XmlPullParser xmlPullParser, AbstractC1600ez abstractC1600ez) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", FrescoMonitorConst.URI_QUERY_PARAM_FROM);
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        C1613fl.a m2579a = C1613fl.a.m2579a(xmlPullParser.getAttributeValue("", DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        C1613fl c1613fl = null;
        C1619fr c1619fr = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    c1619fr = m2642a(xmlPullParser);
                } else {
                    c1613fl = new C1613fl();
                    c1613fl.m2607a(m2637a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (c1613fl == null) {
            if (C1613fl.a.f1764a == m2579a || C1613fl.a.f1765b == m2579a) {
                C1613fl c1613fl2 = new C1613fl() { // from class: com.xiaomi.push.fv.1
                    @Override // com.xiaomi.push.C1613fl
                    /* renamed from: b */
                    public String mo2578b() {
                        return null;
                    }
                };
                c1613fl2.m2612k(attributeValue);
                c1613fl2.m2616m(attributeValue3);
                c1613fl2.m2618n(attributeValue2);
                c1613fl2.m2576a(C1613fl.a.f1767d);
                c1613fl2.m2614l(attributeValue4);
                c1613fl2.m2608a(new C1619fr(C1619fr.a.f1828e));
                abstractC1600ez.mo2487a(c1613fl2);
                AbstractC1417b.m1103d("iq usage error. send packet in packet parser.");
                return null;
            }
            c1613fl = new C1613fl() { // from class: com.xiaomi.push.fv.2
                @Override // com.xiaomi.push.C1613fl
                /* renamed from: b */
                public String mo2578b() {
                    return null;
                }
            };
        }
        c1613fl.m2612k(attributeValue);
        c1613fl.m2616m(attributeValue2);
        c1613fl.m2614l(attributeValue4);
        c1613fl.m2618n(attributeValue3);
        c1613fl.m2576a(m2579a);
        c1613fl.m2608a(c1619fr);
        c1613fl.m2577a(hashMap);
        return c1613fl;
    }

    /* renamed from: a */
    public static C1618fq m2641a(XmlPullParser xmlPullParser) {
        C1618fq c1618fq = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                c1618fq = new C1618fq(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z = true;
            }
        }
        return c1618fq;
    }

    /* renamed from: a */
    public static C1619fr m2642a(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        String str = LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
        boolean z = false;
        String str2 = null;
        String str3 = null;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals(MonitorConstants.CODE)) {
                str = xmlPullParser.getAttributeValue("", MonitorConstants.CODE);
            }
            if (xmlPullParser.getAttributeName(i).equals(DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE)) {
                str3 = xmlPullParser.getAttributeValue("", DownloadSettingKeys.AhPlans.KEY_AH_PLAN_TYPE);
            }
            if (xmlPullParser.getAttributeName(i).equals(BaseConstants.DownloadManager.COLUMN_REASON)) {
                str2 = xmlPullParser.getAttributeValue("", BaseConstants.DownloadManager.COLUMN_REASON);
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals(PropsConstants.TEXT)) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(m2637a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new C1619fr(Integer.parseInt(str), str3 == null ? "cancel" : str3, str2, str4, str5, arrayList);
    }

    /* renamed from: a */
    public static C1612fk m2637a(String str, String str2, XmlPullParser xmlPullParser) {
        Object m2634a = C1622fu.m2631a().m2634a("all", "xm:chat");
        if (m2634a == null || !(m2634a instanceof C1780i)) {
            return null;
        }
        return ((C1780i) m2634a).m3861b(xmlPullParser);
    }

    /* renamed from: b */
    private static String m2645b(XmlPullParser xmlPullParser) {
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i)))) {
                return xmlPullParser.getAttributeValue(i);
            }
        }
        return null;
    }
}
