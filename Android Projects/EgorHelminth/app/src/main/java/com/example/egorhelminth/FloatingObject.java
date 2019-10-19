package com.example.egorhelminth;

import android.util.AttributeSet;
import android.widget.ImageView;
import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;

public class FloatingObject extends AppCompatImageView {
    public FloatingObject(Context context){
        super(context);
    }

    public FloatingObject(Context context, AttributeSet as){
        super(context, as);
    }

    public FloatingObject(Context context, AttributeSet as, int i){
        super(context, as, i);
    }

    public boolean setFobjectType(int fobjectType){
        switch(fobjectType){
            case 0: // standard bonus point
                super.setImageResource(R.drawable.meat1);
                break;
            case 1: // barrier
                super.setImageResource(R.drawable.tablette);
                break;
            case 2: // shuba
                super.setImageResource(R.drawable.shuba);
                break;
            case 3: // shoe
                super.setImageResource(R.drawable.shoe);
                break;
            default: return false;
        }
        return true;
    }

    public boolean setSide(int side){
        int centerPos = 447;
        super.setY(100);
        switch(side){
            case 0: // left
                super.setX(centerPos - CONSTANT.DELTA_X);
                break;
            case 1: // centre
                super.setX(centerPos);
                break;
            case 2: // right
                super.setX(centerPos + CONSTANT.DELTA_X);
                break;
            default:
                return false;
        }
        return true;
    }
}
