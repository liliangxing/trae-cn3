package com.bytedance.bdinstall.loader;

import android.os.Environment;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import com.bytedance.common.utility.io.IOUtils;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class DeprecatedFileCleaner implements Runnable {
    private final InstallOptions mOptions;

    public DeprecatedFileCleaner(InstallOptions installOptions) {
        this.mOptions = installOptions;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList<String> arrayList = new ArrayList();
        try {
            arrayList.add(this.mOptions.getContext().getExternalCacheDir().getParent() + "/" + (this.mOptions.isAnonymous() ? "device_id" : StringEncryptUtils.getBytedanceString()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!this.mOptions.isAnonymous()) {
            try {
                arrayList.add(Environment.getExternalStorageDirectory().getPath() + StringEncryptUtils.base64DecodeToString("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                arrayList.add(Environment.getExternalStorageDirectory().getPath() + "/" + StringEncryptUtils.getBytedanceString());
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
        for (String str : arrayList) {
            try {
                IOUtils.deletePath(str);
                DrLog.m143v("dt " + str);
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
        }
    }
}
