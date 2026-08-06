package com.lynx.canvas;

import java.util.List;

/* loaded from: classes6.dex */
public abstract class KryptonPermissionService extends KryptonService {

    /* loaded from: classes6.dex */
    public enum PermissionType {
        CAMERA,
        RECORD_AUDIO
    }

    /* loaded from: classes6.dex */
    public interface Responder {
        void onResponse(boolean z);
    }

    public abstract boolean requestGranted(List<PermissionType> list);

    public abstract void requestPermission(List<PermissionType> list, Responder responder);
}
