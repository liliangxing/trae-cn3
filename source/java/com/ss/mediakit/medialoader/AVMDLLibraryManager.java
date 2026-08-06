package com.ss.mediakit.medialoader;

import android.util.Log;
import com.bytedance.boringssl.so.BoringsslLoaderWrapper;

/* loaded from: classes7.dex */
class AVMDLLibraryManager {
    private static final String BaseLibName = "avmdlbase";
    private static final String CryptoName = "ttcrypto";
    public static final int MediaLoadBase = 4;
    public static final int MediaLoadBoringssl = 32;
    public static final int MediaLoadP2P = 1;
    public static final int MediaLoadTTNet = 2;
    public static final int MediaLoadV1 = 8;
    public static final int MediaLoadV2 = 16;
    public static final int MediaLoadVcn = 64;
    private static final String P2PLibName = "avmdlp2p";
    private static final String SSLName = "ttboringssl";
    private static final String ShadowVerName = "avmdls";
    private static final String TTNetLibName = "avmdlttnet";
    private static final String V1LibName = "avmdl";
    private static final String V2LibName = "avmdlv2";
    private static final String VcnName = "vcn";
    private static boolean dependBoringSSl = true;
    private static boolean dependVcn = true;
    private static boolean enableV2 = false;
    private static IAVMDLLibraryLoader libraryLoader = null;
    private static int loadLevel = 0;
    private static boolean needBase = true;
    private static boolean needP2PLib;
    private static boolean needTTnetLib;
    private static boolean useShadowVersion;

    AVMDLLibraryManager() {
    }

    private static boolean shouldLoadLib(int i) {
        return libraryLoader != null && i > 0 && (loadLevel & i) == i;
    }

    private static boolean tryLoadLibray(int i) {
        String str;
        boolean z = false;
        boolean z2 = true;
        if (i == 1) {
            str = P2PLibName;
        } else if (i == 2) {
            str = TTNetLibName;
        } else if (i == 4) {
            str = BaseLibName;
        } else if (i == 8) {
            str = V1LibName;
        } else {
            if (i != 16) {
                return false;
            }
            str = useShadowVersion ? ShadowVerName : V2LibName;
        }
        if (shouldLoadLib(i)) {
            z = libraryLoader.loadLibrary(str);
            Log.e("ttmn", "tryLoadLibray " + str + " result: " + z);
        }
        if (!z) {
            try {
                System.loadLibrary(str);
            } catch (Throwable th) {
                Log.e("ttmn", "Can't load " + str + ", cause: " + th);
            }
            Log.e("ttmn", "load lib " + str + " result : " + z2);
            return z2;
        }
        z2 = z;
        Log.e("ttmn", "load lib " + str + " result : " + z2);
        return z2;
    }

    private static boolean tryLoadSSL() {
        boolean z;
        if (shouldLoadLib(32)) {
            z = libraryLoader.loadLibrary(CryptoName);
            if (z) {
                z = libraryLoader.loadLibrary(SSLName);
            }
        } else {
            z = false;
        }
        if (z) {
            return z;
        }
        try {
            if (!dependBoringSSl) {
                return z;
            }
            if (!BoringsslLoaderWrapper.loadBoringssl()) {
                Log.e("ttmn", "load boringssl fail!");
            }
            return true;
        } catch (Exception e) {
            Log.e("ttmn", "load ssl failed: " + e);
            return z;
        }
    }

    private static boolean tryLoadVcn() {
        if (!dependVcn) {
            return true;
        }
        boolean loadLibrary = shouldLoadLib(64) ? libraryLoader.loadLibrary(VcnName) : false;
        if (!loadLibrary) {
            Log.e("ttmn", "Can't load vcn ");
        }
        return loadLibrary;
    }

    public static synchronized void setLibraryLoadLevel(int i) {
        synchronized (AVMDLLibraryManager.class) {
            loadLevel = i;
        }
    }

    public static synchronized void setBoringSSLDependency(boolean z) {
        synchronized (AVMDLLibraryManager.class) {
            dependBoringSSl = z;
        }
    }

    public static synchronized void setVcnDependency(boolean z) {
        synchronized (AVMDLLibraryManager.class) {
            dependVcn = z;
        }
    }

    public static synchronized void setEnableV2(boolean z) {
        synchronized (AVMDLLibraryManager.class) {
            enableV2 = z;
        }
    }

    public static synchronized void setLibraryLoader(IAVMDLLibraryLoader iAVMDLLibraryLoader) {
        synchronized (AVMDLLibraryManager.class) {
            libraryLoader = iAVMDLLibraryLoader;
        }
    }

    public static synchronized void setNeedBase(boolean z) {
        synchronized (AVMDLLibraryManager.class) {
            needBase = z;
        }
    }

    public static synchronized void setNeedP2PLib(boolean z) {
        synchronized (AVMDLLibraryManager.class) {
            needP2PLib = z;
        }
    }

    public static synchronized void setNeedTTnetLib(boolean z) {
        synchronized (AVMDLLibraryManager.class) {
            needTTnetLib = z;
        }
    }

    public static synchronized void setUseShadowVersion(boolean z) {
        synchronized (AVMDLLibraryManager.class) {
            useShadowVersion = z;
        }
    }

    public static synchronized boolean loadLibraries() {
        boolean z;
        synchronized (AVMDLLibraryManager.class) {
            tryLoadSSL();
            tryLoadVcn();
            if (needBase) {
                tryLoadLibray(4);
            }
            z = false;
            if (enableV2) {
                boolean tryLoadLibray = tryLoadLibray(16);
                if (tryLoadLibray || !useShadowVersion) {
                    z = tryLoadLibray;
                } else {
                    useShadowVersion = false;
                    z = tryLoadLibray(16);
                }
            }
            if (!z) {
                z = tryLoadLibray(8);
                if (needP2PLib) {
                    tryLoadLibray(1);
                }
                if (needTTnetLib) {
                    tryLoadLibray(2);
                }
            }
        }
        return z;
    }
}
