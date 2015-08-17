package example.com.pagetransformerdemo.transformers;

import android.view.View;

public class CubeTransformer extends DefaultTransformer {

	public static final float MAX_ROTATION = 90.0f;

	@Override
	public void transformPage(final View page, final int pageIndex, final float position) {
		super.transformPage(page, pageIndex, position);

		if (inRange(position)) {
			if (isRightPage(position)) {

				final float rotation = position * MAX_ROTATION;
				page.setPivotX(0);
				page.setRotationY(rotation);
			} else if (isLeftPage(position)) {

				final float rotation = position * MAX_ROTATION;
				page.setPivotX(page.getWidth());
				page.setRotationY(rotation);
			} else {

				page.setRotationY(0);
			}
		} else {

			page.setRotationY(0);
		}
	}
}
