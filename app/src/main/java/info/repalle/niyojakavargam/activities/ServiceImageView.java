package info.repalle.niyojakavargam.activities;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class ServiceImageView extends ImageView {
    public ServiceImageView(Context context) {
        super(context);
    }

    public ServiceImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ServiceImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth()); //Snap to width
    }
}
