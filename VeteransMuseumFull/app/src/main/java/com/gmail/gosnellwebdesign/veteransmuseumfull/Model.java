package com.gmail.gosnellwebdesign.veteransmuseumfull;

public class Model {

    public static final int IMAGE_TYPE =1;
    public String title, subtitle, Image;
    public int type;

    // Model structure for veteran posts in the archive
    public Model ( int mtype, String mtitle, String msubtitle, String image  ){

        this.title = mtitle;
        this.subtitle = msubtitle;
        this.type = mtype;
        this.Image = image;
    }
}