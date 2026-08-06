package com.apm.lite.p023k;

import android.text.TextUtils;
import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.p023k.C0782e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.apm.lite.k.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0799v {

    /* renamed from: a */
    private static final StackTraceElement f602a = new StackTraceElement("", "", "", 0);

    /* renamed from: com.apm.lite.k.v$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class a {

        /* renamed from: a */
        public int f603a;

        /* renamed from: b */
        public int f604b;

        public a(int i, int i2) {
            this.f603a = i;
            this.f604b = i2;
        }

        /* renamed from: a */
        public JSONObject m940a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", this.f603a);
                jSONObject.put("end", this.f604b);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m916a(String str) {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            int i2 = 0;
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (i2 <= 256) {
                        linkedList.add(readLine);
                        sb.append(readLine).append('\n');
                    } else {
                        linkedList2.add(readLine);
                        if (linkedList2.size() > 256) {
                            linkedList2.poll();
                            i++;
                        }
                    }
                    i2++;
                } catch (Throwable unused) {
                    bufferedReader = bufferedReader2;
                    C0788k.m813a(bufferedReader);
                    if (!linkedList2.isEmpty()) {
                    }
                    return sb.toString();
                }
            }
            C0788k.m813a(bufferedReader2);
        } catch (Throwable unused2) {
        }
        if (!linkedList2.isEmpty()) {
            if (i != 0) {
                sb.append("\t... skip ").append(i).append(" lines\n");
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next()).append('\n');
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    /* renamed from: a */
    public static String m917a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            m928a(th, printWriter);
            String stringWriter2 = stringWriter.toString();
            printWriter.close();
            return stringWriter2;
        } catch (Throwable unused) {
            printWriter.close();
            return "";
        }
    }

    /* renamed from: a */
    public static String m918a(Throwable th, Thread thread, PrintStream printStream, C0782e.a aVar) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (Throwable unused) {
            messageDigest = null;
        }
        C0782e c0782e = new C0782e(printStream, messageDigest, aVar);
        try {
            m928a(th, c0782e);
        } catch (Throwable unused2) {
        }
        c0782e.close();
        if (messageDigest != null) {
            return m919a(messageDigest.digest());
        }
        return null;
    }

    /* renamed from: a */
    private static String m919a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    /* renamed from: a */
    public static String m920a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            m921a(stackTraceElement, sb);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static StringBuilder m921a(StackTraceElement stackTraceElement, StringBuilder sb) {
        sb.append("  at ").append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName()).append("(").append(stackTraceElement.getFileName()).append(":").append(stackTraceElement.getLineNumber()).append(")\n");
        return sb;
    }

    /* renamed from: a */
    public static JSONArray m922a(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (aVar.f603a == -1) {
                if (m932a(stackTraceElementArr[i].getClassName(), strArr)) {
                    aVar.f603a = i;
                    aVar.f604b = i;
                }
            } else if (!m932a(stackTraceElementArr[i].getClassName(), strArr)) {
                aVar.f604b = i;
                jSONArray.put(aVar.m940a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.f603a != -1) {
            aVar.f604b = stackTraceElementArr.length;
            jSONArray.put(aVar.m940a());
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static JSONArray m923a(String[] strArr, String[] strArr2) {
        a aVar = new a(-1, -1);
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < strArr.length; i++) {
            if (aVar.f603a == -1) {
                if (m932a(strArr[i], strArr2)) {
                    aVar.f603a = i;
                    aVar.f604b = i;
                }
            } else if (!m932a(strArr[i], strArr2)) {
                aVar.f604b = i;
                jSONArray.put(aVar.m940a());
                aVar = new a(-1, -1);
            }
        }
        if (aVar.f603a != -1) {
            aVar.f604b = strArr.length;
            jSONArray.put(aVar.m940a());
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static void m924a(StackTraceElement stackTraceElement, int i) {
        String str;
        String valueOf;
        try {
            m925a("\tat ", i);
            m925a(stackTraceElement.getClassName(), i);
            m925a(".", i);
            m925a(stackTraceElement.getMethodName(), i);
            if (!stackTraceElement.isNativeMethod()) {
                if (stackTraceElement.getFileName() != null) {
                    if (stackTraceElement.getLineNumber() >= 0) {
                        m925a("(", i);
                        m925a(stackTraceElement.getFileName(), i);
                        m925a(":", i);
                        valueOf = String.valueOf(stackTraceElement.getLineNumber());
                    } else {
                        m925a("(", i);
                        valueOf = stackTraceElement.getFileName();
                    }
                } else if (stackTraceElement.getLineNumber() >= 0) {
                    m925a("(Unknown Source:", i);
                    valueOf = String.valueOf(stackTraceElement.getLineNumber());
                } else {
                    str = "(Unknown Source)";
                }
                m925a(valueOf, i);
                m925a(")", i);
                m925a("\n", i);
            }
            str = "(Native Method)";
            m925a(str, i);
            m925a("\n", i);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static void m925a(String str, int i) {
        NativeImpl.writeFile(i, str);
    }

    /* renamed from: a */
    public static void m926a(Throwable th, int i) {
        try {
            m936c(th, i);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private static void m927a(Throwable th, int i, String str, String str2) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        try {
            NativeImpl.writeFile(i, str2);
            NativeImpl.writeFile(i, str);
        } catch (Throwable unused) {
        }
        m934b(th, i);
        for (StackTraceElement stackTraceElement : stackTrace) {
            m924a(stackTraceElement, i);
        }
        for (Throwable th2 : th.getSuppressed()) {
            m927a(th2, i, "Suppressed: ", str2 + "\t");
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            m927a(cause, i, "Caused by: ", str2);
        }
    }

    /* renamed from: a */
    private static void m928a(Throwable th, PrintWriter printWriter) {
        if (th == null || printWriter == null) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        printWriter.println(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > 384;
        int length = stackTrace.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (z && i2 > 256) {
                printWriter.println("\t... skip " + ((stackTrace.length - i2) - 128) + " lines");
                break;
            } else {
                printWriter.println("\tat " + stackTraceElement);
                i2++;
                i++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                printWriter.println("\tat " + stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            m929a(th2, printWriter, stackTrace, "Suppressed: ", "\t", (Set<Throwable>) newSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            m929a(cause, printWriter, stackTrace, "Caused by: ", "", (Set<Throwable>) newSetFromMap, 128);
        }
    }

    /* renamed from: a */
    private static void m929a(Throwable th, PrintWriter printWriter, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set, int i) {
        if (set.contains(th)) {
            printWriter.println("\t[CIRCULAR REFERENCE:" + th + "]");
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > i;
        printWriter.println(str2 + str + th);
        int length = stackTrace.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (z && i3 > i) {
                printWriter.println("\t... skip " + ((stackTrace.length - i3) - (i / 2)) + " lines");
                break;
            } else {
                printWriter.println("\tat " + stackTraceElement);
                i3++;
                i2++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                printWriter.println("\tat " + stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            int i4 = i / 2;
            m929a(th2, printWriter, stackTrace, "Suppressed: ", str2 + "\t", set, i4 > 10 ? i4 : 10);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i5 = i / 2;
            m929a(cause, printWriter, stackTrace, "Caused by: ", str2, set, i5 > 10 ? i5 : 10);
        }
    }

    /* renamed from: a */
    private static void m930a(Throwable th, List<StackTraceElement> list) {
        if (th == null || list == null) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        newSetFromMap.add(th);
        list.add(f602a);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > 384;
        int length = stackTrace.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i];
            if (z && i2 > 256) {
                list.add(f602a);
                break;
            } else {
                list.add(stackTraceElement);
                i2++;
                i++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - 128; length2 < stackTrace.length; length2++) {
                list.add(stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            m931a(th2, list, stackTrace, "Suppressed: ", "\t", (Set<Throwable>) newSetFromMap, 128);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            m931a(cause, list, stackTrace, "Caused by: ", "", (Set<Throwable>) newSetFromMap, 128);
        }
    }

    /* renamed from: a */
    private static void m931a(Throwable th, List<StackTraceElement> list, StackTraceElement[] stackTraceElementArr, String str, String str2, Set<Throwable> set, int i) {
        if (set.contains(th)) {
            list.add(f602a);
            return;
        }
        set.add(th);
        StackTraceElement[] stackTrace = th.getStackTrace();
        boolean z = stackTrace.length > i;
        list.add(f602a);
        int length = stackTrace.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            StackTraceElement stackTraceElement = stackTrace[i2];
            if (z && i3 > i) {
                list.add(f602a);
                break;
            } else {
                list.add(stackTraceElement);
                i3++;
                i2++;
            }
        }
        if (z) {
            for (int length2 = stackTrace.length - (i / 2); length2 < stackTrace.length; length2++) {
                list.add(stackTrace[length2]);
            }
        }
        for (Throwable th2 : th.getSuppressed()) {
            int i4 = i / 2;
            m931a(th2, list, stackTrace, "Suppressed: ", str2 + "\t", set, i4 > 10 ? i4 : 10);
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            int i5 = i / 2;
            m931a(cause, list, stackTrace, "Caused by: ", str2, set, i5 > 10 ? i5 : 10);
        }
    }

    /* renamed from: a */
    public static boolean m932a(String str, String[] strArr) {
        if (strArr != null && !TextUtils.isEmpty(str)) {
            for (String str2 : strArr) {
                if (str.contains(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x002a A[SYNTHETIC] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONObject m933b(String str) {
        boolean z;
        try {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            JSONObject jSONObject = new JSONObject();
            if (allStackTraces == null) {
                return null;
            }
            jSONObject.put("thread_all_count", allStackTraces.size());
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
                JSONObject jSONObject2 = new JSONObject();
                Thread key = entry.getKey();
                String name = key.getName();
                if (!m937c(name) && (str == null || (!str.equals(name) && !name.startsWith(str) && !name.endsWith(str)))) {
                    jSONObject2.put("thread_name", key.getName() + "(" + key.getId() + ")");
                    StackTraceElement[] value = entry.getValue();
                    if (value != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : value) {
                            jSONArray2.put(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getLineNumber() + ")");
                        }
                        jSONObject2.put("thread_stack", jSONArray2);
                        if (jSONArray2.length() <= 0) {
                            z = false;
                            if (!z) {
                                jSONArray.put(jSONObject2);
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
            }
            jSONObject.put("thread_stacks", jSONArray);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    private static void m934b(Throwable th, int i) {
        th.getClass().getName();
        String localizedMessage = th.getLocalizedMessage();
        try {
            m925a(th.getClass().getName(), i);
            if (localizedMessage != null) {
                m925a(": ", i);
                m925a(localizedMessage, i);
            }
            m925a("\n", i);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    public static StackTraceElement[] m935b(Throwable th) {
        ArrayList arrayList = new ArrayList();
        try {
            m930a(th, arrayList);
        } catch (Throwable unused) {
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]);
    }

    /* renamed from: c */
    private static void m936c(Throwable th, int i) {
        if (th == null || i <= 0) {
            return;
        }
        m934b(th, i);
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            m924a(stackTraceElement, i);
        }
        for (Throwable th2 : th.getSuppressed()) {
            m927a(th2, i, "Suppressed: ", "\t");
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            m927a(cause, i, "Caused by: ", "");
        }
    }

    /* renamed from: c */
    private static boolean m937c(String str) {
        Set<String> m812a = C0787j.m812a();
        if (m812a.contains(str)) {
            return true;
        }
        for (String str2 : m812a) {
            if (!TextUtils.isEmpty(str) && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public static boolean m938c(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if (th instanceof OutOfMemoryError) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: d */
    public static boolean m939d(Throwable th) {
        if (th == null) {
            return false;
        }
        int i = 0;
        while (th != null) {
            try {
                if ((th instanceof OutOfMemoryError) && (th.getMessage().contains("allocate") || th.getMessage().contains("thrown"))) {
                    return true;
                }
                if (i > 20) {
                    return false;
                }
                i++;
                th = th.getCause();
            } catch (Throwable unused) {
                return true;
            }
        }
        return false;
    }
}
