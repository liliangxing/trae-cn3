package com.bytedance.reparo.core.check;

import android.app.Application;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: classes4.dex */
public class SignChecker {
    private static List<String> appSignatures;

    public boolean check(Application application, File file) {
        List<String> checkPatchSignatureConsistency = checkPatchSignatureConsistency(file);
        if (checkPatchSignatureConsistency == null || checkPatchSignatureConsistency.size() == 0) {
            return false;
        }
        if (appSignatures == null) {
            appSignatures = getAppSignatures(application);
        }
        return compare(checkPatchSignatureConsistency, appSignatures);
    }

    private List<String> checkPatchSignatureConsistency(File file) {
        List<String> list;
        JarFile jarFile = null;
        try {
            try {
                try {
                    JarFile jarFile2 = new JarFile(file);
                    try {
                        try {
                            Enumeration<JarEntry> entries = jarFile2.entries();
                            list = null;
                            while (entries.hasMoreElements()) {
                                try {
                                    List<String> loadEntryCertificates = loadEntryCertificates(jarFile2, entries.nextElement(), new byte[8096]);
                                    if (loadEntryCertificates != null && loadEntryCertificates.size() != 0) {
                                        if (list == null) {
                                            list = loadEntryCertificates;
                                        }
                                        if (!compare(list, loadEntryCertificates)) {
                                            try {
                                                jarFile2.close();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                            return null;
                                        }
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    jarFile = jarFile2;
                                    e.printStackTrace();
                                    if (jarFile != null) {
                                        jarFile.close();
                                    }
                                    return list;
                                }
                            }
                            jarFile2.close();
                        } catch (IOException e3) {
                            e = e3;
                            list = null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        jarFile = jarFile2;
                        if (jarFile != null) {
                            try {
                                jarFile.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e5) {
                e = e5;
                list = null;
            }
        } catch (IOException e6) {
            e6.printStackTrace();
        }
        return list;
    }

    private boolean compare(List<String> list, List<String> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        Collections.sort(list);
        Collections.sort(list2);
        for (int i = 0; i < list.size(); i++) {
            if (!TextUtils.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0032 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<String> loadEntryCertificates(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InputStream inputStream;
        Certificate[] certificateArr;
        InputStream inputStream2 = null;
        try {
            try {
                inputStream = jarFile.getInputStream(jarEntry);
                do {
                    try {
                    } catch (IOException e) {
                        e = e;
                        e.printStackTrace();
                        JarFile jarFile2 = inputStream;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                                jarFile2 = inputStream;
                            } catch (IOException e2) {
                                e2.printStackTrace();
                                jarFile2 = e2;
                            }
                        }
                        certificateArr = null;
                        jarFile = jarFile2;
                        if (certificateArr != null) {
                        }
                    }
                } while (inputStream.read(bArr) != -1);
                certificateArr = jarEntry.getCertificates();
                jarFile = inputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        jarFile = inputStream;
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        jarFile = e3;
                    }
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = jarFile;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
            }
            throw th;
        }
        if (certificateArr != null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (Certificate certificate : certificateArr) {
                String charsString = toCharsString(certificate.getEncoded());
                if (!TextUtils.isEmpty(charsString)) {
                    arrayList.add(charsString);
                }
            }
        } catch (CertificateEncodingException e6) {
            e6.printStackTrace();
        }
        return arrayList;
    }

    private List<String> getAppSignatures(Application application) {
        ArrayList arrayList = new ArrayList();
        try {
            for (Signature signature : application.getPackageManager().getPackageInfo(application.getPackageName(), 64).signatures) {
                String charsString = signature.toCharsString();
                if (!charsString.isEmpty()) {
                    arrayList.add(charsString);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    private String toCharsString(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length * 2];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            int i3 = i * 2;
            cArr[i3] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            int i4 = b & 15;
            cArr[i3 + 1] = (char) (i4 >= 10 ? (i4 + 97) - 10 : i4 + 48);
        }
        return new String(cArr);
    }
}
