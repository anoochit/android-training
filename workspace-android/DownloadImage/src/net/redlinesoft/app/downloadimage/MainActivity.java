package net.redlinesoft.app.downloadimage;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button bntLoadImage = (Button) findViewById(R.id.button1);

		bntLoadImage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// load image
				new DownloadImageTask( (ImageView) findViewById(R.id.imageView1)).execute("http://cdn.slashgear.com/wp-content/uploads/2011/09/oracle_android_google.png");
			}
		});
	}

	private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
		ImageView bmImage;
		
		public DownloadImageTask(ImageView bmImage) {
			this.bmImage=bmImage;
		}
		
		@Override
		protected Bitmap doInBackground(String... urls) {
			String url = urls[0];
			Bitmap mIcon = null;

			try {
				InputStream in = new URL(url).openStream();
				mIcon = BitmapFactory.decodeStream(in);

			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mIcon;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
			bmImage.setImageBitmap(result);
		}
		
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
