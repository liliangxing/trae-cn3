package com.bytedance.crash.dumper;

import com.bytedance.crash.util.FileSystemUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class GfxInfo {
    private static final String FILE_NAME = "gfxinfo.txt";

    public static void dump(File file) {
        FileOutputStream fileOutputStream = null;
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Object invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Method declaredMethod = cls.getDeclaredMethod("dumpGfxInfo", FileDescriptor.class, String[].class);
            declaredMethod.setAccessible(true);
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, FILE_NAME));
            try {
                declaredMethod.invoke(invoke, fileOutputStream2.getFD(), new String[0]);
                FileSystemUtils.close(fileOutputStream2);
            } catch (Throwable unused) {
                fileOutputStream = fileOutputStream2;
                FileSystemUtils.close(fileOutputStream);
            }
        } catch (Throwable unused2) {
        }
    }
}
