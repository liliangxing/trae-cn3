package com.bytedance.librarian;

import java.util.ArrayList;

/* loaded from: classes4.dex */
class LibrarianUnsatisfiedLinkError extends UnsatisfiedLinkError {
    private static final ArrayList<LibrarianUnsatisfiedLinkError> sErrors = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LibrarianUnsatisfiedLinkError(String str) {
        super(str);
        ArrayList<LibrarianUnsatisfiedLinkError> arrayList = sErrors;
        synchronized (arrayList) {
            arrayList.add(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LibrarianUnsatisfiedLinkError(String str, Throwable th) {
        super(str);
        initCause(th);
        ArrayList<LibrarianUnsatisfiedLinkError> arrayList = sErrors;
        synchronized (arrayList) {
            arrayList.add(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnsatisfiedLinkError[] getErrors() {
        UnsatisfiedLinkError[] unsatisfiedLinkErrorArr;
        ArrayList<LibrarianUnsatisfiedLinkError> arrayList = sErrors;
        synchronized (arrayList) {
            unsatisfiedLinkErrorArr = (UnsatisfiedLinkError[]) arrayList.toArray(new UnsatisfiedLinkError[0]);
        }
        return unsatisfiedLinkErrorArr;
    }
}
