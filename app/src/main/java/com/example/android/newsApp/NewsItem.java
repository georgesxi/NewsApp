package com.example.android.newsApp;

public class NewsItem {

    private String mWebTitle;
    private String mSectionName;
    private String mWebPublicationDate;
    private String mAuthorName;
    private String mWebUrl;
    private String mThumbnail;

    public NewsItem(String WebTitle, String SectionName, String webPublicationDate, String AuthorName, String WebUrl, String Thumbnail ) {
        mWebTitle = WebTitle;
        mWebPublicationDate = webPublicationDate;
        mSectionName = SectionName;
        mAuthorName = AuthorName;
        mWebUrl = WebUrl;
        mThumbnail = Thumbnail;
    }

    /**
     * Returns the web title.
     */
    public String getWebTitle() {
        return mWebTitle;
    }

    /**
     * Returns the section title.
     */

    public String getSectionName() {
        return mSectionName;
    }

    /**
     * Returns the publication date.
     */
    public String getWebPublicationDate() {
        return mWebPublicationDate;
    }

    /**
     * Returns the author.
     */

    public String getAuthorName() {
        return mAuthorName;
    }

    /**
     * Returns the web url.
     */

    public String getWebUrl() {
        return mWebUrl;
    }

    public String getThumbnailSrc() { return mThumbnail;}
}