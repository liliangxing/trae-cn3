package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.SysUtil;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DirectApkSoSource extends SoSource {
    private final File mApkFile;
    private final Set<String> mDirectApkLdPaths;
    private final Map<String, Set<String>> mLibsInApkMap;

    public DirectApkSoSource(Context context) {
        this.mLibsInApkMap = new HashMap();
        this.mDirectApkLdPaths = getDirectApkLdPaths("");
        this.mApkFile = new File(context.getApplicationInfo().sourceDir);
    }

    public DirectApkSoSource(File file) {
        this.mLibsInApkMap = new HashMap();
        this.mDirectApkLdPaths = getDirectApkLdPaths(SysUtil.getBaseName(file.getName()));
        this.mApkFile = file;
    }

    @Override // com.facebook.soloader.SoSource
    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.sSoFileLoader == null) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
        for (String str2 : this.mDirectApkLdPaths) {
            Set<String> set = this.mLibsInApkMap.get(str2);
            if (TextUtils.isEmpty(str2) || set == null || !set.contains(str)) {
                Log.v("SoLoader", str + " not found on " + str2);
            } else {
                loadDependencies(str, i, threadPolicy);
                try {
                    i |= 4;
                    SoLoader.sSoFileLoader.load(str2 + File.separator + str, i);
                    Log.d("SoLoader", str + " found on " + str2);
                    return 1;
                } catch (UnsatisfiedLinkError e) {
                    Log.w("SoLoader", str + " not found on " + str2 + " flag: " + i, e);
                }
            }
        }
        return 0;
    }

    @Override // com.facebook.soloader.SoSource
    public File unpackLibrary(String str) throws IOException {
        throw new UnsupportedOperationException("DirectAPKSoSource doesn't support unpackLibrary");
    }

    static Set<String> getDirectApkLdPaths(String str) {
        HashSet hashSet = new HashSet();
        String classLoaderLdLoadLibrary = SysUtil.Api14Utils.getClassLoaderLdLoadLibrary();
        if (classLoaderLdLoadLibrary != null) {
            for (String str2 : classLoaderLdLoadLibrary.split(":")) {
                if (str2.contains(str + ".apk!/")) {
                    hashSet.add(str2);
                }
            }
        }
        return hashSet;
    }

    private static String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", str, "]");
        }
        try {
            return NativeDeps.getDependencies(str, elfByteChannel);
        } finally {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        r2 = new com.facebook.soloader.ElfZipFileChannel(r1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        r8 = getDependencies(r8, r2);
        r3 = r8.length;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        if (r4 >= r3) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        r5 = r8[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (contains(r5) != false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
    
        if (r5.startsWith("/") == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0057, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0052, code lost:
    
        com.facebook.soloader.SoLoader.loadLibraryBySoName(r5, r9 | 1, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0068, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005e, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0067, code lost:
    
        throw r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void loadDependencies(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        ZipFile zipFile = new ZipFile(this.mApkFile);
        try {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (true) {
                if (!entries.hasMoreElements()) {
                    break;
                }
                ZipEntry nextElement = entries.nextElement();
                if (nextElement != null && nextElement.getName().endsWith("/" + str)) {
                    break;
                }
            }
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.soloader.SoSource
    public void prepare(int i) throws IOException {
        int indexOf;
        int i2;
        String str = null;
        for (String str2 : this.mDirectApkLdPaths) {
            if (!TextUtils.isEmpty(str2) && (indexOf = str2.indexOf(33)) >= 0 && (i2 = indexOf + 2) < str2.length()) {
                str = str2.substring(i2);
            }
            if (!TextUtils.isEmpty(str)) {
                ZipFile zipFile = new ZipFile(this.mApkFile);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (nextElement != null && nextElement.getName().startsWith(str) && nextElement.getName().endsWith(".so") && nextElement.getMethod() == 0) {
                            append(str2, nextElement.getName().substring(str.length() + 1));
                        }
                    }
                    zipFile.close();
                } catch (Throwable th) {
                    try {
                        zipFile.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
        }
    }

    @Override // com.facebook.soloader.SoSource
    public String toString() {
        return getClass().getName() + "[root = " + LdPathsToString() + ']';
    }

    private synchronized boolean contains(String str) {
        Iterator<Set<String>> it = this.mLibsInApkMap.values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(str)) {
                return true;
            }
        }
        return false;
    }

    private synchronized void append(String str, String str2) {
        if (!this.mLibsInApkMap.containsKey(str)) {
            this.mLibsInApkMap.put(str, new HashSet());
        }
        this.mLibsInApkMap.get(str).add(str2);
    }

    private String LdPathsToString() {
        StringBuilder sb = new StringBuilder("(");
        Iterator<String> it = this.mDirectApkLdPaths.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(", ");
        }
        sb.append(')');
        return sb.toString();
    }
}
