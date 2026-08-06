package com.bytedance.crash.util;

import android.text.TextUtils;
import com.caverock.androidsvg.SVGParser;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FileUtils {
    public static void writeFile(File file, String str, boolean z) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z);
            try {
                fileOutputStream2.write(str.getBytes());
                fileOutputStream2.flush();
                FileSystemUtils.close(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                FileSystemUtils.close(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void clearFile(File file) throws IOException {
        FileOutputStream fileOutputStream;
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file, false);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileOutputStream.write("".getBytes());
            fileOutputStream.flush();
            FileSystemUtils.close(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            FileSystemUtils.close(fileOutputStream2);
            throw th;
        }
    }

    public static void writeFile(File file, JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, z));
            try {
                JSONWriter.writeTo(jSONObject, bufferedWriter2);
                FileSystemUtils.close(bufferedWriter2);
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
                FileSystemUtils.close(bufferedWriter);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void writeFile(File file, JSONArray jSONArray, boolean z) {
        if (jSONArray == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = null;
        try {
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, z));
            try {
                JSONWriter.writeTo(jSONArray, bufferedWriter2);
                FileSystemUtils.close(bufferedWriter2);
            } catch (Throwable unused) {
                bufferedWriter = bufferedWriter2;
                FileSystemUtils.close(bufferedWriter);
            }
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void safeWriteFile(File file, JSONArray jSONArray, boolean z) {
        BufferedWriter bufferedWriter;
        if (file == null) {
            return;
        }
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter2 = null;
        try {
            if (jSONArray == null) {
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                try {
                    FileOutputStream fileOutputStream2 = fileOutputStream;
                    fileOutputStream.write("".getBytes());
                    FileOutputStream fileOutputStream3 = fileOutputStream;
                    fileOutputStream.flush();
                    bufferedWriter = fileOutputStream;
                } catch (Throwable unused) {
                    bufferedWriter2 = fileOutputStream;
                    FileSystemUtils.close(bufferedWriter2);
                    return;
                }
            } else {
                BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(file, z));
                try {
                    BufferedWriter bufferedWriter4 = bufferedWriter3;
                    JSONWriter.writeTo(jSONArray, bufferedWriter3);
                    bufferedWriter = bufferedWriter3;
                } catch (Throwable unused2) {
                    bufferedWriter2 = bufferedWriter3;
                    FileSystemUtils.close(bufferedWriter2);
                    return;
                }
            }
            FileSystemUtils.close(bufferedWriter);
        } catch (Throwable unused3) {
        }
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return deleteFile(new File(str));
    }

    public static boolean deleteFile(File file) {
        boolean deleteFile;
        boolean z = true;
        if (!file.exists()) {
            return true;
        }
        if (!file.canWrite()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (!file.isDirectory()) {
            return true;
        }
        File[] listFiles = file.listFiles();
        for (int i = 0; listFiles != null && i < listFiles.length; i++) {
            if (listFiles[i].isFile()) {
                if (listFiles[i].canWrite()) {
                    deleteFile = listFiles[i].delete();
                } else {
                    z = false;
                }
            } else {
                deleteFile = deleteFile(listFiles[i]);
            }
            z &= deleteFile;
        }
        return z & file.delete();
    }

    public static String readFile(String str, String str2) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return readFile(new File(str), str2);
    }

    public static String readFile(File file, String str) throws IOException {
        return readFile(file, str, -1L);
    }

    public static String readFile(File file, String str, long j) throws IOException {
        if (file == null || !file.exists()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            if (j > 0) {
                try {
                    bufferedReader2.skip(j);
                    bufferedReader2.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    FileSystemUtils.close(bufferedReader);
                    throw th;
                }
            }
            while (true) {
                String readLine = bufferedReader2.readLine();
                if (readLine != null) {
                    if (sb.length() != 0 && str != null) {
                        sb.append(str);
                    }
                    sb.append(readLine);
                } else {
                    FileSystemUtils.close(bufferedReader2);
                    return sb.toString();
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONArray readFileArray(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return readFileArray(new File(str), -1L);
    }

    public static JSONArray readFileArray(File file) throws IOException {
        return readFileArray(file, -1L);
    }

    public static JSONArray readFileArray(File file, long j) throws IOException {
        JSONArray jSONArray = new JSONArray();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            if (j > 0) {
                try {
                    bufferedReader2.skip(j);
                    bufferedReader2.readLine();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    FileSystemUtils.close(bufferedReader);
                    throw th;
                }
            }
            while (true) {
                String readLine = bufferedReader2.readLine();
                if (readLine != null) {
                    jSONArray.put(readLine);
                } else {
                    FileSystemUtils.close(bufferedReader2);
                    return jSONArray;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isEmpty(File file) {
        String[] list = file.list();
        return list == null || list.length == 0;
    }

    public static boolean isEmpty(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() == 0;
    }

    public static String readFile(String str) throws IOException {
        return readFile(str, UpdateDialogNewBase.TYPE);
    }

    public static String tryReadFile(File file) {
        try {
            return readFile(file);
        } catch (IOException unused) {
            return null;
        }
    }

    public static String safeReadFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return readFile(new File(str), UpdateDialogNewBase.TYPE);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String readFile(File file) throws IOException {
        return readFile(file, UpdateDialogNewBase.TYPE);
    }

    public static String readFile(File file, long j) throws IOException {
        return readFile(file, UpdateDialogNewBase.TYPE, j);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0041: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:20:0x0041 */
    public static Map<String, String> readPropertiesFile(File file) {
        FileInputStream fileInputStream;
        Closeable closeable;
        Closeable closeable2 = null;
        try {
            try {
                Properties properties = new Properties();
                fileInputStream = new FileInputStream(file);
                try {
                    properties.load(fileInputStream);
                    Set<String> stringPropertyNames = properties.stringPropertyNames();
                    HashMap hashMap = new HashMap();
                    for (String str : stringPropertyNames) {
                        hashMap.put(str, properties.getProperty(str));
                    }
                    FileSystemUtils.close(fileInputStream);
                    return hashMap;
                } catch (IOException e) {
                    e = e;
                    NpthLog.w(e);
                    FileSystemUtils.close(fileInputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                closeable2 = closeable;
                FileSystemUtils.close(closeable2);
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            FileSystemUtils.close(closeable2);
            throw th;
        }
    }

    public static void writePropertiesFile(File file, Map<String, String> map) {
        Properties properties;
        FileOutputStream fileOutputStream;
        if (map == null || map.isEmpty()) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                properties = new Properties();
                fileOutputStream = new FileOutputStream(file);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                properties.setProperty(entry.getKey(), entry.getValue());
            }
            properties.store(fileOutputStream, SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO);
            FileSystemUtils.close(fileOutputStream);
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            NpthLog.w(e);
            FileSystemUtils.close(fileOutputStream2);
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            FileSystemUtils.close(fileOutputStream2);
            throw th;
        }
    }

    public static boolean isEmpty(File[] fileArr) {
        return fileArr == null || fileArr.length == 0;
    }

    public static void copy(File file, File file2) {
        copy(file, file2, Integer.MAX_VALUE);
    }

    public static void copyDir(File file, File file2) {
        if (file.exists()) {
            if (file.isFile()) {
                if (file2.exists()) {
                    if (file2.isDirectory()) {
                        return;
                    } else {
                        file2.delete();
                    }
                }
                copy(file, file2, Integer.MAX_VALUE);
                return;
            }
            if (file2.exists()) {
                if (file2.isFile()) {
                    file2.delete();
                } else if (!file2.getName().equals(file.getName())) {
                    return;
                }
            } else {
                file2.mkdirs();
            }
            for (String str : file.list()) {
                copyDir(new File(file, str), new File(file2, str));
            }
        }
    }

    public static void copy(File file, File file2, int i) {
        copy(file, file2, i, false);
    }

    public static void copyAppend(File file, File file2) {
        copy(file, file2, Integer.MAX_VALUE, true);
    }

    public static void copy(File file, File file2, int i, boolean z) {
        FileOutputStream fileOutputStream;
        if (file == null || file2 == null || !file.exists()) {
            return;
        }
        if (!file2.exists() || z) {
            FileInputStream fileInputStream = null;
            try {
                file2.getParentFile().mkdirs();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2, z);
                    try {
                        byte[] bArr = new byte[8192];
                        int i2 = 0;
                        do {
                            int read = fileInputStream2.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            i2 += read;
                        } while (i2 < i);
                        FileSystemUtils.close(fileInputStream2);
                    } catch (Exception unused) {
                        fileInputStream = fileInputStream2;
                        FileSystemUtils.close(fileInputStream);
                        FileSystemUtils.close(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        FileSystemUtils.close(fileInputStream);
                        FileSystemUtils.close(fileOutputStream);
                        throw th;
                    }
                } catch (Exception unused2) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Exception unused3) {
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            FileSystemUtils.close(fileOutputStream);
        }
    }

    public static void zip(OutputStream outputStream, List<File> list) throws IOException {
        ZipOutputStream zipOutputStream;
        if (list.size() != 0) {
            ZipOutputStream zipOutputStream2 = null;
            try {
                zipOutputStream = new ZipOutputStream(outputStream);
            } catch (Throwable th) {
                th = th;
            }
            try {
                zipOutputStream.putNextEntry(new ZipEntry("/"));
                Iterator<File> it = list.iterator();
                while (it.hasNext()) {
                    zip(zipOutputStream, it.next(), true);
                }
                FileSystemUtils.close(zipOutputStream);
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream2 = zipOutputStream;
                FileSystemUtils.close(zipOutputStream2);
                throw th;
            }
        }
    }

    public static void zip(String str, String str2) throws Exception {
        zip(str2, new File(str));
    }

    private static void zip(String str, File file) throws Exception {
        ZipOutputStream zipOutputStream = null;
        try {
            new File(str).getParentFile().mkdirs();
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
            try {
                zip(zipOutputStream2, file, "");
                FileSystemUtils.close(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                FileSystemUtils.close(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void zip(ZipOutputStream zipOutputStream, File file, boolean z) throws IOException {
        if (file == null || !file.exists()) {
            return;
        }
        if (!z && file.isDirectory()) {
            zip(zipOutputStream, file, file.getName());
            return;
        }
        File[] listFiles = file.isDirectory() ? file.listFiles() : new File[]{file};
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            zip(zipOutputStream, file2, file2.getName());
        }
    }

    private static void zip(ZipOutputStream zipOutputStream, File file, String str) throws IOException {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            zipOutputStream.putNextEntry(new ZipEntry(str + "/"));
            String str2 = str.length() == 0 ? "" : str + "/";
            for (File file2 : listFiles) {
                zip(zipOutputStream, file2, str2 + file2.getName());
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (-1 != read) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    FileSystemUtils.close(fileInputStream);
                    return;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            FileSystemUtils.close(fileInputStream2);
            throw th;
        }
    }

    public static File getExceptionLogDir(File file) {
        File[] listFiles;
        if (file == null) {
            return null;
        }
        try {
            listFiles = file.listFiles();
        } catch (Throwable th) {
            NpthLog.e("NPTH", " path:" + file + " exception:" + th);
        }
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (!file2.isFile()) {
                    return file2;
                }
            }
            return null;
        }
        return null;
    }
}
