package com.google.zxing.oned;

import com.bytedance.android.sdk.bdticketguard.key.TeeKeyHelperKt;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import com.ss.android.download.api.constant.Downloads;
import com.ss.bduploader.UploadKeys;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
final class EANManufacturerOrgSupport {
    private final List<int[]> ranges = new ArrayList();
    private final List<String> countryIdentifiers = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String lookupCountryIdentifier(String str) {
        int[] iArr;
        int i;
        initIfNeeded();
        int parseInt = Integer.parseInt(str.substring(0, 3));
        int size = this.ranges.size();
        for (int i2 = 0; i2 < size && parseInt >= (i = (iArr = this.ranges.get(i2))[0]); i2++) {
            if (iArr.length != 1) {
                i = iArr[1];
            }
            if (parseInt <= i) {
                return this.countryIdentifiers.get(i2);
            }
        }
        return null;
    }

    private void add(int[] iArr, String str) {
        this.ranges.add(iArr);
        this.countryIdentifiers.add(str);
    }

    private synchronized void initIfNeeded() {
        if (this.ranges.isEmpty()) {
            add(new int[]{0, 19}, "US/CA");
            add(new int[]{30, 39}, "US");
            add(new int[]{60, 139}, "US/CA");
            add(new int[]{300, MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL}, "FR");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER}, "BG");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400}, "SI");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500}, "HR");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500}, "BA");
            add(new int[]{400, UploadKeys.KeyIsEnd2EndEncryptionPublicKey}, "DE");
            add(new int[]{450, MediaPlayer.MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME}, "JP");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_TIMESCALE_ENABLE, MediaPlayer.MEDIA_PLAYER_OPTION_GET_NETWORK_CONNECT_COUNT}, "RU");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SPADE_EXPIRE_TIME}, "TW");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_PLAYER_DBEUG_STATE}, "EE");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_REPORT_FIRST_AVSYNC_FRAME}, "LV");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_ACCUMULATE_DOWNLOAD_BYTES}, "AZ");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_BOX_DEMUXER}, "LT");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CODEC}, "UZ");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC}, "LK");
            add(new int[]{480}, "PH");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_TIMECOST_INFO}, "BY");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_CURRENT_POSITION_OFFSET_INFO}, "UA");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ACTUAL_SIZE_RATE}, "MD");
            add(new int[]{485}, "AM");
            add(new int[]{486}, "GE");
            add(new int[]{Downloads.Impl.MIN_ARTIFICIAL_ERROR_STATUS}, "KZ");
            add(new int[]{Downloads.Impl.STATUS_CANNOT_RESUME}, "HK");
            add(new int[]{Downloads.Impl.STATUS_CANCELED, 499}, "JP");
            add(new int[]{500, MediaPlayer.MEDIA_PLAYER_OPTION_MODULE_NAME}, "GB");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX}, "GR");
            add(new int[]{528}, ExpandedProductParsedResult.POUND);
            add(new int[]{529}, "CY");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE}, "MK");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_METHOD}, "MT");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DUMMY_VOICE_SLEEP}, "IE");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_CLOSE_IO_COST}, "BE/LU");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ}, "PT");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_LINE_STRIDE}, "IS");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_MDL_SEEK_REOPEN, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_TONEW}, "DK");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SOCKET_CREATE_SUCCESS_TIME}, "PL");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_OPT_AUDIORENDERTIME_REPORT}, "RO");
            add(new int[]{599}, "HU");
            add(new int[]{600, 601}, "ZA");
            add(new int[]{603}, "GH");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_MDAT_POS}, "BH");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_BUFS_WHEN_BUFFER_START}, "MU");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE}, "MA");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BARRAGE_MASK}, "DZ");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH}, "KE");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB}, "CI");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID}, "TN");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME}, "SY");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DNS_START_TIME}, "EG");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME}, "LY");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME}, "JO");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_DEC_CREATE_TIME}, "IR");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME}, "KW");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME}, "SA");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME}, "AE");
            add(new int[]{640, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME}, "FI");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_REQUEST_LOG, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_LIVE_CONNECT_TIME}, "CN");
            add(new int[]{700, 709}, "NO");
            add(new int[]{729}, "IL");
            add(new int[]{730, 739}, "SE");
            add(new int[]{740}, "GT");
            add(new int[]{741}, "SV");
            add(new int[]{742}, "HN");
            add(new int[]{743}, "NI");
            add(new int[]{744}, "CR");
            add(new int[]{745}, "PA");
            add(new int[]{746}, "DO");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AI_BARRAGE_URL}, "MX");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_FEED_IN_BEFORE_DECODED, MediaPlayer.MEDIA_PLAYER_OPTION_PRELOAD_GEAR}, "CA");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_GET_PLAYER_READ_STATE}, "VE");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_WAIT_TIME, 769}, "CH");
            add(new int[]{770}, "CO");
            add(new int[]{773}, "UY");
            add(new int[]{775}, "PE");
            add(new int[]{777}, "BO");
            add(new int[]{779}, "AR");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SET_PCDN_ENABLE}, "CL");
            add(new int[]{784}, "PY");
            add(new int[]{785}, "PE");
            add(new int[]{786}, TeeKeyHelperKt.KEY_PAIR_ALGORITHM);
            add(new int[]{789, 790}, "BR");
            add(new int[]{800, MediaPlayer.MEDIA_PLAYER_OPTION_RTM_SIGNAL_ANSWER_UPDATED_TIME}, "IT");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_RTM_DATA_ICE_CONNECT_START_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DIFF_COUNT}, "ES");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME}, "CU");
            add(new int[]{858}, "SK");
            add(new int[]{859}, "CZ");
            add(new int[]{860}, "YU");
            add(new int[]{865}, "MN");
            add(new int[]{867}, "KP");
            add(new int[]{868, 869}, "TR");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_THREAD_SAFE_REF, 879}, "NL");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE}, "KR");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_PLUGIN_LOAD}, "TH");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION}, "SG");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_COUNT_REASON2}, "IN");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DURATION_REASON2}, "VN");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT}, "PK");
            add(new int[]{899}, "ID");
            add(new int[]{900, 919}, "AT");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST, MediaPlayer.MEDIA_PLAYER_OPTION_PROTOCOL_RETRY_TIMES}, "AU");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_PARAMS, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_REJ_REASONS}, "AZ");
            add(new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTPX_CACHED}, "MY");
            add(new int[]{958}, "MO");
        }
    }
}
