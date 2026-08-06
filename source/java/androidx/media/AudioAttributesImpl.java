package androidx.media;

import android.os.Bundle;
import androidx.versionedparcelable.VersionedParcelable;

/* loaded from: classes2.dex */
interface AudioAttributesImpl extends VersionedParcelable {
    Object getAudioAttributes();

    int getContentType();

    int getFlags();

    int getLegacyStreamType();

    int getRawLegacyStreamType();

    int getUsage();

    int getVolumeControlStream();

    Bundle toBundle();
}
