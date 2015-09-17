package com.example.givemepass.glidedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;


public class MainActivity extends Activity{
	private String[] mImgsPath = {
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/01.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/02.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/03.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/04.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/05.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/06.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/07.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/08.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/09.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/10.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/11.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/12.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/13.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/14.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/15.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/16.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/17.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/18.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/19.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/20.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/21.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/22.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/23.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/24.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/25.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/26.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/27.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/28.jpg",
			"https://dl.dropboxusercontent.com/u/24682760/Android_AS/LRUCacheDemo/29.jpg"
	};

	private ListView mListView;

	private BaseAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.list);
		mAdapter = new MyAdapter();
		mListView.setAdapter(mAdapter);
	}

	private class MyAdapter extends BaseAdapter {

		public MyAdapter() {
		}

		@Override
		public int getCount() {
			return mImgsPath.length;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			View v = convertView;
			final Holder holder;
			if(null == v){
				v = LayoutInflater.from(MainActivity.this).inflate(R.layout.list_item, null);
				holder = new Holder();
				holder.img = (ImageView) v.findViewById(R.id.img);
				v.setTag(holder);
			} else{
				holder = (Holder) v.getTag();
			}
			holder.img.setImageResource(R.drawable.default_img);
			Glide.with(MainActivity.this)
					.load(mImgsPath[position])
					.error(R.drawable.default_img)
					.centerCrop()
					.fitCenter()
					.into(holder.img);
			return v;
		}
		class Holder{
			ImageView img;
		}
	}


}
