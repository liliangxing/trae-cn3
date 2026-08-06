package com.lynx.tasm.core;

import android.text.TextUtils;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ResourceLoader {
    private static final String ASSETS_SCHEME = "assets://";
    private static final String CORE_DEBUG_JS = "lynx_core_dev.js";
    private static final String CORE_JS = "assets://lynx_core.js";
    private static final String FILE_SCHEME = "file://";
    private static final String LYNX_ASSETS_SCHEME = "lynx_assets://";
    private static final String TAG = "ResourceLoader";

    private native void nativeConfigLynxResourceSetting();

    private byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00dc, code lost:
    
        if (r1 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0108, code lost:
    
        com.lynx.tasm.base.LLog.e(com.lynx.tasm.core.ResourceLoader.TAG, "loadJSSource failed, can not load " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x011a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00de, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0105, code lost:
    
        if (r1 == null) goto L57;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] loadJSSource(String str) {
        InputStream inputStream;
        File file;
        InputStream inputStream2 = null;
        if (TextUtils.isEmpty(str)) {
            LLog.w(TAG, "loadJSSource failed with empty name");
            return null;
        }
        String str2 = "loadJSSource with name " + str;
        LLog.i(TAG, str2);
        try {
            try {
                try {
                    if (CORE_JS.equals(str) && LynxEnv.inst().isDevtoolEnabled()) {
                        try {
                            inputStream = LynxEnv.inst().getAppContext().getResources().getAssets().open(CORE_DEBUG_JS);
                        } catch (IOException e) {
                            e.printStackTrace();
                            inputStream = null;
                        }
                        if (inputStream != null) {
                            try {
                                nativeConfigLynxResourceSetting();
                            } catch (IOException e2) {
                                e = e2;
                                LLog.e(TAG, "loadJSSource " + str + "with error message " + e.getMessage());
                            }
                        }
                    } else {
                        inputStream = null;
                    }
                    if (inputStream == null) {
                        if (str.length() > 7 && str.startsWith("file://")) {
                            String substring = str.substring(7);
                            if (substring.startsWith("/")) {
                                file = new File(substring);
                            } else {
                                file = new File(LynxEnv.inst().getAppContext().getFilesDir(), substring);
                            }
                            inputStream = new FileInputStream(file);
                        } else if (str.length() > 9 && str.startsWith(ASSETS_SCHEME)) {
                            inputStream = LynxEnv.inst().getAppContext().getResources().getAssets().open(str.substring(9));
                        } else if (str.startsWith(LYNX_ASSETS_SCHEME)) {
                            byte[] loadLynxJSAsset = loadLynxJSAsset(str);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            return loadLynxJSAsset;
                        }
                    }
                    if (inputStream != null) {
                        byte[] byteArray = toByteArray(inputStream);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return byteArray;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                inputStream = null;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = str2;
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00ef: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:57:0x00ef */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006f A[Catch: IOException -> 0x006b, all -> 0x00ee, TRY_LEAVE, TryCatch #7 {all -> 0x00ee, blocks: (B:38:0x0056, B:9:0x006f, B:21:0x00af), top: B:2:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] loadLynxJSAsset(String str) {
        InputStream inputStream;
        InputStream inputStream2;
        StringBuilder sb;
        IOException e;
        String[] split;
        String substring = str.substring(14);
        InputStream inputStream3 = null;
        try {
            try {
                try {
                } catch (Throwable th) {
                    th = th;
                    if (inputStream3 != null) {
                        try {
                            inputStream3.close();
                        } catch (IOException e2) {
                            LLog.e(TAG, "loadLynxJSAsset inputStream close error: " + e2.getMessage());
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                inputStream2 = null;
            }
            if (LynxEnv.inst().isDevtoolEnabled()) {
                try {
                    split = substring.split("\\.");
                } catch (IOException unused) {
                }
                if (split.length == 2) {
                    inputStream2 = LynxEnv.inst().getAppContext().getResources().getAssets().open(split[0] + "_dev." + split[1]);
                    if (inputStream2 == null) {
                        try {
                            inputStream2 = LynxEnv.inst().getAppContext().getResources().getAssets().open(substring);
                        } catch (IOException e4) {
                            e = e4;
                            LLog.e(TAG, "loadLynxJSAsset " + str + "with error message " + e.getMessage());
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (IOException e5) {
                                    e = e5;
                                    sb = new StringBuilder("loadLynxJSAsset inputStream close error: ");
                                    LLog.e(TAG, sb.append(e.getMessage()).toString());
                                    LLog.e(TAG, "loadLynxJSAsset failed, can not load " + str);
                                    return null;
                                }
                            }
                            LLog.e(TAG, "loadLynxJSAsset failed, can not load " + str);
                            return null;
                        }
                    }
                    if (inputStream2 == null) {
                        byte[] byteArray = toByteArray(inputStream2);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (IOException e6) {
                                LLog.e(TAG, "loadLynxJSAsset inputStream close error: " + e6.getMessage());
                            }
                        }
                        return byteArray;
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e7) {
                            e = e7;
                            sb = new StringBuilder("loadLynxJSAsset inputStream close error: ");
                            LLog.e(TAG, sb.append(e.getMessage()).toString());
                            LLog.e(TAG, "loadLynxJSAsset failed, can not load " + str);
                            return null;
                        }
                    }
                    LLog.e(TAG, "loadLynxJSAsset failed, can not load " + str);
                    return null;
                }
            }
            inputStream2 = null;
            if (inputStream2 == null) {
            }
            if (inputStream2 == null) {
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream3 = inputStream;
        }
    }
}
