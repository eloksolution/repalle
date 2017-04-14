package info.repalle.niyojakavargam.activities;

/**
 * Created by welcome on 1/19/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import activities.repalle.info.repalle.R;

public class ShopesGridview extends BaseAdapter {
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;


    public ShopesGridview(Context c, String[] web, int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = inflater.inflate(R.layout.gridview_layout, null);
        }
        else {
            grid = (View) convertView;
        }
        TextView textView = (TextView) grid.findViewById(R.id.services);
        ImageView imageView = (ImageView)grid.findViewById(R.id.Icon);
        textView.setText(web[position]);
        imageView.setImageResource(Imageid[position]);
        return grid;
    }
}