package com.bytedance.reparo.core;

import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.reparo.core.log.TLog;
import com.bytedance.reparo.core.utils.ReflectUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PatchClassLayoutChangeHelper {
    public static Map<String, Object> mAddedFieldMap = new HashMap();

    public static void classForName(String str) {
        try {
            Class.forName(str);
        } catch (Throwable th) {
            TLog.m321e("error classForName " + str, th);
        }
    }

    public static synchronized Object getInstanceField(Object obj, String str, String str2) {
        Object obj2;
        synchronized (PatchClassLayoutChangeHelper.class) {
            try {
                String fieldKey = getFieldKey(obj, str);
                if (!mAddedFieldMap.containsKey(fieldKey)) {
                    mAddedFieldMap.put(fieldKey, getInitValue(str2));
                }
                obj2 = mAddedFieldMap.get(fieldKey);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return obj2;
    }

    public static synchronized void setInstanceField(Object obj, String str, Object obj2) {
        synchronized (PatchClassLayoutChangeHelper.class) {
            try {
                mAddedFieldMap.put(getFieldKey(obj, str), obj2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static String getFieldKey(Object obj, String str) {
        return obj.getClass().getName() + RomVersionParamHelper.SEPARATOR + obj.hashCode() + RomVersionParamHelper.SEPARATOR + str;
    }

    public static Object invokePrivateSuperMethod(Object obj, String str, String str2, ArrayList<String> arrayList, ArrayList<Object> arrayList2) throws Throwable {
        try {
            Class classByClassType = getClassByClassType(str);
            Class[] clsArr = new Class[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                clsArr[i] = getClassByClassType(arrayList.get(i));
            }
            Method findMethodWithPeer = ReflectUtils.findMethodWithPeer(classByClassType, str2, clsArr);
            findMethodWithPeer.setAccessible(true);
            if (findMethodWithPeer.getParameterTypes().length == arrayList2.size() + 1) {
                arrayList2.add(0, obj);
                return findMethodWithPeer.invoke(obj, arrayList2.toArray());
            }
            return WandTrick.callMethodDirect(classByClassType, findMethodWithPeer, obj, arrayList.toArray(), arrayList2.toArray(), PatchUtils.getTypeDescriptor(findMethodWithPeer.getReturnType()), findMethodWithPeer.getReturnType());
        } catch (InvocationTargetException e) {
            throw e.getCause();
        } catch (Exception e2) {
            TLog.m324w("error when cls: " + str + LibrarianImpl.Constants.DOT + str2 + "(" + arrayList, e2);
            return null;
        }
    }

    public static Object invokePrivateMethod(Object obj, String str, String str2, ArrayList<String> arrayList, ArrayList<Object> arrayList2) throws Throwable {
        try {
            Class classByClassType = getClassByClassType(str);
            Class<?>[] clsArr = new Class[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                clsArr[i] = getClassByClassType(arrayList.get(i));
            }
            if (str2.equals("<init>")) {
                WandTrick.callMethodDirect(classByClassType, classByClassType.getDeclaredConstructor(clsArr), obj, arrayList.toArray(), arrayList2.toArray(), null, null);
                return null;
            }
            Method findMethodWithPeer = ReflectUtils.findMethodWithPeer(classByClassType, str2, clsArr);
            findMethodWithPeer.setAccessible(true);
            if (findMethodWithPeer.getParameterTypes().length == arrayList2.size() + 1) {
                arrayList2.add(0, obj);
            }
            return findMethodWithPeer.invoke(obj, arrayList2.toArray());
        } catch (InvocationTargetException e) {
            throw e.getCause();
        } catch (Exception e2) {
            TLog.m324w("error when cls: " + str + LibrarianImpl.Constants.DOT + str2 + "(" + arrayList, e2);
            return null;
        }
    }

    public static Object newWithPrivateConstructor(String str, ArrayList<String> arrayList, ArrayList<Object> arrayList2) {
        try {
            Class classByClassType = getClassByClassType(str);
            Class<?>[] clsArr = new Class[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                clsArr[i] = getClassByClassType(arrayList.get(i));
            }
            Constructor declaredConstructor = classByClassType.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return WandTrick.createInstance(classByClassType, declaredConstructor, arrayList.toArray(), arrayList2.toArray());
        } catch (Throwable th) {
            TLog.m324w("newWithPrivateConstructor " + str, th);
            return null;
        }
    }

    public static Object getPrivateField(Object obj, String str, String str2) {
        try {
            Field findField = ReflectUtils.findField(getClassByClassType(str), str2);
            findField.setAccessible(true);
            return findField.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setPrivateField(Object obj, String str, String str2, ArrayList<Object> arrayList) {
        try {
            Field findField = ReflectUtils.findField(getClassByClassType(str), str2);
            findField.setAccessible(true);
            findField.set(obj, arrayList.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0072 A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:2:0x0000, B:12:0x001a, B:15:0x006f, B:16:0x0072, B:19:0x0093, B:22:0x00a4, B:24:0x00ac, B:26:0x00b4, B:27:0x00c7, B:30:0x0077, B:32:0x007a, B:34:0x007d, B:36:0x0080, B:38:0x0083, B:40:0x0086, B:42:0x0089, B:44:0x008c, B:46:0x001e, B:49:0x0028, B:52:0x0032, B:55:0x003c, B:58:0x0046, B:61:0x0050, B:64:0x005a, B:67:0x0064), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0077 A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:2:0x0000, B:12:0x001a, B:15:0x006f, B:16:0x0072, B:19:0x0093, B:22:0x00a4, B:24:0x00ac, B:26:0x00b4, B:27:0x00c7, B:30:0x0077, B:32:0x007a, B:34:0x007d, B:36:0x0080, B:38:0x0083, B:40:0x0086, B:42:0x0089, B:44:0x008c, B:46:0x001e, B:49:0x0028, B:52:0x0032, B:55:0x003c, B:58:0x0046, B:61:0x0050, B:64:0x005a, B:67:0x0064), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007a A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:2:0x0000, B:12:0x001a, B:15:0x006f, B:16:0x0072, B:19:0x0093, B:22:0x00a4, B:24:0x00ac, B:26:0x00b4, B:27:0x00c7, B:30:0x0077, B:32:0x007a, B:34:0x007d, B:36:0x0080, B:38:0x0083, B:40:0x0086, B:42:0x0089, B:44:0x008c, B:46:0x001e, B:49:0x0028, B:52:0x0032, B:55:0x003c, B:58:0x0046, B:61:0x0050, B:64:0x005a, B:67:0x0064), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007d A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:2:0x0000, B:12:0x001a, B:15:0x006f, B:16:0x0072, B:19:0x0093, B:22:0x00a4, B:24:0x00ac, B:26:0x00b4, B:27:0x00c7, B:30:0x0077, B:32:0x007a, B:34:0x007d, B:36:0x0080, B:38:0x0083, B:40:0x0086, B:42:0x0089, B:44:0x008c, B:46:0x001e, B:49:0x0028, B:52:0x0032, B:55:0x003c, B:58:0x0046, B:61:0x0050, B:64:0x005a, B:67:0x0064), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0080 A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:2:0x0000, B:12:0x001a, B:15:0x006f, B:16:0x0072, B:19:0x0093, B:22:0x00a4, B:24:0x00ac, B:26:0x00b4, B:27:0x00c7, B:30:0x0077, B:32:0x007a, B:34:0x007d, B:36:0x0080, B:38:0x0083, B:40:0x0086, B:42:0x0089, B:44:0x008c, B:46:0x001e, B:49:0x0028, B:52:0x0032, B:55:0x003c, B:58:0x0046, B:61:0x0050, B:64:0x005a, B:67:0x0064), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0083 A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:2:0x0000, B:12:0x001a, B:15:0x006f, B:16:0x0072, B:19:0x0093, B:22:0x00a4, B:24:0x00ac, B:26:0x00b4, B:27:0x00c7, B:30:0x0077, B:32:0x007a, B:34:0x007d, B:36:0x0080, B:38:0x0083, B:40:0x0086, B:42:0x0089, B:44:0x008c, B:46:0x001e, B:49:0x0028, B:52:0x0032, B:55:0x003c, B:58:0x0046, B:61:0x0050, B:64:0x005a, B:67:0x0064), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086 A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:2:0x0000, B:12:0x001a, B:15:0x006f, B:16:0x0072, B:19:0x0093, B:22:0x00a4, B:24:0x00ac, B:26:0x00b4, B:27:0x00c7, B:30:0x0077, B:32:0x007a, B:34:0x007d, B:36:0x0080, B:38:0x0083, B:40:0x0086, B:42:0x0089, B:44:0x008c, B:46:0x001e, B:49:0x0028, B:52:0x0032, B:55:0x003c, B:58:0x0046, B:61:0x0050, B:64:0x005a, B:67:0x0064), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0089 A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:2:0x0000, B:12:0x001a, B:15:0x006f, B:16:0x0072, B:19:0x0093, B:22:0x00a4, B:24:0x00ac, B:26:0x00b4, B:27:0x00c7, B:30:0x0077, B:32:0x007a, B:34:0x007d, B:36:0x0080, B:38:0x0083, B:40:0x0086, B:42:0x0089, B:44:0x008c, B:46:0x001e, B:49:0x0028, B:52:0x0032, B:55:0x003c, B:58:0x0046, B:61:0x0050, B:64:0x005a, B:67:0x0064), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c A[Catch: all -> 0x00d2, TryCatch #0 {all -> 0x00d2, blocks: (B:2:0x0000, B:12:0x001a, B:15:0x006f, B:16:0x0072, B:19:0x0093, B:22:0x00a4, B:24:0x00ac, B:26:0x00b4, B:27:0x00c7, B:30:0x0077, B:32:0x007a, B:34:0x007d, B:36:0x0080, B:38:0x0083, B:40:0x0086, B:42:0x0089, B:44:0x008c, B:46:0x001e, B:49:0x0028, B:52:0x0032, B:55:0x003c, B:58:0x0046, B:61:0x0050, B:64:0x005a, B:67:0x0064), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Class getClassByClassType(String str) throws ClassNotFoundException {
        char c;
        try {
            int hashCode = str.hashCode();
            if (hashCode == 70) {
                if (str.equals("F")) {
                    c = 5;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            } else if (hashCode == 83) {
                if (str.equals("S")) {
                    c = 2;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            } else if (hashCode == 90) {
                if (str.equals("Z")) {
                    c = 0;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            } else if (hashCode == 73) {
                if (str.equals("I")) {
                    c = 4;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            } else {
                if (hashCode != 74) {
                    switch (hashCode) {
                        case 66:
                            if (str.equals("B")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case 67:
                            if (str.equals("C")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case 68:
                            if (str.equals("D")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        case 0:
                            return Boolean.TYPE;
                        case 1:
                            return Byte.TYPE;
                        case 2:
                            return Short.TYPE;
                        case 3:
                            return Character.TYPE;
                        case 4:
                            return Integer.TYPE;
                        case 5:
                            return Float.TYPE;
                        case 6:
                            return Double.TYPE;
                        case 7:
                            return Long.TYPE;
                        default:
                            if ('[' == str.charAt(0)) {
                                return Array.newInstance((Class<?>) getClassByClassType(str.substring(1)), 0).getClass();
                            }
                            return Class.forName((str.startsWith("L") && str.endsWith(";")) ? str.substring(1, str.length() - 1).replace('/', '.') : str, false, PatchContainerClassLoader.class.getClassLoader());
                    }
                }
                if (str.equals("J")) {
                    c = 7;
                    switch (c) {
                    }
                }
                c = 65535;
                switch (c) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            System.err.println("getClassByClassType " + str);
            TLog.m321e("getClassByClassType " + str, th);
            return null;
        }
    }

    private static Object getInitValue(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 66:
                if (str.equals("B")) {
                    c = 0;
                    break;
                }
                break;
            case 67:
                if (str.equals("C")) {
                    c = 1;
                    break;
                }
                break;
            case 68:
                if (str.equals("D")) {
                    c = 2;
                    break;
                }
                break;
            case 70:
                if (str.equals("F")) {
                    c = 3;
                    break;
                }
                break;
            case 73:
                if (str.equals("I")) {
                    c = 4;
                    break;
                }
                break;
            case 74:
                if (str.equals("J")) {
                    c = 5;
                    break;
                }
                break;
            case 83:
                if (str.equals("S")) {
                    c = 6;
                    break;
                }
                break;
            case 90:
                if (str.equals("Z")) {
                    c = 7;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return (byte) 0;
            case 1:
                return (char) 0;
            case 2:
                return Double.valueOf(0.0d);
            case 3:
                return Float.valueOf(0.0f);
            case 4:
                return 0;
            case 5:
                return 0L;
            case 6:
                return (short) 0;
            case 7:
                return false;
            default:
                return null;
        }
    }

    public static Object newInstanceWithoutConstruct(String str) throws ClassNotFoundException {
        return WandTrick.allocObject(getClassByClassType(str));
    }
}
