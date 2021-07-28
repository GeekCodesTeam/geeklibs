package com.haier.cellarette.baselibrary.switchbutton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.haier.cellarette.baselibrary.R;


public class MainActivitySwitchButtonK extends AppCompatActivity implements AdapterView.OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainswitchbuttonk);
		ListView listView = (ListView) findViewById(R.id.list);
		listView.setOnItemClickListener(this);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_mainswitchbuttonk, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		int id = item.getItemId();
		if (id == R.id.action_github) {
			intent.setData(Uri.parse("https://github.com/kyleduo/SwitchButton"));
			startActivity(intent);
			return true;
		} else if (id == R.id.action_blog) {
			intent.setData(Uri.parse("https://kyleduo.com"));
			startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void jumpToStyle() {
		startActivity(new Intent(this, StyleActivitySwitchButtonK.class));
	}

	private void jumpToStyleInCode() {
		startActivity(new Intent(this, StyleInCodeActivitySwitchButtonK.class));
	}

	private void jumpToUse() {
		startActivity(new Intent(this, UseActivitySwitchButtonK.class));
	}

	private void jumpToRecycler() {
		startActivity(new Intent(this, RecyclerActivitySwitchButtonK.class));
	}

	private void gotoBlog() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("https://kyleduo.com"));
		startActivity(intent);
	}

	private void gotoLicense() {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("https://www.apache.org/licenses/LICENSE-2.0"));
		startActivity(intent);
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		switch (position) {
			case 0:
				jumpToStyle();
				break;
			case 1:
				jumpToStyleInCode();
				break;
			case 2:
				jumpToUse();
				break;
			case 3:
				jumpToRecycler();
				break;
			case 4:
				gotoBlog();
				break;
			case 5:
				gotoLicense();
				break;

			default:
				break;
		}
	}

}
