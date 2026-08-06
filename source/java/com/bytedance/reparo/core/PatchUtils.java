package com.bytedance.reparo.core;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.reparo.core.log.TLog;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import dalvik.system.DexFile;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class PatchUtils {
    private static HashMap<String, Class> sAdditionalClassHolder = new HashMap<>();
    private static ArrayList<DexFile> sAdditionalDexFileHolder = new ArrayList<>();
    private static final String VENDOR_VERSION = System.getProperty("java.vm.version", "");

    public static ArrayList<Class> loadAdditionalClasses(Context context, List<String> list, List<String> list2) {
        ArrayList<Class> arrayList = new ArrayList<>();
        try {
            File file = new File(context.getFilesDir(), "hotfix_opt");
            if (file.exists()) {
                if (!file.isDirectory()) {
                    file.delete();
                    file.mkdirs();
                }
            } else {
                file.mkdirs();
            }
            for (String str : list) {
                File file2 = new File(str);
                File file3 = new File(file, file2.getName());
                file2.setReadOnly();
                DexFile loadDex = DexFile.loadDex(str, file3.getAbsolutePath(), 0);
                sAdditionalDexFileHolder.add(loadDex);
                if (list.size() <= 1 && list2 != null && !list2.isEmpty()) {
                    Iterator<String> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(loadAdditionalClass(it.next(), loadDex));
                    }
                } else {
                    Enumeration<String> entries = loadDex.entries();
                    while (entries.hasMoreElements()) {
                        arrayList.add(loadAdditionalClass(entries.nextElement(), loadDex));
                    }
                }
            }
            Iterator<Class> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ClassModifier.changeClassToVerified(it2.next(), false);
            }
        } catch (IOException e) {
            e = e;
            TLog.e("load additional class failed.", e);
        } catch (ClassNotFoundException e2) {
            e = e2;
            TLog.e("load additional class failed.", e);
        } catch (Exception e3) {
            TLog.e("load additional class failed.", e3);
        }
        return arrayList;
    }

    private static Class loadAdditionalClass(String str, DexFile dexFile) throws Exception {
        Class loadClass = dexFile.loadClass(str, PatchUtils.class.getClassLoader());
        if (loadClass == null) {
            throw new ClassNotFoundException(str);
        }
        Class.forName(loadClass.getName(), false, loadClass.getClassLoader());
        TLog.i("load additional class :" + str);
        if (loadClass != null) {
            sAdditionalClassHolder.put(loadClass.getName(), loadClass);
        }
        return loadClass;
    }

    public static void closeSafely(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                TLog.e("closeSafely", e);
            }
        }
    }

    public static boolean isART() {
        try {
            String str = VENDOR_VERSION;
            if (str == null || str.length() < 1) {
                return true;
            }
            return Integer.parseInt(String.valueOf(str.charAt(0))) >= 2;
        } catch (Exception unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isYunOS() {
        String str;
        String str2 = null;
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            str = (String) method.invoke(null, "ro.yunos.version");
            try {
                str2 = (String) method.invoke(null, "java.vm.name");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            str = null;
        }
        return (str2 != null && str2.toLowerCase().contains("lemur")) || (str != null && str.trim().length() > 0);
    }

    public static String DotToDescriptor(String str) {
        String replace = str.replace('.', '/');
        return (replace.length() <= 0 || replace.charAt(0) == '[') ? replace : "L" + replace + ";";
    }

    public static String DescriptorToDot(String str) {
        int length = str.length();
        if (length <= 1) {
            return str;
        }
        if (str.charAt(0) == 'L') {
            int i = length - 1;
            if (str.charAt(i) == ';') {
                return str.substring(1, i).replace('/', '.');
            }
        }
        return str.replace('/', '.');
    }

    public static String getMethodSignature(Method method) {
        StringBuilder sb = new StringBuilder("(");
        for (Class<?> cls : method.getParameterTypes()) {
            String typeDescriptor = getTypeDescriptor(cls);
            if (!TextUtils.isEmpty(typeDescriptor)) {
                sb.append(typeDescriptor);
            }
        }
        sb.append(")");
        sb.append(getTypeDescriptor(method.getReturnType()));
        return sb.toString();
    }

    public static String getConstructorSignature(Constructor constructor) {
        StringBuilder sb = new StringBuilder("(");
        for (Class<?> cls : constructor.getParameterTypes()) {
            String typeDescriptor = getTypeDescriptor(cls);
            if (!TextUtils.isEmpty(typeDescriptor)) {
                sb.append(typeDescriptor);
            }
        }
        sb.append(")");
        sb.append(getPrimitiveString(Void.TYPE));
        return sb.toString();
    }

    public static String getTypeDescriptor(Class<?> cls) {
        if (cls.isPrimitive()) {
            return getPrimitiveString(cls);
        }
        if (cls.isArray()) {
            return "[" + getTypeDescriptor(cls.getComponentType());
        }
        return DotToDescriptor(cls.getName());
    }

    private static String getPrimitiveString(Class<?> cls) {
        if (Boolean.TYPE.equals(cls)) {
            return "Z";
        }
        if (Byte.TYPE.equals(cls)) {
            return TextAttributes.INLINE_BLOCK_PLACEHOLDER;
        }
        if (Character.TYPE.equals(cls)) {
            return "C";
        }
        if (Short.TYPE.equals(cls)) {
            return ExifInterface.LATITUDE_SOUTH;
        }
        if (Integer.TYPE.equals(cls)) {
            return TextAttributes.INLINE_IMAGE_PLACEHOLDER;
        }
        if (Long.TYPE.equals(cls)) {
            return "J";
        }
        if (Float.TYPE.equals(cls)) {
            return "F";
        }
        if (Double.TYPE.equals(cls)) {
            return "D";
        }
        if (Void.TYPE.equals(cls)) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        return null;
    }

    public static Class getPeerPatchClass(String str) {
        return sAdditionalClassHolder.get(str + "_PeerPatchClass");
    }

    public static String getReplacePatchName(String str, String str2) {
        return "L" + str.replaceAll("\\.", "_") + "_" + str2.replaceAll("<", "_i_").replaceAll(">", "_i_");
    }
}
