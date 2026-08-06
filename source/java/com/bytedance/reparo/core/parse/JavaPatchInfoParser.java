package com.bytedance.reparo.core.parse;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.reparo.core.PatchConfigCell;
import com.bytedance.reparo.core.PatchUtils;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.JavaPatchParseException;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.log.TLog;
import com.bytedance.reparo.core.patch.DurationMetric;
import com.bytedance.reparo.core.utils.ReflectUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class JavaPatchInfoParser {
    private static final String TAG = "JavaPatchInfoParser";
    private List<String> mAddedClassNames;
    private final File mJavaPatchRootDir;
    private Map<Class, PatchConfigCell> mPatchClassInfoMap = new HashMap();
    private final List<String> mAddedClassDexPaths = new ArrayList();
    private final List<Object> mDeoptimizeMethodSet = new ArrayList();
    private boolean hasParsed = false;

    public JavaPatchInfoParser(File file) {
        this.mJavaPatchRootDir = file;
    }

    public void parse(DurationMetric durationMetric) throws JavaPatchParseException {
        durationMetric.start("parse_patch_io");
        if (FileUtils.isEmpty(this.mJavaPatchRootDir)) {
            throw new JavaPatchParseException("Failed to parse java patch, java patch root dir is empty", 106);
        }
        File file = new File(this.mJavaPatchRootDir, PatchFileParser.FILE_PATCH_CLASSES_METHODS);
        if (!FileUtils.isExist(file)) {
            throw new JavaPatchParseException("Failed to parse java patch, patch_classes_methods.txt not exist", 107);
        }
        try {
            Map<String, Map<String, Set<String>>> loadPatchConfig = loadPatchConfig(file);
            Map<String, Map<String, Set<String>>> loadPatchConfig2 = loadPatchConfig(getDeoptFile());
            this.mAddedClassNames = FileUtils.readAsArray(new File(this.mJavaPatchRootDir, PatchFileParser.FILE_ADDED_CLASSES));
            durationMetric.end("parse_patch_io");
            durationMetric.start("parse_patch_load");
            ConfigFileParseResult parsePatchConfig = parsePatchConfig(loadPatchConfig, true);
            this.mPatchClassInfoMap.putAll(parsePatchConfig.getPatchConfigCellMap());
            this.mAddedClassDexPaths.addAll(parsePatchConfig.getAddedClassDexPaths());
            this.mDeoptimizeMethodSet.addAll(parseDeoptimizeMethods(loadPatchConfig2));
            this.hasParsed = true;
            durationMetric.end("parse_patch_load");
        } catch (IOException e) {
            throw new JavaPatchParseException("loadPatchConfig failed", e, 111);
        }
    }

    private File getDeoptFile() throws JavaPatchParseException {
        new File(this.mJavaPatchRootDir, PatchFileParser.FILE_DEOPTIMIZE_METHODS_L);
        File file = new File(this.mJavaPatchRootDir, PatchFileParser.FILE_DEOPTIMIZE_METHODS_MN);
        File file2 = new File(this.mJavaPatchRootDir, PatchFileParser.FILE_DEOPTIMIZE_METHODS_OS);
        File file3 = new File(this.mJavaPatchRootDir, PatchFileParser.FILE_DEOPTIMIZE_METHODS);
        if (Build.VERSION.SDK_INT <= 25 && file.exists()) {
            System.out.println("use deoptimize_methods_mn.txt");
        } else if (Build.VERSION.SDK_INT > 30 || !file2.exists()) {
            file = file3;
        } else {
            System.out.println("use deoptimize_methods_os.txt");
            file = file2;
        }
        if (FileUtils.isExist(file)) {
            return file;
        }
        throw new JavaPatchParseException("Failed to parse java patch, " + file.getAbsolutePath() + " not exist", 108);
    }

    private List<Object> parseDeoptimizeMethods(Map<String, Map<String, Set<String>>> map) throws JavaPatchParseException {
        ArrayList arrayList = new ArrayList();
        for (PatchConfigCell patchConfigCell : parsePatchConfig(map, false).getPatchConfigCellMap().values()) {
            if (patchConfigCell != null) {
                List<Method> configMethods = patchConfigCell.getConfigMethods();
                if (configMethods != null && !configMethods.isEmpty()) {
                    arrayList.addAll(configMethods);
                }
                List<Constructor> configConstructors = patchConfigCell.getConfigConstructors();
                if (configConstructors != null && !configConstructors.isEmpty()) {
                    arrayList.addAll(configConstructors);
                }
            }
        }
        return arrayList;
    }

    private ConfigFileParseResult parsePatchConfig(Map<String, Map<String, Set<String>>> map, boolean z) throws JavaPatchParseException {
        Constructor clinitMethod;
        ConfigFileParseResult configFileParseResult = new ConfigFileParseResult();
        for (Map.Entry<String, Map<String, Set<String>>> entry : map.entrySet()) {
            String DescriptorToDot = PatchUtils.DescriptorToDot(entry.getKey());
            File file = new File(this.mJavaPatchRootDir, DescriptorToDot + ".dex");
            if (!file.exists() && z) {
                throw new JavaPatchParseException("parsePatchConfig patch dex file: " + file.getPath() + " does not exist", 109);
            }
            Map<String, Set<String>> value = entry.getValue();
            if (value != null && !value.isEmpty()) {
                try {
                    try {
                        Class<?> cls = Class.forName(DescriptorToDot, false, JavaPatchInfoParser.class.getClassLoader());
                        PatchConfigCell patchConfigCell = new PatchConfigCell(cls, file.getPath());
                        if (value.containsKey("<clinit>") && (clinitMethod = WandTrick.getInstance().getClinitMethod(cls)) != null) {
                            patchConfigCell.addConfigConstructor(clinitMethod);
                        }
                        try {
                            for (Method method : ReflectUtils.getDeclaredMethods(cls).getValueMayError()) {
                                String name = method.getName();
                                if (value.containsKey(name) && value.get(name).contains(PatchUtils.getMethodSignature(method))) {
                                    patchConfigCell.addConfigMethod(method);
                                }
                            }
                            for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
                                String name2 = constructor.getName();
                                if (value.containsKey(name2) && value.get(name2).contains(PatchUtils.getConstructorSignature(constructor))) {
                                    patchConfigCell.addConfigConstructor(constructor);
                                }
                            }
                            if (patchConfigCell.getConfigMethods() == null && patchConfigCell.getConfigConstructors() == null) {
                                TLog.m320e("parsePatchConfig ignore class:" + cls.getName());
                            } else {
                                configFileParseResult.putPatchConfigCell(cls, patchConfigCell);
                            }
                        } catch (NoClassDefFoundError e) {
                            TLog.m321e("skip patch class " + cls.getName(), e);
                        }
                    } catch (PatchException e2) {
                        throw e2;
                    } catch (Exception e3) {
                        throw new JavaPatchParseException("parsePatchConfig class: " + DescriptorToDot, e3, 110);
                    }
                } catch (ClassNotFoundException e4) {
                    e = e4;
                    TLog.m321e("skip patch class " + DescriptorToDot, e);
                } catch (NoClassDefFoundError e5) {
                    e = e5;
                    TLog.m321e("skip patch class " + DescriptorToDot, e);
                }
            } else {
                configFileParseResult.addAddedClassDexPath(file.getAbsolutePath());
            }
        }
        return configFileParseResult;
    }

    private Map<String, Map<String, Set<String>>> loadPatchConfig(File file) throws IOException {
        HashMap hashMap = new HashMap();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String str = null;
        for (String readLine = bufferedReader.readLine(); !TextUtils.isEmpty(readLine); readLine = bufferedReader.readLine()) {
            if (readLine.startsWith("#")) {
                String substring = readLine.substring(2);
                if (!TextUtils.isEmpty(substring) && !hashMap.containsKey(substring)) {
                    hashMap.put(substring, new HashMap());
                }
                str = substring;
            } else if (!TextUtils.isEmpty(str)) {
                String trim = readLine.trim();
                int indexOf = trim.indexOf(32);
                String substring2 = trim.substring(0, indexOf);
                String substring3 = trim.substring(indexOf + 1);
                if (!TextUtils.isEmpty(substring2) && !TextUtils.isEmpty(substring3)) {
                    if ("<init>".equals(substring2)) {
                        substring2 = PatchUtils.DescriptorToDot(str);
                    }
                    if (((Map) hashMap.get(str)).containsKey(substring2)) {
                        ((Set) ((Map) hashMap.get(str)).get(substring2)).add(substring3);
                    } else {
                        HashSet hashSet = new HashSet();
                        hashSet.add(substring3);
                        ((Map) hashMap.get(str)).put(substring2, hashSet);
                    }
                }
            }
        }
        bufferedReader.close();
        return hashMap;
    }

    public Map<Class, PatchConfigCell> getPatchClassInfoMap() {
        return this.mPatchClassInfoMap;
    }

    public List<String> getAddedClassDexPaths() {
        return this.mAddedClassDexPaths;
    }

    public List<String> getAddedClassNames() {
        return this.mAddedClassNames;
    }

    public List<Object> getDeoptimizeMethodSet() {
        return this.mDeoptimizeMethodSet;
    }

    public boolean hasParsed() {
        return this.hasParsed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class ConfigFileParseResult {
        private final Set<String> mAddedClassDexPaths;
        private final Map<Class<?>, PatchConfigCell> mPatchConfigCellMap;

        private ConfigFileParseResult() {
            this.mPatchConfigCellMap = new HashMap();
            this.mAddedClassDexPaths = new HashSet();
        }

        public void putPatchConfigCell(Class<?> cls, PatchConfigCell patchConfigCell) {
            this.mPatchConfigCellMap.put(cls, patchConfigCell);
        }

        public Map<Class<?>, PatchConfigCell> getPatchConfigCellMap() {
            return this.mPatchConfigCellMap;
        }

        public void addAddedClassDexPath(String str) {
            this.mAddedClassDexPaths.add(str);
        }

        public Set<String> getAddedClassDexPaths() {
            return this.mAddedClassDexPaths;
        }
    }
}
