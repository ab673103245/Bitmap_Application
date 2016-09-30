package qianfeng.bitmap_application;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = ((ImageView) findViewById(R.id.iv));
    }

    public void loadBitmap(View view) { // 点击加载图片，进行二次采样
          /*

        //        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
//        iv.setImageBitmap(bitmap);

       // ******************第一次采样，目的就是为了计算缩放比例
        BitmapFactory.Options options = new BitmapFactory.Options();
        //设置只加载图像的边界到内存中
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);
        //获取原图的宽度
        int outWidth = options.outWidth;
        //获取原图的高度
        int outHeight = options.outHeight;
        Log.d("sang", "btnClick: width:" + outWidth + ";height:" + outHeight);
        //缩放比例，该参数的值必须为2的n次幂
        int simpleSize = 1;
        //获取目标宽高
        int destWidth = iv.getWidth();
        int destHeight = iv.getHeight();
        while (outWidth / simpleSize > destWidth || outHeight / simpleSize > destHeight) {
            simpleSize *= 2;
        }
        //设置不仅只加载图片边界
        options.inJustDecodeBounds = false;
        //设置缩略图缩放比例
        options.inSampleSize = simpleSize;
        //设置图像的色彩模式,四种取值：
        //Bitmap.Config.ALPHA_8 加载只有透明度的图片，在这种色彩模式下，一个像素点占1个字节, 大小：长*宽*1 字节
        //Bitmap.Config.ARGB_4444 透明度、红、绿、蓝各占4位，一个像素点占2字节，图片大小：长*宽*2 字节
        //Bitmap.Config.ARGB_8888(默认) 透明度、红、绿、蓝各占8位，一个像素点占4字节，图片大小：长*宽*4 字节
        //Bitmap.Config.RGB_565  红、绿、蓝各占5、6、5位，一个像素点占2字节，图片大小：长*宽*2 字节
         */

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        String filename ="a7.jpg";
        String absolutePath = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), filename).getAbsolutePath();

        int outWidth = options.outWidth;
        int outHeight = options.outHeight;

        int width = iv.getWidth();
        int height = iv.getHeight();

        int sampleSize = 1; // 缩放比例，该参数的值必须为2的n次幂
        while (outWidth / sampleSize > width || outHeight / sampleSize > height) {
            sampleSize *= 2;
        }
        // 第一次采样结束，目的是获取到这个放缩比SapleSize

//       new BitmapFactory.Options();

        options.inJustDecodeBounds = false;

        options.inSampleSize = sampleSize;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;

        Bitmap bitmap = BitmapFactory.decodeFile(absolutePath, options);
        // 第二次采样结束，目的是利用这个放缩比来进行获取经过放缩后的原图

        iv.setImageBitmap(bitmap);




    }
}
