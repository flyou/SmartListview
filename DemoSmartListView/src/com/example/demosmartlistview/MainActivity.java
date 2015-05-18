package com.example.demosmartlistview;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.flyou.smartlistview.view.SmartListView;
import com.flyou.smartlistview.view.SmartListView.ISmartListViewListener;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity {
  private SmartListView smartListView;
  private List<String> datalList;
  private ArrayAdapter<String> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    smartListView = (SmartListView) findViewById(R.id.smart_listview);
    // init data
    // 初始化数据
    datalList = new ArrayList<String>();
    for (int i = 0; i < 15; i++) {
      datalList.add("this is line " + i);
    }
    adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, datalList);
    smartListView.setAdapter(adapter);
    // set the enble of pullLoad more and setPullRefresh
    // 设置开启下拉刷新和 加载更多
    smartListView.setPullLoadEnable(true);
    smartListView.setPullRefreshEnable(true);
    // 设置时间
    smartListView.setRefreshTime(new SimpleDateFormat("yyy-MM-dd mm:ss").format(new Date()));
    // set smartlistviewListener
    // 设置smartlistviewListener监听
    smartListView.setSmartListViewListener(new SmartListViewListener());
  }

  class SmartListViewListener implements ISmartListViewListener {

    @Override
    public void onRefresh() {
      new stopRefeshTask().execute("stop refsh");
    }

    @Override
    public void onLoadMore() {
      new stopLoadMoreTask().execute("stop load more");
    }

  }

  class stopRefeshTask extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return params[0];
    }

    @Override
    protected void onPostExecute(String result) {
      smartListView.setRefreshTime(new SimpleDateFormat("yyy-MM-dd mm:ss").format(new Date()));
      datalList.add(0, "this is the new  data");
      // stop refresh
      //获取到数据 停止刷新
      smartListView.stopRefresh();
      adapter.notifyDataSetChanged();

    }

  }

  class stopLoadMoreTask extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      return params[0];
    }

    @Override
    protected void onPostExecute(String result) {

      datalList.add("this is the load more data1");
      datalList.add("this is the load more data2");
      datalList.add("this is the load more data3");
      // stop LoadMore
      //获取到数据 停止加载
      smartListView.stopLoadMore();
      // update datalsit
      // 更新数据
      adapter.notifyDataSetChanged();

    }

  }
}
