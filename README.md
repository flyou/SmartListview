# SmartListview

This is an amazing ListView for the Android platform.
with thi view you can easy do pull to refresh and pull to load more
# Demo #
![](http://img.my.csdn.net/uploads/201505/18/1431919320_6684.gif)
# use #
# step1 #
down the zip of SmartListView

get SmartListView_libary into your progect

# step2 #
	
    <com.flyou.smartlistview.view.SmartListView
    android:id="@+id/smart_listview"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    /> 

# step3 #

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

# about me #
 
I am a student in mainland China. I love Google, love Android, love everything that is interesting.

 If you get any problems when using this library or you have an internship opportunity, please feel free to [email me](fangjaylong@gmail.com). :smiley:

at least if you have a opportunity of Internship ,I will will appreciate it.