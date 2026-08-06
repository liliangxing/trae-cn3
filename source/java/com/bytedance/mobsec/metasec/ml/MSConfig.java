package com.bytedance.mobsec.metasec.ml;

import java.util.Map;
import ms.bd.c.a2;
import ms.bd.c.c2;

/* loaded from: classes4.dex */
public final class MSConfig extends c2 {
    private final c2 a;

    /* loaded from: classes4.dex */
    public static class Builder extends a2 {

        /* loaded from: classes4.dex */
        public interface IFetchedDid {
            String fetchedDid();
        }

        /* loaded from: classes4.dex */
        public interface IMsComplianceScene {
            boolean isComplianceScene(String str);
        }

        /* loaded from: classes4.dex */
        public interface IMsSettingConfig {
            String settingConfig();
        }

        public Builder(String str, String str2) {
            super(str, str2, c2.COLLECT_MODE_DEFAULT);
        }

        public Builder addAdvanceInfo(String str, String str2) {
            addAdvanceInfo0(str, str2);
            return this;
        }

        public MSConfig build() {
            return new MSConfig(build0());
        }

        public Builder setBDDeviceID(String str) {
            setBDDeviceID0(str);
            return this;
        }

        public Builder setChannel(String str) {
            setChannel0(str);
            return this;
        }

        public Builder setClientType(int i) {
            setClientType0(i);
            return this;
        }

        public Builder setCustomInfo(Map<String, String> map) {
            setCustomInfo0(map);
            return this;
        }

        public Builder setDefaultReportHost(String str) {
            setDefaultReportHost0(str);
            return this;
        }

        public Builder setDeviceID(String str) {
            setDeviceID0(str);
            return this;
        }

        public Builder setFetchedDidInterface(IFetchedDid iFetchedDid) {
            setFetchedDidInterface0(iFetchedDid);
            return this;
        }

        public Builder setInstallID(String str) {
            setInstallID0(str);
            return this;
        }

        public Builder setMsComplianceScene(IMsComplianceScene iMsComplianceScene) {
            setMsComplianceScene0(iMsComplianceScene);
            return this;
        }

        public Builder setMsSettingConfig(IMsSettingConfig iMsSettingConfig) {
            setMsSettingConfig0(iMsSettingConfig);
            return this;
        }

        public Builder setOVRegionType(int i) {
            setOVRegionType0(i);
            return this;
        }

        @Deprecated
        public Builder setSecssionID(String str) {
            return this;
        }

        public Builder(String str, String str2, int i) {
            super(str, str2, i);
        }

        public Builder(String str, String str2, String str3) {
            super(str, str2, str3, c2.COLLECT_MODE_DEFAULT);
        }

        public Builder(String str, String str2, String str3, int i) {
            super(str, str2, str3, i);
        }
    }

    MSConfig(c2 c2Var) {
        this.a = c2Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c2 a() {
        return this.a;
    }
}
