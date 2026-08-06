package com.bytedance.reparo.core.parse;

import android.app.Application;
import android.os.Build;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.reparo.core.PatchLogger;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes4.dex */
public class AbiHelperImpl implements AbiHelper {
    private static final String CPU_ARM64_V8A = "arm64-v8a";
    private static final String CPU_ARMEABI = "armeabi";
    private static final String CPU_ARMEABI_V7A = "armeabi-v7a";
    private static final String CPU_X86 = "x86";
    private static final String CPU_X86_64 = "x86_64";
    private static final String TAG = "AbiHelper";
    private static final String UNKNOWN_HOST_ABI = "unknown_host_abi";
    private Application application;
    private String hostAbi;
    private int hostApkAbiBits = -1;

    public AbiHelperImpl(Application application) {
        this.application = application;
    }

    @Override // com.bytedance.reparo.core.parse.AbiHelper
    public String getHostAbi() {
        if (this.hostAbi == null) {
            this.hostAbi = parseHostAbi();
            PatchLogger.i(TAG, "parse host abi : " + this.hostAbi);
        }
        return this.hostAbi;
    }

    private String parseHostAbi() {
        try {
            ZipFile zipFile = new ZipFile(new File(this.application.getApplicationInfo().sourceDir));
            Set<String> abiSet = getAbiSet(zipFile);
            zipFile.close();
            String[] strArr = Build.SUPPORTED_ABIS;
            if (abiSet.isEmpty()) {
                return strArr[0];
            }
            for (String str : strArr) {
                if (abiSet.contains(str)) {
                    return str;
                }
            }
            return UNKNOWN_HOST_ABI;
        } catch (IOException e) {
            e.printStackTrace();
            PatchLogger.e(TAG, "parse host abi failed. ", e);
            return UNKNOWN_HOST_ABI;
        }
    }

    private static Set<String> getAbiSet(ZipFile zipFile) {
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        HashSet hashSet = new HashSet();
        while (entries.hasMoreElements()) {
            String name = entries.nextElement().getName();
            if (name.endsWith(LibrarianImpl.Constants.SO_SUFFIX)) {
                hashSet.add(name.split("/")[1]);
            }
        }
        return hashSet;
    }

    @Override // com.bytedance.reparo.core.parse.AbiHelper
    public int getHostApkAbiBits() {
        if (this.hostApkAbiBits == -1) {
            this.hostApkAbiBits = parseHostApkAbiBits();
        }
        return this.hostApkAbiBits;
    }

    private int parseHostApkAbiBits() {
        try {
            ZipFile zipFile = new ZipFile(new File(this.application.getApplicationInfo().sourceDir));
            Set<String> abiSet = getAbiSet(zipFile);
            zipFile.close();
            boolean contains32Bits = contains32Bits(abiSet);
            return contains64Bits(abiSet) ? (contains32Bits ? 1 : 0) | 2 : contains32Bits ? 1 : 0;
        } catch (IOException e) {
            e.printStackTrace();
            PatchLogger.e(TAG, "parse host abi failed. ", e);
            return -1;
        }
    }

    private boolean contains32Bits(Set<String> set) {
        return set.contains(CPU_ARMEABI) || set.contains(CPU_ARMEABI_V7A) || set.contains(CPU_X86);
    }

    private boolean contains64Bits(Set<String> set) {
        return set.contains(CPU_ARM64_V8A) || set.contains(CPU_X86_64);
    }
}
