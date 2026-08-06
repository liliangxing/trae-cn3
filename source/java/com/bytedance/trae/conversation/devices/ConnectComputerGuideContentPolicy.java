package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.conversation.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectComputerGuideContentPolicy.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContentPolicy;", "", "<init>", "()V", "DOWNLOAD_UTM", "", "OVERSEA_DOWNLOAD_URL", "MAINLAND_IDE_DOWNLOAD_URL", "OVERSEA_DISPLAY_URL", "MAINLAND_DISPLAY_URL", "content", "Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideContent;", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "downloadUrl", "isOversea", "", "displayUrl", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConnectComputerGuideContentPolicy {
    private static final String DOWNLOAD_UTM = "?utm_source=content&utm_medium=mobile_download";
    public static final ConnectComputerGuideContentPolicy INSTANCE = new ConnectComputerGuideContentPolicy();
    private static final String MAINLAND_DISPLAY_URL = "trae.cn";
    private static final String MAINLAND_IDE_DOWNLOAD_URL = "https://www.trae.cn/ide/download?utm_source=content&utm_medium=mobile_download";
    private static final String OVERSEA_DISPLAY_URL = "trae.ai";
    private static final String OVERSEA_DOWNLOAD_URL = "https://www.trae.ai/download?utm_source=content&utm_medium=mobile_download";

    /* compiled from: ConnectComputerGuideContentPolicy.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceProductType.values().length];
            try {
                iArr[DeviceProductType.WORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceProductType.IDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String displayUrl(boolean isOversea) {
        return isOversea ? OVERSEA_DISPLAY_URL : MAINLAND_DISPLAY_URL;
    }

    public final String downloadUrl(boolean isOversea) {
        return isOversea ? OVERSEA_DOWNLOAD_URL : MAINLAND_IDE_DOWNLOAD_URL;
    }

    private ConnectComputerGuideContentPolicy() {
    }

    public final ConnectComputerGuideContent content(DeviceProductType productType) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i == 1) {
            return new ConnectComputerGuideContent(R.drawable.trae_connect_guide_work_hero, R.string.trae_device_connect_work_step1, R.string.trae_device_connect_work_step2);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return new ConnectComputerGuideContent(R.drawable.trae_connect_guide_ide_hero, R.string.trae_device_connect_ide_step1, R.string.trae_device_connect_ide_step2);
    }
}
