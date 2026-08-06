package com.bytedance.bdturing.ttnet;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.TuringLifeCycleListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BdTuringInitProvider extends ContentProvider {
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
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        try {
            TuringLifeCycleListener.getInstance().init(getContext());
            TTNetUtil.addVersionHeaders();
            EventReport.sAppLaunchTime = System.currentTimeMillis();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
