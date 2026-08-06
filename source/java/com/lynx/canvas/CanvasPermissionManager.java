package com.lynx.canvas;

import com.lynx.canvas.KryptonPermissionService;
import java.util.LinkedList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class CanvasPermissionManager {
    private static final String TAG = "KryptonCanvasPermissionManager";

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeOnUserMediaPermissionResponse(long j, boolean z);

    private static boolean RequestUserMediaGranted(KryptonApp kryptonApp, boolean z, boolean z2) {
        return DoRequest(kryptonApp, z, z2, null);
    }

    private static void RequestUserMediaPermission(KryptonApp kryptonApp, final boolean z, final boolean z2, final long j) {
        DoRequest(kryptonApp, z, z2, new KryptonPermissionService.Responder() { // from class: com.lynx.canvas.CanvasPermissionManager.1
            @Override // com.lynx.canvas.KryptonPermissionService.Responder
            public void onResponse(boolean z3) {
                KryptonLLog.m2561i(CanvasPermissionManager.TAG, "request permission video:" + z + " audio:" + z2 + " result " + z3);
                CanvasPermissionManager.nativeOnUserMediaPermissionResponse(j, z3);
            }
        });
    }

    private static boolean DoRequest(KryptonApp kryptonApp, boolean z, boolean z2, KryptonPermissionService.Responder responder) {
        if (kryptonApp == null || !kryptonApp.isNativeReady()) {
            return false;
        }
        KryptonPermissionService kryptonPermissionService = (KryptonPermissionService) kryptonApp.getService(KryptonPermissionService.class);
        if (kryptonPermissionService == null) {
            if (responder != null) {
                KryptonLLog.m2561i(TAG, "request permission video:" + z + " audio:" + z2 + " force allow, no permission service found");
                responder.onResponse(true);
            }
            return true;
        }
        LinkedList linkedList = new LinkedList();
        if (z) {
            linkedList.add(KryptonPermissionService.PermissionType.CAMERA);
        }
        if (z2) {
            linkedList.add(KryptonPermissionService.PermissionType.RECORD_AUDIO);
        }
        if (kryptonPermissionService.requestGranted(linkedList)) {
            if (responder != null) {
                responder.onResponse(true);
            }
            return true;
        }
        if (responder == null) {
            return false;
        }
        kryptonPermissionService.requestPermission(linkedList, responder);
        return true;
    }
}
