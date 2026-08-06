package com.lynx.canvas;

import com.lynx.canvas.Krypton;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes6.dex */
public class KryptonLLog {
    static final String KRYPTON_TAG = "[Krypton]";

    public static void v(String str, String str2) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> it = Krypton.inst().getLoggers().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().v(KRYPTON_TAG + str, str2);
        }
    }

    public static void d(String str, String str2) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> it = Krypton.inst().getLoggers().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().d(KRYPTON_TAG + str, str2);
        }
    }

    public static void i(String str, String str2) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> it = Krypton.inst().getLoggers().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().i(KRYPTON_TAG + str, str2);
        }
    }

    public static void w(String str, String str2) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> it = Krypton.inst().getLoggers().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().w(KRYPTON_TAG + str, str2);
        }
    }

    public static void e(String str, String str2) {
        Iterator<Map.Entry<String, Krypton.IKryptonJavaLogger>> it = Krypton.inst().getLoggers().entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().e(KRYPTON_TAG + str, str2);
        }
    }
}
