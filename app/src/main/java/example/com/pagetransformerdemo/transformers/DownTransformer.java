package example.com.pagetransformerdemo.transformers;

import android.view.View;

public class DownTransformer extends DefaultTransformer {

	@Override
	public void transformPage(final View page, final int pageIndex, final float position) {
		super.transformPage(page, pageIndex, position);

		if (inRange(position)) {
			if (isRightPage(position)) {

				final float translationY = page.getHeight() * position;
				page.setTranslationY(translationY);
			} else if (isLeftPage(position)) {

				final float translationY = page.getHeight() * (Math.abs(position));
				page.setTranslationY(translationY);
			} else {
				page.setTranslationY(0.0f);
			}
		} else {

			page.setTranslationY(0.0f);
		}
	}
}
