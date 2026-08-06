package com.monitor.cloudmessage.internal.file.generator;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public class DirTreeFileGenerator {
    public static boolean writeDirTreeInfo(File file, File file2, List<String> list) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        BufferedWriter bufferedWriter2 = null;
        try {
            fileWriter = new FileWriter(file2);
            try {
                try {
                    bufferedWriter = new BufferedWriter(fileWriter);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
            fileWriter = null;
        } catch (Throwable th2) {
            th = th2;
            fileWriter = null;
        }
        try {
            getDeptJson(file, bufferedWriter, list);
            try {
                bufferedWriter.close();
                fileWriter.close();
                return true;
            } catch (IOException e3) {
                e3.printStackTrace();
                return true;
            }
        } catch (IOException e4) {
            e = e4;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return false;
                }
            }
            if (fileWriter == null) {
                return false;
            }
            fileWriter.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e6) {
                    e6.printStackTrace();
                    throw th;
                }
            }
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw th;
        }
    }

    protected static void getDeptJson(File file, BufferedWriter bufferedWriter, List<String> list) throws IOException {
        HashMap hashMap = new HashMap();
        bufferedWriter.write("{");
        bufferedWriter.newLine();
        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            hashMap.clear();
            dir2map(listFiles[i], hashMap, list);
            if (!hashMap.keySet().isEmpty()) {
                writeJson(hashMap, 1, bufferedWriter);
                if (i + 1 < listFiles.length) {
                    bufferedWriter.write(",");
                }
            }
        }
        bufferedWriter.write("}");
        bufferedWriter.flush();
    }

    private static void writeJson(HashMap<String, Object> hashMap, int i, BufferedWriter bufferedWriter) throws IOException {
        int size = hashMap.keySet().size();
        int i2 = 0;
        for (String str : hashMap.keySet()) {
            Object obj = hashMap.get(str);
            i2++;
            if (obj instanceof Long) {
                for (int i3 = 0; i3 < i + 1; i3++) {
                    bufferedWriter.write("\t");
                }
                bufferedWriter.write(String.format("\"%s\": %d", str.replaceAll(UpdateDialogNewBase.TYPE, ""), Long.valueOf(((Long) obj).longValue())));
                if (i2 < size) {
                    bufferedWriter.write(",");
                }
                bufferedWriter.newLine();
            } else {
                for (int i4 = 0; i4 < i; i4++) {
                    bufferedWriter.write("\t");
                }
                bufferedWriter.write(String.format("\"%s\": {", str.replaceAll(UpdateDialogNewBase.TYPE, "")));
                bufferedWriter.newLine();
                int i5 = i + 1;
                writeJson((HashMap) obj, i5, bufferedWriter);
                for (int i6 = 0; i6 < i5; i6++) {
                    bufferedWriter.write("\t");
                }
                bufferedWriter.write("}");
                if (i2 < size) {
                    bufferedWriter.write(",");
                }
                bufferedWriter.newLine();
            }
        }
    }

    private static boolean shouldSkip(String str) {
        return str.startsWith(LibrarianImpl.Constants.DOT);
    }

    private static void dir2map(File file, HashMap<String, Object> hashMap, List<String> list) {
        boolean z;
        String name;
        if (shouldSkip(file.getName())) {
            return;
        }
        if (!ListUtils.isEmpty(list)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (file.getAbsolutePath().startsWith(it.next())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < file.getName().length(); i++) {
                sb.append("*");
            }
            name = sb.toString();
        } else {
            name = file.getName();
        }
        if (file.isFile()) {
            hashMap.put(name, Long.valueOf(file.length()));
        }
        if (file.isDirectory()) {
            HashMap hashMap2 = new HashMap();
            hashMap.put(name, hashMap2);
            for (String str : file.list()) {
                dir2map(new File(file, str), hashMap2, list);
            }
        }
    }
}
