package myid.supri.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieParcel implements Parcelable {
    private String name;
    private String description;
    private String cast;
    private int poster;

    public MovieParcel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public static Creator<MovieParcel> getCREATOR() {
        return CREATOR;
    }



    protected MovieParcel(Parcel in) {
        name = in.readString();
        description = in.readString();
        cast = in.readString();
        poster = in.readInt();
    }

    public static final Creator<MovieParcel> CREATOR = new Creator<MovieParcel>() {
        @Override
        public MovieParcel createFromParcel(Parcel in) {
            return new MovieParcel(in);
        }

        @Override
        public MovieParcel[] newArray(int size) {
            return new MovieParcel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(cast);
        dest.writeInt(poster);
    }
}
