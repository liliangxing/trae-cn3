package com.ss.android.common.app.permission;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes7.dex */
public abstract class PermissionsResultAction {
    private static final String TAG = "PermissionsResultAction";
    private Looper mLooper;
    private final Set<String> mPermissions;

    public abstract void onDenied(String str);

    public abstract void onGranted();

    public PermissionsResultAction() {
        this.mPermissions = new HashSet(1);
        this.mLooper = Looper.getMainLooper();
    }

    public PermissionsResultAction(Looper looper) {
        this.mPermissions = new HashSet(1);
        Looper.getMainLooper();
        this.mLooper = looper;
    }

    public synchronized boolean shouldIgnorePermissionNotFound(String str) {
        Log.d(TAG, "Permission not found: " + str);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean onResult(String str, int i) {
        if (i == 0) {
            return onResult(str, Permissions.GRANTED);
        }
        return onResult(str, Permissions.DENIED);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized boolean onResult(final String str, Permissions permissions) {
        Log.d(TAG, str + Constants.COLON_SEPARATOR + permissions);
        this.mPermissions.remove(str);
        if (permissions == Permissions.GRANTED) {
            if (this.mPermissions.isEmpty()) {
                new Handler(this.mLooper).post(new Runnable() { // from class: com.ss.android.common.app.permission.PermissionsResultAction.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PermissionsManager.getInstance().notifyRequestPermissionResultListener(str, 0);
                        PermissionsResultAction.this.onGranted();
                    }
                });
                return true;
            }
        } else {
            if (permissions == Permissions.DENIED) {
                new Handler(this.mLooper).post(new Runnable() { // from class: com.ss.android.common.app.permission.PermissionsResultAction.2
                    @Override // java.lang.Runnable
                    public void run() {
                        PermissionsManager.getInstance().notifyRequestPermissionResultListener(str, 1);
                        PermissionsResultAction.this.onDenied(str);
                    }
                });
                return true;
            }
            if (permissions == Permissions.NOT_FOUND) {
                if (shouldIgnorePermissionNotFound(str)) {
                    if (this.mPermissions.isEmpty()) {
                        new Handler(this.mLooper).post(new Runnable() { // from class: com.ss.android.common.app.permission.PermissionsResultAction.3
                            @Override // java.lang.Runnable
                            public void run() {
                                PermissionsManager.getInstance().notifyRequestPermissionResultListener(str, 2);
                                PermissionsResultAction.this.onGranted();
                            }
                        });
                        return true;
                    }
                } else {
                    new Handler(this.mLooper).post(new Runnable() { // from class: com.ss.android.common.app.permission.PermissionsResultAction.4
                        @Override // java.lang.Runnable
                        public void run() {
                            PermissionsManager.getInstance().notifyRequestPermissionResultListener(str, 1);
                            PermissionsResultAction.this.onDenied(str);
                        }
                    });
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void registerPermissions(String[] strArr) {
        Collections.addAll(this.mPermissions, strArr);
    }
}
