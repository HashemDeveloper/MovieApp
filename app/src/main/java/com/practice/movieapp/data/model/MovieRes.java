package com.practice.movieapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.vimeo.stag.UseStag;

import java.util.ArrayList;
import java.util.List;

@UseStag
public class MovieRes implements Parcelable
{

    @SerializedName("page")
    @Expose
    Integer page;
    @SerializedName("total_results")
    @Expose
    Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    Integer totalPages;
    @SerializedName("results")
    @Expose
    List<Result> results = new ArrayList<>();

    public final static Parcelable.Creator<MovieRes> CREATOR = new Creator<MovieRes>() {
        @SuppressWarnings({
                "unchecked"
        })
        public MovieRes createFromParcel(Parcel in) {
            return new MovieRes(in);
        }

        public MovieRes[] newArray(int size) {
            return (new MovieRes[size]);
        }

    };

    protected MovieRes(Parcel in) {
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results, (Result.class.getClassLoader()));
    }

    public MovieRes() {
    }

    public MovieRes(Integer page, Integer totalResults, Integer totalPages, List<Result> results) {
        super();
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(totalResults);
        dest.writeValue(totalPages);
        dest.writeList(results);
    }

    public int describeContents() {
        return 0;
    }
}
