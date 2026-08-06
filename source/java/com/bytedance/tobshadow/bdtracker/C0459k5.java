package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.bytedance.tobshadow.bdtracker.k5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0459k5 {

    /* renamed from: a */
    public final ArrayList<String> f728a = new ArrayList<>();

    /* renamed from: a */
    public final void m504a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(C0380a.m252a(str).append(File.separator).append(str2).append(".dat").toString());
        if (file.exists()) {
            file.delete();
        }
    }
}
