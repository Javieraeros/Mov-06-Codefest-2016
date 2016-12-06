package es.iesnervion.fjruiz.mov_06_codefest_2016;

import android.widget.TextView;

public class ViewHolder {
    TextView tv;

    public ViewHolder (TextView tv)
    {
        this.tv = tv;
    }

    public TextView getTv (){
        return this.tv;
    }

}
