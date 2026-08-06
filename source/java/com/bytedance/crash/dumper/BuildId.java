package com.bytedance.crash.dumper;

import android.text.TextUtils;
import com.bytedance.crash.entity.CrashBody;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.util.FileSystemUtils;
import com.bytedance.crash.util.JSONUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BuildId {
    public static void putCrashBuildIdToJson(JSONObject jSONObject, File file, boolean z) {
        String GetBuildID;
        HashMap hashMap = new HashMap();
        ArrayList<String> arrayList = new ArrayList();
        if (z) {
            loadBuildIdFromTombstone(hashMap, new File(file, "tombstone.txt"));
            new NativeStackFile(new File(file, "nstack.txt")).loadSoList(arrayList);
        }
        new RoutinesFile(new File(file, "rountines.txt")).loadSoList(arrayList);
        for (String str : arrayList) {
            if (!isSystemLibrary(str) && !hashMap.containsKey(str) && (GetBuildID = NativeBridge.GetBuildID(str)) != null) {
                hashMap.put(str, GetBuildID);
            }
        }
        putToJson(jSONObject, hashMap);
    }

    public static void putAsanBuildIdToJson(JSONObject jSONObject, File file) {
        String GetBuildID;
        HashMap hashMap = new HashMap();
        ArrayList<String> arrayList = new ArrayList();
        new AsanFile(file).loadSoList(arrayList);
        for (String str : arrayList) {
            if (!isSystemLibrary(str) && !hashMap.containsKey(str) && (GetBuildID = NativeBridge.GetBuildID(str)) != null) {
                hashMap.put(str, GetBuildID);
            }
        }
        putToJson(jSONObject, hashMap);
    }

    public static void putAnrBuildIDToJson(JSONObject jSONObject, File file) {
        String GetBuildID;
        HashMap hashMap = new HashMap();
        ArrayList<String> arrayList = new ArrayList();
        new AnrTraceFile(file).loadSoList(arrayList);
        for (String str : arrayList) {
            if (!isSystemLibrary(str) && !hashMap.containsKey(str) && (GetBuildID = NativeBridge.GetBuildID(str)) != null) {
                hashMap.put(str, GetBuildID);
            }
        }
        putToJson(jSONObject, hashMap);
    }

    private static void putToJson(JSONObject jSONObject, Map<String, String> map) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                String pathToName = pathToName(entry.getKey());
                if (!TextUtils.isEmpty(pathToName)) {
                    JSONObject jSONObject2 = new JSONObject();
                    JSONUtils.put(jSONObject2, CrashBody.LIB_NAME, pathToName);
                    JSONUtils.put(jSONObject2, CrashBody.LIB_UUID, buildIDToUUID(entry.getValue()));
                    jSONArray.put(jSONObject2);
                }
            } catch (Throwable unused) {
            }
        }
        JSONUtils.put(jSONObject, CrashBody.CRASH_LIB_UUID, jSONArray);
    }

    private static String pathToName(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(47)) == -1) {
            return null;
        }
        String substring = str.substring(lastIndexOf + 1);
        int indexOf = substring.indexOf(".apk!");
        return indexOf != -1 ? substring.substring(indexOf + 5) : substring;
    }

    private static String buildIDToUUID(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            if (str.length() < 16) {
                sb.append(str);
            } else {
                sb.append(str.charAt(6));
                sb.append(str.charAt(7));
                sb.append(str.charAt(4));
                sb.append(str.charAt(5));
                sb.append(str.charAt(2));
                sb.append(str.charAt(3));
                sb.append(str.charAt(0));
                sb.append(str.charAt(1));
                sb.append(str.charAt(10));
                sb.append(str.charAt(11));
                sb.append(str.charAt(8));
                sb.append(str.charAt(9));
                sb.append(str.charAt(14));
                sb.append(str.charAt(15));
                sb.append(str.charAt(12));
                sb.append(str.charAt(13));
                if (str.length() >= 32) {
                    sb.append((CharSequence) str, 16, 32);
                    sb.append('0');
                }
            }
        } catch (Throwable unused) {
        }
        return sb.toString().toUpperCase();
    }

    private static boolean isSystemLibrary(String str) {
        return str.startsWith("/system/lib") || str.startsWith("/vendor/lib") || str.startsWith("/apex/");
    }

    private static void loadBuildIdFromTombstone(Map<String, String> map, File file) {
        BufferedReader bufferedReader;
        if (file.exists()) {
            Pattern compile = Pattern.compile("^ {4}(/(?:[^/]+/)+[^.]+\\.so) \\(BuildId: ([0-9a-f]+)\\).*");
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        if (readLine.startsWith("build id:")) {
                            while (true) {
                                String readLine2 = bufferedReader.readLine();
                                if (readLine2 != null && readLine2.startsWith("    /")) {
                                    Matcher matcher = compile.matcher(readLine2);
                                    if (matcher.find() && matcher.groupCount() == 2) {
                                        String group = matcher.group(1);
                                        String group2 = matcher.group(2);
                                        if (group != null && !isSystemLibrary(group) && !map.containsKey(group)) {
                                            map.put(group, group2);
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Throwable unused) {
                        bufferedReader2 = bufferedReader;
                        bufferedReader = bufferedReader2;
                        FileSystemUtils.close(bufferedReader);
                    }
                }
            } catch (Throwable unused2) {
            }
            FileSystemUtils.close(bufferedReader);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static abstract class SoListContainer {
        private final File mFile;
        private final Pattern mPattern = getPattern();

        abstract Pattern getPattern();

        abstract boolean isBackTraceLine(String str);

        SoListContainer(File file) {
            this.mFile = file;
        }

        void loadSoList(List<String> list) {
            BufferedReader bufferedReader;
            if (this.mFile.exists()) {
                BufferedReader bufferedReader2 = null;
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(this.mFile)));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            if (isBackTraceLine(readLine)) {
                                Matcher matcher = this.mPattern.matcher(readLine);
                                if (matcher.find() && matcher.groupCount() == 1) {
                                    String group = matcher.group(1);
                                    if (!list.contains(group)) {
                                        list.add(group);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                            bufferedReader2 = bufferedReader;
                            bufferedReader = bufferedReader2;
                            FileSystemUtils.close(bufferedReader);
                        }
                    }
                } catch (Throwable unused2) {
                }
                FileSystemUtils.close(bufferedReader);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    static class TombstoneFile extends SoListContainer {
        TombstoneFile(File file) {
            super(file);
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        Pattern getPattern() {
            return Pattern.compile("^ {4}#\\d{1,3} pc [0-9a-f]{8,16} {2}(/(?:[^/]+/)+.*\\.so).*");
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        boolean isBackTraceLine(String str) {
            return str.startsWith("    ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class NativeStackFile extends SoListContainer {
        NativeStackFile(File file) {
            super(file);
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        Pattern getPattern() {
            return Pattern.compile("^#\\d{1,3} pc [0-9a-f]{8,16} {2}(/(?:[^/]+/)+.*\\.so).*");
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        boolean isBackTraceLine(String str) {
            return str.startsWith("#");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class RoutinesFile extends SoListContainer {
        RoutinesFile(File file) {
            super(file);
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        Pattern getPattern() {
            return Pattern.compile("^0x[0-9a-f]{1,16}:(/(?:[^/]+/)+[^.]+\\.so):.*");
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        boolean isBackTraceLine(String str) {
            return str.startsWith("0x");
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    static class AsanFile extends SoListContainer {
        AsanFile(File file) {
            super(file);
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        Pattern getPattern() {
            return Pattern.compile("^ {4}#\\d{1,3} 0x[0-9a-f]{1,16} {2}\\((/(?:[^/]+/)+.*\\.so)\\+0x[0-9a-f]{1,16}\\)$");
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        boolean isBackTraceLine(String str) {
            return str.startsWith("    #");
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    static class AnrTraceFile extends SoListContainer {
        AnrTraceFile(File file) {
            super(file);
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        Pattern getPattern() {
            return Pattern.compile("^  native: #\\d{1,3} pc [0-9a-f]{8,16} {2}(/(?:[^/]+/)+.*\\.so).*");
        }

        @Override // com.bytedance.crash.dumper.BuildId.SoListContainer
        boolean isBackTraceLine(String str) {
            return str.startsWith("  native: #");
        }
    }
}
