package com.bytedance.reparo.core;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.common.utils.IOUtils;
import com.bytedance.reparo.core.log.TLog;
import com.bytedance.reparo.core.patch.DurationMetric;
import com.bytedance.reparo.core.patch.Patch;
import com.bytedance.reparo.core.utils.AutoFailSyncHelper;
import com.bytedance.reparo.core.utils.ProcessUtils;
import com.bytedance.reparo.core.utils.ReflectUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MethodWand extends WandTrick {
    ArrayList<ClassLoader> mPatchClassLoaders = new ArrayList<>();

    private PatchContainerClassLoader createPatchClassLoader(Map<Class, PatchConfigCell> map) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (PatchConfigCell patchConfigCell : map.values()) {
            if (patchConfigCell != null) {
                String configClassDexPath = patchConfigCell.getConfigClassDexPath();
                if (!TextUtils.isEmpty(configClassDexPath)) {
                    arrayList.add(configClassDexPath);
                }
            }
        }
        ClassLoader classLoader = WandTrick.class.getClassLoader();
        final ArrayList arrayList2 = new ArrayList();
        int i = 0;
        File parentFile = new File((String) arrayList.get(0)).getParentFile();
        parentFile.listFiles(new FilenameFilter() { // from class: com.bytedance.reparo.core.MethodWand.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                if (!str.startsWith("patch") || !str.endsWith(".zip")) {
                    return false;
                }
                arrayList2.add(new File(file, str));
                return true;
            }
        });
        int size = arrayList.size() / 99;
        if (arrayList.size() % 99 != 0) {
            size++;
        }
        if (arrayList2.size() != size) {
            int i2 = 0;
            while (i2 < size) {
                int i3 = i2 * 99;
                int i4 = i2 + 1;
                try {
                    int min = Math.min(i4 * 99, arrayList.size());
                    File file = new File(parentFile, "tmp" + i2);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    int i5 = i;
                    while (i3 < min) {
                        FileUtils.copy(new File((String) arrayList.get(i3)), new File(file, getClassesNameForIndex(i5)));
                        i3++;
                        i5++;
                    }
                    File file2 = new File(parentFile, "patch" + i2 + ".zip");
                    arrayList2.add(file2);
                    ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                    for (File file3 : file.listFiles()) {
                        zipOutputStream.putNextEntry(new ZipEntry(file3.getName()));
                        FileInputStream fileInputStream = new FileInputStream(file3);
                        IOUtils.copy(fileInputStream, zipOutputStream);
                        IOUtils.close(fileInputStream);
                    }
                    IOUtils.close(zipOutputStream);
                    FileUtils.delete(file);
                    i2 = i4;
                    i = 0;
                } catch (Exception e) {
                    TLog.m320e("make patch.zip failed");
                    e.printStackTrace();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        FileUtils.delete((File) it.next());
                    }
                    return null;
                }
            }
        }
        StringBuilder sb = new StringBuilder(((File) arrayList2.get(0)).getAbsolutePath());
        for (int i6 = 1; i6 < arrayList2.size(); i6++) {
            sb.append(":");
            sb.append(((File) arrayList2.get(i6)).getAbsolutePath());
        }
        PatchContainerClassLoader patchContainerClassLoader = new PatchContainerClassLoader(sb.toString(), null, this.mApplicationContext.getApplicationInfo().nativeLibraryDir, classLoader);
        Object obj = ReflectUtils.findField(patchContainerClassLoader, "pathList").get(classLoader);
        IOException[] iOExceptionArr = (IOException[]) ReflectUtils.findField(obj, "dexElementsSuppressedExceptions").get(obj);
        if (iOExceptionArr != null && iOExceptionArr.length > 0) {
            TLog.m320e("create patchClassLoader failed");
            return null;
        }
        this.mPatchClassLoaders.add(patchContainerClassLoader);
        return patchContainerClassLoader;
    }

    @Override // com.bytedance.reparo.core.WandTrick
    public WandTrick.RetryTaskMayFailure applyPatch(Application application, boolean z, Map<Class, PatchConfigCell> map, List<String> list, List<String> list2, List<Object> list3, DurationMetric durationMetric, Patch patch) throws Exception {
        if (PatchUtils.isYunOS()) {
            TLog.m320e("device not supported");
            return WandTrick.RetryTaskMayFailure.EMPTY;
        }
        durationMetric.start("createPatchClassLoader");
        PatchContainerClassLoader createPatchClassLoader = createPatchClassLoader(map);
        durationMetric.end("createPatchClassLoader");
        if (createPatchClassLoader == null) {
            return WandTrick.RetryTaskMayFailure.EMPTY;
        }
        return artApplyReplacementInner(application, z, map, list, list2, list3, createPatchClassLoader, durationMetric, patch);
    }

    private String getClassesNameForIndex(int i) {
        return i == 0 ? "classes.dex" : "classes" + (i + 1) + ".dex";
    }

    private WandTrick.RetryTaskMayFailure artApplyReplacementInner(Application application, boolean z, Map<Class, PatchConfigCell> map, List<String> list, List<String> list2, List<Object> list3, PatchContainerClassLoader patchContainerClassLoader, DurationMetric durationMetric, Patch patch) throws Exception {
        Iterator<Class> it;
        HashMap hashMap;
        List<Constructor> list4;
        List<Method> list5;
        Method[] methodArr;
        Constructor[] constructorArr;
        Class<?> cls;
        Constructor<?> constructor;
        Method method;
        Iterator<Class> it2;
        Set<Class> keySet = map.keySet();
        DexCacheCleaner dexCacheCleaner = new DexCacheCleaner();
        HashMap hashMap2 = new HashMap();
        durationMetric.start("loadPatchClasses");
        Iterator<Class> it3 = keySet.iterator();
        while (it3.hasNext()) {
            Class next = it3.next();
            ClassModifier.changeClassToVerified(next, false);
            ClassModifier.changeFieldsToPublic(next);
            ClassModifier.changeConstructorsToPublic(next);
            ClassModifier.changeMethodProtectedToPublic(next);
            ClassModifier.changeClassSuperAndInterfacesToPublic(next);
            Class<?> findClassFromCurrent = patchContainerClassLoader.findClassFromCurrent(next.getName());
            if (findClassFromCurrent == null || next == null) {
                it2 = it3;
            } else {
                ClassModifier.changeClassToVerified(findClassFromCurrent, true);
                ClassModifier.changeFieldsToPublic(findClassFromCurrent);
                ClassModifier.changeConstructorsToPublic(findClassFromCurrent);
                ClassModifier.changeMethodProtectedToPublic(findClassFromCurrent);
                dexCacheCleaner.collectDexCache(findClassFromCurrent);
                hashMap2.put(next, findClassFromCurrent);
                ArrayList arrayList = new ArrayList(Arrays.asList(ReflectUtils.getDeclaredMethods(next).getValueIgnoreError()));
                ArrayList<Method> declaredMethods = getDeclaredMethods(findClassFromCurrent);
                if (arrayList.size() != declaredMethods.size() || ReflectUtils.getDeclaredFields(findClassFromCurrent).length != ReflectUtils.getDeclaredFields(next).length) {
                    TLog.m320e("structure changed in " + findClassFromCurrent + ", abort.");
                    throw new Exception("Structure changed in: " + findClassFromCurrent.getName());
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int i = 0;
                while (i < arrayList.size()) {
                    Method method2 = (Method) arrayList.get(i);
                    linkedHashMap.put(method2.getName() + PatchUtils.getMethodSignature(method2), method2);
                    i++;
                    it3 = it3;
                }
                it2 = it3;
                for (int i2 = 0; i2 < declaredMethods.size(); i2++) {
                    Method method3 = declaredMethods.get(i2);
                    if (!linkedHashMap.containsKey(method3.getName() + PatchUtils.getMethodSignature(method3))) {
                        throw new Exception("Structure changed in: " + findClassFromCurrent.getName());
                    }
                }
            }
            it3 = it2;
        }
        dexCacheCleaner.clearDexCaches();
        String[] strArr = new String[hashMap2.size()];
        Iterator it4 = hashMap2.values().iterator();
        int i3 = 0;
        while (it4.hasNext()) {
            strArr[i3] = ((Class) it4.next()).getName();
            i3++;
        }
        WandTrick.removeClassesFromClassLinker(strArr, patchContainerClassLoader);
        durationMetric.end("loadPatchClasses");
        durationMetric.start("preparePatchMethods");
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator<Class> it5 = keySet.iterator();
        while (it5.hasNext()) {
            Class next2 = it5.next();
            Class<?> cls2 = (Class) hashMap2.get(next2);
            if (cls2 == null || next2 == null) {
                it = it5;
                hashMap = hashMap2;
            } else {
                ClassModifier.changeClassClassLoader(cls2, next2.getClassLoader());
                PatchConfigCell patchConfigCell = map.get(next2);
                if (patchConfigCell != null) {
                    list5 = patchConfigCell.getConfigMethods();
                    list4 = patchConfigCell.getConfigConstructors();
                } else {
                    list4 = null;
                    list5 = null;
                }
                if (list5 == null || list5.isEmpty()) {
                    methodArr = null;
                } else {
                    methodArr = new Method[list5.size()];
                    list5.toArray(methodArr);
                }
                if (list4 == null || list4.isEmpty()) {
                    constructorArr = null;
                } else {
                    constructorArr = new Constructor[list4.size()];
                    list4.toArray(constructorArr);
                }
                if (methodArr == null && constructorArr == null) {
                    throw new Exception("Unspecified target in class: " + next2.getSimpleName());
                }
                arrayList4.add(cls2);
                if (methodArr != null) {
                    int i4 = 0;
                    while (i4 < methodArr.length) {
                        Method method4 = methodArr[i4];
                        Method[] valueIgnoreError = ReflectUtils.getDeclaredMethods(cls2).getValueIgnoreError();
                        Iterator<Class> it6 = it5;
                        int length = valueIgnoreError.length;
                        HashMap hashMap3 = hashMap2;
                        int i5 = 0;
                        while (true) {
                            if (i5 >= length) {
                                method = null;
                                break;
                            }
                            Method method5 = valueIgnoreError[i5];
                            int i6 = length;
                            if (method5.getDeclaringClass() == cls2 && method5.getName().equals(method4.getName()) && PatchUtils.getMethodSignature(method5).equals(PatchUtils.getMethodSignature(method4))) {
                                method = method5;
                                break;
                            }
                            i5++;
                            length = i6;
                        }
                        if (method == null) {
                            throw new NoSuchMethodException(method4.getName() + " " + Arrays.toString(method4.getParameterTypes()));
                        }
                        arrayList2.add(method4);
                        arrayList3.add(method);
                        i4++;
                        it5 = it6;
                        hashMap2 = hashMap3;
                    }
                }
                it = it5;
                hashMap = hashMap2;
                if (constructorArr != null) {
                    int i7 = 0;
                    while (i7 < constructorArr.length) {
                        Constructor constructor2 = constructorArr[i7];
                        Constructor<?>[] declaredConstructors = cls2.getDeclaredConstructors();
                        int length2 = declaredConstructors.length;
                        int i8 = 0;
                        while (true) {
                            if (i8 >= length2) {
                                cls = cls2;
                                constructor = null;
                                break;
                            }
                            constructor = declaredConstructors[i8];
                            cls = cls2;
                            if (PatchUtils.getConstructorSignature(constructor2).equals(PatchUtils.getConstructorSignature(constructor))) {
                                break;
                            }
                            i8++;
                            cls2 = cls;
                        }
                        if (constructor == null) {
                            throw new NoSuchMethodException(constructor2.getName() + " " + Arrays.toString(constructor2.getParameterTypes()));
                        }
                        arrayList2.add(constructor2);
                        PatchConstructorHelper.collectConstructorClass(constructor2);
                        arrayList3.add(constructor);
                        i7++;
                        cls2 = cls;
                    }
                } else {
                    continue;
                }
            }
            it5 = it;
            hashMap2 = hashMap;
        }
        durationMetric.end("preparePatchMethods");
        return new WandTrick.RetryTaskMayFailure(patch, list3, arrayList2, arrayList3, application, z, map, list, list2, durationMetric, arrayList4) { // from class: com.bytedance.reparo.core.MethodWand.2
            AutoFailSyncHelper autoFailSyncHelper;
            final /* synthetic */ List val$addedClassDexPaths;
            final /* synthetic */ List val$addedClassNames;
            final /* synthetic */ boolean val$allowDebuggable;
            final /* synthetic */ Application val$application;
            final /* synthetic */ DurationMetric val$durationMetric;
            final /* synthetic */ ArrayList val$orderedOrigMethodsAndConstructors;
            final /* synthetic */ ArrayList val$orderedPatchedClasses;
            final /* synthetic */ ArrayList val$orderedPatchedMethodsAndConstructors;
            final /* synthetic */ List val$oriCallgraphMethods;
            final /* synthetic */ Patch val$patch;
            final /* synthetic */ Map val$patchClassInfoMap;

            @Override // com.bytedance.reparo.core.WandTrick.RetryTaskMayFailure
            public boolean success(int i9) {
                return i9 == 0;
            }

            {
                this.val$patch = patch;
                this.val$oriCallgraphMethods = list3;
                this.val$orderedOrigMethodsAndConstructors = arrayList2;
                this.val$orderedPatchedMethodsAndConstructors = arrayList3;
                this.val$application = application;
                this.val$allowDebuggable = z;
                this.val$patchClassInfoMap = map;
                this.val$addedClassDexPaths = list;
                this.val$addedClassNames = list2;
                this.val$durationMetric = durationMetric;
                this.val$orderedPatchedClasses = arrayList4;
                this.autoFailSyncHelper = new AutoFailSyncHelper(patch, ProcessUtils.getCurrentProcessName(MethodWand.this.mApplicationContext));
            }

            @Override // com.bytedance.reparo.core.WandTrick.RetryTaskMayFailure
            public int run() throws Exception {
                ArrayList arrayList5 = new ArrayList();
                arrayList5.addAll(this.val$oriCallgraphMethods);
                arrayList5.addAll(this.val$orderedOrigMethodsAndConstructors);
                arrayList5.addAll(this.val$orderedPatchedMethodsAndConstructors);
                int deoptimizeCallGraph = MethodWand.this.deoptimizeCallGraph(this.val$application, this.val$allowDebuggable, this.val$patchClassInfoMap, this.val$addedClassDexPaths, this.val$addedClassNames, arrayList5, this.val$durationMetric);
                if (deoptimizeCallGraph != 0) {
                    this.autoFailSyncHelper.fail();
                    return deoptimizeCallGraph;
                }
                this.val$durationMetric.start("replaceSuper");
                PatchInvokeSuperHelper.setPatchedClasses(this.val$orderedPatchedClasses);
                Iterator it7 = this.val$orderedPatchedClasses.iterator();
                while (it7.hasNext()) {
                    PatchInvokeSuperHelper.replaceSuperClassForReflectionInvokeNoLock((Class) it7.next(), null);
                }
                this.val$durationMetric.end("replaceSuper");
                this.val$durationMetric.start("replaceMethodNative");
                String[] strArr2 = new String[10];
                int replaceMethodNative = MethodWand.this.replaceMethodNative(this.val$orderedOrigMethodsAndConstructors.toArray(), this.val$orderedPatchedMethodsAndConstructors.toArray(), MethodWand.this.getModifier(this.val$orderedPatchedMethodsAndConstructors.toArray()), strArr2, this.val$durationMetric.getNativeTags(), this.val$durationMetric.getNativeTimes());
                PatchLogger.logForCollideMethod("replace", strArr2);
                this.val$durationMetric.end("replaceMethodNative");
                if (replaceMethodNative == -9) {
                    this.autoFailSyncHelper.fail();
                    return -9;
                }
                if (replaceMethodNative != 0) {
                    throw new Exception("Failure in replacement, ret:." + replaceMethodNative);
                }
                this.autoFailSyncHelper.success();
                return 0;
            }
        };
    }
}
