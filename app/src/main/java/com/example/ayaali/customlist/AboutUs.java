package com.example.ayaali.customlist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class AboutUs extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        WebView webView=(WebView)findViewById(R.id.webPage);
        String summary = "<html><body><br/><br/><p dir='RTL'><span style='font-size:20px'><span style='font-family:tahoma,geneva,sans-serif'><strong>معاهد البخاري الأزهرية للغات</strong></span></span></p><p dir='RTL'><span style='color:#808080'><span style='font-size:16px'><span style='font-family:tahoma,geneva,sans-serif'>إيماناً منا بمسئولية الأبوين والمعلم والمجتمع أمام الله تعالى عن تربية هذا الجيل والذي نسأل الله جل وعلا أن يجعله جيلاً ربانياً، فإن أحسنا تربيته سعد في الدنيا والآخرة، وإن أهملنا تربيته شقى وكان الوزر في عنقنا ولهذا جاء في الحديث الذي رواه البخاري ومسلم من حديث عبد الله بن عمر رضى الله عنه أنه سمع رسول الله&nbsp;صلى الله عليه وسلم يقول: &quot;</span></span></span><span style='color:#B22222'><span style='font-size:16px'><span style='font-family:tahoma,geneva,sans-serif'>كلكم راعٍ وكلكم مسئول عن رعيته</span></span></span><span style='color:#808080'><span style='font-size:16px'><span style='font-family:tahoma,geneva,sans-serif'>&quot;</span></span></span></p><p dir='RTL'><br /><span style='color:#808080'><span style='font-size:16px'><span style='font-family:tahoma,geneva,sans-serif'>فبشرى لكما أيها الأبوان الكريمان بهذا الحديث الذي رواه مسلم من حديث أبي هريرة رضى الله عنه: &quot;</span></span></span><span style='color:#B22222'><span style='font-size:16px'><span style='font-family:tahoma,geneva,sans-serif'>إذا مات الإنسان انقطع عمله إلا من ثلاث: صدقة جارية، أوعلم ينتفع به، أو ولد صالح يدعو له</span></span></span><span style='color:#808080'><span style='font-size:16px'><span style='font-family:tahoma,geneva,sans-serif'>&quot;</span></span></span></p><h2><img alt='' src='http://images.madaresegypt.com//images/1027/910270.jpg' style='width:100%' /></h2><h2><img alt='' src='http://images.madaresegypt.com//images/1027/210270.jpg' style='width:100%' /></h2><h2><img alt=''src='http://images.madaresegypt.com//images/1027/310270.jpg' style='width:100%' /></h2><p><video  height='300' src='http://www.youtube.com/embed/XGaNEL4Ph7Y?rel=0' width='100%'></video></p></body></html>";
        WebSettings settings = webView.getSettings();
        settings.setDefaultTextEncodingName("utf-8");
        webView.loadDataWithBaseURL(null,summary, "text/html; charset=utf-8",null,null);
      //  webView.loadData(summary, "text/html","UTF-8");


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.aboutUs) {
            Intent main=new Intent("AboutUs");
            startActivity(main);

        } else if (id == R.id.contactUs) {

          //this.finish();

        } else if (id == R.id.webPage) {

            Uri uriUrl = Uri.parse("http://hadeya.net/");
            Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
            startActivity(launchBrowser);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
