package com.bytedance.vcloud.uniplayer;

import kotlin.Metadata;

/* compiled from: PlayRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u0003H&J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u000f\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/vcloud/uniplayer/IBitrate;", "", "getBitrate", "", "getBitrateFormat", "", "getDefinition", "getExtra", "getFileId", "getFps", "getGearName", "getPktOffsetMap", "getPlayAddr", "Lcom/bytedance/vcloud/uniplayer/IUrlModel;", "getQuality", "getQualityType", "getRealBitrate", "getRelatedAudioFileId", "getSubInfo", "isByteVC1", "()Ljava/lang/Integer;", "uniplayer_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface IBitrate {

    /* compiled from: PlayRequest.kt */
    @Metadata(k = 3, mv = {1, 7, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class DefaultImpls {
        public static String getDefinition(IBitrate iBitrate) {
            return null;
        }

        public static String getFileId(IBitrate iBitrate) {
            return null;
        }

        public static int getFps(IBitrate iBitrate) {
            return 0;
        }

        public static String getGearName(IBitrate iBitrate) {
            return null;
        }

        public static String getPktOffsetMap(IBitrate iBitrate) {
            return null;
        }

        public static IUrlModel getPlayAddr(IBitrate iBitrate) {
            return null;
        }

        public static String getQuality(IBitrate iBitrate) {
            return null;
        }

        public static int getRealBitrate(IBitrate iBitrate) {
            return 0;
        }

        public static String getRelatedAudioFileId(IBitrate iBitrate) {
            return null;
        }

        public static String getSubInfo(IBitrate iBitrate) {
            return null;
        }

        public static Integer isByteVC1(IBitrate iBitrate) {
            return null;
        }
    }

    int getBitrate();

    String getBitrateFormat();

    String getDefinition();

    String getExtra();

    String getFileId();

    int getFps();

    String getGearName();

    String getPktOffsetMap();

    IUrlModel getPlayAddr();

    String getQuality();

    int getQualityType();

    int getRealBitrate();

    String getRelatedAudioFileId();

    String getSubInfo();

    Integer isByteVC1();
}
