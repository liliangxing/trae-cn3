package com.lynx.animax.player;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class VideoPlayerFactory {

    /* renamed from: com.lynx.animax.player.VideoPlayerFactory$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    static /* synthetic */ class C13491 {
        static final /* synthetic */ int[] $SwitchMap$com$lynx$animax$player$VideoPlayerType;

        static {
            int[] iArr = new int[VideoPlayerType.values().length];
            $SwitchMap$com$lynx$animax$player$VideoPlayerType = iArr;
            try {
                iArr[VideoPlayerType.CUSTOM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$lynx$animax$player$VideoPlayerType[VideoPlayerType.DEFAULT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static IVideoPlayer create(long j, VideoPlayerConfig videoPlayerConfig) {
        int i = C13491.$SwitchMap$com$lynx$animax$player$VideoPlayerType[videoPlayerConfig.getPlayerType().ordinal()];
        return new VideoPlayerImpl(j, videoPlayerConfig);
    }
}
