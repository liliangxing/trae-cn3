package com.ss.bytertc.ktv.data;

/* loaded from: classes7.dex */
public enum DownloadLyricType {
    KRC(0),
    LRC(1);

    private int value;

    DownloadLyricType(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

    /* renamed from: com.ss.bytertc.ktv.data.DownloadLyricType$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$ktv$data$DownloadLyricType;

        static {
            int[] iArr = new int[DownloadLyricType.values().length];
            $SwitchMap$com$ss$bytertc$ktv$data$DownloadLyricType = iArr;
            try {
                iArr[DownloadLyricType.KRC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$ktv$data$DownloadLyricType[DownloadLyricType.LRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$ktv$data$DownloadLyricType[ordinal()];
        return i != 1 ? i != 2 ? "" : "DOWNLOAD_LYRIC_TYPE_LRC" : "DOWNLOAD_LYRIC_TYPE_KRC";
    }

    public static DownloadLyricType fromId(int id) {
        for (DownloadLyricType downloadLyricType : values()) {
            if (downloadLyricType.value() == id) {
                return downloadLyricType;
            }
        }
        return null;
    }
}
