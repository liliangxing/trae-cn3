package ms.bd.p001c;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/* renamed from: ms.bd.c.t0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0208t0 {

    /* renamed from: a */
    public static final String f397a;

    static {
        f397a = (String) AbstractC0190p2.m166a(16777217, 0, 0L, "05e7d2", new byte[]{44, 50, 24, 71});
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00eb, code lost:
    
        if (r5 != null) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0110 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m192a(String str) {
        Process process;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedInputStream bufferedInputStream2 = null;
        bufferedOutputStream2 = null;
        r4 = null;
        String str2 = null;
        try {
            process = Runtime.getRuntime().exec((String) AbstractC0190p2.m166a(16777217, 0, 0L, "dae412", new byte[]{102, 107}));
        } catch (Exception unused) {
            process = null;
        } catch (Throwable th) {
            th = th;
            process = null;
            bufferedInputStream = null;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(process.getOutputStream());
            try {
                bufferedInputStream = new BufferedInputStream(process.getInputStream());
                try {
                    bufferedOutputStream.write(str.getBytes());
                    bufferedOutputStream.write(10);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    process.waitFor();
                    String m191a = m191a(bufferedInputStream);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException unused2) {
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused3) {
                    }
                    str2 = m191a;
                } catch (Exception unused4) {
                    try {
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused5) {
                            }
                        }
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException unused6) {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream2 = bufferedOutputStream;
                        bufferedOutputStream = bufferedOutputStream2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException unused7) {
                            }
                        }
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException unused8) {
                            }
                        }
                        if (process != null) {
                            throw th;
                        }
                        process.destroy();
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream2 != null) {
                    }
                    if (process != null) {
                    }
                }
            } catch (Exception unused9) {
                bufferedInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                if (bufferedOutputStream != null) {
                }
                if (bufferedInputStream2 != null) {
                }
                if (process != null) {
                }
            }
        } catch (Exception unused10) {
            bufferedOutputStream = null;
            bufferedInputStream = null;
            if (bufferedOutputStream != null) {
            }
            if (bufferedInputStream != null) {
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedInputStream = null;
            bufferedOutputStream = bufferedOutputStream2;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedOutputStream != null) {
            }
            if (bufferedInputStream2 != null) {
            }
            if (process != null) {
            }
        }
        process.destroy();
        return str2;
    }

    /* renamed from: a */
    public static String m191a(BufferedInputStream bufferedInputStream) {
        int read;
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    sb.append(new String(bArr, 0, read));
                }
            } catch (Exception unused) {
            }
        } while (read >= 4096);
        return sb.toString();
    }
}
