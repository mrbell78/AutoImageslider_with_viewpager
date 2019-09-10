package com.mrbell.autoimageslider_with_viewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Viewpageradapter extends PagerAdapter {

    Context context;

    public Viewpageradapter(Context context) {
        this.context = context;
    }

    LayoutInflater inflater;

    int images[]={R.drawable.thetoscope2,R.drawable.unknown,R.drawable.doctor,R.drawable.syring,R.drawable.paitent};

    String header[]={"Thetoscope","probblyThetoscope","Doctor","Syrings","paitent"};
    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_viewpager,container,false);

        ImageView img = view.findViewById(R.id.img_view);
        TextView textView = view.findViewById(R.id.header_id);


        img.setImageResource(images[position]);
        textView.setText(header[position]);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
