package example.com.pagetransformerdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragment extends Fragment {

	private static final String ARG_POSITION = "com.example.PageFragment.ARG_POSITION";

	public PageFragment() {
	}

	public static PageFragment newInstance(final int position) {
		final Bundle args = new Bundle();
		args.putInt(ARG_POSITION, position);
		PageFragment f = new PageFragment();
		f.setArguments(args);
		return f;
	}

	@Nullable
	@Override
	public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle
			savedInstanceState) {
		return inflater.inflate(R.layout.fragment_page, container, false);
	}

	@Override
	public void onViewCreated(final View view, final Bundle savedInstanceState) {
		final int position = getArguments().getInt(ARG_POSITION);
		final String text = MainActivity.Content.values()[position].getText();

		view.setTag(position);

		final TextView contentTextView = (TextView) view.findViewById(R.id.contentTextView);
		contentTextView.setText(text);
	}
}
