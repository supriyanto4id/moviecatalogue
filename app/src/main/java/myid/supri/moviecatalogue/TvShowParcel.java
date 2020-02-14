package myid.supri.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShowParcel implements Parcelable {
    private String name_tv_show;
    private String overivew_tv_show;
    private String cast_tv_show;
    private int poster_tv_show;

    public TvShowParcel() {

    }

    public String getName_tv_show() {
        return name_tv_show;
    }

    public void setName_tv_show(String name_tv_show) {
        this.name_tv_show = name_tv_show;
    }

    public String getOverivew_tv_show() {
        return overivew_tv_show;
    }

    public void setOverivew_tv_show(String overivew_tv_show) {
        this.overivew_tv_show = overivew_tv_show;
    }

    public String getCast_tv_show() {
        return cast_tv_show;
    }

    public void setCast_tv_show(String cast_tv_show) {
        this.cast_tv_show = cast_tv_show;
    }

    public int getPoster_tv_show() {
        return poster_tv_show;
    }

    public void setPoster_tv_show(int poster_tv_show) {
        this.poster_tv_show = poster_tv_show;
    }

    public static Creator<TvShowParcel> getCREATOR() {
        return CREATOR;
    }


    protected TvShowParcel(Parcel in) {
        name_tv_show = in.readString();
        overivew_tv_show= in.readString();
        cast_tv_show =in.readString();
        poster_tv_show=in.readInt();
    }

    public static final Creator<TvShowParcel> CREATOR = new Creator<TvShowParcel>() {
        @Override
        public TvShowParcel createFromParcel(Parcel in) {
            return new TvShowParcel(in);
        }

        @Override
        public TvShowParcel[] newArray(int size) {
            return new TvShowParcel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name_tv_show);
        dest.writeString(overivew_tv_show);
        dest.writeString(cast_tv_show);
        dest.writeInt(poster_tv_show);
    }
}
