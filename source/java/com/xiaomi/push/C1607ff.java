package com.xiaomi.push;

import com.ss.android.http.legacy.protocol.HTTP;
import com.vivo.push.PushClientConstants;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* renamed from: com.xiaomi.push.ff */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1607ff {

    /* renamed from: a */
    private static int f1730a = 5000;

    /* renamed from: a */
    private static Vector<String> f1731a = new Vector<>();

    /* renamed from: b */
    private static int f1732b = 330000;

    /* renamed from: c */
    private static int f1733c = 600000;

    /* renamed from: d */
    private static int f1734d = 330000;

    /* renamed from: a */
    public static String m2544a() {
        return "3.1.0";
    }

    static {
        try {
            for (ClassLoader classLoader : m2546a()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        try {
                            inputStream = resources.nextElement().openStream();
                            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, HTTP.UTF_8);
                            int eventType = newPullParser.getEventType();
                            do {
                                if (eventType == 2) {
                                    if (newPullParser.getName().equals(PushClientConstants.TAG_CLASS_NAME)) {
                                        m2545a(newPullParser);
                                    } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                        f1730a = m2543a(newPullParser, f1730a);
                                    } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                        f1732b = m2543a(newPullParser, f1732b);
                                    } else if (newPullParser.getName().equals("mechName")) {
                                        f1731a.add(newPullParser.nextText());
                                    }
                                }
                                eventType = newPullParser.next();
                            } while (eventType != 1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private C1607ff() {
    }

    /* renamed from: a */
    public static int m2542a() {
        return f1732b;
    }

    /* renamed from: b */
    public static int m2547b() {
        return f1733c;
    }

    /* renamed from: a */
    private static void m2545a(XmlPullParser xmlPullParser) {
        String nextText = xmlPullParser.nextText();
        try {
            Class.forName(nextText);
        } catch (ClassNotFoundException unused) {
            System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + nextText);
        }
    }

    /* renamed from: a */
    private static int m2543a(XmlPullParser xmlPullParser, int i) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    /* renamed from: a */
    private static ClassLoader[] m2546a() {
        ClassLoader[] classLoaderArr = {C1607ff.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 2; i++) {
            ClassLoader classLoader = classLoaderArr[i];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
