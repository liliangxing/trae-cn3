package com.apm.lite.p023k;

import android.text.TextUtils;
import androidx.room.FtsOptions;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.CrashType;
import com.apm.lite.nativecrash.NativeImpl;
import com.apm.lite.p016d.C0745a;
import com.apm.lite.p016d.C0747c;
import com.apm.lite.p016d.C0748d;
import com.apm.lite.p017e.C0753d;
import com.apm.lite.p022j.C0770e;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.k.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0786i {
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        if (r18 != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0116, code lost:
    
        if (r18 != false) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0119, code lost:
    
        r3 = "InvalidStack.NoStackAvailable: not OOM.\n";
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x011a, code lost:
    
        r0 = null;
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ce, code lost:
    
        if (r18 != false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d1, code lost:
    
        r3 = "InvalidStack.NoStackAvailable: not OOM.\n";
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d2, code lost:
    
        r2 = r2.append(r3).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ea, code lost:
    
        if (r18 != false) goto L56;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0745a m779a(File file, boolean z) {
        String str;
        String str2;
        String str3;
        StringBuilder append;
        String str4;
        String str5;
        StringBuilder append2;
        C0745a c0745a = new C0745a();
        str = "InvalidStack.NoStackAvailable: OOM.\n";
        if (file.exists()) {
            try {
                str2 = m785a(file.getAbsolutePath(), "\n");
            } catch (IOException unused) {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                String[] split = str2.split("\n");
                ArrayList arrayList = new ArrayList();
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                boolean z2 = false;
                boolean z3 = false;
                for (String str6 : split) {
                    if (!z2 && str6.startsWith("stack:")) {
                        z2 = true;
                    } else if (z3 || !str6.startsWith("err:")) {
                        if (z3) {
                            append2 = sb2.append(str6);
                        } else if (z2) {
                            append2 = sb.append(str6);
                        } else {
                            arrayList.add(str6);
                        }
                        append2.append("\n");
                    } else {
                        z3 = true;
                    }
                }
                String str7 = arrayList.size() >= 1 ? (String) arrayList.get(0) : null;
                String str8 = arrayList.size() >= 2 ? (String) arrayList.get(1) : null;
                String str9 = arrayList.size() >= 3 ? (String) arrayList.get(2) : null;
                String str10 = arrayList.size() >= 4 ? (String) arrayList.get(3) : null;
                if (z2 && sb.length() > 0) {
                    str3 = sb.toString();
                } else if (str9 != null) {
                    append = new StringBuilder().append(str9).append("\nCaused by: ");
                } else if (str8 != null) {
                    append = new StringBuilder().append(str8).append("\nCaused by: ");
                } else {
                    str3 = z ? "InvalidStack.NoStackAvailable: OOM.\n" : "InvalidStack.NoStackAvailable: not OOM.\n";
                }
                if (z3 && sb2.length() > 0) {
                    str3 = str3 + "\nCaused by: InvalidStack.CrashWhenWriteStack: Npth ERROR:\n" + ((Object) sb2);
                }
                str = str3;
                str4 = str7;
                str5 = str10;
            }
        }
        c0745a.m484a(Constants.KEY_DATA, (Object) str);
        c0745a.m484a("process_name", (Object) str4);
        c0745a.m484a("crash_thread_name", (Object) str5);
        c0745a.m484a("isOOM", Boolean.valueOf(z));
        return c0745a;
    }

    /* renamed from: a */
    public static C0748d m780a(File file, CrashType crashType) {
        C0745a m806d = m806d(file);
        String name = file.getName();
        String substring = name.substring(name.lastIndexOf(95) + 1);
        JSONObject optJSONObject = m806d.m498h().optJSONObject(Constants.KEY_HEADER);
        if (optJSONObject.optString("unique_key", null) == null) {
            try {
                optJSONObject.put("unique_key", "android_" + C0749e.m560c().m1226a() + "_" + substring + "_" + CrashType.LAUNCH);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        C0748d c0748d = new C0748d();
        c0748d.m539a(crashType == CrashType.LAUNCH ? C0770e.m709e() : C0770e.m707c());
        c0748d.m541a(m806d.m498h());
        c0748d.m542a(C0770e.m696a());
        return c0748d;
    }

    /* renamed from: a */
    public static String m781a(File file, String str) {
        return m782a(file, str, -1L);
    }

    /* renamed from: a */
    public static String m782a(File file, String str, long j) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            if (j > 0) {
                try {
                    bufferedReader2.skip(j);
                    bufferedReader2.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    C0788k.m813a(bufferedReader);
                    throw th;
                }
            }
            while (true) {
                String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    C0788k.m813a(bufferedReader2);
                    return sb.toString();
                }
                if (sb.length() != 0 && str != null) {
                    sb.append(str);
                }
                sb.append(readLine);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static String m783a(File file, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(StreamTrafficObservable.STREAM_URL, str2);
            jSONObject2.put("body", jSONObject);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject2.put("dump_file", str3);
            jSONObject2.put("encrypt", z);
            m791a(file2, jSONObject2, false);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return file2.getAbsolutePath();
    }

    /* renamed from: a */
    public static String m784a(File file, String str, String str2, JSONObject jSONObject, boolean z) {
        return m783a(file, str, str2, jSONObject, null, z);
    }

    /* renamed from: a */
    public static String m785a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m781a(new File(str), str2);
    }

    /* renamed from: a */
    public static JSONArray m786a(File file, long j) {
        JSONArray jSONArray = new JSONArray();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            if (j > 0) {
                try {
                    bufferedReader2.skip(j);
                    bufferedReader2.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    C0788k.m813a(bufferedReader);
                    throw th;
                }
            }
            while (true) {
                String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    C0788k.m813a(bufferedReader2);
                    return jSONArray;
                }
                jSONArray.put(readLine);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static void m787a(File file, File file2) {
        FileOutputStream fileOutputStream;
        if (file == null || file2 == null) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            file2.getParentFile().mkdirs();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    C0788k.m813a(fileInputStream2);
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        C0788k.m813a(fileInputStream);
                        C0788k.m813a(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        C0788k.m813a(fileInputStream);
                        C0788k.m813a(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    C0788k.m813a(fileInputStream);
                    C0788k.m813a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        C0788k.m813a(fileOutputStream);
    }

    /* renamed from: a */
    public static void m788a(File file, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                C0788k.m813a(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                C0788k.m813a(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static void m789a(File file, Map<String, String> map) {
        Properties properties;
        FileOutputStream fileOutputStream;
        if (map == null || map.isEmpty()) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                properties = new Properties();
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }
            properties.store(fileOutputStream, "no");
            C0788k.m813a(fileOutputStream);
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            C0794q.m893b(e);
            C0788k.m813a(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            C0788k.m813a(fileOutputStream2);
            throw th;
        }
    }

    /* renamed from: a */
    public static void m790a(File file, JSONArray jSONArray, boolean z) {
        if (jSONArray == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                C0790m.m828a(jSONArray, bufferedWriter2);
                C0788k.m813a(bufferedWriter2);
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
                C0788k.m813a(bufferedWriter);
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public static void m791a(File file, JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            try {
                C0790m.m830a(jSONObject, bufferedWriter2);
                C0788k.m813a(bufferedWriter2);
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
                C0788k.m813a(bufferedWriter);
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public static void m792a(OutputStream outputStream, File... fileArr) {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(outputStream);
            try {
                zipOutputStream2.putNextEntry(new ZipEntry("/"));
                for (File file : fileArr) {
                    m794a(zipOutputStream2, file);
                }
                C0788k.m813a(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                C0788k.m813a(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private static void m793a(String str, File file) {
        ZipOutputStream zipOutputStream = null;
        try {
            new File(str).getParentFile().mkdirs();
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
            try {
                m795a(zipOutputStream2, file, "");
                C0788k.m813a(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                C0788k.m813a(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    private static void m794a(ZipOutputStream zipOutputStream, File file) {
        if (file == null || !file.exists()) {
            return;
        }
        File[] listFiles = file.isDirectory() ? file.listFiles() : new File[]{file};
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            m795a(zipOutputStream, file2, file2.getName());
        }
    }

    /* renamed from: a */
    private static void m795a(ZipOutputStream zipOutputStream, File file, String str) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            zipOutputStream.putNextEntry(new ZipEntry(str + "/"));
            String str2 = str.length() == 0 ? "" : str + "/";
            for (int i = 0; i < listFiles.length; i++) {
                m795a(zipOutputStream, listFiles[i], str2 + listFiles[i].getName());
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (-1 == read) {
                        C0788k.m813a(fileInputStream2);
                        return;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                C0788k.m813a(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static boolean m796a(File file) {
        boolean m796a;
        boolean z = true;
        if (!file.exists()) {
            return true;
        }
        if (!file.canWrite()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        for (int i = 0; listFiles != null && i < listFiles.length; i++) {
            if (!listFiles[i].isFile()) {
                m796a = m796a(listFiles[i]);
            } else if (listFiles[i].canWrite()) {
                m796a = listFiles[i].delete();
            } else {
                z = false;
            }
            z &= m796a;
        }
        return z & file.delete();
    }

    /* renamed from: a */
    public static boolean m797a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return m796a(new File(str));
    }

    /* renamed from: a */
    public static boolean m798a(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    /* renamed from: b */
    public static JSONArray m799b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return m786a(new File(str), -1L);
    }

    /* renamed from: b */
    public static JSONArray m800b(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (str != null && str2 != null) {
            for (String str3 : str.split(str2)) {
                jSONArray.put(str3);
            }
        }
        return jSONArray;
    }

    /* renamed from: b */
    public static void m801b(File file, JSONObject jSONObject, boolean z) {
        BufferedWriter bufferedWriter;
        if (jSONObject == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter2 = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            C0790m.m830a(jSONObject, bufferedWriter);
            C0788k.m813a(bufferedWriter);
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter2 = bufferedWriter;
            try {
                try {
                    jSONObject.put("err_write", th.toString());
                    C0745a.m466a(jSONObject, "filters", "err_write", th.getLocalizedMessage());
                } catch (JSONException unused) {
                    C0738c.m435a();
                    C0738c.m436a("NPTH_CATCH", th);
                    C0788k.m813a(bufferedWriter2);
                }
            } catch (Throwable th3) {
                C0788k.m813a(bufferedWriter2);
                throw th3;
            }
        }
    }

    /* renamed from: b */
    public static boolean m802b(File file) {
        String[] list = file.list();
        return list == null || list.length == 0;
    }

    /* renamed from: c */
    public static String m803c(File file) {
        return m781a(file, "\n");
    }

    /* renamed from: c */
    public static String m804c(String str) {
        return m785a(str, "\n");
    }

    /* renamed from: c */
    public static void m805c(String str, String str2) {
        m793a(str2, new File(str));
    }

    /* renamed from: d */
    public static C0745a m806d(File file) {
        C0745a m779a = m779a(new File(file, "logEventStack"), file.getName().contains("oom"));
        boolean z = false;
        for (int i = 0; i < C0753d.m610a(); i++) {
            File m849a = C0792o.m849a(file, "." + i);
            if (m849a.exists()) {
                try {
                    m779a.m492c(new JSONObject(m804c(m849a.getAbsolutePath())));
                    z = true;
                } catch (Throwable unused) {
                }
            }
        }
        m779a.m479a("crash_type", z ? "step" : FtsOptions.TOKENIZER_SIMPLE);
        JSONObject optJSONObject = m779a.m498h().optJSONObject(Constants.KEY_HEADER);
        JSONObject m537g = C0747c.m513a(C0749e.m565g(), m779a.m498h().optLong("crash_time", 0L)).m537g();
        if (optJSONObject == null) {
            m779a.m483a(m537g);
        } else {
            C0789l.m820a(optJSONObject, m537g);
        }
        return m779a;
    }

    /* renamed from: d */
    public static C0748d m807d(String str) {
        try {
            String m804c = m804c(str);
            if (m804c == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(m804c);
            C0748d c0748d = new C0748d();
            c0748d.m539a(jSONObject.optString(StreamTrafficObservable.STREAM_URL));
            c0748d.m541a(jSONObject.optJSONObject("body"));
            c0748d.m544b(jSONObject.optString("dump_file"));
            c0748d.m542a(jSONObject.optBoolean("encrypt", false));
            return c0748d;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: e */
    public static C0748d m808e(String str) {
        try {
            JSONObject jSONObject = new JSONObject(m804c(str));
            C0748d c0748d = new C0748d();
            c0748d.m548d(jSONObject.optString(MonitorConstants.KEY_AID));
            c0748d.m546c(jSONObject.optString("did"));
            c0748d.m550e(jSONObject.optString("processName"));
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("alogFiles");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
                c0748d.m540a(arrayList);
            }
            return c0748d;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0041: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:20:0x0041 */
    /* renamed from: e */
    public static Map<String, String> m809e(File file) {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                Properties properties = new Properties();
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    Set<String> stringPropertyNames = properties.stringPropertyNames();
                    HashMap hashMap = new HashMap();
                    for (String str : stringPropertyNames) {
                        hashMap.put(str, properties.getProperty(str));
                    }
                    C0788k.m813a(fileInputStream);
                    return hashMap;
                } catch (IOException e) {
                    e = e;
                    C0794q.m893b(e);
                    C0788k.m813a(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                C0788k.m813a(closeable2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            C0788k.m813a(closeable2);
            throw th;
        }
    }

    /* renamed from: f */
    public static void m810f(File file) {
        File file2 = new File(file, "lock");
        try {
            file2.createNewFile();
            NativeImpl.doLock(file2.getAbsolutePath());
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
    }

    /* renamed from: g */
    public static boolean m811g(File file) {
        int doLock;
        if (!file.isFile()) {
            file = new File(file, "lock");
        }
        if (!file.exists()) {
            return false;
        }
        try {
            doLock = NativeImpl.doLock(file.getAbsolutePath());
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
        }
        if (doLock <= 0) {
            return doLock < 0;
        }
        NativeImpl.unLock(doLock);
        return false;
    }
}
