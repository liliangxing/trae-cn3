package bytedance.io;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
public class BdMediaItem implements Parcelable {
    public static final Parcelable.Creator<BdMediaItem> CREATOR = new Parcelable.Creator<BdMediaItem>() { // from class: bytedance.io.BdMediaItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BdMediaItem createFromParcel(Parcel parcel) {
            return new BdMediaItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BdMediaItem[] newArray(int i) {
            return new BdMediaItem[i];
        }
    };
    private String album;
    private long albumId;
    private String artist;
    private long bucketId;
    private String bucketName;
    private long dateAdded;
    private long dateToken;
    private long duration;
    private long fileSize;
    private int height;
    private long id;
    private String mimeType;
    private long modify;
    private int musicType;
    private String name;
    private int orientation;
    private String relativePath;
    private String resolution;
    private String title;
    private Uri uri;
    private int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "BdMediaItem{id=" + this.id + ", name='" + this.name + "', modify=" + this.modify + ", dateAdded=" + this.dateAdded + ", mimeType='" + this.mimeType + "', duration=" + this.duration + ", fileSize=" + this.fileSize + ", width=" + this.width + ", height=" + this.height + ", musicType=" + this.musicType + ", uri=" + this.uri + ", relativePath='" + this.relativePath + "', dateToken=" + this.dateToken + ", orientation=" + this.orientation + ", resolution='" + this.resolution + "', album='" + this.album + "', artist='" + this.artist + "', title='" + this.title + "', albumId=" + this.albumId + ", bucketId=" + this.bucketId + ", bucketName=" + this.bucketName + AbstractJsonLexerKt.END_OBJ;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public long getModify() {
        return this.modify;
    }

    public void setModify(long j) {
        this.modify = j;
    }

    public long getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(long j) {
        this.dateAdded = j;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long j) {
        this.fileSize = j;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getMusicType() {
        return this.musicType;
    }

    public void setMusicType(int i) {
        this.musicType = i;
    }

    public Uri getUri() {
        return this.uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public String getRelativePath() {
        return this.relativePath;
    }

    public void setRelativePath(String str) {
        this.relativePath = str;
    }

    public long getDateToken() {
        return this.dateToken;
    }

    public void setDateToken(long j) {
        this.dateToken = j;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public String getResolution() {
        return this.resolution;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String str) {
        this.album = str;
    }

    public String getArtist() {
        return this.artist;
    }

    public void setArtist(String str) {
        this.artist = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public long getAlbumId() {
        return this.albumId;
    }

    public void setAlbumId(long j) {
        this.albumId = j;
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public void setBucketId(long j) {
        this.bucketId = j;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String str) {
        this.bucketName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.name);
        parcel.writeLong(this.modify);
        parcel.writeLong(this.dateAdded);
        parcel.writeString(this.mimeType);
        parcel.writeLong(this.duration);
        parcel.writeLong(this.fileSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.musicType);
        parcel.writeParcelable(this.uri, i);
        parcel.writeString(this.relativePath);
        parcel.writeLong(this.dateToken);
        parcel.writeInt(this.orientation);
        parcel.writeString(this.resolution);
        parcel.writeString(this.album);
        parcel.writeString(this.artist);
        parcel.writeString(this.title);
        parcel.writeLong(this.albumId);
        parcel.writeLong(this.bucketId);
        parcel.writeString(this.bucketName);
    }

    public void readFromParcel(Parcel parcel) {
        this.id = parcel.readLong();
        this.name = parcel.readString();
        this.modify = parcel.readLong();
        this.dateAdded = parcel.readLong();
        this.mimeType = parcel.readString();
        this.duration = parcel.readLong();
        this.fileSize = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.musicType = parcel.readInt();
        this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.relativePath = parcel.readString();
        this.dateToken = parcel.readLong();
        this.orientation = parcel.readInt();
        this.resolution = parcel.readString();
        this.album = parcel.readString();
        this.artist = parcel.readString();
        this.title = parcel.readString();
        this.albumId = parcel.readLong();
        this.bucketId = parcel.readLong();
        this.bucketName = parcel.readString();
    }

    public BdMediaItem() {
    }

    protected BdMediaItem(Parcel parcel) {
        this.id = parcel.readLong();
        this.name = parcel.readString();
        this.modify = parcel.readLong();
        this.dateAdded = parcel.readLong();
        this.mimeType = parcel.readString();
        this.duration = parcel.readLong();
        this.fileSize = parcel.readLong();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.musicType = parcel.readInt();
        this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.relativePath = parcel.readString();
        this.dateToken = parcel.readLong();
        this.orientation = parcel.readInt();
        this.resolution = parcel.readString();
        this.album = parcel.readString();
        this.artist = parcel.readString();
        this.title = parcel.readString();
        this.albumId = parcel.readLong();
        this.bucketId = parcel.readLong();
        this.bucketName = parcel.readString();
    }
}
