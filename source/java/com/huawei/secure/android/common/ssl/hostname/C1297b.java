package com.huawei.secure.android.common.ssl.hostname;

import com.example.memorycollector.BuildConfig;
import com.huawei.secure.android.common.ssl.util.C1302e;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;

/* renamed from: com.huawei.secure.android.common.ssl.hostname.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1297b {

    /* renamed from: a */
    private static final Pattern f2178a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");

    /* renamed from: b */
    private static final String[] f2179b;

    static {
        String[] strArr = {"ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        f2179b = strArr;
        Arrays.sort(strArr);
    }

    /* renamed from: a */
    public static final void m2355a(String str, X509Certificate x509Certificate, boolean z) throws SSLException {
        String[] m2358a = m2358a(x509Certificate);
        String[] m2360b = m2360b(x509Certificate);
        C1302e.m2405a("", "cn is : " + Arrays.toString(m2358a));
        C1302e.m2405a("", "san is : " + Arrays.toString(m2360b));
        m2356a(str, m2358a, m2360b, z);
    }

    /* renamed from: b */
    public static String[] m2360b(X509Certificate x509Certificate) {
        Collection<List<?>> collection;
        LinkedList linkedList = new LinkedList();
        try {
            collection = x509Certificate.getSubjectAlternativeNames();
        } catch (CertificateParsingException e) {
            C1302e.m2406a("", "Error parsing certificate.", e);
            collection = null;
        }
        if (collection != null) {
            for (List<?> list : collection) {
                if (((Integer) list.get(0)).intValue() == 2) {
                    linkedList.add((String) list.get(1));
                }
            }
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        return strArr;
    }

    /* renamed from: c */
    private static boolean m2361c(String str) {
        return f2178a.matcher(str).matches();
    }

    /* renamed from: a */
    public static final void m2356a(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        String str2;
        LinkedList linkedList = new LinkedList();
        if (strArr != null && strArr.length > 0 && (str2 = strArr[0]) != null) {
            linkedList.add(str2);
        }
        if (strArr2 != null) {
            for (String str3 : strArr2) {
                if (str3 != null) {
                    linkedList.add(str3);
                }
            }
        }
        if (!linkedList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
            Iterator it = linkedList.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                stringBuffer.append(" <");
                stringBuffer.append(lowerCase2);
                stringBuffer.append('>');
                if (it.hasNext()) {
                    stringBuffer.append(" OR");
                }
                if (lowerCase2.startsWith("*.") && lowerCase2.indexOf(46, 2) != -1 && m2357a(lowerCase2) && !m2361c(str)) {
                    boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                    if (endsWith && z) {
                        z2 = m2359b(lowerCase) == m2359b(lowerCase2);
                    } else {
                        z2 = endsWith;
                    }
                } else {
                    z2 = lowerCase.equals(lowerCase2);
                }
                if (z2) {
                    break;
                }
            }
            if (!z2) {
                throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) stringBuffer));
            }
            return;
        }
        throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
    }

    /* renamed from: b */
    public static int m2359b(String str) {
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '.') {
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    public static boolean m2357a(String str) {
        int length = str.length();
        if (length < 7 || length > 9) {
            return true;
        }
        int i = length - 3;
        if (str.charAt(i) == '.') {
            return Arrays.binarySearch(f2179b, str.substring(2, i)) < 0;
        }
        return true;
    }

    /* renamed from: a */
    public static String[] m2358a(X509Certificate x509Certificate) {
        List<String> m2354b = new C1296a(x509Certificate.getSubjectX500Principal()).m2354b(BuildConfig.FLAVOR_region);
        if (m2354b.isEmpty()) {
            return null;
        }
        String[] strArr = new String[m2354b.size()];
        m2354b.toArray(strArr);
        return strArr;
    }
}
