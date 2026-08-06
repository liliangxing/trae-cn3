package com.vivo.push.p011c;

import android.content.ContentProviderClient;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.vivo.push.C1402x;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1373ah;
import com.vivo.push.util.C1393t;
import java.util.HashMap;

/* compiled from: CoreConfigManager.java */
/* renamed from: com.vivo.push.c.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1231a {

    /* renamed from: a */
    private Context f390a;

    /* renamed from: b */
    private HashMap<String, String> f391b = new HashMap<>();

    public C1231a(Context context) {
        this.f390a = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1 A[Catch: Exception -> 0x00bd, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bd, blocks: (B:76:0x00b9, B:69:0x00c1), top: B:75:0x00b9 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int m640g() {
        ContentProviderClient contentProviderClient;
        if (this.f390a == null) {
            return AVMDLDataLoader.KeyIsLiveGetP2pState;
        }
        if (this.f391b.size() > 0) {
            return 0;
        }
        Cursor cursor = null;
        Object[] objArr = 0;
        Cursor query = null;
        Object[] objArr2 = 0;
        try {
            try {
                contentProviderClient = this.f390a.getContentResolver().acquireUnstableContentProviderClient(C1402x.f728a);
                if (contentProviderClient != null) {
                    try {
                        query = contentProviderClient.query(C1402x.f728a, null, null, null, null);
                    } catch (Exception e) {
                        e = e;
                        C1393t.m1035a("CoreConfigManager", "provider exception", e);
                        if (0 != 0) {
                            try {
                                (objArr2 == true ? 1 : 0).close();
                            } catch (Exception e2) {
                                C1393t.m1035a("CoreConfigManager", "close err ", e2);
                                return AVMDLDataLoader.KeyIsLiveWatchDurationThreshold;
                            }
                        }
                        if (contentProviderClient == null) {
                            return AVMDLDataLoader.KeyIsLiveWatchDurationThreshold;
                        }
                        contentProviderClient.close();
                        return AVMDLDataLoader.KeyIsLiveWatchDurationThreshold;
                    }
                }
                if (query == null) {
                    query = this.f390a.getContentResolver().query(C1402x.f728a, null, null, null, null);
                }
                if (query == null) {
                    C1393t.m1034a("CoreConfigManager", "cursor is null");
                    if (query != null) {
                        try {
                            query.close();
                        } catch (Exception e3) {
                            C1393t.m1035a("CoreConfigManager", "close err ", e3);
                            return AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes;
                        }
                    }
                    if (contentProviderClient == null) {
                        return AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes;
                    }
                    contentProviderClient.close();
                    return AVMDLDataLoader.KeyIsLiveMaxTrySwitchP2pTimes;
                }
                while (query.moveToNext()) {
                    String string = query.getString(query.getColumnIndex("name"));
                    String string2 = query.getString(query.getColumnIndex("value"));
                    if (!TextUtils.isEmpty(string)) {
                        this.f391b.put(string, string2);
                    }
                }
                if (query != null) {
                    try {
                        query.close();
                    } catch (Exception e4) {
                        C1393t.m1035a("CoreConfigManager", "close err ", e4);
                    }
                }
                if (contentProviderClient != null) {
                    contentProviderClient.close();
                }
                return 0;
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        cursor.close();
                    } catch (Exception e5) {
                        C1393t.m1035a("CoreConfigManager", "close err ", e5);
                        throw th;
                    }
                }
                if (0 != 0) {
                    (objArr == true ? 1 : 0).close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            contentProviderClient = null;
        } catch (Throwable th2) {
            th = th2;
            if (0 != 0) {
            }
            if (0 != 0) {
            }
            throw th;
        }
    }

    /* renamed from: a */
    public final int m641a() {
        int m639b = m639b(1);
        C1393t.m1048d("CoreConfigManager", "isSupportNewControlStrategies : ".concat(String.valueOf(m639b)));
        return m639b;
    }

    /* renamed from: b */
    public final int m643b() {
        int m639b = m639b(4);
        C1393t.m1048d("CoreConfigManager", "isSupportSyncProfileInfo : ".concat(String.valueOf(m639b)));
        return m639b;
    }

    /* renamed from: c */
    public final boolean m644c() {
        int m639b = m639b(8);
        C1393t.m1048d("CoreConfigManager", "isSupportdeleteRegid : ".concat(String.valueOf(m639b)));
        return m639b == 0;
    }

    /* renamed from: d */
    public final boolean m645d() {
        int m639b = m639b(16);
        C1393t.m1048d("CoreConfigManager", "isSupportQueryCurrentAppState : ".concat(String.valueOf(m639b)));
        return m639b == 0;
    }

    /* renamed from: e */
    public final boolean m646e() {
        int m639b = m639b(32);
        C1393t.m1048d("CoreConfigManager", "isSupportCreateNotifyChannel : ".concat(String.valueOf(m639b)));
        return m639b == 0;
    }

    /* renamed from: f */
    public final boolean m647f() {
        int m639b = m639b(128);
        C1393t.m1048d("CoreConfigManager", "isSupportAliasSubscribeCheck : ".concat(String.valueOf(m639b)));
        return m639b == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        if (r10 != 4096) goto L39;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m642a(int i) {
        if (m639b(i) == 0) {
            return true;
        }
        if ((i == 256 || i == 512 || i == 4096 || i == 1024 || i == 2048) && "com.vivo.pushservice".equals(C1366aa.m925a(this.f390a))) {
            long m951a = C1373ah.m951a(this.f390a);
            if (i != 256) {
                if (i != 512) {
                    if (i == 1024) {
                        return m951a >= 4200;
                    }
                    if (i == 2048) {
                        return m951a >= 4400;
                    }
                }
                return m951a >= 4100;
            }
            if (m951a >= 3700) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00a7: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:64:0x00a7 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009d A[Catch: Exception -> 0x008a, TRY_ENTER, TryCatch #2 {Exception -> 0x008a, blocks: (B:28:0x0086, B:30:0x008e, B:38:0x009d, B:40:0x00a2), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a2 A[Catch: Exception -> 0x008a, TRY_LEAVE, TryCatch #2 {Exception -> 0x008a, blocks: (B:28:0x0086, B:30:0x008e, B:38:0x009d, B:40:0x00a2), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3 A[Catch: Exception -> 0x00af, TRY_LEAVE, TryCatch #0 {Exception -> 0x00af, blocks: (B:59:0x00ab, B:50:0x00b3), top: B:58:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m638a(Context context, String str) {
        Throwable th;
        ContentProviderClient contentProviderClient;
        Cursor cursor;
        Cursor cursor2;
        Cursor cursor3 = null;
        cursor3 = null;
        r3 = null;
        r3 = null;
        String str2 = null;
        try {
            try {
                try {
                } catch (Exception e) {
                    C1393t.m1035a("CoreConfigManager", "queryFromCoreSdk close error", e);
                }
            } catch (Throwable th2) {
                th = th2;
                cursor3 = cursor2;
            }
        } catch (Exception e2) {
            e = e2;
            contentProviderClient = null;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            contentProviderClient = null;
            if (cursor3 != null) {
            }
            if (contentProviderClient != null) {
            }
        }
        if (context == null) {
            C1393t.m1034a("CoreConfigManager", "queryFromCoreSdk context is null");
            return null;
        }
        contentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(C1402x.f733f);
        if (contentProviderClient != null) {
            try {
                C1393t.m1034a("CoreConfigManager", "queryFromCoreSdk client is null");
                cursor = contentProviderClient.query(C1402x.f733f, null, "queryParameter = ?  ", new String[]{str}, null);
            } catch (Exception e3) {
                e = e3;
                cursor = null;
                C1393t.m1035a("CoreConfigManager", "queryFromCoreSdk error ", e);
                if (cursor != null) {
                }
                if (contentProviderClient != null) {
                }
                return str2;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                if (cursor3 != null) {
                    try {
                        cursor3.close();
                    } catch (Exception e4) {
                        C1393t.m1035a("CoreConfigManager", "queryFromCoreSdk close error", e4);
                        throw th;
                    }
                }
                if (contentProviderClient != null) {
                    throw th;
                }
                contentProviderClient.close();
                throw th;
            }
        } else {
            cursor = null;
        }
        if (cursor == null) {
            try {
                cursor = context.getContentResolver().query(C1402x.f733f, null, "queryParameter = ?  ", new String[]{str}, null);
            } catch (Exception e5) {
                e = e5;
                C1393t.m1035a("CoreConfigManager", "queryFromCoreSdk error ", e);
                if (cursor != null) {
                    cursor.close();
                }
                if (contentProviderClient != null) {
                    contentProviderClient.close();
                }
                return str2;
            }
        }
        if (cursor != null) {
            str2 = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndex("queryAppState")) : null;
            if (cursor != null) {
                cursor.close();
            }
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
            return str2;
        }
        C1393t.m1034a("CoreConfigManager", "queryFromCoreSdk cursor is null");
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e6) {
                C1393t.m1035a("CoreConfigManager", "queryFromCoreSdk close error", e6);
            }
        }
        if (contentProviderClient != null) {
            contentProviderClient.close();
        }
        return null;
    }

    /* renamed from: b */
    private int m639b(int i) {
        int m640g = m640g();
        if (m640g != 0) {
            return m640g;
        }
        HashMap<String, String> hashMap = this.f391b;
        if (hashMap == null || hashMap.size() == 0) {
            return AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p;
        }
        String str = this.f391b.get("pushSupport");
        if (TextUtils.isEmpty(str)) {
            return 2;
        }
        try {
            return (i & Integer.parseInt(str)) > 0 ? 0 : 1;
        } catch (Exception unused) {
            return AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp;
        }
    }
}
