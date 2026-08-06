package com.xiaomi.push;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public final class s {
    private static final Set<String> a = Collections.synchronizedSet(new HashSet());

    /* renamed from: a, reason: collision with other field name */
    private Context f910a;

    /* renamed from: a, reason: collision with other field name */
    private RandomAccessFile f911a;

    /* renamed from: a, reason: collision with other field name */
    private String f912a;

    /* renamed from: a, reason: collision with other field name */
    private FileLock f913a;

    private s(Context context) {
        this.f910a = context;
    }

    public static s a(Context context, File file) {
        com.xiaomi.channel.commonutils.logger.b.c("Locking: " + file.getAbsolutePath());
        String str = file.getAbsolutePath() + ".LOCK";
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.getParentFile().mkdirs();
            file2.createNewFile();
        }
        Set<String> set = a;
        if (set.add(str)) {
            s sVar = new s(context);
            sVar.f912a = str;
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                sVar.f911a = randomAccessFile;
                sVar.f913a = randomAccessFile.getChannel().lock();
                com.xiaomi.channel.commonutils.logger.b.c("Locked: " + str + " :" + sVar.f913a);
                if (sVar.f913a == null) {
                    RandomAccessFile randomAccessFile2 = sVar.f911a;
                    if (randomAccessFile2 != null) {
                        v.a(randomAccessFile2);
                    }
                    set.remove(sVar.f912a);
                }
                return sVar;
            } catch (Throwable th) {
                if (sVar.f913a == null) {
                    RandomAccessFile randomAccessFile3 = sVar.f911a;
                    if (randomAccessFile3 != null) {
                        v.a(randomAccessFile3);
                    }
                    a.remove(sVar.f912a);
                }
                throw th;
            }
        }
        throw new IOException("abtain lock failure");
    }

    public void a() {
        com.xiaomi.channel.commonutils.logger.b.c("unLock: " + this.f913a);
        FileLock fileLock = this.f913a;
        if (fileLock != null && fileLock.isValid()) {
            try {
                this.f913a.release();
            } catch (IOException unused) {
            }
            this.f913a = null;
        }
        RandomAccessFile randomAccessFile = this.f911a;
        if (randomAccessFile != null) {
            v.a(randomAccessFile);
        }
        a.remove(this.f912a);
    }
}
