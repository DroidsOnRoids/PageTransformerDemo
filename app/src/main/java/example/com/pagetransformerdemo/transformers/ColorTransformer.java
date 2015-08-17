package example.com.pagetransformerdemo.transformers;

import android.graphics.Color;
import android.view.View;

import example.com.pagetransformerdemo.MainActivity;

public class ColorTransformer extends BasePageTransformer {

	private static int blendColors(int color1, int color2, float ratio) {
		final float inverseRation = 1f - ratio;
		float r = (Color.red(color1) * ratio) + (Color.red(color2) * inverseRation);
		float g = (Color.green(color1) * ratio) + (Color.green(color2) * inverseRation);
		float b = (Color.blue(color1) * ratio) + (Color.blue(color2) * inverseRation);
		return Color.rgb((int) r, (int) g, (int) b);
	}

	@SuppressWarnings("UnnecessaryLocalVariable")
	@Override
	public void transformPage(final View page, final int pageIndex, final float position) {

		if (inRange(position)) {
			if (isRightPage(position)) {

				final int leftIndex = pageIndex - 1;
				final int rightIndex = pageIndex;

				final int leftColor = MainActivity.Content.values()[leftIndex].getColor();
				final int rightColor = MainActivity.Content.values()[rightIndex].getColor();

				final int composedColor = blendColors(leftColor, rightColor, position);
				page.setBackgroundColor(composedColor);
			} else if (isLeftPage(position)) {

				final int leftIndex = pageIndex;
				final int rightIndex = leftIndex + 1;

				final int leftColor = MainActivity.Content.values()[leftIndex].getColor();
				final int rightColor = MainActivity.Content.values()[rightIndex].getColor();

				final int composedColor = blendColors(leftColor, rightColor, 1 - Math.abs(position));
				page.setBackgroundColor(composedColor);
			} else {
				page.setBackgroundColor(MainActivity.Content.values()[pageIndex].getColor());
			}
		} else {
			page.setBackgroundColor(MainActivity.Content.values()[pageIndex].getColor());
		}
	}
}
