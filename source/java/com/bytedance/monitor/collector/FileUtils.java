package com.bytedance.monitor.collector;

import android.text.TextUtils;
import com.bytedance.monitor.util.IoUtil;
import com.ss.android.update.UpdateDialogNewBase;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public class FileUtils {
    private FileUtils() {
    }

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
                IoUtil.safeClose(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                IoUtil.safeClose(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
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
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        if (str2 != null) {
                            sb.append(str2);
                        }
                    } else {
                        IoUtil.safeClose(bufferedReader2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    IoUtil.safeClose(bufferedReader);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONArray readFileArray(String str) throws IOException {
        BufferedReader bufferedReader = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        JSONArray jSONArray = new JSONArray();
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        jSONArray.put(readLine);
                    } else {
                        IoUtil.safeClose(bufferedReader2);
                        return jSONArray;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    IoUtil.safeClose(bufferedReader);
                    throw th;
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
        return readFile(str, null);
    }

    public static JSONArray toJsonArray(String str, String str2) {
        JSONArray jSONArray = new JSONArray();
        if (str != null && str2 != null) {
            for (String str3 : str.split(str2)) {
                jSONArray.put(str3);
            }
        }
        return jSONArray;
    }

    public static Map<String, String> readPropertiesFile(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
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
                IoUtil.safeClose(fileInputStream);
                return hashMap;
            } catch (IOException unused) {
                IoUtil.safeClose(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                IoUtil.safeClose(fileInputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String[] readProcFile(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)), 1000);
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            int indexOf = readLine.indexOf(")");
            if (indexOf > 0) {
                readLine = readLine.substring(indexOf + 2);
            }
            return readLine.split(" ");
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                return null;
            } finally {
                IoUtil.safeClose(bufferedReader);
            }
        }
    }

    public static boolean isEmpty(File[] fileArr) {
        return fileArr == null || fileArr.length == 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public static void writeListMap(File file, ArrayList<HashMap<String, String>> arrayList, String str, String str2) {
        FileOutputStream fileOutputStream;
        if (file == null || arrayList == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            StringBuilder sb = new StringBuilder();
            ?? r0 = 0;
            while (r0 < arrayList.size()) {
                HashMap<String, String> hashMap = arrayList.get(r0);
                if (hashMap != null && hashMap.size() != 0) {
                    for (String str3 : hashMap.keySet()) {
                        sb.append(str3).append(str2).append(hashMap.get(str3)).append(str);
                    }
                    sb.append(UpdateDialogNewBase.TYPE);
                }
                r0++;
            }
            fileOutputStream.write(sb.toString().getBytes());
            IoUtil.safeClose(fileOutputStream);
            fileOutputStream2 = r0;
        } catch (IOException e2) {
            e = e2;
            fileOutputStream3 = fileOutputStream;
            e.printStackTrace();
            IoUtil.safeClose(fileOutputStream3);
            fileOutputStream2 = fileOutputStream3;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            IoUtil.safeClose(fileOutputStream2);
            throw th;
        }
    }

    public static ArrayList<HashMap<String, String>> readListMap(File file, String str, String str2) {
        ArrayList<HashMap<String, String>> arrayList;
        String[] split;
        BufferedReader bufferedReader = null;
        ArrayList<HashMap<String, String>> arrayList2 = null;
        BufferedReader bufferedReader2 = null;
        if (file == null || !file.exists() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    String readLine = bufferedReader3.readLine();
                    if (readLine != null) {
                        if (!UpdateDialogNewBase.TYPE.equals(readLine) && (split = readLine.split(str)) != null) {
                            HashMap<String, String> hashMap = new HashMap<>();
                            for (String str3 : split) {
                                String[] split2 = str3.split(str2);
                                if (split2 != null && split2.length == 2) {
                                    hashMap.put(split2[0], split2[1]);
                                }
                            }
                            if (hashMap.size() > 0) {
                                if (arrayList2 == null) {
                                    arrayList2 = new ArrayList<>();
                                }
                                arrayList2.add(hashMap);
                            }
                        }
                    } else {
                        IoUtil.safeClose(bufferedReader3);
                        return arrayList2;
                    }
                } catch (FileNotFoundException | IOException unused) {
                    arrayList = arrayList2;
                    bufferedReader2 = bufferedReader3;
                    IoUtil.safeClose(bufferedReader2);
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader3;
                    IoUtil.safeClose(bufferedReader);
                    throw th;
                }
            }
        } catch (FileNotFoundException | IOException unused2) {
            arrayList = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void copy(File file, File file2) {
        FileOutputStream fileOutputStream;
        if (file == null || file2 == null) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            file2.getParentFile().mkdirs();
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream2.read(bArr);
                        if (read <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    IoUtil.safeClose(fileInputStream2);
                } catch (Exception e) {
                    e = e;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        IoUtil.safeClose(fileInputStream);
                        IoUtil.safeClose(fileOutputStream);
                    } catch (Throwable th) {
                        th = th;
                        IoUtil.safeClose(fileInputStream);
                        IoUtil.safeClose(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    IoUtil.safeClose(fileInputStream);
                    IoUtil.safeClose(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (Exception e3) {
            e = e3;
            fileOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
        IoUtil.safeClose(fileOutputStream);
    }

    public static void zip(String str, String str2) throws Exception {
        zip(str2, new File(str));
    }

    public static void zip(List<String> list, String str) throws Exception {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    File file = new File(it.next());
                    zip(zipOutputStream2, file, file.getName());
                }
                IoUtil.safeClose(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                IoUtil.safeClose(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void zip(String str, File file) throws Exception {
        ZipOutputStream zipOutputStream = null;
        try {
            new File(str).getParentFile().mkdirs();
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(str));
            try {
                zip(zipOutputStream2, file, "");
                IoUtil.safeClose(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                IoUtil.safeClose(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void zip(OutputStream outputStream, File... fileArr) throws IOException {
        ZipOutputStream zipOutputStream = null;
        try {
            ZipOutputStream zipOutputStream2 = new ZipOutputStream(outputStream);
            try {
                zipOutputStream2.putNextEntry(new ZipEntry("/"));
                for (File file : fileArr) {
                    zip(zipOutputStream2, file);
                }
                IoUtil.safeClose(zipOutputStream2);
            } catch (Throwable th) {
                th = th;
                zipOutputStream = zipOutputStream2;
                IoUtil.safeClose(zipOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void zip(ZipOutputStream zipOutputStream, File file) throws IOException {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                zip(zipOutputStream, file2, file2.getName());
            }
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (-1 != read) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        IoUtil.safeClose(fileInputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                IoUtil.safeClose(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void zip(ZipOutputStream zipOutputStream, File file, String str) throws IOException {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            zipOutputStream.putNextEntry(new ZipEntry(str + "/"));
            String str2 = str.length() == 0 ? "" : str + "/";
            for (int i = 0; i < listFiles.length; i++) {
                zip(zipOutputStream, listFiles[i], str2 + listFiles[i].getName());
            }
            return;
        }
        zipOutputStream.putNextEntry(new ZipEntry(str));
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (-1 != read) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        IoUtil.safeClose(fileInputStream2);
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                IoUtil.safeClose(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
