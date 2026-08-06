package com.ttnet.org.chromium.net;

import java.util.List;

/* loaded from: classes7.dex */
public abstract class TTNetDiagnosisRequest {

    /* loaded from: classes7.dex */
    public static abstract class Builder {
        public abstract TTNetDiagnosisRequest build();

        public abstract Builder setMultiNetAction(int i);

        public abstract Builder setNetDetectType(int i);

        public abstract Builder setRequestType(int i);

        public abstract Builder setTargets(List<String> list);

        public abstract Builder setTimeout(int i);
    }

    /* loaded from: classes7.dex */
    public interface Callback {
        void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest tTNetDiagnosisRequest, String str);
    }

    public abstract void cancel();

    public abstract void doExtraCommand(String str, String str2);

    public abstract void start();
}
