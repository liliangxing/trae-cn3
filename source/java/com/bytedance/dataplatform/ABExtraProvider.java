package com.bytedance.dataplatform;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.dataplatform.ExperimentPanel;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ABExtraProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Context context = getContext();
        try {
            Bundle bundle = context.getPackageManager().getProviderInfo(new ComponentName(context.getPackageName(), ABExtraProvider.class.getName()), 128).metaData;
            if (bundle == null) {
                return true;
            }
            HashMap hashMap = new HashMap();
            for (String str : bundle.keySet()) {
                if ("____libra____ab____panel".equals(str)) {
                    if (bundle.getBoolean(str, false)) {
                        ExperimentPanel.setExperimentPanel((ExperimentPanel.IExperimentPanel) Class.forName("com.bytedance.dataplatform.ExperimentPanelDataManager").getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
                    }
                } else {
                    Object obj = bundle.get(str);
                    if (obj != null) {
                        hashMap.put(str, obj.toString());
                    }
                }
            }
            ExperimentManager.addExtraParameter(hashMap);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }
}
