package com.ss.android.deviceregister;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.common.utility.io.IOUtils;
import com.ss.android.deviceregister.core.cache.internal.EncryptUtils;
import java.util.ArrayList;

/* loaded from: classes7.dex */
class DeprecatedFileCleaner {
    private final boolean mAnonymous;
    private final Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeprecatedFileCleaner(Context context, boolean z) {
        this.mContext = context;
        this.mAnonymous = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void execute() {
        TTExecutors.getIOThreadPool().submit(new Runnable() { // from class: com.ss.android.deviceregister.DeprecatedFileCleaner.1
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<String> arrayList = new ArrayList();
                try {
                    arrayList.add(DeprecatedFileCleaner.this.mContext.getExternalCacheDir().getParent() + "/" + (DeprecatedFileCleaner.this.mAnonymous ? "device_id" : EncryptUtils.getBytedanceString()));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (!DeprecatedFileCleaner.this.mAnonymous) {
                    try {
                        arrayList.add(Environment.getExternalStorageDirectory().getPath() + EncryptUtils.base64DecodeToString("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    try {
                        arrayList.add(Environment.getExternalStorageDirectory().getPath() + "/" + EncryptUtils.getBytedanceString());
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
                for (String str : arrayList) {
                    try {
                        Log.d("DeprecatedFileCleaner", "dlt " + str);
                        IOUtils.deletePath(str);
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
        });
    }
}
