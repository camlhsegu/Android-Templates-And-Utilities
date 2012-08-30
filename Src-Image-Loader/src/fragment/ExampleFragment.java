package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.actionbarsherlock.app.SherlockFragment;
import com.example.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;


public class ExampleFragment extends SherlockFragment
{
	private View mRootView;
	private ImageLoader mImageLoader = ImageLoader.getInstance();
	private DisplayImageOptions mDisplayImageOptions;

	
	@Override
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		// image caching options
		mDisplayImageOptions = new DisplayImageOptions.Builder()
			.showStubImage(R.drawable.placeholder_photo)
			.showImageForEmptyUri(R.drawable.placeholder_photo)
			.cacheInMemory()
			.cacheOnDisc()
			.build();
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{	
		mRootView = inflater.inflate(R.layout.layout_example, container, false);
		return mRootView;
	}
	
	
	private void renderView()
	{
		// reference
		ImageView imageViewPhoto = (ImageView) mRootView.findViewById(R.id.layout_example_photo);

		// image caching
		mImageLoader.displayImage("http://placedog.com/200/200", imageViewPhoto, mDisplayImageOptions);
	}
}