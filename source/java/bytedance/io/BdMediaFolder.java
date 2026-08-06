package bytedance.io;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class BdMediaFolder implements Parcelable {
    public static final Parcelable.Creator<BdMediaFolder> CREATOR = new Parcelable.Creator<BdMediaFolder>() { // from class: bytedance.io.BdMediaFolder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BdMediaFolder createFromParcel(Parcel parcel) {
            return new BdMediaFolder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BdMediaFolder[] newArray(int i) {
            return new BdMediaFolder[i];
        }
    };
    private long bucketId;
    private ArrayList<BdMediaItem> data;
    private long firstDateAdded;
    private Uri firstImagePath;
    private String firstMimeType;
    private String folderName;
    private int folderTotalNum;
    private ArrayList<BdMediaItem> images;
    private boolean isAllAblubm;
    private ArrayList<BdMediaItem> videos;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public void setBucketId(long j) {
        this.bucketId = j;
    }

    public String getFolderName() {
        return this.folderName;
    }

    public void setFolderName(String str) {
        this.folderName = str;
    }

    public Uri getFirstImagePath() {
        return this.firstImagePath;
    }

    public void setFirstImagePath(Uri uri) {
        this.firstImagePath = uri;
    }

    public String getFirstMimeType() {
        return this.firstMimeType;
    }

    public void setFirstMimeType(String str) {
        this.firstMimeType = str;
    }

    public int getFolderTotalNum() {
        return this.folderTotalNum;
    }

    public void setFolderTotalNum(int i) {
        this.folderTotalNum = i;
    }

    public ArrayList<BdMediaItem> getData() {
        ArrayList<BdMediaItem> arrayList = this.data;
        return arrayList != null ? arrayList : new ArrayList<>();
    }

    public void setData(ArrayList<BdMediaItem> arrayList) {
        this.data = arrayList;
    }

    public ArrayList<BdMediaItem> getImages() {
        ArrayList<BdMediaItem> arrayList = this.images;
        return arrayList != null ? arrayList : new ArrayList<>();
    }

    public void setImages(ArrayList<BdMediaItem> arrayList) {
        this.images = arrayList;
    }

    public ArrayList<BdMediaItem> getVideos() {
        ArrayList<BdMediaItem> arrayList = this.videos;
        return arrayList != null ? arrayList : new ArrayList<>();
    }

    public void setVideos(ArrayList<BdMediaItem> arrayList) {
        this.videos = arrayList;
    }

    public long getFirstDateAdded() {
        return this.firstDateAdded;
    }

    public void setFirstDateAdded(long j) {
        this.firstDateAdded = j;
    }

    public boolean isAllAblubm() {
        return this.isAllAblubm;
    }

    public void setAllAblubm(boolean z) {
        this.isAllAblubm = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.bucketId);
        parcel.writeString(this.folderName);
        parcel.writeParcelable(this.firstImagePath, i);
        parcel.writeString(this.firstMimeType);
        parcel.writeLong(this.firstDateAdded);
        parcel.writeInt(this.folderTotalNum);
        parcel.writeByte(this.isAllAblubm ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.data);
        parcel.writeTypedList(this.images);
        parcel.writeTypedList(this.videos);
    }

    public void readFromParcel(Parcel parcel) {
        this.bucketId = parcel.readLong();
        this.folderName = parcel.readString();
        this.firstImagePath = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.firstMimeType = parcel.readString();
        this.firstDateAdded = parcel.readLong();
        this.folderTotalNum = parcel.readInt();
        this.isAllAblubm = parcel.readByte() != 0;
        this.data = parcel.createTypedArrayList(BdMediaItem.CREATOR);
        this.images = parcel.createTypedArrayList(BdMediaItem.CREATOR);
        this.videos = parcel.createTypedArrayList(BdMediaItem.CREATOR);
    }

    public BdMediaFolder() {
        this.bucketId = -1L;
        this.data = new ArrayList<>();
        this.images = new ArrayList<>();
        this.videos = new ArrayList<>();
    }

    protected BdMediaFolder(Parcel parcel) {
        this.bucketId = -1L;
        this.data = new ArrayList<>();
        this.images = new ArrayList<>();
        this.videos = new ArrayList<>();
        this.bucketId = parcel.readLong();
        this.folderName = parcel.readString();
        this.firstImagePath = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.firstMimeType = parcel.readString();
        this.firstDateAdded = parcel.readLong();
        this.folderTotalNum = parcel.readInt();
        this.isAllAblubm = parcel.readByte() != 0;
        this.data = parcel.createTypedArrayList(BdMediaItem.CREATOR);
        this.images = parcel.createTypedArrayList(BdMediaItem.CREATOR);
        this.videos = parcel.createTypedArrayList(BdMediaItem.CREATOR);
    }
}
