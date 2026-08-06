package com.ss.bytertc.ktv.data;

/* loaded from: classes7.dex */
public enum DownloadFileType {
    MUSIC(1),
    KRC(2),
    LRC(3),
    MIDI(4);

    private int value;

    DownloadFileType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.ktv.data.DownloadFileType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType;

        static {
            int[] iArr = new int[DownloadFileType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType = iArr;
            try {
                iArr[DownloadFileType.MUSIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType[DownloadFileType.KRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType[DownloadFileType.LRC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType[DownloadFileType.MIDI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$DownloadFileType[ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "DOWNLOAD_FILE_TYPE_MIDI" : "DOWNLOAD_FILE_TYPE_LRC" : "DOWNLOAD_FILE_TYPE_KRC" : "DOWNLOAD_FILE_TYPE_MUSIC";
    }

    public static DownloadFileType fromId(int id) {
        for (DownloadFileType downloadFileType : values()) {
            if (downloadFileType.value() == id) {
                return downloadFileType;
            }
        }
        return null;
    }
}
