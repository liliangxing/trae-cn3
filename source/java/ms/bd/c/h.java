package ms.bd.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes8.dex */
public final class h implements e3 {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static g a(Context context, String[] strArr, String str, i3 i3Var) {
        String[] strArr2;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr3 = applicationInfo.splitSourceDirs;
        if (strArr3 == null || strArr3.length == 0) {
            strArr2 = new String[]{applicationInfo.sourceDir};
        } else {
            strArr2 = new String[strArr3.length + 1];
            strArr2[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr3, 0, strArr2, 1, strArr3.length);
        }
        int length = strArr2.length;
        int i = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i >= length) {
                return null;
            }
            String str2 = strArr2[i];
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i2 = i3;
                }
            }
            if (zipFile != null) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb = new StringBuilder(LibrarianImpl.Constants.LIB_PREFIX);
                            char c = File.separatorChar;
                            String sb2 = sb.append(c).append(str3).append(c).append(str).toString();
                            i3Var.getClass();
                            Locale locale = Locale.US;
                            ZipEntry entry = zipFile.getEntry(sb2);
                            if (entry != null) {
                                return new g(zipFile, entry);
                            }
                        }
                        i4 = i5;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i++;
        }
    }

    public static String[] a(Context context, String str) {
        String[] strArr;
        StringBuilder sb = new StringBuilder(LibrarianImpl.Constants.LIB_PREFIX);
        char c = File.separatorChar;
        Pattern compile = Pattern.compile(sb.append(c).append("([^\\").append(c).append("]*)").append(c).append(str).toString());
        HashSet hashSet = new HashSet();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr2 = applicationInfo.splitSourceDirs;
        if (strArr2 == null || strArr2.length == 0) {
            strArr = new String[]{applicationInfo.sourceDir};
        } else {
            strArr = new String[strArr2.length + 1];
            strArr[0] = applicationInfo.sourceDir;
            System.arraycopy(strArr2, 0, strArr, 1, strArr2.length);
        }
        ZipFile zipFile = null;
        for (String str2 : strArr) {
            try {
                ZipFile zipFile2 = new ZipFile(new File(str2), 1);
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
                zipFile = zipFile2;
            } catch (IOException unused) {
            }
        }
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final void a(Context context, String[] strArr, String str, File file, i3 i3Var) {
        g a;
        String[] strArr2;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        String path;
        g gVar = null;
        r0 = null;
        FileOutputStream fileOutputStream2 = null;
        try {
            a = a(context, strArr, str, i3Var);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (a == null) {
                try {
                    strArr2 = a(context, str);
                } catch (Exception e) {
                    strArr2 = new String[]{e.toString()};
                }
                throw new r2(str, strArr, strArr2);
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i < 5) {
                    i3Var.getClass();
                    Locale locale = Locale.US;
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = a.a.getInputStream(a.b);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        try {
                                            path = file.getPath();
                                        } catch (FileNotFoundException | IOException unused) {
                                            a(inputStream);
                                            a(fileOutputStream);
                                            i = i2;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        fileOutputStream2 = fileOutputStream;
                                        a(inputStream);
                                        a(fileOutputStream2);
                                        throw th;
                                    }
                                } catch (FileNotFoundException unused2) {
                                    fileOutputStream = null;
                                    a(inputStream);
                                    a(fileOutputStream);
                                    i = i2;
                                } catch (IOException unused3) {
                                    fileOutputStream = null;
                                    a(inputStream);
                                    a(fileOutputStream);
                                    i = i2;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            } catch (FileNotFoundException unused4) {
                                inputStream = null;
                            } catch (IOException unused5) {
                                inputStream = null;
                            } catch (Throwable th5) {
                                th = th5;
                                inputStream = null;
                            }
                            if (path.contains("../")) {
                                Log.w("UnzipSecurity", "Dangerous path detected! Blocked unzip operation.\nTimestamp: " + System.currentTimeMillis() + "\nDangerous Path: " + path);
                                a(inputStream);
                                a(fileOutputStream);
                                try {
                                    ZipFile zipFile = a.a;
                                    if (zipFile != null) {
                                        zipFile.close();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused6) {
                                    return;
                                }
                            }
                            byte[] bArr = new byte[4096];
                            long j = 0;
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                fileOutputStream.write(bArr, 0, read);
                                j += read;
                            }
                            fileOutputStream.flush();
                            fileOutputStream.getFD().sync();
                            if (j == file.length()) {
                                a(inputStream);
                                a(fileOutputStream);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                try {
                                    ZipFile zipFile2 = a.a;
                                    if (zipFile2 != null) {
                                        zipFile2.close();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused7) {
                                    return;
                                }
                            }
                            a(inputStream);
                            a(fileOutputStream);
                        }
                    } catch (IOException unused8) {
                    }
                    i = i2;
                } else {
                    i3Var.getClass();
                    try {
                        ZipFile zipFile3 = a.a;
                        if (zipFile3 != null) {
                            zipFile3.close();
                            return;
                        }
                        return;
                    } catch (IOException unused9) {
                        return;
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            gVar = a;
            if (gVar != null) {
                try {
                    ZipFile zipFile4 = gVar.a;
                    if (zipFile4 != null) {
                        zipFile4.close();
                    }
                } catch (IOException unused10) {
                }
            }
            throw th;
        }
    }
}
