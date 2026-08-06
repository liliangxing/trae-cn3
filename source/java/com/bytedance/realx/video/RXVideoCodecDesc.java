package com.bytedance.realx.video;

/* loaded from: classes4.dex */
public class RXVideoCodecDesc {
    public final RXVideoCodecProfile profile;
    public final RXVideoCodecStandard standard;

    public RXVideoCodecDesc(int standard_value, int profile_value) {
        this.standard = RXVideoCodecStandard.fromValue(standard_value);
        this.profile = RXVideoCodecProfile.fromValue(profile_value);
    }

    public RXVideoCodecDesc(RXVideoCodecStandard standard, RXVideoCodecProfile profile) {
        this.standard = standard;
        this.profile = profile;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RXVideoCodecDesc)) {
            return false;
        }
        RXVideoCodecDesc rXVideoCodecDesc = (RXVideoCodecDesc) obj;
        return this.standard == rXVideoCodecDesc.standard && this.profile == rXVideoCodecDesc.profile;
    }

    String getName() {
        return this.standard.mimeType();
    }

    int GetStandardInt() {
        return this.standard.toInt();
    }

    int GetProfileInt() {
        return this.profile.toInt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RXVideoCodecProfile getProfile() {
        return this.profile;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RXVideoCodecStandard getStandard() {
        return this.standard;
    }
}
