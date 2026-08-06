package com.bytedance.realx.video;

/* compiled from: RXVideoCodecDesc.java */
/* loaded from: classes4.dex */
enum RXVideoCodecProfile {
    Unknown(0),
    ProfileConstrainedBaseline(1),
    ProfileBaseline(2),
    ProfileMain(3),
    ProfileConstrainedHigh(4),
    ProfileHigh(5),
    ByteVC1ProfileUnknown(10),
    ByteVC1ProfileMain(11),
    ByteVC1ProfileMain10(12),
    VP8ProfileMain(80),
    ByteVC1ProfileMain10HDR10(100),
    ByteVC1ProfileMax(128);

    private int value;

    RXVideoCodecProfile(int value) {
        this.value = value;
    }

    public int toInt() {
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RXVideoCodecProfile fromValue(int value) {
        if (value == 0) {
            return Unknown;
        }
        if (value == 1) {
            return ProfileConstrainedBaseline;
        }
        if (value == 2) {
            return ProfileBaseline;
        }
        if (value == 3) {
            return ProfileMain;
        }
        if (value == 4) {
            return ProfileConstrainedHigh;
        }
        if (value == 5) {
            return ProfileHigh;
        }
        if (value == 80) {
            return VP8ProfileMain;
        }
        if (value == 100) {
            return ByteVC1ProfileMain10HDR10;
        }
        if (value != 128) {
            switch (value) {
                case 10:
                    return ByteVC1ProfileUnknown;
                case 11:
                    return ByteVC1ProfileMain;
                case 12:
                    return ByteVC1ProfileMain10;
                default:
                    return Unknown;
            }
        }
        return ByteVC1ProfileMax;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int toSystemProfile() {
        int i = this.value;
        if (i == 0 || i == 1 || i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        if (i == 4 || i == 5) {
            return 8;
        }
        if (i == 80) {
            return 1;
        }
        if (i == 100) {
            return 4096;
        }
        if (i == 128) {
            return 4;
        }
        switch (i) {
            case 10:
            case 11:
                return 1;
            case 12:
                return 2;
            default:
                throw new RuntimeException("profile not match system!");
        }
    }
}
