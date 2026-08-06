package com.apm.lite.nativecrash;

import com.apm.lite.C0738c;
import com.apm.lite.p023k.C0788k;
import com.apm.lite.p023k.C0792o;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.apm.lite.nativecrash.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0807e {

    /* renamed from: i */
    private static final Pattern f631i = Pattern.compile("^pid:\\s(.*),\\stid:\\s(.*),\\sname:\\s(.*)\\s+>>>\\s(.*)\\s<<<$");

    /* renamed from: j */
    private static final Pattern f632j = Pattern.compile("^signal\\s(.*),\\scode\\s(.*),\\sfault\\saddr\\s(.*)$");

    /* renamed from: k */
    private static final Pattern f633k = Pattern.compile("^Abort message: (.*)$");

    /* renamed from: l */
    private static final Pattern f634l = Pattern.compile("^Crash message: (.*)$");

    /* renamed from: m */
    private static final Pattern f635m = Pattern.compile("^    \\/(\\w*)\\/.*\\/(.*\\.so)\\s\\(BuildId: ([a-f0-9]*)\\)$");

    /* renamed from: a */
    private String f636a;

    /* renamed from: b */
    private String f637b;

    /* renamed from: c */
    private String f638c;

    /* renamed from: d */
    private String f639d;

    /* renamed from: e */
    private String f640e;

    /* renamed from: f */
    private String f641f;

    /* renamed from: g */
    private String f642g;

    /* renamed from: h */
    private Map<String, String> f643h = new HashMap();

    public C0807e(File file) {
        m1007c(C0792o.m853b(file));
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x019b, code lost:
    
        r12 = r3.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x019f, code lost:
    
        if (r12 == null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a7, code lost:
    
        if (r12.contains("BuildId:") != false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01aa, code lost:
    
        r12 = com.apm.lite.nativecrash.C0807e.f635m.matcher(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01b4, code lost:
    
        if (r12.find() != false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01b7, code lost:
    
        r0 = r12.group(1);
        r1 = r12.group(2);
        r12 = r12.group(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01c9, code lost:
    
        if (r0.equals(com.bytedance.framwork.core.sdklib.apm6.Constants.KEY_DATA) == false) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01cb, code lost:
    
        r11.f643h.put(r1, r12);
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m1007c(File file) {
        String str;
        if (!file.exists() || file.length() == 0) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            int i = 0;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null || i >= 64) {
                        break;
                    }
                    if (this.f636a == null && readLine.startsWith("pid: ")) {
                        Matcher matcher = f631i.matcher(readLine);
                        if (matcher.find() && matcher.groupCount() == 4) {
                            this.f636a = matcher.group(1);
                            this.f637b = matcher.group(2);
                            this.f639d = matcher.group(3);
                            this.f638c = matcher.group(4);
                        }
                    } else if (this.f640e == null && readLine.startsWith("signal ")) {
                        Matcher matcher2 = f632j.matcher(readLine);
                        if (matcher2.find() && matcher2.groupCount() == 3) {
                            String replace = matcher2.group(1).replace(" ", "");
                            String replace2 = matcher2.group(2).replace(" ", "");
                            int indexOf = replace2.indexOf("frompid");
                            if (indexOf > 0) {
                                replace2 = replace2.substring(0, indexOf) + ")";
                            }
                            this.f640e = "Signal " + replace + ", Code " + replace2 + "\n";
                        }
                    } else if (this.f641f == null && readLine.startsWith("Abort ")) {
                        Matcher matcher3 = f633k.matcher(readLine);
                        if (matcher3.find() && matcher3.groupCount() == 1) {
                            str = "abort message: " + matcher3.group(1) + "\n";
                            this.f641f = str;
                        }
                    } else if (this.f641f == null && readLine.startsWith("Crash ")) {
                        Matcher matcher4 = f634l.matcher(readLine);
                        if (matcher4.find() && matcher4.groupCount() == 1) {
                            str = "crash message: " + matcher4.group(1) + "\n";
                            this.f641f = str;
                        }
                    } else if (this.f642g != null || !readLine.startsWith("backtrace:")) {
                        if (this.f643h.isEmpty() && readLine.startsWith("build id:")) {
                            break;
                        }
                    } else {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String readLine2 = bufferedReader2.readLine();
                            if (readLine2 == null || !readLine2.startsWith("    #")) {
                                break;
                            } else {
                                sb.append(readLine2.substring(4)).append('\n');
                            }
                        }
                        i++;
                        this.f642g = sb.toString();
                    }
                    i++;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        C0738c.m435a();
                        C0738c.m436a("NPTH_CATCH", th);
                        return;
                    } finally {
                        C0788k.m813a(bufferedReader);
                    }
                }
            }
            C0788k.m813a(bufferedReader2);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public String m1008a() {
        return this.f642g;
    }

    /* renamed from: a */
    public void m1009a(File file) {
        File m853b = C0792o.m853b(file);
        if (m853b.exists()) {
            m853b.renameTo(new File(m853b.getAbsoluteFile() + ".old"));
        }
        NativeImpl.rebuildTombstone(file);
        m1007c(C0792o.m853b(file));
    }

    /* renamed from: b */
    public Map<String, String> m1010b() {
        return this.f643h;
    }

    /* renamed from: b */
    public void m1011b(File file) {
        m1007c(C0792o.m853b(file));
    }

    /* renamed from: c */
    public String m1012c() {
        StringBuilder sb = new StringBuilder();
        String str = this.f640e;
        if (str != null) {
            sb.append(str);
        }
        String str2 = this.f641f;
        if (str2 != null) {
            sb.append(str2);
        }
        String str3 = this.f642g;
        if (str3 != null) {
            sb.append(str3);
        }
        return sb.toString();
    }
}
