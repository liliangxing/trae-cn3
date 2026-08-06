package com.ss.android.deviceregister.base;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.ss.android.deviceregister.LogUtils;
import com.ss.android.deviceregister.base.OaidApi;
import com.ss.android.deviceregister.utils.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class OaidVivoImpl implements OaidApi {
    private static final String ID_PROPERTY = "persist.sys.identifierid.supported";
    private static final String NOT_SUPPORTED = "0";
    private static final String SUPPORTED = "1";
    private static final int TYPE_AAID = 2;
    private static final int TYPE_OAID = 0;
    private static final int TYPE_VAID = 1;
    private static final Singleton<Boolean> support = new Singleton<Boolean>() { // from class: com.ss.android.deviceregister.base.OaidVivoImpl.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ss.android.deviceregister.utils.Singleton
        public Boolean create(Object... objArr) {
            return Boolean.valueOf("1".equals(OaidVivoImpl.getSystemProperties(OaidVivoImpl.ID_PROPERTY, "0")));
        }
    };

    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return "Vivo";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSupport() {
        return support.get(new Object[0]).booleanValue();
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public boolean support(Context context) {
        return isSupport();
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public OaidApi.Result getOaid(Context context) {
        OaidApi.Result result = new OaidApi.Result();
        result.oaid = query(context, 0, null);
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getSystemProperties(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(2:5|(4:7|8|(4:12|13|(3:19|20|(1:22))|(2:16|17))|10)(1:44))(1:46))(1:47)|45|8|(0)|10|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0066, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0067, code lost:
    
        r8.printStackTrace();
        com.ss.android.deviceregister.LogUtils.d(com.ss.android.deviceregister.LogUtils.TAG, "OaidVivo#query close cursor exception.", r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0088 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String query(Context context, int i, String str) {
        Uri parse;
        Uri uri;
        Cursor cursor;
        String str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        Cursor cursor2 = null;
        str2 = null;
        if (i == 0) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i == 1) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else {
            if (i != 2) {
                uri = null;
                if (uri != null) {
                    try {
                        cursor = context.getContentResolver().query(uri, null, null, null, null);
                        if (cursor != null) {
                            try {
                                try {
                                    if (cursor.moveToNext()) {
                                        str2 = cursor.getString(cursor.getColumnIndex("value"));
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    e.printStackTrace();
                                    LogUtils.d(LogUtils.TAG, "OaidVivo#query", e);
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return str2;
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        LogUtils.d(LogUtils.TAG, "OaidVivo#query close cursor exception.", e2);
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor2 != null) {
                        }
                        throw th;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                return str2;
            }
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        }
        uri = parse;
        if (uri != null) {
        }
        return str2;
    }
}
