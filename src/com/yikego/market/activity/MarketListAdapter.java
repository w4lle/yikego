package com.yikego.market.activity;

import java.util.List;

import com.yikego.android.rom.sdk.bean.StoreInfo;
import com.yikego.market.R;
import com.yikego.market.model.MarketData;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MarketListAdapter extends ArrayAdapter<StoreInfo> {
	private Context mContext;
	private ViewHolder viewHolder = null;
	private LayoutInflater mLayoutInflater;
	public MarketListAdapter(Context context, List<StoreInfo> objects) {
		super(context, 0, objects);
		// TODO Auto-generated constructor stub
		mContext = context;
		mLayoutInflater = 
				(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		StoreInfo marketInfo = null;
		Log.v("asd", "position ="+position);
		if(position>=0){
			marketInfo = getItem(position);
		}
		if (convertView == null){
//			convertView = mLayoutInflater.inflate(R.layout.app_list_item, null);
			convertView = mLayoutInflater.inflate(R.layout.market_list_item, parent, false);
			viewHolder = new ViewHolder();
			viewHolder._id = marketInfo.storeId;
			viewHolder.mName =  (TextView) convertView.findViewById(R.id.market_listitem_name);
			viewHolder.mPath =  (TextView) convertView.findViewById(R.id.market_listitem_path);
			viewHolder.mBusinessTime =  (TextView) convertView.findViewById(R.id.market_business_time);
			viewHolder.mThumbnail =  (ImageView) convertView.findViewById(R.id.market_listitem_thumb);
			convertView.setTag(viewHolder);
		}else{
				viewHolder = (ViewHolder) convertView.getTag();
			}
		if(marketInfo !=null){
			viewHolder.mName.setText(marketInfo.name);
			viewHolder.mPath.setText(marketInfo.aboutDistance+"米");
			viewHolder.mBusinessTime.setText("营业时间"+marketInfo.createTime);
		}
		
		return convertView;
	}
	
	
	public class ViewHolder {
		public int _id;
		View mParent;
		ImageView mThumbnail;
//		TextView mAuthor;
		TextView mName;
		TextView mPath;
		TextView mBusinessTime;
		RelativeLayout mListItem;
	}
}