package com.bytedance.sdk.account.bus.util;

import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes5.dex */
public class Version implements Comparable<Version> {
    private String[] baseVersions;
    private int code;
    private String original;
    private String[] suffixVersions;
    private VersionType type;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public enum VersionType {
        STABLE,
        RC,
        ALPHA
    }

    public Version(String str) {
        this(str, 0);
    }

    public Version(String str, int i) {
        this.baseVersions = null;
        this.suffixVersions = null;
        this.type = VersionType.STABLE;
        this.code = i;
        this.original = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = this.original.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        this.baseVersions = split[0].split("\\.");
        if (split.length > 1) {
            String[] split2 = split[1].split("\\.");
            this.suffixVersions = split2;
            if ("rc".equalsIgnoreCase(split2[0])) {
                this.type = VersionType.RC;
            } else if ("alpha".equalsIgnoreCase(this.suffixVersions[0])) {
                this.type = VersionType.ALPHA;
            }
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Version version) {
        int i = this.code - version.code;
        if (i != 0) {
            return i;
        }
        if (TextUtils.isEmpty(this.original) && TextUtils.isEmpty(version.original)) {
            return 0;
        }
        if (TextUtils.isEmpty(version.original)) {
            return 1;
        }
        if (TextUtils.isEmpty(this.original)) {
            return -1;
        }
        if (this.original.equals(version.original)) {
            return 0;
        }
        int min = Math.min(this.baseVersions.length, version.baseVersions.length);
        for (int i2 = 0; i2 < min; i2++) {
            int parseInt = Integer.parseInt(this.baseVersions[i2]) - Integer.parseInt(version.baseVersions[i2]);
            if (parseInt != 0) {
                return parseInt;
            }
        }
        if (this.baseVersions.length > min) {
            return 1;
        }
        if (version.baseVersions.length > min) {
            return -1;
        }
        if (this.type == VersionType.STABLE && version.type == VersionType.STABLE) {
            return 0;
        }
        if ((this.type == VersionType.RC && version.type == VersionType.RC) || (this.type == VersionType.ALPHA && version.type == VersionType.ALPHA)) {
            return Integer.parseInt(this.suffixVersions[1]) - Integer.parseInt(version.suffixVersions[1]);
        }
        if (this.type == VersionType.STABLE) {
            return 1;
        }
        return (version.type != VersionType.STABLE && this.type == VersionType.RC) ? 1 : -1;
    }
}
