package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class k5 {
    public final ArrayList<String> a = new ArrayList<>();

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(a.a(str).append(File.separator).append(str2).append(".dat").toString());
        if (file.exists()) {
            file.delete();
        }
    }
}
