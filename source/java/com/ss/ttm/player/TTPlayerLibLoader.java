package com.ss.ttm.player;

import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import com.ss.android.socialbase.appdownloader.ah.DevicePlans;
import com.ss.ttffmpeg.BuildConfig;
import com.ss.ttm.vcshared.VCBaseKitLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class TTPlayerLibLoader {
    private static final int DEGRADED_VERSION = 2925;
    private static final String TAG = "TTPlayerLibLoader";
    private static ILibraryLoader mDebugLibraryLoader;
    private static ILibraryLoader mLibraryLoader;
    private static ILibraryLoader mDefaultLibLoader = new DefaultLibraryLoader();
    private static boolean mLibraryLoaded = false;
    private static boolean IsErrored = false;
    private static String mErrorInfo = null;
    private static int mVersion = 0;
    private static String playerLibName = "";

    private static boolean loadPlayerlibrary(String libName) {
        String str;
        try {
            TTPlayerConfiger.setLibraryName(LibrarianImpl.Constants.LIB_PREFIX + libName + LibrarianImpl.Constants.SO_SUFFIX);
            TTPlayerConfiger.checkDebugTTPlayerLib();
            str = TTPlayerConfiger.getPlayerLibraryPath();
            if (str != null && !new File(str).exists()) {
                str = null;
            }
            if (str != null) {
                if (mDebugLibraryLoader != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(str);
                    Log.d(TAG, "load library path = " + str);
                    mDebugLibraryLoader.onLoadNativeLibs(arrayList);
                } else {
                    System.load(str);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            mErrorInfo = "load path library error." + th.toString();
            str = null;
        }
        if (str == null) {
            try {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(libName);
                loadLibs(arrayList2, true);
                mErrorInfo = null;
            } catch (Throwable unused) {
                Log.e(TAG, "load lib failed name = " + libName);
                return false;
            }
        }
        return true;
    }

    public static final synchronized void loadLibrary() {
        synchronized (TTPlayerLibLoader.class) {
            try {
                if (mVersion == 0) {
                    mVersion = TTPlayerConfiger.getValue(13, 0) / 1000;
                }
                VCBaseKitLoader.loadLibrary();
                Log.d(TAG, "pgo player setting = " + TTPlayerConfiger.getValue(76, ""));
                boolean z = mVersion == DEGRADED_VERSION;
                if (TTPlayerConfiger.getValue(3, false)) {
                    if (!z) {
                        if (!TTPlayerConfiger.getValue(30, false)) {
                            System.loadLibrary("c++_shared");
                        }
                        if (!TTPlayerConfiger.getValue(28, false)) {
                            loadPlayerlibrary("ttcrypto");
                            loadPlayerlibrary("ttboringssl");
                        }
                        loadPlayerlibrary("ByteVC1_dec");
                        loadPlayerlibrary(BuildConfig.FFMPEG_LIBNAME);
                    }
                    if (TTPlayerConfiger.getValue(29, false)) {
                        if (!loadPlayerlibrary("ttmplayerbeta")) {
                            IsErrored = loadPlayerlibrary("ttmplayer") ? false : true;
                        } else {
                            playerLibName = "ttmplayerbeta";
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("default")) {
                        if (!loadPlayerlibrary("ttmplayerdef")) {
                            IsErrored = loadPlayerlibrary("ttmplayer") ? false : true;
                        } else {
                            playerLibName = "ttmplayerdef";
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("pgo")) {
                        if (!loadPlayerlibrary("ttmplayerpgo")) {
                            IsErrored = loadPlayerlibrary("ttmplayer") ? false : true;
                        } else {
                            playerLibName = "ttmplayerpgo";
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("bytepgo")) {
                        if (!loadPlayerlibrary("ttmplayerbytepgo")) {
                            IsErrored = loadPlayerlibrary("ttmplayer") ? false : true;
                        } else {
                            playerLibName = "ttmplayerbytepgo";
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals(DevicePlans.DEVICE_PLAN_OPPO3)) {
                        if (!loadPlayerlibrary("ttmplayero3")) {
                            IsErrored = loadPlayerlibrary("ttmplayer") ? false : true;
                        } else {
                            playerLibName = "ttmplayero3";
                        }
                    } else if (!loadPlayerlibrary("ttmplayer")) {
                        IsErrored = true;
                    }
                    if (!IsErrored && playerLibName.isEmpty()) {
                        playerLibName = "ttmplayer";
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (!z) {
                        if (!TTPlayerConfiger.getValue(30, false)) {
                            arrayList.add("c++_shared");
                        }
                        if (!TTPlayerConfiger.getValue(28, false)) {
                            arrayList.add("ttcrypto");
                            arrayList.add("ttboringssl");
                        }
                        arrayList.add("ByteVC1_dec");
                        arrayList.add(BuildConfig.FFMPEG_LIBNAME);
                    }
                    if (TTPlayerConfiger.getValue(29, false)) {
                        boolean z2 = !loadLibs(arrayList, false);
                        IsErrored = z2;
                        if (!z2) {
                            arrayList.clear();
                            arrayList.add("ttmplayerbeta");
                            boolean z3 = !loadLibs(arrayList, true);
                            IsErrored = z3;
                            if (!z3) {
                                playerLibName = "ttmplayerbeta";
                            } else {
                                arrayList.clear();
                                arrayList.add("ttmplayer");
                                IsErrored = loadLibs(arrayList, true) ? false : true;
                            }
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("default")) {
                        boolean z4 = !loadLibs(arrayList, false);
                        IsErrored = z4;
                        if (!z4) {
                            arrayList.clear();
                            arrayList.add("ttmplayerdef");
                            boolean z5 = !loadLibs(arrayList, true);
                            IsErrored = z5;
                            if (!z5) {
                                playerLibName = "ttmplayerdef";
                            } else {
                                arrayList.clear();
                                arrayList.add("ttmplayer");
                                IsErrored = loadLibs(arrayList, true) ? false : true;
                            }
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("pgo")) {
                        boolean z6 = !loadLibs(arrayList, false);
                        IsErrored = z6;
                        if (!z6) {
                            arrayList.clear();
                            arrayList.add("ttmplayerpgo");
                            boolean z7 = !loadLibs(arrayList, true);
                            IsErrored = z7;
                            if (!z7) {
                                playerLibName = "ttmplayerpgo";
                            } else {
                                arrayList.clear();
                                arrayList.add("ttmplayer");
                                IsErrored = loadLibs(arrayList, true) ? false : true;
                            }
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals("bytepgo")) {
                        boolean z8 = !loadLibs(arrayList, false);
                        IsErrored = z8;
                        if (!z8) {
                            arrayList.clear();
                            arrayList.add("ttmplayerbytepgo");
                            boolean z9 = !loadLibs(arrayList, true);
                            IsErrored = z9;
                            if (!z9) {
                                playerLibName = "ttmplayerbytepgo";
                            } else {
                                arrayList.clear();
                                arrayList.add("ttmplayer");
                                IsErrored = loadLibs(arrayList, true) ? false : true;
                            }
                        }
                    } else if (TTPlayerConfiger.getValue(76, "").equals(DevicePlans.DEVICE_PLAN_OPPO3)) {
                        boolean z10 = !loadLibs(arrayList, false);
                        IsErrored = z10;
                        if (!z10) {
                            arrayList.clear();
                            arrayList.add("ttmplayero3");
                            boolean z11 = !loadLibs(arrayList, true);
                            IsErrored = z11;
                            if (!z11) {
                                playerLibName = "ttmplayero3";
                            } else {
                                arrayList.clear();
                                arrayList.add("ttmplayer");
                                IsErrored = loadLibs(arrayList, true) ? false : true;
                            }
                        }
                    } else {
                        arrayList.add("ttmplayer");
                        IsErrored = loadLibs(arrayList, false) ? false : true;
                    }
                    if (!IsErrored && playerLibName.isEmpty()) {
                        playerLibName = "ttmplayer";
                    }
                }
            } catch (Throwable th) {
                IsErrored = true;
                th.printStackTrace();
                mErrorInfo = "load default library error." + th.toString();
            }
        }
    }

    public static boolean isError() {
        return IsErrored;
    }

    public static String getErrorInfo() {
        return mErrorInfo;
    }

    public static final void setLibraryLoader(ILibraryLoader loader) {
        mLibraryLoader = loader;
    }

    public static final void setDebugLibraryLoader(ILibraryLoader loader) {
        mDebugLibraryLoader = loader;
    }

    public static String getPlayerLibName() {
        return playerLibName;
    }

    private static boolean loadLibs(List<String> libs, boolean forceLoad) {
        boolean z = mLibraryLoaded;
        if ((!forceLoad) && z) {
            return z;
        }
        ILibraryLoader iLibraryLoader = mLibraryLoader;
        if (iLibraryLoader != null) {
            try {
                mLibraryLoaded = iLibraryLoader.onLoadNativeLibs(libs);
            } catch (Throwable th) {
                mErrorInfo = th.getMessage();
            }
        } else {
            mLibraryLoaded = mDefaultLibLoader.onLoadNativeLibs(libs);
        }
        return mLibraryLoaded;
    }

    /* loaded from: classes7.dex */
    private static class DefaultLibraryLoader implements ILibraryLoader {
        private DefaultLibraryLoader() {
        }

        @Override // com.ss.ttm.player.ILibraryLoader
        public boolean onLoadNativeLibs(List<String> list) {
            for (String str : list) {
                try {
                    System.loadLibrary(str);
                    Log.d(TTPlayerLibLoader.TAG, "main load " + str + " done");
                } catch (Throwable th) {
                    String unused = TTPlayerLibLoader.mErrorInfo = th.getMessage();
                    Log.d(TTPlayerLibLoader.TAG, "main load lib failed = " + str + ",error:" + TTPlayerLibLoader.mErrorInfo);
                    return false;
                }
            }
            return true;
        }
    }
}
