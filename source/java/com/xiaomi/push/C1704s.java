package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.xiaomi.push.s */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1704s {

    /* renamed from: a */
    private static final Set<String> f2837a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a */
    private Context f2838a;

    /* renamed from: a */
    private RandomAccessFile f2839a;

    /* renamed from: a */
    private String f2840a;

    /* renamed from: a */
    private FileLock f2841a;

    private C1704s(Context context) {
        this.f2838a = context;
    }

    /* renamed from: a */
    public static C1704s m3478a(Context context, File file) {
        AbstractC1417b.m1101c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = f2837a;
        if (set.add(str)) {
            C1704s c1704s = new C1704s(context);
            c1704s.f2840a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                c1704s.f2839a = randomAccessFile;
                c1704s.f2841a = randomAccessFile.getChannel().lock();
                AbstractC1417b.m1101c("Locked: " + str + " :" + c1704s.f2841a);
                if (c1704s.f2841a == null) {
                    RandomAccessFile randomAccessFile2 = c1704s.f2839a;
                    if (randomAccessFile2 != null) {
                        C1801v.m4105a(randomAccessFile2);
                    }
                    set.remove(c1704s.f2840a);
                }
                return c1704s;
            } catch (Throwable th) {
                if (c1704s.f2841a == null) {
                    RandomAccessFile randomAccessFile3 = c1704s.f2839a;
                    if (randomAccessFile3 != null) {
                        C1801v.m4105a(randomAccessFile3);
                    }
                    f2837a.remove(c1704s.f2840a);
                }
                throw th;
            }
        }
        throw new IOException("abtain lock failure");
    }

    /* renamed from: a */
    public void m3479a() {
        AbstractC1417b.m1101c("unLock: " + this.f2841a);
        FileLock fileLock = this.f2841a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f2841a.release();
            } catch (IOException unused) {
            }
            this.f2841a = null;
        }
        RandomAccessFile randomAccessFile = this.f2839a;
        if (randomAccessFile != null) {
            C1801v.m4105a(randomAccessFile);
        }
        f2837a.remove(this.f2840a);
    }
}
