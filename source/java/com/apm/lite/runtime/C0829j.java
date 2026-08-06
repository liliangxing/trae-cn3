package com.apm.lite.runtime;

import android.text.TextUtils;
import com.apm.lite.C0738c;
import com.apm.lite.C0749e;
import com.apm.lite.p023k.C0783f;
import com.apm.lite.p023k.C0788k;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;

/* renamed from: com.apm.lite.runtime.j */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0829j {
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004b: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:31:0x004b */
    /* renamed from: a */
    public static JSONArray m1150a(String str) {
        Closeable closeable;
        BufferedReader bufferedReader;
        Closeable closeable2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray();
                bufferedReader = new BufferedReader(new FileReader(str));
                try {
                    File file = new File(str);
                    if (file.length() > 512000) {
                        bufferedReader.skip(file.length() - 512000);
                    }
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            C0788k.m813a(bufferedReader);
                            return jSONArray;
                        }
                        jSONArray.put(readLine);
                    }
                } catch (IOException e) {
                    e = e;
                    e.printStackTrace();
                    C0788k.m813a(bufferedReader);
                    return null;
                }
            } catch (IOException e2) {
                e = e2;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                C0788k.m813a(closeable2);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            closeable2 = closeable;
        }
    }

    /* renamed from: b */
    public static JSONArray m1151b(String str) {
        try {
            return m1150a(C0783f.m770a(str, C0749e.m567i().getLogcatDumpCount(), C0749e.m567i().getLogcatLevel()).getAbsolutePath());
        } catch (Throwable th) {
            C0738c.m435a();
            C0738c.m436a("NPTH_CATCH", th);
            return null;
        }
    }
}
