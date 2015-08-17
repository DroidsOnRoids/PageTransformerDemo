package example.com.pagetransformerdemo.transformers;

import android.view.View;

public class RotationTransformer extends DefaultTransformer {

	private static final float MAX_ROTATION = 90;

	@Override
	public void transformPage(final View page, final int pageIndex, final float position) {
		super.transformPage(page, pageIndex, position);

		page.setPivotY(0);

		if (inRange(position)) {
			if (isRightPage(position)) {

				final float rotation = -position * MAX_ROTATION;

				page.setPivotX(0);
				page.setRotation(rotation);
			} else if (isLeftPage(position)) {

				final float rotation = Math.abs(position) * MAX_ROTATION;

				page.setPivotX(page.getWidth());
				page.setRotation(rotation);
			} else {

				page.setRotation(0);
			}
		}
	}
}
