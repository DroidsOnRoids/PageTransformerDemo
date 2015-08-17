package example.com.pagetransformerdemo.transformers;

import android.view.View;

import example.com.pagetransformerdemo.MainActivity;

public class DefaultTransformer extends BasePageTransformer {

	@Override
	public void transformPage(final View page, final int pageIndex, final float position) {
		page.setBackgroundColor(MainActivity.Content.values()[pageIndex].getColor());
	}
}
