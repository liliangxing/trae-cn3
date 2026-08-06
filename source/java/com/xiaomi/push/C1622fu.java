package com.xiaomi.push;

import com.ss.android.http.legacy.protocol.HTTP;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.push.fu */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1622fu {

    /* renamed from: a */
    private static C1622fu f1849a;

    /* renamed from: a */
    private Map<String, Object> f1850a = new ConcurrentHashMap();

    /* renamed from: b */
    private Map<String, Object> f1851b = new ConcurrentHashMap();

    /* renamed from: a */
    public static synchronized C1622fu m2631a() {
        C1622fu c1622fu;
        synchronized (C1622fu.class) {
            if (f1849a == null) {
                f1849a = new C1622fu();
            }
            c1622fu = f1849a;
        }
        return c1622fu;
    }

    /* renamed from: a */
    protected void m2635a() {
        InputStream inputStream;
        XmlPullParser newPullParser;
        int eventType;
        try {
            for (ClassLoader classLoader : m2633a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    try {
                        inputStream = resources.nextElement().openStream();
                        try {
                            newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, HTTP.UTF_8);
                            eventType = newPullParser.getEventType();
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = null;
                    }
                    do {
                        if (eventType == 2) {
                            if (newPullParser.getName().equals("iqProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText2 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText3 = newPullParser.nextText();
                                String m2632a = m2632a(nextText, nextText2);
                                if (!this.f1851b.containsKey(m2632a)) {
                                    try {
                                        Class<?> cls = Class.forName(nextText3);
                                        if (InterfaceC1620fs.class.isAssignableFrom(cls)) {
                                            this.f1851b.put(m2632a, cls.newInstance());
                                        } else if (C1613fl.class.isAssignableFrom(cls)) {
                                            this.f1851b.put(m2632a, cls);
                                        }
                                    } catch (ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else if (newPullParser.getName().equals("extensionProvider")) {
                                newPullParser.next();
                                newPullParser.next();
                                String nextText4 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText5 = newPullParser.nextText();
                                newPullParser.next();
                                newPullParser.next();
                                String nextText6 = newPullParser.nextText();
                                String m2632a2 = m2632a(nextText4, nextText5);
                                if (!this.f1850a.containsKey(m2632a2)) {
                                    try {
                                        Class<?> cls2 = Class.forName(nextText6);
                                        if (InterfaceC1621ft.class.isAssignableFrom(cls2)) {
                                            this.f1850a.put(m2632a2, cls2.newInstance());
                                        } else if (InterfaceC1616fo.class.isAssignableFrom(cls2)) {
                                            this.f1850a.put(m2632a2, cls2);
                                        }
                                    } catch (ClassNotFoundException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            th = th;
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                        eventType = newPullParser.next();
                    } while (eventType != 1);
                    inputStream.close();
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    public Object m2634a(String str, String str2) {
        return this.f1850a.get(m2632a(str, str2));
    }

    /* renamed from: a */
    public void m2636a(String str, String str2, Object obj) {
        if (!(obj instanceof InterfaceC1621ft) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f1850a.put(m2632a(str, str2), obj);
    }

    /* renamed from: a */
    private String m2632a(String str, String str2) {
        StringBuilder sb = new StringBuilder("<");
        sb.append(str).append("/>");
        if (str != null) {
            sb.append("<").append(str2).append("/>");
        }
        return sb.toString();
    }

    /* renamed from: a */
    private ClassLoader[] m2633a() {
        ClassLoader[] classLoaderArr = {C1622fu.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    private C1622fu() {
        m2635a();
    }
}
