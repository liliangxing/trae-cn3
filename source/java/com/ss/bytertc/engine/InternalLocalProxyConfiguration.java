package com.ss.bytertc.engine;

import com.ss.bytertc.engine.type.LocalProxyConfiguration;
import com.ss.bytertc.engine.type.LocalProxyType;

/* loaded from: classes7.dex */
public class InternalLocalProxyConfiguration {
    public String localProxyIp;
    public String localProxyPassword;
    public int localProxyPort;
    public InternalLocalProxyType localProxyType;
    public String localProxyUsername;

    /* loaded from: classes7.dex */
    public enum InternalLocalProxyType {
        SOCKS5(1),
        HTTP_TUNNEL(2);

        private int value;

        InternalLocalProxyType(int v) {
            this.value = v;
        }

        public int getIntValue() {
            return this.value;
        }
    }

    public InternalLocalProxyConfiguration(LocalProxyConfiguration conf) {
        this.localProxyType = ConvertEnumValue(conf.localProxyType);
        this.localProxyIp = conf.localProxyIp;
        this.localProxyPort = conf.localProxyPort;
        this.localProxyUsername = conf.localProxyUsername;
        this.localProxyPassword = conf.localProxyPassword;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.bytertc.engine.InternalLocalProxyConfiguration$1, reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$bytertc$engine$type$LocalProxyType;

        static {
            int[] iArr = new int[LocalProxyType.values().length];
            $SwitchMap$com$ss$bytertc$engine$type$LocalProxyType = iArr;
            try {
                iArr[LocalProxyType.SOCKS5.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$bytertc$engine$type$LocalProxyType[LocalProxyType.HTTP_TUNNEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private InternalLocalProxyType ConvertEnumValue(LocalProxyType localProxyType) {
        InternalLocalProxyType internalLocalProxyType = InternalLocalProxyType.SOCKS5;
        int i = AnonymousClass1.$SwitchMap$com$ss$bytertc$engine$type$LocalProxyType[localProxyType.ordinal()];
        if (i != 1) {
            return i != 2 ? internalLocalProxyType : InternalLocalProxyType.HTTP_TUNNEL;
        }
        return InternalLocalProxyType.SOCKS5;
    }

    public String getLocalProxyIp() {
        return this.localProxyIp;
    }

    int getLocalProxyPort() {
        return this.localProxyPort;
    }

    public String getLocalProxyUsername() {
        return this.localProxyUsername;
    }

    public String getLocalProxyPassword() {
        return this.localProxyPassword;
    }

    InternalLocalProxyType getLocalProxyType() {
        return this.localProxyType;
    }
}
