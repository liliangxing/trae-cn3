package com.bytedance.crash.util;

import com.bytedance.crash.NpthBus;
import com.bytedance.librarian.Librarian;

/* loaded from: classes3.dex */
public class SoUtils {
    public static boolean loadLib(String str) {
        try {
            try {
                System.loadLibrary(str);
                return true;
            } catch (Throwable unused) {
                Librarian.loadLibraryForModule(str, NpthBus.getApplicationContext());
                return true;
            }
        } catch (Throwable unused2) {
            return false;
        }
    }
}
