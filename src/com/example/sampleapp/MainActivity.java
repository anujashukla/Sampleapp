package com.example.sampleapp;

import com.example.sampleapp.R;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.webkit.WebView;
import android.app.ActionBar; 

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//ActionBar actionBar = getSupportActionBar();
	    //actionBar.setDisplayHomeAsUpEnabled(true);
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(false);
		
		ActionBar.Tab tabA = actionBar.newTab().setText("Home").setIcon(R.drawable.home);;
		
		Fragment fragmentA = new AFragmentTab();
		tabA.setTabListener(new MyTabsListener(fragmentA));
		
		actionBar.addTab(tabA);

		ActionBar.Tab tabB = actionBar.newTab().setText("Browse").setIcon(R.drawable.browse);;
		
		Fragment fragmentB = new BFragmentTab();
		tabB.setTabListener(new MyTabsListener(fragmentB));
		
		actionBar.addTab(tabB);
	}

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
*/
	 @Override
     public boolean onCreateOptionsMenu(Menu menu) {
         //Inflate the menu items for use in the action bar
         MenuInflater inflater = getMenuInflater();
         inflater.inflate(R.menu.main_activity_actions, menu);
         return super.onCreateOptionsMenu(menu);
     }
     
     @Override
     public boolean onOptionsItemSelected(MenuItem item) {
         // Handle presses on the action bar items
         switch (item.getItemId()) {
             case R.id.action_search:
                 openSearch();
                 return true;
             case R.id.action_settings:
                 openSettings();
                 return true;
             default:
                 return super.onOptionsItemSelected(item);
         }
     }

		private void openSettings() {
			TextView text = new TextView(this);
         text.setText("Settings Opened");
         setContentView(text);			
		}

		private void openSearch() {
			// TODO Auto-generated method stub
		/*
		TextView text = new TextView(this);
        text.setText("Search Opened");
        setContentView(text);
        */
		/*	
			Uri uriUrl = Uri.parse("http://stackoverflow.com/");
	        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
	        startActivity(launchBrowser);
	    */
			//Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
			//startActivity(browserIntent);
			//setContentView(browserIntent);
			WebView myWebView = (WebView) findViewById(R.id.webview);
			myWebView.loadUrl("http://google.com/");
			
			
		}
	
}


 class MyTabsListener implements ActionBar.TabListener {

    private Fragment fragment;

    public MyTabsListener(Fragment fragment) {
        this.fragment = fragment;
    }
    /*
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }

    public void onTabSelected(Tab tab, FragmentTransaction ft) {
	    ft.add(R.id.fragment_container, fragment, null);
    }

    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // some people needed this line as well to make it work: 
        ft.remove(fragment);
    }
*/

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.add(R.id.fragment_container, fragment, null);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.remove(fragment);
	}
}