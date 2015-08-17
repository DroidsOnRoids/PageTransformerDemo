package example.com.pagetransformerdemo.transformers;

import android.view.View;

import example.com.pagetransformerdemo.R;

public class TextSwitchTransformer extends DefaultTransformer {

	@Override
	public void transformPage(final View page, final int pageIndex, final float position) {
		super.transformPage(page, pageIndex, position);

		final View content = page.findViewById(R.id.contentTextView);

		if (inRange(position)) {
			if (position != 0) {

				final float translationX = page.getWidth() * position;
				content.setTranslationX(-translationX);

			} else {

				content.setTranslationX(0);
			}
		} else {
			content.setTranslationX(0);
		}
	}
}
