package com.bytedance.reparo.core.hook;

import android.os.Build;
import com.bytedance.reparo.core.PatchLogger;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.SoLoadException;
import com.bytedance.reparo.core.utils.ReflectUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SoLibraryHooker {
    private static final String TAG = "SoLibraryHooker";

    public void hook(File file) throws SoLoadException {
        SoLoadException soLoadException;
        SoLoadException soLoadException2;
        if (!FileUtils.isExist(file)) {
            PatchLogger.m303e(TAG, String.format("library dir %s not exist, hook failed.", file.getAbsolutePath()));
            return;
        }
        ClassLoader classLoader = SoLibraryHooker.class.getClassLoader();
        if (Build.VERSION.SDK_INT <= 25) {
            try {
                V23.install(classLoader, file);
            } finally {
                try {
                } catch (Throwable th) {
                }
            }
        } else {
            try {
                V25.install(classLoader, file);
            } finally {
                try {
                } catch (Throwable th2) {
                }
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class V14 {
        private V14() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = ReflectUtils.findField(classLoader, "pathList").get(classLoader);
            Field findField = ReflectUtils.findField(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) findField.get(obj);
            ArrayList arrayList = new ArrayList(fileArr.length + 1);
            arrayList.add(file);
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            findField.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* renamed from: com.bytedance.reparo.core.hook.SoLibraryHooker$V4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class C0743V4 {
        private C0743V4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            String path = file.getPath();
            Field findField = ReflectUtils.findField(classLoader, "libPath");
            String[] split = ((String) findField.get(classLoader)).split(":");
            StringBuilder sb = new StringBuilder(path);
            for (String str : split) {
                if (str != null && !path.equals(str)) {
                    sb.append(':').append(str);
                }
            }
            findField.set(classLoader, sb.toString());
            Field findField2 = ReflectUtils.findField(classLoader, "libraryPathElements");
            List list = (List) findField2.get(classLoader);
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (path.equals((String) it.next())) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
            list.add(0, path);
            findField2.set(classLoader, list);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class V23 {
        private V23() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = ReflectUtils.findField(classLoader, "pathList").get(classLoader);
            List list = (List) ReflectUtils.findField(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            list.add(0, file);
            List list2 = (List) ReflectUtils.findField(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            ReflectUtils.findField(obj, "nativeLibraryPathElements").set(obj, (Object[]) ReflectUtils.findMethod(obj, "makePathElements", (Class<?>[]) new Class[]{List.class, File.class, List.class}).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static final class V25 {
        private V25() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void install(ClassLoader classLoader, File file) throws Throwable {
            Object obj = ReflectUtils.findField(classLoader, "pathList").get(classLoader);
            List list = (List) ReflectUtils.findField(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            list.add(0, file);
            List list2 = (List) ReflectUtils.findField(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            ReflectUtils.findField(obj, "nativeLibraryPathElements").set(obj, (Object[]) ReflectUtils.findMethod(obj, "makePathElements", (Class<?>[]) new Class[]{List.class}).invoke(obj, arrayList));
        }
    }
}
