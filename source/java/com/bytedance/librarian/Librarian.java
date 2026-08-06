package com.bytedance.librarian;

import android.content.Context;
import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;

/* loaded from: classes4.dex */
public class Librarian {
    static Context sContext;
    private static final Object sLock = new Object();
    static LibrarianMonitor sMonitor;
    static volatile String sVersion;

    public static void init(Context context, String str, LibrarianMonitor librarianMonitor) {
        synchronized (sLock) {
            if (sVersion != null) {
                Log.w(LibrarianImpl.Constants.TAG, "already set init, just skip...");
            } else {
                if (context == null || str == null) {
                    throw new IllegalStateException("context or version is null in init");
                }
                sContext = context;
                sVersion = str;
                sMonitor = librarianMonitor;
            }
        }
    }

    public static void loadLibrary(String str) {
        loadLibraryInternal(str, false, false, null);
    }

    public static void loadLibraryForModule(String str, Context context) {
        loadLibraryInternal(str, false, true, context);
    }

    public static void loadLibraryRecursively(String str) {
        loadLibraryInternal(str, true, false, null);
    }

    public static void loadLibraryForModuleRecursively(String str, Context context) {
        loadLibraryInternal(str, true, true, context);
    }

    private static void loadLibraryInternal(String str, boolean z, boolean z2, Context context) {
        if (z2 && sContext == null) {
            sContext = context;
        }
        LibrarianImpl librarianImpl = LibrarianImpl.instance;
        if (librarianImpl != null) {
            librarianImpl.loadLibrary(str, z);
            return;
        }
        LibrarianMonitor librarianMonitor = sMonitor;
        if (librarianMonitor != null) {
            librarianMonitor.systemLoadLibrary(str);
        } else {
            System.loadLibrary(str);
        }
    }

    public static UnsatisfiedLinkError[] getErrors() {
        return LibrarianUnsatisfiedLinkError.getErrors();
    }

    public static String getInnerInfo() {
        LibrarianImpl librarianImpl = LibrarianImpl.instance;
        if (librarianImpl != null) {
            return sVersion + librarianImpl.getLoadedLibsInfo();
        }
        return sVersion;
    }
}
