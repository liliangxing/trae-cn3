package com.ss.ttm.player;

import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes7.dex */
public class TTPlayerLibraryLoader {
    private static final int DEGRADED_VERSION = 2925;
    private static final String TAG = "TTPlayerLibraryLoader";
    private static ILibraryLoader mDebugLibraryLoader;
    private static ILibraryLoader mLibraryLoader;
    private static ILibraryLoader mPluginLibLoader;
    private static ILibraryLoader mDefaultLibLoader = new DefaultLibraryLoader();
    private static boolean mLibraryLoaded = false;
    private static boolean IsErrored = false;
    private static String mErrorInfo = null;
    private static int mVersion = 0;

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
        synchronized (TTPlayerLibraryLoader.class) {
            try {
                if (mVersion == 0) {
                    mVersion = TTPlayerConfiger.getValue(13, 0) / 1000;
                }
                boolean z = mVersion == DEGRADED_VERSION;
                if (TTPlayerConfiger.getValue(3, false)) {
                    if (!z) {
                        loadPlayerlibrary("ttopenssl");
                        loadPlayerlibrary("mffmpeg");
                    }
                    if (!loadPlayerlibrary("ttmplayer")) {
                        IsErrored = true;
                    }
                } else {
                    ArrayList arrayList = new ArrayList();
                    if (!z) {
                        arrayList.add("ttopenssl");
                        arrayList.add("mffmpeg");
                    }
                    arrayList.add("ttmplayer");
                    IsErrored = loadLibs(arrayList, false) ? false : true;
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

    public static final void setPluginLibraryLoader(ILibraryLoader loader) {
        mPluginLibLoader = loader;
    }

    public static final void setDebugLibraryLoader(ILibraryLoader loader) {
        mDebugLibraryLoader = loader;
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
            ILibraryLoader iLibraryLoader2 = mPluginLibLoader;
            if (iLibraryLoader2 != null) {
                try {
                    mLibraryLoaded = iLibraryLoader2.onLoadNativeLibs(libs);
                } catch (Throwable th2) {
                    mErrorInfo = th2.getMessage();
                }
            } else {
                mLibraryLoaded = mDefaultLibLoader.onLoadNativeLibs(libs);
            }
        }
        return mLibraryLoaded;
    }

    /* loaded from: classes7.dex */
    private static class DefaultLibraryLoader implements ILibraryLoader {
        private DefaultLibraryLoader() {
        }

        @Override // com.ss.ttm.player.ILibraryLoader
        public boolean onLoadNativeLibs(List<String> list) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                try {
                    System.loadLibrary(it.next());
                } catch (Throwable th) {
                    String unused = TTPlayerLibraryLoader.mErrorInfo = th.getMessage();
                    Log.d(TTPlayerLibraryLoader.TAG, "load lib failed = " + TTPlayerLibraryLoader.mErrorInfo);
                    return false;
                }
            }
            return true;
        }
    }
}
