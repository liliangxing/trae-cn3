package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.hash.PBKDF2;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.File;
import java.io.IOException;

/* renamed from: com.huawei.hms.hatool.x */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1186x {

    /* renamed from: a */
    private String f1583a = AbstractC1173q0.m1707i().getFilesDir().getPath();

    /* renamed from: a */
    private String m1798a(String str) {
        return this.f1583a + "/hms/component/".replace("component", str);
    }

    /* renamed from: a */
    private void m1799a(String str, String str2) {
        File file = new File(m1798a(str));
        File file2 = new File(m1798a(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            C1182v.m1781c("hmsSdk", "file directory is mkdirs");
        }
        if (m1800a(file2)) {
            C1156k1.m1598a(file2, str2);
        } else {
            C1182v.m1786f("hmsSdk", "refreshComponent():file is not found,and file is create failed");
        }
    }

    /* renamed from: a */
    private boolean m1800a(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            C1182v.m1786f("hmsSdk", "create new file error!");
            return false;
        }
    }

    /* renamed from: a */
    private char[] m1801a(String str, String str2, String str3, String str4) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        byte[] hexStr2ByteArray4 = HexUtil.hexStr2ByteArray(str4);
        int length = hexStr2ByteArray.length;
        if (length > hexStr2ByteArray2.length) {
            length = hexStr2ByteArray2.length;
        }
        if (length > hexStr2ByteArray3.length) {
            length = hexStr2ByteArray3.length;
        }
        if (length > hexStr2ByteArray4.length) {
            length = hexStr2ByteArray4.length;
        }
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = (char) (((hexStr2ByteArray[i] ^ hexStr2ByteArray2[i]) ^ hexStr2ByteArray3[i]) ^ hexStr2ByteArray4[i]);
        }
        return cArr;
    }

    /* renamed from: b */
    private String m1802b(String str) {
        File file = new File(m1798a(str), "hianalytics_" + str);
        if (m1800a(file)) {
            return C1156k1.m1595a(file);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(128);
        C1156k1.m1598a(file, generateSecureRandomStr);
        return generateSecureRandomStr;
    }

    /* renamed from: b */
    private boolean m1803b() {
        long m1463a = C1133d.m1463a(AbstractC1173q0.m1707i(), "Privacy_MY", "assemblyFlash", -1L);
        if (-1 != m1463a) {
            return System.currentTimeMillis() - m1463a > 31536000000L;
        }
        C1182v.m1781c("hmsSdk", "First init components");
        return true;
    }

    /* renamed from: b */
    private static boolean m1804b(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    C1182v.m1781c("hmsSdk", "delete file failed : " + file2.getName());
                }
            } else if (file2.isDirectory()) {
                m1804b(file2);
            }
        }
        return file.delete();
    }

    /* renamed from: c */
    public static boolean m1805c() {
        return m1804b(new File(AbstractC1173q0.m1707i().getFilesDir().getPath() + "/hms"));
    }

    /* renamed from: d */
    private String m1806d() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    /* renamed from: a */
    public String m1807a() {
        String m1802b;
        String m1802b2;
        String m1802b3;
        String m1802b4;
        String m1806d = m1806d();
        if (m1803b()) {
            C1182v.m1781c("hmsSdk", "refresh components");
            m1802b = EncryptUtil.generateSecureRandomStr(128);
            m1799a("aprpap", m1802b);
            m1802b2 = EncryptUtil.generateSecureRandomStr(128);
            m1799a("febdoc", m1802b2);
            m1802b3 = EncryptUtil.generateSecureRandomStr(128);
            m1799a("marfil", m1802b3);
            m1802b4 = EncryptUtil.generateSecureRandomStr(128);
            m1799a("maywnj", m1802b4);
            C1133d.m1468b(AbstractC1173q0.m1707i(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            m1802b = m1802b("aprpap");
            m1802b2 = m1802b("febdoc");
            m1802b3 = m1802b("marfil");
            m1802b4 = m1802b("maywnj");
        }
        return HexUtil.byteArray2HexStr(PBKDF2.pbkdf2(m1801a(m1802b, m1802b2, m1802b3, m1806d), HexUtil.hexStr2ByteArray(m1802b4), 10000, 16));
    }
}
