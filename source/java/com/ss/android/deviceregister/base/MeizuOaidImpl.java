package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.ss.android.deviceregister.base.OaidApi;
import com.ss.android.deviceregister.utils.Singleton;

/* loaded from: classes7.dex */
final class MeizuOaidImpl implements OaidApi {
    private Singleton<Boolean> isSupport = new Singleton<Boolean>() { // from class: com.ss.android.deviceregister.base.MeizuOaidImpl.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ss.android.deviceregister.utils.Singleton
        public Boolean create(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception unused) {
            }
            return false;
        }
    };

    @Override // com.ss.android.deviceregister.base.OaidApi
    public String getName(Context context) {
        return "Meizu";
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        return this.isSupport.get(context).booleanValue();
    }

    @Override // com.ss.android.deviceregister.base.OaidApi
    public OaidApi.Result getOaid(Context context) {
        Cursor cursor;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursor == null) {
                return null;
            }
            try {
                OaidApi.Result result = new OaidApi.Result();
                result.oaid = getOaid(cursor);
                if (cursor != null) {
                    cursor.close();
                }
                return result;
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private String getOaid(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex("value");
        if (columnIndex >= 0) {
            return cursor.getString(columnIndex);
        }
        return null;
    }
}
