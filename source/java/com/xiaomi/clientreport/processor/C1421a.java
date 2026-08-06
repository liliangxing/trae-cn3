package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.clientreport.data.C1419a;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.manager.C1420a;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1494ba;
import com.xiaomi.push.C1504bk;
import com.xiaomi.push.C1655h;
import com.xiaomi.push.C1801v;
import com.xiaomi.push.C1803x;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* renamed from: com.xiaomi.clientreport.processor.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1421a implements IEventProcessor {

    /* renamed from: a */
    protected Context f776a;

    /* renamed from: a */
    private HashMap<String, ArrayList<C1419a>> f777a;

    public C1421a(Context context) {
        m1141a(context);
    }

    /* renamed from: a */
    public void m1141a(Context context) {
        this.f776a = context;
    }

    /* renamed from: a */
    public static String m1134a(C1419a c1419a) {
        return String.valueOf(c1419a.production);
    }

    /* renamed from: a */
    public void mo1143a(List<String> list) {
        C1504bk.m1667a(this.f776a, list);
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC1423c
    /* renamed from: a */
    public void mo1140a() {
        int i;
        RandomAccessFile randomAccessFile;
        C1504bk.m1666a(this.f776a, "event", "eventUploading");
        File[] m1671a = C1504bk.m1671a(this.f776a, "eventUploading");
        if (m1671a == null || m1671a.length <= 0) {
            return;
        }
        FileLock fileLock = null;
        File file = null;
        RandomAccessFile randomAccessFile2 = null;
        for (File file2 : m1671a) {
            if (file2 == null) {
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException e) {
                        AbstractC1417b.m1093a(e);
                    }
                }
                C1801v.m4105a(randomAccessFile2);
                i = file == null ? i + 1 : 0;
                file.delete();
            } else {
                try {
                    try {
                    } catch (Exception e2) {
                        e = e2;
                    }
                    if (file2.length() > 5242880) {
                        AbstractC1417b.m1103d("eventData read from cache file failed because " + file2.getName() + " is too big, length " + file2.length());
                        m1137a(file2.getName(), Formatter.formatFileSize(this.f776a, file2.length()));
                        file2.delete();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException e3) {
                                AbstractC1417b.m1093a(e3);
                            }
                        }
                        C1801v.m4105a(randomAccessFile2);
                        if (file == null) {
                        }
                        file.delete();
                    } else {
                        String absolutePath = file2.getAbsolutePath();
                        File file3 = new File(absolutePath + ".lock");
                        try {
                            C1801v.m4109a(file3);
                            randomAccessFile = new RandomAccessFile(file3, "rw");
                        } catch (Exception e4) {
                            e = e4;
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            fileLock = randomAccessFile.getChannel().lock();
                            mo1143a(m1135a(absolutePath));
                            file2.delete();
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e5) {
                                    AbstractC1417b.m1093a(e5);
                                }
                            }
                            C1801v.m4105a(randomAccessFile);
                            file3.delete();
                            randomAccessFile2 = randomAccessFile;
                            file = file3;
                        } catch (Exception e6) {
                            e = e6;
                            randomAccessFile2 = randomAccessFile;
                            file = file3;
                            AbstractC1417b.m1093a(e);
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e7) {
                                    AbstractC1417b.m1093a(e7);
                                }
                            }
                            C1801v.m4105a(randomAccessFile2);
                            if (file == null) {
                            }
                            file.delete();
                        } catch (Throwable th2) {
                            th = th2;
                            randomAccessFile2 = randomAccessFile;
                            file = file3;
                            if (fileLock != null && fileLock.isValid()) {
                                try {
                                    fileLock.release();
                                } catch (IOException e8) {
                                    AbstractC1417b.m1093a(e8);
                                }
                            }
                            C1801v.m4105a(randomAccessFile2);
                            if (file == null) {
                                throw th;
                            }
                            file.delete();
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
        }
    }

    /* renamed from: a */
    private void m1137a(String str, String str2) {
        EventClientReport m1124a = C1420a.m1108a(this.f776a).m1124a(5001, "24:" + str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m1124a.toJsonString());
        mo1143a(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        com.xiaomi.channel.commonutils.logger.AbstractC1417b.m1103d("eventData read from cache file failed cause lengthBuffer < 1 || lengthBuffer > 4K");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<String> m1135a(String str) {
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(str));
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        if (read != 4) {
                            AbstractC1417b.m1103d("eventData read from cache file failed because magicNumber error");
                            break;
                        }
                        if (C1803x.m4117a(bArr) != -573785174) {
                            AbstractC1417b.m1103d("eventData read from cache file failed because magicNumber error");
                            break;
                        }
                        int read2 = fileInputStream2.read(bArr2);
                        if (read2 == -1) {
                            break;
                        }
                        if (read2 != 4) {
                            AbstractC1417b.m1103d("eventData read from cache file failed cause lengthBuffer error");
                            break;
                        }
                        int m4117a = C1803x.m4117a(bArr2);
                        if (m4117a < 1 || m4117a > 4096) {
                            break;
                        }
                        byte[] bArr3 = new byte[m4117a];
                        if (fileInputStream2.read(bArr3) != m4117a) {
                            AbstractC1417b.m1103d("eventData read from cache file failed cause buffer size not equal length");
                            break;
                        }
                        String bytesToString = bytesToString(bArr3);
                        if (!TextUtils.isEmpty(bytesToString)) {
                            arrayList.add(bytesToString);
                        }
                    } catch (Exception e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        AbstractC1417b.m1093a(e);
                        C1801v.m4105a((Closeable) fileInputStream);
                        return arrayList;
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        C1801v.m4105a((Closeable) fileInputStream);
                        throw th;
                    }
                }
                C1801v.m4105a((Closeable) fileInputStream2);
            } catch (Exception e2) {
                e = e2;
            }
            return arrayList;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public String bytesToString(byte[] bArr) {
        byte[] m1670a;
        if (bArr != null && bArr.length >= 1) {
            if (!C1420a.m1108a(this.f776a).m1123a().isEventEncrypted()) {
                return C1494ba.m1635b(bArr);
            }
            String m1664a = C1504bk.m1664a(this.f776a);
            if (!TextUtils.isEmpty(m1664a) && (m1670a = C1504bk.m1670a(m1664a)) != null && m1670a.length > 0) {
                try {
                    return C1494ba.m1635b(Base64.decode(C1655h.m3006a(m1670a, bArr), 2));
                } catch (InvalidAlgorithmParameterException e) {
                    AbstractC1417b.m1093a(e);
                } catch (InvalidKeyException e2) {
                    AbstractC1417b.m1093a(e2);
                } catch (NoSuchAlgorithmException e3) {
                    AbstractC1417b.m1093a(e3);
                } catch (BadPaddingException e4) {
                    AbstractC1417b.m1093a(e4);
                } catch (IllegalBlockSizeException e5) {
                    AbstractC1417b.m1093a(e5);
                } catch (NoSuchPaddingException e6) {
                    AbstractC1417b.m1093a(e6);
                }
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public byte[] stringToBytes(String str) {
        byte[] m1670a;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!C1420a.m1108a(this.f776a).m1123a().isEventEncrypted()) {
            return C1494ba.m1633a(str);
        }
        String m1664a = C1504bk.m1664a(this.f776a);
        byte[] m1633a = C1494ba.m1633a(str);
        if (!TextUtils.isEmpty(m1664a) && m1633a != null && m1633a.length > 1 && (m1670a = C1504bk.m1670a(m1664a)) != null) {
            try {
                if (m1670a.length > 1) {
                    return C1655h.m3007b(m1670a, Base64.encode(m1633a, 2));
                }
            } catch (Exception e) {
                AbstractC1417b.m1093a(e);
            }
        }
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.IEventProcessor
    public void setEventMap(HashMap<String, ArrayList<C1419a>> hashMap) {
        this.f777a = hashMap;
    }

    /* renamed from: a */
    public void m1144a(C1419a[] c1419aArr) {
        if (c1419aArr == null || c1419aArr.length == 0 || c1419aArr[0] == null) {
            AbstractC1417b.m1089a("event data write to cache file failed because data null");
            return;
        }
        do {
            c1419aArr = m1138a(c1419aArr);
            if (c1419aArr == null || c1419aArr.length <= 0) {
                return;
            }
        } while (c1419aArr[0] != null);
    }

    /* renamed from: a */
    private C1419a[] m1138a(C1419a[] c1419aArr) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        BufferedOutputStream bufferedOutputStream;
        String m1139b = m1139b(c1419aArr[0]);
        BufferedOutputStream bufferedOutputStream2 = null;
        if (TextUtils.isEmpty(m1139b)) {
            return null;
        }
        try {
            File file = new File(m1139b + ".lock");
            C1801v.m4109a(file);
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                fileLock = randomAccessFile.getChannel().lock();
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(m1139b), true));
                    try {
                        try {
                            int i = 0;
                            for (C1419a c1419a : c1419aArr) {
                                if (c1419a != null) {
                                    byte[] stringToBytes = stringToBytes(c1419a.toJsonString());
                                    if (stringToBytes != null && stringToBytes.length >= 1 && stringToBytes.length <= 4096) {
                                        if (!C1504bk.m1669a(this.f776a, m1139b)) {
                                            int length = c1419aArr.length - i;
                                            C1419a[] c1419aArr2 = new C1419a[length];
                                            System.arraycopy(c1419aArr, i, c1419aArr2, 0, length);
                                            C1801v.m4105a(bufferedOutputStream);
                                            m1136a(randomAccessFile, fileLock);
                                            return c1419aArr2;
                                        }
                                        bufferedOutputStream.write(C1803x.m4118a(-573785174));
                                        bufferedOutputStream.write(C1803x.m4118a(stringToBytes.length));
                                        bufferedOutputStream.write(stringToBytes);
                                        bufferedOutputStream.flush();
                                        i++;
                                    }
                                    AbstractC1417b.m1103d("event data throw a invalid item ");
                                }
                            }
                        } catch (Exception e) {
                            e = e;
                            AbstractC1417b.m1091a("event data write to cache file failed cause exception", e);
                            C1801v.m4105a(bufferedOutputStream);
                            m1136a(randomAccessFile, fileLock);
                            return null;
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedOutputStream2 = bufferedOutputStream;
                        C1801v.m4105a(bufferedOutputStream2);
                        m1136a(randomAccessFile, fileLock);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    C1801v.m4105a(bufferedOutputStream2);
                    m1136a(randomAccessFile, fileLock);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                fileLock = null;
                bufferedOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileLock = null;
            }
        } catch (Exception e4) {
            e = e4;
            fileLock = null;
            randomAccessFile = null;
            bufferedOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            fileLock = null;
            randomAccessFile = null;
        }
        C1801v.m4105a(bufferedOutputStream);
        m1136a(randomAccessFile, fileLock);
        return null;
    }

    /* renamed from: a */
    private void m1136a(RandomAccessFile randomAccessFile, FileLock fileLock) {
        if (fileLock != null && fileLock.isValid()) {
            try {
                fileLock.release();
            } catch (IOException e) {
                AbstractC1417b.m1093a(e);
            }
        }
        C1801v.m4105a(randomAccessFile);
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC1424d
    /* renamed from: b */
    public void mo1145b() {
        HashMap<String, ArrayList<C1419a>> hashMap = this.f777a;
        if (hashMap == null) {
            return;
        }
        if (hashMap.size() > 0) {
            Iterator<String> it = this.f777a.keySet().iterator();
            while (it.hasNext()) {
                ArrayList<C1419a> arrayList = this.f777a.get(it.next());
                if (arrayList != null && arrayList.size() > 0) {
                    C1419a[] c1419aArr = new C1419a[arrayList.size()];
                    arrayList.toArray(c1419aArr);
                    m1144a(c1419aArr);
                }
            }
        }
        this.f777a.clear();
    }

    @Override // com.xiaomi.clientreport.processor.InterfaceC1424d
    /* renamed from: a */
    public void mo1142a(C1419a c1419a) {
        if ((c1419a instanceof EventClientReport) && this.f777a != null) {
            EventClientReport eventClientReport = (EventClientReport) c1419a;
            String m1134a = m1134a((C1419a) eventClientReport);
            ArrayList<C1419a> arrayList = this.f777a.get(m1134a);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eventClientReport);
            this.f777a.put(m1134a, arrayList);
        }
    }

    /* renamed from: b */
    private String m1139b(C1419a c1419a) {
        String str = new File(this.f776a.getFilesDir(), "event").getAbsolutePath() + File.separator + m1134a(c1419a);
        for (int i = 0; i < 100; i++) {
            String str2 = str + i;
            if (C1504bk.m1669a(this.f776a, str2)) {
                return str2;
            }
        }
        return null;
    }
}
