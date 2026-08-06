package ms.bd.p001c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import net.openid.appauth.BuildConfig;
import okio.Utf8;
import org.bouncycastle.math.ec.Tnaf;

/* renamed from: ms.bd.c.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0217v {

    /* renamed from: a */
    public static final String f417a = (String) AbstractC0190p2.m166a(16777217, 0, 0, "a7ce96", new byte[]{64, 39, 31, 18, 3, 50, 113, 25, 32});

    /* renamed from: b */
    public static final String f418b = (String) AbstractC0190p2.m166a(16777217, 0, 0, "12cfb9", new byte[]{8, 49, 2, 22, 74, 47, 32, 22});

    /* renamed from: c */
    public static final String f419c = (String) AbstractC0190p2.m166a(16777217, 0, 0, "f0b44b", new byte[]{81, 55, Tnaf.POW_2_WIDTH, 84, 30, 103, 96, 2});

    /* renamed from: d */
    public static final String f420d = (String) AbstractC0190p2.m166a(16777217, 0, 0, "9cad6a", new byte[]{56, 98});

    /* renamed from: e */
    public static final String f421e = (String) AbstractC0190p2.m166a(16777217, 0, 0, "fe9478", new byte[]{Byte.MAX_VALUE, 112});

    /* renamed from: f */
    public static final String f422f = (String) AbstractC0190p2.m166a(16777217, 0, 0, "7109ca", new byte[]{32, 39});

    /* renamed from: g */
    public static final String f423g = (String) AbstractC0190p2.m166a(16777217, 0, 0, "e1092e", new byte[]{121, 50, 91});

    /* renamed from: h */
    public static final String f424h = (String) AbstractC0190p2.m166a(16777217, 0, 0, "28da52", new byte[]{46, 51, 25});

    /* renamed from: i */
    public static final String f425i = (String) AbstractC0190p2.m166a(16777217, 0, 0, "024b3c", new byte[]{34, Utf8.REPLACEMENT_BYTE, 85, 19});

    /* renamed from: j */
    public static final C0212u f426j = new C0212u();

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0041, code lost:
    
        if (r10 == null) goto L19;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m196a(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        File file;
        String str2 = null;
        try {
            file = new File(str);
        } catch (Throwable unused) {
            fileReader = null;
            bufferedReader = null;
        }
        if (!file.exists()) {
            return (String) AbstractC0190p2.m166a(16777217, 0, 0L, "0ad581", new byte[]{113});
        }
        fileReader = new FileReader(file);
        try {
            bufferedReader = new BufferedReader(fileReader);
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        try {
            str2 = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused5) {
                }
            }
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
            return str2 == null ? (String) AbstractC0190p2.m166a(16777217, 0, 0L, "d34651", new byte[]{37}) : str2.trim();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
    
        if (r2 == null) goto L25;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HashMap m198a() {
        FileReader fileReader;
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader((String) AbstractC0190p2.m166a(16777217, 0, 0L, "0e4185", new byte[]{110, 119, 85, 74, 4, 109, 48, 84, 112, 104, 47, 97, 72}));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(fileReader);
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            try {
                                break;
                            } catch (Throwable unused) {
                            }
                        } else {
                            String[] split = readLine.split((String) AbstractC0190p2.m166a(16777217, 0, 0L, "27c013", new byte[]{121}), 2);
                            if (split.length >= 2) {
                                String trim = split[0].trim();
                                String trim2 = split[1].trim();
                                if (hashMap.get(trim) == null) {
                                    hashMap.put(trim, trim2);
                                }
                            }
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable unused3) {
                            }
                        }
                    }
                }
                bufferedReader2.close();
            } catch (Throwable unused4) {
            }
        } catch (Throwable unused5) {
            fileReader = null;
        }
        try {
            fileReader.close();
        } catch (Throwable unused6) {
            return hashMap;
        }
    }

    /* renamed from: a */
    public static String m197a(HashMap hashMap, String str) {
        String str2;
        try {
            str2 = (String) hashMap.get(str);
        } catch (Throwable unused) {
            str2 = null;
        }
        return str2 == null ? BuildConfig.FLAVOR : str2.trim();
    }
}
