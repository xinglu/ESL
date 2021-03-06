package com.cxt.esl.sale.adapter;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxt.esl.R;
import com.cxt.esl.good.domain.Good;
import com.cxt.esl.sale.domain.SaleItem;

public class SaleAdapter extends ArrayAdapter<SaleItem> {

	private int resourceId;
	private static final String STR_POS_NAME = "商品名称: ";
	private static final String STR_ORGI__PRICE = "原价: ";
	private static final String STR_PRES__PRICE = "现价: ";
	private static final String STR_COUNT = "购买数量: ";
	
	public SaleAdapter(Context context, int textViewResourceId,
			List<SaleItem> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Good good = getItem(position).getGood();
		int count = getItem(position).getCount();
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.goodImg = (ImageView) view.findViewById(R.id.good_image);
			viewHolder.posName = (TextView) view.findViewById(R.id.pos_name);
			viewHolder.origPrice = (TextView) view.findViewById(R.id.orig_price);
			viewHolder.presPrice = (TextView) view.findViewById(R.id.pres_price);
			viewHolder.count = (TextView) view.findViewById(R.id.count);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		if(good.getImgUrl().length()>0){
			Bitmap bitmap = BitmapFactory.decodeFile(good.getImgUrl());
			viewHolder.goodImg.setImageBitmap(bitmap);
		}else{
			viewHolder.goodImg.setImageResource(R.drawable.no_img);
		}
		viewHolder.posName.setText(STR_POS_NAME+good.getPosName());
		viewHolder.origPrice.setText(STR_ORGI__PRICE+good.getOrigPrice());
		viewHolder.presPrice.setText(STR_PRES__PRICE+good.getPresPrice());
		viewHolder.count.setText(STR_COUNT+count);
		
		return view;
	}
	
	class ViewHolder {
		
		ImageView goodImg;
		TextView posName;
		TextView origPrice;
		TextView presPrice;
		TextView count;
		
	}
	
	

}
