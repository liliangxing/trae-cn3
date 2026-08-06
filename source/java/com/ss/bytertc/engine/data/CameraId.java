package com.ss.bytertc.engine.data;

/* loaded from: classes7.dex */
public enum CameraId {
    CAMERA_ID_FRONT(0),
    CAMERA_ID_BACK(1),
    CAMERA_ID_EXTERNAL(2),
    CAMERA_ID_INVALID(3);

    private int value;

    CameraId(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.engine.data.CameraId$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$data$CameraId;

        static {
            int[] iArr = new int[CameraId.values().length];
            $SwitchMap$com$ss$bytertc$engine$data$CameraId = iArr;
            try {
                iArr[CameraId.CAMERA_ID_FRONT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$data$CameraId[CameraId.CAMERA_ID_BACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$data$CameraId[ordinal()];
        return i != 1 ? i != 2 ? "" : "kCameraIDBack" : "kCameraIDFront";
    }

    public static CameraId fromId(int id) {
        for (CameraId cameraId : values()) {
            if (cameraId.value() == id) {
                return cameraId;
            }
        }
        return null;
    }
}
