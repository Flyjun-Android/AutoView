# AutoView

android适配是繁琐的事，分辨率多样，考虑因素多，并且ui设计图还是px单位的，这时候你就需要AutoView了，AutoView可以帮你做什么呢？写多个dimens文件？
还是需要写很多的代码？no，这些都不用了，开发还是和之前的一样，而且还可以轻松的和ui设计图对应上（px单位适配，内部会自适应分辨率大小）

AutoView使用大法

1、你的build.gradle需要
           
     compile project(':AutoViewCore')

2、在你的BaseActivity上调用
   
     AutoView.init(this);
  
     or
  
     AutoView.init(this,1080.0f);
  
  第二个参数为你ui设计图设计的基准尺寸（比如1080 * 1920就是1080，720 * 1280就是720，默认是1080的）
  需要在setContentView之前执行
  
3、在你的布局layout文件中这么使用（ui图上标记的px像素值你可以直接对号入座了）
    
    <?xml version="1.0" encoding="utf-8"?>
    <com.flyjun.view.AutoLinearLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:id="@+id/layout"
    >
    <TextView
        android:layout_width="200px"
        android:layout_height="200px"
        android:textSize="50px"
        android:textColor="@android:color/black"
        android:background="@android:color/darker_gray"
        android:text="hello"/>
    <com.flyjun.view.AutoRelativeLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:layout_width="520px"
            android:layout_height="520px"
            android:textSize="80px"
            android:textColor="@android:color/holo_red_light"
            android:background="@android:color/holo_green_light"
            android:text="AutoView"/>
    </com.flyjun.view.AutoRelativeLayout>
    <include layout="@layout/inlayout"/>
    </com.flyjun.view.AutoLinearLayout>
   
   
   
   你只需要做的的是
   
       LinearLayout->AutoLinearLayout 
   
       RelativeLayout->AutoRelativeLayout
   
       FrameLayout->AutoFrameLayout


注意，如果你的跟布局也需要适配，需要加上
    
    xmlns:auto="http://schemas.android.com/apk/res-auto"
    auto:autoParents="true"
    
4、AutoView支持的属性几乎涵盖了所有
 
            android.R.attr.textSize

            android.R.attr.padding
            android.R.attr.paddingLeft
            android.R.attr.paddingTop
            android.R.attr.paddingRight
            android.R.attr.paddingBottom

            android.R.attr.layout_width
            android.R.attr.layout_height

            android.R.attr.layout_margin
            android.R.attr.layout_marginLeft
            android.R.attr.layout_marginTop
            android.R.attr.layout_marginRight
            android.R.attr.layout_marginBottom

            android.R.attr.drawablePadding 
            
5、使用代码也可以轻松的适配view，builder模式调用
  例如：
  
      AutoView.autoBuilder(view).setWidth(320).setHeight(120).setMarginTop(50).builder();
  
6、你还可以获取一个已经适配好的值
   
      AutoView.getAutoSize(this,120)
  
7、如果需要适配横竖屏，那么需要values-land的dimens和values的dimens一起来操作即可
   比如都有一个宽度width，都引用这个值即可

