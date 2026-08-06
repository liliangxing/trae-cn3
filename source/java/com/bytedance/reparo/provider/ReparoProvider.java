package com.bytedance.reparo.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.reparo.constant.Constant;
import com.bytedance.reparo.secondary.Logger;

/* loaded from: classes4.dex */
public class ReparoProvider extends ContentProvider {
    private static final String TAG = "FrankieProvider";

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
    }

    public static void notifySubProcess(Context context) {
        try {
            context.getContentResolver().notifyChange(Constant.getAuthoritiesUri(context), null);
        } catch (Exception e) {
            Logger.e(TAG, "notifySubProcess failed! ", e);
        }
    }
}
