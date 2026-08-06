package com.bytedance.reparo.core;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.patch.DurationMetric;
import com.bytedance.reparo.core.patch.Patch;
import com.bytedance.reparo.core.utils.AutoFailSyncHelper;
import com.bytedance.reparo.core.utils.ProcessUtils;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClassWand extends WandTrick {
    @Override // com.bytedance.reparo.core.WandTrick
    public WandTrick.RetryTaskMayFailure applyPatch(Application application, boolean z, Map<Class, PatchConfigCell> map, List<String> list, List<String> list2, List<Object> list3, DurationMetric durationMetric, Patch patch) throws Exception {
        durationMetric.start("read_patch_dex");
        byte[][] bArr = new byte[map.size()];
        int size = map.size();
        Class[] clsArr = new Class[size];
        int i = 0;
        for (Class cls : map.keySet()) {
            FileInputStream fileInputStream = null;
            try {
                PatchConfigCell patchConfigCell = map.get(cls);
                String configClassDexPath = patchConfigCell != null ? patchConfigCell.getConfigClassDexPath() : null;
                if (!TextUtils.isEmpty(configClassDexPath)) {
                    FileInputStream fileInputStream2 = new FileInputStream(configClassDexPath);
                    try {
                        byte[] bArr2 = new byte[fileInputStream2.available()];
                        fileInputStream2.read(bArr2);
                        bArr[i] = bArr2;
                        clsArr[i] = cls;
                        i++;
                        fileInputStream = fileInputStream2;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        try {
                            throw new Exception("Failed to read dex: " + cls.getName(), th);
                        } finally {
                            PatchUtils.closeSafely(fileInputStream);
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            Class cls2 = clsArr[i2];
            Constructor clinitMethod = getClinitMethod(cls2);
            if (clinitMethod != null) {
                arrayList.add(clinitMethod);
            }
            arrayList.addAll(getDeclaredMethods(cls2));
            arrayList.addAll(getDeclaredConstructors(cls2));
        }
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT < 28) {
            Field declaredField = Class.forName("java.lang.reflect.Executable").getDeclaredField("accessFlags");
            declaredField.setAccessible(true);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                int i3 = declaredField.getInt(next);
                if (Build.VERSION.SDK_INT == 26) {
                    if ((i3 & 1024) != 0 || (i3 & 8388608) != 0) {
                        arrayList2.add(next);
                    }
                } else if ((i3 & 1024) != 0 || (i3 & 16777216) != 0) {
                    arrayList2.add(next);
                }
            }
        }
        durationMetric.end("read_patch_dex");
        return new WandTrick.RetryTaskMayFailure(patch, list3, application, z, map, list, list2, durationMetric, clsArr, bArr, arrayList, arrayList2) { // from class: com.bytedance.reparo.core.ClassWand.1
            AutoFailSyncHelper autoFailSyncHelper;
            final /* synthetic */ List val$addedClassDexPaths;
            final /* synthetic */ List val$addedClassNames;
            final /* synthetic */ boolean val$allowDebuggable;
            final /* synthetic */ Application val$application;
            final /* synthetic */ DurationMetric val$durationMetric;
            final /* synthetic */ ArrayList val$notInvokableMethods;
            final /* synthetic */ List val$oriCallgraphMethods;
            final /* synthetic */ Patch val$patch;
            final /* synthetic */ Map val$patchClassInfoMap;
            final /* synthetic */ Class[] val$patchClasses;
            final /* synthetic */ byte[][] val$patchDexByteArray;
            final /* synthetic */ ArrayList val$redefinedMethodsAndConstructors;

            @Override // com.bytedance.reparo.core.WandTrick.RetryTaskMayFailure
            public boolean success(int i4) {
                return i4 == 0;
            }

            {
                this.val$patch = patch;
                this.val$oriCallgraphMethods = list3;
                this.val$application = application;
                this.val$allowDebuggable = z;
                this.val$patchClassInfoMap = map;
                this.val$addedClassDexPaths = list;
                this.val$addedClassNames = list2;
                this.val$durationMetric = durationMetric;
                this.val$patchClasses = clsArr;
                this.val$patchDexByteArray = bArr;
                this.val$redefinedMethodsAndConstructors = arrayList;
                this.val$notInvokableMethods = arrayList2;
                this.autoFailSyncHelper = new AutoFailSyncHelper(patch, ProcessUtils.getCurrentProcessName(ClassWand.this.mApplicationContext));
            }

            @Override // com.bytedance.reparo.core.WandTrick.RetryTaskMayFailure
            public int run() throws Exception {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.val$oriCallgraphMethods);
                int deoptimizeCallGraph = ClassWand.this.deoptimizeCallGraph(this.val$application, this.val$allowDebuggable, this.val$patchClassInfoMap, this.val$addedClassDexPaths, this.val$addedClassNames, arrayList3, this.val$durationMetric);
                if (deoptimizeCallGraph != 0) {
                    this.autoFailSyncHelper.fail();
                    return deoptimizeCallGraph;
                }
                this.val$durationMetric.start("redefineClassesNative");
                String[] strArr = new String[10];
                int redefineClassesNative = ClassWand.this.redefineClassesNative(this.val$patchClasses, this.val$patchDexByteArray, this.val$redefinedMethodsAndConstructors.toArray(), ClassWand.this.getModifier(this.val$redefinedMethodsAndConstructors.toArray()), this.val$notInvokableMethods.toArray(), strArr, this.val$durationMetric.getNativeTags(), this.val$durationMetric.getNativeTimes());
                this.val$durationMetric.end("redefineClassesNative");
                PatchLogger.logForCollideMethod("redefine", strArr);
                if (redefineClassesNative == -9) {
                    this.autoFailSyncHelper.fail();
                    return redefineClassesNative;
                }
                if (redefineClassesNative == 0) {
                    this.autoFailSyncHelper.success();
                    return 0;
                }
                throw new Exception("Failure in redefinition, ret: " + (redefineClassesNative > 0 ? "+" + redefineClassesNative : Integer.valueOf(redefineClassesNative)));
            }
        };
    }
}
