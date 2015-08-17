package example.com.pagetransformerdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import example.com.pagetransformerdemo.transformers.BasePageTransformer;
import example.com.pagetransformerdemo.transformers.ColorTransformer;
import example.com.pagetransformerdemo.transformers.CubeTransformer;
import example.com.pagetransformerdemo.transformers.DefaultTransformer;
import example.com.pagetransformerdemo.transformers.DownTransformer;
import example.com.pagetransformerdemo.transformers.RotationTransformer;
import example.com.pagetransformerdemo.transformers.TextSwitchColorTransformer;
import example.com.pagetransformerdemo.transformers.TextSwitchTransformer;
import example.com.pagetransformerdemo.transformers.TextTransformer;
import example.com.pagetransformerdemo.transformers.UpTransformer;

public class MainActivity extends AppCompatActivity {

	private static final BasePageTransformer[] PAGE_TRANSFORMERS = new BasePageTransformer[] {
			new DefaultTransformer(),
			new ColorTransformer(),
			new CubeTransformer(),
			new DownTransformer(),
			new UpTransformer(),
			new RotationTransformer(),
			new TextTransformer(),
			new TextSwitchTransformer(),
			new TextSwitchColorTransformer()
	};
	private ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		//noinspection ConstantConditions
		getSupportActionBar().setDisplayShowTitleEnabled(false);

		setSpinner();

		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
		mViewPager.setPageTransformer(false, new ColorTransformer());
	}

	private void setSpinner() {
		final Spinner navigationSpinner = (Spinner) findViewById(R.id.spinner_nav);
		navigationSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,
				PAGE_TRANSFORMERS));
		navigationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long
					id) {
				mViewPager.setPageTransformer(false, PAGE_TRANSFORMERS[position]);
			}

			@Override
			public void onNothingSelected(final AdapterView<?> parent) {
				mViewPager.setPageTransformer(false, PAGE_TRANSFORMERS[0]);
			}
		});
	}

	public enum Content {
		ONE("1", Color.GREEN),
		TWO("2", Color.YELLOW),
		THREE("3", Color.RED),
		FOUR("4", Color.BLUE),
		FIVE("5", Color.CYAN),
		SIX("6", Color.LTGRAY),
		SEVEN("7", Color.MAGENTA),
		EIGHT("8", Color.DKGRAY);

		private final String mText;
		private final int mColor;

		Content(final String text, final int color) {
			mText = text;
			mColor = color;
		}

		public String getText() {
			return mText;
		}

		public int getColor() {
			return mColor;
		}
	}

	private static class ViewPagerAdapter extends FragmentPagerAdapter {

		public ViewPagerAdapter(final FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(final int position) {
			return PageFragment.newInstance(position);
		}

		@Override
		public int getCount() {
			return Content.values().length;
		}
	}
}
