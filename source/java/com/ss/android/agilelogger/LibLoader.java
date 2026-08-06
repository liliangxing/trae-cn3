package com.ss.android.agilelogger;

import com.bytedance.android.alog.ILibLoader;
import com.bytedance.librarian.Librarian;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class LibLoader implements ILibLoader {
    public void loadLibrary(String str) {
        try {
            Librarian.loadLibraryForModule(CloudControlInf.ALOG, ALog.sConfig.getContext());
        } catch (Throwable unused) {
            System.loadLibrary(CloudControlInf.ALOG);
        }
    }
}
