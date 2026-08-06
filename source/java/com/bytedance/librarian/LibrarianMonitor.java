package com.bytedance.librarian;

import android.util.Log;
import com.bytedance.librarian.LibrarianImpl;

/* loaded from: classes4.dex */
public class LibrarianMonitor {
    /* JADX INFO: Access modifiers changed from: protected */
    public void logDebug(String str) {
        Log.d(LibrarianImpl.Constants.TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void logWarning(String str) {
        Log.w(LibrarianImpl.Constants.TAG, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void logWarning(String str, Throwable th) {
        Log.w(LibrarianImpl.Constants.TAG, str, th);
    }

    protected void logError(String str) {
        Log.e(LibrarianImpl.Constants.TAG, str);
    }

    protected void logError(String str, Throwable th) {
        Log.e(LibrarianImpl.Constants.TAG, str, th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void systemLoadLibrary(String str) {
        System.loadLibrary(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void systemLoad(String str) {
        System.load(str);
    }
}
