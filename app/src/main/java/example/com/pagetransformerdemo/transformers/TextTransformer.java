package example.com.pagetransformerdemo.transformers;

import android.view.View;

import example.com.pagetransformerdemo.R;

public class TextTransformer extends DefaultTransformer {

	@Override
	public void transformPage(final View page, final int pageIndex, final float position) {
		super.transformPage(page, pageIndex, position);

		final View content = page.findViewById(R.id.contentTextView);
		final float maxTranslation = page.getWidth() / 2.0f;

		if (inRange(position)) {
			if (position != 0) {

				final float translationX = maxTranslation * position;
				content.setTranslationX(translationX);

				if (Math.abs(position) < 0.5) {

					final float alpha = (1.0f - Math.abs(position * 2));
					content.setAlpha(alpha);
				} else {
					content.setAlpha(0);
				}
			} else {

				content.setTranslationX(0);
				content.setAlpha(1);
			}
		} else {

			content.setTranslationX(0);
			content.setAlpha(1);
		}
	}
}
