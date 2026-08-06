package ms.bd.p001c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.io.encoding.Base64;
import net.openid.appauth.BuildConfig;
import okio.Utf8;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: ms.bd.c.o2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0185o2 {

    /* renamed from: a */
    public static final C0241z3 f296a;

    static {
        C0241z3 c0241z3 = new C0241z3();
        f296a = c0241z3;
        synchronized (C0241z3.class) {
            C0241z3.f482c = c0241z3;
        }
    }

    /* renamed from: a */
    public static boolean m163a(Context context, String str, String str2) {
        try {
            String[] list = context.getAssets().list(str);
            if (list.length > 0) {
                new File(str2).mkdirs();
                for (String str3 : list) {
                    m163a(context, str + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "957d55", new byte[]{103})) + str3, str2 + ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "7ac05d", new byte[]{105})) + str3);
                }
            } else {
                InputStream open = context.getAssets().open(str);
                FileOutputStream fileOutputStream = new FileOutputStream(str2);
                try {
                    byte[] bArr = new byte[256];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    AbstractC0213u0.m194a(fileOutputStream);
                    AbstractC0213u0.m194a(open);
                    throw th;
                }
                AbstractC0213u0.m194a(fileOutputStream);
                AbstractC0213u0.m194a(open);
            }
            return true;
        } catch (Exception unused2) {
            return false;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0022. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0026. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:74:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0329 A[Catch: all -> 0x0378, TryCatch #13 {all -> 0x0378, blocks: (B:83:0x0309, B:85:0x0313, B:86:0x0323, B:88:0x0329, B:91:0x0332, B:94:0x0339), top: B:82:0x0309 }] */
    /* JADX WARN: Type inference failed for: r8v14, types: [java.lang.Object[], java.io.Serializable] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Serializable m162a(int i, int i2, long j, String str, Object obj) {
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList;
        ArrayList arrayList2;
        Serializable serializable;
        boolean z;
        String str5;
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        long j2;
        HashMap hashMap;
        String str6;
        String str7;
        Serializable serializable2;
        Class<?> cls;
        String str8;
        String[] strArr;
        String str9 = str;
        int i3 = 0;
        if (i != 131073 && i != 131074) {
            String str10 = BuildConfig.FLAVOR;
            switch (i) {
                case 65537:
                    serializable = BuildConfig.FLAVOR;
                    try {
                        Context context = C0122d2.f158b.f159a;
                        str8 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                        return str8;
                    } catch (Throwable unused) {
                        break;
                    }
                case 65538:
                    serializable = BuildConfig.FLAVOR;
                    Context context2 = C0122d2.f158b.f159a;
                    if (context2 != null) {
                        return context2.getPackageName();
                    }
                    return serializable;
                case 65539:
                    File file = new File(C0122d2.f158b.f159a.getFilesDir(), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "a3ba3f", new byte[]{62, 60, 2, 17, 13, 101, 99}));
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    return file.getAbsolutePath();
                case 65540:
                    try {
                        z = m163a(C0122d2.f158b.f159a, str9, obj.toString());
                    } catch (Throwable unused2) {
                        z = false;
                    }
                    if (z) {
                        return (String) AbstractC0190p2.m166a(16777217, 0, 0L, "85263c", new byte[]{6, 28});
                    }
                    break;
                case 65541:
                    FileOutputStream fileOutputStream2 = null;
                    Context context3 = C0122d2.f158b.f159a;
                    AssetManager assets = context3.getAssets();
                    if (!str9.startsWith((String) AbstractC0190p2.m166a(16777217, 0, 0L, "2e8d81", new byte[]{109}))) {
                        str9 = ((String) AbstractC0190p2.m166a(16777217, 0, 0L, "386440", new byte[]{108})) + str9;
                    }
                    String[] list = assets.list(BuildConfig.FLAVOR);
                    ArrayList arrayList3 = new ArrayList();
                    int i4 = 0;
                    while (i4 < list.length) {
                        if (list[i4].endsWith(str9)) {
                            String str11 = list[i4];
                            String absolutePath = File.createTempFile((String) AbstractC0190p2.m166a(16777217, 0, 0L, "1d228e", new byte[]{45, 117, 68, 94, 19}), str10).getAbsolutePath();
                            try {
                                inputStream2 = assets.open(str11);
                                try {
                                    fileOutputStream = new FileOutputStream(absolutePath);
                                    try {
                                        try {
                                            bArr = new byte[256];
                                            j2 = 0;
                                        } catch (Throwable th) {
                                            th = th;
                                            AbstractC0213u0.m194a(inputStream2);
                                            AbstractC0213u0.m194a(fileOutputStream);
                                            throw th;
                                        }
                                    } catch (IOException e) {
                                        e = e;
                                        str5 = str10;
                                    }
                                } catch (IOException e2) {
                                    e = e2;
                                    str5 = str10;
                                    fileOutputStream = null;
                                    try {
                                        e.printStackTrace();
                                        AbstractC0213u0.m194a(inputStream2);
                                        AbstractC0213u0.m194a(fileOutputStream);
                                        i4++;
                                        str10 = str5;
                                        i3 = 0;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        inputStream = inputStream2;
                                        fileOutputStream2 = fileOutputStream;
                                        fileOutputStream = fileOutputStream2;
                                        inputStream2 = inputStream;
                                        AbstractC0213u0.m194a(inputStream2);
                                        AbstractC0213u0.m194a(fileOutputStream);
                                        throw th;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    inputStream = inputStream2;
                                    fileOutputStream = fileOutputStream2;
                                    inputStream2 = inputStream;
                                    AbstractC0213u0.m194a(inputStream2);
                                    AbstractC0213u0.m194a(fileOutputStream);
                                    throw th;
                                }
                            } catch (IOException e3) {
                                e = e3;
                                str5 = str10;
                                inputStream2 = null;
                            } catch (Throwable th4) {
                                th = th4;
                                inputStream = null;
                            }
                            while (true) {
                                int read = inputStream2.read(bArr);
                                if (read > 0) {
                                    fileOutputStream.write(bArr, i3, read);
                                    j2 += read;
                                    str10 = str10;
                                    i3 = 0;
                                } else {
                                    str5 = str10;
                                    try {
                                        fileOutputStream.flush();
                                        if (j2 > 0) {
                                            arrayList3.add(absolutePath);
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                        e.printStackTrace();
                                        AbstractC0213u0.m194a(inputStream2);
                                        AbstractC0213u0.m194a(fileOutputStream);
                                        i4++;
                                        str10 = str5;
                                        i3 = 0;
                                    }
                                    AbstractC0213u0.m194a(inputStream2);
                                    AbstractC0213u0.m194a(fileOutputStream);
                                }
                            }
                        } else {
                            str5 = str10;
                        }
                        i4++;
                        str10 = str5;
                        i3 = 0;
                    }
                    File[] listFiles = new File(context3.getFilesDir(), (String) AbstractC0190p2.m166a(16777217, 0, 0L, "61be8f", new byte[]{105, 62, 2, 21, 6, 101, 52, 47, Utf8.REPLACEMENT_BYTE, 54})).listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            if (file2.isFile() && file2.getName().endsWith(str9)) {
                                arrayList3.add(file2.getAbsolutePath());
                            }
                        }
                    }
                    return arrayList3.toArray(new String[0]);
                case 65542:
                    RandomAccessFile randomAccessFile = null;
                    Context context4 = C0122d2.f158b.f159a;
                    ApplicationInfo applicationInfo = context4.getPackageManager().getApplicationInfo(context4.getPackageName(), 0);
                    String str12 = applicationInfo.sourceDir;
                    if (str12 == null) {
                        str12 = applicationInfo.publicSourceDir;
                    }
                    if (TextUtils.isEmpty(str12)) {
                        hashMap = null;
                    } else {
                        hashMap = new HashMap();
                        try {
                            try {
                                RandomAccessFile randomAccessFile2 = new RandomAccessFile(str12, (String) AbstractC0190p2.m166a(16777217, 0, 0L, "39a4fd", new byte[]{48}));
                                try {
                                    C0119d m95a = AbstractC0131f.m95a(randomAccessFile2.getChannel());
                                    if (m95a != null) {
                                        for (Map.Entry entry : AbstractC0131f.m94a((ByteBuffer) m95a.f151a).entrySet()) {
                                            if (entry != null && entry.getKey() != null) {
                                                if (((Integer) entry.getKey()).intValue() != 1896449818) {
                                                    try {
                                                        ByteBuffer byteBuffer = (ByteBuffer) entry.getValue();
                                                        byte[] array = byteBuffer.array();
                                                        int arrayOffset = byteBuffer.arrayOffset();
                                                        hashMap.put((Integer) entry.getKey(), new String(Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, byteBuffer.limit() + arrayOffset)));
                                                    } catch (Throwable unused3) {
                                                    }
                                                }
                                                while (r1.hasNext()) {
                                                }
                                            }
                                        }
                                    }
                                    randomAccessFile2.close();
                                } catch (Throwable unused4) {
                                    randomAccessFile = randomAccessFile2;
                                    if (randomAccessFile != null) {
                                        randomAccessFile.close();
                                    }
                                    if (hashMap == null) {
                                    }
                                    if (str6 != null) {
                                        JSONObject jSONObject2 = new JSONObject(str6);
                                        try {
                                            str7 = jSONObject2.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "56e4d6", new byte[]{41, 49, 2, 65, 100, 52, 59, 18, 58, 99, 27, 55, 30, 65, 85, 47, 51, 27}));
                                        } catch (JSONException unused5) {
                                            str7 = BuildConfig.FLAVOR;
                                        }
                                        StringBuilder append = new StringBuilder().append(str7).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "c20582", new byte[]{41}));
                                        try {
                                            str10 = jSONObject2.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "9788fc", new byte[]{58, 48, 71, 73, 88, 103, Utf8.REPLACEMENT_BYTE, 41, 107, 125, 33, 57, 79}));
                                        } catch (JSONException unused6) {
                                        }
                                        str10 = append.append(str10).toString();
                                    }
                                    if (!str10.isEmpty()) {
                                    }
                                }
                            } catch (Throwable unused7) {
                            }
                        } catch (Throwable unused8) {
                        }
                    }
                    str6 = (hashMap == null && hashMap.containsKey(1903654775)) ? (String) hashMap.get(1903654775) : BuildConfig.FLAVOR;
                    if (str6 != null && !str6.isEmpty()) {
                        JSONObject jSONObject22 = new JSONObject(str6);
                        str7 = jSONObject22.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "56e4d6", new byte[]{41, 49, 2, 65, 100, 52, 59, 18, 58, 99, 27, 55, 30, 65, 85, 47, 51, 27}));
                        StringBuilder append2 = new StringBuilder().append(str7).append((String) AbstractC0190p2.m166a(16777217, 0, 0L, "c20582", new byte[]{41}));
                        str10 = jSONObject22.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "9788fc", new byte[]{58, 48, 71, 73, 88, 103, Utf8.REPLACEMENT_BYTE, 41, 107, 125, 33, 57, 79}));
                        str10 = append2.append(str10).toString();
                    }
                    return !str10.isEmpty() ? (String) AbstractC0190p2.m166a(16777217, 0, 0L, "8758b3", new byte[]{7, 58, 72, 73}) : str10;
                case 65543:
                    try {
                        cls = Class.forName((String) AbstractC0190p2.m166a(16777217, 0, 0L, "d3ece7", new byte[]{118, 62, 27, 89, 73, 51, 41, 19, 58, 55, 103, 62, 31, 19, 20, 53, 96, 17, 122, 34, 96, 62, 2, 22, 20, 2, 67, 60, 49, 39, 98, 62, 4, 28, 110, 33, 96, 49, 59, Base64.padSymbol, 97, 52, 14, 3, 106, 50, 104, 4, Base64.padSymbol, 55, 112, 35, 55, 19, 91, 48, 115, 23, 38}));
                        serializable2 = null;
                    } catch (Throwable unused9) {
                        serializable2 = null;
                    }
                    try {
                        Method declaredMethod = cls.getDeclaredMethod((String) AbstractC0190p2.m166a(16777217, 0, 0L, "032ccb", new byte[]{44, 48, 83, 28, 125, 102, 29, 23, 116, 6, 50, 52, 83}), null);
                        declaredMethod.setAccessible(true);
                        Object newInstance = cls.newInstance();
                        if (newInstance != null ? ((Boolean) declaredMethod.invoke(newInstance, null)).booleanValue() : false) {
                            str8 = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "e28ad4", new byte[]{122, 53, 92, 32, 72, 38, 116});
                            return str8;
                        }
                    } catch (Throwable unused10) {
                        return serializable2;
                    }
                    return serializable2;
                case 65544:
                    try {
                        Context context5 = C0122d2.f158b.f159a;
                        str8 = context5.getPackageManager().getApplicationInfo(context5.getPackageName(), 128).metaData.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "3b4029", new byte[]{17, 83, 120, 114, 40, 28, 3, 106, 74, 78, 29, 78, 102, 105, 40}));
                        return str8;
                    } catch (Throwable unused11) {
                        return BuildConfig.FLAVOR;
                    }
                default:
                    serializable2 = null;
                    switch (i) {
                        case 196609:
                        case 196610:
                        case 196611:
                            if (AbstractC0123d3.m84a((String) AbstractC0190p2.m166a(16777217, 0, 0L, "9c755a", new byte[]{41, 111, 64, 83, 5, Byte.MAX_VALUE, 62, 12, 118, 96, 58, 108, 77, 82, 25, Byte.MAX_VALUE, 53, 76, 40, 76, 6, 85, 97, 115, 36, 83, 14}))) {
                                switch (i) {
                                    case 196609:
                                        Object[] objArr = (Object[]) obj;
                                        byte[] bArr2 = (byte[]) objArr[0];
                                        String str13 = (String) objArr[1];
                                        String str14 = (String) objArr[2];
                                        HashMap hashMap2 = new HashMap();
                                        if (objArr.length > 3 && (strArr = (String[]) objArr[3]) != null && strArr.length % 2 == 0) {
                                            for (int i5 = 0; i5 < strArr.length; i5 += 2) {
                                                hashMap2.put(strArr[i5], strArr[i5 + 1]);
                                            }
                                        }
                                        str8 = C0130e4.m91a(str, bArr2, str13, str14, hashMap2, null, true);
                                        break;
                                    case 196610:
                                        Object[] objArr2 = (Object[]) obj;
                                        str8 = C0130e4.m91a(str, null, (String) objArr2[0], (String) objArr2[1], null, null, false);
                                        break;
                                    case 196611:
                                        Object[] objArr3 = (Object[]) obj;
                                        str8 = C0130e4.m91a(str, null, null, (String) objArr3[1], null, (String) objArr3[0], false);
                                        break;
                                }
                                return str8;
                            }
                            break;
                        default:
                            return serializable2;
                    }
            }
        } else {
            C0241z3 c0241z3 = f296a;
            if (i == 131073) {
                if (str9 != null) {
                    Context context6 = C0122d2.f158b.f159a;
                    try {
                        jSONObject = new JSONObject(str9);
                    } catch (JSONException unused12) {
                        jSONObject = null;
                    }
                    if (jSONObject != null) {
                        try {
                            str2 = jSONObject.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "b35278", new byte[]{96, 53, 77, 121, 9, 38, 101}));
                        } catch (JSONException unused13) {
                            str2 = null;
                        }
                        try {
                            str4 = jSONObject.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "404464", new byte[]{45, Base64.padSymbol, 84, 84, 54, 34, 62, 21}));
                        } catch (JSONException unused14) {
                            str3 = null;
                            str4 = str3;
                            jSONObject.remove((String) AbstractC0190p2.m166a(16777217, 0, 0L, "4ebcc9", new byte[]{38, 104, 31, 17, 85, 41, 2, 118, 31, 32}));
                            jSONObject.remove((String) AbstractC0190p2.m166a(16777217, 0, 0L, "fc301e", new byte[]{101, 100, 80, 75, 28, 102, 80, 112, 78, 115}));
                            SDKMonitorUtils.initMonitor(context6, str2, jSONObject, new C0236y3(jSONObject, str4));
                            c0241z3.f483a = SDKMonitorUtils.getInstance(str2);
                            return (String) AbstractC0190p2.m166a(16777217, 0, 0L, "76b933", new byte[]{9, 31});
                        }
                        try {
                            arrayList = new ArrayList();
                            arrayList2 = new ArrayList();
                            JSONArray jSONArray = jSONObject.getJSONArray((String) AbstractC0190p2.m166a(16777217, 0, 0L, "3a70e1", new byte[]{33, 108, 74, 66, 83, 33, 5, 114, 74, 115}));
                            JSONArray jSONArray2 = jSONObject.getJSONArray((String) AbstractC0190p2.m166a(16777217, 0, 0L, "e29979", new byte[]{102, 53, 90, 66, 26, 58, 83, 33, 68, 122}));
                            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                                arrayList.add(jSONArray.getString(i6));
                            }
                            for (int i7 = 0; i7 < jSONArray2.length(); i7++) {
                                arrayList2.add(jSONArray2.getString(i7));
                            }
                        } catch (JSONException unused15) {
                            str3 = str4;
                            str4 = str3;
                            jSONObject.remove((String) AbstractC0190p2.m166a(16777217, 0, 0L, "4ebcc9", new byte[]{38, 104, 31, 17, 85, 41, 2, 118, 31, 32}));
                            jSONObject.remove((String) AbstractC0190p2.m166a(16777217, 0, 0L, "fc301e", new byte[]{101, 100, 80, 75, 28, 102, 80, 112, 78, 115}));
                            SDKMonitorUtils.initMonitor(context6, str2, jSONObject, new C0236y3(jSONObject, str4));
                            c0241z3.f483a = SDKMonitorUtils.getInstance(str2);
                            return (String) AbstractC0190p2.m166a(16777217, 0, 0L, "76b933", new byte[]{9, 31});
                        }
                        if (arrayList.size() > 0 && arrayList2.size() > 0) {
                            SDKMonitorUtils.setConfigUrl(str2, arrayList);
                            SDKMonitorUtils.setDefaultReportUrl(str2, arrayList2);
                            jSONObject.remove((String) AbstractC0190p2.m166a(16777217, 0, 0L, "4ebcc9", new byte[]{38, 104, 31, 17, 85, 41, 2, 118, 31, 32}));
                            jSONObject.remove((String) AbstractC0190p2.m166a(16777217, 0, 0L, "fc301e", new byte[]{101, 100, 80, 75, 28, 102, 80, 112, 78, 115}));
                            SDKMonitorUtils.initMonitor(context6, str2, jSONObject, new C0236y3(jSONObject, str4));
                            c0241z3.f483a = SDKMonitorUtils.getInstance(str2);
                            return (String) AbstractC0190p2.m166a(16777217, 0, 0L, "76b933", new byte[]{9, 31});
                        }
                    }
                }
            } else if (i == 131074) {
                String[] strArr2 = (String[]) obj;
                if (str9 != null && strArr2 != null && strArr2.length != 0) {
                    JSONObject jSONObject3 = new JSONObject(strArr2[0]);
                    JSONObject jSONObject4 = new JSONObject(strArr2[1]);
                    JSONObject jSONObject5 = new JSONObject(strArr2[2]);
                    if (c0241z3.f483a != null && (jSONObject3.length() > 0 || jSONObject4.length() > 0)) {
                        c0241z3.f483a.monitorEvent(str9, jSONObject3, jSONObject4, jSONObject5);
                    }
                }
            }
        }
        return null;
    }
}
