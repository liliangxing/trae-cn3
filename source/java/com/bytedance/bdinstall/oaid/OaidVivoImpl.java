package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.oaid.OaidApi;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class OaidVivoImpl implements OaidApi {
    private static final String ID_PROPERTY = "persist.sys.identifierid.supported";
    private static final String NOT_SUPPORTED = "0";
    private static final String SUPPORTED = "1";
    private static final int TYPE_AAID = 2;
    private static final int TYPE_OAID = 0;
    private static final int TYPE_VAID = 1;
    private static final Singleton<Boolean> support = new Singleton<Boolean>() { // from class: com.bytedance.bdinstall.oaid.OaidVivoImpl.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public Boolean create(Object... objArr) {
            return Boolean.valueOf("1".equals(OaidVivoImpl.getSystemProperties(OaidVivoImpl.ID_PROPERTY, "0")));
        }
    };

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Vivo";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OaidVivoImpl(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSupport() {
        return support.get(new Object[0]).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context context) {
        return isSupport();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
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

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String query(Context context, int i, String str) {
        Uri parse;
        Uri uri;
        Cursor cursor;
        StringBuilder sb;
        String str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        str2 = null;
        Cursor cursor2 = null;
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
                                    DrLog.d("OaidVivo#query" + e);
                                    if (cursor != null) {
                                        try {
                                            cursor.close();
                                        } catch (Exception e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            sb = new StringBuilder("OaidVivo#query close cursor exception.");
                                            DrLog.d(sb.append(e).toString());
                                            return str2;
                                        }
                                    }
                                    return str2;
                                }
                            } catch (Throwable th) {
                                th = th;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    try {
                                        cursor2.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                        DrLog.d("OaidVivo#query close cursor exception." + e3);
                                    }
                                }
                                throw th;
                            }
                        }
                        if (cursor != null) {
                            try {
                                cursor.close();
                            } catch (Exception e4) {
                                e = e4;
                                e.printStackTrace();
                                sb = new StringBuilder("OaidVivo#query close cursor exception.");
                                DrLog.d(sb.append(e).toString());
                                return str2;
                            }
                        }
                    } catch (Exception e5) {
                        e = e5;
                        cursor = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor2 != null) {
                        }
                        throw th;
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
